// Minimal JCC816 test runner. From the repo root: java tests/RunTests.java [name ...]
//
// For each tests/cases/<name>.c: compile it to a ROM with JCC816.jar (cl65 must be on PATH),
// then run the ROM under `Mesen --testrunner` with harness.lua + <name>.lua; Mesen's exit
// code is the result. Set MESEN if Mesen isn't on PATH.

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunTests
{
	static final Path TESTS = Path.of("tests").toAbsolutePath();
	static final Pattern SYM = Pattern.compile("^sym\\s.*name=\"([^\"]+)\".*val=0x(\\p{XDigit}+)", Pattern.MULTILINE);

	record Result(boolean ok, String out) {}

	// Runs cmd in dir, returning whether it exited 0 and its combined output.
	static Result run(Path dir, String... cmd) throws Exception
	{
		Path log = dir.resolve("out.log");
		Process p = new ProcessBuilder(cmd).directory(dir.toFile())
			.redirectErrorStream(true).redirectOutput(log.toFile()).start();
		if (!p.waitFor(300, TimeUnit.SECONDS))
			p.destroyForcibly().waitFor();
		return new Result(p.exitValue() == 0, new String(Files.readAllBytes(log)).strip());
	}

	static Result test(String name) throws Exception
	{
		Path dir = Files.createDirectories(TESTS.resolve("build").resolve(name));
		Files.copy(TESTS.resolve("cases").resolve(name + ".c"), dir.resolve(name + ".c"), StandardCopyOption.REPLACE_EXISTING);
		Files.copy(TESTS.resolve("header.xml"), dir.resolve("header.xml"), StandardCopyOption.REPLACE_EXISTING);
		Path rom = dir.resolve(name + ".sfc");
		Files.deleteIfExists(rom);

		String java = Path.of(System.getProperty("java.home"), "bin", "java").toString();
		Result r = run(dir, java, "-jar", TESTS.resolveSibling("JCC816.jar").toString(),
			"-l", name, "header.xml", "-D2", "-O2", name + ".c");
		// JCC816 can print an error and still exit 0.
		if (!r.ok() || r.out().contains("Error:") || !Files.exists(rom))
			return new Result(false, "compile failed:\n" + r.out());

		StringBuilder lua = new StringBuilder("SYM = {\n");
		Matcher m = SYM.matcher(new String(Files.readAllBytes(dir.resolve(name + ".dbg"))));
		while (m.find())
			lua.append("[\"").append(m.group(1)).append("\"] = 0x").append(m.group(2)).append(",\n");
		lua.append("}\n").append(Files.readString(TESTS.resolve("harness.lua")))
			.append(Files.readString(TESTS.resolve("cases").resolve(name + ".lua")));
		Path script = Files.writeString(dir.resolve(name + ".test.lua"), lua);

		return run(dir, System.getenv().getOrDefault("MESEN", "Mesen"), "--testrunner", rom.toString(), script.toString());
	}

	public static void main(String[] args) throws Exception
	{
		List<String> names;
		try (var files = Files.list(TESTS.resolve("cases")))
		{
			names = files.map(p -> p.getFileName().toString()).filter(f -> f.endsWith(".c"))
				.map(f -> f.substring(0, f.length() - 2)).sorted()
				.filter(n -> args.length == 0 || List.of(args).contains(n)).toList();
		}
		int failed = 0;
		for (String name : names)
		{
			Result r;
			try { r = test(name); }
			catch (Exception e) { r = new Result(false, e.toString()); }
			System.out.println((r.ok() ? "PASS  " : "FAIL  ") + name);
			if (!r.ok())
			{
				++failed;
				System.out.println("      " + r.out().replace("\n", "\n      "));
			}
		}
		System.out.printf("%n%d/%d passed%n", names.size() - failed, names.size());
		System.exit(failed == 0 ? 0 : 1);
	}
}
