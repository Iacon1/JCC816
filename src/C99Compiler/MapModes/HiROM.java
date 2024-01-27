// Created by Iacon1 on 01/23/2024.
//
package C99Compiler.MapModes;

public class HiROM implements MapModeInterface
{
	@Override public String getName() {return "HiROM";}
	@Override public byte getCode() {return 0x01;}
	@Override public int getHeaderPosition(boolean longHeader) {return longHeader ? 0x00FFB0 : 0x00FFC0;}
	
	@Override public int getWRAMBankLength() {return 128*1024;} // 128 KB since we use the contiguous mirror
	@Override public int getSRAMBankLength() {return 8*1024;} // 8 KB
	@Override public int getROMBankLength(boolean isFast, int i)
	{
		if (isFast)
			return 64 * 64 * 1024;
		else if (i == 0)
			return 62 * 64 * 1024;
		else return 2 * 64 * 1024;
	} // 4096 KB ; 
	
	@Override public int getMaxWRAMBanks() {return 1;}
	@Override public int getMaxSRAMBanks() {return 16;} // 16 * 8 = 128 KB
	@Override public int getMaxROMBanks(boolean isFast) {return isFast? 1 : 2;} // 1 * 64 = 4096 KB; 1 * 62 + 1 * 2 = 4096 KB
	
	@Override public int getWRAMBankStart(int i) {return 0x7E0000;}
	@Override public int getSRAMBankStart(int i) {return 0xB06000 + 0x010000 * i;}
	@Override public int getROMBankStart(boolean isFast, int i) {return (isFast || i == 1) ? 0x800000 : 0x000000;} // Last region only accessable in FastROM space
	@Override public int getROMBankAlign(int i) {return 0x000000;}
}
