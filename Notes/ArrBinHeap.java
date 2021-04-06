/**
 * Auto Generated Java Class.
 */
public class ArrBinHeap <T extends Comparable<T>>{
  private T[] heap;
  private int lastIndex;
  public static final int DEFAULT_SIZE = 128;
  public ArrBinHeap()
  {
    init(DEFAULT_SIZE);
  }
  public ArrBinHeap(int size)
  {
    init(size);
  }
  public void init(int size)
  {
    if(size<=0)
      return;
    heap = (T[])(new Comparable[size]);
    lastIndex = 0;
  }
  public void insert(T aData)
  {
    if(lastIndex>=heap.length)
      return;//full
    heap[lastIndex]=aData;
    bubbleUp();
    lastIndex++;
  }
  private void bubbleUp()
  {
    int currentIndex = lastIndex;
    while(currentIndex>0 &&
          heap[(currentIndex-1)/2].compareTo(heap[currentIndex])<0)
    {
      //swap
      int parentIndex = (currentIndex-1)/2;
      T temp = heap[parentIndex];
      heap[parentIndex] = heap[currentIndex];
      heap[currentIndex] = temp;
      currentIndex = parentIndex;
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
    T temp = peek();
    heap[0] = heap[lastIndex-1];
    heap[lastIndex-1] = null;
    lastIndex--;
    bubbleDown();
    return temp;
  }
  private void bubbleDown()
  {
    int currentIndex = 0;
    while(currentIndex*2+1<lastIndex)
    {
      int bigIndex = currentIndex*2+1;//assumse the left is the largest 
      if(currentIndex*2+2<lastIndex &&
         heap[bigIndex].compareTo(heap[bigIndex+1])<0)
        bigIndex++;//actually right child was larger
      if(heap[currentIndex].compareTo(heap[bigIndex])<0)//need to swap
      {
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
    int currentIndex = lastIndex;
    for(int i = 0; i<currentIndex; i++)
      System.out.println(this.remove()+ " ");
  }
  
  
}
