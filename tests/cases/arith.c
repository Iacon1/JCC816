#include <stdint.h>

uint8_t test_done = 0; // explicit: JCC816 does not zero uninitialized globals
uint16_t sum;
uint16_t diff;
uint8_t masked;
int16_t neg;

uint16_t add(uint16_t a, uint16_t b) { return a + b; }

void main()
{
	sum = add(40, 2);
	diff = 1000 - sum;
	masked = (sum << 2) & 0xF0;
	neg = -(int16_t) sum;
	test_done = 1;
	while (1);
}
