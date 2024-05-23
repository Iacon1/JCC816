// Created by Iacon1 on 01/15/2024.
// Executable

package Executables;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import Assembler.Assembler;
import Assembler.Header;
import Assembler.MemorySize;
import AsmBuilder.AssemblyUnit;
import AsmBuilder.AsmBuilder;

import C99Compiler.CartConfig;
import C99Compiler.CompConfig;
import C99Compiler.C99Compiler;
import C99Compiler.Preprocessor;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompConfig.VerbosityLevel;
import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.CompilerNodes.Interfaces.TranslationUnit;
import C99Compiler.Utils.FileIO;
import C99Compiler.Utils.LineInfo;
import Logging.DebugLogger;
import Logging.Logging;

public class JCC816
{
	private static final String helpName = "JCC816";
	private static final String helpHeader = "A C compiler for the WDC 65c816 and especially Ricoh 5a22 processor.\n\n";
	private static final String helpFooter = "\nVersion " + CompConfig.version + "; Source code available at https://github.com/Iacon1/JCC816.\n";
	
	private static Options getOptions()
	{
		Options options = new Options();
		Option option;
		
		option = Option.builder("l")
				.longOpt("linker")
				.hasArg()
				.argName("output> <header")
				.numberOfArgs(2)
				.valueSeparator()
				.desc("Links the provided source and object files into a single specified SFC file according to a provided header configuration.")
				.build();
		options.addOption(option);
		
		option = Option.builder("h")
				.longOpt("help")
				.desc("Displays information about the program's usage.")
				.build();
		options.addOption(option);
		
		option = Option.builder("p")
			.longOpt("preprocessor")
			.hasArg()
			.argName("output")
			.desc("Preprocesses the provided source file and stores it in a specified source file.")
			.build();
		options.addOption(option);
		
		option = Option.builder("o")
				.longOpt("object")
				.hasArg()
				.argName("output")
				.desc("Preprocesses the provided source file and stores it in a specified object file.")
				.build();
		options.addOption(option);
		
		option = Option.builder("H")
			.longOpt("generate-header")
			.hasArg()
			.argName("output")
			.desc("Generates a default header configuration file for the user to edit.")
			.build();
		options.addOption(option);
		
		option = Option.builder("O")
			.longOpt("optimization-level")
			.hasArg()
			.argName("level")
			.desc("Sets the level of optimization, from 0 to 3. Note that only levels 0 and 2 are meaningful for object files.")
			.build();
		options.addOption(option);
		
		option = Option.builder("D")
			.longOpt("debug-level")
			.hasArg()
			.argName("level")
			.desc("Sets the level of debug info generated, from 0 to 3.")
			.build();
		options.addOption(option);
	
		option = Option.builder("V")
			.longOpt("debug-level")
			.hasArg()
			.argName("level")
			.desc("Sets the level of console output, from 0 to 1.")
			.build();
		options.addOption(option);
		
		option = Option.builder("r")
				.longOpt("root")
				.hasArg()
				.argName("path")
				.desc("Specifies the root directory to search for files in. Otherwise defaults to current directory.")
				.build();
		options.addOption(option);
		
		option = Option.builder("c")
				.longOpt("cleanup")
				.desc("Ensures the assembler doesn't leave behind unecessary files.")
				.build();
		options.addOption(option);
		
		return options;
	}
	
