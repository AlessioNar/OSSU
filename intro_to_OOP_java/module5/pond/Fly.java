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
    return this.mass;
  }
  public double getSpeed() {
    return this.speed;
  }

  public void setMass(float mass) {
    if(mass >= 0) {
      this.mass = mass;
    }
  }
  public void setSpeed(double speed) {
    if(speed >= 0) {
      this.speed = speed;
    }
  }

  public String toString() {
    if (mass == 0) {
      return "I'm dead, but I used to be a fly with a speed of " + speed + ".";
    } else {
      return "I'm a speedy fly with " + speed + " speed and " + mass + " mass.";
    }
  }

  public void grow(int mass) {

    for (int i = 0; i < mass; i++) {
      this.mass++;
      if (this.mass < 20) {
        this.speed = this.speed + 1;
      } else {
        this.speed = this.speed - 0.5;
      }
    }
  }

  public boolean isDead() {
    if (this.mass == 0) {
      return true;
    } else {
      return false;
    }
  }

}
