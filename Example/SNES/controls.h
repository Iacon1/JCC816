// Controls
// https://www.youtube.com/watch?v=2Dw7NFm1ZfY

#include "SNES/mmio.h"

enum JoypadButton
{
	joypadSignature		= 0x000F,

	joypadButton_R 		= 0x0010,
	joypadButton_L 		= 0x0020,

	joypadButton_X 		= 0x0040,
	joypadButton_A 		= 0x0080,

	joypadButton_Right	= 0x0100,
	joypadButton_Left 	= 0x0200,
	joypadButton_Down 	= 0x0400,
	joypadButton_Up 	= 0x0800,

	joypadButton_Start	= 0x1000,
	joypadButton_Select	= 0x2000,

	joypadButton_Y		= 0x4000,
	joypadButton_B		= 0x8000,
};
extern uint16_t JOYPAD[4];
