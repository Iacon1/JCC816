// Thanks Sir Walrus

// Division
[[optional]] unsigned int __div8by16(__SPECX unsigned char x, __SPECY unsigned short y)
{
	asm("__div8by16@ret = __@callResult+0");
	asm("__div8by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div8by24(__SPECX unsigned char x, __SPECY unsigned int y)
{
	asm("__div8by24@ret = __@callResult+0");
	asm("__div8by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div8by32(__SPECX unsigned char x, __SPECY unsigned long y)
{
	asm("__div8by32@ret = __@callResult+0");
	asm("__div8by32@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div8by64(__SPECX unsigned char x, __SPECY unsigned long long y)
{
	asm("__div8by64@ret = __@callResult+0");
	asm("__div8by64@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div16by16(__SPECX unsigned short x, __SPECY unsigned short y)
{
	asm("__div16by16@ret = __@callResult+0");
	asm("__div16by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div16by24(__SPECX unsigned short x, __SPECY unsigned int y)
{
	asm("__div16by24@ret = __@callResult+0");
	asm("__div16by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div16by32(__SPECX unsigned short x, __SPECY unsigned long y)
{
	asm("__div16by32@ret = __@callResult+0");
	asm("__div16by32@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div16by64(__SPECX unsigned short x, __SPECY unsigned long long y)
{
	asm("__div16by64@ret = __@callResult+0");
	asm("__div16by64@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div24by16(__SPECX unsigned int x, __SPECY unsigned short y)
{
	asm("__div24by16@ret = __@callResult+0");
	asm("__div24by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div24by24(__SPECX unsigned int x, __SPECY unsigned int y)
{
	asm("__div24by24@ret = __@callResult+0");
	asm("__div24by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div24by32(__SPECX unsigned int x, __SPECY unsigned long y)
{
	asm("__div24by32@ret = __@callResult+0");
	asm("__div24by32@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div24by64(__SPECX unsigned int x, __SPECY unsigned long long y)
{
	asm("__div24by64@ret = __@callResult+0");
	asm("__div24by64@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div32by16(__SPECX unsigned long x, __SPECY unsigned short y)
{
	asm("__div32by16@ret = __@callResult+0");
	asm("__div32by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div32by24(__SPECX unsigned long x, __SPECY unsigned int y)
{
	asm("__div32by24@ret = __@callResult+0");
	asm("__div32by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned long __div32by32(__SPECX unsigned long x, __SPECY unsigned long y)
{
	asm("__div32by32@ret = __@callResult+0");
	asm("__div32by32@start = __@callResult+4");
	unsigned long ret = 0;
	unsigned long start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned long __div32by64(__SPECX unsigned long x, __SPECY unsigned long long y)
{
	asm("__div32by64@ret = __@callResult+0");
	asm("__div32by64@start = __@callResult+4");
	unsigned long ret = 0;
	unsigned long start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div64by16(__SPECX unsigned long long x, __SPECY unsigned short y)
{
	asm("__div64by16@ret = __@callResult+0");
	asm("__div64by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned int __div64by24(__SPECX unsigned long long x, __SPECY unsigned int y)
{
	asm("__div64by24@ret = __@callResult+0");
	asm("__div64by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned long __div64by32(__SPECX unsigned long long x, __SPECY unsigned long y)
{
	asm("__div64by32@ret = __@callResult+0");
	asm("__div64by32@start = __@callResult+4");
	unsigned long ret = 0;
	unsigned long start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}

[[optional]] unsigned long long __div64by64(__SPECX unsigned long long x, __SPECY unsigned long long y)
{
	asm("__div64by64@ret = __@callResult+0");
	asm("__div64by64@start = __@callResult+8");
	unsigned long long ret = 0;
	unsigned long long start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return ret;
}


// Modulation
[[optional]] unsigned int __mod8by16(__SPECX unsigned char x, __SPECY unsigned short y)
{
	asm("__mod8by16@ret = __@callResult+0");
	asm("__mod8by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod8by24(__SPECX unsigned char x, __SPECY unsigned int y)
{
	asm("__mod8by24@ret = __@callResult+0");
	asm("__mod8by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod8by32(__SPECX unsigned char x, __SPECY unsigned long y)
{
	asm("__mod8by32@ret = __@callResult+0");
	asm("__mod8by32@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod8by64(__SPECX unsigned char x, __SPECY unsigned long long y)
{
	asm("__mod8by64@ret = __@callResult+0");
	asm("__mod8by64@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod16by16(__SPECX unsigned short x, __SPECY unsigned short y)
{
	asm("__mod16by16@ret = __@callResult+0");
	asm("__mod16by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod16by24(__SPECX unsigned short x, __SPECY unsigned int y)
{
	asm("__mod16by24@ret = __@callResult+0");
	asm("__mod16by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod16by32(__SPECX unsigned short x, __SPECY unsigned long y)
{
	asm("__mod16by32@ret = __@callResult+0");
	asm("__mod16by32@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod16by64(__SPECX unsigned short x, __SPECY unsigned long long y)
{
	asm("__mod16by64@ret = __@callResult+0");
	asm("__mod16by64@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod24by16(__SPECX unsigned int x, __SPECY unsigned short y)
{
	asm("__mod24by16@ret = __@callResult+0");
	asm("__mod24by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod24by24(__SPECX unsigned int x, __SPECY unsigned int y)
{
	asm("__mod24by24@ret = __@callResult+0");
	asm("__mod24by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod24by32(__SPECX unsigned int x, __SPECY unsigned long y)
{
	asm("__mod24by32@ret = __@callResult+0");
	asm("__mod24by32@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod24by64(__SPECX unsigned int x, __SPECY unsigned long long y)
{
	asm("__mod24by64@ret = __@callResult+0");
	asm("__mod24by64@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod32by16(__SPECX unsigned long x, __SPECY unsigned short y)
{
	asm("__mod32by16@ret = __@callResult+0");
	asm("__mod32by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod32by24(__SPECX unsigned long x, __SPECY unsigned int y)
{
	asm("__mod32by24@ret = __@callResult+0");
	asm("__mod32by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned long __mod32by32(__SPECX unsigned long x, __SPECY unsigned long y)
{
	asm("__mod32by32@ret = __@callResult+0");
	asm("__mod32by32@start = __@callResult+4");
	unsigned long ret = 0;
	unsigned long start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned long __mod32by64(__SPECX unsigned long x, __SPECY unsigned long long y)
{
	asm("__mod32by64@ret = __@callResult+0");
	asm("__mod32by64@start = __@callResult+4");
	unsigned long ret = 0;
	unsigned long start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod64by16(__SPECX unsigned long long x, __SPECY unsigned short y)
{
	asm("__mod64by16@ret = __@callResult+0");
	asm("__mod64by16@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x8000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned int __mod64by24(__SPECX unsigned long long x, __SPECY unsigned int y)
{
	asm("__mod64by24@ret = __@callResult+0");
	asm("__mod64by24@start = __@callResult+3");
	unsigned int ret = 0;
	unsigned int start = 1;
	while (x > y)
	{
		if (y & 0x800000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned long __mod64by32(__SPECX unsigned long long x, __SPECY unsigned long y)
{
	asm("__mod64by32@ret = __@callResult+0");
	asm("__mod64by32@start = __@callResult+4");
	unsigned long ret = 0;
	unsigned long start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

[[optional]] unsigned long long __mod64by64(__SPECX unsigned long long x, __SPECY unsigned long long y)
{
	asm("__mod64by64@ret = __@callResult+0");
	asm("__mod64by64@start = __@callResult+8");
	unsigned long long ret = 0;
	unsigned long long start = 1;
	while (x > y)
	{
		if (y & 0x80000000)
			break;
		y <<= 1;
		start <<= 1;
	}
	while (start)
	{
		if (x >= y)
		{
			x -= y;
			ret += start;
		}
		y >>= 1;
		start >>= 1;
	}
	return x;
}

