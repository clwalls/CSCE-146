/**
 * Written by CHristopher Walls.
 */
public class ArrayBinHeap<T extends Comparable<T>> {
  private T[] heap;//Priority Queue
  public static final int DEFAULT_SIZE = 128;
  private int lastIndex;//First null value
  public ArrayBinHeap()
  {
    init(DEFAULT_SIZE);
  }
  public ArrayBinHeap(int size)
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
          heap[(currentIndex-1)/2].compareTo(heap[currentIndex])<0)
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
  public T remove()
  {
    if(heap == null)
      return null;
    T retVal = heap[0];
    heap[0] = heap[lastIndex-1];
    heap[lastIndex-1] = null;
    lastIndex--;
    bubbleDown();
    return retVal;
  }
  private void bubbleDown()
  {
    int currentIndex = 0;
    while(currentIndex*2+1 < lastIndex)
    {
      int bigIndex = currentIndex*2+1;//Assumes left child is the largest
      if(currentIndex*2+2 < lastIndex &&
      heap[currentIndex*2+1].compareTo(heap[currentIndex*2+2])<0)//or bigIndex ++
        bigIndex = currentIndex*2+2;//or the largest is the right child
      //Compare parent with largest child
      if(heap[currentIndex].compareTo(heap[bigIndex])<0)
      {
        //swap
        T temp = heap[currentIndex];
        heap[currentIndex] = heap[bigIndex];
        heap[bigIndex] = temp;
      }
      else//itw as in the right place
        break;
      currentIndex = bigIndex; 
    }
  }
  public void heapSort()
  {
    //ArrayBinHeap heap2 = this;
    //T[] heap2 = heap;
    //ArrayBinHeap heap2 = (ArrayBinHeap)this.clone(); THIS WORKS MUST PUT IN TRY?CATCH
    T[] heap2 = heap.clone();
    for(int i=0; i<lastIndex; i++)
      System.out.println(this.remove());
    for(int i=0;i<heap2.length;i++)
      heap[i] = heap2[i];
  }
  
  
  /* ADD YOUR CODE HERE */
  
}
