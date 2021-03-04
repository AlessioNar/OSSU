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
        a = input.nextInt();
        b = input.nextInt();
        if (a == (int) a & b == (int) b)
        {
          int result = a + b;
          System.out.printf("Answer: %d\n", result);
          break;
        }
        else
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
      }
      case "subtract":
      {
        int a, b;
        System.out.print("Enter two integers: \n");
        a = input.nextInt();
        b = input.nextInt();
        if (a == (int) a & b == (int) b)
        {
          int result = a - b;
          System.out.printf("Answer: %d\n", result);
          break;
        }
        else
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
      }
      case "multiply":
      {
          double a, b;
          System.out.print("Enter two doubles: \n");
          a = input.nextDouble();
          b = input.nextDouble();
          if (a == (double) a & b == (double) b)
          {
            double result = a * b;
            System.out.printf("Answer: %.2f\n", result);
            break;
          }
          else
          {
            System.out.printf("Invalid input entered. Terminating...\n");
            break;
          }
      }
      case "divide":
      {
        double a, b;
        System.out.print("Enter two doubles: \n");
        a = input.nextDouble();
        b = input.nextDouble();

        if (a == (double) a & b == (double) b)
        {
          if (b == 0)
          {
            System.out.print("Invalid input entered. Terminating... \n");
          }
          else
          {
            double result = a / b;
            System.out.printf("Answer: %.2f\n", result);
          }
          break;
        }
        else
        {
          System.out.printf("Invalid input entered. Terminating...\n");
          break;
        }
      }
      case "alphabetize":
      {
        String a, b;
        System.out.print("Enter two words: \n");
        a = input.next();
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
