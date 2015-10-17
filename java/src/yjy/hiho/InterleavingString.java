package yjy.hiho;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
    	int n = s1.length();
    	int m = s2.length();
    	if(n+m!=s3.length()){
    		return false;
    	}
    	boolean[][] v = new boolean[n+1][m+1];
    	v[0][0] = true;
    	for(int i=1;i<=n;i++){
    		v[i][0] = v[i-1][0]&&s3.charAt(i-1)==s1.charAt(i-1);
    	}
    	for(int i=1;i<=m;i++){
    		v[0][i] = v[0][i-1]&&s3.charAt(i-1)==s2.charAt(i-1);
    	}
    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=m;j++){
    			char c = s3.charAt(i+j-1);
    			v[i][j] = (s1.charAt(i-1)==c&&v[i-1][j])||(s2.charAt(j-1)==c&&v[i][j-1]);
    		}
    	}
        return v[n][m];
    }
	public static void main(String[] args) {
		InterleavingString s = new InterleavingString();
		boolean r = s.isInterleave("db","b","cbb");
		System.out.println(r);
	}

}
