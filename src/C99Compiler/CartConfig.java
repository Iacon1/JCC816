// By Iacon1
// Created 10/13/2023
// Cartridge configuration info that the compiler needs to know.

package C99Compiler;

import C99Compiler.ROMTypes.LoROMType;
import C99Compiler.ROMTypes.ROMTypeInterface;

public class CartConfig
{
	public static enum ROMType implements ROMTypeInterface
	{
		loROM(new LoROMType()),
		hiROM(new LoROMType()), //0x01),
		SA1(new LoROMType()), // 0x03),
		exHiROM(new LoROMType()); // 0x05);
		
		private ROMTypeInterface implementer;
		
		private ROMType(ROMTypeInterface implementer)
		{
			this.implementer = implementer;
		}

		@Override public byte getCode() {return implementer.getCode();}
		
		@Override public int getWRAMBankLength() {return implementer.getWRAMBankLength();} 
		@Override public int getSRAMBankLength() {return implementer.getSRAMBankLength();}

		@Override public int getWRAMBanks() {return implementer.getWRAMBanks();}
		@Override public int getSRAMBanks() {return implementer.getSRAMBanks();}

		@Override public int getWRAMBankStart(int i) {return implementer.getWRAMBankStart(i);}
		@Override public int getSRAMBankStart(int i) {return implementer.getSRAMBankStart(i);}
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
	
	protected ROMType ROMType_;
	
	protected AddonChip addonChip;
	protected boolean hasBattery;
	
	protected boolean isFast;
	protected int SRAMSize;
	
	public CartConfig(ROMType ROMType, AddonChip addonChip, boolean hasBattery, boolean isFast, int SRAMSize)
	{
		this.ROMType_ = ROMType;
		this.addonChip = addonChip;
		this.hasBattery = hasBattery;
		this.isFast = isFast;
		this.SRAMSize = Math.max(0, (int) Math.ceil(Math.log(SRAMSize) / Math.log(2)));
	}
	public CartConfig(CartConfig cartConfig)
	{
		this.ROMType_ = cartConfig.ROMType_;
		this.addonChip = cartConfig.addonChip;
		this.hasBattery = cartConfig.hasBattery;
		this.isFast = cartConfig.isFast;
		this.SRAMSize = cartConfig.SRAMSize;
	}
	public CartConfig()
	{
		this.ROMType_ = ROMType.loROM;
		this.addonChip = AddonChip.none;
		this.hasBattery = false;
		this.isFast = false;
		this.SRAMSize = 0;
	}
	
	public boolean containsChip(AddonChip addonChip)
	{
		return addonChip.equals(addonChip);
	}

	public ROMType getType()
	{
		return ROMType_;
	}
}
