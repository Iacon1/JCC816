.p816
.smart	+
.feature at_in_identifiers
.dbg file, "Example//SNES/dma.c", 0, 0
.dbg file, "Example//SNES\Graphics\colors.c", 0, 0
.dbg file, "Example//SNES\init.asm", 0, 0
.dbg file, "Example//SNES\mmio.asm", 0, 0
.dbg file, "Example//SNES/Graphics/backgrounds.c", 0, 0
.dbg file, "Example//SNES\dma.c", 0, 0
.dbg file, "Example//SNES\Graphics\ppu.c", 0, 0
.dbg file, "Example//SNES\Graphics\backgrounds.c", 0, 0
.dbg file, "Example//example.c", 0, 0
.dbg file, "Example//SNES\Graphics\oam.c", 0, 0
.dbg file, "Example//Resources\resources.c", 0, 0
.dbg file, "Example//SNES/Graphics/oam.c", 0, 0
.dbg file, "Example//SNES/mmio.asm", 0, 0
.segment "VECTORS"
.word	RESET
.word	RESET
.word	__longCOP
.word	__longBRK
.word	__longABORT
.word	__longNMI
.word	RESET
.word	__longIRQ
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.word	RESET
.segment "HEADER"
.res	48, 0;	HEADER_HERE
__@callResult                     = $000000
__@specSubY                       = $000040
__@specSubX                       = $000050
__@funcPointer                    = $000060
__@signExtend                     = $000063
__@pointerBase                    = $000065
__@scratchBase                    = $000086
queueHDMAEN                       = $7e2000	; unsigned char (1 bytes)
.dbg sym, "queueHDMAEN", "00", EXTERN, "queueHDMAEN"
setColor@color                    = $7e2001	; unsigned short (2 bytes)
.dbg sym, "color", "00", EXTERN, "setColor@color"
setColor@destination              = $7e2003	; unsigned char (1 bytes)
.dbg sym, "destination", "00", EXTERN, "setColor@destination"
copyPalette@palette               = $7e2001	; (unsigned short)* (3 bytes)
.dbg sym, "palette", "00", EXTERN, "copyPalette@palette"
copyPalette@destination           = $7e2004	; unsigned char (1 bytes)
.dbg sym, "destination", "00", EXTERN, "copyPalette@destination"
copyPalette@paletteSize           = $7e2005	; unsigned char (1 bytes)
.dbg sym, "paletteSize", "00", EXTERN, "copyPalette@paletteSize"
setBackgroundMode@mode            = $7e2001	; unsigned char (1 bytes)
.dbg sym, "mode", "00", EXTERN, "setBackgroundMode@mode"
setBackgroundMode@BG3Priority     = $7e2002	; _Bool (1 bytes)
.dbg sym, "BG3Priority", "00", EXTERN, "setBackgroundMode@BG3Priority"
setBackgroundMode@largeTiles      = $7e2003	; _Bool (1 bytes)
.dbg sym, "largeTiles", "00", EXTERN, "setBackgroundMode@largeTiles"
setBackgroundAddress@backgroundNo = $7e2001	; unsigned char (1 bytes)
.dbg sym, "backgroundNo", "00", EXTERN, "setBackgroundAddress@backgroundNo"
setBackgroundAddress@wordAddress  = $7e2002	; unsigned short (2 bytes)
.dbg sym, "wordAddress", "00", EXTERN, "setBackgroundAddress@wordAddress"
setBackgroundAddress@tilemapCount = $7e2004	; enum TilemapCount (1 bytes)
.dbg sym, "tilemapCount", "00", EXTERN, "setBackgroundAddress@tilemapCount"
setBackgroundTileset@backgroundNo = $7e2001	; unsigned char (1 bytes)
.dbg sym, "backgroundNo", "00", EXTERN, "setBackgroundTileset@backgroundNo"
setBackgroundTileset@wordAddress  = $7e2002	; unsigned short (2 bytes)
.dbg sym, "wordAddress", "00", EXTERN, "setBackgroundTileset@wordAddress"
bufferBG12NBA                     = $7e2006	; unsigned char (1 bytes)
.dbg sym, "bufferBG12NBA", "00", EXTERN, "bufferBG12NBA"
bufferBG34NBA                     = $7e2007	; unsigned char (1 bytes)
.dbg sym, "bufferBG34NBA", "00", EXTERN, "bufferBG34NBA"
copyTilemap@tilemap               = $7e2008	; (unsigned short)* (3 bytes)
.dbg sym, "tilemap", "00", EXTERN, "copyTilemap@tilemap"
copyTilemap@destination           = $7e200b	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTilemap@destination"
copyTileRegion@tilemap            = $7e2008	; (unsigned short)* (3 bytes)
.dbg sym, "tilemap", "00", EXTERN, "copyTileRegion@tilemap"
copyTileRegion@destination        = $7e200b	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTileRegion@destination"
copyTileRegion@n                  = $7e200d	; unsigned short (2 bytes)
.dbg sym, "n", "00", EXTERN, "copyTileRegion@n"
copyTiles2BPP@tiles               = $7e2008	; (unsigned short)* (3 bytes)
.dbg sym, "tiles", "00", EXTERN, "copyTiles2BPP@tiles"
copyTiles2BPP@destination         = $7e200b	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTiles2BPP@destination"
copyTiles2BPP@nTiles              = $7e200d	; unsigned short (2 bytes)
.dbg sym, "nTiles", "00", EXTERN, "copyTiles2BPP@nTiles"
copyTiles4BPP@tiles               = $7e2008	; (unsigned short)* (3 bytes)
.dbg sym, "tiles", "00", EXTERN, "copyTiles4BPP@tiles"
copyTiles4BPP@destination         = $7e200b	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTiles4BPP@destination"
copyTiles4BPP@nTiles              = $7e200d	; unsigned short (2 bytes)
.dbg sym, "nTiles", "00", EXTERN, "copyTiles4BPP@nTiles"
copyTiles8BPP@tiles               = $7e2008	; (unsigned short)* (3 bytes)
.dbg sym, "tiles", "00", EXTERN, "copyTiles8BPP@tiles"
copyTiles8BPP@destination         = $7e200b	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTiles8BPP@destination"
copyTiles8BPP@nTiles              = $7e200d	; unsigned short (2 bytes)
.dbg sym, "nTiles", "00", EXTERN, "copyTiles8BPP@nTiles"
setHighOAMProperties@i            = $7e2008	; unsigned char (1 bytes)
.dbg sym, "i", "00", EXTERN, "setHighOAMProperties@i"
setHighOAMProperties@xShift       = $7e2009	; _Bool (1 bytes)
.dbg sym, "xShift", "00", EXTERN, "setHighOAMProperties@xShift"
setHighOAMProperties@largeSprite  = $7e200a	; _Bool (1 bytes)
.dbg sym, "largeSprite", "00", EXTERN, "setHighOAMProperties@largeSprite"
isScanning                        = $7e200f	; _Bool (1 bytes)
.dbg sym, "isScanning", "00", EXTERN, "isScanning"
isColliding@x1                    = $7e2010	; unsigned char (1 bytes)
.dbg sym, "x1", "00", EXTERN, "isColliding@x1"
isColliding@w1                    = $7e2011	; unsigned char (1 bytes)
.dbg sym, "w1", "00", EXTERN, "isColliding@w1"
isColliding@y1                    = $7e2012	; unsigned char (1 bytes)
.dbg sym, "y1", "00", EXTERN, "isColliding@y1"
isColliding@h1                    = $7e2013	; unsigned char (1 bytes)
.dbg sym, "h1", "00", EXTERN, "isColliding@h1"
isColliding@x2                    = $7e2014	; unsigned char (1 bytes)
.dbg sym, "x2", "00", EXTERN, "isColliding@x2"
isColliding@w2                    = $7e2015	; unsigned char (1 bytes)
.dbg sym, "w2", "00", EXTERN, "isColliding@w2"
isColliding@y2                    = $7e2016	; unsigned char (1 bytes)
.dbg sym, "y2", "00", EXTERN, "isColliding@y2"
isColliding@h2                    = $7e2017	; unsigned char (1 bytes)
.dbg sym, "h2", "00", EXTERN, "isColliding@h2"
uiToTiles@c                       = $7e2010	; (unsigned short)* (3 bytes)
.dbg sym, "c", "00", EXTERN, "uiToTiles@c"
uiToTiles@n                       = $7e2013	; unsigned char (1 bytes)
.dbg sym, "n", "00", EXTERN, "uiToTiles@n"
uiToTiles@value                   = $7e2014	; unsigned int (3 bytes)
.dbg sym, "value", "00", EXTERN, "uiToTiles@value"
uiToTiles@zeroTile                = $7e2017	; unsigned short (2 bytes)
.dbg sym, "zeroTile", "00", EXTERN, "uiToTiles@zeroTile"
uiToTiles@x                       = $7e2019	; unsigned short (2 bytes)
.dbg sym, "x", "00", EXTERN, "uiToTiles@x"
uiToTiles@i                       = $7e201b	; short (2 bytes)
.dbg sym, "i", "00", EXTERN, "uiToTiles@i"
main@tilemapAddress               = $7e201d	; unsigned short (2 bytes)
.dbg sym, "tilemapAddress", "00", EXTERN, "main@tilemapAddress"
main@tilesetAddress               = $7e201f	; unsigned short (2 bytes)
.dbg sym, "tilesetAddress", "00", EXTERN, "main@tilesetAddress"
main@scoreP1                      = $7e2021	; unsigned int (3 bytes)
.dbg sym, "scoreP1", "00", EXTERN, "main@scoreP1"
main@scoreP2                      = $7e2024	; unsigned int (3 bytes)
.dbg sym, "scoreP2", "00", EXTERN, "main@scoreP2"
main@scoreP1Tiles                 = $7e2027	; unsigned short[4] (8 bytes)
.dbg sym, "scoreP1Tiles", "00", EXTERN, "main@scoreP1Tiles"
main@scoreP2Tiles                 = $7e202f	; unsigned short[4] (8 bytes)
.dbg sym, "scoreP2Tiles", "00", EXTERN, "main@scoreP2Tiles"
main@goRight                      = $7e2037	; _Bool (1 bytes)
.dbg sym, "goRight", "00", EXTERN, "main@goRight"
main@goDown                       = $7e2038	; _Bool (1 bytes)
.dbg sym, "goDown", "00", EXTERN, "main@goDown"
main@refreshScores                = $7e2039	; _Bool (1 bytes)
.dbg sym, "refreshScores", "00", EXTERN, "main@refreshScores"
lowOAMBuffer                      = $7e203a	; struct LowOAMObj[128] (512 bytes)
.dbg sym, "lowOAMBuffer", "00", EXTERN, "lowOAMBuffer"
highOAMBuffer                     = $7e223a	; unsigned char[32] (32 bytes)
.dbg sym, "highOAMBuffer", "00", EXTERN, "highOAMBuffer"
setHighOAMProperties@j            = $7e225a	; unsigned char (1 bytes)
.dbg sym, "j", "00", EXTERN, "setHighOAMProperties@j"
setHighOAMProperties@b            = $7e225b	; unsigned char (1 bytes)
.dbg sym, "b", "00", EXTERN, "setHighOAMProperties@b"
clearOAMBuffers@i                 = $7e225a	; unsigned char (1 bytes)
.dbg sym, "i", "00", EXTERN, "clearOAMBuffers@i"
__REG@WRMPYA                      = $004202
__REG@WRMPYB                      = $004203
__REG@WRDIVL                      = $004204
__REG@WRDIVH                      = $004205
__REG@WRDIVB                      = $004206
__REG@RDDIVL                      = $004214
__REG@RDDIVH                      = $004215
__REG@RDMPYL                      = $004216
__REG@RDMPYH                      = $004217
.segment "ROM000"
RESET:
SEI
CLC
XCE
REP	#$28
LDA	#$1fff
TCS
PHK
PEA	RESET
SEP	#$30
LDA	#$00
STA	queueHDMAEN + 0
LDA	#$00
STA	bufferBG12NBA + 0
LDA	#$00
STA	bufferBG34NBA + 0
LDA	#$00
STA	queueHDMAEN + 0
LDA	#$00
STA	bufferBG12NBA + 0
LDA	#$00
STA	bufferBG34NBA + 0
JML	main
__longCOP:JML	RESET
__longBRK:JML	RESET
__longABORT:JML	RESET
__longNMI:JML	handleNMI
__longIRQ:JML	RESET
__modulator@3@1:
  REP	#$30
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  SEP	#$20
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  REP	#$20
  LDA	__@specSubX + 1
  TAX
  NOP
  NOP
  LDA	__REG@RDMPYL
  STA	__@callResult + 0
  TXA
  SEP	#$30
  LDA	__@specSubX + 2
  STA	__REG@WRDIVL
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  LDA	__REG@RDMPYL
  STA	__@signExtend
RTL
__divider@3@1:
  REP	#$30
  LDA	__@specSubX + 0
  STA	__REG@WRDIVL
  SEP	#$20
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  REP	#$20
  LDA	__@specSubX + 1
  TAX
  NOP
  NOP
  LDA	__REG@RDDIVL
  STA	__@callResult + 0
  TXA
  SEP	#$30
  LDA	__@specSubX + 2
  STA	__REG@WRDIVL
  LDA	__@specSubY + 0
  STA	__REG@WRDIVB
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  NOP
  LDA	__REG@RDDIVL
  STA	__@callResult + 2
RTL
__multiplier@1@1:
  SEP	#$30
  LDA	__@specSubX + 0
  STA	__REG@WRMPYA
  LDA	__@specSubY + 0
  STA	__REG@WRMPYB
  NOP
  NOP
  LDA	__REG@RDMPYL
  STA	__@callResult + 0
  LDA	__REG@RDMPYH
  STA	__@callResult + 1
RTL
runAllHDMAs:	; @func void()
  .dbg	line, "Example//SNES/dma.c", 9
  SEP	#$30
  LDA	queueHDMAEN + 0
  STA	HDMAEN + 0
  .dbg	line, "Example//SNES/dma.c", 10
  LDA	#$00
  STA	queueHDMAEN + 0
__runAllHDMAs_END: RTL
setColor:	; @func void(unsigned short, unsigned char)
  .dbg	line, "Example//SNES\Graphics\colors.c", 9
  SEP	#$30
  LDA	setColor@destination + 0
  STA	CGADDR + 0
  .dbg	line, "Example//SNES\Graphics\colors.c", 10
  LDA	setColor@color + 0
  STA	CGDATA + 0
  LDA	setColor@color + 1
  STA	CGDATA + 0
__setColor_END: RTL
copyPalette:	; @func void((unsigned short)*, unsigned char, unsigned char)
  .dbg	line, "Example//SNES\Graphics\colors.c", 15
  SEP	#$30
  LDA	#$02
  STA	DMACHN + 0
  .dbg	line, "Example//SNES\Graphics\colors.c", 16
  LDA	copyPalette@destination + 0
  STA	CGADDR + 0
  .dbg	line, "Example//SNES\Graphics\colors.c", 17
  LDA	#.loByte(CGDATA)
  STA	DMACHN + 1
  .dbg	line, "Example//SNES\Graphics\colors.c", 18
  REP	#$30
  LDA	copyPalette@palette + 0
  STA	DMACHN + 2
  SEP	#$30
  LDA	copyPalette@palette + 2
  STA	DMACHN + 4
  .dbg	line, "Example//SNES\Graphics\colors.c", 19
  LDA	copyPalette@paletteSize + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  SEP	#$20
  REP	#$30
  LDA	#$0000
  STA	DMACHN + 6
  SEP	#$30
  LDA	copyPalette@paletteSize + 0
  STA	DMACHN + 5
  REP	#$30
  LDA	DMACHN + 5
  ASL
  STA	DMACHN + 5
  SEP	#$30
  LDA	DMACHN + 7
  ROL
  STA	DMACHN + 7
  .dbg	line, "Example//SNES\Graphics\colors.c", 20
  LDA	#$01
  STA	MDMAEN + 0
