// String handling

#include <stddef.h>

[[optional]] void* memcpy(void* restrict s1, const void* restrict s2, size_t n);
[[optional]] char* strcpy(char* restrict s1, const char* restrict s2);
[[optional]] char* strncpy(char* restrict s1, const char* restrict s2, size_t n);
[[optional]] char* strcat(char* restrict s1, const char* restrict s2);
[[optional]] char* strncat(char* restrict s1, const char* restrict s2, size_t n);
[[optional]] int memcmp(const void *s1, const void* s2, size_t n);
[[optional]] int strcmp(const char* s1, const char* s2);
[[optional]] int strncmp(const char* s1, const char* s2, size_t n);
[[optional]] void* memchr(const void *s, int c, size_t n);
[[optional]] char* strchr(const char *s, int c);
[[optional]] void* memset(void* s, int c, size_t n);
[[optional]] size_t strlen(const char* s);
