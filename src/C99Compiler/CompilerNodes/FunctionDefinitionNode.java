// By Iacon1
// Created 05/11/2023
//
package C99Compiler.CompilerNodes;

import Grammar.C99.C99Parser.Attributes_declarationContext;
import Grammar.C99.C99Parser.Compound_statementContext;
import Grammar.C99.C99Parser.Declaration_specifiersContext;
import Grammar.C99.C99Parser.DeclaratorContext;
import Grammar.C99.C99Parser.Direct_declaratorContext;
import Grammar.C99.C99Parser.Function_definitionContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

import C99Compiler.CompConfig;
import C99Compiler.CompConfig.Attributes;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompConfig.DefinableInterrupt;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.ASMGrapher.ASMGraphBuilder;
import C99Compiler.CompilerNodes.Declarations.DeclarationSpecifiersNode;
import C99Compiler.CompilerNodes.Declarations.DeclaratorNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Interfaces.UnvaluedAssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.CompilerNodes.Statements.CompoundStatementNode;
import C99Compiler.CompilerNodes.Statements.StatementNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Exceptions.UnsupportedFeatureException;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.StackLoader;
import C99Compiler.Utils.AssemblyUtils.StackPusher;

public class FunctionDefinitionNode extends InterpretingNode<FunctionDefinitionNode, Function_definitionContext> implements NamedNode, TypedNode, UnvaluedAssemblableNode
{
	private Set<String> attributes;
	private DeclarationSpecifiersNode.DeclSpecifiers specifiers;
	private Type type;
	private DeclaratorNode signature;
	
	private StatementNode<?> code;
	private FunctionDefinitionNode implementation; // For intra-linker definitions
	
	private boolean requiresStackLoader; // Do we need a stack-loading foreword?
	
	public FunctionDefinitionNode(ComponentNode<?> parent)
	{
		super(parent);
		attributes = new HashSet<String>();
		requiresStackLoader = false;
		implementation = null;
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

		code = new CompoundStatementNode(this, getName()).interpret(node.compound_statement());
		
		if (attributes.contains(Attributes.interruptCOP))
			getTranslationUnit().registerInterrupt(DefinableInterrupt.COP, getStartLabel());
		if (attributes.contains(Attributes.interruptBRK))
			getTranslationUnit().registerInterrupt(DefinableInterrupt.BRK, getStartLabel());
		if (attributes.contains(Attributes.interruptABORT))
			getTranslationUnit().registerInterrupt(DefinableInterrupt.ABORT, getStartLabel());
		if (attributes.contains(Attributes.interruptIRQ))
			getTranslationUnit().registerInterrupt(DefinableInterrupt.IRQ, getStartLabel());
		if (attributes.contains(Attributes.interruptNMI))
			getTranslationUnit().registerInterrupt(DefinableInterrupt.NMI, getStartLabel());
			
		return this;
	}
	public FunctionDefinitionNode interpret(Declaration_specifiersContext declarationSpecifiers, DeclaratorContext declarator) throws Exception // Load from declaration
	{
		specifiers = new DeclarationSpecifiersNode(this).interpret(declarationSpecifiers).getSpecifiers();
		signature = new DeclaratorNode(this, getName(declarator.direct_declarator())).interpret(declarator);

		type = Type.manufacture(specifiers, signature, declarationSpecifiers.start);

		if (type.isArray()) throw new ConstraintException("6.9.1", 3, declarator.start);
		if (getName().equals(CompConfig.mainName)) // If main
			if (!getType().getSignature().equals("void()")) // Must be void with no arguments
				throw new UnsupportedFeatureException("Function \"main\" having a signature other than \"void()\"", true, declarator.start);

		return this;
	}
	public void implement(Compound_statementContext implementation) throws Exception
	{
		code = new CompoundStatementNode(this, getName()).interpret(implementation);
	}
	public void implement(FunctionDefinitionNode implementation)
	{
		this.implementation = implementation;
	}
	private String getName(Direct_declaratorContext node)
	{
		while (node.Identifier() == null)
			node = node.direct_declarator();
		return node.Identifier().getText();
	}
	
