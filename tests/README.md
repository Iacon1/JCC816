# JCC816 tests

Each test is a pair in `cases/`:

- `<name>.c` is a program that stores its results in globals and then sets `test_done`.
- `<name>.lua` defines `check()`, which asserts on those globals.

`RunTests.java` compiles each `.c` into a ROM with `JCC816.jar` and gets the addresses of its globals from the ld65 `.dbg` file. It then runs the ROM under `Mesen --testrunner` with the symbol table, `harness.lua` and the test's `.lua` script. Mesen's exit code is the test result: 0 means pass, 1 means an expectation failed, and 2 means an error or timeout.

```sh
# from the repo root (Java 17+)
java tests/RunTests.java            # all tests
java tests/RunTests.java arith loop # by name
```

`cl65` must be on `PATH`, because JCC816 runs it from there. Set `MESEN` to the Mesen 2 executable if it isn't on `PATH`, and set `CC65_HOME` if `cl65` can't find its libraries (`c64.lib`). On Windows (cmd.exe):

```bat
set PATH=C:\cc65\bin;%PATH%
set MESEN=C:\Mesen\Mesen.exe
java tests\RunTests.java
```

## Writing a test

```c
#include <stdint.h>
uint8_t test_done = 0;   // initialize explicitly: uninitialized globals are not zeroed
uint16_t result;

void main()
{
	result = 6 * 7;
	test_done = 1;
	while (1);
}
```

```lua
function check()
	expect_eq(read16("result"), 42, "result")
end
```

Helpers: `read8(name, offset)`, `read16(name, offset)` and `expect_eq(actual, expected, what)`. `name` is a C global and `offset` is an optional byte offset. Build output, including the ROM and the generated `<name>.test.lua`, goes to `tests/build/<name>/`.
