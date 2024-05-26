// Created by Iacon1 on 02/17/2024.
// Dummy function for ASM files

package C99Compiler.CompilerNodes.Dummies;

import C99Compiler.CompilerNodes.FunctionDefinitionNode;

public class DummyFunctionNode extends FunctionDefinitionNode
{
	private String name;
	private boolean isImplemented;
	public DummyFunctionNode(String name, boolean isImplemented)
	{
		super(null);
		this.name = name;
		this.isImplemented = isImplemented;
	}
	@Override public String getName() {return name;}
	@Override public boolean isStatic() {return false;}
	@Override public boolean isInline() {return false;}
	@Override public boolean canCall(FunctionDefinitionNode function) {return true;}
	@Override public boolean isImplemented() {return isImplemented;}
	@Override public String getAssembly(int leadingWhitespace) {return "";}
}
