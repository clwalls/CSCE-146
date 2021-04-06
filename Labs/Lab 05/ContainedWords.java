/**
 * Written by Christopher Walls.
 */
import java.util.Scanner;
public class ContainedWords {
  
  
  public static void main(String[] args) { 
    System.out.println("Enter 2 words. I will determine if the letters of "
                         + "one is contained in the other");
    Scanner keyboard = new Scanner(System.in);
    String firstWord = keyboard.nextLine();
    String secondWord = keyboard.nextLine();
    int index = secondWord.length()-1;
    keyboard.close();
    if(contained(firstWord, secondWord, index, 0, 0) ==true) 
         System.out.println("They are contained");

  }
  
  public static boolean contained(String firstWord, String secondWord, int index, int where, int equals) {
    if(firstWord.length()>secondWord.length())
      return false;
    if(firstWord.length()==0 && secondWord.length()==0)
      return false;
    boolean contains = true;
    System.out.println(index+" "+where);
    if(index==-1) {//checked first letter in entire second word, and didnt find.
      contains = false;
      System.out.println("They are not contained");
      return contains;
    }
    char in = firstWord.charAt(where);
    char word = secondWord.charAt(index);
    if(in == word) {
      System.out.println("equal");
      equals++;
      contains = true;
      index=secondWord.length()-1;
      if(equals==firstWord.length()-1)
        return contains;
    }
    else
      contains = false;
    if(contains==true) {
      if(index>=0) {
        System.out.println("index down");
        where = 0;
        index--;
        contained(firstWord, secondWord, index, where, equals);
      }
      else 
        return contains;
    }
      else if(contains!=true) {//moves on to check next letter
        if(where<=firstWord.length()-1) {
          where++;
          System.out.println("where up");
          contained(firstWord, secondWord, index, where, equals);
        }
        else 
          return contains;
      }
    return contains;
  }
  
}
