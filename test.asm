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
__operandA    := $7fffbf
__operandB    := $7fff7f
__operandC    := $7fff3f
__callResult  := $7ffeff
main__x       := $7ffefd
main__y       := $7ffefb
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
LDA	#$2000
TCS
JML	main
__DIV_2_2:CLC
  SEP	#$30
  LDY	#$00
  LDA	__operandA + 1
  BPL	:+
  INY
  REP	#$30
  LDA	__operandA + 0
  EOR	#$ffff
  STA	__operandA + 0
  SEP	#$20
  LDA	__operandB + 1
  BPL	:+
  DEY
  REP	#$20
  LDA	__operandB + 0
  EOR	#$ffff
  STA	__operandB + 0
:
  REP	#$30
  LDA	__operandB + 0
  STA	__operandB + 2 + 0
  LDA	#$0001
  STA	__operandB + 0
  LDA	#$0000
  STA	__operandB + 2
:
  REP	#$30
  LDA	__operandB + 2
  LSR
  STA	__operandB + 2
  LDA	__operandB + 0
  LSR
  STA	__operandB + 0
  SEC
  LDA	__operandB + 2
  SBC	#$0000
  STA	__operandB + 2
  LDA	__operandB + 0
  SBC	#$0001
  STA	__operandB + 0
  BNE	:-
  LDA	#$8000
  STA	__operandC + 0
@reiterate:
  SEP	#$10
  LDX	#$00
  REP	#$30
  LDA	__operandB + 0
  EOR	#$8000
  STA	__operandA + 2
  LDA	__operandA + 0
  EOR	#$8000
  CMP	__operandA + 2
  BCS	:+
  BNE	:++
: INX
: TXA
  SEP	#$20
  STA	__operandA + 2
  BEQ	:+
  SEC
  REP	#$30
  LDA	__operandA + 0
  SBC	__operandB + 0
  STA	__operandA + 0
  CLC
  LDA	__callResult + 0
  ADC	__operandC + 0
  STA	__callResult + 0
:
    REP	#$30
  LDA	#$0001
  STA	__operandB + 0
:
  REP	#$30
  LDA	__operandB + 2
  LSR
  STA	__operandB + 2
  LDA	__operandB + 0
  LSR
  STA	__operandB + 0
  SEC
  LDA	__operandB + 0
  SBC	#$0001
  STA	__operandB + 0
  BNE	:-
  LDA	#$0001
  STA	__operandB + 0
:
  REP	#$30
  LDA	__operandC + 0
  LSR
  STA	__operandC + 0
  SEC
  LDA	__operandB + 0
  SBC	#$0001
  STA	__operandB + 0
  BNE	:-
  BEQ	:+
  JMP	@reiterate
  :
  TYA
  BEQ	:+
  LDA	__callResult + 0
  EOR	#$0000
  STA	__callResult + 0
:
RTL
main:
  REP	#$30
  LDA	#$02ee
  STA	main__x + 0
  LDA	#$0002
  STA	main__y + 0
  LDA	main__x + 0
  STA	__operandA + 0
  LDA	main__y + 0
  STA	__operandB + 0
  JSL	__DIV_2_2
  LDA	__callResult + 0
  STA	main__x + 0
  STP
__main_END: RTL
