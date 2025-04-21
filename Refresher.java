import org.code.theater.*;
import org.code.media.*;

public class Refresher extends Drink {

  /*
   * Instance Variables
   */
  private String type;  // The type of tea

  /**
   * Constructs a new Refresher with the specified size, price, and type of tea.
   * @param size  The size of the drink
   * @param price The price of the drink
   * @param type The type of tea used in the refresher
   */
  public Refresher(double price, String size, String type) {
    super(size, price);
    this.type = type;
  }

  /**
   * Returns the type of tea used in the refresher.
   * @return The type of tes used in the refresher as a String
   */
  public String getType() {
    return type;
  }
  
}