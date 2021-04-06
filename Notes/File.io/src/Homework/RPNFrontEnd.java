package Homework;

import java.util.Scanner;

public class RPNFrontEnd {

	  public static void main(String[] args) { 
		    Scanner keyboard = new Scanner(System.in);
		    ReversePolishCalculator rpn = new ReversePolishCalculator();
		    System.out.println("Welcome to the reverse Polish Calculator!\nEnter in the name of the file");
		    String fileName = keyboard.nextLine();
		    keyboard.close();
		    rpn.readFile(fileName);
		  }

}
