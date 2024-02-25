// General PPU functions

#include "SNES/Graphics/ppu.h"
#include "SNES/dma.h"

void copyTilemap(uint16_t* tilemap, uint16_t destination)
{
	VMAIN = 0x80;
	DMACHN[0].DMAP = DMATransferTwoOnce; // Set to write mode compatible with VRAM
	VMADDR = destination;
	DMACHN[0].writeAddr = &VMDATA; // Which address on the B-bus do we write to
	DMACHN[0].sourceAddr = (uint24_t) tilemap;
	DMACHN[0].byteCount = 2048; // 2 KB
	MDMAEN = 0x01;
}
void copyTileRegion(uint16_t* tilemap, uint16_t destination, uint16_t n)
{
	VMAIN = 0x80;
	DMACHN[0].DMAP = DMATransferTwoOnce; // Set to write mode compatible with VRAM
	VMADDR = destination;
	DMACHN[0].writeAddr = &VMDATA; // Which address on the B-bus do we write to
	DMACHN[0].sourceAddr = (uint24_t) tilemap;
	DMACHN[0].byteCount = n << 1;
	MDMAEN = 0x01;
}

void copyTiles2BPP(uint16_t* tiles, uint16_t destination, uint16_t nTiles)
{
	VMAIN = 0x80;
	DMACHN[0].DMAP = DMATransferTwoOnce; // Set to write mode compatible with VRAM
	VMADDR = destination;
	DMACHN[0].writeAddr = &VMDATA; // Which address on the B-bus do we write to
	DMACHN[0].sourceAddr = (uint24_t) tiles;
	DMACHN[0].byteCount = nTiles << 4; // 2 bits per pixel -> 16 bytes per tile
	MDMAEN = 0x01;
}
void copyTiles4BPP(uint16_t* tiles, uint16_t nTiles)
{
	VMAIN = 0x80;
	DMACHN[0].DMAP = DMATransferTwoOnce; // Set to write mode compatible with VRAM
	VMADDR = destination;
	DMACHN[0].writeAddr = &VMDATA; // Which address on the B-bus do we write to
	DMACHN[0].sourceAddr = (uint24_t) tiles;
	DMACHN[0].byteCount = nTiles << 5; // 4 bits per pixel -> 32 bytes per tile
	MDMAEN = 0x01;
}
void copyTiles8BPP(uint16_t* tiles, uint16_t nTiles)
{
	VMAIN = 0x80;
	DMACHN[0].DMAP = DMATransferTwoOnce; // Set to write mode compatible with VRAM
	VMADDR = destination;
	DMACHN[0].writeAddr = &VMDATA; // Which address on the B-bus do we write to
	DMACHN[0].sourceAddr = (uint24_t) tiles;
	DMACHN[0].byteCount = nTiles << 6; // 8 bits per pixel -> 64 bytes per tile
	MDMAEN = 0x01;
}
