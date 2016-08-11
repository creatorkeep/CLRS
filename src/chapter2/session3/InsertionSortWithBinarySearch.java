package chapter2.session3;

public class InsertionSortWithBinarySearch {
	public static void main(String[] args){
		
	}
	private static int[] insertionSortWithBinarySearch(int[] arr){
		int length = arr.length;
		for(int j=1; j<arr.length; j++){
			int key = arr[j];
			int i = j - 1;
//			while(i>-1&&(arr[i]>key)){
//				arr[i+1] = arr[i];
//				i--;
//			}
			//use binary here
			i = findPosition(arr, i, key);
			arr[i+1] = key;
		}
		
		return arr;			
	}
	private static int findPosition(int[] arr, int s, int i, int key){
		int start = s;
		int end = i;
		int q = (start + end)/2;
		if(s==i){
			return s;
		} else if(s>i){
			return i;
		}
		else{
			if(arr[i]<key){
				return i;
			}
			if(arr[s]>key){
				return s;
			}
			if(arr[q]<=key) {
				start = q + 1;
				return findPosition(arr, start, end, key);
			} else if(arr[q]>key) {
				end = q - 1;
				return findPosition(arr, start, end, key);					
			}
		}
	}

}
