// Created by Iacon1 on 2/7/2022.
// Test rig.

package Executables;

import C99Compiler.Utils.FileIO;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		FileIO.outputFolder = "./Example/";
		JCC816.main(new String[] {"-r=Example/", "-l=example=exampleHeader.xml", "-O=2", "-D=2", "-V=3", "example.c"});
	}
}
