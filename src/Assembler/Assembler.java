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
import Assembler.Configs.Configurer;
import C99Compiler.Utils.FileIO;
import Logging.Logging;

public class Assembler
{
	// toLinux = 0 -> LF to CRLF, = 1 -> CRLF to LF
	private static void convertNewline(String filename, boolean toLinux) throws IOException
	{
		File file = new File(filename);
		char[] chars = FileIO.readFile(file).toCharArray();
		file.delete();
		FileOutputStream outStream = new FileOutputStream(file);
		if (toLinux) outStream.write(new String(chars).replaceAll("\\r\\n?", "\n").getBytes());
		else outStream.write(new String(chars).replaceAll("\\n", "\r\n").getBytes());
		outStream.close();
	}
	public static byte[] assemble(String name, CartConfig cartConfig, String assembly) throws IOException
	{
		File cfgFile, asmFile, sfcFile, dbgFile;
		cfgFile = new File(name + ".cfg");
		asmFile = new File(name + ".asm");
		sfcFile = new File(name + ".sfc");
		FileOutputStream configStream = new FileOutputStream(cfgFile);
		FileOutputStream asmStream = new FileOutputStream(asmFile);
		FileInputStream sfcStream;
		
		Configurer.selectConfig(cartConfig).writeConfig(configStream, 2);
		configStream.close();
		
		asmStream.write(assembly.getBytes());
		asmStream.close();
		
		Process proc;
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			proc = Runtime.getRuntime().exec(new String[] {"cl65", "--verbose", "-g", "-C", cfgFile.getAbsolutePath(), "-o", sfcFile.getAbsolutePath(), asmFile.getAbsolutePath(), "-Wl", "--dbgfile", "-Wl", name + ".dbg"});
		else
			proc = Runtime.getRuntime().exec(new String[] {"cl65", "--verbose", "-C", cfgFile.getAbsolutePath(), "-o", sfcFile.getAbsolutePath(), asmFile.getAbsolutePath()});
		Logging.logNotice(new String(proc.getErrorStream().readAllBytes()));
		Logging.logNotice(new String(proc.getInputStream().readAllBytes()));
		while (proc.isAlive());
		sfcStream = new FileInputStream(sfcFile);
		byte[] bytes = sfcStream.readAllBytes();
		sfcStream.close();

		Header header = new Header("TT", "TEST", "TEST", 0, 0, DestinationCode.USA, cartConfig);

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
		if (DebugLevel.isAtLeast(DebugLevel.medium))
		{
			dbgFile = new File(name + ".dbg");
			convertNewline(dbgFile.getAbsolutePath(), true);
		}
			
		return bytes;
	}
}
