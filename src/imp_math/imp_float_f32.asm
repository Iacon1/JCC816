__addflt32:			;	@func
	; Test if second is negative
	SEP #$20
	TRB __@specSubY+3
	BEQ :+
	JMP __subflt32
	:
RTL					;	@endfunc
__subflt32:			;	@func
	; Test if second is negative
	SEP #$20
	TRB __@specSubY+3
	BEQ :+
	JMP __addflt32
	:
RTL					;	@endfunc
__mulflt32:			;	@func
	; Isolate and add exponents
	REP #$21
	LDA __@specSubX+2
	AND #$7800
	ADC __@specSubY+2
	ASL
	SEP #$20
	XBA
	; Subtract 127+23+23 - 127 because of Y's bias and 23 twice to turn each from X.XXX... to XXXXX...
	CLC
	SBC #$AD
	STA __@callResult+3
	; Set negative flag
	LDA __@specSubX+3
	EOR __@specSubY+3
	ASL
	ROR __@callResult+3
	ROR __@callResult+4
	
	; Set highest bit of each mantissa
	LDA #$80
	TRB __@specSubX+2
	TRB __@specSubY+2
	JSL __mul24by24
	
	; Set last bit of exponent
	SEP #$20
	LDA #$80
	TRB __@callResult+2
	AND __@callResult+4
	TSB __@callResult+2
RTL					;	@endfunc
__divflt32:			;	@func
	; Isolate and subtract exponents
	REP #$21
	LDA __@specSubX+2
	AND #$7800
	SBC __@specSubY+2
	ASL
	SEP #$20
	XBA
	; Add 127-23-23 - 127 because of Y's bias and 23 twice to turn each from X.XXX... to XXXXX...
	CLC
	ADC #$51
	STA __@callResult+3
	; Set negative flag
	LDA __@specSubX+3
	EOR __@specSubY+3
	ASL
	ROR __@callResult+3
	ROR __@callResult+4
	
	; Set highest bit of each mantissa
	LDA #$80
	TRB __@specSubX+2
	TRB __@specSubY+2
	JSL __div24by24
	
	; Set last bit of exponent
	SEP #$20
	LDA #$80
	TRB __@callResult+2
	AND __@callResult+4
	TSB __@callResult+2
RTL					;	@endfunc
__negflt32:			;	@func
	REP #$20
	LDA __@specSubX+0
	STA __@callResult+0
	LDA __@specSubX+2
	EOR #$8000
	STA __@callResult+2
RTL					;	@endfunc
__cmpsflt32:		;	@func
RTL					;	@endfunc