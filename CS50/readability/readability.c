#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

float per_word(int value, int words);

int main(void){

  string text = get_string("Text: ");
  int letters = 0;
  int words = 1;
  int sentences = 0;
  int length = strlen(text);
  for (int i = 0; i < length; i++){

    text[i] = tolower(text[i]);

    // check if it is a letter
    if (text[i] > 95 & text[i] < 123)
    {
      letters  = letters + 1;
    }

    if (text[i] == 32)
    {
      words  = words + 1;
    }
    if (text[i] == 46 || text[i] == 33 || text[i] == 63){
      sentences  = sentences + 1;
    }

  }
  if (sentences == 0){
    sentences = 1;
  }
  printf("%d Letter(s)\n", letters);
  printf("%d Word(s)\n", words);
  printf("%d Sentence(s)\n", sentences);

  float avg_let = per_word(letters, words);
  float avg_sent = per_word(sentences, words);

  float index = 0.0588 * avg_let - 0.296 * avg_sent - 15.8;

  printf("The Coleman-Liau index is: %f\n", index);
}

float per_word(int value, int words)
{
    float avg = (value/(float) words) * 100;
    float rounded_avg = round(avg);
    return avg;
}
