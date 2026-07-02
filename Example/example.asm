.p816
.smart	+
.feature at_in_identifiers
.dbg file, "imp_math\imp_float_f2u64.h", 0, 0
.dbg file, "imp_math\imp_float_f2u64.asm", 0, 0
.dbg file, "imp_math\imp_float_s2f64.asm", 0, 0
.dbg file, "imp_math\imp_float_f2s32.h", 0, 0
.dbg file, "Example\SNES\dma.c", 0, 0
.dbg file, "imp_math\imp_float.asm", 0, 0
.dbg file, "Example\SNES\init.asm", 0, 0
.dbg file, "Example\example.c", 0, 0
.dbg file, "SNES\Graphics\colors.h", 0, 0
.dbg file, "imp_math\imp_float_f2s64.asm", 0, 0
.dbg file, "stdlib\stdint.h", 0, 0
.dbg file, "imp_math\imp_float_s2f32.h", 0, 0
.dbg file, "Example\SNES\Graphics\colors.c", 0, 0
.dbg file, "Resources\resources.h", 0, 0
.dbg file, "Example\SNES\Graphics\oam.c", 0, 0
.dbg file, "imp_math\imp_float_f32.h", 0, 0
.dbg file, "imp_math\imp_mult.asm", 0, 0
.dbg file, "imp_math\imp_float_u2f32.asm", 0, 0
.dbg file, "SNES\mmio.h", 0, 0
.dbg file, "imp_math\imp_float_f2u32.asm", 0, 0
.dbg file, "imp_math\imp_float_f64.asm", 0, 0
.dbg file, "imp_math\imp_float.h", 0, 0
.dbg file, "SNES\init.h", 0, 0
.dbg file, "imp_math\imp_float_u2f32.h", 0, 0
.dbg file, "SNES\Graphics\oam.h", 0, 0
.dbg file, "imp_math\imp_float_s2f64.h", 0, 0
.dbg file, "imp_math\imp_float_f2u32.h", 0, 0
.dbg file, "imp_math\imp_float_s2f32.asm", 0, 0
.dbg file, "imp_math\imp_mult.h", 0, 0
.dbg file, "Example\SNES\mmio.asm", 0, 0
.dbg file, "imp_math\imp_float_f2s64.h", 0, 0
.dbg file, "imp_math\imp_float_f2s32.asm", 0, 0
.dbg file, "SNES\cpu.h", 0, 0
.dbg file, "SNES\Graphics\backgrounds.h", 0, 0
.dbg file, "SNES\Graphics\ppu.h", 0, 0
.dbg file, "SNES\controls.h", 0, 0
.dbg file, "SNES\dma.h", 0, 0
.dbg file, "imp_math\imp_float_f64.h", 0, 0
.dbg file, "imp_math\imp_float_f32.asm", 0, 0
.dbg file, "Example\SNES\Graphics\ppu.c", 0, 0
.dbg file, "imp_math\imp_float_u2f64.asm", 0, 0
.dbg file, "Example\SNES\Graphics\backgrounds.c", 0, 0
.dbg file, "Example\Resources\resources.c", 0, 0
.dbg file, "imp_math\imp_float_u2f64.h", 0, 0
.segment "LVECTORS"
__longCOP:JML	RESET
__longBRK:JML	RESET
__longABORT:JML	RESET
__longNMI:JML	handleNMI
__longRESET:JML	RESET
__longIRQ:JML	RESET
.segment "HEADER"
.res	48, 0;	HEADER_HERE
.segment "VECTORS"
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longCOP)
.word	.loWORD(__longBRK)
.word	.loWORD(__longABORT)
.word	.loWORD(__longNMI)
.word	.loWORD(__longRESET)
.word	.loWORD(__longIRQ)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
.word	.loWORD(__longRESET)
__@callResult                     = $000000
__@specSubY                       = $000040
__@specSubX                       = $000050
__@funcPointer                    = $000060
__@signExtend                     = $000063
__@scratchBase                    = $000065
queueHDMAEN                       = $7e2000	; unsigned char (1 bytes)
.dbg sym, "queueHDMAEN", "00", EXTERN, "queueHDMAEN"
copyTilemap@tilemap               = $7e2001	; (unsigned short)* (3 bytes)
.dbg sym, "tilemap", "00", EXTERN, "copyTilemap@tilemap"
copyTilemap@destination           = $7e2004	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTilemap@destination"
copyTileRegion@tilemap            = $7e2001	; (unsigned short)* (3 bytes)
.dbg sym, "tilemap", "00", EXTERN, "copyTileRegion@tilemap"
copyTileRegion@destination        = $7e2004	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTileRegion@destination"
copyTileRegion@n                  = $7e2006	; unsigned short (2 bytes)
.dbg sym, "n", "00", EXTERN, "copyTileRegion@n"
copyTiles2BPP@tiles               = $7e2001	; (unsigned short)* (3 bytes)
.dbg sym, "tiles", "00", EXTERN, "copyTiles2BPP@tiles"
copyTiles2BPP@destination         = $7e2004	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTiles2BPP@destination"
copyTiles2BPP@nTiles              = $7e2006	; unsigned short (2 bytes)
.dbg sym, "nTiles", "00", EXTERN, "copyTiles2BPP@nTiles"
copyTiles4BPP@tiles               = $7e2001	; (unsigned short)* (3 bytes)
.dbg sym, "tiles", "00", EXTERN, "copyTiles4BPP@tiles"
copyTiles4BPP@destination         = $7e2004	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTiles4BPP@destination"
copyTiles4BPP@nTiles              = $7e2006	; unsigned short (2 bytes)
.dbg sym, "nTiles", "00", EXTERN, "copyTiles4BPP@nTiles"
copyTiles8BPP@tiles               = $7e2001	; (unsigned short)* (3 bytes)
.dbg sym, "tiles", "00", EXTERN, "copyTiles8BPP@tiles"
copyTiles8BPP@destination         = $7e2004	; unsigned short (2 bytes)
.dbg sym, "destination", "00", EXTERN, "copyTiles8BPP@destination"
copyTiles8BPP@nTiles              = $7e2006	; unsigned short (2 bytes)
.dbg sym, "nTiles", "00", EXTERN, "copyTiles8BPP@nTiles"
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
setHighOAMProperties@i            = $7e2001	; unsigned char (1 bytes)
.dbg sym, "i", "00", EXTERN, "setHighOAMProperties@i"
setHighOAMProperties@xShift       = $7e2002	; _Bool (1 bytes)
.dbg sym, "xShift", "00", EXTERN, "setHighOAMProperties@xShift"
setHighOAMProperties@largeSprite  = $7e2003	; _Bool (1 bytes)
.dbg sym, "largeSprite", "00", EXTERN, "setHighOAMProperties@largeSprite"
isScanning                        = $7e2008	; _Bool (1 bytes)
.dbg sym, "isScanning", "00", EXTERN, "isScanning"
isColliding@x1                    = $7e2009	; unsigned char (1 bytes)
.dbg sym, "x1", "00", EXTERN, "isColliding@x1"
isColliding@w1                    = $7e200a	; unsigned char (1 bytes)
.dbg sym, "w1", "00", EXTERN, "isColliding@w1"
isColliding@y1                    = $7e200b	; unsigned char (1 bytes)
.dbg sym, "y1", "00", EXTERN, "isColliding@y1"
isColliding@h1                    = $7e200c	; unsigned char (1 bytes)
.dbg sym, "h1", "00", EXTERN, "isColliding@h1"
isColliding@x2                    = $7e200d	; unsigned char (1 bytes)
.dbg sym, "x2", "00", EXTERN, "isColliding@x2"
isColliding@w2                    = $7e200e	; unsigned char (1 bytes)
.dbg sym, "w2", "00", EXTERN, "isColliding@w2"
isColliding@y2                    = $7e200f	; unsigned char (1 bytes)
.dbg sym, "y2", "00", EXTERN, "isColliding@y2"
isColliding@h2                    = $7e2010	; unsigned char (1 bytes)
.dbg sym, "h2", "00", EXTERN, "isColliding@h2"
uiToTiles@c                       = $7e2009	; (unsigned short)* (3 bytes)
.dbg sym, "c", "00", EXTERN, "uiToTiles@c"
uiToTiles@n                       = $7e200c	; unsigned char (1 bytes)
.dbg sym, "n", "00", EXTERN, "uiToTiles@n"
uiToTiles@value                   = $7e200d	; unsigned int (3 bytes)
.dbg sym, "value", "00", EXTERN, "uiToTiles@value"
uiToTiles@zeroTile                = $7e2010	; unsigned short (2 bytes)
.dbg sym, "zeroTile", "00", EXTERN, "uiToTiles@zeroTile"
uiToTiles@x                       = $7e2012	; unsigned short (2 bytes)
.dbg sym, "x", "00", EXTERN, "uiToTiles@x"
uiToTiles@i                       = $7e2014	; short (2 bytes)
.dbg sym, "i", "00", EXTERN, "uiToTiles@i"
main@tilemapAddress               = $7e2016	; unsigned short (2 bytes)
.dbg sym, "tilemapAddress", "00", EXTERN, "main@tilemapAddress"
main@tilesetAddress               = $7e2018	; unsigned short (2 bytes)
.dbg sym, "tilesetAddress", "00", EXTERN, "main@tilesetAddress"
main@scoreP1                      = $7e201a	; unsigned int (3 bytes)
.dbg sym, "scoreP1", "00", EXTERN, "main@scoreP1"
main@scoreP2                      = $7e201d	; unsigned int (3 bytes)
.dbg sym, "scoreP2", "00", EXTERN, "main@scoreP2"
main@scoreP1Tiles                 = $7e2020	; unsigned short[4] (8 bytes)
.dbg sym, "scoreP1Tiles", "00", EXTERN, "main@scoreP1Tiles"
main@scoreP2Tiles                 = $7e2028	; unsigned short[4] (8 bytes)
.dbg sym, "scoreP2Tiles", "00", EXTERN, "main@scoreP2Tiles"
main@goRight                      = $7e2030	; _Bool (1 bytes)
.dbg sym, "goRight", "00", EXTERN, "main@goRight"
main@goDown                       = $7e2031	; _Bool (1 bytes)
.dbg sym, "goDown", "00", EXTERN, "main@goDown"
main@refreshScores                = $7e2032	; _Bool (1 bytes)
.dbg sym, "refreshScores", "00", EXTERN, "main@refreshScores"
lowOAMBuffer                      = $7e2033	; struct LowOAMObj[128] (512 bytes)
.dbg sym, "lowOAMBuffer", "00", EXTERN, "lowOAMBuffer"
highOAMBuffer                     = $7e2233	; unsigned char[32] (32 bytes)
.dbg sym, "highOAMBuffer", "00", EXTERN, "highOAMBuffer"
setHighOAMProperties@j            = $7e2253	; unsigned char (1 bytes)
.dbg sym, "j", "00", EXTERN, "setHighOAMProperties@j"
setHighOAMProperties@b            = $7e2254	; unsigned char (1 bytes)
.dbg sym, "b", "00", EXTERN, "setHighOAMProperties@b"
clearOAMBuffers@i                 = $7e2253	; unsigned char (1 bytes)
.dbg sym, "i", "00", EXTERN, "clearOAMBuffers@i"
bufferBG12NBA                     = $7e2255	; unsigned char (1 bytes)
.dbg sym, "bufferBG12NBA", "00", EXTERN, "bufferBG12NBA"
bufferBG34NBA                     = $7e2256	; unsigned char (1 bytes)
.dbg sym, "bufferBG34NBA", "00", EXTERN, "bufferBG34NBA"
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
LDA	#$1eff
TCS
LDA	#$FFFF
STA	$00420D
PHK
PEA	RESET
SEP	#$20
LDA	#$00
STA	queueHDMAEN + 0
STA	bufferBG12NBA + 0
STA	bufferBG34NBA + 0
JML	main
runAllHDMAs:	; @func void()
  .dbg	line, "Example\SNES\dma.c", 9
  SEP	#$20
  LDA	queueHDMAEN + 0
  STA	HDMAEN + 0
  .dbg	line, "Example\SNES\dma.c", 10
  LDA	#$00
  STA	queueHDMAEN + 0
