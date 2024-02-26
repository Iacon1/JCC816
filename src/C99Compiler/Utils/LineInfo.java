// Created by Iacon1 on 02/23/2024.
// Line info for debug purposes
package C99Compiler.Utils;

import java.io.Serializable;

public class LineInfo implements Serializable
{
	public String filename;
	public int line;

	public LineInfo(String filename, int line)
	{
		this.filename = filename;
		this.line = line;
	}
}
