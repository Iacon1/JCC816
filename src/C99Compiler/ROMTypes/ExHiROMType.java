// Created by Iacon1 on 01/23/2024.
// ExHiROM cartridge type
package C99Compiler.ROMTypes;

public class ExHiROMType extends HiROMType
{
	@Override public String getName() {return "ExHiROM";}
	@Override public byte getCode() {return 0x05;}
	@Override public int getHeaderPosition(boolean longHeader) {return longHeader ? 0x40FFB0 : 0x40FFC0;}

	@Override public int getROMBankLength(boolean isFast, int i)
	{
		switch (i)
		{
		case 0: return 64 * 64 * 1024; // Q4 chunk
		case 1: return 62 * 64 * 1024; // Q2 chunk
		case 2: return 32 * 1024; // Q1 Chunk 1
		case 3: return 32 * 1024; // Q1 Chunk 2
		default: return 0; // Error
		}
	}  // 4096 / 3968 / 32 / 32 KB
	@Override public int getMaxROMBanks(boolean isFast) {return 4;} // 4096 + 3968 + 32 + 32 = 8128 KB
	@Override public int getROMBankStart(boolean isFast, int i)
	{
		switch (i)
		{
		case 0: return 0x800000;
		case 1: return 0x400000;
		case 2: return 0x3E8000;
		case 3: return 0x3F8000;
		default: return 0; // Error
		}
	}
	@Override public int getROMBankAlign(int i) {return (i < 2) ? 0x000000 : 0x008000;}
}
