// Created by Iacon1 on 01/15/2024.
// Executable

package Executables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import AsmBuilder.ModuleAssemblyUnit;
import AsmBuilder.AsmBuilder;

import C99Compiler.CompConfig;
import C99Compiler.C99Compiler;
import C99Compiler.Preprocessor;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompConfig.VerbosityLevel;
import C99Compiler.CompilerNodes.Dummies.DummyTranslationUnit;
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
				.longOpt("link")
				.hasArg()
				.argName("output> <header")
				.numberOfArgs(2)
				.valueSeparator()
				.desc("Links the provided source and object files into a single specified SFC file according to a provided header configuration.")
				.build();
		options.addOption(option);
		/*
		option = Option.builder("o")
				.longOpt("object")
				.hasArg()
				.argName("output> <header")
				.numberOfArgs(2)
				.valueSeparator()
				.desc("Assembles the provided source file into an object file, optionally according to a provided header configuration.")
				.build();
		options.addOption(option);
		*/
		option = Option.builder("s")
				.longOpt("assembler")
				.hasArg()
				.argName("output> <header")
				.numberOfArgs(2)
				.valueSeparator()
				.desc("Compiles the provided source file into an assembly file, optionally according to a provided header configuration.")
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
		
		option = Option.builder()
				.longOpt("optimize-addresses")
				.desc("Optimizes most memory accesses to use 16 bit instead of 24 bit addressing. Only valid if < 64 KB of work memory are used.")
				.build();
		options.addOption(option);
		
		option = Option.builder()
				.longOpt("fast-byte-count")
				.desc("Uses a faster but more generous method for estimating the size of assembly chunks during banking.")
				.build();
		options.addOption(option);
		
		option = Option.builder()
				.longOpt("no-node-caching")
				.desc("Disables caching of searches in the node tree. Uses less memory but takes a lot longer.")
				.build();
		options.addOption(option);
		
		option = Option.builder()
				.longOpt("no-static-initialization")
				.desc("Doesn't initialize static variables. Not compliant with standard.")
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
	
	private static boolean isHeaderLoaded(Map<String, TranslationUnit> translationUnits, String headerName)
	{
		String nameA, nameC;
		
		nameA = headerName.replace(".h", ".asm");
		nameC = headerName.replace(".h", ".c");
		
		return translationUnits.containsKey(headerName) || translationUnits.containsKey(nameA) || translationUnits.containsKey(nameC);
	}
	private static TranslationUnit loadUnit(String sourceName, boolean isHeader, boolean isResource, Header ROMHeader) throws Exception
	{
		String sourceNameA, sourceNameC, sourceNameH;
		
		if (isHeader)
		{
			sourceNameA = sourceName.replace(".h", ".asm");
			sourceNameC = sourceName.replace(".h", ".c");
			sourceNameH = null;
		}
		else
		{
			sourceNameA = null;
			sourceNameC = null;
			sourceNameH = null;
			if (sourceName.endsWith(".asm"))
				sourceNameA = sourceName;
			else if (sourceName.endsWith(".c"))
				sourceNameC = sourceName;
			else if (sourceName.endsWith(".h"))
				sourceNameH = sourceName;
		}
		
		if (sourceNameC != null && (isResource ? FileIO.hasResource(sourceNameC) : FileIO.hasFile(sourceNameC)))
		{
			if (VerbosityLevel.isAtLeast(VerbosityLevel.high))
				Logging.logNotice("Loading file " + sourceNameC);
			String fileText = isResource ? FileIO.readResource(sourceNameC) : FileIO.readFile(sourceNameC);
			if (!isResource) sourceNameC = FileIO.getFile(sourceNameC).getPath();
			return C99Compiler.compile(sourceNameC, fileText, ROMHeader);
		}
		else if (sourceNameA != null && (isResource ? FileIO.hasResource(sourceNameA) : FileIO.hasFile(sourceNameA)))
		{
			if (VerbosityLevel.isAtLeast(VerbosityLevel.high))
				Logging.logNotice("Loading file " + sourceNameA);
			String fileText = isResource ? FileIO.readResource(sourceNameA) : FileIO.readFile(sourceNameA);
			if (!isResource) sourceNameA = FileIO.getFile(sourceNameA).getPath();
			if (fileText.startsWith(ModuleAssemblyUnit.getPrefix()))
				return new ModuleAssemblyUnit(fileText);
			else
				return new AssemblyUnit(sourceNameA, fileText);
		}
		else if (sourceNameH != null && (isResource ? FileIO.hasResource(sourceNameH) : FileIO.hasFile(sourceNameH)))
		{
			if (VerbosityLevel.isAtLeast(VerbosityLevel.high))
				Logging.logNotice("Loading file " + sourceNameH);
			String fileText = isResource ? FileIO.readResource(sourceNameH) : FileIO.readFile(sourceNameH);
			if (!isResource) sourceNameH = FileIO.getFile(sourceNameH).getPath();
			return C99Compiler.compile(sourceNameH, fileText);
		}
		else
			return null;
	}
	private static void resolveIncludes(Map<String, TranslationUnit> translationUnits, Header ROMHeader) throws Exception
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
				stdLib = "stdlib\\" + stdLib;
				if (stdLib.endsWith(".h"))
				{
					if (isHeaderLoaded(translationUnits, stdLib)) continue;
					translationUnits.put(stdLib, new DummyTranslationUnit(stdLib));
				}
				TranslationUnit unit = loadUnit(stdLib, true, true, ROMHeader);
				if (unit != null)
					translationUnits.put(unit.getFilename(), unit);
				else if (!stdLib.endsWith(".h"))
					Logging.logError("File not found: " + stdLib);
			}
			
			for (String otherLib : includedOtherLibs)
			{
				if (otherLib.endsWith(".h"))
				{
					if (isHeaderLoaded(translationUnits, otherLib)) continue;
					translationUnits.put(otherLib, new DummyTranslationUnit(otherLib));
				}
				TranslationUnit unit = loadUnit(otherLib, true, false, ROMHeader);
				if (unit != null)
					translationUnits.put(unit.getFilename(), unit);
				else if (!otherLib.endsWith(".h"))
					Logging.logError("File not found: " + otherLib);
			}
		}
		return;
	}
	
	public static void main(String[] args) throws Exception
	{
		AsmBuilder builder = new AsmBuilder();
		Header header;
		
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
			CompConfig.rootFolder = commandLine.getOptionValue("r").replace("/", "\\");
		
		if (commandLine.hasOption("H"))
		{
			String filename = commandLine.getOptionValue("H");
			FileIO.writeFile(filename, FileIO.readResourceBytes("XML\\Header.XML"));
			return;
		}
		
		// Load header
		if (commandLine.hasOption("l")) // Executable
		{
			String headerName = commandLine.getOptionValues("l")[1];
			header = new Header(FileIO.readFileXML(headerName));
		}
		else if (commandLine.hasOption("s")) // Assembly
		{
			String headerName = commandLine.getOptionValues("s")[1];
			header = new Header(FileIO.readFileXML(headerName));
		}
		else
			header = null;
		
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
			case "3" : CompConfig.verbosityLevel = VerbosityLevel.high; break;
			}
		
		if (commandLine.hasOption("optimize-addresses"))
			CompConfig.wordAddresses = true;
		if (commandLine.hasOption("fast-byte-count"))
			CompConfig.fastByteCount = true;
		if (commandLine.hasOption("no-node-caching"))
			CompConfig.cacheSearches = false;
		if (commandLine.hasOption("no-static-initialization"))
			CompConfig.initializeStatics = false;
		
		if (commandLine.hasOption("l") || commandLine.hasOption("s")) // Link to executable or to assembly
		{	
			Map<String, TranslationUnit> translationUnits  = new HashMap<String, TranslationUnit>();
			List<String> filenames = new LinkedList<String>();
			for (String parameter : commandLine.getArgList())
			{
				List<String> matchingFiles = FileIO.matchingFiles(parameter);
				if (matchingFiles.isEmpty())
					Logging.logError("File not found: " + parameter);
				else
					filenames.addAll(matchingFiles);
			}
			
			for (String filename : filenames) // Read all input files
			{
				TranslationUnit unit = loadUnit(filename, false, false, header);
				if (unit != null)
					translationUnits.put(unit.getFilename(), unit);
				else
					Logging.logError("File not found: " + filename);
			}
			
			if (commandLine.hasOption("s"))
			{
				if (translationUnits.size() > 1)
					Logging.logError("Multiple sources provided. Only saving file " + filenames.get(0) + ".");
			}
			else
				resolveIncludes(translationUnits, header);
			
			builder.addUnits(translationUnits.values().toArray(new TranslationUnit[] {}));

			MemorySize memorySize = new MemorySize(0, 0, 0, false);

			if (commandLine.hasOption("l")) // Executable
			{
				String outName = commandLine.getOptionValues("l")[0];
				if (header == null) header = new Header();
				String assembly = builder.build(header, memorySize);
				Assembler.assemble(outName, header, assembly, commandLine.hasOption("c"), memorySize);
			}
			else if (commandLine.hasOption("s")) // Assembly
			{
				String outName = commandLine.getOptionValues("s")[0];
				if (header == null) header = new Header();
				
				ModuleAssemblyUnit unit = builder.buildModule(header, memorySize);
				if (!outName.endsWith(".asm"))
					outName = outName + ".asm";
				FileIO.writeFile(outName, unit.save());
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
	}

}
