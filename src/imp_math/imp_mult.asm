; Thanks Sir Walrus

; Multiplication
__mul8by8:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@callResult + 1
RTL		; @endfunc

__mul16by8:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@callResult + 2
RTL		; @endfunc

__mul16by16:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul24by8:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul24by16:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul24by24:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul32by8:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul32by16:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul32by24:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul32by32:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul64by8:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul64by16:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul64by24:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul64by32:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc

__mul64by64:		; @func
  CLC
  SEP	#$20
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 1
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  LDA	__REG@RDMPYH
  ADC	#$00
  STA	__@signExtend
RTL		; @endfunc


; Division
__div8by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  SEP	#$20
  STA	__@callResult + 2
  LDA	__@specSubX + -1
  STA	__REG@WRDIVL
  STZ	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + -1
  ADC	__REG@RDDIVL
  STA	__@callResult + -1
  SEP	#$20
RTL		; @endfunc

__div16by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  SEP	#$20
  STA	__@callResult + 2
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  LDA	__@specSubX + 1
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 0
  ADC	__REG@RDDIVL
  STA	__@callResult + 0
  SEP	#$20
RTL		; @endfunc

__div24by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  SEP	#$20
  STA	__@callResult + 2
  LDA	__@specSubX + 1
  STA	__REG@WRDIVL
  LDA	__@specSubX + 2
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 1
  ADC	__REG@RDDIVL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 1
  LDA	__REG@RDMPYH
  STA	__@specSubX + 2
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  LDA	__@specSubX + 1
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 0
  ADC	__REG@RDDIVL
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@callResult + 2
  ADC	#$00
  STA	__@callResult + 1
RTL		; @endfunc

__div32by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRDIVL
  LDA	__@specSubX + 3
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 2
  ADC	__REG@RDDIVL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 2
  LDA	__REG@RDMPYH
  STA	__@specSubX + 3
  LDA	__@specSubX + 1
  STA	__REG@WRDIVL
  LDA	__@specSubX + 2
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 1
  ADC	__REG@RDDIVL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@callResult + 3
  ADC	#$00
  STA	__@callResult + 2
  LDA	__REG@RDMPYL
  STA	__@specSubX + 1
  LDA	__REG@RDMPYH
  STA	__@specSubX + 2
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  LDA	__@specSubX + 1
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 0
  ADC	__REG@RDDIVL
  STA	__@callResult + 0
  LDA	__@callResult + 2
  ADC	#$0000
  STA	__@callResult + 1
  SEP	#$20
RTL		; @endfunc

__div64by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  STA	__@callResult + 2
  STA	__@callResult + 4
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRDIVL
  LDA	__@specSubX + 7
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 6
  ADC	__REG@RDDIVL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 6
  LDA	__REG@RDMPYH
  STA	__@specSubX + 7
  LDA	__@specSubX + 5
  STA	__REG@WRDIVL
  LDA	__@specSubX + 6
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 5
  ADC	__REG@RDDIVL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@callResult + 7
  ADC	#$00
  STA	__@callResult + 6
  LDA	__REG@RDMPYL
  STA	__@specSubX + 5
  LDA	__REG@RDMPYH
  STA	__@specSubX + 6
  LDA	__@specSubX + 4
  STA	__REG@WRDIVL
  LDA	__@specSubX + 5
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 4
  ADC	__REG@RDDIVL
  STA	__@callResult + 4
  LDA	__@callResult + 6
  ADC	#$0000
  STA	__@callResult + 5
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 4
  LDA	__REG@RDMPYH
  STA	__@specSubX + 5
  LDA	__@specSubX + 3
  STA	__REG@WRDIVL
  LDA	__@specSubX + 4
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 3
  ADC	__REG@RDDIVL
  STA	__@callResult + 3
  LDA	__@callResult + 5
  ADC	#$0000
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@callResult + 7
  ADC	#$00
  STA	__@callResult + 4
  LDA	__REG@RDMPYL
  STA	__@specSubX + 3
  LDA	__REG@RDMPYH
  STA	__@specSubX + 4
  LDA	__@specSubX + 2
  STA	__REG@WRDIVL
  LDA	__@specSubX + 3
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 2
  ADC	__REG@RDDIVL
  STA	__@callResult + 2
  LDA	__@callResult + 4
  ADC	#$0000
  STA	__@callResult + 3
  LDA	__@callResult + 6
  ADC	#$0000
  STA	__@callResult + 3
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 2
  LDA	__REG@RDMPYH
  STA	__@specSubX + 3
  LDA	__@specSubX + 1
  STA	__REG@WRDIVL
  LDA	__@specSubX + 2
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 1
  ADC	__REG@RDDIVL
  STA	__@callResult + 1
  LDA	__@callResult + 3
  ADC	#$0000
  STA	__@callResult + 2
  LDA	__@callResult + 5
  ADC	#$0000
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@callResult + 7
  ADC	#$00
  STA	__@callResult + 2
  LDA	__REG@RDMPYL
  STA	__@specSubX + 1
  LDA	__REG@RDMPYH
  STA	__@specSubX + 2
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  LDA	__@specSubX + 1
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$21
  LDA	__@callResult + 0
  ADC	__REG@RDDIVL
  STA	__@callResult + 0
  LDA	__@callResult + 2
  ADC	#$0000
  STA	__@callResult + 1
  LDA	__@callResult + 4
  ADC	#$0000
  STA	__@callResult + 1
  LDA	__@callResult + 6
  ADC	#$0000
  STA	__@callResult + 1
  SEP	#$20
RTL		; @endfunc


; Modulation
__mod8by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  SEP	#$20
  STA	__@callResult + 2
  LDA	__@specSubX + -1
  STA	__REG@WRDIVL
  STZ	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 0
  SEP	#$20
RTL		; @endfunc

__mod16by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  SEP	#$20
  STA	__@callResult + 2
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  LDA	__@specSubX + 1
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
RTL		; @endfunc

__mod24by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  SEP	#$20
  STA	__@callResult + 2
  LDA	__@specSubX + 1
  STA	__REG@WRDIVL
  LDA	__@specSubX + 2
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 1
  LDA	__REG@RDMPYH
  STA	__@specSubX + 2
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  LDA	__@specSubX + 1
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
RTL		; @endfunc

__mod32by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRDIVL
  LDA	__@specSubX + 3
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 2
  LDA	__REG@RDMPYH
  STA	__@specSubX + 3
  LDA	__@specSubX + 1
  STA	__REG@WRDIVL
  LDA	__@specSubX + 2
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 1
  LDA	__REG@RDMPYH
  STA	__@specSubX + 2
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  LDA	__@specSubX + 1
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
RTL		; @endfunc

__mod64by8:		; @func
  REP	#$20
  LDA	#$0000
  STA	__@callResult + 0
  STA	__@callResult + 2
  STA	__@callResult + 4
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRDIVL
  LDA	__@specSubX + 7
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 6
  LDA	__REG@RDMPYH
  STA	__@specSubX + 7
  LDA	__@specSubX + 5
  STA	__REG@WRDIVL
  LDA	__@specSubX + 6
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 5
  LDA	__REG@RDMPYH
  STA	__@specSubX + 6
  LDA	__@specSubX + 4
  STA	__REG@WRDIVL
  LDA	__@specSubX + 5
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 4
  LDA	__REG@RDMPYH
  STA	__@specSubX + 5
  LDA	__@specSubX + 3
  STA	__REG@WRDIVL
  LDA	__@specSubX + 4
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 3
  LDA	__REG@RDMPYH
  STA	__@specSubX + 4
  LDA	__@specSubX + 2
  STA	__REG@WRDIVL
  LDA	__@specSubX + 3
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 2
  LDA	__REG@RDMPYH
  STA	__@specSubX + 3
  LDA	__@specSubX + 1
  STA	__REG@WRDIVL
  LDA	__@specSubX + 2
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__REG@RDMPYL
  STA	__@specSubX + 1
  LDA	__REG@RDMPYH
  STA	__@specSubX + 2
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  LDA	__@specSubX + 1
  STA	__REG@WRDIVH
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  REP	#$20
  LDA	__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
RTL		; @endfunc


__div8by16:	; @func
  __div8by16@ret = __@callResult+0
  __div8by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div8by16@ret + 0
  SEP	#$20
  STA	__div8by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div8by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div8by16@start + 2
  __ITER__START__5990df36_64bf_471c_800d_ccdaf0ca3179:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b
  BNE	__CMP_YES_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b
  BNE	__CMP_YES_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b
  JMP	__CMP_NO_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b
  __CMP_YES_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b
  __CMP_NO_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b:
  SEP	#$20
  LDA	#$00
  __CMP_END_28f8af6b_35a8_4f2c_82ba_3fbabde6dd7b:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5990df36_64bf_471c_800d_ccdaf0ca3179
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_eaa3a45f_a486_480c_8ab0_4a411533527d
  JMP	__ITER__END__5990df36_64bf_471c_800d_ccdaf0ca3179
  __IFNOT_eaa3a45f_a486_480c_8ab0_4a411533527d:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div8by16@start + 0
  ASL
  STA	__div8by16@start + 0
  SEP	#$20
  LDA	__div8by16@start + 2
  ROL
  STA	__div8by16@start + 2
  JMP	__ITER__START__5990df36_64bf_471c_800d_ccdaf0ca3179
  __ITER__END__5990df36_64bf_471c_800d_ccdaf0ca3179:
  __ITER__START__bf263cd0_cdeb_4799_97f2_5ba6c60b5ab9:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div8by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div8by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__bf263cd0_cdeb_4799_97f2_5ba6c60b5ab9
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2def1916_885f_4410_8e53_6644bbeb4371
  BNE	__CMP_YES_2def1916_885f_4410_8e53_6644bbeb4371
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2def1916_885f_4410_8e53_6644bbeb4371
  BNE	__CMP_YES_2def1916_885f_4410_8e53_6644bbeb4371
  JMP	__CMP_YES_2def1916_885f_4410_8e53_6644bbeb4371
  __CMP_YES_2def1916_885f_4410_8e53_6644bbeb4371:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2def1916_885f_4410_8e53_6644bbeb4371
  __CMP_NO_2def1916_885f_4410_8e53_6644bbeb4371:
  SEP	#$20
  LDA	#$00
  __CMP_END_2def1916_885f_4410_8e53_6644bbeb4371:
  BEQ	__IFNOT_28389b41_18d7_478c_ad6f_1babd56f061a
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  SEP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__div8by16@ret + 0
  ADC	__div8by16@start + 0
  STA	__div8by16@ret + 0
  SEP	#$20
  LDA	__div8by16@ret + 2
  ADC	__div8by16@start + 2
  STA	__div8by16@ret + 2
  __IFNOT_28389b41_18d7_478c_ad6f_1babd56f061a:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div8by16@start + 1
  LSR
  STA	__div8by16@start + 1
  SEP	#$20
  LDA	__div8by16@start + 0
  ROR
  STA	__div8by16@start + 0
  JMP	__ITER__START__bf263cd0_cdeb_4799_97f2_5ba6c60b5ab9
  __ITER__END__bf263cd0_cdeb_4799_97f2_5ba6c60b5ab9:
  REP	#$20
  LDA	__div8by16@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div8by16@ret + 2
  STA	__@callResult + 2
  JMP	____div8by16_END
____div8by16_END:
RTL	; @endfunc
__div16by16:	; @func
  __div16by16@ret = __@callResult+0
  __div16by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div16by16@ret + 0
  SEP	#$20
  STA	__div16by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div16by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div16by16@start + 2
  __ITER__START__3df33d71_17a4_462a_9e53_410f771f4435:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_bc766b0c_8dc2_4ebe_8077_46890a410a46
  BNE	__CMP_YES_bc766b0c_8dc2_4ebe_8077_46890a410a46
  JMP	__CMP_NO_bc766b0c_8dc2_4ebe_8077_46890a410a46
  __CMP_YES_bc766b0c_8dc2_4ebe_8077_46890a410a46:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_bc766b0c_8dc2_4ebe_8077_46890a410a46
  __CMP_NO_bc766b0c_8dc2_4ebe_8077_46890a410a46:
  SEP	#$20
  LDA	#$00
  __CMP_END_bc766b0c_8dc2_4ebe_8077_46890a410a46:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__3df33d71_17a4_462a_9e53_410f771f4435
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_e54619ed_1b96_4d54_b28d_b8e3f3dae6a0
  JMP	__ITER__END__3df33d71_17a4_462a_9e53_410f771f4435
  __IFNOT_e54619ed_1b96_4d54_b28d_b8e3f3dae6a0:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div16by16@start + 0
  ASL
  STA	__div16by16@start + 0
  SEP	#$20
  LDA	__div16by16@start + 2
  ROL
  STA	__div16by16@start + 2
  JMP	__ITER__START__3df33d71_17a4_462a_9e53_410f771f4435
  __ITER__END__3df33d71_17a4_462a_9e53_410f771f4435:
  __ITER__START__a3ef8310_9fd0_4bf4_b94b_4587af38c2d6:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div16by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div16by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a3ef8310_9fd0_4bf4_b94b_4587af38c2d6
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ea70e07d_f98e_432b_bbee_915c5a15516c
  BNE	__CMP_YES_ea70e07d_f98e_432b_bbee_915c5a15516c
  JMP	__CMP_YES_ea70e07d_f98e_432b_bbee_915c5a15516c
  __CMP_YES_ea70e07d_f98e_432b_bbee_915c5a15516c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ea70e07d_f98e_432b_bbee_915c5a15516c
  __CMP_NO_ea70e07d_f98e_432b_bbee_915c5a15516c:
  SEP	#$20
  LDA	#$00
  __CMP_END_ea70e07d_f98e_432b_bbee_915c5a15516c:
  BEQ	__IFNOT_d1e944bf_b093_48bd_b5bb_8fdc3289016d
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__div16by16@ret + 0
  ADC	__div16by16@start + 0
  STA	__div16by16@ret + 0
  SEP	#$20
  LDA	__div16by16@ret + 2
  ADC	__div16by16@start + 2
  STA	__div16by16@ret + 2
  __IFNOT_d1e944bf_b093_48bd_b5bb_8fdc3289016d:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div16by16@start + 1
  LSR
  STA	__div16by16@start + 1
  SEP	#$20
  LDA	__div16by16@start + 0
  ROR
  STA	__div16by16@start + 0
  JMP	__ITER__START__a3ef8310_9fd0_4bf4_b94b_4587af38c2d6
  __ITER__END__a3ef8310_9fd0_4bf4_b94b_4587af38c2d6:
  REP	#$20
  LDA	__div16by16@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div16by16@ret + 2
  STA	__@callResult + 2
  JMP	____div16by16_END
____div16by16_END:
RTL	; @endfunc
__div24by16:	; @func
  __div24by16@ret = __@callResult+0
  __div24by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div24by16@ret + 0
  SEP	#$20
  STA	__div24by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div24by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div24by16@start + 2
  __ITER__START__30925aff_8452_4443_9d09_a78cd51a0b92:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1
  BNE	__CMP_YES_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1
  BNE	__CMP_YES_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1
  JMP	__CMP_NO_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1
  __CMP_YES_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1
  __CMP_NO_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1:
  SEP	#$20
  LDA	#$00
  __CMP_END_b10b04eb_6a45_456c_9a1b_6055a8fe1aa1:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__30925aff_8452_4443_9d09_a78cd51a0b92
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_514b93de_c00b_4adc_b403_1aa473a0258a
  JMP	__ITER__END__30925aff_8452_4443_9d09_a78cd51a0b92
  __IFNOT_514b93de_c00b_4adc_b403_1aa473a0258a:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div24by16@start + 0
  ASL
  STA	__div24by16@start + 0
  SEP	#$20
  LDA	__div24by16@start + 2
  ROL
  STA	__div24by16@start + 2
  JMP	__ITER__START__30925aff_8452_4443_9d09_a78cd51a0b92
  __ITER__END__30925aff_8452_4443_9d09_a78cd51a0b92:
  __ITER__START__fb8377e6_483f_41d2_a2eb_572029eee870:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div24by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div24by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__fb8377e6_483f_41d2_a2eb_572029eee870
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_04299222_68a9_42da_aef4_745380c8fd9f
  BNE	__CMP_YES_04299222_68a9_42da_aef4_745380c8fd9f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_04299222_68a9_42da_aef4_745380c8fd9f
  BNE	__CMP_YES_04299222_68a9_42da_aef4_745380c8fd9f
  JMP	__CMP_YES_04299222_68a9_42da_aef4_745380c8fd9f
  __CMP_YES_04299222_68a9_42da_aef4_745380c8fd9f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_04299222_68a9_42da_aef4_745380c8fd9f
  __CMP_NO_04299222_68a9_42da_aef4_745380c8fd9f:
  SEP	#$20
  LDA	#$00
  __CMP_END_04299222_68a9_42da_aef4_745380c8fd9f:
  BEQ	__IFNOT_ad1c76fe_cc93_46c4_bfae_c419165436e0
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@signExtend
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__div24by16@ret + 0
  ADC	__div24by16@start + 0
  STA	__div24by16@ret + 0
  SEP	#$20
  LDA	__div24by16@ret + 2
  ADC	__div24by16@start + 2
  STA	__div24by16@ret + 2
  __IFNOT_ad1c76fe_cc93_46c4_bfae_c419165436e0:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div24by16@start + 1
  LSR
  STA	__div24by16@start + 1
  SEP	#$20
  LDA	__div24by16@start + 0
  ROR
  STA	__div24by16@start + 0
  JMP	__ITER__START__fb8377e6_483f_41d2_a2eb_572029eee870
  __ITER__END__fb8377e6_483f_41d2_a2eb_572029eee870:
  REP	#$20
  LDA	__div24by16@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div24by16@ret + 2
  STA	__@callResult + 2
  JMP	____div24by16_END
____div24by16_END:
RTL	; @endfunc
__div32by16:	; @func
  __div32by16@ret = __@callResult+0
  __div32by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div32by16@ret + 0
  SEP	#$20
  STA	__div32by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div32by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div32by16@start + 2
  __ITER__START__74d4e83a_7742_494b_b754_0b132f192829:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8
  BNE	__CMP_YES_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8
  BNE	__CMP_YES_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8
  JMP	__CMP_NO_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8
  __CMP_YES_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8
  __CMP_NO_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8:
  SEP	#$20
  LDA	#$00
  __CMP_END_f2d2b74d_748b_4bd6_8c1c_c6c51c31ade8:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__74d4e83a_7742_494b_b754_0b132f192829
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_5e3cdb02_1faa_47ff_8b63_57441a3243ca
  JMP	__ITER__END__74d4e83a_7742_494b_b754_0b132f192829
  __IFNOT_5e3cdb02_1faa_47ff_8b63_57441a3243ca:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div32by16@start + 0
  ASL
  STA	__div32by16@start + 0
  SEP	#$20
  LDA	__div32by16@start + 2
  ROL
  STA	__div32by16@start + 2
  JMP	__ITER__START__74d4e83a_7742_494b_b754_0b132f192829
  __ITER__END__74d4e83a_7742_494b_b754_0b132f192829:
  __ITER__START__786f5474_33a2_4a9b_b974_3be3f32b758a:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div32by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div32by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__786f5474_33a2_4a9b_b974_3be3f32b758a
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_e7e96178_6197_4a40_923a_4b548c77014a
  BNE	__CMP_YES_e7e96178_6197_4a40_923a_4b548c77014a
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e7e96178_6197_4a40_923a_4b548c77014a
  BNE	__CMP_YES_e7e96178_6197_4a40_923a_4b548c77014a
  JMP	__CMP_YES_e7e96178_6197_4a40_923a_4b548c77014a
  __CMP_YES_e7e96178_6197_4a40_923a_4b548c77014a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e7e96178_6197_4a40_923a_4b548c77014a
  __CMP_NO_e7e96178_6197_4a40_923a_4b548c77014a:
  SEP	#$20
  LDA	#$00
  __CMP_END_e7e96178_6197_4a40_923a_4b548c77014a:
  BEQ	__IFNOT_ccc804df_ac5b_480d_9d6e_24695f245d87
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@signExtend
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__div32by16@ret + 0
  ADC	__div32by16@start + 0
  STA	__div32by16@ret + 0
  SEP	#$20
  LDA	__div32by16@ret + 2
  ADC	__div32by16@start + 2
  STA	__div32by16@ret + 2
  __IFNOT_ccc804df_ac5b_480d_9d6e_24695f245d87:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div32by16@start + 1
  LSR
  STA	__div32by16@start + 1
  SEP	#$20
  LDA	__div32by16@start + 0
  ROR
  STA	__div32by16@start + 0
  JMP	__ITER__START__786f5474_33a2_4a9b_b974_3be3f32b758a
  __ITER__END__786f5474_33a2_4a9b_b974_3be3f32b758a:
  REP	#$20
  LDA	__div32by16@ret + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__div32by16@ret + 2
  STA	__@callResult + 2
  JMP	____div32by16_END
