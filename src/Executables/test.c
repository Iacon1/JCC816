// Type your code here, or load an example.
typedef enum
	{
		red,
		blue,
		yellow,
		green
	} color;
color x;

void main()
{
	asm(".res $7000, 0");
}

void main2()
{
	asm(".res $7000, 0");
}
