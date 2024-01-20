// By Iacon1
// Created 05/11/2023
// An interpreted component node

package C99Compiler.PreprocNodes;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class InterpretingNode<T extends InterpretingNode<T, C>, C extends ParserRuleContext> extends PreProcComponentNode<T>
{
	public InterpretingNode(PreProcComponentNode<?> parent) {super(parent);}
	public InterpretingNode() {super();}

	public abstract T interpret(C node) throws Exception;
}
