package yjy.hiho;

import java.util.Scanner;

public class UFSet {
	
	static class Node{
		Node parent;
		int value;
		int count;
		void merge(Node n){
			if(n==null){
				return;
			}
			
			Node selfP = this.getP();
			Node nodeP = n.getP();
			if(selfP.count>nodeP.count){
				nodeP.parent = selfP;
				selfP.count +=nodeP.count;
			}else{
				selfP.parent = nodeP;
				nodeP.count +=selfP.count;
			}
			
		}
		
		Node getP(){
			Node selfP = this;
			while(selfP.parent != null){
				selfP = selfP.parent;
			}
			return selfP;
		}
	}
	 
	 public static void main(String[] args){
		 Scanner scan = new Scanner(System.in);
		 int N = scan.nextInt();
		 int M = scan.nextInt();
		 Node[] nodes = new Node[N];
		 for(int i=0;i<N;i++){
			 nodes[i] = new Node();
			 nodes[i].value = i+1;
			 nodes[i].count = 1;
			 nodes[i].parent = null;
		 }
		 
		 for(int i=0;i<M;i++){
			 int a = scan.nextInt()-1;
			 int b = scan.nextInt()-1;
			 nodes[a].merge(nodes[b]);
		 }
		 
		 for(int i=0;i<N;i++){
			 System.out.println(nodes[i].getP().value);
		 }
		 
		 scan.close();
	 }

}
