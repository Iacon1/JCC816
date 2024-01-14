// Created by Iacon1 on 01/14/2024.
// Generates a LoROM config for CA65

package Assembler.Configs;

import Compiler.CompConfig;

public class LoROMConfigurer implements Configurer
{

	@Override
	public String getName()
	{
		return "LoROM";
	}

	@Override
	public String getRegions(int banks)
	{
		banks = Math.max(banks, 4); // Minimum 128 KB
		String regions = "";
		regions += whitespace + "ZEROPAGE: start = 0, size = $100;\n".replace(" ", "\t");
		regions += whitespace + "BSS: start = $200, size = $1800;\n".replace(" ", "\t");
		for (int i = 0; i < banks; ++i)
			regions += whitespace + "ROMBANK" + i + ": start = $" + String.format("%x",  i * 0x10000 + 0x8000) + ", size = $8000, fill = yes;\n".replace(" ", "\t");
		
		return regions;
	}

	@Override
	public String getSegments(int banks)
	{
		banks = Math.max(banks, 4); // Minimum 128 KB
		String segments = "";
		segments += whitespace + "ZEROPAGE: load = ZEROPAGE, type=zp;\n".replace(" ", "\t");
		segments += whitespace + "BSS: load = BSS, type=bss, align = $100;\n".replace(" ", "\t");
		segments += whitespace + CompConfig.bankName(0) + ": load = ROMBANK0, align = $8000;\n".replace(" ", "\t");
		segments += whitespace + "HEADER: load = ROMBANK0, start = $FFB0;\n".replace(" ", "\t");
		segments += whitespace + "VECTORS: load = ROMBANK0, align = $FFE0;\n".replace(" ", "\t");
		for (int i = 1; i < banks; ++i)
			segments += whitespace + CompConfig.bankName(i) + ": load = ROMBANK" + i + ", align = $8000;\n".replace(" ", "\t");		
		
		return segments;
	}
}