____div32by16_END:
RTL	; @endfunc
__div64by16:	; @func
  __div64by16@ret = __@callResult+0
  __div64by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div64by16@ret + 0
  SEP	#$20
  STA	__div64by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div64by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div64by16@start + 2
  __ITER__START__32f1dc6f_8baf_4f29_96e0_7fda679aaf7e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  BNE	__CMP_YES_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  BNE	__CMP_YES_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  BNE	__CMP_YES_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  BNE	__CMP_YES_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  JMP	__CMP_NO_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  __CMP_YES_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0
  __CMP_NO_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0:
  SEP	#$20
  LDA	#$00
  __CMP_END_01d129fb_c746_4ac5_b3cb_d35a6fa65ce0:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__32f1dc6f_8baf_4f29_96e0_7fda679aaf7e
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_cd807634_636d_4a2c_8b7e_b23d07c82e9f
  JMP	__ITER__END__32f1dc6f_8baf_4f29_96e0_7fda679aaf7e
  __IFNOT_cd807634_636d_4a2c_8b7e_b23d07c82e9f:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div64by16@start + 0
  ASL
  STA	__div64by16@start + 0
  SEP	#$20
  LDA	__div64by16@start + 2
  ROL
  STA	__div64by16@start + 2
  JMP	__ITER__START__32f1dc6f_8baf_4f29_96e0_7fda679aaf7e
  __ITER__END__32f1dc6f_8baf_4f29_96e0_7fda679aaf7e:
  __ITER__START__a8969381_61c0_40cf_8eb5_612468083696:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div64by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div64by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a8969381_61c0_40cf_8eb5_612468083696
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  BNE	__CMP_YES_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  BNE	__CMP_YES_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  BNE	__CMP_YES_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  BNE	__CMP_YES_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  JMP	__CMP_YES_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  __CMP_YES_dd5b4f98_fe2a_4f55_9d32_de908119f6ff:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_dd5b4f98_fe2a_4f55_9d32_de908119f6ff
  __CMP_NO_dd5b4f98_fe2a_4f55_9d32_de908119f6ff:
  SEP	#$20
  LDA	#$00
  __CMP_END_dd5b4f98_fe2a_4f55_9d32_de908119f6ff:
  BEQ	__IFNOT_d6f4e3d8_6265_4301_a7bd_72990a52de4c
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@signExtend
  STA	__@specSubX + 2
  REP	#$20
  LDA	__@specSubX + 4
  SBC	__@signExtend
  STA	__@specSubX + 4
  REP	#$20
  LDA	__@specSubX + 6
  SBC	__@signExtend
  STA	__@specSubX + 6
  CLC
  REP	#$20
  LDA	__div64by16@ret + 0
  ADC	__div64by16@start + 0
  STA	__div64by16@ret + 0
  SEP	#$20
  LDA	__div64by16@ret + 2
  ADC	__div64by16@start + 2
  STA	__div64by16@ret + 2
  __IFNOT_d6f4e3d8_6265_4301_a7bd_72990a52de4c:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div64by16@start + 1
  LSR
  STA	__div64by16@start + 1
  SEP	#$20
  LDA	__div64by16@start + 0
  ROR
  STA	__div64by16@start + 0
  JMP	__ITER__START__a8969381_61c0_40cf_8eb5_612468083696
  __ITER__END__a8969381_61c0_40cf_8eb5_612468083696:
  REP	#$20
  LDA	__div64by16@ret + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__div64by16@ret + 2
  STA	__@callResult + 2
  REP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  REP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____div64by16_END
____div64by16_END:
RTL	; @endfunc
__div8by24:	; @func
  __div8by24@ret = __@callResult+0
  __div8by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div8by24@ret + 0
  SEP	#$20
  STA	__div8by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div8by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div8by24@start + 2
  __ITER__START__89bdf3c8_95e2_4cda_b122_004e9c678672:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c512e392_fadf_49c2_933a_5c62199d8ad3
  BNE	__CMP_YES_c512e392_fadf_49c2_933a_5c62199d8ad3
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c512e392_fadf_49c2_933a_5c62199d8ad3
  BNE	__CMP_YES_c512e392_fadf_49c2_933a_5c62199d8ad3
  JMP	__CMP_NO_c512e392_fadf_49c2_933a_5c62199d8ad3
  __CMP_YES_c512e392_fadf_49c2_933a_5c62199d8ad3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c512e392_fadf_49c2_933a_5c62199d8ad3
  __CMP_NO_c512e392_fadf_49c2_933a_5c62199d8ad3:
  SEP	#$20
  LDA	#$00
  __CMP_END_c512e392_fadf_49c2_933a_5c62199d8ad3:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__89bdf3c8_95e2_4cda_b122_004e9c678672
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_763c48c9_3998_49f6_9724_f61b1ee34d03
  JMP	__ITER__END__89bdf3c8_95e2_4cda_b122_004e9c678672
  __IFNOT_763c48c9_3998_49f6_9724_f61b1ee34d03:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div8by24@start + 0
  ASL
  STA	__div8by24@start + 0
  SEP	#$20
  LDA	__div8by24@start + 2
  ROL
  STA	__div8by24@start + 2
  JMP	__ITER__START__89bdf3c8_95e2_4cda_b122_004e9c678672
  __ITER__END__89bdf3c8_95e2_4cda_b122_004e9c678672:
  __ITER__START__4beb2eda_983e_467a_95bb_b28ea070938a:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div8by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div8by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4beb2eda_983e_467a_95bb_b28ea070938a
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_0eec20b9_e75c_4f22_a8c1_81284ab70ada
  BNE	__CMP_YES_0eec20b9_e75c_4f22_a8c1_81284ab70ada
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0eec20b9_e75c_4f22_a8c1_81284ab70ada
  BNE	__CMP_YES_0eec20b9_e75c_4f22_a8c1_81284ab70ada
  JMP	__CMP_YES_0eec20b9_e75c_4f22_a8c1_81284ab70ada
  __CMP_YES_0eec20b9_e75c_4f22_a8c1_81284ab70ada:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0eec20b9_e75c_4f22_a8c1_81284ab70ada
  __CMP_NO_0eec20b9_e75c_4f22_a8c1_81284ab70ada:
  SEP	#$20
  LDA	#$00
  __CMP_END_0eec20b9_e75c_4f22_a8c1_81284ab70ada:
  BEQ	__IFNOT_3b968193_385d_4bbd_a351_5177c451c535
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  SEP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__div8by24@ret + 0
  ADC	__div8by24@start + 0
  STA	__div8by24@ret + 0
  SEP	#$20
  LDA	__div8by24@ret + 2
  ADC	__div8by24@start + 2
  STA	__div8by24@ret + 2
  __IFNOT_3b968193_385d_4bbd_a351_5177c451c535:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div8by24@start + 1
  LSR
  STA	__div8by24@start + 1
  SEP	#$20
  LDA	__div8by24@start + 0
  ROR
  STA	__div8by24@start + 0
  JMP	__ITER__START__4beb2eda_983e_467a_95bb_b28ea070938a
  __ITER__END__4beb2eda_983e_467a_95bb_b28ea070938a:
  REP	#$20
  LDA	__div8by24@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div8by24@ret + 2
  STA	__@callResult + 2
  JMP	____div8by24_END
____div8by24_END:
RTL	; @endfunc
__div16by24:	; @func
  __div16by24@ret = __@callResult+0
  __div16by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div16by24@ret + 0
  SEP	#$20
  STA	__div16by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div16by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div16by24@start + 2
  __ITER__START__f8500439_408e_492d_bb60_d022a139bc0f:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1
  BNE	__CMP_YES_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1
  BNE	__CMP_YES_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1
  JMP	__CMP_NO_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1
  __CMP_YES_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1
  __CMP_NO_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1:
  SEP	#$20
  LDA	#$00
  __CMP_END_cfec7d2a_a43a_482b_ba4a_0b8f90440ec1:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f8500439_408e_492d_bb60_d022a139bc0f
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_0bc8b2b2_889b_46df_9a7e_ed7577904dce
  JMP	__ITER__END__f8500439_408e_492d_bb60_d022a139bc0f
  __IFNOT_0bc8b2b2_889b_46df_9a7e_ed7577904dce:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div16by24@start + 0
  ASL
  STA	__div16by24@start + 0
  SEP	#$20
  LDA	__div16by24@start + 2
  ROL
  STA	__div16by24@start + 2
  JMP	__ITER__START__f8500439_408e_492d_bb60_d022a139bc0f
  __ITER__END__f8500439_408e_492d_bb60_d022a139bc0f:
  __ITER__START__bcd4fff6_2150_4b12_8c3a_9bd39629b3f2:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div16by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div16by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__bcd4fff6_2150_4b12_8c3a_9bd39629b3f2
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_060f2eba_999e_4c64_8a48_02fd2af5372d
  BNE	__CMP_YES_060f2eba_999e_4c64_8a48_02fd2af5372d
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_060f2eba_999e_4c64_8a48_02fd2af5372d
  BNE	__CMP_YES_060f2eba_999e_4c64_8a48_02fd2af5372d
  JMP	__CMP_YES_060f2eba_999e_4c64_8a48_02fd2af5372d
  __CMP_YES_060f2eba_999e_4c64_8a48_02fd2af5372d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_060f2eba_999e_4c64_8a48_02fd2af5372d
  __CMP_NO_060f2eba_999e_4c64_8a48_02fd2af5372d:
  SEP	#$20
  LDA	#$00
  __CMP_END_060f2eba_999e_4c64_8a48_02fd2af5372d:
  BEQ	__IFNOT_fbc6995f_4955_41d6_99bf_68f6255cb87b
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__div16by24@ret + 0
  ADC	__div16by24@start + 0
  STA	__div16by24@ret + 0
  SEP	#$20
  LDA	__div16by24@ret + 2
  ADC	__div16by24@start + 2
  STA	__div16by24@ret + 2
  __IFNOT_fbc6995f_4955_41d6_99bf_68f6255cb87b:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div16by24@start + 1
  LSR
  STA	__div16by24@start + 1
  SEP	#$20
  LDA	__div16by24@start + 0
  ROR
  STA	__div16by24@start + 0
  JMP	__ITER__START__bcd4fff6_2150_4b12_8c3a_9bd39629b3f2
  __ITER__END__bcd4fff6_2150_4b12_8c3a_9bd39629b3f2:
  REP	#$20
  LDA	__div16by24@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div16by24@ret + 2
  STA	__@callResult + 2
  JMP	____div16by24_END
____div16by24_END:
RTL	; @endfunc
__div24by24:	; @func
  __div24by24@ret = __@callResult+0
  __div24by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div24by24@ret + 0
  SEP	#$20
  STA	__div24by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div24by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div24by24@start + 2
  __ITER__START__34d4c3fd_812b_48e2_9950_534b6fb49adf:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8043ca5f_7241_45f7_94a3_85730f822482
  BNE	__CMP_YES_8043ca5f_7241_45f7_94a3_85730f822482
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8043ca5f_7241_45f7_94a3_85730f822482
  BNE	__CMP_YES_8043ca5f_7241_45f7_94a3_85730f822482
  JMP	__CMP_NO_8043ca5f_7241_45f7_94a3_85730f822482
  __CMP_YES_8043ca5f_7241_45f7_94a3_85730f822482:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8043ca5f_7241_45f7_94a3_85730f822482
  __CMP_NO_8043ca5f_7241_45f7_94a3_85730f822482:
  SEP	#$20
  LDA	#$00
  __CMP_END_8043ca5f_7241_45f7_94a3_85730f822482:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__34d4c3fd_812b_48e2_9950_534b6fb49adf
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_55a4509b_4307_41a2_bb61_97b7e5882679
  JMP	__ITER__END__34d4c3fd_812b_48e2_9950_534b6fb49adf
  __IFNOT_55a4509b_4307_41a2_bb61_97b7e5882679:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div24by24@start + 0
  ASL
  STA	__div24by24@start + 0
  SEP	#$20
  LDA	__div24by24@start + 2
  ROL
  STA	__div24by24@start + 2
  JMP	__ITER__START__34d4c3fd_812b_48e2_9950_534b6fb49adf
  __ITER__END__34d4c3fd_812b_48e2_9950_534b6fb49adf:
  __ITER__START__74e815d3_722f_453c_afe8_fc68dad684cf:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div24by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div24by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__74e815d3_722f_453c_afe8_fc68dad684cf
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_063b7a7a_8f11_437c_ac1c_4c5851779071
  BNE	__CMP_YES_063b7a7a_8f11_437c_ac1c_4c5851779071
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_063b7a7a_8f11_437c_ac1c_4c5851779071
  BNE	__CMP_YES_063b7a7a_8f11_437c_ac1c_4c5851779071
  JMP	__CMP_YES_063b7a7a_8f11_437c_ac1c_4c5851779071
  __CMP_YES_063b7a7a_8f11_437c_ac1c_4c5851779071:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_063b7a7a_8f11_437c_ac1c_4c5851779071
  __CMP_NO_063b7a7a_8f11_437c_ac1c_4c5851779071:
  SEP	#$20
  LDA	#$00
  __CMP_END_063b7a7a_8f11_437c_ac1c_4c5851779071:
  BEQ	__IFNOT_e851fa77_be6e_4b50_9298_6de74ca914a7
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__div24by24@ret + 0
  ADC	__div24by24@start + 0
  STA	__div24by24@ret + 0
  SEP	#$20
  LDA	__div24by24@ret + 2
  ADC	__div24by24@start + 2
  STA	__div24by24@ret + 2
  __IFNOT_e851fa77_be6e_4b50_9298_6de74ca914a7:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div24by24@start + 1
  LSR
  STA	__div24by24@start + 1
  SEP	#$20
  LDA	__div24by24@start + 0
  ROR
  STA	__div24by24@start + 0
  JMP	__ITER__START__74e815d3_722f_453c_afe8_fc68dad684cf
  __ITER__END__74e815d3_722f_453c_afe8_fc68dad684cf:
  REP	#$20
  LDA	__div24by24@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div24by24@ret + 2
  STA	__@callResult + 2
  JMP	____div24by24_END
____div24by24_END:
RTL	; @endfunc
__div32by24:	; @func
  __div32by24@ret = __@callResult+0
  __div32by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div32by24@ret + 0
  SEP	#$20
  STA	__div32by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div32by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div32by24@start + 2
  __ITER__START__35e16dfa_b16d_452e_a1a7_9db6947f1aa5:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_29c69f7a_2f8d_412e_a74f_e41b2e8d4269
  BNE	__CMP_YES_29c69f7a_2f8d_412e_a74f_e41b2e8d4269
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_29c69f7a_2f8d_412e_a74f_e41b2e8d4269
  BNE	__CMP_YES_29c69f7a_2f8d_412e_a74f_e41b2e8d4269
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_29c69f7a_2f8d_412e_a74f_e41b2e8d4269
  BNE	__CMP_YES_29c69f7a_2f8d_412e_a74f_e41b2e8d4269
  JMP	__CMP_NO_29c69f7a_2f8d_412e_a74f_e41b2e8d4269
  __CMP_YES_29c69f7a_2f8d_412e_a74f_e41b2e8d4269:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_29c69f7a_2f8d_412e_a74f_e41b2e8d4269
  __CMP_NO_29c69f7a_2f8d_412e_a74f_e41b2e8d4269:
  SEP	#$20
  LDA	#$00
  __CMP_END_29c69f7a_2f8d_412e_a74f_e41b2e8d4269:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__35e16dfa_b16d_452e_a1a7_9db6947f1aa5
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_50cd3df0_3398_43cf_a03a_c56848a25db5
  JMP	__ITER__END__35e16dfa_b16d_452e_a1a7_9db6947f1aa5
  __IFNOT_50cd3df0_3398_43cf_a03a_c56848a25db5:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div32by24@start + 0
  ASL
  STA	__div32by24@start + 0
  SEP	#$20
  LDA	__div32by24@start + 2
  ROL
  STA	__div32by24@start + 2
  JMP	__ITER__START__35e16dfa_b16d_452e_a1a7_9db6947f1aa5
  __ITER__END__35e16dfa_b16d_452e_a1a7_9db6947f1aa5:
  __ITER__START__e1701fd2_8ed1_4e06_9ffc_a557efcbaaad:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div32by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div32by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e1701fd2_8ed1_4e06_9ffc_a557efcbaaad
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_5fea5c11_2042_4767_addf_a921491faf07
  BNE	__CMP_YES_5fea5c11_2042_4767_addf_a921491faf07
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_5fea5c11_2042_4767_addf_a921491faf07
  BNE	__CMP_YES_5fea5c11_2042_4767_addf_a921491faf07
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5fea5c11_2042_4767_addf_a921491faf07
  BNE	__CMP_YES_5fea5c11_2042_4767_addf_a921491faf07
  JMP	__CMP_YES_5fea5c11_2042_4767_addf_a921491faf07
  __CMP_YES_5fea5c11_2042_4767_addf_a921491faf07:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5fea5c11_2042_4767_addf_a921491faf07
  __CMP_NO_5fea5c11_2042_4767_addf_a921491faf07:
  SEP	#$20
  LDA	#$00
  __CMP_END_5fea5c11_2042_4767_addf_a921491faf07:
  BEQ	__IFNOT_3d6f2cb3_51db_4522_a27c_f7ea6e937e16
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  SEP	#$20
  LDA	__@specSubX + 3
  SBC	__@signExtend
  STA	__@specSubX + 3
  CLC
  REP	#$20
  LDA	__div32by24@ret + 0
  ADC	__div32by24@start + 0
  STA	__div32by24@ret + 0
  SEP	#$20
  LDA	__div32by24@ret + 2
  ADC	__div32by24@start + 2
  STA	__div32by24@ret + 2
  __IFNOT_3d6f2cb3_51db_4522_a27c_f7ea6e937e16:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div32by24@start + 1
  LSR
  STA	__div32by24@start + 1
  SEP	#$20
  LDA	__div32by24@start + 0
  ROR
  STA	__div32by24@start + 0
  JMP	__ITER__START__e1701fd2_8ed1_4e06_9ffc_a557efcbaaad
  __ITER__END__e1701fd2_8ed1_4e06_9ffc_a557efcbaaad:
  REP	#$20
  LDA	__div32by24@ret + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__div32by24@ret + 2
  STA	__@callResult + 2
  JMP	____div32by24_END
