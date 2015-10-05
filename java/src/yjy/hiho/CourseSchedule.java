package yjy.hiho;

import java.util.ArrayList;
import java.util.LinkedList;

public class CourseSchedule {
	
	class Node{
		int index;
		int incount;
		ArrayList<Node> adjs;
		Node(int index){
			this.index = index;
			this.incount = 0;
			this.adjs = new ArrayList<Node>();
		}
	}
	
    public boolean canFinish(int n, int[][] pre) {
    	Node[] nodes = new Node[n];
    	for(int i=0;i<n;i++){
    		nodes[i]=new Node(i);
    	}
    	int m = pre.length;
    	for(int i=0;i<m;i++){
    		nodes[pre[i][0]].adjs.add(nodes[pre[i][1]]);
    		nodes[pre[i][1]].incount++;
    	}
    	LinkedList<Node> Q = new LinkedList<Node>();
    	for(int i=0;i<n;i++){
    		if(nodes[i].incount==0){
    			Q.add(nodes[i]);
    		}
    	}
    	while(!Q.isEmpty()){
    		Node cur = Q.poll();
    		for(Node adj:cur.adjs){
    			adj.incount--;
    			if(adj.incount==0){
    				Q.add(adj);
    			}
    		}
    	}
    	for(int i=0;i<n;i++){
    		if(nodes[i].incount>0){
    			return false;
    		}
    	}
        return true;
    }

	public static void main(String[] args) {
		CourseSchedule s = new CourseSchedule();
		int[][] prerequisites = {
				{0,1},
				{0,2},
				{2,1},
				{1,2}
		};
		boolean r = s.canFinish(3, prerequisites);
		System.out.println(r);
	}

}
