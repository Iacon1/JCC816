int main()
{
	short x = 101, y = 2;

	do
	{
		x *= y;
		y += 1;
	}
	while (x < 100);
	asm("lda main__x");
	asm("L:JMP L");
}
