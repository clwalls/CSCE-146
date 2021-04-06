package Homework;

/**
 * Written by Christopher Walls.
 */
public interface StackInterface<T> {
  
  public void push(T aData);//adds to stack
  public T pop();//removes from stack
  public T peek();
  public void print();//good for debugging
  
}

