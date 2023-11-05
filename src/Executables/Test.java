// Created by Iacon1 on 2/7/2022.
// Test rig.
// https://en.wikipedia.org/wiki/CYK_algorithm

package Executables;

import Compiler.CartConfig;
import Compiler.CartConfig.AddonChip;
import Compiler.CartConfig.ROMType;
import Compiler.Compiler;

import java.io.File;
import java.io.FileOutputStream;

import Assembler.Assembler;
import Logging.DebugLogger;
import Logging.Logging;
public class Test
{
	public static void main(String[] args) throws Exception
	{
		String main = null;
		Logging.setLogger(new DebugLogger());
		main = new String(ClassLoader.getSystemResourceAsStream("Executables/test.c").readAllBytes());

		CartConfig cartConfig = new CartConfig(ROMType.loROM, AddonChip.none, false, false, 0);
		
		String c = Compiler.compile(main, true);
		Logging.logNotice("\n" + c);
		
		byte[] sfc = Assembler.assemble("test", cartConfig, c, "loROM", true);
		
		File f = new File("./test.sfc");
		f.createNewFile();
		FileOutputStream fo = new FileOutputStream(f);
		fo.write(sfc);
		fo.close();
	}
}
