// Colors
// https://snes.nesdev.org/wiki/Palettes

#include "SNES/Graphics/colors.h"
#include "SNES/dma.h"

void setColor(uint8_t color, uint8_t destination)
{
	CGADDR = destination;
	CGDATA = color;
}

void copyPalette(uint16_t* palette, uint8_t destination, uint8_t paletteSize)
{
	DMACHN[0].DMAP = DMATransferOneTwice; // Set to write mode compatible with CGRAM
	CGADDR = destination;
	DMACHN[0].writeAddr = &CGDATA; // Which address on the B-bus do we write to
	DMACHN[0].sourceAddr = (uint24_t) palette;
	DMACHN[0].byteCount = paletteSize << 1; // 2 bytes per color
	MDMAEN = 0x01;
}