____div32by24_END:
RTL	; @endfunc
__div64by24:	; @func
  __div64by24@ret = __@callResult+0
  __div64by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div64by24@ret + 0
  SEP	#$20
  STA	__div64by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div64by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div64by24@start + 2
  __ITER__START__aef18f54_fb22_4d8c_8061_05cd805e8688:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_de185e86_4399_4d54_b290_1637c9f3e136
  BNE	__CMP_YES_de185e86_4399_4d54_b290_1637c9f3e136
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_de185e86_4399_4d54_b290_1637c9f3e136
  BNE	__CMP_YES_de185e86_4399_4d54_b290_1637c9f3e136
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_de185e86_4399_4d54_b290_1637c9f3e136
  BNE	__CMP_YES_de185e86_4399_4d54_b290_1637c9f3e136
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_de185e86_4399_4d54_b290_1637c9f3e136
  BNE	__CMP_YES_de185e86_4399_4d54_b290_1637c9f3e136
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_de185e86_4399_4d54_b290_1637c9f3e136
  BNE	__CMP_YES_de185e86_4399_4d54_b290_1637c9f3e136
  JMP	__CMP_NO_de185e86_4399_4d54_b290_1637c9f3e136
  __CMP_YES_de185e86_4399_4d54_b290_1637c9f3e136:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_de185e86_4399_4d54_b290_1637c9f3e136
  __CMP_NO_de185e86_4399_4d54_b290_1637c9f3e136:
  SEP	#$20
  LDA	#$00
  __CMP_END_de185e86_4399_4d54_b290_1637c9f3e136:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__aef18f54_fb22_4d8c_8061_05cd805e8688
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_011c0245_7155_4696_9369_cd2c0f1c398e
  JMP	__ITER__END__aef18f54_fb22_4d8c_8061_05cd805e8688
  __IFNOT_011c0245_7155_4696_9369_cd2c0f1c398e:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div64by24@start + 0
  ASL
  STA	__div64by24@start + 0
  SEP	#$20
  LDA	__div64by24@start + 2
  ROL
  STA	__div64by24@start + 2
  JMP	__ITER__START__aef18f54_fb22_4d8c_8061_05cd805e8688
  __ITER__END__aef18f54_fb22_4d8c_8061_05cd805e8688:
  __ITER__START__8cdb4a72_a6fb_4591_a2c6_9f724773c73e:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div64by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div64by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__8cdb4a72_a6fb_4591_a2c6_9f724773c73e
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_85ae6b59_ed9c_428c_83a3_973b684bc007
  BNE	__CMP_YES_85ae6b59_ed9c_428c_83a3_973b684bc007
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_85ae6b59_ed9c_428c_83a3_973b684bc007
  BNE	__CMP_YES_85ae6b59_ed9c_428c_83a3_973b684bc007
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_85ae6b59_ed9c_428c_83a3_973b684bc007
  BNE	__CMP_YES_85ae6b59_ed9c_428c_83a3_973b684bc007
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_85ae6b59_ed9c_428c_83a3_973b684bc007
  BNE	__CMP_YES_85ae6b59_ed9c_428c_83a3_973b684bc007
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_85ae6b59_ed9c_428c_83a3_973b684bc007
  BNE	__CMP_YES_85ae6b59_ed9c_428c_83a3_973b684bc007
  JMP	__CMP_YES_85ae6b59_ed9c_428c_83a3_973b684bc007
  __CMP_YES_85ae6b59_ed9c_428c_83a3_973b684bc007:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_85ae6b59_ed9c_428c_83a3_973b684bc007
  __CMP_NO_85ae6b59_ed9c_428c_83a3_973b684bc007:
  SEP	#$20
  LDA	#$00
  __CMP_END_85ae6b59_ed9c_428c_83a3_973b684bc007:
  BNE	:+
  JMP	__IFNOT_0d48c7cc_e782_47b4_bdd6_3277267e0396
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  REP	#$20
  LDA	__@specSubX + 3
  SBC	__@signExtend
  STA	__@specSubX + 3
  REP	#$20
  LDA	__@specSubX + 5
  SBC	__@signExtend
  STA	__@specSubX + 5
  SEP	#$20
  LDA	__@specSubX + 7
  SBC	__@signExtend
  STA	__@specSubX + 7
  CLC
  REP	#$20
  LDA	__div64by24@ret + 0
  ADC	__div64by24@start + 0
  STA	__div64by24@ret + 0
  SEP	#$20
  LDA	__div64by24@ret + 2
  ADC	__div64by24@start + 2
  STA	__div64by24@ret + 2
  __IFNOT_0d48c7cc_e782_47b4_bdd6_3277267e0396:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div64by24@start + 1
  LSR
  STA	__div64by24@start + 1
  SEP	#$20
  LDA	__div64by24@start + 0
  ROR
  STA	__div64by24@start + 0
  JMP	__ITER__START__8cdb4a72_a6fb_4591_a2c6_9f724773c73e
  __ITER__END__8cdb4a72_a6fb_4591_a2c6_9f724773c73e:
  REP	#$20
  LDA	__div64by24@ret + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__div64by24@ret + 2
  STA	__@callResult + 2
  REP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  REP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____div64by24_END
____div64by24_END:
RTL	; @endfunc
__div8by32:	; @func
  __div8by32@ret = __@callResult+0
  __div8by32@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div8by32@ret + 0
  SEP	#$20
  STA	__div8by32@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div8by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div8by32@start + 2
  __ITER__START__6079d7da_3f54_406e_9248_0c72031b2f81:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_022e4e0e_49c8_4da6_95c4_d4c1810ada2a
  BNE	__CMP_YES_022e4e0e_49c8_4da6_95c4_d4c1810ada2a
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_022e4e0e_49c8_4da6_95c4_d4c1810ada2a
  BNE	__CMP_YES_022e4e0e_49c8_4da6_95c4_d4c1810ada2a
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_022e4e0e_49c8_4da6_95c4_d4c1810ada2a
  BNE	__CMP_YES_022e4e0e_49c8_4da6_95c4_d4c1810ada2a
  JMP	__CMP_NO_022e4e0e_49c8_4da6_95c4_d4c1810ada2a
  __CMP_YES_022e4e0e_49c8_4da6_95c4_d4c1810ada2a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_022e4e0e_49c8_4da6_95c4_d4c1810ada2a
  __CMP_NO_022e4e0e_49c8_4da6_95c4_d4c1810ada2a:
  SEP	#$20
  LDA	#$00
  __CMP_END_022e4e0e_49c8_4da6_95c4_d4c1810ada2a:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6079d7da_3f54_406e_9248_0c72031b2f81
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_2e9990f0_96ef_470f_9efa_6a1d2a1320f3
  JMP	__ITER__END__6079d7da_3f54_406e_9248_0c72031b2f81
  __IFNOT_2e9990f0_96ef_470f_9efa_6a1d2a1320f3:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div8by32@start + 0
  ASL
  STA	__div8by32@start + 0
  SEP	#$20
  LDA	__div8by32@start + 2
  ROL
  STA	__div8by32@start + 2
  JMP	__ITER__START__6079d7da_3f54_406e_9248_0c72031b2f81
  __ITER__END__6079d7da_3f54_406e_9248_0c72031b2f81:
  __ITER__START__9125f139_84a9_4ef5_ae58_72b80a2a5b9f:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div8by32@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div8by32@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9125f139_84a9_4ef5_ae58_72b80a2a5b9f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b82ce341_edaf_4744_a602_7aa414018eca
  BNE	__CMP_YES_b82ce341_edaf_4744_a602_7aa414018eca
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b82ce341_edaf_4744_a602_7aa414018eca
  BNE	__CMP_YES_b82ce341_edaf_4744_a602_7aa414018eca
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b82ce341_edaf_4744_a602_7aa414018eca
  BNE	__CMP_YES_b82ce341_edaf_4744_a602_7aa414018eca
  JMP	__CMP_YES_b82ce341_edaf_4744_a602_7aa414018eca
  __CMP_YES_b82ce341_edaf_4744_a602_7aa414018eca:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b82ce341_edaf_4744_a602_7aa414018eca
  __CMP_NO_b82ce341_edaf_4744_a602_7aa414018eca:
  SEP	#$20
  LDA	#$00
  __CMP_END_b82ce341_edaf_4744_a602_7aa414018eca:
  BEQ	__IFNOT_42a235e6_1876_4393_993e_db47107d7cda
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  SEP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__div8by32@ret + 0
  ADC	__div8by32@start + 0
  STA	__div8by32@ret + 0
  SEP	#$20
  LDA	__div8by32@ret + 2
  ADC	__div8by32@start + 2
  STA	__div8by32@ret + 2
  __IFNOT_42a235e6_1876_4393_993e_db47107d7cda:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div8by32@start + 1
  LSR
  STA	__div8by32@start + 1
  SEP	#$20
  LDA	__div8by32@start + 0
  ROR
  STA	__div8by32@start + 0
  JMP	__ITER__START__9125f139_84a9_4ef5_ae58_72b80a2a5b9f
  __ITER__END__9125f139_84a9_4ef5_ae58_72b80a2a5b9f:
  REP	#$20
  LDA	__div8by32@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div8by32@ret + 2
  STA	__@callResult + 2
  JMP	____div8by32_END
____div8by32_END:
RTL	; @endfunc
__div16by32:	; @func
  __div16by32@ret = __@callResult+0
  __div16by32@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div16by32@ret + 0
  SEP	#$20
  STA	__div16by32@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div16by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div16by32@start + 2
  __ITER__START__eb6d09ac_761f_4ab5_8050_0fd82a89747a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_51607134_f03a_4ae8_879c_ef2627725e07
  BNE	__CMP_YES_51607134_f03a_4ae8_879c_ef2627725e07
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_51607134_f03a_4ae8_879c_ef2627725e07
  BNE	__CMP_YES_51607134_f03a_4ae8_879c_ef2627725e07
  JMP	__CMP_NO_51607134_f03a_4ae8_879c_ef2627725e07
  __CMP_YES_51607134_f03a_4ae8_879c_ef2627725e07:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_51607134_f03a_4ae8_879c_ef2627725e07
  __CMP_NO_51607134_f03a_4ae8_879c_ef2627725e07:
  SEP	#$20
  LDA	#$00
  __CMP_END_51607134_f03a_4ae8_879c_ef2627725e07:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__eb6d09ac_761f_4ab5_8050_0fd82a89747a
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_2c8588f4_7a21_47f5_a99f_1feab717c5e4
  JMP	__ITER__END__eb6d09ac_761f_4ab5_8050_0fd82a89747a
  __IFNOT_2c8588f4_7a21_47f5_a99f_1feab717c5e4:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div16by32@start + 0
  ASL
  STA	__div16by32@start + 0
  SEP	#$20
  LDA	__div16by32@start + 2
  ROL
  STA	__div16by32@start + 2
  JMP	__ITER__START__eb6d09ac_761f_4ab5_8050_0fd82a89747a
  __ITER__END__eb6d09ac_761f_4ab5_8050_0fd82a89747a:
  __ITER__START__47592cc1_f4b1_424f_bdd8_ad0695d5451b:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div16by32@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div16by32@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__47592cc1_f4b1_424f_bdd8_ad0695d5451b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e38d6799_f33b_4c3b_9d76_e3a27472a805
  BNE	__CMP_YES_e38d6799_f33b_4c3b_9d76_e3a27472a805
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e38d6799_f33b_4c3b_9d76_e3a27472a805
  BNE	__CMP_YES_e38d6799_f33b_4c3b_9d76_e3a27472a805
  JMP	__CMP_YES_e38d6799_f33b_4c3b_9d76_e3a27472a805
  __CMP_YES_e38d6799_f33b_4c3b_9d76_e3a27472a805:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e38d6799_f33b_4c3b_9d76_e3a27472a805
  __CMP_NO_e38d6799_f33b_4c3b_9d76_e3a27472a805:
  SEP	#$20
  LDA	#$00
  __CMP_END_e38d6799_f33b_4c3b_9d76_e3a27472a805:
  BEQ	__IFNOT_122d5a56_377d_4bf6_9602_a9981bcab794
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__div16by32@ret + 0
  ADC	__div16by32@start + 0
  STA	__div16by32@ret + 0
  SEP	#$20
  LDA	__div16by32@ret + 2
  ADC	__div16by32@start + 2
  STA	__div16by32@ret + 2
  __IFNOT_122d5a56_377d_4bf6_9602_a9981bcab794:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div16by32@start + 1
  LSR
  STA	__div16by32@start + 1
  SEP	#$20
  LDA	__div16by32@start + 0
  ROR
  STA	__div16by32@start + 0
  JMP	__ITER__START__47592cc1_f4b1_424f_bdd8_ad0695d5451b
  __ITER__END__47592cc1_f4b1_424f_bdd8_ad0695d5451b:
  REP	#$20
  LDA	__div16by32@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div16by32@ret + 2
  STA	__@callResult + 2
  JMP	____div16by32_END
____div16by32_END:
RTL	; @endfunc
__div24by32:	; @func
  __div24by32@ret = __@callResult+0
  __div24by32@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div24by32@ret + 0
  SEP	#$20
  STA	__div24by32@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div24by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div24by32@start + 2
  __ITER__START__4c6e3ab4_92c9_43d8_8237_893d1452b083:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_389d04b4_abdd_4a38_8f46_43ec23d45dc6
  BNE	__CMP_YES_389d04b4_abdd_4a38_8f46_43ec23d45dc6
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_389d04b4_abdd_4a38_8f46_43ec23d45dc6
  BNE	__CMP_YES_389d04b4_abdd_4a38_8f46_43ec23d45dc6
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_389d04b4_abdd_4a38_8f46_43ec23d45dc6
  BNE	__CMP_YES_389d04b4_abdd_4a38_8f46_43ec23d45dc6
  JMP	__CMP_NO_389d04b4_abdd_4a38_8f46_43ec23d45dc6
  __CMP_YES_389d04b4_abdd_4a38_8f46_43ec23d45dc6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_389d04b4_abdd_4a38_8f46_43ec23d45dc6
  __CMP_NO_389d04b4_abdd_4a38_8f46_43ec23d45dc6:
  SEP	#$20
  LDA	#$00
  __CMP_END_389d04b4_abdd_4a38_8f46_43ec23d45dc6:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4c6e3ab4_92c9_43d8_8237_893d1452b083
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_2fb9f057_7778_49be_ae1d_d4ec3530ed80
  JMP	__ITER__END__4c6e3ab4_92c9_43d8_8237_893d1452b083
  __IFNOT_2fb9f057_7778_49be_ae1d_d4ec3530ed80:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div24by32@start + 0
  ASL
  STA	__div24by32@start + 0
  SEP	#$20
  LDA	__div24by32@start + 2
  ROL
  STA	__div24by32@start + 2
  JMP	__ITER__START__4c6e3ab4_92c9_43d8_8237_893d1452b083
  __ITER__END__4c6e3ab4_92c9_43d8_8237_893d1452b083:
  __ITER__START__dbbef32e_4c8e_4df9_a0cc_cdd3f4e09eae:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div24by32@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div24by32@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__dbbef32e_4c8e_4df9_a0cc_cdd3f4e09eae
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_ebcbba7f_6210_4730_92cd_059dbe206336
  BNE	__CMP_YES_ebcbba7f_6210_4730_92cd_059dbe206336
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ebcbba7f_6210_4730_92cd_059dbe206336
  BNE	__CMP_YES_ebcbba7f_6210_4730_92cd_059dbe206336
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ebcbba7f_6210_4730_92cd_059dbe206336
  BNE	__CMP_YES_ebcbba7f_6210_4730_92cd_059dbe206336
  JMP	__CMP_YES_ebcbba7f_6210_4730_92cd_059dbe206336
  __CMP_YES_ebcbba7f_6210_4730_92cd_059dbe206336:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ebcbba7f_6210_4730_92cd_059dbe206336
  __CMP_NO_ebcbba7f_6210_4730_92cd_059dbe206336:
  SEP	#$20
  LDA	#$00
  __CMP_END_ebcbba7f_6210_4730_92cd_059dbe206336:
  BEQ	__IFNOT_a58d258f_45b2_41e3_920d_99364ac3a8dc
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__div24by32@ret + 0
  ADC	__div24by32@start + 0
  STA	__div24by32@ret + 0
  SEP	#$20
  LDA	__div24by32@ret + 2
  ADC	__div24by32@start + 2
  STA	__div24by32@ret + 2
  __IFNOT_a58d258f_45b2_41e3_920d_99364ac3a8dc:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div24by32@start + 1
  LSR
  STA	__div24by32@start + 1
  SEP	#$20
  LDA	__div24by32@start + 0
  ROR
  STA	__div24by32@start + 0
  JMP	__ITER__START__dbbef32e_4c8e_4df9_a0cc_cdd3f4e09eae
  __ITER__END__dbbef32e_4c8e_4df9_a0cc_cdd3f4e09eae:
  REP	#$20
  LDA	__div24by32@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div24by32@ret + 2
  STA	__@callResult + 2
  JMP	____div24by32_END
____div24by32_END:
RTL	; @endfunc
__div32by32:	; @func
  __div32by32@ret = __@callResult+0
  __div32by32@start = __@callResult+4
  REP	#$20
  LDA	#$0000
  STA	__div32by32@ret + 0
  STA	__div32by32@ret + 2
  LDA	#$0001
  STA	__div32by32@start + 0
  LDA	#$0000
  STA	__div32by32@start + 2
  __ITER__START__4588162e_d2e1_495e_924a_00501398fa37:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7f96cb04_5c75_4541_a1e7_6211944a3b6c
  BNE	__CMP_YES_7f96cb04_5c75_4541_a1e7_6211944a3b6c
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7f96cb04_5c75_4541_a1e7_6211944a3b6c
  BNE	__CMP_YES_7f96cb04_5c75_4541_a1e7_6211944a3b6c
  JMP	__CMP_NO_7f96cb04_5c75_4541_a1e7_6211944a3b6c
  __CMP_YES_7f96cb04_5c75_4541_a1e7_6211944a3b6c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7f96cb04_5c75_4541_a1e7_6211944a3b6c
  __CMP_NO_7f96cb04_5c75_4541_a1e7_6211944a3b6c:
  SEP	#$20
  LDA	#$00
  __CMP_END_7f96cb04_5c75_4541_a1e7_6211944a3b6c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4588162e_d2e1_495e_924a_00501398fa37
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_7ef47d05_8b24_499e_ab36_c3c90d2fbf08
  JMP	__ITER__END__4588162e_d2e1_495e_924a_00501398fa37
  __IFNOT_7ef47d05_8b24_499e_ab36_c3c90d2fbf08:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div32by32@start + 0
  ASL
  STA	__div32by32@start + 0
  REP	#$20
  LDA	__div32by32@start + 2
  ROL
  STA	__div32by32@start + 2
  JMP	__ITER__START__4588162e_d2e1_495e_924a_00501398fa37
  __ITER__END__4588162e_d2e1_495e_924a_00501398fa37:
  __ITER__START__be488de6_7894_47e3_bead_bc7f16e74206:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div32by32@start + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__div32by32@start + 2
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__be488de6_7894_47e3_bead_bc7f16e74206
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688
  BNE	__CMP_YES_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688
  BNE	__CMP_YES_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688
  JMP	__CMP_YES_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688
  __CMP_YES_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688
  __CMP_NO_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688:
  SEP	#$20
  LDA	#$00
  __CMP_END_024b7ed7_31e5_4f9e_bb97_ada6dd3ca688:
  BEQ	__IFNOT_5f6713f4_caa0_42ff_9cc1_285f9f4dbad1
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__div32by32@ret + 0
  ADC	__div32by32@start + 0
  STA	__div32by32@ret + 0
  REP	#$20
  LDA	__div32by32@ret + 2
  ADC	__div32by32@start + 2
  STA	__div32by32@ret + 2
  __IFNOT_5f6713f4_caa0_42ff_9cc1_285f9f4dbad1:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div32by32@start + 2
  LSR
  STA	__div32by32@start + 2
  LDA	__div32by32@start + 0
  ROR
  STA	__div32by32@start + 0
  JMP	__ITER__START__be488de6_7894_47e3_bead_bc7f16e74206
  __ITER__END__be488de6_7894_47e3_bead_bc7f16e74206:
  REP	#$20
  LDA	__div32by32@ret + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__div32by32@ret + 2
  STA	__@callResult + 2
  JMP	____div32by32_END
____div32by32_END:
RTL	; @endfunc
__div64by32:	; @func
  __div64by32@ret = __@callResult+0
  __div64by32@start = __@callResult+4
  REP	#$20
  LDA	#$0000
  STA	__div64by32@ret + 0
  STA	__div64by32@ret + 2
  LDA	#$0001
  STA	__div64by32@start + 0
  LDA	#$0000
  STA	__div64by32@start + 2
  __ITER__START__b2c3b81a_60f6_4458_bbbf_2aae448dc5cc:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_873d14d5_8804_4dc5_87bd_b4010f7226cb
  BNE	__CMP_YES_873d14d5_8804_4dc5_87bd_b4010f7226cb
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_873d14d5_8804_4dc5_87bd_b4010f7226cb
  BNE	__CMP_YES_873d14d5_8804_4dc5_87bd_b4010f7226cb
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_873d14d5_8804_4dc5_87bd_b4010f7226cb
  BNE	__CMP_YES_873d14d5_8804_4dc5_87bd_b4010f7226cb
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_873d14d5_8804_4dc5_87bd_b4010f7226cb
  BNE	__CMP_YES_873d14d5_8804_4dc5_87bd_b4010f7226cb
  JMP	__CMP_NO_873d14d5_8804_4dc5_87bd_b4010f7226cb
  __CMP_YES_873d14d5_8804_4dc5_87bd_b4010f7226cb:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_873d14d5_8804_4dc5_87bd_b4010f7226cb
  __CMP_NO_873d14d5_8804_4dc5_87bd_b4010f7226cb:
  SEP	#$20
  LDA	#$00
  __CMP_END_873d14d5_8804_4dc5_87bd_b4010f7226cb:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b2c3b81a_60f6_4458_bbbf_2aae448dc5cc
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_b9f3302e_af12_4bb1_8669_c6e793f80ab9
  JMP	__ITER__END__b2c3b81a_60f6_4458_bbbf_2aae448dc5cc
  __IFNOT_b9f3302e_af12_4bb1_8669_c6e793f80ab9:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__div64by32@start + 0
  ASL
  STA	__div64by32@start + 0
  REP	#$20
  LDA	__div64by32@start + 2
  ROL
  STA	__div64by32@start + 2
  JMP	__ITER__START__b2c3b81a_60f6_4458_bbbf_2aae448dc5cc
  __ITER__END__b2c3b81a_60f6_4458_bbbf_2aae448dc5cc:
  __ITER__START__1d82daaf_9e75_47a8_a985_96622612ad59:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div64by32@start + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__div64by32@start + 2
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1d82daaf_9e75_47a8_a985_96622612ad59
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_d7eab061_3d07_4d56_9292_6fb59a3081b5
  BNE	__CMP_YES_d7eab061_3d07_4d56_9292_6fb59a3081b5
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_d7eab061_3d07_4d56_9292_6fb59a3081b5
  BNE	__CMP_YES_d7eab061_3d07_4d56_9292_6fb59a3081b5
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d7eab061_3d07_4d56_9292_6fb59a3081b5
  BNE	__CMP_YES_d7eab061_3d07_4d56_9292_6fb59a3081b5
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d7eab061_3d07_4d56_9292_6fb59a3081b5
  BNE	__CMP_YES_d7eab061_3d07_4d56_9292_6fb59a3081b5
  JMP	__CMP_YES_d7eab061_3d07_4d56_9292_6fb59a3081b5
  __CMP_YES_d7eab061_3d07_4d56_9292_6fb59a3081b5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d7eab061_3d07_4d56_9292_6fb59a3081b5
  __CMP_NO_d7eab061_3d07_4d56_9292_6fb59a3081b5:
  SEP	#$20
  LDA	#$00
  __CMP_END_d7eab061_3d07_4d56_9292_6fb59a3081b5:
  BEQ	__IFNOT_e5389c48_b086_4f24_b624_c506c5e704dc
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  REP	#$20
  LDA	__@specSubX + 4
  SBC	__@signExtend
  STA	__@specSubX + 4
  REP	#$20
  LDA	__@specSubX + 6
  SBC	__@signExtend
  STA	__@specSubX + 6
  CLC
  REP	#$20
  LDA	__div64by32@ret + 0
  ADC	__div64by32@start + 0
  STA	__div64by32@ret + 0
  REP	#$20
  LDA	__div64by32@ret + 2
  ADC	__div64by32@start + 2
  STA	__div64by32@ret + 2
  __IFNOT_e5389c48_b086_4f24_b624_c506c5e704dc:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div64by32@start + 2
  LSR
  STA	__div64by32@start + 2
  LDA	__div64by32@start + 0
  ROR
  STA	__div64by32@start + 0
  JMP	__ITER__START__1d82daaf_9e75_47a8_a985_96622612ad59
  __ITER__END__1d82daaf_9e75_47a8_a985_96622612ad59:
  REP	#$20
  LDA	__div64by32@ret + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__div64by32@ret + 2
  STA	__@callResult + 2
  REP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  REP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____div64by32_END
