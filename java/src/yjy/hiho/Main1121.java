package yjy.hiho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1121 {
	static enum State{
		U,M,F
	}
	
	static class Node{
		ArrayList<Node> adjs;
		State s;
		int index;
		Node(){
			s = State.U;
			adjs = new ArrayList<Node>();
		}
		void test(){
//			waitfor(this);
		}
	}
	
	public static void solveCase(Scanner scan){
		int N =scan.nextInt();
		int M=scan.nextInt();
		Node[] nodes = new Node[N];
		for(int i=0;i<N;i++){
			nodes[i] = new Node();
			nodes[i].index = i;
		}
		
		for(int i=0;i<M;i++){
			int L =scan.nextInt()-1;
			int R =scan.nextInt()-1;
			nodes[L].adjs.add(nodes[R]);
			nodes[R].adjs.add(nodes[L]);
		}
		Queue<Node> q = new LinkedList<Node>();
		for(int i=0;i<N;i++){
			if(nodes[i].s == State.U){
				nodes[i].s = State.M;
				q.add(nodes[i]);
				while(!q.isEmpty()){
					Node node = q.poll();
					State ss = State.U;
					if(node.s == State.M){
						ss = State.F;
					}
					if(node.s == State.F){
						ss = State.M;
					}
					for(Node n : node.adjs){
						if(n.s == State.U){
							n.s = ss;
							q.add(n);
						}else{
							if(n.s == ss){
								// right
							}else{
								System.out.println("Wrong");
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("Correct");
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t=0;t<T;t++){
			Main1121.solveCase(scan);
		}
		scan.close();
	}
}
