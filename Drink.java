import org.code.theater.*;
import org.code.media.*;

public class Drink {

  /*
   * Instance Variables (different drink sizes and prices)
   */ 
  public String size; // The different sizes for the drinks
  public double price;  // The different prices for the drinks

  /**
   * Constructs a new Drink with the specified size and price.
   * @param size  The size of the drink
   * @param price The price of the drink
   */
  public Drink(String size, double price) {
    this.size = size;
    this.price = price;
  }

  /**
   * Returns the price of the drink.
   * @return The price as a double
   */
  public double getPrice() {
    return price;
  }

  /**
   * Returns the size of the drink.
   * @return The size as a String
   */
  public String getSize() {
    return size;
  }
}