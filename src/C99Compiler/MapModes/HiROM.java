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
		if (i == 0 || i == 64)
			return 32 * 1024;
		else
			return 64 * 1024;
	} // 4096 KB ; 
	
	@Override public int getMaxWRAMBanks() {return 1;}
	@Override public int getMaxSRAMBanks() {return 16;} // 16 * 8 = 128 KB
	@Override public int getMinROMBanks() {return 2;}
	@Override public int getMaxROMBanks(boolean isFast) {return 65;} // Split zero bank into 2
	
	@Override public int getWRAMBankStart(int i) {return 0x7E0000;}
	@Override public int getSRAMBankStart(int i) {return 0xB06000 + 0x010000 * i;}
	@Override public int getROMBankStart(boolean isFast, int i) // Last 2 banks only accessable in FastROM space
	{
		int start = (isFast || i >= 63) ? 0xC00000 : 0x400000;
		if (i == 0) // Start of bank 0 has to be here because 0x000000-0x007fff are mapped to something else
			return start + 0x8000;
		else if (i == 64)
			return start;
		else
			return start + i * 0x010000;
	} 
	@Override public int getROMBankAlign(int i) {return (i < 2) ? 0x008000 : 0x010000;}
	@Override public int getHeaderAddress(boolean isFast) {return isFast ? 0xC0FFB0 : 0x40FFB0;}
	@Override public int getVectorAddress(boolean isFast) {return isFast ? 0xC0FFE0 : 0x40FFE0;}
}
