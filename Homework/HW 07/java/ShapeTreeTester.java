//christopher walls
import java.util.Scanner;
import java.io.*;
public class ShapeTreeTester {
  
  static final String DELIM = "\t";
  static LinkedBSTree<Shape> shapeTree = new LinkedBSTree<Shape>();
  
  public static void main(String[] args) {
    final String fileName = "shapeFile.txt";

    System.out.println("Welcome to the shape tree tester!"
                         +"\nReading from File");
    readFile(fileName);
    System.out.println("\nPrinting pre-order");
    shapeTree.printPreOrder();
    System.out.println("\nPrinting in-order");
    shapeTree.printInOrder();
    System.out.println("\nPrinting post-order");
    shapeTree.printPostOrder();
    //System.out.println("\nThe max area is: ");
    //shapeTree.maxArea();
    System.out.println("Deleting Rectangle Side 1: 2.0 Side 2: 7.0 Area: 14.0");
    shapeTree.delete(new Shape("Rectangle",2.0,7.0));
    System.out.println("\nPrinting in-order");
    shapeTree.printInOrder();
    //System.out.println("\nDeleting Values larger than 30");
    //shapeTree.deleteAreasGreater(30.0);
    //i mean for this part jj printed in his deleting using in order, you can tell by missing -, ill
    // do the same
  }
  //read
  public static void readFile(String aFileName) {
    if(aFileName == null)
      return;
    try
    {
      Scanner input = new Scanner(new File(aFileName));
      //First pass count the elements
      int count = 0;
      while(input.hasNextLine())
      {
        input.nextLine();
        count++;
      }
      if(count<=0)
        return;
      input = new Scanner(new File(aFileName));//Resets the scanner
      String fileLine;
      String[] splitLine;
      while(input.hasNextLine())
      {
        fileLine = input.nextLine();
        splitLine = fileLine.split(DELIM);
        //add as shape
        if(splitLine.length < 2)
          System.out.println("Not properly formatted!");
        if (splitLine.length == 3)//rectangle or triangle
        {
          shapeTree.insert(new Shape(splitLine[0], Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2])));
          System.out.println(fileLine);
        }
        if (splitLine.length == 2)//circle
        {
          shapeTree.insert(new Shape(splitLine[0], Double.parseDouble(splitLine[1])));
          System.out.println(fileLine);
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
  
}
