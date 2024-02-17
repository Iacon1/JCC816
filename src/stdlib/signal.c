// Signal handling

#include <signal.h>

int raise(int sig)
{
	switch (sig)
	{
	case SIGCOP: asm("COP"); return;
	case SIGBRK: asm("BRK"); return;
	}
	return 0;
}
