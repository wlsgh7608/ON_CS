#include <stdio.h>
#include <unistd.h>
#include <wait.h>

int value = 5;

int main()
{
  pid_t pid;
  pid = fork();
  if (pid == 0)
  { // child
    value += 15;
    return 0;
  }
  else
  { // parent
    wait(NULL);
    printf("value = %d \n", value);
  }

  return 0;
}