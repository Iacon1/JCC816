__flt32toflt64:		;	@func
	REP #$20
	STZ __@callResult+0
	STZ __@callResult+2
	; Copy number
	LDA __@specSubX+0
	STA __@callResult+4
	LDA __@specSubX+2
	AND #$7FFF		; Remove sign bit
	STA __@callResult+6
	
	; Move into place and extract exponent
	SEP #$10
	LDA __@callResult+6
	LDX #$03		; Shift 3 times
	:
		LSR __@callResult+6
		ROR __@callResult+4
		ROR __@callResult+2
		DEX
	BNE :-
	LDA __@callResult+6
	LSR
	LSR
	LSR
	LSR
	; Add (1023-127) to correct bias
	CLC
	ADC #$0380
	ASL
	ASL
	ASL
	ASL
	STA __@callResult+8
	
	; Store in proper place
	LDA __@callResult+6
	AND #$000F
	ORA __@callResult+8
	STA __@callResult+6
	
	; Collect sign bit
	SEP #$20
	LDA __@specSubX+3
	ASL __@callResult+7
	ASL
	ROR __@callResult+7
RTL					;;	@endfunc
__flt64toflt32:		;	@func
	; Store sign bit
	LDA __@specSubX+6
	ASL
	ROL __@specSubX+8
	; Shift into place
	REP #$20
	SEP #$10
	LDX #$04 ; Shift right 4 times
	:
		LSR __@specSubX+6
		ROR __@specSubX+4
		ROR __@specSubX+2
		DEX
	BNE :-
	; Copy number
	LDA __@specSubX+3
	STA __@callResult+0
	LDA __@specSubX+5
	STA __@callResult+2
	; Shift once more
	LSR __@callResult+2
	ROR __@callResult+0
	
	; extract exponent
	LDA __@specSubX+6
	AND #$07FF
	; Subtract (1023-127) to correct bias
	SEC
	SBC #$0380
	BIT #$FF00
	BNE :+
	SEP #$20
	LSR
	STA __@callResult+3
	ROR
	AND #$80
	ORA __@callResult+2
	STA __@callResult+2
	BRA :++
	
	:
	; Too big, call it infinity
	REP #$20
	STZ __@callResult+0
	LDA #$7F80
	STA __@callResult+1
	SEP #$20
	
	; Set sign bit
	:
	ASL __@callResult+3
	LSR __@specSubX+8
	ROR __@callResult+3
RTL					;	@endfunc
