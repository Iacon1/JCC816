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
  __ITER__START__b9e7a2c9_d31c_47e9_9c49_de1b01b6d800:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f5c010e9_23ca_47e9_b6cd_7487c33529a8
  BNE	__CMP_YES_f5c010e9_23ca_47e9_b6cd_7487c33529a8
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f5c010e9_23ca_47e9_b6cd_7487c33529a8
  BNE	__CMP_YES_f5c010e9_23ca_47e9_b6cd_7487c33529a8
  JMP	__CMP_NO_f5c010e9_23ca_47e9_b6cd_7487c33529a8
  __CMP_YES_f5c010e9_23ca_47e9_b6cd_7487c33529a8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f5c010e9_23ca_47e9_b6cd_7487c33529a8
  __CMP_NO_f5c010e9_23ca_47e9_b6cd_7487c33529a8:
  SEP	#$20
  LDA	#$00
  __CMP_END_f5c010e9_23ca_47e9_b6cd_7487c33529a8:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b9e7a2c9_d31c_47e9_9c49_de1b01b6d800
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
  BNE	__IFNOT_204f72d8_5b55_45d1_a6ea_174a368770fa
  JMP	__ITER__END__b9e7a2c9_d31c_47e9_9c49_de1b01b6d800
  __IFNOT_204f72d8_5b55_45d1_a6ea_174a368770fa:
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
  JMP	__ITER__START__b9e7a2c9_d31c_47e9_9c49_de1b01b6d800
  __ITER__END__b9e7a2c9_d31c_47e9_9c49_de1b01b6d800:
  __ITER__START__7e1d8691_92a5_43c7_96ae_9a82b886c989:
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
  JMP	__ITER__END__7e1d8691_92a5_43c7_96ae_9a82b886c989
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_7b3f19d7_4638_4b86_92fa_0f22fea7d054
  BNE	__CMP_YES_7b3f19d7_4638_4b86_92fa_0f22fea7d054
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7b3f19d7_4638_4b86_92fa_0f22fea7d054
  BNE	__CMP_YES_7b3f19d7_4638_4b86_92fa_0f22fea7d054
  JMP	__CMP_YES_7b3f19d7_4638_4b86_92fa_0f22fea7d054
  __CMP_YES_7b3f19d7_4638_4b86_92fa_0f22fea7d054:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7b3f19d7_4638_4b86_92fa_0f22fea7d054
  __CMP_NO_7b3f19d7_4638_4b86_92fa_0f22fea7d054:
  SEP	#$20
  LDA	#$00
  __CMP_END_7b3f19d7_4638_4b86_92fa_0f22fea7d054:
  BEQ	__IFNOT_8ff5d3aa_e5e3_43e1_be3a_e091f4c6c4d0
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
  __IFNOT_8ff5d3aa_e5e3_43e1_be3a_e091f4c6c4d0:
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
  JMP	__ITER__START__7e1d8691_92a5_43c7_96ae_9a82b886c989
  __ITER__END__7e1d8691_92a5_43c7_96ae_9a82b886c989:
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
  __ITER__START__763740b7_f03a_4c7f_a3ee_01351443bf4e:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_40f72d14_1182_4b7b_98ef_b748654368ce
  BNE	__CMP_YES_40f72d14_1182_4b7b_98ef_b748654368ce
  JMP	__CMP_NO_40f72d14_1182_4b7b_98ef_b748654368ce
  __CMP_YES_40f72d14_1182_4b7b_98ef_b748654368ce:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_40f72d14_1182_4b7b_98ef_b748654368ce
  __CMP_NO_40f72d14_1182_4b7b_98ef_b748654368ce:
  SEP	#$20
  LDA	#$00
  __CMP_END_40f72d14_1182_4b7b_98ef_b748654368ce:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__763740b7_f03a_4c7f_a3ee_01351443bf4e
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
  BNE	__IFNOT_c26203a2_4f73_4d29_b4a0_953f48ab65dc
  JMP	__ITER__END__763740b7_f03a_4c7f_a3ee_01351443bf4e
  __IFNOT_c26203a2_4f73_4d29_b4a0_953f48ab65dc:
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
  JMP	__ITER__START__763740b7_f03a_4c7f_a3ee_01351443bf4e
  __ITER__END__763740b7_f03a_4c7f_a3ee_01351443bf4e:
  __ITER__START__6266cd13_0dd7_4264_a6f7_c91f16559541:
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
  JMP	__ITER__END__6266cd13_0dd7_4264_a6f7_c91f16559541
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6f5b26be_20d5_4c55_adba_a16fe6bdd4f5
  BNE	__CMP_YES_6f5b26be_20d5_4c55_adba_a16fe6bdd4f5
  JMP	__CMP_YES_6f5b26be_20d5_4c55_adba_a16fe6bdd4f5
  __CMP_YES_6f5b26be_20d5_4c55_adba_a16fe6bdd4f5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6f5b26be_20d5_4c55_adba_a16fe6bdd4f5
  __CMP_NO_6f5b26be_20d5_4c55_adba_a16fe6bdd4f5:
  SEP	#$20
  LDA	#$00
  __CMP_END_6f5b26be_20d5_4c55_adba_a16fe6bdd4f5:
  BEQ	__IFNOT_fe1f62de_e6c5_4474_84e5_0d92920fe5f6
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
  __IFNOT_fe1f62de_e6c5_4474_84e5_0d92920fe5f6:
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
  JMP	__ITER__START__6266cd13_0dd7_4264_a6f7_c91f16559541
  __ITER__END__6266cd13_0dd7_4264_a6f7_c91f16559541:
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
  __ITER__START__fd6e71fb_0355_4486_8e9d_fa459f19830b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_3507d5d9_8300_4d7c_b56f_1baf5e57139b
  BNE	__CMP_YES_3507d5d9_8300_4d7c_b56f_1baf5e57139b
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3507d5d9_8300_4d7c_b56f_1baf5e57139b
  BNE	__CMP_YES_3507d5d9_8300_4d7c_b56f_1baf5e57139b
  JMP	__CMP_NO_3507d5d9_8300_4d7c_b56f_1baf5e57139b
  __CMP_YES_3507d5d9_8300_4d7c_b56f_1baf5e57139b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3507d5d9_8300_4d7c_b56f_1baf5e57139b
  __CMP_NO_3507d5d9_8300_4d7c_b56f_1baf5e57139b:
  SEP	#$20
  LDA	#$00
  __CMP_END_3507d5d9_8300_4d7c_b56f_1baf5e57139b:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__fd6e71fb_0355_4486_8e9d_fa459f19830b
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
  BNE	__IFNOT_b30795b7_b3b7_4c29_98cb_e73ea23d890d
  JMP	__ITER__END__fd6e71fb_0355_4486_8e9d_fa459f19830b
  __IFNOT_b30795b7_b3b7_4c29_98cb_e73ea23d890d:
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
  JMP	__ITER__START__fd6e71fb_0355_4486_8e9d_fa459f19830b
  __ITER__END__fd6e71fb_0355_4486_8e9d_fa459f19830b:
  __ITER__START__4008d61e_524c_410a_a3b8_d4e6b16318c3:
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
  JMP	__ITER__END__4008d61e_524c_410a_a3b8_d4e6b16318c3
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_354aeb5b_58b0_4b97_acb1_599b6feadff7
  BNE	__CMP_YES_354aeb5b_58b0_4b97_acb1_599b6feadff7
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_354aeb5b_58b0_4b97_acb1_599b6feadff7
  BNE	__CMP_YES_354aeb5b_58b0_4b97_acb1_599b6feadff7
  JMP	__CMP_YES_354aeb5b_58b0_4b97_acb1_599b6feadff7
  __CMP_YES_354aeb5b_58b0_4b97_acb1_599b6feadff7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_354aeb5b_58b0_4b97_acb1_599b6feadff7
  __CMP_NO_354aeb5b_58b0_4b97_acb1_599b6feadff7:
  SEP	#$20
  LDA	#$00
  __CMP_END_354aeb5b_58b0_4b97_acb1_599b6feadff7:
  BEQ	__IFNOT_fc10b905_6255_4996_97b3_923044688c43
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
  __IFNOT_fc10b905_6255_4996_97b3_923044688c43:
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
  JMP	__ITER__START__4008d61e_524c_410a_a3b8_d4e6b16318c3
  __ITER__END__4008d61e_524c_410a_a3b8_d4e6b16318c3:
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
  __ITER__START__4c268d50_3ed7_4ae1_89c5_6d3fed2e65e4:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_06d49eb7_d347_4ddb_add4_9aaa31c044d4
  BNE	__CMP_YES_06d49eb7_d347_4ddb_add4_9aaa31c044d4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_06d49eb7_d347_4ddb_add4_9aaa31c044d4
  BNE	__CMP_YES_06d49eb7_d347_4ddb_add4_9aaa31c044d4
  JMP	__CMP_NO_06d49eb7_d347_4ddb_add4_9aaa31c044d4
  __CMP_YES_06d49eb7_d347_4ddb_add4_9aaa31c044d4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_06d49eb7_d347_4ddb_add4_9aaa31c044d4
  __CMP_NO_06d49eb7_d347_4ddb_add4_9aaa31c044d4:
  SEP	#$20
  LDA	#$00
  __CMP_END_06d49eb7_d347_4ddb_add4_9aaa31c044d4:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4c268d50_3ed7_4ae1_89c5_6d3fed2e65e4
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
  BNE	__IFNOT_b93528dc_d77d_47ea_9030_72af9a9eac97
  JMP	__ITER__END__4c268d50_3ed7_4ae1_89c5_6d3fed2e65e4
  __IFNOT_b93528dc_d77d_47ea_9030_72af9a9eac97:
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
  JMP	__ITER__START__4c268d50_3ed7_4ae1_89c5_6d3fed2e65e4
  __ITER__END__4c268d50_3ed7_4ae1_89c5_6d3fed2e65e4:
  __ITER__START__ac414a85_e56f_43d0_9f94_03c6f8e5138c:
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
  JMP	__ITER__END__ac414a85_e56f_43d0_9f94_03c6f8e5138c
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_53c5a42a_d7a8_4a4c_a386_b47140ec4038
  BNE	__CMP_YES_53c5a42a_d7a8_4a4c_a386_b47140ec4038
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_53c5a42a_d7a8_4a4c_a386_b47140ec4038
  BNE	__CMP_YES_53c5a42a_d7a8_4a4c_a386_b47140ec4038
  JMP	__CMP_YES_53c5a42a_d7a8_4a4c_a386_b47140ec4038
  __CMP_YES_53c5a42a_d7a8_4a4c_a386_b47140ec4038:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_53c5a42a_d7a8_4a4c_a386_b47140ec4038
  __CMP_NO_53c5a42a_d7a8_4a4c_a386_b47140ec4038:
  SEP	#$20
  LDA	#$00
  __CMP_END_53c5a42a_d7a8_4a4c_a386_b47140ec4038:
  BEQ	__IFNOT_ac06827f_892f_4f7a_bf43_f4b0bdefac95
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
  __IFNOT_ac06827f_892f_4f7a_bf43_f4b0bdefac95:
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
  JMP	__ITER__START__ac414a85_e56f_43d0_9f94_03c6f8e5138c
  __ITER__END__ac414a85_e56f_43d0_9f94_03c6f8e5138c:
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
  __ITER__START__4b7b98fb_b2fb_476a_aa3d_803ed5841dda:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  BNE	__CMP_YES_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  BNE	__CMP_YES_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  BNE	__CMP_YES_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  BNE	__CMP_YES_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  JMP	__CMP_NO_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  __CMP_YES_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0
  __CMP_NO_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0:
  SEP	#$20
  LDA	#$00
  __CMP_END_eb340472_1e71_4f8e_b3bc_b3244bbdcdb0:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4b7b98fb_b2fb_476a_aa3d_803ed5841dda
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
  BNE	__IFNOT_31d11ec0_e550_4324_a116_562747363fb8
  JMP	__ITER__END__4b7b98fb_b2fb_476a_aa3d_803ed5841dda
  __IFNOT_31d11ec0_e550_4324_a116_562747363fb8:
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
  JMP	__ITER__START__4b7b98fb_b2fb_476a_aa3d_803ed5841dda
  __ITER__END__4b7b98fb_b2fb_476a_aa3d_803ed5841dda:
  __ITER__START__8a656cc9_eee8_43fc_ba37_4b1196b250b0:
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
  JMP	__ITER__END__8a656cc9_eee8_43fc_ba37_4b1196b250b0
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_db663599_ddc1_4b0b_bd89_5e33849abe2a
  BNE	__CMP_YES_db663599_ddc1_4b0b_bd89_5e33849abe2a
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_db663599_ddc1_4b0b_bd89_5e33849abe2a
  BNE	__CMP_YES_db663599_ddc1_4b0b_bd89_5e33849abe2a
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_db663599_ddc1_4b0b_bd89_5e33849abe2a
  BNE	__CMP_YES_db663599_ddc1_4b0b_bd89_5e33849abe2a
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_db663599_ddc1_4b0b_bd89_5e33849abe2a
  BNE	__CMP_YES_db663599_ddc1_4b0b_bd89_5e33849abe2a
  JMP	__CMP_YES_db663599_ddc1_4b0b_bd89_5e33849abe2a
  __CMP_YES_db663599_ddc1_4b0b_bd89_5e33849abe2a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_db663599_ddc1_4b0b_bd89_5e33849abe2a
  __CMP_NO_db663599_ddc1_4b0b_bd89_5e33849abe2a:
  SEP	#$20
  LDA	#$00
  __CMP_END_db663599_ddc1_4b0b_bd89_5e33849abe2a:
  BEQ	__IFNOT_31326ba8_1cc4_4ccf_82ef_30ef45c19c1c
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
  __IFNOT_31326ba8_1cc4_4ccf_82ef_30ef45c19c1c:
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
  JMP	__ITER__START__8a656cc9_eee8_43fc_ba37_4b1196b250b0
  __ITER__END__8a656cc9_eee8_43fc_ba37_4b1196b250b0:
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
  __ITER__START__e1c05cab_5774_4936_bb0c_522dad9a1269:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_3eaace26_f391_47d6_9cb6_cbc495631a65
  BNE	__CMP_YES_3eaace26_f391_47d6_9cb6_cbc495631a65
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3eaace26_f391_47d6_9cb6_cbc495631a65
  BNE	__CMP_YES_3eaace26_f391_47d6_9cb6_cbc495631a65
  JMP	__CMP_NO_3eaace26_f391_47d6_9cb6_cbc495631a65
  __CMP_YES_3eaace26_f391_47d6_9cb6_cbc495631a65:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3eaace26_f391_47d6_9cb6_cbc495631a65
  __CMP_NO_3eaace26_f391_47d6_9cb6_cbc495631a65:
  SEP	#$20
  LDA	#$00
  __CMP_END_3eaace26_f391_47d6_9cb6_cbc495631a65:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e1c05cab_5774_4936_bb0c_522dad9a1269
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
  BNE	__IFNOT_5788f9f1_2c9c_4a23_94c1_6775472541b8
  JMP	__ITER__END__e1c05cab_5774_4936_bb0c_522dad9a1269
  __IFNOT_5788f9f1_2c9c_4a23_94c1_6775472541b8:
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
  JMP	__ITER__START__e1c05cab_5774_4936_bb0c_522dad9a1269
  __ITER__END__e1c05cab_5774_4936_bb0c_522dad9a1269:
  __ITER__START__f80977d7_b98d_4174_864b_4de4e0948e41:
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
  JMP	__ITER__END__f80977d7_b98d_4174_864b_4de4e0948e41
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_4e0ac496_c1ba_40fc_9629_4790d78feade
  BNE	__CMP_YES_4e0ac496_c1ba_40fc_9629_4790d78feade
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4e0ac496_c1ba_40fc_9629_4790d78feade
  BNE	__CMP_YES_4e0ac496_c1ba_40fc_9629_4790d78feade
  JMP	__CMP_YES_4e0ac496_c1ba_40fc_9629_4790d78feade
  __CMP_YES_4e0ac496_c1ba_40fc_9629_4790d78feade:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4e0ac496_c1ba_40fc_9629_4790d78feade
  __CMP_NO_4e0ac496_c1ba_40fc_9629_4790d78feade:
  SEP	#$20
  LDA	#$00
  __CMP_END_4e0ac496_c1ba_40fc_9629_4790d78feade:
  BEQ	__IFNOT_592be2f2_30e1_4cbe_86d7_8c1325418aed
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
  __IFNOT_592be2f2_30e1_4cbe_86d7_8c1325418aed:
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
  JMP	__ITER__START__f80977d7_b98d_4174_864b_4de4e0948e41
  __ITER__END__f80977d7_b98d_4174_864b_4de4e0948e41:
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
  __ITER__START__db591c54_430a_47b5_8796_510180245356:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_0f530af6_83b6_4bc9_973e_52d7b700477f
  BNE	__CMP_YES_0f530af6_83b6_4bc9_973e_52d7b700477f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0f530af6_83b6_4bc9_973e_52d7b700477f
  BNE	__CMP_YES_0f530af6_83b6_4bc9_973e_52d7b700477f
  JMP	__CMP_NO_0f530af6_83b6_4bc9_973e_52d7b700477f
  __CMP_YES_0f530af6_83b6_4bc9_973e_52d7b700477f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0f530af6_83b6_4bc9_973e_52d7b700477f
  __CMP_NO_0f530af6_83b6_4bc9_973e_52d7b700477f:
  SEP	#$20
  LDA	#$00
  __CMP_END_0f530af6_83b6_4bc9_973e_52d7b700477f:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__db591c54_430a_47b5_8796_510180245356
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
  BNE	__IFNOT_2ca940a0_ce48_4ba0_b9de_e92e305848c0
  JMP	__ITER__END__db591c54_430a_47b5_8796_510180245356
  __IFNOT_2ca940a0_ce48_4ba0_b9de_e92e305848c0:
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
  JMP	__ITER__START__db591c54_430a_47b5_8796_510180245356
  __ITER__END__db591c54_430a_47b5_8796_510180245356:
  __ITER__START__e7721ce8_dd82_4c1a_a69c_087cfc28b8b7:
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
  JMP	__ITER__END__e7721ce8_dd82_4c1a_a69c_087cfc28b8b7
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f57402de_0fd9_471d_8a36_00393937d8bc
  BNE	__CMP_YES_f57402de_0fd9_471d_8a36_00393937d8bc
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f57402de_0fd9_471d_8a36_00393937d8bc
  BNE	__CMP_YES_f57402de_0fd9_471d_8a36_00393937d8bc
  JMP	__CMP_YES_f57402de_0fd9_471d_8a36_00393937d8bc
  __CMP_YES_f57402de_0fd9_471d_8a36_00393937d8bc:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f57402de_0fd9_471d_8a36_00393937d8bc
  __CMP_NO_f57402de_0fd9_471d_8a36_00393937d8bc:
  SEP	#$20
  LDA	#$00
  __CMP_END_f57402de_0fd9_471d_8a36_00393937d8bc:
  BEQ	__IFNOT_4c15530a_453d_46f4_8bac_c66047c9fd55
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
  __IFNOT_4c15530a_453d_46f4_8bac_c66047c9fd55:
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
  JMP	__ITER__START__e7721ce8_dd82_4c1a_a69c_087cfc28b8b7
  __ITER__END__e7721ce8_dd82_4c1a_a69c_087cfc28b8b7:
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
  __ITER__START__2b935b0f_8b5d_44f4_9658_bc406b4017a6:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8b27343b_0282_4095_8339_8d35f8bed1d8
  BNE	__CMP_YES_8b27343b_0282_4095_8339_8d35f8bed1d8
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8b27343b_0282_4095_8339_8d35f8bed1d8
  BNE	__CMP_YES_8b27343b_0282_4095_8339_8d35f8bed1d8
  JMP	__CMP_NO_8b27343b_0282_4095_8339_8d35f8bed1d8
  __CMP_YES_8b27343b_0282_4095_8339_8d35f8bed1d8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8b27343b_0282_4095_8339_8d35f8bed1d8
  __CMP_NO_8b27343b_0282_4095_8339_8d35f8bed1d8:
  SEP	#$20
  LDA	#$00
  __CMP_END_8b27343b_0282_4095_8339_8d35f8bed1d8:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__2b935b0f_8b5d_44f4_9658_bc406b4017a6
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
  BNE	__IFNOT_f6f78a76_a0cb_4e53_8ef7_35459e7ec9b3
  JMP	__ITER__END__2b935b0f_8b5d_44f4_9658_bc406b4017a6
  __IFNOT_f6f78a76_a0cb_4e53_8ef7_35459e7ec9b3:
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
  JMP	__ITER__START__2b935b0f_8b5d_44f4_9658_bc406b4017a6
  __ITER__END__2b935b0f_8b5d_44f4_9658_bc406b4017a6:
  __ITER__START__3385ffbb_d8f8_4225_8bf1_68704281817c:
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
  JMP	__ITER__END__3385ffbb_d8f8_4225_8bf1_68704281817c
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b8df6a41_c766_41d7_af87_214d97013f64
  BNE	__CMP_YES_b8df6a41_c766_41d7_af87_214d97013f64
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b8df6a41_c766_41d7_af87_214d97013f64
  BNE	__CMP_YES_b8df6a41_c766_41d7_af87_214d97013f64
  JMP	__CMP_YES_b8df6a41_c766_41d7_af87_214d97013f64
  __CMP_YES_b8df6a41_c766_41d7_af87_214d97013f64:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b8df6a41_c766_41d7_af87_214d97013f64
  __CMP_NO_b8df6a41_c766_41d7_af87_214d97013f64:
  SEP	#$20
  LDA	#$00
  __CMP_END_b8df6a41_c766_41d7_af87_214d97013f64:
  BEQ	__IFNOT_e309728e_1373_4ab5_8a45_93746e0ed940
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
  __IFNOT_e309728e_1373_4ab5_8a45_93746e0ed940:
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
  JMP	__ITER__START__3385ffbb_d8f8_4225_8bf1_68704281817c
  __ITER__END__3385ffbb_d8f8_4225_8bf1_68704281817c:
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
  __ITER__START__43eae53d_b1b6_4022_9bf0_2873f2a4624b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17
  BNE	__CMP_YES_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17
  BNE	__CMP_YES_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17
  BNE	__CMP_YES_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17
  JMP	__CMP_NO_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17
  __CMP_YES_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17
  __CMP_NO_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17:
  SEP	#$20
  LDA	#$00
  __CMP_END_85a64ff5_a6f5_48fb_bfb3_d2a56244fe17:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__43eae53d_b1b6_4022_9bf0_2873f2a4624b
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
  BNE	__IFNOT_92ae211a_9b32_4553_aaf2_5f74645fc830
  JMP	__ITER__END__43eae53d_b1b6_4022_9bf0_2873f2a4624b
  __IFNOT_92ae211a_9b32_4553_aaf2_5f74645fc830:
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
  JMP	__ITER__START__43eae53d_b1b6_4022_9bf0_2873f2a4624b
  __ITER__END__43eae53d_b1b6_4022_9bf0_2873f2a4624b:
  __ITER__START__4e073406_056f_4061_bbd7_b06c3a53fd90:
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
  JMP	__ITER__END__4e073406_056f_4061_bbd7_b06c3a53fd90
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_9ecf12de_327d_4ae8_b117_2d8375126da4
  BNE	__CMP_YES_9ecf12de_327d_4ae8_b117_2d8375126da4
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_9ecf12de_327d_4ae8_b117_2d8375126da4
  BNE	__CMP_YES_9ecf12de_327d_4ae8_b117_2d8375126da4
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9ecf12de_327d_4ae8_b117_2d8375126da4
  BNE	__CMP_YES_9ecf12de_327d_4ae8_b117_2d8375126da4
  JMP	__CMP_YES_9ecf12de_327d_4ae8_b117_2d8375126da4
  __CMP_YES_9ecf12de_327d_4ae8_b117_2d8375126da4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9ecf12de_327d_4ae8_b117_2d8375126da4
  __CMP_NO_9ecf12de_327d_4ae8_b117_2d8375126da4:
  SEP	#$20
  LDA	#$00
  __CMP_END_9ecf12de_327d_4ae8_b117_2d8375126da4:
  BEQ	__IFNOT_b2398030_438a_44a8_8a6e_647a730cd066
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
  __IFNOT_b2398030_438a_44a8_8a6e_647a730cd066:
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
  JMP	__ITER__START__4e073406_056f_4061_bbd7_b06c3a53fd90
  __ITER__END__4e073406_056f_4061_bbd7_b06c3a53fd90:
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
  __ITER__START__4305a167_81f9_457d_b49f_9f67f663f83a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  BNE	__CMP_YES_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  BNE	__CMP_YES_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  BNE	__CMP_YES_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  BNE	__CMP_YES_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  BNE	__CMP_YES_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  JMP	__CMP_NO_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  __CMP_YES_a6e80078_7b1d_479b_bef8_eae1d2d713d4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a6e80078_7b1d_479b_bef8_eae1d2d713d4
  __CMP_NO_a6e80078_7b1d_479b_bef8_eae1d2d713d4:
  SEP	#$20
  LDA	#$00
  __CMP_END_a6e80078_7b1d_479b_bef8_eae1d2d713d4:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4305a167_81f9_457d_b49f_9f67f663f83a
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
  BNE	__IFNOT_32737708_1ddd_473b_bef7_8bcd3bf6dda8
  JMP	__ITER__END__4305a167_81f9_457d_b49f_9f67f663f83a
  __IFNOT_32737708_1ddd_473b_bef7_8bcd3bf6dda8:
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
  JMP	__ITER__START__4305a167_81f9_457d_b49f_9f67f663f83a
  __ITER__END__4305a167_81f9_457d_b49f_9f67f663f83a:
  __ITER__START__86e6a96e_8405_4bf2_b90e_754bd30c2f0a:
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
  JMP	__ITER__END__86e6a96e_8405_4bf2_b90e_754bd30c2f0a
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  BNE	__CMP_YES_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  BNE	__CMP_YES_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  BNE	__CMP_YES_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  BNE	__CMP_YES_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  BNE	__CMP_YES_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  JMP	__CMP_YES_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  __CMP_YES_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928
  __CMP_NO_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928:
  SEP	#$20
  LDA	#$00
  __CMP_END_e6fdc90b_c5a9_4c4c_99fd_ec6cad75f928:
  BNE	:+
  JMP	__IFNOT_b499b252_9fad_4047_89eb_b5bc3382006d
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
  __IFNOT_b499b252_9fad_4047_89eb_b5bc3382006d:
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
  JMP	__ITER__START__86e6a96e_8405_4bf2_b90e_754bd30c2f0a
  __ITER__END__86e6a96e_8405_4bf2_b90e_754bd30c2f0a:
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
  __ITER__START__5274abcc_752f_4459_af4d_d95905d649a7:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_563e60f1_7a96_4f8d_8fb1_204d72849542
  BNE	__CMP_YES_563e60f1_7a96_4f8d_8fb1_204d72849542
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_563e60f1_7a96_4f8d_8fb1_204d72849542
  BNE	__CMP_YES_563e60f1_7a96_4f8d_8fb1_204d72849542
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_563e60f1_7a96_4f8d_8fb1_204d72849542
  BNE	__CMP_YES_563e60f1_7a96_4f8d_8fb1_204d72849542
  JMP	__CMP_NO_563e60f1_7a96_4f8d_8fb1_204d72849542
  __CMP_YES_563e60f1_7a96_4f8d_8fb1_204d72849542:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_563e60f1_7a96_4f8d_8fb1_204d72849542
  __CMP_NO_563e60f1_7a96_4f8d_8fb1_204d72849542:
  SEP	#$20
  LDA	#$00
  __CMP_END_563e60f1_7a96_4f8d_8fb1_204d72849542:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5274abcc_752f_4459_af4d_d95905d649a7
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
  BNE	__IFNOT_f9a212a1_0e75_486f_ac71_c0ead4aa382d
  JMP	__ITER__END__5274abcc_752f_4459_af4d_d95905d649a7
  __IFNOT_f9a212a1_0e75_486f_ac71_c0ead4aa382d:
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
  JMP	__ITER__START__5274abcc_752f_4459_af4d_d95905d649a7
  __ITER__END__5274abcc_752f_4459_af4d_d95905d649a7:
  __ITER__START__c99d971e_40c3_4ad9_bc2a_bc79879147e1:
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
  JMP	__ITER__END__c99d971e_40c3_4ad9_bc2a_bc79879147e1
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744
  BNE	__CMP_YES_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744
  BNE	__CMP_YES_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744
  BNE	__CMP_YES_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744
  JMP	__CMP_YES_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744
  __CMP_YES_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744
  __CMP_NO_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744:
  SEP	#$20
  LDA	#$00
  __CMP_END_7c6af8ac_f81d_42dd_b1de_aad9fe2e5744:
  BEQ	__IFNOT_cfb3f379_e940_46a1_9588_aa3e70289f01
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
  __IFNOT_cfb3f379_e940_46a1_9588_aa3e70289f01:
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
  JMP	__ITER__START__c99d971e_40c3_4ad9_bc2a_bc79879147e1
  __ITER__END__c99d971e_40c3_4ad9_bc2a_bc79879147e1:
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
  __ITER__START__914f140d_d2e5_4790_a233_d6041b487156:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3d9b8f03_7979_4e2e_8c22_53f140c9aace
  BNE	__CMP_YES_3d9b8f03_7979_4e2e_8c22_53f140c9aace
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3d9b8f03_7979_4e2e_8c22_53f140c9aace
  BNE	__CMP_YES_3d9b8f03_7979_4e2e_8c22_53f140c9aace
  JMP	__CMP_NO_3d9b8f03_7979_4e2e_8c22_53f140c9aace
  __CMP_YES_3d9b8f03_7979_4e2e_8c22_53f140c9aace:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3d9b8f03_7979_4e2e_8c22_53f140c9aace
  __CMP_NO_3d9b8f03_7979_4e2e_8c22_53f140c9aace:
  SEP	#$20
  LDA	#$00
  __CMP_END_3d9b8f03_7979_4e2e_8c22_53f140c9aace:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__914f140d_d2e5_4790_a233_d6041b487156
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
  BNE	__IFNOT_48c605d2_f92a_4383_a0f6_0b839bb8224f
  JMP	__ITER__END__914f140d_d2e5_4790_a233_d6041b487156
  __IFNOT_48c605d2_f92a_4383_a0f6_0b839bb8224f:
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
  JMP	__ITER__START__914f140d_d2e5_4790_a233_d6041b487156
  __ITER__END__914f140d_d2e5_4790_a233_d6041b487156:
  __ITER__START__4bd7c724_7aba_4a3c_9e89_1527f9c061c5:
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
  JMP	__ITER__END__4bd7c724_7aba_4a3c_9e89_1527f9c061c5
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_77e5361b_f02f_4efb_b4c0_04bc05aa1e56
  BNE	__CMP_YES_77e5361b_f02f_4efb_b4c0_04bc05aa1e56
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_77e5361b_f02f_4efb_b4c0_04bc05aa1e56
  BNE	__CMP_YES_77e5361b_f02f_4efb_b4c0_04bc05aa1e56
  JMP	__CMP_YES_77e5361b_f02f_4efb_b4c0_04bc05aa1e56
  __CMP_YES_77e5361b_f02f_4efb_b4c0_04bc05aa1e56:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_77e5361b_f02f_4efb_b4c0_04bc05aa1e56
  __CMP_NO_77e5361b_f02f_4efb_b4c0_04bc05aa1e56:
  SEP	#$20
  LDA	#$00
  __CMP_END_77e5361b_f02f_4efb_b4c0_04bc05aa1e56:
  BEQ	__IFNOT_aa328461_9f54_4d4b_a838_f4f2395ceb81
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
  __IFNOT_aa328461_9f54_4d4b_a838_f4f2395ceb81:
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
  JMP	__ITER__START__4bd7c724_7aba_4a3c_9e89_1527f9c061c5
  __ITER__END__4bd7c724_7aba_4a3c_9e89_1527f9c061c5:
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
  __ITER__START__b74ac516_d92f_4bae_b17b_ce41501d10e2:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_e618e343_c971_43d5_aa93_6401f0381884
  BNE	__CMP_YES_e618e343_c971_43d5_aa93_6401f0381884
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e618e343_c971_43d5_aa93_6401f0381884
  BNE	__CMP_YES_e618e343_c971_43d5_aa93_6401f0381884
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e618e343_c971_43d5_aa93_6401f0381884
  BNE	__CMP_YES_e618e343_c971_43d5_aa93_6401f0381884
  JMP	__CMP_NO_e618e343_c971_43d5_aa93_6401f0381884
  __CMP_YES_e618e343_c971_43d5_aa93_6401f0381884:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e618e343_c971_43d5_aa93_6401f0381884
  __CMP_NO_e618e343_c971_43d5_aa93_6401f0381884:
  SEP	#$20
  LDA	#$00
  __CMP_END_e618e343_c971_43d5_aa93_6401f0381884:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b74ac516_d92f_4bae_b17b_ce41501d10e2
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
  BNE	__IFNOT_bde7ac35_1c3c_4e73_9667_7d332f905bfa
  JMP	__ITER__END__b74ac516_d92f_4bae_b17b_ce41501d10e2
  __IFNOT_bde7ac35_1c3c_4e73_9667_7d332f905bfa:
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
  JMP	__ITER__START__b74ac516_d92f_4bae_b17b_ce41501d10e2
  __ITER__END__b74ac516_d92f_4bae_b17b_ce41501d10e2:
  __ITER__START__a0dd91d8_a3b7_4faa_a794_884b318a7487:
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
  JMP	__ITER__END__a0dd91d8_a3b7_4faa_a794_884b318a7487
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_000b16b7_4deb_471d_8d08_06a049d81c87
  BNE	__CMP_YES_000b16b7_4deb_471d_8d08_06a049d81c87
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_000b16b7_4deb_471d_8d08_06a049d81c87
  BNE	__CMP_YES_000b16b7_4deb_471d_8d08_06a049d81c87
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_000b16b7_4deb_471d_8d08_06a049d81c87
  BNE	__CMP_YES_000b16b7_4deb_471d_8d08_06a049d81c87
  JMP	__CMP_YES_000b16b7_4deb_471d_8d08_06a049d81c87
  __CMP_YES_000b16b7_4deb_471d_8d08_06a049d81c87:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_000b16b7_4deb_471d_8d08_06a049d81c87
  __CMP_NO_000b16b7_4deb_471d_8d08_06a049d81c87:
  SEP	#$20
  LDA	#$00
  __CMP_END_000b16b7_4deb_471d_8d08_06a049d81c87:
  BEQ	__IFNOT_6b95d079_655c_4e7a_872d_993fbf553b67
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
  __IFNOT_6b95d079_655c_4e7a_872d_993fbf553b67:
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
  JMP	__ITER__START__a0dd91d8_a3b7_4faa_a794_884b318a7487
  __ITER__END__a0dd91d8_a3b7_4faa_a794_884b318a7487:
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
  __ITER__START__a44aa414_d099_4b9a_8bd6_6d09cfb4f924:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_57b88d1c_5955_48d2_a24d_bd03e0cf97ff
  BNE	__CMP_YES_57b88d1c_5955_48d2_a24d_bd03e0cf97ff
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_57b88d1c_5955_48d2_a24d_bd03e0cf97ff
  BNE	__CMP_YES_57b88d1c_5955_48d2_a24d_bd03e0cf97ff
  JMP	__CMP_NO_57b88d1c_5955_48d2_a24d_bd03e0cf97ff
  __CMP_YES_57b88d1c_5955_48d2_a24d_bd03e0cf97ff:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_57b88d1c_5955_48d2_a24d_bd03e0cf97ff
  __CMP_NO_57b88d1c_5955_48d2_a24d_bd03e0cf97ff:
  SEP	#$20
  LDA	#$00
  __CMP_END_57b88d1c_5955_48d2_a24d_bd03e0cf97ff:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a44aa414_d099_4b9a_8bd6_6d09cfb4f924
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
  BNE	__IFNOT_6984e0f9_f019_44f1_8992_9ec09f8456ed
  JMP	__ITER__END__a44aa414_d099_4b9a_8bd6_6d09cfb4f924
  __IFNOT_6984e0f9_f019_44f1_8992_9ec09f8456ed:
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
  JMP	__ITER__START__a44aa414_d099_4b9a_8bd6_6d09cfb4f924
  __ITER__END__a44aa414_d099_4b9a_8bd6_6d09cfb4f924:
  __ITER__START__c75e8621_997f_4ef0_a7be_41babbee5d87:
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
  JMP	__ITER__END__c75e8621_997f_4ef0_a7be_41babbee5d87
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_271175d7_479f_4663_9c7f_aeb437d296ec
  BNE	__CMP_YES_271175d7_479f_4663_9c7f_aeb437d296ec
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_271175d7_479f_4663_9c7f_aeb437d296ec
  BNE	__CMP_YES_271175d7_479f_4663_9c7f_aeb437d296ec
  JMP	__CMP_YES_271175d7_479f_4663_9c7f_aeb437d296ec
  __CMP_YES_271175d7_479f_4663_9c7f_aeb437d296ec:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_271175d7_479f_4663_9c7f_aeb437d296ec
  __CMP_NO_271175d7_479f_4663_9c7f_aeb437d296ec:
  SEP	#$20
  LDA	#$00
  __CMP_END_271175d7_479f_4663_9c7f_aeb437d296ec:
  BEQ	__IFNOT_6db0844b_e7c2_429a_81a0_5d31832f06cd
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
  __IFNOT_6db0844b_e7c2_429a_81a0_5d31832f06cd:
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
  JMP	__ITER__START__c75e8621_997f_4ef0_a7be_41babbee5d87
  __ITER__END__c75e8621_997f_4ef0_a7be_41babbee5d87:
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
  __ITER__START__d159e0d2_f476_4d92_ac58_4e150c933f27:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_525095e8_ecc3_460a_bb94_df0e5812c14f
  BNE	__CMP_YES_525095e8_ecc3_460a_bb94_df0e5812c14f
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_525095e8_ecc3_460a_bb94_df0e5812c14f
  BNE	__CMP_YES_525095e8_ecc3_460a_bb94_df0e5812c14f
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_525095e8_ecc3_460a_bb94_df0e5812c14f
  BNE	__CMP_YES_525095e8_ecc3_460a_bb94_df0e5812c14f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_525095e8_ecc3_460a_bb94_df0e5812c14f
  BNE	__CMP_YES_525095e8_ecc3_460a_bb94_df0e5812c14f
  JMP	__CMP_NO_525095e8_ecc3_460a_bb94_df0e5812c14f
  __CMP_YES_525095e8_ecc3_460a_bb94_df0e5812c14f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_525095e8_ecc3_460a_bb94_df0e5812c14f
  __CMP_NO_525095e8_ecc3_460a_bb94_df0e5812c14f:
  SEP	#$20
  LDA	#$00
  __CMP_END_525095e8_ecc3_460a_bb94_df0e5812c14f:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d159e0d2_f476_4d92_ac58_4e150c933f27
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
  BNE	__IFNOT_b565b010_2a31_4f86_9761_190586344fba
  JMP	__ITER__END__d159e0d2_f476_4d92_ac58_4e150c933f27
  __IFNOT_b565b010_2a31_4f86_9761_190586344fba:
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
  JMP	__ITER__START__d159e0d2_f476_4d92_ac58_4e150c933f27
  __ITER__END__d159e0d2_f476_4d92_ac58_4e150c933f27:
  __ITER__START__c2789258_274f_4aa3_83ff_000f3cbf551b:
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
  JMP	__ITER__END__c2789258_274f_4aa3_83ff_000f3cbf551b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_e8551cee_5655_4931_8952_7545e402e6c6
  BNE	__CMP_YES_e8551cee_5655_4931_8952_7545e402e6c6
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_e8551cee_5655_4931_8952_7545e402e6c6
  BNE	__CMP_YES_e8551cee_5655_4931_8952_7545e402e6c6
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e8551cee_5655_4931_8952_7545e402e6c6
  BNE	__CMP_YES_e8551cee_5655_4931_8952_7545e402e6c6
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e8551cee_5655_4931_8952_7545e402e6c6
  BNE	__CMP_YES_e8551cee_5655_4931_8952_7545e402e6c6
  JMP	__CMP_YES_e8551cee_5655_4931_8952_7545e402e6c6
  __CMP_YES_e8551cee_5655_4931_8952_7545e402e6c6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e8551cee_5655_4931_8952_7545e402e6c6
  __CMP_NO_e8551cee_5655_4931_8952_7545e402e6c6:
  SEP	#$20
  LDA	#$00
  __CMP_END_e8551cee_5655_4931_8952_7545e402e6c6:
  BEQ	__IFNOT_ece4d981_6c5b_49ce_8c2f_d2e569efb389
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
  __IFNOT_ece4d981_6c5b_49ce_8c2f_d2e569efb389:
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
  JMP	__ITER__START__c2789258_274f_4aa3_83ff_000f3cbf551b
  __ITER__END__c2789258_274f_4aa3_83ff_000f3cbf551b:
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
  __ITER__START__12e03761_5a08_419b_b1ff_8e751bff4be5:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_5d886386_1574_4083_b0c5_04dc85971609
  BNE	__CMP_YES_5d886386_1574_4083_b0c5_04dc85971609
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_5d886386_1574_4083_b0c5_04dc85971609
  BNE	__CMP_YES_5d886386_1574_4083_b0c5_04dc85971609
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5d886386_1574_4083_b0c5_04dc85971609
  BNE	__CMP_YES_5d886386_1574_4083_b0c5_04dc85971609
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_5d886386_1574_4083_b0c5_04dc85971609
  BNE	__CMP_YES_5d886386_1574_4083_b0c5_04dc85971609
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5d886386_1574_4083_b0c5_04dc85971609
  BNE	__CMP_YES_5d886386_1574_4083_b0c5_04dc85971609
  JMP	__CMP_NO_5d886386_1574_4083_b0c5_04dc85971609
  __CMP_YES_5d886386_1574_4083_b0c5_04dc85971609:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5d886386_1574_4083_b0c5_04dc85971609
  __CMP_NO_5d886386_1574_4083_b0c5_04dc85971609:
  SEP	#$20
  LDA	#$00
  __CMP_END_5d886386_1574_4083_b0c5_04dc85971609:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__12e03761_5a08_419b_b1ff_8e751bff4be5
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
  BNE	__IFNOT_0aa0afdf_3e1b_4a17_a051_91edc3ac80c1
  JMP	__ITER__END__12e03761_5a08_419b_b1ff_8e751bff4be5
  __IFNOT_0aa0afdf_3e1b_4a17_a051_91edc3ac80c1:
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
  JMP	__ITER__START__12e03761_5a08_419b_b1ff_8e751bff4be5
  __ITER__END__12e03761_5a08_419b_b1ff_8e751bff4be5:
  __ITER__START__f8f62d4d_614e_4892_9719_6ac1ecb6e54a:
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
  JMP	__ITER__END__f8f62d4d_614e_4892_9719_6ac1ecb6e54a
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_1092e13d_d43e_4b16_89a1_8c96637d7461
  BNE	__CMP_YES_1092e13d_d43e_4b16_89a1_8c96637d7461
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_1092e13d_d43e_4b16_89a1_8c96637d7461
  BNE	__CMP_YES_1092e13d_d43e_4b16_89a1_8c96637d7461
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_1092e13d_d43e_4b16_89a1_8c96637d7461
  BNE	__CMP_YES_1092e13d_d43e_4b16_89a1_8c96637d7461
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_1092e13d_d43e_4b16_89a1_8c96637d7461
  BNE	__CMP_YES_1092e13d_d43e_4b16_89a1_8c96637d7461
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1092e13d_d43e_4b16_89a1_8c96637d7461
  BNE	__CMP_YES_1092e13d_d43e_4b16_89a1_8c96637d7461
  JMP	__CMP_YES_1092e13d_d43e_4b16_89a1_8c96637d7461
  __CMP_YES_1092e13d_d43e_4b16_89a1_8c96637d7461:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1092e13d_d43e_4b16_89a1_8c96637d7461
  __CMP_NO_1092e13d_d43e_4b16_89a1_8c96637d7461:
  SEP	#$20
  LDA	#$00
  __CMP_END_1092e13d_d43e_4b16_89a1_8c96637d7461:
  BEQ	__IFNOT_f179b147_df21_49ac_a51e_c2a716fbc8e7
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
  __IFNOT_f179b147_df21_49ac_a51e_c2a716fbc8e7:
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
  JMP	__ITER__START__f8f62d4d_614e_4892_9719_6ac1ecb6e54a
  __ITER__END__f8f62d4d_614e_4892_9719_6ac1ecb6e54a:
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
  __ITER__START__a24dce63_c740_4da7_8b4e_2fa4e575ed29:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  BNE	__CMP_YES_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  BNE	__CMP_YES_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  BNE	__CMP_YES_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  BNE	__CMP_YES_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  JMP	__CMP_NO_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  __CMP_YES_6020f8c4_8e67_49d2_93b9_e3e29bf87854:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6020f8c4_8e67_49d2_93b9_e3e29bf87854
  __CMP_NO_6020f8c4_8e67_49d2_93b9_e3e29bf87854:
  SEP	#$20
  LDA	#$00
  __CMP_END_6020f8c4_8e67_49d2_93b9_e3e29bf87854:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a24dce63_c740_4da7_8b4e_2fa4e575ed29
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
  BNE	__IFNOT_a72563a5_bd23_47b8_833a_d627670430d9
  JMP	__ITER__END__a24dce63_c740_4da7_8b4e_2fa4e575ed29
  __IFNOT_a72563a5_bd23_47b8_833a_d627670430d9:
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
  JMP	__ITER__START__a24dce63_c740_4da7_8b4e_2fa4e575ed29
  __ITER__END__a24dce63_c740_4da7_8b4e_2fa4e575ed29:
  __ITER__START__637b2c26_a7d1_424a_87db_eac3e3f51efb:
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
  JMP	__ITER__END__637b2c26_a7d1_424a_87db_eac3e3f51efb
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_1f777696_20d9_4a06_bc92_066cbc33f247
  BNE	__CMP_YES_1f777696_20d9_4a06_bc92_066cbc33f247
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_1f777696_20d9_4a06_bc92_066cbc33f247
  BNE	__CMP_YES_1f777696_20d9_4a06_bc92_066cbc33f247
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_1f777696_20d9_4a06_bc92_066cbc33f247
  BNE	__CMP_YES_1f777696_20d9_4a06_bc92_066cbc33f247
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1f777696_20d9_4a06_bc92_066cbc33f247
  BNE	__CMP_YES_1f777696_20d9_4a06_bc92_066cbc33f247
  JMP	__CMP_YES_1f777696_20d9_4a06_bc92_066cbc33f247
  __CMP_YES_1f777696_20d9_4a06_bc92_066cbc33f247:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1f777696_20d9_4a06_bc92_066cbc33f247
  __CMP_NO_1f777696_20d9_4a06_bc92_066cbc33f247:
  SEP	#$20
  LDA	#$00
  __CMP_END_1f777696_20d9_4a06_bc92_066cbc33f247:
  BEQ	__IFNOT_50441b4b_a6c1_4166_9c3f_bb1feb6fe7e0
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
  __IFNOT_50441b4b_a6c1_4166_9c3f_bb1feb6fe7e0:
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
  JMP	__ITER__START__637b2c26_a7d1_424a_87db_eac3e3f51efb
  __ITER__END__637b2c26_a7d1_424a_87db_eac3e3f51efb:
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
  __ITER__START__8516e6db_e483_4814_b4a1_184b527521b4:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  BNE	__CMP_YES_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  BNE	__CMP_YES_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  BNE	__CMP_YES_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  BNE	__CMP_YES_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  BNE	__CMP_YES_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  JMP	__CMP_NO_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  __CMP_YES_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca
  __CMP_NO_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca:
  SEP	#$20
  LDA	#$00
  __CMP_END_ace6a1a9_749b_47eb_b0c6_82c92a41b1ca:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__8516e6db_e483_4814_b4a1_184b527521b4
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
  BNE	__IFNOT_5fe2535a_d8d4_4063_b824_df8a9910739a
  JMP	__ITER__END__8516e6db_e483_4814_b4a1_184b527521b4
  __IFNOT_5fe2535a_d8d4_4063_b824_df8a9910739a:
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
  JMP	__ITER__START__8516e6db_e483_4814_b4a1_184b527521b4
  __ITER__END__8516e6db_e483_4814_b4a1_184b527521b4:
  __ITER__START__627a72cd_6ee9_4ebd_b05f_bc11a1414091:
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
  JMP	__ITER__END__627a72cd_6ee9_4ebd_b05f_bc11a1414091
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_11f8e678_6b4e_492a_a0d1_32e20422b64f
  BNE	__CMP_YES_11f8e678_6b4e_492a_a0d1_32e20422b64f
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_11f8e678_6b4e_492a_a0d1_32e20422b64f
  BNE	__CMP_YES_11f8e678_6b4e_492a_a0d1_32e20422b64f
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_11f8e678_6b4e_492a_a0d1_32e20422b64f
  BNE	__CMP_YES_11f8e678_6b4e_492a_a0d1_32e20422b64f
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_11f8e678_6b4e_492a_a0d1_32e20422b64f
  BNE	__CMP_YES_11f8e678_6b4e_492a_a0d1_32e20422b64f
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_11f8e678_6b4e_492a_a0d1_32e20422b64f
  BNE	__CMP_YES_11f8e678_6b4e_492a_a0d1_32e20422b64f
  JMP	__CMP_YES_11f8e678_6b4e_492a_a0d1_32e20422b64f
  __CMP_YES_11f8e678_6b4e_492a_a0d1_32e20422b64f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_11f8e678_6b4e_492a_a0d1_32e20422b64f
  __CMP_NO_11f8e678_6b4e_492a_a0d1_32e20422b64f:
  SEP	#$20
  LDA	#$00
  __CMP_END_11f8e678_6b4e_492a_a0d1_32e20422b64f:
  BEQ	__IFNOT_43726ca6_fc82_4353_876a_8212268ab82f
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
  __IFNOT_43726ca6_fc82_4353_876a_8212268ab82f:
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
  JMP	__ITER__START__627a72cd_6ee9_4ebd_b05f_bc11a1414091
  __ITER__END__627a72cd_6ee9_4ebd_b05f_bc11a1414091:
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
  __ITER__START__b99fa804_61de_4fbc_95cf_eac927d72d88:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_687fd437_a805_41d7_99db_b6d2433fc4d8
  BNE	__CMP_YES_687fd437_a805_41d7_99db_b6d2433fc4d8
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_687fd437_a805_41d7_99db_b6d2433fc4d8
  BNE	__CMP_YES_687fd437_a805_41d7_99db_b6d2433fc4d8
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_687fd437_a805_41d7_99db_b6d2433fc4d8
  BNE	__CMP_YES_687fd437_a805_41d7_99db_b6d2433fc4d8
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_687fd437_a805_41d7_99db_b6d2433fc4d8
  BNE	__CMP_YES_687fd437_a805_41d7_99db_b6d2433fc4d8
  JMP	__CMP_NO_687fd437_a805_41d7_99db_b6d2433fc4d8
  __CMP_YES_687fd437_a805_41d7_99db_b6d2433fc4d8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_687fd437_a805_41d7_99db_b6d2433fc4d8
  __CMP_NO_687fd437_a805_41d7_99db_b6d2433fc4d8:
  SEP	#$20
  LDA	#$00
  __CMP_END_687fd437_a805_41d7_99db_b6d2433fc4d8:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b99fa804_61de_4fbc_95cf_eac927d72d88
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
  BNE	__IFNOT_373a3b78_70b6_4b7f_83c2_c13348672427
  JMP	__ITER__END__b99fa804_61de_4fbc_95cf_eac927d72d88
  __IFNOT_373a3b78_70b6_4b7f_83c2_c13348672427:
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
  JMP	__ITER__START__b99fa804_61de_4fbc_95cf_eac927d72d88
  __ITER__END__b99fa804_61de_4fbc_95cf_eac927d72d88:
  __ITER__START__4068a112_3ae9_4dd9_9e33_02ad15036240:
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
  JMP	__ITER__END__4068a112_3ae9_4dd9_9e33_02ad15036240
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  BNE	__CMP_YES_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  BNE	__CMP_YES_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  BNE	__CMP_YES_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  BNE	__CMP_YES_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  JMP	__CMP_YES_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  __CMP_YES_c65bc916_e90f_4afb_ac3f_9441f3fe5030:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c65bc916_e90f_4afb_ac3f_9441f3fe5030
  __CMP_NO_c65bc916_e90f_4afb_ac3f_9441f3fe5030:
  SEP	#$20
  LDA	#$00
  __CMP_END_c65bc916_e90f_4afb_ac3f_9441f3fe5030:
  BEQ	__IFNOT_f74bd2b3_a2a1_4766_b0ec_a354cf7e9577
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
  __IFNOT_f74bd2b3_a2a1_4766_b0ec_a354cf7e9577:
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
  JMP	__ITER__START__4068a112_3ae9_4dd9_9e33_02ad15036240
  __ITER__END__4068a112_3ae9_4dd9_9e33_02ad15036240:
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
  __ITER__START__74667acf_5a2c_474a_a013_f9426bfcd2f5:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  BNE	__CMP_YES_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  BNE	__CMP_YES_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  BNE	__CMP_YES_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  BNE	__CMP_YES_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  JMP	__CMP_NO_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  __CMP_YES_40b55880_8c82_4fbe_88e9_ab5a3d15c49a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_40b55880_8c82_4fbe_88e9_ab5a3d15c49a
  __CMP_NO_40b55880_8c82_4fbe_88e9_ab5a3d15c49a:
  SEP	#$20
  LDA	#$00
  __CMP_END_40b55880_8c82_4fbe_88e9_ab5a3d15c49a:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__74667acf_5a2c_474a_a013_f9426bfcd2f5
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
  BNE	__IFNOT_914c774e_1f82_46b9_970f_74db887c4e80
  JMP	__ITER__END__74667acf_5a2c_474a_a013_f9426bfcd2f5
  __IFNOT_914c774e_1f82_46b9_970f_74db887c4e80:
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
  JMP	__ITER__START__74667acf_5a2c_474a_a013_f9426bfcd2f5
  __ITER__END__74667acf_5a2c_474a_a013_f9426bfcd2f5:
  __ITER__START__414af8b4_7fe5_43ec_a0f8_c5665c5ae5a8:
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
  JMP	__ITER__END__414af8b4_7fe5_43ec_a0f8_c5665c5ae5a8
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_4039f886_6710_4ff1_9e53_7b4d80a96daf
  BNE	__CMP_YES_4039f886_6710_4ff1_9e53_7b4d80a96daf
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_4039f886_6710_4ff1_9e53_7b4d80a96daf
  BNE	__CMP_YES_4039f886_6710_4ff1_9e53_7b4d80a96daf
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_4039f886_6710_4ff1_9e53_7b4d80a96daf
  BNE	__CMP_YES_4039f886_6710_4ff1_9e53_7b4d80a96daf
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4039f886_6710_4ff1_9e53_7b4d80a96daf
  BNE	__CMP_YES_4039f886_6710_4ff1_9e53_7b4d80a96daf
  JMP	__CMP_YES_4039f886_6710_4ff1_9e53_7b4d80a96daf
  __CMP_YES_4039f886_6710_4ff1_9e53_7b4d80a96daf:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4039f886_6710_4ff1_9e53_7b4d80a96daf
  __CMP_NO_4039f886_6710_4ff1_9e53_7b4d80a96daf:
  SEP	#$20
  LDA	#$00
  __CMP_END_4039f886_6710_4ff1_9e53_7b4d80a96daf:
  BNE	:+
  JMP	__IFNOT_a3bdcdf2_f29b_4222_bfc6_3f84df67f1cc
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
  __IFNOT_a3bdcdf2_f29b_4222_bfc6_3f84df67f1cc:
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
  JMP	__ITER__START__414af8b4_7fe5_43ec_a0f8_c5665c5ae5a8
  __ITER__END__414af8b4_7fe5_43ec_a0f8_c5665c5ae5a8:
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
  __ITER__START__a1b39bd7_7aa4_46ba_a268_e467d53e975d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d
  BNE	__CMP_YES_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d
  BNE	__CMP_YES_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d
  JMP	__CMP_NO_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d
  __CMP_YES_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d
  __CMP_NO_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d:
  SEP	#$20
  LDA	#$00
  __CMP_END_85d60f70_bc0e_475f_bbb3_cf6f0196bc3d:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a1b39bd7_7aa4_46ba_a268_e467d53e975d
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
  BNE	__IFNOT_e382879e_3d66_4090_a3b4_cedb7e58610e
  JMP	__ITER__END__a1b39bd7_7aa4_46ba_a268_e467d53e975d
  __IFNOT_e382879e_3d66_4090_a3b4_cedb7e58610e:
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
  JMP	__ITER__START__a1b39bd7_7aa4_46ba_a268_e467d53e975d
  __ITER__END__a1b39bd7_7aa4_46ba_a268_e467d53e975d:
  __ITER__START__ea6f0ce1_a090_44b0_ae22_b822ee86f8ac:
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
  JMP	__ITER__END__ea6f0ce1_a090_44b0_ae22_b822ee86f8ac
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_0158d2e9_49e4_45b5_9aae_f1b2b91d898e
  BNE	__CMP_YES_0158d2e9_49e4_45b5_9aae_f1b2b91d898e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0158d2e9_49e4_45b5_9aae_f1b2b91d898e
  BNE	__CMP_YES_0158d2e9_49e4_45b5_9aae_f1b2b91d898e
  JMP	__CMP_YES_0158d2e9_49e4_45b5_9aae_f1b2b91d898e
  __CMP_YES_0158d2e9_49e4_45b5_9aae_f1b2b91d898e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0158d2e9_49e4_45b5_9aae_f1b2b91d898e
  __CMP_NO_0158d2e9_49e4_45b5_9aae_f1b2b91d898e:
  SEP	#$20
  LDA	#$00
  __CMP_END_0158d2e9_49e4_45b5_9aae_f1b2b91d898e:
  BEQ	__IFNOT_6e2dd3d4_e4be_4620_87ca_fc3a6a5b2673
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
  __IFNOT_6e2dd3d4_e4be_4620_87ca_fc3a6a5b2673:
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
  JMP	__ITER__START__ea6f0ce1_a090_44b0_ae22_b822ee86f8ac
  __ITER__END__ea6f0ce1_a090_44b0_ae22_b822ee86f8ac:
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
  __ITER__START__1a9b39c3_a6dd_456f_b052_c0e1309d66ee:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5adaf6f6_fdb8_44fc_9435_bf971101d913
  BNE	__CMP_YES_5adaf6f6_fdb8_44fc_9435_bf971101d913
  JMP	__CMP_NO_5adaf6f6_fdb8_44fc_9435_bf971101d913
  __CMP_YES_5adaf6f6_fdb8_44fc_9435_bf971101d913:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5adaf6f6_fdb8_44fc_9435_bf971101d913
  __CMP_NO_5adaf6f6_fdb8_44fc_9435_bf971101d913:
  SEP	#$20
  LDA	#$00
  __CMP_END_5adaf6f6_fdb8_44fc_9435_bf971101d913:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1a9b39c3_a6dd_456f_b052_c0e1309d66ee
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
  BNE	__IFNOT_77968058_125c_46d3_9988_d5b10325dd4f
  JMP	__ITER__END__1a9b39c3_a6dd_456f_b052_c0e1309d66ee
  __IFNOT_77968058_125c_46d3_9988_d5b10325dd4f:
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
  JMP	__ITER__START__1a9b39c3_a6dd_456f_b052_c0e1309d66ee
  __ITER__END__1a9b39c3_a6dd_456f_b052_c0e1309d66ee:
  __ITER__START__319b791d_f807_4872_be92_060576308c9c:
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
  JMP	__ITER__END__319b791d_f807_4872_be92_060576308c9c
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_385a1023_41e7_4ad7_a9b0_9946415882d3
  BNE	__CMP_YES_385a1023_41e7_4ad7_a9b0_9946415882d3
  JMP	__CMP_YES_385a1023_41e7_4ad7_a9b0_9946415882d3
  __CMP_YES_385a1023_41e7_4ad7_a9b0_9946415882d3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_385a1023_41e7_4ad7_a9b0_9946415882d3
  __CMP_NO_385a1023_41e7_4ad7_a9b0_9946415882d3:
  SEP	#$20
  LDA	#$00
  __CMP_END_385a1023_41e7_4ad7_a9b0_9946415882d3:
  BEQ	__IFNOT_092dd641_70c3_4a14_b215_96fb9932df92
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
  __IFNOT_092dd641_70c3_4a14_b215_96fb9932df92:
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
  JMP	__ITER__START__319b791d_f807_4872_be92_060576308c9c
  __ITER__END__319b791d_f807_4872_be92_060576308c9c:
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
  __ITER__START__49d9cd48_fa61_4ab3_b269_906465301403:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_372ae2bd_2bac_4304_8810_1c5021d86bc6
  BNE	__CMP_YES_372ae2bd_2bac_4304_8810_1c5021d86bc6
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_372ae2bd_2bac_4304_8810_1c5021d86bc6
  BNE	__CMP_YES_372ae2bd_2bac_4304_8810_1c5021d86bc6
  JMP	__CMP_NO_372ae2bd_2bac_4304_8810_1c5021d86bc6
  __CMP_YES_372ae2bd_2bac_4304_8810_1c5021d86bc6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_372ae2bd_2bac_4304_8810_1c5021d86bc6
  __CMP_NO_372ae2bd_2bac_4304_8810_1c5021d86bc6:
  SEP	#$20
  LDA	#$00
  __CMP_END_372ae2bd_2bac_4304_8810_1c5021d86bc6:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__49d9cd48_fa61_4ab3_b269_906465301403
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
  BNE	__IFNOT_1ba9c98c_7777_43a4_9d3e_f6512b0892e0
  JMP	__ITER__END__49d9cd48_fa61_4ab3_b269_906465301403
  __IFNOT_1ba9c98c_7777_43a4_9d3e_f6512b0892e0:
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
  JMP	__ITER__START__49d9cd48_fa61_4ab3_b269_906465301403
  __ITER__END__49d9cd48_fa61_4ab3_b269_906465301403:
  __ITER__START__aff33907_0a78_42ee_a271_9aedb20a7d6e:
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
  JMP	__ITER__END__aff33907_0a78_42ee_a271_9aedb20a7d6e
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_a758265d_730e_4bc1_ad25_205869a5d7ba
  BNE	__CMP_YES_a758265d_730e_4bc1_ad25_205869a5d7ba
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a758265d_730e_4bc1_ad25_205869a5d7ba
  BNE	__CMP_YES_a758265d_730e_4bc1_ad25_205869a5d7ba
  JMP	__CMP_YES_a758265d_730e_4bc1_ad25_205869a5d7ba
  __CMP_YES_a758265d_730e_4bc1_ad25_205869a5d7ba:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a758265d_730e_4bc1_ad25_205869a5d7ba
  __CMP_NO_a758265d_730e_4bc1_ad25_205869a5d7ba:
  SEP	#$20
  LDA	#$00
  __CMP_END_a758265d_730e_4bc1_ad25_205869a5d7ba:
  BEQ	__IFNOT_8904241a_562e_4503_b8af_f46aab81195f
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
  __IFNOT_8904241a_562e_4503_b8af_f46aab81195f:
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
  JMP	__ITER__START__aff33907_0a78_42ee_a271_9aedb20a7d6e
  __ITER__END__aff33907_0a78_42ee_a271_9aedb20a7d6e:
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
  __ITER__START__3a5734ef_2d1c_4fcd_b732_5204722d5456:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_b4e4e329_c8ff_4d59_96a8_efe43deccf28
  BNE	__CMP_YES_b4e4e329_c8ff_4d59_96a8_efe43deccf28
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b4e4e329_c8ff_4d59_96a8_efe43deccf28
  BNE	__CMP_YES_b4e4e329_c8ff_4d59_96a8_efe43deccf28
  JMP	__CMP_NO_b4e4e329_c8ff_4d59_96a8_efe43deccf28
  __CMP_YES_b4e4e329_c8ff_4d59_96a8_efe43deccf28:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b4e4e329_c8ff_4d59_96a8_efe43deccf28
  __CMP_NO_b4e4e329_c8ff_4d59_96a8_efe43deccf28:
  SEP	#$20
  LDA	#$00
  __CMP_END_b4e4e329_c8ff_4d59_96a8_efe43deccf28:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__3a5734ef_2d1c_4fcd_b732_5204722d5456
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
  BNE	__IFNOT_34c7b687_49ac_4956_b340_0a16b7758aef
  JMP	__ITER__END__3a5734ef_2d1c_4fcd_b732_5204722d5456
  __IFNOT_34c7b687_49ac_4956_b340_0a16b7758aef:
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
  JMP	__ITER__START__3a5734ef_2d1c_4fcd_b732_5204722d5456
  __ITER__END__3a5734ef_2d1c_4fcd_b732_5204722d5456:
  __ITER__START__25d9c994_e143_4ed3_b7e0_9a92483f2467:
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
  JMP	__ITER__END__25d9c994_e143_4ed3_b7e0_9a92483f2467
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_6eecdfd7_e084_4c38_b60f_7be09681f21e
  BNE	__CMP_YES_6eecdfd7_e084_4c38_b60f_7be09681f21e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6eecdfd7_e084_4c38_b60f_7be09681f21e
  BNE	__CMP_YES_6eecdfd7_e084_4c38_b60f_7be09681f21e
  JMP	__CMP_YES_6eecdfd7_e084_4c38_b60f_7be09681f21e
  __CMP_YES_6eecdfd7_e084_4c38_b60f_7be09681f21e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6eecdfd7_e084_4c38_b60f_7be09681f21e
  __CMP_NO_6eecdfd7_e084_4c38_b60f_7be09681f21e:
  SEP	#$20
  LDA	#$00
  __CMP_END_6eecdfd7_e084_4c38_b60f_7be09681f21e:
  BEQ	__IFNOT_c91c02d9_b9b9_42e3_a3fa_b6a9fb69103f
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
  __IFNOT_c91c02d9_b9b9_42e3_a3fa_b6a9fb69103f:
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
  JMP	__ITER__START__25d9c994_e143_4ed3_b7e0_9a92483f2467
  __ITER__END__25d9c994_e143_4ed3_b7e0_9a92483f2467:
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
  __ITER__START__ef49b949_e5f6_4681_a87e_ea81e03bd89c:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_beecb487_c631_4e6a_8371_aba37b0cd096
  BNE	__CMP_YES_beecb487_c631_4e6a_8371_aba37b0cd096
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_beecb487_c631_4e6a_8371_aba37b0cd096
  BNE	__CMP_YES_beecb487_c631_4e6a_8371_aba37b0cd096
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_beecb487_c631_4e6a_8371_aba37b0cd096
  BNE	__CMP_YES_beecb487_c631_4e6a_8371_aba37b0cd096
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_beecb487_c631_4e6a_8371_aba37b0cd096
  BNE	__CMP_YES_beecb487_c631_4e6a_8371_aba37b0cd096
  JMP	__CMP_NO_beecb487_c631_4e6a_8371_aba37b0cd096
  __CMP_YES_beecb487_c631_4e6a_8371_aba37b0cd096:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_beecb487_c631_4e6a_8371_aba37b0cd096
  __CMP_NO_beecb487_c631_4e6a_8371_aba37b0cd096:
  SEP	#$20
  LDA	#$00
  __CMP_END_beecb487_c631_4e6a_8371_aba37b0cd096:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__ef49b949_e5f6_4681_a87e_ea81e03bd89c
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
  BNE	__IFNOT_df485932_7529_4d1e_ae2d_c1906d78fd97
  JMP	__ITER__END__ef49b949_e5f6_4681_a87e_ea81e03bd89c
  __IFNOT_df485932_7529_4d1e_ae2d_c1906d78fd97:
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
  JMP	__ITER__START__ef49b949_e5f6_4681_a87e_ea81e03bd89c
  __ITER__END__ef49b949_e5f6_4681_a87e_ea81e03bd89c:
  __ITER__START__18716238_5163_4ede_b528_33cbdb7516d6:
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
  JMP	__ITER__END__18716238_5163_4ede_b528_33cbdb7516d6
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_c4e37572_fb71_419c_9b42_4891ff5985af
  BNE	__CMP_YES_c4e37572_fb71_419c_9b42_4891ff5985af
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_c4e37572_fb71_419c_9b42_4891ff5985af
  BNE	__CMP_YES_c4e37572_fb71_419c_9b42_4891ff5985af
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_c4e37572_fb71_419c_9b42_4891ff5985af
  BNE	__CMP_YES_c4e37572_fb71_419c_9b42_4891ff5985af
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c4e37572_fb71_419c_9b42_4891ff5985af
  BNE	__CMP_YES_c4e37572_fb71_419c_9b42_4891ff5985af
  JMP	__CMP_YES_c4e37572_fb71_419c_9b42_4891ff5985af
  __CMP_YES_c4e37572_fb71_419c_9b42_4891ff5985af:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c4e37572_fb71_419c_9b42_4891ff5985af
  __CMP_NO_c4e37572_fb71_419c_9b42_4891ff5985af:
  SEP	#$20
  LDA	#$00
  __CMP_END_c4e37572_fb71_419c_9b42_4891ff5985af:
  BEQ	__IFNOT_01965fe2_5bc7_4f97_aedf_73f2592b1b29
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
  __IFNOT_01965fe2_5bc7_4f97_aedf_73f2592b1b29:
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
  JMP	__ITER__START__18716238_5163_4ede_b528_33cbdb7516d6
  __ITER__END__18716238_5163_4ede_b528_33cbdb7516d6:
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
  __ITER__START__fc73ef90_d92c_4bb6_a5d6_bacaac711932:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_97ea6612_4075_4b0d_b6bb_ee687332d9c7
  BNE	__CMP_YES_97ea6612_4075_4b0d_b6bb_ee687332d9c7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_97ea6612_4075_4b0d_b6bb_ee687332d9c7
  BNE	__CMP_YES_97ea6612_4075_4b0d_b6bb_ee687332d9c7
  JMP	__CMP_NO_97ea6612_4075_4b0d_b6bb_ee687332d9c7
  __CMP_YES_97ea6612_4075_4b0d_b6bb_ee687332d9c7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_97ea6612_4075_4b0d_b6bb_ee687332d9c7
  __CMP_NO_97ea6612_4075_4b0d_b6bb_ee687332d9c7:
  SEP	#$20
  LDA	#$00
  __CMP_END_97ea6612_4075_4b0d_b6bb_ee687332d9c7:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__fc73ef90_d92c_4bb6_a5d6_bacaac711932
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
  BNE	__IFNOT_88795099_c5b8_4880_937b_43db5778253a
  JMP	__ITER__END__fc73ef90_d92c_4bb6_a5d6_bacaac711932
  __IFNOT_88795099_c5b8_4880_937b_43db5778253a:
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
  JMP	__ITER__START__fc73ef90_d92c_4bb6_a5d6_bacaac711932
  __ITER__END__fc73ef90_d92c_4bb6_a5d6_bacaac711932:
  __ITER__START__ab40755e_e910_4299_8ad9_1cc78ba1fef7:
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
  JMP	__ITER__END__ab40755e_e910_4299_8ad9_1cc78ba1fef7
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e296889c_4bf5_44a1_879a_541404e90453
  BNE	__CMP_YES_e296889c_4bf5_44a1_879a_541404e90453
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e296889c_4bf5_44a1_879a_541404e90453
  BNE	__CMP_YES_e296889c_4bf5_44a1_879a_541404e90453
  JMP	__CMP_YES_e296889c_4bf5_44a1_879a_541404e90453
  __CMP_YES_e296889c_4bf5_44a1_879a_541404e90453:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e296889c_4bf5_44a1_879a_541404e90453
  __CMP_NO_e296889c_4bf5_44a1_879a_541404e90453:
  SEP	#$20
  LDA	#$00
  __CMP_END_e296889c_4bf5_44a1_879a_541404e90453:
  BEQ	__IFNOT_93c6ee05_8e8c_47a3_9a16_9c4dd4f88b63
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
  __IFNOT_93c6ee05_8e8c_47a3_9a16_9c4dd4f88b63:
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
  JMP	__ITER__START__ab40755e_e910_4299_8ad9_1cc78ba1fef7
  __ITER__END__ab40755e_e910_4299_8ad9_1cc78ba1fef7:
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
  __ITER__START__e9e20e6d_3b64_4044_a2c1_e9c4c5d9398b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3
  BNE	__CMP_YES_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3
  BNE	__CMP_YES_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3
  JMP	__CMP_NO_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3
  __CMP_YES_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3
  __CMP_NO_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3:
  SEP	#$20
  LDA	#$00
  __CMP_END_6f334412_b81b_4d52_90c0_a4fbc1e8a1c3:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e9e20e6d_3b64_4044_a2c1_e9c4c5d9398b
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
  BNE	__IFNOT_fc3873dd_6201_40f2_a9cf_f7a3b0e627d2
  JMP	__ITER__END__e9e20e6d_3b64_4044_a2c1_e9c4c5d9398b
  __IFNOT_fc3873dd_6201_40f2_a9cf_f7a3b0e627d2:
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
  JMP	__ITER__START__e9e20e6d_3b64_4044_a2c1_e9c4c5d9398b
  __ITER__END__e9e20e6d_3b64_4044_a2c1_e9c4c5d9398b:
  __ITER__START__13de07b4_3f0b_4eef_b195_8405007d6c93:
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
  JMP	__ITER__END__13de07b4_3f0b_4eef_b195_8405007d6c93
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f1eac784_42f8_49ba_9893_4dab5b898d63
  BNE	__CMP_YES_f1eac784_42f8_49ba_9893_4dab5b898d63
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f1eac784_42f8_49ba_9893_4dab5b898d63
  BNE	__CMP_YES_f1eac784_42f8_49ba_9893_4dab5b898d63
  JMP	__CMP_YES_f1eac784_42f8_49ba_9893_4dab5b898d63
  __CMP_YES_f1eac784_42f8_49ba_9893_4dab5b898d63:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f1eac784_42f8_49ba_9893_4dab5b898d63
  __CMP_NO_f1eac784_42f8_49ba_9893_4dab5b898d63:
  SEP	#$20
  LDA	#$00
  __CMP_END_f1eac784_42f8_49ba_9893_4dab5b898d63:
  BEQ	__IFNOT_47bcdad9_114c_4d71_8489_fd65385fb0bb
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
  __IFNOT_47bcdad9_114c_4d71_8489_fd65385fb0bb:
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
  JMP	__ITER__START__13de07b4_3f0b_4eef_b195_8405007d6c93
  __ITER__END__13de07b4_3f0b_4eef_b195_8405007d6c93:
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
  __ITER__START__6e92b0dd_259d_411f_886f_587fca63dc55:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e8327c19_efe3_445d_a380_09c11d3d9d7c
  BNE	__CMP_YES_e8327c19_efe3_445d_a380_09c11d3d9d7c
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e8327c19_efe3_445d_a380_09c11d3d9d7c
  BNE	__CMP_YES_e8327c19_efe3_445d_a380_09c11d3d9d7c
  JMP	__CMP_NO_e8327c19_efe3_445d_a380_09c11d3d9d7c
  __CMP_YES_e8327c19_efe3_445d_a380_09c11d3d9d7c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e8327c19_efe3_445d_a380_09c11d3d9d7c
  __CMP_NO_e8327c19_efe3_445d_a380_09c11d3d9d7c:
  SEP	#$20
  LDA	#$00
  __CMP_END_e8327c19_efe3_445d_a380_09c11d3d9d7c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6e92b0dd_259d_411f_886f_587fca63dc55
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
  BNE	__IFNOT_a5c19791_5447_45f6_b7ee_e585a63032eb
  JMP	__ITER__END__6e92b0dd_259d_411f_886f_587fca63dc55
  __IFNOT_a5c19791_5447_45f6_b7ee_e585a63032eb:
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
  JMP	__ITER__START__6e92b0dd_259d_411f_886f_587fca63dc55
  __ITER__END__6e92b0dd_259d_411f_886f_587fca63dc55:
  __ITER__START__55d19179_2d15_445b_b4a6_7f05fdd6b385:
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
  JMP	__ITER__END__55d19179_2d15_445b_b4a6_7f05fdd6b385
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_708d9b1c_21bf_401b_a71b_36c9d6bbf018
  BNE	__CMP_YES_708d9b1c_21bf_401b_a71b_36c9d6bbf018
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_708d9b1c_21bf_401b_a71b_36c9d6bbf018
  BNE	__CMP_YES_708d9b1c_21bf_401b_a71b_36c9d6bbf018
  JMP	__CMP_YES_708d9b1c_21bf_401b_a71b_36c9d6bbf018
  __CMP_YES_708d9b1c_21bf_401b_a71b_36c9d6bbf018:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_708d9b1c_21bf_401b_a71b_36c9d6bbf018
  __CMP_NO_708d9b1c_21bf_401b_a71b_36c9d6bbf018:
  SEP	#$20
  LDA	#$00
  __CMP_END_708d9b1c_21bf_401b_a71b_36c9d6bbf018:
  BEQ	__IFNOT_f7007d02_2d5f_4261_ac76_a681e6c6f5d7
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
  __IFNOT_f7007d02_2d5f_4261_ac76_a681e6c6f5d7:
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
  JMP	__ITER__START__55d19179_2d15_445b_b4a6_7f05fdd6b385
  __ITER__END__55d19179_2d15_445b_b4a6_7f05fdd6b385:
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
  __ITER__START__671e97a9_6741_4b8b_a124_e2c561f16204:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_0160be4f_24ef_4696_acaf_f4085070db7a
  BNE	__CMP_YES_0160be4f_24ef_4696_acaf_f4085070db7a
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_0160be4f_24ef_4696_acaf_f4085070db7a
  BNE	__CMP_YES_0160be4f_24ef_4696_acaf_f4085070db7a
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0160be4f_24ef_4696_acaf_f4085070db7a
  BNE	__CMP_YES_0160be4f_24ef_4696_acaf_f4085070db7a
  JMP	__CMP_NO_0160be4f_24ef_4696_acaf_f4085070db7a
  __CMP_YES_0160be4f_24ef_4696_acaf_f4085070db7a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0160be4f_24ef_4696_acaf_f4085070db7a
  __CMP_NO_0160be4f_24ef_4696_acaf_f4085070db7a:
  SEP	#$20
  LDA	#$00
  __CMP_END_0160be4f_24ef_4696_acaf_f4085070db7a:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__671e97a9_6741_4b8b_a124_e2c561f16204
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
  BNE	__IFNOT_7bddbcba_13c7_4bed_a42a_aee72c44b6d6
  JMP	__ITER__END__671e97a9_6741_4b8b_a124_e2c561f16204
  __IFNOT_7bddbcba_13c7_4bed_a42a_aee72c44b6d6:
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
  JMP	__ITER__START__671e97a9_6741_4b8b_a124_e2c561f16204
  __ITER__END__671e97a9_6741_4b8b_a124_e2c561f16204:
  __ITER__START__d1810a70_cd3d_4a1a_b041_129e919cbd28:
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
  JMP	__ITER__END__d1810a70_cd3d_4a1a_b041_129e919cbd28
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_d12e55d2_cf89_453a_b409_a777b7cf358a
  BNE	__CMP_YES_d12e55d2_cf89_453a_b409_a777b7cf358a
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d12e55d2_cf89_453a_b409_a777b7cf358a
  BNE	__CMP_YES_d12e55d2_cf89_453a_b409_a777b7cf358a
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d12e55d2_cf89_453a_b409_a777b7cf358a
  BNE	__CMP_YES_d12e55d2_cf89_453a_b409_a777b7cf358a
  JMP	__CMP_YES_d12e55d2_cf89_453a_b409_a777b7cf358a
  __CMP_YES_d12e55d2_cf89_453a_b409_a777b7cf358a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d12e55d2_cf89_453a_b409_a777b7cf358a
  __CMP_NO_d12e55d2_cf89_453a_b409_a777b7cf358a:
  SEP	#$20
  LDA	#$00
  __CMP_END_d12e55d2_cf89_453a_b409_a777b7cf358a:
  BEQ	__IFNOT_cefb8ccb_10d9_488f_bd90_05bc717b077e
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
  __IFNOT_cefb8ccb_10d9_488f_bd90_05bc717b077e:
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
  JMP	__ITER__START__d1810a70_cd3d_4a1a_b041_129e919cbd28
  __ITER__END__d1810a70_cd3d_4a1a_b041_129e919cbd28:
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
  __ITER__START__1f7a3e95_8fc6_4314_9781_ff2dbaef829e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  BNE	__CMP_YES_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  BNE	__CMP_YES_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  BNE	__CMP_YES_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  BNE	__CMP_YES_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  BNE	__CMP_YES_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  JMP	__CMP_NO_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  __CMP_YES_15a72354_e348_4a3e_9dcc_518d8d5cf5b2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_15a72354_e348_4a3e_9dcc_518d8d5cf5b2
  __CMP_NO_15a72354_e348_4a3e_9dcc_518d8d5cf5b2:
  SEP	#$20
  LDA	#$00
  __CMP_END_15a72354_e348_4a3e_9dcc_518d8d5cf5b2:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1f7a3e95_8fc6_4314_9781_ff2dbaef829e
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
  BNE	__IFNOT_e61904f9_1348_436e_a2f4_7f2dbd4f18f8
  JMP	__ITER__END__1f7a3e95_8fc6_4314_9781_ff2dbaef829e
  __IFNOT_e61904f9_1348_436e_a2f4_7f2dbd4f18f8:
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
  JMP	__ITER__START__1f7a3e95_8fc6_4314_9781_ff2dbaef829e
  __ITER__END__1f7a3e95_8fc6_4314_9781_ff2dbaef829e:
  __ITER__START__2b6db3f6_4676_4468_99d2_6bd320690fb3:
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
  JMP	__ITER__END__2b6db3f6_4676_4468_99d2_6bd320690fb3
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_30a91f89_5455_4470_a5ba_0c628461d89e
  BNE	__CMP_YES_30a91f89_5455_4470_a5ba_0c628461d89e
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_30a91f89_5455_4470_a5ba_0c628461d89e
  BNE	__CMP_YES_30a91f89_5455_4470_a5ba_0c628461d89e
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_30a91f89_5455_4470_a5ba_0c628461d89e
  BNE	__CMP_YES_30a91f89_5455_4470_a5ba_0c628461d89e
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_30a91f89_5455_4470_a5ba_0c628461d89e
  BNE	__CMP_YES_30a91f89_5455_4470_a5ba_0c628461d89e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_30a91f89_5455_4470_a5ba_0c628461d89e
  BNE	__CMP_YES_30a91f89_5455_4470_a5ba_0c628461d89e
  JMP	__CMP_YES_30a91f89_5455_4470_a5ba_0c628461d89e
  __CMP_YES_30a91f89_5455_4470_a5ba_0c628461d89e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_30a91f89_5455_4470_a5ba_0c628461d89e
  __CMP_NO_30a91f89_5455_4470_a5ba_0c628461d89e:
  SEP	#$20
  LDA	#$00
  __CMP_END_30a91f89_5455_4470_a5ba_0c628461d89e:
  BNE	:+
  JMP	__IFNOT_a3eede4d_5f75_4d2c_b03f_4bc997ef0115
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
  __IFNOT_a3eede4d_5f75_4d2c_b03f_4bc997ef0115:
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
  JMP	__ITER__START__2b6db3f6_4676_4468_99d2_6bd320690fb3
  __ITER__END__2b6db3f6_4676_4468_99d2_6bd320690fb3:
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
  __ITER__START__32e62b3e_ecf7_4725_beaa_1b34a68ca202:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a4f29c82_9561_4230_966c_e62ba3e17258
  BNE	__CMP_YES_a4f29c82_9561_4230_966c_e62ba3e17258
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a4f29c82_9561_4230_966c_e62ba3e17258
  BNE	__CMP_YES_a4f29c82_9561_4230_966c_e62ba3e17258
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a4f29c82_9561_4230_966c_e62ba3e17258
  BNE	__CMP_YES_a4f29c82_9561_4230_966c_e62ba3e17258
  JMP	__CMP_NO_a4f29c82_9561_4230_966c_e62ba3e17258
  __CMP_YES_a4f29c82_9561_4230_966c_e62ba3e17258:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a4f29c82_9561_4230_966c_e62ba3e17258
  __CMP_NO_a4f29c82_9561_4230_966c_e62ba3e17258:
  SEP	#$20
  LDA	#$00
  __CMP_END_a4f29c82_9561_4230_966c_e62ba3e17258:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__32e62b3e_ecf7_4725_beaa_1b34a68ca202
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
  BNE	__IFNOT_4e7f94c2_35a6_4c48_a754_c6696f556603
  JMP	__ITER__END__32e62b3e_ecf7_4725_beaa_1b34a68ca202
  __IFNOT_4e7f94c2_35a6_4c48_a754_c6696f556603:
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
  JMP	__ITER__START__32e62b3e_ecf7_4725_beaa_1b34a68ca202
  __ITER__END__32e62b3e_ecf7_4725_beaa_1b34a68ca202:
  __ITER__START__a10196c6_5e08_48c5_aa82_383b773976b4:
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
  JMP	__ITER__END__a10196c6_5e08_48c5_aa82_383b773976b4
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_508b2151_9dda_4ae9_a220_cbcd3bf8c472
  BNE	__CMP_YES_508b2151_9dda_4ae9_a220_cbcd3bf8c472
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_508b2151_9dda_4ae9_a220_cbcd3bf8c472
  BNE	__CMP_YES_508b2151_9dda_4ae9_a220_cbcd3bf8c472
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_508b2151_9dda_4ae9_a220_cbcd3bf8c472
  BNE	__CMP_YES_508b2151_9dda_4ae9_a220_cbcd3bf8c472
  JMP	__CMP_YES_508b2151_9dda_4ae9_a220_cbcd3bf8c472
  __CMP_YES_508b2151_9dda_4ae9_a220_cbcd3bf8c472:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_508b2151_9dda_4ae9_a220_cbcd3bf8c472
  __CMP_NO_508b2151_9dda_4ae9_a220_cbcd3bf8c472:
  SEP	#$20
  LDA	#$00
  __CMP_END_508b2151_9dda_4ae9_a220_cbcd3bf8c472:
  BEQ	__IFNOT_b2553263_ac80_43a6_ac0c_cd0e3ec93e95
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
  __IFNOT_b2553263_ac80_43a6_ac0c_cd0e3ec93e95:
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
  JMP	__ITER__START__a10196c6_5e08_48c5_aa82_383b773976b4
  __ITER__END__a10196c6_5e08_48c5_aa82_383b773976b4:
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
  __ITER__START__226c9a7f_8032_48e2_af65_6fe39930b187:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a26f91f2_3da5_4930_927a_25461db7d52e
  BNE	__CMP_YES_a26f91f2_3da5_4930_927a_25461db7d52e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a26f91f2_3da5_4930_927a_25461db7d52e
  BNE	__CMP_YES_a26f91f2_3da5_4930_927a_25461db7d52e
  JMP	__CMP_NO_a26f91f2_3da5_4930_927a_25461db7d52e
  __CMP_YES_a26f91f2_3da5_4930_927a_25461db7d52e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a26f91f2_3da5_4930_927a_25461db7d52e
  __CMP_NO_a26f91f2_3da5_4930_927a_25461db7d52e:
  SEP	#$20
  LDA	#$00
  __CMP_END_a26f91f2_3da5_4930_927a_25461db7d52e:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__226c9a7f_8032_48e2_af65_6fe39930b187
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
  BNE	__IFNOT_eeb0044f_7e6d_4cb6_a7cb_00e81a3c2a29
  JMP	__ITER__END__226c9a7f_8032_48e2_af65_6fe39930b187
  __IFNOT_eeb0044f_7e6d_4cb6_a7cb_00e81a3c2a29:
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
  JMP	__ITER__START__226c9a7f_8032_48e2_af65_6fe39930b187
  __ITER__END__226c9a7f_8032_48e2_af65_6fe39930b187:
  __ITER__START__7f2d2f1d_2b26_4f51_a0f0_9ab1cfac4529:
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
  JMP	__ITER__END__7f2d2f1d_2b26_4f51_a0f0_9ab1cfac4529
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5ea0ce22_625a_47d5_8193_ec771547b6c7
  BNE	__CMP_YES_5ea0ce22_625a_47d5_8193_ec771547b6c7
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5ea0ce22_625a_47d5_8193_ec771547b6c7
  BNE	__CMP_YES_5ea0ce22_625a_47d5_8193_ec771547b6c7
  JMP	__CMP_YES_5ea0ce22_625a_47d5_8193_ec771547b6c7
  __CMP_YES_5ea0ce22_625a_47d5_8193_ec771547b6c7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5ea0ce22_625a_47d5_8193_ec771547b6c7
  __CMP_NO_5ea0ce22_625a_47d5_8193_ec771547b6c7:
  SEP	#$20
  LDA	#$00
  __CMP_END_5ea0ce22_625a_47d5_8193_ec771547b6c7:
  BEQ	__IFNOT_d8e06d03_d4f3_42b3_96cc_dc7f482a43a1
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
  __IFNOT_d8e06d03_d4f3_42b3_96cc_dc7f482a43a1:
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
  JMP	__ITER__START__7f2d2f1d_2b26_4f51_a0f0_9ab1cfac4529
  __ITER__END__7f2d2f1d_2b26_4f51_a0f0_9ab1cfac4529:
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
  __ITER__START__3667439b_7e24_4fd4_a439_def757a55b2a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_0f83c17d_7a12_404d_a050_16eec38dc11a
  BNE	__CMP_YES_0f83c17d_7a12_404d_a050_16eec38dc11a
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_0f83c17d_7a12_404d_a050_16eec38dc11a
  BNE	__CMP_YES_0f83c17d_7a12_404d_a050_16eec38dc11a
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0f83c17d_7a12_404d_a050_16eec38dc11a
  BNE	__CMP_YES_0f83c17d_7a12_404d_a050_16eec38dc11a
  JMP	__CMP_NO_0f83c17d_7a12_404d_a050_16eec38dc11a
  __CMP_YES_0f83c17d_7a12_404d_a050_16eec38dc11a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0f83c17d_7a12_404d_a050_16eec38dc11a
  __CMP_NO_0f83c17d_7a12_404d_a050_16eec38dc11a:
  SEP	#$20
  LDA	#$00
  __CMP_END_0f83c17d_7a12_404d_a050_16eec38dc11a:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__3667439b_7e24_4fd4_a439_def757a55b2a
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
  BNE	__IFNOT_38fa5f98_cf01_477f_a87c_c86685c24403
  JMP	__ITER__END__3667439b_7e24_4fd4_a439_def757a55b2a
  __IFNOT_38fa5f98_cf01_477f_a87c_c86685c24403:
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
  JMP	__ITER__START__3667439b_7e24_4fd4_a439_def757a55b2a
  __ITER__END__3667439b_7e24_4fd4_a439_def757a55b2a:
  __ITER__START__01ec0af3_b079_495e_8add_437bd8f5bf5b:
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
  JMP	__ITER__END__01ec0af3_b079_495e_8add_437bd8f5bf5b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_bc220358_47b7_491f_8330_9d5cb5d4950b
  BNE	__CMP_YES_bc220358_47b7_491f_8330_9d5cb5d4950b
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_bc220358_47b7_491f_8330_9d5cb5d4950b
  BNE	__CMP_YES_bc220358_47b7_491f_8330_9d5cb5d4950b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_bc220358_47b7_491f_8330_9d5cb5d4950b
  BNE	__CMP_YES_bc220358_47b7_491f_8330_9d5cb5d4950b
  JMP	__CMP_YES_bc220358_47b7_491f_8330_9d5cb5d4950b
  __CMP_YES_bc220358_47b7_491f_8330_9d5cb5d4950b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_bc220358_47b7_491f_8330_9d5cb5d4950b
  __CMP_NO_bc220358_47b7_491f_8330_9d5cb5d4950b:
  SEP	#$20
  LDA	#$00
  __CMP_END_bc220358_47b7_491f_8330_9d5cb5d4950b:
  BEQ	__IFNOT_581f70e0_4100_4156_85e9_0cd748f2d6c4
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
  __IFNOT_581f70e0_4100_4156_85e9_0cd748f2d6c4:
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
  JMP	__ITER__START__01ec0af3_b079_495e_8add_437bd8f5bf5b
  __ITER__END__01ec0af3_b079_495e_8add_437bd8f5bf5b:
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
  __ITER__START__7244feaf_0cf3_4bda_aabe_de9ab299a263:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c82a98cd_ee33_4b80_a8f6_62898c9155b2
  BNE	__CMP_YES_c82a98cd_ee33_4b80_a8f6_62898c9155b2
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c82a98cd_ee33_4b80_a8f6_62898c9155b2
  BNE	__CMP_YES_c82a98cd_ee33_4b80_a8f6_62898c9155b2
  JMP	__CMP_NO_c82a98cd_ee33_4b80_a8f6_62898c9155b2
  __CMP_YES_c82a98cd_ee33_4b80_a8f6_62898c9155b2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c82a98cd_ee33_4b80_a8f6_62898c9155b2
  __CMP_NO_c82a98cd_ee33_4b80_a8f6_62898c9155b2:
  SEP	#$20
  LDA	#$00
  __CMP_END_c82a98cd_ee33_4b80_a8f6_62898c9155b2:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7244feaf_0cf3_4bda_aabe_de9ab299a263
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
  BNE	__IFNOT_91599e8e_87b4_41e9_aab1_742554651ec8
  JMP	__ITER__END__7244feaf_0cf3_4bda_aabe_de9ab299a263
  __IFNOT_91599e8e_87b4_41e9_aab1_742554651ec8:
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
  JMP	__ITER__START__7244feaf_0cf3_4bda_aabe_de9ab299a263
  __ITER__END__7244feaf_0cf3_4bda_aabe_de9ab299a263:
  __ITER__START__ec553278_1fb1_452a_9df6_cab258efb406:
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
  JMP	__ITER__END__ec553278_1fb1_452a_9df6_cab258efb406
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac
  BNE	__CMP_YES_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac
  BNE	__CMP_YES_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac
  JMP	__CMP_YES_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac
  __CMP_YES_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac
  __CMP_NO_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac:
  SEP	#$20
  LDA	#$00
  __CMP_END_b2fb110e_aff8_485b_a8fb_06b2c0e4d2ac:
  BEQ	__IFNOT_bb43cd47_ab79_4474_9269_3a23fc94d0ae
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
  __IFNOT_bb43cd47_ab79_4474_9269_3a23fc94d0ae:
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
  JMP	__ITER__START__ec553278_1fb1_452a_9df6_cab258efb406
  __ITER__END__ec553278_1fb1_452a_9df6_cab258efb406:
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
  __ITER__START__9d6682b5_d392_4bcf_9033_f374aae8d553:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  BNE	__CMP_YES_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  BNE	__CMP_YES_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  BNE	__CMP_YES_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  BNE	__CMP_YES_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  JMP	__CMP_NO_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  __CMP_YES_9b4874a0_10bc_4c0f_8a37_63329e6beb46:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9b4874a0_10bc_4c0f_8a37_63329e6beb46
  __CMP_NO_9b4874a0_10bc_4c0f_8a37_63329e6beb46:
  SEP	#$20
  LDA	#$00
  __CMP_END_9b4874a0_10bc_4c0f_8a37_63329e6beb46:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9d6682b5_d392_4bcf_9033_f374aae8d553
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
  BNE	__IFNOT_8fde5215_f55e_4a3f_9b82_9cb3c68089d3
  JMP	__ITER__END__9d6682b5_d392_4bcf_9033_f374aae8d553
  __IFNOT_8fde5215_f55e_4a3f_9b82_9cb3c68089d3:
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
  JMP	__ITER__START__9d6682b5_d392_4bcf_9033_f374aae8d553
  __ITER__END__9d6682b5_d392_4bcf_9033_f374aae8d553:
  __ITER__START__ddb48983_c446_4dbc_a837_f139f0097999:
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
  JMP	__ITER__END__ddb48983_c446_4dbc_a837_f139f0097999
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  BNE	__CMP_YES_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  BNE	__CMP_YES_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  BNE	__CMP_YES_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  BNE	__CMP_YES_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  JMP	__CMP_YES_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  __CMP_YES_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a
  __CMP_NO_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a:
  SEP	#$20
  LDA	#$00
  __CMP_END_d9cd9dba_5146_4cb6_bac0_9754cdf12e4a:
  BEQ	__IFNOT_e25a5fa8_d07e_43f6_ab8a_c5152a6b6ef4
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
  __IFNOT_e25a5fa8_d07e_43f6_ab8a_c5152a6b6ef4:
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
  JMP	__ITER__START__ddb48983_c446_4dbc_a837_f139f0097999
  __ITER__END__ddb48983_c446_4dbc_a837_f139f0097999:
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
  __ITER__START__bbdf0f18_a090_43a9_85c2_ad45cc88380a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  BNE	__CMP_YES_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  BNE	__CMP_YES_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  BNE	__CMP_YES_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  BNE	__CMP_YES_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  BNE	__CMP_YES_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  JMP	__CMP_NO_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  __CMP_YES_340f2b78_f6a3_40e5_b258_58ae4a8b9133:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_340f2b78_f6a3_40e5_b258_58ae4a8b9133
  __CMP_NO_340f2b78_f6a3_40e5_b258_58ae4a8b9133:
  SEP	#$20
  LDA	#$00
  __CMP_END_340f2b78_f6a3_40e5_b258_58ae4a8b9133:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__bbdf0f18_a090_43a9_85c2_ad45cc88380a
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
  BNE	__IFNOT_dc547250_f88c_4092_b667_c728a4c169b1
  JMP	__ITER__END__bbdf0f18_a090_43a9_85c2_ad45cc88380a
  __IFNOT_dc547250_f88c_4092_b667_c728a4c169b1:
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
  JMP	__ITER__START__bbdf0f18_a090_43a9_85c2_ad45cc88380a
  __ITER__END__bbdf0f18_a090_43a9_85c2_ad45cc88380a:
  __ITER__START__60bf0e6a_f5a7_4b57_85c4_39625fb16a74:
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
  JMP	__ITER__END__60bf0e6a_f5a7_4b57_85c4_39625fb16a74
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_d3652f90_2c11_449c_bb25_93f9270fc3d3
  BNE	__CMP_YES_d3652f90_2c11_449c_bb25_93f9270fc3d3
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_d3652f90_2c11_449c_bb25_93f9270fc3d3
  BNE	__CMP_YES_d3652f90_2c11_449c_bb25_93f9270fc3d3
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d3652f90_2c11_449c_bb25_93f9270fc3d3
  BNE	__CMP_YES_d3652f90_2c11_449c_bb25_93f9270fc3d3
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d3652f90_2c11_449c_bb25_93f9270fc3d3
  BNE	__CMP_YES_d3652f90_2c11_449c_bb25_93f9270fc3d3
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d3652f90_2c11_449c_bb25_93f9270fc3d3
  BNE	__CMP_YES_d3652f90_2c11_449c_bb25_93f9270fc3d3
  JMP	__CMP_YES_d3652f90_2c11_449c_bb25_93f9270fc3d3
  __CMP_YES_d3652f90_2c11_449c_bb25_93f9270fc3d3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d3652f90_2c11_449c_bb25_93f9270fc3d3
  __CMP_NO_d3652f90_2c11_449c_bb25_93f9270fc3d3:
  SEP	#$20
  LDA	#$00
  __CMP_END_d3652f90_2c11_449c_bb25_93f9270fc3d3:
  BEQ	__IFNOT_e2e9a09a_fd4c_466c_b6d0_6ae2a38a03a2
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
  __IFNOT_e2e9a09a_fd4c_466c_b6d0_6ae2a38a03a2:
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
  JMP	__ITER__START__60bf0e6a_f5a7_4b57_85c4_39625fb16a74
  __ITER__END__60bf0e6a_f5a7_4b57_85c4_39625fb16a74:
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
  __ITER__START__1c3f85ec_4b40_4511_8b29_beee34bcafb2:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  BNE	__CMP_YES_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  BNE	__CMP_YES_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  BNE	__CMP_YES_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  BNE	__CMP_YES_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  JMP	__CMP_NO_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  __CMP_YES_525eba3e_162f_4fca_b273_1c4d37d3ce7c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_525eba3e_162f_4fca_b273_1c4d37d3ce7c
  __CMP_NO_525eba3e_162f_4fca_b273_1c4d37d3ce7c:
  SEP	#$20
  LDA	#$00
  __CMP_END_525eba3e_162f_4fca_b273_1c4d37d3ce7c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1c3f85ec_4b40_4511_8b29_beee34bcafb2
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
  BNE	__IFNOT_1d692fd3_b81b_47b7_acd9_d3c4e8faa261
  JMP	__ITER__END__1c3f85ec_4b40_4511_8b29_beee34bcafb2
  __IFNOT_1d692fd3_b81b_47b7_acd9_d3c4e8faa261:
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
  JMP	__ITER__START__1c3f85ec_4b40_4511_8b29_beee34bcafb2
  __ITER__END__1c3f85ec_4b40_4511_8b29_beee34bcafb2:
  __ITER__START__cc42a956_056a_46d2_8eab_0ca1756dcf19:
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
  JMP	__ITER__END__cc42a956_056a_46d2_8eab_0ca1756dcf19
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_ed933516_3eb9_4d2e_a532_d2127cde7b83
  BNE	__CMP_YES_ed933516_3eb9_4d2e_a532_d2127cde7b83
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_ed933516_3eb9_4d2e_a532_d2127cde7b83
  BNE	__CMP_YES_ed933516_3eb9_4d2e_a532_d2127cde7b83
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_ed933516_3eb9_4d2e_a532_d2127cde7b83
  BNE	__CMP_YES_ed933516_3eb9_4d2e_a532_d2127cde7b83
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ed933516_3eb9_4d2e_a532_d2127cde7b83
  BNE	__CMP_YES_ed933516_3eb9_4d2e_a532_d2127cde7b83
  JMP	__CMP_YES_ed933516_3eb9_4d2e_a532_d2127cde7b83
  __CMP_YES_ed933516_3eb9_4d2e_a532_d2127cde7b83:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ed933516_3eb9_4d2e_a532_d2127cde7b83
  __CMP_NO_ed933516_3eb9_4d2e_a532_d2127cde7b83:
  SEP	#$20
  LDA	#$00
  __CMP_END_ed933516_3eb9_4d2e_a532_d2127cde7b83:
  BEQ	__IFNOT_364ab330_0614_4c46_9195_b1bb7fde3679
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
  __IFNOT_364ab330_0614_4c46_9195_b1bb7fde3679:
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
  JMP	__ITER__START__cc42a956_056a_46d2_8eab_0ca1756dcf19
  __ITER__END__cc42a956_056a_46d2_8eab_0ca1756dcf19:
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
  __ITER__START__badca7e2_43ba_4268_9aca_8cbc719d1f3b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_11cf2224_ad92_4872_a420_1c909f5e740d
  BNE	__CMP_YES_11cf2224_ad92_4872_a420_1c909f5e740d
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_11cf2224_ad92_4872_a420_1c909f5e740d
  BNE	__CMP_YES_11cf2224_ad92_4872_a420_1c909f5e740d
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_11cf2224_ad92_4872_a420_1c909f5e740d
  BNE	__CMP_YES_11cf2224_ad92_4872_a420_1c909f5e740d
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_11cf2224_ad92_4872_a420_1c909f5e740d
  BNE	__CMP_YES_11cf2224_ad92_4872_a420_1c909f5e740d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_11cf2224_ad92_4872_a420_1c909f5e740d
  BNE	__CMP_YES_11cf2224_ad92_4872_a420_1c909f5e740d
  JMP	__CMP_NO_11cf2224_ad92_4872_a420_1c909f5e740d
  __CMP_YES_11cf2224_ad92_4872_a420_1c909f5e740d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_11cf2224_ad92_4872_a420_1c909f5e740d
  __CMP_NO_11cf2224_ad92_4872_a420_1c909f5e740d:
  SEP	#$20
  LDA	#$00
  __CMP_END_11cf2224_ad92_4872_a420_1c909f5e740d:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__badca7e2_43ba_4268_9aca_8cbc719d1f3b
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
  BNE	__IFNOT_c2d14495_0b58_4d31_8d3b_16caa835f191
  JMP	__ITER__END__badca7e2_43ba_4268_9aca_8cbc719d1f3b
  __IFNOT_c2d14495_0b58_4d31_8d3b_16caa835f191:
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
  JMP	__ITER__START__badca7e2_43ba_4268_9aca_8cbc719d1f3b
  __ITER__END__badca7e2_43ba_4268_9aca_8cbc719d1f3b:
  __ITER__START__3dd02db3_8e77_4bde_b2ef_6ade4c9a8e17:
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
  JMP	__ITER__END__3dd02db3_8e77_4bde_b2ef_6ade4c9a8e17
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_da415554_e295_4085_b342_fdc9c5793d71
  BNE	__CMP_YES_da415554_e295_4085_b342_fdc9c5793d71
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_da415554_e295_4085_b342_fdc9c5793d71
  BNE	__CMP_YES_da415554_e295_4085_b342_fdc9c5793d71
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_da415554_e295_4085_b342_fdc9c5793d71
  BNE	__CMP_YES_da415554_e295_4085_b342_fdc9c5793d71
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_da415554_e295_4085_b342_fdc9c5793d71
  BNE	__CMP_YES_da415554_e295_4085_b342_fdc9c5793d71
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_da415554_e295_4085_b342_fdc9c5793d71
  BNE	__CMP_YES_da415554_e295_4085_b342_fdc9c5793d71
  JMP	__CMP_YES_da415554_e295_4085_b342_fdc9c5793d71
  __CMP_YES_da415554_e295_4085_b342_fdc9c5793d71:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_da415554_e295_4085_b342_fdc9c5793d71
  __CMP_NO_da415554_e295_4085_b342_fdc9c5793d71:
  SEP	#$20
  LDA	#$00
  __CMP_END_da415554_e295_4085_b342_fdc9c5793d71:
  BEQ	__IFNOT_f2b450eb_a524_4273_a58d_b57a71b86624
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
  __IFNOT_f2b450eb_a524_4273_a58d_b57a71b86624:
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
  JMP	__ITER__START__3dd02db3_8e77_4bde_b2ef_6ade4c9a8e17
  __ITER__END__3dd02db3_8e77_4bde_b2ef_6ade4c9a8e17:
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
  __ITER__START__81a4c1d9_ae6d_4bfa_8aad_5ed2c4fd76d8:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_3caeed0f_4c92_49e5_b17c_4e3f18722886
  BNE	__CMP_YES_3caeed0f_4c92_49e5_b17c_4e3f18722886
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_3caeed0f_4c92_49e5_b17c_4e3f18722886
  BNE	__CMP_YES_3caeed0f_4c92_49e5_b17c_4e3f18722886
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3caeed0f_4c92_49e5_b17c_4e3f18722886
  BNE	__CMP_YES_3caeed0f_4c92_49e5_b17c_4e3f18722886
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3caeed0f_4c92_49e5_b17c_4e3f18722886
  BNE	__CMP_YES_3caeed0f_4c92_49e5_b17c_4e3f18722886
  JMP	__CMP_NO_3caeed0f_4c92_49e5_b17c_4e3f18722886
  __CMP_YES_3caeed0f_4c92_49e5_b17c_4e3f18722886:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3caeed0f_4c92_49e5_b17c_4e3f18722886
  __CMP_NO_3caeed0f_4c92_49e5_b17c_4e3f18722886:
  SEP	#$20
  LDA	#$00
  __CMP_END_3caeed0f_4c92_49e5_b17c_4e3f18722886:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__81a4c1d9_ae6d_4bfa_8aad_5ed2c4fd76d8
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
  BNE	__IFNOT_551eec4b_449a_47e9_93fd_531ad643420e
  JMP	__ITER__END__81a4c1d9_ae6d_4bfa_8aad_5ed2c4fd76d8
  __IFNOT_551eec4b_449a_47e9_93fd_531ad643420e:
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
  JMP	__ITER__START__81a4c1d9_ae6d_4bfa_8aad_5ed2c4fd76d8
  __ITER__END__81a4c1d9_ae6d_4bfa_8aad_5ed2c4fd76d8:
  __ITER__START__4e97fa6e_97a5_4dcc_9537_4776f8617fc1:
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
  JMP	__ITER__END__4e97fa6e_97a5_4dcc_9537_4776f8617fc1
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_3dbbbf3f_6674_4964_802c_1deebe12e372
  BNE	__CMP_YES_3dbbbf3f_6674_4964_802c_1deebe12e372
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_3dbbbf3f_6674_4964_802c_1deebe12e372
  BNE	__CMP_YES_3dbbbf3f_6674_4964_802c_1deebe12e372
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3dbbbf3f_6674_4964_802c_1deebe12e372
  BNE	__CMP_YES_3dbbbf3f_6674_4964_802c_1deebe12e372
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3dbbbf3f_6674_4964_802c_1deebe12e372
  BNE	__CMP_YES_3dbbbf3f_6674_4964_802c_1deebe12e372
  JMP	__CMP_YES_3dbbbf3f_6674_4964_802c_1deebe12e372
  __CMP_YES_3dbbbf3f_6674_4964_802c_1deebe12e372:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3dbbbf3f_6674_4964_802c_1deebe12e372
  __CMP_NO_3dbbbf3f_6674_4964_802c_1deebe12e372:
  SEP	#$20
  LDA	#$00
  __CMP_END_3dbbbf3f_6674_4964_802c_1deebe12e372:
  BEQ	__IFNOT_5a6af463_2cab_4ef7_b0bf_6358eb051ba9
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
  __IFNOT_5a6af463_2cab_4ef7_b0bf_6358eb051ba9:
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
  JMP	__ITER__START__4e97fa6e_97a5_4dcc_9537_4776f8617fc1
  __ITER__END__4e97fa6e_97a5_4dcc_9537_4776f8617fc1:
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
  __ITER__START__af5faa11_c9d7_44d6_990a_d096a2c04f00:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_6887c596_57ec_4c82_84d6_4dd83533f189
  BNE	__CMP_YES_6887c596_57ec_4c82_84d6_4dd83533f189
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_6887c596_57ec_4c82_84d6_4dd83533f189
  BNE	__CMP_YES_6887c596_57ec_4c82_84d6_4dd83533f189
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6887c596_57ec_4c82_84d6_4dd83533f189
  BNE	__CMP_YES_6887c596_57ec_4c82_84d6_4dd83533f189
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6887c596_57ec_4c82_84d6_4dd83533f189
  BNE	__CMP_YES_6887c596_57ec_4c82_84d6_4dd83533f189
  JMP	__CMP_NO_6887c596_57ec_4c82_84d6_4dd83533f189
  __CMP_YES_6887c596_57ec_4c82_84d6_4dd83533f189:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6887c596_57ec_4c82_84d6_4dd83533f189
  __CMP_NO_6887c596_57ec_4c82_84d6_4dd83533f189:
  SEP	#$20
  LDA	#$00
  __CMP_END_6887c596_57ec_4c82_84d6_4dd83533f189:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__af5faa11_c9d7_44d6_990a_d096a2c04f00
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
  BNE	__IFNOT_1bb0bbe0_3393_4af3_b6cb_e7613581fc93
  JMP	__ITER__END__af5faa11_c9d7_44d6_990a_d096a2c04f00
  __IFNOT_1bb0bbe0_3393_4af3_b6cb_e7613581fc93:
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
  JMP	__ITER__START__af5faa11_c9d7_44d6_990a_d096a2c04f00
  __ITER__END__af5faa11_c9d7_44d6_990a_d096a2c04f00:
  __ITER__START__c93265a6_90c2_41a8_b209_7cb1cc023772:
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
  JMP	__ITER__END__c93265a6_90c2_41a8_b209_7cb1cc023772
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_09b07cc2_a936_40bc_a01b_46473943ac82
  BNE	__CMP_YES_09b07cc2_a936_40bc_a01b_46473943ac82
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_09b07cc2_a936_40bc_a01b_46473943ac82
  BNE	__CMP_YES_09b07cc2_a936_40bc_a01b_46473943ac82
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_09b07cc2_a936_40bc_a01b_46473943ac82
  BNE	__CMP_YES_09b07cc2_a936_40bc_a01b_46473943ac82
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_09b07cc2_a936_40bc_a01b_46473943ac82
  BNE	__CMP_YES_09b07cc2_a936_40bc_a01b_46473943ac82
  JMP	__CMP_YES_09b07cc2_a936_40bc_a01b_46473943ac82
  __CMP_YES_09b07cc2_a936_40bc_a01b_46473943ac82:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_09b07cc2_a936_40bc_a01b_46473943ac82
  __CMP_NO_09b07cc2_a936_40bc_a01b_46473943ac82:
  SEP	#$20
  LDA	#$00
  __CMP_END_09b07cc2_a936_40bc_a01b_46473943ac82:
  BNE	:+
  JMP	__IFNOT_4ccf8ef2_f2cf_414b_858f_1dd724c8470f
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
  __IFNOT_4ccf8ef2_f2cf_414b_858f_1dd724c8470f:
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
  JMP	__ITER__START__c93265a6_90c2_41a8_b209_7cb1cc023772
  __ITER__END__c93265a6_90c2_41a8_b209_7cb1cc023772:
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
