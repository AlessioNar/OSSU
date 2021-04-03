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
    this(name, (int) (ageInYears * 12), tongueSpeed);
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
  public void grow() {
    this.grow(1);
  }

  public void grow(int months) {
    // Adjust tongueSpeed
    for (int i = 0; i < months; i++) {
      this.age++;
      if (this.age <= 12) {
        this.tongueSpeed++;
      } else if (this.age > 30 && this.tongueSpeed > 5) {
        this.tongueSpeed--;
      }
    }
    // Check if it is a froglet
    if (this.age > 1 && this.age < 7) {
      this.isFroglet = true;
    } else {
      this.isFroglet = false;
    }
  }

  public void eat(Fly food) {
    if(food.isDead()) {
      return;
    }
    if (this.tongueSpeed > food.getSpeed()) {
      if (food.getMass() > (age * 0.5)) {
        this.grow();
      }
      food.setMass(0);
    } else {
      food.grow(1);
    }
  }

  public String toString() {
    if (this.isFroglet == true) {
      return "My name is " + name + " and I’m a rare froglet! I’m "+ age + " months old and my tongue has a speed of " + tongueSpeed + ".";
    } else {
      return "My name is "+ name + " and I’m a rare frog. I’m "+ age + " months old and my tongue has a speed of " + tongueSpeed + ".";
    }
  }


  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

}
