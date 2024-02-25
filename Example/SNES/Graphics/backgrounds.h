// Backgrounds
// https://snes.nesdev.org/wiki/Backgrounds

#include <stdint.h>
#include "SNES/mmio.h"

extern uint8_t BGMODE;
extern uint8_t BGSC[4];
extern uint8_t BG12NBA, BG34NBA;

// Sets background mode, bacground 3 priority (only important if mode == 1), and large tiles.
void setBackgroundMode(uint8_t mode, _Bool BG3Priority, _Bool largeTiles);

enum TilemapCount
{
	tilemapCount_1x1 = 0x00,
	tilemapCount_1x2 = 0x01,
	tilemapCount_2x1 = 0x02,
	tilemapCount_2x2 = 0x03,
};
// Set address and tilemap count of a background. Note: address should be a multiple of 0x0400
void setBackgroundAddress(uint8_t backgroundNo, uint16_t wordAddress, enum TilemapCount tilemapCount);

void setBackgroundTileset(uint8_t backgroundNo, uint16_t wordAddress);