__copyPalette_END: RTL
setBackgroundMode:	; @func void(unsigned char, _Bool, _Bool)
  .dbg	line, "Example//SNES/Graphics/backgrounds.c", 11
  SEP	#$20
  LDA	setBackgroundMode@largeTiles + 0
  BNE	:+
  JMP	__condSkipeab46c98_5f98_48e7_a9fe_a01e8a42031a
  :
  SEP	#$30
  LDA	#$f0
  STA	__@scratchBase + 0
  JMP	__condEnd008f85c6_ca0b_4a3b_ba59_4a42d4b474ed
  __condSkipeab46c98_5f98_48e7_a9fe_a01e8a42031a:
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 0
  __condEnd008f85c6_ca0b_4a3b_ba59_4a42d4b474ed:
  SEP	#$30
  LDA	setBackgroundMode@mode + 0
  ORA	__@scratchBase + 0
  STA	setBackgroundMode@mode + 0
  .dbg	line, "Example//SNES/Graphics/backgrounds.c", 12
  LDA	setBackgroundMode@BG3Priority + 0
  BEQ	__IFNOT_49e99689_f347_405d_939f_91afa3827b6e
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 12
    LDA	setBackgroundMode@mode + 0
    ORA	#$08
    STA	setBackgroundMode@mode + 0
  __IFNOT_49e99689_f347_405d_939f_91afa3827b6e:
  .dbg	line, "Example//SNES/Graphics/backgrounds.c", 13
  SEP	#$30
  LDA	setBackgroundMode@mode + 0
  STA	BGMODE + 0
__setBackgroundMode_END: RTL
setBackgroundAddress:	; @func void(unsigned char, unsigned short, enum TilemapCount)
  .dbg	line, "Example//SNES/Graphics/backgrounds.c", 19
  CLC
  SEP	#$20
  LDA	setBackgroundAddress@backgroundNo + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  REP	#$30
  SEP	#$20
  LDA	#.loByte(BGSC)
  ADC	setBackgroundAddress@backgroundNo + 0
  STA	__@pointerBase + 0
  LDA	#.hiByte(BGSC)
  ADC	__@signExtend
  STA	__@pointerBase + 1
  REP	#$20
  SEP	#$30
  LDA	#.bankByte(BGSC)
  ADC	__@signExtend
  STA	__@pointerBase + 2
  LDA	setBackgroundAddress@wordAddress + 1
  STA	__@scratchBase + 0
  LDA	setBackgroundAddress@tilemapCount + 0
  ORA	__@scratchBase + 0
  LDY	#$00
  STA	[__@pointerBase],y
__setBackgroundAddress_END: RTL
setBackgroundTileset:	; @func void(unsigned char, unsigned short)
  .dbg	line, "Example//SNES/Graphics/backgrounds.c", 24
  SEP	#$30
  LDA	setBackgroundTileset@backgroundNo + 0
  STA	__@scratchBase + 0
  LDA	__@signExtend
  STA	__@signExtend
  CLC
  LDA	__@scratchBase + 0
  CMP	#$03
  BCC	:+
  BRA	:++
  :JMP	__mLabel6438ac00_8f21_43ba_aea1_fd218979a6e9
  :BEQ	:+
  JMP	__CASE_SKIP_7494b3d0_62a4_4e3b_9c36_4b333d9796ec
  :
  SEP	#$30
  JMP	__mLabel6438ac00_8f21_43ba_aea1_fd218979a6e9
  __mLabel6438ac00_8f21_43ba_aea1_fd218979a6e9:
  SEP	#$30
  LDA	__@scratchBase + 0
  ASL
  STA	__@scratchBase + 3
  TAX
  JMP	(__SWITCH_TABLE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec,x)
  __SWITCH_TABLE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec:
    .word	__CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_0
    .word	__CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_1
    .word	__CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_2
    .word	__CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_3
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 26
    __CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_0:
    SEP	#$30
    LDA	bufferBG12NBA + 0
    AND	#$f0
    STA	bufferBG12NBA + 0
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 28
    LDA	setBackgroundTileset@wordAddress + 1
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$30
    LDA	setBackgroundTileset@wordAddress + 1
    STA	__@scratchBase + 1
    LDA	#$00
    STA	__@scratchBase + 2
    REP	#$30
    LDA	__@scratchBase + 1
    STA	__@scratchBase + 4
    SEP	#$30
    LDA	__@scratchBase + 3
    STA	__@scratchBase + 6
    LDA	#$04
    BEQ	:++
    TAX	
   :
      REP	#$30
      LDA	__@scratchBase + 5
      LSR
      STA	__@scratchBase + 5
      SEP	#$30
      LDA	__@scratchBase + 4
      ROR
      STA	__@scratchBase + 4
      DEX
      BNE	:-
   :
    SEP	#$30
    LDA	__@scratchBase + 4
    STA	__@scratchBase + 0
    LDA	bufferBG12NBA + 0
    ORA	__@scratchBase + 0
    STA	bufferBG12NBA + 0
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 29
    JMP	__CASE_SKIP_7494b3d0_62a4_4e3b_9c36_4b333d9796ec
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 30
    __CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_1:
    SEP	#$30
    LDA	bufferBG12NBA + 0
    AND	#$0f
    STA	bufferBG12NBA + 0
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 32
    LDA	setBackgroundTileset@wordAddress + 1
    STA	__@scratchBase + 1
    LDA	__@scratchBase + 1
    AND	#$f0
    STA	__@scratchBase + 0
    LDA	bufferBG12NBA + 0
    ORA	__@scratchBase + 0
    STA	bufferBG12NBA + 0
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 33
    JMP	__CASE_SKIP_7494b3d0_62a4_4e3b_9c36_4b333d9796ec
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 34
    __CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_2:
    SEP	#$30
    LDA	bufferBG34NBA + 0
    AND	#$f0
    STA	bufferBG34NBA + 0
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 36
    LDA	setBackgroundTileset@wordAddress + 1
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$30
    LDA	setBackgroundTileset@wordAddress + 1
    STA	__@scratchBase + 1
    LDA	#$00
    STA	__@scratchBase + 2
    REP	#$30
    LDA	__@scratchBase + 1
    STA	__@scratchBase + 4
    SEP	#$30
    LDA	__@scratchBase + 3
    STA	__@scratchBase + 6
    LDA	#$04
    BEQ	:++
    TAX	
   :
      REP	#$30
      LDA	__@scratchBase + 5
      LSR
      STA	__@scratchBase + 5
      SEP	#$30
      LDA	__@scratchBase + 4
      ROR
      STA	__@scratchBase + 4
      DEX
      BNE	:-
   :
    SEP	#$30
    LDA	__@scratchBase + 4
    STA	__@scratchBase + 0
    LDA	bufferBG34NBA + 0
    ORA	__@scratchBase + 0
    STA	bufferBG34NBA + 0
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 37
    JMP	__CASE_SKIP_7494b3d0_62a4_4e3b_9c36_4b333d9796ec
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 38
    __CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_3:
    SEP	#$30
    LDA	bufferBG34NBA + 0
    AND	#$0f
    STA	bufferBG34NBA + 0
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 40
    LDA	setBackgroundTileset@wordAddress + 1
    STA	__@scratchBase + 1
    LDA	__@scratchBase + 1
    AND	#$f0
    STA	__@scratchBase + 0
    LDA	bufferBG34NBA + 0
    ORA	__@scratchBase + 0
    STA	bufferBG34NBA + 0
    .dbg	line, "Example//SNES/Graphics/backgrounds.c", 41
    JMP	__CASE_SKIP_7494b3d0_62a4_4e3b_9c36_4b333d9796ec
  __CASE_7494b3d0_62a4_4e3b_9c36_4b333d9796ec_DEF:
  __CASE_SKIP_7494b3d0_62a4_4e3b_9c36_4b333d9796ec:
  .dbg	line, "Example//SNES/Graphics/backgrounds.c", 44
  SEP	#$30
  LDA	bufferBG12NBA + 0
  STA	BG12NBA + 0
  .dbg	line, "Example//SNES/Graphics/backgrounds.c", 45
  LDA	bufferBG34NBA + 0
  STA	BG34NBA + 0
__setBackgroundTileset_END: RTL
copyTilemap:	; @func void((unsigned short)*, unsigned short)
  .dbg	line, "Example//SNES\Graphics\ppu.c", 8
  SEP	#$30
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 9
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 10
  REP	#$30
  LDA	copyTilemap@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 11
  SEP	#$30
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example//SNES\Graphics\ppu.c", 12
  REP	#$30
  LDA	copyTilemap@tilemap + 0
  STA	DMACHN + 2
  SEP	#$30
  LDA	copyTilemap@tilemap + 2
  STA	DMACHN + 4
  .dbg	line, "Example//SNES\Graphics\ppu.c", 13
  REP	#$30
  LDA	#$0800
  STA	DMACHN + 5
  SEP	#$30
  LDA	#$00
  STA	DMACHN + 7
  .dbg	line, "Example//SNES\Graphics\ppu.c", 14
  LDA	#$01
  STA	MDMAEN + 0
__copyTilemap_END: RTL
copyTileRegion:	; @func void((unsigned short)*, unsigned short, unsigned short)
  .dbg	line, "Example//SNES\Graphics\ppu.c", 18
  SEP	#$30
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 19
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 20
  REP	#$30
  LDA	copyTileRegion@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 21
  SEP	#$30
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example//SNES\Graphics\ppu.c", 22
  REP	#$30
  LDA	copyTileRegion@tilemap + 0
  STA	DMACHN + 2
  SEP	#$30
  LDA	copyTileRegion@tilemap + 2
  STA	DMACHN + 4
  .dbg	line, "Example//SNES\Graphics\ppu.c", 23
  LDA	copyTileRegion@n + 1
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  SEP	#$30
  LDA	#$00
  STA	DMACHN + 7
  REP	#$30
  LDA	copyTileRegion@n + 0
  STA	DMACHN + 5
  LDA	DMACHN + 5
  ASL
  STA	DMACHN + 5
  SEP	#$30
  LDA	DMACHN + 7
  ROL
  STA	DMACHN + 7
  .dbg	line, "Example//SNES\Graphics\ppu.c", 24
  LDA	#$01
  STA	MDMAEN + 0
__copyTileRegion_END: RTL
copyTiles2BPP:	; @func void((unsigned short)*, unsigned short, unsigned short)
  .dbg	line, "Example//SNES\Graphics\ppu.c", 29
  SEP	#$30
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 30
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 31
  REP	#$30
  LDA	copyTiles2BPP@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 32
  SEP	#$30
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example//SNES\Graphics\ppu.c", 33
  REP	#$30
  LDA	copyTiles2BPP@tiles + 0
  STA	DMACHN + 2
  SEP	#$30
  LDA	copyTiles2BPP@tiles + 2
  STA	DMACHN + 4
  .dbg	line, "Example//SNES\Graphics\ppu.c", 34
  LDA	copyTiles2BPP@nTiles + 1
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  SEP	#$30
  LDA	#$00
  STA	DMACHN + 7
  REP	#$30
  LDA	copyTiles2BPP@nTiles + 0
  STA	DMACHN + 5
  LDA	#$04
  BEQ	:++
  TAX	
 :
    REP	#$30
    LDA	DMACHN + 5
    ASL
    STA	DMACHN + 5
    SEP	#$30
    LDA	DMACHN + 7
    ROL
    STA	DMACHN + 7
    DEX
    BNE	:-
 :
  .dbg	line, "Example//SNES\Graphics\ppu.c", 35
  SEP	#$30
  LDA	#$01
  STA	MDMAEN + 0
__copyTiles2BPP_END: RTL
copyTiles4BPP:	; @func void((unsigned short)*, unsigned short, unsigned short)
  .dbg	line, "Example//SNES\Graphics\ppu.c", 39
  SEP	#$30
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 40
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 41
  REP	#$30
  LDA	copyTiles4BPP@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 42
  SEP	#$30
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example//SNES\Graphics\ppu.c", 43
  REP	#$30
  LDA	copyTiles4BPP@tiles + 0
  STA	DMACHN + 2
  SEP	#$30
  LDA	copyTiles4BPP@tiles + 2
  STA	DMACHN + 4
  .dbg	line, "Example//SNES\Graphics\ppu.c", 44
  LDA	copyTiles4BPP@nTiles + 1
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  SEP	#$30
  LDA	#$00
  STA	DMACHN + 7
  REP	#$30
  LDA	copyTiles4BPP@nTiles + 0
  STA	DMACHN + 5
  LDA	#$05
  BEQ	:++
  TAX	
 :
    REP	#$30
    LDA	DMACHN + 5
    ASL
    STA	DMACHN + 5
    SEP	#$30
    LDA	DMACHN + 7
    ROL
    STA	DMACHN + 7
    DEX
    BNE	:-
 :
  .dbg	line, "Example//SNES\Graphics\ppu.c", 45
  SEP	#$30
  LDA	#$01
  STA	MDMAEN + 0
__copyTiles4BPP_END: RTL
copyTiles8BPP:	; @func void((unsigned short)*, unsigned short, unsigned short)
  .dbg	line, "Example//SNES\Graphics\ppu.c", 49
  SEP	#$30
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 50
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 51
  REP	#$30
  LDA	copyTiles8BPP@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example//SNES\Graphics\ppu.c", 52
  SEP	#$30
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example//SNES\Graphics\ppu.c", 53
  REP	#$30
  LDA	copyTiles8BPP@tiles + 0
  STA	DMACHN + 2
  SEP	#$30
  LDA	copyTiles8BPP@tiles + 2
  STA	DMACHN + 4
  .dbg	line, "Example//SNES\Graphics\ppu.c", 54
  LDA	copyTiles8BPP@nTiles + 1
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  SEP	#$30
  LDA	#$00
  STA	DMACHN + 7
  REP	#$30
  LDA	copyTiles8BPP@nTiles + 0
  STA	DMACHN + 5
  LDA	#$06
  BEQ	:++
  TAX	
 :
    REP	#$30
    LDA	DMACHN + 5
    ASL
    STA	DMACHN + 5
    SEP	#$30
    LDA	DMACHN + 7
    ROL
    STA	DMACHN + 7
    DEX
    BNE	:-
 :
  .dbg	line, "Example//SNES\Graphics\ppu.c", 55
  SEP	#$30
  LDA	#$01
  STA	MDMAEN + 0
