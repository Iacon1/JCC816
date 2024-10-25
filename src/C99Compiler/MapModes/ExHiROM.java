// Created by Iacon1 on 01/23/2024.
// ExHiROM cartridge type
package C99Compiler.MapModes;

public class ExHiROM extends HiROM
{
	@Override public String getName() {return "ExHiROM";}
	@Override public byte getCode() {return 0x05;}
	
	@Override public int getROMBankLength(boolean isFast, int i)
	{
		switch (i)
		{
		case 0: case 128: case 129:
			return 32 * 1024;
		default:
			return 64 * 1024;
		}
	}
	@Override public int getMaxROMBanks(boolean isFast) {return 131;}
	@Override public int getROMBankStart(boolean isFast, int i)
	{
		if (i == 0)
			return 0x408000;
		else if (i < 64)
			return 0x400000 + i * 0x010000;
		else if (i < 128)
			return 0xC00000 + (i - 64) * 0x01000;
		else if (i == 128)
			return 0x400000;
		else if (i == 129)
			return 0x3E8000;
		else
			return 0x3F8000;
	}
	@Override public int getROMBankAlign(int i) {return (i < 4) ? 0x008000 : 0x010000;}
	@Override public int getHeaderAddress(boolean isFast) {return 0x40FFB0;}
	@Override public int getVectorAddress(boolean isFast) {return 0x40FFE0;}
	@Override public boolean isContiguous(int i) {return i != 63 && i < 127;}
}
