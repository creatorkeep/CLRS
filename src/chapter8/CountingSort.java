package chapter8;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int[] array = {2,5,3,0,2,3,0,3};
		int[] array2 = {7,2,4,3,4,5,6,7};
		countingSort(array2);
	}
	
	private static void countingSort(int[] a) {
		int[] c = generateTempArray(a);
		int[] b = new int[a.length];
		for(int i=a.length-1; i>=0; i--) {
			// -1 here because we should put c[a[i]] stay in 0 - length-1, rather than 1 to length
			b[c[a[i]] - 1] = a[i]; 
			c[a[i]]--;
		}
		System.out.println(Arrays.toString(b));
	}
	
	/**
	 * 
	 * @param a input array
	 * @return an array c that each element counts the number of elements smaller than the number of its position
	 */
	private static int[] generateTempArray(int[] a) {
		// find maximum in a
		int max = findMaxInArray(a);
		//create a temp array		
		// use +1 here so that the last element in c's position should equal the max in a
		int[] c = new int[max + 1]; 
		for(int i=0; i<c.length; i++) {
			c[i] = 0;
		}
		//count the occurrence of each item in a and store them in c
		for(int i=0; i<a.length; i++) {
			c[a[i]]++;
		}
		// count number of elements <= current elements
		for(int i=1; i<c.length; i++) {
			c[i] = c[i] + c[i - 1];
		}
		return c;
		
	}
	
	private static int findMaxInArray(int[] a){
		int max = a[0];
		for(int i=0; i<a.length; i++) {
			if(a[i]>max) {
				max = a[i];
			}
		}
		return max;
	}
	
	
}
