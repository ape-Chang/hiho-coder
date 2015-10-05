package yjy.hiho;

import java.util.ArrayList;
import java.util.LinkedList;

public class CourseScheduleII {
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
	
    public int[] findOrder(int n, int[][] pre) {
    	int[] r = new int[n];
    	int index = 0;
    	Node[] nodes = new Node[n];
    	for(int i=0;i<n;i++){
    		nodes[i]=new Node(i);
    	}
    	int m = pre.length;
    	for(int i=0;i<m;i++){
    		nodes[pre[i][1]].adjs.add(nodes[pre[i][0]]);
    		nodes[pre[i][0]].incount++;
    	}
    	LinkedList<Node> Q = new LinkedList<Node>();
    	for(int i=0;i<n;i++){
    		if(nodes[i].incount==0){
    			Q.add(nodes[i]);
    		}
    	}
    	while(!Q.isEmpty()){
    		Node cur = Q.poll();
    		r[index] = cur.index;
    		index++;
    		for(Node adj:cur.adjs){
    			adj.incount--;
    			if(adj.incount==0){
    				Q.add(adj);
    			}
    		}
    	}
    	for(int i=0;i<n;i++){
    		if(nodes[i].incount>0){
    			int[] tmp={};
    			return tmp;
    		}
    	}
        return r;
    }

	public static void main(String[] args) {
		CourseScheduleII s = new CourseScheduleII();
		int[][] prerequisites = {
				{0,1},
				{0,2},
				{2,1}
		};
		int[] r = s.findOrder(3, prerequisites);
		if(r==null){
			System.out.println("null");
			return;
		}
		for(int i=0;i<r.length;i++){
			System.out.println(r[i]);
		}
	}

}
