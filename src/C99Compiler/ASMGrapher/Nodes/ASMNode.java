// Created by Iacon1 on 11/30/2023.
// Node for constructing ASM dependency graph
package C99Compiler.ASMGrapher.Nodes;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import C99Compiler.ASMGrapher.Address;

public abstract class ASMNode<C extends ParserRuleContext>
{
	public static enum ASMType
	{
		label,
		jump,
		jumpSub, // Always assume important
		branch,
		preproc,
		load,
		store,
		REPSEP,
		other,
	}
	private static List<ASMNode<?>> exports = new ArrayList<ASMNode<?>>();
	private List<ASMNode<?>> requirers;
	private int lineNo;
	
	private boolean is16A = false;
	private boolean is16XY = false;
	private boolean hidden = false;
	
	protected static int procNumber(String text)
	{
		if (text.contains("$"))
			return Integer.valueOf(text.replace("$", ""), 16);
		else
			return Integer.valueOf(text, 10);
	}
	protected static int procNumber(TerminalNode node)
	{
		return procNumber(node.getText());
	}
	protected static int sizeOfNumber(TerminalNode node) // Size of number in bytes
	{
		if (node.getText().contains("$")) // Hex
			return node.getText().replace("$", "").length() / 2;
		else // Decimal
			return ((int) (Math.log(procNumber(node))/Math.log(16)) + 1)/2; // (Log16 + 1)/2
	}
	public ASMNode(int lineNumber)
	{
		this.lineNo = lineNumber;
		requirers = new ArrayList<ASMNode<?>>();
	}
	public void require(ASMNode<?> node)
	{
		node.requirers.add(this);
	}
	public void setExport()
	{
		exports.add(this);
	}
	
	public boolean isRequiredForExports()
	{
		if (hidden) return false;
		
		for (ASMNode<?> export : exports)
			if (export.equals(this)) return true;
		for (ASMNode<?> requirer : requirers)
			if (requirer == this) continue;
			else if (requirer.isRequiredForExports()) return true;
		
		return false;
	}
	
	public abstract ASMNode<C> interpret(C node) throws Exception;
	
	public abstract byte affectingRegisters();
	public abstract byte affectingFlags();
	public abstract boolean affectedByParameter();
	
	public abstract byte affectedRegisters();
	public abstract byte affectedFlags();
	public abstract boolean affectsParameter();
	
	public abstract Address getAddress();
	public abstract int getImmediate();
	
	public abstract ASMType getType();
	
	public void set16A() {is16A = true;}
	public boolean is16A() {return is16A;}
	public void set16XY() {is16XY = true;}
	public boolean is16XY() {return is16XY;}
	
	public void hide() {hidden = true;}
	
	public abstract int getSize(); // Size in bytes of assembled form
}