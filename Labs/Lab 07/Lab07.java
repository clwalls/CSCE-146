/**
 * Written by Christopher Walls.
 * 
 * Implement both linear search and binary search, and see which one performs better 
 * given an array 1,000 randomly generated whole numbers (between 0-999), a number 
 * picked to search that array at random, and conducting these tests 20 times.  
 * Each time the search is conducted the number of checks (IE number of times the 
 * loop is ran or the number of times the recursive method is called) needs to be 
 * counted and at the end the total number of checks should be averaged.
 */
public class Lab07 {
  
  private static int ARRAY_SIZE = 1000;
  private static int RANDOM_MIN = 0;
  private static int RANDOM_MAX = 1000;
  private static int NUM_TESTS = 20;
  
  public static void main(String[] args) { 
    System.out.println("Welcome to the search tester. We are going to see which algorithm performs the best out of 20 tests");
    int linCheckAvg = 0;
    int binCheckAvg = 0;
    
    for(int i=0; i<NUM_TESTS; i++)
    {
      int linChecks = 0;
      int binChecks = 0;
      
      int searchFor = (int)(Math.random()*RANDOM_MAX);
      int[] temp = generateArray();
      /*This was my only problem with the lab, I kept generating new arrays each call but it was 
       * fixed with this place holder temp. */
      System.out.println("Searching using linear search");
      linChecks = linearSearchRecur(temp,searchFor,RANDOM_MIN);
      linCheckAvg += linChecks;
      System.out.println("Searching using binary search");
      binChecks = binarySearchRecur(temp, searchFor, RANDOM_MIN, RANDOM_MAX, RANDOM_MIN);
      binCheckAvg += binChecks;
      System.out.println("Linear Checks: " + linChecks);
      System.out.println("Binary Checks: " + binChecks);
      System.out.println();
    }
    linCheckAvg /=NUM_TESTS;
    binCheckAvg /=NUM_TESTS;
    System.out.println("The average number of checks for " +NUM_TESTS+" were:");
    System.out.println("Linear Search " + linCheckAvg);
    System.out.println("Binary Search " + binCheckAvg);
  }
  //METHODS ************************************************************************
  public static void quickSort(int[] a, int leftIndex, int rightIndex)
  {
    //partition
    int index = partition(a, leftIndex, rightIndex);
    if(leftIndex<index-1)
      quickSort(a,leftIndex,index-1);
    if(index<rightIndex)
      quickSort(a,index,rightIndex);
  }
  private static int partition(int[] a, int leftIndex, int rightIndex)
  {
    int i = leftIndex;
    int j = rightIndex;
    int pivot = a[(leftIndex+rightIndex)/2];
    while(i<=j)
    {
      while(a[i]<pivot)
      {
        i++;
      }
      while(a[j]>pivot)
      {
        j--;
      }
      if(i<=j)//found valseu out of order so swap
      {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        i++;
        j--;
      }
    }
    return i;
  }
  //Generates array 
  public static int[] generateArray() 
  {
    int[] array = new int[ARRAY_SIZE];
    
    /*Populates an int array called array with size ARRAY_SIZE with random numbers ranging
     * from 0 to RANDOM_MAX. */
    for(int i=0; i<ARRAY_SIZE; i++)
    {
      array[i] = (int)(Math.random()*RANDOM_MAX);
    }
    quickSort(array,RANDOM_MIN,RANDOM_MAX-1);//Arrays.sort would do same thing
    //Sorts the array 
    return array;
  }
  
  //Recursive Linear Search
  public static int linearSearchRecur(int[] a, int val, int currIndex)
  {
    if(a[currIndex]==val) {
      System.out.println("Found!");
      return currIndex;
    }
    currIndex++;
    if(currIndex>=a.length) {
      System.out.println("Not Found");
      return currIndex;//This value is returned as it was not found and it is linear. 
    }
    else
      return linearSearchRecur(a, val, currIndex);
  }
  
  //Recursive Binary Search 
  public static int binarySearchRecur(int[] a, int val, int minIndex, int maxIndex, int numChecks)
  {
    if(minIndex>maxIndex) {//Never found 
      System.out.println("Not Found");
      return numChecks;
    }
    int midIndex =(maxIndex+minIndex)/2;
    if (midIndex>RANDOM_MAX-1)
      return numChecks;
    if(a[midIndex]==val) {
      System.out.println("Found!");
      return numChecks;
    }
    numChecks++;
    if(val>a[midIndex]) //we need to search top half
      return binarySearchRecur(a,val,midIndex+1,maxIndex, numChecks);
    else //search the lower half
      return binarySearchRecur(a,val,minIndex,midIndex-1, numChecks);
  } 
  /* ADD YOUR CODE HERE */
  
}
