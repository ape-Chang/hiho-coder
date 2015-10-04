package yjy.hiho;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean hasZero = false;
        int I=0,J=0;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(matrix[i][j]==0){
        			if(!hasZero){
        				I = i;
        				J = j;
        				hasZero = true;
        			}
        			matrix[I][j]=0;
        			matrix[i][J]=0;
        		}
        	}
        }
        if(!hasZero){
        	return;
        }
        for(int i=0;i<m;i++){
        	if(matrix[i][J]==0){
        		for(int j=0;j<n;j++){
        			if(I!=i){
        				matrix[i][j]=0;
        			}
        		}
        	}
        }
        for(int j=0;j<n;j++){
        	if(matrix[I][j]==0){
        		for(int i=0;i<m;i++){
        			if(J!=j){
        				matrix[i][j]=0;
        			}
        		}
        	}
        }
        for(int i=0;i<m;i++){
        	matrix[i][J]=0;
        }
        for(int j=0;j<n;j++){
        	matrix[I][j]=0;
        }
    }	
    
    public static void main(String[] args) {
    	SetMatrixZeroes s = new SetMatrixZeroes();
    	int[][] matrix = {
    			{0,0,0,5},
    			{4,3,1,4},
    			{0,1,1,4},
    			{1,2,1,3},
    			{0,0,1,1}
				};
    	s.setZeroes(matrix);
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
    			System.out.print(String.format("%d ",matrix[i][j]));
    		}
    		System.out.println("");
    	}
	}

}
