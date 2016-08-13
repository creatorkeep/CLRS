package chapter2;

import java.util.Arrays;

public class MergeSort {

	public static int counter = 0;
	public static int inverse = 0;
	public static void main(String[] args){
		int[] a = {5,6,7,8,1,2,3,4};
//	int[] a = {8,7,6,5,4,3,2,1};
	//	int[] a = {4,3,2,1};
		//merge(a,0,3,a.length-1);
		mergeSort(a,0,a.length-1);
		System.out.println("Final Result is " + Arrays.toString(a));
		System.out.println("run time is " + counter);
		System.out.println("inverse is "+ inverse);
	}
	private static int[] mergeSort(int[] a, int p, int r) {
		int q;
		if(p<r){
			q = (p+r)/2;
			System.out.println(q+"-------sort from " + p + " to " + q + "---------");
			mergeSort(a,p,q);
			System.out.println("*******sort from " + (q+1) + " to " + r + "**********");
			mergeSort(a,q+1,r);
			System.out.println("@@@@@@@@merge@@@@@@@@");
			merge(a,p,q,r);
		}
		counter++;

		return a;
	}
	
	private static int[] merge(int[] a, int p, int q, int r) {

		counter++;

		System.out.println("p="+p + "and " + "q=" + q);
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] left = new int[n1];
		int[] right = new int[n2];
		// make left right, left part and right part must be sorted inside
		for(int i = 0; i< n1; i++){
			left[i] = a[p + i];			
		}
		for(int j = 0; j<n2;j++){
			right[j] = a[q+1+j];
		}
		System.out.println("left: " + Arrays.toString(left));
		System.out.println("right: " +Arrays.toString(right));
		
		// after assignment, start merging
		int li = 0; 
		int ri = 0;
		// use the absolute position here rather so that the loop will not put a[0] all the time
		int i = p;
		// here also
		for(;i<=r;i++){
			if(li>left.length-1){

				inverse+= (n1-li);
				a[i] = right[ri];
				ri++;
			} else if(ri>right.length-1){
				a[i] = left[li];
				li++;
			} else if(left[li]<=right[ri] ){

				a[i] = left[li];
				li++;
			} else if(right[ri]<left[li]){
				inverse+=(n1-li);
				a[i] = right[ri];
				ri++;
			}
		}
		System.out.println("merged: " +Arrays.toString(a));
		return a;
	}

}
