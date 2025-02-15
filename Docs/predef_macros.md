# Predefined macros

For convienences' sake, JCC816 defines several macros whenever a header file is provided or debug level above 0 is specified.
These allow the code to, say, use different timers in PAL regions or output debug messages in debug code.

These are enumerated below.

## `__SNES_REGION__`
This macro is defined as the hex value of the ROM header's destination code.
Additionally, a second macro will be defined depending on the code so that `#ifdef` can be used for checking this code. These secondary macros are:  
|Japan|`__SNES_REGION_JPN__`|
|---|---|
|USA|			`__SNES_REGION_USA__`|
|Australia:		`__SNES_REGION_AUS__`|
Brazil:			`__SNES_REGION_BRA__`  
Canada:			`__SNES_REGION_CAN__`  
China:			`__SNES_REGION_CHN__`  
Denmark:		`__SNES_REGION_DEN__`  
Europe:			`__SNES_REGION_EUR__`  
Finland:		`__SNES_REGION_FIN__`  
Germany:		`__SNES_REGION_GER__`  
Indonesia:		`__SNES_REGION_IND__`  
International:	`__SNES_REGION_INT__`  
Italy:			`__SNES_REGION_ITA__`  
Netherlands:	`__SNES_REGION_NET__`  
South Korea:	`__SNES_REGION_KOR__`  
Spain:			`__SNES_REGION_SPN__`  
Sweden:			`__SNES_REGION_SWE__`  