	@Override
	public String getName() {return signature.getIdentifier();}
	@Override
	public String getFullName() {return NamedNode.super.getFullName() + (isStatic() ? "@" + getTranslationUnit().getStaticUUID() : "");}
	public boolean isMain()
	{
		return getName().equals("main");
	}
	public boolean isImplemented()
	{
		if (this.implementation != null) return this.implementation.isImplemented();
		else return code != null;
	}
	public LinkedHashMap<String, VariableNode> getParameters()
	{
		if (this.implementation != null) return this.implementation.getParameters();
		else return signature.getChildVariables();
	}
	public String getLoaderLabel()
	{
		return "__" + getFullName() + "_LOAD";
	}
	public String getStartLabel() {return getFullName();}
	public String getLabel(String gotoLabel)
	{
		return "__" + getFullName() + CompConfig.scopeDelimiter + gotoLabel;
	}
	public String getEndLabel()
	{
		return "__" + getFullName() + "_END";
	}
	public boolean isStatic()
	{
		return type.isStatic() || isInline();
	}
	public boolean isInterruptHandler()
	{
		return Attributes.isInterrupt(attributes);
	}
	private boolean isISR()
	{
		if (this.implementation != null) return this.implementation.isISR();
		else return !attributes.contains(Attributes.noISR1) && !attributes.contains(Attributes.noISR2);
	}
	public boolean isSA1()
	{
		if (this.implementation != null) return this.implementation.isSA1();
		else return attributes.contains(Attributes.SA1);
	}
	public boolean isInline()
	{
		return specifiers.functionSpecifiers.length > 0 && specifiers.functionSpecifiers[0].equals("inline");
	}
	
	public void requireStackLoader()
	{
		if (this.implementation != null) this.implementation.requiresStackLoader = true;
		else requiresStackLoader = true;
	}

	@Override
	public Type getType()
	{
		return type;
	}
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		if (this.implementation != null)
		{
			return (
					function == this || function == this.implementation ||
					this.implementation.canCall(state, function) ||
					(function.implementation != null && this.implementation.canCall(state, function.implementation))
				   );
		}
		else if (code == null) return function == this;
		return code.canCall(state, function) || (function == this);
	}
	
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		return isImplemented(); // Always there as a label at least
	}

	private List<VariableNode> interruptRequirements(ProgramState state, boolean reverse) // The variables an interrupt needs to preserve
	{
		List<VariableNode> variables = new ArrayList<VariableNode>();
		
		for (VariableNode var : getTranslationUnit().getVariables().values())
			if (var.getEnclosingFunction() == null || canCall(state, var.getEnclosingFunction()))
				variables.add(var);
		
		if (reverse) Collections.reverse(variables);
		return variables;
	}

	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		
