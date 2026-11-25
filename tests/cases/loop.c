#include <stdint.h>

uint8_t test_done = 0; // explicit: JCC816 does not zero uninitialized globals
uint16_t total;
uint8_t squares[8];

void main()
{
	total = 0;
	for (uint8_t i = 0; i < 8; ++i)
	{
		squares[i] = i * i;
		total += squares[i];
	}
	test_done = 1;
	while (1);
}