__runAllHDMAs_END:
RTL	; @endfunc
copyTilemap:	; @func void((unsigned short)*, unsigned short)
  .dbg	line, "Example\SNES\Graphics\ppu.c", 8
  SEP	#$20
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 9
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 10
  REP	#$20
  LDA	copyTilemap@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 11
  SEP	#$20
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example\SNES\Graphics\ppu.c", 12
  REP	#$20
  LDA	copyTilemap@tilemap + 0
  STA	DMACHN + 2
  SEP	#$20
  LDA	copyTilemap@tilemap + 2
  STA	DMACHN + 4
  .dbg	line, "Example\SNES\Graphics\ppu.c", 13
  REP	#$20
  LDA	#$0800
  STA	DMACHN + 5
  SEP	#$20
  STA	DMACHN + 7
  .dbg	line, "Example\SNES\Graphics\ppu.c", 14
  LDA	#$01
  STA	MDMAEN + 0
__copyTilemap_END:
RTL	; @endfunc
copyTileRegion:	; @func void((unsigned short)*, unsigned short, unsigned short)
  .dbg	line, "Example\SNES\Graphics\ppu.c", 18
  SEP	#$20
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 19
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 20
  REP	#$20
  LDA	copyTileRegion@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 21
  SEP	#$20
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example\SNES\Graphics\ppu.c", 22
  REP	#$20
  LDA	copyTileRegion@tilemap + 0
  STA	DMACHN + 2
  SEP	#$20
  LDA	copyTileRegion@tilemap + 2
  STA	DMACHN + 4
  .dbg	line, "Example\SNES\Graphics\ppu.c", 23
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  LDA	copyTileRegion@n + 0
  ASL
  STA	DMACHN + 5
  SEP	#$20
  LDA	__@signExtend
  ROL
  STA	DMACHN + 7
  .dbg	line, "Example\SNES\Graphics\ppu.c", 24
  LDA	#$01
  STA	MDMAEN + 0
__copyTileRegion_END:
RTL	; @endfunc
copyTiles2BPP:	; @func void((unsigned short)*, unsigned short, unsigned short)
  .dbg	line, "Example\SNES\Graphics\ppu.c", 29
  SEP	#$20
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 30
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 31
  REP	#$20
  LDA	copyTiles2BPP@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 32
  SEP	#$20
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example\SNES\Graphics\ppu.c", 33
  REP	#$20
  LDA	copyTiles2BPP@tiles + 0
  STA	DMACHN + 2
  SEP	#$20
  LDA	copyTiles2BPP@tiles + 2
  STA	DMACHN + 4
  .dbg	line, "Example\SNES\Graphics\ppu.c", 34
  REP	#$20
  LDA	copyTiles2BPP@nTiles + 0
  STA	DMACHN + 5
  SEP	#$20
  LDA	#$00
  STA	DMACHN + 7
  REP	#$30
  LDA	#$0004
  TAX
  :
    REP	#$21
    LDA	DMACHN + 5
    ASL
    STA	DMACHN + 5
    SEP	#$20
    LDA	DMACHN + 7
    ROL
    STA	DMACHN + 7
    DEX
  BNE	:-
  .dbg	line, "Example\SNES\Graphics\ppu.c", 35
  SEP	#$20
  LDA	#$01
  STA	MDMAEN + 0
__copyTiles2BPP_END:
RTL	; @endfunc
copyTiles4BPP:	; @func void((unsigned short)*, unsigned short, unsigned short)
  .dbg	line, "Example\SNES\Graphics\ppu.c", 39
  SEP	#$20
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 40
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 41
  REP	#$20
  LDA	copyTiles4BPP@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 42
  SEP	#$20
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example\SNES\Graphics\ppu.c", 43
  REP	#$20
  LDA	copyTiles4BPP@tiles + 0
  STA	DMACHN + 2
  SEP	#$20
  LDA	copyTiles4BPP@tiles + 2
  STA	DMACHN + 4
  .dbg	line, "Example\SNES\Graphics\ppu.c", 44
  REP	#$20
  LDA	copyTiles4BPP@nTiles + 0
  STA	DMACHN + 5
  SEP	#$20
  LDA	#$00
  STA	DMACHN + 7
  REP	#$30
  LDA	#$0005
  TAX
  :
    REP	#$21
    LDA	DMACHN + 5
    ASL
    STA	DMACHN + 5
    SEP	#$20
    LDA	DMACHN + 7
    ROL
    STA	DMACHN + 7
    DEX
  BNE	:-
  .dbg	line, "Example\SNES\Graphics\ppu.c", 45
  SEP	#$20
  LDA	#$01
  STA	MDMAEN + 0
__copyTiles4BPP_END:
RTL	; @endfunc
copyTiles8BPP:	; @func void((unsigned short)*, unsigned short, unsigned short)
  .dbg	line, "Example\SNES\Graphics\ppu.c", 49
  SEP	#$20
  LDA	#$80
  STA	VMAIN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 50
  LDA	#$01
  STA	DMACHN + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 51
  REP	#$20
  LDA	copyTiles8BPP@destination + 0
  STA	VMADDR + 0
  .dbg	line, "Example\SNES\Graphics\ppu.c", 52
  SEP	#$20
  LDA	#.loByte(VMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example\SNES\Graphics\ppu.c", 53
  REP	#$20
  LDA	copyTiles8BPP@tiles + 0
  STA	DMACHN + 2
  SEP	#$20
  LDA	copyTiles8BPP@tiles + 2
  STA	DMACHN + 4
  .dbg	line, "Example\SNES\Graphics\ppu.c", 54
  REP	#$20
  LDA	copyTiles8BPP@nTiles + 0
  STA	DMACHN + 5
  SEP	#$20
  LDA	#$00
  STA	DMACHN + 7
  REP	#$30
  LDA	#$0006
  TAX
  :
    REP	#$21
    LDA	DMACHN + 5
    ASL
    STA	DMACHN + 5
    SEP	#$20
    LDA	DMACHN + 7
    ROL
    STA	DMACHN + 7
    DEX
  BNE	:-
  .dbg	line, "Example\SNES\Graphics\ppu.c", 55
  SEP	#$20
  LDA	#$01
  STA	MDMAEN + 0
__copyTiles8BPP_END:
RTL	; @endfunc
setBackgroundMode:	; @func void(unsigned char, _Bool, _Bool)
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 11
  SEP	#$10
  LDX	#$00
  SEP	#$20
  LDA	setBackgroundMode@largeTiles + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__condSkip69f07f50_59ba_4b87_8ac7_3fa56a05776a
  REP	#$20
  LDA	#$00f0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  STA	__@scratchBase + 2
  JMP	__condEnd69f07f50_59ba_4b87_8ac7_3fa56a05776a
  __condSkip69f07f50_59ba_4b87_8ac7_3fa56a05776a:
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$20
  STA	__@scratchBase + 2
  __condEnd69f07f50_59ba_4b87_8ac7_3fa56a05776a:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setBackgroundMode@mode + 0
  ORA	__@scratchBase + 0
  STA	setBackgroundMode@mode + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 12
  SEP	#$10
  LDX	#$00
  LDA	setBackgroundMode@BG3Priority + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_25635ef0_6431_4c54_a370_eb912de8ba49
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 12
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setBackgroundMode@mode + 0
  ORA	#$08
  STA	setBackgroundMode@mode + 0
  __IFNOT_25635ef0_6431_4c54_a370_eb912de8ba49:
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 13
  SEP	#$20
  LDA	setBackgroundMode@mode + 0
  STA	BGMODE + 0
__setBackgroundMode_END:
RTL	; @endfunc
setBackgroundAddress:	; @func void(unsigned char, unsigned short, enum TilemapCount)
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 19
  SEP	#$20
  LDA	setBackgroundAddress@backgroundNo + 0
  STA	__@scratchBase + 127
  LDA	setBackgroundAddress@wordAddress + 1
  STA	__@scratchBase + 0
  LDA	setBackgroundAddress@tilemapCount + 0
  ORA	__@scratchBase + 0
  SEP	#$10
  LDX	__@scratchBase + 127
  STA	BGSC + 0,X
__setBackgroundAddress_END:
RTL	; @endfunc
setBackgroundTileset:	; @func void(unsigned char, unsigned short)
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 24
  SEP	#$20
  LDA	setBackgroundTileset@backgroundNo + 0
  STA	__@scratchBase + 0
  SEP	#$10
  CMP	#$04
  BCS	:+
  SEP	#$20
  LDA	__@scratchBase + 0
  ASL
  STA	__@scratchBase + 0
  TAX
  JMP	(__SWITCH_TABLE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d,x)
  :
  JMP	__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_DEF
  __SWITCH_TABLE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d:
    .word	.LoWord(__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_0)
    .word	.LoWord(__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_1)
    .word	.LoWord(__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_2)
    .word	.LoWord(__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_3)
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 26
__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_0:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	bufferBG12NBA + 0
  AND	#$f0
  STA	bufferBG12NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 28
  LDA	setBackgroundTileset@wordAddress + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 3
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@scratchBase + 2
  LSR
  LSR
  LSR
  LSR
  STA	__@scratchBase + 1
  LDA	bufferBG12NBA + 0
  ORA	__@scratchBase + 1
  STA	bufferBG12NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 29
  JMP	__CASE_SKIP_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 30
