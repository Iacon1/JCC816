// Created by Iacon1 on 01/23/2024.
// Solves overlays generally.

package C99Compiler.Utils;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import C99Compiler.CompilerNodes.LValues.VariableNode;
import Logging.Logging;

public final class OverlaySolver
{
	public static class OverlayUnsolveableException extends Exception
	{
		private int size;
		public OverlayUnsolveableException(int size)
		{
			super();
			this.size = size;
		}
		
		public int getSize()
		{
			return size;
		}
	}
	public static interface Overlayable<T extends Overlayable<T>>
	{
		boolean isOverlayableWith(T b);
		int getLength();
	}
	
	public static <T extends Overlayable<T>> SimpleEntry<List<Integer>, Integer> solveOverlay(List<T> overlayables, int numBanks, Function<Integer, Integer> bankLengths, Function<Integer, Integer> bankStarts) throws OverlayUnsolveableException
	{
		int[][] solution = new int[numBanks][overlayables.size()];
		if (overlayables.size() < 1) return null;
		else if (overlayables.size() == 1) return new SimpleEntry<List<Integer>, Integer>(Arrays.asList(bankStarts.apply(0)), overlayables.get(0).getLength());

		for (int b = 0; b < numBanks; ++b)
			for (int i = 0; i < overlayables.size(); ++i)
				solution[b][i] = (b == 0 ? bankStarts.apply(0) : -1); // -1 indicates not on that bank
		
		for (int b = 0; b < numBanks; ++b) // For each bank, starting with 0
		{
			for (int i = 0; i < overlayables.size(); ++i)
			{
				if (solution[b][i] == -1) continue; // This overlayable isn't on this bank
				T x = overlayables.get(i);
				for (int j = i + 1; j < overlayables.size(); ++j)
				{
					if (solution[b][j] == -1) continue; // This overlayable isn't on this bank
					T y = overlayables.get(j);
					if (!x.isOverlayableWith(y)) // Can't have x and y overlay
					{
						// Move b so that it isn't in the way
						solution[b][j] = Math.max(solution[b][j], solution[b][i] + x.getLength());
						if (y.getLength() > bankLengths.apply(b)) // Too big to fit in any bank
							throw new OverlayUnsolveableException(y.getLength());
						if (solution[b][j] + y.getLength() > bankStarts.apply(b) + bankLengths.apply(b)) // Too high for this bank
						{
							solution[b][j] = -1; // Leave this bank
							
							if (b + 1 == numBanks)
								throw new OverlayUnsolveableException(y.getLength());
							solution[b + 1][j] = bankStarts.apply(b + 1);
						}
					}
				}
			}
		}
		
		List<Integer> solutionList = new ArrayList<Integer>();
		int[] usedBankLengths = new int[numBanks];
		// Calculate how much of each bank is used
		for (int i = 0; i < overlayables.size(); ++i) // For each overlayable
		{
			for (int b = 0; b < numBanks; ++b) // Find the first bank it's in
				if (solution[b][i] != -1)
				{
					usedBankLengths[b] = Math.max(usedBankLengths[b], solution[b][i] - bankStarts.apply(b) + overlayables.get(i).getLength());
					solutionList.add(solution[b][i]);
					break;
				}
		}
		for (int b = numBanks - 1; b >= 0; --b) // Find the first bank used
			if (usedBankLengths[b] != 0)
			{
				// Assume all prior banks are used
				for (int i = 0; i < b; ++i)
					usedBankLengths[b] += bankLengths.apply(i);
				return new SimpleEntry<List<Integer>, Integer>(solutionList, usedBankLengths[b]);
			}
		// If no bank was used
		return new SimpleEntry<List<Integer>, Integer>(solutionList, 0);
	}
}