____div64by32_END:
RTL	; @endfunc
__div8by64:	; @func
  __div8by64@ret = __@callResult+0
  __div8by64@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div8by64@ret + 0
  SEP	#$20
  STA	__div8by64@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div8by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div8by64@start + 2
  __ITER__START__f7c2eb64_29f1_48b5_b18d_173cef7c3547:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  BNE	__CMP_YES_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  BNE	__CMP_YES_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  BNE	__CMP_YES_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  BNE	__CMP_YES_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  BNE	__CMP_YES_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  JMP	__CMP_NO_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  __CMP_YES_db203973_b0f4_4e7c_a005_72da7b7d4fdb:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_db203973_b0f4_4e7c_a005_72da7b7d4fdb
  __CMP_NO_db203973_b0f4_4e7c_a005_72da7b7d4fdb:
  SEP	#$20
  LDA	#$00
  __CMP_END_db203973_b0f4_4e7c_a005_72da7b7d4fdb:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f7c2eb64_29f1_48b5_b18d_173cef7c3547
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_e543bff8_a526_44be_a064_b90773f95cde
  JMP	__ITER__END__f7c2eb64_29f1_48b5_b18d_173cef7c3547
  __IFNOT_e543bff8_a526_44be_a064_b90773f95cde:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__div8by64@start + 0
  ASL
  STA	__div8by64@start + 0
  SEP	#$20
  LDA	__div8by64@start + 2
  ROL
  STA	__div8by64@start + 2
  JMP	__ITER__START__f7c2eb64_29f1_48b5_b18d_173cef7c3547
  __ITER__END__f7c2eb64_29f1_48b5_b18d_173cef7c3547:
  __ITER__START__c62eec7f_c49f_4a8d_96b2_e473f33ed702:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div8by64@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div8by64@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__c62eec7f_c49f_4a8d_96b2_e473f33ed702
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  BNE	__CMP_YES_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  BNE	__CMP_YES_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  BNE	__CMP_YES_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  BNE	__CMP_YES_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  BNE	__CMP_YES_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  JMP	__CMP_YES_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  __CMP_YES_5f24b7f8_3582_4ccd_83a2_d2e3319a7783:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5f24b7f8_3582_4ccd_83a2_d2e3319a7783
  __CMP_NO_5f24b7f8_3582_4ccd_83a2_d2e3319a7783:
  SEP	#$20
  LDA	#$00
  __CMP_END_5f24b7f8_3582_4ccd_83a2_d2e3319a7783:
  BEQ	__IFNOT_a0191a90_9fbe_4ab6_a055_f919c7861696
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  SEP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__div8by64@ret + 0
  ADC	__div8by64@start + 0
  STA	__div8by64@ret + 0
  SEP	#$20
  LDA	__div8by64@ret + 2
  ADC	__div8by64@start + 2
  STA	__div8by64@ret + 2
  __IFNOT_a0191a90_9fbe_4ab6_a055_f919c7861696:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div8by64@start + 1
  LSR
  STA	__div8by64@start + 1
  SEP	#$20
  LDA	__div8by64@start + 0
  ROR
  STA	__div8by64@start + 0
  JMP	__ITER__START__c62eec7f_c49f_4a8d_96b2_e473f33ed702
  __ITER__END__c62eec7f_c49f_4a8d_96b2_e473f33ed702:
  REP	#$20
  LDA	__div8by64@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div8by64@ret + 2
  STA	__@callResult + 2
  JMP	____div8by64_END
____div8by64_END:
RTL	; @endfunc
__div16by64:	; @func
  __div16by64@ret = __@callResult+0
  __div16by64@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div16by64@ret + 0
  SEP	#$20
  STA	__div16by64@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div16by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div16by64@start + 2
  __ITER__START__4ce94762_67af_4adf_9ceb_d0aa6c31a31d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_b0cfc034_6446_46d6_adc6_6c423f29ea63
  BNE	__CMP_YES_b0cfc034_6446_46d6_adc6_6c423f29ea63
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_b0cfc034_6446_46d6_adc6_6c423f29ea63
  BNE	__CMP_YES_b0cfc034_6446_46d6_adc6_6c423f29ea63
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b0cfc034_6446_46d6_adc6_6c423f29ea63
  BNE	__CMP_YES_b0cfc034_6446_46d6_adc6_6c423f29ea63
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b0cfc034_6446_46d6_adc6_6c423f29ea63
  BNE	__CMP_YES_b0cfc034_6446_46d6_adc6_6c423f29ea63
  JMP	__CMP_NO_b0cfc034_6446_46d6_adc6_6c423f29ea63
  __CMP_YES_b0cfc034_6446_46d6_adc6_6c423f29ea63:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b0cfc034_6446_46d6_adc6_6c423f29ea63
  __CMP_NO_b0cfc034_6446_46d6_adc6_6c423f29ea63:
  SEP	#$20
  LDA	#$00
  __CMP_END_b0cfc034_6446_46d6_adc6_6c423f29ea63:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4ce94762_67af_4adf_9ceb_d0aa6c31a31d
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_b64782cb_c65e_414b_9a42_81bf4016f8ca
  JMP	__ITER__END__4ce94762_67af_4adf_9ceb_d0aa6c31a31d
  __IFNOT_b64782cb_c65e_414b_9a42_81bf4016f8ca:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__div16by64@start + 0
  ASL
  STA	__div16by64@start + 0
  SEP	#$20
  LDA	__div16by64@start + 2
  ROL
  STA	__div16by64@start + 2
  JMP	__ITER__START__4ce94762_67af_4adf_9ceb_d0aa6c31a31d
  __ITER__END__4ce94762_67af_4adf_9ceb_d0aa6c31a31d:
  __ITER__START__358d7a77_5626_45b5_a6e4_3a48cd5587ba:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div16by64@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div16by64@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__358d7a77_5626_45b5_a6e4_3a48cd5587ba
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_054958b0_2364_4b94_87cb_7615b8645214
  BNE	__CMP_YES_054958b0_2364_4b94_87cb_7615b8645214
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_054958b0_2364_4b94_87cb_7615b8645214
  BNE	__CMP_YES_054958b0_2364_4b94_87cb_7615b8645214
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_054958b0_2364_4b94_87cb_7615b8645214
  BNE	__CMP_YES_054958b0_2364_4b94_87cb_7615b8645214
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_054958b0_2364_4b94_87cb_7615b8645214
  BNE	__CMP_YES_054958b0_2364_4b94_87cb_7615b8645214
  JMP	__CMP_YES_054958b0_2364_4b94_87cb_7615b8645214
  __CMP_YES_054958b0_2364_4b94_87cb_7615b8645214:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_054958b0_2364_4b94_87cb_7615b8645214
  __CMP_NO_054958b0_2364_4b94_87cb_7615b8645214:
  SEP	#$20
  LDA	#$00
  __CMP_END_054958b0_2364_4b94_87cb_7615b8645214:
  BEQ	__IFNOT_028b5623_71ce_4e8f_a668_d3391e4c511f
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__div16by64@ret + 0
  ADC	__div16by64@start + 0
  STA	__div16by64@ret + 0
  SEP	#$20
  LDA	__div16by64@ret + 2
  ADC	__div16by64@start + 2
  STA	__div16by64@ret + 2
  __IFNOT_028b5623_71ce_4e8f_a668_d3391e4c511f:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div16by64@start + 1
  LSR
  STA	__div16by64@start + 1
  SEP	#$20
  LDA	__div16by64@start + 0
  ROR
  STA	__div16by64@start + 0
  JMP	__ITER__START__358d7a77_5626_45b5_a6e4_3a48cd5587ba
  __ITER__END__358d7a77_5626_45b5_a6e4_3a48cd5587ba:
  REP	#$20
  LDA	__div16by64@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div16by64@ret + 2
  STA	__@callResult + 2
  JMP	____div16by64_END
____div16by64_END:
RTL	; @endfunc
__div24by64:	; @func
  __div24by64@ret = __@callResult+0
  __div24by64@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__div24by64@ret + 0
  SEP	#$20
  STA	__div24by64@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__div24by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div24by64@start + 2
  __ITER__START__e60e9bc2_8fd9_4eca_a72c_414c8f4216b8:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  BNE	__CMP_YES_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  BNE	__CMP_YES_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  BNE	__CMP_YES_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  BNE	__CMP_YES_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  BNE	__CMP_YES_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  JMP	__CMP_NO_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  __CMP_YES_1519a1e9_7dab_4dcb_af26_30a4f074b3c5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1519a1e9_7dab_4dcb_af26_30a4f074b3c5
  __CMP_NO_1519a1e9_7dab_4dcb_af26_30a4f074b3c5:
  SEP	#$20
  LDA	#$00
  __CMP_END_1519a1e9_7dab_4dcb_af26_30a4f074b3c5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e60e9bc2_8fd9_4eca_a72c_414c8f4216b8
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_a90f8542_8a52_49af_9028_4e8a4eeb7db3
  JMP	__ITER__END__e60e9bc2_8fd9_4eca_a72c_414c8f4216b8
  __IFNOT_a90f8542_8a52_49af_9028_4e8a4eeb7db3:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__div24by64@start + 0
  ASL
  STA	__div24by64@start + 0
  SEP	#$20
  LDA	__div24by64@start + 2
  ROL
  STA	__div24by64@start + 2
  JMP	__ITER__START__e60e9bc2_8fd9_4eca_a72c_414c8f4216b8
  __ITER__END__e60e9bc2_8fd9_4eca_a72c_414c8f4216b8:
  __ITER__START__6f35092e_befa_4877_b4e1_98014f4e3f28:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div24by64@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__div24by64@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6f35092e_befa_4877_b4e1_98014f4e3f28
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_20fe8c01_201a_440d_85d8_ec458a48e0ef
  BNE	__CMP_YES_20fe8c01_201a_440d_85d8_ec458a48e0ef
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_20fe8c01_201a_440d_85d8_ec458a48e0ef
  BNE	__CMP_YES_20fe8c01_201a_440d_85d8_ec458a48e0ef
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_20fe8c01_201a_440d_85d8_ec458a48e0ef
  BNE	__CMP_YES_20fe8c01_201a_440d_85d8_ec458a48e0ef
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_20fe8c01_201a_440d_85d8_ec458a48e0ef
  BNE	__CMP_YES_20fe8c01_201a_440d_85d8_ec458a48e0ef
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_20fe8c01_201a_440d_85d8_ec458a48e0ef
  BNE	__CMP_YES_20fe8c01_201a_440d_85d8_ec458a48e0ef
  JMP	__CMP_YES_20fe8c01_201a_440d_85d8_ec458a48e0ef
  __CMP_YES_20fe8c01_201a_440d_85d8_ec458a48e0ef:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_20fe8c01_201a_440d_85d8_ec458a48e0ef
  __CMP_NO_20fe8c01_201a_440d_85d8_ec458a48e0ef:
  SEP	#$20
  LDA	#$00
  __CMP_END_20fe8c01_201a_440d_85d8_ec458a48e0ef:
  BEQ	__IFNOT_a8e7c61f_f49a_45be_a40c_ef446190265b
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__div24by64@ret + 0
  ADC	__div24by64@start + 0
  STA	__div24by64@ret + 0
  SEP	#$20
  LDA	__div24by64@ret + 2
  ADC	__div24by64@start + 2
  STA	__div24by64@ret + 2
  __IFNOT_a8e7c61f_f49a_45be_a40c_ef446190265b:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div24by64@start + 1
  LSR
  STA	__div24by64@start + 1
  SEP	#$20
  LDA	__div24by64@start + 0
  ROR
  STA	__div24by64@start + 0
  JMP	__ITER__START__6f35092e_befa_4877_b4e1_98014f4e3f28
  __ITER__END__6f35092e_befa_4877_b4e1_98014f4e3f28:
  REP	#$20
  LDA	__div24by64@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div24by64@ret + 2
  STA	__@callResult + 2
  JMP	____div24by64_END
____div24by64_END:
RTL	; @endfunc
__div32by64:	; @func
  __div32by64@ret = __@callResult+0
  __div32by64@start = __@callResult+4
  REP	#$20
  LDA	#$0000
  STA	__div32by64@ret + 0
  STA	__div32by64@ret + 2
  LDA	#$0001
  STA	__div32by64@start + 0
  LDA	#$0000
  STA	__div32by64@start + 2
  __ITER__START__aeec6b04_46d4_455a_abe1_aec2835a7793:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_cf041848_0679_4fb0_9631_d11cf0354f34
  BNE	__CMP_YES_cf041848_0679_4fb0_9631_d11cf0354f34
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_cf041848_0679_4fb0_9631_d11cf0354f34
  BNE	__CMP_YES_cf041848_0679_4fb0_9631_d11cf0354f34
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_cf041848_0679_4fb0_9631_d11cf0354f34
  BNE	__CMP_YES_cf041848_0679_4fb0_9631_d11cf0354f34
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cf041848_0679_4fb0_9631_d11cf0354f34
  BNE	__CMP_YES_cf041848_0679_4fb0_9631_d11cf0354f34
  JMP	__CMP_NO_cf041848_0679_4fb0_9631_d11cf0354f34
  __CMP_YES_cf041848_0679_4fb0_9631_d11cf0354f34:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cf041848_0679_4fb0_9631_d11cf0354f34
  __CMP_NO_cf041848_0679_4fb0_9631_d11cf0354f34:
  SEP	#$20
  LDA	#$00
  __CMP_END_cf041848_0679_4fb0_9631_d11cf0354f34:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__aeec6b04_46d4_455a_abe1_aec2835a7793
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_b4f3f441_44aa_4b3b_85df_24874fa445e9
  JMP	__ITER__END__aeec6b04_46d4_455a_abe1_aec2835a7793
  __IFNOT_b4f3f441_44aa_4b3b_85df_24874fa445e9:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__div32by64@start + 0
  ASL
  STA	__div32by64@start + 0
  REP	#$20
  LDA	__div32by64@start + 2
  ROL
  STA	__div32by64@start + 2
  JMP	__ITER__START__aeec6b04_46d4_455a_abe1_aec2835a7793
  __ITER__END__aeec6b04_46d4_455a_abe1_aec2835a7793:
  __ITER__START__a3e6c46d_568e_49aa_b442_1888b7b7ade7:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div32by64@start + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__div32by64@start + 2
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a3e6c46d_568e_49aa_b442_1888b7b7ade7
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  BNE	__CMP_YES_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  BNE	__CMP_YES_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  BNE	__CMP_YES_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  BNE	__CMP_YES_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  JMP	__CMP_YES_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  __CMP_YES_8e4ea317_f5e3_4b23_98c7_0fdfca60e256:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8e4ea317_f5e3_4b23_98c7_0fdfca60e256
  __CMP_NO_8e4ea317_f5e3_4b23_98c7_0fdfca60e256:
  SEP	#$20
  LDA	#$00
  __CMP_END_8e4ea317_f5e3_4b23_98c7_0fdfca60e256:
  BEQ	__IFNOT_8638498f_a408_4eed_8ee1_f37a08bb91c3
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__div32by64@ret + 0
  ADC	__div32by64@start + 0
  STA	__div32by64@ret + 0
  REP	#$20
  LDA	__div32by64@ret + 2
  ADC	__div32by64@start + 2
  STA	__div32by64@ret + 2
  __IFNOT_8638498f_a408_4eed_8ee1_f37a08bb91c3:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div32by64@start + 2
  LSR
  STA	__div32by64@start + 2
  LDA	__div32by64@start + 0
  ROR
  STA	__div32by64@start + 0
  JMP	__ITER__START__a3e6c46d_568e_49aa_b442_1888b7b7ade7
  __ITER__END__a3e6c46d_568e_49aa_b442_1888b7b7ade7:
  REP	#$20
  LDA	__div32by64@ret + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__div32by64@ret + 2
  STA	__@callResult + 2
  JMP	____div32by64_END
____div32by64_END:
RTL	; @endfunc
__div64by64:	; @func
  __div64by64@ret = __@callResult+0
  __div64by64@start = __@callResult+8
  REP	#$20
  LDA	#$0000
  STA	__div64by64@ret + 0
  STA	__div64by64@ret + 2
  STA	__div64by64@ret + 4
  STA	__div64by64@ret + 6
  LDA	#$0001
  STA	__div64by64@start + 0
  LDA	#$0000
  STA	__div64by64@start + 2
  STA	__div64by64@start + 4
  STA	__div64by64@start + 6
  __ITER__START__39c102e7_4d80_4130_983b_0bf09f006505:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_63011e7b_5b8f_42b2_97db_afb31edd951a
  BNE	__CMP_YES_63011e7b_5b8f_42b2_97db_afb31edd951a
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_63011e7b_5b8f_42b2_97db_afb31edd951a
  BNE	__CMP_YES_63011e7b_5b8f_42b2_97db_afb31edd951a
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_63011e7b_5b8f_42b2_97db_afb31edd951a
  BNE	__CMP_YES_63011e7b_5b8f_42b2_97db_afb31edd951a
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_63011e7b_5b8f_42b2_97db_afb31edd951a
  BNE	__CMP_YES_63011e7b_5b8f_42b2_97db_afb31edd951a
  JMP	__CMP_NO_63011e7b_5b8f_42b2_97db_afb31edd951a
  __CMP_YES_63011e7b_5b8f_42b2_97db_afb31edd951a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_63011e7b_5b8f_42b2_97db_afb31edd951a
  __CMP_NO_63011e7b_5b8f_42b2_97db_afb31edd951a:
  SEP	#$20
  LDA	#$00
  __CMP_END_63011e7b_5b8f_42b2_97db_afb31edd951a:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__39c102e7_4d80_4130_983b_0bf09f006505
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_130b70be_8816_4ada_a3c5_7df162ffee8f
  JMP	__ITER__END__39c102e7_4d80_4130_983b_0bf09f006505
  __IFNOT_130b70be_8816_4ada_a3c5_7df162ffee8f:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__div64by64@start + 0
  ASL
  STA	__div64by64@start + 0
  REP	#$20
  LDA	__div64by64@start + 2
  ROL
  STA	__div64by64@start + 2
  REP	#$20
  LDA	__div64by64@start + 4
  ROL
  STA	__div64by64@start + 4
  REP	#$20
  LDA	__div64by64@start + 6
  ROL
  STA	__div64by64@start + 6
  JMP	__ITER__START__39c102e7_4d80_4130_983b_0bf09f006505
  __ITER__END__39c102e7_4d80_4130_983b_0bf09f006505:
  __ITER__START__4cc3a5b6_ec25_4503_a8b0_756000283f7a:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__div64by64@start + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__div64by64@start + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__div64by64@start + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__div64by64@start + 6
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4cc3a5b6_ec25_4503_a8b0_756000283f7a
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  BNE	__CMP_YES_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  BNE	__CMP_YES_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  BNE	__CMP_YES_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  BNE	__CMP_YES_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  JMP	__CMP_YES_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  __CMP_YES_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49
  __CMP_NO_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49:
  SEP	#$20
  LDA	#$00
  __CMP_END_3bdd5f92_7cb1_4de7_b7c8_59dbbf2c0b49:
  BNE	:+
  JMP	__IFNOT_3abf644b_15b0_4a03_904d_95e745d407dd
  :
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  REP	#$20
  LDA	__@specSubX + 4
  SBC	__@specSubY + 4
  STA	__@specSubX + 4
  REP	#$20
  LDA	__@specSubX + 6
  SBC	__@specSubY + 6
  STA	__@specSubX + 6
  CLC
  REP	#$20
  LDA	__div64by64@ret + 0
  ADC	__div64by64@start + 0
  STA	__div64by64@ret + 0
  REP	#$20
  LDA	__div64by64@ret + 2
  ADC	__div64by64@start + 2
  STA	__div64by64@ret + 2
  REP	#$20
  LDA	__div64by64@ret + 4
  ADC	__div64by64@start + 4
  STA	__div64by64@ret + 4
  REP	#$20
  LDA	__div64by64@ret + 6
  ADC	__div64by64@start + 6
  STA	__div64by64@ret + 6
  __IFNOT_3abf644b_15b0_4a03_904d_95e745d407dd:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__div64by64@start + 6
  LSR
  STA	__div64by64@start + 6
  LDA	__div64by64@start + 4
  ROR
  STA	__div64by64@start + 4
  LDA	__div64by64@start + 2
  ROR
  STA	__div64by64@start + 2
  LDA	__div64by64@start + 0
  ROR
  STA	__div64by64@start + 0
  JMP	__ITER__START__4cc3a5b6_ec25_4503_a8b0_756000283f7a
  __ITER__END__4cc3a5b6_ec25_4503_a8b0_756000283f7a:
  REP	#$20
  LDA	__div64by64@ret + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__div64by64@ret + 2
  STA	__@callResult + 2
  REP	#$20
  LDA	__div64by64@ret + 4
  STA	__@callResult + 4
  REP	#$20
  LDA	__div64by64@ret + 6
  STA	__@callResult + 6
  JMP	____div64by64_END
