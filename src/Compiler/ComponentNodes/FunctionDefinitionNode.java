// By Iacon1
// Created 05/11/2023
//
package Compiler.ComponentNodes;

import Grammar.C99.C99Parser.Attributes_declarationContext;
import Grammar.C99.C99Parser.DeclaratorContext;
import Grammar.C99.C99Parser.Direct_declaratorContext;
import Grammar.C99.C99Parser.Function_definitionContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

import Compiler.CompConfig;
import Compiler.CompConfig.DebugLevel;
import Compiler.CompConfig.OptimizationLevel;
import Compiler.ComponentNodes.Declarations.DeclarationSpecifiersNode;
import Compiler.ComponentNodes.Declarations.DeclaratorNode;
import Compiler.ComponentNodes.Definitions.PointerType;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.ComponentNodes.Expressions.PostfixExpressionNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.ComponentNodes.LValues.LValueNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.ComponentNodes.Statements.AssemblyStatementNode;
import Compiler.ComponentNodes.Statements.CompoundStatementNode;
import Compiler.ComponentNodes.Statements.JumpStatementNode;
import Compiler.ComponentNodes.Statements.LabeledStatementNode;
import Compiler.ComponentNodes.Statements.StatementNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;

public class FunctionDefinitionNode extends InterpretingNode<FunctionDefinitionNode, Function_definitionContext> implements NamedNode, TypedNode, AssemblableNode
{
	private Set<String> attributes;
	private DeclarationSpecifiersNode.DeclSpecifiers specifiers;
	private Type type;
	private DeclaratorNode signature;
	
	private StatementNode<?> code;
	
	private boolean requiresStackLoader; // Do we need a stack-loading foreword?
	
	private List<LValueNode<?>> possibleReturns;
	private boolean requiresAll; // Turned on during first pass of assembly, turned off for second one
	
	public FunctionDefinitionNode(ComponentNode<?> parent)
	{
		super(parent);
		attributes = new HashSet<String>();
		possibleReturns = new ArrayList<LValueNode<?>>();
		requiresStackLoader = false;
		requiresAll = false;
	}

	private String getName(Direct_declaratorContext node)
	{
		while (node.Identifier() == null)
			node = node.direct_declarator();
		return node.Identifier().getText();
	}
	@Override
	public FunctionDefinitionNode interpret(Function_definitionContext node) throws Exception
	{
		for (Attributes_declarationContext attributes_declaration : node.attributes_declaration())
			for (TerminalNode attribute : attributes_declaration.identifier_list().Identifier())
				attributes.add(attribute.getText());

		specifiers = new DeclarationSpecifiersNode(this).interpret(node.declaration_specifiers()).getSpecifiers();
		signature = new DeclaratorNode(this, getName(node.declarator().direct_declarator())).interpret(node.declarator());
		type = Type.manufacture(specifiers, signature, node.declaration_specifiers().start);

		if (node.compound_statement() != null) code = new CompoundStatementNode(this, getName()).interpret(node.compound_statement());
		registerFunction(this);
		return this;
	}
	@Override
	public String getName() {return signature.getIdentifier();}
	public boolean isMain()
	{
		return getName().equals("main");
	}
	public List<VariableNode> getParameters()
	{
		return signature.getChildVariables();
	}
	public String getLoaderLabel()
	{
		return "__" + getFullName() + "_LOAD";
	}
	public String getLabel(String gotoLabel)
	{
		return "__" + getFullName() + CompConfig.scopeDelimiter + gotoLabel;
	}
	public String getEndLabel()
	{
		return "__" + getFullName() + "_END";
	}

	public boolean isInterruptHandler()
	{
		return attributes.contains(CompUtils.Attributes.interrupt);
	}
	private boolean isISR()
	{
		return !attributes.contains(CompUtils.Attributes.noISR1) && !attributes.contains(CompUtils.Attributes.noISR2);
	}
	public boolean isSA1()
	{
		return attributes.contains(CompUtils.Attributes.SA1);
	}
	
	public void requireStackLoader()
	{
		requiresStackLoader = true;
	}

	@Override
	public Type getType()
	{
		return type;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return code.canCall(function) || (function == this);
	}
	
	@Override
	public boolean hasAssembly()
	{
		return true; // Always there as a label at least
	}

