package yjy.hiho;

public class UniquePathsII {
	
	public int uniquePathsWithObstacles(int[][] O) {
		int m = O.length;
		if(m==0){
			return 1;
		}
		int n = O[0].length;
		if(n==0){
			return 1;
		}
		int[][] A = new int[m][n];
		if(O[0][0]==1 || O[m-1][n-1]==1){
			return 0;
		}
		A[0][0] = 1;
        for(int i=1;i<m;i++){
        	if(O[i][0]==1 || A[i-1][0]==0){
        		A[i][0] = 0;
        	}else{
        		A[i][0] = 1;
        	}
        }
        for(int i=1;i<n;i++){
        	if(O[0][i]==1 || A[0][i-1]==0){
        		A[0][i] = 0;
        	}else{
        		A[0][i] = 1;
        	}
        }
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		if(O[i][j]==1){
        			A[i][j] = 0;
        		}else{
        			A[i][j] = A[i-1][j]+A[i][j-1];
        		}
        	}
        }
        return A[m-1][n-1];
    }

	public static void main(String[] args) {
		UniquePathsII s = new UniquePathsII();
		int[][] o = {
		             {0,0,0},
		             {1,0,0},
		             {0,0,0}
		             };
		int r = s.uniquePathsWithObstacles(o);
		System.out.println(r);
	}

}
