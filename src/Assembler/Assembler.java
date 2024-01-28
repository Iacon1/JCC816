// Created by Iacon1 on 10/24/2023.
// Assembles assembly into a ROM by calling CA65.
package Assembler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Assembler.Header.DestinationCode;
import C99Compiler.CartConfig;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompConfig.VerbosityLevel;
import C99Compiler.Exceptions.AssemblerException;
import C99Compiler.Utils.FileIO;
import Logging.Logging;

public class Assembler
{
	public static byte[] assemble(String name, Header header, String assembly, MemorySize memorySize) throws Exception
	{
		File cfgFile, asmFile, sfcFile;
		cfgFile = new File(name + ".cfg");
		asmFile = new File(name + ".asm");
		sfcFile = new File(name + ".sfc");
		FileOutputStream configStream = new FileOutputStream(cfgFile);
		FileOutputStream asmStream = new FileOutputStream(asmFile);
		FileInputStream sfcStream;
		
		header.getType().writeConfig(configStream, memorySize);
		configStream.close();
		
		asmStream.write(assembly.getBytes());
		asmStream.close();
		
		Process proc;
		if (DebugLevel.isAtLeast(DebugLevel.medium))
			proc = Runtime.getRuntime().exec(new String[] {"cl65", "--verbose", "-g", "-C", cfgFile.getAbsolutePath(), "-o", sfcFile.getAbsolutePath(), asmFile.getAbsolutePath(), "-Wl", "--dbgfile", "-Wl", name + ".dbg"});
		else
			proc = Runtime.getRuntime().exec(new String[] {"cl65", "--verbose", "-C", cfgFile.getAbsolutePath(), "-o", sfcFile.getAbsolutePath(), asmFile.getAbsolutePath()});
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
		FileIO.writeFile(sfcFile.getAbsolutePath(), bytes);

		return bytes;
	}
}
