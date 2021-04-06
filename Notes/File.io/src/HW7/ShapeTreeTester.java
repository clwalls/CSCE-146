package HW7;
import java.util.Scanner;
import java.io.*;
public class ShapeTreeTester {

	public static void main(String[] args) {
		 final String fileName = "shapeFile.txt";
		System.out.println("Welcome to the shape tree tester!"
				+"\nReading from File");

		 readFile(fileName, 0);

	}
	public static String[] readFile(String aFileName, int index) {
	      int resultCount = 0;
	      String fileLine = null;
	      String[] splitLine = null;
	      try
	      {
	    	  Scanner input = new Scanner(new File(aFileName));
	    	  while(input.hasNextLine())
	      {
	        input.nextLine();
	        resultCount++;
	      }
	      if(resultCount<=0) {
	    	  input.close();
	        return null;
	      }
	      input = new Scanner(new File(aFileName));//Resets the scanner
	      while(input.hasNextLine())
	      {
	    	  for(int i=0; i<index; i++) 
	    	  {
	    	  fileLine = input.nextLine();
	    	  }
	        splitLine = fileLine.split("\t");
	        input.close();
	        return splitLine;
	        //return fileLine;
	      }
		 } 
		 catch (IOException e)
		 	{
			 System.out.println("ERROR: File not found");
		 	}
	      return splitLine;
	      //return fileLine;
	 }
	 public int countLines(String aFileName) {
	      int resultCount = 0;
	      try
	      {
	    	  Scanner input = new Scanner(new File(aFileName));
	    	  while(input.hasNextLine())
	    	  {
	    		  input.nextLine();
	    		  resultCount++;
	    	  }
	      }
	      catch (IOException e)
	      {
	    	  System.out.println("ERROR: File not found");
	      }
	      return resultCount;
	 }

}
