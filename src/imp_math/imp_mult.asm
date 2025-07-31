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
  __ITER__START__77306403_0a3e_471f_a417_0e7d57d8df0e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8fa573ae_d17b_4dc7_8382_57d353249767
  BNE	__CMP_YES_8fa573ae_d17b_4dc7_8382_57d353249767
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8fa573ae_d17b_4dc7_8382_57d353249767
  BNE	__CMP_YES_8fa573ae_d17b_4dc7_8382_57d353249767
  JMP	__CMP_NO_8fa573ae_d17b_4dc7_8382_57d353249767
  __CMP_YES_8fa573ae_d17b_4dc7_8382_57d353249767:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8fa573ae_d17b_4dc7_8382_57d353249767
  __CMP_NO_8fa573ae_d17b_4dc7_8382_57d353249767:
  SEP	#$20
  LDA	#$00
  __CMP_END_8fa573ae_d17b_4dc7_8382_57d353249767:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__77306403_0a3e_471f_a417_0e7d57d8df0e
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
  BNE	__IFNOT_ca0773d4_8de3_4636_9cdf_fd974885ddfd
  JMP	__ITER__END__77306403_0a3e_471f_a417_0e7d57d8df0e
  __IFNOT_ca0773d4_8de3_4636_9cdf_fd974885ddfd:
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
  JMP	__ITER__START__77306403_0a3e_471f_a417_0e7d57d8df0e
  __ITER__END__77306403_0a3e_471f_a417_0e7d57d8df0e:
  __ITER__START__32af657b_48b1_4f6a_b81e_2fa111d7413f:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__32af657b_48b1_4f6a_b81e_2fa111d7413f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a6bd9067_83c0_4421_bc53_b5b3586ce2c7
  BNE	__CMP_YES_a6bd9067_83c0_4421_bc53_b5b3586ce2c7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a6bd9067_83c0_4421_bc53_b5b3586ce2c7
  BNE	__CMP_YES_a6bd9067_83c0_4421_bc53_b5b3586ce2c7
  JMP	__CMP_YES_a6bd9067_83c0_4421_bc53_b5b3586ce2c7
  __CMP_YES_a6bd9067_83c0_4421_bc53_b5b3586ce2c7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a6bd9067_83c0_4421_bc53_b5b3586ce2c7
  __CMP_NO_a6bd9067_83c0_4421_bc53_b5b3586ce2c7:
  SEP	#$20
  LDA	#$00
  __CMP_END_a6bd9067_83c0_4421_bc53_b5b3586ce2c7:
  BEQ	__IFNOT_ed25d411_1340_4bff_a9a7_0acd486d2428
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
  __IFNOT_ed25d411_1340_4bff_a9a7_0acd486d2428:
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
  JMP	__ITER__START__32af657b_48b1_4f6a_b81e_2fa111d7413f
  __ITER__END__32af657b_48b1_4f6a_b81e_2fa111d7413f:
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
  __ITER__START__0bb4ac33_9178_4962_ac9b_5d5ab3806b90:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8fd326b2_6416_4b8f_87eb_e47002e3437a
  BNE	__CMP_YES_8fd326b2_6416_4b8f_87eb_e47002e3437a
  JMP	__CMP_NO_8fd326b2_6416_4b8f_87eb_e47002e3437a
  __CMP_YES_8fd326b2_6416_4b8f_87eb_e47002e3437a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8fd326b2_6416_4b8f_87eb_e47002e3437a
  __CMP_NO_8fd326b2_6416_4b8f_87eb_e47002e3437a:
  SEP	#$20
  LDA	#$00
  __CMP_END_8fd326b2_6416_4b8f_87eb_e47002e3437a:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__0bb4ac33_9178_4962_ac9b_5d5ab3806b90
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
  BNE	__IFNOT_2ef7df1f_e122_4197_97df_e553264a608a
  JMP	__ITER__END__0bb4ac33_9178_4962_ac9b_5d5ab3806b90
  __IFNOT_2ef7df1f_e122_4197_97df_e553264a608a:
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
  JMP	__ITER__START__0bb4ac33_9178_4962_ac9b_5d5ab3806b90
  __ITER__END__0bb4ac33_9178_4962_ac9b_5d5ab3806b90:
  __ITER__START__d415d3dc_db4a_4c1e_a000_30146b0f3518:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d415d3dc_db4a_4c1e_a000_30146b0f3518
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_af0839b1_166c_42d3_b09d_4279a9aea65b
  BNE	__CMP_YES_af0839b1_166c_42d3_b09d_4279a9aea65b
  JMP	__CMP_YES_af0839b1_166c_42d3_b09d_4279a9aea65b
  __CMP_YES_af0839b1_166c_42d3_b09d_4279a9aea65b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_af0839b1_166c_42d3_b09d_4279a9aea65b
  __CMP_NO_af0839b1_166c_42d3_b09d_4279a9aea65b:
  SEP	#$20
  LDA	#$00
  __CMP_END_af0839b1_166c_42d3_b09d_4279a9aea65b:
  BEQ	__IFNOT_bea13046_0066_4884_844c_818a4198988e
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
  __IFNOT_bea13046_0066_4884_844c_818a4198988e:
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
  JMP	__ITER__START__d415d3dc_db4a_4c1e_a000_30146b0f3518
  __ITER__END__d415d3dc_db4a_4c1e_a000_30146b0f3518:
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
  __ITER__START__0f32bdb8_70b6_4a86_8cb2_b2e1104ecc3b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_412080cf_8d94_4451_8dda_8bc55f7d1cd6
  BNE	__CMP_YES_412080cf_8d94_4451_8dda_8bc55f7d1cd6
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_412080cf_8d94_4451_8dda_8bc55f7d1cd6
  BNE	__CMP_YES_412080cf_8d94_4451_8dda_8bc55f7d1cd6
  JMP	__CMP_NO_412080cf_8d94_4451_8dda_8bc55f7d1cd6
  __CMP_YES_412080cf_8d94_4451_8dda_8bc55f7d1cd6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_412080cf_8d94_4451_8dda_8bc55f7d1cd6
  __CMP_NO_412080cf_8d94_4451_8dda_8bc55f7d1cd6:
  SEP	#$20
  LDA	#$00
  __CMP_END_412080cf_8d94_4451_8dda_8bc55f7d1cd6:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__0f32bdb8_70b6_4a86_8cb2_b2e1104ecc3b
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
  BNE	__IFNOT_43259514_02af_4a68_82bc_ce1757d15f61
  JMP	__ITER__END__0f32bdb8_70b6_4a86_8cb2_b2e1104ecc3b
  __IFNOT_43259514_02af_4a68_82bc_ce1757d15f61:
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
  JMP	__ITER__START__0f32bdb8_70b6_4a86_8cb2_b2e1104ecc3b
  __ITER__END__0f32bdb8_70b6_4a86_8cb2_b2e1104ecc3b:
  __ITER__START__aeea2aa0_f3c4_4527_b233_26953104d7d1:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__aeea2aa0_f3c4_4527_b233_26953104d7d1
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_a7566b48_8711_4a2a_96a9_ae8da5e5ee61
  BNE	__CMP_YES_a7566b48_8711_4a2a_96a9_ae8da5e5ee61
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a7566b48_8711_4a2a_96a9_ae8da5e5ee61
  BNE	__CMP_YES_a7566b48_8711_4a2a_96a9_ae8da5e5ee61
  JMP	__CMP_YES_a7566b48_8711_4a2a_96a9_ae8da5e5ee61
  __CMP_YES_a7566b48_8711_4a2a_96a9_ae8da5e5ee61:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a7566b48_8711_4a2a_96a9_ae8da5e5ee61
  __CMP_NO_a7566b48_8711_4a2a_96a9_ae8da5e5ee61:
  SEP	#$20
  LDA	#$00
  __CMP_END_a7566b48_8711_4a2a_96a9_ae8da5e5ee61:
  BEQ	__IFNOT_c9f1859c_705d_494a_a93f_f2924f6a3c09
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
  __IFNOT_c9f1859c_705d_494a_a93f_f2924f6a3c09:
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
  JMP	__ITER__START__aeea2aa0_f3c4_4527_b233_26953104d7d1
  __ITER__END__aeea2aa0_f3c4_4527_b233_26953104d7d1:
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
  __ITER__START__078bf4ec_5438_4577_8d2b_a4453b0b1acc:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_4113c408_1aad_4e0b_bf3d_cd1592fe25fc
  BNE	__CMP_YES_4113c408_1aad_4e0b_bf3d_cd1592fe25fc
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4113c408_1aad_4e0b_bf3d_cd1592fe25fc
  BNE	__CMP_YES_4113c408_1aad_4e0b_bf3d_cd1592fe25fc
  JMP	__CMP_NO_4113c408_1aad_4e0b_bf3d_cd1592fe25fc
  __CMP_YES_4113c408_1aad_4e0b_bf3d_cd1592fe25fc:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4113c408_1aad_4e0b_bf3d_cd1592fe25fc
  __CMP_NO_4113c408_1aad_4e0b_bf3d_cd1592fe25fc:
  SEP	#$20
  LDA	#$00
  __CMP_END_4113c408_1aad_4e0b_bf3d_cd1592fe25fc:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__078bf4ec_5438_4577_8d2b_a4453b0b1acc
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
  BNE	__IFNOT_78951e36_593b_4840_bb1a_14f0195d8e50
  JMP	__ITER__END__078bf4ec_5438_4577_8d2b_a4453b0b1acc
  __IFNOT_78951e36_593b_4840_bb1a_14f0195d8e50:
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
  JMP	__ITER__START__078bf4ec_5438_4577_8d2b_a4453b0b1acc
  __ITER__END__078bf4ec_5438_4577_8d2b_a4453b0b1acc:
  __ITER__START__a0817c94_ab70_4cc1_859b_bd693efbedeb:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a0817c94_ab70_4cc1_859b_bd693efbedeb
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_99fbe6fc_853d_4750_b488_cc696140ced9
  BNE	__CMP_YES_99fbe6fc_853d_4750_b488_cc696140ced9
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_99fbe6fc_853d_4750_b488_cc696140ced9
  BNE	__CMP_YES_99fbe6fc_853d_4750_b488_cc696140ced9
  JMP	__CMP_YES_99fbe6fc_853d_4750_b488_cc696140ced9
  __CMP_YES_99fbe6fc_853d_4750_b488_cc696140ced9:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_99fbe6fc_853d_4750_b488_cc696140ced9
  __CMP_NO_99fbe6fc_853d_4750_b488_cc696140ced9:
  SEP	#$20
  LDA	#$00
  __CMP_END_99fbe6fc_853d_4750_b488_cc696140ced9:
  BEQ	__IFNOT_0c417561_cb3c_4671_908e_ef54fcd9a3e9
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
  __IFNOT_0c417561_cb3c_4671_908e_ef54fcd9a3e9:
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
  JMP	__ITER__START__a0817c94_ab70_4cc1_859b_bd693efbedeb
  __ITER__END__a0817c94_ab70_4cc1_859b_bd693efbedeb:
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
  __ITER__START__cb937acc_9ac6_4dae_a843_c56cf79eb211:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_16603014_1775_4c54_8285_aacd51dec265
  BNE	__CMP_YES_16603014_1775_4c54_8285_aacd51dec265
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_16603014_1775_4c54_8285_aacd51dec265
  BNE	__CMP_YES_16603014_1775_4c54_8285_aacd51dec265
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_16603014_1775_4c54_8285_aacd51dec265
  BNE	__CMP_YES_16603014_1775_4c54_8285_aacd51dec265
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_16603014_1775_4c54_8285_aacd51dec265
  BNE	__CMP_YES_16603014_1775_4c54_8285_aacd51dec265
  JMP	__CMP_NO_16603014_1775_4c54_8285_aacd51dec265
  __CMP_YES_16603014_1775_4c54_8285_aacd51dec265:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_16603014_1775_4c54_8285_aacd51dec265
  __CMP_NO_16603014_1775_4c54_8285_aacd51dec265:
  SEP	#$20
  LDA	#$00
  __CMP_END_16603014_1775_4c54_8285_aacd51dec265:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__cb937acc_9ac6_4dae_a843_c56cf79eb211
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
  BNE	__IFNOT_9e939a97_cf1f_491a_9958_7870529cf835
  JMP	__ITER__END__cb937acc_9ac6_4dae_a843_c56cf79eb211
  __IFNOT_9e939a97_cf1f_491a_9958_7870529cf835:
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
  JMP	__ITER__START__cb937acc_9ac6_4dae_a843_c56cf79eb211
  __ITER__END__cb937acc_9ac6_4dae_a843_c56cf79eb211:
  __ITER__START__9d83774d_120a_4bb1_b12a_d9cdc387717b:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9d83774d_120a_4bb1_b12a_d9cdc387717b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_9c12b722_5400_478f_8ebd_226b8f7605f7
  BNE	__CMP_YES_9c12b722_5400_478f_8ebd_226b8f7605f7
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_9c12b722_5400_478f_8ebd_226b8f7605f7
  BNE	__CMP_YES_9c12b722_5400_478f_8ebd_226b8f7605f7
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_9c12b722_5400_478f_8ebd_226b8f7605f7
  BNE	__CMP_YES_9c12b722_5400_478f_8ebd_226b8f7605f7
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9c12b722_5400_478f_8ebd_226b8f7605f7
  BNE	__CMP_YES_9c12b722_5400_478f_8ebd_226b8f7605f7
  JMP	__CMP_YES_9c12b722_5400_478f_8ebd_226b8f7605f7
  __CMP_YES_9c12b722_5400_478f_8ebd_226b8f7605f7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9c12b722_5400_478f_8ebd_226b8f7605f7
  __CMP_NO_9c12b722_5400_478f_8ebd_226b8f7605f7:
  SEP	#$20
  LDA	#$00
  __CMP_END_9c12b722_5400_478f_8ebd_226b8f7605f7:
  BEQ	__IFNOT_e275f723_e172_41a3_ba41_02eba9aeee59
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
  __IFNOT_e275f723_e172_41a3_ba41_02eba9aeee59:
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
  JMP	__ITER__START__9d83774d_120a_4bb1_b12a_d9cdc387717b
  __ITER__END__9d83774d_120a_4bb1_b12a_d9cdc387717b:
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
  __ITER__START__b7afbc5c_2181_4f55_b51d_39ec41254f85:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_90651862_e8ce_4cd4_9bc2_d7eaefe647a9
  BNE	__CMP_YES_90651862_e8ce_4cd4_9bc2_d7eaefe647a9
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_90651862_e8ce_4cd4_9bc2_d7eaefe647a9
  BNE	__CMP_YES_90651862_e8ce_4cd4_9bc2_d7eaefe647a9
  JMP	__CMP_NO_90651862_e8ce_4cd4_9bc2_d7eaefe647a9
  __CMP_YES_90651862_e8ce_4cd4_9bc2_d7eaefe647a9:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_90651862_e8ce_4cd4_9bc2_d7eaefe647a9
  __CMP_NO_90651862_e8ce_4cd4_9bc2_d7eaefe647a9:
  SEP	#$20
  LDA	#$00
  __CMP_END_90651862_e8ce_4cd4_9bc2_d7eaefe647a9:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b7afbc5c_2181_4f55_b51d_39ec41254f85
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
  BNE	__IFNOT_4c53a756_4698_4650_9e94_75d02d038829
  JMP	__ITER__END__b7afbc5c_2181_4f55_b51d_39ec41254f85
  __IFNOT_4c53a756_4698_4650_9e94_75d02d038829:
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
  JMP	__ITER__START__b7afbc5c_2181_4f55_b51d_39ec41254f85
  __ITER__END__b7afbc5c_2181_4f55_b51d_39ec41254f85:
  __ITER__START__abb5acd2_6a7b_4ef7_a075_e3ae5e03e52f:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__abb5acd2_6a7b_4ef7_a075_e3ae5e03e52f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_20340354_8138_46b8_b38d_76aa259341bb
  BNE	__CMP_YES_20340354_8138_46b8_b38d_76aa259341bb
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_20340354_8138_46b8_b38d_76aa259341bb
  BNE	__CMP_YES_20340354_8138_46b8_b38d_76aa259341bb
  JMP	__CMP_YES_20340354_8138_46b8_b38d_76aa259341bb
  __CMP_YES_20340354_8138_46b8_b38d_76aa259341bb:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_20340354_8138_46b8_b38d_76aa259341bb
  __CMP_NO_20340354_8138_46b8_b38d_76aa259341bb:
  SEP	#$20
  LDA	#$00
  __CMP_END_20340354_8138_46b8_b38d_76aa259341bb:
  BEQ	__IFNOT_ed3f48af_91de_45cc_adfa_a2f80309a2a3
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
  __IFNOT_ed3f48af_91de_45cc_adfa_a2f80309a2a3:
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
  JMP	__ITER__START__abb5acd2_6a7b_4ef7_a075_e3ae5e03e52f
  __ITER__END__abb5acd2_6a7b_4ef7_a075_e3ae5e03e52f:
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
  __ITER__START__9201f74b_76e0_4ef8_94c4_42b996ff44f3:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_54ac5469_935f_4983_aab9_85160b027b73
  BNE	__CMP_YES_54ac5469_935f_4983_aab9_85160b027b73
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_54ac5469_935f_4983_aab9_85160b027b73
  BNE	__CMP_YES_54ac5469_935f_4983_aab9_85160b027b73
  JMP	__CMP_NO_54ac5469_935f_4983_aab9_85160b027b73
  __CMP_YES_54ac5469_935f_4983_aab9_85160b027b73:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_54ac5469_935f_4983_aab9_85160b027b73
  __CMP_NO_54ac5469_935f_4983_aab9_85160b027b73:
  SEP	#$20
  LDA	#$00
  __CMP_END_54ac5469_935f_4983_aab9_85160b027b73:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9201f74b_76e0_4ef8_94c4_42b996ff44f3
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
  BNE	__IFNOT_638b3c91_d332_4bfe_b44e_66178bb1b1b4
  JMP	__ITER__END__9201f74b_76e0_4ef8_94c4_42b996ff44f3
  __IFNOT_638b3c91_d332_4bfe_b44e_66178bb1b1b4:
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
  JMP	__ITER__START__9201f74b_76e0_4ef8_94c4_42b996ff44f3
  __ITER__END__9201f74b_76e0_4ef8_94c4_42b996ff44f3:
  __ITER__START__300973c7_e03e_49ca_a39a_098ab50abd81:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__300973c7_e03e_49ca_a39a_098ab50abd81
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_cfddb98d_ecdc_4e61_9cff_8df94feb22d5
  BNE	__CMP_YES_cfddb98d_ecdc_4e61_9cff_8df94feb22d5
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cfddb98d_ecdc_4e61_9cff_8df94feb22d5
  BNE	__CMP_YES_cfddb98d_ecdc_4e61_9cff_8df94feb22d5
  JMP	__CMP_YES_cfddb98d_ecdc_4e61_9cff_8df94feb22d5
  __CMP_YES_cfddb98d_ecdc_4e61_9cff_8df94feb22d5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cfddb98d_ecdc_4e61_9cff_8df94feb22d5
  __CMP_NO_cfddb98d_ecdc_4e61_9cff_8df94feb22d5:
  SEP	#$20
  LDA	#$00
  __CMP_END_cfddb98d_ecdc_4e61_9cff_8df94feb22d5:
  BEQ	__IFNOT_14b2569c_5c73_4606_bd15_6cb8253b22f8
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
  __IFNOT_14b2569c_5c73_4606_bd15_6cb8253b22f8:
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
  JMP	__ITER__START__300973c7_e03e_49ca_a39a_098ab50abd81
  __ITER__END__300973c7_e03e_49ca_a39a_098ab50abd81:
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
  __ITER__START__8d4f426c_237f_4f7e_a2d8_85d64fc714c9:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_07fc42de_a6c3_4254_a01a_c7bcd01cb65f
  BNE	__CMP_YES_07fc42de_a6c3_4254_a01a_c7bcd01cb65f
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_07fc42de_a6c3_4254_a01a_c7bcd01cb65f
  BNE	__CMP_YES_07fc42de_a6c3_4254_a01a_c7bcd01cb65f
  JMP	__CMP_NO_07fc42de_a6c3_4254_a01a_c7bcd01cb65f
  __CMP_YES_07fc42de_a6c3_4254_a01a_c7bcd01cb65f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_07fc42de_a6c3_4254_a01a_c7bcd01cb65f
  __CMP_NO_07fc42de_a6c3_4254_a01a_c7bcd01cb65f:
  SEP	#$20
  LDA	#$00
  __CMP_END_07fc42de_a6c3_4254_a01a_c7bcd01cb65f:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__8d4f426c_237f_4f7e_a2d8_85d64fc714c9
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
  BNE	__IFNOT_46e8ce53_c0fc_4140_8e34_f7c64c9c14db
  JMP	__ITER__END__8d4f426c_237f_4f7e_a2d8_85d64fc714c9
  __IFNOT_46e8ce53_c0fc_4140_8e34_f7c64c9c14db:
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
  JMP	__ITER__START__8d4f426c_237f_4f7e_a2d8_85d64fc714c9
  __ITER__END__8d4f426c_237f_4f7e_a2d8_85d64fc714c9:
  __ITER__START__dc2aa847_3548_45c0_b2d6_9645871cc637:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__dc2aa847_3548_45c0_b2d6_9645871cc637
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271
  BNE	__CMP_YES_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271
  BNE	__CMP_YES_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271
  JMP	__CMP_YES_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271
  __CMP_YES_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271
  __CMP_NO_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271:
  SEP	#$20
  LDA	#$00
  __CMP_END_05ee7e90_4a8e_4b0d_a23f_39b8fd9d3271:
  BEQ	__IFNOT_765314cf_e32b_4131_ba0d_ffa4a62e4bc2
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
  __IFNOT_765314cf_e32b_4131_ba0d_ffa4a62e4bc2:
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
  JMP	__ITER__START__dc2aa847_3548_45c0_b2d6_9645871cc637
  __ITER__END__dc2aa847_3548_45c0_b2d6_9645871cc637:
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
  __ITER__START__8e3d9c71_9860_49ac_aa1c_5bbf57eca197:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_c86f0d31_1c00_4ef9_a8da_7aab634976b3
  BNE	__CMP_YES_c86f0d31_1c00_4ef9_a8da_7aab634976b3
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c86f0d31_1c00_4ef9_a8da_7aab634976b3
  BNE	__CMP_YES_c86f0d31_1c00_4ef9_a8da_7aab634976b3
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c86f0d31_1c00_4ef9_a8da_7aab634976b3
  BNE	__CMP_YES_c86f0d31_1c00_4ef9_a8da_7aab634976b3
  JMP	__CMP_NO_c86f0d31_1c00_4ef9_a8da_7aab634976b3
  __CMP_YES_c86f0d31_1c00_4ef9_a8da_7aab634976b3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c86f0d31_1c00_4ef9_a8da_7aab634976b3
  __CMP_NO_c86f0d31_1c00_4ef9_a8da_7aab634976b3:
  SEP	#$20
  LDA	#$00
  __CMP_END_c86f0d31_1c00_4ef9_a8da_7aab634976b3:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__8e3d9c71_9860_49ac_aa1c_5bbf57eca197
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
  BNE	__IFNOT_04bc1925_c062_4f5d_bf68_dd10879b0ae2
  JMP	__ITER__END__8e3d9c71_9860_49ac_aa1c_5bbf57eca197
  __IFNOT_04bc1925_c062_4f5d_bf68_dd10879b0ae2:
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
  JMP	__ITER__START__8e3d9c71_9860_49ac_aa1c_5bbf57eca197
  __ITER__END__8e3d9c71_9860_49ac_aa1c_5bbf57eca197:
  __ITER__START__2308462b_8844_409d_af8a_9486519ab812:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__2308462b_8844_409d_af8a_9486519ab812
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_766ff3a4_29f0_4086_8290_d709aa19cc12
  BNE	__CMP_YES_766ff3a4_29f0_4086_8290_d709aa19cc12
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_766ff3a4_29f0_4086_8290_d709aa19cc12
  BNE	__CMP_YES_766ff3a4_29f0_4086_8290_d709aa19cc12
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_766ff3a4_29f0_4086_8290_d709aa19cc12
  BNE	__CMP_YES_766ff3a4_29f0_4086_8290_d709aa19cc12
  JMP	__CMP_YES_766ff3a4_29f0_4086_8290_d709aa19cc12
  __CMP_YES_766ff3a4_29f0_4086_8290_d709aa19cc12:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_766ff3a4_29f0_4086_8290_d709aa19cc12
  __CMP_NO_766ff3a4_29f0_4086_8290_d709aa19cc12:
  SEP	#$20
  LDA	#$00
  __CMP_END_766ff3a4_29f0_4086_8290_d709aa19cc12:
  BEQ	__IFNOT_4f1223b2_baf4_440c_b935_225af7fb2e0e
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
  __IFNOT_4f1223b2_baf4_440c_b935_225af7fb2e0e:
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
  JMP	__ITER__START__2308462b_8844_409d_af8a_9486519ab812
  __ITER__END__2308462b_8844_409d_af8a_9486519ab812:
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
  __ITER__START__d77722db_10ba_4142_a073_464f24049814:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_e5dc6068_5a23_46c8_9140_97ae00b458b5
  BNE	__CMP_YES_e5dc6068_5a23_46c8_9140_97ae00b458b5
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_e5dc6068_5a23_46c8_9140_97ae00b458b5
  BNE	__CMP_YES_e5dc6068_5a23_46c8_9140_97ae00b458b5
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_e5dc6068_5a23_46c8_9140_97ae00b458b5
  BNE	__CMP_YES_e5dc6068_5a23_46c8_9140_97ae00b458b5
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e5dc6068_5a23_46c8_9140_97ae00b458b5
  BNE	__CMP_YES_e5dc6068_5a23_46c8_9140_97ae00b458b5
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e5dc6068_5a23_46c8_9140_97ae00b458b5
  BNE	__CMP_YES_e5dc6068_5a23_46c8_9140_97ae00b458b5
  JMP	__CMP_NO_e5dc6068_5a23_46c8_9140_97ae00b458b5
  __CMP_YES_e5dc6068_5a23_46c8_9140_97ae00b458b5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e5dc6068_5a23_46c8_9140_97ae00b458b5
  __CMP_NO_e5dc6068_5a23_46c8_9140_97ae00b458b5:
  SEP	#$20
  LDA	#$00
  __CMP_END_e5dc6068_5a23_46c8_9140_97ae00b458b5:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d77722db_10ba_4142_a073_464f24049814
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
  BNE	__IFNOT_8557d269_b185_4136_ac59_415032402aeb
  JMP	__ITER__END__d77722db_10ba_4142_a073_464f24049814
  __IFNOT_8557d269_b185_4136_ac59_415032402aeb:
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
  JMP	__ITER__START__d77722db_10ba_4142_a073_464f24049814
  __ITER__END__d77722db_10ba_4142_a073_464f24049814:
  __ITER__START__1d1210c1_40c8_43b6_b99a_27ac7acf4a95:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1d1210c1_40c8_43b6_b99a_27ac7acf4a95
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  BNE	__CMP_YES_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  BNE	__CMP_YES_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  BNE	__CMP_YES_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  BNE	__CMP_YES_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  BNE	__CMP_YES_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  JMP	__CMP_YES_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  __CMP_YES_3114a33d_bb4e_4a8a_bb85_aeb98c21f765:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3114a33d_bb4e_4a8a_bb85_aeb98c21f765
  __CMP_NO_3114a33d_bb4e_4a8a_bb85_aeb98c21f765:
  SEP	#$20
  LDA	#$00
  __CMP_END_3114a33d_bb4e_4a8a_bb85_aeb98c21f765:
  BNE	:+
  JMP	__IFNOT_9ac429bb_8142_44e2_8830_cb4972d654c0
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
  __IFNOT_9ac429bb_8142_44e2_8830_cb4972d654c0:
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
  JMP	__ITER__START__1d1210c1_40c8_43b6_b99a_27ac7acf4a95
  __ITER__END__1d1210c1_40c8_43b6_b99a_27ac7acf4a95:
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
  __ITER__START__b18ecf99_d767_4b66_9efd_4e6ba9363cf6:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_ab4879d0_4aff_46af_a3e5_4077b70f701c
  BNE	__CMP_YES_ab4879d0_4aff_46af_a3e5_4077b70f701c
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ab4879d0_4aff_46af_a3e5_4077b70f701c
  BNE	__CMP_YES_ab4879d0_4aff_46af_a3e5_4077b70f701c
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ab4879d0_4aff_46af_a3e5_4077b70f701c
  BNE	__CMP_YES_ab4879d0_4aff_46af_a3e5_4077b70f701c
  JMP	__CMP_NO_ab4879d0_4aff_46af_a3e5_4077b70f701c
  __CMP_YES_ab4879d0_4aff_46af_a3e5_4077b70f701c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ab4879d0_4aff_46af_a3e5_4077b70f701c
  __CMP_NO_ab4879d0_4aff_46af_a3e5_4077b70f701c:
  SEP	#$20
  LDA	#$00
  __CMP_END_ab4879d0_4aff_46af_a3e5_4077b70f701c:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b18ecf99_d767_4b66_9efd_4e6ba9363cf6
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
  BNE	__IFNOT_b4eff1a6_1869_4591_a210_63828ca593b7
  JMP	__ITER__END__b18ecf99_d767_4b66_9efd_4e6ba9363cf6
  __IFNOT_b4eff1a6_1869_4591_a210_63828ca593b7:
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
  JMP	__ITER__START__b18ecf99_d767_4b66_9efd_4e6ba9363cf6
  __ITER__END__b18ecf99_d767_4b66_9efd_4e6ba9363cf6:
  __ITER__START__1f20991b_6bc3_4e2c_a68c_2fec7a9b1cb4:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1f20991b_6bc3_4e2c_a68c_2fec7a9b1cb4
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a3b78286_6a07_4cf4_afa5_e4d17b22f68d
  BNE	__CMP_YES_a3b78286_6a07_4cf4_afa5_e4d17b22f68d
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a3b78286_6a07_4cf4_afa5_e4d17b22f68d
  BNE	__CMP_YES_a3b78286_6a07_4cf4_afa5_e4d17b22f68d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a3b78286_6a07_4cf4_afa5_e4d17b22f68d
  BNE	__CMP_YES_a3b78286_6a07_4cf4_afa5_e4d17b22f68d
  JMP	__CMP_YES_a3b78286_6a07_4cf4_afa5_e4d17b22f68d
  __CMP_YES_a3b78286_6a07_4cf4_afa5_e4d17b22f68d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a3b78286_6a07_4cf4_afa5_e4d17b22f68d
  __CMP_NO_a3b78286_6a07_4cf4_afa5_e4d17b22f68d:
  SEP	#$20
  LDA	#$00
  __CMP_END_a3b78286_6a07_4cf4_afa5_e4d17b22f68d:
  BEQ	__IFNOT_e4298d35_4223_4837_be04_70f0caa5788b
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
  __IFNOT_e4298d35_4223_4837_be04_70f0caa5788b:
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
  JMP	__ITER__START__1f20991b_6bc3_4e2c_a68c_2fec7a9b1cb4
  __ITER__END__1f20991b_6bc3_4e2c_a68c_2fec7a9b1cb4:
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
  __ITER__START__f6aeee8c_57fa_41b4_aae5_8017c3790ea8:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_1211a56b_4d4a_4f46_a6ed_ba66f96ef441
  BNE	__CMP_YES_1211a56b_4d4a_4f46_a6ed_ba66f96ef441
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1211a56b_4d4a_4f46_a6ed_ba66f96ef441
  BNE	__CMP_YES_1211a56b_4d4a_4f46_a6ed_ba66f96ef441
  JMP	__CMP_NO_1211a56b_4d4a_4f46_a6ed_ba66f96ef441
  __CMP_YES_1211a56b_4d4a_4f46_a6ed_ba66f96ef441:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1211a56b_4d4a_4f46_a6ed_ba66f96ef441
  __CMP_NO_1211a56b_4d4a_4f46_a6ed_ba66f96ef441:
  SEP	#$20
  LDA	#$00
  __CMP_END_1211a56b_4d4a_4f46_a6ed_ba66f96ef441:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f6aeee8c_57fa_41b4_aae5_8017c3790ea8
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
  BNE	__IFNOT_d126f723_bda2_4e4b_94e5_715555da7128
  JMP	__ITER__END__f6aeee8c_57fa_41b4_aae5_8017c3790ea8
  __IFNOT_d126f723_bda2_4e4b_94e5_715555da7128:
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
  JMP	__ITER__START__f6aeee8c_57fa_41b4_aae5_8017c3790ea8
  __ITER__END__f6aeee8c_57fa_41b4_aae5_8017c3790ea8:
  __ITER__START__f47da6e3_9828_4b72_b180_44fe9f258f03:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f47da6e3_9828_4b72_b180_44fe9f258f03
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_4266b7ef_a7b3_4041_a37c_d996a8608367
  BNE	__CMP_YES_4266b7ef_a7b3_4041_a37c_d996a8608367
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4266b7ef_a7b3_4041_a37c_d996a8608367
  BNE	__CMP_YES_4266b7ef_a7b3_4041_a37c_d996a8608367
  JMP	__CMP_YES_4266b7ef_a7b3_4041_a37c_d996a8608367
  __CMP_YES_4266b7ef_a7b3_4041_a37c_d996a8608367:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4266b7ef_a7b3_4041_a37c_d996a8608367
  __CMP_NO_4266b7ef_a7b3_4041_a37c_d996a8608367:
  SEP	#$20
  LDA	#$00
  __CMP_END_4266b7ef_a7b3_4041_a37c_d996a8608367:
  BEQ	__IFNOT_3a34d5b2_51c9_42eb_aa2d_8e2ab1037cd0
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
  __IFNOT_3a34d5b2_51c9_42eb_aa2d_8e2ab1037cd0:
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
  JMP	__ITER__START__f47da6e3_9828_4b72_b180_44fe9f258f03
  __ITER__END__f47da6e3_9828_4b72_b180_44fe9f258f03:
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
  __ITER__START__2cce88ca_8b30_4c9d_a1db_6a4d2adb4a1b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_8f07e03b_f76b_4349_a60c_49b8d6580f96
  BNE	__CMP_YES_8f07e03b_f76b_4349_a60c_49b8d6580f96
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8f07e03b_f76b_4349_a60c_49b8d6580f96
  BNE	__CMP_YES_8f07e03b_f76b_4349_a60c_49b8d6580f96
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8f07e03b_f76b_4349_a60c_49b8d6580f96
  BNE	__CMP_YES_8f07e03b_f76b_4349_a60c_49b8d6580f96
  JMP	__CMP_NO_8f07e03b_f76b_4349_a60c_49b8d6580f96
  __CMP_YES_8f07e03b_f76b_4349_a60c_49b8d6580f96:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8f07e03b_f76b_4349_a60c_49b8d6580f96
  __CMP_NO_8f07e03b_f76b_4349_a60c_49b8d6580f96:
  SEP	#$20
  LDA	#$00
  __CMP_END_8f07e03b_f76b_4349_a60c_49b8d6580f96:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__2cce88ca_8b30_4c9d_a1db_6a4d2adb4a1b
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
  BNE	__IFNOT_144003db_37c6_481c_8318_efa671ee54c0
  JMP	__ITER__END__2cce88ca_8b30_4c9d_a1db_6a4d2adb4a1b
  __IFNOT_144003db_37c6_481c_8318_efa671ee54c0:
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
  JMP	__ITER__START__2cce88ca_8b30_4c9d_a1db_6a4d2adb4a1b
  __ITER__END__2cce88ca_8b30_4c9d_a1db_6a4d2adb4a1b:
  __ITER__START__9b202321_eed6_4b3e_a0f4_75b049061a1b:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9b202321_eed6_4b3e_a0f4_75b049061a1b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_f0e76968_9a00_49c3_a676_4c3fabda1eab
  BNE	__CMP_YES_f0e76968_9a00_49c3_a676_4c3fabda1eab
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f0e76968_9a00_49c3_a676_4c3fabda1eab
  BNE	__CMP_YES_f0e76968_9a00_49c3_a676_4c3fabda1eab
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f0e76968_9a00_49c3_a676_4c3fabda1eab
  BNE	__CMP_YES_f0e76968_9a00_49c3_a676_4c3fabda1eab
  JMP	__CMP_YES_f0e76968_9a00_49c3_a676_4c3fabda1eab
  __CMP_YES_f0e76968_9a00_49c3_a676_4c3fabda1eab:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f0e76968_9a00_49c3_a676_4c3fabda1eab
  __CMP_NO_f0e76968_9a00_49c3_a676_4c3fabda1eab:
  SEP	#$20
  LDA	#$00
  __CMP_END_f0e76968_9a00_49c3_a676_4c3fabda1eab:
  BEQ	__IFNOT_2c229e46_de2e_4349_b549_3185f5f4156e
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
  __IFNOT_2c229e46_de2e_4349_b549_3185f5f4156e:
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
  JMP	__ITER__START__9b202321_eed6_4b3e_a0f4_75b049061a1b
  __ITER__END__9b202321_eed6_4b3e_a0f4_75b049061a1b:
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
  __ITER__START__2ac77730_1823_4faf_972a_98315f4a9925:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_39cb0ff5_f7b3_45d9_9188_5da8b79234a6
  BNE	__CMP_YES_39cb0ff5_f7b3_45d9_9188_5da8b79234a6
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_39cb0ff5_f7b3_45d9_9188_5da8b79234a6
  BNE	__CMP_YES_39cb0ff5_f7b3_45d9_9188_5da8b79234a6
  JMP	__CMP_NO_39cb0ff5_f7b3_45d9_9188_5da8b79234a6
  __CMP_YES_39cb0ff5_f7b3_45d9_9188_5da8b79234a6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_39cb0ff5_f7b3_45d9_9188_5da8b79234a6
  __CMP_NO_39cb0ff5_f7b3_45d9_9188_5da8b79234a6:
  SEP	#$20
  LDA	#$00
  __CMP_END_39cb0ff5_f7b3_45d9_9188_5da8b79234a6:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__2ac77730_1823_4faf_972a_98315f4a9925
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
  BNE	__IFNOT_80526828_a970_46e4_96c7_bee89f8deb6c
  JMP	__ITER__END__2ac77730_1823_4faf_972a_98315f4a9925
  __IFNOT_80526828_a970_46e4_96c7_bee89f8deb6c:
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
  JMP	__ITER__START__2ac77730_1823_4faf_972a_98315f4a9925
  __ITER__END__2ac77730_1823_4faf_972a_98315f4a9925:
  __ITER__START__6feb5b91_6a1a_4298_98d5_e56ead8d4e5b:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6feb5b91_6a1a_4298_98d5_e56ead8d4e5b
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_9e21e611_19ee_4ee8_af03_422f5c938d34
  BNE	__CMP_YES_9e21e611_19ee_4ee8_af03_422f5c938d34
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9e21e611_19ee_4ee8_af03_422f5c938d34
  BNE	__CMP_YES_9e21e611_19ee_4ee8_af03_422f5c938d34
  JMP	__CMP_YES_9e21e611_19ee_4ee8_af03_422f5c938d34
  __CMP_YES_9e21e611_19ee_4ee8_af03_422f5c938d34:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9e21e611_19ee_4ee8_af03_422f5c938d34
  __CMP_NO_9e21e611_19ee_4ee8_af03_422f5c938d34:
  SEP	#$20
  LDA	#$00
  __CMP_END_9e21e611_19ee_4ee8_af03_422f5c938d34:
  BEQ	__IFNOT_71e76dbf_253f_4745_b524_e76e2a31aab3
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
  __IFNOT_71e76dbf_253f_4745_b524_e76e2a31aab3:
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
  JMP	__ITER__START__6feb5b91_6a1a_4298_98d5_e56ead8d4e5b
  __ITER__END__6feb5b91_6a1a_4298_98d5_e56ead8d4e5b:
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
  __ITER__START__cf81a037_4d44_4807_94b6_356de87b5e43:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_7ffa865c_1b2e_439b_8234_7f836df8331e
  BNE	__CMP_YES_7ffa865c_1b2e_439b_8234_7f836df8331e
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_7ffa865c_1b2e_439b_8234_7f836df8331e
  BNE	__CMP_YES_7ffa865c_1b2e_439b_8234_7f836df8331e
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7ffa865c_1b2e_439b_8234_7f836df8331e
  BNE	__CMP_YES_7ffa865c_1b2e_439b_8234_7f836df8331e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7ffa865c_1b2e_439b_8234_7f836df8331e
  BNE	__CMP_YES_7ffa865c_1b2e_439b_8234_7f836df8331e
  JMP	__CMP_NO_7ffa865c_1b2e_439b_8234_7f836df8331e
  __CMP_YES_7ffa865c_1b2e_439b_8234_7f836df8331e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7ffa865c_1b2e_439b_8234_7f836df8331e
  __CMP_NO_7ffa865c_1b2e_439b_8234_7f836df8331e:
  SEP	#$20
  LDA	#$00
  __CMP_END_7ffa865c_1b2e_439b_8234_7f836df8331e:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__cf81a037_4d44_4807_94b6_356de87b5e43
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
  BNE	__IFNOT_7598db20_df2e_4209_a331_7fd4021e1cb6
  JMP	__ITER__END__cf81a037_4d44_4807_94b6_356de87b5e43
  __IFNOT_7598db20_df2e_4209_a331_7fd4021e1cb6:
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
  JMP	__ITER__START__cf81a037_4d44_4807_94b6_356de87b5e43
  __ITER__END__cf81a037_4d44_4807_94b6_356de87b5e43:
  __ITER__START__bd46f56f_4c10_499e_820b_1e4fdf8cbf91:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__bd46f56f_4c10_499e_820b_1e4fdf8cbf91
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_725c89c8_4714_4344_9061_d610673d1e71
  BNE	__CMP_YES_725c89c8_4714_4344_9061_d610673d1e71
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_725c89c8_4714_4344_9061_d610673d1e71
  BNE	__CMP_YES_725c89c8_4714_4344_9061_d610673d1e71
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_725c89c8_4714_4344_9061_d610673d1e71
  BNE	__CMP_YES_725c89c8_4714_4344_9061_d610673d1e71
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_725c89c8_4714_4344_9061_d610673d1e71
  BNE	__CMP_YES_725c89c8_4714_4344_9061_d610673d1e71
  JMP	__CMP_YES_725c89c8_4714_4344_9061_d610673d1e71
  __CMP_YES_725c89c8_4714_4344_9061_d610673d1e71:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_725c89c8_4714_4344_9061_d610673d1e71
  __CMP_NO_725c89c8_4714_4344_9061_d610673d1e71:
  SEP	#$20
  LDA	#$00
  __CMP_END_725c89c8_4714_4344_9061_d610673d1e71:
  BEQ	__IFNOT_ec57f948_4f3e_490a_a349_b4e0b9dbcab7
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
  __IFNOT_ec57f948_4f3e_490a_a349_b4e0b9dbcab7:
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
  JMP	__ITER__START__bd46f56f_4c10_499e_820b_1e4fdf8cbf91
  __ITER__END__bd46f56f_4c10_499e_820b_1e4fdf8cbf91:
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
  __ITER__START__fffd4d45_88a6_4bd4_8c00_90e2534c735a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_9c4c8b69_0cca_4387_98e2_70d5f4132209
  BNE	__CMP_YES_9c4c8b69_0cca_4387_98e2_70d5f4132209
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_9c4c8b69_0cca_4387_98e2_70d5f4132209
  BNE	__CMP_YES_9c4c8b69_0cca_4387_98e2_70d5f4132209
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_9c4c8b69_0cca_4387_98e2_70d5f4132209
  BNE	__CMP_YES_9c4c8b69_0cca_4387_98e2_70d5f4132209
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_9c4c8b69_0cca_4387_98e2_70d5f4132209
  BNE	__CMP_YES_9c4c8b69_0cca_4387_98e2_70d5f4132209
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9c4c8b69_0cca_4387_98e2_70d5f4132209
  BNE	__CMP_YES_9c4c8b69_0cca_4387_98e2_70d5f4132209
  JMP	__CMP_NO_9c4c8b69_0cca_4387_98e2_70d5f4132209
  __CMP_YES_9c4c8b69_0cca_4387_98e2_70d5f4132209:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9c4c8b69_0cca_4387_98e2_70d5f4132209
  __CMP_NO_9c4c8b69_0cca_4387_98e2_70d5f4132209:
  SEP	#$20
  LDA	#$00
  __CMP_END_9c4c8b69_0cca_4387_98e2_70d5f4132209:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__fffd4d45_88a6_4bd4_8c00_90e2534c735a
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
  BNE	__IFNOT_bdfe50a6_7352_4402_9394_e2b6f7a3ff50
  JMP	__ITER__END__fffd4d45_88a6_4bd4_8c00_90e2534c735a
  __IFNOT_bdfe50a6_7352_4402_9394_e2b6f7a3ff50:
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
  JMP	__ITER__START__fffd4d45_88a6_4bd4_8c00_90e2534c735a
  __ITER__END__fffd4d45_88a6_4bd4_8c00_90e2534c735a:
  __ITER__START__a3fb26ee_b96e_4f30_90fc_f810f96051fc:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a3fb26ee_b96e_4f30_90fc_f810f96051fc
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  BNE	__CMP_YES_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  BNE	__CMP_YES_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  BNE	__CMP_YES_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  BNE	__CMP_YES_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  BNE	__CMP_YES_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  JMP	__CMP_YES_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  __CMP_YES_60a6f82c_9a03_41e5_a5ab_a52f17885d08:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_60a6f82c_9a03_41e5_a5ab_a52f17885d08
  __CMP_NO_60a6f82c_9a03_41e5_a5ab_a52f17885d08:
  SEP	#$20
  LDA	#$00
  __CMP_END_60a6f82c_9a03_41e5_a5ab_a52f17885d08:
  BEQ	__IFNOT_0b20f439_c3a5_4643_b3eb_dd144aa87027
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
  __IFNOT_0b20f439_c3a5_4643_b3eb_dd144aa87027:
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
  JMP	__ITER__START__a3fb26ee_b96e_4f30_90fc_f810f96051fc
  __ITER__END__a3fb26ee_b96e_4f30_90fc_f810f96051fc:
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
  __ITER__START__df622301_2727_4c86_b512_757e3bf8647d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  BNE	__CMP_YES_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  BNE	__CMP_YES_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  BNE	__CMP_YES_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  BNE	__CMP_YES_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  JMP	__CMP_NO_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  __CMP_YES_e1f99a46_8408_48dc_b3c6_b70bb962b7aa:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e1f99a46_8408_48dc_b3c6_b70bb962b7aa
  __CMP_NO_e1f99a46_8408_48dc_b3c6_b70bb962b7aa:
  SEP	#$20
  LDA	#$00
  __CMP_END_e1f99a46_8408_48dc_b3c6_b70bb962b7aa:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__df622301_2727_4c86_b512_757e3bf8647d
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
  BNE	__IFNOT_5674089c_4393_4296_9d59_47f5b1ab3a24
  JMP	__ITER__END__df622301_2727_4c86_b512_757e3bf8647d
  __IFNOT_5674089c_4393_4296_9d59_47f5b1ab3a24:
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
  JMP	__ITER__START__df622301_2727_4c86_b512_757e3bf8647d
  __ITER__END__df622301_2727_4c86_b512_757e3bf8647d:
  __ITER__START__45d51ff2_6154_4c40_8dd7_1a9e61226af7:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__45d51ff2_6154_4c40_8dd7_1a9e61226af7
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  BNE	__CMP_YES_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  BNE	__CMP_YES_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  BNE	__CMP_YES_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  BNE	__CMP_YES_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  JMP	__CMP_YES_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  __CMP_YES_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4
  __CMP_NO_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4:
  SEP	#$20
  LDA	#$00
  __CMP_END_6b9c4dcc_2bb6_4700_8b43_6b6aa794e5f4:
  BEQ	__IFNOT_1f3a80d6_d3ad_4483_b600_41f6dfb38e78
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
  __IFNOT_1f3a80d6_d3ad_4483_b600_41f6dfb38e78:
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
  JMP	__ITER__START__45d51ff2_6154_4c40_8dd7_1a9e61226af7
  __ITER__END__45d51ff2_6154_4c40_8dd7_1a9e61226af7:
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
  __ITER__START__5d1be1e0_3373_4679_ac50_d8ba7ccdd680:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  BNE	__CMP_YES_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  BNE	__CMP_YES_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  BNE	__CMP_YES_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  BNE	__CMP_YES_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  BNE	__CMP_YES_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  JMP	__CMP_NO_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  __CMP_YES_ff702342_ec3f_4e9d_b412_2c0f8e48393e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ff702342_ec3f_4e9d_b412_2c0f8e48393e
  __CMP_NO_ff702342_ec3f_4e9d_b412_2c0f8e48393e:
  SEP	#$20
  LDA	#$00
  __CMP_END_ff702342_ec3f_4e9d_b412_2c0f8e48393e:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5d1be1e0_3373_4679_ac50_d8ba7ccdd680
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
  BNE	__IFNOT_1b9586e7_91a8_48b4_9aac_a324e0584992
  JMP	__ITER__END__5d1be1e0_3373_4679_ac50_d8ba7ccdd680
  __IFNOT_1b9586e7_91a8_48b4_9aac_a324e0584992:
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
  JMP	__ITER__START__5d1be1e0_3373_4679_ac50_d8ba7ccdd680
  __ITER__END__5d1be1e0_3373_4679_ac50_d8ba7ccdd680:
  __ITER__START__1a38dc91_db8d_484b_a227_306307a07cad:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1a38dc91_db8d_484b_a227_306307a07cad
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_dd277789_45bc_4e8a_8382_00993e6a0825
  BNE	__CMP_YES_dd277789_45bc_4e8a_8382_00993e6a0825
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_dd277789_45bc_4e8a_8382_00993e6a0825
  BNE	__CMP_YES_dd277789_45bc_4e8a_8382_00993e6a0825
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_dd277789_45bc_4e8a_8382_00993e6a0825
  BNE	__CMP_YES_dd277789_45bc_4e8a_8382_00993e6a0825
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_dd277789_45bc_4e8a_8382_00993e6a0825
  BNE	__CMP_YES_dd277789_45bc_4e8a_8382_00993e6a0825
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_dd277789_45bc_4e8a_8382_00993e6a0825
  BNE	__CMP_YES_dd277789_45bc_4e8a_8382_00993e6a0825
  JMP	__CMP_YES_dd277789_45bc_4e8a_8382_00993e6a0825
  __CMP_YES_dd277789_45bc_4e8a_8382_00993e6a0825:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_dd277789_45bc_4e8a_8382_00993e6a0825
  __CMP_NO_dd277789_45bc_4e8a_8382_00993e6a0825:
  SEP	#$20
  LDA	#$00
  __CMP_END_dd277789_45bc_4e8a_8382_00993e6a0825:
  BEQ	__IFNOT_40435de8_7881_4d82_acc5_23363154d3df
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
  __IFNOT_40435de8_7881_4d82_acc5_23363154d3df:
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
  JMP	__ITER__START__1a38dc91_db8d_484b_a227_306307a07cad
  __ITER__END__1a38dc91_db8d_484b_a227_306307a07cad:
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
  __ITER__START__9f5b371b_5c91_4ce8_8958_29ee6b1f145e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_2194bcbb_da7f_4894_8215_13f07858050a
  BNE	__CMP_YES_2194bcbb_da7f_4894_8215_13f07858050a
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_2194bcbb_da7f_4894_8215_13f07858050a
  BNE	__CMP_YES_2194bcbb_da7f_4894_8215_13f07858050a
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_2194bcbb_da7f_4894_8215_13f07858050a
  BNE	__CMP_YES_2194bcbb_da7f_4894_8215_13f07858050a
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2194bcbb_da7f_4894_8215_13f07858050a
  BNE	__CMP_YES_2194bcbb_da7f_4894_8215_13f07858050a
  JMP	__CMP_NO_2194bcbb_da7f_4894_8215_13f07858050a
  __CMP_YES_2194bcbb_da7f_4894_8215_13f07858050a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2194bcbb_da7f_4894_8215_13f07858050a
  __CMP_NO_2194bcbb_da7f_4894_8215_13f07858050a:
  SEP	#$20
  LDA	#$00
  __CMP_END_2194bcbb_da7f_4894_8215_13f07858050a:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9f5b371b_5c91_4ce8_8958_29ee6b1f145e
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
  BNE	__IFNOT_7ff88d6a_73b2_437a_8d03_79b6bf194c6a
  JMP	__ITER__END__9f5b371b_5c91_4ce8_8958_29ee6b1f145e
  __IFNOT_7ff88d6a_73b2_437a_8d03_79b6bf194c6a:
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
  JMP	__ITER__START__9f5b371b_5c91_4ce8_8958_29ee6b1f145e
  __ITER__END__9f5b371b_5c91_4ce8_8958_29ee6b1f145e:
  __ITER__START__7f165aaf_a475_48a3_9cd6_78f2f210394c:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7f165aaf_a475_48a3_9cd6_78f2f210394c
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  BNE	__CMP_YES_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  BNE	__CMP_YES_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  BNE	__CMP_YES_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  BNE	__CMP_YES_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  JMP	__CMP_YES_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  __CMP_YES_e6567ae5_404f_4c89_aecd_28639ba9d5bc:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e6567ae5_404f_4c89_aecd_28639ba9d5bc
  __CMP_NO_e6567ae5_404f_4c89_aecd_28639ba9d5bc:
  SEP	#$20
  LDA	#$00
  __CMP_END_e6567ae5_404f_4c89_aecd_28639ba9d5bc:
  BEQ	__IFNOT_7d355a7d_25bd_4645_8d87_bd446da834bc
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
  __IFNOT_7d355a7d_25bd_4645_8d87_bd446da834bc:
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
  JMP	__ITER__START__7f165aaf_a475_48a3_9cd6_78f2f210394c
  __ITER__END__7f165aaf_a475_48a3_9cd6_78f2f210394c:
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
  __ITER__START__4351a6e3_0d30_4a22_a850_140429d7469d:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  BNE	__CMP_YES_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  BNE	__CMP_YES_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  BNE	__CMP_YES_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  BNE	__CMP_YES_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  JMP	__CMP_NO_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  __CMP_YES_ec3f68a0_7a09_4ad8_9580_dd9ed847b715:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ec3f68a0_7a09_4ad8_9580_dd9ed847b715
  __CMP_NO_ec3f68a0_7a09_4ad8_9580_dd9ed847b715:
  SEP	#$20
  LDA	#$00
  __CMP_END_ec3f68a0_7a09_4ad8_9580_dd9ed847b715:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4351a6e3_0d30_4a22_a850_140429d7469d
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
  BNE	__IFNOT_73351d8b_0a21_413b_a74e_75a226ea0530
  JMP	__ITER__END__4351a6e3_0d30_4a22_a850_140429d7469d
  __IFNOT_73351d8b_0a21_413b_a74e_75a226ea0530:
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
  JMP	__ITER__START__4351a6e3_0d30_4a22_a850_140429d7469d
  __ITER__END__4351a6e3_0d30_4a22_a850_140429d7469d:
  __ITER__START__ff9ca68d_7961_4ff7_bafa_52f9cf2cfcf6:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__ff9ca68d_7961_4ff7_bafa_52f9cf2cfcf6
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  BNE	__CMP_YES_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  BNE	__CMP_YES_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  BNE	__CMP_YES_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  BNE	__CMP_YES_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  JMP	__CMP_YES_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  __CMP_YES_da95a7e4_bbd5_449b_802a_460c20c2a9c3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_da95a7e4_bbd5_449b_802a_460c20c2a9c3
  __CMP_NO_da95a7e4_bbd5_449b_802a_460c20c2a9c3:
  SEP	#$20
  LDA	#$00
  __CMP_END_da95a7e4_bbd5_449b_802a_460c20c2a9c3:
  BNE	:+
  JMP	__IFNOT_df846ebb_991c_4056_b650_cdb65846d435
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
  __IFNOT_df846ebb_991c_4056_b650_cdb65846d435:
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
  JMP	__ITER__START__ff9ca68d_7961_4ff7_bafa_52f9cf2cfcf6
  __ITER__END__ff9ca68d_7961_4ff7_bafa_52f9cf2cfcf6:
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
  __ITER__START__4a8e7a25_d1f7_4d0a_9013_505a895c128f:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7
  BNE	__CMP_YES_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7
  BNE	__CMP_YES_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7
  JMP	__CMP_NO_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7
  __CMP_YES_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7
  __CMP_NO_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7:
  SEP	#$20
  LDA	#$00
  __CMP_END_840b7fa9_c2bd_4766_8ccb_8e58c0aec4b7:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4a8e7a25_d1f7_4d0a_9013_505a895c128f
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
  BNE	__IFNOT_e4ee3c08_9e06_4e34_93fa_e109a60c4905
  JMP	__ITER__END__4a8e7a25_d1f7_4d0a_9013_505a895c128f
  __IFNOT_e4ee3c08_9e06_4e34_93fa_e109a60c4905:
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
  JMP	__ITER__START__4a8e7a25_d1f7_4d0a_9013_505a895c128f
  __ITER__END__4a8e7a25_d1f7_4d0a_9013_505a895c128f:
  __ITER__START__1f8bbdc5_57e3_4f36_89d3_ad52bb4b238d:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1f8bbdc5_57e3_4f36_89d3_ad52bb4b238d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_154214b9_6e98_4398_9db5_b4c07686f9bf
  BNE	__CMP_YES_154214b9_6e98_4398_9db5_b4c07686f9bf
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_154214b9_6e98_4398_9db5_b4c07686f9bf
  BNE	__CMP_YES_154214b9_6e98_4398_9db5_b4c07686f9bf
  JMP	__CMP_YES_154214b9_6e98_4398_9db5_b4c07686f9bf
  __CMP_YES_154214b9_6e98_4398_9db5_b4c07686f9bf:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_154214b9_6e98_4398_9db5_b4c07686f9bf
  __CMP_NO_154214b9_6e98_4398_9db5_b4c07686f9bf:
  SEP	#$20
  LDA	#$00
  __CMP_END_154214b9_6e98_4398_9db5_b4c07686f9bf:
  BEQ	__IFNOT_0e3d7f05_5889_40e8_b93c_b0ff8c3b59bb
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
  __IFNOT_0e3d7f05_5889_40e8_b93c_b0ff8c3b59bb:
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
  JMP	__ITER__START__1f8bbdc5_57e3_4f36_89d3_ad52bb4b238d
  __ITER__END__1f8bbdc5_57e3_4f36_89d3_ad52bb4b238d:
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
  __ITER__START__b231be38_ccd0_4d3b_bc3e_1c2cb8148eec:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3f1d7e5a_3689_45c7_aeca_035ddb11e77a
  BNE	__CMP_YES_3f1d7e5a_3689_45c7_aeca_035ddb11e77a
  JMP	__CMP_NO_3f1d7e5a_3689_45c7_aeca_035ddb11e77a
  __CMP_YES_3f1d7e5a_3689_45c7_aeca_035ddb11e77a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3f1d7e5a_3689_45c7_aeca_035ddb11e77a
  __CMP_NO_3f1d7e5a_3689_45c7_aeca_035ddb11e77a:
  SEP	#$20
  LDA	#$00
  __CMP_END_3f1d7e5a_3689_45c7_aeca_035ddb11e77a:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b231be38_ccd0_4d3b_bc3e_1c2cb8148eec
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
  BNE	__IFNOT_8e10bd36_01b7_481e_9005_3f5b27e600b8
  JMP	__ITER__END__b231be38_ccd0_4d3b_bc3e_1c2cb8148eec
  __IFNOT_8e10bd36_01b7_481e_9005_3f5b27e600b8:
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
  JMP	__ITER__START__b231be38_ccd0_4d3b_bc3e_1c2cb8148eec
  __ITER__END__b231be38_ccd0_4d3b_bc3e_1c2cb8148eec:
  __ITER__START__fd00a334_2a9c_43a8_9965_a53533a00a62:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__fd00a334_2a9c_43a8_9965_a53533a00a62
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6973e2ea_842f_4dd4_a5a1_7639b5d3f810
  BNE	__CMP_YES_6973e2ea_842f_4dd4_a5a1_7639b5d3f810
  JMP	__CMP_YES_6973e2ea_842f_4dd4_a5a1_7639b5d3f810
  __CMP_YES_6973e2ea_842f_4dd4_a5a1_7639b5d3f810:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6973e2ea_842f_4dd4_a5a1_7639b5d3f810
  __CMP_NO_6973e2ea_842f_4dd4_a5a1_7639b5d3f810:
  SEP	#$20
  LDA	#$00
  __CMP_END_6973e2ea_842f_4dd4_a5a1_7639b5d3f810:
  BEQ	__IFNOT_1597e655_5b87_4a4d_9a7c_b312bde2bafe
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
  __IFNOT_1597e655_5b87_4a4d_9a7c_b312bde2bafe:
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
  JMP	__ITER__START__fd00a334_2a9c_43a8_9965_a53533a00a62
  __ITER__END__fd00a334_2a9c_43a8_9965_a53533a00a62:
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
  __ITER__START__1437dc2a_98c8_4bd2_a87c_74ad02601f3f:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_b62cc557_7bdf_4623_a8e4_275b4f9158d8
  BNE	__CMP_YES_b62cc557_7bdf_4623_a8e4_275b4f9158d8
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b62cc557_7bdf_4623_a8e4_275b4f9158d8
  BNE	__CMP_YES_b62cc557_7bdf_4623_a8e4_275b4f9158d8
  JMP	__CMP_NO_b62cc557_7bdf_4623_a8e4_275b4f9158d8
  __CMP_YES_b62cc557_7bdf_4623_a8e4_275b4f9158d8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b62cc557_7bdf_4623_a8e4_275b4f9158d8
  __CMP_NO_b62cc557_7bdf_4623_a8e4_275b4f9158d8:
  SEP	#$20
  LDA	#$00
  __CMP_END_b62cc557_7bdf_4623_a8e4_275b4f9158d8:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1437dc2a_98c8_4bd2_a87c_74ad02601f3f
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
  BNE	__IFNOT_a9e32e2d_e756_4ff1_9548_663989b52090
  JMP	__ITER__END__1437dc2a_98c8_4bd2_a87c_74ad02601f3f
  __IFNOT_a9e32e2d_e756_4ff1_9548_663989b52090:
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
  JMP	__ITER__START__1437dc2a_98c8_4bd2_a87c_74ad02601f3f
  __ITER__END__1437dc2a_98c8_4bd2_a87c_74ad02601f3f:
  __ITER__START__15636f8d_af27_4c4a_a188_65410f355ef5:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__15636f8d_af27_4c4a_a188_65410f355ef5
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_15f265b5_f57d_41c0_9050_23f8a057c86b
  BNE	__CMP_YES_15f265b5_f57d_41c0_9050_23f8a057c86b
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_15f265b5_f57d_41c0_9050_23f8a057c86b
  BNE	__CMP_YES_15f265b5_f57d_41c0_9050_23f8a057c86b
  JMP	__CMP_YES_15f265b5_f57d_41c0_9050_23f8a057c86b
  __CMP_YES_15f265b5_f57d_41c0_9050_23f8a057c86b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_15f265b5_f57d_41c0_9050_23f8a057c86b
  __CMP_NO_15f265b5_f57d_41c0_9050_23f8a057c86b:
  SEP	#$20
  LDA	#$00
  __CMP_END_15f265b5_f57d_41c0_9050_23f8a057c86b:
  BEQ	__IFNOT_7fc556eb_09a0_4505_9011_ed856a748d16
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
  __IFNOT_7fc556eb_09a0_4505_9011_ed856a748d16:
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
  JMP	__ITER__START__15636f8d_af27_4c4a_a188_65410f355ef5
  __ITER__END__15636f8d_af27_4c4a_a188_65410f355ef5:
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
  __ITER__START__5fbca29c_013c_440c_af14_a81d2dcb67e6:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e
  BNE	__CMP_YES_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e
  BNE	__CMP_YES_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e
  JMP	__CMP_NO_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e
  __CMP_YES_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e
  __CMP_NO_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e:
  SEP	#$20
  LDA	#$00
  __CMP_END_6d3256a0_1eb2_4bd1_8806_2bcef2579e3e:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5fbca29c_013c_440c_af14_a81d2dcb67e6
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
  BNE	__IFNOT_56a5e34c_470d_4c77_8f91_5f0bcf471bd7
  JMP	__ITER__END__5fbca29c_013c_440c_af14_a81d2dcb67e6
  __IFNOT_56a5e34c_470d_4c77_8f91_5f0bcf471bd7:
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
  JMP	__ITER__START__5fbca29c_013c_440c_af14_a81d2dcb67e6
  __ITER__END__5fbca29c_013c_440c_af14_a81d2dcb67e6:
  __ITER__START__d21b19d7_bd11_4138_8f6a_4db52e56143c:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d21b19d7_bd11_4138_8f6a_4db52e56143c
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_92423324_c422_4a58_84c0_f3c8c6342efd
  BNE	__CMP_YES_92423324_c422_4a58_84c0_f3c8c6342efd
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_92423324_c422_4a58_84c0_f3c8c6342efd
  BNE	__CMP_YES_92423324_c422_4a58_84c0_f3c8c6342efd
  JMP	__CMP_YES_92423324_c422_4a58_84c0_f3c8c6342efd
  __CMP_YES_92423324_c422_4a58_84c0_f3c8c6342efd:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_92423324_c422_4a58_84c0_f3c8c6342efd
  __CMP_NO_92423324_c422_4a58_84c0_f3c8c6342efd:
  SEP	#$20
  LDA	#$00
  __CMP_END_92423324_c422_4a58_84c0_f3c8c6342efd:
  BEQ	__IFNOT_03e7a3c0_7324_4d8f_a8da_3092b3746964
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
  __IFNOT_03e7a3c0_7324_4d8f_a8da_3092b3746964:
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
  JMP	__ITER__START__d21b19d7_bd11_4138_8f6a_4db52e56143c
  __ITER__END__d21b19d7_bd11_4138_8f6a_4db52e56143c:
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
  __ITER__START__a8439bbb_3e48_4b87_814a_28dac3261741:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_34bfd81e_71d9_4285_9124_da147e6d3b62
  BNE	__CMP_YES_34bfd81e_71d9_4285_9124_da147e6d3b62
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_34bfd81e_71d9_4285_9124_da147e6d3b62
  BNE	__CMP_YES_34bfd81e_71d9_4285_9124_da147e6d3b62
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_34bfd81e_71d9_4285_9124_da147e6d3b62
  BNE	__CMP_YES_34bfd81e_71d9_4285_9124_da147e6d3b62
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_34bfd81e_71d9_4285_9124_da147e6d3b62
  BNE	__CMP_YES_34bfd81e_71d9_4285_9124_da147e6d3b62
  JMP	__CMP_NO_34bfd81e_71d9_4285_9124_da147e6d3b62
  __CMP_YES_34bfd81e_71d9_4285_9124_da147e6d3b62:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_34bfd81e_71d9_4285_9124_da147e6d3b62
  __CMP_NO_34bfd81e_71d9_4285_9124_da147e6d3b62:
  SEP	#$20
  LDA	#$00
  __CMP_END_34bfd81e_71d9_4285_9124_da147e6d3b62:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a8439bbb_3e48_4b87_814a_28dac3261741
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
  BNE	__IFNOT_fe8f6fa1_e690_42fb_8c16_8ecebfa188bc
  JMP	__ITER__END__a8439bbb_3e48_4b87_814a_28dac3261741
  __IFNOT_fe8f6fa1_e690_42fb_8c16_8ecebfa188bc:
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
  JMP	__ITER__START__a8439bbb_3e48_4b87_814a_28dac3261741
  __ITER__END__a8439bbb_3e48_4b87_814a_28dac3261741:
  __ITER__START__365cf0b6_5aa5_452e_ba38_b4d8449537d7:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__365cf0b6_5aa5_452e_ba38_b4d8449537d7
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  BNE	__CMP_YES_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  BNE	__CMP_YES_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  BNE	__CMP_YES_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  BNE	__CMP_YES_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  JMP	__CMP_YES_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  __CMP_YES_1ede72a1_589a_4a25_96b0_a637f0cf18c8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1ede72a1_589a_4a25_96b0_a637f0cf18c8
  __CMP_NO_1ede72a1_589a_4a25_96b0_a637f0cf18c8:
  SEP	#$20
  LDA	#$00
  __CMP_END_1ede72a1_589a_4a25_96b0_a637f0cf18c8:
  BEQ	__IFNOT_ce8bc8bc_c905_4793_9010_a25a3677ebf9
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
  __IFNOT_ce8bc8bc_c905_4793_9010_a25a3677ebf9:
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
  JMP	__ITER__START__365cf0b6_5aa5_452e_ba38_b4d8449537d7
  __ITER__END__365cf0b6_5aa5_452e_ba38_b4d8449537d7:
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
  __ITER__START__5177141e_6f46_4087_9534_0c373fdd8e21:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2cbb0aef_2976_4335_8ed5_3b340636610e
  BNE	__CMP_YES_2cbb0aef_2976_4335_8ed5_3b340636610e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2cbb0aef_2976_4335_8ed5_3b340636610e
  BNE	__CMP_YES_2cbb0aef_2976_4335_8ed5_3b340636610e
  JMP	__CMP_NO_2cbb0aef_2976_4335_8ed5_3b340636610e
  __CMP_YES_2cbb0aef_2976_4335_8ed5_3b340636610e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2cbb0aef_2976_4335_8ed5_3b340636610e
  __CMP_NO_2cbb0aef_2976_4335_8ed5_3b340636610e:
  SEP	#$20
  LDA	#$00
  __CMP_END_2cbb0aef_2976_4335_8ed5_3b340636610e:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5177141e_6f46_4087_9534_0c373fdd8e21
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
  BNE	__IFNOT_9ead7c02_6993_457d_b375_75446daa7780
  JMP	__ITER__END__5177141e_6f46_4087_9534_0c373fdd8e21
  __IFNOT_9ead7c02_6993_457d_b375_75446daa7780:
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
  JMP	__ITER__START__5177141e_6f46_4087_9534_0c373fdd8e21
  __ITER__END__5177141e_6f46_4087_9534_0c373fdd8e21:
  __ITER__START__9c0e5c33_3b1e_4add_b268_50ee139e17f8:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9c0e5c33_3b1e_4add_b268_50ee139e17f8
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c0c2a7ae_787c_4e59_9e65_fc488aea3760
  BNE	__CMP_YES_c0c2a7ae_787c_4e59_9e65_fc488aea3760
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c0c2a7ae_787c_4e59_9e65_fc488aea3760
  BNE	__CMP_YES_c0c2a7ae_787c_4e59_9e65_fc488aea3760
  JMP	__CMP_YES_c0c2a7ae_787c_4e59_9e65_fc488aea3760
  __CMP_YES_c0c2a7ae_787c_4e59_9e65_fc488aea3760:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c0c2a7ae_787c_4e59_9e65_fc488aea3760
  __CMP_NO_c0c2a7ae_787c_4e59_9e65_fc488aea3760:
  SEP	#$20
  LDA	#$00
  __CMP_END_c0c2a7ae_787c_4e59_9e65_fc488aea3760:
  BEQ	__IFNOT_7eb5b95e_c449_4e93_afd2_60bd2de1fc86
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
  __IFNOT_7eb5b95e_c449_4e93_afd2_60bd2de1fc86:
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
  JMP	__ITER__START__9c0e5c33_3b1e_4add_b268_50ee139e17f8
  __ITER__END__9c0e5c33_3b1e_4add_b268_50ee139e17f8:
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
  __ITER__START__0e4b38ae_279d_4db9_92cf_99ae4e536245:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e
  BNE	__CMP_YES_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e
  BNE	__CMP_YES_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e
  JMP	__CMP_NO_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e
  __CMP_YES_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e
  __CMP_NO_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e:
  SEP	#$20
  LDA	#$00
  __CMP_END_aa4ebbfa_28da_4a70_9ff5_3a6966991c7e:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__0e4b38ae_279d_4db9_92cf_99ae4e536245
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
  BNE	__IFNOT_547538e5_928c_4821_a229_23322d02d6ea
  JMP	__ITER__END__0e4b38ae_279d_4db9_92cf_99ae4e536245
  __IFNOT_547538e5_928c_4821_a229_23322d02d6ea:
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
  JMP	__ITER__START__0e4b38ae_279d_4db9_92cf_99ae4e536245
  __ITER__END__0e4b38ae_279d_4db9_92cf_99ae4e536245:
  __ITER__START__2321e019_2f8b_479c_9565_577c594d0048:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__2321e019_2f8b_479c_9565_577c594d0048
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_0ccaf890_ceae_4b53_8298_e70c4b462617
  BNE	__CMP_YES_0ccaf890_ceae_4b53_8298_e70c4b462617
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0ccaf890_ceae_4b53_8298_e70c4b462617
  BNE	__CMP_YES_0ccaf890_ceae_4b53_8298_e70c4b462617
  JMP	__CMP_YES_0ccaf890_ceae_4b53_8298_e70c4b462617
  __CMP_YES_0ccaf890_ceae_4b53_8298_e70c4b462617:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0ccaf890_ceae_4b53_8298_e70c4b462617
  __CMP_NO_0ccaf890_ceae_4b53_8298_e70c4b462617:
  SEP	#$20
  LDA	#$00
  __CMP_END_0ccaf890_ceae_4b53_8298_e70c4b462617:
  BEQ	__IFNOT_2d480583_6a56_42b5_8463_743a880e4604
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
  __IFNOT_2d480583_6a56_42b5_8463_743a880e4604:
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
  JMP	__ITER__START__2321e019_2f8b_479c_9565_577c594d0048
  __ITER__END__2321e019_2f8b_479c_9565_577c594d0048:
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
  __ITER__START__cf5f305b_531c_47c9_8308_87c008e06ddd:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_78718867_c8ef_4c92_9b37_5a39b51664ac
  BNE	__CMP_YES_78718867_c8ef_4c92_9b37_5a39b51664ac
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_78718867_c8ef_4c92_9b37_5a39b51664ac
  BNE	__CMP_YES_78718867_c8ef_4c92_9b37_5a39b51664ac
  JMP	__CMP_NO_78718867_c8ef_4c92_9b37_5a39b51664ac
  __CMP_YES_78718867_c8ef_4c92_9b37_5a39b51664ac:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_78718867_c8ef_4c92_9b37_5a39b51664ac
  __CMP_NO_78718867_c8ef_4c92_9b37_5a39b51664ac:
  SEP	#$20
  LDA	#$00
  __CMP_END_78718867_c8ef_4c92_9b37_5a39b51664ac:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__cf5f305b_531c_47c9_8308_87c008e06ddd
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
  BNE	__IFNOT_b2476dbc_0d1b_487d_8809_04998dc98309
  JMP	__ITER__END__cf5f305b_531c_47c9_8308_87c008e06ddd
  __IFNOT_b2476dbc_0d1b_487d_8809_04998dc98309:
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
  JMP	__ITER__START__cf5f305b_531c_47c9_8308_87c008e06ddd
  __ITER__END__cf5f305b_531c_47c9_8308_87c008e06ddd:
  __ITER__START__cb9d30a3_63c2_4345_9f26_58d9141f513d:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__cb9d30a3_63c2_4345_9f26_58d9141f513d
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_89058a79_6272_4a55_81cd_5487e08ae102
  BNE	__CMP_YES_89058a79_6272_4a55_81cd_5487e08ae102
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_89058a79_6272_4a55_81cd_5487e08ae102
  BNE	__CMP_YES_89058a79_6272_4a55_81cd_5487e08ae102
  JMP	__CMP_YES_89058a79_6272_4a55_81cd_5487e08ae102
  __CMP_YES_89058a79_6272_4a55_81cd_5487e08ae102:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_89058a79_6272_4a55_81cd_5487e08ae102
  __CMP_NO_89058a79_6272_4a55_81cd_5487e08ae102:
  SEP	#$20
  LDA	#$00
  __CMP_END_89058a79_6272_4a55_81cd_5487e08ae102:
  BEQ	__IFNOT_2c350f8b_2faf_471a_a059_328f289b3c9b
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
  __IFNOT_2c350f8b_2faf_471a_a059_328f289b3c9b:
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
  JMP	__ITER__START__cb9d30a3_63c2_4345_9f26_58d9141f513d
  __ITER__END__cb9d30a3_63c2_4345_9f26_58d9141f513d:
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
  __ITER__START__31a02413_27cd_43c8_90bb_c75bdf1e205c:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_a962d121_51a7_4c70_aee3_16e7042ea122
  BNE	__CMP_YES_a962d121_51a7_4c70_aee3_16e7042ea122
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a962d121_51a7_4c70_aee3_16e7042ea122
  BNE	__CMP_YES_a962d121_51a7_4c70_aee3_16e7042ea122
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a962d121_51a7_4c70_aee3_16e7042ea122
  BNE	__CMP_YES_a962d121_51a7_4c70_aee3_16e7042ea122
  JMP	__CMP_NO_a962d121_51a7_4c70_aee3_16e7042ea122
  __CMP_YES_a962d121_51a7_4c70_aee3_16e7042ea122:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a962d121_51a7_4c70_aee3_16e7042ea122
  __CMP_NO_a962d121_51a7_4c70_aee3_16e7042ea122:
  SEP	#$20
  LDA	#$00
  __CMP_END_a962d121_51a7_4c70_aee3_16e7042ea122:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__31a02413_27cd_43c8_90bb_c75bdf1e205c
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
  BNE	__IFNOT_5930e88d_b153_45ca_8684_df296c603815
  JMP	__ITER__END__31a02413_27cd_43c8_90bb_c75bdf1e205c
  __IFNOT_5930e88d_b153_45ca_8684_df296c603815:
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
  JMP	__ITER__START__31a02413_27cd_43c8_90bb_c75bdf1e205c
  __ITER__END__31a02413_27cd_43c8_90bb_c75bdf1e205c:
  __ITER__START__cfc69dd6_134d_4cf0_9937_9ded26f18602:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__cfc69dd6_134d_4cf0_9937_9ded26f18602
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_c78ac93e_d698_4fde_829d_9acc8be6810e
  BNE	__CMP_YES_c78ac93e_d698_4fde_829d_9acc8be6810e
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c78ac93e_d698_4fde_829d_9acc8be6810e
  BNE	__CMP_YES_c78ac93e_d698_4fde_829d_9acc8be6810e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c78ac93e_d698_4fde_829d_9acc8be6810e
  BNE	__CMP_YES_c78ac93e_d698_4fde_829d_9acc8be6810e
  JMP	__CMP_YES_c78ac93e_d698_4fde_829d_9acc8be6810e
  __CMP_YES_c78ac93e_d698_4fde_829d_9acc8be6810e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c78ac93e_d698_4fde_829d_9acc8be6810e
  __CMP_NO_c78ac93e_d698_4fde_829d_9acc8be6810e:
  SEP	#$20
  LDA	#$00
  __CMP_END_c78ac93e_d698_4fde_829d_9acc8be6810e:
  BEQ	__IFNOT_28c07bbe_46c3_4647_a793_424d2c321b39
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
  __IFNOT_28c07bbe_46c3_4647_a793_424d2c321b39:
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
  JMP	__ITER__START__cfc69dd6_134d_4cf0_9937_9ded26f18602
  __ITER__END__cfc69dd6_134d_4cf0_9937_9ded26f18602:
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
  __ITER__START__07a4be55_48da_4b92_895f_1284f2199483:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  BNE	__CMP_YES_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  BNE	__CMP_YES_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  BNE	__CMP_YES_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  BNE	__CMP_YES_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  BNE	__CMP_YES_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  JMP	__CMP_NO_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  __CMP_YES_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8
  __CMP_NO_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8:
  SEP	#$20
  LDA	#$00
  __CMP_END_d1a46d3c_2b51_4cff_8e69_c06d92b4abf8:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__07a4be55_48da_4b92_895f_1284f2199483
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
  BNE	__IFNOT_649f2e27_41d7_46e2_b689_1e882aa2df3e
  JMP	__ITER__END__07a4be55_48da_4b92_895f_1284f2199483
  __IFNOT_649f2e27_41d7_46e2_b689_1e882aa2df3e:
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
  JMP	__ITER__START__07a4be55_48da_4b92_895f_1284f2199483
  __ITER__END__07a4be55_48da_4b92_895f_1284f2199483:
  __ITER__START__58b56c44_602a_4163_8c42_79c52a212261:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__58b56c44_602a_4163_8c42_79c52a212261
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_48415afd_f622_4bff_b8f8_a7c4f09d0908
  BNE	__CMP_YES_48415afd_f622_4bff_b8f8_a7c4f09d0908
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_48415afd_f622_4bff_b8f8_a7c4f09d0908
  BNE	__CMP_YES_48415afd_f622_4bff_b8f8_a7c4f09d0908
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_48415afd_f622_4bff_b8f8_a7c4f09d0908
  BNE	__CMP_YES_48415afd_f622_4bff_b8f8_a7c4f09d0908
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_48415afd_f622_4bff_b8f8_a7c4f09d0908
  BNE	__CMP_YES_48415afd_f622_4bff_b8f8_a7c4f09d0908
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_48415afd_f622_4bff_b8f8_a7c4f09d0908
  BNE	__CMP_YES_48415afd_f622_4bff_b8f8_a7c4f09d0908
  JMP	__CMP_YES_48415afd_f622_4bff_b8f8_a7c4f09d0908
  __CMP_YES_48415afd_f622_4bff_b8f8_a7c4f09d0908:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_48415afd_f622_4bff_b8f8_a7c4f09d0908
  __CMP_NO_48415afd_f622_4bff_b8f8_a7c4f09d0908:
  SEP	#$20
  LDA	#$00
  __CMP_END_48415afd_f622_4bff_b8f8_a7c4f09d0908:
  BNE	:+
  JMP	__IFNOT_8f0de944_f6b8_425c_9345_35b605789794
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
  __IFNOT_8f0de944_f6b8_425c_9345_35b605789794:
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
  JMP	__ITER__START__58b56c44_602a_4163_8c42_79c52a212261
  __ITER__END__58b56c44_602a_4163_8c42_79c52a212261:
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
  __ITER__START__9865542f_ed91_4d37_9b77_4d2445490957:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398
  BNE	__CMP_YES_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398
  BNE	__CMP_YES_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398
  BNE	__CMP_YES_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398
  JMP	__CMP_NO_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398
  __CMP_YES_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398
  __CMP_NO_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398:
  SEP	#$20
  LDA	#$00
  __CMP_END_ec84e7bc_4ff7_4019_80a1_cf61c4e1e398:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9865542f_ed91_4d37_9b77_4d2445490957
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
  BNE	__IFNOT_b3f546d8_e978_4aba_904e_4d4cbe31a695
  JMP	__ITER__END__9865542f_ed91_4d37_9b77_4d2445490957
  __IFNOT_b3f546d8_e978_4aba_904e_4d4cbe31a695:
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
  JMP	__ITER__START__9865542f_ed91_4d37_9b77_4d2445490957
  __ITER__END__9865542f_ed91_4d37_9b77_4d2445490957:
  __ITER__START__b298b4a4_d5d7_466a_920d_22c7c45cdaa9:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b298b4a4_d5d7_466a_920d_22c7c45cdaa9
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a465ed08_1133_43a7_8461_b2863df33e9e
  BNE	__CMP_YES_a465ed08_1133_43a7_8461_b2863df33e9e
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a465ed08_1133_43a7_8461_b2863df33e9e
  BNE	__CMP_YES_a465ed08_1133_43a7_8461_b2863df33e9e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a465ed08_1133_43a7_8461_b2863df33e9e
  BNE	__CMP_YES_a465ed08_1133_43a7_8461_b2863df33e9e
  JMP	__CMP_YES_a465ed08_1133_43a7_8461_b2863df33e9e
  __CMP_YES_a465ed08_1133_43a7_8461_b2863df33e9e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a465ed08_1133_43a7_8461_b2863df33e9e
  __CMP_NO_a465ed08_1133_43a7_8461_b2863df33e9e:
  SEP	#$20
  LDA	#$00
  __CMP_END_a465ed08_1133_43a7_8461_b2863df33e9e:
  BEQ	__IFNOT_62dec033_9bf3_4fa3_8ed7_2c06c9f00136
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
  __IFNOT_62dec033_9bf3_4fa3_8ed7_2c06c9f00136:
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
  JMP	__ITER__START__b298b4a4_d5d7_466a_920d_22c7c45cdaa9
  __ITER__END__b298b4a4_d5d7_466a_920d_22c7c45cdaa9:
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
  __ITER__START__1fd8cfbd_785e_481c_a0bc_a06db1bd31b9:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_37962f23_4c1a_455a_b272_5824b8f18346
  BNE	__CMP_YES_37962f23_4c1a_455a_b272_5824b8f18346
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_37962f23_4c1a_455a_b272_5824b8f18346
  BNE	__CMP_YES_37962f23_4c1a_455a_b272_5824b8f18346
  JMP	__CMP_NO_37962f23_4c1a_455a_b272_5824b8f18346
  __CMP_YES_37962f23_4c1a_455a_b272_5824b8f18346:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_37962f23_4c1a_455a_b272_5824b8f18346
  __CMP_NO_37962f23_4c1a_455a_b272_5824b8f18346:
  SEP	#$20
  LDA	#$00
  __CMP_END_37962f23_4c1a_455a_b272_5824b8f18346:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1fd8cfbd_785e_481c_a0bc_a06db1bd31b9
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
  BNE	__IFNOT_72107dd6_59f8_47a7_abee_bd2942d80b55
  JMP	__ITER__END__1fd8cfbd_785e_481c_a0bc_a06db1bd31b9
  __IFNOT_72107dd6_59f8_47a7_abee_bd2942d80b55:
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
  JMP	__ITER__START__1fd8cfbd_785e_481c_a0bc_a06db1bd31b9
  __ITER__END__1fd8cfbd_785e_481c_a0bc_a06db1bd31b9:
  __ITER__START__691e4256_7ba4_4f38_bbfe_82fc45bb1295:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__691e4256_7ba4_4f38_bbfe_82fc45bb1295
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f9e6cec1_a555_4908_9ec4_bbdffe47e861
  BNE	__CMP_YES_f9e6cec1_a555_4908_9ec4_bbdffe47e861
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f9e6cec1_a555_4908_9ec4_bbdffe47e861
  BNE	__CMP_YES_f9e6cec1_a555_4908_9ec4_bbdffe47e861
  JMP	__CMP_YES_f9e6cec1_a555_4908_9ec4_bbdffe47e861
  __CMP_YES_f9e6cec1_a555_4908_9ec4_bbdffe47e861:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f9e6cec1_a555_4908_9ec4_bbdffe47e861
  __CMP_NO_f9e6cec1_a555_4908_9ec4_bbdffe47e861:
  SEP	#$20
  LDA	#$00
  __CMP_END_f9e6cec1_a555_4908_9ec4_bbdffe47e861:
  BEQ	__IFNOT_8426ec3a_6372_4df5_92e8_f9e4d8b47843
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
  __IFNOT_8426ec3a_6372_4df5_92e8_f9e4d8b47843:
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
  JMP	__ITER__START__691e4256_7ba4_4f38_bbfe_82fc45bb1295
  __ITER__END__691e4256_7ba4_4f38_bbfe_82fc45bb1295:
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
  __ITER__START__2ff10734_1bab_479a_ac62_8ad730c777c2:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8
  BNE	__CMP_YES_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8
  BNE	__CMP_YES_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8
  BNE	__CMP_YES_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8
  JMP	__CMP_NO_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8
  __CMP_YES_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8
  __CMP_NO_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8:
  SEP	#$20
  LDA	#$00
  __CMP_END_9b50d7e7_ba3f_4cf7_8292_1b8d940246b8:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__2ff10734_1bab_479a_ac62_8ad730c777c2
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
  BNE	__IFNOT_4e0edab5_0a00_4b24_93bc_88cafaf4d79a
  JMP	__ITER__END__2ff10734_1bab_479a_ac62_8ad730c777c2
  __IFNOT_4e0edab5_0a00_4b24_93bc_88cafaf4d79a:
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
  JMP	__ITER__START__2ff10734_1bab_479a_ac62_8ad730c777c2
  __ITER__END__2ff10734_1bab_479a_ac62_8ad730c777c2:
  __ITER__START__5d3913ad_ba6b_4f4c_8f88_ae74387668f0:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5d3913ad_ba6b_4f4c_8f88_ae74387668f0
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_da50cf84_7644_4ecf_ad94_cb7314dfa520
  BNE	__CMP_YES_da50cf84_7644_4ecf_ad94_cb7314dfa520
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_da50cf84_7644_4ecf_ad94_cb7314dfa520
  BNE	__CMP_YES_da50cf84_7644_4ecf_ad94_cb7314dfa520
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_da50cf84_7644_4ecf_ad94_cb7314dfa520
  BNE	__CMP_YES_da50cf84_7644_4ecf_ad94_cb7314dfa520
  JMP	__CMP_YES_da50cf84_7644_4ecf_ad94_cb7314dfa520
  __CMP_YES_da50cf84_7644_4ecf_ad94_cb7314dfa520:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_da50cf84_7644_4ecf_ad94_cb7314dfa520
  __CMP_NO_da50cf84_7644_4ecf_ad94_cb7314dfa520:
  SEP	#$20
  LDA	#$00
  __CMP_END_da50cf84_7644_4ecf_ad94_cb7314dfa520:
  BEQ	__IFNOT_e48698ab_e9a2_4955_9333_dffbecc8eb26
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
  __IFNOT_e48698ab_e9a2_4955_9333_dffbecc8eb26:
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
  JMP	__ITER__START__5d3913ad_ba6b_4f4c_8f88_ae74387668f0
  __ITER__END__5d3913ad_ba6b_4f4c_8f88_ae74387668f0:
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
  __ITER__START__c700898d_aa0a_47c0_a71a_1ef3c27caf88:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_25f77812_5d13_458e_9f75_8181487788f2
  BNE	__CMP_YES_25f77812_5d13_458e_9f75_8181487788f2
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_25f77812_5d13_458e_9f75_8181487788f2
  BNE	__CMP_YES_25f77812_5d13_458e_9f75_8181487788f2
  JMP	__CMP_NO_25f77812_5d13_458e_9f75_8181487788f2
  __CMP_YES_25f77812_5d13_458e_9f75_8181487788f2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_25f77812_5d13_458e_9f75_8181487788f2
  __CMP_NO_25f77812_5d13_458e_9f75_8181487788f2:
  SEP	#$20
  LDA	#$00
  __CMP_END_25f77812_5d13_458e_9f75_8181487788f2:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__c700898d_aa0a_47c0_a71a_1ef3c27caf88
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
  BNE	__IFNOT_cfe311d6_c650_4cb2_bdb1_5af0aed9c748
  JMP	__ITER__END__c700898d_aa0a_47c0_a71a_1ef3c27caf88
  __IFNOT_cfe311d6_c650_4cb2_bdb1_5af0aed9c748:
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
  JMP	__ITER__START__c700898d_aa0a_47c0_a71a_1ef3c27caf88
  __ITER__END__c700898d_aa0a_47c0_a71a_1ef3c27caf88:
  __ITER__START__1e9f2f7f_106d_4d1c_b614_4fcdfe2d842d:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1e9f2f7f_106d_4d1c_b614_4fcdfe2d842d
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_fda8f0ce_642c_4c09_a24f_162b61dea1d4
  BNE	__CMP_YES_fda8f0ce_642c_4c09_a24f_162b61dea1d4
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_fda8f0ce_642c_4c09_a24f_162b61dea1d4
  BNE	__CMP_YES_fda8f0ce_642c_4c09_a24f_162b61dea1d4
  JMP	__CMP_YES_fda8f0ce_642c_4c09_a24f_162b61dea1d4
  __CMP_YES_fda8f0ce_642c_4c09_a24f_162b61dea1d4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_fda8f0ce_642c_4c09_a24f_162b61dea1d4
  __CMP_NO_fda8f0ce_642c_4c09_a24f_162b61dea1d4:
  SEP	#$20
  LDA	#$00
  __CMP_END_fda8f0ce_642c_4c09_a24f_162b61dea1d4:
  BEQ	__IFNOT_584703b7_7cff_4323_867f_3502e17b9a10
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
  __IFNOT_584703b7_7cff_4323_867f_3502e17b9a10:
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
  JMP	__ITER__START__1e9f2f7f_106d_4d1c_b614_4fcdfe2d842d
  __ITER__END__1e9f2f7f_106d_4d1c_b614_4fcdfe2d842d:
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
  __ITER__START__7f228806_6f7a_455d_9177_43724009da1b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_6d25658e_1883_4322_9abe_ad60650ef31f
  BNE	__CMP_YES_6d25658e_1883_4322_9abe_ad60650ef31f
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_6d25658e_1883_4322_9abe_ad60650ef31f
  BNE	__CMP_YES_6d25658e_1883_4322_9abe_ad60650ef31f
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6d25658e_1883_4322_9abe_ad60650ef31f
  BNE	__CMP_YES_6d25658e_1883_4322_9abe_ad60650ef31f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6d25658e_1883_4322_9abe_ad60650ef31f
  BNE	__CMP_YES_6d25658e_1883_4322_9abe_ad60650ef31f
  JMP	__CMP_NO_6d25658e_1883_4322_9abe_ad60650ef31f
  __CMP_YES_6d25658e_1883_4322_9abe_ad60650ef31f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6d25658e_1883_4322_9abe_ad60650ef31f
  __CMP_NO_6d25658e_1883_4322_9abe_ad60650ef31f:
  SEP	#$20
  LDA	#$00
  __CMP_END_6d25658e_1883_4322_9abe_ad60650ef31f:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7f228806_6f7a_455d_9177_43724009da1b
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
  BNE	__IFNOT_43e9caba_d885_4cdf_96ea_d1c52688ccb6
  JMP	__ITER__END__7f228806_6f7a_455d_9177_43724009da1b
  __IFNOT_43e9caba_d885_4cdf_96ea_d1c52688ccb6:
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
  JMP	__ITER__START__7f228806_6f7a_455d_9177_43724009da1b
  __ITER__END__7f228806_6f7a_455d_9177_43724009da1b:
  __ITER__START__24cf341d_9b64_4ffa_adad_f2c950349692:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__24cf341d_9b64_4ffa_adad_f2c950349692
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_3aec43fa_88d2_4117_9b9f_4ac123f86741
  BNE	__CMP_YES_3aec43fa_88d2_4117_9b9f_4ac123f86741
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_3aec43fa_88d2_4117_9b9f_4ac123f86741
  BNE	__CMP_YES_3aec43fa_88d2_4117_9b9f_4ac123f86741
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3aec43fa_88d2_4117_9b9f_4ac123f86741
  BNE	__CMP_YES_3aec43fa_88d2_4117_9b9f_4ac123f86741
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3aec43fa_88d2_4117_9b9f_4ac123f86741
  BNE	__CMP_YES_3aec43fa_88d2_4117_9b9f_4ac123f86741
  JMP	__CMP_YES_3aec43fa_88d2_4117_9b9f_4ac123f86741
  __CMP_YES_3aec43fa_88d2_4117_9b9f_4ac123f86741:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3aec43fa_88d2_4117_9b9f_4ac123f86741
  __CMP_NO_3aec43fa_88d2_4117_9b9f_4ac123f86741:
  SEP	#$20
  LDA	#$00
  __CMP_END_3aec43fa_88d2_4117_9b9f_4ac123f86741:
  BEQ	__IFNOT_66417f39_128f_49c3_aa45_5b096f4aee28
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
  __IFNOT_66417f39_128f_49c3_aa45_5b096f4aee28:
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
  JMP	__ITER__START__24cf341d_9b64_4ffa_adad_f2c950349692
  __ITER__END__24cf341d_9b64_4ffa_adad_f2c950349692:
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
  __ITER__START__da0dc135_28bd_4e0a_b013_bba4d4fac95b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_80b0ea40_ac7a_4760_8566_ee7fd3879363
  BNE	__CMP_YES_80b0ea40_ac7a_4760_8566_ee7fd3879363
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_80b0ea40_ac7a_4760_8566_ee7fd3879363
  BNE	__CMP_YES_80b0ea40_ac7a_4760_8566_ee7fd3879363
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_80b0ea40_ac7a_4760_8566_ee7fd3879363
  BNE	__CMP_YES_80b0ea40_ac7a_4760_8566_ee7fd3879363
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_80b0ea40_ac7a_4760_8566_ee7fd3879363
  BNE	__CMP_YES_80b0ea40_ac7a_4760_8566_ee7fd3879363
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_80b0ea40_ac7a_4760_8566_ee7fd3879363
  BNE	__CMP_YES_80b0ea40_ac7a_4760_8566_ee7fd3879363
  JMP	__CMP_NO_80b0ea40_ac7a_4760_8566_ee7fd3879363
  __CMP_YES_80b0ea40_ac7a_4760_8566_ee7fd3879363:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_80b0ea40_ac7a_4760_8566_ee7fd3879363
  __CMP_NO_80b0ea40_ac7a_4760_8566_ee7fd3879363:
  SEP	#$20
  LDA	#$00
  __CMP_END_80b0ea40_ac7a_4760_8566_ee7fd3879363:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__da0dc135_28bd_4e0a_b013_bba4d4fac95b
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
  BNE	__IFNOT_bc062e40_a2fc_43a3_8ffe_19a7acf0a997
  JMP	__ITER__END__da0dc135_28bd_4e0a_b013_bba4d4fac95b
  __IFNOT_bc062e40_a2fc_43a3_8ffe_19a7acf0a997:
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
  JMP	__ITER__START__da0dc135_28bd_4e0a_b013_bba4d4fac95b
  __ITER__END__da0dc135_28bd_4e0a_b013_bba4d4fac95b:
  __ITER__START__f91ab971_b17c_443a_86de_ccf263e7b541:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f91ab971_b17c_443a_86de_ccf263e7b541
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_c763c858_7ae3_426e_9401_01510a4d64e1
  BNE	__CMP_YES_c763c858_7ae3_426e_9401_01510a4d64e1
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_c763c858_7ae3_426e_9401_01510a4d64e1
  BNE	__CMP_YES_c763c858_7ae3_426e_9401_01510a4d64e1
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c763c858_7ae3_426e_9401_01510a4d64e1
  BNE	__CMP_YES_c763c858_7ae3_426e_9401_01510a4d64e1
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c763c858_7ae3_426e_9401_01510a4d64e1
  BNE	__CMP_YES_c763c858_7ae3_426e_9401_01510a4d64e1
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c763c858_7ae3_426e_9401_01510a4d64e1
  BNE	__CMP_YES_c763c858_7ae3_426e_9401_01510a4d64e1
  JMP	__CMP_YES_c763c858_7ae3_426e_9401_01510a4d64e1
  __CMP_YES_c763c858_7ae3_426e_9401_01510a4d64e1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c763c858_7ae3_426e_9401_01510a4d64e1
  __CMP_NO_c763c858_7ae3_426e_9401_01510a4d64e1:
  SEP	#$20
  LDA	#$00
  __CMP_END_c763c858_7ae3_426e_9401_01510a4d64e1:
  BEQ	__IFNOT_4539c902_38b8_47e8_8fd5_eb6fa0778665
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
  __IFNOT_4539c902_38b8_47e8_8fd5_eb6fa0778665:
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
  JMP	__ITER__START__f91ab971_b17c_443a_86de_ccf263e7b541
  __ITER__END__f91ab971_b17c_443a_86de_ccf263e7b541:
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
  __ITER__START__17fc11ca_698a_45aa_b256_121dbe177b49:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e6986e72_18fb_4029_b609_21344acdf6a8
  BNE	__CMP_YES_e6986e72_18fb_4029_b609_21344acdf6a8
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e6986e72_18fb_4029_b609_21344acdf6a8
  BNE	__CMP_YES_e6986e72_18fb_4029_b609_21344acdf6a8
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e6986e72_18fb_4029_b609_21344acdf6a8
  BNE	__CMP_YES_e6986e72_18fb_4029_b609_21344acdf6a8
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e6986e72_18fb_4029_b609_21344acdf6a8
  BNE	__CMP_YES_e6986e72_18fb_4029_b609_21344acdf6a8
  JMP	__CMP_NO_e6986e72_18fb_4029_b609_21344acdf6a8
  __CMP_YES_e6986e72_18fb_4029_b609_21344acdf6a8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e6986e72_18fb_4029_b609_21344acdf6a8
  __CMP_NO_e6986e72_18fb_4029_b609_21344acdf6a8:
  SEP	#$20
  LDA	#$00
  __CMP_END_e6986e72_18fb_4029_b609_21344acdf6a8:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__17fc11ca_698a_45aa_b256_121dbe177b49
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
  BNE	__IFNOT_26f622b7_c244_4f48_b159_25c2f8d99d97
  JMP	__ITER__END__17fc11ca_698a_45aa_b256_121dbe177b49
  __IFNOT_26f622b7_c244_4f48_b159_25c2f8d99d97:
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
  JMP	__ITER__START__17fc11ca_698a_45aa_b256_121dbe177b49
  __ITER__END__17fc11ca_698a_45aa_b256_121dbe177b49:
  __ITER__START__dbeeb07c_aa98_4813_9d65_2d9999b53e79:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__dbeeb07c_aa98_4813_9d65_2d9999b53e79
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  BNE	__CMP_YES_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  BNE	__CMP_YES_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  BNE	__CMP_YES_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  BNE	__CMP_YES_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  JMP	__CMP_YES_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  __CMP_YES_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d
  __CMP_NO_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d:
  SEP	#$20
  LDA	#$00
  __CMP_END_2cd6e85d_53d9_4999_bb4b_d81eaaa3068d:
  BEQ	__IFNOT_fe6b4191_5145_46d2_a820_d059b23e4d0c
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
  __IFNOT_fe6b4191_5145_46d2_a820_d059b23e4d0c:
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
  JMP	__ITER__START__dbeeb07c_aa98_4813_9d65_2d9999b53e79
  __ITER__END__dbeeb07c_aa98_4813_9d65_2d9999b53e79:
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
  __ITER__START__647aadc6_1977_4ba6_ac43_d7a4ab516092:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  BNE	__CMP_YES_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  BNE	__CMP_YES_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  BNE	__CMP_YES_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  BNE	__CMP_YES_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  BNE	__CMP_YES_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  JMP	__CMP_NO_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  __CMP_YES_d39719a3_5db9_48e9_a5aa_0943f6a3c649:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d39719a3_5db9_48e9_a5aa_0943f6a3c649
  __CMP_NO_d39719a3_5db9_48e9_a5aa_0943f6a3c649:
  SEP	#$20
  LDA	#$00
  __CMP_END_d39719a3_5db9_48e9_a5aa_0943f6a3c649:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__647aadc6_1977_4ba6_ac43_d7a4ab516092
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
  BNE	__IFNOT_49993ec3_d5ed_41b9_b64b_9fc080d3673c
  JMP	__ITER__END__647aadc6_1977_4ba6_ac43_d7a4ab516092
  __IFNOT_49993ec3_d5ed_41b9_b64b_9fc080d3673c:
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
  JMP	__ITER__START__647aadc6_1977_4ba6_ac43_d7a4ab516092
  __ITER__END__647aadc6_1977_4ba6_ac43_d7a4ab516092:
  __ITER__START__b16aac2e_1d9e_4c9b_9a01_30acc41502db:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b16aac2e_1d9e_4c9b_9a01_30acc41502db
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  BNE	__CMP_YES_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  BNE	__CMP_YES_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  BNE	__CMP_YES_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  BNE	__CMP_YES_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  BNE	__CMP_YES_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  JMP	__CMP_YES_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  __CMP_YES_107737f0_7ee5_456c_8bb1_3fd537dcb13b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_107737f0_7ee5_456c_8bb1_3fd537dcb13b
  __CMP_NO_107737f0_7ee5_456c_8bb1_3fd537dcb13b:
  SEP	#$20
  LDA	#$00
  __CMP_END_107737f0_7ee5_456c_8bb1_3fd537dcb13b:
  BEQ	__IFNOT_5b92ebd1_b563_47c2_9f53_2bcaf24c1f90
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
  __IFNOT_5b92ebd1_b563_47c2_9f53_2bcaf24c1f90:
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
  JMP	__ITER__START__b16aac2e_1d9e_4c9b_9a01_30acc41502db
  __ITER__END__b16aac2e_1d9e_4c9b_9a01_30acc41502db:
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
  __ITER__START__934a6074_c9d8_431b_87b0_9cd4afcfaed6:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_be3a1357_f035_430c_bf87_64a0a641f363
  BNE	__CMP_YES_be3a1357_f035_430c_bf87_64a0a641f363
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_be3a1357_f035_430c_bf87_64a0a641f363
  BNE	__CMP_YES_be3a1357_f035_430c_bf87_64a0a641f363
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_be3a1357_f035_430c_bf87_64a0a641f363
  BNE	__CMP_YES_be3a1357_f035_430c_bf87_64a0a641f363
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_be3a1357_f035_430c_bf87_64a0a641f363
  BNE	__CMP_YES_be3a1357_f035_430c_bf87_64a0a641f363
  JMP	__CMP_NO_be3a1357_f035_430c_bf87_64a0a641f363
  __CMP_YES_be3a1357_f035_430c_bf87_64a0a641f363:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_be3a1357_f035_430c_bf87_64a0a641f363
  __CMP_NO_be3a1357_f035_430c_bf87_64a0a641f363:
  SEP	#$20
  LDA	#$00
  __CMP_END_be3a1357_f035_430c_bf87_64a0a641f363:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__934a6074_c9d8_431b_87b0_9cd4afcfaed6
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
  BNE	__IFNOT_24c32861_1977_4107_9970_4466b6a577d4
  JMP	__ITER__END__934a6074_c9d8_431b_87b0_9cd4afcfaed6
  __IFNOT_24c32861_1977_4107_9970_4466b6a577d4:
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
  JMP	__ITER__START__934a6074_c9d8_431b_87b0_9cd4afcfaed6
  __ITER__END__934a6074_c9d8_431b_87b0_9cd4afcfaed6:
  __ITER__START__fa615fda_e466_4c00_bea1_ab5cdf1094e1:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__fa615fda_e466_4c00_bea1_ab5cdf1094e1
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_c09b80b1_985b_456f_b764_4b729bc11ec4
  BNE	__CMP_YES_c09b80b1_985b_456f_b764_4b729bc11ec4
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_c09b80b1_985b_456f_b764_4b729bc11ec4
  BNE	__CMP_YES_c09b80b1_985b_456f_b764_4b729bc11ec4
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c09b80b1_985b_456f_b764_4b729bc11ec4
  BNE	__CMP_YES_c09b80b1_985b_456f_b764_4b729bc11ec4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c09b80b1_985b_456f_b764_4b729bc11ec4
  BNE	__CMP_YES_c09b80b1_985b_456f_b764_4b729bc11ec4
  JMP	__CMP_YES_c09b80b1_985b_456f_b764_4b729bc11ec4
  __CMP_YES_c09b80b1_985b_456f_b764_4b729bc11ec4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c09b80b1_985b_456f_b764_4b729bc11ec4
  __CMP_NO_c09b80b1_985b_456f_b764_4b729bc11ec4:
  SEP	#$20
  LDA	#$00
  __CMP_END_c09b80b1_985b_456f_b764_4b729bc11ec4:
  BEQ	__IFNOT_5f6b127f_055d_45cb_8155_d9b6e0c1b988
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
  __IFNOT_5f6b127f_055d_45cb_8155_d9b6e0c1b988:
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
  JMP	__ITER__START__fa615fda_e466_4c00_bea1_ab5cdf1094e1
  __ITER__END__fa615fda_e466_4c00_bea1_ab5cdf1094e1:
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
  __ITER__START__e332bca7_2d78_47e3_a716_680d926fabd3:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  BNE	__CMP_YES_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  BNE	__CMP_YES_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  BNE	__CMP_YES_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  BNE	__CMP_YES_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  JMP	__CMP_NO_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  __CMP_YES_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6
  __CMP_NO_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6:
  SEP	#$20
  LDA	#$00
  __CMP_END_bf4ae5b1_1fac_4b55_8b98_cd9c51a652b6:
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e332bca7_2d78_47e3_a716_680d926fabd3
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
  BNE	__IFNOT_d9274f94_9b89_441c_813f_2b141454cf39
  JMP	__ITER__END__e332bca7_2d78_47e3_a716_680d926fabd3
  __IFNOT_d9274f94_9b89_441c_813f_2b141454cf39:
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
  JMP	__ITER__START__e332bca7_2d78_47e3_a716_680d926fabd3
  __ITER__END__e332bca7_2d78_47e3_a716_680d926fabd3:
  __ITER__START__771017cd_441b_45ec_8e49_7f824890ef75:
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
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__771017cd_441b_45ec_8e49_7f824890ef75
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  BNE	__CMP_YES_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  BNE	__CMP_YES_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  BNE	__CMP_YES_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  BNE	__CMP_YES_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  JMP	__CMP_YES_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  __CMP_YES_b2172cec_fd82_46b4_988a_8c6bddc5aec3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b2172cec_fd82_46b4_988a_8c6bddc5aec3
  __CMP_NO_b2172cec_fd82_46b4_988a_8c6bddc5aec3:
  SEP	#$20
  LDA	#$00
  __CMP_END_b2172cec_fd82_46b4_988a_8c6bddc5aec3:
  BNE	:+
  JMP	__IFNOT_824326f1_411c_46bd_9a18_3975dc5864ad
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
  __IFNOT_824326f1_411c_46bd_9a18_3975dc5864ad:
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
  JMP	__ITER__START__771017cd_441b_45ec_8e49_7f824890ef75
  __ITER__END__771017cd_441b_45ec_8e49_7f824890ef75:
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
