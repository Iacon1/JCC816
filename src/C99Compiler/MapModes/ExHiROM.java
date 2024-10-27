// Created by Iacon1 on 01/23/2024.
// ExHiROM cartridge type
package C99Compiler.MapModes;

public class ExHiROM extends HiROM
{
	@Override public String getName() {return "ExHiROM";}
	@Override public byte getCode() {return 0x05;}
	
	@Override public int getROMBankLength(boolean isFast, int i)
	{
		if (i < 127)
			return 64 * 1024;
		else
			return 32 * 1024;
	}
	// banks 0-63 in C0-FF, 64-125 in 40-7D, 126 in 3E, and 127 in 3F.
	@Override public int getMaxROMBanks(boolean isFast) {return 128;}
	@Override public int getROMBankStart(boolean isFast, int i)
	{
		if (i < 64)
			return super.getROMBankStart(true, i);
		else if (i < 127)
			return super.getROMBankStart(false, i - 64);
		else if (i == 127)
			return 0x3E8000;
		else
			return 0x3F8000;
	}
	@Override public int getROMBankAlign(int i)
	{
		switch (i)
		{
		case 0: case 128: case 129:
			return 0x008000;
		default:
			return 0x010000;
		}
	}
	@Override public int getHVAddress(boolean isFast) {return super.getHVAddress(true);}
	@Override public boolean isContiguous(int i) {return i != 0 && i != 127;}
}
