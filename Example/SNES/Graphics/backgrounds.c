// Backgrounds

#include <stdint.h>
#include "SNES/Graphics/backgrounds.h"

// Buffers for BG12NBA and BG34NBA, since they're write-only.
uint8_t bufferBG12NBA = 0x00, bufferBG34NBA = 0x00;

void setBackgroundMode(uint8_t mode, _Bool BG3Priority, _Bool largeTiles)
{
	mode |= (largeTiles ? 0xF0 : 0x00);
	if (BG3Priority) mode |= 0x08; // Set BG3 priority bit
	BGMODE = mode;
}

void setBackgroundAddress(uint8_t backgroundNo, uint16_t wordAddress, enum TilemapCount tilemapCount)
{
	// Word address is 2 bits offset from byte start, so shifting by 8 has same result as shifting by 10 and then offsetting
	BGSC[backgroundNo] = ((uint8_t) (wordAddress >> 8)) | ((uint8_t) tilemapCount);
}

void setBackgroundTileset(uint8_t backgroundNo, uint16_t wordAddress)
{
	switch (backgroundNo)
	{
	case 0: // Background 1
		bufferBG12NBA &= 0xF0;
		bufferBG12NBA |= (uint8_t) (((wordAddress) >> 8) >> 4);
		break;
	case 1: // Background 2
		bufferBG12NBA &= 0x0F;
		bufferBG12NBA |= 0xF0 & (uint8_t) ((wordAddress) >> 8); // Only need to shift 8, since we're offset by 4 anyway
		break;
	case 2: // Background 3
		bufferBG34NBA &= 0xF0;
		bufferBG34NBA |= (uint8_t) (((wordAddress) >> 8) >> 4);
		break;
	case 3: // Background 4
		bufferBG34NBA &= 0x0F;
		bufferBG34NBA |= 0xF0 & (uint8_t) ((wordAddress) >> 8); // Only need to shift 8, since we're offset by 4 anyway
		break;
	}

	BG12NBA = bufferBG12NBA;
	BG34NBA = bufferBG34NBA;
}
