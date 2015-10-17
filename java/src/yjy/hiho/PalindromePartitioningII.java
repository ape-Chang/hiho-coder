package yjy.hiho;

public class PalindromePartitioningII {
    public int minCut(String s) {
    	int n = s.length();
    	if(n==0){return 0;}
    	boolean[][] isP = new boolean[n][n];
    	for(int i=0;i<n;i++){
    		isP[i][i] = true;
    	}
    	for(int i=1;i<n;i++){
    		for(int j=0;j<n-i;j++){
    			isP[j][j+i] = s.charAt(j)==s.charAt(j+i);
    			if(i>1){isP[j][j+i] &=isP[j+1][j+i-1];}
    		}
    	}
    	int[] minC = new int[n+1];
    	minC[0]=0;
    	for(int i=1;i<=n;i++){
    		if(isP[0][i-1]){
    			minC[i]=0;
    		}else{
    			int min = n-2;
    			for(int j=1;j<i;j++){
        			if(isP[j][i-1]){
        				min = Math.min(min,minC[j]);
        			}
        		}
    			minC[i]=min+1;
    		}
    	}
        return minC[n];
    }
	public static void main(String[] args) {
		PalindromePartitioningII s = new PalindromePartitioningII();
		int r = s.minCut("aabaaaabdsa");
		System.out.println(r);
	}

}