__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_1:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	bufferBG12NBA + 0
  AND	#$0f
  STA	bufferBG12NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 32
  LDA	setBackgroundTileset@wordAddress + 1
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@scratchBase + 4
  AND	#$f0
  STA	__@scratchBase + 1
  REP	#$20
  LDA	__@signExtend
  AND	#$0000
  STA	__@scratchBase + 2
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	bufferBG12NBA + 0
  ORA	__@scratchBase + 1
  STA	bufferBG12NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 33
  JMP	__CASE_SKIP_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 34
__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_2:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	bufferBG34NBA + 0
  AND	#$f0
  STA	bufferBG34NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 36
  LDA	setBackgroundTileset@wordAddress + 1
  STA	__@scratchBase + 2
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 3
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@scratchBase + 2
  LSR
  LSR
  LSR
  LSR
  STA	__@scratchBase + 1
  LDA	bufferBG34NBA + 0
  ORA	__@scratchBase + 1
  STA	bufferBG34NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 37
  JMP	__CASE_SKIP_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 38
__CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_3:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	bufferBG34NBA + 0
  AND	#$0f
  STA	bufferBG34NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 40
  LDA	setBackgroundTileset@wordAddress + 1
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	__@scratchBase + 4
  AND	#$f0
  STA	__@scratchBase + 1
  REP	#$20
  LDA	__@signExtend
  AND	#$0000
  STA	__@scratchBase + 2
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	bufferBG34NBA + 0
  ORA	__@scratchBase + 1
  STA	bufferBG34NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 41
  JMP	__CASE_SKIP_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d
  __CASE_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d_DEF:
  __CASE_SKIP_9b261bf1_d13a_453a_bfa7_5e2a5bd56d6d:
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 44
  SEP	#$20
  LDA	bufferBG12NBA + 0
  STA	BG12NBA + 0
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 45
  LDA	bufferBG34NBA + 0
  STA	BG34NBA + 0
__setBackgroundTileset_END:
RTL	; @endfunc
setColor:	; @func void(unsigned short, unsigned char)
  .dbg	line, "Example\SNES\Graphics\colors.c", 9
  SEP	#$20
  LDA	setColor@destination + 0
  STA	CGADDR + 0
  .dbg	line, "Example\SNES\Graphics\colors.c", 10
  REP	#$20
  LDA	setColor@color + 0
  SEP	#$20
  STA	CGDATA + 0
  XBA
  STA	CGDATA + 0
  XBA
  REP	#$20
__setColor_END:
RTL	; @endfunc
copyPalette:	; @func void((unsigned short)*, unsigned char, unsigned char)
  .dbg	line, "Example\SNES\Graphics\colors.c", 15
  SEP	#$20
  LDA	#$02
  STA	DMACHN + 0
  .dbg	line, "Example\SNES\Graphics\colors.c", 16
  LDA	copyPalette@destination + 0
  STA	CGADDR + 0
  .dbg	line, "Example\SNES\Graphics\colors.c", 17
  LDA	#.loByte(CGDATA)
  STA	DMACHN + 1
  .dbg	line, "Example\SNES\Graphics\colors.c", 18
  REP	#$20
  LDA	copyPalette@palette + 0
  STA	DMACHN + 2
  SEP	#$20
  LDA	copyPalette@palette + 2
  STA	DMACHN + 4
  .dbg	line, "Example\SNES\Graphics\colors.c", 19
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	copyPalette@paletteSize + 0
  ASL
  STA	DMACHN + 5
  REP	#$20
  LDA	__@signExtend
  ROL
  STA	DMACHN + 6
  .dbg	line, "Example\SNES\Graphics\colors.c", 20
  SEP	#$20
  LDA	#$01
  STA	MDMAEN + 0
__copyPalette_END:
RTL	; @endfunc
setHighOAMProperties:	; @func void(unsigned char, _Bool, _Bool)
  .dbg	line, "Example\SNES\Graphics\oam.c", 27
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	#$03
  AND	setHighOAMProperties@i + 0
  STA	setHighOAMProperties@j + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 28
  LDA	setHighOAMProperties@i + 0
  LSR
  LSR
  STA	setHighOAMProperties@i + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 29
  LDA	setHighOAMProperties@i + 0
  STA	__@scratchBase + 127
  SEP	#$10
  LDX	__@scratchBase + 127
  LDA	highOAMBuffer + 0,X
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 30
  LDA	setHighOAMProperties@j + 0
  STA	__@scratchBase + 0
  CMP	#$04
  BCS	:+
  SEP	#$20
  LDA	__@scratchBase + 0
  ASL
  STA	__@scratchBase + 0
  TAX
  JMP	(__SWITCH_TABLE_c03eed28_29da_41b4_b798_963313e81fae,x)
  :
  JMP	__CASE_c03eed28_29da_41b4_b798_963313e81fae_DEF
  __SWITCH_TABLE_c03eed28_29da_41b4_b798_963313e81fae:
    .word	.LoWord(__CASE_c03eed28_29da_41b4_b798_963313e81fae_0)
    .word	.LoWord(__CASE_c03eed28_29da_41b4_b798_963313e81fae_1)
    .word	.LoWord(__CASE_c03eed28_29da_41b4_b798_963313e81fae_2)
    .word	.LoWord(__CASE_c03eed28_29da_41b4_b798_963313e81fae_3)
  .dbg	line, "Example\SNES\Graphics\oam.c", 32
__CASE_c03eed28_29da_41b4_b798_963313e81fae_0:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  AND	#$fc
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 34
  LDA	setHighOAMProperties@largeSprite + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  STA	__@signExtend + 1
  SEP	#$20
  LDA	setHighOAMProperties@largeSprite + 0
  ASL
  STA	__@scratchBase + 4
  REP	#$20
  LDA	__@signExtend
  ROL
  STA	__@scratchBase + 5
  SEP	#$20
  LDA	setHighOAMProperties@xShift + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  STA	__@signExtend + 1
  SEP	#$20
  LDA	setHighOAMProperties@xShift + 0
  ORA	__@scratchBase + 4
  STA	__@scratchBase + 1
  REP	#$20
  LDA	__@signExtend
  ORA	__@scratchBase + 5
  STA	__@scratchBase + 2
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  ORA	__@scratchBase + 1
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 35
  JMP	__CASE_SKIP_c03eed28_29da_41b4_b798_963313e81fae
  .dbg	line, "Example\SNES\Graphics\oam.c", 36
__CASE_c03eed28_29da_41b4_b798_963313e81fae_1:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  AND	#$f3
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 38
  LDA	setHighOAMProperties@xShift + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 5
  REP	#$10
  LDA	#$0002
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 4
    ASL
    STA	__@scratchBase + 4
    SEP	#$20
    LDA	__@scratchBase + 6
    ROL
    STA	__@scratchBase + 6
    DEX
  BNE	:-
  SEP	#$20
  LDA	setHighOAMProperties@largeSprite + 0
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 8
  REP	#$10
  LDA	#$0003
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 7
    ASL
    STA	__@scratchBase + 7
    SEP	#$20
    LDA	__@scratchBase + 9
    ROL
    STA	__@scratchBase + 9
    DEX
  BNE	:-
  REP	#$20
  LDA	__@scratchBase + 4
  ORA	__@scratchBase + 7
  STA	__@scratchBase + 1
  SEP	#$20
  LDA	__@scratchBase + 6
  ORA	__@scratchBase + 9
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  ORA	__@scratchBase + 1
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 39
  JMP	__CASE_SKIP_c03eed28_29da_41b4_b798_963313e81fae
  .dbg	line, "Example\SNES\Graphics\oam.c", 40
__CASE_c03eed28_29da_41b4_b798_963313e81fae_2:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  AND	#$cf
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 42
  LDA	setHighOAMProperties@xShift + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 5
  REP	#$10
  LDA	#$0004
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 4
    ASL
    STA	__@scratchBase + 4
    SEP	#$20
    LDA	__@scratchBase + 6
    ROL
    STA	__@scratchBase + 6
    DEX
  BNE	:-
  SEP	#$20
  LDA	setHighOAMProperties@largeSprite + 0
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 8
  REP	#$10
  LDA	#$0005
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 7
    ASL
    STA	__@scratchBase + 7
    SEP	#$20
    LDA	__@scratchBase + 9
    ROL
    STA	__@scratchBase + 9
    DEX
  BNE	:-
  REP	#$20
  LDA	__@scratchBase + 4
  ORA	__@scratchBase + 7
  STA	__@scratchBase + 1
  SEP	#$20
  LDA	__@scratchBase + 6
  ORA	__@scratchBase + 9
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  ORA	__@scratchBase + 1
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 43
  JMP	__CASE_SKIP_c03eed28_29da_41b4_b798_963313e81fae
  .dbg	line, "Example\SNES\Graphics\oam.c", 44
__CASE_c03eed28_29da_41b4_b798_963313e81fae_3:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  AND	#$f3
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 46
  LDA	setHighOAMProperties@xShift + 0
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 5
  REP	#$10
  LDA	#$0006
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 4
    ASL
    STA	__@scratchBase + 4
    SEP	#$20
    LDA	__@scratchBase + 6
    ROL
    STA	__@scratchBase + 6
    DEX
  BNE	:-
  SEP	#$20
  LDA	setHighOAMProperties@largeSprite + 0
  STA	__@scratchBase + 7
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 8
  REP	#$10
  LDA	#$0007
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 7
    ASL
    STA	__@scratchBase + 7
    SEP	#$20
    LDA	__@scratchBase + 9
    ROL
    STA	__@scratchBase + 9
    DEX
  BNE	:-
  REP	#$20
  LDA	__@scratchBase + 4
  ORA	__@scratchBase + 7
  STA	__@scratchBase + 1
  SEP	#$20
  LDA	__@scratchBase + 6
  ORA	__@scratchBase + 9
  STA	__@scratchBase + 3
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  ORA	__@scratchBase + 1
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 47
  JMP	__CASE_SKIP_c03eed28_29da_41b4_b798_963313e81fae
  __CASE_c03eed28_29da_41b4_b798_963313e81fae_DEF:
  __CASE_SKIP_c03eed28_29da_41b4_b798_963313e81fae:
  .dbg	line, "Example\SNES\Graphics\oam.c", 49
  SEP	#$20
  LDA	setHighOAMProperties@i + 0
  STA	__@scratchBase + 126
  LDA	setHighOAMProperties@b + 0
  SEP	#$10
  LDX	__@scratchBase + 126
  STA	highOAMBuffer + 0,X
