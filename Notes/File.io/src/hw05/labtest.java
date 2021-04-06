package hw05;
/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class labtest {
  
  
  public static void main(String[] args) { 
    System.out.println("Enter 2 words. I will determine if the letters of "
                         + "one is contained in the other");
    Scanner keyboard = new Scanner(System.in);
    String firstWord = keyboard.nextLine();
    String secondWord = keyboard.nextLine();
    keyboard.close();
    System.out.println(contained(firstWord, secondWord, 0, 0));
  }
  
  /* ADD YOUR CODE HERE */
  public static boolean contained(String a, String b, int fwLoc, int swLoc) {
    if(a.length()>b.length())
      return false;
    if(a.length()==0 && b.length()==0)
      return true;
    
    char in = a.charAt(fwLoc);
    char word = b.charAt(swLoc);
    boolean contains = true;
    
    System.out.println(in+" "+ fwLoc+" "+word+" "+swLoc);
    
    if(in==word) {
      contains = true;  
      System.out.println("CONTAINS");
      if(fwLoc==a.length()-1) 
        return true;
      swLoc=0;
      if(swLoc==b.length()-1 && contains==true) {
        contained(" "," ",0,0);
      }
      if(fwLoc<a.length()-1) {
        fwLoc++;
        System.out.println("A up");
        contained(a, b, fwLoc, swLoc);
      }
    }
    else {
      contains = false;
      System.out.println("DNE");
    }
    if(contains==false) {
      if(swLoc<b.length()-1) {
        swLoc++;
        System.out.println("B up");
        contained(a, b, fwLoc, swLoc);
      }
    }
    //return contains;  
    if(contains)
      return true;
    else
      return false;
  }
  
}//end class