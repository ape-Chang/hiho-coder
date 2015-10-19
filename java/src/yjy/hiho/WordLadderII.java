package yjy.hiho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderII {

	class Node{
		ArrayList<Node> adj;
		String s;
		int layer;
		List<Node> pre;
		Node(String s){
			this.adj = new ArrayList<Node>();
			this.s = s;
			this.layer = 0;
			this.pre = new ArrayList<Node>();
		}
		
		List<List<String>> addPath(){
			List<List<String>> r = new ArrayList<List<String>>();
			if(this.pre.isEmpty()){
				r.add(new ArrayList<String>());
			}else{
				for(Node p:this.pre){
					List<List<String>> l = p.addPath();
					r.addAll(l);
				}
			}
			for(List<String> ll:r){
				ll.add(this.s);
			}
			return r;
		}
	}
	
	public boolean isAdj(String s1, String s2){
		int n = s1.length();
		int count = 0;
		for(int i=0;i<n;i++){
			if(s1.charAt(i)!=s2.charAt(i)){
				count++;
				if(count>1){
					return false;
				}
			}
		}
		return true;
	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		ArrayList<List<String>> r = new ArrayList<List<String>>();
    	Object[] w = wordList.toArray();
    	int n = w.length;
    	Node[] nodes = new Node[n+2];
    	nodes[0] = new Node(beginWord);
    	nodes[1] = new Node(endWord);
    	for(int i=2;i<n+2;i++){
    		nodes[i] = new Node((String)w[i-2]);
    	}
    	for(int i=0;i<n+2;i++){
    		for(int j=i+1;j<n+2;j++){
    			if(this.isAdj(nodes[i].s,nodes[j].s)){
    				nodes[i].adj.add(nodes[j]);
    				nodes[j].adj.add(nodes[i]);
    			}
    		}
    	}
    	LinkedList<Node> Q = new LinkedList<Node>();
    	nodes[0].layer = 1;
    	Q.add(nodes[0]);
    	int distance = 0;
    	while(!Q.isEmpty()){
    		Node cur = Q.poll();
    		int curLayer = cur.layer;
    		for(Node a:cur.adj){
    			if(distance!=0 && distance<curLayer+1){return r;}
    			if(a.layer==0){
    				a.layer = curLayer+1;
    				a.pre.add(cur);
    				if(a==nodes[1]){
    					if(distance==0){distance = a.layer;}
    					List<List<String>> pp = cur.addPath();
    					for(List<String> ll:pp){
    						ll.add(a.s);
    					}
    					r.addAll(pp);
    				}
    				Q.add(a);
    			}else if(a.layer==curLayer+1){
    				a.pre.add(cur);
    				if(a==nodes[1]){
    					List<List<String>> pp = cur.addPath();
    					for(List<String> ll:pp){
    						ll.add(a.s);
    					}
    					r.addAll(pp);
    				}
    			}
    			
    		}
    	}
        return r;
    }
	
	public static void main(String[] args) {
		WordLadderII s = new WordLadderII();
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		List<List<String>> r = s.findLadders("hit", "cog", set);
//		for(List<String> l:r){
//			for(String ss:l){
//				System.out.print(String.format("%s ",ss));
//			}
//			System.out.println("");
//		}
		System.out.println(r);
	}

}
