[[optional]] extern double __addflt64(__SPECX double x, __SPECY double y);
[[optional]] extern double __subflt64(__SPECX double x, __SPECY double y);
[[optional, __req, __mul64by64]] extern double __mulflt64(__SPECX double x, __SPECY double y);
[[optional, __req, __div64by64]] extern double __divflt64(__SPECX double x, __SPECY double y);
[[optional]] extern double __negflt64(__SPECX double x);
// -1 = x < y, 0 = x == y, 1 = x > y
[[optional]] extern char __cmpsflt64(__SPECX double x, __SPECY double y);