__setHighOAMProperties_END:
RTL	; @endfunc
clearOAMBuffers:	; @func void()
  .dbg	line, "Example\SNES\Graphics\oam.c", 11
  .dbg	line, "Example\SNES\Graphics\oam.c", 12
  SEP	#$20
  LDA	#$00
  STA	clearOAMBuffers@i + 0
  __ITER__START__70cfcb64_f5ac_4c99_a844_0d0db54e9e43:
  REP	#$21
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  EOR	#$8000
  CMP	#$8000
  BCC	__CMP_YES_ee5504f1_99e0_490b_b37d_8529b09bc88f
  BNE	__CMP_NO_ee5504f1_99e0_490b_b37d_8529b09bc88f
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  CMP	#$80
  BCC	__CMP_YES_ee5504f1_99e0_490b_b37d_8529b09bc88f
  BNE	__CMP_NO_ee5504f1_99e0_490b_b37d_8529b09bc88f
  JMP	__CMP_NO_ee5504f1_99e0_490b_b37d_8529b09bc88f
  __CMP_YES_ee5504f1_99e0_490b_b37d_8529b09bc88f:
  REP	#$20
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_ee5504f1_99e0_490b_b37d_8529b09bc88f
  __CMP_NO_ee5504f1_99e0_490b_b37d_8529b09bc88f:
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$20
  STA	__@scratchBase + 2
  __CMP_END_ee5504f1_99e0_490b_b37d_8529b09bc88f:
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
  BEQ	:+
  JMP	__ITER__END__70cfcb64_f5ac_4c99_a844_0d0db54e9e43
  :
  .dbg	line, "Example\SNES\Graphics\oam.c", 14
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 0
  LDA	__@signExtend
  STA	__@scratchBase + 1
  REP	#$20
  LDA	__@scratchBase + 0
  ASL
  ASL
  STA	__@scratchBase + 126
  SEP	#$20
  LDA	#$00
  REP	#$10
  LDX	__@scratchBase + 126
  STA	lowOAMBuffer + 0,X
  .dbg	line, "Example\SNES\Graphics\oam.c", 15
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 0
  LDA	__@signExtend
  STA	__@scratchBase + 1
  REP	#$20
  LDA	__@scratchBase + 0
  ASL
  ASL
  STA	__@scratchBase + 124
  SEP	#$20
  LDA	#$00
  LDX	__@scratchBase + 124
  STA	lowOAMBuffer + 1,X
  .dbg	line, "Example\SNES\Graphics\oam.c", 16
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 0
  LDA	__@signExtend
  STA	__@scratchBase + 1
  REP	#$20
  LDA	__@scratchBase + 0
  ASL
  ASL
  STA	__@scratchBase + 122
  SEP	#$20
  LDA	#$00
  LDX	__@scratchBase + 122
  STA	lowOAMBuffer + 2,X
  .dbg	line, "Example\SNES\Graphics\oam.c", 17
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 0
  LDA	__@signExtend
  STA	__@scratchBase + 1
  REP	#$20
  LDA	__@scratchBase + 0
  ASL
  ASL
  STA	__@scratchBase + 120
  SEP	#$20
  LDA	#$00
  LDX	__@scratchBase + 120
  STA	lowOAMBuffer + 3,X
  __ITER__ITER__70cfcb64_f5ac_4c99_a844_0d0db54e9e43:
  CLC
  LDA	clearOAMBuffers@i + 0
  ADC	#$01
  STA	clearOAMBuffers@i + 0
  JMP	__ITER__START__70cfcb64_f5ac_4c99_a844_0d0db54e9e43
  __ITER__END__70cfcb64_f5ac_4c99_a844_0d0db54e9e43:
  .dbg	line, "Example\SNES\Graphics\oam.c", 19
  SEP	#$20
  LDA	#$00
  STA	clearOAMBuffers@i + 0
  __ITER__START__442a1157_e0b1_4d9a_986b_e5f7434d8577:
  REP	#$21
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  EOR	#$8000
  CMP	#$8000
  BCC	__CMP_YES_ba16441e_6a1b_43ab_98c6_c546c4086128
  BNE	__CMP_NO_ba16441e_6a1b_43ab_98c6_c546c4086128
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  CMP	#$20
  BCC	__CMP_YES_ba16441e_6a1b_43ab_98c6_c546c4086128
  BNE	__CMP_NO_ba16441e_6a1b_43ab_98c6_c546c4086128
  JMP	__CMP_NO_ba16441e_6a1b_43ab_98c6_c546c4086128
  __CMP_YES_ba16441e_6a1b_43ab_98c6_c546c4086128:
  REP	#$20
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_ba16441e_6a1b_43ab_98c6_c546c4086128
  __CMP_NO_ba16441e_6a1b_43ab_98c6_c546c4086128:
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$20
  STA	__@scratchBase + 2
  __CMP_END_ba16441e_6a1b_43ab_98c6_c546c4086128:
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
  BNE	__ITER__END__442a1157_e0b1_4d9a_986b_e5f7434d8577
  .dbg	line, "Example\SNES\Graphics\oam.c", 21
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 119
  LDA	#$55
  SEP	#$10
  LDX	__@scratchBase + 119
  STA	highOAMBuffer + 0,X
  __ITER__ITER__442a1157_e0b1_4d9a_986b_e5f7434d8577:
  CLC
  LDA	clearOAMBuffers@i + 0
  ADC	#$01
  STA	clearOAMBuffers@i + 0
  JMP	__ITER__START__442a1157_e0b1_4d9a_986b_e5f7434d8577
  __ITER__END__442a1157_e0b1_4d9a_986b_e5f7434d8577:
__clearOAMBuffers_END:
RTL	; @endfunc
updateOAM:	; @func void()
  .dbg	line, "Example\SNES\Graphics\oam.c", 54
  SEP	#$20
  LDA	#$02
  STA	DMACHN + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 55
  LDA	#$00
  STA	OAMADDL + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 56
  STA	OAMADDH + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 57
  LDA	#.loByte(OAMDATA)
  STA	DMACHN + 1
  .dbg	line, "Example\SNES\Graphics\oam.c", 58
  REP	#$20
  LDA	#.loWord(lowOAMBuffer)
  STA	DMACHN + 2
  SEP	#$20
  LDA	#.bankByte(lowOAMBuffer)
  STA	DMACHN + 4
  .dbg	line, "Example\SNES\Graphics\oam.c", 59
  REP	#$20
  LDA	#$0200
  STA	DMACHN + 5
  SEP	#$20
  STA	DMACHN + 7
  .dbg	line, "Example\SNES\Graphics\oam.c", 60
  LDA	#$01
  STA	MDMAEN + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 62
  REP	#$20
  LDA	#.loWord(highOAMBuffer)
  STA	DMACHN + 2
  SEP	#$20
  LDA	#.bankByte(highOAMBuffer)
  STA	DMACHN + 4
  .dbg	line, "Example\SNES\Graphics\oam.c", 63
  REP	#$20
  LDA	#$0020
  STA	DMACHN + 5
  SEP	#$20
  LDA	#$00
  STA	DMACHN + 7
  .dbg	line, "Example\SNES\Graphics\oam.c", 64
  LDA	#$01
  STA	MDMAEN + 0
__updateOAM_END:
RTL	; @endfunc
handleNMI:	; @func void()
REP	#$30
PHY
PHX
PHA
  .dbg	line, "Example\example.c", 17
  SEP	#$20
  LDA	#$00
  STA	isScanning + 0
__handleNMI_END:
REP	#$30
PLA
PLX
PLY
RTI; @endfunc
isColliding:	; @func _Bool(unsigned char, unsigned char, unsigned char, unsigned char, unsigned char, unsigned char, unsigned char, unsigned char)
  .dbg	line, "Example\example.c", 22
  CLC
  SEP	#$20
  LDA	isColliding@x2 + 0
  ADC	isColliding@w2 + 0
  STA	__@scratchBase + 0
  CLC
  LDA	isColliding@x1 + 0
  CMP	__@scratchBase + 0
  BCC	__CMP_NO_749bb77a_ff34_42e5_a01c_167475017e95
  BNE	__CMP_YES_749bb77a_ff34_42e5_a01c_167475017e95
  JMP	__CMP_YES_749bb77a_ff34_42e5_a01c_167475017e95
  __CMP_YES_749bb77a_ff34_42e5_a01c_167475017e95:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_749bb77a_ff34_42e5_a01c_167475017e95
  __CMP_NO_749bb77a_ff34_42e5_a01c_167475017e95:
  SEP	#$20
  LDA	#$00
  __CMP_END_749bb77a_ff34_42e5_a01c_167475017e95:
  BEQ	__IFNOT_c9818312_2be4_4990_aa73_292efc149c77
  .dbg	line, "Example\example.c", 22
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 0
  JMP	__isColliding_END
  __IFNOT_c9818312_2be4_4990_aa73_292efc149c77:
  .dbg	line, "Example\example.c", 23
  CLC
  SEP	#$20
  LDA	isColliding@x1 + 0
  ADC	isColliding@w1 + 0
  STA	__@scratchBase + 0
  CLC
  LDA	__@scratchBase + 0
  CMP	isColliding@x2 + 0
  BCC	__CMP_YES_82e7c7dc_9b6b_4a1e_9c11_453349b9590f
  BNE	__CMP_NO_82e7c7dc_9b6b_4a1e_9c11_453349b9590f
  JMP	__CMP_YES_82e7c7dc_9b6b_4a1e_9c11_453349b9590f
  __CMP_YES_82e7c7dc_9b6b_4a1e_9c11_453349b9590f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_82e7c7dc_9b6b_4a1e_9c11_453349b9590f
  __CMP_NO_82e7c7dc_9b6b_4a1e_9c11_453349b9590f:
  SEP	#$20
  LDA	#$00
  __CMP_END_82e7c7dc_9b6b_4a1e_9c11_453349b9590f:
  BEQ	__IFNOT_cb887e00_7783_413d_bf37_adad542a7ad0
  .dbg	line, "Example\example.c", 23
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 0
  JMP	__isColliding_END
  __IFNOT_cb887e00_7783_413d_bf37_adad542a7ad0:
  .dbg	line, "Example\example.c", 24
  CLC
  SEP	#$20
  LDA	isColliding@y2 + 0
  ADC	isColliding@h2 + 0
  STA	__@scratchBase + 0
  CLC
  LDA	isColliding@y1 + 0
  CMP	__@scratchBase + 0
  BCC	__CMP_NO_bcfe7f5d_cf7a_4f5e_a55e_e25b1a17d90a
  BNE	__CMP_YES_bcfe7f5d_cf7a_4f5e_a55e_e25b1a17d90a
  JMP	__CMP_YES_bcfe7f5d_cf7a_4f5e_a55e_e25b1a17d90a
  __CMP_YES_bcfe7f5d_cf7a_4f5e_a55e_e25b1a17d90a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_bcfe7f5d_cf7a_4f5e_a55e_e25b1a17d90a
  __CMP_NO_bcfe7f5d_cf7a_4f5e_a55e_e25b1a17d90a:
  SEP	#$20
  LDA	#$00
  __CMP_END_bcfe7f5d_cf7a_4f5e_a55e_e25b1a17d90a:
  BEQ	__IFNOT_05956f9c_89f7_4bbe_81ee_87fe7d13a918
  .dbg	line, "Example\example.c", 24
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 0
  JMP	__isColliding_END
  __IFNOT_05956f9c_89f7_4bbe_81ee_87fe7d13a918:
  .dbg	line, "Example\example.c", 25
  CLC
  SEP	#$20
  LDA	isColliding@y1 + 0
  ADC	isColliding@h1 + 0
  STA	__@scratchBase + 0
  CLC
  LDA	__@scratchBase + 0
  CMP	isColliding@y2 + 0
  BCC	__CMP_YES_483b0598_4055_4320_8ce0_f94f65cfd28e
  BNE	__CMP_NO_483b0598_4055_4320_8ce0_f94f65cfd28e
  JMP	__CMP_YES_483b0598_4055_4320_8ce0_f94f65cfd28e
  __CMP_YES_483b0598_4055_4320_8ce0_f94f65cfd28e:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_483b0598_4055_4320_8ce0_f94f65cfd28e
  __CMP_NO_483b0598_4055_4320_8ce0_f94f65cfd28e:
  SEP	#$20
  LDA	#$00
  __CMP_END_483b0598_4055_4320_8ce0_f94f65cfd28e:
  BEQ	__IFNOT_f8fdbce3_311c_40f8_beb7_c91a139c5745
  .dbg	line, "Example\example.c", 25
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 0
  JMP	__isColliding_END
  __IFNOT_f8fdbce3_311c_40f8_beb7_c91a139c5745:
  .dbg	line, "Example\example.c", 26
  SEP	#$20
  LDA	#$01
  STA	__@callResult + 0
  JMP	__isColliding_END
