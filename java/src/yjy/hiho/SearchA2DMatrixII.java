package yjy.hiho;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int n = matrix.length;
    	if(n==0)return false;
    	int m = matrix[0].length;
    	int i=n-1,j=0;
    	while(true){
    		if(i<0){break;}
    		if(matrix[i][j]==target){return true;}
    		if(j==m-1||matrix[i][j]>target){
    			i--;
    		}else{
    			j++;
    		}
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
		boolean r = s.searchMatrix(matrix,27);
		System.out.println(r);
	}

}
