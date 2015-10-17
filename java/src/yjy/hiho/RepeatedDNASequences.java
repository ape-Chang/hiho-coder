package yjy.hiho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
	class Node{
		int count;
		Node[] clds;
		Node(){
			this.count = 0;
			this.clds = new Node[4];
		}
	}
	
	// Memory Limit Exceeded
    public List<String> findRepeatedDnaSequences1(String s) {
    	List<String> r = new ArrayList<String>();
    	int n = s.length();
    	if(n<10){
    		return r;
    	}
    	Node root = new Node();
    	char[] buf = new char[10];
    	Node cur = root;
    	for(int i=0;i<=n-10;i++){
    		for(int j=i;j<i+10;j++){
    			buf[j-i] = s.charAt(j);
    			switch(buf[j-i])
    			{
    			case 'A':
    				if(cur.clds[0] == null){
    					cur.clds[0] = new Node();
    				}
    				cur = cur.clds[0];
    				break;
    			case 'C':
    				if(cur.clds[1] == null){
    					cur.clds[1] = new Node();
    				}
    				cur = cur.clds[1];
    				break;
    			case 'G':
    				if(cur.clds[2] == null){
    					cur.clds[2] = new Node();
    				}
    				cur = cur.clds[2];
    				break;
    			case 'T':
    				if(cur.clds[3] == null){
    					cur.clds[3] = new Node();
    				}
    				cur = cur.clds[3];
    				break;
    			}
    		}
    		if(cur.count==1){
    			r.add(new String(buf));
    		}
    		cur.count++;
    		cur = root;
    	}
        return r;
    }
    
    public int readACGT(char c){
    	switch(c){
		case 'A':
			return 0;
		case 'C':
			return 1; 
		case 'G':
			return 2; 
		case 'T':
			return 3; 
		}
    	return 0;
    }
    
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> r = new ArrayList<String>();
    	char[] c = s.toCharArray();
    	int n = c.length;
    	if(n<10){
    		return r;
    	}
    	int sum = 0;
    	for(int i=0;i<10;i++){
    		int x = readACGT(c[i]);
    		sum = (sum<<2) + x;
    	}
    	char[] buf = new char[10];
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	map.put(sum,1);
    	for(int i=1;i<=n-10;i++){
    		int x = readACGT(c[i-1]);
    		int y = readACGT(c[i+9]);
    		sum = ((sum-(x<<18))<<2)+y;
    		Integer count = map.get(sum);
    		if(count==null){
    			count = new Integer(0);
    		}else if(count==1){
    			for(int k=0;k<10;k++){
    				buf[k] = c[i+k];
    			}
    			r.add(new String(buf));
    		}
    		map.put(sum,count+1);
    	}
    	return r;
    }
	public static void main(String[] args) {
		RepeatedDNASequences s = new RepeatedDNASequences();
		String xx = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> r = s.findRepeatedDnaSequences(xx);
		for(String ss:r){
			System.out.println(ss);
		}
		
	}

}
