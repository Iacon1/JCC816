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
__@pointerBase                    = $000065
__@scratchBase                    = $000086
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
  LDA	#$00
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
  BNE	__condSkipeeb2427f_a7bf_4cdb_9f9d_7af9b9d242a7
  REP	#$20
  LDA	#$00f0
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  STA	__@scratchBase + 2
  JMP	__condEndeeb2427f_a7bf_4cdb_9f9d_7af9b9d242a7
  __condSkipeeb2427f_a7bf_4cdb_9f9d_7af9b9d242a7:
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$20
  STA	__@scratchBase + 2
  __condEndeeb2427f_a7bf_4cdb_9f9d_7af9b9d242a7:
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
  BNE	__IFNOT_3d9d3f27_8676_4e87_b79e_861c6acf371a
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 12
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setBackgroundMode@mode + 0
  ORA	#$08
  STA	setBackgroundMode@mode + 0
  __IFNOT_3d9d3f27_8676_4e87_b79e_861c6acf371a:
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
  STA	__@scratchBase + 0
  LDA	setBackgroundAddress@wordAddress + 1
  STA	__@scratchBase + 1
  LDA	setBackgroundAddress@tilemapCount + 0
  ORA	__@scratchBase + 1
  SEP	#$10
  LDX	__@scratchBase + 0
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
  JMP	(__SWITCH_TABLE_0bbb8de6_a673_45cd_add8_0256dccf12a7,x)
  :
  JMP	__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_DEF
  __SWITCH_TABLE_0bbb8de6_a673_45cd_add8_0256dccf12a7:
    .word	.LoWord(__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_0)
    .word	.LoWord(__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_1)
    .word	.LoWord(__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_2)
    .word	.LoWord(__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_3)
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 26
__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_0:
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
  JMP	__CASE_SKIP_0bbb8de6_a673_45cd_add8_0256dccf12a7
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 30
__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_1:
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
  JMP	__CASE_SKIP_0bbb8de6_a673_45cd_add8_0256dccf12a7
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 34
__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_2:
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
  JMP	__CASE_SKIP_0bbb8de6_a673_45cd_add8_0256dccf12a7
  .dbg	line, "Example\SNES\Graphics\backgrounds.c", 38
__CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_3:
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
  JMP	__CASE_SKIP_0bbb8de6_a673_45cd_add8_0256dccf12a7
  __CASE_0bbb8de6_a673_45cd_add8_0256dccf12a7_DEF:
  __CASE_SKIP_0bbb8de6_a673_45cd_add8_0256dccf12a7:
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
  STA	__@scratchBase + 0
  SEP	#$10
  LDX	__@scratchBase + 0
  LDA	highOAMBuffer + 0,X
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 30
  LDA	setHighOAMProperties@j + 0
  STA	__@scratchBase + 1
  CMP	#$04
  BCS	:+
  SEP	#$20
  LDA	__@scratchBase + 1
  ASL
  STA	__@scratchBase + 1
  TAX
  JMP	(__SWITCH_TABLE_af3bfd1f_1120_490f_9d17_6fd4daac4a82,x)
  :
  JMP	__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_DEF
  __SWITCH_TABLE_af3bfd1f_1120_490f_9d17_6fd4daac4a82:
    .word	.LoWord(__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_0)
    .word	.LoWord(__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_1)
    .word	.LoWord(__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_2)
    .word	.LoWord(__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_3)
  .dbg	line, "Example\SNES\Graphics\oam.c", 32
__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_0:
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
  STA	__@scratchBase + 5
  REP	#$20
  LDA	__@signExtend
  ROL
  STA	__@scratchBase + 6
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
  ORA	__@scratchBase + 5
  STA	__@scratchBase + 2
  REP	#$20
  LDA	__@signExtend
  ORA	__@scratchBase + 6
  STA	__@scratchBase + 3
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  ORA	__@scratchBase + 2
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 35
  JMP	__CASE_SKIP_af3bfd1f_1120_490f_9d17_6fd4daac4a82
  .dbg	line, "Example\SNES\Graphics\oam.c", 36
