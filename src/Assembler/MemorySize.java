// Created by Iacon1 on 01/21/2024.
//
package Assembler;

public class MemorySize
{
	public int ROMSize, WRAMSize, SRAMSize;
	public boolean isFast;
	public MemorySize(int WRAMSize, int SRAMSize, int ROMSize, boolean isFast) // In bytes
	{
		this.WRAMSize = WRAMSize;
		this.SRAMSize = SRAMSize;
		this.ROMSize = ROMSize;
		this.isFast = isFast;
	}
}
