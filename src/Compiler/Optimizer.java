// Created by Iacon1 on 10/26/2023.
// handles optimizing the ASM.

package Compiler;

import java.util.List;

import Compiler.Utils.CompUtils;

public final class Optimizer
{
	private static List<String> minimizeModeSwitches(List<String> lines)
	{
		int aMode = 0, xyMode = 0; // 0 = 8-bit, 1 = 16-bit, -1 = unknown
		for (int i = 0; i < lines.size(); ++i)
		{
			String line = lines.get(i);
			String prevLine = (i == 0) ? "" : lines.get(i - 1);
			if (line.matches("[^:\s]*:.*") || prevLine.contains("JSL")) // At a label or a JSL return point lose all assumptions of mode
			{
				aMode = -1;
				xyMode = -1;
			}
				
			if (line.contains(CompUtils.setAXY8))
			{
				if (aMode == 0 && xyMode == 0) lines.set(i, line.replace(CompUtils.setAXY8, ""));
				else if (aMode == 0) lines.set(i, line.replace(CompUtils.setAXY8, CompUtils.setXY8));
				else if (xyMode == 0) lines.set(i, line.replace(CompUtils.setAXY8, CompUtils.setA8));
				
				aMode = 0;
				xyMode = 0;
			}
			else if (line.contains(CompUtils.setAXY16))
			{
				if (aMode == 1 && xyMode == 1) lines.set(i, line.replace(CompUtils.setAXY16, ""));
				else if (aMode == 1) lines.set(i, line.replace(CompUtils.setAXY16, CompUtils.setXY16));
				else if (xyMode == 1) lines.set(i, line.replace(CompUtils.setAXY16, CompUtils.setA16));
				
				aMode = 1;
				xyMode = 1;
			}
			else if (line.contains(CompUtils.setA8))
			{
				if (aMode == 0) lines.set(i, line.replace(CompUtils.setA8, ""));
				aMode = 0;
			}
			else if (line.contains(CompUtils.setA16))
			{
				if (aMode == 1) lines.set(i, line.replace(CompUtils.setA16, ""));
				aMode = 1;
			}
			else if (line.contains(CompUtils.setXY8))
			{
				if (xyMode == 0) lines.set(i, line.replace(CompUtils.setXY8, ""));
				xyMode = 0;
			}
			else if (line.contains(CompUtils.setXY16))
			{
				if (xyMode == 1) lines.set(i, line.replace(CompUtils.setXY16, ""));
				xyMode = 1;
			}
		}
		
		return lines;
	}
	
	private static List<String> mergeREPs(List<String> lines)
	{
		for (int i = 0; i < lines.size(); ++i)
		{
			String prevLine = (i == 0) ? "" : lines.get(i - 1);
			String line = lines.get(i);
			
		}
		
		return lines;
	}
	
	public static List<String> getOptimized(List<String> lines)
	{
		lines = minimizeModeSwitches(lines);
		
		return lines;
	}
}