____div64by64_END:
RTL	; @endfunc
__mod8by16:	; @func
  __mod8by16@ret = __@callResult+0
  __mod8by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod8by16@ret + 0
  SEP	#$20
  STA	__mod8by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod8by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod8by16@start + 2
  __ITER__START__698e4422_c9e6_4d20_9acb_2515e827732d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_09026d81_37bc_4363_9d04_bf78179d608e
  BNE	__CMP_YES_09026d81_37bc_4363_9d04_bf78179d608e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_09026d81_37bc_4363_9d04_bf78179d608e
  BNE	__CMP_YES_09026d81_37bc_4363_9d04_bf78179d608e
  JMP	__CMP_NO_09026d81_37bc_4363_9d04_bf78179d608e
  __CMP_YES_09026d81_37bc_4363_9d04_bf78179d608e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_09026d81_37bc_4363_9d04_bf78179d608e
  __CMP_NO_09026d81_37bc_4363_9d04_bf78179d608e:
  SEP	#$20
  LDA	#$00
  __CMP_END_09026d81_37bc_4363_9d04_bf78179d608e:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__698e4422_c9e6_4d20_9acb_2515e827732d
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_9e451e99_45a8_41d2_9986_ee90bb66b88f
  JMP	__ITER__END__698e4422_c9e6_4d20_9acb_2515e827732d
  __IFNOT_9e451e99_45a8_41d2_9986_ee90bb66b88f:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod8by16@start + 0
  ASL
  STA	__mod8by16@start + 0
  SEP	#$20
  LDA	__mod8by16@start + 2
  ROL
  STA	__mod8by16@start + 2
  JMP	__ITER__START__698e4422_c9e6_4d20_9acb_2515e827732d
  __ITER__END__698e4422_c9e6_4d20_9acb_2515e827732d:
  __ITER__START__84a7b520_31b8_427a_8ed3_31a265e1657a:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod8by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod8by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__84a7b520_31b8_427a_8ed3_31a265e1657a
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c8e00418_6f12_4d52_9eee_f24327915325
  BNE	__CMP_YES_c8e00418_6f12_4d52_9eee_f24327915325
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c8e00418_6f12_4d52_9eee_f24327915325
  BNE	__CMP_YES_c8e00418_6f12_4d52_9eee_f24327915325
  JMP	__CMP_YES_c8e00418_6f12_4d52_9eee_f24327915325
  __CMP_YES_c8e00418_6f12_4d52_9eee_f24327915325:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c8e00418_6f12_4d52_9eee_f24327915325
  __CMP_NO_c8e00418_6f12_4d52_9eee_f24327915325:
  SEP	#$20
  LDA	#$00
  __CMP_END_c8e00418_6f12_4d52_9eee_f24327915325:
  BEQ	__IFNOT_18c09ca0_345a_41c7_b3a5_071c21fd1f37
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  SEP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__mod8by16@ret + 0
  ADC	__mod8by16@start + 0
  STA	__mod8by16@ret + 0
  SEP	#$20
  LDA	__mod8by16@ret + 2
  ADC	__mod8by16@start + 2
  STA	__mod8by16@ret + 2
  __IFNOT_18c09ca0_345a_41c7_b3a5_071c21fd1f37:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod8by16@start + 1
  LSR
  STA	__mod8by16@start + 1
  SEP	#$20
  LDA	__mod8by16@start + 0
  ROR
  STA	__mod8by16@start + 0
  JMP	__ITER__START__84a7b520_31b8_427a_8ed3_31a265e1657a
  __ITER__END__84a7b520_31b8_427a_8ed3_31a265e1657a:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____mod8by16_END
____mod8by16_END:
RTL	; @endfunc
__mod16by16:	; @func
  __mod16by16@ret = __@callResult+0
  __mod16by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod16by16@ret + 0
  SEP	#$20
  STA	__mod16by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod16by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod16by16@start + 2
  __ITER__START__b07dc351_605d_41f3_9971_e7890bba6d66:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b70bedd2_4840_40a0_b512_e95237d8ee9d
  BNE	__CMP_YES_b70bedd2_4840_40a0_b512_e95237d8ee9d
  JMP	__CMP_NO_b70bedd2_4840_40a0_b512_e95237d8ee9d
  __CMP_YES_b70bedd2_4840_40a0_b512_e95237d8ee9d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b70bedd2_4840_40a0_b512_e95237d8ee9d
  __CMP_NO_b70bedd2_4840_40a0_b512_e95237d8ee9d:
  SEP	#$20
  LDA	#$00
  __CMP_END_b70bedd2_4840_40a0_b512_e95237d8ee9d:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b07dc351_605d_41f3_9971_e7890bba6d66
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_c0389bb7_2390_42e6_9908_aadd87cede0f
  JMP	__ITER__END__b07dc351_605d_41f3_9971_e7890bba6d66
  __IFNOT_c0389bb7_2390_42e6_9908_aadd87cede0f:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod16by16@start + 0
  ASL
  STA	__mod16by16@start + 0
  SEP	#$20
  LDA	__mod16by16@start + 2
  ROL
  STA	__mod16by16@start + 2
  JMP	__ITER__START__b07dc351_605d_41f3_9971_e7890bba6d66
  __ITER__END__b07dc351_605d_41f3_9971_e7890bba6d66:
  __ITER__START__ad44f5d7_0c96_476c_a9c2_db9c81593ab7:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod16by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod16by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__ad44f5d7_0c96_476c_a9c2_db9c81593ab7
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_879116d6_e74a_4c91_b838_cc6ddc2c0ffd
  BNE	__CMP_YES_879116d6_e74a_4c91_b838_cc6ddc2c0ffd
  JMP	__CMP_YES_879116d6_e74a_4c91_b838_cc6ddc2c0ffd
  __CMP_YES_879116d6_e74a_4c91_b838_cc6ddc2c0ffd:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_879116d6_e74a_4c91_b838_cc6ddc2c0ffd
  __CMP_NO_879116d6_e74a_4c91_b838_cc6ddc2c0ffd:
  SEP	#$20
  LDA	#$00
  __CMP_END_879116d6_e74a_4c91_b838_cc6ddc2c0ffd:
  BEQ	__IFNOT_f6c937e9_8e7f_467f_a59c_48980761b101
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__mod16by16@ret + 0
  ADC	__mod16by16@start + 0
  STA	__mod16by16@ret + 0
  SEP	#$20
  LDA	__mod16by16@ret + 2
  ADC	__mod16by16@start + 2
  STA	__mod16by16@ret + 2
  __IFNOT_f6c937e9_8e7f_467f_a59c_48980761b101:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod16by16@start + 1
  LSR
  STA	__mod16by16@start + 1
  SEP	#$20
  LDA	__mod16by16@start + 0
  ROR
  STA	__mod16by16@start + 0
  JMP	__ITER__START__ad44f5d7_0c96_476c_a9c2_db9c81593ab7
  __ITER__END__ad44f5d7_0c96_476c_a9c2_db9c81593ab7:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____mod16by16_END
____mod16by16_END:
RTL	; @endfunc
__mod24by16:	; @func
  __mod24by16@ret = __@callResult+0
  __mod24by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod24by16@ret + 0
  SEP	#$20
  STA	__mod24by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod24by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod24by16@start + 2
  __ITER__START__35153044_3204_4bef_884e_165384faf63f:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_b4c3171c_de32_40d9_a2d4_98eab5c6b983
  BNE	__CMP_YES_b4c3171c_de32_40d9_a2d4_98eab5c6b983
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b4c3171c_de32_40d9_a2d4_98eab5c6b983
  BNE	__CMP_YES_b4c3171c_de32_40d9_a2d4_98eab5c6b983
  JMP	__CMP_NO_b4c3171c_de32_40d9_a2d4_98eab5c6b983
  __CMP_YES_b4c3171c_de32_40d9_a2d4_98eab5c6b983:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b4c3171c_de32_40d9_a2d4_98eab5c6b983
  __CMP_NO_b4c3171c_de32_40d9_a2d4_98eab5c6b983:
  SEP	#$20
  LDA	#$00
  __CMP_END_b4c3171c_de32_40d9_a2d4_98eab5c6b983:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__35153044_3204_4bef_884e_165384faf63f
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_0348d7c5_2610_46df_b4b2_923ead7b3071
  JMP	__ITER__END__35153044_3204_4bef_884e_165384faf63f
  __IFNOT_0348d7c5_2610_46df_b4b2_923ead7b3071:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod24by16@start + 0
  ASL
  STA	__mod24by16@start + 0
  SEP	#$20
  LDA	__mod24by16@start + 2
  ROL
  STA	__mod24by16@start + 2
  JMP	__ITER__START__35153044_3204_4bef_884e_165384faf63f
  __ITER__END__35153044_3204_4bef_884e_165384faf63f:
  __ITER__START__1de53248_c604_4256_a717_173f6bd952c3:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod24by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod24by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1de53248_c604_4256_a717_173f6bd952c3
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_30698d2e_43d9_4dba_88a2_b9e0c98a41b1
  BNE	__CMP_YES_30698d2e_43d9_4dba_88a2_b9e0c98a41b1
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_30698d2e_43d9_4dba_88a2_b9e0c98a41b1
  BNE	__CMP_YES_30698d2e_43d9_4dba_88a2_b9e0c98a41b1
  JMP	__CMP_YES_30698d2e_43d9_4dba_88a2_b9e0c98a41b1
  __CMP_YES_30698d2e_43d9_4dba_88a2_b9e0c98a41b1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_30698d2e_43d9_4dba_88a2_b9e0c98a41b1
  __CMP_NO_30698d2e_43d9_4dba_88a2_b9e0c98a41b1:
  SEP	#$20
  LDA	#$00
  __CMP_END_30698d2e_43d9_4dba_88a2_b9e0c98a41b1:
  BEQ	__IFNOT_2002242d_d5a1_4127_9203_08fc05f16c56
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@signExtend
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__mod24by16@ret + 0
  ADC	__mod24by16@start + 0
  STA	__mod24by16@ret + 0
  SEP	#$20
  LDA	__mod24by16@ret + 2
  ADC	__mod24by16@start + 2
  STA	__mod24by16@ret + 2
  __IFNOT_2002242d_d5a1_4127_9203_08fc05f16c56:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod24by16@start + 1
  LSR
  STA	__mod24by16@start + 1
  SEP	#$20
  LDA	__mod24by16@start + 0
  ROR
  STA	__mod24by16@start + 0
  JMP	__ITER__START__1de53248_c604_4256_a717_173f6bd952c3
  __ITER__END__1de53248_c604_4256_a717_173f6bd952c3:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod24by16_END
____mod24by16_END:
RTL	; @endfunc
__mod32by16:	; @func
  __mod32by16@ret = __@callResult+0
  __mod32by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod32by16@ret + 0
  SEP	#$20
  STA	__mod32by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod32by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod32by16@start + 2
  __ITER__START__e4d91fa9_a7a4_42fc_96ea_bc5864ed0d98:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_ba9217f0_c28f_4acb_8173_e6414aaad122
  BNE	__CMP_YES_ba9217f0_c28f_4acb_8173_e6414aaad122
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ba9217f0_c28f_4acb_8173_e6414aaad122
  BNE	__CMP_YES_ba9217f0_c28f_4acb_8173_e6414aaad122
  JMP	__CMP_NO_ba9217f0_c28f_4acb_8173_e6414aaad122
  __CMP_YES_ba9217f0_c28f_4acb_8173_e6414aaad122:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ba9217f0_c28f_4acb_8173_e6414aaad122
  __CMP_NO_ba9217f0_c28f_4acb_8173_e6414aaad122:
  SEP	#$20
  LDA	#$00
  __CMP_END_ba9217f0_c28f_4acb_8173_e6414aaad122:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e4d91fa9_a7a4_42fc_96ea_bc5864ed0d98
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_1c79e2e1_1f49_4d93_a8c6_11898b239aa6
  JMP	__ITER__END__e4d91fa9_a7a4_42fc_96ea_bc5864ed0d98
  __IFNOT_1c79e2e1_1f49_4d93_a8c6_11898b239aa6:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod32by16@start + 0
  ASL
  STA	__mod32by16@start + 0
  SEP	#$20
  LDA	__mod32by16@start + 2
  ROL
  STA	__mod32by16@start + 2
  JMP	__ITER__START__e4d91fa9_a7a4_42fc_96ea_bc5864ed0d98
  __ITER__END__e4d91fa9_a7a4_42fc_96ea_bc5864ed0d98:
  __ITER__START__24a8ffd6_64e2_41e2_87e9_5ce01a7eaa44:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod32by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod32by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__24a8ffd6_64e2_41e2_87e9_5ce01a7eaa44
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_67e412bc_8892_428e_b12e_6bfbd9abd0a2
  BNE	__CMP_YES_67e412bc_8892_428e_b12e_6bfbd9abd0a2
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_67e412bc_8892_428e_b12e_6bfbd9abd0a2
  BNE	__CMP_YES_67e412bc_8892_428e_b12e_6bfbd9abd0a2
  JMP	__CMP_YES_67e412bc_8892_428e_b12e_6bfbd9abd0a2
  __CMP_YES_67e412bc_8892_428e_b12e_6bfbd9abd0a2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_67e412bc_8892_428e_b12e_6bfbd9abd0a2
  __CMP_NO_67e412bc_8892_428e_b12e_6bfbd9abd0a2:
  SEP	#$20
  LDA	#$00
  __CMP_END_67e412bc_8892_428e_b12e_6bfbd9abd0a2:
  BEQ	__IFNOT_3a2c5ca1_521f_47ac_b985_f19260e09247
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@signExtend
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__mod32by16@ret + 0
  ADC	__mod32by16@start + 0
  STA	__mod32by16@ret + 0
  SEP	#$20
  LDA	__mod32by16@ret + 2
  ADC	__mod32by16@start + 2
  STA	__mod32by16@ret + 2
  __IFNOT_3a2c5ca1_521f_47ac_b985_f19260e09247:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod32by16@start + 1
  LSR
  STA	__mod32by16@start + 1
  SEP	#$20
  LDA	__mod32by16@start + 0
  ROR
  STA	__mod32by16@start + 0
  JMP	__ITER__START__24a8ffd6_64e2_41e2_87e9_5ce01a7eaa44
  __ITER__END__24a8ffd6_64e2_41e2_87e9_5ce01a7eaa44:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod32by16_END
____mod32by16_END:
RTL	; @endfunc
__mod64by16:	; @func
  __mod64by16@ret = __@callResult+0
  __mod64by16@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod64by16@ret + 0
  SEP	#$20
  STA	__mod64by16@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod64by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod64by16@start + 2
  __ITER__START__bb21c645_0c0b_4522_9408_1a9d507bcb44:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_0c8bbf01_c456_4085_8318_f444805719bc
  BNE	__CMP_YES_0c8bbf01_c456_4085_8318_f444805719bc
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_0c8bbf01_c456_4085_8318_f444805719bc
  BNE	__CMP_YES_0c8bbf01_c456_4085_8318_f444805719bc
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_0c8bbf01_c456_4085_8318_f444805719bc
  BNE	__CMP_YES_0c8bbf01_c456_4085_8318_f444805719bc
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0c8bbf01_c456_4085_8318_f444805719bc
  BNE	__CMP_YES_0c8bbf01_c456_4085_8318_f444805719bc
  JMP	__CMP_NO_0c8bbf01_c456_4085_8318_f444805719bc
  __CMP_YES_0c8bbf01_c456_4085_8318_f444805719bc:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0c8bbf01_c456_4085_8318_f444805719bc
  __CMP_NO_0c8bbf01_c456_4085_8318_f444805719bc:
  SEP	#$20
  LDA	#$00
  __CMP_END_0c8bbf01_c456_4085_8318_f444805719bc:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__bb21c645_0c0b_4522_9408_1a9d507bcb44
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_1573644c_ade5_4caa_81ca_840f58425e88
  JMP	__ITER__END__bb21c645_0c0b_4522_9408_1a9d507bcb44
  __IFNOT_1573644c_ade5_4caa_81ca_840f58425e88:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod64by16@start + 0
  ASL
  STA	__mod64by16@start + 0
  SEP	#$20
  LDA	__mod64by16@start + 2
  ROL
  STA	__mod64by16@start + 2
  JMP	__ITER__START__bb21c645_0c0b_4522_9408_1a9d507bcb44
  __ITER__END__bb21c645_0c0b_4522_9408_1a9d507bcb44:
  __ITER__START__d40ccb72_5217_4066_b398_4aa66f2d17af:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod64by16@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod64by16@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d40ccb72_5217_4066_b398_4aa66f2d17af
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_3cba1659_80b2_442e_9239_5f8224240cd2
  BNE	__CMP_YES_3cba1659_80b2_442e_9239_5f8224240cd2
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_3cba1659_80b2_442e_9239_5f8224240cd2
  BNE	__CMP_YES_3cba1659_80b2_442e_9239_5f8224240cd2
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_3cba1659_80b2_442e_9239_5f8224240cd2
  BNE	__CMP_YES_3cba1659_80b2_442e_9239_5f8224240cd2
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3cba1659_80b2_442e_9239_5f8224240cd2
  BNE	__CMP_YES_3cba1659_80b2_442e_9239_5f8224240cd2
  JMP	__CMP_YES_3cba1659_80b2_442e_9239_5f8224240cd2
  __CMP_YES_3cba1659_80b2_442e_9239_5f8224240cd2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3cba1659_80b2_442e_9239_5f8224240cd2
  __CMP_NO_3cba1659_80b2_442e_9239_5f8224240cd2:
  SEP	#$20
  LDA	#$00
  __CMP_END_3cba1659_80b2_442e_9239_5f8224240cd2:
  BEQ	__IFNOT_c1637c47_2fb3_44cb_9975_42a3ce8982c2
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@signExtend
  STA	__@specSubX + 2
  REP	#$20
  LDA	__@specSubX + 4
  SBC	__@signExtend
  STA	__@specSubX + 4
  REP	#$20
  LDA	__@specSubX + 6
  SBC	__@signExtend
  STA	__@specSubX + 6
  CLC
  REP	#$20
  LDA	__mod64by16@ret + 0
  ADC	__mod64by16@start + 0
  STA	__mod64by16@ret + 0
  SEP	#$20
  LDA	__mod64by16@ret + 2
  ADC	__mod64by16@start + 2
  STA	__mod64by16@ret + 2
  __IFNOT_c1637c47_2fb3_44cb_9975_42a3ce8982c2:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod64by16@start + 1
  LSR
  STA	__mod64by16@start + 1
  SEP	#$20
  LDA	__mod64by16@start + 0
  ROR
  STA	__mod64by16@start + 0
  JMP	__ITER__START__d40ccb72_5217_4066_b398_4aa66f2d17af
  __ITER__END__d40ccb72_5217_4066_b398_4aa66f2d17af:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  REP	#$20
  LDA	__@specSubX + 4
  STA	__@callResult + 4
  REP	#$20
  LDA	__@specSubX + 6
  STA	__@callResult + 6
  JMP	____mod64by16_END
