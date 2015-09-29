package yjy.hiho;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {
	
	static class Node{
		Node parent;
		int index;
		int count;
		Node(int index){
			this.count = 1;
			this.parent = null;
			this.index = index;
		}
		
		Node superP(){
			Node cur = this;
			while(cur.parent!=null){
				cur = cur.parent;
			}
			return cur;
		}
		
		boolean sameSet(Node n){
			return this.superP() == n.superP();
		}
		
		void mergeNode(Node n){
			Node superN = n.superP();
			Node superThis = this.superP();
			if(superN.count>superThis.count){
				superThis.parent = superN;
				superN.count += superThis.count;
			}else{
				superN.parent = superThis;
				superThis.count += superN.count;
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		Node a;
		Node b;
		int d;
		
		@Override
		public int compareTo(Edge o) {
			return this.d - o.d;
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		Node[] nodes = new Node[N];
		
		for(int i=0;i<N;i++){
			nodes[i] = new Node(i);
		}
		
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		for(int i=0;i<M;i++){
			int a = scan.nextInt();
			int b = scan.nextInt();
			int d = scan.nextInt();
			Edge e = new Edge();
			e.a = nodes[a];
			e.b = nodes[b];
			e.d = d;
			edges.add(e);
		}
		
		ArrayList<Edge> R = new ArrayList<Edge>();
		while(!edges.isEmpty()){			
			Edge e = edges.poll();
			if(e.a.sameSet(e.b)){
				continue;
			}else{
				R.add(e);
				e.a.mergeNode(e.b);
			}
		}
		
		for(Edge e:R){
			System.out.println(e.d);
		}
		
		scan.close();
	}
}
