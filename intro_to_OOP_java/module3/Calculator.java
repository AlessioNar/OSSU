import java.util.Scanner;

public class Calculator
{
  public static void main(String[] args)
  {

    System.out.println("List of operations: add subtract multiply divide alphabetize");
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an operation: ");
    String operation = input.next();
    operation = operation.toLowerCase();

    // Switch statement
    switch(operation)
    {
      case "add":
      {
        int a, b;
        System.out.print("Enter two integers: \n");

        if (!input.hasNextInt())
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        a = input.nextInt();

        if (!input.hasNextInt())
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        b = input.nextInt();

        int result = a + b;
        System.out.printf("Answer: %d\n", result);
        break;
      }
      case "subtract":
      {
        int a, b;

        System.out.print("Enter two integers: \n");

        if (!input.hasNextInt())
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        a = input.nextInt();

        if (!input.hasNextInt())
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        b = input.nextInt();

        int result = a - b;
        System.out.printf("Answer: %d\n", result);
        break;

      }
      case "multiply":
      {
        double a, b;

        System.out.print("Enter two doubles: \n");

        if (!input.hasNextDouble())
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        a = input.nextDouble();

        if (!input.hasNextDouble())
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        b = input.nextDouble();

        double result = a * b;
        System.out.printf("Answer: %d\n", result);
        break;
      }
      case "divide":
      {
        double a, b;
        System.out.print("Enter two doubles: \n");

        if (!input.hasNextDouble())
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        a = input.nextDouble();

        if (!input.hasNextDouble())
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        b = input.nextDouble();

        if (b == 0)
        {
          System.out.print("Invalid input entered. Terminating... \n");
        }
        else
        {
          double result = a * b;
          System.out.printf("Answer: %d\n", result);
        }
          break;
        }

      case "alphabetize":
      {
        String a, b;
        System.out.print("Enter two words: \n");
        // Here i need to validate inputs for words containing only letters

        if(!input.hasNext("[a-zA-Z]+"))
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        a = input.next();
        if(!input.hasNext("[a-zA-Z]+"))
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
        b = input.next();
        char a_init = a.charAt(0);
        char b_init = b.charAt(0);

        a_init = Character.toLowerCase(a_init);
        b_init = Character.toLowerCase(b_init);

        if (a_init < b_init)
        {
          System.out.printf("Answer: %s comes before %s alphabetically.\n", a, b);
        }
        else if(b_init < a_init)
        {
          System.out.printf("Answer: %s comes before %s alphabetically.\n", b, a);
        }
        else
        {
          System.out.printf("Answer: Chicken or Egg.\n");
        }
        break;
      }
      default:
        System.out.printf("Invalid input entered. Terminating...\n");
        break;
      }

  }
}
