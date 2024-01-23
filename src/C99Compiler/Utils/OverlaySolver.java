// Created by Iacon1 on 01/23/2024.
// Solves overlays generally.

package C99Compiler.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public final class OverlaySolver
{
	public static interface Overlayable<T extends Overlayable<T>>
	{
		boolean isOverlayableWith(T b);
		int getLength();
	}
	
	public static <T extends Overlayable<T>> List<Integer> solveOverlay(List<T> overlayables, int bankLength, int numBanks, Function<Integer, Integer> bankStarts)
	{
		int[][] solution = new int[numBanks][overlayables.size()];
		if (overlayables.size() < 1) return null;
		else if (overlayables.size() == 1) return Arrays.asList(bankStarts.apply(0));

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
						solution[b][j] = Math.max(solution[b][j], solution[b][i] + x.getLength());
						if (solution[b][j] + y.getLength() > bankStarts.apply(b) + bankLength) // Too high for this bank
						{
							solution[b][j] = -1; // Leave this bank
							solution[b + 1][j] = bankStarts.apply(b + 1);
						}
					}
				}
			}
		}
		
		List<Integer> solutionList = new ArrayList<Integer>();
		for (int i = 0; i < overlayables.size(); ++i) // For each overlayable
		{
			for (int b = 0; b < numBanks; ++b) // Find the first bank it's in
				if (solution[b][i] != -1)
				{
					solutionList.add(solution[b][i]);
					break;
				}
		}
		
		return solutionList;
	}
}
