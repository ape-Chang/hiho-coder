package yjy.hiho;

public class UniqueBinarySearchTrees {
	
	public int numTrees(int n) {
		int[] A = new int[n+1];
		A[0]=1;
		A[1]=1;
		for(int i=2;i<=n;i++){
			A[i] = 0;
			for(int j=0;j<=i-1;j++){
				A[i]+=A[j]*A[i-1-j];
			}
		}
        return A[n];
    }

	public static void main(String[] args) {
		UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
		int R = s.numTrees(19);
		System.out.println(R);
	}

}
