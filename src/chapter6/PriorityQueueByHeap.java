package chapter6;

import java.util.Arrays;

public class PriorityQueueByHeap extends BuildMaxHeap {
	
	public static void main(String[] args) {
		int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
//		MaxHeap maxheap = new MaxHeap(array);
//		array = BuildMaxHeap.buildMaxHeap(maxheap);
		//test heap maximum
		//System.out.println(heapMaximum(array));
		//
		//test heap extract max
		//heapExtractMax(array);
		//test heapIncreaseKey
		//heapIncreaseKey(array, 1, 17);
		//test maxHeapInsert
		//maxHeapInsert(array, 17);
		
	}
	private static int heapMaximum(int[] heapifiedArray) {
		return heapifiedArray[0];
	}
	
	private static int heapExtractMax(int[] array) {			
		if(array.length < 1) {
			System.err.println("heap underflow");
			return -1;
		}
		MaxHeap maxheap = new MaxHeap(array);
		int heapsize = maxheap.heapSize;
		BuildMaxHeap.buildMaxHeap(maxheap);
		int max = maxheap.array[0];
		maxheap.array[0] = maxheap.array[heapsize - 1];
		BuildMaxHeap.maxHeapify(maxheap, 0);
		System.out.println(Arrays.toString(maxheap.array));
		return max;		
	}

	private static void heapIncreaseKey(int[] array, int i, int key) {
		if(key < array[i]) {
			System.out.println("the value increased to is smaller than the original");
			return;
		}
		MaxHeap maxheap = new MaxHeap(array);
		BuildMaxHeap.buildMaxHeap(maxheap);
		maxheap.array[i] = key;
		while(i>0 && maxheap.array[i/2] < maxheap.array[i]) {
			int temp = maxheap.array[i/2];
			maxheap.array[i/2] = maxheap.array[i];
			maxheap.array[i] = temp;
			i = i / 2;
		}
		System.out.println(Arrays.toString(maxheap.array));
	}
	
	private static void maxHeapInsert(int[] array, int key) {
		int[] newArray = new int[array.length + 1];		
		for(int i=0; i<array.length; i++){
			newArray[i] = array[i];
		}
		MaxHeap maxheap = new MaxHeap(newArray);
		BuildMaxHeap.buildMaxHeap(maxheap);
		int heapsize = maxheap.heapSize;
		
		maxheap.array[heapsize - 1] = Integer.MIN_VALUE;
		heapIncreaseKey(maxheap.array, maxheap.heapSize-1, key);
	}
	

}
