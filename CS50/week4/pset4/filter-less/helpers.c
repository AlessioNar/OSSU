#include "helpers.h"
#include <math.h>

// Convert image to grayscale
void grayscale(int height, int width, RGBTRIPLE image[height][width])
{
    for (int row = 0; row < height; row++)
    {
      for(int col = 0; col < width; col++)
      {
        // take current pixel
        RGBTRIPLE pixel = image[row][col];

        // find average
        int avg = round((pixel.rgbtBlue + pixel.rgbtGreen + pixel.rgbtRed) / 3.0);

        // assign it to RGB triples
        image[row][col].rgbtBlue = avg;
        image[row][col].rgbtGreen = avg;
        image[row][col].rgbtRed = avg;
      }
    }

    return;
}

// Convert image to sepia
void sepia(int height, int width, RGBTRIPLE image[height][width])
{

  // loop through pixels
  for (int row = 0; row < height; row++)
  {
    for(int col = 0; col < width; col++)
    {

      RGBTRIPLE pixel = image[row][col];

      // Compute sepia RGB
      int sepiaRed = round(.393 * pixel.rgbtRed + .769 * pixel.rgbtGreen + .189 * pixel.rgbtBlue);
      int sepiaGreen = round(.349 * pixel.rgbtRed + .686 * pixel.rgbtGreen + .168 * pixel.rgbtBlue);
      int sepiaBlue = round(.272 * pixel.rgbtRed + .534 * pixel.rgbtGreen + .131 * pixel.rgbtBlue);

      // Check if it is greater of 255
      if (sepiaRed > 255)
      {
        sepiaRed = 255;
      }
      if (sepiaGreen > 255)
      {
        sepiaGreen = 255;
      }
      if (sepiaBlue > 255)
      {
        sepiaBlue = 255;
      }

      image[row][col].rgbtBlue = sepiaBlue;
      image[row][col].rgbtGreen = sepiaGreen;
      image[row][col].rgbtRed = sepiaRed;
    }
  }

    return;
}

// Reflect image horizontally
void reflect(int height, int width, RGBTRIPLE image[height][width])
{
        // Create temporary buffer
        RGBTRIPLE temp[height][width];

        // Transformation
        for (int row = 0; row < height; row++)
        {
          int curPos = 0;
          for (int col = width - 1; col >=0; col--, curPos++)
          {
            temp[row][curPos] = image[row][col];
          }
        }

        // Copy to final image
        for (int row = 0; row < height; row++)
        {
          for (int col = 0; col < width; col++)
          {
            image[row][col] = temp[row][col];
          }
        }
  return;
}

// Blur image
void blur(int height, int width, RGBTRIPLE image[height][width])
{
    // Create temporary buffer
    RGBTRIPLE temp[height][width];

    // Blur box algorithm
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col < width; col++)
      {
        int counter = 0;
        int x[] = {row -1, row, row + 1};
        int y[] = {col -1, col, col + 1};

        float totalR = 0;
        float totalG = 0;
        float totalB = 0;

        for (int r = 0; r < 3; r++)
        {
          for (int c = 0; c < 3; c++)
          {
            int curRow = x[r];
            int curCol = y[c];
            if (curRow >= 0 && curRow < height && curCol >= 0 && curCol < width)
            {
              RGBTRIPLE pixel = image[curRow][curCol];
              totalR += pixel.rgbtRed;
              totalG += pixel.rgbtGreen;
              totalB += pixel.rgbtBlue;
              counter++;
            }
          }
        }
        temp[row][col].rgbtRed = round(totalR/counter);
        temp[row][col].rgbtGreen = round(totalG/counter);
        temp[row][col].rgbtBlue = round(totalB/counter);
      }
    }
    // Copy to final image
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col < width; col++)
      {
        image[row][col] = temp[row][col];
      }
    }
    return;
}
