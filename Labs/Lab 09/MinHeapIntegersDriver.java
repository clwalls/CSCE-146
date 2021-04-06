/**
 * Written by Christopher Walls.
 */
public class MinHeapIntegersDriver {
  
  
  public static void main(String[] args) { 
    MinHeapIntegers<Integer> heap = new MinHeapIntegers<Integer>();
    System.out.println("Int Min Heap Tester");
    System.out.println("Populating Heap with values");
    int[] arr = {21,37,49,11,23,1,13,16,33,17};
    for(int i : arr) {
      System.out.println(i);
      heap.insert(i);
    }
    
    System.out.println("Printing Heap");
    heap.print();
    System.out.println("Testing heap sort");
    heap.heapSort();
    System.out.println("\nRemoving an element from the heap");
    System.out.println("The element removed is " + heap.delete() +" and the heap now is: ");
    heap.print();
  }
  
  /* ADD YOUR CODE HERE */
  
}
