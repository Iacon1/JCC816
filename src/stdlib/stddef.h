// Common definitions
#ifndef STDDEF_H
#define STDDEF_H
typedef signed int ptrdiff_t;
typedef unsigned int size_t;
typedef char wchar_t;

#define NULL 0
#define offsetof(st, m) __offset_of(st, m)
#endif
