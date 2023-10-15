// Created by Iacon1 on 2/7/2022.
// Test rig.
// https://en.wikipedia.org/wiki/CYK_algorithm

package Executables;

import Compiler.Compiler;
import Logging.DebugLogger;
import Logging.Logging;
public class Test
{
	public static void main(String[] args) throws Exception
	{
		String main = null;
		Logging.setLogger(new DebugLogger());
		main = new String(ClassLoader.getSystemResourceAsStream("Executables/test.c").readAllBytes());

		Logging.logNotice(Compiler.compile(main));
	}
}
