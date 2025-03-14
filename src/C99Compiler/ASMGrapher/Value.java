// Created by Iacon1 on 12/01/2023.
// The name of a byte in RAM

package C99Compiler.ASMGrapher;

public class Value
{
	private String name;
	private int offset;
	private boolean usesOffset;
	private int address;
	
	public Value(int address)
	{
		this.address = address;
	}
	public Value(String name)
	{
		this.name = name;
		usesOffset = false;
		this.offset = 0;
	}
	public Value(String name, int offset)
	{
		this.name = name;
		usesOffset = true;
		this.offset = offset;
	}
	
	public Value add(Value a)
	{
		if (name != null && usesOffset && a.name != null && a.usesOffset)
			return new Value(name + " + " + a.name, offset + a.offset);
		else if (name != null && usesOffset && a.name != null)
			return new Value(name + " + " + a.name, offset);
		else if (name != null && a.usesOffset && a.name != null)
			return new Value(name + " + " + a.name, a.offset);
		else if (name != null && a.name != null)
			return new Value(name + " + " + a.name);
		else if (name != null)
			return new Value(name, a.address);
		else if (a.name != null)
			return new Value(a.name, address);
		else
			return new Value(address + a.address);
	}
	public Value sub(Value a)
	{
		if (name != null && usesOffset && a.name != null && a.usesOffset)
			return new Value(name + " - " + a.name, offset - a.offset);
		else if (name != null && usesOffset && a.name != null)
			return new Value(name + " - " + a.name, offset);
		else if (name != null && a.usesOffset && a.name != null)
			return new Value(name + " - " + a.name, -a.offset);
		else if (name != null && a.name != null)
			return new Value(name + " - " + a.name);
		else if (name != null)
			return new Value(name, -a.address);
		else if (a.name != null)
			return new Value("-" + a.name, address);
		else
			return new Value(address - a.address);
	}
	public Value mask(Value a)
	{
		if (name != null && usesOffset && a.name != null && a.usesOffset)
			return new Value("(" + name + " + " + offset + ") & (" + a.name + " + " + a.offset + ")");
		else if (name != null && usesOffset && a.name != null)
			return new Value("(" + name + " + " + offset + ") & " + a.name);
		else if (name != null && a.usesOffset && a.name != null)
			return new Value(name + " & (" + a.name + " + " + a.offset + ")");
		else if (name != null && a.name != null)
			return new Value(name + " & " + a.name);
		else if (name != null)
			return new Value(name + " & " + a.address);
		else if (a.name != null)
			return new Value(a.name + " & " + address);
		else
			return new Value(address & a.address);
	}
	public Value unmask(Value a)
	{
		if (name != null && usesOffset && a.name != null && a.usesOffset)
			return new Value("(" + name + " + " + offset + ") | (" + a.name + " + " + a.offset + ")");
		else if (name != null && usesOffset && a.name != null)
			return new Value("(" + name + " + " + offset + ") | " + a.name);
		else if (name != null && a.usesOffset && a.name != null)
			return new Value(name + " | (" + a.name + " + " + a.offset + ")");
		else if (name != null && a.name != null)
			return new Value(name + " | " + a.name);
		else if (name != null)
			return new Value(name + " | " + a.address);
		else if (a.name != null)
			return new Value(a.name + " | " + address);
		else
			return new Value(address | a.address);
	}
	public Value lshift(Value a)
	{
		if (name != null && usesOffset && a.name != null && a.usesOffset)
			return new Value("(" + name + " + " + offset + ") << (" + a.name + " + " + a.offset + ")");
		else if (name != null && usesOffset && a.name != null)
			return new Value("(" + name + " + " + offset + ") << " + a.name);
		else if (name != null && a.usesOffset && a.name != null)
			return new Value(name + " << (" + a.name + " + " + a.offset + ")");
		else if (name != null && a.name != null)
			return new Value(name + " << " + a.name);
		else if (name != null)
			return new Value(name + " << " + a.address);
		else if (a.name != null)
			return new Value(a.name + " << " + address);
		else
			return new Value(address << a.address);
	}
	public Value rshift(Value a)
	{
		if (name != null && usesOffset && a.name != null && a.usesOffset)
			return new Value("(" + name + " + " + offset + ") >> (" + a.name + " + " + a.offset + ")");
		else if (name != null && usesOffset && a.name != null)
			return new Value("(" + name + " + " + offset + ") >> " + a.name);
		else if (name != null && a.usesOffset && a.name != null)
			return new Value(name + " >> (" + a.name + " + " + a.offset + ")");
		else if (name != null && a.name != null)
			return new Value(name + " >> " + a.name);
		else if (name != null)
			return new Value(name + " >> " + a.address);
		else if (a.name != null)
			return new Value(a.name + " >> " + address);
		else
			return new Value(address >> a.address);
	}
	public Value add(int a)
	{
		return add(new Value(a));
	}
	public Value sub(int a)
	{
		return sub(new Value(a));
	}
	
	public Value increment()
	{
		return add(1);
	}
	
	public Value mask(int a)
	{
		return mask(new Value(a));
	}
	public Value unmask(int a)
	{
		return mask(new Value(a));
	}
	
	public Value lshift(int a)
	{
		return lshift(new Value(a));
	}
	public Value rshift(int a)
	{
		return rshift(new Value(a));
	}
	
	public int getImmediate()
	{
		return address;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null) return false;
		if (Value.class.isAssignableFrom(other.getClass()))
		{
			Value addr = (Value) other;
			if (this.name != null && addr.name != null)
				return this.name.equals(addr.name) && this.usesOffset == addr.usesOffset && this.offset == addr.offset;
			else if (this.name == null && addr.name == null)
				return this.address == addr.address;
			else return false;
		}
		else return false;
	}
	
	@Override
	public String toString()
	{
		if (this.name != null)
			if (usesOffset)
				return this.name + " + " + offset;
			else return this.name;
		else
			return Integer.toString(address, 16);
	}
	
	@Override
	public int hashCode()
	{
		if (this.name != null)
			return this.name.hashCode() + offset;
		else
			return address;
	}
}
