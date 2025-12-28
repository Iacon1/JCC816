; Thanks to Sir Walrus for long div/mod code

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
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 2
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


; @asm
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
  __ITER__START__cadca6fe_e313_4857_8566_e63b43e423b3:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2842552b_d60f_4b8a_92d4_39e2fade386f
  BNE	__CMP_YES_2842552b_d60f_4b8a_92d4_39e2fade386f
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2842552b_d60f_4b8a_92d4_39e2fade386f
  BNE	__CMP_YES_2842552b_d60f_4b8a_92d4_39e2fade386f
  JMP	__CMP_NO_2842552b_d60f_4b8a_92d4_39e2fade386f
  __CMP_YES_2842552b_d60f_4b8a_92d4_39e2fade386f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2842552b_d60f_4b8a_92d4_39e2fade386f
  __CMP_NO_2842552b_d60f_4b8a_92d4_39e2fade386f:
  SEP	#$20
  LDA	#$00
  __CMP_END_2842552b_d60f_4b8a_92d4_39e2fade386f:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__cadca6fe_e313_4857_8566_e63b43e423b3
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
  BNE	__IFNOT_f3196056_7ab6_4ad7_9493_12ba46bae024
  JMP	__ITER__END__cadca6fe_e313_4857_8566_e63b43e423b3
  __IFNOT_f3196056_7ab6_4ad7_9493_12ba46bae024:
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
  JMP	__ITER__START__cadca6fe_e313_4857_8566_e63b43e423b3
  __ITER__END__cadca6fe_e313_4857_8566_e63b43e423b3:
  __ITER__START__f6254268_f96b_4876_bb8c_aea73e496a92:
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
  JMP	__ITER__END__f6254268_f96b_4876_bb8c_aea73e496a92
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_31c03f69_1dff_4705_a0a7_c801bf0f1422
  BNE	__CMP_YES_31c03f69_1dff_4705_a0a7_c801bf0f1422
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_31c03f69_1dff_4705_a0a7_c801bf0f1422
  BNE	__CMP_YES_31c03f69_1dff_4705_a0a7_c801bf0f1422
  JMP	__CMP_YES_31c03f69_1dff_4705_a0a7_c801bf0f1422
  __CMP_YES_31c03f69_1dff_4705_a0a7_c801bf0f1422:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_31c03f69_1dff_4705_a0a7_c801bf0f1422
  __CMP_NO_31c03f69_1dff_4705_a0a7_c801bf0f1422:
  SEP	#$20
  LDA	#$00
  __CMP_END_31c03f69_1dff_4705_a0a7_c801bf0f1422:
  BEQ	__IFNOT_bd8fba7d_9617_493c_9bd1_3afb860534e7
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
  __IFNOT_bd8fba7d_9617_493c_9bd1_3afb860534e7:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div8by16@start + 1
  LSR
  STA	__div8by16@start + 1
  SEP	#$20
  LDA	__div8by16@start + 0
  ROR
  STA	__div8by16@start + 0
  JMP	__ITER__START__f6254268_f96b_4876_bb8c_aea73e496a92
  __ITER__END__f6254268_f96b_4876_bb8c_aea73e496a92:
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
  __ITER__START__4481649e_2121_4f6e_bf9b_473ad9e52418:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e450083c_4c2c_4d09_a310_acfecb0eb2d8
  BNE	__CMP_YES_e450083c_4c2c_4d09_a310_acfecb0eb2d8
  JMP	__CMP_NO_e450083c_4c2c_4d09_a310_acfecb0eb2d8
  __CMP_YES_e450083c_4c2c_4d09_a310_acfecb0eb2d8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e450083c_4c2c_4d09_a310_acfecb0eb2d8
  __CMP_NO_e450083c_4c2c_4d09_a310_acfecb0eb2d8:
  SEP	#$20
  LDA	#$00
  __CMP_END_e450083c_4c2c_4d09_a310_acfecb0eb2d8:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4481649e_2121_4f6e_bf9b_473ad9e52418
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
  BNE	__IFNOT_ca553638_edaf_4729_981d_ebaa2e9d1235
  JMP	__ITER__END__4481649e_2121_4f6e_bf9b_473ad9e52418
  __IFNOT_ca553638_edaf_4729_981d_ebaa2e9d1235:
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
  JMP	__ITER__START__4481649e_2121_4f6e_bf9b_473ad9e52418
  __ITER__END__4481649e_2121_4f6e_bf9b_473ad9e52418:
  __ITER__START__3c4b81d9_3e56_463f_81c3_306e7637683d:
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
  JMP	__ITER__END__3c4b81d9_3e56_463f_81c3_306e7637683d
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e3cd4c0b_9c13_4343_98c6_c9401d17c4a7
  BNE	__CMP_YES_e3cd4c0b_9c13_4343_98c6_c9401d17c4a7
  JMP	__CMP_YES_e3cd4c0b_9c13_4343_98c6_c9401d17c4a7
  __CMP_YES_e3cd4c0b_9c13_4343_98c6_c9401d17c4a7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e3cd4c0b_9c13_4343_98c6_c9401d17c4a7
  __CMP_NO_e3cd4c0b_9c13_4343_98c6_c9401d17c4a7:
  SEP	#$20
  LDA	#$00
  __CMP_END_e3cd4c0b_9c13_4343_98c6_c9401d17c4a7:
  BEQ	__IFNOT_0ca8fb07_9b93_4286_be3c_131dd01459e2
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
  __IFNOT_0ca8fb07_9b93_4286_be3c_131dd01459e2:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div16by16@start + 1
  LSR
  STA	__div16by16@start + 1
  SEP	#$20
  LDA	__div16by16@start + 0
  ROR
  STA	__div16by16@start + 0
  JMP	__ITER__START__3c4b81d9_3e56_463f_81c3_306e7637683d
  __ITER__END__3c4b81d9_3e56_463f_81c3_306e7637683d:
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
  __ITER__START__56cc39db_c717_4b60_9ca3_40a7b8905908:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_a8b48551_3036_431a_a326_ce6b24332187
  BNE	__CMP_YES_a8b48551_3036_431a_a326_ce6b24332187
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a8b48551_3036_431a_a326_ce6b24332187
  BNE	__CMP_YES_a8b48551_3036_431a_a326_ce6b24332187
  JMP	__CMP_NO_a8b48551_3036_431a_a326_ce6b24332187
  __CMP_YES_a8b48551_3036_431a_a326_ce6b24332187:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a8b48551_3036_431a_a326_ce6b24332187
  __CMP_NO_a8b48551_3036_431a_a326_ce6b24332187:
  SEP	#$20
  LDA	#$00
  __CMP_END_a8b48551_3036_431a_a326_ce6b24332187:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__56cc39db_c717_4b60_9ca3_40a7b8905908
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
  BNE	__IFNOT_e54d5bf9_ac5d_477a_9d5f_6c7e71edbcf0
  JMP	__ITER__END__56cc39db_c717_4b60_9ca3_40a7b8905908
  __IFNOT_e54d5bf9_ac5d_477a_9d5f_6c7e71edbcf0:
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
  JMP	__ITER__START__56cc39db_c717_4b60_9ca3_40a7b8905908
  __ITER__END__56cc39db_c717_4b60_9ca3_40a7b8905908:
  __ITER__START__4dab34f3_62c5_4e9b_9fd2_09f4a6733e37:
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
  JMP	__ITER__END__4dab34f3_62c5_4e9b_9fd2_09f4a6733e37
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_bec8ea9c_efcf_493f_9138_be761fca966c
  BNE	__CMP_YES_bec8ea9c_efcf_493f_9138_be761fca966c
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_bec8ea9c_efcf_493f_9138_be761fca966c
  BNE	__CMP_YES_bec8ea9c_efcf_493f_9138_be761fca966c
  JMP	__CMP_YES_bec8ea9c_efcf_493f_9138_be761fca966c
  __CMP_YES_bec8ea9c_efcf_493f_9138_be761fca966c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_bec8ea9c_efcf_493f_9138_be761fca966c
  __CMP_NO_bec8ea9c_efcf_493f_9138_be761fca966c:
  SEP	#$20
  LDA	#$00
  __CMP_END_bec8ea9c_efcf_493f_9138_be761fca966c:
  BEQ	__IFNOT_5511aa2e_3f72_46ef_b6e9_dc57b1a11a46
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
  __IFNOT_5511aa2e_3f72_46ef_b6e9_dc57b1a11a46:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div24by16@start + 1
  LSR
  STA	__div24by16@start + 1
  SEP	#$20
  LDA	__div24by16@start + 0
  ROR
  STA	__div24by16@start + 0
  JMP	__ITER__START__4dab34f3_62c5_4e9b_9fd2_09f4a6733e37
  __ITER__END__4dab34f3_62c5_4e9b_9fd2_09f4a6733e37:
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
  __ITER__START__1607b51d_06b4_4ea3_a5a3_a47f180914bd:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_555350eb_856e_4a8f_a7c6_89740c9a78c4
  BNE	__CMP_YES_555350eb_856e_4a8f_a7c6_89740c9a78c4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_555350eb_856e_4a8f_a7c6_89740c9a78c4
  BNE	__CMP_YES_555350eb_856e_4a8f_a7c6_89740c9a78c4
  JMP	__CMP_NO_555350eb_856e_4a8f_a7c6_89740c9a78c4
  __CMP_YES_555350eb_856e_4a8f_a7c6_89740c9a78c4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_555350eb_856e_4a8f_a7c6_89740c9a78c4
  __CMP_NO_555350eb_856e_4a8f_a7c6_89740c9a78c4:
  SEP	#$20
  LDA	#$00
  __CMP_END_555350eb_856e_4a8f_a7c6_89740c9a78c4:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1607b51d_06b4_4ea3_a5a3_a47f180914bd
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
  BNE	__IFNOT_52aa08bc_24b1_4756_8b1b_c731fd36c79a
  JMP	__ITER__END__1607b51d_06b4_4ea3_a5a3_a47f180914bd
  __IFNOT_52aa08bc_24b1_4756_8b1b_c731fd36c79a:
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
  JMP	__ITER__START__1607b51d_06b4_4ea3_a5a3_a47f180914bd
  __ITER__END__1607b51d_06b4_4ea3_a5a3_a47f180914bd:
  __ITER__START__2a161cb3_03b4_4613_b717_a013c86f9884:
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
  JMP	__ITER__END__2a161cb3_03b4_4613_b717_a013c86f9884
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_6c3df0dd_cd8a_4014_89de_de6cc19d955f
  BNE	__CMP_YES_6c3df0dd_cd8a_4014_89de_de6cc19d955f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6c3df0dd_cd8a_4014_89de_de6cc19d955f
  BNE	__CMP_YES_6c3df0dd_cd8a_4014_89de_de6cc19d955f
  JMP	__CMP_YES_6c3df0dd_cd8a_4014_89de_de6cc19d955f
  __CMP_YES_6c3df0dd_cd8a_4014_89de_de6cc19d955f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6c3df0dd_cd8a_4014_89de_de6cc19d955f
  __CMP_NO_6c3df0dd_cd8a_4014_89de_de6cc19d955f:
  SEP	#$20
  LDA	#$00
  __CMP_END_6c3df0dd_cd8a_4014_89de_de6cc19d955f:
  BEQ	__IFNOT_a3ce1b68_af4d_4e78_94f0_1b97e425ca98
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
  __IFNOT_a3ce1b68_af4d_4e78_94f0_1b97e425ca98:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div32by16@start + 1
  LSR
  STA	__div32by16@start + 1
  SEP	#$20
  LDA	__div32by16@start + 0
  ROR
  STA	__div32by16@start + 0
  JMP	__ITER__START__2a161cb3_03b4_4613_b717_a013c86f9884
  __ITER__END__2a161cb3_03b4_4613_b717_a013c86f9884:
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
  __ITER__START__32bed669_96e3_40b2_bc08_2b969a520fac:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_e29ef103_bce7_4c6f_a676_d36961c7381b
  BNE	__CMP_YES_e29ef103_bce7_4c6f_a676_d36961c7381b
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_e29ef103_bce7_4c6f_a676_d36961c7381b
  BNE	__CMP_YES_e29ef103_bce7_4c6f_a676_d36961c7381b
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_e29ef103_bce7_4c6f_a676_d36961c7381b
  BNE	__CMP_YES_e29ef103_bce7_4c6f_a676_d36961c7381b
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e29ef103_bce7_4c6f_a676_d36961c7381b
  BNE	__CMP_YES_e29ef103_bce7_4c6f_a676_d36961c7381b
  JMP	__CMP_NO_e29ef103_bce7_4c6f_a676_d36961c7381b
  __CMP_YES_e29ef103_bce7_4c6f_a676_d36961c7381b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e29ef103_bce7_4c6f_a676_d36961c7381b
  __CMP_NO_e29ef103_bce7_4c6f_a676_d36961c7381b:
  SEP	#$20
  LDA	#$00
  __CMP_END_e29ef103_bce7_4c6f_a676_d36961c7381b:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__32bed669_96e3_40b2_bc08_2b969a520fac
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
  BNE	__IFNOT_b4de80c8_ab34_46d5_a6e3_a3f6e31c4ee1
  JMP	__ITER__END__32bed669_96e3_40b2_bc08_2b969a520fac
  __IFNOT_b4de80c8_ab34_46d5_a6e3_a3f6e31c4ee1:
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
  JMP	__ITER__START__32bed669_96e3_40b2_bc08_2b969a520fac
  __ITER__END__32bed669_96e3_40b2_bc08_2b969a520fac:
  __ITER__START__a56307af_32de_410e_88d7_801c7cdeea99:
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
  JMP	__ITER__END__a56307af_32de_410e_88d7_801c7cdeea99
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  BNE	__CMP_YES_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  BNE	__CMP_YES_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  BNE	__CMP_YES_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  BNE	__CMP_YES_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  JMP	__CMP_YES_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  __CMP_YES_4946ba6d_2d6d_479d_84c3_df525f5f3e60:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4946ba6d_2d6d_479d_84c3_df525f5f3e60
  __CMP_NO_4946ba6d_2d6d_479d_84c3_df525f5f3e60:
  SEP	#$20
  LDA	#$00
  __CMP_END_4946ba6d_2d6d_479d_84c3_df525f5f3e60:
  BEQ	__IFNOT_3a8e3751_0177_4407_a914_de127ee1eeae
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
  __IFNOT_3a8e3751_0177_4407_a914_de127ee1eeae:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div64by16@start + 1
  LSR
  STA	__div64by16@start + 1
  SEP	#$20
  LDA	__div64by16@start + 0
  ROR
  STA	__div64by16@start + 0
  JMP	__ITER__START__a56307af_32de_410e_88d7_801c7cdeea99
  __ITER__END__a56307af_32de_410e_88d7_801c7cdeea99:
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
  __ITER__START__d975d740_7311_41c1_bf42_b70e13ef46f3:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_6586b2f4_c23b_4a3f_9bed_7999148cbe57
  BNE	__CMP_YES_6586b2f4_c23b_4a3f_9bed_7999148cbe57
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6586b2f4_c23b_4a3f_9bed_7999148cbe57
  BNE	__CMP_YES_6586b2f4_c23b_4a3f_9bed_7999148cbe57
  JMP	__CMP_NO_6586b2f4_c23b_4a3f_9bed_7999148cbe57
  __CMP_YES_6586b2f4_c23b_4a3f_9bed_7999148cbe57:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6586b2f4_c23b_4a3f_9bed_7999148cbe57
  __CMP_NO_6586b2f4_c23b_4a3f_9bed_7999148cbe57:
  SEP	#$20
  LDA	#$00
  __CMP_END_6586b2f4_c23b_4a3f_9bed_7999148cbe57:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d975d740_7311_41c1_bf42_b70e13ef46f3
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
  BNE	__IFNOT_84fe642f_c53f_4ca5_a322_8706a873267c
  JMP	__ITER__END__d975d740_7311_41c1_bf42_b70e13ef46f3
  __IFNOT_84fe642f_c53f_4ca5_a322_8706a873267c:
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
  JMP	__ITER__START__d975d740_7311_41c1_bf42_b70e13ef46f3
  __ITER__END__d975d740_7311_41c1_bf42_b70e13ef46f3:
  __ITER__START__69c325e3_32db_404c_8f3a_d3b902e13d8b:
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
  JMP	__ITER__END__69c325e3_32db_404c_8f3a_d3b902e13d8b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a9894f11_bca1_40c1_8577_e581d2cf1c8a
  BNE	__CMP_YES_a9894f11_bca1_40c1_8577_e581d2cf1c8a
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a9894f11_bca1_40c1_8577_e581d2cf1c8a
  BNE	__CMP_YES_a9894f11_bca1_40c1_8577_e581d2cf1c8a
  JMP	__CMP_YES_a9894f11_bca1_40c1_8577_e581d2cf1c8a
  __CMP_YES_a9894f11_bca1_40c1_8577_e581d2cf1c8a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a9894f11_bca1_40c1_8577_e581d2cf1c8a
  __CMP_NO_a9894f11_bca1_40c1_8577_e581d2cf1c8a:
  SEP	#$20
  LDA	#$00
  __CMP_END_a9894f11_bca1_40c1_8577_e581d2cf1c8a:
  BEQ	__IFNOT_fb33cecf_a2c9_439d_8fc6_9ab5e09527af
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
  __IFNOT_fb33cecf_a2c9_439d_8fc6_9ab5e09527af:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div8by24@start + 1
  LSR
  STA	__div8by24@start + 1
  SEP	#$20
  LDA	__div8by24@start + 0
  ROR
  STA	__div8by24@start + 0
  JMP	__ITER__START__69c325e3_32db_404c_8f3a_d3b902e13d8b
  __ITER__END__69c325e3_32db_404c_8f3a_d3b902e13d8b:
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
  __ITER__START__609f0f2f_5035_4925_a6fa_f61a4d630d5e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_9ded2ba0_73ef_44ec_ba8f_0d12886fab99
  BNE	__CMP_YES_9ded2ba0_73ef_44ec_ba8f_0d12886fab99
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9ded2ba0_73ef_44ec_ba8f_0d12886fab99
  BNE	__CMP_YES_9ded2ba0_73ef_44ec_ba8f_0d12886fab99
  JMP	__CMP_NO_9ded2ba0_73ef_44ec_ba8f_0d12886fab99
  __CMP_YES_9ded2ba0_73ef_44ec_ba8f_0d12886fab99:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9ded2ba0_73ef_44ec_ba8f_0d12886fab99
  __CMP_NO_9ded2ba0_73ef_44ec_ba8f_0d12886fab99:
  SEP	#$20
  LDA	#$00
  __CMP_END_9ded2ba0_73ef_44ec_ba8f_0d12886fab99:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__609f0f2f_5035_4925_a6fa_f61a4d630d5e
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
  BNE	__IFNOT_acbbc597_fe86_4385_ab03_09caf44c2058
  JMP	__ITER__END__609f0f2f_5035_4925_a6fa_f61a4d630d5e
  __IFNOT_acbbc597_fe86_4385_ab03_09caf44c2058:
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
  JMP	__ITER__START__609f0f2f_5035_4925_a6fa_f61a4d630d5e
  __ITER__END__609f0f2f_5035_4925_a6fa_f61a4d630d5e:
  __ITER__START__bc56f785_592f_4b62_81b6_1e9dbd38586e:
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
  JMP	__ITER__END__bc56f785_592f_4b62_81b6_1e9dbd38586e
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_89a0704f_0dde_4d37_8f06_fc688307789d
  BNE	__CMP_YES_89a0704f_0dde_4d37_8f06_fc688307789d
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_89a0704f_0dde_4d37_8f06_fc688307789d
  BNE	__CMP_YES_89a0704f_0dde_4d37_8f06_fc688307789d
  JMP	__CMP_YES_89a0704f_0dde_4d37_8f06_fc688307789d
  __CMP_YES_89a0704f_0dde_4d37_8f06_fc688307789d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_89a0704f_0dde_4d37_8f06_fc688307789d
  __CMP_NO_89a0704f_0dde_4d37_8f06_fc688307789d:
  SEP	#$20
  LDA	#$00
  __CMP_END_89a0704f_0dde_4d37_8f06_fc688307789d:
  BEQ	__IFNOT_3ab546a2_4a75_4211_8026_89763890a155
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
  __IFNOT_3ab546a2_4a75_4211_8026_89763890a155:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div16by24@start + 1
  LSR
  STA	__div16by24@start + 1
  SEP	#$20
  LDA	__div16by24@start + 0
  ROR
  STA	__div16by24@start + 0
  JMP	__ITER__START__bc56f785_592f_4b62_81b6_1e9dbd38586e
  __ITER__END__bc56f785_592f_4b62_81b6_1e9dbd38586e:
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
  __ITER__START__e0ffdefc_e59e_41c2_a8ab_f98b14ceb56e:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_4365abf3_4fb2_4ba7_8701_f27ebabbcff1
  BNE	__CMP_YES_4365abf3_4fb2_4ba7_8701_f27ebabbcff1
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4365abf3_4fb2_4ba7_8701_f27ebabbcff1
  BNE	__CMP_YES_4365abf3_4fb2_4ba7_8701_f27ebabbcff1
  JMP	__CMP_NO_4365abf3_4fb2_4ba7_8701_f27ebabbcff1
  __CMP_YES_4365abf3_4fb2_4ba7_8701_f27ebabbcff1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4365abf3_4fb2_4ba7_8701_f27ebabbcff1
  __CMP_NO_4365abf3_4fb2_4ba7_8701_f27ebabbcff1:
  SEP	#$20
  LDA	#$00
  __CMP_END_4365abf3_4fb2_4ba7_8701_f27ebabbcff1:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e0ffdefc_e59e_41c2_a8ab_f98b14ceb56e
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
  BNE	__IFNOT_2a0d6ec9_c506_4f18_b6c0_3796f3838346
  JMP	__ITER__END__e0ffdefc_e59e_41c2_a8ab_f98b14ceb56e
  __IFNOT_2a0d6ec9_c506_4f18_b6c0_3796f3838346:
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
  JMP	__ITER__START__e0ffdefc_e59e_41c2_a8ab_f98b14ceb56e
  __ITER__END__e0ffdefc_e59e_41c2_a8ab_f98b14ceb56e:
  __ITER__START__2252d62a_b6ba_4e16_9292_481232903866:
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
  JMP	__ITER__END__2252d62a_b6ba_4e16_9292_481232903866
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8933e8ae_360c_4cfe_a107_36adcd39ac03
  BNE	__CMP_YES_8933e8ae_360c_4cfe_a107_36adcd39ac03
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8933e8ae_360c_4cfe_a107_36adcd39ac03
  BNE	__CMP_YES_8933e8ae_360c_4cfe_a107_36adcd39ac03
  JMP	__CMP_YES_8933e8ae_360c_4cfe_a107_36adcd39ac03
  __CMP_YES_8933e8ae_360c_4cfe_a107_36adcd39ac03:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8933e8ae_360c_4cfe_a107_36adcd39ac03
  __CMP_NO_8933e8ae_360c_4cfe_a107_36adcd39ac03:
  SEP	#$20
  LDA	#$00
  __CMP_END_8933e8ae_360c_4cfe_a107_36adcd39ac03:
  BEQ	__IFNOT_d299e8ac_172c_4cc1_8bb4_a9672d2ee91c
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
  __IFNOT_d299e8ac_172c_4cc1_8bb4_a9672d2ee91c:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div24by24@start + 1
  LSR
  STA	__div24by24@start + 1
  SEP	#$20
  LDA	__div24by24@start + 0
  ROR
  STA	__div24by24@start + 0
  JMP	__ITER__START__2252d62a_b6ba_4e16_9292_481232903866
  __ITER__END__2252d62a_b6ba_4e16_9292_481232903866:
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
  __ITER__START__510093ae_0469_43e9_b902_fd0509db006b:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_9bea27b8_b149_41a3_953d_07091fcefbbe
  BNE	__CMP_YES_9bea27b8_b149_41a3_953d_07091fcefbbe
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_9bea27b8_b149_41a3_953d_07091fcefbbe
  BNE	__CMP_YES_9bea27b8_b149_41a3_953d_07091fcefbbe
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9bea27b8_b149_41a3_953d_07091fcefbbe
  BNE	__CMP_YES_9bea27b8_b149_41a3_953d_07091fcefbbe
  JMP	__CMP_NO_9bea27b8_b149_41a3_953d_07091fcefbbe
  __CMP_YES_9bea27b8_b149_41a3_953d_07091fcefbbe:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9bea27b8_b149_41a3_953d_07091fcefbbe
  __CMP_NO_9bea27b8_b149_41a3_953d_07091fcefbbe:
  SEP	#$20
  LDA	#$00
  __CMP_END_9bea27b8_b149_41a3_953d_07091fcefbbe:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__510093ae_0469_43e9_b902_fd0509db006b
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
  BNE	__IFNOT_146ee008_88fc_4b0b_aa11_f7d1c414e77f
  JMP	__ITER__END__510093ae_0469_43e9_b902_fd0509db006b
  __IFNOT_146ee008_88fc_4b0b_aa11_f7d1c414e77f:
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
  JMP	__ITER__START__510093ae_0469_43e9_b902_fd0509db006b
  __ITER__END__510093ae_0469_43e9_b902_fd0509db006b:
  __ITER__START__880e6c41_8384_49e4_9a91_dd7311962303:
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
  JMP	__ITER__END__880e6c41_8384_49e4_9a91_dd7311962303
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5
  BNE	__CMP_YES_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5
  BNE	__CMP_YES_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5
  BNE	__CMP_YES_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5
  JMP	__CMP_YES_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5
  __CMP_YES_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5
  __CMP_NO_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5:
  SEP	#$20
  LDA	#$00
  __CMP_END_faca5f3a_37ce_4b3c_b15f_4e405ce8fdb5:
  BEQ	__IFNOT_0e57da3d_d641_4137_a0cd_6cbb0c326f18
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
  __IFNOT_0e57da3d_d641_4137_a0cd_6cbb0c326f18:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div32by24@start + 1
  LSR
  STA	__div32by24@start + 1
  SEP	#$20
  LDA	__div32by24@start + 0
  ROR
  STA	__div32by24@start + 0
  JMP	__ITER__START__880e6c41_8384_49e4_9a91_dd7311962303
  __ITER__END__880e6c41_8384_49e4_9a91_dd7311962303:
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
  __ITER__START__4620703e_c37b_43e2_877f_89144422a76a:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_d0b34003_5732_433f_a933_dd30b46995ff
  BNE	__CMP_YES_d0b34003_5732_433f_a933_dd30b46995ff
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_d0b34003_5732_433f_a933_dd30b46995ff
  BNE	__CMP_YES_d0b34003_5732_433f_a933_dd30b46995ff
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_d0b34003_5732_433f_a933_dd30b46995ff
  BNE	__CMP_YES_d0b34003_5732_433f_a933_dd30b46995ff
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d0b34003_5732_433f_a933_dd30b46995ff
  BNE	__CMP_YES_d0b34003_5732_433f_a933_dd30b46995ff
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d0b34003_5732_433f_a933_dd30b46995ff
  BNE	__CMP_YES_d0b34003_5732_433f_a933_dd30b46995ff
  JMP	__CMP_NO_d0b34003_5732_433f_a933_dd30b46995ff
  __CMP_YES_d0b34003_5732_433f_a933_dd30b46995ff:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d0b34003_5732_433f_a933_dd30b46995ff
  __CMP_NO_d0b34003_5732_433f_a933_dd30b46995ff:
  SEP	#$20
  LDA	#$00
  __CMP_END_d0b34003_5732_433f_a933_dd30b46995ff:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__4620703e_c37b_43e2_877f_89144422a76a
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
  BNE	__IFNOT_74fd1aef_fe03_4fc4_8b09_91598533af3e
  JMP	__ITER__END__4620703e_c37b_43e2_877f_89144422a76a
  __IFNOT_74fd1aef_fe03_4fc4_8b09_91598533af3e:
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
  JMP	__ITER__START__4620703e_c37b_43e2_877f_89144422a76a
  __ITER__END__4620703e_c37b_43e2_877f_89144422a76a:
  __ITER__START__64f2d276_b2e3_4b62_960f_d37882585b8f:
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
  JMP	__ITER__END__64f2d276_b2e3_4b62_960f_d37882585b8f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_88f80f1d_1976_40ff_ac72_eaa4288f7947
  BNE	__CMP_YES_88f80f1d_1976_40ff_ac72_eaa4288f7947
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_88f80f1d_1976_40ff_ac72_eaa4288f7947
  BNE	__CMP_YES_88f80f1d_1976_40ff_ac72_eaa4288f7947
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_88f80f1d_1976_40ff_ac72_eaa4288f7947
  BNE	__CMP_YES_88f80f1d_1976_40ff_ac72_eaa4288f7947
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_88f80f1d_1976_40ff_ac72_eaa4288f7947
  BNE	__CMP_YES_88f80f1d_1976_40ff_ac72_eaa4288f7947
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_88f80f1d_1976_40ff_ac72_eaa4288f7947
  BNE	__CMP_YES_88f80f1d_1976_40ff_ac72_eaa4288f7947
  JMP	__CMP_YES_88f80f1d_1976_40ff_ac72_eaa4288f7947
  __CMP_YES_88f80f1d_1976_40ff_ac72_eaa4288f7947:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_88f80f1d_1976_40ff_ac72_eaa4288f7947
  __CMP_NO_88f80f1d_1976_40ff_ac72_eaa4288f7947:
  SEP	#$20
  LDA	#$00
  __CMP_END_88f80f1d_1976_40ff_ac72_eaa4288f7947:
  BNE	:+
  JMP	__IFNOT_b92affcb_9d8f_4baa_b0a2_b68703d951f2
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
  __IFNOT_b92affcb_9d8f_4baa_b0a2_b68703d951f2:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div64by24@start + 1
  LSR
  STA	__div64by24@start + 1
  SEP	#$20
  LDA	__div64by24@start + 0
  ROR
  STA	__div64by24@start + 0
  JMP	__ITER__START__64f2d276_b2e3_4b62_960f_d37882585b8f
  __ITER__END__64f2d276_b2e3_4b62_960f_d37882585b8f:
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
  __ITER__START__3484eebd_a6da_431f_ab06_4fb7c3fa70e3:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f4255741_1fce_452d_831e_310348d4d774
  BNE	__CMP_YES_f4255741_1fce_452d_831e_310348d4d774
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f4255741_1fce_452d_831e_310348d4d774
  BNE	__CMP_YES_f4255741_1fce_452d_831e_310348d4d774
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f4255741_1fce_452d_831e_310348d4d774
  BNE	__CMP_YES_f4255741_1fce_452d_831e_310348d4d774
  JMP	__CMP_NO_f4255741_1fce_452d_831e_310348d4d774
  __CMP_YES_f4255741_1fce_452d_831e_310348d4d774:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f4255741_1fce_452d_831e_310348d4d774
  __CMP_NO_f4255741_1fce_452d_831e_310348d4d774:
  SEP	#$20
  LDA	#$00
  __CMP_END_f4255741_1fce_452d_831e_310348d4d774:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__3484eebd_a6da_431f_ab06_4fb7c3fa70e3
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_84b694a7_a18e_4845_82e9_2dab9120b3f5
  JMP	__ITER__END__3484eebd_a6da_431f_ab06_4fb7c3fa70e3
  __IFNOT_84b694a7_a18e_4845_82e9_2dab9120b3f5:
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
  JMP	__ITER__START__3484eebd_a6da_431f_ab06_4fb7c3fa70e3
  __ITER__END__3484eebd_a6da_431f_ab06_4fb7c3fa70e3:
  __ITER__START__3fb11d4b_177d_410c_8ba2_165622e591c4:
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
  JMP	__ITER__END__3fb11d4b_177d_410c_8ba2_165622e591c4
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_438f4d0c_41df_4501_8dff_ecde3fae1aad
  BNE	__CMP_YES_438f4d0c_41df_4501_8dff_ecde3fae1aad
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_438f4d0c_41df_4501_8dff_ecde3fae1aad
  BNE	__CMP_YES_438f4d0c_41df_4501_8dff_ecde3fae1aad
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_438f4d0c_41df_4501_8dff_ecde3fae1aad
  BNE	__CMP_YES_438f4d0c_41df_4501_8dff_ecde3fae1aad
  JMP	__CMP_YES_438f4d0c_41df_4501_8dff_ecde3fae1aad
  __CMP_YES_438f4d0c_41df_4501_8dff_ecde3fae1aad:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_438f4d0c_41df_4501_8dff_ecde3fae1aad
  __CMP_NO_438f4d0c_41df_4501_8dff_ecde3fae1aad:
  SEP	#$20
  LDA	#$00
  __CMP_END_438f4d0c_41df_4501_8dff_ecde3fae1aad:
  BEQ	__IFNOT_b9b58674_b150_4427_9497_e9a8269b0009
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
  __IFNOT_b9b58674_b150_4427_9497_e9a8269b0009:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div8by32@start + 1
  LSR
  STA	__div8by32@start + 1
  SEP	#$20
  LDA	__div8by32@start + 0
  ROR
  STA	__div8by32@start + 0
  JMP	__ITER__START__3fb11d4b_177d_410c_8ba2_165622e591c4
  __ITER__END__3fb11d4b_177d_410c_8ba2_165622e591c4:
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
  __ITER__START__3fb22f07_e1fb_41da_bdbf_2bd74616de01:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_fa5606eb_bcbc_437a_b612_be0654fc09ee
  BNE	__CMP_YES_fa5606eb_bcbc_437a_b612_be0654fc09ee
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_fa5606eb_bcbc_437a_b612_be0654fc09ee
  BNE	__CMP_YES_fa5606eb_bcbc_437a_b612_be0654fc09ee
  JMP	__CMP_NO_fa5606eb_bcbc_437a_b612_be0654fc09ee
  __CMP_YES_fa5606eb_bcbc_437a_b612_be0654fc09ee:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_fa5606eb_bcbc_437a_b612_be0654fc09ee
  __CMP_NO_fa5606eb_bcbc_437a_b612_be0654fc09ee:
  SEP	#$20
  LDA	#$00
  __CMP_END_fa5606eb_bcbc_437a_b612_be0654fc09ee:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__3fb22f07_e1fb_41da_bdbf_2bd74616de01
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_2c9331ae_fc1d_4241_b9ad_ad2d5563a0ab
  JMP	__ITER__END__3fb22f07_e1fb_41da_bdbf_2bd74616de01
  __IFNOT_2c9331ae_fc1d_4241_b9ad_ad2d5563a0ab:
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
  JMP	__ITER__START__3fb22f07_e1fb_41da_bdbf_2bd74616de01
  __ITER__END__3fb22f07_e1fb_41da_bdbf_2bd74616de01:
  __ITER__START__3ce83a3d_1cb1_4417_86d5_112cb921392b:
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
  JMP	__ITER__END__3ce83a3d_1cb1_4417_86d5_112cb921392b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d874c733_29b4_4d29_8d8f_a930b6d27474
  BNE	__CMP_YES_d874c733_29b4_4d29_8d8f_a930b6d27474
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d874c733_29b4_4d29_8d8f_a930b6d27474
  BNE	__CMP_YES_d874c733_29b4_4d29_8d8f_a930b6d27474
  JMP	__CMP_YES_d874c733_29b4_4d29_8d8f_a930b6d27474
  __CMP_YES_d874c733_29b4_4d29_8d8f_a930b6d27474:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d874c733_29b4_4d29_8d8f_a930b6d27474
  __CMP_NO_d874c733_29b4_4d29_8d8f_a930b6d27474:
  SEP	#$20
  LDA	#$00
  __CMP_END_d874c733_29b4_4d29_8d8f_a930b6d27474:
  BEQ	__IFNOT_6b2a8510_2eb0_401b_892c_a8673ffecc2e
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
  __IFNOT_6b2a8510_2eb0_401b_892c_a8673ffecc2e:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div16by32@start + 1
  LSR
  STA	__div16by32@start + 1
  SEP	#$20
  LDA	__div16by32@start + 0
  ROR
  STA	__div16by32@start + 0
  JMP	__ITER__START__3ce83a3d_1cb1_4417_86d5_112cb921392b
  __ITER__END__3ce83a3d_1cb1_4417_86d5_112cb921392b:
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
  __ITER__START__893751bc_26fd_4d68_bac2_3d767ac34780:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_1c50c037_9a8b_4a99_ad69_51d6918e92f8
  BNE	__CMP_YES_1c50c037_9a8b_4a99_ad69_51d6918e92f8
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_1c50c037_9a8b_4a99_ad69_51d6918e92f8
  BNE	__CMP_YES_1c50c037_9a8b_4a99_ad69_51d6918e92f8
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1c50c037_9a8b_4a99_ad69_51d6918e92f8
  BNE	__CMP_YES_1c50c037_9a8b_4a99_ad69_51d6918e92f8
  JMP	__CMP_NO_1c50c037_9a8b_4a99_ad69_51d6918e92f8
  __CMP_YES_1c50c037_9a8b_4a99_ad69_51d6918e92f8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1c50c037_9a8b_4a99_ad69_51d6918e92f8
  __CMP_NO_1c50c037_9a8b_4a99_ad69_51d6918e92f8:
  SEP	#$20
  LDA	#$00
  __CMP_END_1c50c037_9a8b_4a99_ad69_51d6918e92f8:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__893751bc_26fd_4d68_bac2_3d767ac34780
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_e0c19585_2cb3_4902_b753_ea863e1b0d0f
  JMP	__ITER__END__893751bc_26fd_4d68_bac2_3d767ac34780
  __IFNOT_e0c19585_2cb3_4902_b753_ea863e1b0d0f:
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
  JMP	__ITER__START__893751bc_26fd_4d68_bac2_3d767ac34780
  __ITER__END__893751bc_26fd_4d68_bac2_3d767ac34780:
  __ITER__START__242d4bbb_cbb9_43a5_8b1d_2bc928dbd6d8:
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
  JMP	__ITER__END__242d4bbb_cbb9_43a5_8b1d_2bc928dbd6d8
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_cbf0674b_3eb6_4eb3_adba_07db8485006b
  BNE	__CMP_YES_cbf0674b_3eb6_4eb3_adba_07db8485006b
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_cbf0674b_3eb6_4eb3_adba_07db8485006b
  BNE	__CMP_YES_cbf0674b_3eb6_4eb3_adba_07db8485006b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cbf0674b_3eb6_4eb3_adba_07db8485006b
  BNE	__CMP_YES_cbf0674b_3eb6_4eb3_adba_07db8485006b
  JMP	__CMP_YES_cbf0674b_3eb6_4eb3_adba_07db8485006b
  __CMP_YES_cbf0674b_3eb6_4eb3_adba_07db8485006b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cbf0674b_3eb6_4eb3_adba_07db8485006b
  __CMP_NO_cbf0674b_3eb6_4eb3_adba_07db8485006b:
  SEP	#$20
  LDA	#$00
  __CMP_END_cbf0674b_3eb6_4eb3_adba_07db8485006b:
  BEQ	__IFNOT_5dbb8346_1579_4f1c_9a39_00874f66231f
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
  __IFNOT_5dbb8346_1579_4f1c_9a39_00874f66231f:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div24by32@start + 1
  LSR
  STA	__div24by32@start + 1
  SEP	#$20
  LDA	__div24by32@start + 0
  ROR
  STA	__div24by32@start + 0
  JMP	__ITER__START__242d4bbb_cbb9_43a5_8b1d_2bc928dbd6d8
  __ITER__END__242d4bbb_cbb9_43a5_8b1d_2bc928dbd6d8:
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
  __ITER__START__3a509575_36dc_4e40_85a7_aa0d57802bb6:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e2c85984_77b0_42d5_a514_1e477400a7ae
  BNE	__CMP_YES_e2c85984_77b0_42d5_a514_1e477400a7ae
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e2c85984_77b0_42d5_a514_1e477400a7ae
  BNE	__CMP_YES_e2c85984_77b0_42d5_a514_1e477400a7ae
  JMP	__CMP_NO_e2c85984_77b0_42d5_a514_1e477400a7ae
  __CMP_YES_e2c85984_77b0_42d5_a514_1e477400a7ae:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e2c85984_77b0_42d5_a514_1e477400a7ae
  __CMP_NO_e2c85984_77b0_42d5_a514_1e477400a7ae:
  SEP	#$20
  LDA	#$00
  __CMP_END_e2c85984_77b0_42d5_a514_1e477400a7ae:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__3a509575_36dc_4e40_85a7_aa0d57802bb6
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_8329f8f7_88f5_4217_ab0b_136b8661103e
  JMP	__ITER__END__3a509575_36dc_4e40_85a7_aa0d57802bb6
  __IFNOT_8329f8f7_88f5_4217_ab0b_136b8661103e:
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
  JMP	__ITER__START__3a509575_36dc_4e40_85a7_aa0d57802bb6
  __ITER__END__3a509575_36dc_4e40_85a7_aa0d57802bb6:
  __ITER__START__a09d41ef_894a_4891_8b65_feadf98619b2:
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
  JMP	__ITER__END__a09d41ef_894a_4891_8b65_feadf98619b2
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a98d614a_6cb8_4309_990b_0feaaf46cc94
  BNE	__CMP_YES_a98d614a_6cb8_4309_990b_0feaaf46cc94
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a98d614a_6cb8_4309_990b_0feaaf46cc94
  BNE	__CMP_YES_a98d614a_6cb8_4309_990b_0feaaf46cc94
  JMP	__CMP_YES_a98d614a_6cb8_4309_990b_0feaaf46cc94
  __CMP_YES_a98d614a_6cb8_4309_990b_0feaaf46cc94:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a98d614a_6cb8_4309_990b_0feaaf46cc94
  __CMP_NO_a98d614a_6cb8_4309_990b_0feaaf46cc94:
  SEP	#$20
  LDA	#$00
  __CMP_END_a98d614a_6cb8_4309_990b_0feaaf46cc94:
  BEQ	__IFNOT_e1c2acbe_12fa_418d_8d65_6b26ed3c3f57
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
  __IFNOT_e1c2acbe_12fa_418d_8d65_6b26ed3c3f57:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div32by32@start + 2
  LSR
  STA	__div32by32@start + 2
  REP	#$20
  LDA	__div32by32@start + 0
  ROR
  STA	__div32by32@start + 0
  JMP	__ITER__START__a09d41ef_894a_4891_8b65_feadf98619b2
  __ITER__END__a09d41ef_894a_4891_8b65_feadf98619b2:
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
  __ITER__START__47b53567_59ff_4423_9945_e6e6691e8379:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_a0b1153b_68e3_46ff_9cae_763cf4e98192
  BNE	__CMP_YES_a0b1153b_68e3_46ff_9cae_763cf4e98192
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_a0b1153b_68e3_46ff_9cae_763cf4e98192
  BNE	__CMP_YES_a0b1153b_68e3_46ff_9cae_763cf4e98192
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a0b1153b_68e3_46ff_9cae_763cf4e98192
  BNE	__CMP_YES_a0b1153b_68e3_46ff_9cae_763cf4e98192
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a0b1153b_68e3_46ff_9cae_763cf4e98192
  BNE	__CMP_YES_a0b1153b_68e3_46ff_9cae_763cf4e98192
  JMP	__CMP_NO_a0b1153b_68e3_46ff_9cae_763cf4e98192
  __CMP_YES_a0b1153b_68e3_46ff_9cae_763cf4e98192:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a0b1153b_68e3_46ff_9cae_763cf4e98192
  __CMP_NO_a0b1153b_68e3_46ff_9cae_763cf4e98192:
  SEP	#$20
  LDA	#$00
  __CMP_END_a0b1153b_68e3_46ff_9cae_763cf4e98192:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__47b53567_59ff_4423_9945_e6e6691e8379
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_c002fad7_9ce0_4b32_b9a3_e12c95c053a1
  JMP	__ITER__END__47b53567_59ff_4423_9945_e6e6691e8379
  __IFNOT_c002fad7_9ce0_4b32_b9a3_e12c95c053a1:
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
  JMP	__ITER__START__47b53567_59ff_4423_9945_e6e6691e8379
  __ITER__END__47b53567_59ff_4423_9945_e6e6691e8379:
  __ITER__START__1835e847_f6a7_4b73_858f_8c7bd3e7403a:
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
  JMP	__ITER__END__1835e847_f6a7_4b73_858f_8c7bd3e7403a
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  BNE	__CMP_YES_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  BNE	__CMP_YES_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  BNE	__CMP_YES_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  BNE	__CMP_YES_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  JMP	__CMP_YES_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  __CMP_YES_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941
  __CMP_NO_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941:
  SEP	#$20
  LDA	#$00
  __CMP_END_6ae0b3ab_d497_4a3b_8b7b_ddbc317bc941:
  BEQ	__IFNOT_23e5262f_7687_447f_ac19_66cb8b13443f
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
  __IFNOT_23e5262f_7687_447f_ac19_66cb8b13443f:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div64by32@start + 2
  LSR
  STA	__div64by32@start + 2
  REP	#$20
  LDA	__div64by32@start + 0
  ROR
  STA	__div64by32@start + 0
  JMP	__ITER__START__1835e847_f6a7_4b73_858f_8c7bd3e7403a
  __ITER__END__1835e847_f6a7_4b73_858f_8c7bd3e7403a:
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
  __ITER__START__36363dee_c366_4d09_ab19_1f34a84ee24c:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_c9c419a6_befe_4633_818b_b543a01a0c0f
  BNE	__CMP_YES_c9c419a6_befe_4633_818b_b543a01a0c0f
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_c9c419a6_befe_4633_818b_b543a01a0c0f
  BNE	__CMP_YES_c9c419a6_befe_4633_818b_b543a01a0c0f
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c9c419a6_befe_4633_818b_b543a01a0c0f
  BNE	__CMP_YES_c9c419a6_befe_4633_818b_b543a01a0c0f
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c9c419a6_befe_4633_818b_b543a01a0c0f
  BNE	__CMP_YES_c9c419a6_befe_4633_818b_b543a01a0c0f
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c9c419a6_befe_4633_818b_b543a01a0c0f
  BNE	__CMP_YES_c9c419a6_befe_4633_818b_b543a01a0c0f
  JMP	__CMP_NO_c9c419a6_befe_4633_818b_b543a01a0c0f
  __CMP_YES_c9c419a6_befe_4633_818b_b543a01a0c0f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c9c419a6_befe_4633_818b_b543a01a0c0f
  __CMP_NO_c9c419a6_befe_4633_818b_b543a01a0c0f:
  SEP	#$20
  LDA	#$00
  __CMP_END_c9c419a6_befe_4633_818b_b543a01a0c0f:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__36363dee_c366_4d09_ab19_1f34a84ee24c
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_59c4942e_9d26_4674_813b_07f04cc1027b
  JMP	__ITER__END__36363dee_c366_4d09_ab19_1f34a84ee24c
  __IFNOT_59c4942e_9d26_4674_813b_07f04cc1027b:
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
  JMP	__ITER__START__36363dee_c366_4d09_ab19_1f34a84ee24c
  __ITER__END__36363dee_c366_4d09_ab19_1f34a84ee24c:
  __ITER__START__70cf8b3c_921d_4311_b4c9_ee1fe95301fe:
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
  JMP	__ITER__END__70cf8b3c_921d_4311_b4c9_ee1fe95301fe
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  BNE	__CMP_YES_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  BNE	__CMP_YES_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  BNE	__CMP_YES_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  BNE	__CMP_YES_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  BNE	__CMP_YES_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  JMP	__CMP_YES_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  __CMP_YES_7ee32ee4_e1a8_4104_a695_a58d1fd8391b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7ee32ee4_e1a8_4104_a695_a58d1fd8391b
  __CMP_NO_7ee32ee4_e1a8_4104_a695_a58d1fd8391b:
  SEP	#$20
  LDA	#$00
  __CMP_END_7ee32ee4_e1a8_4104_a695_a58d1fd8391b:
  BEQ	__IFNOT_2f2f2bd3_524c_4b4b_9ea5_828aaa201975
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
  __IFNOT_2f2f2bd3_524c_4b4b_9ea5_828aaa201975:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div8by64@start + 1
  LSR
  STA	__div8by64@start + 1
  SEP	#$20
  LDA	__div8by64@start + 0
  ROR
  STA	__div8by64@start + 0
  JMP	__ITER__START__70cf8b3c_921d_4311_b4c9_ee1fe95301fe
  __ITER__END__70cf8b3c_921d_4311_b4c9_ee1fe95301fe:
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
  __ITER__START__1c8efdd3_f96b_4b9b_80b7_e9433bda2d44:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  BNE	__CMP_YES_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  BNE	__CMP_YES_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  BNE	__CMP_YES_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  BNE	__CMP_YES_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  JMP	__CMP_NO_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  __CMP_YES_61798dc0_9d6c_47a5_9e7b_720298fe33fc:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_61798dc0_9d6c_47a5_9e7b_720298fe33fc
  __CMP_NO_61798dc0_9d6c_47a5_9e7b_720298fe33fc:
  SEP	#$20
  LDA	#$00
  __CMP_END_61798dc0_9d6c_47a5_9e7b_720298fe33fc:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1c8efdd3_f96b_4b9b_80b7_e9433bda2d44
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_6b3e0e99_9aa6_40fd_a709_515f6f874900
  JMP	__ITER__END__1c8efdd3_f96b_4b9b_80b7_e9433bda2d44
  __IFNOT_6b3e0e99_9aa6_40fd_a709_515f6f874900:
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
  JMP	__ITER__START__1c8efdd3_f96b_4b9b_80b7_e9433bda2d44
  __ITER__END__1c8efdd3_f96b_4b9b_80b7_e9433bda2d44:
  __ITER__START__c74ef659_a375_4ffd_8780_36d833894a68:
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
  JMP	__ITER__END__c74ef659_a375_4ffd_8780_36d833894a68
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  BNE	__CMP_YES_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  BNE	__CMP_YES_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  BNE	__CMP_YES_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  BNE	__CMP_YES_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  JMP	__CMP_YES_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  __CMP_YES_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a
  __CMP_NO_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a:
  SEP	#$20
  LDA	#$00
  __CMP_END_c5fa28ce_d4f6_4947_b3ea_0c809cbb5f4a:
  BEQ	__IFNOT_2f6dabcc_957e_4de8_842c_ff88232f6b69
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
  __IFNOT_2f6dabcc_957e_4de8_842c_ff88232f6b69:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div16by64@start + 1
  LSR
  STA	__div16by64@start + 1
  SEP	#$20
  LDA	__div16by64@start + 0
  ROR
  STA	__div16by64@start + 0
  JMP	__ITER__START__c74ef659_a375_4ffd_8780_36d833894a68
  __ITER__END__c74ef659_a375_4ffd_8780_36d833894a68:
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
  __ITER__START__7185c8c4_557d_468a_a803_af88481dcaae:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_daf00149_f968_4d7d_a129_f19230565726
  BNE	__CMP_YES_daf00149_f968_4d7d_a129_f19230565726
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_daf00149_f968_4d7d_a129_f19230565726
  BNE	__CMP_YES_daf00149_f968_4d7d_a129_f19230565726
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_daf00149_f968_4d7d_a129_f19230565726
  BNE	__CMP_YES_daf00149_f968_4d7d_a129_f19230565726
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_daf00149_f968_4d7d_a129_f19230565726
  BNE	__CMP_YES_daf00149_f968_4d7d_a129_f19230565726
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_daf00149_f968_4d7d_a129_f19230565726
  BNE	__CMP_YES_daf00149_f968_4d7d_a129_f19230565726
  JMP	__CMP_NO_daf00149_f968_4d7d_a129_f19230565726
  __CMP_YES_daf00149_f968_4d7d_a129_f19230565726:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_daf00149_f968_4d7d_a129_f19230565726
  __CMP_NO_daf00149_f968_4d7d_a129_f19230565726:
  SEP	#$20
  LDA	#$00
  __CMP_END_daf00149_f968_4d7d_a129_f19230565726:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7185c8c4_557d_468a_a803_af88481dcaae
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_969ca2cc_e5fd_4540_8d5f_4a9625b2b22c
  JMP	__ITER__END__7185c8c4_557d_468a_a803_af88481dcaae
  __IFNOT_969ca2cc_e5fd_4540_8d5f_4a9625b2b22c:
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
  JMP	__ITER__START__7185c8c4_557d_468a_a803_af88481dcaae
  __ITER__END__7185c8c4_557d_468a_a803_af88481dcaae:
  __ITER__START__f791cc3e_5220_4add_b968_b76a40cd948f:
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
  JMP	__ITER__END__f791cc3e_5220_4add_b968_b76a40cd948f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  BNE	__CMP_YES_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  BNE	__CMP_YES_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  BNE	__CMP_YES_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  BNE	__CMP_YES_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  BNE	__CMP_YES_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  JMP	__CMP_YES_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  __CMP_YES_b008a94b_3a0e_4762_b0b9_0b0131cfabd3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b008a94b_3a0e_4762_b0b9_0b0131cfabd3
  __CMP_NO_b008a94b_3a0e_4762_b0b9_0b0131cfabd3:
  SEP	#$20
  LDA	#$00
  __CMP_END_b008a94b_3a0e_4762_b0b9_0b0131cfabd3:
  BEQ	__IFNOT_1ca810d3_5444_4fab_b524_5f10bd60229d
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
  __IFNOT_1ca810d3_5444_4fab_b524_5f10bd60229d:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div24by64@start + 1
  LSR
  STA	__div24by64@start + 1
  SEP	#$20
  LDA	__div24by64@start + 0
  ROR
  STA	__div24by64@start + 0
  JMP	__ITER__START__f791cc3e_5220_4add_b968_b76a40cd948f
  __ITER__END__f791cc3e_5220_4add_b968_b76a40cd948f:
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
  __ITER__START__761e9e6f_88eb_43ce_8c53_3c2b30c4bcf7:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_d16775fc_4468_4055_9c0f_8f4214e65fe2
  BNE	__CMP_YES_d16775fc_4468_4055_9c0f_8f4214e65fe2
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_d16775fc_4468_4055_9c0f_8f4214e65fe2
  BNE	__CMP_YES_d16775fc_4468_4055_9c0f_8f4214e65fe2
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d16775fc_4468_4055_9c0f_8f4214e65fe2
  BNE	__CMP_YES_d16775fc_4468_4055_9c0f_8f4214e65fe2
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d16775fc_4468_4055_9c0f_8f4214e65fe2
  BNE	__CMP_YES_d16775fc_4468_4055_9c0f_8f4214e65fe2
  JMP	__CMP_NO_d16775fc_4468_4055_9c0f_8f4214e65fe2
  __CMP_YES_d16775fc_4468_4055_9c0f_8f4214e65fe2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d16775fc_4468_4055_9c0f_8f4214e65fe2
  __CMP_NO_d16775fc_4468_4055_9c0f_8f4214e65fe2:
  SEP	#$20
  LDA	#$00
  __CMP_END_d16775fc_4468_4055_9c0f_8f4214e65fe2:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__761e9e6f_88eb_43ce_8c53_3c2b30c4bcf7
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_3d7bdd95_760c_49d0_bded_4aa6bd87427f
  JMP	__ITER__END__761e9e6f_88eb_43ce_8c53_3c2b30c4bcf7
  __IFNOT_3d7bdd95_760c_49d0_bded_4aa6bd87427f:
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
  JMP	__ITER__START__761e9e6f_88eb_43ce_8c53_3c2b30c4bcf7
  __ITER__END__761e9e6f_88eb_43ce_8c53_3c2b30c4bcf7:
  __ITER__START__cd97fd1b_0aa0_4725_8afd_72c8dbc5a116:
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
  JMP	__ITER__END__cd97fd1b_0aa0_4725_8afd_72c8dbc5a116
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  BNE	__CMP_YES_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  BNE	__CMP_YES_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  BNE	__CMP_YES_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  BNE	__CMP_YES_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  JMP	__CMP_YES_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  __CMP_YES_a0593d44_a524_4b62_8bdf_9ba839bd1c07:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a0593d44_a524_4b62_8bdf_9ba839bd1c07
  __CMP_NO_a0593d44_a524_4b62_8bdf_9ba839bd1c07:
  SEP	#$20
  LDA	#$00
  __CMP_END_a0593d44_a524_4b62_8bdf_9ba839bd1c07:
  BEQ	__IFNOT_07f78791_31fb_49e7_9e0f_6093c69aaef3
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
  __IFNOT_07f78791_31fb_49e7_9e0f_6093c69aaef3:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div32by64@start + 2
  LSR
  STA	__div32by64@start + 2
  REP	#$20
  LDA	__div32by64@start + 0
  ROR
  STA	__div32by64@start + 0
  JMP	__ITER__START__cd97fd1b_0aa0_4725_8afd_72c8dbc5a116
  __ITER__END__cd97fd1b_0aa0_4725_8afd_72c8dbc5a116:
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
  __ITER__START__2d5e1884_3385_4151_868a_1954fd314895:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  BNE	__CMP_YES_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  BNE	__CMP_YES_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  BNE	__CMP_YES_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  BNE	__CMP_YES_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  JMP	__CMP_NO_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  __CMP_YES_4bea6b82_1dbc_4023_928b_ca5c12eb6a98:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4bea6b82_1dbc_4023_928b_ca5c12eb6a98
  __CMP_NO_4bea6b82_1dbc_4023_928b_ca5c12eb6a98:
  SEP	#$20
  LDA	#$00
  __CMP_END_4bea6b82_1dbc_4023_928b_ca5c12eb6a98:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__2d5e1884_3385_4151_868a_1954fd314895
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_2fa651e4_7cda_4755_a7e0_656c3f1fd08f
  JMP	__ITER__END__2d5e1884_3385_4151_868a_1954fd314895
  __IFNOT_2fa651e4_7cda_4755_a7e0_656c3f1fd08f:
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
  JMP	__ITER__START__2d5e1884_3385_4151_868a_1954fd314895
  __ITER__END__2d5e1884_3385_4151_868a_1954fd314895:
  __ITER__START__b73db744_a6b2_4561_b3dd_b6f1b9e63f4e:
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
  JMP	__ITER__END__b73db744_a6b2_4561_b3dd_b6f1b9e63f4e
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_1b838448_cc4c_4fdd_ae96_4fbe19851896
  BNE	__CMP_YES_1b838448_cc4c_4fdd_ae96_4fbe19851896
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_1b838448_cc4c_4fdd_ae96_4fbe19851896
  BNE	__CMP_YES_1b838448_cc4c_4fdd_ae96_4fbe19851896
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_1b838448_cc4c_4fdd_ae96_4fbe19851896
  BNE	__CMP_YES_1b838448_cc4c_4fdd_ae96_4fbe19851896
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1b838448_cc4c_4fdd_ae96_4fbe19851896
  BNE	__CMP_YES_1b838448_cc4c_4fdd_ae96_4fbe19851896
  JMP	__CMP_YES_1b838448_cc4c_4fdd_ae96_4fbe19851896
  __CMP_YES_1b838448_cc4c_4fdd_ae96_4fbe19851896:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1b838448_cc4c_4fdd_ae96_4fbe19851896
  __CMP_NO_1b838448_cc4c_4fdd_ae96_4fbe19851896:
  SEP	#$20
  LDA	#$00
  __CMP_END_1b838448_cc4c_4fdd_ae96_4fbe19851896:
  BNE	:+
  JMP	__IFNOT_2092eb16_ac88_4ed3_9101_2ee303015720
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
  __IFNOT_2092eb16_ac88_4ed3_9101_2ee303015720:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div64by64@start + 6
  LSR
  STA	__div64by64@start + 6
  REP	#$20
  LDA	__div64by64@start + 4
  ROR
  STA	__div64by64@start + 4
  REP	#$20
  LDA	__div64by64@start + 2
  ROR
  STA	__div64by64@start + 2
  REP	#$20
  LDA	__div64by64@start + 0
  ROR
  STA	__div64by64@start + 0
  JMP	__ITER__START__b73db744_a6b2_4561_b3dd_b6f1b9e63f4e
  __ITER__END__b73db744_a6b2_4561_b3dd_b6f1b9e63f4e:
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
  __ITER__START__720fe348_f467_4f5f_915e_9b14a11bebf0:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2b7a5248_a8e1_40fa_bfd6_bf5744a51313
  BNE	__CMP_YES_2b7a5248_a8e1_40fa_bfd6_bf5744a51313
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2b7a5248_a8e1_40fa_bfd6_bf5744a51313
  BNE	__CMP_YES_2b7a5248_a8e1_40fa_bfd6_bf5744a51313
  JMP	__CMP_NO_2b7a5248_a8e1_40fa_bfd6_bf5744a51313
  __CMP_YES_2b7a5248_a8e1_40fa_bfd6_bf5744a51313:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2b7a5248_a8e1_40fa_bfd6_bf5744a51313
  __CMP_NO_2b7a5248_a8e1_40fa_bfd6_bf5744a51313:
  SEP	#$20
  LDA	#$00
  __CMP_END_2b7a5248_a8e1_40fa_bfd6_bf5744a51313:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__720fe348_f467_4f5f_915e_9b14a11bebf0
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
  BNE	__IFNOT_2b6fef88_8e14_40fb_886b_428ce9a39fa9
  JMP	__ITER__END__720fe348_f467_4f5f_915e_9b14a11bebf0
  __IFNOT_2b6fef88_8e14_40fb_886b_428ce9a39fa9:
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
  JMP	__ITER__START__720fe348_f467_4f5f_915e_9b14a11bebf0
  __ITER__END__720fe348_f467_4f5f_915e_9b14a11bebf0:
  __ITER__START__ecb02dd2_3d7e_404a_9f55_90189349b48c:
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
  JMP	__ITER__END__ecb02dd2_3d7e_404a_9f55_90189349b48c
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1
  BNE	__CMP_YES_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1
  BNE	__CMP_YES_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1
  JMP	__CMP_YES_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1
  __CMP_YES_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1
  __CMP_NO_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1:
  SEP	#$20
  LDA	#$00
  __CMP_END_8dc69c90_b4dc_4119_a9e7_ba38ac427bc1:
  BEQ	__IFNOT_26baf0dc_8b61_44fa_8346_0f3d47980cf0
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
  __IFNOT_26baf0dc_8b61_44fa_8346_0f3d47980cf0:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod8by16@start + 1
  LSR
  STA	__mod8by16@start + 1
  SEP	#$20
  LDA	__mod8by16@start + 0
  ROR
  STA	__mod8by16@start + 0
  JMP	__ITER__START__ecb02dd2_3d7e_404a_9f55_90189349b48c
  __ITER__END__ecb02dd2_3d7e_404a_9f55_90189349b48c:
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
  __ITER__START__3f795fa1_5dd7_4f18_b3a0_b2f50e461d2d:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a641c5d5_422a_44f3_90bb_cf9e609e5682
  BNE	__CMP_YES_a641c5d5_422a_44f3_90bb_cf9e609e5682
  JMP	__CMP_NO_a641c5d5_422a_44f3_90bb_cf9e609e5682
  __CMP_YES_a641c5d5_422a_44f3_90bb_cf9e609e5682:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a641c5d5_422a_44f3_90bb_cf9e609e5682
  __CMP_NO_a641c5d5_422a_44f3_90bb_cf9e609e5682:
  SEP	#$20
  LDA	#$00
  __CMP_END_a641c5d5_422a_44f3_90bb_cf9e609e5682:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__3f795fa1_5dd7_4f18_b3a0_b2f50e461d2d
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
  BNE	__IFNOT_2388559c_6a59_4f69_97c6_500a5fb6704a
  JMP	__ITER__END__3f795fa1_5dd7_4f18_b3a0_b2f50e461d2d
  __IFNOT_2388559c_6a59_4f69_97c6_500a5fb6704a:
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
  JMP	__ITER__START__3f795fa1_5dd7_4f18_b3a0_b2f50e461d2d
  __ITER__END__3f795fa1_5dd7_4f18_b3a0_b2f50e461d2d:
  __ITER__START__a7e5a7c4_0433_43a4_bfcc_d2bfd787cd4e:
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
  JMP	__ITER__END__a7e5a7c4_0433_43a4_bfcc_d2bfd787cd4e
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_59d3f3e7_c5aa_4035_a4f8_cd0619b012d1
  BNE	__CMP_YES_59d3f3e7_c5aa_4035_a4f8_cd0619b012d1
  JMP	__CMP_YES_59d3f3e7_c5aa_4035_a4f8_cd0619b012d1
  __CMP_YES_59d3f3e7_c5aa_4035_a4f8_cd0619b012d1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_59d3f3e7_c5aa_4035_a4f8_cd0619b012d1
  __CMP_NO_59d3f3e7_c5aa_4035_a4f8_cd0619b012d1:
  SEP	#$20
  LDA	#$00
  __CMP_END_59d3f3e7_c5aa_4035_a4f8_cd0619b012d1:
  BEQ	__IFNOT_451fc14f_221e_49e4_a6ff_89e73d7e9647
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
  __IFNOT_451fc14f_221e_49e4_a6ff_89e73d7e9647:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod16by16@start + 1
  LSR
  STA	__mod16by16@start + 1
  SEP	#$20
  LDA	__mod16by16@start + 0
  ROR
  STA	__mod16by16@start + 0
  JMP	__ITER__START__a7e5a7c4_0433_43a4_bfcc_d2bfd787cd4e
  __ITER__END__a7e5a7c4_0433_43a4_bfcc_d2bfd787cd4e:
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
  __ITER__START__33cf647f_c89d_4c73_b133_e988e7613cdd:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3
  BNE	__CMP_YES_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3
  BNE	__CMP_YES_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3
  JMP	__CMP_NO_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3
  __CMP_YES_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3
  __CMP_NO_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3:
  SEP	#$20
  LDA	#$00
  __CMP_END_ecf9bf21_e16b_45f3_a3aa_ca880e8c70b3:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__33cf647f_c89d_4c73_b133_e988e7613cdd
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
  BNE	__IFNOT_010fae5a_6015_4e15_9a37_5db93c5a06a5
  JMP	__ITER__END__33cf647f_c89d_4c73_b133_e988e7613cdd
  __IFNOT_010fae5a_6015_4e15_9a37_5db93c5a06a5:
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
  JMP	__ITER__START__33cf647f_c89d_4c73_b133_e988e7613cdd
  __ITER__END__33cf647f_c89d_4c73_b133_e988e7613cdd:
  __ITER__START__08a3a78a_004e_4641_8912_e7f1766ef9f7:
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
  JMP	__ITER__END__08a3a78a_004e_4641_8912_e7f1766ef9f7
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_2a661c67_12d4_491e_891a_9be39131cb44
  BNE	__CMP_YES_2a661c67_12d4_491e_891a_9be39131cb44
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2a661c67_12d4_491e_891a_9be39131cb44
  BNE	__CMP_YES_2a661c67_12d4_491e_891a_9be39131cb44
  JMP	__CMP_YES_2a661c67_12d4_491e_891a_9be39131cb44
  __CMP_YES_2a661c67_12d4_491e_891a_9be39131cb44:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2a661c67_12d4_491e_891a_9be39131cb44
  __CMP_NO_2a661c67_12d4_491e_891a_9be39131cb44:
  SEP	#$20
  LDA	#$00
  __CMP_END_2a661c67_12d4_491e_891a_9be39131cb44:
  BEQ	__IFNOT_4d242c4b_cec0_499b_bc68_c5a9e3e31330
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
  __IFNOT_4d242c4b_cec0_499b_bc68_c5a9e3e31330:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod24by16@start + 1
  LSR
  STA	__mod24by16@start + 1
  SEP	#$20
  LDA	__mod24by16@start + 0
  ROR
  STA	__mod24by16@start + 0
  JMP	__ITER__START__08a3a78a_004e_4641_8912_e7f1766ef9f7
  __ITER__END__08a3a78a_004e_4641_8912_e7f1766ef9f7:
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
  __ITER__START__cb48dd20_8cef_4321_b7bc_b969bda9de4c:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_54c1056c_9906_40b5_ad7b_c8e72641ff76
  BNE	__CMP_YES_54c1056c_9906_40b5_ad7b_c8e72641ff76
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_54c1056c_9906_40b5_ad7b_c8e72641ff76
  BNE	__CMP_YES_54c1056c_9906_40b5_ad7b_c8e72641ff76
  JMP	__CMP_NO_54c1056c_9906_40b5_ad7b_c8e72641ff76
  __CMP_YES_54c1056c_9906_40b5_ad7b_c8e72641ff76:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_54c1056c_9906_40b5_ad7b_c8e72641ff76
  __CMP_NO_54c1056c_9906_40b5_ad7b_c8e72641ff76:
  SEP	#$20
  LDA	#$00
  __CMP_END_54c1056c_9906_40b5_ad7b_c8e72641ff76:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__cb48dd20_8cef_4321_b7bc_b969bda9de4c
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
  BNE	__IFNOT_732129bd_a538_42e8_9a5e_0b24bf040940
  JMP	__ITER__END__cb48dd20_8cef_4321_b7bc_b969bda9de4c
  __IFNOT_732129bd_a538_42e8_9a5e_0b24bf040940:
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
  JMP	__ITER__START__cb48dd20_8cef_4321_b7bc_b969bda9de4c
  __ITER__END__cb48dd20_8cef_4321_b7bc_b969bda9de4c:
  __ITER__START__55350cd0_f7a7_4662_b6d9_450bfe091aea:
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
  JMP	__ITER__END__55350cd0_f7a7_4662_b6d9_450bfe091aea
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_a3d74803_46e4_420e_bdb4_aac89653dcb3
  BNE	__CMP_YES_a3d74803_46e4_420e_bdb4_aac89653dcb3
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a3d74803_46e4_420e_bdb4_aac89653dcb3
  BNE	__CMP_YES_a3d74803_46e4_420e_bdb4_aac89653dcb3
  JMP	__CMP_YES_a3d74803_46e4_420e_bdb4_aac89653dcb3
  __CMP_YES_a3d74803_46e4_420e_bdb4_aac89653dcb3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a3d74803_46e4_420e_bdb4_aac89653dcb3
  __CMP_NO_a3d74803_46e4_420e_bdb4_aac89653dcb3:
  SEP	#$20
  LDA	#$00
  __CMP_END_a3d74803_46e4_420e_bdb4_aac89653dcb3:
  BEQ	__IFNOT_ddfa3e43_dc7d_4c79_b870_d1e683f297eb
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
  __IFNOT_ddfa3e43_dc7d_4c79_b870_d1e683f297eb:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod32by16@start + 1
  LSR
  STA	__mod32by16@start + 1
  SEP	#$20
  LDA	__mod32by16@start + 0
  ROR
  STA	__mod32by16@start + 0
  JMP	__ITER__START__55350cd0_f7a7_4662_b6d9_450bfe091aea
  __ITER__END__55350cd0_f7a7_4662_b6d9_450bfe091aea:
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
  __ITER__START__13205e22_71bf_43d7_a0ff_996841c419be:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  BNE	__CMP_YES_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  BNE	__CMP_YES_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  BNE	__CMP_YES_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  BNE	__CMP_YES_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  JMP	__CMP_NO_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  __CMP_YES_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c
  __CMP_NO_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c:
  SEP	#$20
  LDA	#$00
  __CMP_END_cbb3b79d_3e94_4bdd_9ee5_d6991e4e7b2c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__13205e22_71bf_43d7_a0ff_996841c419be
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
  BNE	__IFNOT_b09ae630_36c9_43fd_a8b8_a876907e9fa3
  JMP	__ITER__END__13205e22_71bf_43d7_a0ff_996841c419be
  __IFNOT_b09ae630_36c9_43fd_a8b8_a876907e9fa3:
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
  JMP	__ITER__START__13205e22_71bf_43d7_a0ff_996841c419be
  __ITER__END__13205e22_71bf_43d7_a0ff_996841c419be:
  __ITER__START__4e78516a_bd81_49a1_a324_5390dd0d2ce4:
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
  JMP	__ITER__END__4e78516a_bd81_49a1_a324_5390dd0d2ce4
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  BNE	__CMP_YES_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  BNE	__CMP_YES_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  BNE	__CMP_YES_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  BNE	__CMP_YES_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  JMP	__CMP_YES_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  __CMP_YES_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a
  __CMP_NO_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a:
  SEP	#$20
  LDA	#$00
  __CMP_END_fbfc8ad7_aa7f_491a_be87_7b8eb05ca52a:
  BEQ	__IFNOT_da4c573e_b7f4_4832_9cb4_9ec6cd59fba1
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
  __IFNOT_da4c573e_b7f4_4832_9cb4_9ec6cd59fba1:
  REP	#$20
  LDA	__@specSubY + 0
  LSR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod64by16@start + 1
  LSR
  STA	__mod64by16@start + 1
  SEP	#$20
  LDA	__mod64by16@start + 0
  ROR
  STA	__mod64by16@start + 0
  JMP	__ITER__START__4e78516a_bd81_49a1_a324_5390dd0d2ce4
  __ITER__END__4e78516a_bd81_49a1_a324_5390dd0d2ce4:
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
  __ITER__START__926b0bf7_0edb_4cb0_9626_b2057c3f4065:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b0971193_f593_43de_a584_11451c7b9249
  BNE	__CMP_YES_b0971193_f593_43de_a584_11451c7b9249
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b0971193_f593_43de_a584_11451c7b9249
  BNE	__CMP_YES_b0971193_f593_43de_a584_11451c7b9249
  JMP	__CMP_NO_b0971193_f593_43de_a584_11451c7b9249
  __CMP_YES_b0971193_f593_43de_a584_11451c7b9249:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b0971193_f593_43de_a584_11451c7b9249
  __CMP_NO_b0971193_f593_43de_a584_11451c7b9249:
  SEP	#$20
  LDA	#$00
  __CMP_END_b0971193_f593_43de_a584_11451c7b9249:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__926b0bf7_0edb_4cb0_9626_b2057c3f4065
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
  BNE	__IFNOT_940ac6ba_3be8_49dc_99a2_1f9ffd95177c
  JMP	__ITER__END__926b0bf7_0edb_4cb0_9626_b2057c3f4065
  __IFNOT_940ac6ba_3be8_49dc_99a2_1f9ffd95177c:
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
  JMP	__ITER__START__926b0bf7_0edb_4cb0_9626_b2057c3f4065
  __ITER__END__926b0bf7_0edb_4cb0_9626_b2057c3f4065:
  __ITER__START__e7a9f389_1356_4009_b2b7_9300c081c43d:
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
  JMP	__ITER__END__e7a9f389_1356_4009_b2b7_9300c081c43d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_3d6af13a_79c8_47a1_8070_7634fa9fad3b
  BNE	__CMP_YES_3d6af13a_79c8_47a1_8070_7634fa9fad3b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3d6af13a_79c8_47a1_8070_7634fa9fad3b
  BNE	__CMP_YES_3d6af13a_79c8_47a1_8070_7634fa9fad3b
  JMP	__CMP_YES_3d6af13a_79c8_47a1_8070_7634fa9fad3b
  __CMP_YES_3d6af13a_79c8_47a1_8070_7634fa9fad3b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3d6af13a_79c8_47a1_8070_7634fa9fad3b
  __CMP_NO_3d6af13a_79c8_47a1_8070_7634fa9fad3b:
  SEP	#$20
  LDA	#$00
  __CMP_END_3d6af13a_79c8_47a1_8070_7634fa9fad3b:
  BEQ	__IFNOT_22eb6437_d9fa_40b9_ac73_0f80f8330f70
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
  __IFNOT_22eb6437_d9fa_40b9_ac73_0f80f8330f70:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod8by24@start + 1
  LSR
  STA	__mod8by24@start + 1
  SEP	#$20
  LDA	__mod8by24@start + 0
  ROR
  STA	__mod8by24@start + 0
  JMP	__ITER__START__e7a9f389_1356_4009_b2b7_9300c081c43d
  __ITER__END__e7a9f389_1356_4009_b2b7_9300c081c43d:
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
  __ITER__START__18f35335_c981_4df9_97b7_714f338353f4:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e
  BNE	__CMP_YES_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e
  BNE	__CMP_YES_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e
  JMP	__CMP_NO_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e
  __CMP_YES_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e
  __CMP_NO_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e:
  SEP	#$20
  LDA	#$00
  __CMP_END_0dd8b092_df7f_4e33_a1fe_f1a01f375a5e:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__18f35335_c981_4df9_97b7_714f338353f4
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
  BNE	__IFNOT_d75ecc1d_a11e_4fed_9363_bec819aa4f3b
  JMP	__ITER__END__18f35335_c981_4df9_97b7_714f338353f4
  __IFNOT_d75ecc1d_a11e_4fed_9363_bec819aa4f3b:
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
  JMP	__ITER__START__18f35335_c981_4df9_97b7_714f338353f4
  __ITER__END__18f35335_c981_4df9_97b7_714f338353f4:
  __ITER__START__226e7e24_1a14_4d5d_a5a0_b5d1e4d3ada8:
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
  JMP	__ITER__END__226e7e24_1a14_4d5d_a5a0_b5d1e4d3ada8
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_df846d71_ff33_491c_b3b7_e7dc4560423b
  BNE	__CMP_YES_df846d71_ff33_491c_b3b7_e7dc4560423b
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_df846d71_ff33_491c_b3b7_e7dc4560423b
  BNE	__CMP_YES_df846d71_ff33_491c_b3b7_e7dc4560423b
  JMP	__CMP_YES_df846d71_ff33_491c_b3b7_e7dc4560423b
  __CMP_YES_df846d71_ff33_491c_b3b7_e7dc4560423b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_df846d71_ff33_491c_b3b7_e7dc4560423b
  __CMP_NO_df846d71_ff33_491c_b3b7_e7dc4560423b:
  SEP	#$20
  LDA	#$00
  __CMP_END_df846d71_ff33_491c_b3b7_e7dc4560423b:
  BEQ	__IFNOT_5fcc2395_e0ba_4691_807d_32bc9d85d269
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
  __IFNOT_5fcc2395_e0ba_4691_807d_32bc9d85d269:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod16by24@start + 1
  LSR
  STA	__mod16by24@start + 1
  SEP	#$20
  LDA	__mod16by24@start + 0
  ROR
  STA	__mod16by24@start + 0
  JMP	__ITER__START__226e7e24_1a14_4d5d_a5a0_b5d1e4d3ada8
  __ITER__END__226e7e24_1a14_4d5d_a5a0_b5d1e4d3ada8:
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
  __ITER__START__5a29d1c4_d293_40a4_bea1_c2861d307712:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a652bbd5_cee2_4eab_b0ad_105d6e51432c
  BNE	__CMP_YES_a652bbd5_cee2_4eab_b0ad_105d6e51432c
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a652bbd5_cee2_4eab_b0ad_105d6e51432c
  BNE	__CMP_YES_a652bbd5_cee2_4eab_b0ad_105d6e51432c
  JMP	__CMP_NO_a652bbd5_cee2_4eab_b0ad_105d6e51432c
  __CMP_YES_a652bbd5_cee2_4eab_b0ad_105d6e51432c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a652bbd5_cee2_4eab_b0ad_105d6e51432c
  __CMP_NO_a652bbd5_cee2_4eab_b0ad_105d6e51432c:
  SEP	#$20
  LDA	#$00
  __CMP_END_a652bbd5_cee2_4eab_b0ad_105d6e51432c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5a29d1c4_d293_40a4_bea1_c2861d307712
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
  BNE	__IFNOT_c800db99_159e_46bd_8769_b0ef74a8030e
  JMP	__ITER__END__5a29d1c4_d293_40a4_bea1_c2861d307712
  __IFNOT_c800db99_159e_46bd_8769_b0ef74a8030e:
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
  JMP	__ITER__START__5a29d1c4_d293_40a4_bea1_c2861d307712
  __ITER__END__5a29d1c4_d293_40a4_bea1_c2861d307712:
  __ITER__START__00492b92_3064_4769_8946_a4444a7234b5:
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
  JMP	__ITER__END__00492b92_3064_4769_8946_a4444a7234b5
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_665a5aad_538b_43ec_8472_bbf24fdd813e
  BNE	__CMP_YES_665a5aad_538b_43ec_8472_bbf24fdd813e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_665a5aad_538b_43ec_8472_bbf24fdd813e
  BNE	__CMP_YES_665a5aad_538b_43ec_8472_bbf24fdd813e
  JMP	__CMP_YES_665a5aad_538b_43ec_8472_bbf24fdd813e
  __CMP_YES_665a5aad_538b_43ec_8472_bbf24fdd813e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_665a5aad_538b_43ec_8472_bbf24fdd813e
  __CMP_NO_665a5aad_538b_43ec_8472_bbf24fdd813e:
  SEP	#$20
  LDA	#$00
  __CMP_END_665a5aad_538b_43ec_8472_bbf24fdd813e:
  BEQ	__IFNOT_2c0b84f0_0e36_4090_a7f7_d85025887ba7
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
  __IFNOT_2c0b84f0_0e36_4090_a7f7_d85025887ba7:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod24by24@start + 1
  LSR
  STA	__mod24by24@start + 1
  SEP	#$20
  LDA	__mod24by24@start + 0
  ROR
  STA	__mod24by24@start + 0
  JMP	__ITER__START__00492b92_3064_4769_8946_a4444a7234b5
  __ITER__END__00492b92_3064_4769_8946_a4444a7234b5:
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
  __ITER__START__d0efefa7_f009_4c50_a04f_5d5e2dd144f4:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_ccad99d7_e8cf_4a44_9055_b2ac19871ea5
  BNE	__CMP_YES_ccad99d7_e8cf_4a44_9055_b2ac19871ea5
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ccad99d7_e8cf_4a44_9055_b2ac19871ea5
  BNE	__CMP_YES_ccad99d7_e8cf_4a44_9055_b2ac19871ea5
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ccad99d7_e8cf_4a44_9055_b2ac19871ea5
  BNE	__CMP_YES_ccad99d7_e8cf_4a44_9055_b2ac19871ea5
  JMP	__CMP_NO_ccad99d7_e8cf_4a44_9055_b2ac19871ea5
  __CMP_YES_ccad99d7_e8cf_4a44_9055_b2ac19871ea5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ccad99d7_e8cf_4a44_9055_b2ac19871ea5
  __CMP_NO_ccad99d7_e8cf_4a44_9055_b2ac19871ea5:
  SEP	#$20
  LDA	#$00
  __CMP_END_ccad99d7_e8cf_4a44_9055_b2ac19871ea5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d0efefa7_f009_4c50_a04f_5d5e2dd144f4
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
  BNE	__IFNOT_d4dbdd37_1163_452b_a399_320b9dcd9dd3
  JMP	__ITER__END__d0efefa7_f009_4c50_a04f_5d5e2dd144f4
  __IFNOT_d4dbdd37_1163_452b_a399_320b9dcd9dd3:
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
  JMP	__ITER__START__d0efefa7_f009_4c50_a04f_5d5e2dd144f4
  __ITER__END__d0efefa7_f009_4c50_a04f_5d5e2dd144f4:
  __ITER__START__b37167be_b057_42c4_9035_b9127171a1ce:
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
  JMP	__ITER__END__b37167be_b057_42c4_9035_b9127171a1ce
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_d464ea4c_cbbe_45f4_a26f_06069e22503e
  BNE	__CMP_YES_d464ea4c_cbbe_45f4_a26f_06069e22503e
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d464ea4c_cbbe_45f4_a26f_06069e22503e
  BNE	__CMP_YES_d464ea4c_cbbe_45f4_a26f_06069e22503e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d464ea4c_cbbe_45f4_a26f_06069e22503e
  BNE	__CMP_YES_d464ea4c_cbbe_45f4_a26f_06069e22503e
  JMP	__CMP_YES_d464ea4c_cbbe_45f4_a26f_06069e22503e
  __CMP_YES_d464ea4c_cbbe_45f4_a26f_06069e22503e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d464ea4c_cbbe_45f4_a26f_06069e22503e
  __CMP_NO_d464ea4c_cbbe_45f4_a26f_06069e22503e:
  SEP	#$20
  LDA	#$00
  __CMP_END_d464ea4c_cbbe_45f4_a26f_06069e22503e:
  BEQ	__IFNOT_1df64ca3_8ffa_47f5_afcb_4f5543575027
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
  __IFNOT_1df64ca3_8ffa_47f5_afcb_4f5543575027:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod32by24@start + 1
  LSR
  STA	__mod32by24@start + 1
  SEP	#$20
  LDA	__mod32by24@start + 0
  ROR
  STA	__mod32by24@start + 0
  JMP	__ITER__START__b37167be_b057_42c4_9035_b9127171a1ce
  __ITER__END__b37167be_b057_42c4_9035_b9127171a1ce:
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
  __ITER__START__90d3cfa8_7ed5_4d33_a199_70e79bb3d8d9:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  BNE	__CMP_YES_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  BNE	__CMP_YES_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  BNE	__CMP_YES_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  BNE	__CMP_YES_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  BNE	__CMP_YES_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  JMP	__CMP_NO_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  __CMP_YES_0873c9c1_6a4c_4a84_b954_48a673b84f2e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0873c9c1_6a4c_4a84_b954_48a673b84f2e
  __CMP_NO_0873c9c1_6a4c_4a84_b954_48a673b84f2e:
  SEP	#$20
  LDA	#$00
  __CMP_END_0873c9c1_6a4c_4a84_b954_48a673b84f2e:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__90d3cfa8_7ed5_4d33_a199_70e79bb3d8d9
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
  BNE	__IFNOT_2c3e5c7a_8090_4632_bb9b_24a0b37858e5
  JMP	__ITER__END__90d3cfa8_7ed5_4d33_a199_70e79bb3d8d9
  __IFNOT_2c3e5c7a_8090_4632_bb9b_24a0b37858e5:
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
  JMP	__ITER__START__90d3cfa8_7ed5_4d33_a199_70e79bb3d8d9
  __ITER__END__90d3cfa8_7ed5_4d33_a199_70e79bb3d8d9:
  __ITER__START__903127ed_7927_4e01_ab1b_f949fa01c709:
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
  JMP	__ITER__END__903127ed_7927_4e01_ab1b_f949fa01c709
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  BNE	__CMP_YES_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  BNE	__CMP_YES_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  BNE	__CMP_YES_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  BNE	__CMP_YES_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  BNE	__CMP_YES_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  JMP	__CMP_YES_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  __CMP_YES_a9519a47_1ee8_4184_9d09_aed3fe3447cc:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a9519a47_1ee8_4184_9d09_aed3fe3447cc
  __CMP_NO_a9519a47_1ee8_4184_9d09_aed3fe3447cc:
  SEP	#$20
  LDA	#$00
  __CMP_END_a9519a47_1ee8_4184_9d09_aed3fe3447cc:
  BNE	:+
  JMP	__IFNOT_9093929b_2792_42ff_b341_ab5bb683d559
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
  __IFNOT_9093929b_2792_42ff_b341_ab5bb683d559:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 1
  LSR
  STA	__@specSubY + 1
  SEP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod64by24@start + 1
  LSR
  STA	__mod64by24@start + 1
  SEP	#$20
  LDA	__mod64by24@start + 0
  ROR
  STA	__mod64by24@start + 0
  JMP	__ITER__START__903127ed_7927_4e01_ab1b_f949fa01c709
  __ITER__END__903127ed_7927_4e01_ab1b_f949fa01c709:
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
  __ITER__START__b6ed9b48_e8e3_4539_9f5b_917249cfcde0:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5cf06f83_cb46_4749_8964_d887d02426d2
  BNE	__CMP_YES_5cf06f83_cb46_4749_8964_d887d02426d2
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_5cf06f83_cb46_4749_8964_d887d02426d2
  BNE	__CMP_YES_5cf06f83_cb46_4749_8964_d887d02426d2
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5cf06f83_cb46_4749_8964_d887d02426d2
  BNE	__CMP_YES_5cf06f83_cb46_4749_8964_d887d02426d2
  JMP	__CMP_NO_5cf06f83_cb46_4749_8964_d887d02426d2
  __CMP_YES_5cf06f83_cb46_4749_8964_d887d02426d2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5cf06f83_cb46_4749_8964_d887d02426d2
  __CMP_NO_5cf06f83_cb46_4749_8964_d887d02426d2:
  SEP	#$20
  LDA	#$00
  __CMP_END_5cf06f83_cb46_4749_8964_d887d02426d2:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b6ed9b48_e8e3_4539_9f5b_917249cfcde0
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_cf2d86fe_87dd_4462_be9d_68750a9f2295
  JMP	__ITER__END__b6ed9b48_e8e3_4539_9f5b_917249cfcde0
  __IFNOT_cf2d86fe_87dd_4462_be9d_68750a9f2295:
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
  JMP	__ITER__START__b6ed9b48_e8e3_4539_9f5b_917249cfcde0
  __ITER__END__b6ed9b48_e8e3_4539_9f5b_917249cfcde0:
  __ITER__START__93fec1eb_71c6_4f13_9860_e66aae8646ca:
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
  JMP	__ITER__END__93fec1eb_71c6_4f13_9860_e66aae8646ca
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e
  BNE	__CMP_YES_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e
  BNE	__CMP_YES_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e
  BNE	__CMP_YES_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e
  JMP	__CMP_YES_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e
  __CMP_YES_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e
  __CMP_NO_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e:
  SEP	#$20
  LDA	#$00
  __CMP_END_7819f8a2_1dce_4f09_84a6_c9f7ffed6e7e:
  BEQ	__IFNOT_2bd4d6d1_20d4_4282_966d_210861af5370
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
  __IFNOT_2bd4d6d1_20d4_4282_966d_210861af5370:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod8by32@start + 1
  LSR
  STA	__mod8by32@start + 1
  SEP	#$20
  LDA	__mod8by32@start + 0
  ROR
  STA	__mod8by32@start + 0
  JMP	__ITER__START__93fec1eb_71c6_4f13_9860_e66aae8646ca
  __ITER__END__93fec1eb_71c6_4f13_9860_e66aae8646ca:
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
  __ITER__START__b92f93ad_2e08_4487_b0fd_46072f07cb9d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_044a7764_7962_4ad0_a0c5_7186440121b0
  BNE	__CMP_YES_044a7764_7962_4ad0_a0c5_7186440121b0
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_044a7764_7962_4ad0_a0c5_7186440121b0
  BNE	__CMP_YES_044a7764_7962_4ad0_a0c5_7186440121b0
  JMP	__CMP_NO_044a7764_7962_4ad0_a0c5_7186440121b0
  __CMP_YES_044a7764_7962_4ad0_a0c5_7186440121b0:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_044a7764_7962_4ad0_a0c5_7186440121b0
  __CMP_NO_044a7764_7962_4ad0_a0c5_7186440121b0:
  SEP	#$20
  LDA	#$00
  __CMP_END_044a7764_7962_4ad0_a0c5_7186440121b0:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b92f93ad_2e08_4487_b0fd_46072f07cb9d
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_729abb6e_d3ad_44d5_9f7d_3d929ddf195f
  JMP	__ITER__END__b92f93ad_2e08_4487_b0fd_46072f07cb9d
  __IFNOT_729abb6e_d3ad_44d5_9f7d_3d929ddf195f:
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
  JMP	__ITER__START__b92f93ad_2e08_4487_b0fd_46072f07cb9d
  __ITER__END__b92f93ad_2e08_4487_b0fd_46072f07cb9d:
  __ITER__START__0b317d55_8174_4e5c_8e89_f2edc59f03ca:
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
  JMP	__ITER__END__0b317d55_8174_4e5c_8e89_f2edc59f03ca
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_786fd673_a770_4808_ac63_1338ad8a0546
  BNE	__CMP_YES_786fd673_a770_4808_ac63_1338ad8a0546
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_786fd673_a770_4808_ac63_1338ad8a0546
  BNE	__CMP_YES_786fd673_a770_4808_ac63_1338ad8a0546
  JMP	__CMP_YES_786fd673_a770_4808_ac63_1338ad8a0546
  __CMP_YES_786fd673_a770_4808_ac63_1338ad8a0546:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_786fd673_a770_4808_ac63_1338ad8a0546
  __CMP_NO_786fd673_a770_4808_ac63_1338ad8a0546:
  SEP	#$20
  LDA	#$00
  __CMP_END_786fd673_a770_4808_ac63_1338ad8a0546:
  BEQ	__IFNOT_690a9cfb_0adb_4c51_82ab_5ab9cbcb3a79
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
  __IFNOT_690a9cfb_0adb_4c51_82ab_5ab9cbcb3a79:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod16by32@start + 1
  LSR
  STA	__mod16by32@start + 1
  SEP	#$20
  LDA	__mod16by32@start + 0
  ROR
  STA	__mod16by32@start + 0
  JMP	__ITER__START__0b317d55_8174_4e5c_8e89_f2edc59f03ca
  __ITER__END__0b317d55_8174_4e5c_8e89_f2edc59f03ca:
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
  __ITER__START__49dfcf88_d691_4bcd_a4de_fb7f76a2914e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64
  BNE	__CMP_YES_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64
  BNE	__CMP_YES_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64
  BNE	__CMP_YES_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64
  JMP	__CMP_NO_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64
  __CMP_YES_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64
  __CMP_NO_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64:
  SEP	#$20
  LDA	#$00
  __CMP_END_9ea2e6bc_881c_4c77_b6c2_3959d8e54a64:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__49dfcf88_d691_4bcd_a4de_fb7f76a2914e
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_f499ae50_1d5a_4094_86f9_02027e1fac35
  JMP	__ITER__END__49dfcf88_d691_4bcd_a4de_fb7f76a2914e
  __IFNOT_f499ae50_1d5a_4094_86f9_02027e1fac35:
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
  JMP	__ITER__START__49dfcf88_d691_4bcd_a4de_fb7f76a2914e
  __ITER__END__49dfcf88_d691_4bcd_a4de_fb7f76a2914e:
  __ITER__START__9dfa3b60_cada_48ee_9daa_f6cdb086b0e4:
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
  JMP	__ITER__END__9dfa3b60_cada_48ee_9daa_f6cdb086b0e4
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_4ea0bce5_56fc_4390_a6f3_322b7cb26389
  BNE	__CMP_YES_4ea0bce5_56fc_4390_a6f3_322b7cb26389
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_4ea0bce5_56fc_4390_a6f3_322b7cb26389
  BNE	__CMP_YES_4ea0bce5_56fc_4390_a6f3_322b7cb26389
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4ea0bce5_56fc_4390_a6f3_322b7cb26389
  BNE	__CMP_YES_4ea0bce5_56fc_4390_a6f3_322b7cb26389
  JMP	__CMP_YES_4ea0bce5_56fc_4390_a6f3_322b7cb26389
  __CMP_YES_4ea0bce5_56fc_4390_a6f3_322b7cb26389:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4ea0bce5_56fc_4390_a6f3_322b7cb26389
  __CMP_NO_4ea0bce5_56fc_4390_a6f3_322b7cb26389:
  SEP	#$20
  LDA	#$00
  __CMP_END_4ea0bce5_56fc_4390_a6f3_322b7cb26389:
  BEQ	__IFNOT_fd6a2643_6dc0_4191_b0d5_9f6ec3359d78
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
  __IFNOT_fd6a2643_6dc0_4191_b0d5_9f6ec3359d78:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod24by32@start + 1
  LSR
  STA	__mod24by32@start + 1
  SEP	#$20
  LDA	__mod24by32@start + 0
  ROR
  STA	__mod24by32@start + 0
  JMP	__ITER__START__9dfa3b60_cada_48ee_9daa_f6cdb086b0e4
  __ITER__END__9dfa3b60_cada_48ee_9daa_f6cdb086b0e4:
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
  __ITER__START__f62a04ad_a9ba_4e9a_8e55_d7e45d7adf52:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b70bc8d4_6bb5_49c7_832a_60e19599bfe6
  BNE	__CMP_YES_b70bc8d4_6bb5_49c7_832a_60e19599bfe6
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b70bc8d4_6bb5_49c7_832a_60e19599bfe6
  BNE	__CMP_YES_b70bc8d4_6bb5_49c7_832a_60e19599bfe6
  JMP	__CMP_NO_b70bc8d4_6bb5_49c7_832a_60e19599bfe6
  __CMP_YES_b70bc8d4_6bb5_49c7_832a_60e19599bfe6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b70bc8d4_6bb5_49c7_832a_60e19599bfe6
  __CMP_NO_b70bc8d4_6bb5_49c7_832a_60e19599bfe6:
  SEP	#$20
  LDA	#$00
  __CMP_END_b70bc8d4_6bb5_49c7_832a_60e19599bfe6:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f62a04ad_a9ba_4e9a_8e55_d7e45d7adf52
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_4d32cd15_96ee_4737_b1aa_66ad8965bc46
  JMP	__ITER__END__f62a04ad_a9ba_4e9a_8e55_d7e45d7adf52
  __IFNOT_4d32cd15_96ee_4737_b1aa_66ad8965bc46:
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
  JMP	__ITER__START__f62a04ad_a9ba_4e9a_8e55_d7e45d7adf52
  __ITER__END__f62a04ad_a9ba_4e9a_8e55_d7e45d7adf52:
  __ITER__START__43e6fbab_d525_4fe2_90df_cac7dac59a89:
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
  JMP	__ITER__END__43e6fbab_d525_4fe2_90df_cac7dac59a89
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f5ffd54d_6fa9_4795_ae02_a577ded197bd
  BNE	__CMP_YES_f5ffd54d_6fa9_4795_ae02_a577ded197bd
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f5ffd54d_6fa9_4795_ae02_a577ded197bd
  BNE	__CMP_YES_f5ffd54d_6fa9_4795_ae02_a577ded197bd
  JMP	__CMP_YES_f5ffd54d_6fa9_4795_ae02_a577ded197bd
  __CMP_YES_f5ffd54d_6fa9_4795_ae02_a577ded197bd:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f5ffd54d_6fa9_4795_ae02_a577ded197bd
  __CMP_NO_f5ffd54d_6fa9_4795_ae02_a577ded197bd:
  SEP	#$20
  LDA	#$00
  __CMP_END_f5ffd54d_6fa9_4795_ae02_a577ded197bd:
  BEQ	__IFNOT_34a15ff2_399f_4dfb_897e_4d1e2c40ab36
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
  __IFNOT_34a15ff2_399f_4dfb_897e_4d1e2c40ab36:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod32by32@start + 2
  LSR
  STA	__mod32by32@start + 2
  REP	#$20
  LDA	__mod32by32@start + 0
  ROR
  STA	__mod32by32@start + 0
  JMP	__ITER__START__43e6fbab_d525_4fe2_90df_cac7dac59a89
  __ITER__END__43e6fbab_d525_4fe2_90df_cac7dac59a89:
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
  __ITER__START__f5d8161c_b75a_4dc6_9dfd_c73f69531c69:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_085de22a_9f58_412b_983d_3feea3d839f4
  BNE	__CMP_YES_085de22a_9f58_412b_983d_3feea3d839f4
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_085de22a_9f58_412b_983d_3feea3d839f4
  BNE	__CMP_YES_085de22a_9f58_412b_983d_3feea3d839f4
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_085de22a_9f58_412b_983d_3feea3d839f4
  BNE	__CMP_YES_085de22a_9f58_412b_983d_3feea3d839f4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_085de22a_9f58_412b_983d_3feea3d839f4
  BNE	__CMP_YES_085de22a_9f58_412b_983d_3feea3d839f4
  JMP	__CMP_NO_085de22a_9f58_412b_983d_3feea3d839f4
  __CMP_YES_085de22a_9f58_412b_983d_3feea3d839f4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_085de22a_9f58_412b_983d_3feea3d839f4
  __CMP_NO_085de22a_9f58_412b_983d_3feea3d839f4:
  SEP	#$20
  LDA	#$00
  __CMP_END_085de22a_9f58_412b_983d_3feea3d839f4:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__f5d8161c_b75a_4dc6_9dfd_c73f69531c69
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_a2d82629_a47b_492b_8fa2_916a22971ae1
  JMP	__ITER__END__f5d8161c_b75a_4dc6_9dfd_c73f69531c69
  __IFNOT_a2d82629_a47b_492b_8fa2_916a22971ae1:
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
  JMP	__ITER__START__f5d8161c_b75a_4dc6_9dfd_c73f69531c69
  __ITER__END__f5d8161c_b75a_4dc6_9dfd_c73f69531c69:
  __ITER__START__db06b35b_9202_4c5f_aa51_0cfe6de3c85f:
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
  JMP	__ITER__END__db06b35b_9202_4c5f_aa51_0cfe6de3c85f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_4d408dfa_fc18_460f_b363_865f54ed206e
  BNE	__CMP_YES_4d408dfa_fc18_460f_b363_865f54ed206e
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_4d408dfa_fc18_460f_b363_865f54ed206e
  BNE	__CMP_YES_4d408dfa_fc18_460f_b363_865f54ed206e
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_4d408dfa_fc18_460f_b363_865f54ed206e
  BNE	__CMP_YES_4d408dfa_fc18_460f_b363_865f54ed206e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4d408dfa_fc18_460f_b363_865f54ed206e
  BNE	__CMP_YES_4d408dfa_fc18_460f_b363_865f54ed206e
  JMP	__CMP_YES_4d408dfa_fc18_460f_b363_865f54ed206e
  __CMP_YES_4d408dfa_fc18_460f_b363_865f54ed206e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4d408dfa_fc18_460f_b363_865f54ed206e
  __CMP_NO_4d408dfa_fc18_460f_b363_865f54ed206e:
  SEP	#$20
  LDA	#$00
  __CMP_END_4d408dfa_fc18_460f_b363_865f54ed206e:
  BEQ	__IFNOT_5bfdaf19_6cb4_48e0_a16a_fdeedbf5eb36
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
  __IFNOT_5bfdaf19_6cb4_48e0_a16a_fdeedbf5eb36:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 2
  LSR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod64by32@start + 2
  LSR
  STA	__mod64by32@start + 2
  REP	#$20
  LDA	__mod64by32@start + 0
  ROR
  STA	__mod64by32@start + 0
  JMP	__ITER__START__db06b35b_9202_4c5f_aa51_0cfe6de3c85f
  __ITER__END__db06b35b_9202_4c5f_aa51_0cfe6de3c85f:
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
  __ITER__START__d74ac44c_4070_479b_b24e_7bfaeced6e9c:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  BNE	__CMP_YES_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  BNE	__CMP_YES_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  BNE	__CMP_YES_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  BNE	__CMP_YES_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  BNE	__CMP_YES_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  JMP	__CMP_NO_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  __CMP_YES_f764cf08_03eb_4f45_90d7_f98c2e57b2cf:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f764cf08_03eb_4f45_90d7_f98c2e57b2cf
  __CMP_NO_f764cf08_03eb_4f45_90d7_f98c2e57b2cf:
  SEP	#$20
  LDA	#$00
  __CMP_END_f764cf08_03eb_4f45_90d7_f98c2e57b2cf:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d74ac44c_4070_479b_b24e_7bfaeced6e9c
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_7a55d554_97ef_4dc8_abe3_8d7c0ee66bc7
  JMP	__ITER__END__d74ac44c_4070_479b_b24e_7bfaeced6e9c
  __IFNOT_7a55d554_97ef_4dc8_abe3_8d7c0ee66bc7:
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
  JMP	__ITER__START__d74ac44c_4070_479b_b24e_7bfaeced6e9c
  __ITER__END__d74ac44c_4070_479b_b24e_7bfaeced6e9c:
  __ITER__START__e67eb602_c5f5_4533_bc47_0e5fccae9002:
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
  JMP	__ITER__END__e67eb602_c5f5_4533_bc47_0e5fccae9002
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  BNE	__CMP_YES_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  BNE	__CMP_YES_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  BNE	__CMP_YES_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  BNE	__CMP_YES_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  BNE	__CMP_YES_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  JMP	__CMP_YES_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  __CMP_YES_8eaa5d22_bc8e_48dd_a73a_31eab843adc0:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8eaa5d22_bc8e_48dd_a73a_31eab843adc0
  __CMP_NO_8eaa5d22_bc8e_48dd_a73a_31eab843adc0:
  SEP	#$20
  LDA	#$00
  __CMP_END_8eaa5d22_bc8e_48dd_a73a_31eab843adc0:
  BEQ	__IFNOT_ff7cf322_983f_46e2_9612_97c26d0fa29e
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
  __IFNOT_ff7cf322_983f_46e2_9612_97c26d0fa29e:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod8by64@start + 1
  LSR
  STA	__mod8by64@start + 1
  SEP	#$20
  LDA	__mod8by64@start + 0
  ROR
  STA	__mod8by64@start + 0
  JMP	__ITER__START__e67eb602_c5f5_4533_bc47_0e5fccae9002
  __ITER__END__e67eb602_c5f5_4533_bc47_0e5fccae9002:
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
  __ITER__START__659b7f36_d511_4a98_972f_89058de53fcf:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  BNE	__CMP_YES_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  BNE	__CMP_YES_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  BNE	__CMP_YES_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  BNE	__CMP_YES_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  JMP	__CMP_NO_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  __CMP_YES_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe
  __CMP_NO_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe:
  SEP	#$20
  LDA	#$00
  __CMP_END_5a6f4a64_fea3_4f04_ac2e_9340d0169ffe:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__659b7f36_d511_4a98_972f_89058de53fcf
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_e0bb16ed_2aeb_4e7b_90fe_4b0ce5b62dd6
  JMP	__ITER__END__659b7f36_d511_4a98_972f_89058de53fcf
  __IFNOT_e0bb16ed_2aeb_4e7b_90fe_4b0ce5b62dd6:
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
  JMP	__ITER__START__659b7f36_d511_4a98_972f_89058de53fcf
  __ITER__END__659b7f36_d511_4a98_972f_89058de53fcf:
  __ITER__START__116cf2bb_d05d_4a3c_bfcf_42047b18077d:
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
  JMP	__ITER__END__116cf2bb_d05d_4a3c_bfcf_42047b18077d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  BNE	__CMP_YES_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  BNE	__CMP_YES_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  BNE	__CMP_YES_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  BNE	__CMP_YES_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  JMP	__CMP_YES_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  __CMP_YES_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef
  __CMP_NO_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef:
  SEP	#$20
  LDA	#$00
  __CMP_END_821cf0b6_e5be_4b6a_b97f_8ed3a91276ef:
  BEQ	__IFNOT_c56d525f_420e_42c5_a1cd_b23947772c28
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
  __IFNOT_c56d525f_420e_42c5_a1cd_b23947772c28:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod16by64@start + 1
  LSR
  STA	__mod16by64@start + 1
  SEP	#$20
  LDA	__mod16by64@start + 0
  ROR
  STA	__mod16by64@start + 0
  JMP	__ITER__START__116cf2bb_d05d_4a3c_bfcf_42047b18077d
  __ITER__END__116cf2bb_d05d_4a3c_bfcf_42047b18077d:
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
  __ITER__START__76f3101f_8f54_4eb1_9e57_fd9eff427e00:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  BNE	__CMP_YES_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  BNE	__CMP_YES_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  BNE	__CMP_YES_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  BNE	__CMP_YES_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  BNE	__CMP_YES_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  JMP	__CMP_NO_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  __CMP_YES_2b7178fc_59d0_4b47_ae68_9fec08ddb644:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2b7178fc_59d0_4b47_ae68_9fec08ddb644
  __CMP_NO_2b7178fc_59d0_4b47_ae68_9fec08ddb644:
  SEP	#$20
  LDA	#$00
  __CMP_END_2b7178fc_59d0_4b47_ae68_9fec08ddb644:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__76f3101f_8f54_4eb1_9e57_fd9eff427e00
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_6ac360f2_ae90_43d0_93b2_97002141e8fc
  JMP	__ITER__END__76f3101f_8f54_4eb1_9e57_fd9eff427e00
  __IFNOT_6ac360f2_ae90_43d0_93b2_97002141e8fc:
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
  JMP	__ITER__START__76f3101f_8f54_4eb1_9e57_fd9eff427e00
  __ITER__END__76f3101f_8f54_4eb1_9e57_fd9eff427e00:
  __ITER__START__69d3f311_c2ba_4c54_a6ee_be831b67ad1b:
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
  JMP	__ITER__END__69d3f311_c2ba_4c54_a6ee_be831b67ad1b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e92b2980_3a66_4910_b599_e3453c3bc809
  BNE	__CMP_YES_e92b2980_3a66_4910_b599_e3453c3bc809
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e92b2980_3a66_4910_b599_e3453c3bc809
  BNE	__CMP_YES_e92b2980_3a66_4910_b599_e3453c3bc809
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_e92b2980_3a66_4910_b599_e3453c3bc809
  BNE	__CMP_YES_e92b2980_3a66_4910_b599_e3453c3bc809
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e92b2980_3a66_4910_b599_e3453c3bc809
  BNE	__CMP_YES_e92b2980_3a66_4910_b599_e3453c3bc809
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e92b2980_3a66_4910_b599_e3453c3bc809
  BNE	__CMP_YES_e92b2980_3a66_4910_b599_e3453c3bc809
  JMP	__CMP_YES_e92b2980_3a66_4910_b599_e3453c3bc809
  __CMP_YES_e92b2980_3a66_4910_b599_e3453c3bc809:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e92b2980_3a66_4910_b599_e3453c3bc809
  __CMP_NO_e92b2980_3a66_4910_b599_e3453c3bc809:
  SEP	#$20
  LDA	#$00
  __CMP_END_e92b2980_3a66_4910_b599_e3453c3bc809:
  BEQ	__IFNOT_e75aaf9c_a78e_4849_bd60_60d3b09cfef8
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
  __IFNOT_e75aaf9c_a78e_4849_bd60_60d3b09cfef8:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod24by64@start + 1
  LSR
  STA	__mod24by64@start + 1
  SEP	#$20
  LDA	__mod24by64@start + 0
  ROR
  STA	__mod24by64@start + 0
  JMP	__ITER__START__69d3f311_c2ba_4c54_a6ee_be831b67ad1b
  __ITER__END__69d3f311_c2ba_4c54_a6ee_be831b67ad1b:
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
  __ITER__START__01710187_be13_4a17_b75c_60334a7bcfc8:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_ba1874a1_5ff3_47fe_a152_baf3553dacff
  BNE	__CMP_YES_ba1874a1_5ff3_47fe_a152_baf3553dacff
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_ba1874a1_5ff3_47fe_a152_baf3553dacff
  BNE	__CMP_YES_ba1874a1_5ff3_47fe_a152_baf3553dacff
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_ba1874a1_5ff3_47fe_a152_baf3553dacff
  BNE	__CMP_YES_ba1874a1_5ff3_47fe_a152_baf3553dacff
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ba1874a1_5ff3_47fe_a152_baf3553dacff
  BNE	__CMP_YES_ba1874a1_5ff3_47fe_a152_baf3553dacff
  JMP	__CMP_NO_ba1874a1_5ff3_47fe_a152_baf3553dacff
  __CMP_YES_ba1874a1_5ff3_47fe_a152_baf3553dacff:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ba1874a1_5ff3_47fe_a152_baf3553dacff
  __CMP_NO_ba1874a1_5ff3_47fe_a152_baf3553dacff:
  SEP	#$20
  LDA	#$00
  __CMP_END_ba1874a1_5ff3_47fe_a152_baf3553dacff:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__01710187_be13_4a17_b75c_60334a7bcfc8
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_534769e1_66c9_4cd3_bf76_ac4dd40260ff
  JMP	__ITER__END__01710187_be13_4a17_b75c_60334a7bcfc8
  __IFNOT_534769e1_66c9_4cd3_bf76_ac4dd40260ff:
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
  JMP	__ITER__START__01710187_be13_4a17_b75c_60334a7bcfc8
  __ITER__END__01710187_be13_4a17_b75c_60334a7bcfc8:
  __ITER__START__d76a5017_f6f6_44be_b9a3_258346b8a922:
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
  JMP	__ITER__END__d76a5017_f6f6_44be_b9a3_258346b8a922
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_6cac41b0_3dae_45ec_b4a2_d4554726e972
  BNE	__CMP_YES_6cac41b0_3dae_45ec_b4a2_d4554726e972
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_6cac41b0_3dae_45ec_b4a2_d4554726e972
  BNE	__CMP_YES_6cac41b0_3dae_45ec_b4a2_d4554726e972
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_6cac41b0_3dae_45ec_b4a2_d4554726e972
  BNE	__CMP_YES_6cac41b0_3dae_45ec_b4a2_d4554726e972
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6cac41b0_3dae_45ec_b4a2_d4554726e972
  BNE	__CMP_YES_6cac41b0_3dae_45ec_b4a2_d4554726e972
  JMP	__CMP_YES_6cac41b0_3dae_45ec_b4a2_d4554726e972
  __CMP_YES_6cac41b0_3dae_45ec_b4a2_d4554726e972:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6cac41b0_3dae_45ec_b4a2_d4554726e972
  __CMP_NO_6cac41b0_3dae_45ec_b4a2_d4554726e972:
  SEP	#$20
  LDA	#$00
  __CMP_END_6cac41b0_3dae_45ec_b4a2_d4554726e972:
  BEQ	__IFNOT_75aadd1b_7b10_4ed1_8898_34a355695259
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
  __IFNOT_75aadd1b_7b10_4ed1_8898_34a355695259:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod32by64@start + 2
  LSR
  STA	__mod32by64@start + 2
  REP	#$20
  LDA	__mod32by64@start + 0
  ROR
  STA	__mod32by64@start + 0
  JMP	__ITER__START__d76a5017_f6f6_44be_b9a3_258346b8a922
  __ITER__END__d76a5017_f6f6_44be_b9a3_258346b8a922:
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
  __ITER__START__37ef27c1_e8e7_487b_a42b_b9bc9a9d4ae4:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_3497ce5e_8c07_415b_a961_929306e7f352
  BNE	__CMP_YES_3497ce5e_8c07_415b_a961_929306e7f352
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_3497ce5e_8c07_415b_a961_929306e7f352
  BNE	__CMP_YES_3497ce5e_8c07_415b_a961_929306e7f352
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3497ce5e_8c07_415b_a961_929306e7f352
  BNE	__CMP_YES_3497ce5e_8c07_415b_a961_929306e7f352
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3497ce5e_8c07_415b_a961_929306e7f352
  BNE	__CMP_YES_3497ce5e_8c07_415b_a961_929306e7f352
  JMP	__CMP_NO_3497ce5e_8c07_415b_a961_929306e7f352
  __CMP_YES_3497ce5e_8c07_415b_a961_929306e7f352:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3497ce5e_8c07_415b_a961_929306e7f352
  __CMP_NO_3497ce5e_8c07_415b_a961_929306e7f352:
  SEP	#$20
  LDA	#$00
  __CMP_END_3497ce5e_8c07_415b_a961_929306e7f352:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__37ef27c1_e8e7_487b_a42b_b9bc9a9d4ae4
  :
  
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 0
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$8000
  AND	__@specSubY + 2
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 4
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  AND	__@specSubY + 6
  STA	__@scratchBase + 9
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 3
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 5
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 7
  CMP	#$0000
  BNE	:+
  REP	#$20
  LDA	__@scratchBase + 9
  CMP	#$0000
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_4ba85227_383d_44de_8a5d_4aa8e1e91fe4
  JMP	__ITER__END__37ef27c1_e8e7_487b_a42b_b9bc9a9d4ae4
  __IFNOT_4ba85227_383d_44de_8a5d_4aa8e1e91fe4:
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
  JMP	__ITER__START__37ef27c1_e8e7_487b_a42b_b9bc9a9d4ae4
  __ITER__END__37ef27c1_e8e7_487b_a42b_b9bc9a9d4ae4:
  __ITER__START__d8782de4_ead0_46ed_92a5_1a557927c703:
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
  JMP	__ITER__END__d8782de4_ead0_46ed_92a5_1a557927c703
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_78810869_0f47_4735_a65b_898899722d9f
  BNE	__CMP_YES_78810869_0f47_4735_a65b_898899722d9f
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_78810869_0f47_4735_a65b_898899722d9f
  BNE	__CMP_YES_78810869_0f47_4735_a65b_898899722d9f
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_78810869_0f47_4735_a65b_898899722d9f
  BNE	__CMP_YES_78810869_0f47_4735_a65b_898899722d9f
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_78810869_0f47_4735_a65b_898899722d9f
  BNE	__CMP_YES_78810869_0f47_4735_a65b_898899722d9f
  JMP	__CMP_YES_78810869_0f47_4735_a65b_898899722d9f
  __CMP_YES_78810869_0f47_4735_a65b_898899722d9f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_78810869_0f47_4735_a65b_898899722d9f
  __CMP_NO_78810869_0f47_4735_a65b_898899722d9f:
  SEP	#$20
  LDA	#$00
  __CMP_END_78810869_0f47_4735_a65b_898899722d9f:
  BNE	:+
  JMP	__IFNOT_5fddba01_7947_46c0_8440_ae8966d35901
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
  __IFNOT_5fddba01_7947_46c0_8440_ae8966d35901:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 6
  LSR
  STA	__@specSubY + 6
  REP	#$20
  LDA	__@specSubY + 4
  ROR
  STA	__@specSubY + 4
  REP	#$20
  LDA	__@specSubY + 2
  ROR
  STA	__@specSubY + 2
  REP	#$20
  LDA	__@specSubY + 0
  ROR
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod64by64@start + 6
  LSR
  STA	__mod64by64@start + 6
  REP	#$20
  LDA	__mod64by64@start + 4
  ROR
  STA	__mod64by64@start + 4
  REP	#$20
  LDA	__mod64by64@start + 2
  ROR
  STA	__mod64by64@start + 2
  REP	#$20
  LDA	__mod64by64@start + 0
  ROR
  STA	__mod64by64@start + 0
  JMP	__ITER__START__d8782de4_ead0_46ed_92a5_1a557927c703
  __ITER__END__d8782de4_ead0_46ed_92a5_1a557927c703:
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
; @endasm
