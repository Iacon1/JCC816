// General PPU functions
// https://snes.nesdev.org/wiki/PPU_registers

#include <stdint.h>
#include "SNES/mmio.h"

extern volatile int8_t INIDISP; // F... BBBB - F = forced blanking, B = screen brightness

extern volatile uint8_t MOSAIC;

extern volatile uint8_t VMAIN;
extern volatile uint16_t VMADDR;
extern volatile uint16_t VMDATA;

extern volatile uint8_t TM;
extern volatile uint8_t TS;

void copyTilemap(uint16_t* tilemap, uint16_t destination);
void copyTileRegion(uint16_t* tilemap, uint16_t destination, uint16_t n);

void copyTiles2BPP(uint16_t* tiles, uint16_t destination, uint16_t nTiles);
void copyTiles4BPP(uint16_t* tiles, uint16_t destination, uint16_t nTiles);
void copyTiles8BPP(uint16_t* tiles, uint16_t destination, uint16_t nTiles);
