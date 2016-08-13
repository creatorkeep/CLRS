package chapter4;

import java.util.Arrays;

// linear efficiency for find max subarray
public class Exercise4_1_5 {
	public static void main(String[] args){
		int a[] = {-2, -1, -3, -5, -2};
		linearSubArray(a,0,4);
	}
	
	private static int[] linearSubArray(int[] arr, int m, int n){
		int max = Integer.MIN_VALUE;
		int[] result = new int[3];
		int sum = 0;
		// this oldStart is very important for the recording the beginning of the subarray
		int start = 0;
		int tempStart = 0;
		int end = 0;
		for(int i=m;i<=n;i++){
			// if the current sum is negative, the next element must be a new beginning of the max sum,
			// since the negative sum can make the sum of i+1 elements smaller 
			if(sum<0){
				// reset the sum and make this element a new beginning
				sum = 0;	
				// use this temp start as a potential beginning, since the current item may not be the beginning
				tempStart = i;
			} 		
			// no matter what sum looks like, just keep adding new items
			// even if the previous sum is set to zero, still add the current item
			sum += arr[i];			
			
			if(sum > max){
				// if the subarray could be a max, then assign the temp start  to the old start
				start = tempStart;
				max = sum;
				end = i;
			}
		}
		// old start is used to mark the beginning
		result[0] = start;
		result[1] = end;
		result[2] = max;
		System.out.println(Arrays.toString(result));
		return result;
	}

}
