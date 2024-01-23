// Created by Iacon1 on 01/23/2024.
//
package C99Compiler.ROMTypes;

/**
 * 
 */
public class LoROMType implements ROMTypeInterface
{
	@Override public byte getCode() {return 0x00;}

	@Override public int getWRAMBankLength() {return 128*1024;} // 128 KB since we use the contiguous mirror
	@Override public int getSRAMBankLength() {return 32*1024;} // 32 KB

	@Override public int getWRAMBanks() {return 1;}
	@Override public int getSRAMBanks() {return 5;}

	@Override public int getWRAMBankStart(int i) {return 0x7E0000;}
	@Override public int getSRAMBankStart(int i) {return 0x700000 + 0x010000 * i;}
}
