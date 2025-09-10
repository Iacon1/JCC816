__addflt64:			;	@func
RTL					;	@endfunc
__subflt64:			;	@func
RTL					;	@endfunc
__mulflt64:			;	@func
RTL					;	@endfunc
__divflt64:			;	@func
RTL					;	@endfunc
__negflt64:			;	@func
	REP #$20
	LDA __@specSubX+0
	STA __@callResult+0
	LDA __@specSubX+2
	STA __@callResult+2
	LDA __@specSubX+4
	STA __@callResult+4
	LDA __@specSubX+6
	EOR #$8000
	STA __@callResult+6
RTL					;	@endfunc
__cmpsflt64:		;	@func
RTL					;	@endfunc