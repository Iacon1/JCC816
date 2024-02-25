// DMA registers
// https://snes.nesdev.org/wiki/DMA_registers

#include <stdint.h>
#include "SNES/mmio.h"

enum DMAIncrementStep // How we move through A-bus.
{
	DMAIncrement = 0,	// Increment A-addr after each write
	DMARemain = 1,		// A-addr does not change
	DMADecrement = 2,	// Decrement A-addr after each write
};
enum DMATransferPattern // How we move through B-bus.
// https://snesdev.mesen.ca/wiki/index.php?title=DMA_and_HDMA#DMAPx_-_DMA_Control_for_Channel_x_.28x.3D0-7.29_.28.2443X0.29
{
	DMATransferOneOnce = 0, // Writes to one address once
	DMATransferTwoOnce = 1,	// Writes to two addresses once each
	DMATransferOneTwice = 2,// Writes to one address twice
	DMATransferTwoTwice = 3,// Writes to two addresses twice each
	DMATransferFourOnce = 4,// Writes to four addresses once each
	DMATransferTwoAlt = 5,	// Writes to two addresses twice each, alternating between them
};

struct DMARegister
{
	uint8_t 	DMAP;		// DI.A APPP Direction, indirect HDMA, address increment mode, transfer pattern
	uint8_t 	writeAddr;	// AAAA AAAA B-bus address
	uint24_t	sourceAddr;	// LLLL LLLL HHHH HHHH BBBB BBBB DMA source address / HDMA table start address
	uint24_t	byteCount;	// LLLL LLLL HHHH HHHH BBBB BBBB DMA byte count / HDMA indirect table address
	uint16_t	tableAddr;	// LLLL LLLL HHHH HHHH HDMA table address within bank
	uint8_t		HDMA;		// RLLL LLLL HDMA reload flag and scanline counter
	uint8_t		FILLER[5];	// Unused
};

extern volatile uint8_t MDMAEN;
extern volatile uint8_t HDMAEN;

extern volatile struct DMARegister DMACHN[8];

void runAllHDMAs();
