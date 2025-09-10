__flt32tosint8:		;	@func
	SEP	#$20
	LDA	__@specSubX+3
	BIT #$80
	BNE :+
	JMP __flt32touint8
	:
	; If negative
	AND #$7F
	STA __@specSubX+3
	JSL __flt32touint8
	CLC
	SEP #$20
	LDA #$00
	SBC __@callResult+0
	STA __@callResult+0
RTL					;	@endfunc
__flt32tosint16:	;	@func
	SEP	#$20
	LDA	__@specSubX+3
	BIT #$80
	BNE :+
	JMP __flt32touint16
	:
	; If negative
	AND #$7F
	STA __@specSubX+3
	JSL __flt32touint16
	REP #$21
	LDA #$0000
	SBC __@callResult+0
	STA __@callResult+0
RTL					;	@endfunc
__flt32tosint24:	;	@func
	SEP	#$20
	LDA	__@specSubX+3
	BIT #$80
	BNE :+
	JMP __flt32touint24
	:
	; If negative
	AND #$7F
	STA __@specSubX+3
	JSL __flt32touint24
	REP #$20
	SEC
	LDA #$0000
	SBC __@callResult+0
	STA __@callResult+0
	SEP #$20
	LDA #$00
	SBC __@callResult+2
	STA __@callResult+2
RTL					;	@endfunc
__flt32tosint32:	;	@func
	SEP	#$20
	LDA	__@specSubX+3
	BIT #$80
	BNE :+
	JMP __flt32touint32
	:
	; If negative
	AND #$7F
	STA __@specSubX+3
	JSL __flt32touint32
	REP #$20
	SEC
	LDA #$0000
	SBC __@callResult+0
	STA __@callResult+0
	LDA #$0000
	SBC __@callResult+2
	STA __@callResult+2
RTL					;	@endfunc
__flt32tosint64:	;	@func
	SEP	#$20
	LDA	__@specSubX+3
	BIT #$80
	BNE :+
	JMP __flt32touint64
	:
	; If negative
	AND #$7F
	STA __@specSubX+3
	JSL __flt32touint64
	REP #$20
	SEC
	LDA #$0000
	SBC __@callResult+0
	STA __@callResult+0
	LDA #$0000
	SBC __@callResult+2
	STA __@callResult+2
	LDA #$0000
	SBC __@callResult+4
	STA __@callResult+4
	LDA #$0000
	SBC __@callResult+6
	STA __@callResult+6
RTL					;	@endfunc