/**
 * Written by Christopher Walls.
 */
import java.util.Scanner;
public class Lab6test {
  
  
  public static void main(String[] args) { 
    System.out.println("Enter 2 words. I will determine if the letters of "
                         + "one is contained in the other");
    Scanner keyboard = new Scanner(System.in);
    String firstWord = keyboard.nextLine();
    String secondWord = keyboard.nextLine();
    keyboard.close();
    //checks initial conditions
    boolean contains = false;
    if(firstWord.length()>secondWord.length())
      contains = false;
    if(firstWord.length()==0)
      contains = true;
    
    for(int i=0; i<firstWord.length(); i++)
    {
      char in = firstWord.charAt(i);
      for(int j=0; j<secondWord.length(); j++)
      {
        char word = secondWord.charAt(j);
        if(in == word)
          contains = true;
      }
      if(contains!=true) {
        System.out.println("They are not contained");
        break;
      }
      if(i==firstWord.length()-1)
        System.out.println("They are contained!");
      contains = false;
    }
  }
  
  /* ADD YOUR CODE HERE */
  
}