__copyTiles8BPP_END: RTL
setHighOAMProperties:	; @func void(unsigned char, _Bool, _Bool)
  .dbg	line, "Example//SNES\Graphics\oam.c", 27
  SEP	#$30
  LDA	#$03
  AND	setHighOAMProperties@i + 0
  STA	setHighOAMProperties@j + 0
  .dbg	line, "Example//SNES\Graphics\oam.c", 28
  LDA	setHighOAMProperties@i + 0
  STA	setHighOAMProperties@i + 0
  LDA	#$02
  BEQ	:++
  TAX	
 :
    SEP	#$30
    LDA	setHighOAMProperties@i + 0
    LSR
    STA	setHighOAMProperties@i + 0
    DEX
    BNE	:-
 :
  .dbg	line, "Example//SNES\Graphics\oam.c", 29
  CLC
  SEP	#$20
  LDA	setHighOAMProperties@i + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  REP	#$30
  SEP	#$20
  LDA	#.loByte(highOAMBuffer)
  ADC	setHighOAMProperties@i + 0
  STA	__@pointerBase + 0
  LDA	#.hiByte(highOAMBuffer)
  ADC	__@signExtend
  STA	__@pointerBase + 1
  REP	#$20
  SEP	#$30
  LDA	#.bankByte(highOAMBuffer)
  ADC	__@signExtend
  STA	__@pointerBase + 2
  LDY	#$00
  LDA	[__@pointerBase],y
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example//SNES\Graphics\oam.c", 30
  LDA	setHighOAMProperties@j + 0
  STA	__@scratchBase + 0
  LDA	__@signExtend
  STA	__@signExtend
  CLC
  LDA	__@scratchBase + 0
  CMP	#$03
  BCC	:+
  BRA	:++
  :JMP	__mLabelea23a9f6_f53a_4ff8_a9d7_80bff054aa94
  :BEQ	:+
  JMP	__CASE_SKIP_a5894604_8d2d_4c78_a444_8362553e435f
  :
  SEP	#$30
  JMP	__mLabelea23a9f6_f53a_4ff8_a9d7_80bff054aa94
  __mLabelea23a9f6_f53a_4ff8_a9d7_80bff054aa94:
  SEP	#$30
  LDA	__@scratchBase + 0
  ASL
  STA	__@scratchBase + 3
  TAX
  JMP	(__SWITCH_TABLE_a5894604_8d2d_4c78_a444_8362553e435f,x)
  __SWITCH_TABLE_a5894604_8d2d_4c78_a444_8362553e435f:
    .word	__CASE_a5894604_8d2d_4c78_a444_8362553e435f_0
    .word	__CASE_a5894604_8d2d_4c78_a444_8362553e435f_1
    .word	__CASE_a5894604_8d2d_4c78_a444_8362553e435f_2
    .word	__CASE_a5894604_8d2d_4c78_a444_8362553e435f_3
    .dbg	line, "Example//SNES\Graphics\oam.c", 32
    __CASE_a5894604_8d2d_4c78_a444_8362553e435f_0:
    SEP	#$30
    LDA	setHighOAMProperties@b + 0
    AND	#$fc
    STA	setHighOAMProperties@b + 0
    .dbg	line, "Example//SNES\Graphics\oam.c", 34
    LDA	setHighOAMProperties@largeSprite + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$20
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 4
    SEP	#$30
    LDA	setHighOAMProperties@largeSprite + 0
    STA	__@scratchBase + 3
    REP	#$30
    LDA	__@scratchBase + 3
    ASL
    STA	__@scratchBase + 3
    SEP	#$30
    LDA	__@scratchBase + 5
    ROL
    STA	__@scratchBase + 5
    LDA	setHighOAMProperties@xShift + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    REP	#$30
    SEP	#$20
    LDA	setHighOAMProperties@xShift + 0
    ORA	__@scratchBase + 3
    STA	__@scratchBase + 0
    LDA	__@signExtend
    ORA	__@scratchBase + 4
    STA	__@scratchBase + 1
    REP	#$20
    SEP	#$30
    LDA	__@signExtend
    ORA	__@scratchBase + 5
    STA	__@scratchBase + 2
    LDA	#$00
    STA	__@signExtend
    LDA	setHighOAMProperties@b + 0
    ORA	__@scratchBase + 0
    STA	setHighOAMProperties@b + 0
    LDA	__@signExtend
    ORA	__@scratchBase + 1
    STA	__@signExtend
    REP	#$20
    .dbg	line, "Example//SNES\Graphics\oam.c", 35
    JMP	__CASE_SKIP_a5894604_8d2d_4c78_a444_8362553e435f
    .dbg	line, "Example//SNES\Graphics\oam.c", 36
    __CASE_a5894604_8d2d_4c78_a444_8362553e435f_1:
    SEP	#$30
    LDA	setHighOAMProperties@b + 0
    AND	#$f3
    STA	setHighOAMProperties@b + 0
    .dbg	line, "Example//SNES\Graphics\oam.c", 38
    LDA	setHighOAMProperties@xShift + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$20
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 4
    SEP	#$30
    LDA	setHighOAMProperties@xShift + 0
    STA	__@scratchBase + 3
    LDA	#$02
    BEQ	:++
    TAX	
   :
      REP	#$30
      LDA	__@scratchBase + 3
      ASL
      STA	__@scratchBase + 3
      SEP	#$30
      LDA	__@scratchBase + 5
      ROL
      STA	__@scratchBase + 5
      DEX
      BNE	:-
   :
    SEP	#$20
    LDA	setHighOAMProperties@largeSprite + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$20
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 7
    SEP	#$30
    LDA	setHighOAMProperties@largeSprite + 0
    STA	__@scratchBase + 6
    LDA	#$03
    BEQ	:++
    TAX	
   :
      REP	#$30
      LDA	__@scratchBase + 6
      ASL
      STA	__@scratchBase + 6
      SEP	#$30
      LDA	__@scratchBase + 8
      ROL
      STA	__@scratchBase + 8
      DEX
      BNE	:-
   :
    REP	#$30
    LDA	__@scratchBase + 3
    ORA	__@scratchBase + 6
    STA	__@scratchBase + 0
    SEP	#$30
    LDA	__@scratchBase + 5
    ORA	__@scratchBase + 8
    STA	__@scratchBase + 2
    LDA	#$00
    STA	__@signExtend
    LDA	setHighOAMProperties@b + 0
    ORA	__@scratchBase + 0
    STA	setHighOAMProperties@b + 0
    LDA	__@signExtend
    ORA	__@scratchBase + 1
    STA	__@signExtend
    REP	#$20
    .dbg	line, "Example//SNES\Graphics\oam.c", 39
    JMP	__CASE_SKIP_a5894604_8d2d_4c78_a444_8362553e435f
    .dbg	line, "Example//SNES\Graphics\oam.c", 40
    __CASE_a5894604_8d2d_4c78_a444_8362553e435f_2:
    SEP	#$30
    LDA	setHighOAMProperties@b + 0
    AND	#$cf
    STA	setHighOAMProperties@b + 0
    .dbg	line, "Example//SNES\Graphics\oam.c", 42
    LDA	setHighOAMProperties@xShift + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$20
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 4
    SEP	#$30
    LDA	setHighOAMProperties@xShift + 0
    STA	__@scratchBase + 3
    LDA	#$04
    BEQ	:++
    TAX	
   :
      REP	#$30
      LDA	__@scratchBase + 3
      ASL
      STA	__@scratchBase + 3
      SEP	#$30
      LDA	__@scratchBase + 5
      ROL
      STA	__@scratchBase + 5
      DEX
      BNE	:-
   :
    SEP	#$20
    LDA	setHighOAMProperties@largeSprite + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$20
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 7
    SEP	#$30
    LDA	setHighOAMProperties@largeSprite + 0
    STA	__@scratchBase + 6
    LDA	#$05
    BEQ	:++
    TAX	
   :
      REP	#$30
      LDA	__@scratchBase + 6
      ASL
      STA	__@scratchBase + 6
      SEP	#$30
      LDA	__@scratchBase + 8
      ROL
      STA	__@scratchBase + 8
      DEX
      BNE	:-
   :
    REP	#$30
    LDA	__@scratchBase + 3
    ORA	__@scratchBase + 6
    STA	__@scratchBase + 0
    SEP	#$30
    LDA	__@scratchBase + 5
    ORA	__@scratchBase + 8
    STA	__@scratchBase + 2
    LDA	#$00
    STA	__@signExtend
    LDA	setHighOAMProperties@b + 0
    ORA	__@scratchBase + 0
    STA	setHighOAMProperties@b + 0
    LDA	__@signExtend
    ORA	__@scratchBase + 1
    STA	__@signExtend
    REP	#$20
    .dbg	line, "Example//SNES\Graphics\oam.c", 43
    JMP	__CASE_SKIP_a5894604_8d2d_4c78_a444_8362553e435f
    .dbg	line, "Example//SNES\Graphics\oam.c", 44
    __CASE_a5894604_8d2d_4c78_a444_8362553e435f_3:
    SEP	#$30
    LDA	setHighOAMProperties@b + 0
    AND	#$f3
    STA	setHighOAMProperties@b + 0
    .dbg	line, "Example//SNES\Graphics\oam.c", 46
    LDA	setHighOAMProperties@xShift + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$20
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 4
    SEP	#$30
    LDA	setHighOAMProperties@xShift + 0
    STA	__@scratchBase + 3
    LDA	#$06
    BEQ	:++
    TAX	
   :
      REP	#$30
      LDA	__@scratchBase + 3
      ASL
      STA	__@scratchBase + 3
      SEP	#$30
      LDA	__@scratchBase + 5
      ROL
      STA	__@scratchBase + 5
      DEX
      BNE	:-
   :
    SEP	#$20
    LDA	setHighOAMProperties@largeSprite + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$20
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 7
    SEP	#$30
    LDA	setHighOAMProperties@largeSprite + 0
    STA	__@scratchBase + 6
    LDA	#$07
    BEQ	:++
    TAX	
   :
      REP	#$30
      LDA	__@scratchBase + 6
      ASL
      STA	__@scratchBase + 6
      SEP	#$30
      LDA	__@scratchBase + 8
      ROL
      STA	__@scratchBase + 8
      DEX
      BNE	:-
   :
    REP	#$30
    LDA	__@scratchBase + 3
    ORA	__@scratchBase + 6
    STA	__@scratchBase + 0
    SEP	#$30
    LDA	__@scratchBase + 5
    ORA	__@scratchBase + 8
    STA	__@scratchBase + 2
    LDA	#$00
    STA	__@signExtend
    LDA	setHighOAMProperties@b + 0
    ORA	__@scratchBase + 0
    STA	setHighOAMProperties@b + 0
    LDA	__@signExtend
    ORA	__@scratchBase + 1
    STA	__@signExtend
    REP	#$20
    .dbg	line, "Example//SNES\Graphics\oam.c", 47
    JMP	__CASE_SKIP_a5894604_8d2d_4c78_a444_8362553e435f
  __CASE_a5894604_8d2d_4c78_a444_8362553e435f_DEF:
  __CASE_SKIP_a5894604_8d2d_4c78_a444_8362553e435f:
  .dbg	line, "Example//SNES\Graphics\oam.c", 49
  CLC
  SEP	#$20
  LDA	setHighOAMProperties@i + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  REP	#$30
  SEP	#$20
  LDA	#.loByte(highOAMBuffer)
  ADC	setHighOAMProperties@i + 0
  STA	__@pointerBase + 0
  LDA	#.hiByte(highOAMBuffer)
  ADC	__@signExtend
  STA	__@pointerBase + 1
  REP	#$20
  SEP	#$30
  LDA	#.bankByte(highOAMBuffer)
  ADC	__@signExtend
  STA	__@pointerBase + 2
  LDA	setHighOAMProperties@b + 0
  LDY	#$00
  STA	[__@pointerBase],y
__setHighOAMProperties_END: RTL
clearOAMBuffers:	; @func void()
  .dbg	line, "Example//SNES\Graphics\oam.c", 11
  .dbg	line, "Example//SNES\Graphics\oam.c", 12
  SEP	#$30
  LDA	#$00
  STA	clearOAMBuffers@i + 0
  __ITER__START__dfefb7a8_94e4_4c9f_8c61_bc2beebef6da:
    CLC
  SEP	#$30
  LDA	clearOAMBuffers@i + 0
  CMP	#$80
  BCC	:+
  BRA	:++
  :JMP	__CMP_YES_3f5c7d40_028c_429d_89ca_3a1635a45a11
  :BEQ	:+
  JMP	__CMP_NO_3f5c7d40_028c_429d_89ca_3a1635a45a11
  :
  SEP	#$30
  JMP	__CMP_NO_3f5c7d40_028c_429d_89ca_3a1635a45a11
  __CMP_YES_3f5c7d40_028c_429d_89ca_3a1635a45a11:
  REP	#$30
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_3f5c7d40_028c_429d_89ca_3a1635a45a11
  __CMP_NO_3f5c7d40_028c_429d_89ca_3a1635a45a11:
  REP	#$30
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  __CMP_END_3f5c7d40_028c_429d_89ca_3a1635a45a11:
  REP	#$20
  LDA	__@scratchBase + 0
  SEP	#$30
  ORA	__@scratchBase + 2
  BNE	:+
  JMP	__ITER__END__dfefb7a8_94e4_4c9f_8c61_bc2beebef6da
  :
    .dbg	line, "Example//SNES\Graphics\oam.c", 14
    SEP	#$30
    LDA	clearOAMBuffers@i + 0
    STA	__@specSubX + 0
    LDA	#$04
    STA	__@specSubY + 0
    JSL	__multiplier@1@1
    REP	#$30
    LDA	__@callResult + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	#$00
    STA	__@pointerBase + 2
    REP	#$31
    LDA	#.loWord(lowOAMBuffer)
    ADC	__@pointerBase + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	#.bankByte(lowOAMBuffer)
    ADC	__@pointerBase + 2
    STA	__@pointerBase + 2
    LDA	#$00
    LDY	#$00
    STA	[__@pointerBase],y
    .dbg	line, "Example//SNES\Graphics\oam.c", 15
    LDA	clearOAMBuffers@i + 0
    STA	__@specSubX + 0
    LDA	#$04
    STA	__@specSubY + 0
    JSL	__multiplier@1@1
    REP	#$30
    LDA	__@callResult + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	#$00
    STA	__@pointerBase + 2
    REP	#$31
    LDA	#.loWord(lowOAMBuffer)
    ADC	__@pointerBase + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	#.bankByte(lowOAMBuffer)
    ADC	__@pointerBase + 2
    STA	__@pointerBase + 2
    LDA	#$00
    LDY	#$01
    STA	[__@pointerBase],y
    .dbg	line, "Example//SNES\Graphics\oam.c", 16
    LDA	clearOAMBuffers@i + 0
    STA	__@specSubX + 0
    LDA	#$04
    STA	__@specSubY + 0
    JSL	__multiplier@1@1
    REP	#$30
    LDA	__@callResult + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	#$00
    STA	__@pointerBase + 2
    REP	#$31
    LDA	#.loWord(lowOAMBuffer)
    ADC	__@pointerBase + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	#.bankByte(lowOAMBuffer)
    ADC	__@pointerBase + 2
    STA	__@pointerBase + 2
    LDA	#$00
    LDY	#$02
    STA	[__@pointerBase],y
    .dbg	line, "Example//SNES\Graphics\oam.c", 17
    LDA	clearOAMBuffers@i + 0
    STA	__@specSubX + 0
    LDA	#$04
    STA	__@specSubY + 0
    JSL	__multiplier@1@1
    REP	#$30
    LDA	__@callResult + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	#$00
    STA	__@pointerBase + 2
    REP	#$31
    LDA	#.loWord(lowOAMBuffer)
    ADC	__@pointerBase + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	#.bankByte(lowOAMBuffer)
    ADC	__@pointerBase + 2
    STA	__@pointerBase + 2
    LDA	#$00
    LDY	#$03
    STA	[__@pointerBase],y
  __ITER__ITER__dfefb7a8_94e4_4c9f_8c61_bc2beebef6da:
  CLC
  SEP	#$30
  LDA	clearOAMBuffers@i + 0
  ADC	#$01
  STA	clearOAMBuffers@i + 0
  JMP	__ITER__START__dfefb7a8_94e4_4c9f_8c61_bc2beebef6da
  __ITER__END__dfefb7a8_94e4_4c9f_8c61_bc2beebef6da:
  .dbg	line, "Example//SNES\Graphics\oam.c", 19
  SEP	#$30
  LDA	#$00
  STA	clearOAMBuffers@i + 0
  __ITER__START__bb6460fd_022e_4245_8cd3_026e199521f9:
    CLC
  SEP	#$30
  LDA	clearOAMBuffers@i + 0
  CMP	#$20
  BCC	:+
  BRA	:++
  :JMP	__CMP_YES_cb6bdbec_f6a6_468b_a4ca_1b8b351d21b8
  :BEQ	:+
  JMP	__CMP_NO_cb6bdbec_f6a6_468b_a4ca_1b8b351d21b8
  :
  SEP	#$30
  JMP	__CMP_NO_cb6bdbec_f6a6_468b_a4ca_1b8b351d21b8
  __CMP_YES_cb6bdbec_f6a6_468b_a4ca_1b8b351d21b8:
  REP	#$30
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_cb6bdbec_f6a6_468b_a4ca_1b8b351d21b8
  __CMP_NO_cb6bdbec_f6a6_468b_a4ca_1b8b351d21b8:
  REP	#$30
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  __CMP_END_cb6bdbec_f6a6_468b_a4ca_1b8b351d21b8:
  REP	#$20
  LDA	__@scratchBase + 0
  SEP	#$30
  ORA	__@scratchBase + 2
  BNE	:+
  JMP	__ITER__END__bb6460fd_022e_4245_8cd3_026e199521f9
  :
    .dbg	line, "Example//SNES\Graphics\oam.c", 21
    CLC
    SEP	#$20
    LDA	clearOAMBuffers@i + 0
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    REP	#$30
    SEP	#$20
    LDA	#.loByte(highOAMBuffer)
    ADC	clearOAMBuffers@i + 0
    STA	__@pointerBase + 0
    LDA	#.hiByte(highOAMBuffer)
    ADC	__@signExtend
    STA	__@pointerBase + 1
    REP	#$20
    SEP	#$30
    LDA	#.bankByte(highOAMBuffer)
    ADC	__@signExtend
    STA	__@pointerBase + 2
    LDA	#$55
    LDY	#$00
    STA	[__@pointerBase],y
  __ITER__ITER__bb6460fd_022e_4245_8cd3_026e199521f9:
  CLC
  SEP	#$30
  LDA	clearOAMBuffers@i + 0
  ADC	#$01
  STA	clearOAMBuffers@i + 0
  JMP	__ITER__START__bb6460fd_022e_4245_8cd3_026e199521f9
  __ITER__END__bb6460fd_022e_4245_8cd3_026e199521f9:
