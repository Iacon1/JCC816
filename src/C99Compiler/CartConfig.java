// By Iacon1
// Created 10/13/2023
// Cartridge configuration info that the compiler needs to know.

package C99Compiler;

public class CartConfig
{
	public static enum ROMType
	{
		loROM(0x00),
		hiROM(0x01),
		SA1(0x03),
		exHiROM(0x05);
		
		private byte code;
		
		private ROMType(int code)
		{
			this.code = (byte) code;
		}
		
		public byte code() {return code;}
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
	
	protected ROMType ROMType;
	
	protected AddonChip addonChip;
	protected boolean hasBattery;
	
	protected boolean isFast;
	protected int SRAMSize;
	
	public CartConfig(ROMType ROMType, AddonChip addonChip, boolean hasBattery, boolean isFast, int SRAMSize)
	{
		this.ROMType = ROMType;
		this.addonChip = addonChip;
		this.hasBattery = hasBattery;
		this.isFast = isFast;
		this.SRAMSize = Math.max(0, (int) Math.ceil(Math.log(SRAMSize) / Math.log(2)));
	}
	public CartConfig(CartConfig cartConfig)
	{
		this.ROMType = cartConfig.ROMType;
		this.addonChip = cartConfig.addonChip;
		this.hasBattery = cartConfig.hasBattery;
		this.isFast = cartConfig.isFast;
		this.SRAMSize = cartConfig.SRAMSize;
	}
	
	public boolean containsChip(AddonChip addonChip)
	{
		return addonChip.equals(addonChip);
	}
	
	public ROMType getType()
	{
		return ROMType;
	}
}
