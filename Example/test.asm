.p816
.smart	+
.feature at_in_identifiers
.dbg file, "imp_math\imp_float_f2u64.h", 0, 0
.dbg file, "imp_math\imp_float_f2u64.asm", 0, 0
.dbg file, "imp_math\imp_float_s2f64.asm", 0, 0
.dbg file, "imp_math\imp_float_f2s32.h", 0, 0
.dbg file, "imp_math\imp_float.asm", 0, 0
.dbg file, "imp_math\imp_float_f2s64.asm", 0, 0
.dbg file, "Test\test.c", 0, 0
.dbg file, "imp_math\imp_float_s2f32.h", 0, 0
.dbg file, "imp_math\imp_float_f32.h", 0, 0
.dbg file, "imp_math\imp_mult.asm", 0, 0
.dbg file, "imp_math\imp_float_u2f32.asm", 0, 0
.dbg file, "imp_math\imp_float_f2u32.asm", 0, 0
.dbg file, "imp_math\imp_float_f64.asm", 0, 0
.dbg file, "imp_math\imp_float.h", 0, 0
.dbg file, "imp_math\imp_float_u2f32.h", 0, 0
.dbg file, "imp_math\imp_float_s2f64.h", 0, 0
.dbg file, "imp_math\imp_float_f2u32.h", 0, 0
.dbg file, "imp_math\imp_float_s2f32.asm", 0, 0
.dbg file, "imp_math\imp_mult.h", 0, 0
.dbg file, "imp_math\imp_float_f2s64.h", 0, 0
.dbg file, "imp_math\imp_float_f2s32.asm", 0, 0
.dbg file, "imp_math\imp_float_f64.h", 0, 0
.dbg file, "imp_math\imp_float_f32.asm", 0, 0
.dbg file, "imp_math\imp_float_u2f64.asm", 0, 0
.dbg file, "imp_math\imp_float_u2f64.h", 0, 0
.segment "LVECTORS"
__longCOP:JML	RESET
__longBRK:JML	RESET
__longABORT:JML	RESET
__longNMI:JML	RESET
__longRESET:JML	RESET
__longIRQ:JML	RESET
.segment "HEADER"
.res	48, 0;	HEADER_HERE
.segment "VECTORS"
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longCOP)
.word	.loWORD(__longBRK)
.word	.loWORD(__longABORT)
.word	.loWORD(__longNMI)
.word	.loWORD(__longRESET)
.word	.loWORD(__longIRQ)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
__@callResult     = $000000
__@specSubY       = $000040
__@specSubX       = $000050
__@funcPointer    = $000060
__@signExtend     = $000063
__@scratchBase    = $000065
main@t            = $7e2000	; unsigned (3 bytes)
.dbg sym, "t", "00", EXTERN, "main@t"
__REG@WRMPYA      = $004202
__REG@WRMPYB      = $004203
__REG@WRDIVL      = $004204
__REG@WRDIVH      = $004205
__REG@WRDIVB      = $004206
__REG@RDDIVL      = $004214
__REG@RDDIVH      = $004215
__REG@RDMPYL      = $004216
__REG@RDMPYH      = $004217
.segment "ROM000"
RESET:
SEI
CLC
XCE
REP	#$28
LDA	#$1eff
TCS
LDA	#$FFFF
STA	$00420D
PHK
PEA	RESET
JML	main
main:	; @func void()
  .dbg	line, "Test\test.c", 4
  REP	#$20
  LDA	#$0002
  STA	main@t + 0
  SEP	#$20
  LDA	#$00
  STA	main@t + 2
__main_END:
RTL	; @endfunc
; @asm
; @endasm
; @asm
; @endasm
; @asm
; Doubles
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; Thanks to Sir Walrus for long div/mod code
; Multiplication
; Division
; Modulation
; @asm
; @endasm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
; @asm
; @endasm
