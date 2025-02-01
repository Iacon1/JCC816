// Created by Iacon1 on 02/17/2024.
// Dummy function for ASM files

package C99Compiler.CompilerNodes.Dummies;

import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.Utils.ProgramState;

public class DummyFunctionNode extends FunctionDefinitionNode
{
	private String name;
	public DummyFunctionNode(String name)
	{
		super(null);
		this.name = name;
	}
	@Override public String getName() {return name;}
	@Override public boolean isStatic() {return false;}
	@Override public boolean isInline() {return false;}
	@Override public boolean canCall(FunctionDefinitionNode function) {return true;}
	@Override public boolean isImplemented() {return true;}
	
	@Override public ProgramState getStateAfter(ProgramState state) {return state;}
	@Override public String getAssembly(ProgramState state) {return "";}
}
