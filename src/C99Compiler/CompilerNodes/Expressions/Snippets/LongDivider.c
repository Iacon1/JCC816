{
	// Code for long divider
	// https://godbolt.org/z/Y8aM3o8eY
	// %1$s is larger type of size of a and size of b
	// %2$s is a type twice %1$s's size
	// %3$s is the number of bits in %1$s, minus 1
	// %4$s is 0x800..., sized same as %1$s
	extern %1$s a, b;
	extern %1$s ret;
	ret = 0;
	extern %1$s i;
	extern %2$s big_div;
	big_div = (%2$s)b << %3$s;
	for (i=%4$s;i;i>>=1)
	{
		if (a >= big_div)
		{
			a -= big_div;
			ret += i;
		}
		big_div >>= 1;
	}
	// return "ret" for division, "a" for modulo
}
