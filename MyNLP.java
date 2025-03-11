import java.util.ArrayList;
import java.util.Scanner;
/**
 * Javadoc example
 * @param parameter1 the first parameter
 * @return what is returned from this method
 */
public class MyNLP {

  // TODO: Create 1-2 meaningful ArrayList 
ArrayList<String> McFood = FileReader.toStringList("McFood.txt");
ArrayList<Integer> Calories = FileReader.toIntList("Calories.txt");
  private String userInput;
  // TODO: assigned initial values for your instance variables
  public MyNLP() {
    
  }

public ArrayList<String> findFoodByUserInput(String userWord) {
    ArrayList<String> returnList = new ArrayList<String>();
    userWord = userWord.toLowerCase().trim(); // Normalize input
 // 1. Use a for-loop to iterate over all of the McFoods
    for (int i = 0; i < McFood.size(); i++) {
 // 2. Get the current McFood items ( use the .get(i) )
      String foodItem = McFood.get(i);
        int calories = Calories.get(i);
 // 3. Use the .split(" ") on the current McFood item to make a String[] mcFoodWords
        String[] mcFoodWords = foodItem.toLowerCase().split(" "); // Split into words
 // 4. Iterate over the String[] mcFoodWords
      for (String word : mcFoodWords) {
// 5. If the mcFoodWord equals userWord, add that McFood item to the returnArray 
      if (word.trim().equals(userWord)) { // Trim & compare words
                returnList.add(foodItem + " - " + calories + " calories");
                break; // No need to check further, we found a match
            }
        }
    }
    return returnList;
}



  /**
   * Starts the app and gets user input
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to McDonalds! What would you like to order?");
    userInput = input.nextLine();

    ArrayList<String> McFoodOptions = findFoodByUserInput(userInput);

    printSummary(McFoodOptions);
    
    input.close();
  }

  /**
   * Prints the summary of my NLP project
   */
  public void printSummary(ArrayList<String> options) {
    if (options.size() == 0) {
      System.out.println("Sorry there are no options for " + userInput);
    } else {
      System.out.println("Here are some similar items to: " + userInput);
      // TODO: iterate over the option and print the results;
      for (String opt : options) {
        System.out.println(opt);
      }
    }
  }

}