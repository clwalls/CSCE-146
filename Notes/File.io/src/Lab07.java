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
  private static int BINARY_MAX = 10;
  
  public static void main(String[] args) { 
    System.out.println("Welcome to the search tester. We are going to see which algorithm performs the best out of 20 tests");
    int linCheckAvg = 0;
    int binCheckAvg = 0;
    
    for(int i=0; i<NUM_TESTS; i++)
    {
      int linChecks = 0;
      int binChecks = 0;
      
      int searchFor = (int)(Math.random()*RANDOM_MAX);
      System.out.println("Searching using linear search");
      linChecks = linearSearchRecur(generateArray(),searchFor,RANDOM_MIN);
      linCheckAvg += linChecks;
      System.out.println("Searching using binary search");
      binChecks = binarySearchRecur(generateArray(), searchFor, RANDOM_MIN, RANDOM_MAX, RANDOM_MIN);
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
    //Sorts the array 
    return array;
  }
  //Recursive Linear Search
  public static int linearSearchRecur(int[] a, int val, int currIndex)
  {
    int numChecks = currIndex;
    if(a[currIndex]==val) {
      System.out.println("Found!");
      return numChecks;
    }
    currIndex++;
    if(currIndex>=a.length) {
      System.out.println("Not Found");
      return RANDOM_MAX;//This value is returned as it was not found and it is linear. 
    }
    else
      return linearSearchRecur(a, val, currIndex);
  }
  
  //Recursive Binary Search
  public static int binarySearchRecur(int[] a, int val, int minIndex, int maxIndex, int numChecks)
  {
    int checks = numChecks;
    if(minIndex>maxIndex || checks-1>=maxIndex) {//Never found 
      System.out.println("Not Found");
      return BINARY_MAX;
    }
    int midIndex =(maxIndex+minIndex)/2;
    if(a[midIndex]==val) {
      System.out.println("Found!");
      return checks;
    }
    if(val>a[midIndex]) //we need to search top half
      return binarySearchRecur(a,val,midIndex+1,maxIndex, numChecks+1);
    else //search the lower half
      return binarySearchRecur(a,val,minIndex,midIndex-1, numChecks+1);
  }
  /* ADD YOUR CODE HERE */
  
}
