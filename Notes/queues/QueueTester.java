/**
 * Written by Christopher Walls.
 */
public class QueueTester {
  
  
  public static void main(String[] args) { 
    
    //ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
    //QueueInterface<Integer> queue = new QueueInterface<Integer>();//no
    QueueInterface<Integer> queue = new ArrayQueue<Integer>();
    for(int i =0;i<5;i++)
    {
      queue.enqueue(i);
    }
    queue.print();
    System.out.println("Dequeue "+queue.dequeue());
    //Queue<Integer> intQueue = new LinkedList<Integer>();
  }
  
  /* ADD YOUR CODE HERE */
  
}
