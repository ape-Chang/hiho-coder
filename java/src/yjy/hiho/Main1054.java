package yjy.hiho;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1054 {
	
	public static int[][] P;
	public static int sum = 0;
	public static int EC = 0;
	public static Node[] nodes;
	
	static class Node{
		int index;
		boolean v;
		ArrayList<Node> adj;
		Node(int index){
			this.index = index;
			this.v = false;
			this.adj = new ArrayList<Node>();
		}
		
		void T(int d,Node last){
			if(last == null){
				if(this.adj.size()==2){
					return;
				}else if(this.adj.size()==1){
					this.v = true;
					Node n = this.adj.get(0);
					EC--;
					n.T(d+1, this);
					EC++;
					this.v = false;
					return;
				}else if(this.adj.size()==0){
					this.v = true;
					for(int i=0;i<9;i++){
						nodes[i].T(d+1, this);
					}
					this.v = false;
					return;
				}
				return;
			}
			if(this.v==true || last==this){
				return;
			}
			if(P[last.index][this.index]!=-1 && !nodes[P[last.index][this.index]].v){
				return;
			}
			if(this.adj.size()==2){
				if(this.adj.get(0)!=last && this.adj.get(1)!=last){
					return;
				}
			}
			this.v = true;
			if(d>=3 && EC==0){
				sum++;
			}
			if(this.adj.size()==0){
				for(int i=0;i<9;i++){
					nodes[i].T(d+1, this);
				}
			}else if(this.adj.size()==1){
				Node n = this.adj.get(0);
				if(n==last){
					for(int i=0;i<9;i++){
						nodes[i].T(d+1, this);
					}
				}else{
					EC--;
					n.T(d+1, this);
					EC++;
				}
			}else if(this.adj.size()==2){
				Node n1 = this.adj.get(0);
				Node n2 = this.adj.get(1);
				if(n1 == last){
					EC--;
					n2.T(d+1, this);
					EC++;
				}else{
					EC--;
					n1.T(d+1, this);
					EC++;
				}
			}else{
				System.out.println("FUCK!");
			}
			
			this.v = false;
		}
	}
	
	public static void solve(Scanner scan){
		int N = scan.nextInt();
		EC = N;
//		if(N==0){
//			System.out.println(389112);
//			return;
//		}
		
		nodes = new Node[9];
		for(int i=0;i<9;i++){
			nodes[i] = new Node(i);
		}
		
		for(int i=0;i<N;i++){
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			nodes[a].adj.add(nodes[b]);
			nodes[b].adj.add(nodes[a]);
		}
		
		sum = 0;
		for(int i=0;i<9;i++){
			nodes[i].T(0,null);
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args){
		P = new int[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				P[i][j] = -1;
			}
		}
		P[0][2] = 1;
		P[0][6] = 3;
		P[0][8] = 4;
		P[1][7] = 4;
		P[2][8] = 5;
		P[2][6] = 4;
		P[2][0] = 1;
		P[3][5] = 4;
		P[5][3] = 4;
		P[6][2] = 4;
		P[6][0] = 3;
		P[6][8] = 7;
		P[7][1] = 4;
		P[8][0] = 4;
		P[8][6] = 7;
		P[8][2] = 5;
		
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i=0;i<N;i++){
			solve(scan);
		}
		scan.close();
	}
}
