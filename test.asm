.p816
.smart	+
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
__ScratchBase := $7fff3f
__callResult  := $7ffeff
main__p       := $7ffefb
__REG__WRMPYA := $004202
__REG__WRMPYB := $004203
__REG__WRDIVL := $004204
__REG__WRDIVH := $004205
__REG__WRDIVB := $004206
__REG__RDDIVL := $004215
__REG__RDDIVH := $004216
__REG__RDMPYL := $004216
__REG__RDMPYH := $004217
.segment "CODE"
RESET:
SEI
CLC
XCE
REP	#$08
REP	#$20
LDA	#$1fff
TCS
JML	main
main:
__main_END: RTL
