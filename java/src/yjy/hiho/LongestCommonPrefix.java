package yjy.hiho;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	int cur = 0;
    	int n = strs.length;
    	if(n==0)return "";
    	int[] length = new int[n];
    	for(int i=0;i<n;i++){
    		length[i] = strs[i].length();
    	}
    	P:while(true){
    		if(length[0]<=cur){
    			break;
    		}
    		char c = strs[0].charAt(cur);
    		for(int i=0;i<n;i++){
    			if(length[i]<=cur || strs[i].charAt(cur)!=c){
    				break P;
    			}
    		}
    		cur++;
    	}
        return strs[0].substring(0,cur);
    }
    
	public static void main(String[] args) {
		LongestCommonPrefix s = new LongestCommonPrefix();
		String[] strs = {"aaa","aabc","abbc"};
		String r = s.longestCommonPrefix(strs);
		System.out.println(r);
	}

}
