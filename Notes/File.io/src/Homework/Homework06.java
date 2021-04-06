package Homework;

/**
 * Written by Christopher Walls. 
 */
public class Homework06 {
  
  private static int ARRAY_SIZE = 1000;
  private static int RANDOM_MAX = 1000;
  private static int NUM_TESTS = 1;
  private static int checks[] = {0, 0, 0, 0};
  //checks[] will store number of checks for each sorting method. Easier to deal with than return types. 
  public static void main(String[] args) { 
    int selSortAvg = 0;
    int bubSortAvg = 0;
    int merSortAvg = 0;
    int quiSortAvg = 0;
    int[] temp = new int[ARRAY_SIZE];
    int[] arrSel = new int[ARRAY_SIZE];      
    int[] arrBub = new int[ARRAY_SIZE];      
    int[] arrMer = new int[ARRAY_SIZE];
    int[] arrQui = new int[ARRAY_SIZE];
    
    for(int i=0; i<NUM_TESTS; i++)
    {
      /*int[] temp = generateArray();
       arrSel = arrBub = arrMer = arrQui = temp; */
      /*Generates array of size ARRAY_SIZE with values from 0 to RANDOM_MAX.
       * generateArray() method in code at the bottom could not be used as it would
       * refer to memory location of temp. */
      for(int k=0; k<ARRAY_SIZE; k++)
      {
        int rand = (int)(Math.random()*RANDOM_MAX);
        temp[k] = rand;
        arrSel[k] = rand;          
        arrBub[k] = rand;
        arrQui[k] = rand;
        arrMer[k] = rand;
      }
      //Displays unsorted, randomly generated array which all methods will sort. 
      System.out.println("Randomly Generated Array");
      for(int j=0; j<ARRAY_SIZE; j++)
        System.out.print(temp[j] + " ");
      System.out.println();
      //Calls sorting methods on the arrays.
      selectionSort(arrSel);
      bubbleSort(arrBub);
      //mergeSort(arrMer); //Merge sort goes out of bounds
      quickSort(arrQui);  
      //Shows that all methods properly sort and adds to average to determine avg based on NUM_TESTS.
      System.out.println("\nSelection Sort");
      for(int j=0; j<ARRAY_SIZE; j++)
        System.out.print(arrSel[j] + " ");
      System.out.println();
      selSortAvg+=checks[0];
      System.out.println("\nBubble Sort");
      for(int j=0; j<ARRAY_SIZE; j++)
        System.out.print(arrBub[j] + " ");
      System.out.println();
      bubSortAvg+=checks[1];
      System.out.println("\nMerge Sort");
      for(int j=0; j<ARRAY_SIZE; j++)
        System.out.print(arrMer[j] + " ");
      System.out.println();
      merSortAvg+=checks[2];
      System.out.println("\nQuick Sort");
      for(int j=0; j<ARRAY_SIZE; j++)
        System.out.print(arrQui[j] + " ");
      System.out.println();
      quiSortAvg+=checks[3];
    }//end sorting for NUM_TESTS
    selSortAvg /=NUM_TESTS;
    bubSortAvg /=NUM_TESTS;
    merSortAvg /=NUM_TESTS;
    quiSortAvg /=NUM_TESTS;
    System.out.println("\nThe number of values in each array is " + ARRAY_SIZE);
    System.out.println("The average number of checks for " + NUM_TESTS + " were:");
    System.out.println("Selection Sort " + selSortAvg);
    System.out.println("Bubble Sort    " + bubSortAvg);
    System.out.println("Merge Sort     " + merSortAvg);
    System.out.println("Quick Sort     " + quiSortAvg);
  }
  //METHODS ****************************************************************************** 
//Generates array 
  /*
   public static int[] generateArray() 
   {
   int[] array = new int[ARRAY_SIZE];
   /*Populates an int array called array with size ARRAY_SIZE with random numbers ranging
   * from 0 to RANDOM_MAX. 
   for(int i=0; i<ARRAY_SIZE; i++)
   {
   array[i] = (int)(Math.random()*RANDOM_MAX);
   }
   return array;
   } Cannot be used as assignment will refer to memory, therefore manipulating same array.*/
  //Selection Sort
  public static void selectionSort(int[] a)
  {
    for(int i=0; i<a.length; i++)
    {
      int smallIndex = 1;
      for(int j=i+1; j<a.length; j++)
      {
        checks[0] = checks[0]+1;
        if(a[j]<a[smallIndex]) {
          smallIndex = j;
        }
      }
      if(smallIndex != i)//swap
      {
        int temp = a[i];
        a[i] = a[smallIndex];
        a[smallIndex] = temp;
      }
    }
  }
  //Bubble Sort
  public static void bubbleSort(int[] a)
  {
    boolean hasSwapped = true;
    while(hasSwapped)
    {
      hasSwapped = false;
      for(int i=0; i<a.length-1; i++)
      {
        checks[1] = checks[1]+1;
        if(a[i]>a[i+1])
        {
          int temp=a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          hasSwapped = true;
        }
      }
    }
  }
  //Merge Sort
   public static void mergeSort(int[] a)//only one that gets out of bounds
   {
   int size = a.length;
   if(size<2)
	   return;
//   int mid = size/2;
//   int leftSize = mid;
//   int rightSize = size - mid;
   int[] left = new int[size/2];
   int[] right = new int[size-left.length];
   
   for(int i=0;i<(size/2);i++)//Populate the left
   {
   left[i]=a[i];
   }
   for(int i=(size/2);i<size;i++)
   {
   right[i-(size/2)] = a[i];
   }
   mergeSort(left);
   mergeSort(right);
   merge(left,right,a);
   }
   //merge left and right into array a
   private static void merge(int[] left, int[] right, int[] a)
   {
   int leftSize = left.length;
   int rightSize = right.length;
   int i = 0;//left array index
   int j = 0;//right array index
   int k = 0;//sorted array a index
   while(i<leftSize && j<rightSize)
   {
   checks[2] = checks[2]+1;
   if(left[i]<=right[j]) {
   a[k] = left[i];
   i++;
   }
   else {
   a[k] = right[j];
   j++;
   }
   k++;
   }
   while(i<leftSize)
   {
   a[k] = left[i];
   i++;
   k++;
   }
   while(j<rightSize)
   {
   a[k] = right[i];
   j++;
   k++;
   }
   } 
  /*
  public static void mergeSort(int[] a)
  {
    int size = a.length;
    if(size<2)
      return;
    int mid = size/2;
    int leftSize = mid;
    int rightSize = size - mid;
    int[] left = new int[leftSize];
    int[] right = new int[rightSize];
    
    System.arraycopy(a, 0, left, 0, mid);
    System.arraycopy(a, mid, right, 0, size);
    mergeSort(left);
    mergeSort(right);
    merge(a, left, right);
  }
  private static void merge(int[] a, int[] left, int[] right)
  {
    int leftSize = left.length;
    int rightSize = right.length;
    int i = 0;//left array index
    int j = 0;//right array index
    int k = 0;//sorted array a index
    
    while(i<leftSize && j<rightSize)
    {
      checks[2] = checks[2] + 1;
      if(left[i]<=right[j])
      {
        a[k] = left[i];
        i++;
      }
      else
      {
        a[k] = right[j];
        j++;
      }
      k++;
    }
    if(i == leftSize)
      System.arraycopy(right, j, a, k, rightSize - j);
    else
      System.arraycopy(left, i, a, k, leftSize - i);
  } */
  //Quick Sort
  public static void quickSort(int[] a)
  {
    quickSort(a, 0, a.length-1);
  }
  private static void quickSort(int[] a, int leftIndex, int rightIndex)
  {
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
      checks[3] = checks[3]+1;
      while(a[i]<pivot)
        i++;
      checks[3] = checks[3]+1;
      while(a[j]>pivot)
        j--;
      if(i<=j)//found values out of order so swap
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
  
}

