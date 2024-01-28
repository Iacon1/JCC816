// Created by Iacon1 on 01/28/2024.
// A node that has a Sequence Point in it
package C99Compiler.CompilerNodes.Interfaces;

public interface SequencePointNode
{
	void registerSequence(String assembly);
	void clearSequence();
	String getAccumulatedSequences();
}
