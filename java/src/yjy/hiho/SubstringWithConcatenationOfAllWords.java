package yjy.hiho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	class Node{
		int index;
		int count;
		Node(int index){
			this.index = index;
			this.count = 0;
		}
	}
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        int m = words.length;
        int n = s.length();
        if(m==0 || n==0){
        	return r;
        }
        
        int l = words[0].length();
        if(m*l>n){return r;}
        int nodeCount = 0;
        HashMap<String,Node> map = new HashMap<String,Node>();
        for(int i=0;i<m;i++){
        	Node nn = map.get(words[i]);
        	if(nn==null){
        		nn = new Node(nodeCount);
        		nodeCount++;
        		map.put(words[i],nn);
        	}
        	nn.count++;
        }
        int[] a = new int[n];
        for(int i=0;i<n;i++){
        	String subS = s.substring(i,Math.min(i+l,n));
        	Node nn = map.get(subS);
        	if(nn!=null){
        		a[i] = nn.index;
        	}else{
        		a[i] = -1;
        	}
        }
        
        int qq = map.size();
    	int[] count = new int[qq];
        for(int k=0;k<l;k++){
        	int i = k;
        	for(Node node:map.values()){
        		count[node.index] = node.count;
        	}
            int countNum = 0;
        	for(int j=0;j<m;j++){
        		if(a[i+j*l]!=-1){
        			if(count[a[i+j*l]]==0){countNum--;}
        			count[a[i+j*l]]--;
        			if(count[a[i+j*l]]==0){countNum++;}
        		}
        	}
        	if(countNum==qq){
        		r.add(k);
        	}
        	while(i+m*l<n){
        		if(a[i]!=-1){
        			if(count[a[i]]==0){countNum--;}
        			count[a[i]]++;
        			if(count[a[i]]==0){countNum++;}
        		}
        		if(a[i+m*l]!=-1){
        			if(count[a[i+m*l]]==0){countNum--;}
        			count[a[i+m*l]]--;
        			if(count[a[i+m*l]]==0){countNum++;}
        		}
        		i+=l;
        		if(countNum==qq){r.add(i);}
        	}
        }
        return r;
    }
    
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		String[] words = {"foo", "bar"};
		List<Integer> r = s.findSubstring("barfoothefoobarman", words);
		for(Integer i:r){
			System.out.println(i);
		}
	}

}
