package yjy.hiho;

import java.util.HashMap;
import java.util.Scanner;

public class Main1062 {
	
	static class Node{
		String name;
		Node parent;
		Node(String name){
			this.name = name;
			this.parent = null;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String StrN = scan.next();
		int N = Integer.parseInt(StrN);
		HashMap<String,Node> map = new HashMap<String,Node>();
		for(int i=0;i<N;i++){
			String n1 = scan.next();
			String n2 = scan.next();
			Node node1 = map.get(n1);
			Node node2 = map.get(n2);
			if(node1 == null){
				node1 = new Node(n1);
				map.put(n1, node1);
			}
			if(node2 == null){
				node2 = new Node(n2);
				map.put(n2, node2);
			}
			node2.parent = node1;
		}
		
		String StrM = scan.next();
		int M = Integer.parseInt(StrM);
		for(int i=0;i<M;i++){
			String n1 = scan.next();
			String n2 = scan.next();
			Node node1 = map.get(n1);
			Node node2 = map.get(n2);
			
			if(node1==null || node2==null){
				System.out.println(-1);
				continue;
			}
			
			int c1 = 0;
			Node cur1 = node1;
			while(cur1.parent != null){
				cur1 = cur1.parent;
				c1++;
			}
			int c2 = 0;
			Node cur2 = node2;
			while(cur2.parent != null){
				cur2 = cur2.parent;
				c2++;
			}
			if(cur1!=cur2){
				System.out.println(-1);
				continue;
			}
			
			cur1 = node1;
			cur2 = node2;
			if(c2>c1){
				int g = c2-c1;
				for(int j=0;j<g;j++){
					cur2 = cur2.parent;
				}
			}else{
				int g = c1-c2;
				for(int j=0;j<g;j++){
					cur1 = cur1.parent;
				}
			}
			while(cur1!=cur2){
				cur1=cur1.parent;
				cur2=cur2.parent;
			}
			System.out.println(cur1.name);
		}
		scan.close();
	}

}