__clearOAMBuffers_END: RTL
updateOAM:	; @func void()
  .dbg	line, "Example//SNES\Graphics\oam.c", 54
  SEP	#$30
  LDA	#$02
  STA	DMACHN + 0
  .dbg	line, "Example//SNES\Graphics\oam.c", 55
  LDA	#$00
  STA	OAMADDL + 0
  .dbg	line, "Example//SNES\Graphics\oam.c", 56
  LDA	#$00
  STA	OAMADDH + 0
  .dbg	line, "Example//SNES\Graphics\oam.c", 57
  LDA	#.loByte(OAMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example//SNES\Graphics\oam.c", 58
  REP	#$30
  LDA	#.loWord(lowOAMBuffer)
  STA	DMACHN + 2
  SEP	#$30
  LDA	#.bankByte(lowOAMBuffer)
  STA	DMACHN + 4
  .dbg	line, "Example//SNES\Graphics\oam.c", 59
  REP	#$30
  LDA	#$0200
  STA	DMACHN + 5
  SEP	#$30
  LDA	#$00
  STA	DMACHN + 7
  .dbg	line, "Example//SNES\Graphics\oam.c", 60
  LDA	#$01
  STA	MDMAEN + 0
  .dbg	line, "Example//SNES\Graphics\oam.c", 62
  REP	#$30
  LDA	#.loWord(highOAMBuffer)
  STA	DMACHN + 2
  SEP	#$30
  LDA	#.bankByte(highOAMBuffer)
  STA	DMACHN + 4
  .dbg	line, "Example//SNES\Graphics\oam.c", 63
  LDA	#$20
  STA	DMACHN + 5
  REP	#$30
  LDA	#$0000
  STA	DMACHN + 6
  .dbg	line, "Example//SNES\Graphics\oam.c", 64
  SEP	#$30
  LDA	#$01
  STA	MDMAEN + 0
__updateOAM_END: RTL
handleNMI:	; @func void()
  .dbg	line, "Example//example.c", 17
  SEP	#$30
  LDA	#$00
  STA	isScanning + 0
__handleNMI_END: RTI
isColliding:	; @func _Bool(unsigned char, unsigned char, unsigned char, unsigned char, unsigned char, unsigned char, unsigned char, unsigned char)
  .dbg	line, "Example//example.c", 22
  CLC
  SEP	#$30
  LDA	isColliding@x2 + 0
  ADC	isColliding@w2 + 0
  STA	__@scratchBase + 3
  LDA	isColliding@x1 + 0
  CMP	__@scratchBase + 3
  BCC	:+
  BRA	:++
  :JMP	__CMP_NO_aa9dc14c_deee_4f98_841a_12b50a2501f1
  :BEQ	:+
  JMP	__CMP_YES_aa9dc14c_deee_4f98_841a_12b50a2501f1
  :
  SEP	#$30
  JMP	__CMP_YES_aa9dc14c_deee_4f98_841a_12b50a2501f1
  __CMP_YES_aa9dc14c_deee_4f98_841a_12b50a2501f1:
  REP	#$30
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_aa9dc14c_deee_4f98_841a_12b50a2501f1
  __CMP_NO_aa9dc14c_deee_4f98_841a_12b50a2501f1:
  REP	#$30
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  __CMP_END_aa9dc14c_deee_4f98_841a_12b50a2501f1:
  REP	#$20
  LDA	__@scratchBase + 0
  SEP	#$30
  ORA	__@scratchBase + 2
  BEQ	__IFNOT_de47035b_876d_4fe4_ac0e_e555fdd43350
    .dbg	line, "Example//example.c", 22
    LDA	#$00
    STA	__@callResult + 0
    JMP	__isColliding_END
  __IFNOT_de47035b_876d_4fe4_ac0e_e555fdd43350:
  .dbg	line, "Example//example.c", 23
  CLC
  SEP	#$30
  LDA	isColliding@x1 + 0
  ADC	isColliding@w1 + 0
  STA	__@scratchBase + 3
  LDA	__@scratchBase + 3
  CMP	isColliding@x2 + 0
  BCC	:+
  BRA	:++
  :JMP	__CMP_YES_8aa90def_2a46_4788_8b82_b5beacab3bdb
  :BEQ	:+
  JMP	__CMP_NO_8aa90def_2a46_4788_8b82_b5beacab3bdb
  :
  SEP	#$30
  JMP	__CMP_YES_8aa90def_2a46_4788_8b82_b5beacab3bdb
  __CMP_YES_8aa90def_2a46_4788_8b82_b5beacab3bdb:
  REP	#$30
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_8aa90def_2a46_4788_8b82_b5beacab3bdb
  __CMP_NO_8aa90def_2a46_4788_8b82_b5beacab3bdb:
  REP	#$30
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  __CMP_END_8aa90def_2a46_4788_8b82_b5beacab3bdb:
  REP	#$20
  LDA	__@scratchBase + 0
  SEP	#$30
  ORA	__@scratchBase + 2
  BEQ	__IFNOT_d4a436f9_c7d1_4325_9d46_3e5a01a1633b
    .dbg	line, "Example//example.c", 23
    LDA	#$00
    STA	__@callResult + 0
    JMP	__isColliding_END
  __IFNOT_d4a436f9_c7d1_4325_9d46_3e5a01a1633b:
  .dbg	line, "Example//example.c", 24
  CLC
  SEP	#$30
  LDA	isColliding@y2 + 0
  ADC	isColliding@h2 + 0
  STA	__@scratchBase + 3
  LDA	isColliding@y1 + 0
  CMP	__@scratchBase + 3
  BCC	:+
  BRA	:++
  :JMP	__CMP_NO_f2ce8f61_8bf3_4ea7_9be8_0c7199f1f82d
  :BEQ	:+
  JMP	__CMP_YES_f2ce8f61_8bf3_4ea7_9be8_0c7199f1f82d
  :
  SEP	#$30
  JMP	__CMP_YES_f2ce8f61_8bf3_4ea7_9be8_0c7199f1f82d
  __CMP_YES_f2ce8f61_8bf3_4ea7_9be8_0c7199f1f82d:
  REP	#$30
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_f2ce8f61_8bf3_4ea7_9be8_0c7199f1f82d
  __CMP_NO_f2ce8f61_8bf3_4ea7_9be8_0c7199f1f82d:
  REP	#$30
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  __CMP_END_f2ce8f61_8bf3_4ea7_9be8_0c7199f1f82d:
  REP	#$20
  LDA	__@scratchBase + 0
  SEP	#$30
  ORA	__@scratchBase + 2
  BEQ	__IFNOT_8d1ea2a4_64a0_428d_8851_81d46c95c4c6
    .dbg	line, "Example//example.c", 24
    LDA	#$00
    STA	__@callResult + 0
    JMP	__isColliding_END
  __IFNOT_8d1ea2a4_64a0_428d_8851_81d46c95c4c6:
  .dbg	line, "Example//example.c", 25
  CLC
  SEP	#$30
  LDA	isColliding@y1 + 0
  ADC	isColliding@h1 + 0
  STA	__@scratchBase + 3
  LDA	__@scratchBase + 3
  CMP	isColliding@y2 + 0
  BCC	:+
  BRA	:++
  :JMP	__CMP_YES_100c0905_84e4_419d_8e76_c2d9a4b72bee
  :BEQ	:+
  JMP	__CMP_NO_100c0905_84e4_419d_8e76_c2d9a4b72bee
  :
  SEP	#$30
  JMP	__CMP_YES_100c0905_84e4_419d_8e76_c2d9a4b72bee
  __CMP_YES_100c0905_84e4_419d_8e76_c2d9a4b72bee:
  REP	#$30
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_100c0905_84e4_419d_8e76_c2d9a4b72bee
  __CMP_NO_100c0905_84e4_419d_8e76_c2d9a4b72bee:
  REP	#$30
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  __CMP_END_100c0905_84e4_419d_8e76_c2d9a4b72bee:
  REP	#$20
  LDA	__@scratchBase + 0
  SEP	#$30
  ORA	__@scratchBase + 2
  BEQ	__IFNOT_423ff755_71d1_4c07_bd1a_cff4e7d78c8a
    .dbg	line, "Example//example.c", 25
    LDA	#$00
    STA	__@callResult + 0
    JMP	__isColliding_END
  __IFNOT_423ff755_71d1_4c07_bd1a_cff4e7d78c8a:
  .dbg	line, "Example//example.c", 26
  SEP	#$30
  LDA	#$01
  STA	__@callResult + 0
  JMP	__isColliding_END
__isColliding_END: RTL
uiToTiles:	; @func void((unsigned short)*, unsigned char, unsigned int, unsigned short)
  .dbg	line, "Example//example.c", 32
  .dbg	line, "Example//example.c", 33
  SEP	#$31
  LDA	uiToTiles@n + 0
  SBC	#$01
  STA	uiToTiles@i + 0
  PHA
  LDA	#$00
  STA	uiToTiles@i + 1
  PLA
  __ITER__START__ee32dbbe_6573_4898_9363_28c7e1b839b0:
    CLC
  SEP	#$30
  LDA	uiToTiles@i + 1
  EOR	#$80
  CMP	#$80
  BCC	:+
  BRA	:++
  :JMP	__CMP_NO_851620bd_ca2f_4846_adab_ea02138d69e4
  :BEQ	:+
  JMP	__CMP_YES_851620bd_ca2f_4846_adab_ea02138d69e4
  :
  SEP	#$30
  LDA	uiToTiles@i + 0
  CMP	#$00
  BCC	:+
  BRA	:++
  :JMP	__CMP_NO_851620bd_ca2f_4846_adab_ea02138d69e4
  :BEQ	:+
  JMP	__CMP_YES_851620bd_ca2f_4846_adab_ea02138d69e4
  :
  SEP	#$30
  JMP	__CMP_YES_851620bd_ca2f_4846_adab_ea02138d69e4
  __CMP_YES_851620bd_ca2f_4846_adab_ea02138d69e4:
  REP	#$30
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_851620bd_ca2f_4846_adab_ea02138d69e4
  __CMP_NO_851620bd_ca2f_4846_adab_ea02138d69e4:
  REP	#$30
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$30
  LDA	#$00
  STA	__@scratchBase + 2
  __CMP_END_851620bd_ca2f_4846_adab_ea02138d69e4:
  REP	#$20
  LDA	__@scratchBase + 0
  SEP	#$30
  ORA	__@scratchBase + 2
  BNE	:+
  JMP	__ITER__END__ee32dbbe_6573_4898_9363_28c7e1b839b0
  :
    .dbg	line, "Example//example.c", 35
    REP	#$30
    LDA	uiToTiles@value + 0
    STA	__@specSubX + 0
    SEP	#$30
    LDA	uiToTiles@value + 2
    STA	__@specSubX + 2
    LDA	#$0a
    STA	__@specSubY + 0
    JSL	__modulator@3@1
    SEP	#$30
    LDA	__@callResult + 0
    STA	uiToTiles@x + 0
    LDA	#$00
    STA	uiToTiles@x + 1
    .dbg	line, "Example//example.c", 36
    REP	#$30
    LDA	uiToTiles@value + 0
    STA	__@specSubX + 0
    SEP	#$30
    LDA	uiToTiles@value + 2
    STA	__@specSubX + 2
    LDA	#$0a
    STA	__@specSubY + 0
    JSL	__divider@3@1
    REP	#$30
    LDA	__@callResult + 0
    STA	uiToTiles@value + 0
    SEP	#$30
    LDA	__@callResult + 2
    STA	uiToTiles@value + 2
    .dbg	line, "Example//example.c", 37
    LDA	uiToTiles@i + 1
    BPL	:+
    LDA	#$FF
    BRA	:++
    :
    LDA	#$00
    :
    STA	__@signExtend
    SEP	#$30
    LDA	#$00
    STA	__@scratchBase + 5
    REP	#$30
    LDA	uiToTiles@i + 0
    STA	__@scratchBase + 3
    LDA	__@scratchBase + 3
    ASL
    STA	__@scratchBase + 3
    SEP	#$30
    LDA	__@scratchBase + 5
    ROL
    STA	__@scratchBase + 5
    REP	#$31
    LDA	uiToTiles@c + 0
    ADC	__@scratchBase + 3
    STA	__@scratchBase + 0
    SEP	#$30
    LDA	uiToTiles@c + 2
    ADC	__@scratchBase + 5
    STA	__@scratchBase + 2
    REP	#$30
    LDA	__@scratchBase + 0
    STA	__@pointerBase + 0
    SEP	#$30
    LDA	__@scratchBase + 2
    STA	__@pointerBase + 2
    REP	#$30
    LDA	uiToTiles@x + 0
    ADC	uiToTiles@zeroTile + 0
    LDY	#$0000
    STA	[__@pointerBase],y
  __ITER__ITER__ee32dbbe_6573_4898_9363_28c7e1b839b0:
  SEC
  REP	#$30
  LDA	uiToTiles@i + 0
  SBC	#$0001
  STA	uiToTiles@i + 0
  JMP	__ITER__START__ee32dbbe_6573_4898_9363_28c7e1b839b0
  __ITER__END__ee32dbbe_6573_4898_9363_28c7e1b839b0:
