/**
 * Auto Generated Java Class.
 */
public class ArrayStack<T> implements StackInterface<T> {
  private T[] stack;
  private int head;
  public static final int DEFAULT_SIZE = 100;
  
  public ArrayStack() {
    init(DEFAULT_SIZE);
  }
  public ArrayStack(int aSize) {
    init(aSize);
  }
  public void init(int aSize) {
    if(aSize <= 0)
      return;
    head = 0; 
    stack = (T[])(new Object[aSize]);
  }
  public void push(T aData) {
    //regan stealing my code wtf bro
    if(head >= stack.length)
      return; //returns if stack is full
    stack[head] = aData;
    head++;
  }
  public T pop() {
    if(head <= 0)//returns if stack is empty 
      return null;
    T ret = stack[head-1];
    head--;
    return ret;
  }
  public T peek() {
    if(head<=0)
      return null;
    return stack[head-1];
  }
  public void print() {
    for(int i = head-1;i>=0;i--) 
    {
      System.out.println(stack[i]);
    }
  }
  
}
