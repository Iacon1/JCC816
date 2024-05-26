// Created by Iacon1 on 10/24/2023.
// Assembles assembly into a ROM by calling CA65.
package Assembler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import Assembler.Header.DestinationCode;
import C99Compiler.CartConfig;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompConfig.VerbosityLevel;
import C99Compiler.Exceptions.AssemblerException;
import C99Compiler.Utils.FileIO;
import Logging.Logging;

public class Assembler
{
	public static byte[] assemble(String name, Header header, String assembly, List<String> objects, boolean cleanup, MemorySize memorySize) throws Exception
	{
		if (name.endsWith(".sfc"))
			name = name.replace(".sfc", "");
		File cfgFile, asmFile, sfcFile, dbgFile;
		cfgFile = FileIO.getFileER(name + ".cfg");
		asmFile = FileIO.getFileER(name + ".asm");
		sfcFile = FileIO.getFileER(name + ".sfc");
		dbgFile = FileIO.getFileER(name + ".dbg");
		FileOutputStream configStream = new FileOutputStream(cfgFile);
		FileOutputStream asmStream = new FileOutputStream(asmFile);
		FileInputStream sfcStream;
		
		header.getType().writeConfig(configStream, memorySize);
		configStream.close();
		
		asmStream.write(assembly.getBytes());
		asmStream.close();
		
		Process proc;
		List<String> parameters = new LinkedList<String>();
		parameters.add("cl65");
		parameters.add("--verbose");
		if (DebugLevel.isAtLeast(DebugLevel.medium))
			parameters.add("-g");
		parameters.add("-C");
		parameters.add(cfgFile.getAbsolutePath());
		parameters.add("-o");
		parameters.add(sfcFile.getAbsolutePath());
		parameters.add(asmFile.getAbsolutePath());
		for (String object : objects)
			parameters.add(FileIO.getFile(object).getAbsolutePath());
		if (DebugLevel.isAtLeast(DebugLevel.medium))
		{
			parameters.add("-Wl");
			parameters.add("--dbgfile");
			parameters.add("-Wl");
			parameters.add(dbgFile.getAbsolutePath());
		}
		proc = Runtime.getRuntime().exec(parameters.toArray(new String[] {}), null, sfcFile.getParentFile());
		String error = new String(proc.getErrorStream().readAllBytes());
		if (!error.isEmpty()) throw new AssemblerException(error);
		// Logging.logNotice(new String(proc.getInputStream().readAllBytes()));
		while (proc.isAlive());
		sfcStream = new FileInputStream(sfcFile);
		byte[] bytes = sfcStream.readAllBytes();
		sfcStream.close();

		header.calcSRAMSize(memorySize.SRAMSize);
		header.calcROMSize(bytes);
		header.calcChecksum(bytes);
		byte[] headerBytes = header.asBytes();
		for (int i = header.getOffset(); i < header.getOffset() + header.getSize(); ++i)
			bytes[i] = headerBytes[i - header.getOffset()];
		
		header.calcChecksum(bytes);
		headerBytes = header.asBytes();
		for (int i = header.getOffset(); i < header.getOffset() + header.getSize(); ++i)
			bytes[i] = headerBytes[i - header.getOffset()];
		FileIO.writeFile(sfcFile.getName(), bytes);

		if (cleanup)
		{
			cfgFile.delete();
			asmFile.delete();
		}
		
		return bytes;
	}
	
	public static byte[] assembleObject(String name, Header header, String assembly, boolean cleanup) throws Exception
	{
		if (name.endsWith(".o"))
			name = name.replace(".o", "");
		File asmFile, oFile;
		asmFile = FileIO.getFileER(name + ".asm");
		oFile = FileIO.getFileER(name + ".o");

		FileOutputStream asmStream = new FileOutputStream(asmFile);
		FileInputStream oStream;
		
		asmStream.write(assembly.getBytes());
		asmStream.close();
		
		Process proc;
		if (DebugLevel.isAtLeast(DebugLevel.medium))
			proc = Runtime.getRuntime().exec(new String[] {"cl65", "--verbose", "-g", "-c",
					"-o", oFile.getAbsolutePath(),
					asmFile.getAbsolutePath(),
					}, null, oFile.getParentFile());
		else
			proc = Runtime.getRuntime().exec(new String[] {"cl65", "--verbose", "-c",
					"-o", oFile.getAbsolutePath(),
					asmFile.getAbsolutePath()});
		String error = new String(proc.getErrorStream().readAllBytes());
		if (!error.isEmpty()) throw new AssemblerException(error);
		// Logging.logNotice(new String(proc.getInputStream().readAllBytes()));
		while (proc.isAlive());
		oStream = new FileInputStream(oFile);
		byte[] bytes = oStream.readAllBytes();
		oStream.close();

		if (cleanup)
		{
			asmFile.delete();
		}
		
		return bytes;
	}
	
	public static boolean hasCL65()
	{
		try
		{
			Process proc = Runtime.getRuntime().exec(new String[] {"cl65", "--version"});
			InputStream stream = proc.getErrorStream();
			String s = new String(stream.readAllBytes());
			stream.close();
			if (!s.startsWith("cl65")) // Did not return version correctly.
				return false;
			else
				return true;
		}
		catch (Exception e) {return false;}
	}
}
