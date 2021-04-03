public class Frog {

  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private String species;

  private static final String DEFAULT_SPECIES = "Rare Pepe";
  private static final int DEFAULT_AGE = 5;
  private static final int DEFAULT_TONGUESPEED = 5;

  // Constructors
  public Frog(String name) {
    this(name, DEFAULT_AGE, DEFAULT_TONGUESPEED);
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this.name = name;
    this.age = (int) (ageInYears * 12);
    this.tongueSpeed = tongueSpeed;
    if (this.age > 1 && this.age < 7) {
      this.isFroglet = true;
    } else {
      this.isFroglet = false;
    }
    this.species = DEFAULT_SPECIES;
  }
  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    if (this.age > 1 && this.age < 7) {
      this.isFroglet = true;
    } else {
      this.isFroglet = false;
    }
    this.tongueSpeed = tongueSpeed;
    this.species = DEFAULT_SPECIES;
  }

  //  Methods
  public String toString() {
    if (isFroglet == true) {
      return "My name is " + name + " and I’m a rare froglet! I’m "+ age + " months old and my tongue has a speed of " + tongueSpeed + ".";
    } else {
      return "My name is "+ name + " and I’m a rare frog. I’m "+ age + " months old and my tongue has a speed of " + tongueSpeed + ".";
    }
  }

  public void grow() {
    age++;
    if (age < 12 && age > 4) {
      tongueSpeed++;
    } else if (age > 30) {
      tongueSpeed--;
    }
    // Check if it is a froglet
    if (age > 1 && age < 7) {
      isFroglet = true;
    } else {
      isFroglet = false;
    }
  }

  public void grow(int months) {
    // Adjust tongueSpeed
    for (int i = 0; i < months; i++) {
      age++;
      if (age < 12 && age > 4) {
        tongueSpeed++;
      } else if (age > 30) {
        tongueSpeed--;
      }
    }
    // Check if it is a froglet
    if (age > 1 && age < 7) {
      isFroglet = true;
    } else {
      isFroglet = false;
    }
  }

  public int eat(Fly food) {
    if(!(food.isDead())) {
      return 0;
    }
    if (tongueSpeed > food.getSpeed()) {
      if (food.getMass() > age * 0.5) {
        this.grow();
        food.setMass(0);
      }
    }
    return 0;

  }
}
