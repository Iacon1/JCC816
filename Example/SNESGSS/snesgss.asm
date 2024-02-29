.scope SCMD
	NONE			= $00
	INITIALIZE		= $01
	LOAD			= $02
	STEREO			= $03
	GLOBAL_VOLUME	= $04
	CHANNEL_VOLUME	= $05
	MUSIC_PLAY 		= $06
	MUSIC_STOP 		= $07
	MUSIC_PAUSE 	= $08
	SFX_PLAY		= $09
	STOP_ALL_SOUNDS = $0a
	STREAM_START	= $0b
	STREAM_STOP		= $0c
	STREAM_SEND		= $0d
.endscope

__sneslib_ptr = __@pointerBase
;void spc_load_data(unsigned int adr,unsigned short size,const unsigned char *src)
spc_load_data:
	SEI
	REP		#$10
	SEP		#$20
	LDA		#$aa

	:
	cmp		APUIO0
	bne		:-

	REP		#$20
	LDA 	spc_load_data@src+0	;src
	STA		__sneslib_ptr+0
	LDA 	spc_load_data@src+1	;src
	STA		__sneslib_ptr+1
	LDA 	spc_load_data@size	;size
	TAX
	LDA		spc_load_data@adr	;adr
	STA		APUIO2
	
	SEP		#$20
	LDA		#$01
	STA		APUIO1
	LDA		#$cc
	STA		APUIO0
	
	:
	CMP		APUIO0
	BNE		:-
	
	LDY		#$0000
	
	__load_loop:
	XBA
	LDA		[__sneslib_ptr],y
	XBA
	TYA
	
	REP		#$20
	STA		APUIO0
	SEP		#$20
	
	:
	CMP		APUIO0
	BNE		:-
	
	INY
	DEX
	bne		__load_loop
	
	XBA
    LDA		#$00
    XBA
	CLC
	ADC		#$02
	REP		#$20
	TAX
	
	LDA		#$0200			;loaded code starting address
	STA		APUIO2

	TXA
	STA		APUIO0
	SEP		#$20
	
	:
	CMP		APUIO0
	BNE		:-
	
	REP		#$20
	:
	LDA		APUIO0			;wait until SPC700 clears all communication ports, confirming that code has started
	ORA		APUIO2
	BNE		:-
	
	CLI					;enable IRQ
RTL


	
__spc_command_asm:
	SEP		#$20

	:
	LDA		APUIO0
	BNE		:-

	REP		#$20

	LDA		gss_param
	STA		APUIO2
	LDA		gss_command
	SEP		#$20
	XBA
	STA		APUIO1
	XBA
	STA		APUIO0

	CMP		#SCMD::LOAD	;don't wait acknowledge
	BEQ		:++

	:
	LDA		APUIO0
	BEQ		:-

	:
RTL

	

;void spc_command(unsigned short command,unsigned short param);

spc_command:
	REP		#$20
	
	LDA		spc_command@param	;param
	STA		gss_param
	LDA		spc_command@command	;command
	STA		gss_command
	
	JSL		__spc_command_asm
RTL



;void spc_stereo(unsigned short stereo);

spc_stereo:
	REP		#$30
	lda		spc_stereo@stereo	;stereo
	STA		gss_param
	
	LDA		#SCMD::STEREO
	STA		gss_command
	
	JSL		__spc_command_asm
RTL
	
	
	
;void spc_global_volume(unsigned short volume,unsigned short speed);

spc_global_volume:
	REP		#$30
	
	LDA		spc_global_volume@speed		;speed
	XBA
	AND		#$ff00
	STA		gss_param

	LDA		spc_global_volume@volume	;volume
	AND		#$00ff
	ORA		gss_param
	STA		gss_param
	
	LDA		#SCMD::GLOBAL_VOLUME
	STA		gss_command
	
	JSL		__spc_command_asm
RTL
	
	
	
;void spc_channel_volume(unsigned short channels,unsigned short volume);

spc_channel_volume:
	REP		#$30

	LDA		spc_channel_volume@channels		;speed
	XBA
	AND		#$ff00
	STA		gss_param

	LDA		spc_channel_volume@volume	;volume
	AND		#$00ff
	ORA		gss_param
	STA		gss_param
	
	LDA		#SCMD::CHANNEL_VOLUME
	STA		gss_command
	
	JSL		__spc_command_asm
RTL
	
	
;void music_stop(void);

music_stop:
	REP		#$30
	
	LDA 	#SCMD::MUSIC_STOP
	STA 	gss_command
	LDA		#$0000
	STA 	gss_param
	
	JSL 	__spc_command_asm
RTL
	

	
;void music_pause(unsigned short pause);

music_pause:
	REP		#$30
	
	LDA		music_pause@pause	;pause
	STA		gss_param
	
	LDA		#SCMD::MUSIC_PAUSE
	STA		gss_command
	
	JSL		__spc_command_asm
RTL
	
	
	
;void sound_stop_all(void);

sound_stop_all:
	REP		#$30
	
	LDA		#SCMD::STOP_ALL_SOUNDS
	STA		gss_command
	LDA		#$0000
	STA 	gss_param
	
	JSL		__spc_command_asm
RTL
	
	
	
;void sfx_play(unsigned short chn,unsigned short sfx,unsigned short vol,short pan);
sfx_play:
	REP		#$30

	LDA		sfx_play@pan	;pan
	BPL		:+
	LDA		#0
	:
	CMP		#255
	BCC		:+
	LDA		#255
	:

	XBA
	AND		#$ff00
	STA		gss_param
	
	LDA		sfx_play@sfx	;sfx number
	AND		#$00ff
	ORA		gss_param
	STA		gss_param

	LDA		sfx_play@vol;volume
	XBA
	AND		#$ff00
	STA		gss_command

	lda sfx_play@chn	;chn
	ASL
	ASL
	ASL
	ASL
	AND		#$00f0
	ORA		#SCMD::SFX_PLAY
	ORA		gss_command
	STA		gss_command

	JSL		__spc_command_asm
RTL

