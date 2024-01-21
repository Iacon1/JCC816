// Created by Iacon1 on 01/14/2024.
// Creates a config file
package Assembler.Configs;

import java.io.FileOutputStream;
import java.io.IOException;

import C99Compiler.CartConfig;

public interface Configurer
{
	static final String whitespace = "  "; // Whitespace
	
	public String getName();
	public String getRegions(ConfigRequirements requirements);
	public String getSegments(ConfigRequirements requirements);
	
	public default String getConfig(ConfigRequirements requirements)
	{
		String config = "";
		
		config += "# ca65 linker config for " + getName() + "\n";
		
		config += "\n";
		
		config += "# Physical areas of memory\n";
		config += "MEMORY\n";
		config += "{\n";
		config += getRegions(requirements);
		config += "}\n";
		
		config += "\n";
		
		config += "# Logical areas of memory\n";
		config += "SEGMENTS\n";
		config += "{\n";
		config += getSegments(requirements);
		config += "}\n";
		
		return config;
	}
	
	public default void writeConfig(FileOutputStream file, ConfigRequirements requirements) throws IOException
	{
		file.write(getConfig(requirements).getBytes());
	}
	
	public static Configurer selectConfig(CartConfig cartConfig)
	{
		switch (cartConfig.getType())
		{
		case loROM: return new LoROMConfigurer();
		// TODO
		default: return null;
		}
	}
}
