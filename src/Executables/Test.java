// Created by Iacon1 on 2/7/2022.
// Test rig.

package Executables;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		JCC816.main(new String[] {"-h=Test/testHeader.xml", "-l=Test/test", "-o=0", "-d=2", "-v=2", "-r=Test/", "Test/test.c"});
//		BBSnCC.main(new String[] {"-h=Test/testHeader.xml", "-p=Test/testP.c", "-o=0", "-d=2", "-v=2", "-r=Test/", "Test/test.c"});
//		BBSnCC.main(new String[] {"-H=Test/testHeader.xml"});
	}
}
