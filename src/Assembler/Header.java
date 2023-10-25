// Created by Iacon1 on 10/25/2023.
// SNES Header
package Assembler;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Header
{
	public static final int size = 48; // Size in bytes
	
	public static enum MapMode
	{
		LoROM268(0x20),
		HiROM268(0x21),
		SA1(0x23),
		ExHiROM268(0x25),
		LoROM358(0x30),
		HiROM358(0x31),
		ExHiROM358(0x35);
		
		private int number;
		private MapMode(int number)
		{
			this.number = number;
		}
		
		public int getNumber() {return number;}
	}
	public static enum CartridgeType
	{
		ROMOnly(0x00, 0x00),
		ROMRAM(0x01, 0x00),
		ROMRAMBattery(0x02, 0x00),
		ROMSA1(0x33, 0x00),
		ROMRAMSA1(0x34, 0x00),
		RAMRAMSA1Battery(0x35, 0x00);
		
		private int number, subNumber;
		
		private CartridgeType(int number, int subNumber)
		{
			this.number = number;
			this.subNumber = subNumber;
		}
		
		public int getNumber() {return number;}
		public int getSubNumber() {return subNumber;}
	}
	public static enum DestinationCode
	{
		japan(0x00),
		USA(0x01),
		europe(0x02);
		
		private int number;
		private DestinationCode(int number)
		{
			this.number = number;
		}
		
		public int getNumber() {return number;}
	}
	
	private String makerCode;
	private String gameCode;
	private int specialVersion;
	private String title;
	private MapMode mapMode;
	private CartridgeType cartType;
	private int ROMSize;
	private int SRAMSize;
	private boolean isSFX; // Affects where SRAM size goes
	private DestinationCode destCode;
	private int maskVersion;
	
	private int checksum;
	
	public Header(String makerCode, String gameCode, String title, int revision, int specialVersion, int ROMSize, int SRAMSize, boolean isSFX, MapMode mapMode, CartridgeType cartridgeType, DestinationCode destinationCode)
	{
		if (makerCode.length() != 2) throw new IllegalArgumentException("Maker code must be 2 bytes long.");
		this.makerCode = makerCode;
		if (gameCode.length() != 4) throw new IllegalArgumentException("Game code must be 4 bytes long.");
		this.gameCode = gameCode;
		if (title.length() > 21) throw new IllegalArgumentException("Title must be less than 21 bytes long.");
		this.title = title + " ".repeat(21 - title.length());
		if (revision < 0 || 255 < revision) throw new IllegalArgumentException("Revision must be between 0 and 255.");
		this.maskVersion = revision;
		if (specialVersion < 0 || 255 < specialVersion) throw new IllegalArgumentException("Special version must be between 0 and 255.");
		this.specialVersion = specialVersion;
		this.ROMSize = (int) Math.ceil(Math.log(ROMSize) / Math.log(2));
		this.SRAMSize = (int) Math.ceil(Math.log(SRAMSize) / Math.log(2));
		this.isSFX = isSFX;
		this.mapMode = mapMode;
		this.cartType = cartridgeType;
		this.destCode = destinationCode;
		
		checksum = 0;
	}
	
	public void calcChecksum(byte[] bytes)
	{
		checksum = 0;
		int P2Chunk = (int) Math.pow(2, Math.floor(Math.log(bytes.length) / Math.log(2))); // Gets largest power of 2 equal to or smaller than bytes.
		for (byte x : Arrays.copyOfRange(bytes, 0, P2Chunk)) checksum += Byte.toUnsignedInt(x); // Calculate power-of-2 chunk normally, also, make sure unsigned
		
		if (bytes.length - P2Chunk > 0) // If there was a difference...
		{
			int subChecksum = 0;
			for (byte x : Arrays.copyOfRange(bytes, P2Chunk, bytes.length - P2Chunk)) subChecksum += Byte.toUnsignedInt(x);
			double factor = ((double) bytes.length) / ((double) (bytes.length - P2Chunk)); // Repeat until same length as previous chunk
			checksum += factor * subChecksum;
		}
	}
	public byte[] asBytes()
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		bytes.write(makerCode.getBytes(), 0, 2);
		bytes.write(gameCode.getBytes(), 0, 4);
		bytes.write(new byte[] {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00}, 0, 7);
		bytes.write(isSFX ? SRAMSize : 0x00);
		bytes.write(specialVersion);
		bytes.write(cartType.getSubNumber());
		bytes.write(title.getBytes(), 0, 21);
		bytes.write(mapMode.getNumber());
		bytes.write(cartType.getNumber());
		bytes.write(ROMSize);
		bytes.write(isSFX ? 0x00 : SRAMSize);
		bytes.write(destCode.getNumber());
		bytes.write(0x33);
		bytes.write(maskVersion);
		
		int antiChecksum = (checksum == 0 ? 0 : checksum ^ 0xFFFF);

		bytes.write(new byte[] {(byte) (antiChecksum % 0x100), (byte) (antiChecksum / 0x100)}, 0, 2);
		bytes.write(new byte[] {(byte) (checksum % 0x100), (byte) (checksum / 0x100)}, 0, 2);
		
		return bytes.toByteArray();
	}
	
	public int getOffset()
	{
		switch (mapMode)
		{
		case LoROM268 : case LoROM358 : return 0x7FB0;
		case HiROM268 : case HiROM358 : return 0xFFB0;
		case SA1 : return 0xFFB0; // TODO accurate?
		case ExHiROM268 : case ExHiROM358 : return 0xFFB0; // TODO accurate?
		default: return 0x7FB0; // Default to LoROM
		}
	}
}
