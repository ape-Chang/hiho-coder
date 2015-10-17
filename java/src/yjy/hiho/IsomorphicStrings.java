package yjy.hiho;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        HashSet<Character> getMapped = new HashSet<Character>();
        int n = s.length();
        for(int i=0;i<n;i++){
        	char cs = s.charAt(i);
        	char ct = t.charAt(i);
        	Character cc = map.get(cs);
        	if(cc==null){
        		cc = ct;
        		if(!getMapped.contains(ct)){
        			map.put(cs,ct);
            		getMapped.add(ct);
        		}else{
        			return false;
        		}
        	}
        	if(ct!=cc){
        		return false;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		IsomorphicStrings s = new IsomorphicStrings();
		boolean r = s.isIsomorphic("ab","aa");
		System.out.println(r);
	}

}