__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_1:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  AND	#$f3
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 38
  LDA	setHighOAMProperties@xShift + 0
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 6
  REP	#$10
  LDA	#$0002
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 5
    ASL
    STA	__@scratchBase + 5
    SEP	#$20
    LDA	__@scratchBase + 7
    ROL
    STA	__@scratchBase + 7
    DEX
  BNE	:-
  SEP	#$20
  LDA	setHighOAMProperties@largeSprite + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 9
  REP	#$10
  LDA	#$0003
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 8
    ASL
    STA	__@scratchBase + 8
    SEP	#$20
    LDA	__@scratchBase + 10
    ROL
    STA	__@scratchBase + 10
    DEX
  BNE	:-
  REP	#$20
  LDA	__@scratchBase + 5
  ORA	__@scratchBase + 8
  STA	__@scratchBase + 2
  SEP	#$20
  LDA	__@scratchBase + 7
  ORA	__@scratchBase + 10
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  ORA	__@scratchBase + 2
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 39
  JMP	__CASE_SKIP_af3bfd1f_1120_490f_9d17_6fd4daac4a82
  .dbg	line, "Example\SNES\Graphics\oam.c", 40
__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_2:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  AND	#$cf
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 42
  LDA	setHighOAMProperties@xShift + 0
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 6
  REP	#$10
  LDA	#$0004
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 5
    ASL
    STA	__@scratchBase + 5
    SEP	#$20
    LDA	__@scratchBase + 7
    ROL
    STA	__@scratchBase + 7
    DEX
  BNE	:-
  SEP	#$20
  LDA	setHighOAMProperties@largeSprite + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 9
  REP	#$10
  LDA	#$0005
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 8
    ASL
    STA	__@scratchBase + 8
    SEP	#$20
    LDA	__@scratchBase + 10
    ROL
    STA	__@scratchBase + 10
    DEX
  BNE	:-
  REP	#$20
  LDA	__@scratchBase + 5
  ORA	__@scratchBase + 8
  STA	__@scratchBase + 2
  SEP	#$20
  LDA	__@scratchBase + 7
  ORA	__@scratchBase + 10
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  ORA	__@scratchBase + 2
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 43
  JMP	__CASE_SKIP_af3bfd1f_1120_490f_9d17_6fd4daac4a82
  .dbg	line, "Example\SNES\Graphics\oam.c", 44
__CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_3:
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  AND	#$f3
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 46
  LDA	setHighOAMProperties@xShift + 0
  STA	__@scratchBase + 5
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 6
  REP	#$10
  LDA	#$0006
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 5
    ASL
    STA	__@scratchBase + 5
    SEP	#$20
    LDA	__@scratchBase + 7
    ROL
    STA	__@scratchBase + 7
    DEX
  BNE	:-
  SEP	#$20
  LDA	setHighOAMProperties@largeSprite + 0
  STA	__@scratchBase + 8
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 9
  REP	#$10
  LDA	#$0007
  TAX
  :
    REP	#$21
    LDA	__@scratchBase + 8
    ASL
    STA	__@scratchBase + 8
    SEP	#$20
    LDA	__@scratchBase + 10
    ROL
    STA	__@scratchBase + 10
    DEX
  BNE	:-
  REP	#$20
  LDA	__@scratchBase + 5
  ORA	__@scratchBase + 8
  STA	__@scratchBase + 2
  SEP	#$20
  LDA	__@scratchBase + 7
  ORA	__@scratchBase + 10
  STA	__@scratchBase + 4
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	setHighOAMProperties@b + 0
  ORA	__@scratchBase + 2
  STA	setHighOAMProperties@b + 0
  .dbg	line, "Example\SNES\Graphics\oam.c", 47
  JMP	__CASE_SKIP_af3bfd1f_1120_490f_9d17_6fd4daac4a82
  __CASE_af3bfd1f_1120_490f_9d17_6fd4daac4a82_DEF:
  __CASE_SKIP_af3bfd1f_1120_490f_9d17_6fd4daac4a82:
  .dbg	line, "Example\SNES\Graphics\oam.c", 49
  SEP	#$20
  LDA	setHighOAMProperties@i + 0
  STA	__@scratchBase + 1
  LDA	setHighOAMProperties@b + 0
  SEP	#$10
  LDX	__@scratchBase + 1
  STA	highOAMBuffer + 0,X
