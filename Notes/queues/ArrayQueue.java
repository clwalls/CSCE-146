/**
 * Written by Christopher Walls.
 */
public class ArrayQueue<T> implements QueueInterface {
  private T[] queue;
  private int tailIndex;//1 past the last element, first null element in array
  
  public static final int DEFAULT_SIZE = 100;
  
  public ArrayQueue() {
    this.init(DEFAULT_SIZE);
  }
  public ArrayQueue(int size) {
    this.init(size);
  }
  public void init(int size) {
  //initialization
    if(size <=0)
      return;
    //queue = new T[size];
    queue = (T[])(new Object[size]);
    tailIndex = 0;
  }
  public void enqueue(Object aData) {
    if(tailIndex >= queue.length)//queue is full
      return;
    queue[tailIndex] = (T)aData;
    tailIndex++;
  }
  public T dequeue() {
    T ret = queue[0];
    for(int i=0;i<tailIndex;i++)
    {
      queue[i] = queue[i+1];
    }
    tailIndex--;
    return ret;
  }
  public T peak() {
    return queue[0];
  }
  public void print() {
    for(T elem : queue)
    {
      System.out.println(elem);
    }
  }
  
}//end class