__isColliding_END:
RTL	; @endfunc
uiToTiles:	; @func void((unsigned short)*, unsigned char, unsigned int, unsigned short)
  .dbg	line, "Example\example.c", 32
  .dbg	line, "Example\example.c", 33
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$21
  LDA	uiToTiles@n + 0
  SBC	#$01
  STA	uiToTiles@i + 0
  LDA	__@signExtend
  SBC	#$00
  STA	uiToTiles@i + 1
  __ITER__START__5a2f3590_8333_4612_a066_9432f02eed2b:
  CLC
  SEP	#$20
  LDA	uiToTiles@i + 1
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  STA	__@signExtend + 1
  SEP	#$20
  LDA	__@signExtend
  EOR	#$80
  CMP	#$80
  BCC	__CMP_NO_efb47f58_59f8_40d1_8b53_6ab597b21699
  BNE	__CMP_YES_efb47f58_59f8_40d1_8b53_6ab597b21699
  REP	#$20
  LDA	uiToTiles@i + 0
  CMP	#$0000
  BCC	__CMP_NO_efb47f58_59f8_40d1_8b53_6ab597b21699
  BNE	__CMP_YES_efb47f58_59f8_40d1_8b53_6ab597b21699
  JMP	__CMP_YES_efb47f58_59f8_40d1_8b53_6ab597b21699
  __CMP_YES_efb47f58_59f8_40d1_8b53_6ab597b21699:
  REP	#$20
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_efb47f58_59f8_40d1_8b53_6ab597b21699
  __CMP_NO_efb47f58_59f8_40d1_8b53_6ab597b21699:
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$20
  STA	__@scratchBase + 2
  __CMP_END_efb47f58_59f8_40d1_8b53_6ab597b21699:
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
  BEQ	:+
  JMP	__ITER__END__5a2f3590_8333_4612_a066_9432f02eed2b
  :
  .dbg	line, "Example\example.c", 35
  SEP	#$10
  REP	#$20
  LDA	uiToTiles@value + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	uiToTiles@value + 2
  STA	__@specSubX + 2
  REP	#$20
  LDA	#$000a
  STA	__@specSubY + 0
  SEP	#$20
  LDA	#$00
  STA	__@specSubY + 2
  LDY	#$00
  LDA	uiToTiles@value + 2
  AND	#$80
  BEQ	:+
  INY
  SEC
  REP	#$20
  LDA	#$0000
  SBC	__@specSubX + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	#$00
  SBC	__@specSubX + 2
  STA	__@specSubX + 2
  :
  SEP	#$30
  LDA	#$00
  AND	#$80
  BEQ	:+
  DEY
  SEC
  REP	#$20
  LDA	#$0000
  SBC	__@specSubY + 0
  STA	__@specSubY + 0
  SEP	#$20
  LDA	#$00
  SBC	__@specSubY + 2
  STA	__@specSubY + 2
  :
  SEP	#$30
  JSL	__mod24by24
  REP	#$20
  LDA	__@callResult + 0
  STA	uiToTiles@x + 0
  CPY	#$00
  BEQ	:+
  SEC
  REP	#$20
  LDA	#$0000
  SBC	uiToTiles@x + 0
  STA	uiToTiles@x + 0
  :
  .dbg	line, "Example\example.c", 36
  SEP	#$10
  REP	#$20
  LDA	uiToTiles@value + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	uiToTiles@value + 2
  STA	__@specSubX + 2
  REP	#$20
  LDA	#$000a
  STA	__@specSubY + 0
  SEP	#$20
  LDA	#$00
  STA	__@specSubY + 2
  LDY	#$00
  LDA	uiToTiles@value + 2
  AND	#$80
  BEQ	:+
  INY
  SEC
  REP	#$20
  LDA	#$0000
  SBC	__@specSubX + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	#$00
  SBC	__@specSubX + 2
  STA	__@specSubX + 2
  :
  SEP	#$30
  LDA	#$00
  AND	#$80
  BEQ	:+
  DEY
  SEC
  REP	#$20
  LDA	#$0000
  SBC	__@specSubY + 0
  STA	__@specSubY + 0
  SEP	#$20
  LDA	#$00
  SBC	__@specSubY + 2
  STA	__@specSubY + 2
  :
  SEP	#$30
  JSL	__div24by24
  REP	#$20
  LDA	__@callResult + 0
  STA	uiToTiles@value + 0
  SEP	#$20
  LDA	__@callResult + 2
  STA	uiToTiles@value + 2
  CPY	#$00
  BEQ	:+
  SEC
  REP	#$20
  LDA	#$0000
  SBC	uiToTiles@value + 0
  STA	uiToTiles@value + 0
  SEP	#$20
  LDA	#$00
  SBC	uiToTiles@value + 2
  STA	uiToTiles@value + 2
  :
  .dbg	line, "Example\example.c", 37
  SEP	#$20
  LDA	uiToTiles@i + 1
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  STA	__@signExtend + 1
  REP	#$20
  LDA	uiToTiles@i + 0
  ASL
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	__@signExtend
  ROL
  STA	__@scratchBase + 5
  REP	#$21
  LDA	uiToTiles@c + 0
  ADC	__@scratchBase + 3
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	uiToTiles@c + 2
  ADC	__@scratchBase + 5
  STA	__@scratchBase + 2
  REP	#$21
  LDA	uiToTiles@x + 0
  ADC	uiToTiles@zeroTile + 0
  SEP	#$10
  LDY	#$0000
  STA	[__@scratchBase],y
  __ITER__ITER__5a2f3590_8333_4612_a066_9432f02eed2b:
  SEC
  REP	#$20
  LDA	uiToTiles@i + 0
  SBC	#$0001
  STA	uiToTiles@i + 0
  JMP	__ITER__START__5a2f3590_8333_4612_a066_9432f02eed2b
  __ITER__END__5a2f3590_8333_4612_a066_9432f02eed2b:
