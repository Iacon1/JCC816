// Created by Iacon1 on 02/23/2024.
// Line info for debug purposes
package C99Compiler.Utils;

import java.io.Serializable;

public class LineInfo implements Serializable
{
	public String filename;
	public int line;
	public boolean isStd;
	
	public LineInfo(String filename, int line, boolean isStd)
	{
		this.filename = filename;
		this.line = line;
		this.isStd = isStd;
	}
	
	public String getLine()
	{
		if (!isStd)
			return "\"" + FileIO.getFile(filename) + "\", " + line;
		else
			return "\"stdlib\\" + filename.replace("stdlib\\", "") + "\", " + line;

	}
}
