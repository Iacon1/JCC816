// By Iacon1
// Created 02/18/2024
// A wrapper around a type with the same storage requirements as that type

package C99Compiler.CompilerNodes.Definitions;

public abstract class StorageWrapperType extends Type
{
	protected Type type;
	public StorageWrapperType(Type type)
	{
		this.type = type;
	}
	
	@Override public int getSize() {return type.getSize();}	
	@Override public int getSizeBits() {return type.getSizeBits();}
	@Override public boolean isExtern() {return type.isExtern();}
	@Override public boolean isStatic() {return type.isStatic();}
	@Override public boolean isAuto() {return type.isAuto();}
	@Override public boolean isRegister() {return type.isRegister();}
	@Override public boolean isSRAM() {return type.isSRAM();}
	@Override public boolean isRWTwice() {return type.isRWTwice();}
	
	public Type getType() {return type;}
}
