#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char *argv[])
{
    // Check if only one argument is presented
    if (argc != 2){
      printf("Usage: ./substitution key \n");
      return 1;
    }

    string key = argv[1];

    // Check if key is of length 26
    if (strlen(key) != 26){
      printf("Key must contain 26 characters.\n");
      return 1;
    }

    // Check if only letters
    for (int i = 0; i < 26; i++){

      key[i] = tolower(key[i]);

      if (key[i] < 97 || key[i] > 122)
      {
        printf("Key must contain only alphabetical characters\n");
        return 1;
      }

          // Check for duplicate letters

        for (int j = i + 1; j < 26; j++)
        {
            if (key[i] == tolower(key[j]))
            {
              printf("The key must not contain duplicate letters.\n");
              return 1;
            }
        }
  }

  string plaintext = get_string("Plaintext: ");

  printf("Ciphertext: ");

  for (int i = 0; i < strlen(plaintext); i++)
  {
    // Check whether the provided character is upper or lower case
    if (plaintext[i] > 64 && plaintext[i] < 91)
    {
      int temp_int = (int) plaintext[i] - 65;
      printf("%c", toupper(key[temp_int]));
    }
    else if (plaintext[i] > 96 && plaintext[i] < 123)
    {
      int temp_int = (int) plaintext[i] - 97;
      printf("%c", key[temp_int]);
    }
    else
    {
    printf("%c", plaintext[i]);
    }
    }

    printf("\n");
}
