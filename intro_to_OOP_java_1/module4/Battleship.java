import java.util.Scanner;
public class Battleship
{
	public static int BOARD_DIM = 3;
	public static int NUM_SHIP = 5;

	public static void main(String[] args)
	{

			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to Battleship");

			System.out.println("Enter name player 1:");
			String name1 = input.next();

			System.out.println("Enter name player 2:");
			String name2 = input.next();
			// Initialize player maps

			char player1[][] = new char[BOARD_DIM][BOARD_DIM];
			char player2[][] = new char[BOARD_DIM][BOARD_DIM];
			char public1[][] = new char[BOARD_DIM][BOARD_DIM];
			char public2[][] = new char[BOARD_DIM][BOARD_DIM];

			for (int i = 0; i < BOARD_DIM; i++)
			{
				for (int j = 0; j< BOARD_DIM; j++)
				{
					public1[i][j] = '-';
					public2[i][j] = '-';
				}
			}

			System.out.printf("Player %s: enter ship coordinates\n", name1);

			player1 = inputBattleship(input);
			printBoard(player1);

			for (int i=0; i< 100; i++)
			{
				System.out.println("");
			}
			System.out.printf("Player %s: enter ship coordinates\n", name2);
			player2 = inputBattleship(input);
			printBoard(player2);

			for (int i=0; i< 100; i++)
			{
				System.out.println("");
			}

			while((checkWin(public1) == false) && (checkWin(public2) == false))
			{
					public1 = hit(player1, public1, input, "1");
					printBoard(public1);

					public2 = hit(player2, public2, input, "2");
					printBoard(public2);
			}

			if (checkWin(public1) == true && checkWin(public2) == true)
			{
				System.out.println("It's a tie! Nobody wins.");
			}
			else if (checkWin(public1) == true)
			{
				System.out.println("%s wins!", name1);
			}
			else if (checkWin(public2) == true)
			{
				System.out.println("%s wins!", name2);
			}
	}

	public static char[][] inputBattleship(Scanner input)
	{

		// Initialize vector and coordinate placeholder

		char map[][] = new char[BOARD_DIM][BOARD_DIM];
		int x_coord, y_coord;

		for (int i = 0; i < BOARD_DIM; i++)
		{
			for (int j = 0; j< BOARD_DIM; j++)
			{
				map[i][j] = '-';
			}
		}


		// Gather five ships
		for (int i = 0; i < NUM_SHIP; i++)
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
		if ((x_coord >= 0) && (x_coord <= (BOARD_DIM -1)) && (y_coord >= 0) && (y_coord <= (BOARD_DIM - 1)))
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
		System.out.printf("  ");
		for (int i = 0; i < BOARD_DIM; i++)
		{
			System.out.printf("%d ", i);
		}
		System.out.printf("\n");
		for (int i = 0; i < BOARD_DIM; i++)
		{
			System.out.printf("%d", i);
			for (int j = 0; j < BOARD_DIM; j++)
			{
				System.out.printf(" " + player[i][j]);
			}
			System.out.printf("\n");
		}
	}

	public static char[][] hit(char[][] privateBoard, char[][] publicBoard, Scanner input, String player)
	{
		System.out.printf("Player %s, enter hit row/column:\n", player);
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
						if (publicBoard[x_coord][y_coord] == 'O' | publicBoard[x_coord][y_coord] == 'X')
						{
							System.out.println("You already fired on this spot. Choose different coordinates.");
							continue;
						}
						else if (privateBoard[x_coord][y_coord] == '@')
						{
							publicBoard[x_coord][y_coord] = 'X';
							System.out.printf("PLAYER %s HIT A SHIP!\n", player);
							incorrectInput = false;
						}
						else if (privateBoard[x_coord][y_coord] == '-')
						{
							publicBoard[x_coord][y_coord] = 'O';
							System.out.printf("PLAYER %s MISSED!\n", player);
							incorrectInput = false;
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
		return publicBoard;
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
