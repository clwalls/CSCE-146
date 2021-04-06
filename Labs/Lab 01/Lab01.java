/**
 * Written by Christopher Walls.
 */
import java.util.Scanner;
import java.io.*;
public class Lab01 {
  
  public static void main(String[] args) { 
    final int NUM_TYPES_OF_ASSIGNMENTS = 8;//Labs, HW, EX1, EX2, LE1, LE2, FINAL, EXTRA CREDIT
    Scanner input;
    int[] grades = null;
    int count = 0;
    int place = 0;
    int spotEnd = 0;
    try
    {
      input = new Scanner(new File("perfectGrades.txt"));
      while(input.hasNextLine())
      {
        count++;
      }
      input = new Scanner(new File("perfectGrades.txt"));
      while(input.hasNextLine())
      {
        place++;
        if(input.hasNextInt()) {
          for(int i=0; i<(count-NUM_TYPES_OF_ASSIGNMENTS); i++)
          {
            grades[i] = input.nextInt();
          }
        }
        else {
          spotEnd = place;
          input.nextLine();
        }
      }
      input.close();
    }
    catch(Exception e) {
      System.out.println("Couldn't find file.");
    }
    for (int i=0; i<grades.length; i++)
    {
      System.out.print(grades[i] +" ");
    }
    //Read from File, Lab Assignments are 20%
    double labAverage = 0.0;
    System.out.println("Your lab average is " + labAverage);
    //Read from File, Homework Assignments are 30%, drop the lowest grade
    double homeworkAverage = 0.0;
    System.out.println("Your homework average is " + homeworkAverage);
    //Read from File, Exam 1 is 10%
    double firstExam = 0.0;
    System.out.println("Your first exam is " + firstExam);
    //Read from File, Lab Test 1 is 10%
    double firstLabExam = 0.0;
    System.out.println("Your first lab exam is " + firstLabExam);
    //Read from File, Exam 2 is 10%
    double secondExam = 0.0;
    System.out.println("Your second exam is " + secondExam);
    //Read from File, Lab Test 2 is 10%
    double secondLabExam = 0.0;
    System.out.println("Your second lab exam is " + secondLabExam);
    //Read from File, each Extra Credit is 2% a piece
    double extraCredit = 0.0;
    System.out.println("Your extra work total is " + extraCredit + " points");
    //Read from File, final is worth 10%
    double finalGrade = 0.0;
    System.out.println("Your final is " + finalGrade);
    //Add up the total percent 110 and divide by 100
    double rawTotal = 0.0;
    rawTotal = (labAverage+homeworkAverage+firstExam+firstLabExam+secondExam+secondLabExam+extraCredit+finalGrade)/100.0;
    //A: 90-100 B+: 85-89 B: 80-84 C+: 75-79 C: 70-74 D+: 65-69 D: 60-64 F: >60
    //Round to nearest whole number Math.ceil, print final grade
    System.out.println("Your final grade is ");
    if (rawTotal>=89.5) {
      System.out.print("A");
    }
    if (rawTotal>=84.5) {
      System.out.print("B+");
    }
    if (rawTotal>=79.5) {
      System.out.print("B");
    }
    if (rawTotal>=74.5) {
      System.out.print("C+");
    }
    if (rawTotal>=69.5) {
      System.out.print("C");
    }
    if (rawTotal>=64.5) {
      System.out.print("D+");
    }
    if (rawTotal>=60.0) {
      System.out.print("D");
    }
    if (rawTotal<60.0) {
      System.out.print("F");
    }
    
    
    
  }
  
  /*
   public static readfromFile(String fileName)
   {
   if (fileName == null)
   return null;
   try
   {
   Scanner fileScanner = new Scanner(new File(fileName));
   //Read the Header
   String fileLine = fileScanner.nextLine();
   String[] splitStream = fileLine.split(DELIM);
   //check for amount of things in header to see if formatted correctly
   //if not say file couldnt be read, incorrect header
   //Ready the Body
   int count = 0;
   while (fileScanner.hasNextLine())
   {
   count++;
   }
   while(fileScanner.hasNextLine()) 
   {
   fileScanner = new Scanner(new File(fileName));
   String fileLine;
   String[] splitString;
   
   fileLine = fileScanner.nextLine();
   splitString = fileLine.split(DELIM);
   //check to see if split string has correct # elements
   }
   fileScanner.close();
   //return
   }
   catch(Exception e)
   {
   System.out.println(e);
   }
   return null;
   } */
  
  /* ADD YOUR CODE HERE */
  
}
