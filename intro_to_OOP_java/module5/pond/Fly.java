public class Fly {
  private float mass;
  private double speed;

  // Stati constants/variables
  private static final float DEFAULT_MASS = 5;
  private static final double DEFAULT_SPEED = 10;

  // Constructors
  public Fly() {
    this(DEFAULT_MASS, DEFAULT_SPEED);
  }

  public Fly(float mass) {
    this(mass, DEFAULT_SPEED);
  }

  public Fly(float mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }

  public float getMass() {
    return mass;
  }
  public double getSpeed() {
    return speed;
  }

  public void setMass(float mass) {
    if(isLegalMass(mass)) {
      this.mass = mass;
    }
  }
  public void setSpeed(double speed) {
    if(isLegalSpeed(speed)) {
      this.speed = speed;
    }
  }

  public static boolean isLegalMass(float mass) {
    return (mass >= 0 ? true : false);
  }
  public static boolean isLegalSpeed(double speed) {
    return (speed >= 0 ? true : false);
  }

  public String toString() {
    if (mass == 0) {
      return "I'm dead, but I used to be a fly with a speed of " + speed + ".";
    } else {
      return "I'm a speedy fly with " + speed + " speed and " + mass + " mass.";
    }
  }

  public void grow(int newMass) {

    for (int i = 0; i < newMass; i++) {
      mass++;
      if (mass < 20) {
        speed++;
      } else {
        speed = speed - 0.5;
      }
    }
  }

  public boolean isDead() {
    if (mass == 0) {
      return true;
    } else {
      return false;
    }
  }

}
