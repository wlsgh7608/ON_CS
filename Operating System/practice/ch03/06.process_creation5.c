#include <stdio.h>
#include <unistd.h>
#include <wait.h>
int main()
{
  pid_t pid;
  for (int i = 0; i < 4; i++)
  {
    pid = fork();
  }
  printf("HI : %d\n", pid);
  return 0;
}