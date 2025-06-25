// Created by Iacon1 on 02/25/2025.
//
package Shared.MapModes;

public interface MapModeInterfaceWrapper extends MapModeInterface
{	
	public MapModeInterface getImplementer();
	
	@Override default public String getName() {return getImplementer().getName();}
	@Override default public byte getCode() {return getImplementer().getCode();}

	@Override default public int getWRAMBankLength() {return getImplementer().getWRAMBankLength();} 
	@Override default public int getSRAMBankLength() {return getImplementer().getSRAMBankLength();}
	@Override default public int getROMBankLength(boolean isFast, int i) {return getImplementer().getROMBankLength(isFast, i);}
	
	@Override default public int getMaxWRAMBanks() {return getImplementer().getMaxWRAMBanks();}
	@Override default public int getMaxSRAMBanks() {return getImplementer().getMaxSRAMBanks();}
	@Override default public int getMinROMBanks() {return getImplementer().getMinROMBanks();}
	@Override default public int getMaxROMBanks(boolean isFast) {return getImplementer().getMaxROMBanks(isFast);}
	
	@Override default public int getWRAMBankStart(int i) {return getImplementer().getWRAMBankStart(i);}
	@Override default public int getSRAMBankStart(int i) {return getImplementer().getSRAMBankStart(i);}
	@Override default public int getROMBankStart(boolean isFast, int i) {return getImplementer().getROMBankStart(isFast, i);}
	@Override default public int getROMBankAlign(int i) {return getImplementer().getROMBankAlign(i);}
	
	@Override default public int getHVAddress(boolean isFast) {return getImplementer().getHVAddress(isFast);}
	@Override default public boolean isContiguous(int i) {return getImplementer().isContiguous(i);}
}
