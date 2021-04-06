/**
 * Auto Generated Java Class.
 */
public class StackTester {
  
  
  public static void main(String[] args) { 
    StackInterface<Integer> stack = new LLStack<Integer>();
    for(int i=0;i<10;i++) 
      stack.push(i);
    stack.print();
    System.out.println("\nPop"+stack.pop()+"\n");
    stack.print();
    
    //built is java stack
    //Stack<Integer> iStack = new Stack<Integer>();
  }
  
  /* ADD YOUR CODE HERE */
  
}
