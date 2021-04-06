/**
 * Written by CHristopher Walls.
 */
public class MinHeapIntegers<T extends Comparable<T>> {
  private T[] heap;//Priority Queue
  public static final int DEFAULT_SIZE = 128;
  private int lastIndex;//First null value
  public MinHeapIntegers()
  {
    init(DEFAULT_SIZE);
  }
  public MinHeapIntegers(int size)
  {
    init(size);
  }
  private void init(int size)
  {
    if(size >0)
      heap = (T[])(new Comparable[size]);
    lastIndex = 0;
  }
  public void insert(T aData)
  {
    if(lastIndex>=heap.length)//heap is full
      return;
    heap[lastIndex] = aData;
    bubbleUp();//havent moved lastIndex yet
    lastIndex++;
  }
  private void bubbleUp()
  {
    //keeps track of the index of inserted item
    int currentIndex = lastIndex;
    while(currentIndex > 0 &&
          heap[(currentIndex-1)/2].compareTo(heap[currentIndex])>0)
    {
      //swap
      T temp = heap[(currentIndex-1)/2];
    heap[(currentIndex-1)/2] = heap[currentIndex];
    heap[currentIndex] = temp;
    currentIndex = (currentIndex-1)/2;
    }
  }
  public T peek()
  {
    if(heap == null)
      return null;
    return heap[0];
  }
  public T delete()
  {
    if(heap == null)
      return null;
    T retVal = heap[0]; //sets return to min val
    heap[0] = heap[lastIndex-1]; //minvalue index is set to greatest
    heap[lastIndex-1] = null; //last set to null
    lastIndex--; //last goes in one
    bubbleDown();
    return retVal;
  }
  private void bubbleDown()
  {
    int currentIndex = 0;
    while(currentIndex*2+1 < lastIndex) //parent<last
    {
      int bigIndex = currentIndex*2+1;
      if(currentIndex*2+2 < lastIndex &&
      heap[currentIndex*2+1].compareTo(heap[currentIndex*2+2])>0)
        bigIndex = currentIndex*2+2;
      if(heap[currentIndex].compareTo(heap[bigIndex])>0)
      {
        //swap
        T temp = heap[currentIndex];
        heap[currentIndex] = heap[bigIndex];
        heap[bigIndex] = temp;
      }
      else
        break;
      currentIndex = bigIndex; 
    }
  }
  public void heapSort()
  {
    //ArrayBinHeap heap2 = this; DOESNT WORK
    //T[] heap2 = heap; DOENST WORK
    //ArrayBinHeap heap2 = (ArrayBinHeap)this.clone(); THIS WORKS MUST PUT IN TRY?CATCH
    //heapSort: Make a copy of the heap, then remove and print each element from the clone. 
    //Make sure this doesn’t modify the current heap.
    int count=0;
    while(heap[count]!=null)
      count++;
      
    T[] heap2;
    heap2 = (T[])(new Comparable[heap.length]);
    for(int i=0; i<heap.length && heap[i]!=null; i++)
    {
      heap2[i] = heap[i];
    }
    for(int i=0; i<count; i++)
      System.out.print(this.delete()+ " ");
    for(int i=0;i<heap2.length && heap2[i]!=null;i++)
      heap[i] = heap2[i]; 
  }
  public void print()
  {
    for(int i = 0; i<heap.length && heap[i]!=null; i++)
      System.out.println(heap[i]);
  }

  
  
  /* ADD YOUR CODE HERE */
  
}
