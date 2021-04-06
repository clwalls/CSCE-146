
public class ProcessHeap<Process extends Comparable<Process>> {
	private Process[] heap;
	private int lastIndex;// Points to first null item
	public static final int DEFAULT_SIZE = 128;

	public ProcessHeap() {
		init(DEFAULT_SIZE);
	}

	public ProcessHeap(int size) {
		init(size);
	}

	public void init(int size) {
		if (size <= 0)
			return;
		heap = (Process[]) (new Comparable[size]);
		lastIndex = 0;
	}

	public void insert(Process aData) {
		if (lastIndex >= heap.length)
			return;// Heap was full
		heap[lastIndex] = aData;
		bubbleUp();
		lastIndex++;
	}

	public void bubbleUp() {
		int currIndex = lastIndex;
		while (currIndex > 0 && heap[(currIndex - 1) / 2].compareTo(heap[currIndex]) < 0) {
			// SWAP
			int parentIndex = (currIndex - 1) / 2;
			Process temp = heap[parentIndex];
			heap[parentIndex] = heap[currIndex];
			heap[currIndex] = temp;
			currIndex = parentIndex;
		}
	}

	public Process peek() {
		if (heap == null)
			return null;
		return heap[0];
	}

	public Process remove() {
		Process temp = peek();
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex - 1] = null;
		lastIndex--;
		bubbleDown();
		return temp;
	}

	private void bubbleDown() {
		int currIndex = 0;
		while (currIndex * 2 + 1 < lastIndex) {
			int bigIndex = currIndex * 2 + 1;// Assume the left is the largest
			if (currIndex * 2 + 2 < lastIndex && heap[currIndex * 2 + 1].compareTo(heap[currIndex * 2 + 2]) < 0) {
				bigIndex = currIndex * 2 + 2;
			}
			if (heap[currIndex].compareTo(heap[bigIndex]) < 0) {
				Process temp = heap[currIndex];
				heap[currIndex] = heap[bigIndex];
				heap[bigIndex] = temp;
			} else
				break;// No swap so stop
			currIndex = bigIndex;
		}
	}

	public void heapSort() {
		Process[] heap2 = heap.clone();
		int currIndex = lastIndex;
		for (int i = 0; i < currIndex; i++)
			System.out.println(this.remove());
		heap = heap2;
		lastIndex = currIndex;
	}

	public void printHeap() {
		for (int i = 0; i < lastIndex; i++) {
			System.out.println(heap[i]);
		}
	}
	
	public boolean isEmpty() {
		if(heap[0] == null) {
			return true;
		}else
			return false;
	}
}
