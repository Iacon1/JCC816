// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import java.nio.ByteBuffer;
import java.util.Arrays;

import Compiler.CompConfig;
import Compiler.Compiler;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Grammar.GeneralParser.GeneralNode;

public class AssignmentNode extends ComponentNode<AssignmentNode> implements AssemblableNode
{
	private enum InstructionType
	{
		varEqVar,
		varEqLiteral,
		varEqExp,
		varEqCall,
	}
	private InstructionType instructionType;
	
	private String x, y;
	private Object literalY;
	private Class<?> literalYClass;
	
	private ExpressionNode expNode;
	private FunctionCallNode callNode;
	
	public AssignmentNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public AssignmentNode interpret(GeneralNode<String, String> node) throws Exception
	{
		switch (node.childrenNodes.size()) // How many non-terminals?
		{
		case 0: // Possible forms: [var] = [var], [var] = [literal]
			x = node.getT(0);
			y = node.getT(2);
			
			literalY = ExpressionNode.determineLiteral(y);
			if (literalY != null)
			{
				literalYClass = literalY.getClass();
				instructionType = InstructionType.varEqLiteral;
			}
			else instructionType = InstructionType.varEqVar;
			break;
		case 1: // Possible forms: [var] = [expression], [function call]
			if (Compiler.getType(node.getNode(0).ruleName).equals(Compiler.ComponentType.expression))
			{
				x = node.getT(0);
				expNode = new ExpressionNode(this).interpret(node.getNode(0));
				instructionType = InstructionType.varEqExp;
			}
			else if (Compiler.getType(node.getNode(0).ruleName).equals(Compiler.ComponentType.functionCall))
			{
				x = node.getT(0);
				callNode = new FunctionCallNode(this).interpret(node.getNode(0));
				instructionType = InstructionType.varEqCall;
			}
			break;
		default:
			break;
		}

		return this;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		VarDeclarationNode xNode;
		
		switch (instructionType)
		{
		case varEqVar:	// var = var
			VarDeclarationNode yNode;
			
			xNode = resolveVariable(x);
			yNode = resolveVariable(y);
			
			assembly += byteCopier(whitespace, yNode.getType().getSize(), xNode.getFullName(), (Integer i) ->
				{
					if (i >= Math.floor(yNode.getType().getSize() / 2)) return yNode.getFullName() + " + " + (yNode.getType().getSize() - 1);
					else return yNode.getFullName() + " + " + 2 * i;
				});
			break;
		case varEqLiteral:	// var = literal
			xNode = resolveVariable(x);
			
			switch (CompConfig.BasicType.getType(literalYClass))
			{
			case t_int:
				assembly += byteCopier(whitespace, xNode.getFullName(), (Integer) literalY);
				break;
			case t_string:
				assembly += byteCopier(whitespace, xNode.getFullName(), (String) literalY);
				break;
			case t_char:
				assembly += byteCopier(whitespace, xNode.getFullName(), new byte[] {(byte) ((Character) literalY).charValue()});
				break;
			case t_bool:
				assembly += byteCopier(whitespace, xNode.getFullName(), new byte[] {(byte) (((Boolean) literalY) ? 0xFF : 0x00)});
				break;
			default:
				break;
			}
			break;
		case varEqExp: // Expression
			xNode = resolveVariable(x);
			
			assembly += expNode.getAssembly(leadingWhitespace, xNode.getFullName());
			break;
		case varEqCall: // Function call
			xNode = resolveVariable(x);
			
			assembly += callNode.getAssembly(leadingWhitespace);
			assembly += byteCopier(whitespace, xNode.getType().getSize(), xNode.getFullName(), CompConfig.callResult);
		default:
			break;
		}
		return assembly;
	}
}
