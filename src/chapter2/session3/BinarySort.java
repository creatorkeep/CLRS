package chapter2.session3;
// binary search
public class BinarySort {
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8};
		System.out.println(binarySearch(a, 4, 0, 7));
		
	}
	private static int binarySearch(int[] a, int key, int p, int q){
		if(p == q){
			if(key == a[p]){
				return p;
			} else {
				return -1;
					
			}
		}				
		if(q>p){
			// the average number between p and q
			int r = (q + p)/2;
			if(key == a[r]){
				return r;
			}
			if(key>a[r]){
				p = r + 1;
				// must return itself;
				return binarySearch(a,key,p,q);
				
			} 
			if(key<a[r]) {
				q = r - 1;
				return binarySearch(a,key,p,q);
			} 
		} 
        return -1;
		
		
		
	}
		

}
