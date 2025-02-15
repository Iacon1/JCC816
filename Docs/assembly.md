# Variables and Functions
JCC uses a nonstandard format for assigning assembly-level identifiers to C-level structures. This format can be described as such:
* A global-scope variable or function with a name only one character long will have ``__`` prefixed to it in assembly.
* Static-scope variables and functions will have UUIDs suffixed to them. These UUIDs are nondeterministic.
* A function-scope variable will have the name of the parent function and a `@` prefixed to it in assembly. For example, in the case below `x` would be rendered in assembly as `main@x`.  

    void main()
    {
	    int x;
    }

# Registers
JCC816 reserves the direct page (that is, $000000-$0000FF in memory) for ephemeral values and certain operations (like pointer access) that the Ricoh 5a22 processor can only perform in that space. While this does mean that inline `asm(...)` statements should avoid referencing this area of memory without reverence for the compiler, it should be noted that assembly functions linked into a JCC816-compiled program should not have to account for the compiler in the direct page, as no data is stored there that needs be preserved between functions.

That said, it may still be desirable for one to respect or even utilize this space in their assembly functions. for this reason, the compiler-enumerated "registers" are listed below.
## `__@callResult`
This register occupies 64 bytes of DP memory. By default, valued `return` statements copy their values to here. Undefined behavior may occur if a `struct` of size greater than 64 bytes is returned, potentially including stack corruption.
## `__@specSubY`, `__@specSubX`
These registers each occupy 16 bytes. Due to the 5a22's lackluster hardware support for  division, multiplication, and modulation, these operations are managed by compiler-provided subroutines; These registers are used to store the inputs to said subroutines.
## `__@funcPointer`
This register occupies 3 bytes. In the event that a function pointer is needed the pointer will be copied to this address and then jumped to.
## `__@signExtend`
This register occupies 1 byte. For certain operations it is required to use "filler" bytes, which in numerical operations may depend on the sign of an involved number. This byte, once calculated, is stored here for the duration of the operation.
## `__@pointerBase`
This register occupies 11 pointers' worth, or 33 bytes, of memory. Whenever a pointer is accessed it must first be copied to DP and is stored in one of these 11 slots. The compiler will try, to the best of its ability, to keep as many pointers loaded at once to minimize overhead from re-copying them.
## `__@scratchBase`
The remaining 128 bytes are simply used to store ephemeral values during calculations.
