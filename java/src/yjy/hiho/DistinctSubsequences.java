package yjy.hiho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
    	HashMap<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
    	int n = s.length();
    	int m = t.length();
    	if(n==0)return 0;
    	if(m==0)return 0;
    	for(int i=m-1;i>=0;i--){
    		char c = t.charAt(i);
    		List<Integer> l = map.get(c);
    		if(l==null){
    			l = new ArrayList<Integer>();
    			map.put(c,l);
    		}
    		l.add(i+1);
    	}
    	int[] p = new int[m+1];
    	p[0] = 1;
    	for(int i=0;i<n;i++){
    		char c = s.charAt(i);
    		List<Integer> l = map.get(c);
    		if(l!=null){
    			for(Integer index:l){
    				p[index] += p[index-1];
    			}
    		}
    	}
        return p[m];
    }
	public static void main(String[] args) {
		DistinctSubsequences s = new DistinctSubsequences();
		int r = s.numDistinct("rabbbiit","rabbit");
		System.out.println(r);
	}

}
