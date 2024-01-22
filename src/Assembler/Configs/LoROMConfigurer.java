// Created by Iacon1 on 01/14/2024.
// Generates a LoROM config for CA65

package Assembler.Configs;

import C99Compiler.CompConfig;

public class LoROMConfigurer implements Configurer
{

	@Override
	public String getName()
	{
		return "LoROM";
	}

	@Override
	public String getRegions(ConfigRequirements requirements) // init size in bytes
	{
		int romBanks = Math.max(requirements.getCodeBanks(), 4); // Minimum 128 KB
		String regions = "";
		regions += whitespace + "ZEROPAGE: start = $000000, size = $000100;\n".replace(" ", "\t");
		regions += whitespace + "STACK: start = $000100, size = $1eff;\n".replace(" ", "\t");
		regions += whitespace + "WRAM: start = $7e1eff, size = $200000;\n".replace(" ", "\t");
		for (int i = 0; i < romBanks; ++i)
		{
			String regionStart = String.format("%06x",  i * 0x10000 + 0x8000);
			regions += whitespace + "ROMBANK" + i + ": start = $" + regionStart + ", size = $008000, type = ro, fill = yes;\n".replace(" ", "\t");
		}
		return regions;
	}

	@Override
	public String getSegments(ConfigRequirements requirements)
	{
		String segments = "";
		segments += whitespace + "ZEROPAGE: load = ZEROPAGE, type=zp;\n".replace(" ", "\t");
		segments += whitespace + CompConfig.codeBankName(0) + ": load = ROMBANK0, type = ro, align = $8000;\n".replace(" ", "\t");
		segments += whitespace + "HEADER: load = ROMBANK0, type = ro, start = $FFB0;\n".replace(" ", "\t");
		segments += whitespace + "VECTORS: load = ROMBANK0, type = ro, align = $FFE0;\n".replace(" ", "\t");

		for (int i = 1; i < requirements.getCodeBanks(); ++i)
			segments += whitespace + CompConfig.codeBankName(i) + ": load = ROMBANK" + i + ", type = ro, align = $8000;\n".replace(" ", "\t");		

		return segments;
	}
}
