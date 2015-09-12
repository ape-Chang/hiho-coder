package yjy.hiho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1223 {
	
	static enum Sign{
		S,SE,B,BE,E
	}
	
	static class Exp{
		Sign sign;
		int C;
	}
	
	static class Node{
		ArrayList<Node> adjs;
		int index;
		Node(){
			adjs = new ArrayList<Node>();
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String strN = scan.nextLine();
		int N = Integer.parseInt(strN);
		Exp[] exps = new Exp[N];
		Node[] nodes = new Node[N];
		for(int i=0;i<N;i++){
			nodes[i] = new Node();
			nodes[i].index = i;
			String expStr = scan.nextLine();
			String[] expA = expStr.split(" ");
			Exp exp = new Exp();
			if(expA[1].equals("<")){
				exp.sign = Sign.S;
			}else if(expA[1].equals("<=")){
				exp.sign = Sign.SE;
			}else if(expA[1].equals(">")){
				exp.sign = Sign.B;
			}else if(expA[1].equals(">=")){
				exp.sign = Sign.BE;
			}else if(expA[1].equals("=")){
				exp.sign = Sign.E;
			}
			exp.C = Integer.parseInt(expA[2]);
			exps[i] = exp;
		}
		scan.close();
		
		if(N==1){
			System.out.println(1);
			return;
		}
		
		for(int i=0;i<N-1;i++){
			for(int j=i+1;j<N;j++){
				// 1
				if((exps[i].sign == Sign.BE||exps[i].sign == Sign.B) && (exps[j].sign == Sign.BE||exps[j].sign == Sign.B)){
					continue;
				}
				if((exps[i].sign == Sign.SE||exps[i].sign == Sign.S) && (exps[j].sign == Sign.SE||exps[j].sign == Sign.S)){
					continue;
				}
				
				// 2
				if(exps[i].sign == Sign.E || exps[j].sign == Sign.E){
					if(exps[i].sign == Sign.E && exps[j].sign == Sign.E){
						if(exps[i].C != exps[j].C){
							nodes[i].adjs.add(nodes[j]);
							nodes[j].adjs.add(nodes[i]);
						}
						continue;
					}
					int C,C2;
					Sign Si;
					
					if(exps[i].sign == Sign.E){
						C = exps[i].C;
						C2 = exps[j].C;
						Si = exps[j].sign;
					}else{
						C = exps[j].C;
						C2 = exps[i].C;
						Si = exps[i].sign;
					}
					switch(Si){
						case S:
							if(!(C<C2)){
								nodes[i].adjs.add(nodes[j]);
								nodes[j].adjs.add(nodes[i]);
							}
						break;
						case SE:
							if(!(C<=C2)){
								nodes[i].adjs.add(nodes[j]);
								nodes[j].adjs.add(nodes[i]);
							}
						break;
						case B:
							if(!(C>C2)){
								nodes[i].adjs.add(nodes[j]);
								nodes[j].adjs.add(nodes[i]);
							}
						break;
						case BE:
							if(!(C>=C2)){
								nodes[i].adjs.add(nodes[j]);
								nodes[j].adjs.add(nodes[i]);
							}
						break;
					}
					continue;
				}
				
				// 3
				if(exps[i].C == exps[j].C){
					if((exps[i].sign == Sign.BE || exps[i].sign == Sign.SE) && 
							(exps[j].sign == Sign.BE || exps[j].sign == Sign.SE)){
						
					}else{
						nodes[i].adjs.add(nodes[j]);
						nodes[j].adjs.add(nodes[i]);
					}
					continue;
				}
				
				int A,B;
				// 4
				if(exps[i].sign == Sign.BE || exps[i].sign == Sign.B){
					A = exps[i].C;
					B = exps[j].C;
				}else{
					A = exps[j].C;
					B = exps[i].C;
				}
				if(A>B){
					nodes[i].adjs.add(nodes[j]);
					nodes[j].adjs.add(nodes[i]);
				}
				continue;
			}
		}
		
		boolean[] marks = new boolean[N];
		for(int i=0;i<N;i++){
			marks[i] = true;
		}
		int sum = 0;
		for(int i=0;i<N;i++){
			if(marks[i]){
				sum++;
				Queue<Node> q = new LinkedList<Node>();
				q.add(nodes[i]);
				while(!q.isEmpty()){
					Node node = q.poll();
					marks[node.index] = false;
					for(Node n : node.adjs){
						if(marks[n.index]){
							q.add(n);
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
}