__uiToTiles_END: RTL
main:	; @func void()
  .dbg	line, "Example//example.c", 43
  JSL	initSNES
  .dbg	line, "Example//example.c", 44
  REP	#$30
  LDA	#$0400
  STA	main@tilemapAddress + 0
  .dbg	line, "Example//example.c", 45
  LDA	#$0000
  STA	main@tilesetAddress + 0
  .dbg	line, "Example//example.c", 47
  SEP	#$30
  LDA	#$01
  STA	setBackgroundMode@mode + 0
  LDA	#$00
  STA	setBackgroundMode@BG3Priority + 0
  LDA	#$00
  STA	setBackgroundMode@largeTiles + 0
  JSL	setBackgroundMode
  .dbg	line, "Example//example.c", 48
  SEP	#$30
  LDA	#$00
  STA	setBackgroundAddress@backgroundNo + 0
  REP	#$30
  LDA	main@tilemapAddress + 0
  STA	setBackgroundAddress@wordAddress + 0
  SEP	#$30
  LDA	#$00
  STA	setBackgroundAddress@tilemapCount + 0
  JSL	setBackgroundAddress
  .dbg	line, "Example//example.c", 49
  SEP	#$30
  LDA	#$00
  STA	setBackgroundTileset@backgroundNo + 0
  REP	#$30
  LDA	main@tilesetAddress + 0
  STA	setBackgroundTileset@wordAddress + 0
  JSL	setBackgroundTileset
  .dbg	line, "Example//example.c", 51
  REP	#$30
  LDA	#.loWord(tilemap)
  STA	copyTilemap@tilemap + 0
  SEP	#$30
  LDA	#.bankByte(tilemap)
  STA	copyTilemap@tilemap + 2
  REP	#$30
  LDA	main@tilemapAddress + 0
  STA	copyTilemap@destination + 0
  JSL	copyTilemap
  .dbg	line, "Example//example.c", 52
  REP	#$30
  LDA	#.loWord(tile)
  STA	copyTiles4BPP@tiles + 0
  SEP	#$30
  LDA	#.bankByte(tile)
  STA	copyTiles4BPP@tiles + 2
  REP	#$30
  LDA	main@tilesetAddress + 0
  STA	copyTiles4BPP@destination + 0
  SEP	#$30
  LDA	#$2f
  STA	copyTiles4BPP@nTiles + 0
  LDA	#$00
  STA	copyTiles4BPP@nTiles + 1
  JSL	copyTiles4BPP
  .dbg	line, "Example//example.c", 53
  REP	#$30
  LDA	#.loWord(palette)
  STA	copyPalette@palette + 0
  SEP	#$30
  LDA	#.bankByte(palette)
  STA	copyPalette@palette + 2
  LDA	#$00
  STA	copyPalette@destination + 0
  LDA	#$20
  STA	copyPalette@paletteSize + 0
  JSL	copyPalette
  .dbg	line, "Example//example.c", 54
  REP	#$30
  LDA	#.loWord(palette)
  STA	copyPalette@palette + 0
  SEP	#$30
  LDA	#.bankByte(palette)
  STA	copyPalette@palette + 2
  LDA	#$80
  STA	copyPalette@destination + 0
  LDA	#$20
  STA	copyPalette@paletteSize + 0
  JSL	copyPalette
  .dbg	line, "Example//example.c", 56
  JSL	clearOAMBuffers
  .dbg	line, "Example//example.c", 58
  SEP	#$30
  LDA	#$18
  STA	lowOAMBuffer + 0
  .dbg	line, "Example//example.c", 59
  LDA	#$80
  STA	lowOAMBuffer + 1
  .dbg	line, "Example//example.c", 60
  LDA	#$1b
  STA	lowOAMBuffer + 2
  .dbg	line, "Example//example.c", 61
  LDA	#$30
  STA	lowOAMBuffer + 3
  .dbg	line, "Example//example.c", 62
  LDA	#$00
  STA	setHighOAMProperties@i + 0
  LDA	#$00
  STA	setHighOAMProperties@xShift + 0
  LDA	#$01
  STA	setHighOAMProperties@largeSprite + 0
  JSL	setHighOAMProperties
  .dbg	line, "Example//example.c", 64
  SEP	#$30
  LDA	#$d8
  STA	lowOAMBuffer + 4
  .dbg	line, "Example//example.c", 65
  LDA	#$80
  STA	lowOAMBuffer + 5
  .dbg	line, "Example//example.c", 66
  LDA	#$1b
  STA	lowOAMBuffer + 6
  .dbg	line, "Example//example.c", 67
  LDA	#$70
  STA	lowOAMBuffer + 7
  .dbg	line, "Example//example.c", 68
  LDA	#$01
  STA	setHighOAMProperties@i + 0
  LDA	#$00
  STA	setHighOAMProperties@xShift + 0
  LDA	#$01
  STA	setHighOAMProperties@largeSprite + 0
  JSL	setHighOAMProperties
  .dbg	line, "Example//example.c", 70
  SEP	#$30
  LDA	#$80
  STA	lowOAMBuffer + 8
  .dbg	line, "Example//example.c", 71
  LDA	#$80
  STA	lowOAMBuffer + 9
  .dbg	line, "Example//example.c", 72
  LDA	#$00
  STA	lowOAMBuffer + 10
  .dbg	line, "Example//example.c", 73
  LDA	#$30
  STA	lowOAMBuffer + 11
  .dbg	line, "Example//example.c", 74
  LDA	#$02
  STA	setHighOAMProperties@i + 0
  LDA	#$00
  STA	setHighOAMProperties@xShift + 0
  LDA	#$00
  STA	setHighOAMProperties@largeSprite + 0
  JSL	setHighOAMProperties
  .dbg	line, "Example//example.c", 76
  JSL	updateOAM
  .dbg	line, "Example//example.c", 77
  SEP	#$30
  LDA	#$11
  STA	TM + 0
  .dbg	line, "Example//example.c", 79
  REP	#$30
  LDA	#$0000
  STA	main@scoreP1 + 0
  SEP	#$30
  LDA	#$00
  STA	main@scoreP1 + 2
  REP	#$30
  LDA	#$0000
  STA	main@scoreP2 + 0
  SEP	#$30
  LDA	#$00
  STA	main@scoreP2 + 2
  .dbg	line, "Example//example.c", 80
  .dbg	line, "Example//example.c", 81
  REP	#$30
  LDA	#.loWord(main@scoreP1Tiles)
  STA	uiToTiles@c + 0
  SEP	#$30
  LDA	#.bankByte(main@scoreP1Tiles)
  STA	uiToTiles@c + 2
  LDA	#$04
  STA	uiToTiles@n + 0
  REP	#$30
  LDA	main@scoreP1 + 0
  STA	uiToTiles@value + 0
  SEP	#$30
  LDA	main@scoreP1 + 2
  STA	uiToTiles@value + 2
  LDA	#$1e
  STA	uiToTiles@zeroTile + 0
  LDA	#$00
  STA	uiToTiles@zeroTile + 1
  JSL	uiToTiles
  .dbg	line, "Example//example.c", 82
  REP	#$30
  LDA	#.loWord(main@scoreP2Tiles)
  STA	uiToTiles@c + 0
  SEP	#$30
  LDA	#.bankByte(main@scoreP2Tiles)
  STA	uiToTiles@c + 2
  LDA	#$04
  STA	uiToTiles@n + 0
  REP	#$30
  LDA	main@scoreP2 + 0
  STA	uiToTiles@value + 0
  SEP	#$30
  LDA	main@scoreP2 + 2
  STA	uiToTiles@value + 2
  LDA	#$1e
  STA	uiToTiles@zeroTile + 0
  LDA	#$00
  STA	uiToTiles@zeroTile + 1
  JSL	uiToTiles
  .dbg	line, "Example//example.c", 83
  REP	#$30
  LDA	#.loWord(main@scoreP1Tiles)
  STA	copyTileRegion@tilemap + 0
  SEP	#$30
  LDA	#.bankByte(main@scoreP1Tiles)
  STA	copyTileRegion@tilemap + 2
  REP	#$31
  LDA	main@tilemapAddress + 0
  ADC	#$0204
  STA	copyTileRegion@destination + 0
  SEP	#$30
  LDA	#$04
  STA	copyTileRegion@n + 0
  LDA	#$00
  STA	copyTileRegion@n + 1
  JSL	copyTileRegion
  .dbg	line, "Example//example.c", 84
  REP	#$30
  LDA	#.loWord(main@scoreP2Tiles)
  STA	copyTileRegion@tilemap + 0
  SEP	#$30
  LDA	#.bankByte(main@scoreP2Tiles)
  STA	copyTileRegion@tilemap + 2
  REP	#$31
  LDA	main@tilemapAddress + 0
  ADC	#$0218
  STA	copyTileRegion@destination + 0
  SEP	#$30
  LDA	#$04
  STA	copyTileRegion@n + 0
  LDA	#$00
  STA	copyTileRegion@n + 1
  JSL	copyTileRegion
  .dbg	line, "Example//example.c", 88
  SEP	#$30
  LDA	#$0f
  STA	INIDISP + 0
  .dbg	line, "Example//example.c", 89
  LDA	#$81
  STA	NMITIMEN + 0
  .dbg	line, "Example//example.c", 90
  LDA	#$01
  STA	isScanning + 0
  .dbg	line, "Example//example.c", 92
  LDA	#$01
  STA	main@goRight + 0
  LDA	#$01
  STA	main@goDown + 0
  .dbg	line, "Example//example.c", 93
  LDA	#$00
  STA	main@refreshScores + 0
  .dbg	line, "Example//example.c", 95
  __ITER__START__135bf97b_6820_49c3_91c6_2e394967b6e3:
    .dbg	line, "Example//example.c", 97
    SEP	#$20
    LDA	main@refreshScores + 0
    BNE	:+
    JMP	__IFNOT_bde6d85c_e765_4a6f_b9cd_7eb560d8fca4
    :
      .dbg	line, "Example//example.c", 98
      .dbg	line, "Example//example.c", 99
      REP	#$30
      LDA	#.loWord(main@scoreP1Tiles)
      STA	copyTileRegion@tilemap + 0
      SEP	#$30
      LDA	#.bankByte(main@scoreP1Tiles)
      STA	copyTileRegion@tilemap + 2
      REP	#$31
      LDA	main@tilemapAddress + 0
      ADC	#$0204
      STA	copyTileRegion@destination + 0
      SEP	#$30
      LDA	#$04
      STA	copyTileRegion@n + 0
      LDA	#$00
      STA	copyTileRegion@n + 1
      JSL	copyTileRegion
      .dbg	line, "Example//example.c", 100
      REP	#$30
      LDA	#.loWord(main@scoreP2Tiles)
      STA	copyTileRegion@tilemap + 0
      SEP	#$30
      LDA	#.bankByte(main@scoreP2Tiles)
      STA	copyTileRegion@tilemap + 2
      REP	#$31
      LDA	main@tilemapAddress + 0
      ADC	#$0218
      STA	copyTileRegion@destination + 0
      SEP	#$30
      LDA	#$04
      STA	copyTileRegion@n + 0
      LDA	#$00
      STA	copyTileRegion@n + 1
      JSL	copyTileRegion
      .dbg	line, "Example//example.c", 101
      SEP	#$30
      LDA	#$00
      STA	main@refreshScores + 0
    __IFNOT_bde6d85c_e765_4a6f_b9cd_7eb560d8fca4:
    .dbg	line, "Example//example.c", 104
    JSL	updateOAM
    .dbg	line, "Example//example.c", 105
    SEP	#$30
    LDA	#$01
    STA	isScanning + 0
    .dbg	line, "Example//example.c", 107
        CLC
    LDA	lowOAMBuffer + 1
    CMP	#$00
    BCC	:+
    BRA	:++
    :JMP	__CMP_NO_3c184cdf_9451_4bb6_9701_d14bb7ae56a1
    :BEQ	:+
    JMP	__CMP_YES_3c184cdf_9451_4bb6_9701_d14bb7ae56a1
    :
    SEP	#$30
    JMP	__CMP_NO_3c184cdf_9451_4bb6_9701_d14bb7ae56a1
    __CMP_YES_3c184cdf_9451_4bb6_9701_d14bb7ae56a1:
    REP	#$30
    LDA	#$0001
    STA	__@scratchBase + 3
    BRA	__CMP_END_3c184cdf_9451_4bb6_9701_d14bb7ae56a1
    __CMP_NO_3c184cdf_9451_4bb6_9701_d14bb7ae56a1:
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 3
    __CMP_END_3c184cdf_9451_4bb6_9701_d14bb7ae56a1:
    REP	#$30
    LDA	#$0800
    AND	JOYPAD + 0
    STA	__@scratchBase + 7
    LDX	#$01
    LDA	__@scratchBase + 3
    BNE	:+
    DEX
    BRA	:++
   :
    REP	#$30
    LDA	__@scratchBase + 7
    BNE	:+
    DEX
