// Shamelessly stolen from SNESGSS

//last updated 24.08.14

#include <stdint.h>

const extern uint8_t audioDriver[];

/*send a command to the SPC driver*/

extern void spc_command(unsigned short command,unsigned short param);

/*upload data into the sound memory using IPL loader*/

extern void spc_load_data(unsigned short adr, unsigned short size, const unsigned char *src);

/*change stereo sound mode*/

extern void spc_stereo(unsigned short stereo);

/*set global sound volume, target volume 0..127, fade speed 1..255 (slowest to fastest) */

extern void spc_global_volume(unsigned short volume,unsigned short speed);

/*set channel volume*/

extern void spc_channel_volume(unsigned short channels,unsigned short volume);

/*initialize sound, set variables, and upload driver code*/

void spc_init();

/*play sound effect*/

extern void sfx_play(unsigned short chn,unsigned short sfx,unsigned short vol, short pan); //implemented in sneslib.asm

/*play music*/

void music_play(const unsigned char *data);

/*get channel count*/

unsigned char music_channel_count(const unsigned char *data);

/*stop music*/

extern void music_stop();

/*pause or unpause music*/

extern void music_pause(unsigned short pause);

/*stop all sounds*/

extern void sound_stop_all();

