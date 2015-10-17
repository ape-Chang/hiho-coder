package yjy.hiho;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class TheSkylineProblem {
	
	class Node implements Comparable<Node>{
		int l;
		int r;
		int h;
		Node(int l,int r,int h){
			this.l = l;
			this.r = r;
			this.h = h;
		}
		@Override
		public int compareTo(Node o) {
			return this.l - o.l;
		}
	}
    public List<int[]> getSkyline(int[][] buildings) {
    	int n = buildings.length;
    	PriorityQueue<Node> q = new PriorityQueue<Node>();
    	for(int i=0;i<n;i++){
    		q.add(new Node(buildings[i][0],buildings[i][1],buildings[i][2]));
    	}
    	TreeMap<Integer,Node> heap = new TreeMap<Integer,Node>();
    	Stack<Node> SS = new Stack<Node>();
    	ArrayList<int[]> r1 = new ArrayList<int[]>();
    	for(Node nn:q){
    		SS.push(nn);
    		Node hNode = null;
    		while(!heap.isEmpty()){
    			hNode = heap.lastEntry().getValue();
    			if(hNode.r<nn.l){
    				heap.remove(hNode.h);
    			}else{
    				break;
    			}
    		}
    		if(heap.isEmpty()||(hNode.h<nn.h)){
    			int[] newA = {nn.l,nn.h};
    			r1.add(newA);
    		}
    		Node tmp = heap.get(nn.h);
    		if(tmp==null){
    			heap.put(nn.h,nn);
    		}else if(tmp.r<nn.r){
    			heap.put(nn.h,nn);
    		}
    	}
    	heap.clear();
    	ArrayList<int[]> r2 = new ArrayList<int[]>();
    	while(!SS.isEmpty()){
    		Node nn = SS.pop();
    		Node hNode = null;
    		while(!heap.isEmpty()){
    			hNode = heap.lastEntry().getValue();
    			if(hNode.l>nn.r){
    				heap.remove(hNode.h);
    			}else{
    				break;
    			}
    		}
    		if(heap.isEmpty()){
    			int[] newA = {nn.r,0};
    			r2.add(newA);
    		}else if(hNode.h<nn.h){
    			int[] newA = {nn.r,hNode.h};
    			r2.add(newA);
    		}
    		Node tmp = heap.get(nn.h);
    		if(tmp==null){
    			heap.put(nn.h,nn);
    		}else if(tmp.l>nn.l){
    			heap.put(nn.h,nn);
    		}
    	}
    	int m1 = r1.size();
    	int m2 = r2.size();
    	ArrayList<int[]> r = new ArrayList<int[]>();
    	int i=0,j=m2-1;
    	while(i<m1&&j>=0){
    		if(r1.get(i)[0]>r2.get(j)[0]){
    			r.add(r2.get(j));
    			j--;
    		}else{
    			r.add(r1.get(i));
    			i++;
    		}
    	}
    	while(i<m1){
    		r.add(r1.get(i));
			i++;
    	}
    	while(j>=0){
    		r.add(r2.get(j));
			j--;
    	}
        return r;
    }
    
	public static void main(String[] args) {
		TheSkylineProblem s = new TheSkylineProblem();
		int[][] buildings = {
				{2, 9, 10}, 
				{3, 7, 15}, 
				{5, 12, 12}, 
				{15, 20, 10}, 
				{19, 24, 8}
		};
		List<int[]> r = s.getSkyline(buildings);
		for(int[] ii:r){
			System.out.println(String.format("%d %d", ii[0],ii[1]));
		}
	}
}