__setHighOAMProperties_END:
RTL	; @endfunc
clearOAMBuffers:	; @func void()
  .dbg	line, "Example\SNES\Graphics\oam.c", 11
  .dbg	line, "Example\SNES\Graphics\oam.c", 12
  SEP	#$20
  LDA	#$00
  STA	clearOAMBuffers@i + 0
  __ITER__START__4c2cb414_d79d_445c_ae2d_afd5ad17b4b5:
  REP	#$21
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  EOR	#$8000
  CMP	#$8000
  BCC	__CMP_YES_42dc113c_5ec1_4be0_b4a6_553c5680773d
  BNE	__CMP_NO_42dc113c_5ec1_4be0_b4a6_553c5680773d
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  CMP	#$80
  BCC	__CMP_YES_42dc113c_5ec1_4be0_b4a6_553c5680773d
  BNE	__CMP_NO_42dc113c_5ec1_4be0_b4a6_553c5680773d
  JMP	__CMP_NO_42dc113c_5ec1_4be0_b4a6_553c5680773d
  __CMP_YES_42dc113c_5ec1_4be0_b4a6_553c5680773d:
  REP	#$20
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_42dc113c_5ec1_4be0_b4a6_553c5680773d
  __CMP_NO_42dc113c_5ec1_4be0_b4a6_553c5680773d:
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$20
  STA	__@scratchBase + 2
  __CMP_END_42dc113c_5ec1_4be0_b4a6_553c5680773d:
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
  JMP	__ITER__END__4c2cb414_d79d_445c_ae2d_afd5ad17b4b5
  :
  .dbg	line, "Example\SNES\Graphics\oam.c", 14
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 2
  LDA	__@signExtend
  STA	__@scratchBase + 3
  REP	#$20
  LDA	__@scratchBase + 2
  ASL
  ASL
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  REP	#$10
  LDX	__@scratchBase + 0
  STA	lowOAMBuffer + 0,X
  .dbg	line, "Example\SNES\Graphics\oam.c", 15
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 4
  LDA	__@signExtend
  STA	__@scratchBase + 5
  REP	#$20
  LDA	__@scratchBase + 4
  ASL
  ASL
  STA	__@scratchBase + 2
  SEP	#$20
  LDA	#$00
  LDX	__@scratchBase + 2
  STA	lowOAMBuffer + 0,X
  .dbg	line, "Example\SNES\Graphics\oam.c", 16
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 6
  LDA	__@signExtend
  STA	__@scratchBase + 7
  REP	#$20
  LDA	__@scratchBase + 6
  ASL
  ASL
  STA	__@scratchBase + 4
  SEP	#$20
  LDA	#$00
  LDX	__@scratchBase + 4
  STA	lowOAMBuffer + 0,X
  .dbg	line, "Example\SNES\Graphics\oam.c", 17
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 8
  LDA	__@signExtend
  STA	__@scratchBase + 9
  REP	#$20
  LDA	__@scratchBase + 8
  ASL
  ASL
  STA	__@scratchBase + 6
  SEP	#$20
  LDA	#$00
  LDX	__@scratchBase + 6
  STA	lowOAMBuffer + 0,X
  __ITER__ITER__4c2cb414_d79d_445c_ae2d_afd5ad17b4b5:
  CLC
  LDA	clearOAMBuffers@i + 0
  ADC	#$01
  STA	clearOAMBuffers@i + 0
  JMP	__ITER__START__4c2cb414_d79d_445c_ae2d_afd5ad17b4b5
  __ITER__END__4c2cb414_d79d_445c_ae2d_afd5ad17b4b5:
  .dbg	line, "Example\SNES\Graphics\oam.c", 19
  SEP	#$20
  LDA	#$00
  STA	clearOAMBuffers@i + 0
  __ITER__START__f359e873_1e79_4774_a1d8_3a7ef1819bc9:
  REP	#$21
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  EOR	#$8000
  CMP	#$8000
  BCC	__CMP_YES_f542b6a2_0701_42c3_a2ff_1514af4f0b4f
  BNE	__CMP_NO_f542b6a2_0701_42c3_a2ff_1514af4f0b4f
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  CMP	#$20
  BCC	__CMP_YES_f542b6a2_0701_42c3_a2ff_1514af4f0b4f
  BNE	__CMP_NO_f542b6a2_0701_42c3_a2ff_1514af4f0b4f
  JMP	__CMP_NO_f542b6a2_0701_42c3_a2ff_1514af4f0b4f
  __CMP_YES_f542b6a2_0701_42c3_a2ff_1514af4f0b4f:
  REP	#$20
  LDA	#$0001
  STA	__@scratchBase + 8
  SEP	#$20
  LDA	#$00
  STA	__@scratchBase + 10
  BRA	__CMP_END_f542b6a2_0701_42c3_a2ff_1514af4f0b4f
  __CMP_NO_f542b6a2_0701_42c3_a2ff_1514af4f0b4f:
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 8
  SEP	#$20
  STA	__@scratchBase + 10
  __CMP_END_f542b6a2_0701_42c3_a2ff_1514af4f0b4f:
  SEP	#$10
  LDX	#$00
  REP	#$20
  LDA	__@scratchBase + 8
  CMP	#$0000
  BNE	:+
  SEP	#$20
  LDA	__@scratchBase + 10
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__ITER__END__f359e873_1e79_4774_a1d8_3a7ef1819bc9
  .dbg	line, "Example\SNES\Graphics\oam.c", 21
  SEP	#$20
  LDA	clearOAMBuffers@i + 0
  STA	__@scratchBase + 8
  LDA	#$55
  SEP	#$10
  LDX	__@scratchBase + 8
  STA	highOAMBuffer + 0,X
  __ITER__ITER__f359e873_1e79_4774_a1d8_3a7ef1819bc9:
  CLC
  LDA	clearOAMBuffers@i + 0
  ADC	#$01
  STA	clearOAMBuffers@i + 0
  JMP	__ITER__START__f359e873_1e79_4774_a1d8_3a7ef1819bc9
  __ITER__END__f359e873_1e79_4774_a1d8_3a7ef1819bc9:
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
  LDA	#$00
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
  BCC	__CMP_NO_6114a31b_0b1b_4e4f_821f_548c1868cd5c
  BNE	__CMP_YES_6114a31b_0b1b_4e4f_821f_548c1868cd5c
  JMP	__CMP_YES_6114a31b_0b1b_4e4f_821f_548c1868cd5c
  __CMP_YES_6114a31b_0b1b_4e4f_821f_548c1868cd5c:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_6114a31b_0b1b_4e4f_821f_548c1868cd5c
  __CMP_NO_6114a31b_0b1b_4e4f_821f_548c1868cd5c:
  SEP	#$20
  LDA	#$00
  __CMP_END_6114a31b_0b1b_4e4f_821f_548c1868cd5c:
  BEQ	__IFNOT_d75a0403_d68d_41cd_bc4b_543d3c715e2f
  .dbg	line, "Example\example.c", 22
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 0
  JMP	__isColliding_END
  __IFNOT_d75a0403_d68d_41cd_bc4b_543d3c715e2f:
  .dbg	line, "Example\example.c", 23
  CLC
  SEP	#$20
  LDA	isColliding@x1 + 0
  ADC	isColliding@w1 + 0
  STA	__@scratchBase + 0
  CLC
  LDA	__@scratchBase + 0
  CMP	isColliding@x2 + 0
  BCC	__CMP_YES_501b3680_b65c_4acf_9344_d4d18c2d1334
  BNE	__CMP_NO_501b3680_b65c_4acf_9344_d4d18c2d1334
  JMP	__CMP_YES_501b3680_b65c_4acf_9344_d4d18c2d1334
  __CMP_YES_501b3680_b65c_4acf_9344_d4d18c2d1334:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_501b3680_b65c_4acf_9344_d4d18c2d1334
  __CMP_NO_501b3680_b65c_4acf_9344_d4d18c2d1334:
  SEP	#$20
  LDA	#$00
  __CMP_END_501b3680_b65c_4acf_9344_d4d18c2d1334:
  BEQ	__IFNOT_4957315a_615f_4115_ad6a_ffdd09714364
  .dbg	line, "Example\example.c", 23
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 0
  JMP	__isColliding_END
  __IFNOT_4957315a_615f_4115_ad6a_ffdd09714364:
  .dbg	line, "Example\example.c", 24
  CLC
  SEP	#$20
  LDA	isColliding@y2 + 0
  ADC	isColliding@h2 + 0
  STA	__@scratchBase + 0
  CLC
  LDA	isColliding@y1 + 0
  CMP	__@scratchBase + 0
  BCC	__CMP_NO_97c7a3d5_6d75_4038_9f70_45b5e57fec54
  BNE	__CMP_YES_97c7a3d5_6d75_4038_9f70_45b5e57fec54
  JMP	__CMP_YES_97c7a3d5_6d75_4038_9f70_45b5e57fec54
  __CMP_YES_97c7a3d5_6d75_4038_9f70_45b5e57fec54:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_97c7a3d5_6d75_4038_9f70_45b5e57fec54
  __CMP_NO_97c7a3d5_6d75_4038_9f70_45b5e57fec54:
  SEP	#$20
  LDA	#$00
  __CMP_END_97c7a3d5_6d75_4038_9f70_45b5e57fec54:
  BEQ	__IFNOT_92b9ec90_bb4b_4f69_b165_1376dd979575
  .dbg	line, "Example\example.c", 24
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 0
  JMP	__isColliding_END
  __IFNOT_92b9ec90_bb4b_4f69_b165_1376dd979575:
  .dbg	line, "Example\example.c", 25
  CLC
  SEP	#$20
  LDA	isColliding@y1 + 0
  ADC	isColliding@h1 + 0
  STA	__@scratchBase + 0
  CLC
  LDA	__@scratchBase + 0
  CMP	isColliding@y2 + 0
  BCC	__CMP_YES_12ea8818_6197_4987_b149_80f0079800d8
  BNE	__CMP_NO_12ea8818_6197_4987_b149_80f0079800d8
  JMP	__CMP_YES_12ea8818_6197_4987_b149_80f0079800d8
  __CMP_YES_12ea8818_6197_4987_b149_80f0079800d8:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_12ea8818_6197_4987_b149_80f0079800d8
  __CMP_NO_12ea8818_6197_4987_b149_80f0079800d8:
  SEP	#$20
  LDA	#$00
  __CMP_END_12ea8818_6197_4987_b149_80f0079800d8:
  BEQ	__IFNOT_a72c4c87_56c2_49f3_af7f_6d24cca78c0c
  .dbg	line, "Example\example.c", 25
  SEP	#$20
  LDA	#$00
  STA	__@callResult + 0
  JMP	__isColliding_END
  __IFNOT_a72c4c87_56c2_49f3_af7f_6d24cca78c0c:
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
  __ITER__START__d525a5d3_2b40_4ad7_a1c8_4b4d718e3a00:
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
  BCC	__CMP_NO_8047e419_618a_4256_bf92_ce523f56fe56
  BNE	__CMP_YES_8047e419_618a_4256_bf92_ce523f56fe56
  REP	#$20
  LDA	uiToTiles@i + 0
  CMP	#$0000
  BCC	__CMP_NO_8047e419_618a_4256_bf92_ce523f56fe56
  BNE	__CMP_YES_8047e419_618a_4256_bf92_ce523f56fe56
  JMP	__CMP_YES_8047e419_618a_4256_bf92_ce523f56fe56
  __CMP_YES_8047e419_618a_4256_bf92_ce523f56fe56:
  REP	#$20
  LDA	#$0001
  STA	__@scratchBase + 0
  SEP	#$20
  LDA	#$00
  STA	__@scratchBase + 2
  BRA	__CMP_END_8047e419_618a_4256_bf92_ce523f56fe56
  __CMP_NO_8047e419_618a_4256_bf92_ce523f56fe56:
  REP	#$20
  LDA	#$0000
  STA	__@scratchBase + 0
  SEP	#$20
  STA	__@scratchBase + 2
  __CMP_END_8047e419_618a_4256_bf92_ce523f56fe56:
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
  JMP	__ITER__END__d525a5d3_2b40_4ad7_a1c8_4b4d718e3a00
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
  REP	#$20
  LDA	__@scratchBase + 0
  STA	__@scratchBase + 3
  SEP	#$20
  LDA	__@scratchBase + 2
  STA	__@scratchBase + 5
  REP	#$21
  LDA	uiToTiles@x + 0
  ADC	uiToTiles@zeroTile + 0
  SEP	#$10
  LDY	#$0000
  STA	[__@scratchBase + 3],y
  __ITER__ITER__d525a5d3_2b40_4ad7_a1c8_4b4d718e3a00:
  SEC
  REP	#$20
  LDA	uiToTiles@i + 0
  SBC	#$0001
  STA	uiToTiles@i + 0
  JMP	__ITER__START__d525a5d3_2b40_4ad7_a1c8_4b4d718e3a00
  __ITER__END__d525a5d3_2b40_4ad7_a1c8_4b4d718e3a00:
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
  __ITER__START__061fcab2_6639_4df6_84fa_cc239106ed1c:
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
  JMP	__IFNOT_c930d35f_b7f6_4654_b468_c38034b2374d
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
  __IFNOT_c930d35f_b7f6_4654_b468_c38034b2374d:
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
  BEQ	__SKIPb7e1cac7_f114_45f8_9b88_5d5e2f102e71
  REP	#$21
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  EOR	#$8000
  CMP	#$8000
  BCC	__CMP_NO_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943
  BNE	__CMP_YES_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943
  SEP	#$20
  LDA	lowOAMBuffer + 1
  CMP	#$00
  BCC	__CMP_NO_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943
  BNE	__CMP_YES_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943
  JMP	__CMP_NO_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943
  __CMP_YES_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943
  __CMP_NO_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943:
  SEP	#$20
  LDA	#$00
  __CMP_END_1f9cd1cd_f5c9_4c75_b6f8_7f7ad047e943:
  SEP	#$20
  STA	__@scratchBase + 1
  __SKIPb7e1cac7_f114_45f8_9b88_5d5e2f102e71:
  LDA	__@scratchBase + 0
  AND	__@scratchBase + 1
  BEQ	__IFNOT_e525a09f_bd7f_4c76_b100_bb6a8f56fa31
  .dbg	line, "Example\example.c", 108
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$21
  LDA	lowOAMBuffer + 1
  SBC	#$01
  STA	lowOAMBuffer + 1
  JMP	__IFNOTELSE_e525a09f_bd7f_4c76_b100_bb6a8f56fa31
  __IFNOT_e525a09f_bd7f_4c76_b100_bb6a8f56fa31:
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
  BEQ	__SKIP0e922aa8_512f_4b7b_8e0e_be341bdc6cbe
  CLC
  LDA	lowOAMBuffer + 1
  CMP	#$d0
  BCC	__CMP_YES_288273c4_6db3_4199_835c_aeb111f8981d
  BNE	__CMP_NO_288273c4_6db3_4199_835c_aeb111f8981d
  JMP	__CMP_NO_288273c4_6db3_4199_835c_aeb111f8981d
  __CMP_YES_288273c4_6db3_4199_835c_aeb111f8981d:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_288273c4_6db3_4199_835c_aeb111f8981d
  __CMP_NO_288273c4_6db3_4199_835c_aeb111f8981d:
  SEP	#$20
  LDA	#$00
  __CMP_END_288273c4_6db3_4199_835c_aeb111f8981d:
  SEP	#$20
  STA	__@scratchBase + 1
  __SKIP0e922aa8_512f_4b7b_8e0e_be341bdc6cbe:
  LDA	__@scratchBase + 0
  AND	__@scratchBase + 1
  BEQ	__IFNOT_79b7ee13_0c4c_499d_871a_be2e67c62f7a
  .dbg	line, "Example\example.c", 110
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 1
  ADC	#$01
  STA	lowOAMBuffer + 1
  __IFNOT_79b7ee13_0c4c_499d_871a_be2e67c62f7a:
  __IFNOTELSE_e525a09f_bd7f_4c76_b100_bb6a8f56fa31:
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
  BEQ	__SKIP7619551c_87b5_4af9_b964_d3deb72d016f
  REP	#$21
  LDA	#$0000
  STA	__@signExtend
  LDA	__@signExtend
  EOR	#$8000
  CMP	#$8000
  BCC	__CMP_NO_612a3168_6aae_4345_a7b4_dff22a1e310a
  BNE	__CMP_YES_612a3168_6aae_4345_a7b4_dff22a1e310a
  SEP	#$20
  LDA	lowOAMBuffer + 5
  CMP	#$00
  BCC	__CMP_NO_612a3168_6aae_4345_a7b4_dff22a1e310a
  BNE	__CMP_YES_612a3168_6aae_4345_a7b4_dff22a1e310a
  JMP	__CMP_NO_612a3168_6aae_4345_a7b4_dff22a1e310a
  __CMP_YES_612a3168_6aae_4345_a7b4_dff22a1e310a:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_612a3168_6aae_4345_a7b4_dff22a1e310a
  __CMP_NO_612a3168_6aae_4345_a7b4_dff22a1e310a:
  SEP	#$20
  LDA	#$00
  __CMP_END_612a3168_6aae_4345_a7b4_dff22a1e310a:
  SEP	#$20
  STA	__@scratchBase + 1
  __SKIP7619551c_87b5_4af9_b964_d3deb72d016f:
  LDA	__@scratchBase + 0
  AND	__@scratchBase + 1
  BEQ	__IFNOT_adeefbba_f7db_4703_aa5b_4ea5f0bb67c1
  .dbg	line, "Example\example.c", 113
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  SEP	#$21
  LDA	lowOAMBuffer + 5
  SBC	#$01
  STA	lowOAMBuffer + 5
  JMP	__IFNOTELSE_adeefbba_f7db_4703_aa5b_4ea5f0bb67c1
  __IFNOT_adeefbba_f7db_4703_aa5b_4ea5f0bb67c1:
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
  BEQ	__SKIP19f577cf_d214_4cf6_8ae1_26adb40c5efb
  CLC
  LDA	lowOAMBuffer + 5
  CMP	#$d0
  BCC	__CMP_YES_ed3743f5_3604_4285_afb4_89fc0a5f3046
  BNE	__CMP_NO_ed3743f5_3604_4285_afb4_89fc0a5f3046
  JMP	__CMP_NO_ed3743f5_3604_4285_afb4_89fc0a5f3046
  __CMP_YES_ed3743f5_3604_4285_afb4_89fc0a5f3046:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_ed3743f5_3604_4285_afb4_89fc0a5f3046
  __CMP_NO_ed3743f5_3604_4285_afb4_89fc0a5f3046:
  SEP	#$20
  LDA	#$00
  __CMP_END_ed3743f5_3604_4285_afb4_89fc0a5f3046:
  SEP	#$20
  STA	__@scratchBase + 1
  __SKIP19f577cf_d214_4cf6_8ae1_26adb40c5efb:
  LDA	__@scratchBase + 0
  AND	__@scratchBase + 1
  BEQ	__IFNOT_1c8193d4_0587_41a4_b5b5_5414c6f9f56c
  .dbg	line, "Example\example.c", 115
  REP	#$20
  LDA	#$0000
  STA	__@signExtend
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 5
  ADC	#$01
  STA	lowOAMBuffer + 5
  __IFNOT_1c8193d4_0587_41a4_b5b5_5414c6f9f56c:
  __IFNOTELSE_adeefbba_f7db_4703_aa5b_4ea5f0bb67c1:
  .dbg	line, "Example\example.c", 117
  SEP	#$10
  LDX	#$00
  SEP	#$20
  LDA	main@goRight + 0
  CMP	#$00
  BNE	:+
  INX
