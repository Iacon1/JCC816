// String handling

#include <stddef.h>

void* memcpy(void* restrict s1, const void* restrict s2, size_t n);
char* strcpy(char* restrict s1, const char* restrict s2);
char* strncpy(char* restrict s1, const char* restrict s2, size_t n);
char* strcat(char* restrict s1, const char* restrict s2);
char* strncat(char* restrict s1, const char* restrict s2, size_t n);
int memcmp(const void *s1, const void* s2, size_t n);
int strcmp(const char* s1, const char* s2);
int strncmp(const char* s1, const char* s2, size_t n);
void* memchr(const void *s, int c, size_t n);
char* strchr(const char *s, int c);
void* memset(void* s, int c, size_t n);
size_t strlen(const char* s);
