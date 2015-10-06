package yjy.hiho;

public class DecodeWays {
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        if(n==0){
        	return 0;
        }else if(n==1){
        	if(c[0]>'0' && c[0]<='9'){
        		return 1;
        	}else{
        		return 0;
        	}
        }
        int[] count = new int[n];
        if(c[0]=='0'){
        	return 0;
        }
        count[0] = 1;
        count[1] = 0;
        if(10*(c[0]-'0')+(c[1]-'0')<=26){
        	count[1]++;
        }
        if(c[1]!='0'){
        	count[1]++;
        }
        for(int i=2;i<n;i++){
        	count[i] = 0;
        	if(c[i-1]!='0' && 10*(c[i-1]-'0')+(c[i]-'0')<=26){
        		count[i]+=count[i-2];
        	}
        	if(c[i]!='0'){
        		count[i]+=count[i-1];
        	}else if(c[i-1]-'0'==0 || c[i-1]-'0'>=3){
        		return 0;
        	}
        }
        return count[n-1];
    }
	public static void main(String[] args) {
		DecodeWays s = new DecodeWays();
		System.out.println(s.numDecodings("101"));
	}
}