__uiToTiles_END:
RTL	; @endfunc
main:	; @func void()
  .dbg	line, "Example\example.c", 43
  JSL	initSNES
  .dbg	line, "Example\example.c", 44
  REP	#$20
  LDA	#$0400
  STA	main@tilemapAddress + 0
  .dbg	line, "Example\example.c", 45
  LDA	#$0000
  STA	main@tilesetAddress + 0
  .dbg	line, "Example\example.c", 47
  SEP	#$20
  LDA	#$01
  STA	setBackgroundMode@mode + 0
  LDA	#$00
  STA	setBackgroundMode@BG3Priority + 0
  STA	setBackgroundMode@largeTiles + 0
  JSL	setBackgroundMode
  .dbg	line, "Example\example.c", 48
  SEP	#$20
  LDA	#$00
  STA	setBackgroundAddress@backgroundNo + 0
  REP	#$20
  LDA	main@tilemapAddress + 0
  STA	setBackgroundAddress@wordAddress + 0
  SEP	#$20
  LDA	#$00
  STA	setBackgroundAddress@tilemapCount + 0
  JSL	setBackgroundAddress
  .dbg	line, "Example\example.c", 49
  SEP	#$20
  LDA	#$00
  STA	setBackgroundTileset@backgroundNo + 0
  REP	#$20
  LDA	main@tilesetAddress + 0
  STA	setBackgroundTileset@wordAddress + 0
  JSL	setBackgroundTileset
  .dbg	line, "Example\example.c", 51
  REP	#$20
  LDA	#.loWord(tilemap)
  STA	copyTilemap@tilemap + 0
  SEP	#$20
  LDA	#.bankByte(tilemap)
  STA	copyTilemap@tilemap + 2
  REP	#$20
  LDA	main@tilemapAddress + 0
  STA	copyTilemap@destination + 0
  JSL	copyTilemap
  .dbg	line, "Example\example.c", 52
  REP	#$20
  LDA	#.loWord(tile)
  STA	copyTiles4BPP@tiles + 0
  SEP	#$20
  LDA	#.bankByte(tile)
  STA	copyTiles4BPP@tiles + 2
  REP	#$20
  LDA	main@tilesetAddress + 0
  STA	copyTiles4BPP@destination + 0
  LDA	#$002f
  STA	copyTiles4BPP@nTiles + 0
  JSL	copyTiles4BPP
  .dbg	line, "Example\example.c", 53
  REP	#$20
  LDA	#.loWord(palette)
  STA	copyPalette@palette + 0
  SEP	#$20
  LDA	#.bankByte(palette)
  STA	copyPalette@palette + 2
  LDA	#$00
  STA	copyPalette@destination + 0
  LDA	#$20
  STA	copyPalette@paletteSize + 0
  JSL	copyPalette
  .dbg	line, "Example\example.c", 54
  REP	#$20
  LDA	#.loWord(palette)
  STA	copyPalette@palette + 0
  SEP	#$20
  LDA	#.bankByte(palette)
  STA	copyPalette@palette + 2
  LDA	#$80
  STA	copyPalette@destination + 0
  LDA	#$20
  STA	copyPalette@paletteSize + 0
  JSL	copyPalette
  .dbg	line, "Example\example.c", 56
  JSL	clearOAMBuffers
  .dbg	line, "Example\example.c", 58
  SEP	#$20
  LDA	#$18
  STA	lowOAMBuffer + 0
  .dbg	line, "Example\example.c", 59
  LDA	#$80
  STA	lowOAMBuffer + 1
  .dbg	line, "Example\example.c", 60
  LDA	#$1b
  STA	lowOAMBuffer + 2
  .dbg	line, "Example\example.c", 61
  LDA	#$30
  STA	lowOAMBuffer + 3
  .dbg	line, "Example\example.c", 62
  LDA	#$00
  STA	setHighOAMProperties@i + 0
  STA	setHighOAMProperties@xShift + 0
  LDA	#$01
  STA	setHighOAMProperties@largeSprite + 0
  JSL	setHighOAMProperties
  .dbg	line, "Example\example.c", 64
  SEP	#$20
  LDA	#$d8
  STA	lowOAMBuffer + 4
  .dbg	line, "Example\example.c", 65
  LDA	#$80
  STA	lowOAMBuffer + 5
  .dbg	line, "Example\example.c", 66
  LDA	#$1b
  STA	lowOAMBuffer + 6
  .dbg	line, "Example\example.c", 67
  LDA	#$70
  STA	lowOAMBuffer + 7
  .dbg	line, "Example\example.c", 68
  LDA	#$01
  STA	setHighOAMProperties@i + 0
  LDA	#$00
  STA	setHighOAMProperties@xShift + 0
  LDA	#$01
  STA	setHighOAMProperties@largeSprite + 0
  JSL	setHighOAMProperties
  .dbg	line, "Example\example.c", 70
  SEP	#$20
  LDA	#$80
  STA	lowOAMBuffer + 8
  .dbg	line, "Example\example.c", 71
  STA	lowOAMBuffer + 9
  .dbg	line, "Example\example.c", 72
  LDA	#$00
  STA	lowOAMBuffer + 10
  .dbg	line, "Example\example.c", 73
  LDA	#$30
  STA	lowOAMBuffer + 11
  .dbg	line, "Example\example.c", 74
  LDA	#$02
  STA	setHighOAMProperties@i + 0
  LDA	#$00
  STA	setHighOAMProperties@xShift + 0
  STA	setHighOAMProperties@largeSprite + 0
  JSL	setHighOAMProperties
  .dbg	line, "Example\example.c", 76
  JSL	updateOAM
  .dbg	line, "Example\example.c", 77
  SEP	#$20
  LDA	#$11
  STA	TM + 0
  .dbg	line, "Example\example.c", 79
  REP	#$20
  LDA	#$0000
  STA	main@scoreP1 + 0
  SEP	#$20
  STA	main@scoreP1 + 2
  REP	#$20
  LDA	#$0000
  STA	main@scoreP2 + 0
  SEP	#$20
  STA	main@scoreP2 + 2
  .dbg	line, "Example\example.c", 80
  .dbg	line, "Example\example.c", 81
  REP	#$20
  LDA	#.loWord(main@scoreP1Tiles)
  STA	uiToTiles@c + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP1Tiles)
  STA	uiToTiles@c + 2
  LDA	#$04
  STA	uiToTiles@n + 0
  REP	#$20
  LDA	main@scoreP1 + 0
  STA	uiToTiles@value + 0
  SEP	#$20
  LDA	main@scoreP1 + 2
  STA	uiToTiles@value + 2
  REP	#$20
  LDA	#$001e
  STA	uiToTiles@zeroTile + 0
  JSL	uiToTiles
  .dbg	line, "Example\example.c", 82
  REP	#$20
  LDA	#.loWord(main@scoreP2Tiles)
  STA	uiToTiles@c + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP2Tiles)
  STA	uiToTiles@c + 2
  LDA	#$04
  STA	uiToTiles@n + 0
  REP	#$20
  LDA	main@scoreP2 + 0
  STA	uiToTiles@value + 0
  SEP	#$20
  LDA	main@scoreP2 + 2
  STA	uiToTiles@value + 2
  REP	#$20
  LDA	#$001e
  STA	uiToTiles@zeroTile + 0
  JSL	uiToTiles
  .dbg	line, "Example\example.c", 83
  REP	#$20
  LDA	#.loWord(main@scoreP1Tiles)
  STA	copyTileRegion@tilemap + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP1Tiles)
  STA	copyTileRegion@tilemap + 2
  REP	#$21
  LDA	main@tilemapAddress + 0
  ADC	#$0204
  STA	copyTileRegion@destination + 0
  LDA	#$0004
  STA	copyTileRegion@n + 0
  JSL	copyTileRegion
  .dbg	line, "Example\example.c", 84
  REP	#$20
  LDA	#.loWord(main@scoreP2Tiles)
  STA	copyTileRegion@tilemap + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP2Tiles)
  STA	copyTileRegion@tilemap + 2
  REP	#$21
  LDA	main@tilemapAddress + 0
  ADC	#$0218
  STA	copyTileRegion@destination + 0
  LDA	#$0004
  STA	copyTileRegion@n + 0
  JSL	copyTileRegion
  .dbg	line, "Example\example.c", 88
  SEP	#$20
  LDA	#$0f
  STA	INIDISP + 0
  .dbg	line, "Example\example.c", 89
  LDA	#$81
  STA	NMITIMEN + 0
  .dbg	line, "Example\example.c", 90
  LDA	#$01
  STA	isScanning + 0
  .dbg	line, "Example\example.c", 92
  STA	main@goRight + 0
  STA	main@goDown + 0
  .dbg	line, "Example\example.c", 93
  LDA	#$00
  STA	main@refreshScores + 0
  .dbg	line, "Example\example.c", 95
  __ITER__START__b4e4674c_75b8_4cd6_acba_6a0bfd796bc0:
  .dbg	line, "Example\example.c", 97
  SEP	#$10
  LDX	#$00
  SEP	#$20
  LDA	main@refreshScores + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  BEQ	:+
  JMP	__IFNOT_e5e3f31f_4842_4a2b_b3ad_424b943d8b36
  :
  .dbg	line, "Example\example.c", 98
  .dbg	line, "Example\example.c", 99
  REP	#$20
  LDA	#.loWord(main@scoreP1Tiles)
  STA	copyTileRegion@tilemap + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP1Tiles)
  STA	copyTileRegion@tilemap + 2
  REP	#$21
  LDA	main@tilemapAddress + 0
  ADC	#$0204
  STA	copyTileRegion@destination + 0
  LDA	#$0004
  STA	copyTileRegion@n + 0
  JSL	copyTileRegion
  .dbg	line, "Example\example.c", 100
  REP	#$20
  LDA	#.loWord(main@scoreP2Tiles)
  STA	copyTileRegion@tilemap + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP2Tiles)
  STA	copyTileRegion@tilemap + 2
  REP	#$21
  LDA	main@tilemapAddress + 0
  ADC	#$0218
  STA	copyTileRegion@destination + 0
  LDA	#$0004
  STA	copyTileRegion@n + 0
  JSL	copyTileRegion
  .dbg	line, "Example\example.c", 101
  SEP	#$20
  LDA	#$00
  STA	main@refreshScores + 0
  __IFNOT_e5e3f31f_4842_4a2b_b3ad_424b943d8b36:
  .dbg	line, "Example\example.c", 104
  JSL	updateOAM
  .dbg	line, "Example\example.c", 105
  SEP	#$20
  LDA	#$01
  STA	isScanning + 0
  .dbg	line, "Example\example.c", 107
  REP	#$20
  LDA	#$0800
  AND	JOYPAD + 0
  STA	__@scratchBase + 1
  SEP	#$10
  LDX	#$01
  LDA	__@scratchBase + 1
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  BEQ	__SKIPf5bc6f97_858e_49a8_b104_07a0971f8631
  REP	#$21
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  EOR	#$8000
  CMP	#$8000
  BCC	__CMP_NO_4045bca2_47fd_478b_8099_276bce2f8f74
  BNE	__CMP_YES_4045bca2_47fd_478b_8099_276bce2f8f74
  SEP	#$20
  LDA	lowOAMBuffer + 1
  CMP	#$00
  BCC	__CMP_NO_4045bca2_47fd_478b_8099_276bce2f8f74
  BNE	__CMP_YES_4045bca2_47fd_478b_8099_276bce2f8f74
  JMP	__CMP_NO_4045bca2_47fd_478b_8099_276bce2f8f74
  __CMP_YES_4045bca2_47fd_478b_8099_276bce2f8f74:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_4045bca2_47fd_478b_8099_276bce2f8f74
  __CMP_NO_4045bca2_47fd_478b_8099_276bce2f8f74:
  SEP	#$20
  LDA	#$00
  __CMP_END_4045bca2_47fd_478b_8099_276bce2f8f74:
  SEP	#$20
  STA	__@scratchBase + 1
  __SKIPf5bc6f97_858e_49a8_b104_07a0971f8631:
  LDA	__@scratchBase + 0
  AND	__@scratchBase + 1
  BEQ	__IFNOT_a89e4d5f_8d8e_49a7_8737_33ab330a4479
  .dbg	line, "Example\example.c", 108
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$21
  LDA	lowOAMBuffer + 1
  SBC	#$01
  STA	lowOAMBuffer + 1
  JMP	__IFNOTELSE_a89e4d5f_8d8e_49a7_8737_33ab330a4479
  __IFNOT_a89e4d5f_8d8e_49a7_8737_33ab330a4479:
  REP	#$20
  LDA	#$0400
  AND	JOYPAD + 0
  STA	__@scratchBase + 1
  SEP	#$10
  LDX	#$01
  LDA	__@scratchBase + 1
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  BEQ	__SKIPe5d50ed5_2c4b_4a1f_b4de_31214cd588ad
  CLC
  LDA	lowOAMBuffer + 1
  CMP	#$d0
  BCC	__CMP_YES_5c9d6e24_2c8b_4fc8_bea2_e58f33add147
  BNE	__CMP_NO_5c9d6e24_2c8b_4fc8_bea2_e58f33add147
  JMP	__CMP_NO_5c9d6e24_2c8b_4fc8_bea2_e58f33add147
  __CMP_YES_5c9d6e24_2c8b_4fc8_bea2_e58f33add147:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_5c9d6e24_2c8b_4fc8_bea2_e58f33add147
  __CMP_NO_5c9d6e24_2c8b_4fc8_bea2_e58f33add147:
  SEP	#$20
  LDA	#$00
  __CMP_END_5c9d6e24_2c8b_4fc8_bea2_e58f33add147:
  SEP	#$20
  STA	__@scratchBase + 1
  __SKIPe5d50ed5_2c4b_4a1f_b4de_31214cd588ad:
  LDA	__@scratchBase + 0
  AND	__@scratchBase + 1
  BEQ	__IFNOT_24cb149b_a73b_40bd_bc29_05ec835bc171
  .dbg	line, "Example\example.c", 110
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 1
  ADC	#$01
  STA	lowOAMBuffer + 1
  __IFNOT_24cb149b_a73b_40bd_bc29_05ec835bc171:
  __IFNOTELSE_a89e4d5f_8d8e_49a7_8737_33ab330a4479:
  .dbg	line, "Example\example.c", 112
  REP	#$20
  LDA	#$0800
  AND	JOYPAD + 2
  STA	__@scratchBase + 1
  SEP	#$10
  LDX	#$01
  LDA	__@scratchBase + 1
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  BEQ	__SKIP78b8ade6_79c0_48a7_b255_8ec4a386ce7a
  REP	#$21
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  EOR	#$8000
  CMP	#$8000
  BCC	__CMP_NO_da42f219_1734_4cd5_bed4_9bab21a45b8f
  BNE	__CMP_YES_da42f219_1734_4cd5_bed4_9bab21a45b8f
  SEP	#$20
  LDA	lowOAMBuffer + 5
  CMP	#$00
  BCC	__CMP_NO_da42f219_1734_4cd5_bed4_9bab21a45b8f
  BNE	__CMP_YES_da42f219_1734_4cd5_bed4_9bab21a45b8f
  JMP	__CMP_NO_da42f219_1734_4cd5_bed4_9bab21a45b8f
  __CMP_YES_da42f219_1734_4cd5_bed4_9bab21a45b8f:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_da42f219_1734_4cd5_bed4_9bab21a45b8f
  __CMP_NO_da42f219_1734_4cd5_bed4_9bab21a45b8f:
  SEP	#$20
  LDA	#$00
  __CMP_END_da42f219_1734_4cd5_bed4_9bab21a45b8f:
  SEP	#$20
  STA	__@scratchBase + 1
  __SKIP78b8ade6_79c0_48a7_b255_8ec4a386ce7a:
  LDA	__@scratchBase + 0
  AND	__@scratchBase + 1
  BEQ	__IFNOT_3d575cd1_e77c_4ef7_9f6d_7b7b2a982842
  .dbg	line, "Example\example.c", 113
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$21
  LDA	lowOAMBuffer + 5
  SBC	#$01
  STA	lowOAMBuffer + 5
  JMP	__IFNOTELSE_3d575cd1_e77c_4ef7_9f6d_7b7b2a982842
  __IFNOT_3d575cd1_e77c_4ef7_9f6d_7b7b2a982842:
  REP	#$20
  LDA	#$0400
  AND	JOYPAD + 2
  STA	__@scratchBase + 1
  SEP	#$10
  LDX	#$01
  LDA	__@scratchBase + 1
  CMP	#$0000
  BNE	:+
  DEX
