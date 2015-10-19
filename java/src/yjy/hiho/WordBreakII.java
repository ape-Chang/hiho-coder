package yjy.hiho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> wordDict) {
    	int n = s.length();
    	boolean[] segable = new boolean[n+1];
    	List<List<String>> r = new ArrayList<List<String>>();
    	
    	segable[0] = true;
    	List<String> ldummy = new ArrayList<String>();
    	ldummy.add("");
    	r.add(ldummy);
    	for(int i=1;i<=n;i++){
    		r.add(new ArrayList<String>());
    		segable[i] = false;
    	}
    	for(int i=1;i<=n;i++){
    		List<String> li = r.get(i);
    		for(int j=0;j<i;j++){
    			if(segable[j]){
    				String word = s.substring(j, i);
    				if(wordDict.contains(word)){
    					segable[i]=true;
    					List<String> lj = r.get(j);
    					for(String ss:lj){
    						li.add(String.format("%s %s",ss,word));
    					}
    					continue;
    				}
    			}
    		}
    	}
    	List<String> rr = new ArrayList<String>();
    	for(String ss:r.get(n)){
    		rr.add(ss.substring(1));
    	}
        return rr;
    }
	public static void main(String[] args) {
		WordBreakII s = new WordBreakII();
		HashSet<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(s.wordBreak("catsanddog", wordDict));
	}

}
