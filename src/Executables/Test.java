// Created by Iacon1 on 2/7/2022.
// Test rig.
// https://en.wikipedia.org/wiki/CYK_algorithm

package Executables;

import Compiler.Compiler;
public class Test
{
	private static void print(String toPrint)
	{
		System.out.println(toPrint);
	}
	public static void main(String[] args)
	{
		String main = null;
		try {main = new String(ClassLoader.getSystemResourceAsStream("Executables/test.c").readAllBytes());}
		catch (Exception e) {print(e.getMessage()); return;}

		print(Compiler.compile(main));
		
		
	}
}
