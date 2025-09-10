[[optional, __req, __subflt32]] extern float __addflt32(__SPECX float x, __SPECY float y);
[[optional, __req, __addflt32]] extern float __subflt32(__SPECX float x, __SPECY float y);
[[optional, __req, __mul24by24]] extern float __mulflt32(__SPECX float x, __SPECY float y);
[[optional, __req, __div24by24]] extern float __divflt32(__SPECX float x, __SPECY float y);
[[optional]] extern float __negflt32(__SPECX float x);
// -1 = x < y, 0 = x == y, 1 = x > y
[[optional]] extern char __cmpsflt32(__SPECX float x, __SPECY float y);
