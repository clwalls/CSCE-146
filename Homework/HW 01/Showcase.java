/**
 * Written by Christopher Walls.
 */
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Showcase {
  
  static final int NUM_PRIZES = 50;
  static final int SHOWCASE_SIZE = 5;
  static final int FIELD_AMT = 2;
  static final String DELIM = "\t";
  static Prize prize = new Prize();
  
  static Prize[] prizes = new Prize[NUM_PRIZES];
  Prize[] showcaseArray = new Prize[SHOWCASE_SIZE];
  
  //METHODS
  //Print
  public void printArray() {
    for (int i=0; i<showcaseArray.length; i++)
    {
      System.out.println(showcaseArray[i].getName());
    } 
  }
  //Gets total value of showcase
  public int getShowcasePrice() {
    int price = 0;
    for (int i=0; i<showcaseArray.length; i++)
    {
      price= price + showcaseArray[i].getPrice();
    } 
    return price;
  }
  //Add Prize
  public void addPrize (Prize aPrize)
  {
    if(prizes[prizes.length-1] != null)//Check if array is full 
    {
      return;
    }
    for(int i=0; i<prizes.length; i++)
    {
      if(prizes[i] == null) //Found first empty element
      {
        prizes[i] = aPrize;
        break;
      }
    }
  }
  //Populate Array
  public void populateArray(String aFileName) {
    if(aFileName == null)
      return;
    try
    {
      Scanner input = new Scanner(new File(aFileName));
      //First pass count the elements
      int prizeCount = 0;
      while(input.hasNextLine())
      {
        input.nextLine();
        prizeCount++;
      }
      if(prizeCount<=0)
        return;
      input = new Scanner(new File(aFileName));//Resets the scanner
      String fileLine;
      String[] splitLine;
      while(input.hasNextLine())
      {
        fileLine = input.nextLine();
        splitLine = fileLine.split(DELIM);
        if (splitLine.length == FIELD_AMT) 
        {
          this.addPrize(new Prize(splitLine[0], Integer.parseInt(splitLine[1])));
        }
      } 
      input.close();
    }
    catch (FileNotFoundException e) 
    {
      System.out.println("File not found.");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
  //Make showcase Array
  public void constructShowcase () {
    Random r = new Random();
    for (int i=0; i<SHOWCASE_SIZE; i++) {
      int n = r.nextInt(50);
      if(prizes[n]!=null) {
        showcaseArray[i]=prizes[n];
      }
      else if(prizes[n]==null) {
        i--;
      }
    }
  }
  
  /* ADD YOUR CODE HERE */
  
}
