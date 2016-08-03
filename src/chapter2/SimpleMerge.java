package chapter2;

import java.util.Arrays;

public class SimpleMerge {
	
	public static void main(String[] args){
		int[] a = {2,4,5,7,1,2,3,6};
		System.out.println(Arrays.toString(merge(a)));
	}
	
	private static int[] merge(int[] a){
		int i,j;
		int p = 0;
		int r = a.length - 1;
		int q = 3;
		int[] L = new int[5];
		int[] R = new int[5];
		for(i=0;i<L.length-1;i++){
			L[i] = a[i];
		}
		for(j=0;j<R.length-1;j++){
			R[j] = a[4 + j];
		}
		L[4] = Integer.MAX_VALUE;
		R[4] = Integer.MAX_VALUE;
		i=0;
		j=0;
		for(int k=0; k<a.length; k++){
			if(L[i] <= R[j]){
				a[k] = L[i];
				i++;
			}
			else {
				a[k] = R[j];
				j++;
			}
		}
		return a;
	}
}


