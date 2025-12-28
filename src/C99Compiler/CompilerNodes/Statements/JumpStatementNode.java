// Created by Iacon1 on 05/06/2023.
// 
package C99Compiler.CompilerNodes.Statements;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import Grammar.C99.C99Parser.Jump_statementContext;

public class JumpStatementNode extends StatementNode<Jump_statementContext> implements AssemblableNode
{
	private enum Mode
	{
		gotoM, continueM, breakM, returnM
	}
	private Mode mode;
	
	String gotoLabel;
	IterationStatementNode iterNode;
	SelectionStatementNode selNode;
	FunctionDefinitionNode funcNode;
	BaseExpressionNode<?> expr;
	
	public JumpStatementNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public StatementNode<Jump_statementContext> interpret(Jump_statementContext node) throws Exception
	{
		switch (node.getChild(0).getText())
		{
		case "goto":
			gotoLabel = node.identifier().getText();
			funcNode = getEnclosingFunction();
			mode = Mode.gotoM;
			break;
		case "continue":
			iterNode = getEnclosingIteration();
			mode = Mode.continueM;
			break;
		case "break":
			selNode = getEnclosingSwitchSelection();
			iterNode = getEnclosingIteration();
			if (iterNode != null && selNode != null && iterNode.getScope().getDepth() < selNode.getScope().getDepth())
				selNode = null;
			
			mode = Mode.breakM;
			break;	
		case "return":
			funcNode = getEnclosingFunction();
			if (node.expression() != null) expr = new ExpressionNode(this).interpret(node.expression());
			mode = Mode.returnM;
			break;
		}
		
		return this;
	}
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		if (expr == null) return false;
		return expr.canCall(state, function);
	}
	
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		return true; // Always does *something*
	}
	
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();

		return state;
	}
	
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		String whitespace = state.getWhitespace();
		String assembly = "";
		
		switch (mode)
		{
		case gotoM:
			assembly += whitespace + "JMP\t" + funcNode.getLabel(gotoLabel) + "\n";
			break;
		case continueM:
			assembly += whitespace + "JMP\t" + iterNode.getIterLabel() + "\n";
			break;
		case breakM:
			if (selNode != null)
				assembly += whitespace + "JMP\t" + selNode.getEndLabel() + "\n";
			else if (iterNode != null)
				assembly += whitespace + "JMP\t" + iterNode.getEndLabel() + "\n";
			break;
		case returnM:
			if (!this.getEnclosingFunction().getType().isVoid())
			{
				OperandSource s = CompConfig.callResultSource(this.getEnclosingFunction().getSize());
				
				state = state.setDestSource(s);
				if (expr != null && expr.hasAssembly(state))
				{
					AssemblyStatePair tmpPair = expr.getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
				else if (expr != null && expr.hasPropValue(state))
				{
					ByteCopier copier = new ByteCopier(funcNode.getSize(), s, new ConstantSource(expr.getPropValue(state), funcNode.getSize()));
					AssemblyStatePair tmpPair = copier.getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
				else if (expr != null && expr.hasLValue(state))
				{
					ByteCopier copier = new ByteCopier(funcNode.getType().getSize(), CompConfig.callResultSource(expr.getLValue(state).getSize()), expr.getLValue(state).getSource());
					AssemblyStatePair tmpPair = copier.getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
				assembly += whitespace + "JMP\t" + state.exitFuncLabel() + "\n";
				break;
			}
			else
			{
				state = state.setDestSource(null);
				if (expr != null && expr.hasAssembly(state))
				{
					AssemblyStatePair tmpPair = expr.getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
			}
		}
			
		state = state.wipe();
		return new AssemblyStatePair(assembly, state);
		
	}
}
