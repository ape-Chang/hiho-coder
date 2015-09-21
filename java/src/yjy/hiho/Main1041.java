package yjy.hiho;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1041 {
	
	static class Node{
		int index;
		int bits;
		boolean v;
		ArrayList<Node> adj;
		Node(){
			this.adj = new ArrayList<Node>();
			this.v = false;
			this.bits = 0;
		}
	}

	public static int cur;
	public static int[] city;
	
	public static int calculateBits(Node n){
		n.v = true;
		int result = 1<<n.index;
		for(Node e : n.adj){
			if(!e.v){
				result = result|calculateBits(e);
			}
		}
		n.bits = result;
		return result;
	}
	
	public static boolean travelCity(Node n){
		n.v = true;
		if(city[cur]==n.index){
			cur++;
			if(cur == city.length){
				return true; 
			}
		}
		
		while(cur<city.length){
			Node foundNode = null;
			for(Node e : n.adj){
				if(((1<<city[cur])&e.bits)!=0){
					if((e.bits|n.bits)==e.bits){
						continue;
					}
					if(!e.v){
						foundNode = e;
						break;
					}else{
						return false;
					}
				}
				
			}
			if(foundNode != null){
				boolean bb = travelCity(foundNode);
				if(!bb){
					return false;
				}
			}else{
				break;
			}
		}
		
		return true;
	}
	
	public static boolean solveCase(Scanner scan){
		int N = scan.nextInt();
		Node[] nodes = new Node[N];
		for(int i=0;i<N;i++){
			nodes[i] = new Node();
			nodes[i].index = i;
		}
		for(int i=0;i<N-1;i++){
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			nodes[a].adj.add(nodes[b]);
			nodes[b].adj.add(nodes[a]);
		}
		
		int M = scan.nextInt();
		city = new int[M];
		for(int i=0;i<M;i++){
			city[i] = scan.nextInt()-1;
		}
		
		calculateBits(nodes[0]);
		for(int i=0;i<N;i++){
			nodes[i].v = false;
		}
		cur = 0;
		boolean result = travelCity(nodes[0]);
//		System.out.println(cur);
		if(result&&cur==city.length){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i=0;i<N;i++){
			boolean result = solveCase(scan);
			if(result){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		scan.close();
	}
}