	private static void resolveIncludes(Map<String, TranslationUnit> translationUnits) throws Exception
	{
		// Recursively resolve all libs
		Set<String> includedStdLibs = new HashSet<String>();
		Set<String> includedOtherLibs = new HashSet<String>();

		String oldHash = "";
		String hash = String.format("%x X %x", includedStdLibs.hashCode(), includedOtherLibs.hashCode());
		while (true)
		{
			oldHash = hash;
			for (TranslationUnit unit : translationUnits.values())
			{
				if (unit.getIncludedStdLibs() != null)
					includedStdLibs.addAll(unit.getIncludedStdLibs());
				if (unit.getIncludedOtherLibs() != null)
					includedOtherLibs.addAll(unit.getIncludedOtherLibs());
			}
			hash = String.format("%x X %x", includedStdLibs.hashCode(), includedOtherLibs.hashCode());
			
			if (hash.equals(oldHash)) break; // When nothing new is included, stop
			
			for (String stdLib : includedStdLibs)
			{
				String sourceNameC = "stdlib/" + stdLib.replace(".h", "") + ".c";
				String sourceNameA = "stdlib/" + stdLib.replace(".h", "") + ".asm";
				String sourceNameO = "stdlib/" + stdLib.replace(".h", "") + ".o";
				if (translationUnits.get(sourceNameC) != null ||
					translationUnits.get(sourceNameA) != null ||
					translationUnits.get(sourceNameO) != null) continue;
				
				
				if (FileIO.hasResource(sourceNameC))
				{
					String fileText = FileIO.readResource(sourceNameC);
					translationUnits.put(sourceNameC, C99Compiler.compile(sourceNameC, fileText));
				}
				else if (FileIO.hasResource(sourceNameO))
				{
					byte[] bytes = FileIO.readResourceBytes(sourceNameO);
					translationUnits.put(sourceNameO, FileIO.deserialize(bytes));
				}
				
				if (FileIO.hasResource(sourceNameA))
				{
					String fileText = FileIO.readResource(sourceNameA);
					translationUnits.put(sourceNameA, new AssemblyUnit(sourceNameA, fileText));
				}
			}
			
			for (String otherLib : includedOtherLibs)
			{
				otherLib = otherLib;
				String sourceNameC = otherLib.replace(".h", "") + ".c";
				String sourceNameA = otherLib.replace(".h", "") + ".asm";
				String sourceNameO = otherLib.replace(".h", "") + ".o";
				if (translationUnits.get(sourceNameC) != null ||
						translationUnits.get(sourceNameA) != null ||
						translationUnits.get(sourceNameO) != null) continue;
				
				if (FileIO.hasFile(sourceNameC))
				{
					String fileText = FileIO.readFile(sourceNameC);
					translationUnits.put(sourceNameC, C99Compiler.compile(sourceNameC, fileText));
				}
				else if (FileIO.hasFile(sourceNameO))
				{
					byte[] bytes = FileIO.readFileBytes(sourceNameO);
					translationUnits.put(sourceNameO, FileIO.deserialize(bytes));
				}
				else if (!FileIO.hasFile(otherLib) && !FileIO.hasFile(sourceNameA)) // Not found at all
				{
					Logging.logError("File not found: " + otherLib);
				}
				
				if (FileIO.hasFile(sourceNameA))
				{
					String fileText = FileIO.readFile(sourceNameA);
					translationUnits.put(sourceNameA, new AssemblyUnit(sourceNameA, fileText));
				}
				
			}
		}
		return;
	}
	
