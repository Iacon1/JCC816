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
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 2
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 3
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 4
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 5
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 6
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 4
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 5
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 6
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
  CLC
  ADC	__@callResult + 7
  STA	__@callResult + 7
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  CLC
  ADC	__@signExtend
  STA	__@signExtend
  LDA	__REG@RDMPYH
  TAX
  LDA	__@signExtend
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
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 1
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 2
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 3
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 4
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 5
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 6
  LDA	__REG@RDMPYH
  TAX
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@callResult + 7
  SEP	#$20
  LDA	__@specSubX + 1
  STA	__REG@WRMPYA
  LDA	__@specSubY + 1
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
  LDA	__@specSubY + 1
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__REG@WRMPYA
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 2
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  STA	__REG@WRMPYA
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 3
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 4
  STA	__REG@WRMPYA
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 4
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 5
  STA	__REG@WRMPYA
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 5
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 6
  STA	__REG@WRMPYA
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  LDA	__@specSubY + 6
  STA	__REG@WRMPYB
  NOP
  TXA
  ADC	f:__REG@RDMPYL
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 7
  STA	__REG@WRMPYA
  LDA	__@specSubY + 7
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	f:__REG@RDMPYL
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
  __ITER__START__c8220a6c_968c_4268_9bae_7c5a02e53748:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_5be212db_0aa7_46e0_8a81_038fc381a3d5
  BNE	__CMP_YES_5be212db_0aa7_46e0_8a81_038fc381a3d5
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5be212db_0aa7_46e0_8a81_038fc381a3d5
  BNE	__CMP_YES_5be212db_0aa7_46e0_8a81_038fc381a3d5
  JMP	__CMP_NO_5be212db_0aa7_46e0_8a81_038fc381a3d5
  __CMP_YES_5be212db_0aa7_46e0_8a81_038fc381a3d5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5be212db_0aa7_46e0_8a81_038fc381a3d5
  __CMP_NO_5be212db_0aa7_46e0_8a81_038fc381a3d5:
  SEP	#$20
  LDA	#$00
  __CMP_END_5be212db_0aa7_46e0_8a81_038fc381a3d5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__c8220a6c_968c_4268_9bae_7c5a02e53748
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_0ba5a7c2_4e9e_4201_ba7e_2a33f459365d
  JMP	__ITER__END__c8220a6c_968c_4268_9bae_7c5a02e53748
  __IFNOT_0ba5a7c2_4e9e_4201_ba7e_2a33f459365d:
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
  JMP	__ITER__START__c8220a6c_968c_4268_9bae_7c5a02e53748
  __ITER__END__c8220a6c_968c_4268_9bae_7c5a02e53748:
  __ITER__START__fb0e3bdb_9141_4a4d_837b_860a833e4ba6:
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
  JMP	__ITER__END__fb0e3bdb_9141_4a4d_837b_860a833e4ba6
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d0d0f123_6afb_4048_a5f7_0dc591d08269
  BNE	__CMP_YES_d0d0f123_6afb_4048_a5f7_0dc591d08269
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d0d0f123_6afb_4048_a5f7_0dc591d08269
  BNE	__CMP_YES_d0d0f123_6afb_4048_a5f7_0dc591d08269
  JMP	__CMP_YES_d0d0f123_6afb_4048_a5f7_0dc591d08269
  __CMP_YES_d0d0f123_6afb_4048_a5f7_0dc591d08269:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d0d0f123_6afb_4048_a5f7_0dc591d08269
  __CMP_NO_d0d0f123_6afb_4048_a5f7_0dc591d08269:
  SEP	#$20
  LDA	#$00
  __CMP_END_d0d0f123_6afb_4048_a5f7_0dc591d08269:
  BEQ	__IFNOT_19c9786d_a5f3_423a_a49b_66c7b69fe174
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
  __IFNOT_19c9786d_a5f3_423a_a49b_66c7b69fe174:
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
  JMP	__ITER__START__fb0e3bdb_9141_4a4d_837b_860a833e4ba6
  __ITER__END__fb0e3bdb_9141_4a4d_837b_860a833e4ba6:
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
  __ITER__START__1684e3e1_a9f6_4e16_a911_8f5e9ce335ce:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_fc8b7476_b205_4c31_b5ac_ea7dbcd1c1d9
  BNE	__CMP_YES_fc8b7476_b205_4c31_b5ac_ea7dbcd1c1d9
  JMP	__CMP_NO_fc8b7476_b205_4c31_b5ac_ea7dbcd1c1d9
  __CMP_YES_fc8b7476_b205_4c31_b5ac_ea7dbcd1c1d9:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_fc8b7476_b205_4c31_b5ac_ea7dbcd1c1d9
  __CMP_NO_fc8b7476_b205_4c31_b5ac_ea7dbcd1c1d9:
  SEP	#$20
  LDA	#$00
  __CMP_END_fc8b7476_b205_4c31_b5ac_ea7dbcd1c1d9:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1684e3e1_a9f6_4e16_a911_8f5e9ce335ce
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_6813bd8b_0170_4853_bd84_77ddd90a7784
  JMP	__ITER__END__1684e3e1_a9f6_4e16_a911_8f5e9ce335ce
  __IFNOT_6813bd8b_0170_4853_bd84_77ddd90a7784:
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
  JMP	__ITER__START__1684e3e1_a9f6_4e16_a911_8f5e9ce335ce
  __ITER__END__1684e3e1_a9f6_4e16_a911_8f5e9ce335ce:
  __ITER__START__9db63f84_7602_40e7_98b9_c73cca494a1a:
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
  JMP	__ITER__END__9db63f84_7602_40e7_98b9_c73cca494a1a
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_17d38197_1efa_41e2_9c3b_4448dea657aa
  BNE	__CMP_YES_17d38197_1efa_41e2_9c3b_4448dea657aa
  JMP	__CMP_YES_17d38197_1efa_41e2_9c3b_4448dea657aa
  __CMP_YES_17d38197_1efa_41e2_9c3b_4448dea657aa:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_17d38197_1efa_41e2_9c3b_4448dea657aa
  __CMP_NO_17d38197_1efa_41e2_9c3b_4448dea657aa:
  SEP	#$20
  LDA	#$00
  __CMP_END_17d38197_1efa_41e2_9c3b_4448dea657aa:
  BEQ	__IFNOT_0d75aadf_4f75_4e83_a40a_2b973ad80b02
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
  __IFNOT_0d75aadf_4f75_4e83_a40a_2b973ad80b02:
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
  JMP	__ITER__START__9db63f84_7602_40e7_98b9_c73cca494a1a
  __ITER__END__9db63f84_7602_40e7_98b9_c73cca494a1a:
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
  __ITER__START__9b427433_e2a7_4bb7_ae6f_05840221e68f:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_7cfc854b_8149_45e4_b293_3ff7c88c9594
  BNE	__CMP_YES_7cfc854b_8149_45e4_b293_3ff7c88c9594
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7cfc854b_8149_45e4_b293_3ff7c88c9594
  BNE	__CMP_YES_7cfc854b_8149_45e4_b293_3ff7c88c9594
  JMP	__CMP_NO_7cfc854b_8149_45e4_b293_3ff7c88c9594
  __CMP_YES_7cfc854b_8149_45e4_b293_3ff7c88c9594:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7cfc854b_8149_45e4_b293_3ff7c88c9594
  __CMP_NO_7cfc854b_8149_45e4_b293_3ff7c88c9594:
  SEP	#$20
  LDA	#$00
  __CMP_END_7cfc854b_8149_45e4_b293_3ff7c88c9594:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9b427433_e2a7_4bb7_ae6f_05840221e68f
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_f541f734_5ad1_4c92_ac82_54f5263cd1de
  JMP	__ITER__END__9b427433_e2a7_4bb7_ae6f_05840221e68f
  __IFNOT_f541f734_5ad1_4c92_ac82_54f5263cd1de:
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
  JMP	__ITER__START__9b427433_e2a7_4bb7_ae6f_05840221e68f
  __ITER__END__9b427433_e2a7_4bb7_ae6f_05840221e68f:
  __ITER__START__17d14e1e_8552_4eff_aca1_65e6a5b852f3:
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
  JMP	__ITER__END__17d14e1e_8552_4eff_aca1_65e6a5b852f3
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_f5535aff_0572_4b98_b2e2_eaeede5aa663
  BNE	__CMP_YES_f5535aff_0572_4b98_b2e2_eaeede5aa663
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f5535aff_0572_4b98_b2e2_eaeede5aa663
  BNE	__CMP_YES_f5535aff_0572_4b98_b2e2_eaeede5aa663
  JMP	__CMP_YES_f5535aff_0572_4b98_b2e2_eaeede5aa663
  __CMP_YES_f5535aff_0572_4b98_b2e2_eaeede5aa663:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f5535aff_0572_4b98_b2e2_eaeede5aa663
  __CMP_NO_f5535aff_0572_4b98_b2e2_eaeede5aa663:
  SEP	#$20
  LDA	#$00
  __CMP_END_f5535aff_0572_4b98_b2e2_eaeede5aa663:
  BEQ	__IFNOT_796c9dbf_b23b_4e93_bb38_657a478f0fca
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
  __IFNOT_796c9dbf_b23b_4e93_bb38_657a478f0fca:
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
  JMP	__ITER__START__17d14e1e_8552_4eff_aca1_65e6a5b852f3
  __ITER__END__17d14e1e_8552_4eff_aca1_65e6a5b852f3:
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
  __ITER__START__570711fb_b010_484e_ab94_7d6b3fa4a19a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_883d2c5d_2115_4e02_8caa_cdfe75df7f02
  BNE	__CMP_YES_883d2c5d_2115_4e02_8caa_cdfe75df7f02
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_883d2c5d_2115_4e02_8caa_cdfe75df7f02
  BNE	__CMP_YES_883d2c5d_2115_4e02_8caa_cdfe75df7f02
  JMP	__CMP_NO_883d2c5d_2115_4e02_8caa_cdfe75df7f02
  __CMP_YES_883d2c5d_2115_4e02_8caa_cdfe75df7f02:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_883d2c5d_2115_4e02_8caa_cdfe75df7f02
  __CMP_NO_883d2c5d_2115_4e02_8caa_cdfe75df7f02:
  SEP	#$20
  LDA	#$00
  __CMP_END_883d2c5d_2115_4e02_8caa_cdfe75df7f02:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__570711fb_b010_484e_ab94_7d6b3fa4a19a
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_6d60c0e2_ea0b_45e3_85e8_27496fca05cf
  JMP	__ITER__END__570711fb_b010_484e_ab94_7d6b3fa4a19a
  __IFNOT_6d60c0e2_ea0b_45e3_85e8_27496fca05cf:
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
  JMP	__ITER__START__570711fb_b010_484e_ab94_7d6b3fa4a19a
  __ITER__END__570711fb_b010_484e_ab94_7d6b3fa4a19a:
  __ITER__START__897a710e_e277_4cb7_9c99_fd7b5a569604:
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
  JMP	__ITER__END__897a710e_e277_4cb7_9c99_fd7b5a569604
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_1b1da8b8_6939_40a6_af3b_d86ecc460809
  BNE	__CMP_YES_1b1da8b8_6939_40a6_af3b_d86ecc460809
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1b1da8b8_6939_40a6_af3b_d86ecc460809
  BNE	__CMP_YES_1b1da8b8_6939_40a6_af3b_d86ecc460809
  JMP	__CMP_YES_1b1da8b8_6939_40a6_af3b_d86ecc460809
  __CMP_YES_1b1da8b8_6939_40a6_af3b_d86ecc460809:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1b1da8b8_6939_40a6_af3b_d86ecc460809
  __CMP_NO_1b1da8b8_6939_40a6_af3b_d86ecc460809:
  SEP	#$20
  LDA	#$00
  __CMP_END_1b1da8b8_6939_40a6_af3b_d86ecc460809:
  BEQ	__IFNOT_1aa83bdc_378d_4d60_b8bb_e6fda531f0b4
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
  __IFNOT_1aa83bdc_378d_4d60_b8bb_e6fda531f0b4:
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
  JMP	__ITER__START__897a710e_e277_4cb7_9c99_fd7b5a569604
  __ITER__END__897a710e_e277_4cb7_9c99_fd7b5a569604:
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
  __ITER__START__0fe1083f_2349_4057_a177_da8c94bccb78:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  BNE	__CMP_YES_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  BNE	__CMP_YES_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  BNE	__CMP_YES_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  BNE	__CMP_YES_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  JMP	__CMP_NO_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  __CMP_YES_6e9dadf6_3db1_45f4_9c0c_0745644243f7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6e9dadf6_3db1_45f4_9c0c_0745644243f7
  __CMP_NO_6e9dadf6_3db1_45f4_9c0c_0745644243f7:
  SEP	#$20
  LDA	#$00
  __CMP_END_6e9dadf6_3db1_45f4_9c0c_0745644243f7:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__0fe1083f_2349_4057_a177_da8c94bccb78
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_34b2362f_7ec2_4283_b8fc_8018d15ac460
  JMP	__ITER__END__0fe1083f_2349_4057_a177_da8c94bccb78
  __IFNOT_34b2362f_7ec2_4283_b8fc_8018d15ac460:
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
  JMP	__ITER__START__0fe1083f_2349_4057_a177_da8c94bccb78
  __ITER__END__0fe1083f_2349_4057_a177_da8c94bccb78:
  __ITER__START__35bff097_b235_4590_8caa_b92e19c2ec37:
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
  JMP	__ITER__END__35bff097_b235_4590_8caa_b92e19c2ec37
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  BNE	__CMP_YES_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  BNE	__CMP_YES_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  BNE	__CMP_YES_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  BNE	__CMP_YES_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  JMP	__CMP_YES_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  __CMP_YES_a3a6ec86_9fb0_489c_8db1_555c7e550a34:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a3a6ec86_9fb0_489c_8db1_555c7e550a34
  __CMP_NO_a3a6ec86_9fb0_489c_8db1_555c7e550a34:
  SEP	#$20
  LDA	#$00
  __CMP_END_a3a6ec86_9fb0_489c_8db1_555c7e550a34:
  BEQ	__IFNOT_3f5b28bd_deef_430c_a6ab_d4161067cb3d
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
  __IFNOT_3f5b28bd_deef_430c_a6ab_d4161067cb3d:
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
  JMP	__ITER__START__35bff097_b235_4590_8caa_b92e19c2ec37
  __ITER__END__35bff097_b235_4590_8caa_b92e19c2ec37:
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
  __ITER__START__75146d50_0f3c_4bff_8fd5_928fee35d28d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_067ea1f5_76f4_4f1c_8970_17d2a266163f
  BNE	__CMP_YES_067ea1f5_76f4_4f1c_8970_17d2a266163f
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_067ea1f5_76f4_4f1c_8970_17d2a266163f
  BNE	__CMP_YES_067ea1f5_76f4_4f1c_8970_17d2a266163f
  JMP	__CMP_NO_067ea1f5_76f4_4f1c_8970_17d2a266163f
  __CMP_YES_067ea1f5_76f4_4f1c_8970_17d2a266163f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_067ea1f5_76f4_4f1c_8970_17d2a266163f
  __CMP_NO_067ea1f5_76f4_4f1c_8970_17d2a266163f:
  SEP	#$20
  LDA	#$00
  __CMP_END_067ea1f5_76f4_4f1c_8970_17d2a266163f:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__75146d50_0f3c_4bff_8fd5_928fee35d28d
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_61ccf676_8fa6_4071_93d3_cc2c3cce7e6e
  JMP	__ITER__END__75146d50_0f3c_4bff_8fd5_928fee35d28d
  __IFNOT_61ccf676_8fa6_4071_93d3_cc2c3cce7e6e:
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
  JMP	__ITER__START__75146d50_0f3c_4bff_8fd5_928fee35d28d
  __ITER__END__75146d50_0f3c_4bff_8fd5_928fee35d28d:
  __ITER__START__c99384ef_e973_45cd_b4d9_17737fc6079f:
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
  JMP	__ITER__END__c99384ef_e973_45cd_b4d9_17737fc6079f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_02156bcc_2b49_43b4_bfd5_4ef9daca00f6
  BNE	__CMP_YES_02156bcc_2b49_43b4_bfd5_4ef9daca00f6
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_02156bcc_2b49_43b4_bfd5_4ef9daca00f6
  BNE	__CMP_YES_02156bcc_2b49_43b4_bfd5_4ef9daca00f6
  JMP	__CMP_YES_02156bcc_2b49_43b4_bfd5_4ef9daca00f6
  __CMP_YES_02156bcc_2b49_43b4_bfd5_4ef9daca00f6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_02156bcc_2b49_43b4_bfd5_4ef9daca00f6
  __CMP_NO_02156bcc_2b49_43b4_bfd5_4ef9daca00f6:
  SEP	#$20
  LDA	#$00
  __CMP_END_02156bcc_2b49_43b4_bfd5_4ef9daca00f6:
  BEQ	__IFNOT_b0def376_15ad_4d8b_afdc_4b58b48a9e8b
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
  __IFNOT_b0def376_15ad_4d8b_afdc_4b58b48a9e8b:
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
  JMP	__ITER__START__c99384ef_e973_45cd_b4d9_17737fc6079f
  __ITER__END__c99384ef_e973_45cd_b4d9_17737fc6079f:
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
  __ITER__START__bda3eb28_a703_4932_be55_d550e7acdc1d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_24e85033_cd7f_454e_8e2b_f7e1b76f12f7
  BNE	__CMP_YES_24e85033_cd7f_454e_8e2b_f7e1b76f12f7
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_24e85033_cd7f_454e_8e2b_f7e1b76f12f7
  BNE	__CMP_YES_24e85033_cd7f_454e_8e2b_f7e1b76f12f7
  JMP	__CMP_NO_24e85033_cd7f_454e_8e2b_f7e1b76f12f7
  __CMP_YES_24e85033_cd7f_454e_8e2b_f7e1b76f12f7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_24e85033_cd7f_454e_8e2b_f7e1b76f12f7
  __CMP_NO_24e85033_cd7f_454e_8e2b_f7e1b76f12f7:
  SEP	#$20
  LDA	#$00
  __CMP_END_24e85033_cd7f_454e_8e2b_f7e1b76f12f7:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__bda3eb28_a703_4932_be55_d550e7acdc1d
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_c3ea3829_60d3_433c_a6a2_7665d79677d7
  JMP	__ITER__END__bda3eb28_a703_4932_be55_d550e7acdc1d
  __IFNOT_c3ea3829_60d3_433c_a6a2_7665d79677d7:
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
  JMP	__ITER__START__bda3eb28_a703_4932_be55_d550e7acdc1d
  __ITER__END__bda3eb28_a703_4932_be55_d550e7acdc1d:
  __ITER__START__17588adb_fda0_4df1_a1bf_931616ea054d:
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
  JMP	__ITER__END__17588adb_fda0_4df1_a1bf_931616ea054d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a00b370b_cfe7_4bf2_a9b4_6eb568487c45
  BNE	__CMP_YES_a00b370b_cfe7_4bf2_a9b4_6eb568487c45
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a00b370b_cfe7_4bf2_a9b4_6eb568487c45
  BNE	__CMP_YES_a00b370b_cfe7_4bf2_a9b4_6eb568487c45
  JMP	__CMP_YES_a00b370b_cfe7_4bf2_a9b4_6eb568487c45
  __CMP_YES_a00b370b_cfe7_4bf2_a9b4_6eb568487c45:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a00b370b_cfe7_4bf2_a9b4_6eb568487c45
  __CMP_NO_a00b370b_cfe7_4bf2_a9b4_6eb568487c45:
  SEP	#$20
  LDA	#$00
  __CMP_END_a00b370b_cfe7_4bf2_a9b4_6eb568487c45:
  BEQ	__IFNOT_e20299db_2782_4175_8446_794b7165ce7c
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
  __IFNOT_e20299db_2782_4175_8446_794b7165ce7c:
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
  JMP	__ITER__START__17588adb_fda0_4df1_a1bf_931616ea054d
  __ITER__END__17588adb_fda0_4df1_a1bf_931616ea054d:
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
  __ITER__START__7e2e8b08_386d_43a7_8518_cd076ed3c7a3:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7
  BNE	__CMP_YES_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7
  BNE	__CMP_YES_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7
  JMP	__CMP_NO_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7
  __CMP_YES_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7
  __CMP_NO_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7:
  SEP	#$20
  LDA	#$00
  __CMP_END_96e4ddd5_3697_4eb3_a4ca_94044a31c1e7:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7e2e8b08_386d_43a7_8518_cd076ed3c7a3
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_749b5b34_32f7_4c6e_88c7_e8802a8bf3e0
  JMP	__ITER__END__7e2e8b08_386d_43a7_8518_cd076ed3c7a3
  __IFNOT_749b5b34_32f7_4c6e_88c7_e8802a8bf3e0:
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
  JMP	__ITER__START__7e2e8b08_386d_43a7_8518_cd076ed3c7a3
  __ITER__END__7e2e8b08_386d_43a7_8518_cd076ed3c7a3:
  __ITER__START__f583574f_1bc6_4ba8_a294_73ae670ebda8:
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
  JMP	__ITER__END__f583574f_1bc6_4ba8_a294_73ae670ebda8
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c3116aec_6c8a_478f_9523_07bf6e833057
  BNE	__CMP_YES_c3116aec_6c8a_478f_9523_07bf6e833057
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c3116aec_6c8a_478f_9523_07bf6e833057
  BNE	__CMP_YES_c3116aec_6c8a_478f_9523_07bf6e833057
  JMP	__CMP_YES_c3116aec_6c8a_478f_9523_07bf6e833057
  __CMP_YES_c3116aec_6c8a_478f_9523_07bf6e833057:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c3116aec_6c8a_478f_9523_07bf6e833057
  __CMP_NO_c3116aec_6c8a_478f_9523_07bf6e833057:
  SEP	#$20
  LDA	#$00
  __CMP_END_c3116aec_6c8a_478f_9523_07bf6e833057:
  BEQ	__IFNOT_675a0ec3_d891_4fdb_9f94_b53534168294
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
  __IFNOT_675a0ec3_d891_4fdb_9f94_b53534168294:
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
  JMP	__ITER__START__f583574f_1bc6_4ba8_a294_73ae670ebda8
  __ITER__END__f583574f_1bc6_4ba8_a294_73ae670ebda8:
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
  __ITER__START__b98f94b3_5b34_44d2_acfa_495327881ff5:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_7bc97959_cdff_428e_8e5e_180b50ffeb3a
  BNE	__CMP_YES_7bc97959_cdff_428e_8e5e_180b50ffeb3a
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_7bc97959_cdff_428e_8e5e_180b50ffeb3a
  BNE	__CMP_YES_7bc97959_cdff_428e_8e5e_180b50ffeb3a
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7bc97959_cdff_428e_8e5e_180b50ffeb3a
  BNE	__CMP_YES_7bc97959_cdff_428e_8e5e_180b50ffeb3a
  JMP	__CMP_NO_7bc97959_cdff_428e_8e5e_180b50ffeb3a
  __CMP_YES_7bc97959_cdff_428e_8e5e_180b50ffeb3a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7bc97959_cdff_428e_8e5e_180b50ffeb3a
  __CMP_NO_7bc97959_cdff_428e_8e5e_180b50ffeb3a:
  SEP	#$20
  LDA	#$00
  __CMP_END_7bc97959_cdff_428e_8e5e_180b50ffeb3a:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b98f94b3_5b34_44d2_acfa_495327881ff5
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_bb2e6b48_b63c_4b49_bdd5_b8d5ff7786f0
  JMP	__ITER__END__b98f94b3_5b34_44d2_acfa_495327881ff5
  __IFNOT_bb2e6b48_b63c_4b49_bdd5_b8d5ff7786f0:
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
  JMP	__ITER__START__b98f94b3_5b34_44d2_acfa_495327881ff5
  __ITER__END__b98f94b3_5b34_44d2_acfa_495327881ff5:
  __ITER__START__1bccde5e_83ee_4207_b3e0_14b4394afbda:
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
  JMP	__ITER__END__1bccde5e_83ee_4207_b3e0_14b4394afbda
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_e472f77e_7874_4e0a_a614_b5ccc06be8ee
  BNE	__CMP_YES_e472f77e_7874_4e0a_a614_b5ccc06be8ee
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e472f77e_7874_4e0a_a614_b5ccc06be8ee
  BNE	__CMP_YES_e472f77e_7874_4e0a_a614_b5ccc06be8ee
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e472f77e_7874_4e0a_a614_b5ccc06be8ee
  BNE	__CMP_YES_e472f77e_7874_4e0a_a614_b5ccc06be8ee
  JMP	__CMP_YES_e472f77e_7874_4e0a_a614_b5ccc06be8ee
  __CMP_YES_e472f77e_7874_4e0a_a614_b5ccc06be8ee:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e472f77e_7874_4e0a_a614_b5ccc06be8ee
  __CMP_NO_e472f77e_7874_4e0a_a614_b5ccc06be8ee:
  SEP	#$20
  LDA	#$00
  __CMP_END_e472f77e_7874_4e0a_a614_b5ccc06be8ee:
  BEQ	__IFNOT_69558d23_2729_4663_b012_d1ac05c3aef4
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
  __IFNOT_69558d23_2729_4663_b012_d1ac05c3aef4:
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
  JMP	__ITER__START__1bccde5e_83ee_4207_b3e0_14b4394afbda
  __ITER__END__1bccde5e_83ee_4207_b3e0_14b4394afbda:
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
  __ITER__START__76f406a6_2ba4_4f58_ad13_4b928d6ee028:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  BNE	__CMP_YES_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  BNE	__CMP_YES_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  BNE	__CMP_YES_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  BNE	__CMP_YES_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  BNE	__CMP_YES_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  JMP	__CMP_NO_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  __CMP_YES_b0cbd9bb_aa10_4106_b77c_1a49f1103bba:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b0cbd9bb_aa10_4106_b77c_1a49f1103bba
  __CMP_NO_b0cbd9bb_aa10_4106_b77c_1a49f1103bba:
  SEP	#$20
  LDA	#$00
  __CMP_END_b0cbd9bb_aa10_4106_b77c_1a49f1103bba:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__76f406a6_2ba4_4f58_ad13_4b928d6ee028
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_f894317a_ff2b_4790_a9a4_953bc6d572b4
  JMP	__ITER__END__76f406a6_2ba4_4f58_ad13_4b928d6ee028
  __IFNOT_f894317a_ff2b_4790_a9a4_953bc6d572b4:
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
  JMP	__ITER__START__76f406a6_2ba4_4f58_ad13_4b928d6ee028
  __ITER__END__76f406a6_2ba4_4f58_ad13_4b928d6ee028:
  __ITER__START__6ede0b41_df3e_40c3_af0e_82dd10448e07:
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
  JMP	__ITER__END__6ede0b41_df3e_40c3_af0e_82dd10448e07
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_6333736e_7c4c_4d28_a4be_25a8498530b9
  BNE	__CMP_YES_6333736e_7c4c_4d28_a4be_25a8498530b9
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_6333736e_7c4c_4d28_a4be_25a8498530b9
  BNE	__CMP_YES_6333736e_7c4c_4d28_a4be_25a8498530b9
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_6333736e_7c4c_4d28_a4be_25a8498530b9
  BNE	__CMP_YES_6333736e_7c4c_4d28_a4be_25a8498530b9
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_6333736e_7c4c_4d28_a4be_25a8498530b9
  BNE	__CMP_YES_6333736e_7c4c_4d28_a4be_25a8498530b9
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6333736e_7c4c_4d28_a4be_25a8498530b9
  BNE	__CMP_YES_6333736e_7c4c_4d28_a4be_25a8498530b9
  JMP	__CMP_YES_6333736e_7c4c_4d28_a4be_25a8498530b9
  __CMP_YES_6333736e_7c4c_4d28_a4be_25a8498530b9:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6333736e_7c4c_4d28_a4be_25a8498530b9
  __CMP_NO_6333736e_7c4c_4d28_a4be_25a8498530b9:
  SEP	#$20
  LDA	#$00
  __CMP_END_6333736e_7c4c_4d28_a4be_25a8498530b9:
  BNE	:+
  JMP	__IFNOT_c31a4e69_af94_4a56_98ae_6d8b224e7e6a
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
  __IFNOT_c31a4e69_af94_4a56_98ae_6d8b224e7e6a:
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
  JMP	__ITER__START__6ede0b41_df3e_40c3_af0e_82dd10448e07
  __ITER__END__6ede0b41_df3e_40c3_af0e_82dd10448e07:
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
  __ITER__START__982b374d_6273_4370_a343_231237127100:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d3c5fd8d_9bed_402d_b084_4f31f99fa836
  BNE	__CMP_YES_d3c5fd8d_9bed_402d_b084_4f31f99fa836
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d3c5fd8d_9bed_402d_b084_4f31f99fa836
  BNE	__CMP_YES_d3c5fd8d_9bed_402d_b084_4f31f99fa836
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d3c5fd8d_9bed_402d_b084_4f31f99fa836
  BNE	__CMP_YES_d3c5fd8d_9bed_402d_b084_4f31f99fa836
  JMP	__CMP_NO_d3c5fd8d_9bed_402d_b084_4f31f99fa836
  __CMP_YES_d3c5fd8d_9bed_402d_b084_4f31f99fa836:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d3c5fd8d_9bed_402d_b084_4f31f99fa836
  __CMP_NO_d3c5fd8d_9bed_402d_b084_4f31f99fa836:
  SEP	#$20
  LDA	#$00
  __CMP_END_d3c5fd8d_9bed_402d_b084_4f31f99fa836:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__982b374d_6273_4370_a343_231237127100
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_4e1bdd38_713f_462c_922e_a7d93e77e226
  JMP	__ITER__END__982b374d_6273_4370_a343_231237127100
  __IFNOT_4e1bdd38_713f_462c_922e_a7d93e77e226:
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
  JMP	__ITER__START__982b374d_6273_4370_a343_231237127100
  __ITER__END__982b374d_6273_4370_a343_231237127100:
  __ITER__START__d8bc8c62_8fe0_4d47_9d55_4c7a69a607ca:
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
  JMP	__ITER__END__d8bc8c62_8fe0_4d47_9d55_4c7a69a607ca
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd
  BNE	__CMP_YES_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd
  BNE	__CMP_YES_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd
  BNE	__CMP_YES_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd
  JMP	__CMP_YES_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd
  __CMP_YES_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd
  __CMP_NO_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd:
  SEP	#$20
  LDA	#$00
  __CMP_END_7dba237f_fe9c_4ba3_a2d3_7763e1ebecbd:
  BEQ	__IFNOT_b4a36b16_a9bc_49bc_88dc_d5cc65779ab4
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
  __IFNOT_b4a36b16_a9bc_49bc_88dc_d5cc65779ab4:
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
  JMP	__ITER__START__d8bc8c62_8fe0_4d47_9d55_4c7a69a607ca
  __ITER__END__d8bc8c62_8fe0_4d47_9d55_4c7a69a607ca:
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
  __ITER__START__409a444f_273d_45c4_aee8_c5edd054e944:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c5efdd98_8969_4a0e_8ec1_c6f5c6587695
  BNE	__CMP_YES_c5efdd98_8969_4a0e_8ec1_c6f5c6587695
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c5efdd98_8969_4a0e_8ec1_c6f5c6587695
  BNE	__CMP_YES_c5efdd98_8969_4a0e_8ec1_c6f5c6587695
  JMP	__CMP_NO_c5efdd98_8969_4a0e_8ec1_c6f5c6587695
  __CMP_YES_c5efdd98_8969_4a0e_8ec1_c6f5c6587695:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c5efdd98_8969_4a0e_8ec1_c6f5c6587695
  __CMP_NO_c5efdd98_8969_4a0e_8ec1_c6f5c6587695:
  SEP	#$20
  LDA	#$00
  __CMP_END_c5efdd98_8969_4a0e_8ec1_c6f5c6587695:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__409a444f_273d_45c4_aee8_c5edd054e944
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_f3e7941a_076f_4041_a72f_e8889e5938df
  JMP	__ITER__END__409a444f_273d_45c4_aee8_c5edd054e944
  __IFNOT_f3e7941a_076f_4041_a72f_e8889e5938df:
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
  JMP	__ITER__START__409a444f_273d_45c4_aee8_c5edd054e944
  __ITER__END__409a444f_273d_45c4_aee8_c5edd054e944:
  __ITER__START__11768456_e88a_4478_924a_8051d9212fc1:
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
  JMP	__ITER__END__11768456_e88a_4478_924a_8051d9212fc1
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_0c82cc65_1690_460a_987d_372c49e4da03
  BNE	__CMP_YES_0c82cc65_1690_460a_987d_372c49e4da03
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0c82cc65_1690_460a_987d_372c49e4da03
  BNE	__CMP_YES_0c82cc65_1690_460a_987d_372c49e4da03
  JMP	__CMP_YES_0c82cc65_1690_460a_987d_372c49e4da03
  __CMP_YES_0c82cc65_1690_460a_987d_372c49e4da03:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0c82cc65_1690_460a_987d_372c49e4da03
  __CMP_NO_0c82cc65_1690_460a_987d_372c49e4da03:
  SEP	#$20
  LDA	#$00
  __CMP_END_0c82cc65_1690_460a_987d_372c49e4da03:
  BEQ	__IFNOT_5176f3ab_0152_4f3f_ae7e_e1bd752e4704
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
  __IFNOT_5176f3ab_0152_4f3f_ae7e_e1bd752e4704:
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
  JMP	__ITER__START__11768456_e88a_4478_924a_8051d9212fc1
  __ITER__END__11768456_e88a_4478_924a_8051d9212fc1:
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
  __ITER__START__851c36d2_d5db_4724_accc_0498ca1c694e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7
  BNE	__CMP_YES_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7
  BNE	__CMP_YES_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7
  BNE	__CMP_YES_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7
  JMP	__CMP_NO_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7
  __CMP_YES_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7
  __CMP_NO_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7:
  SEP	#$20
  LDA	#$00
  __CMP_END_c94b2fe0_1aa2_460e_ada1_0919e8fc6bf7:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__851c36d2_d5db_4724_accc_0498ca1c694e
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_a764f368_0143_4911_b82b_a8592c99600d
  JMP	__ITER__END__851c36d2_d5db_4724_accc_0498ca1c694e
  __IFNOT_a764f368_0143_4911_b82b_a8592c99600d:
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
  JMP	__ITER__START__851c36d2_d5db_4724_accc_0498ca1c694e
  __ITER__END__851c36d2_d5db_4724_accc_0498ca1c694e:
  __ITER__START__6df9e0cf_f277_4ebf_9c8d_708a6e55ffa9:
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
  JMP	__ITER__END__6df9e0cf_f277_4ebf_9c8d_708a6e55ffa9
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_f1c4d847_7d50_45e4_8ce2_93244939497b
  BNE	__CMP_YES_f1c4d847_7d50_45e4_8ce2_93244939497b
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f1c4d847_7d50_45e4_8ce2_93244939497b
  BNE	__CMP_YES_f1c4d847_7d50_45e4_8ce2_93244939497b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f1c4d847_7d50_45e4_8ce2_93244939497b
  BNE	__CMP_YES_f1c4d847_7d50_45e4_8ce2_93244939497b
  JMP	__CMP_YES_f1c4d847_7d50_45e4_8ce2_93244939497b
  __CMP_YES_f1c4d847_7d50_45e4_8ce2_93244939497b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f1c4d847_7d50_45e4_8ce2_93244939497b
  __CMP_NO_f1c4d847_7d50_45e4_8ce2_93244939497b:
  SEP	#$20
  LDA	#$00
  __CMP_END_f1c4d847_7d50_45e4_8ce2_93244939497b:
  BEQ	__IFNOT_a79bd06c_9445_4d77_9738_274cb7d1cc63
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
  __IFNOT_a79bd06c_9445_4d77_9738_274cb7d1cc63:
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
  JMP	__ITER__START__6df9e0cf_f277_4ebf_9c8d_708a6e55ffa9
  __ITER__END__6df9e0cf_f277_4ebf_9c8d_708a6e55ffa9:
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
  __ITER__START__d7079aed_eebc_4c0e_a011_7cfc22804ca0:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_aff6b586_d719_4f9a_801c_4e400195b36b
  BNE	__CMP_YES_aff6b586_d719_4f9a_801c_4e400195b36b
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_aff6b586_d719_4f9a_801c_4e400195b36b
  BNE	__CMP_YES_aff6b586_d719_4f9a_801c_4e400195b36b
  JMP	__CMP_NO_aff6b586_d719_4f9a_801c_4e400195b36b
  __CMP_YES_aff6b586_d719_4f9a_801c_4e400195b36b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_aff6b586_d719_4f9a_801c_4e400195b36b
  __CMP_NO_aff6b586_d719_4f9a_801c_4e400195b36b:
  SEP	#$20
  LDA	#$00
  __CMP_END_aff6b586_d719_4f9a_801c_4e400195b36b:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d7079aed_eebc_4c0e_a011_7cfc22804ca0
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_77a1d5ba_fa10_4463_9d92_c0fb7ac252ef
  JMP	__ITER__END__d7079aed_eebc_4c0e_a011_7cfc22804ca0
  __IFNOT_77a1d5ba_fa10_4463_9d92_c0fb7ac252ef:
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
  JMP	__ITER__START__d7079aed_eebc_4c0e_a011_7cfc22804ca0
  __ITER__END__d7079aed_eebc_4c0e_a011_7cfc22804ca0:
  __ITER__START__64dad75e_f05c_4cc1_a29a_0f14f5bbdfb5:
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
  JMP	__ITER__END__64dad75e_f05c_4cc1_a29a_0f14f5bbdfb5
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7c3a9277_64d5_4816_af26_094c193c5d80
  BNE	__CMP_YES_7c3a9277_64d5_4816_af26_094c193c5d80
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7c3a9277_64d5_4816_af26_094c193c5d80
  BNE	__CMP_YES_7c3a9277_64d5_4816_af26_094c193c5d80
  JMP	__CMP_YES_7c3a9277_64d5_4816_af26_094c193c5d80
  __CMP_YES_7c3a9277_64d5_4816_af26_094c193c5d80:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7c3a9277_64d5_4816_af26_094c193c5d80
  __CMP_NO_7c3a9277_64d5_4816_af26_094c193c5d80:
  SEP	#$20
  LDA	#$00
  __CMP_END_7c3a9277_64d5_4816_af26_094c193c5d80:
  BEQ	__IFNOT_58fb465d_5393_49b9_a489_431d4c8df806
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
  __IFNOT_58fb465d_5393_49b9_a489_431d4c8df806:
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
  JMP	__ITER__START__64dad75e_f05c_4cc1_a29a_0f14f5bbdfb5
  __ITER__END__64dad75e_f05c_4cc1_a29a_0f14f5bbdfb5:
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
  __ITER__START__31096882_b781_46a1_a675_88b15cdaa035:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_46da6bcb_a7e4_4831_8a15_3934344c99fd
  BNE	__CMP_YES_46da6bcb_a7e4_4831_8a15_3934344c99fd
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_46da6bcb_a7e4_4831_8a15_3934344c99fd
  BNE	__CMP_YES_46da6bcb_a7e4_4831_8a15_3934344c99fd
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_46da6bcb_a7e4_4831_8a15_3934344c99fd
  BNE	__CMP_YES_46da6bcb_a7e4_4831_8a15_3934344c99fd
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_46da6bcb_a7e4_4831_8a15_3934344c99fd
  BNE	__CMP_YES_46da6bcb_a7e4_4831_8a15_3934344c99fd
  JMP	__CMP_NO_46da6bcb_a7e4_4831_8a15_3934344c99fd
  __CMP_YES_46da6bcb_a7e4_4831_8a15_3934344c99fd:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_46da6bcb_a7e4_4831_8a15_3934344c99fd
  __CMP_NO_46da6bcb_a7e4_4831_8a15_3934344c99fd:
  SEP	#$20
  LDA	#$00
  __CMP_END_46da6bcb_a7e4_4831_8a15_3934344c99fd:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__31096882_b781_46a1_a675_88b15cdaa035
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_568b84dc_8bd7_4779_820f_9bd975a1b0d6
  JMP	__ITER__END__31096882_b781_46a1_a675_88b15cdaa035
  __IFNOT_568b84dc_8bd7_4779_820f_9bd975a1b0d6:
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
  JMP	__ITER__START__31096882_b781_46a1_a675_88b15cdaa035
  __ITER__END__31096882_b781_46a1_a675_88b15cdaa035:
  __ITER__START__29001e6f_0b52_4e6e_92aa_4b3f3ba788f7:
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
  JMP	__ITER__END__29001e6f_0b52_4e6e_92aa_4b3f3ba788f7
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_e282a179_ab2f_49f2_910a_c81408be45e5
  BNE	__CMP_YES_e282a179_ab2f_49f2_910a_c81408be45e5
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_e282a179_ab2f_49f2_910a_c81408be45e5
  BNE	__CMP_YES_e282a179_ab2f_49f2_910a_c81408be45e5
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e282a179_ab2f_49f2_910a_c81408be45e5
  BNE	__CMP_YES_e282a179_ab2f_49f2_910a_c81408be45e5
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e282a179_ab2f_49f2_910a_c81408be45e5
  BNE	__CMP_YES_e282a179_ab2f_49f2_910a_c81408be45e5
  JMP	__CMP_YES_e282a179_ab2f_49f2_910a_c81408be45e5
  __CMP_YES_e282a179_ab2f_49f2_910a_c81408be45e5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e282a179_ab2f_49f2_910a_c81408be45e5
  __CMP_NO_e282a179_ab2f_49f2_910a_c81408be45e5:
  SEP	#$20
  LDA	#$00
  __CMP_END_e282a179_ab2f_49f2_910a_c81408be45e5:
  BEQ	__IFNOT_7a5db5cd_a0a9_40f8_a1ad_38049b7871fe
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
  __IFNOT_7a5db5cd_a0a9_40f8_a1ad_38049b7871fe:
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
  JMP	__ITER__START__29001e6f_0b52_4e6e_92aa_4b3f3ba788f7
  __ITER__END__29001e6f_0b52_4e6e_92aa_4b3f3ba788f7:
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
  __ITER__START__7ebefbee_ccb5_4549_a8f0_d9a3876a2c3d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_6168d8f6_171e_48b1_acac_a999bce48039
  BNE	__CMP_YES_6168d8f6_171e_48b1_acac_a999bce48039
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_6168d8f6_171e_48b1_acac_a999bce48039
  BNE	__CMP_YES_6168d8f6_171e_48b1_acac_a999bce48039
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6168d8f6_171e_48b1_acac_a999bce48039
  BNE	__CMP_YES_6168d8f6_171e_48b1_acac_a999bce48039
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_6168d8f6_171e_48b1_acac_a999bce48039
  BNE	__CMP_YES_6168d8f6_171e_48b1_acac_a999bce48039
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6168d8f6_171e_48b1_acac_a999bce48039
  BNE	__CMP_YES_6168d8f6_171e_48b1_acac_a999bce48039
  JMP	__CMP_NO_6168d8f6_171e_48b1_acac_a999bce48039
  __CMP_YES_6168d8f6_171e_48b1_acac_a999bce48039:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6168d8f6_171e_48b1_acac_a999bce48039
  __CMP_NO_6168d8f6_171e_48b1_acac_a999bce48039:
  SEP	#$20
  LDA	#$00
  __CMP_END_6168d8f6_171e_48b1_acac_a999bce48039:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7ebefbee_ccb5_4549_a8f0_d9a3876a2c3d
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_4aa62108_400f_4e87_9087_e7241cb4cb6e
  JMP	__ITER__END__7ebefbee_ccb5_4549_a8f0_d9a3876a2c3d
  __IFNOT_4aa62108_400f_4e87_9087_e7241cb4cb6e:
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
  JMP	__ITER__START__7ebefbee_ccb5_4549_a8f0_d9a3876a2c3d
  __ITER__END__7ebefbee_ccb5_4549_a8f0_d9a3876a2c3d:
  __ITER__START__bf2e60c8_c753_43fa_907c_92faf7cccbca:
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
  JMP	__ITER__END__bf2e60c8_c753_43fa_907c_92faf7cccbca
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_043daeee_8063_4367_aa45_acd04dc60330
  BNE	__CMP_YES_043daeee_8063_4367_aa45_acd04dc60330
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_043daeee_8063_4367_aa45_acd04dc60330
  BNE	__CMP_YES_043daeee_8063_4367_aa45_acd04dc60330
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_043daeee_8063_4367_aa45_acd04dc60330
  BNE	__CMP_YES_043daeee_8063_4367_aa45_acd04dc60330
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_043daeee_8063_4367_aa45_acd04dc60330
  BNE	__CMP_YES_043daeee_8063_4367_aa45_acd04dc60330
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_043daeee_8063_4367_aa45_acd04dc60330
  BNE	__CMP_YES_043daeee_8063_4367_aa45_acd04dc60330
  JMP	__CMP_YES_043daeee_8063_4367_aa45_acd04dc60330
  __CMP_YES_043daeee_8063_4367_aa45_acd04dc60330:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_043daeee_8063_4367_aa45_acd04dc60330
  __CMP_NO_043daeee_8063_4367_aa45_acd04dc60330:
  SEP	#$20
  LDA	#$00
  __CMP_END_043daeee_8063_4367_aa45_acd04dc60330:
  BEQ	__IFNOT_a5a5ea81_d272_4519_bbbc_7e09e81f2852
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
  __IFNOT_a5a5ea81_d272_4519_bbbc_7e09e81f2852:
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
  JMP	__ITER__START__bf2e60c8_c753_43fa_907c_92faf7cccbca
  __ITER__END__bf2e60c8_c753_43fa_907c_92faf7cccbca:
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
  __ITER__START__5f351836_e500_4f72_a533_023a1c8a8e16:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  BNE	__CMP_YES_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  BNE	__CMP_YES_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  BNE	__CMP_YES_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  BNE	__CMP_YES_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  JMP	__CMP_NO_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  __CMP_YES_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8
  __CMP_NO_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8:
  SEP	#$20
  LDA	#$00
  __CMP_END_e0e3350a_48c4_419b_9c93_7cbc43bbf9e8:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5f351836_e500_4f72_a533_023a1c8a8e16
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_943f9e73_d26a_42cd_b53f_4c84cd6d97ea
  JMP	__ITER__END__5f351836_e500_4f72_a533_023a1c8a8e16
  __IFNOT_943f9e73_d26a_42cd_b53f_4c84cd6d97ea:
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
  JMP	__ITER__START__5f351836_e500_4f72_a533_023a1c8a8e16
  __ITER__END__5f351836_e500_4f72_a533_023a1c8a8e16:
  __ITER__START__522b072d_ae0f_4579_988a_48fe599c4fc3:
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
  JMP	__ITER__END__522b072d_ae0f_4579_988a_48fe599c4fc3
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_3121bd57_6237_4588_b689_f251a09f4c48
  BNE	__CMP_YES_3121bd57_6237_4588_b689_f251a09f4c48
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_3121bd57_6237_4588_b689_f251a09f4c48
  BNE	__CMP_YES_3121bd57_6237_4588_b689_f251a09f4c48
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3121bd57_6237_4588_b689_f251a09f4c48
  BNE	__CMP_YES_3121bd57_6237_4588_b689_f251a09f4c48
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3121bd57_6237_4588_b689_f251a09f4c48
  BNE	__CMP_YES_3121bd57_6237_4588_b689_f251a09f4c48
  JMP	__CMP_YES_3121bd57_6237_4588_b689_f251a09f4c48
  __CMP_YES_3121bd57_6237_4588_b689_f251a09f4c48:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3121bd57_6237_4588_b689_f251a09f4c48
  __CMP_NO_3121bd57_6237_4588_b689_f251a09f4c48:
  SEP	#$20
  LDA	#$00
  __CMP_END_3121bd57_6237_4588_b689_f251a09f4c48:
  BEQ	__IFNOT_cbfe933f_b228_437b_bbc5_cea40e695e17
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
  __IFNOT_cbfe933f_b228_437b_bbc5_cea40e695e17:
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
  JMP	__ITER__START__522b072d_ae0f_4579_988a_48fe599c4fc3
  __ITER__END__522b072d_ae0f_4579_988a_48fe599c4fc3:
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
  __ITER__START__139c93f2_71ce_4bb3_992e_a4021274f783:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_ba06f98b_f727_4603_ba88_8f682b61b85b
  BNE	__CMP_YES_ba06f98b_f727_4603_ba88_8f682b61b85b
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_ba06f98b_f727_4603_ba88_8f682b61b85b
  BNE	__CMP_YES_ba06f98b_f727_4603_ba88_8f682b61b85b
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_ba06f98b_f727_4603_ba88_8f682b61b85b
  BNE	__CMP_YES_ba06f98b_f727_4603_ba88_8f682b61b85b
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ba06f98b_f727_4603_ba88_8f682b61b85b
  BNE	__CMP_YES_ba06f98b_f727_4603_ba88_8f682b61b85b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ba06f98b_f727_4603_ba88_8f682b61b85b
  BNE	__CMP_YES_ba06f98b_f727_4603_ba88_8f682b61b85b
  JMP	__CMP_NO_ba06f98b_f727_4603_ba88_8f682b61b85b
  __CMP_YES_ba06f98b_f727_4603_ba88_8f682b61b85b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ba06f98b_f727_4603_ba88_8f682b61b85b
  __CMP_NO_ba06f98b_f727_4603_ba88_8f682b61b85b:
  SEP	#$20
  LDA	#$00
  __CMP_END_ba06f98b_f727_4603_ba88_8f682b61b85b:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__139c93f2_71ce_4bb3_992e_a4021274f783
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_e68c9554_1665_4a67_a9fe_c18a4125fcb4
  JMP	__ITER__END__139c93f2_71ce_4bb3_992e_a4021274f783
  __IFNOT_e68c9554_1665_4a67_a9fe_c18a4125fcb4:
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
  JMP	__ITER__START__139c93f2_71ce_4bb3_992e_a4021274f783
  __ITER__END__139c93f2_71ce_4bb3_992e_a4021274f783:
  __ITER__START__a95f190d_1564_4eac_89dc_73b13e1bddd6:
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
  JMP	__ITER__END__a95f190d_1564_4eac_89dc_73b13e1bddd6
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_6c853f4d_215f_403a_906e_2db2b3646b24
  BNE	__CMP_YES_6c853f4d_215f_403a_906e_2db2b3646b24
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_6c853f4d_215f_403a_906e_2db2b3646b24
  BNE	__CMP_YES_6c853f4d_215f_403a_906e_2db2b3646b24
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_6c853f4d_215f_403a_906e_2db2b3646b24
  BNE	__CMP_YES_6c853f4d_215f_403a_906e_2db2b3646b24
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_6c853f4d_215f_403a_906e_2db2b3646b24
  BNE	__CMP_YES_6c853f4d_215f_403a_906e_2db2b3646b24
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6c853f4d_215f_403a_906e_2db2b3646b24
  BNE	__CMP_YES_6c853f4d_215f_403a_906e_2db2b3646b24
  JMP	__CMP_YES_6c853f4d_215f_403a_906e_2db2b3646b24
  __CMP_YES_6c853f4d_215f_403a_906e_2db2b3646b24:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6c853f4d_215f_403a_906e_2db2b3646b24
  __CMP_NO_6c853f4d_215f_403a_906e_2db2b3646b24:
  SEP	#$20
  LDA	#$00
  __CMP_END_6c853f4d_215f_403a_906e_2db2b3646b24:
  BEQ	__IFNOT_05d84e16_0757_4094_be64_fca11d8111a2
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
  __IFNOT_05d84e16_0757_4094_be64_fca11d8111a2:
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
  JMP	__ITER__START__a95f190d_1564_4eac_89dc_73b13e1bddd6
  __ITER__END__a95f190d_1564_4eac_89dc_73b13e1bddd6:
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
  __ITER__START__e94cd4fb_d1c8_4253_a37e_c0cfbfe64ff0:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  BNE	__CMP_YES_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  BNE	__CMP_YES_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  BNE	__CMP_YES_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  BNE	__CMP_YES_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  JMP	__CMP_NO_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  __CMP_YES_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc
  __CMP_NO_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc:
  SEP	#$20
  LDA	#$00
  __CMP_END_bd58db2c_36e1_47e8_92cf_3da78d3c8bcc:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e94cd4fb_d1c8_4253_a37e_c0cfbfe64ff0
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_5a1ace65_6141_49b2_942e_b5c11b9eaf8d
  JMP	__ITER__END__e94cd4fb_d1c8_4253_a37e_c0cfbfe64ff0
  __IFNOT_5a1ace65_6141_49b2_942e_b5c11b9eaf8d:
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
  JMP	__ITER__START__e94cd4fb_d1c8_4253_a37e_c0cfbfe64ff0
  __ITER__END__e94cd4fb_d1c8_4253_a37e_c0cfbfe64ff0:
  __ITER__START__e43fcc4c_756c_478d_b0d4_bc673c29403e:
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
  JMP	__ITER__END__e43fcc4c_756c_478d_b0d4_bc673c29403e
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e8078b16_b462_4476_b540_9ebccb106c9e
  BNE	__CMP_YES_e8078b16_b462_4476_b540_9ebccb106c9e
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e8078b16_b462_4476_b540_9ebccb106c9e
  BNE	__CMP_YES_e8078b16_b462_4476_b540_9ebccb106c9e
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e8078b16_b462_4476_b540_9ebccb106c9e
  BNE	__CMP_YES_e8078b16_b462_4476_b540_9ebccb106c9e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e8078b16_b462_4476_b540_9ebccb106c9e
  BNE	__CMP_YES_e8078b16_b462_4476_b540_9ebccb106c9e
  JMP	__CMP_YES_e8078b16_b462_4476_b540_9ebccb106c9e
  __CMP_YES_e8078b16_b462_4476_b540_9ebccb106c9e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e8078b16_b462_4476_b540_9ebccb106c9e
  __CMP_NO_e8078b16_b462_4476_b540_9ebccb106c9e:
  SEP	#$20
  LDA	#$00
  __CMP_END_e8078b16_b462_4476_b540_9ebccb106c9e:
  BEQ	__IFNOT_7f1d793b_fe2e_409b_a857_8006ed9ea8fd
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
  __IFNOT_7f1d793b_fe2e_409b_a857_8006ed9ea8fd:
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
  JMP	__ITER__START__e43fcc4c_756c_478d_b0d4_bc673c29403e
  __ITER__END__e43fcc4c_756c_478d_b0d4_bc673c29403e:
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
  __ITER__START__49325e74_1aae_41a6_9c26_7cd7c02dcc7e:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_18daa495_e7a0_470b_a490_54d612cc5309
  BNE	__CMP_YES_18daa495_e7a0_470b_a490_54d612cc5309
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_18daa495_e7a0_470b_a490_54d612cc5309
  BNE	__CMP_YES_18daa495_e7a0_470b_a490_54d612cc5309
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_18daa495_e7a0_470b_a490_54d612cc5309
  BNE	__CMP_YES_18daa495_e7a0_470b_a490_54d612cc5309
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_18daa495_e7a0_470b_a490_54d612cc5309
  BNE	__CMP_YES_18daa495_e7a0_470b_a490_54d612cc5309
  JMP	__CMP_NO_18daa495_e7a0_470b_a490_54d612cc5309
  __CMP_YES_18daa495_e7a0_470b_a490_54d612cc5309:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_18daa495_e7a0_470b_a490_54d612cc5309
  __CMP_NO_18daa495_e7a0_470b_a490_54d612cc5309:
  SEP	#$20
  LDA	#$00
  __CMP_END_18daa495_e7a0_470b_a490_54d612cc5309:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__49325e74_1aae_41a6_9c26_7cd7c02dcc7e
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_55ebcaa1_bb53_47b4_8c79_9b76ce194339
  JMP	__ITER__END__49325e74_1aae_41a6_9c26_7cd7c02dcc7e
  __IFNOT_55ebcaa1_bb53_47b4_8c79_9b76ce194339:
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
  JMP	__ITER__START__49325e74_1aae_41a6_9c26_7cd7c02dcc7e
  __ITER__END__49325e74_1aae_41a6_9c26_7cd7c02dcc7e:
  __ITER__START__8dc3d550_64ec_42e0_967a_aaec1f690790:
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
  JMP	__ITER__END__8dc3d550_64ec_42e0_967a_aaec1f690790
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  BNE	__CMP_YES_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  BNE	__CMP_YES_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  BNE	__CMP_YES_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  BNE	__CMP_YES_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  JMP	__CMP_YES_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  __CMP_YES_e9d18134_61d9_46e6_a121_92cc0f4b15b1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e9d18134_61d9_46e6_a121_92cc0f4b15b1
  __CMP_NO_e9d18134_61d9_46e6_a121_92cc0f4b15b1:
  SEP	#$20
  LDA	#$00
  __CMP_END_e9d18134_61d9_46e6_a121_92cc0f4b15b1:
  BNE	:+
  JMP	__IFNOT_e34bce58_a456_458f_973e_c2c6a81e0569
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
  __IFNOT_e34bce58_a456_458f_973e_c2c6a81e0569:
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
  JMP	__ITER__START__8dc3d550_64ec_42e0_967a_aaec1f690790
  __ITER__END__8dc3d550_64ec_42e0_967a_aaec1f690790:
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
  __ITER__START__7259167e_8a6e_4c64_9f43_ae6142b62df3:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2b2327e0_1e80_47a4_aab5_8f59c43d0872
  BNE	__CMP_YES_2b2327e0_1e80_47a4_aab5_8f59c43d0872
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2b2327e0_1e80_47a4_aab5_8f59c43d0872
  BNE	__CMP_YES_2b2327e0_1e80_47a4_aab5_8f59c43d0872
  JMP	__CMP_NO_2b2327e0_1e80_47a4_aab5_8f59c43d0872
  __CMP_YES_2b2327e0_1e80_47a4_aab5_8f59c43d0872:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2b2327e0_1e80_47a4_aab5_8f59c43d0872
  __CMP_NO_2b2327e0_1e80_47a4_aab5_8f59c43d0872:
  SEP	#$20
  LDA	#$00
  __CMP_END_2b2327e0_1e80_47a4_aab5_8f59c43d0872:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7259167e_8a6e_4c64_9f43_ae6142b62df3
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_06763327_a4cf_4ac6_a8a2_efa39cd9e0d1
  JMP	__ITER__END__7259167e_8a6e_4c64_9f43_ae6142b62df3
  __IFNOT_06763327_a4cf_4ac6_a8a2_efa39cd9e0d1:
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
  JMP	__ITER__START__7259167e_8a6e_4c64_9f43_ae6142b62df3
  __ITER__END__7259167e_8a6e_4c64_9f43_ae6142b62df3:
  __ITER__START__941953d6_f7df_44be_95ce_3d94e4470964:
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
  JMP	__ITER__END__941953d6_f7df_44be_95ce_3d94e4470964
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_180193f7_43e9_4274_b981_6c5b205f191d
  BNE	__CMP_YES_180193f7_43e9_4274_b981_6c5b205f191d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_180193f7_43e9_4274_b981_6c5b205f191d
  BNE	__CMP_YES_180193f7_43e9_4274_b981_6c5b205f191d
  JMP	__CMP_YES_180193f7_43e9_4274_b981_6c5b205f191d
  __CMP_YES_180193f7_43e9_4274_b981_6c5b205f191d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_180193f7_43e9_4274_b981_6c5b205f191d
  __CMP_NO_180193f7_43e9_4274_b981_6c5b205f191d:
  SEP	#$20
  LDA	#$00
  __CMP_END_180193f7_43e9_4274_b981_6c5b205f191d:
  BEQ	__IFNOT_e999ef45_b4f5_4002_87db_02771ef20e75
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
  __IFNOT_e999ef45_b4f5_4002_87db_02771ef20e75:
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
  JMP	__ITER__START__941953d6_f7df_44be_95ce_3d94e4470964
  __ITER__END__941953d6_f7df_44be_95ce_3d94e4470964:
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
  __ITER__START__ada723fd_7bc4_4ea2_9b2c_8394cf3e1e60:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e72066e8_14a8_4ad6_9a8a_12899a306436
  BNE	__CMP_YES_e72066e8_14a8_4ad6_9a8a_12899a306436
  JMP	__CMP_NO_e72066e8_14a8_4ad6_9a8a_12899a306436
  __CMP_YES_e72066e8_14a8_4ad6_9a8a_12899a306436:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e72066e8_14a8_4ad6_9a8a_12899a306436
  __CMP_NO_e72066e8_14a8_4ad6_9a8a_12899a306436:
  SEP	#$20
  LDA	#$00
  __CMP_END_e72066e8_14a8_4ad6_9a8a_12899a306436:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__ada723fd_7bc4_4ea2_9b2c_8394cf3e1e60
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_f923301e_3dde_40f0_906c_19ea88141d85
  JMP	__ITER__END__ada723fd_7bc4_4ea2_9b2c_8394cf3e1e60
  __IFNOT_f923301e_3dde_40f0_906c_19ea88141d85:
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
  JMP	__ITER__START__ada723fd_7bc4_4ea2_9b2c_8394cf3e1e60
  __ITER__END__ada723fd_7bc4_4ea2_9b2c_8394cf3e1e60:
  __ITER__START__d3b3fc2e_4539_4214_8daa_85f6bdce65aa:
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
  JMP	__ITER__END__d3b3fc2e_4539_4214_8daa_85f6bdce65aa
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_bc3b354e_7d45_42a1_a76c_28461362b8a0
  BNE	__CMP_YES_bc3b354e_7d45_42a1_a76c_28461362b8a0
  JMP	__CMP_YES_bc3b354e_7d45_42a1_a76c_28461362b8a0
  __CMP_YES_bc3b354e_7d45_42a1_a76c_28461362b8a0:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_bc3b354e_7d45_42a1_a76c_28461362b8a0
  __CMP_NO_bc3b354e_7d45_42a1_a76c_28461362b8a0:
  SEP	#$20
  LDA	#$00
  __CMP_END_bc3b354e_7d45_42a1_a76c_28461362b8a0:
  BEQ	__IFNOT_370ff6db_1b08_4e22_b2e8_71d41e0a77dd
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
  __IFNOT_370ff6db_1b08_4e22_b2e8_71d41e0a77dd:
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
  JMP	__ITER__START__d3b3fc2e_4539_4214_8daa_85f6bdce65aa
  __ITER__END__d3b3fc2e_4539_4214_8daa_85f6bdce65aa:
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
  __ITER__START__6521a9de_e4cf_44f2_b7ac_8131eb4c4bdf:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_28214227_0eb2_4fd9_9de8_a4b932fcd493
  BNE	__CMP_YES_28214227_0eb2_4fd9_9de8_a4b932fcd493
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_28214227_0eb2_4fd9_9de8_a4b932fcd493
  BNE	__CMP_YES_28214227_0eb2_4fd9_9de8_a4b932fcd493
  JMP	__CMP_NO_28214227_0eb2_4fd9_9de8_a4b932fcd493
  __CMP_YES_28214227_0eb2_4fd9_9de8_a4b932fcd493:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_28214227_0eb2_4fd9_9de8_a4b932fcd493
  __CMP_NO_28214227_0eb2_4fd9_9de8_a4b932fcd493:
  SEP	#$20
  LDA	#$00
  __CMP_END_28214227_0eb2_4fd9_9de8_a4b932fcd493:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6521a9de_e4cf_44f2_b7ac_8131eb4c4bdf
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_e5260b01_441f_45e1_b65c_b0cb206223ca
  JMP	__ITER__END__6521a9de_e4cf_44f2_b7ac_8131eb4c4bdf
  __IFNOT_e5260b01_441f_45e1_b65c_b0cb206223ca:
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
  JMP	__ITER__START__6521a9de_e4cf_44f2_b7ac_8131eb4c4bdf
  __ITER__END__6521a9de_e4cf_44f2_b7ac_8131eb4c4bdf:
  __ITER__START__bcbb4951_82dc_424d_b497_ec4434223890:
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
  JMP	__ITER__END__bcbb4951_82dc_424d_b497_ec4434223890
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_94b9ff87_f9d6_40c1_85e6_be56175ec57f
  BNE	__CMP_YES_94b9ff87_f9d6_40c1_85e6_be56175ec57f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_94b9ff87_f9d6_40c1_85e6_be56175ec57f
  BNE	__CMP_YES_94b9ff87_f9d6_40c1_85e6_be56175ec57f
  JMP	__CMP_YES_94b9ff87_f9d6_40c1_85e6_be56175ec57f
  __CMP_YES_94b9ff87_f9d6_40c1_85e6_be56175ec57f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_94b9ff87_f9d6_40c1_85e6_be56175ec57f
  __CMP_NO_94b9ff87_f9d6_40c1_85e6_be56175ec57f:
  SEP	#$20
  LDA	#$00
  __CMP_END_94b9ff87_f9d6_40c1_85e6_be56175ec57f:
  BEQ	__IFNOT_22ed1043_802d_435b_9c42_52fd81b9989d
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
  __IFNOT_22ed1043_802d_435b_9c42_52fd81b9989d:
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
  JMP	__ITER__START__bcbb4951_82dc_424d_b497_ec4434223890
  __ITER__END__bcbb4951_82dc_424d_b497_ec4434223890:
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
  __ITER__START__6c5584b0_25a0_4d6d_b407_04e0bc979b2a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_192281c7_8be0_4ef8_aebf_8f8521edc5aa
  BNE	__CMP_YES_192281c7_8be0_4ef8_aebf_8f8521edc5aa
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_192281c7_8be0_4ef8_aebf_8f8521edc5aa
  BNE	__CMP_YES_192281c7_8be0_4ef8_aebf_8f8521edc5aa
  JMP	__CMP_NO_192281c7_8be0_4ef8_aebf_8f8521edc5aa
  __CMP_YES_192281c7_8be0_4ef8_aebf_8f8521edc5aa:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_192281c7_8be0_4ef8_aebf_8f8521edc5aa
  __CMP_NO_192281c7_8be0_4ef8_aebf_8f8521edc5aa:
  SEP	#$20
  LDA	#$00
  __CMP_END_192281c7_8be0_4ef8_aebf_8f8521edc5aa:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6c5584b0_25a0_4d6d_b407_04e0bc979b2a
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_e4dbef64_ea48_4740_98da_1dcaeb906bb9
  JMP	__ITER__END__6c5584b0_25a0_4d6d_b407_04e0bc979b2a
  __IFNOT_e4dbef64_ea48_4740_98da_1dcaeb906bb9:
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
  JMP	__ITER__START__6c5584b0_25a0_4d6d_b407_04e0bc979b2a
  __ITER__END__6c5584b0_25a0_4d6d_b407_04e0bc979b2a:
  __ITER__START__46753ff3_5b2c_4a50_87b9_e17d21a60ea2:
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
  JMP	__ITER__END__46753ff3_5b2c_4a50_87b9_e17d21a60ea2
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_f273056f_dcf5_4ad0_b261_6aee41ef4599
  BNE	__CMP_YES_f273056f_dcf5_4ad0_b261_6aee41ef4599
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f273056f_dcf5_4ad0_b261_6aee41ef4599
  BNE	__CMP_YES_f273056f_dcf5_4ad0_b261_6aee41ef4599
  JMP	__CMP_YES_f273056f_dcf5_4ad0_b261_6aee41ef4599
  __CMP_YES_f273056f_dcf5_4ad0_b261_6aee41ef4599:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f273056f_dcf5_4ad0_b261_6aee41ef4599
  __CMP_NO_f273056f_dcf5_4ad0_b261_6aee41ef4599:
  SEP	#$20
  LDA	#$00
  __CMP_END_f273056f_dcf5_4ad0_b261_6aee41ef4599:
  BEQ	__IFNOT_1f9bb143_e29b_4d3f_b4b7_f7d75bf1eaf3
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
  __IFNOT_1f9bb143_e29b_4d3f_b4b7_f7d75bf1eaf3:
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
  JMP	__ITER__START__46753ff3_5b2c_4a50_87b9_e17d21a60ea2
  __ITER__END__46753ff3_5b2c_4a50_87b9_e17d21a60ea2:
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
  __ITER__START__61d61823_ce36_4ee3_8411_1a6d1dbb1a13:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  BNE	__CMP_YES_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  BNE	__CMP_YES_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  BNE	__CMP_YES_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  BNE	__CMP_YES_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  JMP	__CMP_NO_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  __CMP_YES_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70
  __CMP_NO_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70:
  SEP	#$20
  LDA	#$00
  __CMP_END_f21efc3c_eefe_4ce1_9c87_d3070b2b7b70:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__61d61823_ce36_4ee3_8411_1a6d1dbb1a13
  :
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  
  LDA	#$8000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$00
  AND	__@signExtend
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_d567c60a_6d72_4aef_97a2_979bc14c71ab
  JMP	__ITER__END__61d61823_ce36_4ee3_8411_1a6d1dbb1a13
  __IFNOT_d567c60a_6d72_4aef_97a2_979bc14c71ab:
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
  JMP	__ITER__START__61d61823_ce36_4ee3_8411_1a6d1dbb1a13
  __ITER__END__61d61823_ce36_4ee3_8411_1a6d1dbb1a13:
  __ITER__START__56ae649c_13a0_445f_9cb7_23f96104ba82:
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
  JMP	__ITER__END__56ae649c_13a0_445f_9cb7_23f96104ba82
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_06514998_3ecf_4a44_a06a_94d58b7f1b30
  BNE	__CMP_YES_06514998_3ecf_4a44_a06a_94d58b7f1b30
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_06514998_3ecf_4a44_a06a_94d58b7f1b30
  BNE	__CMP_YES_06514998_3ecf_4a44_a06a_94d58b7f1b30
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_06514998_3ecf_4a44_a06a_94d58b7f1b30
  BNE	__CMP_YES_06514998_3ecf_4a44_a06a_94d58b7f1b30
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_06514998_3ecf_4a44_a06a_94d58b7f1b30
  BNE	__CMP_YES_06514998_3ecf_4a44_a06a_94d58b7f1b30
  JMP	__CMP_YES_06514998_3ecf_4a44_a06a_94d58b7f1b30
  __CMP_YES_06514998_3ecf_4a44_a06a_94d58b7f1b30:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_06514998_3ecf_4a44_a06a_94d58b7f1b30
  __CMP_NO_06514998_3ecf_4a44_a06a_94d58b7f1b30:
  SEP	#$20
  LDA	#$00
  __CMP_END_06514998_3ecf_4a44_a06a_94d58b7f1b30:
  BEQ	__IFNOT_c8aea7d7_fbcb_4a20_ad2b_8b21d70e52c9
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
  __IFNOT_c8aea7d7_fbcb_4a20_ad2b_8b21d70e52c9:
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
  JMP	__ITER__START__56ae649c_13a0_445f_9cb7_23f96104ba82
  __ITER__END__56ae649c_13a0_445f_9cb7_23f96104ba82:
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
  __ITER__START__0e30140b_6a2b_48b0_ad7d_f75187bb14f6:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e4d2c988_5791_4339_b544_df17e97848e9
  BNE	__CMP_YES_e4d2c988_5791_4339_b544_df17e97848e9
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e4d2c988_5791_4339_b544_df17e97848e9
  BNE	__CMP_YES_e4d2c988_5791_4339_b544_df17e97848e9
  JMP	__CMP_NO_e4d2c988_5791_4339_b544_df17e97848e9
  __CMP_YES_e4d2c988_5791_4339_b544_df17e97848e9:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e4d2c988_5791_4339_b544_df17e97848e9
  __CMP_NO_e4d2c988_5791_4339_b544_df17e97848e9:
  SEP	#$20
  LDA	#$00
  __CMP_END_e4d2c988_5791_4339_b544_df17e97848e9:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__0e30140b_6a2b_48b0_ad7d_f75187bb14f6
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_d5bcb565_4739_4460_9d46_735bfc6c167c
  JMP	__ITER__END__0e30140b_6a2b_48b0_ad7d_f75187bb14f6
  __IFNOT_d5bcb565_4739_4460_9d46_735bfc6c167c:
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
  JMP	__ITER__START__0e30140b_6a2b_48b0_ad7d_f75187bb14f6
  __ITER__END__0e30140b_6a2b_48b0_ad7d_f75187bb14f6:
  __ITER__START__0be1335a_66d0_4db5_80e6_f15ab3318d7b:
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
  JMP	__ITER__END__0be1335a_66d0_4db5_80e6_f15ab3318d7b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_cb8f5e73_6e64_464b_9f17_06e637109fcd
  BNE	__CMP_YES_cb8f5e73_6e64_464b_9f17_06e637109fcd
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cb8f5e73_6e64_464b_9f17_06e637109fcd
  BNE	__CMP_YES_cb8f5e73_6e64_464b_9f17_06e637109fcd
  JMP	__CMP_YES_cb8f5e73_6e64_464b_9f17_06e637109fcd
  __CMP_YES_cb8f5e73_6e64_464b_9f17_06e637109fcd:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cb8f5e73_6e64_464b_9f17_06e637109fcd
  __CMP_NO_cb8f5e73_6e64_464b_9f17_06e637109fcd:
  SEP	#$20
  LDA	#$00
  __CMP_END_cb8f5e73_6e64_464b_9f17_06e637109fcd:
  BEQ	__IFNOT_b4bada2e_c17a_4ffc_ac90_96df2787c357
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
  __IFNOT_b4bada2e_c17a_4ffc_ac90_96df2787c357:
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
  JMP	__ITER__START__0be1335a_66d0_4db5_80e6_f15ab3318d7b
  __ITER__END__0be1335a_66d0_4db5_80e6_f15ab3318d7b:
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
  __ITER__START__5e548ec0_58d0_4a4e_ba04_96e5d72be677:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_ab29e216_121b_449c_8ab5_1139e4a76c9d
  BNE	__CMP_YES_ab29e216_121b_449c_8ab5_1139e4a76c9d
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ab29e216_121b_449c_8ab5_1139e4a76c9d
  BNE	__CMP_YES_ab29e216_121b_449c_8ab5_1139e4a76c9d
  JMP	__CMP_NO_ab29e216_121b_449c_8ab5_1139e4a76c9d
  __CMP_YES_ab29e216_121b_449c_8ab5_1139e4a76c9d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ab29e216_121b_449c_8ab5_1139e4a76c9d
  __CMP_NO_ab29e216_121b_449c_8ab5_1139e4a76c9d:
  SEP	#$20
  LDA	#$00
  __CMP_END_ab29e216_121b_449c_8ab5_1139e4a76c9d:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5e548ec0_58d0_4a4e_ba04_96e5d72be677
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_930d3fdc_f2f1_4699_ab93_d179774d4658
  JMP	__ITER__END__5e548ec0_58d0_4a4e_ba04_96e5d72be677
  __IFNOT_930d3fdc_f2f1_4699_ab93_d179774d4658:
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
  JMP	__ITER__START__5e548ec0_58d0_4a4e_ba04_96e5d72be677
  __ITER__END__5e548ec0_58d0_4a4e_ba04_96e5d72be677:
  __ITER__START__deb6bec8_a2ef_469f_b645_4a84b3cc8f22:
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
  JMP	__ITER__END__deb6bec8_a2ef_469f_b645_4a84b3cc8f22
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_90aaf4c1_6924_4693_8f6e_23c52ebb4a17
  BNE	__CMP_YES_90aaf4c1_6924_4693_8f6e_23c52ebb4a17
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_90aaf4c1_6924_4693_8f6e_23c52ebb4a17
  BNE	__CMP_YES_90aaf4c1_6924_4693_8f6e_23c52ebb4a17
  JMP	__CMP_YES_90aaf4c1_6924_4693_8f6e_23c52ebb4a17
  __CMP_YES_90aaf4c1_6924_4693_8f6e_23c52ebb4a17:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_90aaf4c1_6924_4693_8f6e_23c52ebb4a17
  __CMP_NO_90aaf4c1_6924_4693_8f6e_23c52ebb4a17:
  SEP	#$20
  LDA	#$00
  __CMP_END_90aaf4c1_6924_4693_8f6e_23c52ebb4a17:
  BEQ	__IFNOT_f4dae96f_1769_4650_9b05_fb3bd7742911
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
  __IFNOT_f4dae96f_1769_4650_9b05_fb3bd7742911:
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
  JMP	__ITER__START__deb6bec8_a2ef_469f_b645_4a84b3cc8f22
  __ITER__END__deb6bec8_a2ef_469f_b645_4a84b3cc8f22:
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
  __ITER__START__53a36642_0401_4cd9_bda5_c85da34c9f1f:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_281032ab_76aa_402b_9b5f_adca0353d363
  BNE	__CMP_YES_281032ab_76aa_402b_9b5f_adca0353d363
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_281032ab_76aa_402b_9b5f_adca0353d363
  BNE	__CMP_YES_281032ab_76aa_402b_9b5f_adca0353d363
  JMP	__CMP_NO_281032ab_76aa_402b_9b5f_adca0353d363
  __CMP_YES_281032ab_76aa_402b_9b5f_adca0353d363:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_281032ab_76aa_402b_9b5f_adca0353d363
  __CMP_NO_281032ab_76aa_402b_9b5f_adca0353d363:
  SEP	#$20
  LDA	#$00
  __CMP_END_281032ab_76aa_402b_9b5f_adca0353d363:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__53a36642_0401_4cd9_bda5_c85da34c9f1f
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_e6d2ad62_9115_4820_9f65_088ef91ee04e
  JMP	__ITER__END__53a36642_0401_4cd9_bda5_c85da34c9f1f
  __IFNOT_e6d2ad62_9115_4820_9f65_088ef91ee04e:
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
  JMP	__ITER__START__53a36642_0401_4cd9_bda5_c85da34c9f1f
  __ITER__END__53a36642_0401_4cd9_bda5_c85da34c9f1f:
  __ITER__START__7b7c529d_b7bb_4dcb_839e_349de35d6137:
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
  JMP	__ITER__END__7b7c529d_b7bb_4dcb_839e_349de35d6137
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_37c720a1_b589_4217_8cd9_9fda48e6414e
  BNE	__CMP_YES_37c720a1_b589_4217_8cd9_9fda48e6414e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_37c720a1_b589_4217_8cd9_9fda48e6414e
  BNE	__CMP_YES_37c720a1_b589_4217_8cd9_9fda48e6414e
  JMP	__CMP_YES_37c720a1_b589_4217_8cd9_9fda48e6414e
  __CMP_YES_37c720a1_b589_4217_8cd9_9fda48e6414e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_37c720a1_b589_4217_8cd9_9fda48e6414e
  __CMP_NO_37c720a1_b589_4217_8cd9_9fda48e6414e:
  SEP	#$20
  LDA	#$00
  __CMP_END_37c720a1_b589_4217_8cd9_9fda48e6414e:
  BEQ	__IFNOT_91db2426_6307_4041_a1f0_dd86ea20012c
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
  __IFNOT_91db2426_6307_4041_a1f0_dd86ea20012c:
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
  JMP	__ITER__START__7b7c529d_b7bb_4dcb_839e_349de35d6137
  __ITER__END__7b7c529d_b7bb_4dcb_839e_349de35d6137:
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
  __ITER__START__59e1d4e3_da15_403d_b71b_dd97193a7dd4:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa
  BNE	__CMP_YES_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa
  BNE	__CMP_YES_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa
  BNE	__CMP_YES_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa
  JMP	__CMP_NO_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa
  __CMP_YES_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa
  __CMP_NO_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa:
  SEP	#$20
  LDA	#$00
  __CMP_END_1af5e01e_b273_44aa_bfb3_6fe5aa6f06fa:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__59e1d4e3_da15_403d_b71b_dd97193a7dd4
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_ee24ee18_e7a6_41b4_a335_0274746fce64
  JMP	__ITER__END__59e1d4e3_da15_403d_b71b_dd97193a7dd4
  __IFNOT_ee24ee18_e7a6_41b4_a335_0274746fce64:
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
  JMP	__ITER__START__59e1d4e3_da15_403d_b71b_dd97193a7dd4
  __ITER__END__59e1d4e3_da15_403d_b71b_dd97193a7dd4:
  __ITER__START__d7076d13_99c2_48c5_81a4_8d36ca1f3d63:
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
  JMP	__ITER__END__d7076d13_99c2_48c5_81a4_8d36ca1f3d63
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_2c44a1eb_5998_41b2_babb_cad7ef89b2c8
  BNE	__CMP_YES_2c44a1eb_5998_41b2_babb_cad7ef89b2c8
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2c44a1eb_5998_41b2_babb_cad7ef89b2c8
  BNE	__CMP_YES_2c44a1eb_5998_41b2_babb_cad7ef89b2c8
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2c44a1eb_5998_41b2_babb_cad7ef89b2c8
  BNE	__CMP_YES_2c44a1eb_5998_41b2_babb_cad7ef89b2c8
  JMP	__CMP_YES_2c44a1eb_5998_41b2_babb_cad7ef89b2c8
  __CMP_YES_2c44a1eb_5998_41b2_babb_cad7ef89b2c8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2c44a1eb_5998_41b2_babb_cad7ef89b2c8
  __CMP_NO_2c44a1eb_5998_41b2_babb_cad7ef89b2c8:
  SEP	#$20
  LDA	#$00
  __CMP_END_2c44a1eb_5998_41b2_babb_cad7ef89b2c8:
  BEQ	__IFNOT_5efb7b8d_1393_46f1_91a4_c8065e597086
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
  __IFNOT_5efb7b8d_1393_46f1_91a4_c8065e597086:
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
  JMP	__ITER__START__d7076d13_99c2_48c5_81a4_8d36ca1f3d63
  __ITER__END__d7076d13_99c2_48c5_81a4_8d36ca1f3d63:
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
  __ITER__START__7f35e9a4_0f66_45c6_a1d5_45164952e676:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_e7cf55fe_55d3_44de_904d_86534a05de09
  BNE	__CMP_YES_e7cf55fe_55d3_44de_904d_86534a05de09
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_e7cf55fe_55d3_44de_904d_86534a05de09
  BNE	__CMP_YES_e7cf55fe_55d3_44de_904d_86534a05de09
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_e7cf55fe_55d3_44de_904d_86534a05de09
  BNE	__CMP_YES_e7cf55fe_55d3_44de_904d_86534a05de09
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e7cf55fe_55d3_44de_904d_86534a05de09
  BNE	__CMP_YES_e7cf55fe_55d3_44de_904d_86534a05de09
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e7cf55fe_55d3_44de_904d_86534a05de09
  BNE	__CMP_YES_e7cf55fe_55d3_44de_904d_86534a05de09
  JMP	__CMP_NO_e7cf55fe_55d3_44de_904d_86534a05de09
  __CMP_YES_e7cf55fe_55d3_44de_904d_86534a05de09:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e7cf55fe_55d3_44de_904d_86534a05de09
  __CMP_NO_e7cf55fe_55d3_44de_904d_86534a05de09:
  SEP	#$20
  LDA	#$00
  __CMP_END_e7cf55fe_55d3_44de_904d_86534a05de09:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7f35e9a4_0f66_45c6_a1d5_45164952e676
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	#$80
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 5
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_395181be_a6c0_4a40_bf03_fdf463810543
  JMP	__ITER__END__7f35e9a4_0f66_45c6_a1d5_45164952e676
  __IFNOT_395181be_a6c0_4a40_bf03_fdf463810543:
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
  JMP	__ITER__START__7f35e9a4_0f66_45c6_a1d5_45164952e676
  __ITER__END__7f35e9a4_0f66_45c6_a1d5_45164952e676:
  __ITER__START__1ea87fe2_254e_4315_a255_2adff343b659:
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
  JMP	__ITER__END__1ea87fe2_254e_4315_a255_2adff343b659
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_8191e524_ba47_4fe8_a2e0_9ef395893b83
  BNE	__CMP_YES_8191e524_ba47_4fe8_a2e0_9ef395893b83
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_8191e524_ba47_4fe8_a2e0_9ef395893b83
  BNE	__CMP_YES_8191e524_ba47_4fe8_a2e0_9ef395893b83
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_8191e524_ba47_4fe8_a2e0_9ef395893b83
  BNE	__CMP_YES_8191e524_ba47_4fe8_a2e0_9ef395893b83
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8191e524_ba47_4fe8_a2e0_9ef395893b83
  BNE	__CMP_YES_8191e524_ba47_4fe8_a2e0_9ef395893b83
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8191e524_ba47_4fe8_a2e0_9ef395893b83
  BNE	__CMP_YES_8191e524_ba47_4fe8_a2e0_9ef395893b83
  JMP	__CMP_YES_8191e524_ba47_4fe8_a2e0_9ef395893b83
  __CMP_YES_8191e524_ba47_4fe8_a2e0_9ef395893b83:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8191e524_ba47_4fe8_a2e0_9ef395893b83
  __CMP_NO_8191e524_ba47_4fe8_a2e0_9ef395893b83:
  SEP	#$20
  LDA	#$00
  __CMP_END_8191e524_ba47_4fe8_a2e0_9ef395893b83:
  BNE	:+
  JMP	__IFNOT_4be7c2b6_a2a5_4ca6_8ff5_c6a3522e3fc8
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
  __IFNOT_4be7c2b6_a2a5_4ca6_8ff5_c6a3522e3fc8:
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
  JMP	__ITER__START__1ea87fe2_254e_4315_a255_2adff343b659
  __ITER__END__1ea87fe2_254e_4315_a255_2adff343b659:
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
  __ITER__START__9c2eeec6_7561_4c6f_bf31_179bfc05a765:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a
  BNE	__CMP_YES_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a
  BNE	__CMP_YES_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a
  BNE	__CMP_YES_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a
  JMP	__CMP_NO_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a
  __CMP_YES_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a
  __CMP_NO_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a:
  SEP	#$20
  LDA	#$00
  __CMP_END_3ffb61b3_40b5_4a20_a06c_dc8e0c7d300a:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9c2eeec6_7561_4c6f_bf31_179bfc05a765
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_b7af17c2_8fac_429c_bb26_8d447cf31b9b
  JMP	__ITER__END__9c2eeec6_7561_4c6f_bf31_179bfc05a765
  __IFNOT_b7af17c2_8fac_429c_bb26_8d447cf31b9b:
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
  JMP	__ITER__START__9c2eeec6_7561_4c6f_bf31_179bfc05a765
  __ITER__END__9c2eeec6_7561_4c6f_bf31_179bfc05a765:
  __ITER__START__eaa81d56_cf89_4abc_95ef_1ef2161d3d18:
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
  JMP	__ITER__END__eaa81d56_cf89_4abc_95ef_1ef2161d3d18
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3
  BNE	__CMP_YES_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3
  BNE	__CMP_YES_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3
  BNE	__CMP_YES_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3
  JMP	__CMP_YES_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3
  __CMP_YES_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3
  __CMP_NO_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3:
  SEP	#$20
  LDA	#$00
  __CMP_END_9d96c3ae_1c23_4fcb_b390_545dc3b54ab3:
  BEQ	__IFNOT_61229049_7c18_4d00_8c70_4720232933ba
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
  __IFNOT_61229049_7c18_4d00_8c70_4720232933ba:
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
  JMP	__ITER__START__eaa81d56_cf89_4abc_95ef_1ef2161d3d18
  __ITER__END__eaa81d56_cf89_4abc_95ef_1ef2161d3d18:
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
  __ITER__START__25168a83_1235_4fc0_9634_f6554949dafc:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5fe626bc_0064_4da8_a14e_765a921d848b
  BNE	__CMP_YES_5fe626bc_0064_4da8_a14e_765a921d848b
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5fe626bc_0064_4da8_a14e_765a921d848b
  BNE	__CMP_YES_5fe626bc_0064_4da8_a14e_765a921d848b
  JMP	__CMP_NO_5fe626bc_0064_4da8_a14e_765a921d848b
  __CMP_YES_5fe626bc_0064_4da8_a14e_765a921d848b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5fe626bc_0064_4da8_a14e_765a921d848b
  __CMP_NO_5fe626bc_0064_4da8_a14e_765a921d848b:
  SEP	#$20
  LDA	#$00
  __CMP_END_5fe626bc_0064_4da8_a14e_765a921d848b:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__25168a83_1235_4fc0_9634_f6554949dafc
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_4712fd82_a151_4664_85e9_2046e8faf2f2
  JMP	__ITER__END__25168a83_1235_4fc0_9634_f6554949dafc
  __IFNOT_4712fd82_a151_4664_85e9_2046e8faf2f2:
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
  JMP	__ITER__START__25168a83_1235_4fc0_9634_f6554949dafc
  __ITER__END__25168a83_1235_4fc0_9634_f6554949dafc:
  __ITER__START__fcdfdd2b_e250_4ae4_bbb4_5113ff5b8b7e:
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
  JMP	__ITER__END__fcdfdd2b_e250_4ae4_bbb4_5113ff5b8b7e
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a
  BNE	__CMP_YES_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a
  BNE	__CMP_YES_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a
  JMP	__CMP_YES_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a
  __CMP_YES_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a
  __CMP_NO_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a:
  SEP	#$20
  LDA	#$00
  __CMP_END_2f627a78_bd43_4ae8_aba4_61d4de0dfd8a:
  BEQ	__IFNOT_2263dded_6dcc_4b1a_84bd_59c5938d4e24
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
  __IFNOT_2263dded_6dcc_4b1a_84bd_59c5938d4e24:
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
  JMP	__ITER__START__fcdfdd2b_e250_4ae4_bbb4_5113ff5b8b7e
  __ITER__END__fcdfdd2b_e250_4ae4_bbb4_5113ff5b8b7e:
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
  __ITER__START__9072fa37_77a5_4f75_8058_b63e2a101b0b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_0579f322_5787_4521_82ac_d32e5f5d97c6
  BNE	__CMP_YES_0579f322_5787_4521_82ac_d32e5f5d97c6
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_0579f322_5787_4521_82ac_d32e5f5d97c6
  BNE	__CMP_YES_0579f322_5787_4521_82ac_d32e5f5d97c6
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0579f322_5787_4521_82ac_d32e5f5d97c6
  BNE	__CMP_YES_0579f322_5787_4521_82ac_d32e5f5d97c6
  JMP	__CMP_NO_0579f322_5787_4521_82ac_d32e5f5d97c6
  __CMP_YES_0579f322_5787_4521_82ac_d32e5f5d97c6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0579f322_5787_4521_82ac_d32e5f5d97c6
  __CMP_NO_0579f322_5787_4521_82ac_d32e5f5d97c6:
  SEP	#$20
  LDA	#$00
  __CMP_END_0579f322_5787_4521_82ac_d32e5f5d97c6:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9072fa37_77a5_4f75_8058_b63e2a101b0b
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_c8f211ad_4e17_402b_b66a_7ce532d7a96f
  JMP	__ITER__END__9072fa37_77a5_4f75_8058_b63e2a101b0b
  __IFNOT_c8f211ad_4e17_402b_b66a_7ce532d7a96f:
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
  JMP	__ITER__START__9072fa37_77a5_4f75_8058_b63e2a101b0b
  __ITER__END__9072fa37_77a5_4f75_8058_b63e2a101b0b:
  __ITER__START__713c7f01_ca34_47b8_827e_497d5c7d8a41:
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
  JMP	__ITER__END__713c7f01_ca34_47b8_827e_497d5c7d8a41
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_07bbbe70_6e0f_4ef4_82f0_501e861e1d95
  BNE	__CMP_YES_07bbbe70_6e0f_4ef4_82f0_501e861e1d95
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_07bbbe70_6e0f_4ef4_82f0_501e861e1d95
  BNE	__CMP_YES_07bbbe70_6e0f_4ef4_82f0_501e861e1d95
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_07bbbe70_6e0f_4ef4_82f0_501e861e1d95
  BNE	__CMP_YES_07bbbe70_6e0f_4ef4_82f0_501e861e1d95
  JMP	__CMP_YES_07bbbe70_6e0f_4ef4_82f0_501e861e1d95
  __CMP_YES_07bbbe70_6e0f_4ef4_82f0_501e861e1d95:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_07bbbe70_6e0f_4ef4_82f0_501e861e1d95
  __CMP_NO_07bbbe70_6e0f_4ef4_82f0_501e861e1d95:
  SEP	#$20
  LDA	#$00
  __CMP_END_07bbbe70_6e0f_4ef4_82f0_501e861e1d95:
  BEQ	__IFNOT_735aa4ed_ebbb_49c8_96fa_43a0723a16ba
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
  __IFNOT_735aa4ed_ebbb_49c8_96fa_43a0723a16ba:
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
  JMP	__ITER__START__713c7f01_ca34_47b8_827e_497d5c7d8a41
  __ITER__END__713c7f01_ca34_47b8_827e_497d5c7d8a41:
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
  __ITER__START__fc1b8156_1a73_4041_9c9f_abb76ed7f2c9:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_8e829e4f_c856_443d_bb60_7b05b0a2a7da
  BNE	__CMP_YES_8e829e4f_c856_443d_bb60_7b05b0a2a7da
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8e829e4f_c856_443d_bb60_7b05b0a2a7da
  BNE	__CMP_YES_8e829e4f_c856_443d_bb60_7b05b0a2a7da
  JMP	__CMP_NO_8e829e4f_c856_443d_bb60_7b05b0a2a7da
  __CMP_YES_8e829e4f_c856_443d_bb60_7b05b0a2a7da:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8e829e4f_c856_443d_bb60_7b05b0a2a7da
  __CMP_NO_8e829e4f_c856_443d_bb60_7b05b0a2a7da:
  SEP	#$20
  LDA	#$00
  __CMP_END_8e829e4f_c856_443d_bb60_7b05b0a2a7da:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__fc1b8156_1a73_4041_9c9f_abb76ed7f2c9
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_3629bd76_a3d6_40ba_8f88_477f2ff62646
  JMP	__ITER__END__fc1b8156_1a73_4041_9c9f_abb76ed7f2c9
  __IFNOT_3629bd76_a3d6_40ba_8f88_477f2ff62646:
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
  JMP	__ITER__START__fc1b8156_1a73_4041_9c9f_abb76ed7f2c9
  __ITER__END__fc1b8156_1a73_4041_9c9f_abb76ed7f2c9:
  __ITER__START__918d0e75_0ebb_4057_848b_35c6e3227824:
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
  JMP	__ITER__END__918d0e75_0ebb_4057_848b_35c6e3227824
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7aa54000_db54_4c5f_b7ef_ab41330bf4d2
  BNE	__CMP_YES_7aa54000_db54_4c5f_b7ef_ab41330bf4d2
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7aa54000_db54_4c5f_b7ef_ab41330bf4d2
  BNE	__CMP_YES_7aa54000_db54_4c5f_b7ef_ab41330bf4d2
  JMP	__CMP_YES_7aa54000_db54_4c5f_b7ef_ab41330bf4d2
  __CMP_YES_7aa54000_db54_4c5f_b7ef_ab41330bf4d2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7aa54000_db54_4c5f_b7ef_ab41330bf4d2
  __CMP_NO_7aa54000_db54_4c5f_b7ef_ab41330bf4d2:
  SEP	#$20
  LDA	#$00
  __CMP_END_7aa54000_db54_4c5f_b7ef_ab41330bf4d2:
  BEQ	__IFNOT_bb761842_e00c_4c06_bcab_6ee8f03c4c69
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
  __IFNOT_bb761842_e00c_4c06_bcab_6ee8f03c4c69:
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
  JMP	__ITER__START__918d0e75_0ebb_4057_848b_35c6e3227824
  __ITER__END__918d0e75_0ebb_4057_848b_35c6e3227824:
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
  __ITER__START__7bb028c1_6e36_4099_89ab_b3dc14fa46c5:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  BNE	__CMP_YES_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  BNE	__CMP_YES_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  BNE	__CMP_YES_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  BNE	__CMP_YES_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  JMP	__CMP_NO_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  __CMP_YES_d4839cfa_b4ea_4154_b11b_ca9e28f991f5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d4839cfa_b4ea_4154_b11b_ca9e28f991f5
  __CMP_NO_d4839cfa_b4ea_4154_b11b_ca9e28f991f5:
  SEP	#$20
  LDA	#$00
  __CMP_END_d4839cfa_b4ea_4154_b11b_ca9e28f991f5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7bb028c1_6e36_4099_89ab_b3dc14fa46c5
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 6
  SEP	#$10
  LDX	#$00
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
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  BNE	__IFNOT_abc20cf9_a27b_4aa7_b2fc_2960a9cfd858
  JMP	__ITER__END__7bb028c1_6e36_4099_89ab_b3dc14fa46c5
  __IFNOT_abc20cf9_a27b_4aa7_b2fc_2960a9cfd858:
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
  JMP	__ITER__START__7bb028c1_6e36_4099_89ab_b3dc14fa46c5
  __ITER__END__7bb028c1_6e36_4099_89ab_b3dc14fa46c5:
  __ITER__START__0afde7a8_0cd5_4bf0_8a05_9be516eac063:
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
  JMP	__ITER__END__0afde7a8_0cd5_4bf0_8a05_9be516eac063
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_4decee92_1051_4d3f_bc38_e9e3214510f4
  BNE	__CMP_YES_4decee92_1051_4d3f_bc38_e9e3214510f4
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_4decee92_1051_4d3f_bc38_e9e3214510f4
  BNE	__CMP_YES_4decee92_1051_4d3f_bc38_e9e3214510f4
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_4decee92_1051_4d3f_bc38_e9e3214510f4
  BNE	__CMP_YES_4decee92_1051_4d3f_bc38_e9e3214510f4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4decee92_1051_4d3f_bc38_e9e3214510f4
  BNE	__CMP_YES_4decee92_1051_4d3f_bc38_e9e3214510f4
  JMP	__CMP_YES_4decee92_1051_4d3f_bc38_e9e3214510f4
  __CMP_YES_4decee92_1051_4d3f_bc38_e9e3214510f4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4decee92_1051_4d3f_bc38_e9e3214510f4
  __CMP_NO_4decee92_1051_4d3f_bc38_e9e3214510f4:
  SEP	#$20
  LDA	#$00
  __CMP_END_4decee92_1051_4d3f_bc38_e9e3214510f4:
  BEQ	__IFNOT_67e3185e_b877_4047_9453_724aac518d32
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
  __IFNOT_67e3185e_b877_4047_9453_724aac518d32:
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
  JMP	__ITER__START__0afde7a8_0cd5_4bf0_8a05_9be516eac063
  __ITER__END__0afde7a8_0cd5_4bf0_8a05_9be516eac063:
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
  __ITER__START__578c2573_a5fd_40fe_a237_50edf52cf3db:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  BNE	__CMP_YES_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  BNE	__CMP_YES_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  BNE	__CMP_YES_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  BNE	__CMP_YES_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  BNE	__CMP_YES_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  JMP	__CMP_NO_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  __CMP_YES_b9b9cc9e_c838_4ce2_aaf8_122af788e956:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b9b9cc9e_c838_4ce2_aaf8_122af788e956
  __CMP_NO_b9b9cc9e_c838_4ce2_aaf8_122af788e956:
  SEP	#$20
  LDA	#$00
  __CMP_END_b9b9cc9e_c838_4ce2_aaf8_122af788e956:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__578c2573_a5fd_40fe_a237_50edf52cf3db
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_076ed1c3_325f_40cd_8893_b4c0f9d24eda
  JMP	__ITER__END__578c2573_a5fd_40fe_a237_50edf52cf3db
  __IFNOT_076ed1c3_325f_40cd_8893_b4c0f9d24eda:
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
  JMP	__ITER__START__578c2573_a5fd_40fe_a237_50edf52cf3db
  __ITER__END__578c2573_a5fd_40fe_a237_50edf52cf3db:
  __ITER__START__3f15e35a_71f4_4876_8456_74e541930997:
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
  JMP	__ITER__END__3f15e35a_71f4_4876_8456_74e541930997
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_c2f733c4_1991_4c64_8334_8b261f732977
  BNE	__CMP_YES_c2f733c4_1991_4c64_8334_8b261f732977
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_c2f733c4_1991_4c64_8334_8b261f732977
  BNE	__CMP_YES_c2f733c4_1991_4c64_8334_8b261f732977
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c2f733c4_1991_4c64_8334_8b261f732977
  BNE	__CMP_YES_c2f733c4_1991_4c64_8334_8b261f732977
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c2f733c4_1991_4c64_8334_8b261f732977
  BNE	__CMP_YES_c2f733c4_1991_4c64_8334_8b261f732977
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c2f733c4_1991_4c64_8334_8b261f732977
  BNE	__CMP_YES_c2f733c4_1991_4c64_8334_8b261f732977
  JMP	__CMP_YES_c2f733c4_1991_4c64_8334_8b261f732977
  __CMP_YES_c2f733c4_1991_4c64_8334_8b261f732977:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c2f733c4_1991_4c64_8334_8b261f732977
  __CMP_NO_c2f733c4_1991_4c64_8334_8b261f732977:
  SEP	#$20
  LDA	#$00
  __CMP_END_c2f733c4_1991_4c64_8334_8b261f732977:
  BEQ	__IFNOT_9fd2f062_8ddd_4bf8_9312_37d359831e3c
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
  __IFNOT_9fd2f062_8ddd_4bf8_9312_37d359831e3c:
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
  JMP	__ITER__START__3f15e35a_71f4_4876_8456_74e541930997
  __ITER__END__3f15e35a_71f4_4876_8456_74e541930997:
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
  __ITER__START__47cc7cfb_634f_4b32_847d_8952fe1b0951:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_5653796d_c7f1_4988_b1e7_77059ffca5e6
  BNE	__CMP_YES_5653796d_c7f1_4988_b1e7_77059ffca5e6
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_5653796d_c7f1_4988_b1e7_77059ffca5e6
  BNE	__CMP_YES_5653796d_c7f1_4988_b1e7_77059ffca5e6
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5653796d_c7f1_4988_b1e7_77059ffca5e6
  BNE	__CMP_YES_5653796d_c7f1_4988_b1e7_77059ffca5e6
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5653796d_c7f1_4988_b1e7_77059ffca5e6
  BNE	__CMP_YES_5653796d_c7f1_4988_b1e7_77059ffca5e6
  JMP	__CMP_NO_5653796d_c7f1_4988_b1e7_77059ffca5e6
  __CMP_YES_5653796d_c7f1_4988_b1e7_77059ffca5e6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5653796d_c7f1_4988_b1e7_77059ffca5e6
  __CMP_NO_5653796d_c7f1_4988_b1e7_77059ffca5e6:
  SEP	#$20
  LDA	#$00
  __CMP_END_5653796d_c7f1_4988_b1e7_77059ffca5e6:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__47cc7cfb_634f_4b32_847d_8952fe1b0951
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_3b721337_0af2_485e_9ad6_099d758afaf9
  JMP	__ITER__END__47cc7cfb_634f_4b32_847d_8952fe1b0951
  __IFNOT_3b721337_0af2_485e_9ad6_099d758afaf9:
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
  JMP	__ITER__START__47cc7cfb_634f_4b32_847d_8952fe1b0951
  __ITER__END__47cc7cfb_634f_4b32_847d_8952fe1b0951:
  __ITER__START__a5693c6a_406a_4da2_b5a8_57a002ca554f:
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
  JMP	__ITER__END__a5693c6a_406a_4da2_b5a8_57a002ca554f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  BNE	__CMP_YES_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  BNE	__CMP_YES_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  BNE	__CMP_YES_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  BNE	__CMP_YES_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  JMP	__CMP_YES_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  __CMP_YES_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b
  __CMP_NO_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b:
  SEP	#$20
  LDA	#$00
  __CMP_END_b5870425_5fa7_4c7e_bb08_6bd4e9dbdf3b:
  BEQ	__IFNOT_ab8b0c05_84af_4cd4_98d0_5892c2aab3b1
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
  __IFNOT_ab8b0c05_84af_4cd4_98d0_5892c2aab3b1:
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
  JMP	__ITER__START__a5693c6a_406a_4da2_b5a8_57a002ca554f
  __ITER__END__a5693c6a_406a_4da2_b5a8_57a002ca554f:
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
  __ITER__START__60d66e8d_bcf9_4078_a9c2_fe56bb30f204:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  BNE	__CMP_YES_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  BNE	__CMP_YES_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  BNE	__CMP_YES_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  BNE	__CMP_YES_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  BNE	__CMP_YES_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  JMP	__CMP_NO_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  __CMP_YES_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c
  __CMP_NO_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c:
  SEP	#$20
  LDA	#$00
  __CMP_END_9ecee57a_4207_4a8c_90bc_ebf9c2206f9c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__60d66e8d_bcf9_4078_a9c2_fe56bb30f204
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_59dedc8a_65ae_4fd7_b514_60f57907ffba
  JMP	__ITER__END__60d66e8d_bcf9_4078_a9c2_fe56bb30f204
  __IFNOT_59dedc8a_65ae_4fd7_b514_60f57907ffba:
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
  JMP	__ITER__START__60d66e8d_bcf9_4078_a9c2_fe56bb30f204
  __ITER__END__60d66e8d_bcf9_4078_a9c2_fe56bb30f204:
  __ITER__START__c9ad0e3a_f43a_4549_b53c_7c497303f545:
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
  JMP	__ITER__END__c9ad0e3a_f43a_4549_b53c_7c497303f545
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e04dfa5f_815c_4319_9dd4_1276c8783beb
  BNE	__CMP_YES_e04dfa5f_815c_4319_9dd4_1276c8783beb
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e04dfa5f_815c_4319_9dd4_1276c8783beb
  BNE	__CMP_YES_e04dfa5f_815c_4319_9dd4_1276c8783beb
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_e04dfa5f_815c_4319_9dd4_1276c8783beb
  BNE	__CMP_YES_e04dfa5f_815c_4319_9dd4_1276c8783beb
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e04dfa5f_815c_4319_9dd4_1276c8783beb
  BNE	__CMP_YES_e04dfa5f_815c_4319_9dd4_1276c8783beb
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e04dfa5f_815c_4319_9dd4_1276c8783beb
  BNE	__CMP_YES_e04dfa5f_815c_4319_9dd4_1276c8783beb
  JMP	__CMP_YES_e04dfa5f_815c_4319_9dd4_1276c8783beb
  __CMP_YES_e04dfa5f_815c_4319_9dd4_1276c8783beb:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e04dfa5f_815c_4319_9dd4_1276c8783beb
  __CMP_NO_e04dfa5f_815c_4319_9dd4_1276c8783beb:
  SEP	#$20
  LDA	#$00
  __CMP_END_e04dfa5f_815c_4319_9dd4_1276c8783beb:
  BEQ	__IFNOT_fb4547c7_037d_47c8_adcc_9379c7e5c41b
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
  __IFNOT_fb4547c7_037d_47c8_adcc_9379c7e5c41b:
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
  JMP	__ITER__START__c9ad0e3a_f43a_4549_b53c_7c497303f545
  __ITER__END__c9ad0e3a_f43a_4549_b53c_7c497303f545:
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
  __ITER__START__f8bdef2e_38d2_4920_8be9_401d84180a38:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_5c80181f_6764_400d_bf54_6e41e28b34cc
  BNE	__CMP_YES_5c80181f_6764_400d_bf54_6e41e28b34cc
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_5c80181f_6764_400d_bf54_6e41e28b34cc
  BNE	__CMP_YES_5c80181f_6764_400d_bf54_6e41e28b34cc
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5c80181f_6764_400d_bf54_6e41e28b34cc
  BNE	__CMP_YES_5c80181f_6764_400d_bf54_6e41e28b34cc
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5c80181f_6764_400d_bf54_6e41e28b34cc
  BNE	__CMP_YES_5c80181f_6764_400d_bf54_6e41e28b34cc
  JMP	__CMP_NO_5c80181f_6764_400d_bf54_6e41e28b34cc
  __CMP_YES_5c80181f_6764_400d_bf54_6e41e28b34cc:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5c80181f_6764_400d_bf54_6e41e28b34cc
  __CMP_NO_5c80181f_6764_400d_bf54_6e41e28b34cc:
  SEP	#$20
  LDA	#$00
  __CMP_END_5c80181f_6764_400d_bf54_6e41e28b34cc:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f8bdef2e_38d2_4920_8be9_401d84180a38
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_8f5d3059_bd97_47b4_b983_1db2d7324f1c
  JMP	__ITER__END__f8bdef2e_38d2_4920_8be9_401d84180a38
  __IFNOT_8f5d3059_bd97_47b4_b983_1db2d7324f1c:
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
  JMP	__ITER__START__f8bdef2e_38d2_4920_8be9_401d84180a38
  __ITER__END__f8bdef2e_38d2_4920_8be9_401d84180a38:
  __ITER__START__781a61c3_f881_4ef4_b8ed_77394fb6e936:
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
  JMP	__ITER__END__781a61c3_f881_4ef4_b8ed_77394fb6e936
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  BNE	__CMP_YES_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  BNE	__CMP_YES_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  BNE	__CMP_YES_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  BNE	__CMP_YES_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  JMP	__CMP_YES_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  __CMP_YES_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f
  __CMP_NO_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f:
  SEP	#$20
  LDA	#$00
  __CMP_END_8b9c89e9_aeef_4c4a_acf1_2f505956fd2f:
  BEQ	__IFNOT_a440b6a7_7417_44bd_9421_3e7312fc41f3
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
  __IFNOT_a440b6a7_7417_44bd_9421_3e7312fc41f3:
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
  JMP	__ITER__START__781a61c3_f881_4ef4_b8ed_77394fb6e936
  __ITER__END__781a61c3_f881_4ef4_b8ed_77394fb6e936:
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
  __ITER__START__d524339a_662f_4cb4_a85f_daa1fedb5526:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_32952ad0_bb1b_415e_8fae_22126f5096d5
  BNE	__CMP_YES_32952ad0_bb1b_415e_8fae_22126f5096d5
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_32952ad0_bb1b_415e_8fae_22126f5096d5
  BNE	__CMP_YES_32952ad0_bb1b_415e_8fae_22126f5096d5
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_32952ad0_bb1b_415e_8fae_22126f5096d5
  BNE	__CMP_YES_32952ad0_bb1b_415e_8fae_22126f5096d5
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_32952ad0_bb1b_415e_8fae_22126f5096d5
  BNE	__CMP_YES_32952ad0_bb1b_415e_8fae_22126f5096d5
  JMP	__CMP_NO_32952ad0_bb1b_415e_8fae_22126f5096d5
  __CMP_YES_32952ad0_bb1b_415e_8fae_22126f5096d5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_32952ad0_bb1b_415e_8fae_22126f5096d5
  __CMP_NO_32952ad0_bb1b_415e_8fae_22126f5096d5:
  SEP	#$20
  LDA	#$00
  __CMP_END_32952ad0_bb1b_415e_8fae_22126f5096d5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d524339a_662f_4cb4_a85f_daa1fedb5526
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 10
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 12
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 14
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 10
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 12
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 14
  CMP	#$0000
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  LDA	#$00
  STA	__@scratchBase + 1
  STA	__@scratchBase + 2
  STA	__@scratchBase + 3
  STA	__@scratchBase + 4
  STA	__@scratchBase + 5
  STA	__@scratchBase + 6
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 0
  REP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@scratchBase + 4
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@scratchBase + 6
  STA	__@scratchBase + 6
  BNE	__IFNOT_21266d22_96e4_4d99_9fb4_7bcf0c201798
  JMP	__ITER__END__d524339a_662f_4cb4_a85f_daa1fedb5526
  __IFNOT_21266d22_96e4_4d99_9fb4_7bcf0c201798:
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
  JMP	__ITER__START__d524339a_662f_4cb4_a85f_daa1fedb5526
  __ITER__END__d524339a_662f_4cb4_a85f_daa1fedb5526:
  __ITER__START__d371e627_a610_40e8_b692_6094b282a29a:
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
  JMP	__ITER__END__d371e627_a610_40e8_b692_6094b282a29a
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_dd4d5699_629d_40d2_8f71_fbc6fc562142
  BNE	__CMP_YES_dd4d5699_629d_40d2_8f71_fbc6fc562142
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_dd4d5699_629d_40d2_8f71_fbc6fc562142
  BNE	__CMP_YES_dd4d5699_629d_40d2_8f71_fbc6fc562142
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_dd4d5699_629d_40d2_8f71_fbc6fc562142
  BNE	__CMP_YES_dd4d5699_629d_40d2_8f71_fbc6fc562142
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_dd4d5699_629d_40d2_8f71_fbc6fc562142
  BNE	__CMP_YES_dd4d5699_629d_40d2_8f71_fbc6fc562142
  JMP	__CMP_YES_dd4d5699_629d_40d2_8f71_fbc6fc562142
  __CMP_YES_dd4d5699_629d_40d2_8f71_fbc6fc562142:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_dd4d5699_629d_40d2_8f71_fbc6fc562142
  __CMP_NO_dd4d5699_629d_40d2_8f71_fbc6fc562142:
  SEP	#$20
  LDA	#$00
  __CMP_END_dd4d5699_629d_40d2_8f71_fbc6fc562142:
  BNE	:+
  JMP	__IFNOT_fbc3d8ca_99f7_4bf0_a2b7_cf8f8ab3764f
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
  __IFNOT_fbc3d8ca_99f7_4bf0_a2b7_cf8f8ab3764f:
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
  JMP	__ITER__START__d371e627_a610_40e8_b692_6094b282a29a
  __ITER__END__d371e627_a610_40e8_b692_6094b282a29a:
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
