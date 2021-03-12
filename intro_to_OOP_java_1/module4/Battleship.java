import java.util.Scanner;
public class Battleship
{
	public static void main(String[] args)
	{
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to Battleship");

			// Initialize player maps

			char player1[][] = new char[5][5];
			char player2[][] = new char[5][5];

			System.out.println("Player 1: enter coordinates");

			player1 = inputBattleship(input);
			printBoard(player1);

			System.out.println("Player 2: enter coordinates");
			player2 = inputBattleship(input);
			printBoard(player2);

			while((checkWin(player1) == false) && (checkWin(player2) == false))
			{
					player1 = hit(player1, input);
					printBoard(player1);

					player2 = hit(player2, input);
					printBoard(player2);
			}

			if (checkWin(player1) == true)
			{
				System.out.println("Player 1 wins!");
			}

			if (checkWin(player2) == true)
			{
				System.out.println("Player 2 wins!");
			}
	}

	public static char[][] inputBattleship(Scanner input)
	{

		// Initialize vector and coordinate placeholder

		char map[][] = new char[5][5];
		int x_coord, y_coord;

		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j< 5; j++)
			{
				map[i][j] = '-';
			}
		}


		// Gather five ships
		for (int i = 0; i < 5; i++)
		{
			System.out.println("Enter ship " + (i+1) + " location:");

			boolean incorrectInput = true;

			while(incorrectInput)
			{
				// First verify that the coordinates are integers
				if (input.hasNextInt())
				{
					x_coord = input.nextInt();

					if (input.hasNextInt())
					{
						y_coord = input.nextInt();

						// Then verify that they are in the map
						if (isInMap(x_coord, y_coord) == true)
						{
							if (map[x_coord][y_coord] != '@')
							{
								map[x_coord][y_coord] = '@';
								incorrectInput = false;
							}
							else
							{
								System.out.println("You already have a ship there. Choose different coordinates.");
								input.next();
								System.out.println("Enter ship " + (i+1) + " location:");
								continue;
							}
						}
						else
						{
							System.out.printf("Invalid coordinates. Choose different coordinates.\n");
							input.next();
							System.out.println("Enter ship " + (i+1) + " location:");
							continue;
						}
					}
				}
				else
				{
					System.out.printf("Invalid coordinates. Choose different coordinates.\n");
					input.next();
					System.out.println("Enter ship " + (i+1) + " location:");
					continue;
				}

			}

		}
		return map;
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

	public static void printBoard(char[][] player)
	{
		System.out.println("  0 1 2 3 4");
		for (int i = 0; i < 5; i++)
		{
			System.out.printf("%d", i);
			for (int j = 0; j < 5; j++)
			{
				System.out.printf(" " + player[i][j]);
			}
			System.out.printf("\n");
		}
	}

	public static char[][] hit(char[][] board, Scanner input)
	{
		System.out.println("Player 1, enter hit row/column:");
		int x_coord, y_coord;

		boolean incorrectInput = true;

		while(incorrectInput)
		{
			// First verify that the coordinates are integers
			if (input.hasNextInt())
			{
				x_coord = input.nextInt();

				if (input.hasNextInt())
				{

					y_coord = input.nextInt();

					if (isInMap(x_coord, y_coord) == true)
					{
						if (board[x_coord][y_coord] == '-')
						{
							board[x_coord][y_coord] = 'O';
							System.out.println("PLAYER [NUM] MISSED!");
							incorrectInput = false;
						}
						else if (board[x_coord][y_coord] == '@')
						{
							board[x_coord][y_coord] = 'X';
							System.out.println("PLAYER [NUM A] HIT PLAYER [NUM B]’s SHIP!");
							incorrectInput = false;
						} else if (board[x_coord][y_coord] == 'O' | board[x_coord][y_coord] == 'X')
						{
							System.out.println("You already fired on this spot. Choose different coordinates.");
							continue;
						}
					}
					else
					{
						System.out.printf("Invalid coordinates. Choose different coordinates.\n");
						input.next();
						continue;
					}

				}
				else
				{
						System.out.printf("Invalid coordinates. Choose different coordinates.\n");
						input.next();
						continue;
				}
			}
			else
			{
				System.out.printf("Invalid coordinates. Choose different coordinates.\n");
				input.next();
				continue;
			}
		}
		return board;
	}

	public static boolean checkWin(char[][] board)
	{
		int counter = 0;
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (board[i][j] == 'X')
				{
					counter = counter + 1;
				}
			}
		}

		System.out.printf("%d ships sunk\n", counter);

		if (counter == 5)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
}