:   TXA
    SEP	#$20
    STA	__@scratchBase + 0
        REP	#$20
    LDA	__@scratchBase + 0
    SEP	#$30
    ORA	__@scratchBase + 2
    BEQ	__IFNOT_0ad4f3fc_5fe4_4c96_9ac9_9a3dcbb4b345
      .dbg	line, "Example//example.c", 108
      SEC
      LDA	lowOAMBuffer + 1
      SBC	#$01
      STA	lowOAMBuffer + 1
    JMP	__IFNOTELSE_0ad4f3fc_5fe4_4c96_9ac9_9a3dcbb4b345
    __IFNOT_0ad4f3fc_5fe4_4c96_9ac9_9a3dcbb4b345:
      .dbg	line, "Example//example.c", 109
            SEP	#$20
      LDA	#$00
      STA	__@signExtend
      CLC
      SEP	#$10
      LDA	__@signExtend
      EOR	#$80
      CMP	#$80
      BCC	:+
      BRA	:++
      :JMP	__CMP_YES_77c3e66c_2595_4a9a_acc1_d474f7005a94
      :BEQ	:+
      JMP	__CMP_NO_77c3e66c_2595_4a9a_acc1_d474f7005a94
      :
      SEP	#$30
      LDA	lowOAMBuffer + 1
      CMP	#$d0
      BCC	:+
      BRA	:++
      :JMP	__CMP_YES_77c3e66c_2595_4a9a_acc1_d474f7005a94
      :BEQ	:+
      JMP	__CMP_NO_77c3e66c_2595_4a9a_acc1_d474f7005a94
      :
      LDA	lowOAMBuffer + 1
      CMP	#$d0
      BCC	:+
      BRA	:++
      :JMP	__CMP_YES_77c3e66c_2595_4a9a_acc1_d474f7005a94
      :BEQ	:+
      JMP	__CMP_NO_77c3e66c_2595_4a9a_acc1_d474f7005a94
      :
      SEP	#$30
      JMP	__CMP_NO_77c3e66c_2595_4a9a_acc1_d474f7005a94
      __CMP_YES_77c3e66c_2595_4a9a_acc1_d474f7005a94:
      REP	#$30
      LDA	#$0001
      STA	__@scratchBase + 3
      BRA	__CMP_END_77c3e66c_2595_4a9a_acc1_d474f7005a94
      __CMP_NO_77c3e66c_2595_4a9a_acc1_d474f7005a94:
      REP	#$30
      LDA	#$0000
      STA	__@scratchBase + 3
      __CMP_END_77c3e66c_2595_4a9a_acc1_d474f7005a94:
      REP	#$30
      LDA	#$0400
      AND	JOYPAD + 0
      STA	__@scratchBase + 7
      LDX	#$01
      LDA	__@scratchBase + 3
      BNE	:+
      DEX
      BRA	:++
     :
      REP	#$30
      LDA	__@scratchBase + 7
      BNE	:+
      DEX
:     TXA
      SEP	#$20
      STA	__@scratchBase + 0
            REP	#$20
      LDA	__@scratchBase + 0
      SEP	#$30
      ORA	__@scratchBase + 2
      BEQ	__IFNOT_27504a67_f1ae_45ed_85b6_6d4296bb2b95
        .dbg	line, "Example//example.c", 110
        CLC
        LDA	lowOAMBuffer + 1
        ADC	#$01
        STA	lowOAMBuffer + 1
      __IFNOT_27504a67_f1ae_45ed_85b6_6d4296bb2b95:
    __IFNOTELSE_0ad4f3fc_5fe4_4c96_9ac9_9a3dcbb4b345:
    .dbg	line, "Example//example.c", 112
        CLC
    SEP	#$30
    LDA	lowOAMBuffer + 5
    CMP	#$00
    BCC	:+
    BRA	:++
    :JMP	__CMP_NO_93b3dcde_db19_4955_a463_2f82374cbfc5
    :BEQ	:+
    JMP	__CMP_YES_93b3dcde_db19_4955_a463_2f82374cbfc5
    :
    SEP	#$30
    JMP	__CMP_NO_93b3dcde_db19_4955_a463_2f82374cbfc5
    __CMP_YES_93b3dcde_db19_4955_a463_2f82374cbfc5:
    REP	#$30
    LDA	#$0001
    STA	__@scratchBase + 3
    BRA	__CMP_END_93b3dcde_db19_4955_a463_2f82374cbfc5
    __CMP_NO_93b3dcde_db19_4955_a463_2f82374cbfc5:
    REP	#$30
    LDA	#$0000
    STA	__@scratchBase + 3
    __CMP_END_93b3dcde_db19_4955_a463_2f82374cbfc5:
    REP	#$30
    LDA	#$0800
    AND	JOYPAD + 2
    STA	__@scratchBase + 7
    LDX	#$01
    LDA	__@scratchBase + 3
    BNE	:+
    DEX
    BRA	:++
   :
    REP	#$30
    LDA	__@scratchBase + 7
    BNE	:+
    DEX
:   TXA
    SEP	#$20
    STA	__@scratchBase + 0
        REP	#$20
    LDA	__@scratchBase + 0
    SEP	#$30
    ORA	__@scratchBase + 2
    BEQ	__IFNOT_e19cb541_a369_417a_b2fa_69b5631c39c0
      .dbg	line, "Example//example.c", 113
      SEC
      LDA	lowOAMBuffer + 5
      SBC	#$01
      STA	lowOAMBuffer + 5
    JMP	__IFNOTELSE_e19cb541_a369_417a_b2fa_69b5631c39c0
    __IFNOT_e19cb541_a369_417a_b2fa_69b5631c39c0:
      .dbg	line, "Example//example.c", 114
            SEP	#$20
      LDA	#$00
      STA	__@signExtend
      CLC
      SEP	#$10
      LDA	__@signExtend
      EOR	#$80
      CMP	#$80
      BCC	:+
      BRA	:++
      :JMP	__CMP_YES_1df651fc_526e_42a1_acee_3505be76e59e
      :BEQ	:+
      JMP	__CMP_NO_1df651fc_526e_42a1_acee_3505be76e59e
      :
      SEP	#$30
      LDA	lowOAMBuffer + 5
      CMP	#$d0
      BCC	:+
      BRA	:++
      :JMP	__CMP_YES_1df651fc_526e_42a1_acee_3505be76e59e
      :BEQ	:+
      JMP	__CMP_NO_1df651fc_526e_42a1_acee_3505be76e59e
      :
      LDA	lowOAMBuffer + 5
      CMP	#$d0
      BCC	:+
      BRA	:++
      :JMP	__CMP_YES_1df651fc_526e_42a1_acee_3505be76e59e
      :BEQ	:+
      JMP	__CMP_NO_1df651fc_526e_42a1_acee_3505be76e59e
      :
      SEP	#$30
      JMP	__CMP_NO_1df651fc_526e_42a1_acee_3505be76e59e
      __CMP_YES_1df651fc_526e_42a1_acee_3505be76e59e:
      REP	#$30
      LDA	#$0001
      STA	__@scratchBase + 3
      BRA	__CMP_END_1df651fc_526e_42a1_acee_3505be76e59e
      __CMP_NO_1df651fc_526e_42a1_acee_3505be76e59e:
      REP	#$30
      LDA	#$0000
      STA	__@scratchBase + 3
      __CMP_END_1df651fc_526e_42a1_acee_3505be76e59e:
      REP	#$30
      LDA	#$0400
      AND	JOYPAD + 2
      STA	__@scratchBase + 7
      LDX	#$01
      LDA	__@scratchBase + 3
      BNE	:+
      DEX
      BRA	:++
     :
      REP	#$30
      LDA	__@scratchBase + 7
      BNE	:+
      DEX
:     TXA
      SEP	#$20
      STA	__@scratchBase + 0
            REP	#$20
      LDA	__@scratchBase + 0
      SEP	#$30
      ORA	__@scratchBase + 2
      BEQ	__IFNOT_86cd29b5_27e5_4d78_92e6_9f77d41d9d3c
        .dbg	line, "Example//example.c", 115
        CLC
        LDA	lowOAMBuffer + 5
        ADC	#$01
        STA	lowOAMBuffer + 5
      __IFNOT_86cd29b5_27e5_4d78_92e6_9f77d41d9d3c:
    __IFNOTELSE_e19cb541_a369_417a_b2fa_69b5631c39c0:
    .dbg	line, "Example//example.c", 117
    SEP	#$20
    LDA	main@goRight + 0
    BNE	:+
    JMP	__condSkipd04b02e0_4d68_4c05_885e_c1a19a6f6f52
    :
    SEP	#$30
    LDA	#$01
    STA	__@scratchBase + 0
    JMP	__condEnd77f611d8_44bb_4132_a3f6_0edb32a613bc
    __condSkipd04b02e0_4d68_4c05_885e_c1a19a6f6f52:
    SEP	#$30
    LDA	#$ff
    STA	__@scratchBase + 0
    __condEnd77f611d8_44bb_4132_a3f6_0edb32a613bc:
    CLC
    SEP	#$30
    LDA	lowOAMBuffer + 8
    ADC	__@scratchBase + 0
    STA	lowOAMBuffer + 8
    .dbg	line, "Example//example.c", 118
    LDA	main@goDown + 0
    BNE	:+
    JMP	__condSkip35b3e5e2_2b9e_4dea_a054_801063df4b79
    :
    SEP	#$30
    LDA	#$01
    STA	__@scratchBase + 0
    JMP	__condEnd0f036800_419c_4926_8d24_531a14821522
    __condSkip35b3e5e2_2b9e_4dea_a054_801063df4b79:
    SEP	#$30
    LDA	#$ff
    STA	__@scratchBase + 0
    __condEnd0f036800_419c_4926_8d24_531a14821522:
    CLC
    SEP	#$30
    LDA	lowOAMBuffer + 9
    ADC	__@scratchBase + 0
    STA	lowOAMBuffer + 9
    .dbg	line, "Example//example.c", 120
    LDX	#$00
    LDA	#$00
    CMP	lowOAMBuffer + 9
    BNE	:+
    INX
:   TXA
    SEP	#$20
    STA	__@scratchBase + 0
    LDA	__@scratchBase + 0
    BEQ	__IFNOT_6b474179_b9e5_4320_8979_79936111f80a
      .dbg	line, "Example//example.c", 121
      .dbg	line, "Example//example.c", 122
      SEP	#$10
      LDA	#$01
      STA	main@goDown + 0
      .dbg	line, "Example//example.c", 123
      LDA	#$01
      STA	lowOAMBuffer + 9
    JMP	__IFNOTELSE_6b474179_b9e5_4320_8979_79936111f80a
    __IFNOT_6b474179_b9e5_4320_8979_79936111f80a:
      .dbg	line, "Example//example.c", 125
            SEP	#$20
      LDA	#$00
      STA	__@signExtend
      CLC
      SEP	#$10
      LDA	__@signExtend
      EOR	#$80
      CMP	#$80
      BCC	:+
      BRA	:++
      :JMP	__CMP_NO_8dfe3ea9_1906_4b98_8215_153baa670e91
      :BEQ	:+
      JMP	__CMP_YES_8dfe3ea9_1906_4b98_8215_153baa670e91
      :
      SEP	#$30
      LDA	lowOAMBuffer + 9
      CMP	#$d8
      BCC	:+
      BRA	:++
      :JMP	__CMP_NO_8dfe3ea9_1906_4b98_8215_153baa670e91
      :BEQ	:+
      JMP	__CMP_YES_8dfe3ea9_1906_4b98_8215_153baa670e91
      :
      LDA	lowOAMBuffer + 9
      CMP	#$d8
      BCC	:+
      BRA	:++
      :JMP	__CMP_NO_8dfe3ea9_1906_4b98_8215_153baa670e91
      :BEQ	:+
      JMP	__CMP_YES_8dfe3ea9_1906_4b98_8215_153baa670e91
      :
      SEP	#$30
      JMP	__CMP_NO_8dfe3ea9_1906_4b98_8215_153baa670e91
      __CMP_YES_8dfe3ea9_1906_4b98_8215_153baa670e91:
      REP	#$30
      LDA	#$0001
      STA	__@scratchBase + 0
      SEP	#$30
      LDA	#$00
      STA	__@scratchBase + 2
      BRA	__CMP_END_8dfe3ea9_1906_4b98_8215_153baa670e91
      __CMP_NO_8dfe3ea9_1906_4b98_8215_153baa670e91:
      REP	#$30
      LDA	#$0000
      STA	__@scratchBase + 0
      SEP	#$30
      LDA	#$00
      STA	__@scratchBase + 2
      __CMP_END_8dfe3ea9_1906_4b98_8215_153baa670e91:
      REP	#$20
      LDA	__@scratchBase + 0
      SEP	#$30
      ORA	__@scratchBase + 2
      BEQ	__IFNOT_15949230_7c90_4d7f_88fb_59fe9e561f96
        .dbg	line, "Example//example.c", 126
        .dbg	line, "Example//example.c", 127
        LDA	#$00
        STA	main@goDown + 0
        .dbg	line, "Example//example.c", 128
        LDA	#$d8
        STA	lowOAMBuffer + 9
      __IFNOT_15949230_7c90_4d7f_88fb_59fe9e561f96:
    __IFNOTELSE_6b474179_b9e5_4320_8979_79936111f80a:
    .dbg	line, "Example//example.c", 130
    REP	#$30
    LDA	#.loWord(main@scoreP2Tiles)
    STA	uiToTiles@c + 0
    SEP	#$30
    LDA	#.bankByte(main@scoreP2Tiles)
    STA	uiToTiles@c + 2
    LDA	#$04
    STA	uiToTiles@n + 0
    REP	#$30
    LDA	main@scoreP2 + 0
    STA	uiToTiles@value + 0
    SEP	#$30
    LDA	main@scoreP2 + 2
    STA	uiToTiles@value + 2
    LDA	#$1e
    STA	uiToTiles@zeroTile + 0
    LDA	#$00
    STA	uiToTiles@zeroTile + 1
    JSL	uiToTiles
    .dbg	line, "Example//example.c", 131
    SEP	#$10
    LDX	#$00
    SEP	#$20
    LDA	#$00
    CMP	lowOAMBuffer + 8
    BNE	:+
    INX
