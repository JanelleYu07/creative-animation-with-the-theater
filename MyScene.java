import org.code.theater.*;
import org.code.media.*;

/**
* Splits up the data in the tct files based on drink name and prices for a small, medium, and large drink
* Prints out the menu with the corresponding prices to show the users their options
*/
public class MyScene extends Scene {

  // Instance Variables
  private String[][] espressoMenu;
  private String[][] refresherMenu;
  
  // Initializes the espresso and refresher menues
  public MyScene() {
    espressoMenu = createMenu();
    refresherMenu = createMenu2();
  }

  /**
   * Reads the items from "espressoMenu.txt" and stores them in a 2D array
   * @return A 2D String array representing the espresso menu
   */
  private String[][] createMenu() {
    String[] menuLines = FileReader.toStringArray("espressoMenu.txt");
    String[][] returnArray = new String[menuLines.length][4];
    for (int i = 0; i < returnArray.length; i++) {
      returnArray[i] = menuLines[i].split(", ");
    }
    return returnArray;
  }

  /**
   * Reads the items from "refresherMenu.txt" and stores them in a 2D array
   * @return A 2D String array representing the refresher menu
   */
  private String[][] createMenu2() {
    String[] menuLines2 = FileReader.toStringArray("refresherMenu.txt");
    String[][] returnArray = new String[menuLines2.length][4];
    for (int i = 0; i < returnArray.length; i++) {
      returnArray[i] = menuLines2[i].split(", ");
    }
    return returnArray;
  }
  
  // Combines the two methods that print the menu on the console and the method that draws the menu onto the screen
  public void drawScene() {
    printEspressoMenu();
    printRefresherMenu();
    drawImage("menu.png", 0, 0, 400);
  }

  /**
  * Prints the espresso menu on the console
  */
  private void printEspressoMenu() {
    System.out.println("Menu!");
    System.out.println("------------------Coffee-----------------");
    for (String[] beverage : espressoMenu) {
      System.out.println(beverage[0] + " - " + beverage[1] + " - " + beverage[2] + " - " + beverage[3]);
    }
    System.out.println("-----------------------------------------");
  }

  /**
  * Prints the refresher menu on the console
  */
  private void printRefresherMenu() {
    System.out.println("----------------Refresher----------------");
    for (String[] drink : refresherMenu) {
      System.out.println(drink[0] + " - " + drink[1] + " - " + drink[2] + " - " + drink[3]);
    }
    System.out.println("-----------------------------------------");
  }
}