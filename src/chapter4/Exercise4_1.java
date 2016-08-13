package chapter4;

import java.util.Arrays;
import java.util.Date;

// brutal force solution of find-max-subarray
public class Exercise4_1 {
	public static void main(String[] args){
		int b[] = {-2,1};
		int[] arr = {-2, 1, 3, -5, 8};
		int n = arr.length - 1;
		long start = (new Date()).getTime();
		brutalForce(arr, 0, n);
		long end = (new Date()).getTime();
		System.out.println(end - start);
		
	}
	private static int[] brutalForce(int[] arr, int init, int end){
		int counter = 0;
		int[] result = new int[3];
		int max = Integer.MIN_VALUE;
		int m = -1;
		int n = -1;
		for(int i=init; i<=end; i++){
			counter++;
			int sum = 0;
			for(int j=i; j<=end; j++){
				counter++;
				sum += arr[j];
				if(sum>max){
					max = sum;
					m = i;
					n = j;
				}
			}
		}
		result[0] = m;
		result[1] = n;
		result[2] = max;
		System.out.println("It takes " + counter + " steps");
		System.out.println(Arrays.toString(result));
		return result;
	}

}
