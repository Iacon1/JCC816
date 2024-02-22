// Created by Iacon1 on 1/14/2024.
// Defines the summary of the C99 keywords and punctuators.

parser grammar C99A1G;
// import C99A11, C99A17;
keyword
	: Auto
	| Break
	| Case
	| Char
	| Const
	| Continue
	| Default
	| Do
	| Double
	| Else
	| Enum
	| Extern
	| Float
	| For
	| Goto
	| If
	| Inline
	| Int
	| Long
	| Register
	| Restrict
	| Return
	| Short
	| Signed
	| Sizeof
	| Static
	| Struct
	| Switch
	| Typedef
	| Union
	| Unsigned
	| Void
	| Volatile
	| While
	| Bool
	| Complex
	| Imaginary
	| Asm
	
	| Defined {Grammar.GrammarFlags.isPreproc}?
	| Define {Grammar.GrammarFlags.isPreproc}?
	| Ifdef {Grammar.GrammarFlags.isPreproc}?
	| Ifndef {Grammar.GrammarFlags.isPreproc}?
	| Elif {Grammar.GrammarFlags.isPreproc}?
	| Endif {Grammar.GrammarFlags.isPreproc}?
	| Include {Grammar.GrammarFlags.isPreproc}?
	| Undef {Grammar.GrammarFlags.isPreproc}?
	| Line {Grammar.GrammarFlags.isPreproc}?
	| Error {Grammar.GrammarFlags.isPreproc}?
	| Pragma {Grammar.GrammarFlags.isPreproc}?
	
	| HasEmbed {Grammar.GrammarFlags.isPreproc}?
	| Embed {Grammar.GrammarFlags.isPreproc}?
	| Offsetof
	
	| SRAM
	| RWTWICE
	| ROTWICE
	| WOTWICE
	;
	
punctuator
	: TwoMCo
	| ThreeP
	| Arrow
	| Incrmn
	| Decrmn
	| LssLss
	| GrtGrt
	| LessTh
	| GretTh
	| LessEq
	| GretEq
	| Equal
	| NotEql
	| AmpAmp
	| OrOr
	| MulAsg
	| DivAsg
	| ModAsg
	| PluAsg
	| SubAsg
	| LShAsg
	| RShAsg
	| AndAsg
	| XorAsg
	| OrAsg
	| TwoHsh
	| LessCo
	| GretCo
	| LessMd
	| GretMd
	| ModCol
	| TwoLSB
	| TwoRSB
	| Amper
	| Star
	| Plus
	| Minus
	| Tilde
	| Excla
	| BckSla
	| Percnt
	| Xor
	| Or
	| Colon
	| Semico
	| Period
	| Questi
	| Assign
	| Comma
	| HashTg
	| LeSqBr
	| RiSqBr
	| LeRoBr
	| RiRoBr
	| LeCuBr
	| RiCuBr
	;