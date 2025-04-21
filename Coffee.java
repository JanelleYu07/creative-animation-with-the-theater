import org.code.theater.*;
import org.code.media.*;

public class Coffee extends Drink {

  /*
   * Instance Variables
   */
  private int espressoShots;  // Number of espresso shots

  /**
   * Constructs a new Coffee with the specified size, price, and number of espressoShots.
   * @param size  The size of the drink
   * @param price The price of the drink
   * @param espressoShots The number of espresso shots in the coffee
   */
  public Coffee(double price, String size, int espressoShots) {
    super(size, price);
    this.espressoShots = espressoShots;
  }

  /**
   * Returns the number of espresso shots in the coffee.
   * @return The number of espresso shots as an integer
   */
  public int getEspressoShots() {
    return espressoShots;
  }
}