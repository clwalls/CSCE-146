/**
 * Written by Christopher Walls.
 */
import java.util.Scanner;
public class ShowcaseGame {
  
  
  public static void main(String[] args) {
    final String fileName = "prizeList.txt";
    Showcase showcase = new Showcase();
    
    Scanner kb = new Scanner(System.in);
    Boolean again = true;
    String userInput = "";
    int guess = -1;
    
    showcase.populateArray(fileName);
    while(again)
    {
      System.out.println("Welcome to the showcase show down!" +
                         "\nYour prizes are: ");
      showcase.constructShowcase();
      int showcasePrice = showcase.getShowcasePrice();
      showcase.printArray();
      //UNCOMMENT TO SEE PRICE
      //System.out.println(showcasePrice);
      while(isNumber(userInput)==false) {
        guess = 0;
        System.out.println("You must guess the total cost of all without going over" +
                           "\nEnter your guess");
        userInput = kb.nextLine();
      }
      guess = Integer.parseInt(userInput);
      System.out.println("You guessed " + guess + " the actual price is " + showcasePrice);
      if(guess<showcasePrice && (showcasePrice-2000)<=guess) {
        System.out.println("Your guess was under! You win!");
      }
      else if(guess>showcasePrice) {
        System.out.println("I'm sorry but that was over. . . You get nothing");
      }
      else if(guess<showcasePrice) {
        System.out.println("I'm sorry but that guess was bad. You lose for being bad.");
      }
      System.out.println("Would you like to play again? Enter 'no' to quit");
      userInput=kb.nextLine();
      if(userInput.equalsIgnoreCase("no")) {
        again = false;
        System.out.println("Goodbye");
      }
      userInput = "";
    }
    kb.close();
  }
  
  //METHODS
  //To see if userInput "guess" is a number.
  public static boolean isNumber(String str) {
    try
    {
      int i = Integer.parseInt(str);
    }
    catch(NumberFormatException a)
    {
      return false;
    }
    return true;
  }
  
  /* ADD YOUR CODE HERE */
  
}
