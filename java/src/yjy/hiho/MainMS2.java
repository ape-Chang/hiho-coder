package yjy.hiho;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMS2 {
	static Node[] nodes;
	static int N;
	static void clearNodes(){
		if(nodes == null){
			return;
		}
		int N = nodes.length;
		for(int i=0;i<N;i++){
			nodes[i].v = false;
		}
	}

	static class Node{
		int index;
		boolean v;
		ArrayList<Edge> edges;
		Node(int index){
			this.v = false;
			this.index = index;
			this.edges = new ArrayList<Edge>();
		}

		public int C1(Edge rootE){
			int sum = 0;
			for(Edge e:this.edges){
				if(e==rootE){
					continue;
				}
				if(e.a == this){
					sum+=e.b.C1(e);
				}else{
					sum+=e.a.C1(e);
				}
			}
			sum++;
			if(rootE!=null){
				rootE.value = (N-sum)*sum;
			}
			return sum;
		}
	}
	
	static class Edge{
		Node a;
		Node b;
		int D;
		int value;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String StrN = scan.next();
		N = Integer.parseInt(StrN);
		String StrM = scan.next();
		int M = Integer.parseInt(StrM);
		
		nodes = new Node[N];
		for(int i=0;i<N;i++){
			nodes[i] = new Node(i);
		}
		Edge[] edges = new Edge[N-1];
		for(int i=0;i<N-1;i++){
			String StrU = scan.next();
			String StrV = scan.next();
			String StrK = scan.next();
			int u = Integer.parseInt(StrU)-1;
			int v = Integer.parseInt(StrV)-1;
			int k = Integer.parseInt(StrK);
			edges[i] = new Edge();
			edges[i].a = nodes[u];
			edges[i].b = nodes[v];
			edges[i].D = k;
			nodes[u].edges.add(edges[i]);
			nodes[v].edges.add(edges[i]);
		}
		
		nodes[0].C1(null);
		
		int R = 0;
		for(int j=0;j<N-1;j++){
			R+=edges[j].D*edges[j].value;
		}
		
		for(int i=0;i<M;i++){
			String CMD = scan.next();
			if(CMD.equals("QUERY")){
				System.out.println(R);
			}else if(CMD.equals("EDIT")){
				String StrU = scan.next();
				String StrV = scan.next();
				String StrK = scan.next();
				int u = Integer.parseInt(StrU)-1;
				int v = Integer.parseInt(StrV)-1;
				int k = Integer.parseInt(StrK);
				for(Edge e:nodes[u].edges){
					if(e.a == nodes[v] || e.b == nodes[v]){
						R = R - e.D*e.value;
						e.D = k;
						R = R + e.D*e.value;
						break;
					}
				}
			}
		}
		
		scan.close();
	}
	
}