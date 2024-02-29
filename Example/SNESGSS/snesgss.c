// Shamelessly stolen from SNESGSS

#include <stdint.h>
#include "SNESGSS/snesgss.h"
#include "SNES/mmio.h"

extern uint8_t APUIO0, APUIO1, APUIO2, APUIO3;

//last updated 24.08.14

uint16_t	gss_param;
uint16_t	gss_command;
static uint16_t musicAdr = 0x0200;

#define SCMD_INITIALIZE 0x01
#define SCMD_MUSIC_STOP 0x07
#define SCMD_MUSIC_PLAY 0x06
#define SCMD_LOAD 		0x02

void spc_init(void)
{
	unsigned short i,size;

	size = audioDriver1[0]+(audioDriver1[1]<<8);

	musicAdr = audioDriver1[14]+(audioDriver1[15]<<8);

	if(size<32766)
	{
		spc_load_data(0x0200,size,audioDriver1+2);
	}
	else
	{
		spc_load_data(0x0200,32766,audioDriver1+2);
		spc_command(SCMD_LOAD,0);
		spc_load_data(0x81fe,size-32766,audioDriver2);
	}

	spc_command(SCMD_INITIALIZE,0);
}

void music_play(const unsigned char *data)
{
	unsigned short size;

	size=data[0]+(data[1]<<8);

	spc_command(SCMD_MUSIC_STOP,0);
	spc_command(SCMD_LOAD,0);
	spc_load_data(musicAdr,size,data+2);
	spc_command(SCMD_MUSIC_PLAY,0);
}

/*get channel count*/

uint8_t music_channel_count(const unsigned char *data)
{
	return data[2];
}
