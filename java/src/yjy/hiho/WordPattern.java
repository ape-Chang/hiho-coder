package yjy.hiho;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
    	HashMap<Character,String> map = new HashMap<Character,String>();
    	HashSet<String> mapped = new HashSet<String>();
    	String[] w = str.split(" ");
    	int n = pattern.length();
    	if(w.length!=n){return false;}
    	for(int i=0;i<n;i++){
    		char c = pattern.charAt(i);
    		String s = w[i];
    		String found = map.get(c);
    		if(found==null){
    			if(mapped.contains(s)){return false;}
    			mapped.add(s);
    			map.put(c,s);
    			found = s;
    		}
    		if(!found.equals(s)){return false;}
    	}
        return true;
    }
	public static void main(String[] args) {
		WordPattern s = new WordPattern();
		boolean r = s.wordPattern("abba", "dog cat cat dog");
		System.out.println(r);
	}

}
