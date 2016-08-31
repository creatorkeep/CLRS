package chapter6;

import java.util.Arrays;

class MaxHeap {
	int[] array;
	int length;
	int heapSize;
	public MaxHeap(int[] arr){
		this.array = arr;
		this.length = arr.length;	
		this.heapSize = length;
	}
}

public class BuildMaxHeap {
	public static void main(String[] args) {
		int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		MaxHeap mh = new MaxHeap(array);
		System.out.println(Arrays.toString(maxHeapify(mh, 1)));
		System.out.println(Arrays.toString(buildMaxHeap(mh)));
		System.out.println(Arrays.toString(heapSort(mh)));
		//System.out.println(Arrays.toString(mh.array));
	}
	private static int[] maxHeapify(MaxHeap mh, int i) {
		int[] arr = mh.array;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest;
		if (left< mh.heapSize && arr[left] > arr[i]) {
			largest = left;
		} else {
			largest = i;
		}
		if (right< mh.heapSize && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			maxHeapify(mh, largest);
		}
		
		return arr;
	}
	private static int[] buildMaxHeap(MaxHeap maxheap) {
		int[] arr = maxheap.array;
		maxheap.heapSize = maxheap.array.length;
		for(int i=maxheap.length/2 - 1 ;i>=0; i--) {
			maxHeapify(maxheap, i);
		}
		return arr;
	}
	
	private static int[] heapSort(MaxHeap maxheap) {
		buildMaxHeap(maxheap);
		int[] arr = maxheap.array; 
		for(int i= maxheap.length - 1; i>=1; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;			
			maxheap.heapSize = maxheap.heapSize - 1;
			maxHeapify(maxheap, 0);
		}
		return arr;
	}
}
