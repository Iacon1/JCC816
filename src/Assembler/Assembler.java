// Created by Iacon1 on 10/24/2023.
// Assembles assembly into a ROM by calling CA65.
package Assembler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Assembler.Header.CartridgeType;
import Assembler.Header.DestinationCode;
import Assembler.Header.MapMode;
import Logging.Logging;

public class Assembler
{
	public static byte[] assemble(String name, String assembly, String cfgType, boolean debug) throws IOException
	{
		File cfgFile, asmFile, sfcFile;
		cfgFile = new File(name + ".cfg");
		asmFile = new File(name + ".asm");
		sfcFile = new File(name + ".sfc");
		FileOutputStream configStream = new FileOutputStream(cfgFile);
		FileOutputStream asmStream = new FileOutputStream(asmFile);
		FileInputStream sfcStream;
		
		String config = new String(ClassLoader.getSystemResourceAsStream("Assembler/Configs/" + cfgType + ".cfg").readAllBytes());
		configStream.write(config.getBytes());
		configStream.close();
		
		asmStream.write(assembly.getBytes());
		asmStream.close();
		
		Process proc;
		if (debug)
			proc = Runtime.getRuntime().exec(new String[] {"cl65", "--verbose", "-g", "-C", cfgFile.getAbsolutePath(), "-o", sfcFile.getAbsolutePath(), "-Ln", name + ".cpu.sym", asmFile.getAbsolutePath()});
		else
			proc = Runtime.getRuntime().exec(new String[] {"cl65", "--verbose", "-C", cfgFile.getAbsolutePath(), "-o", sfcFile.getAbsolutePath(), asmFile.getAbsolutePath()});
		Logging.logNotice(new String(proc.getErrorStream().readAllBytes()));
		Logging.logNotice(new String(proc.getInputStream().readAllBytes()));
		while (proc.isAlive());
		sfcStream = new FileInputStream(sfcFile);
		byte[] bytes = sfcStream.readAllBytes();
		sfcStream.close();
		
		Header header = new Header("TT", "TEST", "TEST", 0, 0, 128, 0, false, MapMode.LoROM268, CartridgeType.ROMOnly, DestinationCode.USA);

		header.calcChecksum(bytes);
		byte[] headerBytes = header.asBytes();
		for (int i = header.getOffset(); i < header.getOffset() + Header.size; ++i) bytes[i] = headerBytes[i - header.getOffset()];
		
		header.calcChecksum(bytes);
		headerBytes = header.asBytes();
		for (int i = header.getOffset(); i < header.getOffset() + Header.size; ++i) bytes[i] = headerBytes[i - header.getOffset()];
		
		
		return bytes;
	}
}
