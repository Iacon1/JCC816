#include <stdint.h>

uint8_t test_done = 0; // explicit: JCC816 does not zero uninitialized globals
uint16_t a = 1234;
uint16_t b = 10;
uint16_t prod;
uint16_t quot;
uint16_t rem;

void main()
{
	prod = a * b;
	quot = a / b;
	rem = a % b;
	test_done = 1;
	while (1);
}
