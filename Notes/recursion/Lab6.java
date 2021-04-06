/**
 * Written by Christopher Walls.
 */
import java.util.Scanner;
public class Lab6 {
  
  public static void main(String[] args) { 
    System.out.println("Enter 2 words. I will determine if the letters of "
                         + "one is contained in the other");
    Scanner keyboard = new Scanner(System.in);
    String firstWord = keyboard.nextLine();
    String secondWord = keyboard.nextLine();
    keyboard.close();
    if(contained(firstWord, secondWord, 0, 0)==true)
      System.out.println("They are contained!");
    else
      System.out.println("They are not contained");
  }
  
  
  public static boolean contained(String a, String b, int fwLoc, int swLoc) {
    if(a.length()>b.length())
      return false;
    if(a.length()==0 && b.length()==0)
      return true;
    
    char in = a.charAt(fwLoc);
    char word = b.charAt(swLoc);
    
    //System.out.println(in+" "+ fwLoc+" "+word+" "+swLoc);
    if(in==word) {
      //System.out.println("CONTAINS");
      if(fwLoc!=a.length()-1) {
        swLoc=0;
        fwLoc = fwLoc +1;
        in = a.charAt(fwLoc);
        //System.out.println("A up");
        contained(a, b, fwLoc, swLoc);
      }
      return false;
    }
    else if (in!=word) {
      if(swLoc!=b.length()-1) {
        swLoc = swLoc + 1;
        word = b.charAt(swLoc);
        //System.out.println("B up");
        contained(a, b, fwLoc, swLoc);
      }
      if(fwLoc!=a.length()-1 && in!=word) 
        return false;
      return true;
    }
    return true;
  }
  
}//end class