// OAM data https://snes.nesdev.org/wiki/Sprites

#include "SNES/Graphics/oam.h"
#include "SNES/dma.h"

struct LowOAMObj lowOAMBuffer[128];
uint8_t highOAMBuffer[32];

void clearOAMBuffers()
{
	uint8_t i;
	for (i = 0; i < 128; ++i)
	{
		lowOAMBuffer[i].x = 0;
		lowOAMBuffer[i].y = 0;
		lowOAMBuffer[i].lowTileNo = 0;
		lowOAMBuffer[i].properties = 0;
	}
	for (i = 0; i < 32; ++i)
	{
		highOAMBuffer[i] = 0x55; // Move all of them offscreen
	}
}

void setHighOAMProperties(uint8_t i, _Bool xShift, _Bool largeSprite)
{
	uint8_t j = i & 0x03; // Last four bits
	i = i >> 2; // 128 / 32 = 4, so div. by 4 to get proper index
	uint8_t b = highOAMBuffer[i];
	switch (j)
	{
	case 0:
		b &= ~0x03; // Clear bits 0 & 1
		b |= (largeSprite << 1) | xShift;
		break;
	case 1:
		b &= ~0x0C; // Clear bits 2 & 3
		b |= (largeSprite << 3) | (xShift << 2);
		break;
	case 2:
		b &= ~0x30; // Clear bits 4 & 5
		b |= (largeSprite << 5) | (xShift << 4);
		break;
	case 3:
		b &= ~0x0C; // Clear bits 6 & 7
		b |= (largeSprite << 7) | (xShift << 6);
		break;
	}
	highOAMBuffer[i] = b;
}

void updateOAM()
{
	DMACHN[0].DMAP = DMATransferOneTwice; // Set to write mode compatible with OAM
	OAMADDL = 0;
	OAMADDH = 0; // Access low table
	DMACHN[0].writeAddr = (uint24_t) &OAMDATA; // Which address on the B-bus do we write to
	DMACHN[0].sourceAddr = (uint24_t) lowOAMBuffer;
	DMACHN[0].byteCount = 512; // 512 bytes
	MDMAEN = 0x01;

	DMACHN[0].sourceAddr = (uint24_t) highOAMBuffer;
	DMACHN[0].byteCount = 32; // 32 bytes
	MDMAEN = 0x01;
}
