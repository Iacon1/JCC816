__uint8toflt32:		;	@func
	REP #$20
	LDA __@specSubX+0
	STZ __@specSubX+0
	STA __@specSubX+2
	LDA #$0086 ; Exponent: 127 + 7
	JMP __uint24toflt32_1
RTL					;	@endfunc
__uint16toflt32:	;	@func
	REP #$20
	LDA __@specSubX+0
	STZ __@specSubX+0
	STA __@specSubX+1
	LDA #$008E ; Exponent: 127 + 15
	JMP __uint24toflt32_1
RTL					;	@endfunc
__uint24toflt32:	;	@func
	REP #$20
	LDA #$0096 ; Exponent: 127 + 23
	
	; Initialize result
	__uint24toflt32_1:
	STA __@callResult+3
	STZ __@callResult+1

	; Check if zero
	LDA __@specSubX+0
	ORA __@specSubX+1
	BNE :+
	STZ __@callResult+0
	RTL
	
	; Align input with 24th bit
	:
	LDA __@specSubX+1
	BMI :+
	ASL __@specSubX+0
	ROL __@specSubX+2
	DEC __@callResult+3
	BRA :-
	:
	
	SEP #$20
	; Clear 24th bit
	LDA #$80
	TRB __@specSubX+2

	; Merge exponent and mantissa
	
	LDA __@callResult+2
	LSR __@callResult+3
	ROR
	ORA __@specSubX+2
	STA __@callResult+2
	REP #$20
	LDA __@specSubX+1
	STA __@callResult+0
RTL					;	@endfunc
__uint32toflt32:	;	@func
	REP #$20
	LDA #$0096 ; Exponent: 127 + 23
	STA __@callResult+0
	
	; Rightshift until input fits, match exponent
	:
	LDA __@specSubX+2
	AND #$FF00
	BEQ :+
	CLC
	LSR __@specSubX+2
	ROR __@specSubX+0
	CLC
	INC __@callResult+0
	BRA :-
	:
	
	LDA __@callResult+0
	JMP __uint24toflt32_1
RTL					;	@endfunc
__uint64toflt32:	;	@func
	REP #$20
	LDA #$0096 ; 127 + 23
	STA __@callResult+0
	
	; Rightshift until input fits, match exponent
	:
	LDA __@specSubX+6
	ORA __@specSubX+4
	AND #$FFFF
	BNE :+
	LDA __@specSubX+2
	AND #$FF00
	BEQ :++
	:
	CLC
	LSR __@specSubX+6
	ROR __@specSubX+4
	ROR __@specSubX+2
	ROR __@specSubX+0
	CLC
	INC __@callResult+0
	BRA :--
	:
	
	LDA __@callResult+0
	JMP __uint24toflt32_1
RTL					;	@endfunc