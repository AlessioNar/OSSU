public class Pond {
  public static void main (String[] args) {
    Frog frog1 = new Frog("Peepo");
    Frog frog2 = new Frog("Pepe", 10, 15);
    Frog frog3 = new Frog("Peepaw", 4.6, 5);
    System.out.println(frog1);
    System.out.println(frog3);

    Fly fly1 = new Fly(1, 3);
    Fly fly2 = new Fly(6);
    Fly fly3 = new Fly(12, 8);
    System.out.println(fly1.toString());
  }
}
