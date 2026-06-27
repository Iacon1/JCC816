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
  STA	__@callResult + 1
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
  LDA	__REG@RDMPYH
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
  STA	__@callResult + 2
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
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
  LDA	__REG@RDMPYH
  STA	__@callResult + 4
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
  STA	__@callResult + 5
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
  STA	__@callResult + 6
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
  STA	__@callResult + 7
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
RTL		; @endfunc


; Division
__div8by8:		; @func
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div8by16@ret + 0
  SEP	#$20
  STA	__div8by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div8by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div8by16@start + 2
  __ITER__START__faffa3f0_9460_4993_a284_acd310499625:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6
  BNE	__CMP_YES_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6
  BNE	__CMP_YES_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6
  JMP	__CMP_NO_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6
  __CMP_YES_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6
  __CMP_NO_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6:
  SEP	#$20
  LDA	#$00
  __CMP_END_a41258d4_4104_4ae6_8fc1_475a5f1ab8e6:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__faffa3f0_9460_4993_a284_acd310499625
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
  BNE	__IFNOT_94568f85_8c5b_4331_ac6b_b019a05b2c33
  JMP	__ITER__END__faffa3f0_9460_4993_a284_acd310499625
  __IFNOT_94568f85_8c5b_4331_ac6b_b019a05b2c33:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div8by16@start + 0
  ASL
  STA	__div8by16@start + 0
  SEP	#$20
  LDA	__div8by16@start + 2
  ROL
  STA	__div8by16@start + 2
  JMP	__ITER__START__faffa3f0_9460_4993_a284_acd310499625
  __ITER__END__faffa3f0_9460_4993_a284_acd310499625:
  __ITER__START__c2e0def2_011b_43a1_95df_a9784f939daa:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__c2e0def2_011b_43a1_95df_a9784f939daa
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d
  BNE	__CMP_YES_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d
  BNE	__CMP_YES_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d
  JMP	__CMP_YES_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d
  __CMP_YES_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d
  __CMP_NO_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d:
  SEP	#$20
  LDA	#$00
  __CMP_END_6fe50fa0_7b47_4309_a4aa_0f7b00e8068d:
  BEQ	__IFNOT_061c339e_5236_4a16_bf55_8ea3926e5f5b
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
  REP	#$20
  LDA	__div8by16@ret + 0
  ADC	__div8by16@start + 0
  STA	__div8by16@ret + 0
  SEP	#$20
  LDA	__div8by16@ret + 2
  ADC	__div8by16@start + 2
  STA	__div8by16@ret + 2
  __IFNOT_061c339e_5236_4a16_bf55_8ea3926e5f5b:
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
  JMP	__ITER__START__c2e0def2_011b_43a1_95df_a9784f939daa
  __ITER__END__c2e0def2_011b_43a1_95df_a9784f939daa:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div16by16@ret + 0
  SEP	#$20
  STA	__div16by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div16by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div16by16@start + 2
  __ITER__START__b702865a_75a9_42bd_8f17_202e43c0a2f2:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_05a5b4b9_94c8_4eec_8eea_6f536a366ff3
  BNE	__CMP_YES_05a5b4b9_94c8_4eec_8eea_6f536a366ff3
  JMP	__CMP_NO_05a5b4b9_94c8_4eec_8eea_6f536a366ff3
  __CMP_YES_05a5b4b9_94c8_4eec_8eea_6f536a366ff3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_05a5b4b9_94c8_4eec_8eea_6f536a366ff3
  __CMP_NO_05a5b4b9_94c8_4eec_8eea_6f536a366ff3:
  SEP	#$20
  LDA	#$00
  __CMP_END_05a5b4b9_94c8_4eec_8eea_6f536a366ff3:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b702865a_75a9_42bd_8f17_202e43c0a2f2
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
  BNE	__IFNOT_2cdd6f34_1585_478f_bbdb_5f12d6008f51
  JMP	__ITER__END__b702865a_75a9_42bd_8f17_202e43c0a2f2
  __IFNOT_2cdd6f34_1585_478f_bbdb_5f12d6008f51:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div16by16@start + 0
  ASL
  STA	__div16by16@start + 0
  SEP	#$20
  LDA	__div16by16@start + 2
  ROL
  STA	__div16by16@start + 2
  JMP	__ITER__START__b702865a_75a9_42bd_8f17_202e43c0a2f2
  __ITER__END__b702865a_75a9_42bd_8f17_202e43c0a2f2:
  __ITER__START__e448b22b_efe1_467a_a520_cb2f2c86882e:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__e448b22b_efe1_467a_a520_cb2f2c86882e
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_eae14066_38b0_4dce_a529_0b6647eba2d6
  BNE	__CMP_YES_eae14066_38b0_4dce_a529_0b6647eba2d6
  JMP	__CMP_YES_eae14066_38b0_4dce_a529_0b6647eba2d6
  __CMP_YES_eae14066_38b0_4dce_a529_0b6647eba2d6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_eae14066_38b0_4dce_a529_0b6647eba2d6
  __CMP_NO_eae14066_38b0_4dce_a529_0b6647eba2d6:
  SEP	#$20
  LDA	#$00
  __CMP_END_eae14066_38b0_4dce_a529_0b6647eba2d6:
  BEQ	__IFNOT_7e6c5d4c_28a1_4330_8881_f1fef36c90c8
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  REP	#$20
  LDA	__div16by16@ret + 0
  ADC	__div16by16@start + 0
  STA	__div16by16@ret + 0
  SEP	#$20
  LDA	__div16by16@ret + 2
  ADC	__div16by16@start + 2
  STA	__div16by16@ret + 2
  __IFNOT_7e6c5d4c_28a1_4330_8881_f1fef36c90c8:
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
  JMP	__ITER__START__e448b22b_efe1_467a_a520_cb2f2c86882e
  __ITER__END__e448b22b_efe1_467a_a520_cb2f2c86882e:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div24by16@ret + 0
  SEP	#$20
  STA	__div24by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div24by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div24by16@start + 2
  __ITER__START__48177a7a_1b47_4c89_9d4b_5a7a5f6beb25:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4
  BNE	__CMP_YES_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4
  BNE	__CMP_YES_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4
  JMP	__CMP_NO_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4
  __CMP_YES_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4
  __CMP_NO_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4:
  SEP	#$20
  LDA	#$00
  __CMP_END_0fd8bd07_f5ce_4186_ab5f_8703bcc21be4:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__48177a7a_1b47_4c89_9d4b_5a7a5f6beb25
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
  BNE	__IFNOT_072192ce_1315_4c46_a479_5e0cf0e7b339
  JMP	__ITER__END__48177a7a_1b47_4c89_9d4b_5a7a5f6beb25
  __IFNOT_072192ce_1315_4c46_a479_5e0cf0e7b339:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div24by16@start + 0
  ASL
  STA	__div24by16@start + 0
  SEP	#$20
  LDA	__div24by16@start + 2
  ROL
  STA	__div24by16@start + 2
  JMP	__ITER__START__48177a7a_1b47_4c89_9d4b_5a7a5f6beb25
  __ITER__END__48177a7a_1b47_4c89_9d4b_5a7a5f6beb25:
  __ITER__START__5dba0f04_27b7_4578_bc0d_aabcd1c2b521:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__5dba0f04_27b7_4578_bc0d_aabcd1c2b521
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4
  BNE	__CMP_YES_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4
  BNE	__CMP_YES_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4
  JMP	__CMP_YES_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4
  __CMP_YES_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4
  __CMP_NO_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4:
  SEP	#$20
  LDA	#$00
  __CMP_END_81a79735_7c7f_4ecf_9699_b7aab8e5cdb4:
  BEQ	__IFNOT_c02ae787_573b_4619_8e4a_66daaf52a840
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
  REP	#$20
  LDA	__div24by16@ret + 0
  ADC	__div24by16@start + 0
  STA	__div24by16@ret + 0
  SEP	#$20
  LDA	__div24by16@ret + 2
  ADC	__div24by16@start + 2
  STA	__div24by16@ret + 2
  __IFNOT_c02ae787_573b_4619_8e4a_66daaf52a840:
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
  JMP	__ITER__START__5dba0f04_27b7_4578_bc0d_aabcd1c2b521
  __ITER__END__5dba0f04_27b7_4578_bc0d_aabcd1c2b521:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div32by16@ret + 0
  SEP	#$20
  STA	__div32by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div32by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div32by16@start + 2
  __ITER__START__fe1a5142_465f_4925_b317_5a9ce6b96671:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_8f16d733_d7f1_4b23_abca_a135544984d3
  BNE	__CMP_YES_8f16d733_d7f1_4b23_abca_a135544984d3
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_8f16d733_d7f1_4b23_abca_a135544984d3
  BNE	__CMP_YES_8f16d733_d7f1_4b23_abca_a135544984d3
  JMP	__CMP_NO_8f16d733_d7f1_4b23_abca_a135544984d3
  __CMP_YES_8f16d733_d7f1_4b23_abca_a135544984d3:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_8f16d733_d7f1_4b23_abca_a135544984d3
  __CMP_NO_8f16d733_d7f1_4b23_abca_a135544984d3:
  SEP	#$20
  LDA	#$00
  __CMP_END_8f16d733_d7f1_4b23_abca_a135544984d3:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__fe1a5142_465f_4925_b317_5a9ce6b96671
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
  BNE	__IFNOT_2daec86a_dc70_4075_83b8_9d9cf0108bed
  JMP	__ITER__END__fe1a5142_465f_4925_b317_5a9ce6b96671
  __IFNOT_2daec86a_dc70_4075_83b8_9d9cf0108bed:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div32by16@start + 0
  ASL
  STA	__div32by16@start + 0
  SEP	#$20
  LDA	__div32by16@start + 2
  ROL
  STA	__div32by16@start + 2
  JMP	__ITER__START__fe1a5142_465f_4925_b317_5a9ce6b96671
  __ITER__END__fe1a5142_465f_4925_b317_5a9ce6b96671:
  __ITER__START__352b886d_9ddb_4a7a_9137_c8e7a289d48d:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__352b886d_9ddb_4a7a_9137_c8e7a289d48d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_e43915cf_0c4a_4a60_a490_4cce6c4540c4
  BNE	__CMP_YES_e43915cf_0c4a_4a60_a490_4cce6c4540c4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e43915cf_0c4a_4a60_a490_4cce6c4540c4
  BNE	__CMP_YES_e43915cf_0c4a_4a60_a490_4cce6c4540c4
  JMP	__CMP_YES_e43915cf_0c4a_4a60_a490_4cce6c4540c4
  __CMP_YES_e43915cf_0c4a_4a60_a490_4cce6c4540c4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e43915cf_0c4a_4a60_a490_4cce6c4540c4
  __CMP_NO_e43915cf_0c4a_4a60_a490_4cce6c4540c4:
  SEP	#$20
  LDA	#$00
  __CMP_END_e43915cf_0c4a_4a60_a490_4cce6c4540c4:
  BEQ	__IFNOT_59efa018_755d_4be8_a3f1_e83caa328df3
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
  REP	#$20
  LDA	__div32by16@ret + 0
  ADC	__div32by16@start + 0
  STA	__div32by16@ret + 0
  SEP	#$20
  LDA	__div32by16@ret + 2
  ADC	__div32by16@start + 2
  STA	__div32by16@ret + 2
  __IFNOT_59efa018_755d_4be8_a3f1_e83caa328df3:
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
  JMP	__ITER__START__352b886d_9ddb_4a7a_9137_c8e7a289d48d
  __ITER__END__352b886d_9ddb_4a7a_9137_c8e7a289d48d:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div64by16@ret + 0
  SEP	#$20
  STA	__div64by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div64by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div64by16@start + 2
  __ITER__START__256160d7_0264_411f_bc6e_48c0b6e11637:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  BNE	__CMP_YES_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  BNE	__CMP_YES_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  BNE	__CMP_YES_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  BNE	__CMP_YES_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  JMP	__CMP_NO_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  __CMP_YES_b27da045_5e26_4cb1_b120_cd9f9b27d1c4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b27da045_5e26_4cb1_b120_cd9f9b27d1c4
  __CMP_NO_b27da045_5e26_4cb1_b120_cd9f9b27d1c4:
  SEP	#$20
  LDA	#$00
  __CMP_END_b27da045_5e26_4cb1_b120_cd9f9b27d1c4:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__256160d7_0264_411f_bc6e_48c0b6e11637
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
  BNE	__IFNOT_7e7f51f5_eb09_4c49_9709_38a06915bfce
  JMP	__ITER__END__256160d7_0264_411f_bc6e_48c0b6e11637
  __IFNOT_7e7f51f5_eb09_4c49_9709_38a06915bfce:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__div64by16@start + 0
  ASL
  STA	__div64by16@start + 0
  SEP	#$20
  LDA	__div64by16@start + 2
  ROL
  STA	__div64by16@start + 2
  JMP	__ITER__START__256160d7_0264_411f_bc6e_48c0b6e11637
  __ITER__END__256160d7_0264_411f_bc6e_48c0b6e11637:
  __ITER__START__5fce1a6e_9515_4a98_bc54_5703498c7c31:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__5fce1a6e_9515_4a98_bc54_5703498c7c31
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  BNE	__CMP_YES_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  BNE	__CMP_YES_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  BNE	__CMP_YES_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  BNE	__CMP_YES_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  JMP	__CMP_YES_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  __CMP_YES_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606
  __CMP_NO_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606:
  SEP	#$20
  LDA	#$00
  __CMP_END_3db9a2a9_fd7b_41f1_bff1_2cb5d2fab606:
  BEQ	__IFNOT_52b0b19b_92e1_4904_a294_b139883225d7
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
  REP	#$20
  LDA	__div64by16@ret + 0
  ADC	__div64by16@start + 0
  STA	__div64by16@ret + 0
  SEP	#$20
  LDA	__div64by16@ret + 2
  ADC	__div64by16@start + 2
  STA	__div64by16@ret + 2
  __IFNOT_52b0b19b_92e1_4904_a294_b139883225d7:
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
  JMP	__ITER__START__5fce1a6e_9515_4a98_bc54_5703498c7c31
  __ITER__END__5fce1a6e_9515_4a98_bc54_5703498c7c31:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div8by24@ret + 0
  SEP	#$20
  STA	__div8by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div8by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div8by24@start + 2
  __ITER__START__24b2256b_db39_4211_be44_d1f7e252a3d7:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d
  BNE	__CMP_YES_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d
  BNE	__CMP_YES_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d
  JMP	__CMP_NO_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d
  __CMP_YES_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d
  __CMP_NO_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d:
  SEP	#$20
  LDA	#$00
  __CMP_END_4f0d3124_d3c6_4c5c_bbb9_8d4551199b3d:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__24b2256b_db39_4211_be44_d1f7e252a3d7
  :
  
  REP	#$20
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
  BNE	__IFNOT_ed25b8d5_728c_448f_bf78_cd94cb001a75
  JMP	__ITER__END__24b2256b_db39_4211_be44_d1f7e252a3d7
  __IFNOT_ed25b8d5_728c_448f_bf78_cd94cb001a75:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div8by24@start + 0
  ASL
  STA	__div8by24@start + 0
  SEP	#$20
  LDA	__div8by24@start + 2
  ROL
  STA	__div8by24@start + 2
  JMP	__ITER__START__24b2256b_db39_4211_be44_d1f7e252a3d7
  __ITER__END__24b2256b_db39_4211_be44_d1f7e252a3d7:
  __ITER__START__c8630288_09cd_4116_938c_f7a3c1c82c3c:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__c8630288_09cd_4116_938c_f7a3c1c82c3c
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_3c88c93c_bdb4_46be_8b19_fcadbf5698a2
  BNE	__CMP_YES_3c88c93c_bdb4_46be_8b19_fcadbf5698a2
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3c88c93c_bdb4_46be_8b19_fcadbf5698a2
  BNE	__CMP_YES_3c88c93c_bdb4_46be_8b19_fcadbf5698a2
  JMP	__CMP_YES_3c88c93c_bdb4_46be_8b19_fcadbf5698a2
  __CMP_YES_3c88c93c_bdb4_46be_8b19_fcadbf5698a2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3c88c93c_bdb4_46be_8b19_fcadbf5698a2
  __CMP_NO_3c88c93c_bdb4_46be_8b19_fcadbf5698a2:
  SEP	#$20
  LDA	#$00
  __CMP_END_3c88c93c_bdb4_46be_8b19_fcadbf5698a2:
  BEQ	__IFNOT_eecc9e41_d909_40d9_afe9_d5c365df86e4
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
  REP	#$20
  LDA	__div8by24@ret + 0
  ADC	__div8by24@start + 0
  STA	__div8by24@ret + 0
  SEP	#$20
  LDA	__div8by24@ret + 2
  ADC	__div8by24@start + 2
  STA	__div8by24@ret + 2
  __IFNOT_eecc9e41_d909_40d9_afe9_d5c365df86e4:
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
  JMP	__ITER__START__c8630288_09cd_4116_938c_f7a3c1c82c3c
  __ITER__END__c8630288_09cd_4116_938c_f7a3c1c82c3c:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div16by24@ret + 0
  SEP	#$20
  STA	__div16by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div16by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div16by24@start + 2
  __ITER__START__7fce9699_0931_4132_8470_3242c9e5de3c:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_9f65ad20_3bcc_43ae_8818_1c3b0bda732f
  BNE	__CMP_YES_9f65ad20_3bcc_43ae_8818_1c3b0bda732f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9f65ad20_3bcc_43ae_8818_1c3b0bda732f
  BNE	__CMP_YES_9f65ad20_3bcc_43ae_8818_1c3b0bda732f
  JMP	__CMP_NO_9f65ad20_3bcc_43ae_8818_1c3b0bda732f
  __CMP_YES_9f65ad20_3bcc_43ae_8818_1c3b0bda732f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9f65ad20_3bcc_43ae_8818_1c3b0bda732f
  __CMP_NO_9f65ad20_3bcc_43ae_8818_1c3b0bda732f:
  SEP	#$20
  LDA	#$00
  __CMP_END_9f65ad20_3bcc_43ae_8818_1c3b0bda732f:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7fce9699_0931_4132_8470_3242c9e5de3c
  :
  
  REP	#$20
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
  BNE	__IFNOT_91eeb349_f68e_494f_ab17_cbff888242e1
  JMP	__ITER__END__7fce9699_0931_4132_8470_3242c9e5de3c
  __IFNOT_91eeb349_f68e_494f_ab17_cbff888242e1:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div16by24@start + 0
  ASL
  STA	__div16by24@start + 0
  SEP	#$20
  LDA	__div16by24@start + 2
  ROL
  STA	__div16by24@start + 2
  JMP	__ITER__START__7fce9699_0931_4132_8470_3242c9e5de3c
  __ITER__END__7fce9699_0931_4132_8470_3242c9e5de3c:
  __ITER__START__7a415cbc_d978_4364_948b_527e170b2f83:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__7a415cbc_d978_4364_948b_527e170b2f83
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_349194f2_0e09_425d_a994_04130af960d6
  BNE	__CMP_YES_349194f2_0e09_425d_a994_04130af960d6
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_349194f2_0e09_425d_a994_04130af960d6
  BNE	__CMP_YES_349194f2_0e09_425d_a994_04130af960d6
  JMP	__CMP_YES_349194f2_0e09_425d_a994_04130af960d6
  __CMP_YES_349194f2_0e09_425d_a994_04130af960d6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_349194f2_0e09_425d_a994_04130af960d6
  __CMP_NO_349194f2_0e09_425d_a994_04130af960d6:
  SEP	#$20
  LDA	#$00
  __CMP_END_349194f2_0e09_425d_a994_04130af960d6:
  BEQ	__IFNOT_391ec805_b162_4f3b_af89_42640e79fe52
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  REP	#$20
  LDA	__div16by24@ret + 0
  ADC	__div16by24@start + 0
  STA	__div16by24@ret + 0
  SEP	#$20
  LDA	__div16by24@ret + 2
  ADC	__div16by24@start + 2
  STA	__div16by24@ret + 2
  __IFNOT_391ec805_b162_4f3b_af89_42640e79fe52:
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
  JMP	__ITER__START__7a415cbc_d978_4364_948b_527e170b2f83
  __ITER__END__7a415cbc_d978_4364_948b_527e170b2f83:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div24by24@ret + 0
  SEP	#$20
  STA	__div24by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div24by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div24by24@start + 2
  __ITER__START__ff259f65_8dca_4d39_bf4e_51a67933c6f2:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e1858aa4_b714_4e41_9246_169c340c198e
  BNE	__CMP_YES_e1858aa4_b714_4e41_9246_169c340c198e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e1858aa4_b714_4e41_9246_169c340c198e
  BNE	__CMP_YES_e1858aa4_b714_4e41_9246_169c340c198e
  JMP	__CMP_NO_e1858aa4_b714_4e41_9246_169c340c198e
  __CMP_YES_e1858aa4_b714_4e41_9246_169c340c198e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e1858aa4_b714_4e41_9246_169c340c198e
  __CMP_NO_e1858aa4_b714_4e41_9246_169c340c198e:
  SEP	#$20
  LDA	#$00
  __CMP_END_e1858aa4_b714_4e41_9246_169c340c198e:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__ff259f65_8dca_4d39_bf4e_51a67933c6f2
  :
  
  REP	#$20
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
  BNE	__IFNOT_ab72ff56_589a_4529_940d_0bda9f66dd62
  JMP	__ITER__END__ff259f65_8dca_4d39_bf4e_51a67933c6f2
  __IFNOT_ab72ff56_589a_4529_940d_0bda9f66dd62:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div24by24@start + 0
  ASL
  STA	__div24by24@start + 0
  SEP	#$20
  LDA	__div24by24@start + 2
  ROL
  STA	__div24by24@start + 2
  JMP	__ITER__START__ff259f65_8dca_4d39_bf4e_51a67933c6f2
  __ITER__END__ff259f65_8dca_4d39_bf4e_51a67933c6f2:
  __ITER__START__e58fbe7f_d04c_40c8_aaeb_22afce13c6dc:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__e58fbe7f_d04c_40c8_aaeb_22afce13c6dc
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_0b2fa22a_d46e_4b46_87d8_76e386245f78
  BNE	__CMP_YES_0b2fa22a_d46e_4b46_87d8_76e386245f78
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0b2fa22a_d46e_4b46_87d8_76e386245f78
  BNE	__CMP_YES_0b2fa22a_d46e_4b46_87d8_76e386245f78
  JMP	__CMP_YES_0b2fa22a_d46e_4b46_87d8_76e386245f78
  __CMP_YES_0b2fa22a_d46e_4b46_87d8_76e386245f78:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0b2fa22a_d46e_4b46_87d8_76e386245f78
  __CMP_NO_0b2fa22a_d46e_4b46_87d8_76e386245f78:
  SEP	#$20
  LDA	#$00
  __CMP_END_0b2fa22a_d46e_4b46_87d8_76e386245f78:
  BEQ	__IFNOT_45c15b49_7329_48c8_bb76_f73433912bd8
  SEC
  REP	#$20
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
  REP	#$20
  LDA	__div24by24@ret + 0
  ADC	__div24by24@start + 0
  STA	__div24by24@ret + 0
  SEP	#$20
  LDA	__div24by24@ret + 2
  ADC	__div24by24@start + 2
  STA	__div24by24@ret + 2
  __IFNOT_45c15b49_7329_48c8_bb76_f73433912bd8:
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
  JMP	__ITER__START__e58fbe7f_d04c_40c8_aaeb_22afce13c6dc
  __ITER__END__e58fbe7f_d04c_40c8_aaeb_22afce13c6dc:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div32by24@ret + 0
  SEP	#$20
  STA	__div32by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div32by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div32by24@start + 2
  __ITER__START__a4d84e89_5e66_4af0_91b9_49290c2ab062:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_06b61f19_40c2_413d_978e_b32c9ecbbeb2
  BNE	__CMP_YES_06b61f19_40c2_413d_978e_b32c9ecbbeb2
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_06b61f19_40c2_413d_978e_b32c9ecbbeb2
  BNE	__CMP_YES_06b61f19_40c2_413d_978e_b32c9ecbbeb2
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_06b61f19_40c2_413d_978e_b32c9ecbbeb2
  BNE	__CMP_YES_06b61f19_40c2_413d_978e_b32c9ecbbeb2
  JMP	__CMP_NO_06b61f19_40c2_413d_978e_b32c9ecbbeb2
  __CMP_YES_06b61f19_40c2_413d_978e_b32c9ecbbeb2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_06b61f19_40c2_413d_978e_b32c9ecbbeb2
  __CMP_NO_06b61f19_40c2_413d_978e_b32c9ecbbeb2:
  SEP	#$20
  LDA	#$00
  __CMP_END_06b61f19_40c2_413d_978e_b32c9ecbbeb2:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a4d84e89_5e66_4af0_91b9_49290c2ab062
  :
  
  REP	#$20
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
  BNE	__IFNOT_077171ed_1af9_4111_a87b_4bf6922bd2d8
  JMP	__ITER__END__a4d84e89_5e66_4af0_91b9_49290c2ab062
  __IFNOT_077171ed_1af9_4111_a87b_4bf6922bd2d8:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div32by24@start + 0
  ASL
  STA	__div32by24@start + 0
  SEP	#$20
  LDA	__div32by24@start + 2
  ROL
  STA	__div32by24@start + 2
  JMP	__ITER__START__a4d84e89_5e66_4af0_91b9_49290c2ab062
  __ITER__END__a4d84e89_5e66_4af0_91b9_49290c2ab062:
  __ITER__START__6208bc6c_2189_4715_9835_c70bf7e5fde5:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__6208bc6c_2189_4715_9835_c70bf7e5fde5
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_397f12be_7a5a_469f_b675_3156c7472f1d
  BNE	__CMP_YES_397f12be_7a5a_469f_b675_3156c7472f1d
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_397f12be_7a5a_469f_b675_3156c7472f1d
  BNE	__CMP_YES_397f12be_7a5a_469f_b675_3156c7472f1d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_397f12be_7a5a_469f_b675_3156c7472f1d
  BNE	__CMP_YES_397f12be_7a5a_469f_b675_3156c7472f1d
  JMP	__CMP_YES_397f12be_7a5a_469f_b675_3156c7472f1d
  __CMP_YES_397f12be_7a5a_469f_b675_3156c7472f1d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_397f12be_7a5a_469f_b675_3156c7472f1d
  __CMP_NO_397f12be_7a5a_469f_b675_3156c7472f1d:
  SEP	#$20
  LDA	#$00
  __CMP_END_397f12be_7a5a_469f_b675_3156c7472f1d:
  BEQ	__IFNOT_606f3cce_5936_448d_89ca_3e6dca83b09a
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
  REP	#$20
  LDA	__div32by24@ret + 0
  ADC	__div32by24@start + 0
  STA	__div32by24@ret + 0
  SEP	#$20
  LDA	__div32by24@ret + 2
  ADC	__div32by24@start + 2
  STA	__div32by24@ret + 2
  __IFNOT_606f3cce_5936_448d_89ca_3e6dca83b09a:
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
  JMP	__ITER__START__6208bc6c_2189_4715_9835_c70bf7e5fde5
  __ITER__END__6208bc6c_2189_4715_9835_c70bf7e5fde5:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div64by24@ret + 0
  SEP	#$20
  STA	__div64by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div64by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div64by24@start + 2
  __ITER__START__dfd0c696_4603_4963_a327_c6c6a81a4285:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  BNE	__CMP_YES_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  BNE	__CMP_YES_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  BNE	__CMP_YES_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  BNE	__CMP_YES_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  BNE	__CMP_YES_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  JMP	__CMP_NO_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  __CMP_YES_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5
  __CMP_NO_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5:
  SEP	#$20
  LDA	#$00
  __CMP_END_d6563d4b_7ce4_410b_8e97_ecc5b33b0bd5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__dfd0c696_4603_4963_a327_c6c6a81a4285
  :
  
  REP	#$20
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
  BNE	__IFNOT_656ea961_49fe_4cc3_b508_8313c9a0f276
  JMP	__ITER__END__dfd0c696_4603_4963_a327_c6c6a81a4285
  __IFNOT_656ea961_49fe_4cc3_b508_8313c9a0f276:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div64by24@start + 0
  ASL
  STA	__div64by24@start + 0
  SEP	#$20
  LDA	__div64by24@start + 2
  ROL
  STA	__div64by24@start + 2
  JMP	__ITER__START__dfd0c696_4603_4963_a327_c6c6a81a4285
  __ITER__END__dfd0c696_4603_4963_a327_c6c6a81a4285:
  __ITER__START__1b50b501_8194_4a45_bb4f_d9d72e38d657:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__1b50b501_8194_4a45_bb4f_d9d72e38d657
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_ab0174bc_3356_4aed_a2be_9f66e39133a7
  BNE	__CMP_YES_ab0174bc_3356_4aed_a2be_9f66e39133a7
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_ab0174bc_3356_4aed_a2be_9f66e39133a7
  BNE	__CMP_YES_ab0174bc_3356_4aed_a2be_9f66e39133a7
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_ab0174bc_3356_4aed_a2be_9f66e39133a7
  BNE	__CMP_YES_ab0174bc_3356_4aed_a2be_9f66e39133a7
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ab0174bc_3356_4aed_a2be_9f66e39133a7
  BNE	__CMP_YES_ab0174bc_3356_4aed_a2be_9f66e39133a7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ab0174bc_3356_4aed_a2be_9f66e39133a7
  BNE	__CMP_YES_ab0174bc_3356_4aed_a2be_9f66e39133a7
  JMP	__CMP_YES_ab0174bc_3356_4aed_a2be_9f66e39133a7
  __CMP_YES_ab0174bc_3356_4aed_a2be_9f66e39133a7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ab0174bc_3356_4aed_a2be_9f66e39133a7
  __CMP_NO_ab0174bc_3356_4aed_a2be_9f66e39133a7:
  SEP	#$20
  LDA	#$00
  __CMP_END_ab0174bc_3356_4aed_a2be_9f66e39133a7:
  BNE	:+
  JMP	__IFNOT_6885acf9_1b81_43a5_9813_8b1772859676
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
  REP	#$20
  LDA	__div64by24@ret + 0
  ADC	__div64by24@start + 0
  STA	__div64by24@ret + 0
  SEP	#$20
  LDA	__div64by24@ret + 2
  ADC	__div64by24@start + 2
  STA	__div64by24@ret + 2
  __IFNOT_6885acf9_1b81_43a5_9813_8b1772859676:
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
  JMP	__ITER__START__1b50b501_8194_4a45_bb4f_d9d72e38d657
  __ITER__END__1b50b501_8194_4a45_bb4f_d9d72e38d657:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div8by32@ret + 0
  SEP	#$20
  STA	__div8by32@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div8by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div8by32@start + 2
  __ITER__START__a0afcccb_378a_48d2_913e_1d6857e7f263:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_1540b0c1_4c2e_4dda_9214_988511fc3af9
  BNE	__CMP_YES_1540b0c1_4c2e_4dda_9214_988511fc3af9
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_1540b0c1_4c2e_4dda_9214_988511fc3af9
  BNE	__CMP_YES_1540b0c1_4c2e_4dda_9214_988511fc3af9
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1540b0c1_4c2e_4dda_9214_988511fc3af9
  BNE	__CMP_YES_1540b0c1_4c2e_4dda_9214_988511fc3af9
  JMP	__CMP_NO_1540b0c1_4c2e_4dda_9214_988511fc3af9
  __CMP_YES_1540b0c1_4c2e_4dda_9214_988511fc3af9:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1540b0c1_4c2e_4dda_9214_988511fc3af9
  __CMP_NO_1540b0c1_4c2e_4dda_9214_988511fc3af9:
  SEP	#$20
  LDA	#$00
  __CMP_END_1540b0c1_4c2e_4dda_9214_988511fc3af9:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a0afcccb_378a_48d2_913e_1d6857e7f263
  :
  
  REP	#$20
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
  BNE	__IFNOT_2b1206bd_cda2_4421_bdd9_ded02a74c90d
  JMP	__ITER__END__a0afcccb_378a_48d2_913e_1d6857e7f263
  __IFNOT_2b1206bd_cda2_4421_bdd9_ded02a74c90d:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div8by32@start + 0
  ASL
  STA	__div8by32@start + 0
  SEP	#$20
  LDA	__div8by32@start + 2
  ROL
  STA	__div8by32@start + 2
  JMP	__ITER__START__a0afcccb_378a_48d2_913e_1d6857e7f263
  __ITER__END__a0afcccb_378a_48d2_913e_1d6857e7f263:
  __ITER__START__fbfb798e_69dc_43e6_9f15_1bd3618a3e98:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__fbfb798e_69dc_43e6_9f15_1bd3618a3e98
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_66bfc89a_134d_4965_b9f8_796f18e62718
  BNE	__CMP_YES_66bfc89a_134d_4965_b9f8_796f18e62718
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_66bfc89a_134d_4965_b9f8_796f18e62718
  BNE	__CMP_YES_66bfc89a_134d_4965_b9f8_796f18e62718
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_66bfc89a_134d_4965_b9f8_796f18e62718
  BNE	__CMP_YES_66bfc89a_134d_4965_b9f8_796f18e62718
  JMP	__CMP_YES_66bfc89a_134d_4965_b9f8_796f18e62718
  __CMP_YES_66bfc89a_134d_4965_b9f8_796f18e62718:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_66bfc89a_134d_4965_b9f8_796f18e62718
  __CMP_NO_66bfc89a_134d_4965_b9f8_796f18e62718:
  SEP	#$20
  LDA	#$00
  __CMP_END_66bfc89a_134d_4965_b9f8_796f18e62718:
  BEQ	__IFNOT_8e2e2162_9cdc_4421_8390_3a53c0aa76a1
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
  REP	#$20
  LDA	__div8by32@ret + 0
  ADC	__div8by32@start + 0
  STA	__div8by32@ret + 0
  SEP	#$20
  LDA	__div8by32@ret + 2
  ADC	__div8by32@start + 2
  STA	__div8by32@ret + 2
  __IFNOT_8e2e2162_9cdc_4421_8390_3a53c0aa76a1:
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
  JMP	__ITER__START__fbfb798e_69dc_43e6_9f15_1bd3618a3e98
  __ITER__END__fbfb798e_69dc_43e6_9f15_1bd3618a3e98:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div16by32@ret + 0
  SEP	#$20
  STA	__div16by32@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div16by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div16by32@start + 2
  __ITER__START__e87775d7_725a_4862_a045_f6df6c77d0c5:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_d24713cc_641b_4a90_a255_5d192dc42e9c
  BNE	__CMP_YES_d24713cc_641b_4a90_a255_5d192dc42e9c
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d24713cc_641b_4a90_a255_5d192dc42e9c
  BNE	__CMP_YES_d24713cc_641b_4a90_a255_5d192dc42e9c
  JMP	__CMP_NO_d24713cc_641b_4a90_a255_5d192dc42e9c
  __CMP_YES_d24713cc_641b_4a90_a255_5d192dc42e9c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d24713cc_641b_4a90_a255_5d192dc42e9c
  __CMP_NO_d24713cc_641b_4a90_a255_5d192dc42e9c:
  SEP	#$20
  LDA	#$00
  __CMP_END_d24713cc_641b_4a90_a255_5d192dc42e9c:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e87775d7_725a_4862_a045_f6df6c77d0c5
  :
  
  REP	#$20
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
  BNE	__IFNOT_763ab5e3_dbb3_4658_91f4_32c0613b3689
  JMP	__ITER__END__e87775d7_725a_4862_a045_f6df6c77d0c5
  __IFNOT_763ab5e3_dbb3_4658_91f4_32c0613b3689:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div16by32@start + 0
  ASL
  STA	__div16by32@start + 0
  SEP	#$20
  LDA	__div16by32@start + 2
  ROL
  STA	__div16by32@start + 2
  JMP	__ITER__START__e87775d7_725a_4862_a045_f6df6c77d0c5
  __ITER__END__e87775d7_725a_4862_a045_f6df6c77d0c5:
  __ITER__START__1cdd6f85_4642_4e4f_91a3_96ed7f707620:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__1cdd6f85_4642_4e4f_91a3_96ed7f707620
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3e221e4c_212b_40ad_8bf5_38ec4b43945e
  BNE	__CMP_YES_3e221e4c_212b_40ad_8bf5_38ec4b43945e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3e221e4c_212b_40ad_8bf5_38ec4b43945e
  BNE	__CMP_YES_3e221e4c_212b_40ad_8bf5_38ec4b43945e
  JMP	__CMP_YES_3e221e4c_212b_40ad_8bf5_38ec4b43945e
  __CMP_YES_3e221e4c_212b_40ad_8bf5_38ec4b43945e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3e221e4c_212b_40ad_8bf5_38ec4b43945e
  __CMP_NO_3e221e4c_212b_40ad_8bf5_38ec4b43945e:
  SEP	#$20
  LDA	#$00
  __CMP_END_3e221e4c_212b_40ad_8bf5_38ec4b43945e:
  BEQ	__IFNOT_b449ff5c_46c0_4225_9a43_fe7f23f237d8
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  REP	#$20
  LDA	__div16by32@ret + 0
  ADC	__div16by32@start + 0
  STA	__div16by32@ret + 0
  SEP	#$20
  LDA	__div16by32@ret + 2
  ADC	__div16by32@start + 2
  STA	__div16by32@ret + 2
  __IFNOT_b449ff5c_46c0_4225_9a43_fe7f23f237d8:
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
  JMP	__ITER__START__1cdd6f85_4642_4e4f_91a3_96ed7f707620
  __ITER__END__1cdd6f85_4642_4e4f_91a3_96ed7f707620:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div24by32@ret + 0
  SEP	#$20
  STA	__div24by32@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div24by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div24by32@start + 2
  __ITER__START__73083875_c03d_42a7_b38e_bbd199f66443:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_1501b837_79c3_427d_ad39_3101587e1ba6
  BNE	__CMP_YES_1501b837_79c3_427d_ad39_3101587e1ba6
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_1501b837_79c3_427d_ad39_3101587e1ba6
  BNE	__CMP_YES_1501b837_79c3_427d_ad39_3101587e1ba6
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1501b837_79c3_427d_ad39_3101587e1ba6
  BNE	__CMP_YES_1501b837_79c3_427d_ad39_3101587e1ba6
  JMP	__CMP_NO_1501b837_79c3_427d_ad39_3101587e1ba6
  __CMP_YES_1501b837_79c3_427d_ad39_3101587e1ba6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1501b837_79c3_427d_ad39_3101587e1ba6
  __CMP_NO_1501b837_79c3_427d_ad39_3101587e1ba6:
  SEP	#$20
  LDA	#$00
  __CMP_END_1501b837_79c3_427d_ad39_3101587e1ba6:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__73083875_c03d_42a7_b38e_bbd199f66443
  :
  
  REP	#$20
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
  BNE	__IFNOT_3c93dff6_24b8_4695_9763_0dd1aaa82b25
  JMP	__ITER__END__73083875_c03d_42a7_b38e_bbd199f66443
  __IFNOT_3c93dff6_24b8_4695_9763_0dd1aaa82b25:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div24by32@start + 0
  ASL
  STA	__div24by32@start + 0
  SEP	#$20
  LDA	__div24by32@start + 2
  ROL
  STA	__div24by32@start + 2
  JMP	__ITER__START__73083875_c03d_42a7_b38e_bbd199f66443
  __ITER__END__73083875_c03d_42a7_b38e_bbd199f66443:
  __ITER__START__9e550fd1_45a8_4e1d_9aff_95b5ef89c610:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__9e550fd1_45a8_4e1d_9aff_95b5ef89c610
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_b5b7c57b_0f35_4918_9d92_dccaad6253f4
  BNE	__CMP_YES_b5b7c57b_0f35_4918_9d92_dccaad6253f4
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b5b7c57b_0f35_4918_9d92_dccaad6253f4
  BNE	__CMP_YES_b5b7c57b_0f35_4918_9d92_dccaad6253f4
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b5b7c57b_0f35_4918_9d92_dccaad6253f4
  BNE	__CMP_YES_b5b7c57b_0f35_4918_9d92_dccaad6253f4
  JMP	__CMP_YES_b5b7c57b_0f35_4918_9d92_dccaad6253f4
  __CMP_YES_b5b7c57b_0f35_4918_9d92_dccaad6253f4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b5b7c57b_0f35_4918_9d92_dccaad6253f4
  __CMP_NO_b5b7c57b_0f35_4918_9d92_dccaad6253f4:
  SEP	#$20
  LDA	#$00
  __CMP_END_b5b7c57b_0f35_4918_9d92_dccaad6253f4:
  BEQ	__IFNOT_64595571_200e_43c4_a66c_98969f7a9fdd
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
  REP	#$20
  LDA	__div24by32@ret + 0
  ADC	__div24by32@start + 0
  STA	__div24by32@ret + 0
  SEP	#$20
  LDA	__div24by32@ret + 2
  ADC	__div24by32@start + 2
  STA	__div24by32@ret + 2
  __IFNOT_64595571_200e_43c4_a66c_98969f7a9fdd:
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
  JMP	__ITER__START__9e550fd1_45a8_4e1d_9aff_95b5ef89c610
  __ITER__END__9e550fd1_45a8_4e1d_9aff_95b5ef89c610:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div32by32@ret + 0
  STA	__div32by32@ret + 2
  LDA	#$0001
  STA	__div32by32@start + 0
  LDA	#$0000
  STA	__div32by32@start + 2
  __ITER__START__af8eff93_b824_4a49_a9bf_f66fa7e40ccc:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e7853098_7949_403d_abe4_98aa15f5c7e4
  BNE	__CMP_YES_e7853098_7949_403d_abe4_98aa15f5c7e4
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e7853098_7949_403d_abe4_98aa15f5c7e4
  BNE	__CMP_YES_e7853098_7949_403d_abe4_98aa15f5c7e4
  JMP	__CMP_NO_e7853098_7949_403d_abe4_98aa15f5c7e4
  __CMP_YES_e7853098_7949_403d_abe4_98aa15f5c7e4:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e7853098_7949_403d_abe4_98aa15f5c7e4
  __CMP_NO_e7853098_7949_403d_abe4_98aa15f5c7e4:
  SEP	#$20
  LDA	#$00
  __CMP_END_e7853098_7949_403d_abe4_98aa15f5c7e4:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__af8eff93_b824_4a49_a9bf_f66fa7e40ccc
  :
  
  REP	#$20
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
  BNE	__IFNOT_ba09ccee_1080_4034_8ed5_a0f95d863051
  JMP	__ITER__END__af8eff93_b824_4a49_a9bf_f66fa7e40ccc
  __IFNOT_ba09ccee_1080_4034_8ed5_a0f95d863051:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div32by32@start + 0
  ASL
  STA	__div32by32@start + 0
  REP	#$20
  LDA	__div32by32@start + 2
  ROL
  STA	__div32by32@start + 2
  JMP	__ITER__START__af8eff93_b824_4a49_a9bf_f66fa7e40ccc
  __ITER__END__af8eff93_b824_4a49_a9bf_f66fa7e40ccc:
  __ITER__START__066a123b_2e22_4f16_9bae_291b558f6130:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__066a123b_2e22_4f16_9bae_291b558f6130
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c06f233a_f04a_4346_9857_36518d374162
  BNE	__CMP_YES_c06f233a_f04a_4346_9857_36518d374162
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c06f233a_f04a_4346_9857_36518d374162
  BNE	__CMP_YES_c06f233a_f04a_4346_9857_36518d374162
  JMP	__CMP_YES_c06f233a_f04a_4346_9857_36518d374162
  __CMP_YES_c06f233a_f04a_4346_9857_36518d374162:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c06f233a_f04a_4346_9857_36518d374162
  __CMP_NO_c06f233a_f04a_4346_9857_36518d374162:
  SEP	#$20
  LDA	#$00
  __CMP_END_c06f233a_f04a_4346_9857_36518d374162:
  BEQ	__IFNOT_f69359c9_4135_4449_82dd_d77c461d3bb3
  SEC
  REP	#$20
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
  REP	#$20
  LDA	__div32by32@ret + 0
  ADC	__div32by32@start + 0
  STA	__div32by32@ret + 0
  REP	#$20
  LDA	__div32by32@ret + 2
  ADC	__div32by32@start + 2
  STA	__div32by32@ret + 2
  __IFNOT_f69359c9_4135_4449_82dd_d77c461d3bb3:
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
  JMP	__ITER__START__066a123b_2e22_4f16_9bae_291b558f6130
  __ITER__END__066a123b_2e22_4f16_9bae_291b558f6130:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div64by32@ret + 0
  STA	__div64by32@ret + 2
  LDA	#$0001
  STA	__div64by32@start + 0
  LDA	#$0000
  STA	__div64by32@start + 2
  __ITER__START__3c4943f0_7d03_4c58_8365_1e2ef484e075:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_ab5f7051_019c_4f85_8c7b_397d611f5040
  BNE	__CMP_YES_ab5f7051_019c_4f85_8c7b_397d611f5040
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_ab5f7051_019c_4f85_8c7b_397d611f5040
  BNE	__CMP_YES_ab5f7051_019c_4f85_8c7b_397d611f5040
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_ab5f7051_019c_4f85_8c7b_397d611f5040
  BNE	__CMP_YES_ab5f7051_019c_4f85_8c7b_397d611f5040
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ab5f7051_019c_4f85_8c7b_397d611f5040
  BNE	__CMP_YES_ab5f7051_019c_4f85_8c7b_397d611f5040
  JMP	__CMP_NO_ab5f7051_019c_4f85_8c7b_397d611f5040
  __CMP_YES_ab5f7051_019c_4f85_8c7b_397d611f5040:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ab5f7051_019c_4f85_8c7b_397d611f5040
  __CMP_NO_ab5f7051_019c_4f85_8c7b_397d611f5040:
  SEP	#$20
  LDA	#$00
  __CMP_END_ab5f7051_019c_4f85_8c7b_397d611f5040:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__3c4943f0_7d03_4c58_8365_1e2ef484e075
  :
  
  REP	#$20
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
  BNE	__IFNOT_3bfd8575_d3f3_4d28_bf41_7415d01b4112
  JMP	__ITER__END__3c4943f0_7d03_4c58_8365_1e2ef484e075
  __IFNOT_3bfd8575_d3f3_4d28_bf41_7415d01b4112:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__div64by32@start + 0
  ASL
  STA	__div64by32@start + 0
  REP	#$20
  LDA	__div64by32@start + 2
  ROL
  STA	__div64by32@start + 2
  JMP	__ITER__START__3c4943f0_7d03_4c58_8365_1e2ef484e075
  __ITER__END__3c4943f0_7d03_4c58_8365_1e2ef484e075:
  __ITER__START__e44cca98_aab8_46da_a0b2_5fcdda1c49cd:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__e44cca98_aab8_46da_a0b2_5fcdda1c49cd
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_cc2fd649_9067_430b_9f17_8ef390f92b26
  BNE	__CMP_YES_cc2fd649_9067_430b_9f17_8ef390f92b26
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_cc2fd649_9067_430b_9f17_8ef390f92b26
  BNE	__CMP_YES_cc2fd649_9067_430b_9f17_8ef390f92b26
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_cc2fd649_9067_430b_9f17_8ef390f92b26
  BNE	__CMP_YES_cc2fd649_9067_430b_9f17_8ef390f92b26
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cc2fd649_9067_430b_9f17_8ef390f92b26
  BNE	__CMP_YES_cc2fd649_9067_430b_9f17_8ef390f92b26
  JMP	__CMP_YES_cc2fd649_9067_430b_9f17_8ef390f92b26
  __CMP_YES_cc2fd649_9067_430b_9f17_8ef390f92b26:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cc2fd649_9067_430b_9f17_8ef390f92b26
  __CMP_NO_cc2fd649_9067_430b_9f17_8ef390f92b26:
  SEP	#$20
  LDA	#$00
  __CMP_END_cc2fd649_9067_430b_9f17_8ef390f92b26:
  BEQ	__IFNOT_696a67b8_92bb_43e6_81f3_8410d4b7ee8a
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
  REP	#$20
  LDA	__div64by32@ret + 0
  ADC	__div64by32@start + 0
  STA	__div64by32@ret + 0
  REP	#$20
  LDA	__div64by32@ret + 2
  ADC	__div64by32@start + 2
  STA	__div64by32@ret + 2
  __IFNOT_696a67b8_92bb_43e6_81f3_8410d4b7ee8a:
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
  JMP	__ITER__START__e44cca98_aab8_46da_a0b2_5fcdda1c49cd
  __ITER__END__e44cca98_aab8_46da_a0b2_5fcdda1c49cd:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div8by64@ret + 0
  SEP	#$20
  STA	__div8by64@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div8by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div8by64@start + 2
  __ITER__START__26eab1fc_64a3_429b_b364_94ea725e3021:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  BNE	__CMP_YES_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  BNE	__CMP_YES_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  BNE	__CMP_YES_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  BNE	__CMP_YES_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  BNE	__CMP_YES_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  JMP	__CMP_NO_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  __CMP_YES_2d0c8f27_50b1_41a0_9b16_120182ea8b0d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2d0c8f27_50b1_41a0_9b16_120182ea8b0d
  __CMP_NO_2d0c8f27_50b1_41a0_9b16_120182ea8b0d:
  SEP	#$20
  LDA	#$00
  __CMP_END_2d0c8f27_50b1_41a0_9b16_120182ea8b0d:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__26eab1fc_64a3_429b_b364_94ea725e3021
  :
  
  REP	#$20
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
  BNE	__IFNOT_62e1aa84_ed5c_4cca_a6c8_998567324a45
  JMP	__ITER__END__26eab1fc_64a3_429b_b364_94ea725e3021
  __IFNOT_62e1aa84_ed5c_4cca_a6c8_998567324a45:
  REP	#$20
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
  REP	#$20
  LDA	__div8by64@start + 0
  ASL
  STA	__div8by64@start + 0
  SEP	#$20
  LDA	__div8by64@start + 2
  ROL
  STA	__div8by64@start + 2
  JMP	__ITER__START__26eab1fc_64a3_429b_b364_94ea725e3021
  __ITER__END__26eab1fc_64a3_429b_b364_94ea725e3021:
  __ITER__START__4d75db9b_0363_49b2_9079_3d6d359fa33c:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__4d75db9b_0363_49b2_9079_3d6d359fa33c
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  BNE	__CMP_YES_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  BNE	__CMP_YES_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  BNE	__CMP_YES_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  BNE	__CMP_YES_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  BNE	__CMP_YES_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  JMP	__CMP_YES_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  __CMP_YES_e5e3495d_79d3_497f_9bdb_1eeb6e3df619:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e5e3495d_79d3_497f_9bdb_1eeb6e3df619
  __CMP_NO_e5e3495d_79d3_497f_9bdb_1eeb6e3df619:
  SEP	#$20
  LDA	#$00
  __CMP_END_e5e3495d_79d3_497f_9bdb_1eeb6e3df619:
  BEQ	__IFNOT_62a04ac6_bf32_43be_be7f_9fcfd2747659
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
  REP	#$20
  LDA	__div8by64@ret + 0
  ADC	__div8by64@start + 0
  STA	__div8by64@ret + 0
  SEP	#$20
  LDA	__div8by64@ret + 2
  ADC	__div8by64@start + 2
  STA	__div8by64@ret + 2
  __IFNOT_62a04ac6_bf32_43be_be7f_9fcfd2747659:
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
  JMP	__ITER__START__4d75db9b_0363_49b2_9079_3d6d359fa33c
  __ITER__END__4d75db9b_0363_49b2_9079_3d6d359fa33c:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div16by64@ret + 0
  SEP	#$20
  STA	__div16by64@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div16by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div16by64@start + 2
  __ITER__START__32d0492e_f21f_4417_858d_507b826c375d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  BNE	__CMP_YES_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  BNE	__CMP_YES_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  BNE	__CMP_YES_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  BNE	__CMP_YES_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  JMP	__CMP_NO_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  __CMP_YES_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5
  __CMP_NO_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5:
  SEP	#$20
  LDA	#$00
  __CMP_END_0e7fb5d9_5ac4_4492_a5f5_71b40b4e5bd5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__32d0492e_f21f_4417_858d_507b826c375d
  :
  
  REP	#$20
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
  BNE	__IFNOT_1df26f05_fd64_47ae_90fc_82ff79df1328
  JMP	__ITER__END__32d0492e_f21f_4417_858d_507b826c375d
  __IFNOT_1df26f05_fd64_47ae_90fc_82ff79df1328:
  REP	#$20
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
  REP	#$20
  LDA	__div16by64@start + 0
  ASL
  STA	__div16by64@start + 0
  SEP	#$20
  LDA	__div16by64@start + 2
  ROL
  STA	__div16by64@start + 2
  JMP	__ITER__START__32d0492e_f21f_4417_858d_507b826c375d
  __ITER__END__32d0492e_f21f_4417_858d_507b826c375d:
  __ITER__START__b493a092_eb91_4d19_9c8b_b56bd1aa03d3:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__b493a092_eb91_4d19_9c8b_b56bd1aa03d3
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_59626de4_70b2_47ee_a29d_75e42738efbf
  BNE	__CMP_YES_59626de4_70b2_47ee_a29d_75e42738efbf
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_59626de4_70b2_47ee_a29d_75e42738efbf
  BNE	__CMP_YES_59626de4_70b2_47ee_a29d_75e42738efbf
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_59626de4_70b2_47ee_a29d_75e42738efbf
  BNE	__CMP_YES_59626de4_70b2_47ee_a29d_75e42738efbf
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_59626de4_70b2_47ee_a29d_75e42738efbf
  BNE	__CMP_YES_59626de4_70b2_47ee_a29d_75e42738efbf
  JMP	__CMP_YES_59626de4_70b2_47ee_a29d_75e42738efbf
  __CMP_YES_59626de4_70b2_47ee_a29d_75e42738efbf:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_59626de4_70b2_47ee_a29d_75e42738efbf
  __CMP_NO_59626de4_70b2_47ee_a29d_75e42738efbf:
  SEP	#$20
  LDA	#$00
  __CMP_END_59626de4_70b2_47ee_a29d_75e42738efbf:
  BEQ	__IFNOT_f0d1af4a_0bf3_476a_b161_f5cadec98ca2
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  REP	#$20
  LDA	__div16by64@ret + 0
  ADC	__div16by64@start + 0
  STA	__div16by64@ret + 0
  SEP	#$20
  LDA	__div16by64@ret + 2
  ADC	__div16by64@start + 2
  STA	__div16by64@ret + 2
  __IFNOT_f0d1af4a_0bf3_476a_b161_f5cadec98ca2:
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
  JMP	__ITER__START__b493a092_eb91_4d19_9c8b_b56bd1aa03d3
  __ITER__END__b493a092_eb91_4d19_9c8b_b56bd1aa03d3:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div24by64@ret + 0
  SEP	#$20
  STA	__div24by64@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__div24by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__div24by64@start + 2
  __ITER__START__062146b3_0e28_4dd9_a3e0_850dce752b80:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  BNE	__CMP_YES_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  BNE	__CMP_YES_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  BNE	__CMP_YES_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  BNE	__CMP_YES_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  BNE	__CMP_YES_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  JMP	__CMP_NO_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  __CMP_YES_e11819b5_c2c4_42ce_9e73_60c1f1b97d90:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e11819b5_c2c4_42ce_9e73_60c1f1b97d90
  __CMP_NO_e11819b5_c2c4_42ce_9e73_60c1f1b97d90:
  SEP	#$20
  LDA	#$00
  __CMP_END_e11819b5_c2c4_42ce_9e73_60c1f1b97d90:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__062146b3_0e28_4dd9_a3e0_850dce752b80
  :
  
  REP	#$20
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
  BNE	__IFNOT_2d1fcd50_cd62_47f9_9e2a_1028f3087f41
  JMP	__ITER__END__062146b3_0e28_4dd9_a3e0_850dce752b80
  __IFNOT_2d1fcd50_cd62_47f9_9e2a_1028f3087f41:
  REP	#$20
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
  REP	#$20
  LDA	__div24by64@start + 0
  ASL
  STA	__div24by64@start + 0
  SEP	#$20
  LDA	__div24by64@start + 2
  ROL
  STA	__div24by64@start + 2
  JMP	__ITER__START__062146b3_0e28_4dd9_a3e0_850dce752b80
  __ITER__END__062146b3_0e28_4dd9_a3e0_850dce752b80:
  __ITER__START__ba2e49a0_489c_4859_b455_7e8052ab3719:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__ba2e49a0_489c_4859_b455_7e8052ab3719
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_255fc415_ba6d_4f28_81b8_d44329a57b27
  BNE	__CMP_YES_255fc415_ba6d_4f28_81b8_d44329a57b27
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_255fc415_ba6d_4f28_81b8_d44329a57b27
  BNE	__CMP_YES_255fc415_ba6d_4f28_81b8_d44329a57b27
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_255fc415_ba6d_4f28_81b8_d44329a57b27
  BNE	__CMP_YES_255fc415_ba6d_4f28_81b8_d44329a57b27
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_255fc415_ba6d_4f28_81b8_d44329a57b27
  BNE	__CMP_YES_255fc415_ba6d_4f28_81b8_d44329a57b27
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_255fc415_ba6d_4f28_81b8_d44329a57b27
  BNE	__CMP_YES_255fc415_ba6d_4f28_81b8_d44329a57b27
  JMP	__CMP_YES_255fc415_ba6d_4f28_81b8_d44329a57b27
  __CMP_YES_255fc415_ba6d_4f28_81b8_d44329a57b27:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_255fc415_ba6d_4f28_81b8_d44329a57b27
  __CMP_NO_255fc415_ba6d_4f28_81b8_d44329a57b27:
  SEP	#$20
  LDA	#$00
  __CMP_END_255fc415_ba6d_4f28_81b8_d44329a57b27:
  BEQ	__IFNOT_1b2cacf8_2b0b_4b13_80c0_b21b6c477f9c
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
  REP	#$20
  LDA	__div24by64@ret + 0
  ADC	__div24by64@start + 0
  STA	__div24by64@ret + 0
  SEP	#$20
  LDA	__div24by64@ret + 2
  ADC	__div24by64@start + 2
  STA	__div24by64@ret + 2
  __IFNOT_1b2cacf8_2b0b_4b13_80c0_b21b6c477f9c:
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
  JMP	__ITER__START__ba2e49a0_489c_4859_b455_7e8052ab3719
  __ITER__END__ba2e49a0_489c_4859_b455_7e8052ab3719:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__div32by64@ret + 0
  STA	__div32by64@ret + 2
  LDA	#$0001
  STA	__div32by64@start + 0
  LDA	#$0000
  STA	__div32by64@start + 2
  __ITER__START__d92f9577_4698_45fc_ae26_5ee1e2f018ff:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_9bf5460f_9521_46e0_8561_d664810275a7
  BNE	__CMP_YES_9bf5460f_9521_46e0_8561_d664810275a7
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_9bf5460f_9521_46e0_8561_d664810275a7
  BNE	__CMP_YES_9bf5460f_9521_46e0_8561_d664810275a7
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_9bf5460f_9521_46e0_8561_d664810275a7
  BNE	__CMP_YES_9bf5460f_9521_46e0_8561_d664810275a7
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_9bf5460f_9521_46e0_8561_d664810275a7
  BNE	__CMP_YES_9bf5460f_9521_46e0_8561_d664810275a7
  JMP	__CMP_NO_9bf5460f_9521_46e0_8561_d664810275a7
  __CMP_YES_9bf5460f_9521_46e0_8561_d664810275a7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_9bf5460f_9521_46e0_8561_d664810275a7
  __CMP_NO_9bf5460f_9521_46e0_8561_d664810275a7:
  SEP	#$20
  LDA	#$00
  __CMP_END_9bf5460f_9521_46e0_8561_d664810275a7:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d92f9577_4698_45fc_ae26_5ee1e2f018ff
  :
  
  REP	#$20
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
  BNE	__IFNOT_cf7a6115_aa23_46f7_b32f_c134227fe203
  JMP	__ITER__END__d92f9577_4698_45fc_ae26_5ee1e2f018ff
  __IFNOT_cf7a6115_aa23_46f7_b32f_c134227fe203:
  REP	#$20
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
  REP	#$20
  LDA	__div32by64@start + 0
  ASL
  STA	__div32by64@start + 0
  REP	#$20
  LDA	__div32by64@start + 2
  ROL
  STA	__div32by64@start + 2
  JMP	__ITER__START__d92f9577_4698_45fc_ae26_5ee1e2f018ff
  __ITER__END__d92f9577_4698_45fc_ae26_5ee1e2f018ff:
  __ITER__START__cda9fa44_0117_43bd_adab_48466a5f232e:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__cda9fa44_0117_43bd_adab_48466a5f232e
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  BNE	__CMP_YES_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  BNE	__CMP_YES_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  BNE	__CMP_YES_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  BNE	__CMP_YES_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  JMP	__CMP_YES_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  __CMP_YES_db3f2eae_143e_45d0_b71d_564a9e9a9c9f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_db3f2eae_143e_45d0_b71d_564a9e9a9c9f
  __CMP_NO_db3f2eae_143e_45d0_b71d_564a9e9a9c9f:
  SEP	#$20
  LDA	#$00
  __CMP_END_db3f2eae_143e_45d0_b71d_564a9e9a9c9f:
  BEQ	__IFNOT_d37ff9a0_845b_4342_b282_56fe861c31c1
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
  REP	#$20
  LDA	__div32by64@ret + 0
  ADC	__div32by64@start + 0
  STA	__div32by64@ret + 0
  REP	#$20
  LDA	__div32by64@ret + 2
  ADC	__div32by64@start + 2
  STA	__div32by64@ret + 2
  __IFNOT_d37ff9a0_845b_4342_b282_56fe861c31c1:
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
  JMP	__ITER__START__cda9fa44_0117_43bd_adab_48466a5f232e
  __ITER__END__cda9fa44_0117_43bd_adab_48466a5f232e:
  REP	#$20
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
  __ITER__START__c11a3e83_8ffe_4c02_8712_8b49a740c5a7:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_c09383de_408e_4394_b52a_e9f33fedb7ca
  BNE	__CMP_YES_c09383de_408e_4394_b52a_e9f33fedb7ca
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_c09383de_408e_4394_b52a_e9f33fedb7ca
  BNE	__CMP_YES_c09383de_408e_4394_b52a_e9f33fedb7ca
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c09383de_408e_4394_b52a_e9f33fedb7ca
  BNE	__CMP_YES_c09383de_408e_4394_b52a_e9f33fedb7ca
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c09383de_408e_4394_b52a_e9f33fedb7ca
  BNE	__CMP_YES_c09383de_408e_4394_b52a_e9f33fedb7ca
  JMP	__CMP_NO_c09383de_408e_4394_b52a_e9f33fedb7ca
  __CMP_YES_c09383de_408e_4394_b52a_e9f33fedb7ca:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c09383de_408e_4394_b52a_e9f33fedb7ca
  __CMP_NO_c09383de_408e_4394_b52a_e9f33fedb7ca:
  SEP	#$20
  LDA	#$00
  __CMP_END_c09383de_408e_4394_b52a_e9f33fedb7ca:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__c11a3e83_8ffe_4c02_8712_8b49a740c5a7
  :
  
  REP	#$20
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
  BNE	__IFNOT_1e2eab0f_9c4a_4a1a_93df_c233d71c350c
  JMP	__ITER__END__c11a3e83_8ffe_4c02_8712_8b49a740c5a7
  __IFNOT_1e2eab0f_9c4a_4a1a_93df_c233d71c350c:
  REP	#$20
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
  JMP	__ITER__START__c11a3e83_8ffe_4c02_8712_8b49a740c5a7
  __ITER__END__c11a3e83_8ffe_4c02_8712_8b49a740c5a7:
  __ITER__START__34824ce8_6877_487b_9a9f_bc02b01a2170:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__34824ce8_6877_487b_9a9f_bc02b01a2170
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_70b664c3_3500_46b1_bc5d_a6caa42b5073
  BNE	__CMP_YES_70b664c3_3500_46b1_bc5d_a6caa42b5073
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_70b664c3_3500_46b1_bc5d_a6caa42b5073
  BNE	__CMP_YES_70b664c3_3500_46b1_bc5d_a6caa42b5073
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_70b664c3_3500_46b1_bc5d_a6caa42b5073
  BNE	__CMP_YES_70b664c3_3500_46b1_bc5d_a6caa42b5073
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_70b664c3_3500_46b1_bc5d_a6caa42b5073
  BNE	__CMP_YES_70b664c3_3500_46b1_bc5d_a6caa42b5073
  JMP	__CMP_YES_70b664c3_3500_46b1_bc5d_a6caa42b5073
  __CMP_YES_70b664c3_3500_46b1_bc5d_a6caa42b5073:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_70b664c3_3500_46b1_bc5d_a6caa42b5073
  __CMP_NO_70b664c3_3500_46b1_bc5d_a6caa42b5073:
  SEP	#$20
  LDA	#$00
  __CMP_END_70b664c3_3500_46b1_bc5d_a6caa42b5073:
  BNE	:+
  JMP	__IFNOT_8c3ac1f8_deb2_48ef_bec0_49e8abd6262e
  :
  SEC
  REP	#$20
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
  __IFNOT_8c3ac1f8_deb2_48ef_bec0_49e8abd6262e:
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
  JMP	__ITER__START__34824ce8_6877_487b_9a9f_bc02b01a2170
  __ITER__END__34824ce8_6877_487b_9a9f_bc02b01a2170:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod8by16@ret + 0
  SEP	#$20
  STA	__mod8by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod8by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod8by16@start + 2
  __ITER__START__d7f2d4c6_040f_42e6_b373_5f003a22470e:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_00cd6d2d_ca44_41a1_8964_912e91c65e95
  BNE	__CMP_YES_00cd6d2d_ca44_41a1_8964_912e91c65e95
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_00cd6d2d_ca44_41a1_8964_912e91c65e95
  BNE	__CMP_YES_00cd6d2d_ca44_41a1_8964_912e91c65e95
  JMP	__CMP_NO_00cd6d2d_ca44_41a1_8964_912e91c65e95
  __CMP_YES_00cd6d2d_ca44_41a1_8964_912e91c65e95:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_00cd6d2d_ca44_41a1_8964_912e91c65e95
  __CMP_NO_00cd6d2d_ca44_41a1_8964_912e91c65e95:
  SEP	#$20
  LDA	#$00
  __CMP_END_00cd6d2d_ca44_41a1_8964_912e91c65e95:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__d7f2d4c6_040f_42e6_b373_5f003a22470e
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
  BNE	__IFNOT_0c192125_84a3_4972_82ee_9ac967647001
  JMP	__ITER__END__d7f2d4c6_040f_42e6_b373_5f003a22470e
  __IFNOT_0c192125_84a3_4972_82ee_9ac967647001:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod8by16@start + 0
  ASL
  STA	__mod8by16@start + 0
  SEP	#$20
  LDA	__mod8by16@start + 2
  ROL
  STA	__mod8by16@start + 2
  JMP	__ITER__START__d7f2d4c6_040f_42e6_b373_5f003a22470e
  __ITER__END__d7f2d4c6_040f_42e6_b373_5f003a22470e:
  __ITER__START__2e676c1b_a6e0_4763_8186_50497afb0f9b:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__2e676c1b_a6e0_4763_8186_50497afb0f9b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_a0da3424_226b_40e0_9d15_3160f273256b
  BNE	__CMP_YES_a0da3424_226b_40e0_9d15_3160f273256b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a0da3424_226b_40e0_9d15_3160f273256b
  BNE	__CMP_YES_a0da3424_226b_40e0_9d15_3160f273256b
  JMP	__CMP_YES_a0da3424_226b_40e0_9d15_3160f273256b
  __CMP_YES_a0da3424_226b_40e0_9d15_3160f273256b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a0da3424_226b_40e0_9d15_3160f273256b
  __CMP_NO_a0da3424_226b_40e0_9d15_3160f273256b:
  SEP	#$20
  LDA	#$00
  __CMP_END_a0da3424_226b_40e0_9d15_3160f273256b:
  BEQ	__IFNOT_0545632f_b86b_42aa_9fbb_0ec43ee87dc2
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
  REP	#$20
  LDA	__mod8by16@ret + 0
  ADC	__mod8by16@start + 0
  STA	__mod8by16@ret + 0
  SEP	#$20
  LDA	__mod8by16@ret + 2
  ADC	__mod8by16@start + 2
  STA	__mod8by16@ret + 2
  __IFNOT_0545632f_b86b_42aa_9fbb_0ec43ee87dc2:
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
  JMP	__ITER__START__2e676c1b_a6e0_4763_8186_50497afb0f9b
  __ITER__END__2e676c1b_a6e0_4763_8186_50497afb0f9b:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod16by16@ret + 0
  SEP	#$20
  STA	__mod16by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod16by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod16by16@start + 2
  __ITER__START__52dcfc52_1110_485b_a598_fe6e16694970:
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3f8c31eb_1c0e_49f2_b14e_540d690f6dac
  BNE	__CMP_YES_3f8c31eb_1c0e_49f2_b14e_540d690f6dac
  JMP	__CMP_NO_3f8c31eb_1c0e_49f2_b14e_540d690f6dac
  __CMP_YES_3f8c31eb_1c0e_49f2_b14e_540d690f6dac:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3f8c31eb_1c0e_49f2_b14e_540d690f6dac
  __CMP_NO_3f8c31eb_1c0e_49f2_b14e_540d690f6dac:
  SEP	#$20
  LDA	#$00
  __CMP_END_3f8c31eb_1c0e_49f2_b14e_540d690f6dac:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__52dcfc52_1110_485b_a598_fe6e16694970
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
  BNE	__IFNOT_ca1b70b1_5689_4b0c_9aa4_9f1afdc41e9f
  JMP	__ITER__END__52dcfc52_1110_485b_a598_fe6e16694970
  __IFNOT_ca1b70b1_5689_4b0c_9aa4_9f1afdc41e9f:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod16by16@start + 0
  ASL
  STA	__mod16by16@start + 0
  SEP	#$20
  LDA	__mod16by16@start + 2
  ROL
  STA	__mod16by16@start + 2
  JMP	__ITER__START__52dcfc52_1110_485b_a598_fe6e16694970
  __ITER__END__52dcfc52_1110_485b_a598_fe6e16694970:
  __ITER__START__7ac36850_688a_46fb_9c26_3a3cef75c66f:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__7ac36850_688a_46fb_9c26_3a3cef75c66f
  :
  CLC
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cc382278_3c02_4b6b_887a_6c8f5b6e8881
  BNE	__CMP_YES_cc382278_3c02_4b6b_887a_6c8f5b6e8881
  JMP	__CMP_YES_cc382278_3c02_4b6b_887a_6c8f5b6e8881
  __CMP_YES_cc382278_3c02_4b6b_887a_6c8f5b6e8881:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cc382278_3c02_4b6b_887a_6c8f5b6e8881
  __CMP_NO_cc382278_3c02_4b6b_887a_6c8f5b6e8881:
  SEP	#$20
  LDA	#$00
  __CMP_END_cc382278_3c02_4b6b_887a_6c8f5b6e8881:
  BEQ	__IFNOT_4061b057_90b9_42cd_9f3a_9e695532746d
  SEC
  REP	#$20
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  REP	#$20
  LDA	__mod16by16@ret + 0
  ADC	__mod16by16@start + 0
  STA	__mod16by16@ret + 0
  SEP	#$20
  LDA	__mod16by16@ret + 2
  ADC	__mod16by16@start + 2
  STA	__mod16by16@ret + 2
  __IFNOT_4061b057_90b9_42cd_9f3a_9e695532746d:
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
  JMP	__ITER__START__7ac36850_688a_46fb_9c26_3a3cef75c66f
  __ITER__END__7ac36850_688a_46fb_9c26_3a3cef75c66f:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod24by16@ret + 0
  SEP	#$20
  STA	__mod24by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod24by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod24by16@start + 2
  __ITER__START__743755e0_2b24_4f24_b0f7_d5e466033de2:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_a92573bb_f6f5_4604_9bd5_cd94959066be
  BNE	__CMP_YES_a92573bb_f6f5_4604_9bd5_cd94959066be
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_a92573bb_f6f5_4604_9bd5_cd94959066be
  BNE	__CMP_YES_a92573bb_f6f5_4604_9bd5_cd94959066be
  JMP	__CMP_NO_a92573bb_f6f5_4604_9bd5_cd94959066be
  __CMP_YES_a92573bb_f6f5_4604_9bd5_cd94959066be:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a92573bb_f6f5_4604_9bd5_cd94959066be
  __CMP_NO_a92573bb_f6f5_4604_9bd5_cd94959066be:
  SEP	#$20
  LDA	#$00
  __CMP_END_a92573bb_f6f5_4604_9bd5_cd94959066be:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__743755e0_2b24_4f24_b0f7_d5e466033de2
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
  BNE	__IFNOT_386472cd_1c25_44e1_8554_e16dc9abec09
  JMP	__ITER__END__743755e0_2b24_4f24_b0f7_d5e466033de2
  __IFNOT_386472cd_1c25_44e1_8554_e16dc9abec09:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod24by16@start + 0
  ASL
  STA	__mod24by16@start + 0
  SEP	#$20
  LDA	__mod24by16@start + 2
  ROL
  STA	__mod24by16@start + 2
  JMP	__ITER__START__743755e0_2b24_4f24_b0f7_d5e466033de2
  __ITER__END__743755e0_2b24_4f24_b0f7_d5e466033de2:
  __ITER__START__ab52bf0f_45ee_47fd_aafe_4c1ff8c1a815:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__ab52bf0f_45ee_47fd_aafe_4c1ff8c1a815
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_91289ba8_acc6_4e96_8b6d_e06227618727
  BNE	__CMP_YES_91289ba8_acc6_4e96_8b6d_e06227618727
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_91289ba8_acc6_4e96_8b6d_e06227618727
  BNE	__CMP_YES_91289ba8_acc6_4e96_8b6d_e06227618727
  JMP	__CMP_YES_91289ba8_acc6_4e96_8b6d_e06227618727
  __CMP_YES_91289ba8_acc6_4e96_8b6d_e06227618727:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_91289ba8_acc6_4e96_8b6d_e06227618727
  __CMP_NO_91289ba8_acc6_4e96_8b6d_e06227618727:
  SEP	#$20
  LDA	#$00
  __CMP_END_91289ba8_acc6_4e96_8b6d_e06227618727:
  BEQ	__IFNOT_07e4627c_af2b_4a3f_b8d3_7624d9db038a
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
  REP	#$20
  LDA	__mod24by16@ret + 0
  ADC	__mod24by16@start + 0
  STA	__mod24by16@ret + 0
  SEP	#$20
  LDA	__mod24by16@ret + 2
  ADC	__mod24by16@start + 2
  STA	__mod24by16@ret + 2
  __IFNOT_07e4627c_af2b_4a3f_b8d3_7624d9db038a:
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
  JMP	__ITER__START__ab52bf0f_45ee_47fd_aafe_4c1ff8c1a815
  __ITER__END__ab52bf0f_45ee_47fd_aafe_4c1ff8c1a815:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod32by16@ret + 0
  SEP	#$20
  STA	__mod32by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod32by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod32by16@start + 2
  __ITER__START__6e522ee8_c3bb_492e_90d2_af5fcfcf6593:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_f6a5304d_4694_4673_a785_5cdcc7b1434e
  BNE	__CMP_YES_f6a5304d_4694_4673_a785_5cdcc7b1434e
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f6a5304d_4694_4673_a785_5cdcc7b1434e
  BNE	__CMP_YES_f6a5304d_4694_4673_a785_5cdcc7b1434e
  JMP	__CMP_NO_f6a5304d_4694_4673_a785_5cdcc7b1434e
  __CMP_YES_f6a5304d_4694_4673_a785_5cdcc7b1434e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f6a5304d_4694_4673_a785_5cdcc7b1434e
  __CMP_NO_f6a5304d_4694_4673_a785_5cdcc7b1434e:
  SEP	#$20
  LDA	#$00
  __CMP_END_f6a5304d_4694_4673_a785_5cdcc7b1434e:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6e522ee8_c3bb_492e_90d2_af5fcfcf6593
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
  BNE	__IFNOT_8f35a3f2_133b_4c17_b046_e512c24c1928
  JMP	__ITER__END__6e522ee8_c3bb_492e_90d2_af5fcfcf6593
  __IFNOT_8f35a3f2_133b_4c17_b046_e512c24c1928:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod32by16@start + 0
  ASL
  STA	__mod32by16@start + 0
  SEP	#$20
  LDA	__mod32by16@start + 2
  ROL
  STA	__mod32by16@start + 2
  JMP	__ITER__START__6e522ee8_c3bb_492e_90d2_af5fcfcf6593
  __ITER__END__6e522ee8_c3bb_492e_90d2_af5fcfcf6593:
  __ITER__START__19f600ab_7104_4ef3_a3e8_6977a6b73bd3:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__19f600ab_7104_4ef3_a3e8_6977a6b73bd3
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_3981fa01_7132_445e_b4fb_62f502ffaca1
  BNE	__CMP_YES_3981fa01_7132_445e_b4fb_62f502ffaca1
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3981fa01_7132_445e_b4fb_62f502ffaca1
  BNE	__CMP_YES_3981fa01_7132_445e_b4fb_62f502ffaca1
  JMP	__CMP_YES_3981fa01_7132_445e_b4fb_62f502ffaca1
  __CMP_YES_3981fa01_7132_445e_b4fb_62f502ffaca1:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3981fa01_7132_445e_b4fb_62f502ffaca1
  __CMP_NO_3981fa01_7132_445e_b4fb_62f502ffaca1:
  SEP	#$20
  LDA	#$00
  __CMP_END_3981fa01_7132_445e_b4fb_62f502ffaca1:
  BEQ	__IFNOT_fbab6515_0772_49e8_bed2_fb3784aac1bc
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
  REP	#$20
  LDA	__mod32by16@ret + 0
  ADC	__mod32by16@start + 0
  STA	__mod32by16@ret + 0
  SEP	#$20
  LDA	__mod32by16@ret + 2
  ADC	__mod32by16@start + 2
  STA	__mod32by16@ret + 2
  __IFNOT_fbab6515_0772_49e8_bed2_fb3784aac1bc:
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
  JMP	__ITER__START__19f600ab_7104_4ef3_a3e8_6977a6b73bd3
  __ITER__END__19f600ab_7104_4ef3_a3e8_6977a6b73bd3:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod64by16@ret + 0
  SEP	#$20
  STA	__mod64by16@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod64by16@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod64by16@start + 2
  __ITER__START__63c2ac82_943e_4f07_bf33_65d3767d19d7:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  BNE	__CMP_YES_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  BNE	__CMP_YES_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  BNE	__CMP_YES_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  BNE	__CMP_YES_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  JMP	__CMP_NO_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  __CMP_YES_c6be3a7a_97cd_46a8_9b13_72483fbee7b2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c6be3a7a_97cd_46a8_9b13_72483fbee7b2
  __CMP_NO_c6be3a7a_97cd_46a8_9b13_72483fbee7b2:
  SEP	#$20
  LDA	#$00
  __CMP_END_c6be3a7a_97cd_46a8_9b13_72483fbee7b2:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__63c2ac82_943e_4f07_bf33_65d3767d19d7
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
  BNE	__IFNOT_651f5e0c_b65f_4009_b8a3_285571af9a82
  JMP	__ITER__END__63c2ac82_943e_4f07_bf33_65d3767d19d7
  __IFNOT_651f5e0c_b65f_4009_b8a3_285571af9a82:
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  REP	#$20
  LDA	__mod64by16@start + 0
  ASL
  STA	__mod64by16@start + 0
  SEP	#$20
  LDA	__mod64by16@start + 2
  ROL
  STA	__mod64by16@start + 2
  JMP	__ITER__START__63c2ac82_943e_4f07_bf33_65d3767d19d7
  __ITER__END__63c2ac82_943e_4f07_bf33_65d3767d19d7:
  __ITER__START__9dd59737_4823_4a73_bbb9_58467147ff09:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__9dd59737_4823_4a73_bbb9_58467147ff09
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_0fd7e960_b39c_4682_81d9_33aa048d8df7
  BNE	__CMP_YES_0fd7e960_b39c_4682_81d9_33aa048d8df7
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_0fd7e960_b39c_4682_81d9_33aa048d8df7
  BNE	__CMP_YES_0fd7e960_b39c_4682_81d9_33aa048d8df7
  LDA	__@specSubX + 2
  CMP	__@signExtend
  BCC	__CMP_NO_0fd7e960_b39c_4682_81d9_33aa048d8df7
  BNE	__CMP_YES_0fd7e960_b39c_4682_81d9_33aa048d8df7
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_0fd7e960_b39c_4682_81d9_33aa048d8df7
  BNE	__CMP_YES_0fd7e960_b39c_4682_81d9_33aa048d8df7
  JMP	__CMP_YES_0fd7e960_b39c_4682_81d9_33aa048d8df7
  __CMP_YES_0fd7e960_b39c_4682_81d9_33aa048d8df7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_0fd7e960_b39c_4682_81d9_33aa048d8df7
  __CMP_NO_0fd7e960_b39c_4682_81d9_33aa048d8df7:
  SEP	#$20
  LDA	#$00
  __CMP_END_0fd7e960_b39c_4682_81d9_33aa048d8df7:
  BEQ	__IFNOT_59dda0ca_c2db_4662_ae9a_0d2d43ad9ef8
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
  REP	#$20
  LDA	__mod64by16@ret + 0
  ADC	__mod64by16@start + 0
  STA	__mod64by16@ret + 0
  SEP	#$20
  LDA	__mod64by16@ret + 2
  ADC	__mod64by16@start + 2
  STA	__mod64by16@ret + 2
  __IFNOT_59dda0ca_c2db_4662_ae9a_0d2d43ad9ef8:
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
  JMP	__ITER__START__9dd59737_4823_4a73_bbb9_58467147ff09
  __ITER__END__9dd59737_4823_4a73_bbb9_58467147ff09:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod8by24@ret + 0
  SEP	#$20
  STA	__mod8by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod8by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod8by24@start + 2
  __ITER__START__7b62bf18_5599_423a_9bb3_83324ad8e26f:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_94f25a29_8212_4b24_8f23_9c8a404fc5d0
  BNE	__CMP_YES_94f25a29_8212_4b24_8f23_9c8a404fc5d0
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_94f25a29_8212_4b24_8f23_9c8a404fc5d0
  BNE	__CMP_YES_94f25a29_8212_4b24_8f23_9c8a404fc5d0
  JMP	__CMP_NO_94f25a29_8212_4b24_8f23_9c8a404fc5d0
  __CMP_YES_94f25a29_8212_4b24_8f23_9c8a404fc5d0:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_94f25a29_8212_4b24_8f23_9c8a404fc5d0
  __CMP_NO_94f25a29_8212_4b24_8f23_9c8a404fc5d0:
  SEP	#$20
  LDA	#$00
  __CMP_END_94f25a29_8212_4b24_8f23_9c8a404fc5d0:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__7b62bf18_5599_423a_9bb3_83324ad8e26f
  :
  
  REP	#$20
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
  BNE	__IFNOT_2d32612c_5e01_4bd5_b285_c3787cb0d875
  JMP	__ITER__END__7b62bf18_5599_423a_9bb3_83324ad8e26f
  __IFNOT_2d32612c_5e01_4bd5_b285_c3787cb0d875:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod8by24@start + 0
  ASL
  STA	__mod8by24@start + 0
  SEP	#$20
  LDA	__mod8by24@start + 2
  ROL
  STA	__mod8by24@start + 2
  JMP	__ITER__START__7b62bf18_5599_423a_9bb3_83324ad8e26f
  __ITER__END__7b62bf18_5599_423a_9bb3_83324ad8e26f:
  __ITER__START__3afc5d78_f9a6_4e47_930c_5e5a2cdc2085:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__3afc5d78_f9a6_4e47_930c_5e5a2cdc2085
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_c2e58e06_3239_414e_8c47_5a7836782b70
  BNE	__CMP_YES_c2e58e06_3239_414e_8c47_5a7836782b70
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c2e58e06_3239_414e_8c47_5a7836782b70
  BNE	__CMP_YES_c2e58e06_3239_414e_8c47_5a7836782b70
  JMP	__CMP_YES_c2e58e06_3239_414e_8c47_5a7836782b70
  __CMP_YES_c2e58e06_3239_414e_8c47_5a7836782b70:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c2e58e06_3239_414e_8c47_5a7836782b70
  __CMP_NO_c2e58e06_3239_414e_8c47_5a7836782b70:
  SEP	#$20
  LDA	#$00
  __CMP_END_c2e58e06_3239_414e_8c47_5a7836782b70:
  BEQ	__IFNOT_0ee858f9_07b0_4c94_8d44_4c51a3cf3e94
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
  REP	#$20
  LDA	__mod8by24@ret + 0
  ADC	__mod8by24@start + 0
  STA	__mod8by24@ret + 0
  SEP	#$20
  LDA	__mod8by24@ret + 2
  ADC	__mod8by24@start + 2
  STA	__mod8by24@ret + 2
  __IFNOT_0ee858f9_07b0_4c94_8d44_4c51a3cf3e94:
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
  JMP	__ITER__START__3afc5d78_f9a6_4e47_930c_5e5a2cdc2085
  __ITER__END__3afc5d78_f9a6_4e47_930c_5e5a2cdc2085:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod16by24@ret + 0
  SEP	#$20
  STA	__mod16by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod16by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod16by24@start + 2
  __ITER__START__56ea87d1_1067_43e4_82b6_99b229c3d636:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_17be27d3_35d5_4578_aa80_38ed4bfb5301
  BNE	__CMP_YES_17be27d3_35d5_4578_aa80_38ed4bfb5301
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_17be27d3_35d5_4578_aa80_38ed4bfb5301
  BNE	__CMP_YES_17be27d3_35d5_4578_aa80_38ed4bfb5301
  JMP	__CMP_NO_17be27d3_35d5_4578_aa80_38ed4bfb5301
  __CMP_YES_17be27d3_35d5_4578_aa80_38ed4bfb5301:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_17be27d3_35d5_4578_aa80_38ed4bfb5301
  __CMP_NO_17be27d3_35d5_4578_aa80_38ed4bfb5301:
  SEP	#$20
  LDA	#$00
  __CMP_END_17be27d3_35d5_4578_aa80_38ed4bfb5301:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__56ea87d1_1067_43e4_82b6_99b229c3d636
  :
  
  REP	#$20
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
  BNE	__IFNOT_9f7015ff_13ad_4b4c_8211_bc850effa288
  JMP	__ITER__END__56ea87d1_1067_43e4_82b6_99b229c3d636
  __IFNOT_9f7015ff_13ad_4b4c_8211_bc850effa288:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod16by24@start + 0
  ASL
  STA	__mod16by24@start + 0
  SEP	#$20
  LDA	__mod16by24@start + 2
  ROL
  STA	__mod16by24@start + 2
  JMP	__ITER__START__56ea87d1_1067_43e4_82b6_99b229c3d636
  __ITER__END__56ea87d1_1067_43e4_82b6_99b229c3d636:
  __ITER__START__86fc7e1c_49b1_44bb_b65c_f97b5be6c07b:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__86fc7e1c_49b1_44bb_b65c_f97b5be6c07b
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_2bba70d1_a80e_4d14_815e_5bb1b69e28c6
  BNE	__CMP_YES_2bba70d1_a80e_4d14_815e_5bb1b69e28c6
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2bba70d1_a80e_4d14_815e_5bb1b69e28c6
  BNE	__CMP_YES_2bba70d1_a80e_4d14_815e_5bb1b69e28c6
  JMP	__CMP_YES_2bba70d1_a80e_4d14_815e_5bb1b69e28c6
  __CMP_YES_2bba70d1_a80e_4d14_815e_5bb1b69e28c6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2bba70d1_a80e_4d14_815e_5bb1b69e28c6
  __CMP_NO_2bba70d1_a80e_4d14_815e_5bb1b69e28c6:
  SEP	#$20
  LDA	#$00
  __CMP_END_2bba70d1_a80e_4d14_815e_5bb1b69e28c6:
  BEQ	__IFNOT_89ce7763_b1ae_4900_b473_fe1dc5b511f3
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  REP	#$20
  LDA	__mod16by24@ret + 0
  ADC	__mod16by24@start + 0
  STA	__mod16by24@ret + 0
  SEP	#$20
  LDA	__mod16by24@ret + 2
  ADC	__mod16by24@start + 2
  STA	__mod16by24@ret + 2
  __IFNOT_89ce7763_b1ae_4900_b473_fe1dc5b511f3:
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
  JMP	__ITER__START__86fc7e1c_49b1_44bb_b65c_f97b5be6c07b
  __ITER__END__86fc7e1c_49b1_44bb_b65c_f97b5be6c07b:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod24by24@ret + 0
  SEP	#$20
  STA	__mod24by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod24by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod24by24@start + 2
  __ITER__START__01ace39b_5980_49de_9ae3_fcaca35223ba:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_44237e31_6986_419c_99f5_44e815f4dd30
  BNE	__CMP_YES_44237e31_6986_419c_99f5_44e815f4dd30
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_44237e31_6986_419c_99f5_44e815f4dd30
  BNE	__CMP_YES_44237e31_6986_419c_99f5_44e815f4dd30
  JMP	__CMP_NO_44237e31_6986_419c_99f5_44e815f4dd30
  __CMP_YES_44237e31_6986_419c_99f5_44e815f4dd30:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_44237e31_6986_419c_99f5_44e815f4dd30
  __CMP_NO_44237e31_6986_419c_99f5_44e815f4dd30:
  SEP	#$20
  LDA	#$00
  __CMP_END_44237e31_6986_419c_99f5_44e815f4dd30:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__01ace39b_5980_49de_9ae3_fcaca35223ba
  :
  
  REP	#$20
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
  BNE	__IFNOT_a72b75de_8a0c_4769_bfcb_8783302fe3ab
  JMP	__ITER__END__01ace39b_5980_49de_9ae3_fcaca35223ba
  __IFNOT_a72b75de_8a0c_4769_bfcb_8783302fe3ab:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod24by24@start + 0
  ASL
  STA	__mod24by24@start + 0
  SEP	#$20
  LDA	__mod24by24@start + 2
  ROL
  STA	__mod24by24@start + 2
  JMP	__ITER__START__01ace39b_5980_49de_9ae3_fcaca35223ba
  __ITER__END__01ace39b_5980_49de_9ae3_fcaca35223ba:
  __ITER__START__1d57d05e_e3d2_46d5_8d9e_b7f2e7c02501:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__1d57d05e_e3d2_46d5_8d9e_b7f2e7c02501
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_d7aba2ba_a702_426d_bedf_860318bc46c2
  BNE	__CMP_YES_d7aba2ba_a702_426d_bedf_860318bc46c2
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_d7aba2ba_a702_426d_bedf_860318bc46c2
  BNE	__CMP_YES_d7aba2ba_a702_426d_bedf_860318bc46c2
  JMP	__CMP_YES_d7aba2ba_a702_426d_bedf_860318bc46c2
  __CMP_YES_d7aba2ba_a702_426d_bedf_860318bc46c2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_d7aba2ba_a702_426d_bedf_860318bc46c2
  __CMP_NO_d7aba2ba_a702_426d_bedf_860318bc46c2:
  SEP	#$20
  LDA	#$00
  __CMP_END_d7aba2ba_a702_426d_bedf_860318bc46c2:
  BEQ	__IFNOT_302736e2_cb46_4286_8a8f_da8ccab722a7
  SEC
  REP	#$20
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
  REP	#$20
  LDA	__mod24by24@ret + 0
  ADC	__mod24by24@start + 0
  STA	__mod24by24@ret + 0
  SEP	#$20
  LDA	__mod24by24@ret + 2
  ADC	__mod24by24@start + 2
  STA	__mod24by24@ret + 2
  __IFNOT_302736e2_cb46_4286_8a8f_da8ccab722a7:
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
  JMP	__ITER__START__1d57d05e_e3d2_46d5_8d9e_b7f2e7c02501
  __ITER__END__1d57d05e_e3d2_46d5_8d9e_b7f2e7c02501:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod32by24@ret + 0
  SEP	#$20
  STA	__mod32by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod32by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod32by24@start + 2
  __ITER__START__9aa1e4ba_389b_468f_b2d4_a3f72eae33ad:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_ea49c082_68ba_4a24_8e79_3d29c10f143e
  BNE	__CMP_YES_ea49c082_68ba_4a24_8e79_3d29c10f143e
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_ea49c082_68ba_4a24_8e79_3d29c10f143e
  BNE	__CMP_YES_ea49c082_68ba_4a24_8e79_3d29c10f143e
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_ea49c082_68ba_4a24_8e79_3d29c10f143e
  BNE	__CMP_YES_ea49c082_68ba_4a24_8e79_3d29c10f143e
  JMP	__CMP_NO_ea49c082_68ba_4a24_8e79_3d29c10f143e
  __CMP_YES_ea49c082_68ba_4a24_8e79_3d29c10f143e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ea49c082_68ba_4a24_8e79_3d29c10f143e
  __CMP_NO_ea49c082_68ba_4a24_8e79_3d29c10f143e:
  SEP	#$20
  LDA	#$00
  __CMP_END_ea49c082_68ba_4a24_8e79_3d29c10f143e:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__9aa1e4ba_389b_468f_b2d4_a3f72eae33ad
  :
  
  REP	#$20
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
  BNE	__IFNOT_150a1035_e337_463a_b95c_4760b1a239bc
  JMP	__ITER__END__9aa1e4ba_389b_468f_b2d4_a3f72eae33ad
  __IFNOT_150a1035_e337_463a_b95c_4760b1a239bc:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod32by24@start + 0
  ASL
  STA	__mod32by24@start + 0
  SEP	#$20
  LDA	__mod32by24@start + 2
  ROL
  STA	__mod32by24@start + 2
  JMP	__ITER__START__9aa1e4ba_389b_468f_b2d4_a3f72eae33ad
  __ITER__END__9aa1e4ba_389b_468f_b2d4_a3f72eae33ad:
  __ITER__START__434566d0_1dc5_44dc_abbd_150de83e76ba:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__434566d0_1dc5_44dc_abbd_150de83e76ba
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_1d3ef632_573d_41b1_b24f_5852bda98ab8
  BNE	__CMP_YES_1d3ef632_573d_41b1_b24f_5852bda98ab8
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_1d3ef632_573d_41b1_b24f_5852bda98ab8
  BNE	__CMP_YES_1d3ef632_573d_41b1_b24f_5852bda98ab8
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_1d3ef632_573d_41b1_b24f_5852bda98ab8
  BNE	__CMP_YES_1d3ef632_573d_41b1_b24f_5852bda98ab8
  JMP	__CMP_YES_1d3ef632_573d_41b1_b24f_5852bda98ab8
  __CMP_YES_1d3ef632_573d_41b1_b24f_5852bda98ab8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1d3ef632_573d_41b1_b24f_5852bda98ab8
  __CMP_NO_1d3ef632_573d_41b1_b24f_5852bda98ab8:
  SEP	#$20
  LDA	#$00
  __CMP_END_1d3ef632_573d_41b1_b24f_5852bda98ab8:
  BEQ	__IFNOT_3009ef0b_7498_4c7c_9666_56844288b923
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
  REP	#$20
  LDA	__mod32by24@ret + 0
  ADC	__mod32by24@start + 0
  STA	__mod32by24@ret + 0
  SEP	#$20
  LDA	__mod32by24@ret + 2
  ADC	__mod32by24@start + 2
  STA	__mod32by24@ret + 2
  __IFNOT_3009ef0b_7498_4c7c_9666_56844288b923:
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
  JMP	__ITER__START__434566d0_1dc5_44dc_abbd_150de83e76ba
  __ITER__END__434566d0_1dc5_44dc_abbd_150de83e76ba:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod64by24@ret + 0
  SEP	#$20
  STA	__mod64by24@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod64by24@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod64by24@start + 2
  __ITER__START__bfd92ece_d7c0_4642_a454_169f367a7acf:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  BNE	__CMP_YES_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  BNE	__CMP_YES_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  BNE	__CMP_YES_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  BNE	__CMP_YES_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  BNE	__CMP_YES_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  JMP	__CMP_NO_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  __CMP_YES_f4eeaa5a_82a7_45e6_bddd_42d72d387dec:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f4eeaa5a_82a7_45e6_bddd_42d72d387dec
  __CMP_NO_f4eeaa5a_82a7_45e6_bddd_42d72d387dec:
  SEP	#$20
  LDA	#$00
  __CMP_END_f4eeaa5a_82a7_45e6_bddd_42d72d387dec:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__bfd92ece_d7c0_4642_a454_169f367a7acf
  :
  
  REP	#$20
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
  BNE	__IFNOT_de2031cc_220c_473d_b8ab_5c5c4d6eb281
  JMP	__ITER__END__bfd92ece_d7c0_4642_a454_169f367a7acf
  __IFNOT_de2031cc_220c_473d_b8ab_5c5c4d6eb281:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  SEP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod64by24@start + 0
  ASL
  STA	__mod64by24@start + 0
  SEP	#$20
  LDA	__mod64by24@start + 2
  ROL
  STA	__mod64by24@start + 2
  JMP	__ITER__START__bfd92ece_d7c0_4642_a454_169f367a7acf
  __ITER__END__bfd92ece_d7c0_4642_a454_169f367a7acf:
  __ITER__START__c0d892e7_41c5_48dc_9e03_f0a765ccac37:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__c0d892e7_41c5_48dc_9e03_f0a765ccac37
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_10d5051c_e781_48d2_b980_de9aa5c13ba7
  BNE	__CMP_YES_10d5051c_e781_48d2_b980_de9aa5c13ba7
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_10d5051c_e781_48d2_b980_de9aa5c13ba7
  BNE	__CMP_YES_10d5051c_e781_48d2_b980_de9aa5c13ba7
  SEP	#$20
  LDA	__@specSubX + 3
  CMP	__@signExtend
  BCC	__CMP_NO_10d5051c_e781_48d2_b980_de9aa5c13ba7
  BNE	__CMP_YES_10d5051c_e781_48d2_b980_de9aa5c13ba7
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_10d5051c_e781_48d2_b980_de9aa5c13ba7
  BNE	__CMP_YES_10d5051c_e781_48d2_b980_de9aa5c13ba7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_10d5051c_e781_48d2_b980_de9aa5c13ba7
  BNE	__CMP_YES_10d5051c_e781_48d2_b980_de9aa5c13ba7
  JMP	__CMP_YES_10d5051c_e781_48d2_b980_de9aa5c13ba7
  __CMP_YES_10d5051c_e781_48d2_b980_de9aa5c13ba7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_10d5051c_e781_48d2_b980_de9aa5c13ba7
  __CMP_NO_10d5051c_e781_48d2_b980_de9aa5c13ba7:
  SEP	#$20
  LDA	#$00
  __CMP_END_10d5051c_e781_48d2_b980_de9aa5c13ba7:
  BNE	:+
  JMP	__IFNOT_46fb4a7f_7f64_4ec9_8f5f_7c45b145b2f5
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
  REP	#$20
  LDA	__mod64by24@ret + 0
  ADC	__mod64by24@start + 0
  STA	__mod64by24@ret + 0
  SEP	#$20
  LDA	__mod64by24@ret + 2
  ADC	__mod64by24@start + 2
  STA	__mod64by24@ret + 2
  __IFNOT_46fb4a7f_7f64_4ec9_8f5f_7c45b145b2f5:
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
  JMP	__ITER__START__c0d892e7_41c5_48dc_9e03_f0a765ccac37
  __ITER__END__c0d892e7_41c5_48dc_9e03_f0a765ccac37:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod8by32@ret + 0
  SEP	#$20
  STA	__mod8by32@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod8by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod8by32@start + 2
  __ITER__START__e4e44ed5_5949_4a7f_a70e_146a274c2504:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_7ba7f465_421c_46be_99f1_e6d5f5cda118
  BNE	__CMP_YES_7ba7f465_421c_46be_99f1_e6d5f5cda118
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_7ba7f465_421c_46be_99f1_e6d5f5cda118
  BNE	__CMP_YES_7ba7f465_421c_46be_99f1_e6d5f5cda118
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_7ba7f465_421c_46be_99f1_e6d5f5cda118
  BNE	__CMP_YES_7ba7f465_421c_46be_99f1_e6d5f5cda118
  JMP	__CMP_NO_7ba7f465_421c_46be_99f1_e6d5f5cda118
  __CMP_YES_7ba7f465_421c_46be_99f1_e6d5f5cda118:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_7ba7f465_421c_46be_99f1_e6d5f5cda118
  __CMP_NO_7ba7f465_421c_46be_99f1_e6d5f5cda118:
  SEP	#$20
  LDA	#$00
  __CMP_END_7ba7f465_421c_46be_99f1_e6d5f5cda118:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__e4e44ed5_5949_4a7f_a70e_146a274c2504
  :
  
  REP	#$20
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
  BNE	__IFNOT_a1cce857_91df_4e0f_b363_e6deb695a767
  JMP	__ITER__END__e4e44ed5_5949_4a7f_a70e_146a274c2504
  __IFNOT_a1cce857_91df_4e0f_b363_e6deb695a767:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod8by32@start + 0
  ASL
  STA	__mod8by32@start + 0
  SEP	#$20
  LDA	__mod8by32@start + 2
  ROL
  STA	__mod8by32@start + 2
  JMP	__ITER__START__e4e44ed5_5949_4a7f_a70e_146a274c2504
  __ITER__END__e4e44ed5_5949_4a7f_a70e_146a274c2504:
  __ITER__START__7a54794d_7065_4e48_b5c2_5d857e9cfd6f:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__7a54794d_7065_4e48_b5c2_5d857e9cfd6f
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_2c950365_0b7d_4bab_8387_0bd6ca3e16c9
  BNE	__CMP_YES_2c950365_0b7d_4bab_8387_0bd6ca3e16c9
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_2c950365_0b7d_4bab_8387_0bd6ca3e16c9
  BNE	__CMP_YES_2c950365_0b7d_4bab_8387_0bd6ca3e16c9
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2c950365_0b7d_4bab_8387_0bd6ca3e16c9
  BNE	__CMP_YES_2c950365_0b7d_4bab_8387_0bd6ca3e16c9
  JMP	__CMP_YES_2c950365_0b7d_4bab_8387_0bd6ca3e16c9
  __CMP_YES_2c950365_0b7d_4bab_8387_0bd6ca3e16c9:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2c950365_0b7d_4bab_8387_0bd6ca3e16c9
  __CMP_NO_2c950365_0b7d_4bab_8387_0bd6ca3e16c9:
  SEP	#$20
  LDA	#$00
  __CMP_END_2c950365_0b7d_4bab_8387_0bd6ca3e16c9:
  BEQ	__IFNOT_07d83fe9_f8a5_4746_b936_3bca2073847a
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
  REP	#$20
  LDA	__mod8by32@ret + 0
  ADC	__mod8by32@start + 0
  STA	__mod8by32@ret + 0
  SEP	#$20
  LDA	__mod8by32@ret + 2
  ADC	__mod8by32@start + 2
  STA	__mod8by32@ret + 2
  __IFNOT_07d83fe9_f8a5_4746_b936_3bca2073847a:
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
  JMP	__ITER__START__7a54794d_7065_4e48_b5c2_5d857e9cfd6f
  __ITER__END__7a54794d_7065_4e48_b5c2_5d857e9cfd6f:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod16by32@ret + 0
  SEP	#$20
  STA	__mod16by32@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod16by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod16by32@start + 2
  __ITER__START__6f64302c_063f_41c3_828b_6aaf0c4ff988:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5
  BNE	__CMP_YES_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5
  BNE	__CMP_YES_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5
  JMP	__CMP_NO_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5
  __CMP_YES_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5
  __CMP_NO_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5:
  SEP	#$20
  LDA	#$00
  __CMP_END_e1572d9b_5a1d_4eef_bbf3_864f5f23f2f5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__6f64302c_063f_41c3_828b_6aaf0c4ff988
  :
  
  REP	#$20
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
  BNE	__IFNOT_8e7a8b4f_1de0_4967_b62c_59338bbc91ac
  JMP	__ITER__END__6f64302c_063f_41c3_828b_6aaf0c4ff988
  __IFNOT_8e7a8b4f_1de0_4967_b62c_59338bbc91ac:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod16by32@start + 0
  ASL
  STA	__mod16by32@start + 0
  SEP	#$20
  LDA	__mod16by32@start + 2
  ROL
  STA	__mod16by32@start + 2
  JMP	__ITER__START__6f64302c_063f_41c3_828b_6aaf0c4ff988
  __ITER__END__6f64302c_063f_41c3_828b_6aaf0c4ff988:
  __ITER__START__b00005c3_e110_478a_b9ed_b283d3078e69:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__b00005c3_e110_478a_b9ed_b283d3078e69
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_478b7a9a_2172_4d2f_a1bf_c126433e706b
  BNE	__CMP_YES_478b7a9a_2172_4d2f_a1bf_c126433e706b
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_478b7a9a_2172_4d2f_a1bf_c126433e706b
  BNE	__CMP_YES_478b7a9a_2172_4d2f_a1bf_c126433e706b
  JMP	__CMP_YES_478b7a9a_2172_4d2f_a1bf_c126433e706b
  __CMP_YES_478b7a9a_2172_4d2f_a1bf_c126433e706b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_478b7a9a_2172_4d2f_a1bf_c126433e706b
  __CMP_NO_478b7a9a_2172_4d2f_a1bf_c126433e706b:
  SEP	#$20
  LDA	#$00
  __CMP_END_478b7a9a_2172_4d2f_a1bf_c126433e706b:
  BEQ	__IFNOT_2bd1d283_5de2_4d9b_81df_50e2447b0467
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  REP	#$20
  LDA	__mod16by32@ret + 0
  ADC	__mod16by32@start + 0
  STA	__mod16by32@ret + 0
  SEP	#$20
  LDA	__mod16by32@ret + 2
  ADC	__mod16by32@start + 2
  STA	__mod16by32@ret + 2
  __IFNOT_2bd1d283_5de2_4d9b_81df_50e2447b0467:
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
  JMP	__ITER__START__b00005c3_e110_478a_b9ed_b283d3078e69
  __ITER__END__b00005c3_e110_478a_b9ed_b283d3078e69:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod24by32@ret + 0
  SEP	#$20
  STA	__mod24by32@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod24by32@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod24by32@start + 2
  __ITER__START__b1a7d967_5510_4552_b66d_cceba221724d:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_b9d992dd_ed46_4d64_b2dd_6fde456262f7
  BNE	__CMP_YES_b9d992dd_ed46_4d64_b2dd_6fde456262f7
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b9d992dd_ed46_4d64_b2dd_6fde456262f7
  BNE	__CMP_YES_b9d992dd_ed46_4d64_b2dd_6fde456262f7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b9d992dd_ed46_4d64_b2dd_6fde456262f7
  BNE	__CMP_YES_b9d992dd_ed46_4d64_b2dd_6fde456262f7
  JMP	__CMP_NO_b9d992dd_ed46_4d64_b2dd_6fde456262f7
  __CMP_YES_b9d992dd_ed46_4d64_b2dd_6fde456262f7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b9d992dd_ed46_4d64_b2dd_6fde456262f7
  __CMP_NO_b9d992dd_ed46_4d64_b2dd_6fde456262f7:
  SEP	#$20
  LDA	#$00
  __CMP_END_b9d992dd_ed46_4d64_b2dd_6fde456262f7:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b1a7d967_5510_4552_b66d_cceba221724d
  :
  
  REP	#$20
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
  BNE	__IFNOT_03a0046c_c89a_433a_89a7_7a34de78f4fe
  JMP	__ITER__END__b1a7d967_5510_4552_b66d_cceba221724d
  __IFNOT_03a0046c_c89a_433a_89a7_7a34de78f4fe:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod24by32@start + 0
  ASL
  STA	__mod24by32@start + 0
  SEP	#$20
  LDA	__mod24by32@start + 2
  ROL
  STA	__mod24by32@start + 2
  JMP	__ITER__START__b1a7d967_5510_4552_b66d_cceba221724d
  __ITER__END__b1a7d967_5510_4552_b66d_cceba221724d:
  __ITER__START__7127cceb_4d72_4990_9667_28e96610ba96:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__7127cceb_4d72_4990_9667_28e96610ba96
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_67b78b1a_85d8_41f0_830e_f968ed7a7552
  BNE	__CMP_YES_67b78b1a_85d8_41f0_830e_f968ed7a7552
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_67b78b1a_85d8_41f0_830e_f968ed7a7552
  BNE	__CMP_YES_67b78b1a_85d8_41f0_830e_f968ed7a7552
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_67b78b1a_85d8_41f0_830e_f968ed7a7552
  BNE	__CMP_YES_67b78b1a_85d8_41f0_830e_f968ed7a7552
  JMP	__CMP_YES_67b78b1a_85d8_41f0_830e_f968ed7a7552
  __CMP_YES_67b78b1a_85d8_41f0_830e_f968ed7a7552:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_67b78b1a_85d8_41f0_830e_f968ed7a7552
  __CMP_NO_67b78b1a_85d8_41f0_830e_f968ed7a7552:
  SEP	#$20
  LDA	#$00
  __CMP_END_67b78b1a_85d8_41f0_830e_f968ed7a7552:
  BEQ	__IFNOT_3e44d0f4_4241_4c36_b8d8_5978eb80e996
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
  REP	#$20
  LDA	__mod24by32@ret + 0
  ADC	__mod24by32@start + 0
  STA	__mod24by32@ret + 0
  SEP	#$20
  LDA	__mod24by32@ret + 2
  ADC	__mod24by32@start + 2
  STA	__mod24by32@ret + 2
  __IFNOT_3e44d0f4_4241_4c36_b8d8_5978eb80e996:
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
  JMP	__ITER__START__7127cceb_4d72_4990_9667_28e96610ba96
  __ITER__END__7127cceb_4d72_4990_9667_28e96610ba96:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod32by32@ret + 0
  STA	__mod32by32@ret + 2
  LDA	#$0001
  STA	__mod32by32@start + 0
  LDA	#$0000
  STA	__mod32by32@start + 2
  __ITER__START__b648710d_a387_4b58_9e2e_c6e7fd2ca970:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_cec078de_3424_4745_b909_674fc9007698
  BNE	__CMP_YES_cec078de_3424_4745_b909_674fc9007698
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_cec078de_3424_4745_b909_674fc9007698
  BNE	__CMP_YES_cec078de_3424_4745_b909_674fc9007698
  JMP	__CMP_NO_cec078de_3424_4745_b909_674fc9007698
  __CMP_YES_cec078de_3424_4745_b909_674fc9007698:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_cec078de_3424_4745_b909_674fc9007698
  __CMP_NO_cec078de_3424_4745_b909_674fc9007698:
  SEP	#$20
  LDA	#$00
  __CMP_END_cec078de_3424_4745_b909_674fc9007698:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__b648710d_a387_4b58_9e2e_c6e7fd2ca970
  :
  
  REP	#$20
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
  BNE	__IFNOT_ab4a981a_7f57_4c0a_8086_58c2de610fab
  JMP	__ITER__END__b648710d_a387_4b58_9e2e_c6e7fd2ca970
  __IFNOT_ab4a981a_7f57_4c0a_8086_58c2de610fab:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod32by32@start + 0
  ASL
  STA	__mod32by32@start + 0
  REP	#$20
  LDA	__mod32by32@start + 2
  ROL
  STA	__mod32by32@start + 2
  JMP	__ITER__START__b648710d_a387_4b58_9e2e_c6e7fd2ca970
  __ITER__END__b648710d_a387_4b58_9e2e_c6e7fd2ca970:
  __ITER__START__9918bc1c_367a_43fc_957b_53ac6fff7d5b:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__9918bc1c_367a_43fc_957b_53ac6fff7d5b
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_998608ab_1663_4e85_adcb_30414045426b
  BNE	__CMP_YES_998608ab_1663_4e85_adcb_30414045426b
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_998608ab_1663_4e85_adcb_30414045426b
  BNE	__CMP_YES_998608ab_1663_4e85_adcb_30414045426b
  JMP	__CMP_YES_998608ab_1663_4e85_adcb_30414045426b
  __CMP_YES_998608ab_1663_4e85_adcb_30414045426b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_998608ab_1663_4e85_adcb_30414045426b
  __CMP_NO_998608ab_1663_4e85_adcb_30414045426b:
  SEP	#$20
  LDA	#$00
  __CMP_END_998608ab_1663_4e85_adcb_30414045426b:
  BEQ	__IFNOT_9df1dfd4_32a6_49fd_af22_a64f801a4d07
  SEC
  REP	#$20
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
  REP	#$20
  LDA	__mod32by32@ret + 0
  ADC	__mod32by32@start + 0
  STA	__mod32by32@ret + 0
  REP	#$20
  LDA	__mod32by32@ret + 2
  ADC	__mod32by32@start + 2
  STA	__mod32by32@ret + 2
  __IFNOT_9df1dfd4_32a6_49fd_af22_a64f801a4d07:
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
  JMP	__ITER__START__9918bc1c_367a_43fc_957b_53ac6fff7d5b
  __ITER__END__9918bc1c_367a_43fc_957b_53ac6fff7d5b:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod64by32@ret + 0
  STA	__mod64by32@ret + 2
  LDA	#$0001
  STA	__mod64by32@start + 0
  LDA	#$0000
  STA	__mod64by32@start + 2
  __ITER__START__0bc85c39_4215_48b8_8cbb_d4140245f0ca:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  BNE	__CMP_YES_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  BNE	__CMP_YES_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  BNE	__CMP_YES_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  BNE	__CMP_YES_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  JMP	__CMP_NO_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  __CMP_YES_c0b6692b_b3c1_4505_9184_ce9c6132bddb:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c0b6692b_b3c1_4505_9184_ce9c6132bddb
  __CMP_NO_c0b6692b_b3c1_4505_9184_ce9c6132bddb:
  SEP	#$20
  LDA	#$00
  __CMP_END_c0b6692b_b3c1_4505_9184_ce9c6132bddb:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__0bc85c39_4215_48b8_8cbb_d4140245f0ca
  :
  
  REP	#$20
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
  BNE	__IFNOT_1cc8254e_ae14_4125_a347_b3e2a09c0ed7
  JMP	__ITER__END__0bc85c39_4215_48b8_8cbb_d4140245f0ca
  __IFNOT_1cc8254e_ae14_4125_a347_b3e2a09c0ed7:
  REP	#$20
  REP	#$20
  LDA	__@specSubY + 0
  ASL
  STA	__@specSubY + 0
  REP	#$20
  LDA	__@specSubY + 2
  ROL
  STA	__@specSubY + 2
  REP	#$20
  REP	#$20
  LDA	__mod64by32@start + 0
  ASL
  STA	__mod64by32@start + 0
  REP	#$20
  LDA	__mod64by32@start + 2
  ROL
  STA	__mod64by32@start + 2
  JMP	__ITER__START__0bc85c39_4215_48b8_8cbb_d4140245f0ca
  __ITER__END__0bc85c39_4215_48b8_8cbb_d4140245f0ca:
  __ITER__START__204544c9_be09_49ff_bf43_307d614751c7:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__204544c9_be09_49ff_bf43_307d614751c7
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@specSubX + 6
  CMP	__@signExtend
  BCC	__CMP_NO_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  BNE	__CMP_YES_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  LDA	__@specSubX + 4
  CMP	__@signExtend
  BCC	__CMP_NO_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  BNE	__CMP_YES_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  BNE	__CMP_YES_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  BNE	__CMP_YES_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  JMP	__CMP_YES_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  __CMP_YES_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2
  __CMP_NO_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2:
  SEP	#$20
  LDA	#$00
  __CMP_END_2fa094b7_4df6_45e5_a528_cdfb27b2a9e2:
  BEQ	__IFNOT_6732ea65_e144_4783_a5bc_3cf012acd256
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
  REP	#$20
  LDA	__mod64by32@ret + 0
  ADC	__mod64by32@start + 0
  STA	__mod64by32@ret + 0
  REP	#$20
  LDA	__mod64by32@ret + 2
  ADC	__mod64by32@start + 2
  STA	__mod64by32@ret + 2
  __IFNOT_6732ea65_e144_4783_a5bc_3cf012acd256:
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
  JMP	__ITER__START__204544c9_be09_49ff_bf43_307d614751c7
  __ITER__END__204544c9_be09_49ff_bf43_307d614751c7:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod8by64@ret + 0
  SEP	#$20
  STA	__mod8by64@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod8by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod8by64@start + 2
  __ITER__START__1d0f58ac_d77b_4453_9be6_422bf857af34:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_28e7035f_322f_4355_ba5a_e173b98a45b5
  BNE	__CMP_YES_28e7035f_322f_4355_ba5a_e173b98a45b5
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_28e7035f_322f_4355_ba5a_e173b98a45b5
  BNE	__CMP_YES_28e7035f_322f_4355_ba5a_e173b98a45b5
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_28e7035f_322f_4355_ba5a_e173b98a45b5
  BNE	__CMP_YES_28e7035f_322f_4355_ba5a_e173b98a45b5
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_28e7035f_322f_4355_ba5a_e173b98a45b5
  BNE	__CMP_YES_28e7035f_322f_4355_ba5a_e173b98a45b5
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_28e7035f_322f_4355_ba5a_e173b98a45b5
  BNE	__CMP_YES_28e7035f_322f_4355_ba5a_e173b98a45b5
  JMP	__CMP_NO_28e7035f_322f_4355_ba5a_e173b98a45b5
  __CMP_YES_28e7035f_322f_4355_ba5a_e173b98a45b5:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_28e7035f_322f_4355_ba5a_e173b98a45b5
  __CMP_NO_28e7035f_322f_4355_ba5a_e173b98a45b5:
  SEP	#$20
  LDA	#$00
  __CMP_END_28e7035f_322f_4355_ba5a_e173b98a45b5:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__1d0f58ac_d77b_4453_9be6_422bf857af34
  :
  
  REP	#$20
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
  BNE	__IFNOT_ab789422_b0ba_4225_acba_5dec0c241fab
  JMP	__ITER__END__1d0f58ac_d77b_4453_9be6_422bf857af34
  __IFNOT_ab789422_b0ba_4225_acba_5dec0c241fab:
  REP	#$20
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
  REP	#$20
  LDA	__mod8by64@start + 0
  ASL
  STA	__mod8by64@start + 0
  SEP	#$20
  LDA	__mod8by64@start + 2
  ROL
  STA	__mod8by64@start + 2
  JMP	__ITER__START__1d0f58ac_d77b_4453_9be6_422bf857af34
  __ITER__END__1d0f58ac_d77b_4453_9be6_422bf857af34:
  __ITER__START__d54668d0_a5a4_4aa7_ba8a_3e1de2a58b8d:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__d54668d0_a5a4_4aa7_ba8a_3e1de2a58b8d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  BNE	__CMP_YES_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  BNE	__CMP_YES_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  BNE	__CMP_YES_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 1
  BCC	__CMP_NO_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  BNE	__CMP_YES_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  BNE	__CMP_YES_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  JMP	__CMP_YES_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  __CMP_YES_b0907ceb_c739_495c_87b0_fd7211dfc7a7:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b0907ceb_c739_495c_87b0_fd7211dfc7a7
  __CMP_NO_b0907ceb_c739_495c_87b0_fd7211dfc7a7:
  SEP	#$20
  LDA	#$00
  __CMP_END_b0907ceb_c739_495c_87b0_fd7211dfc7a7:
  BEQ	__IFNOT_b841b03b_c4a5_4d82_b47d_7a6f1ed8729b
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
  REP	#$20
  LDA	__mod8by64@ret + 0
  ADC	__mod8by64@start + 0
  STA	__mod8by64@ret + 0
  SEP	#$20
  LDA	__mod8by64@ret + 2
  ADC	__mod8by64@start + 2
  STA	__mod8by64@ret + 2
  __IFNOT_b841b03b_c4a5_4d82_b47d_7a6f1ed8729b:
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
  JMP	__ITER__START__d54668d0_a5a4_4aa7_ba8a_3e1de2a58b8d
  __ITER__END__d54668d0_a5a4_4aa7_ba8a_3e1de2a58b8d:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod16by64@ret + 0
  SEP	#$20
  STA	__mod16by64@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod16by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod16by64@start + 2
  __ITER__START__da2970bf_b704_430f_abf2_9ef75b55a065:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  BNE	__CMP_YES_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  BNE	__CMP_YES_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  BNE	__CMP_YES_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  BNE	__CMP_YES_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  JMP	__CMP_NO_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  __CMP_YES_e6a7c06d_9750_4b7d_bb29_414ab895e4cd:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e6a7c06d_9750_4b7d_bb29_414ab895e4cd
  __CMP_NO_e6a7c06d_9750_4b7d_bb29_414ab895e4cd:
  SEP	#$20
  LDA	#$00
  __CMP_END_e6a7c06d_9750_4b7d_bb29_414ab895e4cd:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__da2970bf_b704_430f_abf2_9ef75b55a065
  :
  
  REP	#$20
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
  BNE	__IFNOT_4480469f_9987_420b_b47b_207cde9eca73
  JMP	__ITER__END__da2970bf_b704_430f_abf2_9ef75b55a065
  __IFNOT_4480469f_9987_420b_b47b_207cde9eca73:
  REP	#$20
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
  REP	#$20
  LDA	__mod16by64@start + 0
  ASL
  STA	__mod16by64@start + 0
  SEP	#$20
  LDA	__mod16by64@start + 2
  ROL
  STA	__mod16by64@start + 2
  JMP	__ITER__START__da2970bf_b704_430f_abf2_9ef75b55a065
  __ITER__END__da2970bf_b704_430f_abf2_9ef75b55a065:
  __ITER__START__9cf1abee_f682_4718_9e23_d8a2f0ed4262:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__9cf1abee_f682_4718_9e23_d8a2f0ed4262
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_c0b2e6d5_f20b_40e2_9642_143b121d828f
  BNE	__CMP_YES_c0b2e6d5_f20b_40e2_9642_143b121d828f
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_c0b2e6d5_f20b_40e2_9642_143b121d828f
  BNE	__CMP_YES_c0b2e6d5_f20b_40e2_9642_143b121d828f
  LDA	__@signExtend
  CMP	__@specSubY + 2
  BCC	__CMP_NO_c0b2e6d5_f20b_40e2_9642_143b121d828f
  BNE	__CMP_YES_c0b2e6d5_f20b_40e2_9642_143b121d828f
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_c0b2e6d5_f20b_40e2_9642_143b121d828f
  BNE	__CMP_YES_c0b2e6d5_f20b_40e2_9642_143b121d828f
  JMP	__CMP_YES_c0b2e6d5_f20b_40e2_9642_143b121d828f
  __CMP_YES_c0b2e6d5_f20b_40e2_9642_143b121d828f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_c0b2e6d5_f20b_40e2_9642_143b121d828f
  __CMP_NO_c0b2e6d5_f20b_40e2_9642_143b121d828f:
  SEP	#$20
  LDA	#$00
  __CMP_END_c0b2e6d5_f20b_40e2_9642_143b121d828f:
  BEQ	__IFNOT_5dc14fa7_35eb_4168_92d3_686a2b541ca1
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEC
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  CLC
  REP	#$20
  REP	#$20
  LDA	__mod16by64@ret + 0
  ADC	__mod16by64@start + 0
  STA	__mod16by64@ret + 0
  SEP	#$20
  LDA	__mod16by64@ret + 2
  ADC	__mod16by64@start + 2
  STA	__mod16by64@ret + 2
  __IFNOT_5dc14fa7_35eb_4168_92d3_686a2b541ca1:
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
  JMP	__ITER__START__9cf1abee_f682_4718_9e23_d8a2f0ed4262
  __ITER__END__9cf1abee_f682_4718_9e23_d8a2f0ed4262:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod24by64@ret + 0
  SEP	#$20
  STA	__mod24by64@ret + 2
  REP	#$20
  REP	#$20
  LDA	#$0001
  STA	__mod24by64@start + 0
  SEP	#$20
  LDA	#$00
  STA	__mod24by64@start + 2
  __ITER__START__049b0192_c78a_43c0_92fb_ce3c445fce5f:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  BNE	__CMP_YES_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  BNE	__CMP_YES_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  BNE	__CMP_YES_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  BNE	__CMP_YES_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  BNE	__CMP_YES_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  JMP	__CMP_NO_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  __CMP_YES_694069fc_bdc5_4fcf_b1cc_60991bc7c912:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_694069fc_bdc5_4fcf_b1cc_60991bc7c912
  __CMP_NO_694069fc_bdc5_4fcf_b1cc_60991bc7c912:
  SEP	#$20
  LDA	#$00
  __CMP_END_694069fc_bdc5_4fcf_b1cc_60991bc7c912:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__049b0192_c78a_43c0_92fb_ce3c445fce5f
  :
  
  REP	#$20
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
  BNE	__IFNOT_35e1c395_34ee_43d0_a5e7_a88e5e041120
  JMP	__ITER__END__049b0192_c78a_43c0_92fb_ce3c445fce5f
  __IFNOT_35e1c395_34ee_43d0_a5e7_a88e5e041120:
  REP	#$20
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
  REP	#$20
  LDA	__mod24by64@start + 0
  ASL
  STA	__mod24by64@start + 0
  SEP	#$20
  LDA	__mod24by64@start + 2
  ROL
  STA	__mod24by64@start + 2
  JMP	__ITER__START__049b0192_c78a_43c0_92fb_ce3c445fce5f
  __ITER__END__049b0192_c78a_43c0_92fb_ce3c445fce5f:
  __ITER__START__43f0cbb3_e9ab_4060_92cd_e8ecced24ffb:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__43f0cbb3_e9ab_4060_92cd_e8ecced24ffb
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  BNE	__CMP_YES_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  BNE	__CMP_YES_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  SEP	#$20
  LDA	__@signExtend
  CMP	__@specSubY + 3
  BCC	__CMP_NO_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  BNE	__CMP_YES_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  LDA	__@specSubX + 1
  CMP	__@specSubY + 1
  BCC	__CMP_NO_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  BNE	__CMP_YES_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  SEP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  BNE	__CMP_YES_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  JMP	__CMP_YES_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  __CMP_YES_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b
  __CMP_NO_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b:
  SEP	#$20
  LDA	#$00
  __CMP_END_70d5ffaa_b0c1_4e9d_8786_e7ce55c5814b:
  BEQ	__IFNOT_7dd60772_bdc8_437c_89d3_5f9d8f078347
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
  REP	#$20
  LDA	__mod24by64@ret + 0
  ADC	__mod24by64@start + 0
  STA	__mod24by64@ret + 0
  SEP	#$20
  LDA	__mod24by64@ret + 2
  ADC	__mod24by64@start + 2
  STA	__mod24by64@ret + 2
  __IFNOT_7dd60772_bdc8_437c_89d3_5f9d8f078347:
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
  JMP	__ITER__START__43f0cbb3_e9ab_4060_92cd_e8ecced24ffb
  __ITER__END__43f0cbb3_e9ab_4060_92cd_e8ecced24ffb:
  REP	#$20
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
  REP	#$20
  LDA	#$0000
  STA	__mod32by64@ret + 0
  STA	__mod32by64@ret + 2
  LDA	#$0001
  STA	__mod32by64@start + 0
  LDA	#$0000
  STA	__mod32by64@start + 2
  __ITER__START__73f7b8d4_1f74_458a_ba5d_289c007b8366:
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_b61677b3_42fc_450c_a674_1203c3cf0cdf
  BNE	__CMP_YES_b61677b3_42fc_450c_a674_1203c3cf0cdf
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_b61677b3_42fc_450c_a674_1203c3cf0cdf
  BNE	__CMP_YES_b61677b3_42fc_450c_a674_1203c3cf0cdf
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_b61677b3_42fc_450c_a674_1203c3cf0cdf
  BNE	__CMP_YES_b61677b3_42fc_450c_a674_1203c3cf0cdf
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_b61677b3_42fc_450c_a674_1203c3cf0cdf
  BNE	__CMP_YES_b61677b3_42fc_450c_a674_1203c3cf0cdf
  JMP	__CMP_NO_b61677b3_42fc_450c_a674_1203c3cf0cdf
  __CMP_YES_b61677b3_42fc_450c_a674_1203c3cf0cdf:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_b61677b3_42fc_450c_a674_1203c3cf0cdf
  __CMP_NO_b61677b3_42fc_450c_a674_1203c3cf0cdf:
  SEP	#$20
  LDA	#$00
  __CMP_END_b61677b3_42fc_450c_a674_1203c3cf0cdf:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__73f7b8d4_1f74_458a_ba5d_289c007b8366
  :
  
  REP	#$20
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
  BNE	__IFNOT_6dd68dc2_39f6_43eb_a395_26c2999ba39b
  JMP	__ITER__END__73f7b8d4_1f74_458a_ba5d_289c007b8366
  __IFNOT_6dd68dc2_39f6_43eb_a395_26c2999ba39b:
  REP	#$20
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
  REP	#$20
  LDA	__mod32by64@start + 0
  ASL
  STA	__mod32by64@start + 0
  REP	#$20
  LDA	__mod32by64@start + 2
  ROL
  STA	__mod32by64@start + 2
  JMP	__ITER__START__73f7b8d4_1f74_458a_ba5d_289c007b8366
  __ITER__END__73f7b8d4_1f74_458a_ba5d_289c007b8366:
  __ITER__START__3041b03b_c84b_45aa_809c_1e310c8aa29d:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__3041b03b_c84b_45aa_809c_1e310c8aa29d
  :
  CLC
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  CMP	__@specSubY + 6
  BCC	__CMP_NO_3b5212f1_c0ca_4984_b51e_f6884062f191
  BNE	__CMP_YES_3b5212f1_c0ca_4984_b51e_f6884062f191
  LDA	__@signExtend
  CMP	__@specSubY + 4
  BCC	__CMP_NO_3b5212f1_c0ca_4984_b51e_f6884062f191
  BNE	__CMP_YES_3b5212f1_c0ca_4984_b51e_f6884062f191
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_3b5212f1_c0ca_4984_b51e_f6884062f191
  BNE	__CMP_YES_3b5212f1_c0ca_4984_b51e_f6884062f191
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_3b5212f1_c0ca_4984_b51e_f6884062f191
  BNE	__CMP_YES_3b5212f1_c0ca_4984_b51e_f6884062f191
  JMP	__CMP_YES_3b5212f1_c0ca_4984_b51e_f6884062f191
  __CMP_YES_3b5212f1_c0ca_4984_b51e_f6884062f191:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_3b5212f1_c0ca_4984_b51e_f6884062f191
  __CMP_NO_3b5212f1_c0ca_4984_b51e_f6884062f191:
  SEP	#$20
  LDA	#$00
  __CMP_END_3b5212f1_c0ca_4984_b51e_f6884062f191:
  BEQ	__IFNOT_e6546b56_a2f6_4e14_895e_b8ce167b9913
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
  REP	#$20
  LDA	__mod32by64@ret + 0
  ADC	__mod32by64@start + 0
  STA	__mod32by64@ret + 0
  REP	#$20
  LDA	__mod32by64@ret + 2
  ADC	__mod32by64@start + 2
  STA	__mod32by64@ret + 2
  __IFNOT_e6546b56_a2f6_4e14_895e_b8ce167b9913:
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
  JMP	__ITER__START__3041b03b_c84b_45aa_809c_1e310c8aa29d
  __ITER__END__3041b03b_c84b_45aa_809c_1e310c8aa29d:
  REP	#$20
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
  __ITER__START__a36bce85_c7f2_4ae1_b5d7_fe93a7eb1e7f:
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_5d14f326_355b_4a0d_bd5d_719b89a5147e
  BNE	__CMP_YES_5d14f326_355b_4a0d_bd5d_719b89a5147e
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_5d14f326_355b_4a0d_bd5d_719b89a5147e
  BNE	__CMP_YES_5d14f326_355b_4a0d_bd5d_719b89a5147e
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_5d14f326_355b_4a0d_bd5d_719b89a5147e
  BNE	__CMP_YES_5d14f326_355b_4a0d_bd5d_719b89a5147e
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_5d14f326_355b_4a0d_bd5d_719b89a5147e
  BNE	__CMP_YES_5d14f326_355b_4a0d_bd5d_719b89a5147e
  JMP	__CMP_NO_5d14f326_355b_4a0d_bd5d_719b89a5147e
  __CMP_YES_5d14f326_355b_4a0d_bd5d_719b89a5147e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5d14f326_355b_4a0d_bd5d_719b89a5147e
  __CMP_NO_5d14f326_355b_4a0d_bd5d_719b89a5147e:
  SEP	#$20
  LDA	#$00
  __CMP_END_5d14f326_355b_4a0d_bd5d_719b89a5147e:
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__a36bce85_c7f2_4ae1_b5d7_fe93a7eb1e7f
  :
  
  REP	#$20
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
  BNE	__IFNOT_5d897c39_ea49_48f3_a301_dcf31e69da1f
  JMP	__ITER__END__a36bce85_c7f2_4ae1_b5d7_fe93a7eb1e7f
  __IFNOT_5d897c39_ea49_48f3_a301_dcf31e69da1f:
  REP	#$20
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
  JMP	__ITER__START__a36bce85_c7f2_4ae1_b5d7_fe93a7eb1e7f
  __ITER__END__a36bce85_c7f2_4ae1_b5d7_fe93a7eb1e7f:
  __ITER__START__e23ebbdf_a6ab_423d_8845_ade55ebc46a0:
  SEP	#$10
  LDX	#$01
  REP	#$20
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
  JMP	__ITER__END__e23ebbdf_a6ab_423d_8845_ade55ebc46a0
  :
  CLC
  REP	#$20
  REP	#$20
  LDA	__@specSubX + 6
  CMP	__@specSubY + 6
  BCC	__CMP_NO_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  BNE	__CMP_YES_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  REP	#$20
  LDA	__@specSubX + 4
  CMP	__@specSubY + 4
  BCC	__CMP_NO_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  BNE	__CMP_YES_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  REP	#$20
  LDA	__@specSubX + 2
  CMP	__@specSubY + 2
  BCC	__CMP_NO_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  BNE	__CMP_YES_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  REP	#$20
  LDA	__@specSubX + 0
  CMP	__@specSubY + 0
  BCC	__CMP_NO_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  BNE	__CMP_YES_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  JMP	__CMP_YES_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  __CMP_YES_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f
  __CMP_NO_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f:
  SEP	#$20
  LDA	#$00
  __CMP_END_4ea37ae2_d40c_4b0a_a3e3_be92cb6b6c6f:
  BNE	:+
  JMP	__IFNOT_711c1ff1_b8ca_4709_803f_7fbf012f826a
  :
  SEC
  REP	#$20
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
  __IFNOT_711c1ff1_b8ca_4709_803f_7fbf012f826a:
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
  JMP	__ITER__START__e23ebbdf_a6ab_423d_8845_ade55ebc46a0
  __ITER__END__e23ebbdf_a6ab_423d_8845_ade55ebc46a0:
  REP	#$20
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
