// Integer types

typedef unsigned char uint8_t;			typedef signed char int8_t;
typedef unsigned short uint16_t;		typedef signed short int16_t;
typedef unsigned int uint24_t;			typedef signed int int24_t;
typedef unsigned long uint32_t;			typedef signed long int32_t;
typedef unsigned long long uint64_t;	typedef signed long long int64_t;

typedef uint8_t uint_least8_t;			typedef int8_t int_least8_t;
typedef uint16_t uint_least16_t;		typedef int16_t int_least16_t;
typedef uint24_t uint_least16_t;		typedef int16_t int_least24_t;
typedef uint32_t uint_least32_t;		typedef int32_t int_least32_t;
typedef uint64_t uint_least64_t;		typedef int64_t int_least64_t;

typedef uint8_t uint_fast8_t;			typedef int8_t int_fast8_t;
typedef uint16_t uint_fast16_t;			typedef int16_t int_fast16_t;
typedef uint16_t uint_fast24_t;			typedef int16_t int_fast24_t;
typedef uint32_t uint_fast32_t;			typedef int32_t int_fast32_t;
typedef uint64_t uint_fast64_t;			typedef int64_t int_fast64_t;

typedef uint24_t uintptr_t;				typedef int24_t intptr_t;

typedef uint64_t uintmax_t;				typedef int64_t intmax_t;

#define INT8_MIN			-128
#define INT8_MAX			127
#define UINT8_MAX			255
#define INT16_MIN			-32768
#define INT16_MAX			32767
#define UINT16_MAX			65535
#define INT24_MIN			-8388608
#define INT24_MAX			8388607
#define UINT24_MAX			16777215
#define INT32_MIN			-214783648
#define INT32_MAX			2147483647
#define UINT32_MAX			4294967295
#define INT64_MIN			-9223372036854775808
#define INT64_MAX			9223372036854775807
#define UINT64_MAX			18446744073709551615

#define INT_LEAST8_MIN		-128
#define INT_LEAST8_MAX		127
#define UINT_LEAST8_MAX		255
#define INT_LEAST16_MIN		-32768
#define INT_LEAST16_MAX		32767
#define UINT_LEAST16_MAX	65535
#define INT_LEAST24_MIN		-8388608
#define INT_LEAST24_MAX		8388607
#define UINT_LEAST24_MAX	16777215
#define INT_LEAST32_MIN		-214783648
#define INT_LEAST32_MAX		2147483647
#define UINT_LEAST32_MAX	4294967295
#define INT_LEAST64_MIN		-9223372036854775808
#define INT_LEAST64_MAX		9223372036854775807
#define UINT_LEAST64_MAX	18446744073709551615

#define INT_FAST8_MIN		-128
#define INT_FAST8_MAX		127
#define UINT_FAST8_MAX		255
#define INT_FAST16_MIN		-32768
#define INT_FAST16_MAX		32767
#define UINT_FAST16_MAX		65535
#define INT_FAST24_MIN		-8388608
#define INT_FAST24_MAX		8388607
#define UINT_FAST24_MAX		16777215
#define INT_FAST32_MIN		-214783648
#define INT_FAST32_MAX		2147483647
#define UINT_FAST32_MAX		4294967295
#define INT_FAST64_MIN		-9223372036854775808
#define INT_FAST64_MAX		9223372036854775807
#define UINT_FAST64_MAX		18446744073709551615

#define INTPTR_MIN			-8388608
#define INTPTR_MAX			8388607
#define UINTPTR_MAX			16777215

#define INTMAX_MIN			-9223372036854775808
#define INTMAX_MAX			9223372036854775807
#define UINTMAX_MAX			18446744073709551615

#define PTRDIFF_MIN			-8388608
#define PTRDIFF_MAX			8388607

#define SIZE_MAX			16777215
#define WCHAR_MIN			0
#define WCHAR_MAX			255

#define UINT8_C(value) ((uint_least8_t) value)		#define INT8_C(value) ((int_least8_t) value)
#define UINT16_C(value) ((uint_least16_t) value)	#define INT16_C(value) ((int_least16_t) value)
#define UINT24_C(value) ((uint_least24_t) value)	#define INT24_C(value) ((int_least24_t) value)
#define UINT32_C(value) ((uint_least32_t) value)	#define INT32_C(value) ((int_least32_t) value)
#define UINT64_C(value) ((uint_least64_t) value)	#define INT64_C(value) ((int_least64_t) value)

#define UINTMAX_C(value) ((uintleast_t) value)		#define INTMAX_C(value) ((intmax_t) value)
