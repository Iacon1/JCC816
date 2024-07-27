// Created by Iacon1 on 10/25/2023.
// SNES Header
package Assembler;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import C99Compiler.CartConfig;
import C99Compiler.CartConfig.AddonChip;
import C99Compiler.CartConfig.MapMode;
import C99Compiler.Utils.AssemblyUtils;
import Logging.Logging;

public class Header extends CartConfig
{
	private static final int expSize = 16; // Size of header expansion in bytes
	private static final int baseSize = 32; // Size in bytes
	private static final int interSize = 32; // Size of interrupt table in bytes

	public static enum DestinationCode
	{
		japan(0x00),
		USA(0x01),
		europe(0x02),
		sweden(0x03),
		finland(0x04),
		denmark(0x05),
		france(0x06),
		netherlands(0x07),
		spain(0x08),
		germany(0x09),
		italy(0x0A),
		china(0x0B),
		indonesia(0x0C),
		southKorea(0x0D),
		international(0x0E),
		canada(0x0F),
		brazil(0x10),
		australia(0x11);
		
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

	private int ROMSize, SRAMSize;
	private int devID; // 0x33 indicates expanded ROM header
	private DestinationCode destCode;
	private int revision;
	
	private int checksum;
	
	public Header(String makerCode, String gameCode, String title, int revision, int specialVersion, boolean isFast, int SRAMSize, boolean hasBattery, MapMode mapMode, AddonChip addonChip, DestinationCode destinationCode)
	{
		super(mapMode, addonChip, hasBattery, isFast, SRAMSize);
		if (makerCode.length() != 2) throw new IllegalArgumentException("Maker code must be 2 bytes long.");
		this.makerCode = makerCode;
		if (gameCode.length() != 4) throw new IllegalArgumentException("Game code must be 4 bytes long.");
		this.gameCode = gameCode;
		if (title.length() > 21) throw new IllegalArgumentException("Title must be less than 21 bytes long.");
		this.title = title + " ".repeat(21 - title.length());
		if (revision < 0 || 255 < revision) throw new IllegalArgumentException("Revision must be between 0 and 255.");
		this.revision = revision;
		if (specialVersion < 0 || 255 < specialVersion) throw new IllegalArgumentException("Special version must be between 0 and 255.");
		this.specialVersion = specialVersion;
		this.ROMSize = 7;
		this.devID = 0x33;
		this.destCode = destinationCode;
		
		checksum = 0;
	}
	public Header(String makerCode, String gameCode, String title, int revision, int specialVersion, DestinationCode destinationCode, CartConfig cartConfig)
	{
		super(cartConfig);
		if (makerCode.length() != 2) throw new IllegalArgumentException("Maker code must be 2 bytes long.");
		this.makerCode = makerCode;
		if (gameCode.length() != 4) throw new IllegalArgumentException("Game code must be 4 bytes long.");
		this.gameCode = gameCode;
		if (title.length() > 21) throw new IllegalArgumentException("Title must be less than 21 bytes long.");
		this.title = title + " ".repeat(21 - title.length());
		if (revision < 0 || 255 < revision) throw new IllegalArgumentException("Revision must be between 0 and 255.");
		this.revision = revision;
		if (specialVersion < 0 || 255 < specialVersion) throw new IllegalArgumentException("Special version must be between 0 and 255.");
		this.specialVersion = specialVersion;
		this.ROMSize = 7;
		this.SRAMSize = 0;
		this.devID = 0x33;
		this.destCode = destinationCode;
		
		checksum = 0;
	}
	public Header(int devID, String title, int revision, boolean isFast, int SRAMSize, boolean hasBattery, MapMode ROMType, AddonChip addonChip, DestinationCode destinationCode)
	{
		super(ROMType, addonChip, hasBattery, isFast, SRAMSize);
		if (title.length() > 21) throw new IllegalArgumentException("Title must be less than 21 bytes long.");
		this.title = title + " ".repeat(21 - title.length());
		if (revision < 0 || 255 < revision) throw new IllegalArgumentException("Revision must be between 0 and 255.");
		this.revision = revision;
		this.ROMSize = 7;
		this.SRAMSize = 0;
		if (devID < 0 || 255 < devID) throw new IllegalArgumentException("Developer ID must be between 0 and 255.");
		this.devID = devID;
		this.destCode = destinationCode;
		
		checksum = 0;
	}
	public Header(int devID, String title, int revision, DestinationCode destinationCode, CartConfig cartConfig)
	{
		super(cartConfig);
		if (title.length() > 21) throw new IllegalArgumentException("Title must be less than 21 bytes long.");
		this.title = title + " ".repeat(21 - title.length());
		if (revision < 0 || 255 < revision) throw new IllegalArgumentException("Revision must be between 0 and 255.");
		this.revision = revision;
		this.ROMSize = 7;
		this.SRAMSize = 0;
		if (devID < 0 || 255 < devID) throw new IllegalArgumentException("Developer ID must be between 0 and 255.");
		this.devID = devID;
		this.destCode = destinationCode;
		
		checksum = 0;
	}
	public Header(CartConfig cartConfig)
	{
		super();
		makerCode = "";
		gameCode = "";
		specialVersion = 0;
		title = "";
		devID = 0;
		destCode = DestinationCode.japan;
		revision = 0;
	}
	public Header()
	{
		super();

		makerCode = "";
		gameCode = "";
		specialVersion = 0;
		title = "";
		devID = 0;
		destCode = DestinationCode.japan;
		revision = 0;
	}

