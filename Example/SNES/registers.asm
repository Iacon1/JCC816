; *All* Registers, for reference purposes
; https://snes.nesdev.org/wiki/MMIO_registers

; PPU - https://snes.nesdev.org/wiki/PPU_registers
INIDISP	= $002100

OBJSEL	= $002101
OAMADDL	= $002102
OAMADDH	= $002103
OAMDATA	= $002104

BGMODE	= $002105
MOSAIC	= $002106

BG1SC	= $002107
BG2SC	= $002108
BG3SC	= $002109
BG4SC	= $00210A

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

VMADDL	= $002116
VMADDH	= $002117

VMDATAL	= $002118
VMDATAH = $002119

M7SEL	= $00211A
M7A		= $00211B
M7B		= $00211C
M7C		= $00211D
M7D		= $00211F
M7Y		= $002120

CGADD	= $002121
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

DMAP0	= $004300
BBAD0	= $004301
A1T0L	= $004302
A1T0H	= $004303
A1B0	= $004304
DAS0L	= $004305
DAS0H	= $004306
DASB0	= $004307
A2A0L	= $004308
A2A0H	= $004309
NLTR0	= $00430A

DMAP1	= $004310
BBAD1	= $004311
A1T1L	= $004312
A1T1H	= $004313
A1B1	= $004314
DAS1L	= $004315
DAS1H	= $004316
DASB1	= $004317
A2A1L	= $004318
A2A1H	= $004319
NLTR1	= $00431A

DMAP1	= $004300
BBAD1	= $004301
A1T1L	= $004302
A1T1H	= $004303
A1B1	= $004304
DAS1L	= $004305
DAS1H	= $004306
DASB1	= $004307
A2A1L	= $004308
A2A1H	= $004309
NLTR1	= $00430A

DMAP2	= $004320
BBAD2	= $004321
A1T2L	= $004322
A1T2H	= $004323
A1B2	= $004324
DAS2L	= $004325
DAS2H	= $004326
DASB2	= $004327
A2A2L	= $004328
A2A2H	= $004329
NLTR2	= $00432A
