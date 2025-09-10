__sint8toflt32:		;	@func
	SEP	#$20
	LDA	__@specSubX+0
	AND #$80
	BNE :+
	JMP __uint8toflt32
	:
	; If negative
	CLC
	SEP #$20
	LDA #$00
	SBC __@specSubX+0
	JSL __uint8toflt32
	SEP #$20
	LDA #$80
	ORA __@callResult+3
	STA __@callResult+3	
RTL					;	@endfunc
__sint16toflt32:	;	@func
	SEP	#$20
	LDA	__@specSubX+1
	AND #$80
	BNE :+
	JMP __uint16toflt32
	:
	; If negative
	REP #$21
	LDA #$0000
	SBC __@specSubX+0
	JSL __uint16toflt32
	SEP #$20
	LDA #$80
	ORA __@callResult+3
	STA __@callResult+3	
RTL					;	@endfunc
__sint24toflt32:	;	@func
	SEP	#$20
	LDA	__@specSubX+2
	AND #$80
	BNE :+
	JMP __uint24toflt32
	:
	; If negative
	REP #$21
	LDA #$0000
	SBC __@specSubX+0
	SEP #$20
	SBC __@specSubX+2
	JSL __uint24toflt32
	SEP #$20
	LDA #$80
	ORA __@callResult+0
	STA __@callResult+0	
RTL					;	@endfunc
__sint32toflt32:	;	@func
	SEP	#$20
	LDA	__@specSubX+3
	AND #$80
	BNE :+
	JMP __uint32toflt32
	:
	; If negative
	REP #$21
	LDA #$0000
	SBC __@specSubX+0
	SBC __@specSubX+2
	JSL __uint32toflt32
	SEP #$20
	LDA #$80
	ORA __@callResult+3
	STA __@callResult+3	
RTL					;	@endfunc
__sint64toflt32:	;	@func
	SEP	#$20
	LDA	__@specSubX+7
	AND #$80
	BNE :+
	JMP __uint64toflt32
	:
	; If negative
	REP #$21
	LDA #$0000
	SBC __@specSubX+0
	SBC __@specSubX+2
	SBC __@specSubX+4
	SBC __@specSubX+6
	JSL __uint64toflt32
	SEP #$20
	LDA #$80
	ORA __@callResult+3
	STA __@callResult+3	
RTL					;	@endfunc