: TXA
  SEP	#$20
  STA	__@scratchBase + 0
  BEQ	__SKIP0202da4c_458e_4ea6_8e94_99f9b171cc77
  CLC
  LDA	lowOAMBuffer + 5
  CMP	#$d0
  BCC	__CMP_YES_a4de96d2_e668_4568_994a_dd51c6cb2053
  BNE	__CMP_NO_a4de96d2_e668_4568_994a_dd51c6cb2053
  JMP	__CMP_NO_a4de96d2_e668_4568_994a_dd51c6cb2053
  __CMP_YES_a4de96d2_e668_4568_994a_dd51c6cb2053:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_a4de96d2_e668_4568_994a_dd51c6cb2053
  __CMP_NO_a4de96d2_e668_4568_994a_dd51c6cb2053:
  SEP	#$20
  LDA	#$00
  __CMP_END_a4de96d2_e668_4568_994a_dd51c6cb2053:
  SEP	#$20
  STA	__@scratchBase + 1
  __SKIP0202da4c_458e_4ea6_8e94_99f9b171cc77:
  LDA	__@scratchBase + 0
  AND	__@scratchBase + 1
  BEQ	__IFNOT_9afbdfa3_d121_4eee_a802_f7c54dff50e6
  .dbg	line, "Example\example.c", 115
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 5
  ADC	#$01
  STA	lowOAMBuffer + 5
  __IFNOT_9afbdfa3_d121_4eee_a802_f7c54dff50e6:
  __IFNOTELSE_3d575cd1_e77c_4ef7_9f6d_7b7b2a982842:
  .dbg	line, "Example\example.c", 117
  SEP	#$10
  LDX	#$00
  SEP	#$20
  LDA	main@goRight + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__condSkipf2e572d7_cf51_43f7_bcfe_bcd427556c63
  SEP	#$20
  LDA	__@scratchBase + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  STA	__@signExtend + 1
  SEP	#$20
  LDA	#$01
  STA	__@scratchBase + 0
  JMP	__condEndf2e572d7_cf51_43f7_bcfe_bcd427556c63
  __condSkipf2e572d7_cf51_43f7_bcfe_bcd427556c63:
  SEP	#$20
  LDA	__@scratchBase + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  STA	__@signExtend + 1
  SEP	#$20
  LDA	#$ff
  STA	__@scratchBase + 0
  __condEndf2e572d7_cf51_43f7_bcfe_bcd427556c63:
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 8
  ADC	__@scratchBase + 0
  STA	lowOAMBuffer + 8
  .dbg	line, "Example\example.c", 118
  SEP	#$10
  LDX	#$00
  LDA	main@goDown + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__condSkip3df17a99_e547_45c4_986e_8ad3caabe8cc
  SEP	#$20
  LDA	__@scratchBase + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  STA	__@signExtend + 1
  SEP	#$20
  LDA	#$01
  STA	__@scratchBase + 0
  JMP	__condEnd3df17a99_e547_45c4_986e_8ad3caabe8cc
  __condSkip3df17a99_e547_45c4_986e_8ad3caabe8cc:
  SEP	#$20
  LDA	__@scratchBase + 0
  BPL	:+
  LDA	#$FF
  BRA	:++
  :
  LDA	#$00
  :
  STA	__@signExtend
  STA	__@signExtend + 1
  SEP	#$20
  LDA	#$ff
  STA	__@scratchBase + 0
  __condEnd3df17a99_e547_45c4_986e_8ad3caabe8cc:
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 9
  ADC	__@scratchBase + 0
  STA	lowOAMBuffer + 9
  .dbg	line, "Example\example.c", 120
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	#$0000
  CMP	lowOAMBuffer + 9
  BNE	:+
  SEP	#$20
  CMP	__@signExtend
  BNE	:+
  INX
: TXA
  BEQ	__IFNOT_8a7b17b4_2b38_49b1_a1a2_8dae9890d850
  .dbg	line, "Example\example.c", 121
  .dbg	line, "Example\example.c", 122
  SEP	#$20
  LDA	#$01
  STA	main@goDown + 0
  .dbg	line, "Example\example.c", 123
  STA	lowOAMBuffer + 9
  JMP	__IFNOTELSE_8a7b17b4_2b38_49b1_a1a2_8dae9890d850
  __IFNOT_8a7b17b4_2b38_49b1_a1a2_8dae9890d850:
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 9
  CMP	#$d8
  BCC	__CMP_NO_e63dd7c1_042e_4170_96cf_e5f26533a7e8
  BNE	__CMP_YES_e63dd7c1_042e_4170_96cf_e5f26533a7e8
  JMP	__CMP_NO_e63dd7c1_042e_4170_96cf_e5f26533a7e8
  __CMP_YES_e63dd7c1_042e_4170_96cf_e5f26533a7e8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_e63dd7c1_042e_4170_96cf_e5f26533a7e8
  __CMP_NO_e63dd7c1_042e_4170_96cf_e5f26533a7e8:
  SEP	#$20
  LDA	#$00
  __CMP_END_e63dd7c1_042e_4170_96cf_e5f26533a7e8:
  BEQ	__IFNOT_53bb8434_9874_4b6e_a22c_09ce90caf7df
  .dbg	line, "Example\example.c", 126
  .dbg	line, "Example\example.c", 127
  SEP	#$20
  LDA	#$00
  STA	main@goDown + 0
  .dbg	line, "Example\example.c", 128
  LDA	#$d8
  STA	lowOAMBuffer + 9
  __IFNOT_53bb8434_9874_4b6e_a22c_09ce90caf7df:
  __IFNOTELSE_8a7b17b4_2b38_49b1_a1a2_8dae9890d850:
  .dbg	line, "Example\example.c", 130
  REP	#$20
  LDA	#.loWord(main@scoreP2Tiles)
  STA	uiToTiles@c + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP2Tiles)
  STA	uiToTiles@c + 2
  LDA	#$04
  STA	uiToTiles@n + 0
  REP	#$20
  LDA	main@scoreP2 + 0
  STA	uiToTiles@value + 0
  SEP	#$20
  LDA	main@scoreP2 + 2
  STA	uiToTiles@value + 2
  REP	#$20
  LDA	#$001e
  STA	uiToTiles@zeroTile + 0
  JSL	uiToTiles
  .dbg	line, "Example\example.c", 131
  SEP	#$10
  LDX	#$00
  SEP	#$20
  LDA	#$00
  CMP	lowOAMBuffer + 8
  BNE	:+
  INX
