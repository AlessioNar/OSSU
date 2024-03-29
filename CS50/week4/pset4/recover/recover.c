#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <stdbool.h>

typedef uint8_t byte;

bool is_jpg(byte *buffer);

int BUFFER_SIZE = 512;

int main(int argc, char *argv[])
{

  // Verify usage
  if (argc != 2)
  {
    printf("Usage: ./recover image\n");
    return 1;
   }

 // Open file
 FILE *f = fopen(argv[1], "r");

 // Check whether the file is valid
 if (f == NULL)
 {
        printf("Could not open %s.\n", argv[1]);
        return 2;
 }

 // Declare buffer of length 512
 byte buffer[BUFFER_SIZE];

 FILE *img;
 bool jpg_found = false;
 int counter = 0;
 char filename[8];

 // While the file returns exactly 512 bits
 while(fread(buffer, BUFFER_SIZE, 1, f) == 1)
 {
   // If we find the header of a jpg file
   if (is_jpg(buffer))
   {
     // If we have already found a jpg file
     if(jpg_found == true)
     {
       // We close the previous jpg file
       fclose(img);
     }
     else
     {
        // Otherwise set jpg_found to true
        jpg_found = true;
     }

     // We write the header of the new jpg file into a new file
     sprintf(filename, "%03d.jpg", counter);
     img = fopen(filename, "w");
     fwrite(buffer, BUFFER_SIZE, 1, img);

     counter++;
   }
   // We proceed in writing the body of a new picture
   else if (jpg_found == true)
   {
        fwrite(buffer, BUFFER_SIZE, 1, img);
   }
 }

 fclose(f);
 fclose(img);
}

bool is_jpg(byte *buffer)
{
    if (buffer[0] == 0xff && buffer[1] == 0xd8 && buffer[2] == 0xff && (buffer[3] & 0xf0) == 0xe0)
    {
        return true;
    }
    else
    {
        return false;
    }
}
