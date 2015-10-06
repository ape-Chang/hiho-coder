package yjy.hiho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
	class Node{
		ArrayList<Node> adj;
		String s;
		boolean visited;
		int layer;
		Node(String s){
			this.adj = new ArrayList<Node>();
			this.visited = false;
			this.s = s;
			this.layer = 0;
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
	
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
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
    	nodes[0].visited = true;
    	nodes[0].layer = 1;
    	Q.add(nodes[0]);
    	while(!Q.isEmpty()){
    		Node cur = Q.poll();
    		int curLayer = cur.layer;
    		for(Node a:cur.adj){
    			if(!a.visited){
    				a.visited = true;
    				a.layer = curLayer+1;
    				if(a==nodes[1]){
    					return a.layer;
    				}
    				Q.add(a);
    			}
    		}
    	}
        return 0;
    }
	public static void main(String[] args) {
		WordLadder s = new WordLadder();
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		int r = s.ladderLength("hit", "cog", set);
		System.out.println(r);
	}

}
