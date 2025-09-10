; Doubles
__sint8toflt64:		;	@func
	SEP	#$20
	LDA	__@specSubX+0
	AND #$80
	BNE :+
	JMP __uint8toflt64
	:
	; If negative
	REP #$20
	SEC
	LDA #$00
	SBC __@specSubX+0
	JSL __uint8toflt64
	SEP #$20
	LDA #$80
	ORA __@callResult+0
	STA __@callResult+0
RTL					;	@endfunc
__sint16toflt64:	;	@func
SEP	#$20
	LDA	__@specSubX+1
	AND #$80
	BNE :+
	JMP __uint16toflt64
	:
	; If negative
	REP #$21
	LDA #$0000
	SBC __@specSubX+0
	JSL __uint16toflt64
	SEP #$20
	LDA #$80
	ORA __@callResult+0
	STA __@callResult+0	
RTL					;	@endfunc
__sint24toflt64:	;	@func
	SEP	#$20
	LDA	__@specSubX+2
	AND #$80
	BNE :+
	JMP __uint24toflt64
	:
	; If negative
	REP #$20
	SEC
	LDA #$0000
	SBC __@specSubX+0
	SEP #$20
	SBC __@specSubX+2
	JSL __uint24toflt64
	SEP #$20
	LDA #$80
	ORA __@callResult+0
	STA __@callResult+0
RTL					;	@endfunc
__sint32toflt64:	;	@func
	SEP	#$20
	LDA	__@specSubX+3
	AND #$80
	BNE :+
	JMP __uint32toflt64
	:
	; If negative
	REP #$20
	SEC
	LDA #$0000
	SBC __@specSubX+0
	SBC __@specSubX+2
	JSL __uint32toflt64
	SEP #$20
	LDA #$80
	ORA __@callResult+0
	STA __@callResult+0	
RTL					;	@endfunc
__sint64toflt64:	;	@func
	SEP	#$20
	LDA	__@specSubX+7
	AND #$80
	BNE :+
	JMP __uint64toflt64
	:
	; If negative
	REP #$20
	SEC
	LDA #$0000
	SBC __@specSubX+0
	SBC __@specSubX+2
	SBC __@specSubX+4
	SBC __@specSubX+6
	JSL __uint64toflt64
	SEP #$20
	LDA #$80
	ORA __@callResult+0
	STA __@callResult+0	
RTL					;	@endfunc