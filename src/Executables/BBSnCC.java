// Created by Iacon1 on 01/15/2024.
// Executable

package Executables;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import Assembler.Header;
import C99Compiler.CartConfig;
import C99Compiler.CompConfig;
import C99Compiler.C99Compiler;
import C99Compiler.Linker;
import C99Compiler.Preprocessor;
import C99Compiler.CartConfig.AddonChip;
import C99Compiler.CartConfig.ROMType;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompConfig.VerbosityLevel;
import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.Utils.FileIO;
import Logging.DebugLogger;
import Logging.Logging;

public class BBSnCC
{

	private static Options getOptions()
	{
		Options options = new Options();
		options.addOption("l", "linker", true, "Links the source and object files into a single specified output file.");
		
		options.addOption("c", "cartridge-config", true, "Specifies a cartridge configuration to use.");
		options.addOption("h", "header", true, "Specifies a header file to use.");
		options.addOption("C", "generate-cartridge", false, "Generates a default cartridge configuration file for the user to edit.");
		options.addOption("H", "generate-header", false, "Generates a default header configuration file for the user to edit.");
		
		options.addOption("o", "optimization-level", true, "Sets the level of optimization, from 0 to 3.");
		options.addOption("d", "debug-level", true, "Sets the level of debug info, from 0 to 2.");
		options.addOption("v", "verbosity-level", true, "Sets the level of console output, from 0 to 1.");
		
		return options;
	}
	public static void main(String[] args) throws Exception
	{
		CartConfig cartConfig = new CartConfig(ROMType.loROM, AddonChip.none, false, false, 0); // Default ROM config
		Linker linker = new Linker();
		
		Logging.setLogger(new DebugLogger());
		
		CommandLine commandLine = new DefaultParser().parse(getOptions(), args);
		
		// Set levels
		if (commandLine.hasOption("o"))
			switch (commandLine.getOptionValue("o"))
			{
			case "0" : CompConfig.optimizationLevel = OptimizationLevel.min; break;
			case "1" : CompConfig.optimizationLevel = OptimizationLevel.low; break;
			case "2" : CompConfig.optimizationLevel = OptimizationLevel.medium; break;
			case "3" : CompConfig.optimizationLevel = OptimizationLevel.all; break;
			}
		if (commandLine.hasOption("d"))
			switch (commandLine.getOptionValue("d"))
			{
			case "0" : CompConfig.debugLevel = DebugLevel.none; break;
			case "1" : CompConfig.debugLevel = DebugLevel.low; break;
			case "2" : CompConfig.debugLevel = DebugLevel.medium; break;
			}
		if (commandLine.hasOption("v"))
			switch (commandLine.getOptionValue("v"))
			{
			case "0" : CompConfig.verbosityLevel = VerbosityLevel.none; break;
			case "1" : CompConfig.verbosityLevel = VerbosityLevel.low; break;
			case "2" : CompConfig.verbosityLevel = VerbosityLevel.medium; break;
			}
		
		
		if (commandLine.hasOption("c"))
		{
			
		}
		
		if (commandLine.hasOption("l")) // Link to executable
		{
			List<TranslationUnitNode> translationUnits  = new LinkedList<TranslationUnitNode>();
			for (String parameter : commandLine.getArgList()) // Read all input files
			{
				if (parameter.endsWith(".c") || parameter.endsWith(".h")) // C file
				{
					String fileText = FileIO.readFile(parameter);
					translationUnits.add(C99Compiler.compile(parameter, fileText));
				}
				else if (parameter.endsWith(".o"))
				{
					byte[] bytes = FileIO.readFileBytes(parameter);
					translationUnits.add(FileIO.deserialize(bytes));
				}
			}
			
			// Include std libs
			Set<String> includedStdLibs = new HashSet<String>();
			for (TranslationUnitNode unit : translationUnits)
				if (unit.getIncludedStdLibs() != null) includedStdLibs.addAll(unit.getIncludedStdLibs());
			
			for (String stdLib : includedStdLibs)
			{
				String fileText = FileIO.readResource("stdlib/" + stdLib.replace(".h", "") + ".c");
				translationUnits.add(0, C99Compiler.compile(stdLib, fileText));
			}
			
			String name = commandLine.getOptionValue("l");

			linker.addUnits(translationUnits);
			
			Assembler.Assembler.assemble(name, cartConfig, linker.link(new CartConfig()));
		}
		else // Save to .o files
			for (String parameter : commandLine.getArgList())
				if (parameter.endsWith(".c") || parameter.endsWith(".h")) // C file
				{
					String fileText = FileIO.readFile(parameter);
					TranslationUnitNode node = C99Compiler.compile(parameter, fileText);
					byte[] fileBytes = FileIO.serialize(node);
					FileIO.writeFile(parameter.replaceAll("\\.[ch]", ".o"), fileBytes);
				}
	}

}
