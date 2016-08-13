package chapter4;

import java.util.Arrays;
import java.util.Date;

public class FindMaxSubarray {
	static int counter = 0;
	public static void main(String[] args){
		int b[] = {-2,1};
		int c[] = {};
		//test find max crossing array
		int a[] = {-2, 1, 3, -5, 2};
		findMaxCrossingSubarray(a, 0, 1, 3);
		
		long start = (new Date()).getTime();
		int[] x = findMaxSubarray(a, 0 , a.length-1);
		//int[] x = findMaxSubarray(c, 0 , 0);
		long end = (new Date()).getTime();
		System.out.println(end - start);
		System.out.println(Arrays.toString(x));
		System.out.println(counter);
		
	}
	private static int[] findMaxSubarray(int[] arr, int low, int high) {
		counter++;
		
		int[] result = new int[3];
		//allow empty array as input 4.1-4
		if(arr.length == 0){
			result[0] = 0;
			result[1] = 0;
			result[2] = 0;
			return result;
		}
			
		if(high == low) {
			result[0] = low;
			result[1] = high;
			result[2] = arr[low];
			return result;
		} 
		else {
			int mid = (low + high) / 2;
			int[] leftResult = new int[3];
			int[] rightResult = new int[3];
			int[] midResult = new int[3];
			leftResult = findMaxSubarray(arr, low, mid);
			rightResult = findMaxSubarray(arr, mid+1, high);
			midResult = findMaxCrossingSubarray(arr, low, mid, high);
			// find the max
			if(leftResult[2]>=rightResult[2] && leftResult[2]>=midResult[2]){
				return leftResult;
			} 
			else if (rightResult[2]>=leftResult[2] && rightResult[2]>=midResult[2]){
				return rightResult;
			} 
			else {
				return midResult;
			}
			
		}
	}
	
	private static int[] findMaxCrossingSubarray(int[] arr, int low, int mid, int high){
		int leftSum = Integer.MIN_VALUE;
		int maxLeft = mid;
		int maxRight = mid;
		int sum = 0;
		int[] resultArr = new int[3];
		for(int i=mid; i>=low; i--){
			sum += arr[i];
			if(sum>leftSum){
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		for(int j=mid+1;j<=high;j++){
			sum += arr[j];
			if(sum>rightSum){
				rightSum = sum;
				maxRight = j;
			}
		}
		sum = leftSum + rightSum;
		resultArr[0] = maxLeft;
		resultArr[1] = maxRight;
		resultArr[2] = sum;
		System.out.println("Result tuple is " + Arrays.toString(resultArr));
		return resultArr;
	}
}
