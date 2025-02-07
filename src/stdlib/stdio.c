#include <stdio.h>

int puts(const char* s)
{
	extern char destination;
	int len = 0;
	asm("printf@destination = $006000");
	while (*string != '\0')
	{
		destination = *string;
		string += 1;
		len += 1;
	}
	destination = '\0';
	return len;
}
