import java.util.Scanner;

public class Calculator
{
  public static int integers(String operation, Scanner input)
  {
    int a, b;
    System.out.print("Enter two integers: \n");
    a = input.nextInt();
    b = input.nextInt();
    int result = 0;
    switch(operation)
    {
      case "add":
        result = a + b;
        break;
      case "substract":
        result = a - b;
        break;
    }
    return result;
  }

  public static double doubles(String operation, Scanner input)
  {
    double a, b;
    System.out.print("Enter two doubles: \n");
    a = input.nextDouble();
    b = input.nextDouble();
    double result = 0;
    switch(operation)
    {
      case "multiply":
        result = a * b;
        break;
      case "divide":
        result = a / b;
        break;
    }
    return result;
  }


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
        int added = integers(operation, input);
        System.out.printf("Answer: %d\n", added);

      case "subtract":
        // code block
        int subtracted = integers(operation, input);
        System.out.printf("Answer: %d\n", subtracted);

      case "multiply":
          // code block
          double multiplied = doubles(operation, input);
          System.out.printf("Answer: %d\n", multiplied);

      case "divide":
            // code block
            double divided = doubles(operation, input);
            System.out.printf("Answer: %d\n", divided);

        break;
      case "alphabetize":
            // code block
        break;

      default:
        System.out.printf("Invalid input entered. Terminating...\n");
        break;
    // code block
    }
  }


}