:   TXA
    SEP	#$20
    STA	__@scratchBase + 0
    LDA	__@scratchBase + 0
    BNE	:+
    JMP	__IFNOT_56b2716b_4ce9_48d6_87f9_f9c8da49cee4
    :
      .dbg	line, "Example//example.c", 132
      .dbg	line, "Example//example.c", 133
      SEP	#$30
      LDA	#$80
      STA	lowOAMBuffer + 8
      .dbg	line, "Example//example.c", 134
      LDA	#$80
      STA	lowOAMBuffer + 9
      .dbg	line, "Example//example.c", 135
      LDA	#$01
      STA	main@goRight + 0
      .dbg	line, "Example//example.c", 136
      LDA	#$01
      STA	main@goDown + 0
      .dbg	line, "Example//example.c", 137
      REP	#$31
      SEP	#$20
      LDA	main@scoreP2 + 0
      ADC	#$01
      STA	main@scoreP2 + 0
      LDA	main@scoreP2 + 1
      ADC	#$00
      STA	main@scoreP2 + 1
      REP	#$20
      SEP	#$30
      LDA	main@scoreP2 + 2
      ADC	#$00
      STA	main@scoreP2 + 2
      .dbg	line, "Example//example.c", 138
      REP	#$30
      LDA	#.loWord(main@scoreP2Tiles)
      STA	uiToTiles@c + 0
      SEP	#$30
      LDA	#.bankByte(main@scoreP2Tiles)
      STA	uiToTiles@c + 2
      LDA	#$04
      STA	uiToTiles@n + 0
      REP	#$30
      LDA	main@scoreP2 + 0
      STA	uiToTiles@value + 0
      SEP	#$30
      LDA	main@scoreP2 + 2
      STA	uiToTiles@value + 2
      LDA	#$1e
      STA	uiToTiles@zeroTile + 0
      LDA	#$00
      STA	uiToTiles@zeroTile + 1
      JSL	uiToTiles
      .dbg	line, "Example//example.c", 139
      SEP	#$30
      LDA	#$01
      STA	main@refreshScores + 0
    JMP	__IFNOTELSE_56b2716b_4ce9_48d6_87f9_f9c8da49cee4
    __IFNOT_56b2716b_4ce9_48d6_87f9_f9c8da49cee4:
      .dbg	line, "Example//example.c", 141
            SEP	#$20
      LDA	#$00
      STA	__@signExtend
      CLC
      SEP	#$10
      LDA	__@signExtend
      EOR	#$80
      CMP	#$80
      BCC	:+
      BRA	:++
      :JMP	__CMP_NO_92b76ed8_d299_49eb_bfc6_7338222bc876
      :BEQ	:+
      JMP	__CMP_YES_92b76ed8_d299_49eb_bfc6_7338222bc876
      :
      SEP	#$30
      LDA	lowOAMBuffer + 8
      CMP	#$f8
      BCC	:+
      BRA	:++
      :JMP	__CMP_NO_92b76ed8_d299_49eb_bfc6_7338222bc876
      :BEQ	:+
      JMP	__CMP_YES_92b76ed8_d299_49eb_bfc6_7338222bc876
      :
      LDA	lowOAMBuffer + 8
      CMP	#$f8
      BCC	:+
      BRA	:++
      :JMP	__CMP_NO_92b76ed8_d299_49eb_bfc6_7338222bc876
      :BEQ	:+
      JMP	__CMP_YES_92b76ed8_d299_49eb_bfc6_7338222bc876
      :
      SEP	#$30
      JMP	__CMP_NO_92b76ed8_d299_49eb_bfc6_7338222bc876
      __CMP_YES_92b76ed8_d299_49eb_bfc6_7338222bc876:
      REP	#$30
      LDA	#$0001
      STA	__@scratchBase + 0
      SEP	#$30
      LDA	#$00
      STA	__@scratchBase + 2
      BRA	__CMP_END_92b76ed8_d299_49eb_bfc6_7338222bc876
      __CMP_NO_92b76ed8_d299_49eb_bfc6_7338222bc876:
      REP	#$30
      LDA	#$0000
      STA	__@scratchBase + 0
      SEP	#$30
      LDA	#$00
      STA	__@scratchBase + 2
      __CMP_END_92b76ed8_d299_49eb_bfc6_7338222bc876:
      REP	#$20
      LDA	__@scratchBase + 0
      SEP	#$30
      ORA	__@scratchBase + 2
      BNE	:+
      JMP	__IFNOT_1cca1753_0db6_4ef0_9057_235c110c57d0
      :
        .dbg	line, "Example//example.c", 142
        .dbg	line, "Example//example.c", 143
        SEP	#$30
        LDA	#$80
        STA	lowOAMBuffer + 8
        .dbg	line, "Example//example.c", 144
        LDA	#$80
        STA	lowOAMBuffer + 9
        .dbg	line, "Example//example.c", 145
        LDA	#$00
        STA	main@goRight + 0
        .dbg	line, "Example//example.c", 146
        LDA	#$01
        STA	main@goDown + 0
        .dbg	line, "Example//example.c", 147
        REP	#$31
        SEP	#$20
        LDA	main@scoreP1 + 0
        ADC	#$01
        STA	main@scoreP1 + 0
        LDA	main@scoreP1 + 1
        ADC	#$00
        STA	main@scoreP1 + 1
        REP	#$20
        SEP	#$30
        LDA	main@scoreP1 + 2
        ADC	#$00
        STA	main@scoreP1 + 2
        .dbg	line, "Example//example.c", 148
        REP	#$30
        LDA	#.loWord(main@scoreP1Tiles)
        STA	uiToTiles@c + 0
        SEP	#$30
        LDA	#.bankByte(main@scoreP1Tiles)
        STA	uiToTiles@c + 2
        LDA	#$04
        STA	uiToTiles@n + 0
        REP	#$30
        LDA	main@scoreP1 + 0
        STA	uiToTiles@value + 0
        SEP	#$30
        LDA	main@scoreP1 + 2
        STA	uiToTiles@value + 2
        LDA	#$1e
        STA	uiToTiles@zeroTile + 0
        LDA	#$00
        STA	uiToTiles@zeroTile + 1
        JSL	uiToTiles
        .dbg	line, "Example//example.c", 149
        SEP	#$30
        LDA	#$01
        STA	main@refreshScores + 0
      __IFNOT_1cca1753_0db6_4ef0_9057_235c110c57d0:
    __IFNOTELSE_56b2716b_4ce9_48d6_87f9_f9c8da49cee4:
    .dbg	line, "Example//example.c", 152
    SEP	#$30
    LDA	lowOAMBuffer + 0
    STA	isColliding@x1 + 0
    LDA	#$10
    STA	isColliding@w1 + 0
    LDA	lowOAMBuffer + 1
    STA	isColliding@y1 + 0
    LDA	#$10
    STA	isColliding@h1 + 0
    LDA	lowOAMBuffer + 8
    STA	isColliding@x2 + 0
    LDA	#$08
    STA	isColliding@w2 + 0
    LDA	lowOAMBuffer + 9
    STA	isColliding@y2 + 0
    LDA	#$08
    STA	isColliding@h2 + 0
    JSL	isColliding
    SEP	#$30
    LDA	__@callResult + 0
    STA	__@scratchBase + 0
    LDA	__@scratchBase + 0
    BEQ	__IFNOT_89db5ded_5466_4ab9_93fe_fcf29e628712
      .dbg	line, "Example//example.c", 153
      .dbg	line, "Example//example.c", 154
      CLC
      LDA	lowOAMBuffer + 0
      ADC	#$10
      STA	lowOAMBuffer + 8
      .dbg	line, "Example//example.c", 155
      LDA	#$01
      STA	main@goRight + 0
      .dbg	line, "Example//example.c", 156
      LDA	main@goDown + 0
      BEQ	:+
      SEP	#$30
      LDA	#$00
      STA	main@goDown + 0
      BRA	:++
      :
      SEP	#$30
      LDA	#$01
      STA	main@goDown + 0
      :
    JMP	__IFNOTELSE_89db5ded_5466_4ab9_93fe_fcf29e628712
    __IFNOT_89db5ded_5466_4ab9_93fe_fcf29e628712:
      .dbg	line, "Example//example.c", 158
      SEP	#$30
      LDA	lowOAMBuffer + 4
      STA	isColliding@x1 + 0
      LDA	#$10
      STA	isColliding@w1 + 0
      LDA	lowOAMBuffer + 5
      STA	isColliding@y1 + 0
      LDA	#$10
      STA	isColliding@h1 + 0
      LDA	lowOAMBuffer + 8
      STA	isColliding@x2 + 0
      LDA	#$08
      STA	isColliding@w2 + 0
      LDA	lowOAMBuffer + 9
      STA	isColliding@y2 + 0
      LDA	#$08
      STA	isColliding@h2 + 0
      JSL	isColliding
      SEP	#$30
      LDA	__@callResult + 0
      STA	__@scratchBase + 0
      LDA	__@scratchBase + 0
      BEQ	__IFNOT_dc369d37_0e66_45f1_a88f_0b8a30b2155f
        .dbg	line, "Example//example.c", 159
        .dbg	line, "Example//example.c", 160
        SEC
        LDA	lowOAMBuffer + 4
        SBC	#$08
        STA	lowOAMBuffer + 8
        .dbg	line, "Example//example.c", 161
        LDA	#$00
        STA	main@goRight + 0
        .dbg	line, "Example//example.c", 162
        LDA	main@goDown + 0
        BEQ	:+
        SEP	#$30
        LDA	#$00
        STA	main@goDown + 0
        BRA	:++
        :
        SEP	#$30
        LDA	#$01
        STA	main@goDown + 0
        :
      __IFNOT_dc369d37_0e66_45f1_a88f_0b8a30b2155f:
    __IFNOTELSE_89db5ded_5466_4ab9_93fe_fcf29e628712:
    .dbg	line, "Example//example.c", 165
    __ITER__START__00d0098b_97fc_44eb_9d6f_fe63326086c3:
    SEP	#$20
    LDA	isScanning + 0
    BNE	:+
    JMP	__ITER__END__00d0098b_97fc_44eb_9d6f_fe63326086c3
    :
    JMP	__ITER__START__00d0098b_97fc_44eb_9d6f_fe63326086c3
    __ITER__END__00d0098b_97fc_44eb_9d6f_fe63326086c3:
  JMP	__ITER__START__135bf97b_6820_49c3_91c6_2e394967b6e3
  __ITER__END__135bf97b_6820_49c3_91c6_2e394967b6e3:
__main_END: RTL
; Stolen shamelessly from https
; en.wikibooks.org/wiki/Super_NES_Programming/Initialization_Tutorial/Snes_Init

initSNES: ; @func
	sep 	#$30    ; X,Y,A are 8 bit numbers
	lda 	#$8F    ; screen off, full brightness
	sta 	$2100   ; brightness + screen enable register
	stz 	$2101   ; Sprite register (size + address in VRAM)
	stz 	$2102   ; Sprite registers (address of sprite memory [OAM])
	stz 	$2103   ;    ""                       ""
	stz 	$2105   ; Mode 0, = Graphic mode register
	stz 	$2106   ; noplanes, no mosaic, = Mosaic register
	stz 	$2107   ; Plane 0 map VRAM location
	stz 	$2108   ; Plane 1 map VRAM location
	stz 	$2109   ; Plane 2 map VRAM location
	stz 	$210A   ; Plane 3 map VRAM location
	stz 	$210B   ; Plane 0+1 Tile data location
	stz 	$210C   ; Plane 2+3 Tile data location
	stz 	$210D   ; Plane 0 scroll x (first 8 bits)
	stz 	$210D   ; Plane 0 scroll x (last 3 bits) #$0 - #$07ff
	lda 	#$FF    ; The top pixel drawn on the screen isn't the top one in the tilemap, it's the one above that.
	sta 	$210E   ; Plane 0 scroll y (first 8 bits)
	sta 	$2110   ; Plane 1 scroll y (first 8 bits)
	sta 	$2112   ; Plane 2 scroll y (first 8 bits)
	sta 	$2114   ; Plane 3 scroll y (first 8 bits)
	lda 	#$07    ; Since this could get quite annoying, it's better to edit the scrolling registers to fix this.
	sta 	$210E   ; Plane 0 scroll y (last 3 bits) #$0 - #$07ff
	sta 	$2110   ; Plane 1 scroll y (last 3 bits) #$0 - #$07ff
	sta 	$2112   ; Plane 2 scroll y (last 3 bits) #$0 - #$07ff
	sta 	$2114   ; Plane 3 scroll y (last 3 bits) #$0 - #$07ff
	stz 	$210F   ; Plane 1 scroll x (first 8 bits)
	stz 	$210F   ; Plane 1 scroll x (last 3 bits) #$0 - #$07ff
	stz 	$2111   ; Plane 2 scroll x (first 8 bits)
	stz 	$2111   ; Plane 2 scroll x (last 3 bits) #$0 - #$07ff
	stz 	$2113   ; Plane 3 scroll x (first 8 bits)
	stz 	$2113   ; Plane 3 scroll x (last 3 bits) #$0 - #$07ff
	lda 	#$80    ; increase VRAM address after writing to $2119
	sta 	$2115   ; VRAM address increment register
	stz 	$2116   ; VRAM address low
	stz 	$2117   ; VRAM address high
	stz 	$211A   ; Initial Mode 7 setting register
	stz 	$211B   ; Mode 7 matrix parameter A register (low)
	lda 	#$01
	sta 	$211B   ; Mode 7 matrix parameter A register (high)
	stz 	$211C   ; Mode 7 matrix parameter B register (low)
	stz 	$211C   ; Mode 7 matrix parameter B register (high)
	stz 	$211D   ; Mode 7 matrix parameter C register (low)
	stz 	$211D   ; Mode 7 matrix parameter C register (high)
	stz 	$211E   ; Mode 7 matrix parameter D register (low)
	sta 	$211E   ; Mode 7 matrix parameter D register (high)
	stz 	$211F   ; Mode 7 center position X register (low)
	stz 	$211F   ; Mode 7 center position X register (high)
	stz 	$2120   ; Mode 7 center position Y register (low)
	stz 	$2120   ; Mode 7 center position Y register (high)
	stz 	$2121   ; Color number register ($0-ff)
	stz 	$2123   ; BG1 & BG2 Window mask setting register
	stz 	$2124   ; BG3 & BG4 Window mask setting register
	stz 	$2125   ; OBJ & Color Window mask setting register
	stz 	$2126   ; Window 1 left position register
	stz 	$2127   ; Window 2 left position register
	stz 	$2128   ; Window 3 left position register
	stz 	$2129   ; Window 4 left position register
	stz 	$212A   ; BG1, BG2, BG3, BG4 Window Logic register
	stz 	$212B   ; OBJ, Color Window Logic Register (or,and,xor,xnor)
	sta 	$212C   ; Main Screen designation (planes, sprites enable)
	stz 	$212D   ; Sub Screen designation
	stz 	$212E   ; Window mask for Main Screen
	stz 	$212F   ; Window mask for Sub Screen
	lda 	#$30
	sta 	$2130   ; Color addition & screen addition init setting
	stz 	$2131   ; Add/Sub sub designation for screen, sprite, color
	lda 	#$E0
	sta 	$2132   ; color data for addition/subtraction
	stz 	$2133   ; Screen setting (interlace x,y/enable SFX data)
	stz 	$4200   ; Enable V-blank, interrupt, Joypad register
	lda 	#$FF
	sta 	$4201   ; Programmable I/O port
	stz 	$4202   ; Multiplicand A
	stz 	$4203   ; Multiplier B
	stz 	$4204   ; Multiplier C
	stz 	$4205   ; Multiplicand C
	stz 	$4206   ; Divisor B
	stz 	$4207   ; Horizontal Count Timer
	stz 	$4208   ; Horizontal Count Timer MSB (most significant bit)
	stz 	$4209   ; Vertical Count Timer
	stz 	$420A   ; Vertical Count Timer MSB
	stz 	$420B   ; General DMA enable (bits 0-7)
	stz 	$420C   ; Horizontal DMA (HDMA) enable (bits 0-7)
	stz 	$420D	; Access cycle designation (slow/fast rom)
	cli 	 	; Enable interrupts
RTL
; Registers as the library sees them
; https://snes.nesdev.org/wiki/MMIO_registers

; PPU - https://snes.nesdev.org/wiki/PPU_registers
INIDISP	= $002100

OBJSEL	= $002101
OAMADDL = $002102
OAMADDH = $002103
OAMDATA	= $002104

BGMODE	= $002105
MOSAIC	= $002106

BGSC	= $002107

BG12NBA	= $00210B
BG34NBA	= $00210C

BG1HOFS	= $00210D
M7HOFS	= $00210D
BG1VOFS	= $00210E
M7HOVS	= $00210E

BG2HOFS	= $00210F
BG2VOFS	= $002110

BG3HOFS	= $002111
BG3VOFS	= $002112

BG4HOFS	= $002113
BG4VOFS	= $002114

VMAIN	= $002115
VMADDR	= $002116
VMDATA	= $002118

M7SEL	= $00211A
M7A		= $00211B
M7B		= $00211C
M7C		= $00211D
M7D		= $00211F
M7Y		= $002120

CGADDR	= $002121
CGDATA	= $002122

W12SEL	= $002123
W34SEL	= $002124
WOBJSEL	= $002125
WH0		= $002126
WH1		= $002127
WH2		= $002128
WH3		= $002129

WBGLOG	= $00212A
WOBJLOG	= $00212B
TM		= $00212C
TS		= $00212D
TMW		= $00212E
TSW		= $00212F

CGWSEL	= $002130
CGADSUB	= $002131
COLDATA	= $002132

