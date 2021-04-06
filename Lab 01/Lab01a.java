/**
 * Written by Christopher Walls.
 */
import java.lang.*;
import java.util.Scanner;
import java.io.*;
public class Lab01a {
  
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
  
  public static void main(String[] args) { 
    Scanner input;
    int mark = -1;
    int labs =0, homework =0 , exam1 =0, exam2 =0, labExam1 =0, labExam2 =0, finalExam =0, lowestHW =0;
    int numLabs =0, numHW =0, numExtraCredit =0, hw=0;
    double extraCredit=0.0;
    
    try
    {
      input = new Scanner(new File("perfectGrades.txt"));
      while(input.hasNextLine())
      {
        String line = input.nextLine();
        if (line.equals("LABS")) {
          mark = 0;
          continue;
        }
        else if (mark == 0 && isNumber(line)) {
          labs+= Integer.parseInt(line);
          numLabs++;
        }
        else if (line.equals("HOMEWORK")) {
          mark = 1;
          continue;
        }
        else if (mark == 1 && isNumber(line)) {
          hw = Integer.parseInt(line);
          homework+= Integer.parseInt(line);
          numHW++;
          //FINDS LOWEST HW GRADE
        if(lowestHW>hw) {
            lowestHW = hw;
          }
        }
        else if (line.equals("EXAM 1")) {
          mark = 2;
          continue;
        }
        else if (mark == 2 && isNumber(line)) {
          exam1+= Integer.parseInt(line);
        }
        else if (line.equals("EXAM 2")) {
          mark = 3;
          continue;
        }
        else if (mark == 3 && isNumber(line)) {
          exam2+= Integer.parseInt(line);
        }
        else if (line.equals("LAB EXAM 1")) {
          mark = 4;
          continue;
        }
        else if (mark == 4 && isNumber(line)) {
          labExam1+= Integer.parseInt(line);
        }
        else if (line.equals("LAB EXAM 2")) {
          mark = 5;
          continue;
        }
        else if (mark == 5 && isNumber(line)) {
          labExam2+= Integer.parseInt(line);
        }
        else if (line.equals("FINAL")) {
          mark = 6;
          continue;
        }
        else if (mark == 6 && isNumber(line)) {
          finalExam+= Integer.parseInt(line);
        }
        else if (line.equals("EXTRA CREDIT")) {
          mark = 7;
          continue;
        }
        else if (mark == 7 && isNumber(line)) {
          extraCredit+= Double.parseDouble(line);
        }
      }//end while
    }//end try
    catch(Exception e) {
      System.out.println("Couldn't find file.");
    }
    labs = labs/numLabs;
    //DROPS LOWEST HW GRADE
    homework = (homework-lowestHW)/(numHW-1);
    extraCredit = extraCredit*.02;
    //Add up the total percent 110 and divide by 100
    double rawTotal = 0.0;
    rawTotal = ((labs*.2)+(homework*.3)+(exam1*.1)+(labExam1*.1)+(exam2*.1)+(labExam2*.1)+(extraCredit)+(finalExam*.1));
    //A: 90-100 B+: 85-89 B: 80-84 C+: 75-79 C: 70-74 D+: 65-69 D: 60-64 F: >60
    //Round to nearest whole number Math.ceil, print final grade
    rawTotal = Math.ceil(rawTotal);
    System.out.println("Your lab average is " + labs);
    System.out.println("Your homework average is " + homework);
    System.out.println("Your first exam is " + exam1);
    System.out.println("Your first lab exam is " + labExam1);
    System.out.println("Your second exam is " + exam2);
    System.out.println("Your second lab exam is " + labExam2);
    System.out.println("Your extra work total is " + extraCredit + " points");
    System.out.println("Your final is " + finalExam);
    System.out.println("Your raw total is " + rawTotal);
    System.out.println("Your final grade is ");
    if (rawTotal>=89.5) {
      System.out.print("A");
    }
    else if (rawTotal>=84.5) {
      System.out.print("B+");
    }
    else if (rawTotal>=79.5) {
      System.out.print("B");
    }
    else if (rawTotal>=74.5) {
      System.out.print("C+");
    }
    else if (rawTotal>=69.5) {
      System.out.print("C");
    }
    else if (rawTotal>=64.5) {
      System.out.print("D+");
    }
    else if (rawTotal>=60.0) {
      System.out.print("D");
    }
    else if (rawTotal<60.0) {
      System.out.print("F");
    }
  }
  /* ADD YOUR CODE HERE */
  
}