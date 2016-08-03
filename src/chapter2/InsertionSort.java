package chapter2;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args){
		System.out.println("Start Sorting");
		int[] arr = {5,2,4,6,1,3};
		System.out.println(Arrays.toString(insertionSort(arr)));
	}
	
	private static int[] insertionSort(int[] arr){
		int length = arr.length;
		for(int j=1; j<arr.length; j++){
			int key = arr[j];
			int i = j - 1;
			while(i>-1&&(arr[i]>key)){
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}
		
		return arr;
	}

}
