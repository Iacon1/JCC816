// This one's just for debug purposes and only printf is implemented for now.
#include <stdio.h>

int printf(const char* string)
{
	extern char destination;
	asm("printf@destination = $006000");
	while (*string != '\0')
	{
		destination = *string;
		string += 1;
	}
	destination = '\0';
	return 0;
}
