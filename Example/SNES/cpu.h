// CPU controls

#include <stdint.h>
#include "SNES/mmio.h"

enum NMITIMENFlag
{
	NMITIMENFlag_NMI = 0x80,
	NMITIMENFlag_VIRQ = 0x20,
	NMITIMENFlag_HIRQ = 0x10,
	NMITIMENFlag_AutoJoypad = 0x01,
};
extern volatile uint8_t NMITIMEN;
extern volatile uint16_t HTIME, VTIME;
