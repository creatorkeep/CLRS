package chapter2.session3;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args){
		int[] a = {8,7,6,5,4,3,2,1};
		bubblesort(a);
	}
	private static int[] bubblesort(int[] a){
		int counter = 0;
		// pos of the last item
		int n = a.length - 1;
		// initial val of i and j
		int i = 0;
		int j = n;
		// outer loop, i finishes at n - 1 th item
		for(i=0;i<n;i++){
			counter++;
			// inner loop finishes at i + 1, make sure that ith item is the smallest among the later ones
			for(j=n;j>i;j--){
				counter++;
				if(a[j-1]>a[j]){
					counter++;
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1]= temp;
				}
			}
		}
		System.out.println("The sorted array: " + Arrays.toString(a) + ", it takes " + counter + " times");
		return a;
	}
}
