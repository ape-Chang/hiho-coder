package yjy.hiho;

public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		int[][] A = new int[n][n];
		int count = 1;
		int top=0,bottom=n-1;
		int left=0,right=n-1;
		while(left<=right){
			int d = right-left;
			if(d==0){
				A[top][left]=count;
				break;
			}
			for(int i=left;i<right;i++){
				A[top][i]=count;
				count++;
			}
			for(int i=top;i<bottom;i++){
				A[i][right]=count;
				count++;
			}
			for(int i=right;i>left;i--){
				A[bottom][i]=count;
				count++;
			}
			for(int i=bottom;i>top;i--){
				A[i][left]=count;
				count++;
			}
			top++;
			bottom--;
			left++;
			right--;
		}
        return A;
    }
	
	public static void main(String[] args) {
		SpiralMatrixII s = new SpiralMatrixII();
		int n = 3;
		int[][] r = s.generateMatrix(n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(r[i][j]);
			System.out.print("\n");
		}
			
				
	}

}
