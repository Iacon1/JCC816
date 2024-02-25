// Colors
// https://snes.nesdev.org/wiki/Palettes

#include <stdint.h>
#include "SNES/mmio.h"

extern uint8_t CGADDR;
__WOTWICE uint16_t CGDATA;

void setColor(uint16_t color, uint8_t destination);
void copyPalette(uint16_t* palette, uint8_t destination, uint8_t paletteSize);
