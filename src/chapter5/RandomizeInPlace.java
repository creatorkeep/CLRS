package chapter5;

import java.util.Arrays;
import java.util.Random;

public class RandomizeInPlace {
	public static void main(String[] args){
		int a[] = {1,2,3,4,5,6,7};
		randomize(a);
	}
	private static void randomize(int[] arr){
		int length = arr.length;
		for(int i=0; i<length; i++){
			int pos = getRand(i, length-1);
			int temp;
			temp = arr[pos];
			arr[pos] = arr[i];
			arr[i] = temp;
			System.out.println(Arrays.toString(arr));
		}
		
	}
	
	private static int getRand(int a, int b) {
		Random rand = new Random();	
		// next int is exclusive
		return a + rand.nextInt(b-a+1);
		
	}

}
