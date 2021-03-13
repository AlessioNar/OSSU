import java.util.Scanner;
public class Battleship
{
	public static int BOARD_DIM = 9;
	public static int NUM_SHIP = 3;

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
					public1 = launchTorpedo(player1, public1, input, name1);
					printBoard(public1);

					public2 = launchTorpedo(player2, public2, input, name2);
					printBoard(public2);
			}

			if (checkWin(public1) == true && checkWin(public2) == true)
			{
				System.out.println("It's a tie! Nobody wins.");
			}
			else if (checkWin(public1) == true)
			{
				// Here i could put a functionality that provides a textual effect depending on
				
				System.out.printf("%s\n", name1);
			}
			else if (checkWin(public2) == true)
			{
				System.out.printf("%s wins!\n", name2);
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

	public static char[][] launchTorpedo(char[][] privateBoard, char[][] publicBoard, Scanner input, String player)
	{
		int x_coord, y_coord;
		boolean incorrectInput = true;

		while(incorrectInput)
		{
			System.out.printf("Choose two coordinates - %s's TUBES ARE OPENING...  ", player);
			// First verify that both coordinates are integers
			if (input.hasNextInt())
			{
				x_coord = input.nextInt();

				if (input.hasNextInt())
				{
					y_coord = input.nextInt();

					// Check if it is in map
					if (isInMap(x_coord, y_coord) == true)
					{

					// Now x and y are available. I have to find a nicer way to do this
						if (publicBoard[x_coord][y_coord] == 'O' | publicBoard[x_coord][y_coord] == 'X')
						{
							System.out.println("You already fired on this spot. Choose different coordinates.");
							continue;
						}
						else {

									System.out.printf("PLAYER %s, SHOT A TORPEDO at %d.231 NORD %d.425 EST \n", player.toUpperCase(), x_coord, y_coord);

									if (privateBoard[x_coord][y_coord] == '@')
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
					}
					else
					{
						// closes the if in the map range
						System.out.printf("Invalid coordinates. Choose different coordinates - 0-%d, 0-%d\n", BOARD_DIM, BOARD_DIM);
						input.next();
						continue;
					}

				}
				else
				{
					  // close 2nd integer
						System.out.printf("Invalid coordinates. Choose different coordinates - 0-%d, 0-%d\n", BOARD_DIM, BOARD_DIM);
						input.next();
						continue;
				}
			}
			else
			{
				// closes 1st integer
				System.out.printf("Invalid coordinates. Choose different coordinates - 0-%d, 0-%d\n", BOARD_DIM, BOARD_DIM);
				input.next();
				continue;
			}
		}
		// return board
		return publicBoard;
	}

// At the end of the turn, check if  one of the player won by counting how many
// X they have
	public static boolean checkWin(char[][] board)
	{
		int counter = 0;

		for (int i = 0; i < BOARD_DIM; i++)
		{
			for (int j = 0; j < BOARD_DIM; j++)
			{
				if (board[i][j] == 'X')
				{
					counter++;
				}
			}
		}

		if (counter == NUM_SHIP)
		{
			return true;
		}
		return false;
	}
}
