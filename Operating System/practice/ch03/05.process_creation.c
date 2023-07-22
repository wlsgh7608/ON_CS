#include <stdio.h>
#include <unistd.h>
#include <wait.h>

int value = 5;
int main()
{
  fork();
  value += 5;
  printf("HI, value = %d\n", value);
  fork();
  value += 5;
  printf("HI, value = %d\n", value);
  fork();
  value += 5;
  printf("HI, value = %d\n", value);
  return 0;
}