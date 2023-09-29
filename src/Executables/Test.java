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
		print(Compiler.compile("int intX; char charX;")); // int inta;");
		
		
	}
}
