package chapter2.session3;

// NOT SOLVED YET
import java.util.Arrays;

public class InsertionSortWithBinarySearch {
	public static void main(String[] args){
		int a[] = {8,7,6,5,4,3,2,1};
		insertionSortWithBinarySearch(a);

		

	}
	private static int[] insertionSortWithBinarySearch(int[] arr){
		int length = arr.length;
		for(int j=1; j<arr.length; j++){
			int key = arr[j];
			int i = j - 1;	
			int start = 0; 
			int end = i;
			int mid = 0;
			while(start<end){
			    mid = (start + end) / 2;
				if(arr[mid]>key && arr[mid+1]>key){
					end = mid - 1;
				} else if(arr[mid] < key && arr[mid-1]<key){
					start = mid + 1;
				} else {
					break;
				}
			}
			for(int k=mid+1; k<i;k++ ){
				arr[k + 1] = arr[k];
			}
			arr[mid+1] = key;
			
		}
		System.out.println(Arrays.toString(arr));;
		return arr;			
	}
	
	


}
