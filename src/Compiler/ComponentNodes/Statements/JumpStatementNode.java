// Created by Iacon1 on 05/06/2023.
// 
package Compiler.ComponentNodes.Statements;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.ComponentNodes.Expressions.ExpressionNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
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
		return expr.canCall(function);
	}
	
	@Override
	public boolean hasAssembly()
	{
		return true; // Always does *something*
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		
		switch (mode)
		{
		case gotoM:
			assembly += whitespace + "JML\t" + funcNode.getLabel(gotoLabel) + "\n";
			break;
		case continueM:
			assembly += whitespace + "JML\t" + iterNode.getStartLabel() + "\n";
			break;
		case breakM:
			if (selNode != null)
				assembly += whitespace + "JML\t" + selNode.getEndLabel() + "\n";
			else if (iterNode != null)
				assembly += whitespace + "JML\t" + iterNode.getEndLabel() + "\n";
			break;
		case returnM:
			if (expr != null && expr.hasAssembly()) assembly += expr.getAssembly(leadingWhitespace, CompConfig.callResultSource(expr.getLValue().getSize()));
			else if (expr != null && expr.hasPropValue()) assembly += AssemblyUtils.byteCopier(whitespace, funcNode.getSize(), CompConfig.callResultSource(funcNode.getSize()), new ConstantSource(expr.getPropLong(), funcNode.getSize()));
			else if (expr != null) assembly += AssemblyUtils.byteCopier(whitespace, funcNode.getType().getSize(), CompConfig.callResultSource(expr.getLValue().getSize()), expr.getLValue().getSource());
			assembly += whitespace + "JML\t" + funcNode.getEndLabel() + "\n";
			break;
		}
			
		ScratchManager.clearPointers();
		return assembly;
		
	}

}
