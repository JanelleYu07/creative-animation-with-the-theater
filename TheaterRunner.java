import org.code.theater.*;
import org.code.media.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/*
* Get's the user's input and randomly generates a coffee or a refresher depending on the user's input
*/
public class TheaterRunner {
  public static void main(String[] args) {

    MyScene scene = new MyScene();
    scene.drawScene();

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    // Gets the menus from the txt files
    ArrayList<String> espressoMenu = FileReader.toStringList("espressoMenu.txt");
    ArrayList<String> refresherMenu = FileReader.toStringList("refresherMenu.txt");

    // Get's user input on which random drink they want
    System.out.println("Welcome!");
    System.out.println("Would you like a random coffee or a random refresher?");
    String choice = scanner.next().toLowerCase();

    // Default values
    Drink randomDrink = null;
    String name = "";
    String extraInfo = "";
    String imageFile = "";

    // Generates a random coffee
    if (choice.equals("coffee")) {
      String line = espressoMenu.get(rand.nextInt(espressoMenu.size()));
      String[] parts = line.split(", ");
      name = parts[0];

      int sizeIndex = getValidSizeIndex(parts);
      if (sizeIndex == -1) {
        System.out.println("Sorry, there are no available sizes for this drink.");
        return;
      }
      
      String size = getSizeFromIndex(sizeIndex);
      double price = Double.parseDouble(parts[sizeIndex + 1]);
      int espressoShots = rand.nextInt(3) + 1;
      randomDrink = new Coffee(price, size, espressoShots);

      extraInfo = espressoShots + " espresso shot(s)";
      imageFile = "coffee.png";

      System.out.println("You got a: " + size + " " + name + " with " + extraInfo + " - $" + price);

      // Generates a random refresher
    } else if (choice.equals("refresher")) {
      String line = refresherMenu.get(rand.nextInt(refresherMenu.size()));
      String[] parts = line.split(", ");
      name = parts[0];

      int sizeIndex = getValidSizeIndex(parts);
      if (sizeIndex == -1) {
        System.out.println("Sorry, there are no available sizes for this drink.");
        return;
      }
      
      String size = getSizeFromIndex(sizeIndex);
      double price = Double.parseDouble(parts[sizeIndex + 1]);
      String[] teaOptions = {"Green Tea", "Black Tea", "Hibiscus", "Passionfruit", "Peach"};
      String teaType = teaOptions[rand.nextInt(teaOptions.length)];
      randomDrink = new Refresher(price, size, teaType);

      extraInfo = teaType;
      imageFile = "tea.png";

      System.out.println("You got a: " + size + " " + name + " with " + extraInfo + " - $" + price);
      
    } else {
      System.out.println("Invalid! Please enter 'coffee' or 'refresher'!");
      return;
    }

    // Adds the image and text onto the screen
    scene.pause(0.5);
    scene.drawImage(imageFile, 250, 70, 70);
    scene.pause(0.5);
    scene.setTextHeight(15);
    scene.setTextColor("purple");
    scene.drawText("Enjoy your " + randomDrink.size, 230, 190);
    scene.drawText(name + "!", 230, 210);
    scene.pause(0.5);
    scene.drawText("Extras: " + extraInfo, 210, 230);
    Theater.playScenes(scene);

  }

    /**
    * Returns a random index that corresponds to the drink sizes. 
    * If the size is N/A, it skips over the drink.
    * Runs a maximum od two times. 
    * @param parts An array of strings from either of the drink menu lines, where index 1–3 are prices or "N/A"
    * @return A number 0-2 that corresponds to the drink sizes or -1
    */
    private static int getValidSizeIndex(String[] parts) {
      Random rand = new Random();
        for (int attempts = 0; attempts < 2; attempts++) {
          int randomIndex = rand.nextInt(3); 
          if (!parts[randomIndex + 1].equals("N/A")) {
            return randomIndex;
          }
        }
      return -1; 
    }
    

    /**
    * Returns a String of the drink size based on the int index
    * @param index The index of the drink which corresponds to the size
    * @return The size as a String or "Unknown Size"
    */
    private static String getSizeFromIndex(int index) {
      if (index == 0) {
        return "Small";
      } else if (index == 1) {
        return "Medium";
      } else if (index == 2) {
        return "Large";
      } else {
        return "Unknown Size";
      }
    }
}