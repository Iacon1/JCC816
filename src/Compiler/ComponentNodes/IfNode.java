// By Iacon1
// Created 10/07/2023
// If statement

package Compiler.ComponentNodes;

import java.util.ArrayList;
import java.util.List;

import Compiler.Compiler;
import Compiler.Exceptions.TypeMismatchException;
import Compiler.Utils.CompUtils;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Statements.StatementNode;
import Grammar.GeneralParser.GeneralNode;

public class IfNode extends ComponentNode<IfNode> implements AssemblableNode
{
	private List<RValNode> conditions;
	private List<StatementNode> statements;
	private static int ifCount = 0;
	
	public IfNode(ComponentNode<?> parent)
	{
		super(parent);
		ifCount += 1;
		
		conditions = new ArrayList<RValNode>();
		statements = new ArrayList<StatementNode>();
		}
	@Override public void finalize() {ifCount -= 1;}
	
	@Override
	public IfNode interpret(GeneralNode<String, String> node) throws Exception
	{
		int offset = 0;
		boolean noCondition = false;
		if (Compiler.getType(node.childrenNodes.get(0).ruleName) == Compiler.ComponentType.ifStm) // absorb prior case
		{
			IfNode temp = new IfNode(this).interpret(node.getNode(0));
			conditions = temp.conditions;
			statements = temp.statements;
			
			offset = 1;
			if (node.childrenNodes.size() == 2) noCondition = true; // Else
		}
		
		if (noCondition) // Else
			statements.add(new StatementNode(this).interpret(node.getNode(offset)));
		else // Else If
		{
			conditions.add(new RValNode(this).interpret(node.getNode(offset)));
			statements.add(new StatementNode(this).interpret(node.getNode(offset + 1)));
		}
			
		return this;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		for (int i = 0; i < conditions.size(); ++i)
			if (conditions.get(i).canCall(function)) return true;
		for (int i = 0; i < statements.size(); ++i)
			if (statements.get(i).canCall(function)) return true;
		return false;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		String skipName;
		String lastSkip = "__IFNOT_" + ifCount + "_" + conditions.size();

		for (int i = 0; i < conditions.size(); ++i)
		{
			skipName = "__IFNOT_" + ifCount + "_" + i;
			RValNode condition = conditions.get(i);
			StatementNode statement = statements.get(i);
			if (condition.getType().equals(CompConfig.CompUtils.t_bool.getType())) // Must be boolean
			{
				if (condition.hasPropValue()) // Known value at compile time
				{
					if ((Boolean) condition.getPropValue())
						assembly += condition.getAssembly(leadingWhitespace);
					else
						assembly += "";
				}
				else // Unknown value at compile time
				{
					if (condition.hasAssembly()) assembly += condition.getAssembly(leadingWhitespace);
					else assembly += byteCopier(whitespace, condition.getType().getSize(), CompUtils.operandA, condition.getByteSource()); // Make sure variable loaded.
					assembly += whitespace + "BEQ\t" + skipName + "\n";
					assembly += statement.getAssembly(leadingWhitespace + CompUtils.indentSize);
					if (statements.size() > 1) assembly += whitespace + "JML\t" + lastSkip + "\n"; // If there's more statements make sure to skip them.
					assembly += whitespace + skipName + ":\n";
				}
			}
			else throw new TypeMismatchException(condition.getType().getName(), CompConfig.CompUtils.t_bool.getName());
		}
		if (conditions.size() < statements.size())
		{
			StatementNode statement = statements.get(statements.size() - 1);
			assembly += statement.getAssembly(leadingWhitespace + CompUtils.indentSize);
			assembly += whitespace + "JML\t" + lastSkip + "\n";
		}
		assembly += whitespace + lastSkip + ":\n";
		
		return assembly;
	}
}
