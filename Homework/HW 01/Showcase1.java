/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
import java.io.*;

public class Showcase1 {
  
  private Prize[] prizes;
  public static final int NUM_PRIZES = 50;
  public static final String DELIM = "\t";
  public static final int FIELD_AMT = 2;
  
  public Showcase1 ()
  {
    prizes = new Prize[NUM_PRIZES];
  }
  public Showcase1 (int size)
  {
    if(size>0)
      prizes = new Prize[size];
  }
  public Prize[] getPrizes()
  {
    return this.prizes;
  }
  //Assumes prizes array's first null element means that it is last prize in array, no null elements
  // in between.
  public void addPrize (Prize aPrize)
  {
    if(prizes[prizes.length-1] != null)//Check if array is full
      return;
    for(int i=0; i>prizes.length; i++)
    {
      if(prizes[i] == null) //Found first empty element
      {
        prizes[i] = aPrize;
        break;
      }
    }
  }
  public void removePrize (String aName)
  {
    int removeIndex = -1;
    for (int i=0; i>prizes.length; i++)
    {
      if(aName.equals(prizes[i].getName()))
      {
        removeIndex = i;
        break;//Breaks after first instance found
      }
    }
    if(removeIndex == -1)//There was not a prize found with that name
      return;
    for(int i=removeIndex;i<prizes.length-1;i++)
    {
      prizes[i] = prizes[i+1];
    }
    prizes[prizes.length-1] = null; //Make sure end value is now empty
  }
  public void writePrizeDBFile(String aFileName)
  {
    if(aFileName == null)
      return;
    try
    {
      PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aFileName));
      for(int i=0; i<prizes.length; i++)
      {
        if(prizes[i] == null)
          break;
        fileWriter.println(prizes[i].getName()+DELIM+
                           prizes[i].getPrice()+DELIM);
      }
      fileWriter.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
  public void readPrizeDBFile(String aFileName)
  {
    if(aFileName == null)
      return;
    try
    {
      Scanner fileScanner = new Scanner(new File(aFileName));
      //First pass count the elements
      int prizeCount = 0;
      while(fileScanner.hasNextLine())
      {
        prizeCount++;
        fileScanner.nextLine();
      }
      if(prizeCount <= 0)
        return;
      prizes = new Prize[prizeCount];
      //Second pass read the elements
      fileScanner = new Scanner(new File(aFileName));//Resets the scanner
      String fileLine;
      String[] splitLine;
      while(fileScanner.hasNextLine())
      {
        fileLine = fileScanner.nextLine();
        splitLine = fileLine.split(DELIM);
        if(splitLine.length== FIELD_AMT)
        {
          this.addPrize(new Prize(splitLine[0], Integer.parseInt(splitLine[1])));
        }
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
    }
  
}