: TXA
  BNE	:+
  JMP	__IFNOT_2344629d_8467_4e27_b557_c76f45f62edf
  :
  .dbg	line, "Example\example.c", 132
  .dbg	line, "Example\example.c", 133
  SEP	#$20
  LDA	#$80
  STA	lowOAMBuffer + 8
  .dbg	line, "Example\example.c", 134
  STA	lowOAMBuffer + 9
  .dbg	line, "Example\example.c", 135
  LDA	#$01
  STA	main@goRight + 0
  .dbg	line, "Example\example.c", 136
  STA	main@goDown + 0
  .dbg	line, "Example\example.c", 137
  REP	#$21
  LDA	main@scoreP2 + 0
  ADC	#$0001
  STA	main@scoreP2 + 0
  SEP	#$20
  LDA	main@scoreP2 + 2
  ADC	#$00
  STA	main@scoreP2 + 2
  .dbg	line, "Example\example.c", 138
  REP	#$20
  LDA	#.loWord(main@scoreP2Tiles)
  STA	uiToTiles@c + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP2Tiles)
  STA	uiToTiles@c + 2
  LDA	#$04
  STA	uiToTiles@n + 0
  REP	#$20
  LDA	main@scoreP2 + 0
  STA	uiToTiles@value + 0
  SEP	#$20
  LDA	main@scoreP2 + 2
  STA	uiToTiles@value + 2
  REP	#$20
  LDA	#$001e
  STA	uiToTiles@zeroTile + 0
  JSL	uiToTiles
  .dbg	line, "Example\example.c", 139
  SEP	#$20
  LDA	#$01
  STA	main@refreshScores + 0
  JMP	__IFNOTELSE_2344629d_8467_4e27_b557_c76f45f62edf
  __IFNOT_2344629d_8467_4e27_b557_c76f45f62edf:
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 8
  CMP	#$f8
  BCC	__CMP_NO_fdb16cc0_2131_4452_b2a6_e564aa48303c
  BNE	__CMP_YES_fdb16cc0_2131_4452_b2a6_e564aa48303c
  JMP	__CMP_NO_fdb16cc0_2131_4452_b2a6_e564aa48303c
  __CMP_YES_fdb16cc0_2131_4452_b2a6_e564aa48303c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_fdb16cc0_2131_4452_b2a6_e564aa48303c
  __CMP_NO_fdb16cc0_2131_4452_b2a6_e564aa48303c:
  SEP	#$20
  LDA	#$00
  __CMP_END_fdb16cc0_2131_4452_b2a6_e564aa48303c:
  BNE	:+
  JMP	__IFNOT_c65747f9_45ee_463a_9c76_051df4476f70
  :
  .dbg	line, "Example\example.c", 142
  .dbg	line, "Example\example.c", 143
  SEP	#$20
  LDA	#$80
  STA	lowOAMBuffer + 8
  .dbg	line, "Example\example.c", 144
  STA	lowOAMBuffer + 9
  .dbg	line, "Example\example.c", 145
  LDA	#$00
  STA	main@goRight + 0
  .dbg	line, "Example\example.c", 146
  LDA	#$01
  STA	main@goDown + 0
  .dbg	line, "Example\example.c", 147
  REP	#$21
  LDA	main@scoreP1 + 0
  ADC	#$0001
  STA	main@scoreP1 + 0
  SEP	#$20
  LDA	main@scoreP1 + 2
  ADC	#$00
  STA	main@scoreP1 + 2
  .dbg	line, "Example\example.c", 148
  REP	#$20
  LDA	#.loWord(main@scoreP1Tiles)
  STA	uiToTiles@c + 0
  SEP	#$20
  LDA	#.bankByte(main@scoreP1Tiles)
  STA	uiToTiles@c + 2
  LDA	#$04
  STA	uiToTiles@n + 0
  REP	#$20
  LDA	main@scoreP1 + 0
  STA	uiToTiles@value + 0
  SEP	#$20
  LDA	main@scoreP1 + 2
  STA	uiToTiles@value + 2
  REP	#$20
  LDA	#$001e
  STA	uiToTiles@zeroTile + 0
  JSL	uiToTiles
  .dbg	line, "Example\example.c", 149
  SEP	#$20
  LDA	#$01
  STA	main@refreshScores + 0
  __IFNOT_c65747f9_45ee_463a_9c76_051df4476f70:
  __IFNOTELSE_2344629d_8467_4e27_b557_c76f45f62edf:
  .dbg	line, "Example\example.c", 152
  SEP	#$20
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
  SEP	#$20
  LDA	__@callResult + 0
  STA	__@scratchBase + 0
  SEP	#$10
  LDX	#$00
  LDA	__@scratchBase + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_8cfbc89d_c40c_4248_94fa_3f7a0fe184b2
  .dbg	line, "Example\example.c", 153
  .dbg	line, "Example\example.c", 154
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 0
  ADC	#$10
  STA	lowOAMBuffer + 8
  .dbg	line, "Example\example.c", 155
  LDA	#$01
  STA	main@goRight + 0
  .dbg	line, "Example\example.c", 156
  SEP	#$10
  LDX	#$00
  LDA	main@goDown + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	main@goDown + 0
  JMP	__IFNOTELSE_8cfbc89d_c40c_4248_94fa_3f7a0fe184b2
  __IFNOT_8cfbc89d_c40c_4248_94fa_3f7a0fe184b2:
  SEP	#$20
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
  SEP	#$20
  LDA	__@callResult + 0
  STA	__@scratchBase + 0
  SEP	#$10
  LDX	#$00
  LDA	__@scratchBase + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__IFNOT_7b127356_5e1c_4d26_bec1_e84b61987f61
  .dbg	line, "Example\example.c", 159
  .dbg	line, "Example\example.c", 160
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$21
  LDA	lowOAMBuffer + 4
  SBC	#$08
  STA	lowOAMBuffer + 8
  .dbg	line, "Example\example.c", 161
  LDA	#$00
  STA	main@goRight + 0
  .dbg	line, "Example\example.c", 162
  SEP	#$10
  LDX	#$00
  LDA	main@goDown + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  SEP	#$20
  STA	main@goDown + 0
  __IFNOT_7b127356_5e1c_4d26_bec1_e84b61987f61:
  __IFNOTELSE_8cfbc89d_c40c_4248_94fa_3f7a0fe184b2:
  .dbg	line, "Example\example.c", 165
  __ITER__START__5a4abacf_2f25_405b_8b22_390d2ba45c3d:
  SEP	#$10
  LDX	#$01
  SEP	#$20
  LDA	isScanning + 0
  CMP	#$00
  BNE	:+
  DEX
: TXA
  SEP	#$20
  CMP	#$00
  BNE	:+
  JMP	__ITER__END__5a4abacf_2f25_405b_8b22_390d2ba45c3d
  :
  JMP	__ITER__START__5a4abacf_2f25_405b_8b22_390d2ba45c3d
  __ITER__END__5a4abacf_2f25_405b_8b22_390d2ba45c3d:
  JMP	__ITER__START__b4e4674c_75b8_4cd6_acba_6a0bfd796bc0
  __ITER__END__b4e4674c_75b8_4cd6_acba_6a0bfd796bc0:
__main_END:
RTL	; @endfunc
; @asm imp_math\imp_float_f2u64.h
; @endasm
; @asm imp_math\imp_float_f2u64.asm
; @endasm
; @asm imp_math\imp_float_s2f64.asm
; Doubles
; @endasm
; @asm imp_math\imp_float_f2s32.h
; @endasm
; @asm imp_math\imp_float.asm
; @endasm
; @asm Example\SNES\init.asm
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
; @endasm
; @asm SNES\Graphics\colors.h
; @endasm
; @asm imp_math\imp_float_f2s64.asm
; @endasm
; @asm stdlib\stdint.h
; @endasm
; @asm imp_math\imp_float_s2f32.h
; @endasm
; @asm Resources\resources.h
; @endasm
; @asm imp_math\imp_float_f32.h
; @endasm
; @asm imp_math\imp_mult.asm
; Thanks to Sir Walrus for long div/mod code
; Multiplication
; Division
; Modulation
; @asm
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
  __ITER__START__ff259f65_8dca_4d39_bf4e_51a67933c6f2:
  REP	#$21
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
  BNE	__IFNOT_ab72ff56_589a_4529_940d_0bda9f66dd62
  JMP	__ITER__END__ff259f65_8dca_4d39_bf4e_51a67933c6f2
  __IFNOT_ab72ff56_589a_4529_940d_0bda9f66dd62:
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
  JMP	__ITER__START__ff259f65_8dca_4d39_bf4e_51a67933c6f2
  __ITER__END__ff259f65_8dca_4d39_bf4e_51a67933c6f2:
  __ITER__START__e58fbe7f_d04c_40c8_aaeb_22afce13c6dc:
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
  JMP	__ITER__END__e58fbe7f_d04c_40c8_aaeb_22afce13c6dc
  :
  REP	#$21
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
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  REP	#$21
  LDA	__div24by24@ret + 0
  ADC	__div24by24@start + 0
  STA	__div24by24@ret + 0
  SEP	#$20
  LDA	__div24by24@ret + 2
  ADC	__div24by24@start + 2
  STA	__div24by24@ret + 2
  __IFNOT_45c15b49_7329_48c8_bb76_f73433912bd8:
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
  JMP	__ITER__START__e58fbe7f_d04c_40c8_aaeb_22afce13c6dc
  __ITER__END__e58fbe7f_d04c_40c8_aaeb_22afce13c6dc:
  REP	#$20
  LDA	__div24by24@ret + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__div24by24@ret + 2
  STA	__@callResult + 2
  JMP	____div24by24_END
____div24by24_END:
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
  __ITER__START__01ace39b_5980_49de_9ae3_fcaca35223ba:
  REP	#$21
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
  BNE	__IFNOT_a72b75de_8a0c_4769_bfcb_8783302fe3ab
  JMP	__ITER__END__01ace39b_5980_49de_9ae3_fcaca35223ba
  __IFNOT_a72b75de_8a0c_4769_bfcb_8783302fe3ab:
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
  JMP	__ITER__START__01ace39b_5980_49de_9ae3_fcaca35223ba
  __ITER__END__01ace39b_5980_49de_9ae3_fcaca35223ba:
  __ITER__START__1d57d05e_e3d2_46d5_8d9e_b7f2e7c02501:
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
  JMP	__ITER__END__1d57d05e_e3d2_46d5_8d9e_b7f2e7c02501
  :
  REP	#$21
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
  LDA	__@specSubX + 0
  SBC	__@specSubY + 0
  STA	__@specSubX + 0
  SEP	#$20
  LDA	__@specSubX + 2
  SBC	__@specSubY + 2
  STA	__@specSubX + 2
  REP	#$21
  LDA	__mod24by24@ret + 0
  ADC	__mod24by24@start + 0
  STA	__mod24by24@ret + 0
  SEP	#$20
  LDA	__mod24by24@ret + 2
  ADC	__mod24by24@start + 2
  STA	__mod24by24@ret + 2
  __IFNOT_302736e2_cb46_4286_8a8f_da8ccab722a7:
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
  JMP	__ITER__START__1d57d05e_e3d2_46d5_8d9e_b7f2e7c02501
  __ITER__END__1d57d05e_e3d2_46d5_8d9e_b7f2e7c02501:
  REP	#$20
  LDA	__@specSubX + 0
  STA	__@callResult + 0
  SEP	#$20
  LDA	__@specSubX + 2
  STA	__@callResult + 2
  JMP	____mod24by24_END
____mod24by24_END:
RTL	; @endfunc
; @endasm
; @endasm
; @asm imp_math\imp_float_u2f32.asm
; @endasm
; @asm SNES\mmio.h
; @endasm
; @asm imp_math\imp_float_f2u32.asm
; @endasm
; @asm imp_math\imp_float_f64.asm
; @endasm
; @asm imp_math\imp_float.h
; @endasm
; @asm SNES\init.h
; @endasm
; @asm imp_math\imp_float_u2f32.h
; @endasm
; @asm SNES\Graphics\oam.h
; @endasm
; @asm imp_math\imp_float_s2f64.h
; @endasm
; @asm imp_math\imp_float_f2u32.h
; @endasm
; @asm imp_math\imp_float_s2f32.asm
; @endasm
; @asm imp_math\imp_mult.h
; @endasm
; @asm Example\SNES\mmio.asm
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
; @endasm
; @asm imp_math\imp_float_f2s64.h
; @endasm
; @asm imp_math\imp_float_f2s32.asm
; @endasm
; @asm SNES\cpu.h
; @endasm
; @asm SNES\Graphics\backgrounds.h
; @endasm
; @asm SNES\Graphics\ppu.h
; @endasm
; @asm SNES\controls.h
; @endasm
; @asm SNES\dma.h
; @endasm
; @asm imp_math\imp_float_f64.h
; @endasm
; @asm imp_math\imp_float_f32.asm
; @endasm
; @asm imp_math\imp_float_u2f64.asm
; @endasm
; @asm imp_math\imp_float_u2f64.h
; @endasm
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
