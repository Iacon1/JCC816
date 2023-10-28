// Created by Iacon1 on 10/21/2023.
//
package Compiler.Utils;

public enum SNESRegisters
{
	WRMPYA(0x004202),
	WRMPYB(0x004203),
	WRDIVL(0x004204),
	WRDIVH(0x004205),
	WRDIVB(0x004206),
	RDDIVL(0x004215),
	RDDIVH(0x004216),
	RDMPYL(0x004216),
	RDMPYH(0x004217),
	;
	
	private int address;
	
	private SNESRegisters(int address) {this.address = address;}
	
	@Override
	public String toString() {return "__REG" + CompConfig.scopeDelimiter + name();}
	
	public int address() {return address;}
}
