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
        int avg = round(pixel.rgbtBlue + pixel.rgbtGreen + pixel.rgbtRed) / 3.0;

        // assign it to RGB triples
        image[row][col].rgbtBlue = avg;
        image[row][col].rgbtGreen = avg;
        image[row][col].rgbtRed = avg;
      }
    }

    return;
}

/// Reflect image horizontally
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
      for (int col = 0; col < height; col++)
      {
        int counter = 0;
        int x[] = {row -1, row, row + 1};
        int y[] = {col -1, col, col + 1};

        float totalR = 0, totalG = 0, totalB = 0;

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
      for (int col = 0; col < height; col++)
      {
        image[row][col] = temp[row][col];
      }
    }
    return;
}


// Detect edges
void edges(int height, int width, RGBTRIPLE image[height][width])
{
  RGBTRIPLE temp[height][width];

  // Apply the Sobel algorithm

  // Initialize kernels
  int Gx[3][3] =
  {
      {-1, 0, 1},
      {-2, 0, 2},
      {-1, 0, 1}
  };

  int Gy[3][3] =
  {
      {-1, -2, -1},
      { 0,  0,  0},
      { 1,  2,  1}
  };

  for (int row = 0; row < height; row++)
  {
    for (int col = 0; col < width; col++)
    {
      int x[] = {row -1, row, row + 1};
      int y[] = {col -1, col, col + 1};

      float Gx_red = 0, Gx_green = 0, Gx_blue = 0;
      float Gy_red = 0, Gy_green = 0, Gy_blue = 0;

      for (int r = 0; r < 3; r++)
      {
        for (int c = 0; c < 3; c++)
        {
          int curRow = x[r];
          int curCol = y[c];
          if (curRow >= 0 && curRow < height && curCol >= 0 && curCol < width)
          {
            RGBTRIPLE pixel = image[curRow][curCol];

            Gx_red += Gx[r][c] * pixel.rgbtRed;
            Gx_green += Gx[r][c] * pixel.rgbtGreen;
            Gx_blue += Gx[r][c] * pixel.rgbtBlue;

            Gy_red += Gy[r][c] * pixel.rgbtRed;
            Gy_green += Gy[r][c] * pixel.rgbtGreen;
            Gy_blue += Gy[r][c] * pixel.rgbtBlue;
          }
        }
      }

      int finalRed = round(sqrt(Gx_red * Gx_red + Gy_red * Gy_red));
      int finalGreen = round(sqrt(Gx_green * Gx_green + Gy_green * Gy_green));
      int finalBlue = round(sqrt(Gx_blue * Gx_blue + Gy_blue * Gy_blue));

      // Check if it is greater of 255
      if (finalRed > 255)
      {
        finalRed = 255;
      }
      if (finalGreen > 255)
      {
        finalGreen = 255;
      }
      if (finalBlue > 255)
      {
        finalBlue = 255;
      }

      temp[row][col].rgbtRed = finalRed;
      temp[row][col].rgbtGreen = finalGreen;
      temp[row][col].rgbtBlue = finalBlue;
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
