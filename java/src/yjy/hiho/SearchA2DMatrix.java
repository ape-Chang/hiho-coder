package yjy.hiho;

public class SearchA2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int i=0,j=m-1;
		while(i<j){
			int mid=(i+j)/2;
			if(matrix[mid][0]==target){
				return true;
			}else if(matrix[mid][0]>target){
				j = mid-1;
			}else if(matrix[mid][0]<target){
				i = mid+1;
			}
		}
		int min = Math.max(0,Math.min(i,j)-1);
		int max = Math.min(m-1, Math.max(i,j)+1);
		if(matrix[min][0]>target){
			return false;
		}
		int k;
		for(k=min;k<=max;k++){
			if(matrix[k][0]>target){
				break;
			}
		}
		k--;
		System.out.println(k);
		i=0;j=n-1;
		while(i<=j){
			if(i==j){
				return matrix[k][i]==target;
			}
			int mid=(i+j)/2;
			if(matrix[k][mid]==target){
				return true;
			}else if(matrix[k][mid]>target){
				j = mid-1;
			}else if(matrix[k][mid]<target){
				i = mid+1;
			}
		}
        return false;
    }

	public static void main(String[] args) {
		SearchA2DMatrix s =new SearchA2DMatrix();
		int[][] matrix = {
		                  {1, 	3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}
						};
		boolean r = s.searchMatrix(matrix,7);
		System.out.println(r);
	}

}
