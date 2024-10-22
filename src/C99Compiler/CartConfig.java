// By Iacon1
// Created 10/13/2023
// Cartridge configuration info that the compiler needs to know.

package C99Compiler;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import C99Compiler.MapModes.ExHiROM;
import C99Compiler.MapModes.HiROM;
import C99Compiler.MapModes.LoROM;
import C99Compiler.MapModes.MapModeInterface;
import Logging.Logging;

public class CartConfig
{
	public static enum MapMode implements MapModeInterface
	{
		loROM(new LoROM()),
		hiROM(new HiROM()),
		SA1(new LoROM()),
		exHiROM(new ExHiROM());
		
		private MapModeInterface implementer;
		
		private MapMode(MapModeInterface implementer)
		{
			this.implementer = implementer;
		}

		@Override public String getName() {return implementer.getName();}
		@Override public byte getCode() {return implementer.getCode();}
		@Override public int getHeaderPosition(boolean longHeader) {return implementer.getHeaderPosition(longHeader);}
		
		@Override public int getWRAMBankLength() {return implementer.getWRAMBankLength();} 
		@Override public int getSRAMBankLength() {return implementer.getSRAMBankLength();}
		@Override public int getROMBankLength(boolean isFast, int i) {return implementer.getROMBankLength(isFast, i);}
		
		@Override public int getMaxWRAMBanks() {return implementer.getMaxWRAMBanks();}
		@Override public int getMaxSRAMBanks() {return implementer.getMaxSRAMBanks();}
		@Override public int getMaxROMBanks(boolean isFast) {return implementer.getMaxROMBanks(isFast);}
		
		@Override public int getWRAMBankStart(int i) {return implementer.getWRAMBankStart(i);}
		@Override public int getSRAMBankStart(int i) {return implementer.getSRAMBankStart(i);}
		@Override public int getROMBankStart(boolean isFast, int i) {return implementer.getROMBankStart(isFast, i);}
		@Override public int getROMBankAlign(int i) {return implementer.getROMBankAlign(i);}
		
		@Override public int getHeaderAddress(boolean isFast) {return implementer.getHeaderAddress(isFast);}
		@Override public int getVectorAddress(boolean isFast) {return implementer.getVectorAddress(isFast);}
	}
	public static enum AddonChip
	{
		none(0x00, 0x00),
		DSP(0x00, 0x00),
		SFX(0x10, 0x00),
		OBC1(0x20, 0x00),
		SA1(0x30, 0x00),
		SDD1(0x40, 0x00),
		SRTC(0x50, 0x00),
		other(0xE0, 0x00),
		
		// "Custom" - code 0xFx
		SPC7110(0xF0, 0x00),
		ST010(0xF0, 0x01),
		ST018(0xF0, 0x02),
		CX4(0xF0, 0x03);
		
		private byte type, subType;
		
		private AddonChip(int type, int subType)
		{
			this.type = (byte) type;
			this.subType = (byte) subType;
		}
		
		public byte type() {return type;}
		public byte subType() {return type;}
	}
	
	protected MapMode mapMode;
	
	protected AddonChip addonChip;
	protected boolean hasBattery;
	
	protected boolean isFast;

	public CartConfig(MapMode ROMType, AddonChip addonChip, boolean hasBattery, boolean isFast, int SRAMSize)
	{
		this.mapMode = ROMType;
		this.addonChip = addonChip;
		this.hasBattery = hasBattery;
		this.isFast = isFast;
	}
	public CartConfig(CartConfig cartConfig)
	{
		this.mapMode = cartConfig.mapMode;
		this.addonChip = cartConfig.addonChip;
		this.hasBattery = cartConfig.hasBattery;
		this.isFast = cartConfig.isFast;
	}
	public CartConfig()
	{
		this.mapMode = MapMode.loROM;
		this.addonChip = AddonChip.none;
		this.hasBattery = false;
		this.isFast = false;
	}
	
	public boolean containsChip(AddonChip addonChip)
	{
		return addonChip.equals(addonChip);
	}

	public MapMode getType()
	{
		return mapMode;
	}
	
	public boolean isFast() {return isFast;}
	
	public CartConfig(Document document)
	{
		Node memLayout = document.getElementsByTagName("mapMode").item(0);
		this.mapMode = MapMode.valueOf(memLayout.getTextContent());
		this.isFast = memLayout.getAttributes().getNamedItem("fastROM").getTextContent().equals("true");

		this.hasBattery = memLayout.getAttributes().getNamedItem("battery").getTextContent().equals("true");
		
		Node addon = document.getElementsByTagName("addonChip").item(0);
		this.addonChip = AddonChip.valueOf(addon.getTextContent());
		if (this.addonChip == null) this.addonChip = AddonChip.none;
	}
}
