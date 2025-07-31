// Created by Iacon1 on 2/7/2022.
// Test rig.

package Executables;

import C99Compiler.CompConfig;
import C99Compiler.Utils.FileIO;
import C99Compiler.Utils.ProgramState;
import Shared.CartConfig;
import Shared.MemorySize;
import C99Compiler.Generators.LongDividerModulator;
import C99Compiler.Generators.Multiplier;
import C99Compiler.Generators.ShortDividerModulator;
import C99Compiler.C99Compiler;
import AsmBuilder.AsmBuilder;

public class MultImpGen
{
	public static void main(String[] args) throws Exception
	{
		String assembly = "";
		String cCode = "";
		
		CompConfig.optimizationLevel = CompConfig.OptimizationLevel.medium;
		
		assembly += "; Thanks Sir Walrus\n";
		cCode += "// Thanks Sir Walrus\n";
		// Routine generators already know their output sizes
		ProgramState state = new ProgramState().indent();
		int sizes[] = {1, 2, 3, 4, 8};
		
		assembly += "\n; Multiplication\n";
		for (int xSize : sizes)
			for (int ySize : sizes)
			{
				if (ySize > xSize) continue;
				if (Math.max(xSize, ySize) > 3)
					state = state.setDestSource(CompConfig.callResultSource(Math.max(xSize, ySize)));
				else
					state = state.setDestSource(CompConfig.callResultSource(3));

				assembly += "__mul" + (8 * xSize) + "by" + (8 * ySize) + ":\t\t; @func\n";
				assembly += new Multiplier(CompConfig.specSubSource(true, xSize), CompConfig.specSubSource(false, ySize)).getAssembly(state);
				assembly += "RTL\t\t; @endfunc\n";
				assembly += "\n";
			}
		
		assembly += "\n; Division\n";
		cCode += "\n// Division\n";
		for (int xSize : sizes)
			for (int ySize : sizes)
			{
				if (ySize == 1)
				{
					if (Math.max(xSize, ySize) > 3)
						state = state.setDestSource(CompConfig.callResultSource(Math.max(xSize, ySize)));
					else
						state = state.setDestSource(CompConfig.callResultSource(3));
					
					assembly += "__div" + (8 * xSize) + "by" + (8 * ySize) + ":\t\t; @func\n";
						assembly += new ShortDividerModulator(CompConfig.specSubSource(true, xSize), CompConfig.specSubSource(false, ySize), false).getAssembly(state);
	
					assembly += "RTL\t\t; @endfunc\n";
					assembly += "\n";
				}
				else
				{
					cCode += new LongDividerModulator(xSize, ySize, false).get();
				}
			}
		
		assembly += "\n; Modulation\n";
		cCode += "\n// Modulation\n";
		for (int xSize : sizes)
			for (int ySize : sizes)
			{
				if (ySize == 1)
				{
					if (Math.max(xSize, ySize) > 3)
						state = state.setDestSource(CompConfig.callResultSource(Math.max(xSize, ySize)));
					else
						state = state.setDestSource(CompConfig.callResultSource(3));
					
					assembly += "__mod" + (8 * xSize) + "by" + (8 * ySize) + ":\t\t; @func\n";
						assembly += new ShortDividerModulator(CompConfig.specSubSource(true, xSize), CompConfig.specSubSource(false, ySize), true).getAssembly(state);
	
					assembly += "RTL\t\t; @endfunc\n";
					assembly += "\n";
				}
				else
				{
					cCode += new LongDividerModulator(xSize, ySize, true).get();
				}
			}
		
		AsmBuilder b = new AsmBuilder();
		b.addUnits(C99Compiler.compile("imp_longdiv.c", cCode, true));
		assembly += "\n" + b.buildModule(new CartConfig(), new MemorySize(0, 0, 0, 0, false)).getAssembly();
		FileIO.writeFile("./src/imp_math/imp_mult.asm", assembly.getBytes());
		FileIO.writeFile("./src/imp_math/imp_longdiv.c", cCode.getBytes());
	}
}
