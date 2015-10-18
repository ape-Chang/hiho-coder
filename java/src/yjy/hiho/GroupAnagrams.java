package yjy.hiho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    	ArrayList<List<String>> r = new ArrayList<List<String>>();
    	int n = strs.length;
    	HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    	for(int i=0;i<n;i++){
    		
    		char[] cc = strs[i].toCharArray();
    		Arrays.sort(cc);
    		String code = new String(cc);
//    		int L = strs[i].length();
//    		int[] count = new int[26];
//    		for(int j=0;j<L;j++){
//    			count[strs[i].charAt(j)-'a']++;
//    		}
//    		StringBuffer buf = new StringBuffer();
//    		for(int j=0;j<count.length;j++){
//    			buf.append(String.format(".%d",count[j]));
//    		}
//    		String code = buf.toString();
    		List<String> l = map.get(code);
    		if(l==null){
    			l = new ArrayList<String>();
    			map.put(code,l);
    		}
    		l.add(strs[i]);
    	}
    	for(List<String> ll:map.values()){
    		Collections.sort(ll);
    		r.add(ll);
    	}
        return r;
    }
	public static void main(String[] args) {
		GroupAnagrams s = new GroupAnagrams();
		String[] strs = {"new","sop","ute","poe","elk","twa","cal","ivy","wis","eat","way","oks","ono","tog","art","rev","coo","ann","tug","dog","yew","rap","jug","fix","rip","ats","non","mig","fax","thy","gem","haw","eon","rio","gun","pit","sub","mas","jet","jay","sea","leo","win","par","tea","mop","oho","pen","sol","sip","bra","jog","fir","man","run","fey","box"};
		List<List<String>> r = s.groupAnagrams(strs);
		for(List<String> l:r){
			for(String ss:l){
				System.out.print(String.format("%s ",ss));
			}
			System.out.println("");
		}
	}

}
