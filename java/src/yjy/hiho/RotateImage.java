package yjy.hiho;

public class RotateImage {
	
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==0){
        	return;
        }
        int left = 0,right = n-1;
        int top = 0,bottom = n-1;
        while(left<right){
        	for(int i=0;i<right-left;i++){
        		int tmp = matrix[top][left+i];
        		matrix[top][left+i]=matrix[bottom-i][left];
        		matrix[bottom-i][left]=matrix[bottom][right-i];
        		matrix[bottom][right-i]=matrix[top+i][right];
        		matrix[top+i][right]=tmp;
        	}
        	left++;
        	right--;
        	top++;
        	bottom--;
        }
    }

	public static void main(String[] args) {
		RotateImage s = new RotateImage();
		int[][] matrix = 
			{{1,2,3,0},
			{4,5,6,0},
			{7,8,9,0},
			{0,0,0,0}};
		
		int n = matrix.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(String.format("%d ",matrix[i][j]));
			}
			System.out.println("");
		}
		s.rotate(matrix);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(String.format("%d ",matrix[i][j]));
			}
			System.out.println("");
		}
	}

}
