// Created by Iacon1 on 05/06/2023.
// 
package C99Compiler.CompilerNodes.Statements;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
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
			gotoLabel = node.Identifier().getText();
			funcNode = getEnclosingFunction();
			mode = Mode.gotoM;
			break;
		case "continue":
			iterNode = getEnclosingIteration();
			mode = Mode.continueM;
			break;
		case "break":
			selNode = getEnclosingSelection();
			if (selNode == null || selNode.getEnclosingIteration() == getEnclosingIteration() && selNode.getEnclosingIteration() != null)
			{
				iterNode = getEnclosingIteration();
				selNode = null;
			}
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
	public boolean canCall(FunctionDefinitionNode function)
	{
		if (expr == null) return false;
		return expr.canCall(function);
	}
	
	@Override
	public boolean hasAssembly()
	{
		return true; // Always does *something*
	}
	public String getAssembly(int leadingWhitespace, String returnAddr) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		
		switch (mode)
		{
		case gotoM:
			assembly += whitespace + "JMP\t" + funcNode.getLabel(gotoLabel) + "\n";
			break;
		case continueM:
			assembly += whitespace + "JMP\t" + iterNode.getStartLabel() + "\n";
			break;
		case breakM:
			if (selNode != null)
				assembly += whitespace + "JMP\t" + selNode.getEndLabel() + "\n";
			else if (iterNode != null)
				assembly += whitespace + "JMP\t" + iterNode.getEndLabel() + "\n";
			break;
		case returnM:
			if (expr != null && expr.hasAssembly()) assembly += expr.getAssembly(leadingWhitespace, CompConfig.callResultSource(expr.getSize()));
			else if (expr != null && expr.hasPropValue()) assembly += AssemblyUtils.byteCopier(whitespace, funcNode.getSize(), CompConfig.callResultSource(funcNode.getSize()), new ConstantSource(expr.getPropLong(), funcNode.getSize()));
			else if (expr != null && expr.hasLValue()) assembly += AssemblyUtils.byteCopier(whitespace, funcNode.getType().getSize(), CompConfig.callResultSource(expr.getLValue().getSize()), expr.getLValue().getSource());
			assembly += whitespace + "JMP\t" + returnAddr + "\n";
			break;
		}
			
		ScratchManager.releasePointers();
		return assembly;
		
	}
	@Override public String getAssembly(int leadingWhitespace) throws Exception {return getAssembly(leadingWhitespace, getEnclosingFunction().getEndLabel());}
}
