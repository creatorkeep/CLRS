package chapter4;

public class StrassenAlgorithm {
	static int counter = 0;
	public static void main(String[] args){
		//testing data
		int[][] a = {{1,2,3,4},{2,2,3,4},{3,4,2,1},{4,2,1,2}};
		int[][] b = {{3,4,1,2},{1,2,3,4},{6,3,1,1},{4,2,3,1}};
		// start calculating a * b
		int[][] c = strassenAlgorithm(a, b);
		// print the result
		int n = a[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("The method is called " + counter + " times");
	}
	
	private static int[][] strassenAlgorithm(int[][] a, int[][] b){		
		counter++;
		int n = a[0].length;
		int mid = n/2;
		int[][] c = new int[n][n];
		if(n==1){
			c[0][0] = a[0][0] * b[0][0];
		}
		else{
			// make sub arrays
			int[][] a11 = new int[mid][mid];
			int[][] a12 = new int[mid][mid];
			int[][] a21 = new int[mid][mid];
			int[][] a22 = new int[mid][mid];
			int[][] b11 = new int[mid][mid];
			int[][] b12 = new int[mid][mid];
			int[][] b21 = new int[mid][mid];
			int[][] b22 = new int[mid][mid];
			int[][] c11 = new int[mid][mid];
			int[][] c12 = new int[mid][mid];
			int[][] c21 = new int[mid][mid];
			int[][] c22 = new int[mid][mid];
			
			// populate
			for(int i=0;i<mid;i++){
				for(int j=0;j<mid;j++){
					a11[i][j] = a[i][j];
					a12[i][j] = a[i][j+mid];
					a21[i][j] = a[i+mid][j];
					a22[i][j] = a[i+mid][j+mid];
					b11[i][j] = b[i][j];
					b12[i][j] = b[i][j+mid];
					b21[i][j] = b[i+mid][j];
					b22[i][j] = b[i+mid][j+mid];
				}
			}
			
			int[][] s1 = minus(b12, b22);
			int[][] s2 = add(a11, a12);
			int[][] s3 = add(a21, a22);
			int[][] s4 = minus(b21, b11);
			int[][] s5 = add(a11, a22);
			int[][] s6 = add(b11, b22);
			int[][] s7 = minus(a12, a22);
			int[][] s8 = add(b21, b22);
			int[][] s9 = minus(a11, a21);
			int[][] s10 = add(b11, b12);
			
			int[][] p1 = strassenAlgorithm(a11, s1);
			int[][] p2 = strassenAlgorithm(s2, b22);
			int[][] p3 = strassenAlgorithm(s3, b11);
			int[][] p4 = strassenAlgorithm(a22, s4);
			int[][] p5 = strassenAlgorithm(s5, s6);
			int[][] p6 = strassenAlgorithm(s7, s8);
			int[][] p7 = strassenAlgorithm(s9, s10);
			
			c11 = add(minus(add(p5,p4),p2),p6);
			c12 = add(p1, p2);
			c21 = add(p3, p4);
			c22 = minus(minus(add(p5, p1), p3), p7);
			
			//assemble c
			for(int i=0; i<mid; i++){
				for(int j=0; j<mid; j++){
					c[i][j] = c11[i][j];	
					c[i][j+mid] = c12[i][j];
					c[i+mid][j] = c21[i][j];
					c[i+mid][j+mid] = c22[i][j];
				}
			}			
		}
		return c;
	}
	
	private static int[][] add(int[][] a, int[][] b){
		int n = a[0].length;
		int[][] c = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				 c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	
	private static int[][] minus(int[][] a, int[][] b){
		int n = a[0].length;
		int[][] c = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++){
				 c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}

}