	public Header(Document document) throws Exception
	{
		super(document);
		
		Node releaseInfo = document.getElementsByTagName("releaseInfo").item(0);
		this.title = releaseInfo.getTextContent();
		this.title = this.title + " ".repeat(21 - this.title.length());
		if (releaseInfo.getAttributes().getNamedItem("devID") == null || Integer.decode(releaseInfo.getAttributes().getNamedItem("devID").getTextContent()) == 0x33)
		{
			// ID not present or is 0x33, assume long header
			this.devID = 0x33;
			this.makerCode = releaseInfo.getAttributes().getNamedItem("makerCode").getTextContent();
			this.gameCode = releaseInfo.getAttributes().getNamedItem("gameCode").getTextContent();
			
		}
		else // dev ID presented
			this.devID = Integer.decode(releaseInfo.getAttributes().getNamedItem("devID").getTextContent());
		
		Node revision = document.getElementsByTagName("revision").item(0);
		this.revision = Integer.decode(revision.getTextContent());
		if (this.devID == 0x33)
			this.specialVersion = Integer.decode(revision.getAttributes().getNamedItem("specialVersion").getTextContent());
		
		this.destCode = DestinationCode.valueOf(document.getElementsByTagName("region").item(0).getTextContent());
		
		this.ROMSize = 7;
		this.SRAMSize = 0;
		
		if (this.title.length() > 21) throw new IllegalArgumentException("Title must be less than 21 bytes long.");
		if (this.devID < 0 || 255 < this.devID) throw new IllegalArgumentException("Developer ID must be between 0 and 255.");
		if (this.devID == 0x33)
		{
			if (makerCode.length() != 2) throw new IllegalArgumentException("Maker code must be 2 bytes long.");
			if (gameCode.length() != 4) throw new IllegalArgumentException("Game code must be 4 bytes long.");
			if (specialVersion < 0 || 255 < specialVersion) throw new IllegalArgumentException("Special version must be between 0 and 255.");
		}
		if (this.revision < 0 || 255 < this.revision) throw new IllegalArgumentException("Revision must be between 0 and 255.");
	}
	
	public int getSize()
	{
		if (devID == 0x33) return expSize + baseSize;
		else return baseSize;
	}
	public void calcSRAMSize(int size) // Bytes
	{
		if (size == 0)
		{
			SRAMSize = 0;
			return;
		}
		if (size < 2048)
			size = 2048; // No distinction between 0 and 1 KB, minimum 2 KB
		SRAMSize = (int) Math.ceil(Math.log(size / 1024) / Math.log(2));
	}
	public void calcROMSize(byte[] bytes)
	{
		int sizeB = bytes.length;
		
		for (int i = bytes.length - 1; i >= getOffset() + getSize() + interSize; --i)
			if (bytes[i] != 0x00) break;
			else sizeB -= 1;
		for (int i = getOffset() - 1; i >= 0; --i)
			if (bytes[i] != 0x00) break;
			else sizeB -= 1;
		
		double sizeKB = (double) sizeB / 1024d;
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			Logging.logNotice("\nFinal ROM size: " + sizeB + " B (" + String.format("%.02f", sizeKB) + " KB)");
		ROMSize = (int) Math.ceil(Math.log(sizeKB) / Math.log(2));
	}
	public void calcChecksum(byte[] bytes)
	{
		checksum = 0;
		int P2Chunk = (int) Math.pow(2, Math.floor(Math.log(bytes.length) / Math.log(2))); // Gets largest power of 2 equal to or smaller than bytes.
		for (byte x : Arrays.copyOfRange(bytes, 0, P2Chunk)) checksum += Byte.toUnsignedInt(x); // Calculate power-of-2 chunk normally, also, make sure unsigned
		
		if (bytes.length - P2Chunk > 0) // If there was a difference...
		{
			int subChecksum = 0;
			for (byte x : Arrays.copyOfRange(bytes, P2Chunk, bytes.length)) subChecksum += Byte.toUnsignedInt(x);
			double factor = ((double) bytes.length) / ((double) (bytes.length - P2Chunk)); // Repeat until same length as previous chunk
			checksum += factor * subChecksum;
		}
	}
	public byte[] asBytes()
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		if (devID == 0x33)
		{
			bytes.write(makerCode.getBytes(), 0, 2);
			bytes.write(gameCode.getBytes(), 0, 4);
			bytes.write(new byte[] {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00}, 0, 7);
			bytes.write(addonChip == AddonChip.SFX? SRAMSize : 0x00);
			bytes.write(specialVersion);
			bytes.write(addonChip.subType());
			
		}
		
		bytes.write(AssemblyUtils.applyFiller(title, 21).getBytes(), 0, 21);
		byte mapModeByte = (byte) (isFast? 0x30 : 0x20);
		mapModeByte |= mapMode.getCode();
		bytes.write(mapModeByte);
		
		byte cartType = 0;
		if (SRAMSize != 0 && hasBattery) cartType = 2;
		else if (SRAMSize != 0) cartType = 1;
		else if (addonChip != AddonChip.none && hasBattery) cartType = 3;
		if (addonChip != AddonChip.none) cartType += 3;
		cartType |= addonChip.type();
		
		bytes.write(cartType);
		bytes.write(ROMSize);
		bytes.write(addonChip == AddonChip.SFX? 0x00 : SRAMSize);
		bytes.write(destCode.getNumber());
		bytes.write(devID);
		bytes.write(revision);
		
		int antiChecksum = (checksum == 0 ? 0 : checksum ^ 0xFFFF);

		bytes.write(new byte[] {(byte) (antiChecksum % 0x100), (byte) (antiChecksum / 0x100)}, 0, 2);
		bytes.write(new byte[] {(byte) (checksum % 0x100), (byte) (checksum / 0x100)}, 0, 2);
		
		return bytes.toByteArray();
	}
	
	public int getOffset()
	{
		return mapMode.getHeaderPosition(devID == 0x33);
	}
}
