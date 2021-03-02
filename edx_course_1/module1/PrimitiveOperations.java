public class PrimitiveOperations{
  public static void main(String[] args){
    int variable1 = 23;
    double variable2 = 12.5;
    System.out.println(variable1);
    System.out.println(variable2);
    double total = variable1 * variable2;
    System.out.println(total);

    double float1 = variable1;
    System.out.println(float1);
    int integer2 = (int) variable2;
    System.out.println(integer2);

    char character = 'E';
    System.out.println(character);

    int lowerCharacter = (int) character + 32;
    System.out.println((char) lowerCharacter);

  }

}
