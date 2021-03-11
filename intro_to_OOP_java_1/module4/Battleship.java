import java.util.Scanner;
public class Battleship
{
	public static void main(String[] args)
	{
			System.out.println("Welcome to Battleship");
			inputBattleship();

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

	public static void inputBattleship()
	{
		int boardRow = 5;
		int boardCol = 5;
		Scanner input = new Scanner(System.in);
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
						if ((ship[i][0] >= 0) && (ship[i][0] <= 4) && (ship[i][1] >= 0) && (ship[i][1] <= 4))
						{
							incorrectInput = false;
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


			// Check if coordinates are already occupied


		}

	}

}
