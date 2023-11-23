.p816
.smart	+
.feature at_in_identifiers
.segment "VECTORS"
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.segment "HEADER"
.res	48, 0;	HEADER_HERE
__@callResult  := $000000
__@multDivY    := $000040
__@multDivX    := $000050
__@ScratchBase := $000060
__z            := $7ffffe	; char (1 bytes)
func@x         := $7ffffd	; _Bool (1 bytes)
__REG@WRMPYA   = $004202
__REG@WRMPYB   = $004203
__REG@WRDIVL   = $004204
__REG@WRDIVH   = $004205
__REG@WRDIVB   = $004206
__REG@RDDIVL   = $004215
__REG@RDDIVH   = $004216
__REG@RDMPYL   = $004216
__REG@RDMPYH   = $004217
.segment "CODE"
RESET:
SEP	#$04
REP	#$01
XCE
REP	#$28
LDA	#$1fff
TCS
JML	main
func:	; void(_Bool)
  SEP	#$10
  LDX	#$00
  REP	#$01
  SEP	#$20
  LDA	func@x + 0
  EOR	#$80
  CMP	#$87
  BCC	:+
  BNE	:++
  BRA	:++
: INX
: TXA
  EOR	#1
  SEP	#$20
  BEQ	:+
  JMP	__CASE_0_DEF
 :
    SEP	#$10
  LDA	func@x + 0
  ASL
  TAX
  JMP	(__SWITCH_TABLE_0,X)
  __SWITCH_TABLE_0:
  .word	__CASE_0_DEF
  .word	__CASE_0_N1
  .word	__CASE_0_N2
  .word	__CASE_0_N3
  .word	__CASE_0_DEF
  .word	__CASE_0_DEF
  .word	__CASE_0_DEF
  .word	__CASE_0_N7
    __CASE_0_N1:
    LDA	#$05
    STA	func@x + 0
    JMP	__CASE_SKIP_0
    __CASE_0_N2:
    LDA	#$04
    STA	func@x + 0
    __CASE_0_N3:
    LDA	#$06
    STA	func@x + 0
    __CASE_0_N7:
    LDA	#$05
    STA	__z + 0
    JMP	__CASE_SKIP_0
  __CASE_0_DEF:
  __CASE_SKIP_0:
__func_END: RTL
