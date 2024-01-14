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
__@callResult  = $000000
__@specSubY    = $000040
__@specSubX    = $000050
__@scratchBase = $000060
__x            = $7ffffe	; enum __0enum (1 bytes)
__REG@WRMPYA   = $004202
__REG@WRMPYB   = $004203
__REG@WRDIVL   = $004204
__REG@WRDIVH   = $004205
__REG@WRDIVB   = $004206
__REG@RDDIVL   = $004214
__REG@RDDIVH   = $004215
__REG@RDMPYL   = $004216
__REG@RDMPYH   = $004217
.segment "ROMBANK0"
RESET:
SEI
CLC
XCE
REP	#$28
LDA	#$1fff
TCS
JML	main
main:	; @func void()
  .res $7000, 0
__main_END: RTL
.SEGMENT	"ROMBANK1"
main2:	; @func void()
  .res $7000, 0
__main2_END: RTL
