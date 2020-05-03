package matrix;

public class Matrix {
	
	//Maximum Size Sub Array --> Square Matrix
	public void maxSizeSubArray(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		if(m==0 || n==0) return;
		int [][] temp = new int[m][n];
		for(int i=0;i<m;i++) {
			temp[0][i] = arr[0][i];
		}
		for(int i=0;i<n;i++) {
			temp[i][0] = arr[i][0];
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(arr[i][j]==1) {
					temp[i][j] = Math.min(temp[i][j-1], Math.min(temp[i-1][j], temp[i-1][j-1]))+1;
				}else {
					temp[i][j] = 0;
				}
			}
		}
		int val=0,i_index=0,j_index=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(temp[i][j]>val) {
					val = temp[i][j];
					i_index = i;
					j_index = j;
				}
			}
		}
		
		for(int i=i_index;i>i_index-val;i--) {
			for(int j=j_index;j>j_index-val;j--) {
				System.out.print("1 ");
			}
			System.out.println();
		}		
	}
	
	//Transpose of Square Matrix
	public void squareTranspose(int [][] arr) {
		if(arr.length==0) return;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
	
	//Transpose of Square Matrix
	public void rectangelTranspose(int[][] arr) {
		if(arr.length==0) return;
		int rows = arr.length;
		int cols = arr[0].length;
		int [][] transposedArray = new int[cols][rows];
		for(int i=0;i<cols;i++) {
			for(int j=0;j<rows;j++) {
				transposedArray[i][j] = arr[j][i];
			}
		}
		
		//printing Transposed Array
		for(int i=0;i<cols;i++) {
			for(int j=0;j<rows;j++) {
				System.out.print(transposedArray[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	// Turn Image By 90 --> Inplace Solution
	public void turnImage(int[][] arr) {
		if(arr.length==0) return;
		squareTranspose(arr);
		int n = arr.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n/2;j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][n-j-1];
				arr[i][n-j-1] = temp;
			}
		}
	}
	
	// Search in a row wise and column wise sorted matrix
	public void searchSortedMatrix(int[][] arr,int target) {
		if(arr.length==0) return;
		int rows = arr.length;
		int cols = arr[0].length;
		int rowIndex = rows-1;
		int colIndex = 0;
		while(rowIndex>=0 && rowIndex<rows && colIndex>=0 && colIndex<cols) {
			int curr_value = arr[rowIndex][colIndex];
			if(curr_value == target) {
				System.out.println("Element Found at row: "+rowIndex+" And Column: "+colIndex);
				return;
			}else if(curr_value<target) {
				colIndex++;
			}else {
				rowIndex--;
			}
		}
		System.out.println("Element Not Found in Array");
	}	
	
	// Print a given matrix in spiral form
	public void spiralPrint(int[][] arr) {
		if(arr.length==0) return;
		int t = 0;
		int b = arr.length-1;
		int l = 0;
		int r = arr[0].length-1;
		int dir = 0;
		while(t<=b && l<=r) {
			if(dir==0) {
				int i = l;
				while(i<=r) {
					System.out.print(arr[t][i]+" ");
					i++;
				}
				t++;
				dir = 1;
			}else if(dir==1) {
				int i = t;
				while(i<=b) {
					System.out.print(arr[i][r]+" ");
					i++;
				}
				r--;
				dir = 2;
			}else if(dir==2) {
				int i = r;
				while(i>=l) { 
					System.out.print(arr[b][i]+" ");
					i--;
				}
				b--;
				dir = 3;
			}else if(dir==3) {
				int i = b;
				while(i>=t) {
					System.out.print(arr[i][l]+" ");
					i--;
				}
				l++;
				dir = 0;
			}
		}
	}
	
	// Boolean Matrix Question
	public void booleanChange(int[][] arr) {
		if(arr.length==0) return;
		int rows = arr.length;
		int cols = arr[0].length;
		boolean firstRow = false;
		boolean firstCol = false;
		for(int i=0;i<cols;i++) {
			if(arr[0][i]==1) {
				firstRow = true;
				break;
			}
		}
		for(int i=0;i<rows;i++) {
			if(arr[i][0]==1) {
				firstCol = true;
				break;
			}
		}
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				if(arr[i][j]==1) {
					arr[0][j] = 1; 				// Make it first Row corresponding value as one
					arr[i][0] = 1; 				// Make it first col corresponding value as one
				}
			}
		}
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				if(arr[0][j]==1 || arr[i][0] ==1) {
					arr[i][j] = 1;
				}
			}
		}
		if(firstRow) {
			for(int i=0;i<cols;i++) {
				arr[0][i] = 1;
			}
		}
		if(firstCol) {
			for(int j=0;j<rows;j++) {
				arr[j][0] = 1;
			}
		}
		
	}
	
	//Min Cost Path
	public int minCostPath(int[][] arr) {
		if(arr==null|| arr.length==0|| arr[0].length==0) return 0;
		int m = arr.length;
		int n = arr[0].length;
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum+=arr[0][i];
			arr[0][i] = sum;
		}
		sum = 0;
		for(int i=0;i<m;i++) {
			sum+=arr[i][0];
			arr[i][0] = sum;
		}
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				int minValue = (arr[i-1][j]<arr[i][j-1])?arr[i-1][j]:arr[i][j-1];
				arr[i][j]+=minValue;
			}
		}
		return arr[m-1][n-1];	
	}
	
	//Find the row with maximum number of 1s
	public int maxRow(int[][] arr) {
		if(arr==null || arr.length==0 || arr[0].length==0) return -1;
		int m = arr.length;
		int n = arr[0].length;
		int max_row = -1;
		int max_value = 0;
		for(int i=m-1;i>=0;i--) {
			if(arr[i][0]==1) {
				return i;
			}else {
				for(int j=1;j<n;j++) {
					int val = n-j;
					if(arr[i][j]==1) {
						if(val>=max_value) {
							max_value = val;
							max_row = i;
						}
						break;
					}
					if(val<max_value) {
						break;
					}
				}
			}
		}
		return max_row;
	}
	
	
	//Number of Islands
	public int noOfIslands(int[][] grid) {
		if(grid==null || grid.length==0 || grid[0].length==0) return 0;
		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(grid[i][j]==1) {
					++count;
					markIsland(grid,i,j,rows,cols);
				}
			}
		}
		return count;
	}
	
	//Helper Function
    public void markIsland(int[][] grid,int i,int j,int rows,int cols){
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]!=1) return;
        grid[i][j] = 2;
        
        markIsland(grid,i-1,j,rows,cols);
        markIsland(grid,i+1,j,rows,cols);
        markIsland(grid,i,j-1,rows,cols);
        markIsland(grid,i,j+1,rows,cols);
    }
    
    //Maximum sum rectangle in a 2D matrix
    public int maxSumRectangle(int[][] arr) {
    	if(arr==null || arr.length==0 || arr[0].length==0) return 0;
    	int rows = arr.length;
    	int cols = arr[0].length;	
    	int currMax = 0;
    	int finalMax = 0;
		for(int l=0;l<cols;l++){
		    int [] curr = new int[rows];
		    for(int r=l;r<cols;r++){
		        for(int i=0;i<rows;i++){
		            curr[i]+=arr[i][r];
		        }
		        currMax = maxSubArray(curr);
		        finalMax = Math.max(currMax,finalMax);
		    }
		}
		return finalMax;
    }
    
    //Kadanes Algorithm --> Helper Function
	private  int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int prevMax = nums[0];
        int currMax = nums[0];
        for(int i=1;i<nums.length;i++){
            currMax = Math.max(nums[i],nums[i]+currMax);
            prevMax = Math.max(prevMax,currMax);
        }
        return prevMax;
    }
	
	//Rotate Matrix Elements
	public void rotateMatrix(int[][] arr) {
		if(arr==null || arr.length==0 || arr[0].length==0) return;
		int rs = 0;
		int re = arr.length-1;
		int cs = 0;
		int ce = arr[0].length-1;
		int dir = 0;
		int temp1 = 0;
		int temp2 = 0;
		int c =0;
		while(rs<=re && cs<=ce){
            if(dir==0){
            	temp1 = arr[rs][cs];
                for(int i=cs+1;i<=ce;i++){
                	temp2 = arr[rs][i];
                	arr[rs][i] = temp1;
                	temp1 = temp2;
                }
                rs++;
                dir=1;
            }
            else if(dir==1){
                for(int i=rs;i<=re;i++){
                	temp2 = arr[i][ce];
                	arr[i][ce] = temp1;
                	temp1 = temp2;
                }
                ce--;
                dir=2;
            }
            else if(dir==2){
                for(int i=ce;i>=cs;i--){
                	temp2 = arr[re][i];
                	arr[re][i] = temp1;
                	temp1 = temp2;
                }
                re--;
                dir=3;
            }
            else if(dir==3){
            	c++;
                for(int i=re;i>=rs;i--){
                	temp2 = arr[i][cs];
                	arr[i][cs] = temp1;
                	temp1 = temp2;
                }
                arr[rs-1][cs] = temp1;
                cs++;
                dir=0;
            }
        }
		arr[rs-1][cs] = temp1;
	}
	
	//Given a Boolean Matrix, find k such that all elements in k’th row are 0 and k’th column are 1
	public int validMatrix(int[][] arr) {
		if(arr==null || arr.length==0 || arr[0].length==0) return 0;
		int rows = arr.length-1;
		int cols = arr[0].length-1;
		int i = 0;
		int j = 0;
		while(i<=rows && j<=cols) {
			if(isValidRow(arr,i,cols) && isValidCol(arr, j, rows)) {
				return i;
			}
			i++;
			j++;
		}
		return -1;
	}
	
	//Helper Function
	private boolean isValidRow(int[][] arr,int rowNumber,int cols) {
		for(int i=0;i<cols;i++) {
			if(i==rowNumber) {
				continue;
			}
			if(arr[rowNumber][i]!=0) {
				return false;
			}
		}
		return true;
	}
	
	//Helper Function
	private boolean isValidCol(int[][] arr,int colNumber,int rows) {
		for(int i=0;i<rows;i++) {
			if(i==colNumber) {
				continue;
			}
			if(arr[i][colNumber]!=1) {
				return false;
			}
		}
		return true;
	}
	
	
	
}