SETINI	= $002133

MPYL	= $002134
MPYM	= $002135
MPYH	= $002136

SLHV	= $002137

OAMDATAREAD	= $002138
VMDATALREAD	= $002139
VMDATAHREAD	= $00213A
CGDATAREAD	= $00213B

OPHCT	= $00213C
OPVCT	= $00213D

STAT77	= $00213E
STAT78	= $00213F

; DMA - https://snes.nesdev.org/wiki/DMA_registers
MDMAEN = $00420B
HDMAEN = $00420C
DMACHN = $004300

; MMIO - https://snes.nesdev.org/wiki/MMIO_registers
NMITIMEN = $004200
HTIME	= $004207
VTIME	= $004209
JOYPAD	= $004218

; APU - https://snes.nesdev.org/wiki/MMIO_registers
APUIO0 = $002140
APUIO1 = $002141
APUIO2 = $002142
APUIO3 = $002143
; Registers as the library sees them
; https://snes.nesdev.org/wiki/MMIO_registers

; PPU - https://snes.nesdev.org/wiki/PPU_registers
INIDISP	= $002100

OBJSEL	= $002101
OAMADDL = $002102
OAMADDH = $002103
OAMDATA	= $002104

BGMODE	= $002105
MOSAIC	= $002106

BGSC	= $002107

BG12NBA	= $00210B
BG34NBA	= $00210C

BG1HOFS	= $00210D
M7HOFS	= $00210D
BG1VOFS	= $00210E
M7HOVS	= $00210E

BG2HOFS	= $00210F
BG2VOFS	= $002110

BG3HOFS	= $002111
BG3VOFS	= $002112

BG4HOFS	= $002113
BG4VOFS	= $002114

VMAIN	= $002115
VMADDR	= $002116
VMDATA	= $002118

M7SEL	= $00211A
M7A		= $00211B
M7B		= $00211C
M7C		= $00211D
M7D		= $00211F
M7Y		= $002120

CGADDR	= $002121
CGDATA	= $002122

W12SEL	= $002123
W34SEL	= $002124
WOBJSEL	= $002125
WH0		= $002126
WH1		= $002127
WH2		= $002128
WH3		= $002129

WBGLOG	= $00212A
WOBJLOG	= $00212B
TM		= $00212C
TS		= $00212D
TMW		= $00212E
TSW		= $00212F

CGWSEL	= $002130
CGADSUB	= $002131
COLDATA	= $002132

SETINI	= $002133

MPYL	= $002134
MPYM	= $002135
MPYH	= $002136

SLHV	= $002137

OAMDATAREAD	= $002138
VMDATALREAD	= $002139
VMDATAHREAD	= $00213A
CGDATAREAD	= $00213B

OPHCT	= $00213C
OPVCT	= $00213D

STAT77	= $00213E
STAT78	= $00213F

; DMA - https://snes.nesdev.org/wiki/DMA_registers
MDMAEN = $00420B
HDMAEN = $00420C
DMACHN = $004300

; MMIO - https://snes.nesdev.org/wiki/MMIO_registers
NMITIMEN = $004200
HTIME	= $004207
VTIME	= $004209
JOYPAD	= $004218

; APU - https://snes.nesdev.org/wiki/MMIO_registers
APUIO0 = $002140
APUIO1 = $002141
APUIO2 = $002142
APUIO3 = $002143
tilemap:
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $14, $00, $04, $00, $14, $00
  .byte	$04, $00, $14, $00, $14, $00, $14, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $14, $00, $14, $00, $14, $00
  .byte	$04, $00, $04, $00, $14, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $14, $00, $04, $00, $14, $00
  .byte	$04, $00, $04, $00, $14, $00, $04, $00, $04, $00, $04, $00, $04, $00, $14, $00, $04, $00, $14, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $14, $00, $04, $00, $14, $00
  .byte	$04, $00, $14, $00, $14, $00, $14, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $14, $00, $04, $00, $04, $00, $04, $00, $14, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $05, $00, $07, $00, $06, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $14, $00, $14, $00, $14, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $0a, $00, $0c, $00, $08, $00
  .byte	$13, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $0b, $00, $0d, $00, $09, $00
  .byte	$12, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $0f, $00, $0e, $00, $10, $00
  .byte	$11, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $01, $00, $04, $00, $02, $00
  .byte	$04, $00, $03, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00, $04, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
tile:
  .byte	$00, $ff, $00, $ff, $18, $e7, $ff, $18, $ff, $18, $ff, $e7, $ff, $ff, $ff, $ff, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $c3, $00, $e7, $18, $42, $ff, $18, $ff, $18, $ff, $e7, $ff, $ff, $ff, $ff, $3c, $00, $18, $00, $a5, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$c3, $00, $c3, $00, $db, $00, $ff, $18, $ff, $18, $ff, $e7, $ff, $ff, $ff, $ff, $c3, $00, $c3, $00, $c3, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$18, $e7, $3c, $db, $7e, $81, $ff, $18, $ff, $18, $ff, $e7, $ff, $ff, $ff, $ff, $00, $18, $00, $24, $00, $66, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $e7, $e7, $e7, $e7, $e7, $e7, $00, $00, $7e, $7e, $7e, $7e, $7e, $7e, $00, $ff, $e7, $18, $e7, $18, $e7, $18, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$30, $00, $ff, $87, $ff, $83, $ff, $c1, $3f, $00, $7f, $60, $7f, $60, $7f, $71, $00, $cf, $b7, $00, $bb, $00, $dd, $00, $1e, $c0, $6f, $80, $6f, $80, $76, $80
  .byte	$0c, $00, $ff, $e1, $ff, $c1, $ff, $83, $fc, $00, $fe, $06, $fe, $06, $fe, $0e, $00, $f3, $ed, $00, $dd, $00, $bb, $00, $78, $03, $f6, $01, $f6, $01, $6e, $01
  .byte	$00, $00, $e7, $e7, $e7, $e7, $ff, $e7, $7e, $00, $ff, $00, $ff, $00, $ff, $83, $00, $ff, $e7, $18, $e7, $18, $e7, $00, $00, $81, $7e, $00, $ff, $00, $3c, $00
  .byte	$f0, $00, $ff, $07, $ef, $37, $cf, $36, $fd, $00, $ff, $02, $ff, $02, $fe, $02, $70, $0f, $77, $00, $c7, $00, $c6, $00, $c8, $02, $3a, $00, $fa, $00, $fa, $01
  .byte	$fe, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $fe, $01, $7e, $00, $76, $00, $56, $00, $af, $00, $ff, $00, $ff, $00, $ff, $00
  .byte	$0f, $01, $ff, $e0, $fb, $ec, $f3, $ec, $3f, $00, $7f, $60, $7f, $60, $7f, $60, $0e, $f0, $ee, $00, $e3, $00, $e3, $00, $03, $c0, $6c, $80, $6f, $80, $6f, $80
  .byte	$0f, $00, $ef, $e0, $ef, $e0, $ef, $e0, $0f, $00, $7f, $60, $7f, $60, $7f, $60, $0f, $f0, $ef, $10, $eb, $10, $ea, $10, $0d, $f0, $6f, $80, $6f, $80, $6f, $80
  .byte	$ff, $02, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $3c, $00, $3c, $00, $e7, $00, $5a, $00, $bd, $00, $ff, $00, $00, $00, $ff, $00
  .byte	$ff, $00, $f3, $0c, $e1, $1e, $e1, $1e, $c1, $3e, $c0, $3f, $c0, $3f, $c0, $3f, $ff, $00, $bf, $00, $bf, $00, $bf, $00, $7f, $00, $ff, $00, $ff, $00, $ff, $00
  .byte	$c0, $3f, $c0, $3f, $ff, $00, $ff, $e7, $00, $00, $7e, $7e, $7e, $7e, $7e, $7e, $ff, $00, $ff, $00, $00, $00, $e7, $00, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$ff, $c0, $df, $c0, $ff, $c0, $ff, $c0, $ff, $00, $7f, $7e, $7e, $7e, $7e, $7e, $cf, $00, $df, $20, $d5, $00, $c0, $00, $00, $00, $7e, $80, $7e, $81, $7e, $81
  .byte	$ff, $00, $ff, $00, $ff, $00, $ff, $e0, $ff, $00, $ff, $7e, $ff, $7e, $ff, $7e, $ff, $00, $ff, $00, $0a, $00, $e0, $00, $00, $00, $7e, $00, $7e, $00, $7e, $00
  .byte	$80, $00, $e7, $27, $e7, $27, $e7, $27, $00, $00, $7e, $7e, $7e, $7e, $7e, $7e, $80, $7f, $a7, $18, $a7, $18, $27, $18, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$3c, $00, $ff, $87, $ff, $c3, $ff, $83, $f8, $00, $1e, $ee, $3e, $de, $7e, $3e, $30, $c3, $b7, $00, $db, $00, $bb, $00, $70, $07, $ee, $01, $de, $01, $3e, $81
  .byte	$00, $00, $e7, $e7, $ff, $00, $ff, $06, $fe, $02, $fe, $00, $7f, $00, $7e, $0e, $00, $ff, $e7, $18, $00, $00, $f8, $00, $fc, $01, $fe, $01, $60, $80, $6e, $81
  .byte	$ff, $ff, $18, $ff, $18, $ff, $18, $ff, $ff, $ff, $81, $ff, $81, $ff, $81, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff
  .byte	$0f, $0f, $e8, $ef, $e8, $ef, $e8, $ef, $0f, $0f, $7e, $7e, $7e, $7e, $7e, $7e, $00, $ff, $e0, $1f, $e0, $1f, $e0, $1f, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$f0, $f0, $17, $f7, $17, $f7, $17, $f7, $f0, $f0, $7e, $7e, $7e, $7e, $7e, $7e, $00, $ff, $07, $f8, $07, $f8, $07, $f8, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$ff, $ff, $e7, $e7, $e7, $e7, $e7, $e7, $00, $00, $7e, $7e, $7e, $7e, $7e, $7e, $00, $ff, $e7, $18, $e7, $18, $e7, $18, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$ff, $ff, $18, $ff, $18, $ff, $18, $ff, $ff, $ff, $7e, $7e, $7e, $7e, $7e, $7e, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$ff, $ff, $e8, $ef, $e8, $ef, $e8, $ef, $0f, $0f, $7e, $7e, $7e, $7e, $7e, $7e, $00, $ff, $e0, $1f, $e0, $1f, $e0, $1f, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$ff, $ff, $17, $f7, $17, $f7, $17, $f7, $f0, $f0, $7e, $7e, $7e, $7e, $7e, $7e, $00, $ff, $07, $f8, $07, $f8, $07, $f8, $00, $ff, $7e, $81, $7e, $81, $7e, $81
  .byte	$00, $3c, $00, $3c, $00, $3c, $3f, $00, $3f, $00, $00, $0f, $41, $0f, $f3, $0f, $00, $00, $00, $00, $00, $00, $3f, $3f, $3f, $3f, $0f, $0f, $4e, $4e, $fc, $fc
  .byte	$00, $00, $00, $00, $00, $00, $fc, $00, $fc, $00, $00, $f0, $80, $f0, $40, $70, $3c, $00, $3c, $00, $3c, $00, $fc, $fc, $fc, $fc, $f0, $f0, $70, $70, $b0, $b0
  .byte	$7e, $7e, $ff, $e7, $e7, $e7, $ef, $ef, $5a, $5a, $7e, $7e, $7e, $7e, $7e, $7e, $00, $81, $a5, $00, $a1, $18, $a1, $10, $00, $a5, $0c, $81, $1c, $81, $00, $81
  .byte	$7e, $7e, $ff, $e7, $e7, $e7, $ef, $ef, $5a, $5a, $7e, $7e, $7e, $7e, $7e, $7e, $00, $81, $a5, $00, $a1, $18, $a1, $10, $00, $a5, $0c, $81, $1c, $81, $00, $81
  .byte	$18, $18, $ff, $ff, $ff, $ff, $ff, $ff, $18, $18, $7e, $7e, $7e, $7e, $7e, $7e, $00, $e7, $c7, $00, $e7, $00, $e7, $00, $00, $e7, $66, $81, $66, $81, $42, $81
  .byte	$3c, $1c, $ff, $ff, $ef, $ef, $ff, $ff, $3c, $38, $7e, $7e, $7e, $7e, $7e, $7e, $00, $c3, $c3, $00, $e3, $10, $e3, $00, $00, $c3, $4e, $81, $46, $81, $42, $81
  .byte	$3c, $38, $ff, $ff, $ff, $ef, $ff, $ff, $7e, $3c, $7e, $7e, $7e, $7e, $7e, $7e, $00, $c3, $c3, $00, $e3, $00, $c3, $00, $00, $81, $72, $81, $42, $81, $46, $81
  .byte	$3c, $24, $ff, $e7, $ff, $e7, $ff, $ff, $3c, $3c, $7e, $7e, $7e, $7e, $7e, $7e, $00, $c3, $c3, $00, $c3, $00, $c3, $00, $00, $c3, $72, $81, $72, $81, $72, $81
  .byte	$3c, $38, $ff, $ff, $f7, $f7, $ff, $ff, $3c, $1c, $7e, $7e, $7e, $7e, $7e, $7e, $00, $c3, $c3, $00, $c7, $08, $c7, $00, $00, $c3, $72, $81, $42, $81, $62, $81
  .byte	$7e, $7e, $ff, $ff, $f7, $e7, $ff, $ff, $7e, $7e, $7e, $7e, $7e, $7e, $7e, $7e, $00, $81, $81, $00, $87, $08, $81, $00, $00, $81, $18, $81, $00, $81, $00, $81
  .byte	$3c, $3c, $ff, $ff, $ff, $ef, $ff, $ef, $3c, $18, $7e, $7e, $7e, $7e, $7e, $7e, $00, $c3, $c3, $00, $e3, $00, $e3, $00, $00, $c3, $66, $81, $4e, $81, $4e, $81
  .byte	$7e, $7e, $ff, $e7, $f7, $e7, $ff, $ff, $7e, $7e, $7e, $7e, $7e, $7e, $7e, $7e, $00, $81, $a5, $00, $a5, $08, $81, $00, $00, $81, $3c, $81, $3c, $81, $00, $81
  .byte	$3c, $3c, $ff, $e7, $ff, $e7, $ff, $ff, $3c, $18, $7e, $7e, $7e, $7e, $7e, $7e, $00, $c3, $c3, $00, $c3, $00, $c3, $00, $00, $c3, $66, $81, $4e, $81, $4e, $81
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$f3, $0f, $41, $0f, $00, $0f, $3f, $00, $3f, $00, $00, $00, $00, $00, $00, $00, $fc, $fc, $4e, $4e, $0f, $0f, $3f, $3f, $3f, $3f, $3c, $00, $3c, $00, $3c, $00
  .byte	$c0, $f0, $80, $f0, $00, $f0, $fc, $00, $fc, $00, $00, $3c, $00, $3c, $00, $3c, $30, $30, $70, $70, $f0, $f0, $fc, $fc, $fc, $fc, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
  .byte	$00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00, $00
palette:
  .byte	$84, $10, $00, $00, $1f, $00, $ff, $7f, $00, $7c, $ff, $03, $3f, $03, $c6, $20, $00, $00, $19, $64, $ff, $67, $39, $47, $00, $00, $10, $42, $39, $67, $18, $7f
