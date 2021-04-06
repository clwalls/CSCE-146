/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class Test2 {
  
  
  public static void main(String[] args) { 
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter the numbered element of the array which you would like to "+
                       "find the two indices of a 2D array of");
    int in = kb.nextInt();
    kb.nextLine(); 
    int i = 0;
    int j = 0;
    i = (in-1)%3;
    j = (in-1)/3;
    System.out.println("array["+i+","+j+"]");
    kb.close();
  }
  
  /* ADD YOUR CODE HERE */
  
}
