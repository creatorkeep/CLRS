package chapter7;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {2,8,7,1,3,5,6,4};
		//partition(arr,0,arr.length-1);
		quickSort(arr, 0, arr.length-1);
	}
	protected static int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p - 1;
		for(int j=p; j<=r-1; j++){
			if(arr[j]<=x) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		System.out.println("The array after partition is " + Arrays.toString(arr));
		
		return i+1;
	}
	
	protected static int[] quickSort(int[] arr, int p, int r) {
		if (p<r) {
			int q = partition(arr, p, r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
			
		}
		System.out.println("The array after quickSort is " + Arrays.toString(arr));
		return arr;
	}
}
