package matrix;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Matrix matrix = new Matrix();
		//Binary Matrix
		int [][] binary = new int[][] {
			{0, 1, 1, 0, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1}
            };
		
		int [][] squareMatrix = new int[][] {
			{1,  2,  3,  4}, 
	        {5,  6,  7,  8}, 
	        {9,  10, 11, 12}, 
	        {13, 14, 15, 16}
		};
		
		int [][] rectangelMatrix = new int[][] {
			{1, 2, -1, -4, -20},  
            {-8, -3, 4, 2, 1},  
            {3, 8, 10, 1, 3},  
            {-4, -1, 1, 7, -6}
            };
		
//		matrix.maxSizeSubArray(binary);
//		matrix.squareTranspose(squareMatrix);
//		matrix.turnImage(squareMatrix);
//		matrix.searchSortedMatrix(squareMatrix, 15);
//		for(int i=0;i<squareMatrix.length;i++) {
//			for(int j=0;j<squareMatrix.length;j++) {
//				System.out.print(squareMatrix[i][j]+" ");
//			}
//			System.out.println( );
//		}
//		matrix.rectangelTranspose(rectangelMatrix); 
//		matrix.spiralPrint(rectangelMatrix);
//		matrix.booleanChange(binary);
//		for(int i=0;i<binary.length;i++) {
//			for(int j=0;j<binary[0].length;j++) {
//				System.out.print(binary[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(matrix.minCostPath(squareMatrix));
//		System.out.println(matrix.maxRow(binary));
//		System.out.println(matrix.noOfIslands(binary));
//      System.out.println(matrix.maxSumRectangle(rectangelMatrix));
//        matrix.rotateMatrix(squareMatrix); 
//        for(int i=0;i<squareMatrix.length;i++) {
//        	for(int j=0;j<squareMatrix[0].length;j++) {
//        		System.out.print(squareMatrix[i][j]+" ");
//        	}
//        	System.out.println();
//        }
//        System.out.println(matrix.validMatrix(binary));
          
    
            
	}
}


  
/*
 * Driver Code for Online editor
 * 
 * 		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    t--;
			int m = sc.nextInt();
			int n = sc.nextInt();
			int [][] arr = new int[m][n];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(maxRow(arr));
		}
 *  
 */
