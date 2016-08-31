package chapter5;

import java.util.Arrays;
import java.util.Random;

public class Exercise5_3_2 {
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7};
		permuteWithoutIdentity(a);
	}
	private static void permuteWithoutIdentity(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n-1; i++){
			int j = getRand(i+1, n-1);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private static int getRand(int a, int b) {
		Random rand = new Random();	
		// next int is exclusive
		return a + rand.nextInt(b-a+1);
		
	}
}
