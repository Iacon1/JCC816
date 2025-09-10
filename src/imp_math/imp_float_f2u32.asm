__flt32touint8:		;	@func
	JMP __flt32touint24
RTL					;	@endfunc
__flt32touint16:	;	@func
	JMP __flt32touint24
RTL					;	@endfunc
__flt32touint24:	;	@func
	; Copy into output
	REP #$20
	LDA __@specSubX+0
	STA __@callResult+0
	LDA __@specSubX+2
	; Separate exponent from mantissa
	ASL
	STA __@callResult+2
	SEP #$20
	SEC
	ROR
	STA __@callResult+2
	
	; Calculate shift amount and direction
	REP #$20
	SEC
	SEP #$30
	LDA #$96
	SBC __@specSubX+3
	TAY
	SEC
	LDA __@specSubX+3
	SBC #$96
	TAX
	REP #$20
	BEQ :+++
	BMI :++
	
	; Left shift
	:
		ASL __@callResult+0
		ROL __@callResult+2
		DEX
	BNE :-
	BRA :++
	
	; Right shift
	:
		ASL __@callResult+0
		ROL __@callResult+2
		DEY
	BNE :-
	
	:
RTL					;	@endfunc
__flt32touint32:	;	@func
	JSL __flt32touint24
	REP #$20
	STZ __@callResult+3
RTL					;	@endfunc
__flt32touint64:	;	@func
	JSL __flt32touint24
	REP #$20
	STZ __@callResult+3
	STZ __@callResult+5
	STZ __@callResult+7
RTL					;	@endfunc