	public static void main(String[] args) throws Exception
	{
		AsmBuilder builder = new AsmBuilder();
		
		Logging.setLogger(new DebugLogger());
		
		CommandLine commandLine;
		try
		{
			commandLine = new DefaultParser().parse(getOptions(), args);
		}
		catch (ParseException e)
		{
			new HelpFormatter().printHelp(helpName, helpHeader, getOptions(), helpFooter, true);
			return;
		}
		if (commandLine.hasOption("help") || commandLine.getOptions().length == 0)
		{
			new HelpFormatter().printHelp(helpName, helpHeader, getOptions(), helpFooter, true);
			return;
		}
		if (commandLine.hasOption("l") && !Assembler.hasCL65()) // No Cl65 installed
		{
			Logging.logError("CL65 not detected. Cannot link to executable without Cl65 installed.");
			return;
		}
		
		if (commandLine.hasOption("r")) // Root
			CompConfig.rootFolder = commandLine.getOptionValue("r");
		
		if (commandLine.hasOption("H"))
		{
			String filename = commandLine.getOptionValue("H");
			FileIO.writeFile(filename, FileIO.readResourceBytes("XML/Header.XML"));
			return;
		}
		
		// Set levels
		if (commandLine.hasOption("O"))
			switch (commandLine.getOptionValue("O"))
			{
			case "0" : CompConfig.optimizationLevel = OptimizationLevel.min; break;
			case "1" : CompConfig.optimizationLevel = OptimizationLevel.low; break;
			case "2" : CompConfig.optimizationLevel = OptimizationLevel.medium; break;
			case "3" : CompConfig.optimizationLevel = OptimizationLevel.all; break;
			}
		if (commandLine.hasOption("D"))
			switch (commandLine.getOptionValue("D"))
			{
			case "0" : CompConfig.debugLevel = DebugLevel.none; break;
			case "1" : CompConfig.debugLevel = DebugLevel.low; break;
			case "2" : CompConfig.debugLevel = DebugLevel.medium; break;
			}
		if (commandLine.hasOption("V"))
			switch (commandLine.getOptionValue("V"))
			{
			case "0" : CompConfig.verbosityLevel = VerbosityLevel.none; break;
			case "1" : CompConfig.verbosityLevel = VerbosityLevel.low; break;
			case "2" : CompConfig.verbosityLevel = VerbosityLevel.medium; break;
			}
		
		if (commandLine.hasOption("l")) // Link to executable
		{	
			Map<String, TranslationUnit> translationUnits  = new HashMap<String, TranslationUnit>();
			List<String> filenames = new LinkedList<String>();
			for (String parameter : commandLine.getArgList())
				filenames.addAll(FileIO.matchingFiles(parameter));
			
			for (String filename : filenames) // Read all input files
			{
				if (filename.endsWith(".o"))
				{
					byte[] bytes = FileIO.readFileBytes(filename);
					translationUnits.put(filename, FileIO.deserialize(bytes));
				}
				else if (filename.endsWith(".c") || filename.endsWith(".h")) // C file
				{
					String fileText = FileIO.readFile(filename);
					translationUnits.put(filename, C99Compiler.compile(filename, fileText));
				}
				else if (filename.endsWith(".asm")) // ASM file
				{
					String fileText = FileIO.readFile(filename);
					translationUnits.put(filename, new AssemblyUnit(filename.replace(".asm", ""), fileText));
				}
			}
			
			resolveIncludes(translationUnits);
			
			builder.addUnits(translationUnits.values().toArray(new TranslationUnit[] {}));

			if (commandLine.hasOption("l")) // Link
			{
				MemorySize memorySize = new MemorySize(0, 0, 0, false);
				
				Header header = null;
	
				String sfcName = commandLine.getOptionValues("l")[0];
				String headerName = commandLine.getOptionValues("l")[1];
				header = new Header(FileIO.readFileXML(headerName));
				
				String assembly = builder.build(header, memorySize);
				Assembler.assemble(sfcName, header, assembly, commandLine.hasOption("c"), memorySize);
			}
		}
		else if (commandLine.hasOption("p")) // Preprocess
		{
			String parameter = commandLine.getArgList().get(0);
			String fileText = FileIO.readFile(parameter);
			fileText = Preprocessor.preprocess(new HashSet<String>(), new HashSet<String>(), new LinkedList<LineInfo>(), parameter, fileText);
			byte[] fileBytes = fileText.getBytes();
			FileIO.writeFile(commandLine.getOptionValue("p"), fileBytes);
		}
		else if (commandLine.hasOption("o")) // Object
		{
			String parameter = commandLine.getArgList().get(0);
			String fileText = FileIO.readFile(parameter);
			byte[] fileBytes = FileIO.serialize(C99Compiler.compile(parameter, fileText));
			FileIO.writeFile(commandLine.getOptionValue("o"), fileBytes);
		}
	}

}
