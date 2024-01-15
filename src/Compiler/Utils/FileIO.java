// Created by Iacon1 on 01/15/2024.
// File IO util methods
package Compiler.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class FileIO
{
	public static final String readResource(String filename) throws IOException
	{
		return new String(ClassLoader.getSystemResourceAsStream(filename).readAllBytes());
	}
	
	public static final String readFile(File file) throws IOException
	{
		FileInputStream inStream = new FileInputStream(file);
		char[] chars = new char[(int) file.length()];
		BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
		reader.read(chars);
		reader.close();
		inStream.close();
		
		return new String(chars);
	}
	
	public static final String readFile(String filename) throws IOException
	{
		return readFile(new File(filename));
	}
}
