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
LDA	#$1fff
TCS
JML	main
__MULT_2_2:CLC
  SEP	#$30
  LDA	__ScratchBase + 190
  STA	__REG__WRMPYA
  LDA	__ScratchBase + 188
  STA	__REG__WRMPYB
  NOP
  NOP
  LDA	__REG__RDMPYL
  STA	__callResult + 0
  LDA	__REG__RDMPYH
  TAX
  LDA	__ScratchBase + 190
  STA	__REG__WRMPYA
  LDA	__ScratchBase + 189
  STA	__REG__WRMPYB
  TXA
  NOP
  ADC	__REG__RDMPYL
  STA	__callResult + 1
  LDA	__ScratchBase + 191
  STA	__REG__WRMPYA
  LDA	__ScratchBase + 189
  STA	__REG__WRMPYB
  NOP
  NOP
  LDA	__REG__RDMPYL
  STA	__callResult + 1
RTL
main:
  REP	#$30
  LDA	#$0065
  STA	main__x + 0
  LDA	#$0002
  STA	main__y + 0
  __ITER__START__0:
    LDA	main__x + 0
    STA	__ScratchBase + 190 + 0
    LDA	main__y + 0
    STA	__ScratchBase + 188 + 0
    JSL	__MULT_2_2    
    LDA	__callResult + 0
    STA	main__x + 0
    CLC
    REP	#$30
    LDA	main__y + 0
    ADC	#$0001
    STA	main__y + 0
  SEP	#$10
  LDX	#$00
  CLC
  REP	#$10
  LDA	main__x + 0
  EOR	#$8000
  CMP	#$8064
  BCC	:+
  BNE	:++
  DEX
: INX
: TXA
  SEP	#$20
  STA	__callResult
  LDA	#$00
  SEP	#$10
  ORA	__callResult + 0
  ORA	__callResult + 1
  STA	__callResult
  BNE	__ITER__START__0
  __ITER__END__0:
  lda main__x
  L:JMP L
__main_END: RTL
