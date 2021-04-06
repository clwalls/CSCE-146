/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class ReversePolishCalculator {
  
  private static final String DELIM = "\n";
  public static void main(String[] args) { 
    StackInterface<String> stack = new LLStack<String>();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Welcome to the reverse Polish Calculator!\nEnter in the name of the file");
    String fileName = keyboard.nextLine();
    
    keyboard.close();
    
  }
  public static boolean isNumber(String str) {
    try
    {
      double d = Double.parseDouble(str);
    }
    catch(NumberFormatException a) 
    {
      return false;
    }
    return true;
  }
  public void readFile(String aFileName) {
    if(aFileName == null)
      return;
    try
    {
      Scanner input = new Scanner(new File(aFileName));
      int resultCount = 0;
      while(input.hasNextLine())
      {
        input.nextLine();
        resultCount++;
      }
      if(resultCount<=0)
        return;
      input = new Scanner(new File(aFileName));//Resets the scanner
      String fileLine;
      String[] splitLine;
      while(input.hasNextLine())
      {
        fileLine = input.nextLine();
        splitLine = fileLine.split(DELIM);
        for(int i=0; i<splitLine.length; i++)
        {
          int temp = 0;//temp to perform calculations
          if(isNumber(splitLine[i])) {
            stack.push(Integer.parseInt(splitLine[i]));
          }
          else if (splitLine[i].equals("+")) {
            temp = stack.pop()+ stack.pop();
          }
          else if (splitLine[i].equals("-")) {
            temp = stack.pop()-stack.pop();
          }
          else if (splitLine[i].equals("*")) {
            temp = stack.pop()*stack.pop();
          }
          else if (splitLine[i].equals("/")) {
            if(stack.peek().equals("0")) { //throw cannot divide by zero exception
              System.out.println("Cannot divide by 0");
              temp = 0;
            }
            else {
              temp = stack.pop()/stack.pop();
            }
          }
        }
        System.out.println("Result is "+temp);
      }//end while
      catch (FileNotFoundException e) 
      {
        System.out.println("File not found.");
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
    }
  }
  
  /* ADD YOUR CODE HERE */
  
}
