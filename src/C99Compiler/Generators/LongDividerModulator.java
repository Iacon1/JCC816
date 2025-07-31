// Created by Iacon1 on 12/12/2023.
// Software divider / modulator
// https://godbolt.org/z/Y8aM3o8eY
package C99Compiler.Generators;

import java.util.function.Supplier;

public class LongDividerModulator implements Supplier<String>
{
	private int x, y, r;
	private boolean isMod;
	
	private static String typeName(int nBytes)
	{
		switch (nBytes)
		{
		case 1: return "char";
		case 2: return "short";
		case 3: return "int";
		case 4: return "long";
		case 8: return "long long";
		default: return "char";
		}
	}
	
	private String funcName()
	{
		return "__" + (isMod? "mod" : "div") + (8 * x) + "by" + (8 * y);
	}
	public LongDividerModulator(int x, int y, boolean isMod)
	{
		this.x = x;
		this.y = y;
		this.r = Math.max(3, Math.min(x, y));
		this.isMod = isMod;
	}
	
	// https://godbolt.org/z/fsY9T91s4
	public String get()
	{
		String code = "";
		
		String constant = "0x" + Integer.toHexString(0x80 << (8 * (y - 1)));
		// y = 1 -> 0x80, y = 2 -> 0x8000, y = 3 -> 0x800000, etc. 
		
		code += "[[optional]] unsigned " + typeName(r) + " " + funcName() +
				"(__SPECX unsigned " + typeName(x) +
				" x, __SPECY unsigned " + typeName(y) + " y)\n";
		code += "{\n";
		code += "\tasm(\"" + funcName() + "@ret = __@callResult+0\");\n";
		code += "\tasm(\"" + funcName() + "@start = __@callResult+" + r + "\");\n";

		code += "\tunsigned " + typeName(r) + " ret = 0;\n";
		code += "\tunsigned " + typeName(r) + " start = 1;\n";
		code += "\twhile (x > y)\n";
		code += "\t{\n";
		code += "\t\tif (y & " + constant + ")\n";
		code += "\t\t\tbreak;\n";
		code += "\t\ty <<= 1;\n";
		code += "\t\tstart <<= 1;\n";
		code += "\t}\n";
		
		code += "\twhile (start)\n";
		code += "\t{\n";
		code += "\t\tif (x >= y)\n";
		code += "\t\t{\n";
		code += "\t\t\tx -= y;\n";
		code += "\t\t\tret += start;\n";
		code += "\t\t}\n";
		code += "\t\ty >>= 1;\n";
		code += "\t\tstart >>= 1;\n";
		code += "\t}\n";

		code += "\treturn " + (isMod? "x" : "ret") + ";\n";
		code += "}\n\n";
		return code;
	}
}
