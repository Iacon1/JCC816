// Created by Iacon1 on 01/21/2024.
//
package Shared;

public class MemorySize
{
	public int ROMSize, WRAMSize, SRAMSize, BSSSize;
	public boolean isFast;
	public MemorySize(int WRAMSize, int SRAMSize, int ROMSize, int BSSSize, boolean isFast) // In bytes
	{
		this.WRAMSize = WRAMSize;
		this.SRAMSize = SRAMSize;
		this.ROMSize = ROMSize;
		this.BSSSize = BSSSize;
		this.isFast = isFast;
	}
}
