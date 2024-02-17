// Signal handling

typedef volatile int sig_atomic_t;

#define SIGCOP 0x00
#define SIGBRK 0x01

int raise(int sig);

