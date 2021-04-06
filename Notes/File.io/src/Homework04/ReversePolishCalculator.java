package Homework04;

import java.util.Scanner;

import Homework.LLStack;
import Homework.StackInterface;
/**
 * Written by Christopher Walls.
 */

public class ReversePolishCalculator {
	static ReadFile rf = new ReadFile();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner keyboard = new Scanner(System.in);
		 System.out.println("Welcome to the reverse Polish Calculator!\nEnter in the name of the file");
		 String fileName = keyboard.nextLine();
		 keyboard.close();
		 
		 int numLines = rf.countLines(fileName);
		 String[] fileLines = new String[numLines];
		 for(int i=0; i<numLines; i++)//creates an array of each of the file's lines
		 {
			 fileLines[i]=(rf.readFile(fileName, i+1));
			 rpnMath(splitLine(fileLines[i]));
		 }
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
	public static String[] splitLine(String line) {
		String[] splitLine = line.split("\\s+");
		return splitLine;
	}
	public static void rpnMath(String[] splitLine) {
		System.out.print("\nCalculating ");
		for(int i=0; i<splitLine.length; i++)
		{
			System.out.print(splitLine[i]+" ");
		}
	 	StackInterface<Integer> stack = new LLStack<Integer>();
		int firstTemp = 0;//temp to perform calculations
		int secondTemp = 0;	
		int temp = 0;
		boolean legal = true;
		for(int i=0; i<splitLine.length; i++)
		{
			if(isNumber(splitLine[i])==true) {
	 			stack.push(Integer.parseInt(splitLine[i]));
			}
			else {
	 		switch(splitLine[i])
	 		{
	 		case "+":
	 			if(stack.peek()==null)
	 				break;
	 			firstTemp = stack.pop();
	 			if(stack.peek()==null)
	 				break;
	 			secondTemp = stack.pop();
	 			temp = secondTemp + firstTemp;
	 			stack.push(temp);
	 			break;
	 		case "-":
	 			if(stack.peek()==null)
	 				break;
	 			firstTemp = stack.pop();
	 			if(stack.peek()==null)
	 				break;
	 			secondTemp = stack.pop();
	 			temp = secondTemp - firstTemp;
	 			stack.push(temp);
	 			break;
	 		case "*":
	 			if(stack.peek()==null)
	 				break;
	 			firstTemp = stack.pop();
	 			if(stack.peek()==null)
	 				break;
	 			secondTemp = stack.pop();
	 			temp = secondTemp * firstTemp;
	 			stack.push(temp);
	 			break;
	 		case "/":
	 			if(stack.peek()==null)
	 				break;
	 			firstTemp = stack.pop();
	 			if(stack.peek()==null)
	 				break;
	 			secondTemp = stack.pop();
	 			if(firstTemp==0) {
	 				legal = false;
	 				System.out.print("\nCannot divide by 0");
	 				break;
	 			}
	 			temp = secondTemp / firstTemp;
	 			stack.push(temp);
	 			break;
	 		default:
	 			System.out.print("\nException! For input string: \"" + splitLine[i]+"\"");
	 			legal = false;
	 			break;
	 		}
			}//end else
	 	}
		
		if(stack.pop()==null && legal!=false) {
			System.out.print("\nIll formated expression");
			legal = false;
		}
		else if(stack.pop()!=null && legal!=false) {
			System.out.print("\nIll formated expression");
			legal = false;
			temp =0;
		}
		if(legal=false)
			temp = 0;
		System.out.println("\nResult is "+temp+"\n");
	}	
}
	
	