: TXA
  BNE	__condSkipcf976aa3_d13b_47f4_9bc6_c18bb8ce8750
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
  JMP	__condEndcf976aa3_d13b_47f4_9bc6_c18bb8ce8750
  __condSkipcf976aa3_d13b_47f4_9bc6_c18bb8ce8750:
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
  __condEndcf976aa3_d13b_47f4_9bc6_c18bb8ce8750:
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
  BNE	__condSkip3eba96f9_b4f9_4dcf_b2a8_176f6638b506
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
  JMP	__condEnd3eba96f9_b4f9_4dcf_b2a8_176f6638b506
  __condSkip3eba96f9_b4f9_4dcf_b2a8_176f6638b506:
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
  __condEnd3eba96f9_b4f9_4dcf_b2a8_176f6638b506:
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
  BEQ	__IFNOT_fdb1b753_d33a_46a2_976d_95192baf4683
  .dbg	line, "Example\example.c", 121
  .dbg	line, "Example\example.c", 122
  SEP	#$20
  LDA	#$01
  STA	main@goDown + 0
  .dbg	line, "Example\example.c", 123
  STA	lowOAMBuffer + 9
  JMP	__IFNOTELSE_fdb1b753_d33a_46a2_976d_95192baf4683
  __IFNOT_fdb1b753_d33a_46a2_976d_95192baf4683:
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 9
  CMP	#$d8
  BCC	__CMP_NO_f9661c5d_8db6_46b8_8c11_ef7efebd4a38
  BNE	__CMP_YES_f9661c5d_8db6_46b8_8c11_ef7efebd4a38
  JMP	__CMP_NO_f9661c5d_8db6_46b8_8c11_ef7efebd4a38
  __CMP_YES_f9661c5d_8db6_46b8_8c11_ef7efebd4a38:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f9661c5d_8db6_46b8_8c11_ef7efebd4a38
  __CMP_NO_f9661c5d_8db6_46b8_8c11_ef7efebd4a38:
  SEP	#$20
  LDA	#$00
  __CMP_END_f9661c5d_8db6_46b8_8c11_ef7efebd4a38:
  BEQ	__IFNOT_215744c1_014b_4a50_85c6_722b87ffbf56
  .dbg	line, "Example\example.c", 126
  .dbg	line, "Example\example.c", 127
  SEP	#$20
  LDA	#$00
  STA	main@goDown + 0
  .dbg	line, "Example\example.c", 128
  LDA	#$d8
  STA	lowOAMBuffer + 9
  __IFNOT_215744c1_014b_4a50_85c6_722b87ffbf56:
  __IFNOTELSE_fdb1b753_d33a_46a2_976d_95192baf4683:
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
  JMP	__IFNOT_21049a54_0045_4d26_855b_9b8f7dc2d885
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
  JMP	__IFNOTELSE_21049a54_0045_4d26_855b_9b8f7dc2d885
  __IFNOT_21049a54_0045_4d26_855b_9b8f7dc2d885:
  CLC
  SEP	#$20
  LDA	lowOAMBuffer + 8
  CMP	#$f8
  BCC	__CMP_NO_f78e0c95_9e99_4cc4_adee_23d6107aadc6
  BNE	__CMP_YES_f78e0c95_9e99_4cc4_adee_23d6107aadc6
  JMP	__CMP_NO_f78e0c95_9e99_4cc4_adee_23d6107aadc6
  __CMP_YES_f78e0c95_9e99_4cc4_adee_23d6107aadc6:
  SEP	#$20
  LDA	#$01
  BRA	__CMP_END_f78e0c95_9e99_4cc4_adee_23d6107aadc6
  __CMP_NO_f78e0c95_9e99_4cc4_adee_23d6107aadc6:
  SEP	#$20
  LDA	#$00
  __CMP_END_f78e0c95_9e99_4cc4_adee_23d6107aadc6:
  BNE	:+
  JMP	__IFNOT_5f88cabb_91bd_454b_8e3c_f286cc8a05a6
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
  __IFNOT_5f88cabb_91bd_454b_8e3c_f286cc8a05a6:
  __IFNOTELSE_21049a54_0045_4d26_855b_9b8f7dc2d885:
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
  BNE	__IFNOT_b638758f_74d2_4494_a170_fff5b79b7f8e
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
  JMP	__IFNOTELSE_b638758f_74d2_4494_a170_fff5b79b7f8e
  __IFNOT_b638758f_74d2_4494_a170_fff5b79b7f8e:
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
  BNE	__IFNOT_67a24b9b_fb2c_484b_a8f5_a04aadd76d72
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
  __IFNOT_67a24b9b_fb2c_484b_a8f5_a04aadd76d72:
  __IFNOTELSE_b638758f_74d2_4494_a170_fff5b79b7f8e:
  .dbg	line, "Example\example.c", 165
  __ITER__START__c3557b19_83be_4433_bc30_b886bfe0bac3:
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
  JMP	__ITER__END__c3557b19_83be_4433_bc30_b886bfe0bac3
  :
  JMP	__ITER__START__c3557b19_83be_4433_bc30_b886bfe0bac3
  __ITER__END__c3557b19_83be_4433_bc30_b886bfe0bac3:
  JMP	__ITER__START__061fcab2_6639_4df6_84fa_cc239106ed1c
  __ITER__END__061fcab2_6639_4df6_84fa_cc239106ed1c:
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
; Thanks Sir Walrus
; Multiplication
; Division
; Modulation
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
  REP	#$21
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
  REP	#$21
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
  REP	#$21
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
  REP	#$21
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
  REP	#$21
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
  REP	#$21
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