____mod64by16_END:
RTL	; @endfunc
__mod8by24:	; @func
  __mod8by24@ret = __@callResult+0
  __mod8by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod8by24@ret + 0
  SEP	#$20
  STA	__mod8by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod8by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod8by24@start + 2
  __ITER__START__68017c2d_9c40_46d7_8ca9_612e8013f670:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_dc52ef58_a8c1_4622_ac83_57eb9434e070
  BNE	__CMP_YES_dc52ef58_a8c1_4622_ac83_57eb9434e070
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_dc52ef58_a8c1_4622_ac83_57eb9434e070
  BNE	__CMP_YES_dc52ef58_a8c1_4622_ac83_57eb9434e070
  JMP	__CMP_NO_dc52ef58_a8c1_4622_ac83_57eb9434e070
  __CMP_YES_dc52ef58_a8c1_4622_ac83_57eb9434e070:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_dc52ef58_a8c1_4622_ac83_57eb9434e070
  __CMP_NO_dc52ef58_a8c1_4622_ac83_57eb9434e070:
  SEP	#$20
  LDA	#$00
  __CMP_END_dc52ef58_a8c1_4622_ac83_57eb9434e070:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__68017c2d_9c40_46d7_8ca9_612e8013f670
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_2204bc94_b2b4_460e_a619_9fe7ba1bebe7
  JMP	__ITER__END__68017c2d_9c40_46d7_8ca9_612e8013f670
  __IFNOT_2204bc94_b2b4_460e_a619_9fe7ba1bebe7:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod8by24@start + 0
  ASL
  STA	__mod8by24@start + 0
  SEP	#$20
  LDA	__mod8by24@start + 2
  ROL
  STA	__mod8by24@start + 2
  JMP	__ITER__START__68017c2d_9c40_46d7_8ca9_612e8013f670
  __ITER__END__68017c2d_9c40_46d7_8ca9_612e8013f670:
  __ITER__START__d69e852b_0ac0_495b_83f6_8aad6afee8df:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod8by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod8by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d69e852b_0ac0_495b_83f6_8aad6afee8df
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f61b4d46_2048_4512_8efd_ecface00b6a5
  BNE	__CMP_YES_f61b4d46_2048_4512_8efd_ecface00b6a5
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f61b4d46_2048_4512_8efd_ecface00b6a5
  BNE	__CMP_YES_f61b4d46_2048_4512_8efd_ecface00b6a5
  JMP	__CMP_YES_f61b4d46_2048_4512_8efd_ecface00b6a5
  __CMP_YES_f61b4d46_2048_4512_8efd_ecface00b6a5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f61b4d46_2048_4512_8efd_ecface00b6a5
  __CMP_NO_f61b4d46_2048_4512_8efd_ecface00b6a5:
  SEP	#$20
  LDA	#$00
  __CMP_END_f61b4d46_2048_4512_8efd_ecface00b6a5:
  BEQ	__IFNOT_f2c8ac53_362d_4d94_8f4f_175ebd9ecfc4
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  SEP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__mod8by24@ret + 0
  ADC	__mod8by24@start + 0
  STA	__mod8by24@ret + 0
  SEP	#$20
  LDA	__mod8by24@ret + 2
  ADC	__mod8by24@start + 2
  STA	__mod8by24@ret + 2
  __IFNOT_f2c8ac53_362d_4d94_8f4f_175ebd9ecfc4:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod8by24@start + 1
  LSR
  STA	__mod8by24@start + 1
  SEP	#$20
  LDA	__mod8by24@start + 0
  ROR
  STA	__mod8by24@start + 0
  JMP	__ITER__START__d69e852b_0ac0_495b_83f6_8aad6afee8df
  __ITER__END__d69e852b_0ac0_495b_83f6_8aad6afee8df:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____mod8by24_END
____mod8by24_END:
RTL	; @endfunc
__mod16by24:	; @func
  __mod16by24@ret = __@callResult+0
  __mod16by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod16by24@ret + 0
  SEP	#$20
  STA	__mod16by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod16by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod16by24@start + 2
  __ITER__START__5ae26f53_358f_4ce2_adba_ee696df6496c:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_595c1178_0c8e_437e_a01b_1ca9c19bcc08
  BNE	__CMP_YES_595c1178_0c8e_437e_a01b_1ca9c19bcc08
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_595c1178_0c8e_437e_a01b_1ca9c19bcc08
  BNE	__CMP_YES_595c1178_0c8e_437e_a01b_1ca9c19bcc08
  JMP	__CMP_NO_595c1178_0c8e_437e_a01b_1ca9c19bcc08
  __CMP_YES_595c1178_0c8e_437e_a01b_1ca9c19bcc08:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_595c1178_0c8e_437e_a01b_1ca9c19bcc08
  __CMP_NO_595c1178_0c8e_437e_a01b_1ca9c19bcc08:
  SEP	#$20
  LDA	#$00
  __CMP_END_595c1178_0c8e_437e_a01b_1ca9c19bcc08:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5ae26f53_358f_4ce2_adba_ee696df6496c
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_acb63d05_69e5_4ad5_9b0b_3627540d68ef
  JMP	__ITER__END__5ae26f53_358f_4ce2_adba_ee696df6496c
  __IFNOT_acb63d05_69e5_4ad5_9b0b_3627540d68ef:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod16by24@start + 0
  ASL
  STA	__mod16by24@start + 0
  SEP	#$20
  LDA	__mod16by24@start + 2
  ROL
  STA	__mod16by24@start + 2
  JMP	__ITER__START__5ae26f53_358f_4ce2_adba_ee696df6496c
  __ITER__END__5ae26f53_358f_4ce2_adba_ee696df6496c:
  __ITER__START__dc2c3929_d9c0_4c69_b471_4968438e8af4:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod16by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod16by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__dc2c3929_d9c0_4c69_b471_4968438e8af4
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_1f4d15f2_9827_4288_895f_b8847eec7a76
  BNE	__CMP_YES_1f4d15f2_9827_4288_895f_b8847eec7a76
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1f4d15f2_9827_4288_895f_b8847eec7a76
  BNE	__CMP_YES_1f4d15f2_9827_4288_895f_b8847eec7a76
  JMP	__CMP_YES_1f4d15f2_9827_4288_895f_b8847eec7a76
  __CMP_YES_1f4d15f2_9827_4288_895f_b8847eec7a76:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1f4d15f2_9827_4288_895f_b8847eec7a76
  __CMP_NO_1f4d15f2_9827_4288_895f_b8847eec7a76:
  SEP	#$20
  LDA	#$00
  __CMP_END_1f4d15f2_9827_4288_895f_b8847eec7a76:
  BEQ	__IFNOT_e7d89487_fe0a_4a9a_b13c_ba928fbec6e4
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__mod16by24@ret + 0
  ADC	__mod16by24@start + 0
  STA	__mod16by24@ret + 0
  SEP	#$20
  LDA	__mod16by24@ret + 2
  ADC	__mod16by24@start + 2
  STA	__mod16by24@ret + 2
  __IFNOT_e7d89487_fe0a_4a9a_b13c_ba928fbec6e4:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod16by24@start + 1
  LSR
  STA	__mod16by24@start + 1
  SEP	#$20
  LDA	__mod16by24@start + 0
  ROR
  STA	__mod16by24@start + 0
  JMP	__ITER__START__dc2c3929_d9c0_4c69_b471_4968438e8af4
  __ITER__END__dc2c3929_d9c0_4c69_b471_4968438e8af4:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____mod16by24_END
____mod16by24_END:
RTL	; @endfunc
__mod24by24:	; @func
  __mod24by24@ret = __@callResult+0
  __mod24by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod24by24@ret + 0
  SEP	#$20
  STA	__mod24by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod24by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod24by24@start + 2
  __ITER__START__5795817d_c418_453c_9161_33516080e46a:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_276004d8_b899_40f6_855b_d6d5a11e4094
  BNE	__CMP_YES_276004d8_b899_40f6_855b_d6d5a11e4094
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_276004d8_b899_40f6_855b_d6d5a11e4094
  BNE	__CMP_YES_276004d8_b899_40f6_855b_d6d5a11e4094
  JMP	__CMP_NO_276004d8_b899_40f6_855b_d6d5a11e4094
  __CMP_YES_276004d8_b899_40f6_855b_d6d5a11e4094:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_276004d8_b899_40f6_855b_d6d5a11e4094
  __CMP_NO_276004d8_b899_40f6_855b_d6d5a11e4094:
  SEP	#$20
  LDA	#$00
  __CMP_END_276004d8_b899_40f6_855b_d6d5a11e4094:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5795817d_c418_453c_9161_33516080e46a
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_8c002642_94d3_4eb1_b93b_9d01cd3ef0c3
  JMP	__ITER__END__5795817d_c418_453c_9161_33516080e46a
  __IFNOT_8c002642_94d3_4eb1_b93b_9d01cd3ef0c3:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod24by24@start + 0
  ASL
  STA	__mod24by24@start + 0
  SEP	#$20
  LDA	__mod24by24@start + 2
  ROL
  STA	__mod24by24@start + 2
  JMP	__ITER__START__5795817d_c418_453c_9161_33516080e46a
  __ITER__END__5795817d_c418_453c_9161_33516080e46a:
  __ITER__START__67b1046b_a12f_4490_bef7_18857f02ae17:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod24by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod24by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__67b1046b_a12f_4490_bef7_18857f02ae17
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_335597ae_8f80_4e2f_a713_d747362ac577
  BNE	__CMP_YES_335597ae_8f80_4e2f_a713_d747362ac577
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_335597ae_8f80_4e2f_a713_d747362ac577
  BNE	__CMP_YES_335597ae_8f80_4e2f_a713_d747362ac577
  JMP	__CMP_YES_335597ae_8f80_4e2f_a713_d747362ac577
  __CMP_YES_335597ae_8f80_4e2f_a713_d747362ac577:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_335597ae_8f80_4e2f_a713_d747362ac577
  __CMP_NO_335597ae_8f80_4e2f_a713_d747362ac577:
  SEP	#$20
  LDA	#$00
  __CMP_END_335597ae_8f80_4e2f_a713_d747362ac577:
  BEQ	__IFNOT_aa3eebe7_5430_4b29_9ddf_05015047a2b5
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__mod24by24@ret + 0
  ADC	__mod24by24@start + 0
  STA	__mod24by24@ret + 0
  SEP	#$20
  LDA	__mod24by24@ret + 2
  ADC	__mod24by24@start + 2
  STA	__mod24by24@ret + 2
  __IFNOT_aa3eebe7_5430_4b29_9ddf_05015047a2b5:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod24by24@start + 1
  LSR
  STA	__mod24by24@start + 1
  SEP	#$20
  LDA	__mod24by24@start + 0
  ROR
  STA	__mod24by24@start + 0
  JMP	__ITER__START__67b1046b_a12f_4490_bef7_18857f02ae17
  __ITER__END__67b1046b_a12f_4490_bef7_18857f02ae17:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod24by24_END
____mod24by24_END:
RTL	; @endfunc
__mod32by24:	; @func
  __mod32by24@ret = __@callResult+0
  __mod32by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod32by24@ret + 0
  SEP	#$20
  STA	__mod32by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod32by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod32by24@start + 2
  __ITER__START__da61976c_01f7_472f_a3b9_05e266309257:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_8615b0c1_9ff3_4208_8b1a_e421f55b49a9
  BNE	__CMP_YES_8615b0c1_9ff3_4208_8b1a_e421f55b49a9
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8615b0c1_9ff3_4208_8b1a_e421f55b49a9
  BNE	__CMP_YES_8615b0c1_9ff3_4208_8b1a_e421f55b49a9
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8615b0c1_9ff3_4208_8b1a_e421f55b49a9
  BNE	__CMP_YES_8615b0c1_9ff3_4208_8b1a_e421f55b49a9
  JMP	__CMP_NO_8615b0c1_9ff3_4208_8b1a_e421f55b49a9
  __CMP_YES_8615b0c1_9ff3_4208_8b1a_e421f55b49a9:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8615b0c1_9ff3_4208_8b1a_e421f55b49a9
  __CMP_NO_8615b0c1_9ff3_4208_8b1a_e421f55b49a9:
  SEP	#$20
  LDA	#$00
  __CMP_END_8615b0c1_9ff3_4208_8b1a_e421f55b49a9:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__da61976c_01f7_472f_a3b9_05e266309257
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_a4628e68_f40f_4e96_94e0_35b1fca1f34c
  JMP	__ITER__END__da61976c_01f7_472f_a3b9_05e266309257
  __IFNOT_a4628e68_f40f_4e96_94e0_35b1fca1f34c:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod32by24@start + 0
  ASL
  STA	__mod32by24@start + 0
  SEP	#$20
  LDA	__mod32by24@start + 2
  ROL
  STA	__mod32by24@start + 2
  JMP	__ITER__START__da61976c_01f7_472f_a3b9_05e266309257
  __ITER__END__da61976c_01f7_472f_a3b9_05e266309257:
  __ITER__START__f4bf2374_f349_48a6_a867_4757bba4ee15:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod32by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod32by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f4bf2374_f349_48a6_a867_4757bba4ee15
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_0aac67d7_dc5f_4a5d_8802_81414b44ee21
  BNE	__CMP_YES_0aac67d7_dc5f_4a5d_8802_81414b44ee21
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_0aac67d7_dc5f_4a5d_8802_81414b44ee21
  BNE	__CMP_YES_0aac67d7_dc5f_4a5d_8802_81414b44ee21
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0aac67d7_dc5f_4a5d_8802_81414b44ee21
  BNE	__CMP_YES_0aac67d7_dc5f_4a5d_8802_81414b44ee21
  JMP	__CMP_YES_0aac67d7_dc5f_4a5d_8802_81414b44ee21
  __CMP_YES_0aac67d7_dc5f_4a5d_8802_81414b44ee21:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0aac67d7_dc5f_4a5d_8802_81414b44ee21
  __CMP_NO_0aac67d7_dc5f_4a5d_8802_81414b44ee21:
  SEP	#$20
  LDA	#$00
  __CMP_END_0aac67d7_dc5f_4a5d_8802_81414b44ee21:
  BEQ	__IFNOT_007d1953_4a5e_4b6f_98a3_70f862004b48
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  SEP	#$20
  LDA	__@specSubX + 3
  SBC	__@signExtend
  STA	__@specSubX + 3
  CLC
  REP	#$20
  LDA	__mod32by24@ret + 0
  ADC	__mod32by24@start + 0
  STA	__mod32by24@ret + 0
  SEP	#$20
  LDA	__mod32by24@ret + 2
  ADC	__mod32by24@start + 2
  STA	__mod32by24@ret + 2
  __IFNOT_007d1953_4a5e_4b6f_98a3_70f862004b48:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod32by24@start + 1
  LSR
  STA	__mod32by24@start + 1
  SEP	#$20
  LDA	__mod32by24@start + 0
  ROR
  STA	__mod32by24@start + 0
  JMP	__ITER__START__f4bf2374_f349_48a6_a867_4757bba4ee15
  __ITER__END__f4bf2374_f349_48a6_a867_4757bba4ee15:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod32by24_END
____mod32by24_END:
RTL	; @endfunc
__mod64by24:	; @func
  __mod64by24@ret = __@callResult+0
  __mod64by24@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod64by24@ret + 0
  SEP	#$20
  STA	__mod64by24@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod64by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod64by24@start + 2
  __ITER__START__b83261e5_6b9d_449f_97ac_22fce7fac311:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_2f83e896_a729_43bb_ad7c_03b32d4af24c
  BNE	__CMP_YES_2f83e896_a729_43bb_ad7c_03b32d4af24c
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_2f83e896_a729_43bb_ad7c_03b32d4af24c
  BNE	__CMP_YES_2f83e896_a729_43bb_ad7c_03b32d4af24c
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_2f83e896_a729_43bb_ad7c_03b32d4af24c
  BNE	__CMP_YES_2f83e896_a729_43bb_ad7c_03b32d4af24c
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2f83e896_a729_43bb_ad7c_03b32d4af24c
  BNE	__CMP_YES_2f83e896_a729_43bb_ad7c_03b32d4af24c
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2f83e896_a729_43bb_ad7c_03b32d4af24c
  BNE	__CMP_YES_2f83e896_a729_43bb_ad7c_03b32d4af24c
  JMP	__CMP_NO_2f83e896_a729_43bb_ad7c_03b32d4af24c
  __CMP_YES_2f83e896_a729_43bb_ad7c_03b32d4af24c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2f83e896_a729_43bb_ad7c_03b32d4af24c
  __CMP_NO_2f83e896_a729_43bb_ad7c_03b32d4af24c:
  SEP	#$20
  LDA	#$00
  __CMP_END_2f83e896_a729_43bb_ad7c_03b32d4af24c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b83261e5_6b9d_449f_97ac_22fce7fac311
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 2
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_a9cbb831_cc1b_4b69_bb83_5b4daccefc3e
  JMP	__ITER__END__b83261e5_6b9d_449f_97ac_22fce7fac311
  __IFNOT_a9cbb831_cc1b_4b69_bb83_5b4daccefc3e:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod64by24@start + 0
  ASL
  STA	__mod64by24@start + 0
  SEP	#$20
  LDA	__mod64by24@start + 2
  ROL
  STA	__mod64by24@start + 2
  JMP	__ITER__START__b83261e5_6b9d_449f_97ac_22fce7fac311
  __ITER__END__b83261e5_6b9d_449f_97ac_22fce7fac311:
  __ITER__START__a0135947_3dc8_46a3_9f27_2da0609f156d:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod64by24@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod64by24@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a0135947_3dc8_46a3_9f27_2da0609f156d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_f244e76a_ffcf_4eda_9607_68c774239201
  BNE	__CMP_YES_f244e76a_ffcf_4eda_9607_68c774239201
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_f244e76a_ffcf_4eda_9607_68c774239201
  BNE	__CMP_YES_f244e76a_ffcf_4eda_9607_68c774239201
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_f244e76a_ffcf_4eda_9607_68c774239201
  BNE	__CMP_YES_f244e76a_ffcf_4eda_9607_68c774239201
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f244e76a_ffcf_4eda_9607_68c774239201
  BNE	__CMP_YES_f244e76a_ffcf_4eda_9607_68c774239201
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f244e76a_ffcf_4eda_9607_68c774239201
  BNE	__CMP_YES_f244e76a_ffcf_4eda_9607_68c774239201
  JMP	__CMP_YES_f244e76a_ffcf_4eda_9607_68c774239201
  __CMP_YES_f244e76a_ffcf_4eda_9607_68c774239201:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f244e76a_ffcf_4eda_9607_68c774239201
  __CMP_NO_f244e76a_ffcf_4eda_9607_68c774239201:
  SEP	#$20
  LDA	#$00
  __CMP_END_f244e76a_ffcf_4eda_9607_68c774239201:
  BNE	:+
  JMP	__IFNOT_0041c9ed_aa54_4e7c_9e79_f513b3acdbac
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  REP	#$20
  LDA	__@specSubX + 3
  SBC	__@signExtend
  STA	__@specSubX + 3
  REP	#$20
  LDA	__@specSubX + 5
  SBC	__@signExtend
  STA	__@specSubX + 5
  SEP	#$20
  LDA	__@specSubX + 7
  SBC	__@signExtend
  STA	__@specSubX + 7
  CLC
  REP	#$20
  LDA	__mod64by24@ret + 0
  ADC	__mod64by24@start + 0
  STA	__mod64by24@ret + 0
  SEP	#$20
  LDA	__mod64by24@ret + 2
  ADC	__mod64by24@start + 2
  STA	__mod64by24@ret + 2
  __IFNOT_0041c9ed_aa54_4e7c_9e79_f513b3acdbac:
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod64by24@start + 1
  LSR
  STA	__mod64by24@start + 1
  SEP	#$20
  LDA	__mod64by24@start + 0
  ROR
  STA	__mod64by24@start + 0
  JMP	__ITER__START__a0135947_3dc8_46a3_9f27_2da0609f156d
  __ITER__END__a0135947_3dc8_46a3_9f27_2da0609f156d:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  REP	#$20
  LDA	__@specSubX + 4
  STA	__@callResult + 4
  REP	#$20
  LDA	__@specSubX + 6
  STA	__@callResult + 6
  JMP	____mod64by24_END
