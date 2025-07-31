// Multiplicative expression implementations

// multiplication
[[optional]] extern unsigned int __mul8by8(__SPECX unsigned char x, __SPECY unsigned char y);
[[optional]] extern unsigned int __mul16by8(__SPECX unsigned short x, __SPECY unsigned char y);
[[optional]] extern unsigned int __mul24by8(__SPECX unsigned int x, __SPECY unsigned char y);
[[optional]] extern unsigned long __mul32by8(__SPECX unsigned long x, __SPECY unsigned char y);
[[optional]] extern unsigned long long __mul64by8(__SPECX unsigned long long x, __SPECY unsigned char y);

[[optional]] extern unsigned int __mul16by16(__SPECX unsigned short x, __SPECY unsigned short y);
[[optional]] extern unsigned int __mul24by16(__SPECX unsigned int x, __SPECY unsigned short y);
[[optional]] extern unsigned long __mul32by16(__SPECX unsigned long x, __SPECY unsigned short y);
[[optional]] extern unsigned long long __mul64by16(__SPECX unsigned long long x, __SPECY unsigned short y);

[[optional]] extern unsigned int __mul24by24(__SPECX unsigned int x, __SPECY unsigned int y);
[[optional]] extern unsigned long __mul32by24(__SPECX unsigned long x, __SPECY unsigned int y);
[[optional]] extern unsigned long long __mul64by24(__SPECX unsigned long long x, __SPECY unsigned int y);

[[optional]] extern unsigned long __mul32by32(__SPECX unsigned long x, __SPECY unsigned long y);
[[optional]] extern unsigned long long __mul64by32(__SPECX unsigned long long x, __SPECY unsigned long y);

[[optional]] extern unsigned long long __mul64by32(__SPECX unsigned long long x, __SPECY unsigned long y);

[[optional]] extern unsigned long long __mul64by64(__SPECX unsigned long long x, __SPECY unsigned long long y);

// Division
[[optional]] extern unsigned int __div8by8(__SPECX unsigned char x, __SPECY unsigned char y);
[[optional]] extern unsigned int __div16by8(__SPECX unsigned short x, __SPECY unsigned char y);
[[optional]] extern unsigned int __div24by8(__SPECX unsigned int x, __SPECY unsigned char y);
[[optional]] extern unsigned long __div32by8(__SPECX unsigned long x, __SPECY unsigned char y);
[[optional]] extern unsigned long long __div64by8(__SPECX unsigned long long x, __SPECY unsigned char y);

[[optional]] extern unsigned int __div8by16(__SPECX unsigned char x, __SPECY unsigned short y);
[[optional]] extern unsigned int __div16by16(__SPECX unsigned short x, __SPECY unsigned short y);
[[optional]] extern unsigned int __div24by16(__SPECX unsigned int x, __SPECY unsigned short y);
[[optional]] extern unsigned long __div32by16(__SPECX unsigned long x, __SPECY unsigned short y);
[[optional]] extern unsigned long long __div64by16(__SPECX unsigned long long x, __SPECY unsigned short y);

[[optional]] extern unsigned int __div8by24(__SPECX unsigned char x, __SPECY unsigned int y);
[[optional]] extern unsigned int __div16by24(__SPECX unsigned short x, __SPECY unsigned int y);
[[optional]] extern unsigned int __div24by24(__SPECX unsigned int x, __SPECY unsigned int y);
[[optional]] extern unsigned long __div32by24(__SPECX unsigned long x, __SPECY unsigned int y);
[[optional]] extern unsigned long long __div64by24(__SPECX unsigned long long x, __SPECY unsigned int y);

[[optional]] extern unsigned int __div8by32(__SPECX unsigned char x, __SPECY unsigned long y);
[[optional]] extern unsigned int __div16by32(__SPECX unsigned short x, __SPECY unsigned long y);
[[optional]] extern unsigned int __div24by32(__SPECX unsigned int x, __SPECY unsigned long y);
[[optional]] extern unsigned long __div32by32(__SPECX unsigned long x, __SPECY unsigned long y);
[[optional]] extern unsigned long long __div64by32(__SPECX unsigned long long x, __SPECY unsigned long y);

[[optional]] extern unsigned int __div8by64(__SPECX unsigned char x, __SPECY unsigned long long y);
[[optional]] extern unsigned int __div16by64(__SPECX unsigned short x, __SPECY unsigned long long y);
[[optional]] extern unsigned int __div24by64(__SPECX unsigned int x, __SPECY unsigned long long y);
[[optional]] extern unsigned long __div32by64(__SPECX unsigned long x, __SPECY unsigned long long y);
[[optional]] extern unsigned long long __div64by64(__SPECX unsigned long long x, __SPECY unsigned long long y);

// Modulation
[[optional]] extern unsigned int __mod8by8(__SPECX unsigned char x, __SPECY unsigned char y);
[[optional]] extern unsigned int __mod16by8(__SPECX unsigned short x, __SPECY unsigned char y);
[[optional]] extern unsigned int __mod24by8(__SPECX unsigned int x, __SPECY unsigned char y);
[[optional]] extern unsigned long __mod32by8(__SPECX unsigned long x, __SPECY unsigned char y);
[[optional]] extern unsigned long long __mod64by8(__SPECX unsigned long long x, __SPECY unsigned char y);

[[optional]] extern unsigned int __mod8by16(__SPECX unsigned char x, __SPECY unsigned short y);
[[optional]] extern unsigned int __mod16by16(__SPECX unsigned short x, __SPECY unsigned short y);
[[optional]] extern unsigned int __mod24by16(__SPECX unsigned int x, __SPECY unsigned short y);
[[optional]] extern unsigned long __mod32by16(__SPECX unsigned long x, __SPECY unsigned short y);
[[optional]] extern unsigned long long __mod64by16(__SPECX unsigned long long x, __SPECY unsigned short y);

[[optional]] extern unsigned int __mod8by24(__SPECX unsigned char x, __SPECY unsigned int y);
[[optional]] extern unsigned int __mod16by24(__SPECX unsigned short x, __SPECY unsigned int y);
[[optional]] extern unsigned int __mod24by24(__SPECX unsigned int x, __SPECY unsigned int y);
[[optional]] extern unsigned long __mod32by24(__SPECX unsigned long x, __SPECY unsigned int y);
[[optional]] extern unsigned long long __mod64by24(__SPECX unsigned long long x, __SPECY unsigned int y);

[[optional]] extern unsigned int __mod8by32(__SPECX unsigned char x, __SPECY unsigned long y);
[[optional]] extern unsigned int __mod16by32(__SPECX unsigned short x, __SPECY unsigned long y);
[[optional]] extern unsigned int __mod24by32(__SPECX unsigned int x, __SPECY unsigned long y);
[[optional]] extern unsigned long __mod32by32(__SPECX unsigned long x, __SPECY unsigned long y);
[[optional]] extern unsigned long long __mod64by32(__SPECX unsigned long long x, __SPECY unsigned long y);

[[optional]] extern unsigned int __mod8by64(__SPECX unsigned char x, __SPECY unsigned long long y);
[[optional]] extern unsigned int __mod16by64(__SPECX unsigned short x, __SPECY unsigned long long y);
[[optional]] extern unsigned int __mod24by64(__SPECX unsigned int x, __SPECY unsigned long long y);
[[optional]] extern unsigned long __mod32by64(__SPECX unsigned long x, __SPECY unsigned long long y);
[[optional]] extern unsigned long long __mod64by64(__SPECX unsigned long long x, __SPECY unsigned long long y);

