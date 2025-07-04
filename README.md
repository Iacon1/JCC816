# JCC816
This is a C Compiler for the 65c816 - specifically, the Ricoh 5a22 processor inside the SNES as well as the SA1 cartridge-mounted coprocessor.

This README is incomplete.

# Usage
```
JCC816 [-c] [-D <level>] [--fast-byte-count] [-h] [-H <output>] [-l
   <output> <header>] [--no-node-caching] [--no-static-initialization]
   [-O <level>] [--optimize-addresses] [-p <output>] [-r <path>] [-s
   <output> <header>] [-V <level>]
A C compiler for the WDC 65c816 and especially Ricoh 5a22 processor.

 -c,--cleanup                       Ensures the assembler doesn't leave
                                    behind unecessary files.
 -D,--debug-level <level>           Sets the level of debug info
                                    generated, from 0 to 3.
    --fast-byte-count               Uses a faster but more generous method
                                    for estimating the size of assembly
                                    chunks during banking.
 -h,--help                          Displays information about the
                                    program's usage.
 -H,--generate-header <output>      Generates a default header
                                    configuration file for the user to
                                    edit.
 -l,--link <output> <header>        Links the provided source and object
                                    files into a single specified SFC file
                                    according to a provided header
                                    configuration.
    --no-node-caching               Disables caching of searches in the
                                    node tree. Uses less memory but takes
                                    a lot longer.
    --no-static-initialization      Doesn't initialize static variables.
                                    Not compliant with standard.
 -O,--optimization-level <level>    Sets the level of optimization, from 0
                                    to 3. Note that only levels 0 and 2
                                    are meaningful for object files.
    --optimize-addresses            Optimizes most memory accesses to use
                                    16 bit instead of 24 bit addressing.
                                    Only valid if < 64 KB of work memory
                                    are used.
 -p,--preprocessor <output>         Preprocesses the provided source file
                                    and stores it in a specified source
                                    file.
 -r,--root <path>                   Specifies the root directory to search
                                    for files in. Otherwise defaults to
                                    current directory.
 -s,--assembler <output> <header>   Compiles the provided source file into
                                    an assembly file, optionally according
                                    to a provided header configuration.
 -V,--debug-level <level>           Sets the level of console output, from
                                    0 to 1.

Version 0.X; Source code available at https://github.com/Iacon1/JCC816.
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
* [Implementation-defined features](Docs/implentation-defined.md)