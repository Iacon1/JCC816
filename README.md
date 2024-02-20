# JCC816
This is a C Compiler for the 65c816 - specifically, the Ricoh 5a22 processor inside the SNES as well as the SA1 cartridge-mounted coprocessor.

This README is incomplete.

# Usage
``JCC816 [options] (sources...)``

# Caveats
It is currently riddled with bugs, hence why it's version 0.X.

SA1 support is not complete.

The following features of C are currently unsupported:
* Bitfields
* Floating-points
* Variadic functions and VLAs
* Most of the standard library
# Best Practices
The following should be taken into account for best performance:
* Function pointers and recursion cause imperformant assembly and should be avoided.
