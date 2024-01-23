// Created by Iacon1 on 01/23/2024.
//
package C99Compiler.ROMTypes;

import java.util.ArrayList;
import java.util.List;

import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Utils.OverlaySolver;

public interface ROMTypeInterface
{
	public static class VariableOverlayable implements OverlaySolver.Overlayable<VariableOverlayable>
	{
		private VariableNode variable;
		
		public VariableOverlayable(VariableNode variable)
		{
			this.variable = variable;
		}

		@Override
		public boolean isOverlayableWith(VariableOverlayable b)
		{
			FunctionDefinitionNode aFunc = variable.getEnclosingFunction();
			FunctionDefinitionNode bFunc = b.variable.getEnclosingFunction();
			if (aFunc == null || bFunc == null) return false; // If either are root-level then no overlaying
			else if (aFunc.canCall(bFunc) || bFunc.canCall(aFunc)) return false; // If either func can call the other then no overlaying
			else return true; // Otherwise sure
		}

		@Override
		public int getLength() {return variable.getSize();}
	}
	public byte getCode();
	
	public int getWRAMBankLength();
	public int getSRAMBankLength();
	
	public int getWRAMBanks();
	public int getSRAMBanks();
	
	public int getWRAMBankStart(int i);
	public int getSRAMBankStart(int i);
	
	public default List<Integer> mapWRAM(List<VariableNode> variables, int offset)
	{
		List<VariableOverlayable> variableOverlayables = new ArrayList<VariableOverlayable>();
		for (VariableNode variable : variables)
			variableOverlayables.add(new VariableOverlayable(variable));
		return OverlaySolver.solveOverlay(variableOverlayables, getWRAMBankLength(), getWRAMBanks(), (Integer i) ->
		{
			if (i == 0) return getWRAMBankStart(i) + offset;
			else return getWRAMBankStart(i);
		});
	}
	public default List<Integer> mapSRAM(List<VariableNode> variables)
	{
		List<VariableOverlayable> variableOverlayables = new ArrayList<VariableOverlayable>();
		for (VariableNode variable : variables)
			variableOverlayables.add(new VariableOverlayable(variable));
		return OverlaySolver.solveOverlay(variableOverlayables, getSRAMBankLength(), getSRAMBanks(), this::getSRAMBankStart);
	}
}
