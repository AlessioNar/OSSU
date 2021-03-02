public class StringOperations{
  public static void main(String[] args){
    String name = "Alessio";
    System.out.println(name);
    name = name.substring(1, name.length());
    name = 'A' + name;
    name = name.substring(0, name.length()-1);
    name = name + 'Z';
    System.out.println(name);
    String google = "www.google.com";
    System.out.println(google);

    google = google.replace("www.", "");
    google = google.replace(".com", "");
    System.out.println(google + 1331);

  }
}
