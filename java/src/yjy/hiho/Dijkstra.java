package yjy.hiho;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
	
	static int MAX_INT = 1000000000;
	
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		boolean flag;
		ArrayList<Edge> adj;
		Node(int index){
			this.index = index;
			this.flag = false;
			this.adj = new ArrayList<Edge>();
		}
		
		@Override
		public int compareTo(Node n){
			return this.distance - n.distance;
		}
	}
	
	static class Edge{
		Node to;
		int d;
	}

	// 实现Dijkstra算法寻找单源最短路径
	public static void main(String[] args){
		String path = "/Users/yijiayue/Desktop/test2.in";
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Scanner scan = new Scanner(inputStream, "UTF-8");
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int start = scan.nextInt();
		int end = scan.nextInt();
		Node[] nodes = new Node[N];
		for(int i=0;i<N;i++){
			nodes[i] = new Node(i);
			nodes[i].distance = MAX_INT;
		}
		
		for(int i=0;i<M;i++){
			int a = scan.nextInt();
			int b = scan.nextInt();
			int d = scan.nextInt();
			Edge Ea = new Edge();
			Ea.to = nodes[b];
			Ea.d = d;
			Edge Eb = new Edge();
			Eb.to = nodes[a];
			Eb.d = d;
			nodes[a].adj.add(Ea);
			nodes[b].adj.add(Eb);
		}
		PriorityQueue<Node> Q = new PriorityQueue<Node>();
		Node firstNode = nodes[start];
		firstNode.flag = true;
		firstNode.distance = 0;
		for(Edge e : firstNode.adj){
			e.to.distance = e.d;
			Q.add(e.to);
		}
		while(!Q.isEmpty()){
//			System.out.println(Q.size());
			Node n = Q.poll();
			n.flag = true;
			for(Edge e : n.adj){
				if(!e.to.flag){
					if(e.to.distance>n.distance+e.d){
						e.to.distance = n.distance+e.d;
						Q.add(e.to);
					}
				}
			}
		}
		
//		for(int i=0;i<N;i++){
//			System.out.println(nodes[i].distance);
//		}
		System.out.println(nodes[end].distance);
		scan.close();
		
	}
}
