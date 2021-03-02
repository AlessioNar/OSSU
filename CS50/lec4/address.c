#include <stdio.h>
#include <string.h>

int main (void){

  char *s = "HI!";
  int len = strlen(s);
  for(int i = 0; i < len; i++)
  {
    printf("%c\n", *(s+i));
  }

}
