package chapter7;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort extends QuickSort{
	public static void main(String[] args) {
		int[] arr = {2,8,7,1,3,5,6,4};
		randomizedQuickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
	private static int randomizedPartition(int[] arr, int p, int r) {
		Random rand = new Random(47);
		int increase = rand.nextInt(r-p+1);
		int temp = arr[increase + p];
		arr[increase + p] = arr[r];
		arr[r] = temp;
		return partition(arr, p, r);
	}
	
	private static void randomizedQuickSort(int[] arr, int p, int r) {
		if(p<r) {
			int q = randomizedPartition(arr, p, r);
			randomizedQuickSort(arr, p, q-1);
			randomizedQuickSort(arr, q+1, r);
		}
	}

}
