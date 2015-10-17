package yjy.hiho;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	int n = s.length();
    	boolean[] segable = new boolean[n+1];
    	segable[0] = true;
    	for(int i=1;i<=n;i++){
    		segable[i] = false;
    	}
    	for(int i=1;i<=n;i++){
    		for(int j=0;j<i;j++){
    			if(segable[j]){
    				if(wordDict.contains(s.substring(j, i))){
    					segable[i]=true;
    					break;
    				}
    			}
    		}
    	}
        return segable[n];
    }
	public static void main(String[] args) {
		WordBreak s = new WordBreak();
		HashSet<String> wordDict = new HashSet<String>();
		wordDict.add("ee");
		wordDict.add("leetl");
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(s.wordBreak("leetcodeleetleetlee", wordDict));
		String xx = "asdfgh";
	}

}
