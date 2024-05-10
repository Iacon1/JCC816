// OAM data https://snes.nesdev.org/wiki/Sprites

#include <stdint.h>
#include "SNES/mmio.h"

enum SpriteSize
{
	spriteSize_8x8_16x16,
	spriteSize_8x8_32x32,
	spriteSize_8x8_64x64,
	spriteSize_16x16_32x32,
	spriteSize_16x16_64x64,
	spriteSize_32x32_64x64,
	spriteSize_16x32_32x64,
	spriteSize_16x32_32x32,
};

extern uint8_t OBJSEL; // SSSN NbBB S = sprite size, N = name select, B = name address
extern uint8_t OAMADDL;
extern uint8_t OAMADDH;
extern __WOTWICE uint16_t OAMDATA;

enum LowOAMFlag
{
	lowOAMFlag_NameTable0 = 0x00,
	lowOAMFlag_NameTable1 = 0x01,
	lowOAMFlag_Palette00 = 0x00,
	lowOAMFlag_Palette01 = 0x02,
	lowOAMFlag_Palette02 = 0x04,
	lowOAMFlag_Palette03 = 0x06,
	lowOAMFlag_Palette04 = 0x08,
	lowOAMFlag_Palette05 = 0x0A,
	lowOAMFlag_Palette06 = 0x0C,
	lowOAMFlag_Palette07 = 0x0E,
	lowOAMFlag_Priority0 = 0x00,
	lowOAMFlag_Priority1 = 0x10,
	lowOAMFlag_Priority2 = 0x20,
	lowOAMFlag_Priority3 = 0x30,
	lowOAMFlag_HFlip = 0x40,
	lowOAMFlag_VFlip = 0x80,
};

struct LowOAMObj
{
	uint8_t x;
	uint8_t y;
	uint8_t lowTileNo;
	uint8_t properties; // VHPP CCCt V = Vertical flip, H = horizontal flip, PP = priority, CCC = palette, t = name select
};

extern struct LowOAMObj lowOAMBuffer[128];
extern uint8_t highOAMBuffer[32]; // DdCcBbAa - a = sprite i left shift x, A = sprite i size, etc.

void setHighOAMProperties(uint8_t i, _Bool xShift, _Bool largeSprite);
void clearOAMBuffers();
void updateOAM();
