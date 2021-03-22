#include <stdio.h>
#include <cs50.h>

int main(void){
  int height;

  do
  {
  height = get_int("Enter the height of the pyramid: ");
  }
  while (height <= 0 || height > 8);

  for (int i = 1; i <= height; i++){
    int ndots = height - i;
    for(int j = 1; j <= ndots; j++){
      printf(" ");
    }
    for(int j = 1; j <= i; j++){
      printf("#");
    }
    printf("  ");

    for(int j = 1; j <= i; j++){
      printf("#");
    }

    printf("\n");
  }
}
