[[optional]] float __addflt32(__SPECX float x, __SPECY float y);
[[optional]] float __subflt32(__SPECX float x, __SPECY float y);
[[optional]] float __mulflt32(__SPECX float x, __SPECY float y);
[[optional]] float __divflt32(__SPECX float x, __SPECY float y);
[[optional]] float __negflt32(__SPECX float x);
[[optional]] char __cmpsflt32(__SPECX float x, __SPECY float y);

[[optional]] double __addflt64(__SPECX double x, __SPECY double y);
[[optional]] double __subflt64(__SPECX double x, __SPECY double y);
[[optional]] double __mulflt64(__SPECX double x, __SPECY double y);
[[optional]] double __divflt64(__SPECX double x, __SPECY double y);
[[optional]] double __negflt64(__SPECX double x);
[[optional]] char __cmpsflt64(__SPECX double x, __SPECY double y);

[[optional]] float __sint8toflt32(__SPECX char x);
[[optional]] float __sint16toflt32(__SPECX short x);
[[optional]] float __sint24toflt32(__SPECX int x);
[[optional]] float __sint32toflt32(__SPECX long x);
[[optional]] float __sint64toflt32(__SPECX long long x);

[[optional]] float __uint8toflt32(__SPECX unsigned char x);
[[optional]] float __uint16toflt32(__SPECX unsigned short x);
[[optional]] float __uint24toflt32(__SPECX unsigned int x);
[[optional]] float __uint32toflt32(__SPECX unsigned long x);
[[optional]] float __uint64toflt32(__SPECX unsigned long long x);

[[optional]] char __flt32tosint8(__SPECX float x);
[[optional]] short __flt32tosint16(__SPECX float x);
[[optional]] int __flt32tosint24(__SPECX float x);
[[optional]] long __flt32tosint32(__SPECX float x);
[[optional]] long long  __flt32tosint64(__SPECX float x);

[[optional]] unsigned char __flt32touint8(__SPECX float x);
[[optional]] unsigned short __flt32touint16(__SPECX float x);
[[optional]] unsigned int __flt32touint24(__SPECX float x);
[[optional]] unsigned long __flt32touint32(__SPECX float x);
[[optional]] unsigned long long __flt32touint64(__SPECX float x);

[[optional]] double __flt32toflt64(__SPECX float x);
[[optional]] float __flt64toflt32(__SPECX double x);
