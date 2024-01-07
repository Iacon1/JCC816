// By Iacon1
// Created 05/11/2023
//
package Compiler.ComponentNodes;

import Grammar.C99.C99Parser.Attributes_declarationContext;
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
import Compiler.ASMGrapher.ASMGraphBuilder;
import Compiler.ComponentNodes.Declarations.DeclarationSpecifiersNode;
import Compiler.ComponentNodes.Declarations.DeclaratorNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.ComponentNodes.Statements.CompoundStatementNode;
import Compiler.ComponentNodes.Statements.StatementNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Exceptions.UnsupportedFeatureException;
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
	
	public FunctionDefinitionNode(ComponentNode<?> parent)
	{
		super(parent);
		attributes = new HashSet<String>();
		requiresStackLoader = false;
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

		if (type.isArray()) throw new ConstraintException("6.9.1", 3, node.start);
		if (getName().equals(CompConfig.mainName)) // If main
			if (!getType().getSignature().equals("void()")) // Must be void with no arguments
				throw new UnsupportedFeatureException("Function \"main\" having a signature other than \"void()\"", true, node.start);
		if (node.compound_statement() != null) code = new CompoundStatementNode(this, getName()).interpret(node.compound_statement());
		Globals.registerFunction(this);
		return this;
	}
	
	private String getName(Direct_declaratorContext node)
	{
		while (node.Identifier() == null)
			node = node.direct_declarator();
		return node.Identifier().getText();
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
	public String getStartLabel()
	{
		String label = getFullName();
		for (int i = 0; i < getParameters().size(); ++i)
			label += (i == 0 ? CompConfig.scopeDelimiter : "__") + getParameters().get(i).getType().getSignature().replaceAll(" ", "_");
		
		return label;
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
		
		for (VariableNode var : Globals.variables)
			if (var.getEnclosingFunction() == null || canCall(var.getEnclosingFunction()))
				variables.add(var);
		
		if (reverse) Collections.reverse(variables);
		return variables;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		
		if (requiresStackLoader) // Need to sometimes get arguments from the stack
		{
			assembly += whitespace + getLoaderLabel() + ":\n";
			List<VariableNode> parameters = getParameters();
			Collections.reverse(parameters);
			for (VariableNode parameter : parameters)
				assembly += AssemblyUtils.stackLoader(whitespace, parameter.getSize(), parameter.getSource());
		}
		assembly += whitespace + getStartLabel() + ":" +
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
		
		if (code != null)
		{
			String codeAssembly = code.getAssembly(leadingWhitespace + CompConfig.indentSize);
			if (OptimizationLevel.isAtLeast(OptimizationLevel.all))
				assembly += new ASMGraphBuilder(codeAssembly).clearDeadCode(getChildVariables());
			else
				assembly += codeAssembly;
		}
		
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

		for (VariableNode var : getReferencedVariables())
			var.clearPossibleValues();
		return assembly;
	}	
}
