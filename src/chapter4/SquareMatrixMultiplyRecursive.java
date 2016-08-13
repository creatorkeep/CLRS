package chapter4;

public class SquareMatrixMultiplyRecursive {
	static int counter = 0;
	public static void main(String[] args){
		//testing data
		int[][] a = {{1,2,3,4},{2,2,3,4},{3,4,2,1},{4,2,1,2}};
		int[][] b = {{3,4,1,2},{1,2,3,4},{6,3,1,1},{4,2,3,1}};
		// start calculating a * b
		int[][] c = squareMatrixMultiplyRecursive(a, b);
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
	
	private static int[][] squareMatrixMultiplyRecursive(int[][] a, int[][] b){
		//every time the method is called, count++
		counter++;
		int[][] a11, a12, a21, a22, b11, b12, b21, b22, c11, c12, c21, c22;		
		int n = a[0].length;
		int[][] c = new int[n][n];
		// if there is only one item in a and b
		if(n == 1){
			c[0][0] = a[0][0] * b[0][0];
		//if n = 2^k 
		} else {			
			//split the matrix into 4 pieces
			int mid = n/2;
			// I don't know how to make a Theta(1) split on these matrices in JAVA		
			// init the matrices
			a11 = new int[n/2][n/2];
			a12 = new int[n/2][n/2];
		    a21 = new int[n/2][n/2];
		    a22 = new int[n/2][n/2];
		    b11 = new int[n/2][n/2];
		    b12 = new int[n/2][n/2];
		    b21 = new int[n/2][n/2];
		    b22 = new int[n/2][n/2];
		    c11 = new int[n/2][n/2];
		    c12 = new int[n/2][n/2];
		    c21 = new int[n/2][n/2];
		    c22 = new int[n/2][n/2];		 
		    //assign value from a and b to them
			for(int i=0;i<mid;i++){
				for(int j=0; j<mid;j++){
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
			// so, the new matrices should be like 0 - n/2, n/2+1 - n-1
			c11 = matrixplus(squareMatrixMultiplyRecursive(a11,b11), squareMatrixMultiplyRecursive(a12, b21));
			c12 = matrixplus(squareMatrixMultiplyRecursive(a11,b12), squareMatrixMultiplyRecursive(a12, b22));
			c21 = matrixplus(squareMatrixMultiplyRecursive(a21,b11), squareMatrixMultiplyRecursive(a22, b21));
			c22 = matrixplus(squareMatrixMultiplyRecursive(a21,b12), squareMatrixMultiplyRecursive(a22, b22));
			// compose c
			for(int i=0; i<mid; i++){
				for(int j=0; j<mid; j++){
					c[i][j] = c11[i][j];	
					c[i][j+mid] = c12[i][j];
					c[i+mid][j] = c21[i][j];
					c[i+mid][j+mid] = c22[i][j];
				}
			}
		}		
		// whatever, return c
		return c;
		
	}
	private static int[][] matrixplus(int[][] a, int[][] b){
		int n = a[0].length;
		int[][] c = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				 c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	

}
