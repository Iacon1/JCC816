// Created by Iacon1 on 01/23/2024.
//
package Shared.MapModes;

public class HiROM implements MapModeInterface
{
	@Override public String getName() {return "HiROM";}
	@Override public byte getCode() {return 0x01;}

	@Override public int getWRAMBankLength() {return 128*1024;} // 128 KB since we use the contiguous mirror
	@Override public int getSRAMBankLength() {return 8*1024;} // 8 KB
	@Override public int getROMBankLength(boolean isFast, int i) {return 64 * 1024;} // 4096 KB
	
	@Override public int getMaxWRAMBanks() {return 1;}
	@Override public int getMaxSRAMBanks() {return 16;} // 16 * 8 = 128 KB
	@Override public int getMinROMBanks() {return 2;}
	@Override public int getMaxROMBanks(boolean isFast) {return 64;}
	
	@Override public int getWRAMBankStart(int i) {return 0x7E0000;}
	@Override public int getSRAMBankStart(int i) {return 0xB06000 + 0x010000 * i;}
	@Override public int getROMBankStart(boolean isFast, int i) // Last 2 banks only accessable in FastROM space
	{
		return (isFast ? 0xC00000 : 0x400000) + i * 0x010000;
	} 
	@Override public int getROMBankAlign(int i)
	{
		if (i == 0)
			return 0x008000;
		else
			return 0x010000;
	} // 4096 KB ; 
	@Override public int getHVAddress(boolean isFast) {return (isFast ? 0xC0FFB0 : 0x40FFB0) - 24;}
	@Override public boolean isContiguous(int i) {return true;}
}
