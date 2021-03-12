import java.util.Scanner;
public class Battleship
{
	public static void main(String[] args)
	{
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to Battleship");
			int player1[][] = new int[5][2];
			int player2[][] = new int[5][2];
			printBoard();
			System.out.println("Player1: enter coordinates");
			player1 = inputBattleship(input);

			// Here I print the Board

			// 100 empty lines
			/*for (int i = 0; i < 100; i++)
			{
				System.out.println("");
			}*/

			System.out.println("Player2: enter coordinates");
			player2 = inputBattleship(input);

	}

	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player)
	{
		System.out.print("  ");
		for (int row = -1; row < 5; row++)
		{
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

	public static int[][] inputBattleship(Scanner input)
	{

		int boardRow = 5;
		int boardCol = 5;
		int ship[][] = new int[5][2];

		for (int i = 0; i < 5; i++)
		{
			System.out.println("Enter ship " + (i+1) + " location:");

			boolean incorrectInput = true;

			while(incorrectInput)
			{
				// First verify that the coordinates are integers
				if (input.hasNextInt())
				{
					ship[i][0] = input.nextInt();

					if (input.hasNextInt())
					{
						ship[i][1] = input.nextInt();

						// Then verify that they are in the map
						if (isInMap(ship[i][0], ship[i][1]) == true)
						{
							if (isPresent(ship, ship[i][0], ship[i][1], i) == false)
							{
								incorrectInput = false;
							}
							else
							{
								System.out.println("You already have a ship there. Choose different coordinates.");
								System.out.println("Enter ship " + (i+1) + " location:");
							}
						}
						else
						{
							System.out.printf("Invalid coordinates. Choose different coordinates.\n");
							System.out.println("Enter ship " + (i+1) + " location:");
						}
					}
				}
				else
				{
					input.next();
					System.out.printf("Invalid coordinates. Choose different coordinates.\n");
					System.out.println("Enter ship " + (i+1) + " location:");
				}

			}

		}
		return ship;
	}

	public static boolean isInMap(int x_coord, int y_coord)
	{
		if ((x_coord >= 0) && (x_coord <= 4) && (y_coord >= 0) && (y_coord <= 4))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isPresent(int[][] array, int x_coord, int y_coord, int iteration)
	{
		for(int i = 0; i < iteration; i++)
		{
			if ((x_coord == array[i][0]) && (y_coord == array[i][1]))
			{
				return true;
			}
		}
		return false;
	}
	public static void printBoard()
	{
		System.out.println("  0 1 2 3 4");
		for (int i = 0; i < 5; i++)
		{
			System.out.println(i + " - - - - -");
		}
	}
}
