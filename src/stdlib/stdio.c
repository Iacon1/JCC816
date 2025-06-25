#include <stdio.h>

int puts(const char* s)
{
	extern char destination;
	int len = 0;
	asm("puts@destination = $006000");
	while (*s != '\0')
	{
		destination = *s;
		s += 1;
		len += 1;
	}
	destination = '\0';
	return len;
}
