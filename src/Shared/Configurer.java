// Created by Iacon1 on 01/14/2024.
// Creates a config file
package Shared;

import java.io.FileOutputStream;
import java.io.IOException;

public interface Configurer
{
	static final String whitespace = "  "; // Whitespace
	
	public String getName();
	public String getRegions(MemorySize requirements);
	public String getSegments(MemorySize requirements);
	
	public default String getConfig(MemorySize memorySize)
	{
		String config = "";
		
		config += "# ca65 linker config for " + getName() + "\n";
		
		config += "\n";
		
		config += "# Physical areas of memory\n";
		config += "MEMORY\n";
		config += "{\n";
		config += getRegions(memorySize);
		config += "}\n";
		
		config += "\n";
		
		config += "# Logical areas of memory\n";
		config += "SEGMENTS\n";
		config += "{\n";
		config += getSegments(memorySize);
		config += "}\n";
		
		return config;
	}
	
	public default void writeConfig(FileOutputStream file, MemorySize requirements) throws IOException
	{
		file.write(getConfig(requirements).getBytes());
	}
}
