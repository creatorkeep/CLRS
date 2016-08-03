package chapter2Exercise.session2;

import java.util.Arrays;

public class Exercise2 {
	//selection sort
	public static void main(String[] args){
		int[] a = {6,5,4,3,2,1};
		System.out.println(Arrays.toString(selectionSort(a)));
	}
	private static int[] selectionSort(int[] a){
		int counter = 0;
		int length = a.length;
		counter++;
		for(int i=0; i<length-1; i++){
			counter++;
			int min = a[i];
			int minpos = i;
			for(int j=i+1; j<length;j++){
				counter++;
				if(a[j]<min){
					counter++;
					min = a[j];
					minpos = j;
				}
			}
			//swap a[i] and min
			counter++;
			int temp;
			temp = a[i];
			a[i] = min;
			a[minpos] = temp;
		}
		System.out.println(counter);
		return a;
	}

}
