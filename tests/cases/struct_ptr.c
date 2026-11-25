#include <stdint.h>

struct point { uint8_t x; uint16_t y; };

uint8_t test_done = 0; // explicit: JCC816 does not zero uninitialized globals
struct point pt;
uint16_t via_ptr;

void move(struct point* p, uint8_t dx, uint16_t dy)
{
	p->x += dx;
	p->y += dy;
}

void main()
{
	pt.x = 10;
	pt.y = 300;
	move(&pt, 5, 700);
	uint16_t* q = &pt.y;
	via_ptr = *q + 1;
	test_done = 1;
	while (1);
}
