package hw05;

public class SearchAndSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {1,2,3,4,5,6,7,8};
		System.out.println(binarySearchRecur(s,0,0,8));
	}
	public static boolean linearSearchIter(int[] a, int val)
	{
		for (int i=0; i<a.length;i++)
		{
			if(a[i]==val)
				return true;
		}
		return false;
	}
	public static boolean linearSearchRecur(int[] a, int val, int currIndex)
	{
		if(a[currIndex]==val)
			return true;
		currIndex++;
		if(currIndex>=a.length)
			return false;
		else
			return linearSearchRecur(a, val, currIndex);
	}
	public static boolean binarySearchRecur(int[] a, int val, int minIndex, int maxIndex)
	{
		System.out.println("iteration");
		if(minIndex>maxIndex)//Never found
			return false;
		int midIndex =(maxIndex+minIndex)/2;
		if(a[midIndex]==val)
			return true;
		if(val>a[midIndex])//we need to search top half
			return binarySearchRecur(a,val,midIndex+1,maxIndex);
		else //search the lower half
			return binarySearchRecur(a,val,minIndex,midIndex-1);
	}
	public static void selectionSort(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			int smallIndex = 1;
			for(int j = i+1; j<a.length; j++)
			{
				if(a[j]<a[smallIndex])
					smallIndex = j;
			}
			if(smallIndex != i)//swap
			{
				int temp = a[i];
				a[i] = a[smallIndex];
				a[smallIndex] = temp;
			}
		}
	}
	public static void bubbleSort(int[] a)
	{
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			for(int i = 0; i<a.length-1;i++)
			{
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
	public static void mergeSort(int[] a)
	{
		int size = a.length;
		if(size<2)
			return;
		int mid = size/2;
		int leftSize = mid;
		int rightSize = size-mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		for (int i =0; i<leftSize;i++)//just populates left array
		{
			left[i]=a[i];
		}
		for(int i =mid; i<size; i++)
		{
			right[i-mid]=a[i];
		}
		mergeSort(left);
		mergeSort(right);
		//TODO merge
	}
}
