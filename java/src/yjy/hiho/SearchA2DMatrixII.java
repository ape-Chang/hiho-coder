package yjy.hiho;

// 未完成
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int x) {
    	int m = matrix.length;
    	if(m==0){
    		return false;
    	}
    	int n = matrix[0].length;
    	if(n==0){
    		return false;
    	}
    	int top=0,left=0,bottom=m-1,right=n-1;
    	
    	while(top<bottom && left<right){
    		int i=top;
    		int j=bottom;
    		while(i<j){
    			int mid = (i+j)/2;
    			if(matrix[mid][right]==x){
    				return true;
    			}else if(matrix[mid][right]>x){
    				j=Math.max(i,mid-1);
    			}else if(matrix[mid][right]<x){
    				i=mid+1;
    			}
    		}
    		if(i==j){
    			if(matrix[i][right]==x){
    				return true;
    			}else if(matrix[i][right]>x){
    				
    			}
    		}
    	}
    	
    	if(top==bottom){
    		return this.findXRow(top, x, left, right, matrix);
    	}
    	if(left==right){
    		return this.findXColumn(left, x, top, bottom, matrix);
    	}
        return false;
    }
    
    boolean findXRow(int row,int x,int left,int right,int[][] matrix){
    	int i=left;
    	int j=right;
    	while(i<j){
    		int mid = (i+j)/2;
    		if(matrix[row][mid]==x){
    			return true;
    		}else if(matrix[row][mid]>x){
    			j=mid-1;
    		}else if(matrix[row][mid]<x){
    			i=mid+1;
    		}
    	}
    	if(i==j){
    		return matrix[row][i]==x;
    	}
    	return false;
    }
    
    boolean findXColumn(int column,int x,int top,int bottom,int[][] matrix){
    	int i=top;
    	int j=bottom;
    	while(i<j){
    		int mid = (i+j)/2;
    		if(matrix[mid][column]==x){
    			return true;
    		}else if(matrix[mid][column]>x){
    			j=mid-1;
    		}else if(matrix[mid][column]<x){
    			i=mid+1;
    		}
    	}
    	if(i==j){
    		return matrix[i][column]==x;
    	}
    	return false;
    }

	public static void main(String[] args) {
		SearchA2DMatrixII s = new SearchA2DMatrixII();
		int[][] matrix = {
		                  {1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}
		};
		s.searchMatrix(matrix,5);
	}

}
