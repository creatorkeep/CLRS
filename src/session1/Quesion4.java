package session1;

import java.util.Arrays;

public class Quesion4 {
	public static void main(String[] args){
		int[] a = {1,1,1,1};
		int[] b = {1,1,1,1};
		System.out.println(Arrays.toString(addBinary(a, b)));
	}
	private static int[] addBinary(int[] a, int[] b){
		if(a.length != b.length){
			System.err.println("Please enter arrays with equal size");
			return null;
		} 
		
		int n = a.length;
		int[] c = new int[n+1];
		for(int i=0;i<n;i++){
			c[i+1] = a[i] + b[i];
		}
		c[0] = 0;
		
		for(int j=n; j>-1;j--){
			if(c[j]>=2){
				c[j-1] += 1;
				c[j] -= 2;
			}
		}
		return c;
			
		
	}
}
