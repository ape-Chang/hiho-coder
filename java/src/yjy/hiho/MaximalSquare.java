package yjy.hiho;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
    	int m = matrix.length;
    	if(m==0){
    		return 0;
    	}
    	int n = matrix[0].length;
    	if(n==0){
    		return 0;
    	}
    	int[][] A = new int[m][n];
    	int[][] up = new int[m][n];
    	int[][] left = new int[m][n];
    	int max = 0;
    	if(matrix[0][0]=='1'){
    		A[0][0] = 1;
    		max = 1;
    		up[0][0] = 1;
    		left[0][0] = 1;
    	}else{
    		A[0][0] = 0;
    		up[0][0] = 0;
    		left[0][0] = 0;
    	}
    	for(int i=1;i<n;i++){
    		if(matrix[0][i]=='1'){
    			A[0][i] = 1;
    			max = 1;
        		up[0][i] = 1;
        		left[0][i] = left[0][i-1]+1;
    		}else{
    			A[0][i] = 0;
        		up[0][i] = 0;
        		left[0][i] = 0;
    		}
    	}
    	for(int i=1;i<m;i++){
    		if(matrix[i][0]=='1'){
    			A[i][0] = 1;
    			max = 1;
        		up[i][0] = up[i-1][0]+1;
        		left[i][0] = 1;
    		}else{
    			A[i][0] = 0;
        		up[i][0] = 0;
        		left[i][0] = 0;
    		}
    	}
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			if(matrix[i][j]=='1'){
    				up[i][j] = up[i-1][j]+1;
            		left[i][j] = left[i][j-1]+1;
            		A[i][j] = Math.min(A[i-1][j-1]+1,Math.min(up[i][j],left[i][j]));
            		max = Math.max(max,A[i][j]);
    			}else{
    				A[i][j] = 0;
            		up[i][j] = 0;
            		left[i][j] = 0;
    			}
    		}
    	}
        return max*max;
    }
	public static void main(String[] args) {
		MaximalSquare s = new MaximalSquare();
//		char[][] matrix = {
//				{'1', '0', '1', '0', '0'},
//				{'1', '0', '1', '1', '1'},
//				{'1', '1', '1', '1', '1'},
//				{'1', '1', '0', '1', '0'}
//		};
//		char[][] matrix = {
//				{'0', '0', '0'},
//				{'0', '0', '0'},
//				{'0', '0', '0'},
//				{'0', '0', '0'}
//		};
		char[][] matrix = {
			{'1'}
		};
		int r = s.maximalSquare(matrix);
		System.out.println(r);
	}

}
