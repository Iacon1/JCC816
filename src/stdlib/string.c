// String handling

#include <string.h>

void* memcpy(void* restrict s1, const void* restrict s2, size_t n)
{
	for (size_t i = 0; i < n; ++i)
	{
		*(((char*) s1) + i) = *(((char*) s2) + i);
	}
	return s1;
}
char* strcpy(char* restrict s1, const char* restrict s2)
{
	size_t i = -1;
	do
	{
		i += 1;
		*(s1 + i) = *(s2 + i);
	}
	while (*(s2 + i) != 0);
	return s1;
}
char* strncpy(char* restrict s1, const char* restrict s2, size_t n)
{
	for (size_t i = 0; i < n; ++i)
	{
		*(s1 + i) = *(s2 + i);
		if (*(s2 + i) == 0x00) break;
	}
	return s1;
}
char* strcat(char* restrict s1, const char* restrict s2)
{
	char* s1_head = s1;
	while (*s1 != 0x00) s1 += 1;

	size_t i = 0;
	do
	{
		*(s1 + i) = *(s2 + i);
		i += 1;
	}
	while (*(s2 + i) != 0);

	return s1_head;
}
char* strncat(char* restrict s1, const char* restrict s2, size_t n)
{
	char* s1_head = s1;
	while (*s1 != 0x00) s1 += 1;

	for (size_t i = 0; i < n; ++i)
		{
			*(s1 + i) = *(s2 + i);
			if (*(s2 + i) == 0x00) break;
		}
	while (*(s2 + i) != 0);

	return s1_head;
}
int memcmp(const void *s1, const void* s2, size_t n)
{
	for (size_t i = 0; i < n; ++i)
	{
		if (*(((char*) s1) + i) < *(((char*) s2) + i)) return -1;
		else if (*(((char*) s1) + i) > *(((char*) s2) + i)) return 1;
	}
	return 0;
}
int strcmp(const char* s1, const char* s2)
{
	size_t i = 0;
	do
	{
		if (*(s1 + i) < *(s2 + i)) return -1;
		else if (*(s1 + i) > *(s2 + i)) return 1;
		i += 1;
	}
	while ((*(s1 + i) != 0x00) && (*(s2 + i) != 0x00));

	return 0;
}
int strncmp(const char* s1, const char* s2, size_t n)
{
	for (size_t i = 0; i < n; ++i)
	{
		if (*(s1 + i) < *(s2 + i)) return -1;
		else if (*(s1 + i) > *(s2 + i)) return 1;
		if ((*(s1 + i) == 0x00) || (*(s2 + i) == 0x00)) break;
	}

	return 0;
}
void* memchr(const void *s, int c, size_t n)
{
	for (size_t i = 0; i < n; ++i)
	{
		if (*((char*) s++) == c) return s;
	}
	return 0;
}
char* strchr(const char *s, int c)
{
	do
	{
		if (*(s++) == c) return s;
	}
	while (*s != 0);
	return 0;
}
void* memset(void* s, int c, size_t n)
{
	for (size_t i = 0; i < n; ++i)
	{
		*((char*) s++) = n;
	}
	return 0;
}
size_t strlen(const char *s)
{
	char* start = s;
	do s++;
	while (*s != 0);
	return (size_t) ((unsigned int) s - (unsigned int) start);
}