//		if (DebugLevel.isAtLeast(DebugLevel.low))
//			assembly += ".dbg func, \"" + getName() + "\", \"01\", EXTERN, \"" + getFullName() + "\"\n";
		
		if (requiresStackLoader) // Need to sometimes get arguments from the stack
		{
			pair.assembly += pair.state.getWhitespace() + getLoaderLabel() + ":\t; " + CompConfig.functionTag + "\n";
			List<VariableNode> parameters = new LinkedList<VariableNode>(getParameters().values());
			Collections.reverse(parameters);
			for (VariableNode parameter : parameters)
			{
				StackLoader loader = new StackLoader(parameter.getSize(), parameter.getSource());
				loader.apply(pair);
			}
		}
		pair.assembly += pair.state.getWhitespace() + getStartLabel() + ":" + "\t; " + CompConfig.functionTag + 
				(DebugLevel.isAtLeast(DebugLevel.medium) ? " " + getType().getSignature() : "") + 
				"\n";
		if (isInterruptHandler() && isISR()) // Have to push *everything* to the stack
		{
			// Using MVP to save space
			pair.assembly += pair.state.getWhitespace() + CompUtils.setAXY16 + "\n";
			pair.state = pair.state.setProcessorFlags((byte) (ProcessorFlag.M | ProcessorFlag.I));
			pair.assembly += pair.state.getWhitespace() + "LDA\t#$00FF\n"; 	// 255 -> 256 bytes
			pair.state = pair.state.fixAReg(0xFF);
			pair.assembly += pair.state.getWhitespace() + "LDX\t#$00FF\n"; 	// From first 256 bytes
			pair.state = pair.state.fixXReg(0xFF);
			pair.assembly += pair.state.getWhitespace() + "TSY\n";			// To stack
			pair.state = pair.state.clearKnownFlags(PreserveFlag.Y);
			pair.assembly += pair.state.getWhitespace() + "MVP\t$00,$00\n";
			pair.assembly += pair.state.getWhitespace() + "TYS\n";			// Move stack to new location 
			for (VariableNode variable : interruptRequirements(state, false))
			{
				StackPusher pusher = new StackPusher(variable.getSize(), variable.getSource());
				pusher.apply(pair);
			}
		}
		
		if (code != null)
		{
			AssemblyStatePair codePair = code.getAssemblyAndState(pair.state.indent().setExitFuncLabel(getEndLabel()));
			String codeAssembly = codePair.assembly;
			if (OptimizationLevel.isAtLeast(OptimizationLevel.all))
				pair.assembly += new ASMGraphBuilder(codeAssembly).clearDeadCode(getChildVariables());
			else
			{
				pair.assembly += codeAssembly;
				pair.state = codePair.state;
			}
			pair.state = pair.state.undent();
		}
		
		if (isInterruptHandler() && isISR()) // Have to load *everything* to the stack
		{
			List<VariableNode> variables = new LinkedList<VariableNode>(getChildVariables().values());
			Collections.reverse(variables);
			for (VariableNode variable : interruptRequirements(state, true))
				{
					StackLoader loader = new StackLoader(variable.getSize(), variable.getSource());
					loader.apply(pair);
				}
			
			pair.assembly += pair.state.getWhitespace() + CompUtils.setAXY16 + "\n";
			pair.state = pair.state.clearProcessorFlags((byte) (ProcessorFlag.M | ProcessorFlag.I));
			// Using MVP to save space
			pair.assembly += pair.state.getWhitespace() + CompUtils.setAXY16 + "\n";
			pair.state = pair.state.setProcessorFlags((byte) (ProcessorFlag.M | ProcessorFlag.I));
			pair.assembly += pair.state.getWhitespace() + "LDA\t#$00FF\n"; 	// 255 -> 256 bytes
			pair.state = pair.state.fixAReg(0xFF);
			pair.assembly += pair.state.getWhitespace() + "TSX\n";			// To stack
			pair.state = pair.state.clearKnownFlags(PreserveFlag.X);
			pair.assembly += pair.state.getWhitespace() + "LDA\t#$0000\n"; 	// 255 -> 256 bytes
			pair.state = pair.state.fixAReg(0x00);
			pair.assembly += pair.state.getWhitespace() + "MVN\t$00,$00\n";
			pair.assembly += pair.state.getWhitespace() + "TXS\n";			// Move stack to new location
		}
		
		pair.assembly += pair.state.getWhitespace() + getEndLabel() + ": " + (isInterruptHandler() && !attributes.contains(Attributes.noISR2) ? "RTI\n" : "RTL") + "\n";
		
;//		ScratchManager.releasePointers();

		for (VariableNode var : getReferencedVariables().values())
			state = state.clearPossibleValues(var);
		return pair.getImmutable();
	}
	
	public StatementNode<?> getCode()
	{
		return code;
	}
}
