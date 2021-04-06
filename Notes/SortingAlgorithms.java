/**
 * Auto Generated Java Class.
 */
public class SortingAlgorithms {
  
  
  public static void main(String[] args) { 
    
  }
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
    
    for(int i=0;i<mid;i++)//Populate the left
    {
      left[i]=a[i];
    }
    for(int i = mid;i<size;i++)
    {
      right[i-mid] = a[i];
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
      if(left[i]<=right[j]) {
        a[k] = left[i];
        i++;
        k++;
      }
      else {
        a[k] = right[j];
        j++;
        k++;
      }
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
  
  
  
  /* ADD YOUR CODE HERE */
  
}
