[[optional]] extern float __addflt32(__SPECX float x, __SPECY float y);
[[optional]] extern float __subflt32(__SPECX float x, __SPECY float y);
[[optional]] extern float __mulflt32(__SPECX float x, __SPECY float y);
[[optional]] extern float __divflt32(__SPECX float x, __SPECY float y);
[[optional]] extern float __negflt32(__SPECX float x);
[[optional]] extern char __cmpsflt32(__SPECX float x, __SPECY float y);

[[optional]] extern double __addflt64(__SPECX double x, __SPECY double y);
[[optional]] extern double __subflt64(__SPECX double x, __SPECY double y);
[[optional]] extern double __mulflt64(__SPECX double x, __SPECY double y);
[[optional]] extern double __divflt64(__SPECX double x, __SPECY double y);
[[optional]] extern double __negflt64(__SPECX double x);
[[optional]] extern char __cmpsflt64(__SPECX double x, __SPECY double y);

[[optional]] extern float __sint8toflt32(__SPECX char x);
[[optional]] extern float __sint16toflt32(__SPECX short x);
[[optional]] extern float __sint24toflt32(__SPECX int x);
[[optional]] extern float __sint32toflt32(__SPECX long x);
[[optional]] extern float __sint64toflt32(__SPECX long long x);

[[optional]] extern float __uint8toflt32(__SPECX unsigned char x);
[[optional]] extern float __uint16toflt32(__SPECX unsigned short x);
[[optional]] extern float __uint24toflt32(__SPECX unsigned int x);
[[optional]] extern float __uint32toflt32(__SPECX unsigned long x);
[[optional]] extern float __uint64toflt32(__SPECX unsigned long long x);

[[optional]] extern char __flt32tosint8(__SPECX float x);
[[optional]] extern short __flt32tosint16(__SPECX float x);
[[optional]] extern int __flt32tosint24(__SPECX float x);
[[optional]] extern long __flt32tosint32(__SPECX float x);
[[optional]] extern long long  __flt32tosint64(__SPECX float x);

[[optional]] extern unsigned char __flt32touint8(__SPECX float x);
[[optional]] extern unsigned short __flt32touint16(__SPECX float x);
[[optional]] extern unsigned int __flt32touint24(__SPECX float x);
[[optional]] extern unsigned long __flt32touint32(__SPECX float x);
[[optional]] extern unsigned long long __flt32touint64(__SPECX float x);

// Doubles
[[optional]] extern double __sint8toflt64(__SPECX char x);
[[optional]] extern double __sint16toflt64(__SPECX short x);
[[optional]] extern double __sint24toflt64(__SPECX int x);
[[optional]] extern double __sint32toflt64(__SPECX long x);
[[optional]] extern double __sint64toflt64(__SPECX long long x);

[[optional]] extern double __uint8toflt64(__SPECX unsigned char x);
[[optional]] extern double __uint16toflt64(__SPECX unsigned short x);
[[optional]] extern double __uint24toflt64(__SPECX unsigned int x);
[[optional]] extern double __uint32toflt64(__SPECX unsigned long x);
[[optional]] extern double __uint64toflt64(__SPECX unsigned long long x);

[[optional]] extern char __flt64tosint8(__SPECX double x);
[[optional]] extern short __flt64tosint16(__SPECX double x);
[[optional]] extern int __flt64tosint24(__SPECX double x);
[[optional]] extern long __flt64tosint32(__SPECX double x);
[[optional]] extern long long  __flt64tosint64(__SPECX double x);

[[optional]] extern unsigned char __flt64touint8(__SPECX double x);
[[optional]] extern unsigned short __flt64touint16(__SPECX double x);
[[optional]] extern unsigned int __flt64touint24(__SPECX double x);
[[optional]] extern unsigned long __flt64touint32(__SPECX double x);
[[optional]] extern unsigned long long __flt64touint64(__SPECX double x);

[[optional]] extern double __flt32toflt64(__SPECX double x);
[[optional]] extern float __flt64toflt32(__SPECX double x);
