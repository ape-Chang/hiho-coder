package yjy.hiho;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    	int n = s.length();
    	int m = t.length();
    	for(int i=0;i<m;i++){
    		char c = t.charAt(i);
    		Integer count = map.get(t.charAt(i));
    		if(count==null){
    			count = new Integer(0);
    		}
    		map.put(c,count+1);
    	}
    	int tSum = m;
    	int i = 0;
    	for(;i<n;i++){
    		char c = s.charAt(i);
    		Integer count = map.get(c);
    		if(count!=null){
    			map.put(c,count-1);
    			if(count-1>=0){
        			tSum--;
        			if(tSum<=0){break;}
        		}
    		}
    	}
    	if(i==n){return "";}
    	
    	int min = i+1;
    	int mini = i;
    	int minj = 0;
    	int j = -1;
    	P:while(true){
    		while(true){
    			j++;
    			if(j==i){break;}
    			char c = s.charAt(j);
    			Integer count = map.get(c);
    			if(count!=null){
    				map.put(c,count+1);
    				if(count+1>0){
    					tSum++;
    					break;
    				}
    			}
    			if(i-j<min){
    				min = i-j;
    				mini = i;
    				minj = j+1;
    			}
    		}
    		while(true){
    			i++;
    			if(i==n){break P;}
        		char c = s.charAt(i);
        		Integer count = map.get(c);
        		if(count!=null){
    				map.put(c,count-1);
    				if(count-1>=0)tSum--;
    				if(tSum>0){continue;}
    				else{break;}
    			}
    		}
    	}
        return s.substring(minj, mini+1);
    }
	public static void main(String[] args) {
		MinimumWindowSubstring s = new MinimumWindowSubstring();
		String r = s.minWindow("ACABECODEOANC","AABBC");
		System.out.println(r);
	}

}
