#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <stdlib.h>

// At present, key is equal to the number of arguments provided with the command line

int main(int argc, char *argv[])
{
    if (argc != 2){
      printf("Usage: ./caesar key \n");
      return 1;
    }
    string plaintext = get_string("Plaintext: ");

    int key = atoi(argv[1]);

    printf("Ciphertext: ");

    for (int i = 0; i < strlen(plaintext); i++)
    {
        if (plaintext[i] > 64 && plaintext[i] < 91)
        {
          int temp_int = (int) plaintext[i] - 65;
          temp_int = (temp_int + key) % 26;
          temp_int = temp_int + 65;
          printf("%c", (char) temp_int);
        }
        else if (plaintext[i] > 96 && plaintext[i] < 123)
        {
          int temp_int = (int) plaintext[i] - 97;
          temp_int = (temp_int + key) % 26;
          temp_int = temp_int + 97;
          printf("%c", (char) temp_int);
        }
        else
        {
        printf("%c", plaintext[i]);
        }
    }

    printf("\n");
}
