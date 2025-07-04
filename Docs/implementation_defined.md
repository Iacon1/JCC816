# Implementation-defined features

Enumerated below are features and extensions implemented by the JCC816 compiler not required by the C99 specification.

## `asm(...)`
See C99 specifications, section J.5.10.

## Function attributes
Function attributes are specified per function, like so: `[[spec1, spec2, spec3]] foo(void)` (where `spec1`, `spec2`, and `spec3` are valid identifiers. Depending on these identifiers properties of the function and program may be altered:
* `interrupt_COP`: Marks that whenever a `COP` interrupt occurs this is the function that should be run. UB if more than one function per program have this attribute.
* `interrupt_BRK`: As above but for the `BRK` interrupt.
* `interrupt_ABORT`: As above but for the `ABORT` interrupt.
* `interrupt_NMI`: As above but for the `NMI` interrupt.
* `interrupt_IRQ`: As above but for the `IRQ` interrupt.
* `no_ISR1`: Normally, a function marked as an interrupt handler via the attributes above would save and load large amounts of data to stack, to prevent corruption. This attribute disables that behavior.
* `no_ISR2`: As above but also replaces the RTI instruction with RTL.
* `SA1`: Specifies that the function should only by run by the SA1 coprocessor. A function with this attribute cannot be call by functions without it and cannot call those functions.
* `A8`: Tells the optimization routines that the function can be assumed to start in 8-bit-A-register mode.
* `A16`: Tells the optimization routines that the function  can be assumed to start in 16-bit-A-register mode.
* `XY8`: Tells the optimization routines that the function can be assumed to start in 8-bit-XY-register mode.
* `XY16`: Tells the optimization routines that the function  can be assumed to start in 16-bit-XY-register mode.
* `optional`: Allows the compiler to not emit assembly for the function if it believes the function is never called.

# Type specifiers
* `__SRAM`: Marks the variable as needing to be allocated to SRAM instead of WRAM.
* `__SPECX`: Marks the variable as being an alias for the ``__SpecSubX`` address. See the list of [assembly considerations](Docs/assembly.md).
* `__SPECY`: Marks the variable as being an alias for the ``__SpecSubY`` address. See the list of [assembly considerations](Docs/assembly.md).

# Type qualifiers
* `__RWTWICE`: Marks the variable as "Read or Write Twice", meant primarily for MMIO registers. A multi-byte write or read to this variable's address will be performed as multiple writes or reads to the same address, instead of multiple adjacent addresses.
* `__ROTWICE`: As above, but also marks the variable `const`.
* `__WOTWICE`: As above, but also marks the variable write-only.

