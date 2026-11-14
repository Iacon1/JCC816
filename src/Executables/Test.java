// Created by Iacon1 on 2/7/2022.
// Test rig.

package Executables;

import C99Compiler.CompConfig;
import C99Compiler.Utils.FileIO;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		FileIO.outputFolder = "./Test/";
		CompConfig.showParseTree = false;
		CompConfig.noMath = false;
		CompConfig.throwExceptions = true;
		
		JCC816.main(new String[] {"-r=Example/", "-l=example=exampleHeader.xml", "-V2", "-O2", "-D2", "example.c"});
//		JCC816.main(new String[] {"-r=Test/", "-l=test=testHeader.xml", "-V2", "-O2", "-D2", "test.c"});
	}
}
