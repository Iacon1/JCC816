// DMA registers

#include "SNES/dma.h"

uint8_t queueHDMAEN = 0;

void runAllHDMAs()
{
	HDMAEN = queueHDMAEN;
	queueHDMAEN = 0x00;
}