	private List<VariableNode> interruptRequirements(boolean reverse) // The variables an interrupt needs to preserve
	{
		List<VariableNode> variables = new ArrayList<VariableNode>();
		
		for (VariableNode var : ComponentNode.variables)
			if (var.getEnclosingFunction() == null || canCall(var.getEnclosingFunction()))
				variables.add(var);
		
		if (reverse) Collections.reverse(variables);
		return variables;
	}
	private List<LValueNode<?>> getExports()
	{
		List<LValueNode<?>> exports = new ArrayList<LValueNode<?>>();
		for (VariableNode variable : getChildVariables())
			if (variable.getType().isVolatile())
				exports.add(variable);
		for (LValueNode<?> LValue : possibleReturns)
			exports.add(LValue);
		return exports;
	}
	private boolean requiresLVal(LValueNode<?> node)
	{
		if (requiresAll) return true; // Are we currently pretending we need to evaluate everything?
		if (node.getEnclosingFunction() != this) return true;
		if (getExports().contains(node)) return true; // This is something we have to preserve
		if (node.getType().isPointer() && ((PointerType) node.getType()).isFunction()) return true; // Gotta preserve function pointers
		
		for (LValueNode<?> export : getExports())
			if (export.isInfluencedBy(node)) return true;
		
		return false;
	}
	public boolean requires(ComponentNode<?> node)
	{
		if (requiresAll) return true; // Are we currently pretending we need to evaluate everything?
		
		for (ComponentNode<?> child : node.children)
			if (requires(child)) return true;
		
		if (AssemblyStatementNode.class.isAssignableFrom(node.getClass()))
			return true;
		else if (LabeledStatementNode.class.isAssignableFrom(node.getClass()))
			return true;
		else if (JumpStatementNode.class.isAssignableFrom(node.getClass()))
			return true;
		else if (PostfixExpressionNode.class.isAssignableFrom(node.getClass()))
		{
			PostfixExpressionNode expr = (PostfixExpressionNode) node;
			if (expr.isFuncCall()) return true; // Always keep calls to functions
			if (expr.hasLValue() && requiresLVal(expr.getLValue())) return true;
		}
		else if (BaseExpressionNode.class.isAssignableFrom(node.getClass()))
		{
			BaseExpressionNode<?> expr = (BaseExpressionNode<?>) node;
			if (expr.hasLValue() && requiresLVal(expr.getLValue())) return true;
		}
		else if (VariableNode.class.isAssignableFrom(node.getClass()))
		{
			VariableNode var = (VariableNode) node;
			if (requiresLVal(var)) return true;
		}
		
		return false;
	}
	public void addPossibleReturn(LValueNode<?> value)
	{
		possibleReturns.add(value);
	}

	private String getAssemblyPass(int leadingWhitespace) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
	
		if (requiresStackLoader) // Need to sometimes get arguments from the stack
		{
			assembly += whitespace + getLoaderLabel() + ":\n";
			List<VariableNode> parameters = getParameters();
			Collections.reverse(parameters);
			for (VariableNode parameter : parameters)
				assembly += AssemblyUtils.stackLoader(whitespace, leadingWhitespace, parameter.getSource());
		}
		assembly += whitespace + getFullName() + ":" +
				(DebugLevel.isAtLeast(DebugLevel.medium) ? "\t; " + getType().getSignature() : "") + 
				"\n";
		if (isInterruptHandler() && isISR()) // Have to push *everything* to the stack
		{
			assembly += AssemblyUtils.stackPusher(whitespace, CompConfig.scratchSize, new ScratchSource(0, CompConfig.scratchSize));
			assembly += AssemblyUtils.stackPusher(whitespace, CompConfig.multDivSize, CompConfig.multDivSource(true, CompConfig.multDivSize));
			assembly += AssemblyUtils.stackPusher(whitespace, CompConfig.multDivSize, CompConfig.multDivSource(false, CompConfig.multDivSize));
			assembly += AssemblyUtils.stackPusher(whitespace, CompConfig.callResultSize, CompConfig.callResultSource(CompConfig.callResultSize));
			
			
			for (VariableNode variable : interruptRequirements(false))
				assembly += AssemblyUtils.stackPusher(whitespace, leadingWhitespace, variable.getSource());
		}
		
		if (code != null) assembly += code.getAssembly(leadingWhitespace + CompConfig.indentSize);
		
		if (isInterruptHandler() && isISR()) // Have to load *everything* to the stack
		{
			List<VariableNode> variables = getChildVariables();
			Collections.reverse(variables);
			for (VariableNode variable : interruptRequirements(true))
				assembly += AssemblyUtils.stackLoader(whitespace, leadingWhitespace, variable.getSource());
			
			assembly += AssemblyUtils.stackLoader(whitespace, CompConfig.callResultSize, new ScratchSource(0, CompConfig.scratchSize));
			assembly += AssemblyUtils.stackLoader(whitespace, CompConfig.multDivSize, CompConfig.multDivSource(false, CompConfig.multDivSize));
			assembly += AssemblyUtils.stackLoader(whitespace, CompConfig.multDivSize, CompConfig.multDivSource(true, CompConfig.multDivSize));
			assembly += AssemblyUtils.stackLoader(whitespace, CompConfig.scratchSize, CompConfig.callResultSource(CompConfig.callResultSize));
		}
		
		assembly += whitespace + getEndLabel() + ": " + (isInterruptHandler() && !attributes.contains(CompUtils.Attributes.noISR2) ? "RTI\n" : "RTL") + "\n";
		
		ScratchManager.clearPointers();
		return assembly;
	}

	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		requiresAll = true;
		if (OptimizationLevel.isAtLeast(OptimizationLevel.all))
		{
			getAssemblyPass(leadingWhitespace); // Scan for influence and such
			requiresAll = false;
			return getAssemblyPass(leadingWhitespace); // Return actual assembly
		}
		else return getAssemblyPass(leadingWhitespace);
	}
}
