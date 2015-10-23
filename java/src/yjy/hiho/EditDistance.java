package yjy.hiho;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		int[][] d = new int[n+1][m+1];
		d[0][0] = 0;
		for(int i=1;i<=n;i++){d[i][0] = i;}
		for(int j=1;j<=m;j++){d[0][j] = j;}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				char c1 = word1.charAt(i-1);
				char c2 = word2.charAt(j-1);
				if(c1==c2){
					d[i][j] = d[i-1][j-1];
				}else{
					d[i][j] = d[i-1][j-1]+1;
				}
				d[i][j] = Math.min(d[i][j],d[i-1][j]+1);
				d[i][j] = Math.min(d[i][j],d[i][j-1]+1);
			}
		}
        return d[n][m];
    }
	
	public static void main(String[] args) {
		EditDistance s = new EditDistance();
		int r = s.minDistance("asdadaa", "asddddaa");
		System.out.println(r);
	}

}
