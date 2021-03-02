import java.util.Scanner;

public class FahrenheitToCelsius {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Fahrenheit value: ");
    int fahrenheit = input.nextInt();
    System.out.print("Enter a day of the week: ");
    String day = input.next();
    System.out.println("Enter your preferred Celsius label (Celsius, Centigrade, or C): ");
    String cText = input.next();
    double celsius = (5.0/9) * (fahrenheit - 32);
    System.out.printf("%s Fahrenheit: %d\n", day, fahrenheit);
    System.out.printf("%s %-10s: %.2f\n", day, cText, celsius);
    if (fahrenheit >= 70)
      System.out.println("Yay! Go to the park.");
    
  }
}
