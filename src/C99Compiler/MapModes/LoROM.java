// Created by Iacon1 on 01/23/2024.
//
package C99Compiler.MapModes;

public class LoROM implements MapModeInterface
{
	@Override public String getName() {return "LoROM";}
	@Override public byte getCode() {return 0x00;}
	@Override public int getHeaderPosition(boolean longHeader) {return longHeader ? 0x007FB0 : 0x007FC0;}
	
	@Override public int getWRAMBankLength() {return 128*1024;} // 128 KB since we use the contiguous mirror
	@Override public int getSRAMBankLength() {return 32*1024;} // 32 KB
	@Override public int getROMBankLength(boolean isFast, int i) {return 32*1024;} // 32 KB
	
	@Override public int getMaxWRAMBanks() {return 1;}
	@Override public int getMaxSRAMBanks() {return 4;} // 4 * 32 = 128 KB
	@Override public int getMinROMBanks() {return 1;}
	@Override public int getMaxROMBanks(boolean isFast) {return 128;} // 128 * 32 = 4096 KB
	
	@Override public int getWRAMBankStart(int i) {return 0x7E0000;}
	@Override public int getSRAMBankStart(int i) {return 0xF00000 + 0x010000 * i;}
	@Override public int getROMBankStart(boolean isFast, int i)
	{
		return ((isFast || i >= 126)? 0x808000 : 0x008000) + i * 0x010000; // Banks 126 and 127 only reachable in fastROM area
	}
	@Override public int getROMBankAlign(int i) {return 0x008000;}
	
	@Override public int getHeaderAddress(boolean isFast) {return isFast ? 0x80FFB0 : 0x00FFB0;}
	@Override public int getVectorAddress(boolean isFast) {return isFast ? 0x80FFE0 : 0x00FFE0;}
}
