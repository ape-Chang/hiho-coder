package yjy.hiho;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle1(char[][] matrix) {
    	int m = matrix.length;
    	if(m==0){
    		return 0;
    	}
    	int n = matrix[0].length;
    	if(n==0){
    		return 0;
    	}
    	int[][] up = new int[m][n];
    	int[][] left = new int[m][n];
    	int max = 0;
    	if(matrix[0][0]=='1'){
    		max = 1;
    		up[0][0] = 1;
    		left[0][0] = 1;
    	}else{
    		up[0][0] = 0;
    		left[0][0] = 0;
    	}
    	for(int i=1;i<n;i++){
    		if(matrix[0][i]=='1'){
        		up[0][i] = 1;
        		left[0][i] = left[0][i-1]+1;
        		max = Math.max(max,left[0][i]);
    		}else{
        		up[0][i] = 0;
        		left[0][i] = 0;
    		}
    	}
    	for(int i=1;i<m;i++){
    		if(matrix[i][0]=='1'){
        		up[i][0] = up[i-1][0]+1;
        		left[i][0] = 1;
        		max = Math.max(max,up[i][0]);
    		}else{
        		up[i][0] = 0;
        		left[i][0] = 0;
    		}
    	}
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			if(matrix[i][j]=='1'){
    				up[i][j] = up[i-1][j]+1;
            		left[i][j] = left[i][j-1]+1;
            		int K = up[i][j];
            		int min = left[i][j];
            		for(int k=0;k<K;k++){
            			min = Math.min(min,left[i-k][j]);
            			max = Math.max(max,(k+1)*min);
            		}
    			}else{
            		up[i][j] = 0;
            		left[i][j] = 0;
    			}
    		}
    	}
        return max;
    }
	class Node{
		int val;
		int index;
		Node(int val,int index){
			this.val = val;
			this.index = index;
		}
	}
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if(m==0)
			return 0;
		int n = matrix[0].length;
		if(n==0)
			return 0;
		int max = 0;
		int[] hist = new int[n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]=='1'){
					hist[j] += 1;
				}else{
					hist[j] = 0;
				}
			}
			Stack<Node> S = new Stack<Node>();
			S.push(new Node(0,0));
			for(int j=0;j<n;j++){
				if(hist[j]>=S.peek().val){
					S.push(new Node(hist[j],j));
				}else{
					int left = j;
					while(S.peek().val>hist[j]){
						Node tmp = S.pop();
						left = tmp.index;
						max = Math.max(max,tmp.val*(j-left));
					}
					S.push(new Node(hist[j],left));
				}
			}
			while(!S.isEmpty()){
				Node tmp = S.pop();
				max = Math.max(max,tmp.val*(n-tmp.index));
			}
		}
		return max;
	}
	public static void main(String[] args) {
		MaximalRectangle s = new MaximalRectangle();
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
//		char[][] matrix = {
//				{'0', '0', '0'},
//				{'0', '0', '0'},
//				{'0', '0', '0'},
//				{'0', '0', '0'}
//		};
//		char[][] matrix = {
//			{'1'}
//		};
		int r = s.maximalRectangle(matrix);
		System.out.println(r);
	}
}
