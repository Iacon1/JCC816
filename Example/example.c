#include <stdint.h>
#include "SNES/Graphics/ppu.h"
#include "SNES/dma.h"
#include "SNES/init.h"
#include "SNES/Graphics/backgrounds.h"
#include "SNES/Graphics/colors.h"
#include "SNES/Graphics/oam.h"
#include "SNES/cpu.h"
#include "SNES/controls.h"
#include "SNESGSS/snesgss.h"

#include "Resources/resources.h"

_Bool isScanning;
[[interrupt_NMI, no_ISR1]] void handleNMI()
{
	isScanning = 0;
}

_Bool isColliding(uint8_t x1, uint8_t w1, uint8_t y1, uint8_t h1, uint8_t x2, uint8_t w2, uint8_t y2, uint8_t h2)
{
	if (x1 >= x2 + w2) return 0;
	if (x1 + w1 <= x2) return 0;
	if (y1 >= y2 + h2) return 0;
	if (y1 + h1 <= y2) return 0;
	return 1;
}

// Unsigned integer to tile list
void uiToTiles(uint16_t* c, unsigned char n, unsigned int value, uint16_t zeroTile)
{
	uint16_t x;
	for (short i = n - 1; i >= 0; --i)
	{
		x = value % 0x0A;
		value = value / 0x0A;
		*(c + i) = x + zeroTile;
	}
}

void main()
{
	initSNES();
	uint16_t tilemapAddress = 0x0400;
	uint16_t tilesetAddress = 0x0000;

	setBackgroundMode(1, 0, 0);
	setBackgroundAddress(0, tilemapAddress, tilemapCount_1x1);
	setBackgroundTileset(0, tilesetAddress);

	copyTilemap((uint16_t*) tilemap, tilemapAddress);
	copyTiles4BPP((uint16_t*) tile, tilesetAddress, 47);
	copyPalette((uint16_t*) palette, 0, 32);
	copyPalette((uint16_t*) palette, 128, 32);

	clearOAMBuffers();
	// Initialize player sprites and ball
	lowOAMBuffer[0].x = 8 * 3;
	lowOAMBuffer[0].y = (32*8/2);
	lowOAMBuffer[0].lowTileNo = 0x1B;
	lowOAMBuffer[0].properties = lowOAMFlag_Priority3;
	setHighOAMProperties(0, 0, 1);

	lowOAMBuffer[1].x = (32*8) - 16 - (8 * 3);
	lowOAMBuffer[1].y = (32*8/2);
	lowOAMBuffer[1].lowTileNo = 0x1B;
	lowOAMBuffer[1].properties = lowOAMFlag_Priority3 | lowOAMFlag_HFlip;
	setHighOAMProperties(1, 0, 1);

	lowOAMBuffer[2].x = (32*8/2);
	lowOAMBuffer[2].y = (32*8/2);
	lowOAMBuffer[2].lowTileNo = 0x00;
	lowOAMBuffer[2].properties = lowOAMFlag_Priority3;
	setHighOAMProperties(2, 0, 0);

	updateOAM();
	TM = 0x11;

	unsigned int scoreP1 = 0, scoreP2 = 0;
	uint16_t scoreP1Tiles[4], scoreP2Tiles[4];
	uiToTiles(scoreP1Tiles, 4, scoreP1, 0x001E);
	uiToTiles(scoreP2Tiles, 4, scoreP2, 0x001E);
	copyTileRegion(scoreP1Tiles, tilemapAddress + (32 * 16 + 4), 4);
	copyTileRegion(scoreP2Tiles, tilemapAddress + (32 * 16 + 24), 4);

	spc_init();

	INIDISP = 0x0F;
	NMITIMEN = NMITIMENFlag_NMI | NMITIMENFlag_AutoJoypad;
	isScanning = 1;

	_Bool goRight = 1, goDown = 1;
	_Bool refreshScores = 0;

	while (1)
	{
		if (refreshScores)
		{
			copyTileRegion(scoreP1Tiles, tilemapAddress + (32 * 16 + 4), 4);
			copyTileRegion(scoreP2Tiles, tilemapAddress + (32 * 16 + 24), 4);
			refreshScores = 0;
		}

		updateOAM();
		isScanning = 1;

		if ((JOYPAD[0] & joypadButton_Up) && (lowOAMBuffer[0].y > 0))
			lowOAMBuffer[0].y -= 1;
		else if ((JOYPAD[0] & joypadButton_Down) && (lowOAMBuffer[0].y < 224 - 16))
			lowOAMBuffer[0].y += 1;

		if ((JOYPAD[1] & joypadButton_Up) && (lowOAMBuffer[1].y > 0))
			lowOAMBuffer[1].y -= 1;
		else if ((JOYPAD[1] & joypadButton_Down) && (lowOAMBuffer[1].y < 224 - 16))
			lowOAMBuffer[1].y += 1;

		lowOAMBuffer[2].x += goRight ? 1 : -1;
		lowOAMBuffer[2].y += goDown ? 1 : -1;

		if (0 == lowOAMBuffer[2].y) // Hit upper edge of screen
		{
			goDown = 1;
			lowOAMBuffer[2].y = 1;
		}
		else if (lowOAMBuffer[2].y > 224 - 8) // Hit lower edge of screen
		{
			goDown = 0;
			lowOAMBuffer[2].y = 224 - 8;
		}
		uiToTiles(scoreP2Tiles, 4, scoreP2, 0x001E);
		if (0 == lowOAMBuffer[2].x) // Hit P1's side of screen
		{
			lowOAMBuffer[2].x = (32*8/2); // Reset position
			lowOAMBuffer[2].y = (32*8/2);
			goRight = 1;
			goDown = 1;
			scoreP2 += 1;
			uiToTiles(scoreP2Tiles, 4, scoreP2, 0x001E);
			refreshScores = 1;
		}
		else if (lowOAMBuffer[2].x > 256 - 8) // Hit P2's side of screen
		{
			lowOAMBuffer[2].x = (32*8/2); // Reset position
			lowOAMBuffer[2].y = (32*8/2);
			goRight = 0;
			goDown = 1;
			scoreP1 += 1;
			uiToTiles(scoreP1Tiles, 4, scoreP1, 0x001E);
			refreshScores = 1;
		}

		if (isColliding(lowOAMBuffer[0].x, 16, lowOAMBuffer[0].y, 16, lowOAMBuffer[2].x, 8, lowOAMBuffer[2].y, 8)) // Hit P1
		{
			lowOAMBuffer[2].x = lowOAMBuffer[0].x + 16;
			goRight = 1;
			goDown = !goDown;
		}
		else if (isColliding(lowOAMBuffer[1].x, 16, lowOAMBuffer[1].y, 16, lowOAMBuffer[2].x, 8, lowOAMBuffer[2].y, 8)) // Hit P2
		{
			lowOAMBuffer[2].x = lowOAMBuffer[1].x - 8;
			goRight = 0;
			goDown = !goDown;
		}

		while (isScanning);
	}
}
