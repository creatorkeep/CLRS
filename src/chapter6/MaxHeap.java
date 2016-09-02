package chapter6;

public class MaxHeap {
	int[] array;
	int length;
	int heapSize;
	public MaxHeap(int[] arr){
		this.array = arr;
		this.length = arr.length;	
		this.heapSize = length;
	}
}
