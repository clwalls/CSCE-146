/**
 * Auto Generated Java Class.
 */
public class SimpleRecursion {
  
  
  public static void main(String[] args) { 
    System.out.println("Count down of 5");
    countDown(5);
    
    System.out.println("Factorial of 5");
    System.out.println(factorial(5));
    
    System.out.println("GCD");
    
    System.out.println("FIBBONACCI FEBRUARY 15");
    System.out.println(fibbo(15));
  }
  public static void countDown(int num) {
    System.out.println(num);
    if(num<=0)//halt
      return;
    else
      countDown(num-1);//recursive call
  }
  public static int factorial(int num) {
    if(num==0)
      return 1;//halting condition
    else
      return num*factorial(num-1);
  }
  public static int gcd(int num1, int num2) {
    if(num2==0)
      return num1;
    else
      return gcd(num2, num1%num2);
  }
  public static int fibbo(int pos) {
    if(pos == 1 || pos == 2)
      return 1;
    else
      return fibbo(pos-1)+fibbo(pos-2);
  }
  
  /* ADD YOUR CODE HERE */
  
}
