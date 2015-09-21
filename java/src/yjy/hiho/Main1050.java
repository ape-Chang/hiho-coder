package yjy.hiho;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1050 {
	
	static class Node{
		int index;
		int d;
		boolean v;
		ArrayList<Node> adj;
		Node(int index){
			this.index = index;
			this.v = false;
			this.adj = new ArrayList<Node>();
		}
	}
	
	public static void visitNode(Node n){
		n.v = true;
		int max1=0,max2=0;
		int count = 0;
		for(Node e : n.adj){
			if(!e.v){
				count++;
				visitNode(e);
				if(e.d>max1){
					max2 = max1;
					max1 = e.d;
				}else if(e.d>max2){
					max2 = e.d;
				}
			}
		}
		if(max1+max2+2>MAX){
			MAX = max1+max2+2;
		}
		if(count == 0){
			n.d = 0;
		}else{
			n.d = max1+1;
		}
		
	}
	
	public static int MAX;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Node[] nodes = new Node[N];
		for(int i=0;i<N;i++){
			nodes[i] = new Node(i);
		}
		for(int i=0;i<N-1;i++){
			int a = scan.nextInt() - 1;
			int b = scan.nextInt() - 1;
			nodes[a].adj.add(nodes[b]);
			nodes[b].adj.add(nodes[a]);
		}
		MAX = 0;
		visitNode(nodes[0]);
		System.out.println(MAX);
		scan.close();
	}
}
