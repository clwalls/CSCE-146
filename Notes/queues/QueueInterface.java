/**
 * Written by Christopher Walls.
 */
public interface QueueInterface <T> {
  public void enqueue(T aData);
  public T dequeue();
  public T peak();//returns first element without removing it
  public void print();
}