____mod64by24_END:
RTL	; @endfunc
__mod8by32:	; @func
  __mod8by32@ret = __@callResult+0
  __mod8by32@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod8by32@ret + 0
  SEP	#$20
  STA	__mod8by32@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod8by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod8by32@start + 2
  __ITER__START__581c5f17_949e_4d7f_a97a_d612e95b0334:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c
  BNE	__CMP_YES_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c
  BNE	__CMP_YES_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c
  BNE	__CMP_YES_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c
  JMP	__CMP_NO_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c
  __CMP_YES_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c
  __CMP_NO_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c:
  SEP	#$20
  LDA	#$00
  __CMP_END_9aa5d05b_3aa3_4a49_9fce_524c3fc2b46c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__581c5f17_949e_4d7f_a97a_d612e95b0334
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_27fdd00c_66ad_4ff7_8c54_6f54273ceb08
  JMP	__ITER__END__581c5f17_949e_4d7f_a97a_d612e95b0334
  __IFNOT_27fdd00c_66ad_4ff7_8c54_6f54273ceb08:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod8by32@start + 0
  ASL
  STA	__mod8by32@start + 0
  SEP	#$20
  LDA	__mod8by32@start + 2
  ROL
  STA	__mod8by32@start + 2
  JMP	__ITER__START__581c5f17_949e_4d7f_a97a_d612e95b0334
  __ITER__END__581c5f17_949e_4d7f_a97a_d612e95b0334:
  __ITER__START__8336e82a_ec7f_4ca2_b86c_75abefd45b29:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod8by32@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod8by32@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__8336e82a_ec7f_4ca2_b86c_75abefd45b29
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_19b3413f_302e_49ff_aaac_63f7f03b9b85
  BNE	__CMP_YES_19b3413f_302e_49ff_aaac_63f7f03b9b85
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_19b3413f_302e_49ff_aaac_63f7f03b9b85
  BNE	__CMP_YES_19b3413f_302e_49ff_aaac_63f7f03b9b85
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_19b3413f_302e_49ff_aaac_63f7f03b9b85
  BNE	__CMP_YES_19b3413f_302e_49ff_aaac_63f7f03b9b85
  JMP	__CMP_YES_19b3413f_302e_49ff_aaac_63f7f03b9b85
  __CMP_YES_19b3413f_302e_49ff_aaac_63f7f03b9b85:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_19b3413f_302e_49ff_aaac_63f7f03b9b85
  __CMP_NO_19b3413f_302e_49ff_aaac_63f7f03b9b85:
  SEP	#$20
  LDA	#$00
  __CMP_END_19b3413f_302e_49ff_aaac_63f7f03b9b85:
  BEQ	__IFNOT_d1842fce_f4b6_494f_9225_47a10ad1eb08
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  SEP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__mod8by32@ret + 0
  ADC	__mod8by32@start + 0
  STA	__mod8by32@ret + 0
  SEP	#$20
  LDA	__mod8by32@ret + 2
  ADC	__mod8by32@start + 2
  STA	__mod8by32@ret + 2
  __IFNOT_d1842fce_f4b6_494f_9225_47a10ad1eb08:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod8by32@start + 1
  LSR
  STA	__mod8by32@start + 1
  SEP	#$20
  LDA	__mod8by32@start + 0
  ROR
  STA	__mod8by32@start + 0
  JMP	__ITER__START__8336e82a_ec7f_4ca2_b86c_75abefd45b29
  __ITER__END__8336e82a_ec7f_4ca2_b86c_75abefd45b29:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____mod8by32_END
____mod8by32_END:
RTL	; @endfunc
__mod16by32:	; @func
  __mod16by32@ret = __@callResult+0
  __mod16by32@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod16by32@ret + 0
  SEP	#$20
  STA	__mod16by32@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod16by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod16by32@start + 2
  __ITER__START__c5776d01_b912_4623_8332_fac5cc345b5a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_16925c0d_c834_4918_967b_d86d3ff6edc1
  BNE	__CMP_YES_16925c0d_c834_4918_967b_d86d3ff6edc1
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_16925c0d_c834_4918_967b_d86d3ff6edc1
  BNE	__CMP_YES_16925c0d_c834_4918_967b_d86d3ff6edc1
  JMP	__CMP_NO_16925c0d_c834_4918_967b_d86d3ff6edc1
  __CMP_YES_16925c0d_c834_4918_967b_d86d3ff6edc1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_16925c0d_c834_4918_967b_d86d3ff6edc1
  __CMP_NO_16925c0d_c834_4918_967b_d86d3ff6edc1:
  SEP	#$20
  LDA	#$00
  __CMP_END_16925c0d_c834_4918_967b_d86d3ff6edc1:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__c5776d01_b912_4623_8332_fac5cc345b5a
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_a0811d6c_0a49_4391_80af_914648aa8662
  JMP	__ITER__END__c5776d01_b912_4623_8332_fac5cc345b5a
  __IFNOT_a0811d6c_0a49_4391_80af_914648aa8662:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod16by32@start + 0
  ASL
  STA	__mod16by32@start + 0
  SEP	#$20
  LDA	__mod16by32@start + 2
  ROL
  STA	__mod16by32@start + 2
  JMP	__ITER__START__c5776d01_b912_4623_8332_fac5cc345b5a
  __ITER__END__c5776d01_b912_4623_8332_fac5cc345b5a:
  __ITER__START__ec119a91_50ec_4c23_be1f_ad72aaaf1dc2:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod16by32@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod16by32@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__ec119a91_50ec_4c23_be1f_ad72aaaf1dc2
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_401c5014_45ca_45f4_bfad_ec23037e9d07
  BNE	__CMP_YES_401c5014_45ca_45f4_bfad_ec23037e9d07
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_401c5014_45ca_45f4_bfad_ec23037e9d07
  BNE	__CMP_YES_401c5014_45ca_45f4_bfad_ec23037e9d07
  JMP	__CMP_YES_401c5014_45ca_45f4_bfad_ec23037e9d07
  __CMP_YES_401c5014_45ca_45f4_bfad_ec23037e9d07:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_401c5014_45ca_45f4_bfad_ec23037e9d07
  __CMP_NO_401c5014_45ca_45f4_bfad_ec23037e9d07:
  SEP	#$20
  LDA	#$00
  __CMP_END_401c5014_45ca_45f4_bfad_ec23037e9d07:
  BEQ	__IFNOT_aa32004c_f6fa_49c7_8cb8_65b0e62e5bff
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__mod16by32@ret + 0
  ADC	__mod16by32@start + 0
  STA	__mod16by32@ret + 0
  SEP	#$20
  LDA	__mod16by32@ret + 2
  ADC	__mod16by32@start + 2
  STA	__mod16by32@ret + 2
  __IFNOT_aa32004c_f6fa_49c7_8cb8_65b0e62e5bff:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod16by32@start + 1
  LSR
  STA	__mod16by32@start + 1
  SEP	#$20
  LDA	__mod16by32@start + 0
  ROR
  STA	__mod16by32@start + 0
  JMP	__ITER__START__ec119a91_50ec_4c23_be1f_ad72aaaf1dc2
  __ITER__END__ec119a91_50ec_4c23_be1f_ad72aaaf1dc2:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____mod16by32_END
____mod16by32_END:
RTL	; @endfunc
__mod24by32:	; @func
  __mod24by32@ret = __@callResult+0
  __mod24by32@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod24by32@ret + 0
  SEP	#$20
  STA	__mod24by32@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod24by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod24by32@start + 2
  __ITER__START__8f3a64fa_ae76_433c_a39b_7c0e13f10403:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_f81a84fa_0262_4467_bbb1_a46e93602803
  BNE	__CMP_YES_f81a84fa_0262_4467_bbb1_a46e93602803
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f81a84fa_0262_4467_bbb1_a46e93602803
  BNE	__CMP_YES_f81a84fa_0262_4467_bbb1_a46e93602803
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f81a84fa_0262_4467_bbb1_a46e93602803
  BNE	__CMP_YES_f81a84fa_0262_4467_bbb1_a46e93602803
  JMP	__CMP_NO_f81a84fa_0262_4467_bbb1_a46e93602803
  __CMP_YES_f81a84fa_0262_4467_bbb1_a46e93602803:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f81a84fa_0262_4467_bbb1_a46e93602803
  __CMP_NO_f81a84fa_0262_4467_bbb1_a46e93602803:
  SEP	#$20
  LDA	#$00
  __CMP_END_f81a84fa_0262_4467_bbb1_a46e93602803:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__8f3a64fa_ae76_433c_a39b_7c0e13f10403
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_f257e27b_ac4f_443f_b877_e9ca32d4f46e
  JMP	__ITER__END__8f3a64fa_ae76_433c_a39b_7c0e13f10403
  __IFNOT_f257e27b_ac4f_443f_b877_e9ca32d4f46e:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod24by32@start + 0
  ASL
  STA	__mod24by32@start + 0
  SEP	#$20
  LDA	__mod24by32@start + 2
  ROL
  STA	__mod24by32@start + 2
  JMP	__ITER__START__8f3a64fa_ae76_433c_a39b_7c0e13f10403
  __ITER__END__8f3a64fa_ae76_433c_a39b_7c0e13f10403:
  __ITER__START__64645945_fbce_4b69_85f9_0b2d0a7e85fc:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod24by32@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod24by32@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__64645945_fbce_4b69_85f9_0b2d0a7e85fc
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_2b09d3d4_b7e7_4484_8ee9_1a31d9704661
  BNE	__CMP_YES_2b09d3d4_b7e7_4484_8ee9_1a31d9704661
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2b09d3d4_b7e7_4484_8ee9_1a31d9704661
  BNE	__CMP_YES_2b09d3d4_b7e7_4484_8ee9_1a31d9704661
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2b09d3d4_b7e7_4484_8ee9_1a31d9704661
  BNE	__CMP_YES_2b09d3d4_b7e7_4484_8ee9_1a31d9704661
  JMP	__CMP_YES_2b09d3d4_b7e7_4484_8ee9_1a31d9704661
  __CMP_YES_2b09d3d4_b7e7_4484_8ee9_1a31d9704661:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2b09d3d4_b7e7_4484_8ee9_1a31d9704661
  __CMP_NO_2b09d3d4_b7e7_4484_8ee9_1a31d9704661:
  SEP	#$20
  LDA	#$00
  __CMP_END_2b09d3d4_b7e7_4484_8ee9_1a31d9704661:
  BEQ	__IFNOT_30ab2ad6_0287_4840_a0f9_f4c4f568b224
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__mod24by32@ret + 0
  ADC	__mod24by32@start + 0
  STA	__mod24by32@ret + 0
  SEP	#$20
  LDA	__mod24by32@ret + 2
  ADC	__mod24by32@start + 2
  STA	__mod24by32@ret + 2
  __IFNOT_30ab2ad6_0287_4840_a0f9_f4c4f568b224:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod24by32@start + 1
  LSR
  STA	__mod24by32@start + 1
  SEP	#$20
  LDA	__mod24by32@start + 0
  ROR
  STA	__mod24by32@start + 0
  JMP	__ITER__START__64645945_fbce_4b69_85f9_0b2d0a7e85fc
  __ITER__END__64645945_fbce_4b69_85f9_0b2d0a7e85fc:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod24by32_END
____mod24by32_END:
RTL	; @endfunc
__mod32by32:	; @func
  __mod32by32@ret = __@callResult+0
  __mod32by32@start = __@callResult+4
  REP	#$20
  LDA	#$0000
  STA	__mod32by32@ret + 0
  STA	__mod32by32@ret + 2
  LDA	#$0001
  STA	__mod32by32@start + 0
  LDA	#$0000
  STA	__mod32by32@start + 2
  __ITER__START__4c46175c_737d_455f_9a3c_fb743bbd1bfc:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d4766970_2926_4f75_840b_1ff0aee0f4c0
  BNE	__CMP_YES_d4766970_2926_4f75_840b_1ff0aee0f4c0
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d4766970_2926_4f75_840b_1ff0aee0f4c0
  BNE	__CMP_YES_d4766970_2926_4f75_840b_1ff0aee0f4c0
  JMP	__CMP_NO_d4766970_2926_4f75_840b_1ff0aee0f4c0
  __CMP_YES_d4766970_2926_4f75_840b_1ff0aee0f4c0:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d4766970_2926_4f75_840b_1ff0aee0f4c0
  __CMP_NO_d4766970_2926_4f75_840b_1ff0aee0f4c0:
  SEP	#$20
  LDA	#$00
  __CMP_END_d4766970_2926_4f75_840b_1ff0aee0f4c0:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4c46175c_737d_455f_9a3c_fb743bbd1bfc
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_c62063cb_44f5_4cf9_a436_bb4e1f811456
  JMP	__ITER__END__4c46175c_737d_455f_9a3c_fb743bbd1bfc
  __IFNOT_c62063cb_44f5_4cf9_a436_bb4e1f811456:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod32by32@start + 0
  ASL
  STA	__mod32by32@start + 0
  REP	#$20
  LDA	__mod32by32@start + 2
  ROL
  STA	__mod32by32@start + 2
  JMP	__ITER__START__4c46175c_737d_455f_9a3c_fb743bbd1bfc
  __ITER__END__4c46175c_737d_455f_9a3c_fb743bbd1bfc:
  __ITER__START__b87d28ea_f137_44e5_9ae5_6ea8dea9e81d:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod32by32@start + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__mod32by32@start + 2
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b87d28ea_f137_44e5_9ae5_6ea8dea9e81d
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c9976893_4ac6_4398_a5bd_dba1e709fd78
  BNE	__CMP_YES_c9976893_4ac6_4398_a5bd_dba1e709fd78
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c9976893_4ac6_4398_a5bd_dba1e709fd78
  BNE	__CMP_YES_c9976893_4ac6_4398_a5bd_dba1e709fd78
  JMP	__CMP_YES_c9976893_4ac6_4398_a5bd_dba1e709fd78
  __CMP_YES_c9976893_4ac6_4398_a5bd_dba1e709fd78:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c9976893_4ac6_4398_a5bd_dba1e709fd78
  __CMP_NO_c9976893_4ac6_4398_a5bd_dba1e709fd78:
  SEP	#$20
  LDA	#$00
  __CMP_END_c9976893_4ac6_4398_a5bd_dba1e709fd78:
  BEQ	__IFNOT_bbfa6a6a_1182_4824_b9e1_d3d64f6e5288
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__mod32by32@ret + 0
  ADC	__mod32by32@start + 0
  STA	__mod32by32@ret + 0
  REP	#$20
  LDA	__mod32by32@ret + 2
  ADC	__mod32by32@start + 2
  STA	__mod32by32@ret + 2
  __IFNOT_bbfa6a6a_1182_4824_b9e1_d3d64f6e5288:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod32by32@start + 2
  LSR
  STA	__mod32by32@start + 2
  LDA	__mod32by32@start + 0
  ROR
  STA	__mod32by32@start + 0
  JMP	__ITER__START__b87d28ea_f137_44e5_9ae5_6ea8dea9e81d
  __ITER__END__b87d28ea_f137_44e5_9ae5_6ea8dea9e81d:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod32by32_END
____mod32by32_END:
RTL	; @endfunc
__mod64by32:	; @func
  __mod64by32@ret = __@callResult+0
  __mod64by32@start = __@callResult+4
  REP	#$20
  LDA	#$0000
  STA	__mod64by32@ret + 0
  STA	__mod64by32@ret + 2
  LDA	#$0001
  STA	__mod64by32@start + 0
  LDA	#$0000
  STA	__mod64by32@start + 2
  __ITER__START__5e5bce49_1493_4409_adac_ed34944b7ddc:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_a3747027_5cf7_4db2_acc4_0675e9140119
  BNE	__CMP_YES_a3747027_5cf7_4db2_acc4_0675e9140119
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_a3747027_5cf7_4db2_acc4_0675e9140119
  BNE	__CMP_YES_a3747027_5cf7_4db2_acc4_0675e9140119
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a3747027_5cf7_4db2_acc4_0675e9140119
  BNE	__CMP_YES_a3747027_5cf7_4db2_acc4_0675e9140119
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a3747027_5cf7_4db2_acc4_0675e9140119
  BNE	__CMP_YES_a3747027_5cf7_4db2_acc4_0675e9140119
  JMP	__CMP_NO_a3747027_5cf7_4db2_acc4_0675e9140119
  __CMP_YES_a3747027_5cf7_4db2_acc4_0675e9140119:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a3747027_5cf7_4db2_acc4_0675e9140119
  __CMP_NO_a3747027_5cf7_4db2_acc4_0675e9140119:
  SEP	#$20
  LDA	#$00
  __CMP_END_a3747027_5cf7_4db2_acc4_0675e9140119:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5e5bce49_1493_4409_adac_ed34944b7ddc
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_8bcdec08_e0a3_4cb7_8f0e_5939a36d7078
  JMP	__ITER__END__5e5bce49_1493_4409_adac_ed34944b7ddc
  __IFNOT_8bcdec08_e0a3_4cb7_8f0e_5939a36d7078:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__mod64by32@start + 0
  ASL
  STA	__mod64by32@start + 0
  REP	#$20
  LDA	__mod64by32@start + 2
  ROL
  STA	__mod64by32@start + 2
  JMP	__ITER__START__5e5bce49_1493_4409_adac_ed34944b7ddc
  __ITER__END__5e5bce49_1493_4409_adac_ed34944b7ddc:
  __ITER__START__d9ff6647_30f0_449b_bc54_26ff4ef06a8e:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod64by32@start + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__mod64by32@start + 2
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d9ff6647_30f0_449b_bc54_26ff4ef06a8e
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  BNE	__CMP_YES_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  BNE	__CMP_YES_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  BNE	__CMP_YES_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  BNE	__CMP_YES_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  JMP	__CMP_YES_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  __CMP_YES_6fce5297_1f1b_46b1_9f23_9a6d7be81746:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6fce5297_1f1b_46b1_9f23_9a6d7be81746
  __CMP_NO_6fce5297_1f1b_46b1_9f23_9a6d7be81746:
  SEP	#$20
  LDA	#$00
  __CMP_END_6fce5297_1f1b_46b1_9f23_9a6d7be81746:
  BEQ	__IFNOT_d7618b6e_17b7_4c9a_aff5_1c598298f34f
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  REP	#$20
  LDA	__@specSubX + 4
  SBC	__@signExtend
  STA	__@specSubX + 4
  REP	#$20
  LDA	__@specSubX + 6
  SBC	__@signExtend
  STA	__@specSubX + 6
  CLC
  REP	#$20
  LDA	__mod64by32@ret + 0
  ADC	__mod64by32@start + 0
  STA	__mod64by32@ret + 0
  REP	#$20
  LDA	__mod64by32@ret + 2
  ADC	__mod64by32@start + 2
  STA	__mod64by32@ret + 2
  __IFNOT_d7618b6e_17b7_4c9a_aff5_1c598298f34f:
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod64by32@start + 2
  LSR
  STA	__mod64by32@start + 2
  LDA	__mod64by32@start + 0
  ROR
  STA	__mod64by32@start + 0
  JMP	__ITER__START__d9ff6647_30f0_449b_bc54_26ff4ef06a8e
  __ITER__END__d9ff6647_30f0_449b_bc54_26ff4ef06a8e:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  REP	#$20
  LDA	__@specSubX + 4
  STA	__@callResult + 4
  REP	#$20
  LDA	__@specSubX + 6
  STA	__@callResult + 6
  JMP	____mod64by32_END
