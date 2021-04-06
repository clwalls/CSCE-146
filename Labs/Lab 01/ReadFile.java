/**
 * Written by Christopher Walls.
 */
import java.util.Scanner;
import java.io.*;

public class ReadFile {
  private Scanner input;
  
  public void openFile() {
    try
    {
      input = new Scanner(new File("perfectGrades.txt"));
    }
    catch(Exception e) {
      System.out.println("Couldn't find file.");
    }
  }
  public String[] readFile() {
    String grade = "";
    String[] numStrings = null;
    double[] nums = null;
    while(input.hasNext())
    {
      grade = input.nextLine();
      numStrings = grade.split("\n");
      //nums = new double[numStrings.length];
      
     /* for (int i=0; i<nums.length; i++) {
        nums[i] = Double.parseDouble(numStrings[i]);
      } */
      
    }
    return numStrings;
  }
  public void closeFile() {
    input.close();
  }
  
  
}
