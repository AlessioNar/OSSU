public class ArraySearch
{
  public static void main(String args[])
  {
    String[] concepts = {"abstraction", "polymorphism",
                        "inheritance", "encapsulation"};

    System.out.println(searchStringArray("polymorphism", concepts));
    System.out.println(searchStringArray("abstraction", concepts));

  }

  public static boolean searchStringArray(String target, String[] array)
  {
    boolean result = false;
    for (String element : array)
    {
      if (element.equals(target))
      {
        result = true;
        break;
      }
    }
    return result;
  }

}