____mod64by32_END:
RTL	; @endfunc
__mod8by64:	; @func
  __mod8by64@ret = __@callResult+0
  __mod8by64@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod8by64@ret + 0
  SEP	#$20
  STA	__mod8by64@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod8by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod8by64@start + 2
  __ITER__START__6339776b_dc6b_41e9_a005_e74c5bc6e8ac:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_84471e3c_da4c_436f_9517_d76e7f4d07bf
  BNE	__CMP_YES_84471e3c_da4c_436f_9517_d76e7f4d07bf
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_84471e3c_da4c_436f_9517_d76e7f4d07bf
  BNE	__CMP_YES_84471e3c_da4c_436f_9517_d76e7f4d07bf
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_84471e3c_da4c_436f_9517_d76e7f4d07bf
  BNE	__CMP_YES_84471e3c_da4c_436f_9517_d76e7f4d07bf
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_84471e3c_da4c_436f_9517_d76e7f4d07bf
  BNE	__CMP_YES_84471e3c_da4c_436f_9517_d76e7f4d07bf
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_84471e3c_da4c_436f_9517_d76e7f4d07bf
  BNE	__CMP_YES_84471e3c_da4c_436f_9517_d76e7f4d07bf
  JMP	__CMP_NO_84471e3c_da4c_436f_9517_d76e7f4d07bf
  __CMP_YES_84471e3c_da4c_436f_9517_d76e7f4d07bf:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_84471e3c_da4c_436f_9517_d76e7f4d07bf
  __CMP_NO_84471e3c_da4c_436f_9517_d76e7f4d07bf:
  SEP	#$20
  LDA	#$00
  __CMP_END_84471e3c_da4c_436f_9517_d76e7f4d07bf:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6339776b_dc6b_41e9_a005_e74c5bc6e8ac
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_fdf0f264_7677_46d6_9c2a_8fc6bd4383cc
  JMP	__ITER__END__6339776b_dc6b_41e9_a005_e74c5bc6e8ac
  __IFNOT_fdf0f264_7677_46d6_9c2a_8fc6bd4383cc:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__mod8by64@start + 0
  ASL
  STA	__mod8by64@start + 0
  SEP	#$20
  LDA	__mod8by64@start + 2
  ROL
  STA	__mod8by64@start + 2
  JMP	__ITER__START__6339776b_dc6b_41e9_a005_e74c5bc6e8ac
  __ITER__END__6339776b_dc6b_41e9_a005_e74c5bc6e8ac:
  __ITER__START__15f77635_7706_437a_ad16_dc0982dc1f05:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod8by64@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod8by64@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__15f77635_7706_437a_ad16_dc0982dc1f05
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_26b59d82_482e_40ca_a6a2_82862e690a3d
  BNE	__CMP_YES_26b59d82_482e_40ca_a6a2_82862e690a3d
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_26b59d82_482e_40ca_a6a2_82862e690a3d
  BNE	__CMP_YES_26b59d82_482e_40ca_a6a2_82862e690a3d
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_26b59d82_482e_40ca_a6a2_82862e690a3d
  BNE	__CMP_YES_26b59d82_482e_40ca_a6a2_82862e690a3d
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_26b59d82_482e_40ca_a6a2_82862e690a3d
  BNE	__CMP_YES_26b59d82_482e_40ca_a6a2_82862e690a3d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_26b59d82_482e_40ca_a6a2_82862e690a3d
  BNE	__CMP_YES_26b59d82_482e_40ca_a6a2_82862e690a3d
  JMP	__CMP_YES_26b59d82_482e_40ca_a6a2_82862e690a3d
  __CMP_YES_26b59d82_482e_40ca_a6a2_82862e690a3d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_26b59d82_482e_40ca_a6a2_82862e690a3d
  __CMP_NO_26b59d82_482e_40ca_a6a2_82862e690a3d:
  SEP	#$20
  LDA	#$00
  __CMP_END_26b59d82_482e_40ca_a6a2_82862e690a3d:
  BEQ	__IFNOT_19b5b7c5_eecd_4c34_814d_a488f126c9d1
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  SEP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__mod8by64@ret + 0
  ADC	__mod8by64@start + 0
  STA	__mod8by64@ret + 0
  SEP	#$20
  LDA	__mod8by64@ret + 2
  ADC	__mod8by64@start + 2
  STA	__mod8by64@ret + 2
  __IFNOT_19b5b7c5_eecd_4c34_814d_a488f126c9d1:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod8by64@start + 1
  LSR
  STA	__mod8by64@start + 1
  SEP	#$20
  LDA	__mod8by64@start + 0
  ROR
  STA	__mod8by64@start + 0
  JMP	__ITER__START__15f77635_7706_437a_ad16_dc0982dc1f05
  __ITER__END__15f77635_7706_437a_ad16_dc0982dc1f05:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____mod8by64_END
____mod8by64_END:
RTL	; @endfunc
__mod16by64:	; @func
  __mod16by64@ret = __@callResult+0
  __mod16by64@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod16by64@ret + 0
  SEP	#$20
  STA	__mod16by64@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod16by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod16by64@start + 2
  __ITER__START__49f9b448_a83e_438d_adca_7465c6e39e2e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  BNE	__CMP_YES_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  BNE	__CMP_YES_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  BNE	__CMP_YES_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  BNE	__CMP_YES_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  JMP	__CMP_NO_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  __CMP_YES_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d
  __CMP_NO_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d:
  SEP	#$20
  LDA	#$00
  __CMP_END_86f91294_b68d_41b8_87bd_3d4cbd0a6d3d:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__49f9b448_a83e_438d_adca_7465c6e39e2e
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_75cefaf1_7740_4a2c_9581_cee2b44454c6
  JMP	__ITER__END__49f9b448_a83e_438d_adca_7465c6e39e2e
  __IFNOT_75cefaf1_7740_4a2c_9581_cee2b44454c6:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__mod16by64@start + 0
  ASL
  STA	__mod16by64@start + 0
  SEP	#$20
  LDA	__mod16by64@start + 2
  ROL
  STA	__mod16by64@start + 2
  JMP	__ITER__START__49f9b448_a83e_438d_adca_7465c6e39e2e
  __ITER__END__49f9b448_a83e_438d_adca_7465c6e39e2e:
  __ITER__START__db172fc1_5c21_4fee_a1df_b5e8554843e8:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod16by64@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod16by64@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__db172fc1_5c21_4fee_a1df_b5e8554843e8
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_a439e466_3492_4d1a_be33_b50f02976cc4
  BNE	__CMP_YES_a439e466_3492_4d1a_be33_b50f02976cc4
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_a439e466_3492_4d1a_be33_b50f02976cc4
  BNE	__CMP_YES_a439e466_3492_4d1a_be33_b50f02976cc4
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a439e466_3492_4d1a_be33_b50f02976cc4
  BNE	__CMP_YES_a439e466_3492_4d1a_be33_b50f02976cc4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a439e466_3492_4d1a_be33_b50f02976cc4
  BNE	__CMP_YES_a439e466_3492_4d1a_be33_b50f02976cc4
  JMP	__CMP_YES_a439e466_3492_4d1a_be33_b50f02976cc4
  __CMP_YES_a439e466_3492_4d1a_be33_b50f02976cc4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a439e466_3492_4d1a_be33_b50f02976cc4
  __CMP_NO_a439e466_3492_4d1a_be33_b50f02976cc4:
  SEP	#$20
  LDA	#$00
  __CMP_END_a439e466_3492_4d1a_be33_b50f02976cc4:
  BEQ	__IFNOT_18c2bbe6_a7e4_4b06_9da2_203995c4a7f5
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  LDA	__mod16by64@ret + 0
  ADC	__mod16by64@start + 0
  STA	__mod16by64@ret + 0
  SEP	#$20
  LDA	__mod16by64@ret + 2
  ADC	__mod16by64@start + 2
  STA	__mod16by64@ret + 2
  __IFNOT_18c2bbe6_a7e4_4b06_9da2_203995c4a7f5:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod16by64@start + 1
  LSR
  STA	__mod16by64@start + 1
  SEP	#$20
  LDA	__mod16by64@start + 0
  ROR
  STA	__mod16by64@start + 0
  JMP	__ITER__START__db172fc1_5c21_4fee_a1df_b5e8554843e8
  __ITER__END__db172fc1_5c21_4fee_a1df_b5e8554843e8:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@signExtend
  STA	__@signExtend
  JMP	____mod16by64_END
____mod16by64_END:
RTL	; @endfunc
__mod24by64:	; @func
  __mod24by64@ret = __@callResult+0
  __mod24by64@start = __@callResult+3
  REP	#$20
  LDA	#$0000
  STA	__mod24by64@ret + 0
  SEP	#$20
  STA	__mod24by64@ret + 2
  REP	#$20
  LDA	#$0001
  STA	__mod24by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod24by64@start + 2
  __ITER__START__29643e73_f092_4de7_8646_da4744a21004:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_24326e98_b91e_42fc_9778_83b3e5ed8f41
  BNE	__CMP_YES_24326e98_b91e_42fc_9778_83b3e5ed8f41
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_24326e98_b91e_42fc_9778_83b3e5ed8f41
  BNE	__CMP_YES_24326e98_b91e_42fc_9778_83b3e5ed8f41
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_24326e98_b91e_42fc_9778_83b3e5ed8f41
  BNE	__CMP_YES_24326e98_b91e_42fc_9778_83b3e5ed8f41
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_24326e98_b91e_42fc_9778_83b3e5ed8f41
  BNE	__CMP_YES_24326e98_b91e_42fc_9778_83b3e5ed8f41
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_24326e98_b91e_42fc_9778_83b3e5ed8f41
  BNE	__CMP_YES_24326e98_b91e_42fc_9778_83b3e5ed8f41
  JMP	__CMP_NO_24326e98_b91e_42fc_9778_83b3e5ed8f41
  __CMP_YES_24326e98_b91e_42fc_9778_83b3e5ed8f41:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_24326e98_b91e_42fc_9778_83b3e5ed8f41
  __CMP_NO_24326e98_b91e_42fc_9778_83b3e5ed8f41:
  SEP	#$20
  LDA	#$00
  __CMP_END_24326e98_b91e_42fc_9778_83b3e5ed8f41:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__29643e73_f092_4de7_8646_da4744a21004
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_f5186a86_cb42_45f8_8443_75822da2dbf9
  JMP	__ITER__END__29643e73_f092_4de7_8646_da4744a21004
  __IFNOT_f5186a86_cb42_45f8_8443_75822da2dbf9:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__mod24by64@start + 0
  ASL
  STA	__mod24by64@start + 0
  SEP	#$20
  LDA	__mod24by64@start + 2
  ROL
  STA	__mod24by64@start + 2
  JMP	__ITER__START__29643e73_f092_4de7_8646_da4744a21004
  __ITER__END__29643e73_f092_4de7_8646_da4744a21004:
  __ITER__START__f719242b_ccbf_484a_b65e_9e939550505d:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod24by64@start + 0
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__mod24by64@start + 2
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f719242b_ccbf_484a_b65e_9e939550505d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_483ef66d_2f55_4197_b4d0_78800e2afcf8
  BNE	__CMP_YES_483ef66d_2f55_4197_b4d0_78800e2afcf8
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_483ef66d_2f55_4197_b4d0_78800e2afcf8
  BNE	__CMP_YES_483ef66d_2f55_4197_b4d0_78800e2afcf8
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_483ef66d_2f55_4197_b4d0_78800e2afcf8
  BNE	__CMP_YES_483ef66d_2f55_4197_b4d0_78800e2afcf8
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_483ef66d_2f55_4197_b4d0_78800e2afcf8
  BNE	__CMP_YES_483ef66d_2f55_4197_b4d0_78800e2afcf8
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_483ef66d_2f55_4197_b4d0_78800e2afcf8
  BNE	__CMP_YES_483ef66d_2f55_4197_b4d0_78800e2afcf8
  JMP	__CMP_YES_483ef66d_2f55_4197_b4d0_78800e2afcf8
  __CMP_YES_483ef66d_2f55_4197_b4d0_78800e2afcf8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_483ef66d_2f55_4197_b4d0_78800e2afcf8
  __CMP_NO_483ef66d_2f55_4197_b4d0_78800e2afcf8:
  SEP	#$20
  LDA	#$00
  __CMP_END_483ef66d_2f55_4197_b4d0_78800e2afcf8:
  BEQ	__IFNOT_79f6eeb0_6487_460e_9d51_d30656e90d83
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__mod24by64@ret + 0
  ADC	__mod24by64@start + 0
  STA	__mod24by64@ret + 0
  SEP	#$20
  LDA	__mod24by64@ret + 2
  ADC	__mod24by64@start + 2
  STA	__mod24by64@ret + 2
  __IFNOT_79f6eeb0_6487_460e_9d51_d30656e90d83:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod24by64@start + 1
  LSR
  STA	__mod24by64@start + 1
  SEP	#$20
  LDA	__mod24by64@start + 0
  ROR
  STA	__mod24by64@start + 0
  JMP	__ITER__START__f719242b_ccbf_484a_b65e_9e939550505d
  __ITER__END__f719242b_ccbf_484a_b65e_9e939550505d:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod24by64_END
____mod24by64_END:
RTL	; @endfunc
__mod32by64:	; @func
  __mod32by64@ret = __@callResult+0
  __mod32by64@start = __@callResult+4
  REP	#$20
  LDA	#$0000
  STA	__mod32by64@ret + 0
  STA	__mod32by64@ret + 2
  LDA	#$0001
  STA	__mod32by64@start + 0
  LDA	#$0000
  STA	__mod32by64@start + 2
  __ITER__START__40f659b4_3d3a_40e8_91de_89a208c5e152:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_f9c89975_9cf3_4495_b715_064abbda1663
  BNE	__CMP_YES_f9c89975_9cf3_4495_b715_064abbda1663
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_f9c89975_9cf3_4495_b715_064abbda1663
  BNE	__CMP_YES_f9c89975_9cf3_4495_b715_064abbda1663
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f9c89975_9cf3_4495_b715_064abbda1663
  BNE	__CMP_YES_f9c89975_9cf3_4495_b715_064abbda1663
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f9c89975_9cf3_4495_b715_064abbda1663
  BNE	__CMP_YES_f9c89975_9cf3_4495_b715_064abbda1663
  JMP	__CMP_NO_f9c89975_9cf3_4495_b715_064abbda1663
  __CMP_YES_f9c89975_9cf3_4495_b715_064abbda1663:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f9c89975_9cf3_4495_b715_064abbda1663
  __CMP_NO_f9c89975_9cf3_4495_b715_064abbda1663:
  SEP	#$20
  LDA	#$00
  __CMP_END_f9c89975_9cf3_4495_b715_064abbda1663:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__40f659b4_3d3a_40e8_91de_89a208c5e152
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_685e437b_4e5a_4f55_9191_4d201d551332
  JMP	__ITER__END__40f659b4_3d3a_40e8_91de_89a208c5e152
  __IFNOT_685e437b_4e5a_4f55_9191_4d201d551332:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__mod32by64@start + 0
  ASL
  STA	__mod32by64@start + 0
  REP	#$20
  LDA	__mod32by64@start + 2
  ROL
  STA	__mod32by64@start + 2
  JMP	__ITER__START__40f659b4_3d3a_40e8_91de_89a208c5e152
  __ITER__END__40f659b4_3d3a_40e8_91de_89a208c5e152:
  __ITER__START__ae1e9a35_d986_47f0_baa1_cb41e32d7310:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod32by64@start + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__mod32by64@start + 2
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__ae1e9a35_d986_47f0_baa1_cb41e32d7310
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  BNE	__CMP_YES_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  BNE	__CMP_YES_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  BNE	__CMP_YES_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  BNE	__CMP_YES_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  JMP	__CMP_YES_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  __CMP_YES_f879fc7f_aea3_48c8_a100_9187ff7e1e4d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f879fc7f_aea3_48c8_a100_9187ff7e1e4d
  __CMP_NO_f879fc7f_aea3_48c8_a100_9187ff7e1e4d:
  SEP	#$20
  LDA	#$00
  __CMP_END_f879fc7f_aea3_48c8_a100_9187ff7e1e4d:
  BEQ	__IFNOT_a00184e3_9a6e_4048_b1fd_4de59611dd45
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  CLC
  REP	#$20
  LDA	__mod32by64@ret + 0
  ADC	__mod32by64@start + 0
  STA	__mod32by64@ret + 0
  REP	#$20
  LDA	__mod32by64@ret + 2
  ADC	__mod32by64@start + 2
  STA	__mod32by64@ret + 2
  __IFNOT_a00184e3_9a6e_4048_b1fd_4de59611dd45:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod32by64@start + 2
  LSR
  STA	__mod32by64@start + 2
  LDA	__mod32by64@start + 0
  ROR
  STA	__mod32by64@start + 0
  JMP	__ITER__START__ae1e9a35_d986_47f0_baa1_cb41e32d7310
  __ITER__END__ae1e9a35_d986_47f0_baa1_cb41e32d7310:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod32by64_END
____mod32by64_END:
RTL	; @endfunc
__mod64by64:	; @func
  __mod64by64@ret = __@callResult+0
  __mod64by64@start = __@callResult+8
  REP	#$20
  LDA	#$0000
  STA	__mod64by64@ret + 0
  STA	__mod64by64@ret + 2
  STA	__mod64by64@ret + 4
  STA	__mod64by64@ret + 6
  LDA	#$0001
  STA	__mod64by64@start + 0
  LDA	#$0000
  STA	__mod64by64@start + 2
  STA	__mod64by64@start + 4
  STA	__mod64by64@start + 6
  __ITER__START__6aecae19_2abd_4b56_8d6e_e1830d364fd6:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_08676c51_01fb_4d92_9298_29d9e6449583
  BNE	__CMP_YES_08676c51_01fb_4d92_9298_29d9e6449583
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_08676c51_01fb_4d92_9298_29d9e6449583
  BNE	__CMP_YES_08676c51_01fb_4d92_9298_29d9e6449583
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_08676c51_01fb_4d92_9298_29d9e6449583
  BNE	__CMP_YES_08676c51_01fb_4d92_9298_29d9e6449583
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_08676c51_01fb_4d92_9298_29d9e6449583
  BNE	__CMP_YES_08676c51_01fb_4d92_9298_29d9e6449583
  JMP	__CMP_NO_08676c51_01fb_4d92_9298_29d9e6449583
  __CMP_YES_08676c51_01fb_4d92_9298_29d9e6449583:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_08676c51_01fb_4d92_9298_29d9e6449583
  __CMP_NO_08676c51_01fb_4d92_9298_29d9e6449583:
  SEP	#$20
  LDA	#$00
  __CMP_END_08676c51_01fb_4d92_9298_29d9e6449583:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6aecae19_2abd_4b56_8d6e_e1830d364fd6
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 6
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_4a40bf16_ce8a_4179_a5cd_7fac7e8241d7
  JMP	__ITER__END__6aecae19_2abd_4b56_8d6e_e1830d364fd6
  __IFNOT_4a40bf16_ce8a_4179_a5cd_7fac7e8241d7:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 4
  ROL
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 6
  ROL
  STA	__@specSubY + 6
  REP	#$20
  LDA	__mod64by64@start + 0
  ASL
  STA	__mod64by64@start + 0
  REP	#$20
  LDA	__mod64by64@start + 2
  ROL
  STA	__mod64by64@start + 2
  REP	#$20
  LDA	__mod64by64@start + 4
  ROL
  STA	__mod64by64@start + 4
  REP	#$20
  LDA	__mod64by64@start + 6
  ROL
  STA	__mod64by64@start + 6
  JMP	__ITER__START__6aecae19_2abd_4b56_8d6e_e1830d364fd6
  __ITER__END__6aecae19_2abd_4b56_8d6e_e1830d364fd6:
  __ITER__START__9284b788_3904_480d_8ed9_04bc027db489:
  SEP	#$10
  LDX	#$01
  REP	#$20
  LDA	__mod64by64@start + 0
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__mod64by64@start + 2
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__mod64by64@start + 4
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__mod64by64@start + 6
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9284b788_3904_480d_8ed9_04bc027db489
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  BNE	__CMP_YES_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  BNE	__CMP_YES_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  BNE	__CMP_YES_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  BNE	__CMP_YES_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  JMP	__CMP_YES_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  __CMP_YES_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052
  __CMP_NO_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052:
  SEP	#$20
  LDA	#$00
  __CMP_END_f6a4c0d7_68f2_49ca_bccf_ad25c04c9052:
  BNE	:+
  JMP	__IFNOT_e8039f77_fa75_4e56_a48f_41efa164c861
  :
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  REP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  REP	#$20
  LDA	__@specSubX + 4
  SBC	__@specSubY + 4
  STA	__@specSubX + 4
  REP	#$20
  LDA	__@specSubX + 6
  SBC	__@specSubY + 6
  STA	__@specSubX + 6
  CLC
  REP	#$20
  LDA	__mod64by64@ret + 0
  ADC	__mod64by64@start + 0
  STA	__mod64by64@ret + 0
  REP	#$20
  LDA	__mod64by64@ret + 2
  ADC	__mod64by64@start + 2
  STA	__mod64by64@ret + 2
  REP	#$20
  LDA	__mod64by64@ret + 4
  ADC	__mod64by64@start + 4
  STA	__mod64by64@ret + 4
  REP	#$20
  LDA	__mod64by64@ret + 6
  ADC	__mod64by64@start + 6
  STA	__mod64by64@ret + 6
  __IFNOT_e8039f77_fa75_4e56_a48f_41efa164c861:
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  LDA	__mod64by64@start + 6
  LSR
  STA	__mod64by64@start + 6
  LDA	__mod64by64@start + 4
  ROR
  STA	__mod64by64@start + 4
  LDA	__mod64by64@start + 2
  ROR
  STA	__mod64by64@start + 2
  LDA	__mod64by64@start + 0
  ROR
  STA	__mod64by64@start + 0
  JMP	__ITER__START__9284b788_3904_480d_8ed9_04bc027db489
  __ITER__END__9284b788_3904_480d_8ed9_04bc027db489:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  REP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  REP	#$20
  LDA	__@specSubX + 4
  STA	__@callResult + 4
  REP	#$20
  LDA	__@specSubX + 6
  STA	__@callResult + 6
  JMP	____mod64by64_END
____mod64by64_END:
RTL	; @endfunc
