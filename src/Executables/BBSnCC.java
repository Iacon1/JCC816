// Created by Iacon1 on 01/15/2024.
// Executable

package Executables;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import Assembler.Header;
import Assembler.MemorySize;
import C99Compiler.CartConfig;
import C99Compiler.CompConfig;
import C99Compiler.C99Compiler;
import C99Compiler.Linker;
import C99Compiler.Preprocessor;
import C99Compiler.CartConfig.AddonChip;
import C99Compiler.CartConfig.MapMode;
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
		options.addOption("l", "linker", true, "Links the provided source and object files into a single specified output file.");
		options.addOption("p", "preprocessor", true, "Preprocesses the provided source file into a specified output file.");
		
		options.addOption("c", "cartridge-config", true, "Specifies a cartridge configuration to use.");
		options.addOption("h", "header", true, "Specifies a header file to use.");
		options.addOption("C", "generate-cartridge", true, "Generates a default cartridge configuration file for the user to edit.");
		options.addOption("H", "generate-header", true, "Generates a default header configuration file for the user to edit.");
		
		options.addOption("o", "optimization-level", true, "Sets the level of optimization, from 0 to 3.");
		options.addOption("d", "debug-level", true, "Sets the level of debug info, from 0 to 2.");
		options.addOption("v", "verbosity-level", true, "Sets the level of console output, from 0 to 1.");
		
		options.addOption("r", "root", true, "Specifies the root directory to search for non-stdlib header files in.");
		
		return options;
	}
	public static void main(String[] args) throws Exception
	{
		Linker linker = new Linker();
		
		Logging.setLogger(new DebugLogger());
		
		CommandLine commandLine = new DefaultParser().parse(getOptions(), args);
		
		if (commandLine.hasOption("r")) // Root
			CompConfig.rootFolder = commandLine.getOptionValue("r");
		
		if (commandLine.hasOption("C"))
		{
			String filename = commandLine.getOptionValue("C");
			FileIO.writeFile(filename, FileIO.readResourceBytes("XML/CartConfig.XML"));
			return;
		}
		
		if (commandLine.hasOption("H"))
		{
			String filename = commandLine.getOptionValue("H");
			FileIO.writeFile(filename, FileIO.readResourceBytes("XML/Header.XML"));
			return;
		}
		
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
				String sourceName = "stdlib/" + stdLib.replace(".h", "") + ".c";
				if (FileIO.hasResource(sourceName))
				{
					String fileText = FileIO.readResource(sourceName);
					translationUnits.add(0, C99Compiler.compile(stdLib, fileText));
				}
			}
			
			String name = commandLine.getOptionValue("l");

			linker.addUnits(translationUnits);
			
			MemorySize memorySize = new MemorySize(0, 0, 0, false);
			
			Header header = null;
			if (commandLine.hasOption("c"))
			{
				CartConfig cartConfig = new CartConfig(FileIO.readFileXML(commandLine.getOptionValue("c")));
				header = new Header(cartConfig);
			}
			else if (commandLine.hasOption("h"))
				header = new Header(FileIO.readFileXML(commandLine.getOptionValue("h")));
			else header = new Header();
			String assembly = linker.link(header, memorySize);
			Assembler.Assembler.assemble(name, header, assembly, memorySize);
		}
		else if (commandLine.hasOption("p")) // Preprocess
		{
			String parameter = commandLine.getArgList().get(0);
			String fileText = FileIO.readFile(parameter);
			fileText = Preprocessor.preprocess(new HashSet<String>(), parameter, fileText);
			byte[] fileBytes = fileText.getBytes();
			FileIO.writeFile(commandLine.getOptionValue("p"), fileBytes);
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
