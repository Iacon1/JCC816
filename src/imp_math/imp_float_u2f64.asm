__uint8toflt64:		;	@func
	REP #$20
	LDA __@specSubX+0
	STZ __@specSubX+0
	STZ __@specSubX+2
	STZ __@specSubX+4
	STA __@specSubX+6
	STZ __@specSubX+7
	LDA #$0406 ; Exponent: 1023 + 7
	JMP __uint64toflt64_1
RTL					;	@endfunc
__uint16toflt64:	;	@func
	REP #$20
	LDA __@specSubX+0
	STZ __@specSubX+0
	STZ __@specSubX+2
	STZ __@specSubX+4
	STA __@specSubX+6
	LDA #$040E ; Exponent: 1023 + 15
	JMP __uint64toflt64_1
RTL					;	@endfunc
__uint24toflt64:	;	@func
	REP #$20
	LDA __@specSubX+0
	STZ __@specSubX+0
	STA __@specSubX+5
	LDA __@specSubX+2
	STZ __@specSubX+2
	STZ __@specSubX+3
	STA __@specSubX+7
	LDA #$040E ; Exponent: 1023 + 15
	JMP __uint64toflt64_1
RTL					;	@endfunc
__uint32toflt64:	;	@func
	REP #$20
	LDA __@specSubX+0
	STZ __@specSubX+0
	STA __@specSubX+4
	LDA __@specSubX+2
	STZ __@specSubX+2
	STA __@specSubX+6
	LDA #$0401E ; Exponent: 1023 + 31
	JMP __uint64toflt64_1
RTL					;	@endfunc
__uint64toflt64:	;	@func
	REP #$20
	LDA #$043E ; Exponent: 1023 + 63
	STA __@callResult+0

	; Rightshift until input fits, match exponent
	:
	LDA __@specSubX+6
	AND #$FF20
	BEQ :+
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
	; Initialize result
	__uint64toflt64_1:
	STA __@callResult+0
	STZ __@callResult+2
	STZ __@callResult+4
	STZ __@callResult+6

	; Check if zero
	LDA __@specSubX+0
	ORA __@specSubX+2
	ORA __@specSubX+4
	ORA __@specSubX+6
	BNE :+
	STZ __@callResult+0
	RTL
	
	; Align input with 53rd bit
	:
	LDA __@specSubX+6
	AND #$0010
	BNE :+
	CLC
	ASL __@specSubX+0
	ROL __@specSubX+2
	ROL __@specSubX+4
	ROL __@specSubX+6
	CLC
	DEC __@callResult+0
	BRA :-
	:
	
	SEP #$20
	; Clear 53rd bit
	LDA __@specSubX+6
	AND #$0F
	STA __@specSubX+6

	; Merge exponent and mantissa
	
	LDA __@callResult+1
	LSR __@callResult+0
	ROR
	ORA __@specSubX+6
	STA __@callResult+1
	LDA __@specSubX+5
	STA __@callResult+2
	LDA __@specSubX+4
	STA __@callResult+3
	LDA __@specSubX+3
	STA __@callResult+4
	LDA __@specSubX+2
	STA __@callResult+5
	LDA __@specSubX+1
	STA __@callResult+6
	LDA __@specSubX+0
	STA __@callResult+7
RTL					;	@endfunc