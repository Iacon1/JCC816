# JCC816
This is a C Compiler for the 65c816 - specifically, the Ricoh 5a22 processor inside the SNES as well as the SA1 cartridge-mounted coprocessor.

This README is incomplete.

# Usage
```
JCC816 [-c] [-D <level>] [-h] [-H <output>] [-l <output> <header>]
       [-O <level>] [-p <output>] [-r <path>] [-V <level>]
A C compiler for the WDC 65c816 and especially Ricoh 5a22 processor.

 -c,--cleanup                      Ensures the assembler doesn't leave
                                   behind unecessary files.
 -D,--debug-level <level>          Sets the level of debug info generated,
                                   from 0 to 3.
 -h,--help                         Displays information about the
                                   program's usage.
 -H,--generate-header <output>     Generates a default header
                                   configuration file for the user to
                                   edit.
 -l,--link <output> <header>       Links the provided source and object
                                   files into a single specified SFC file
                                   according to a provided header
                                   configuration.
 -O,--optimization-level <level>   Sets the level of optimization, from 0
                                   to 3. Note that only levels 0 and 2 are
                                   meaningful for object files.
 -p,--preprocessor <output>        Preprocesses the provided source file
                                   and stores it in a specified source
                                   file.
 -r,--root <path>                  Specifies the root directory to search
                                   for files in. Otherwise defaults to
                                   current directory.
 -V,--debug-level <level>          Sets the level of console output, from
                                   0 to 1.
```
# Caveats
It is currently riddled with bugs, hence why it's version 0.X.

SA1 support is not complete.

The following features of C are currently unsupported:
* Bitfields
* Floating-points
* Variadic functions and VLAs
* Most of the standard library
* Object file generation
# Best Practices
The following should be taken into account for best performance:
* Function pointers and recursion cause imperformant assembly and should be avoided.

# Further documentation
* [Assembly considerations](Docs/assembly.md)
