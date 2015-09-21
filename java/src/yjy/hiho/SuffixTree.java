package yjy.hiho;

import java.util.HashMap;
import java.util.Scanner;

public class SuffixTree {
	
	static final int theS1Flag = 0;
	static final int theS2Flag = 1;
	
	static int MAX = 0;
	
	static class Node{
		int layer;
		boolean S1Flag;
		boolean S2Flag;
		HashMap<Character,Node> children;
		Node(){
			this.children = new HashMap<Character,Node>();
			this.S1Flag = false;
			this.S2Flag = false;
		}
		
		boolean insertSuffix(char[] S,int begin,int flag){
			boolean maxReseted = false;
			Node cur = this;
			for(int i=begin;i<S.length;i++){
				char curC = S[i];
				Node cnode = cur.children.get(curC);
				if(cnode==null){
					cnode = new Node();
					cnode.layer = cur.layer + 1;
					cur.children.put(curC, cnode);
				}
				cur = cnode;
				switch(flag){
				case theS1Flag:
					cur.S1Flag = true;
					break;
				case theS2Flag:
					cur.S2Flag = true;
					break;
				}
				
				if(cur.S1Flag && cur.S2Flag){
					if(cur.layer>MAX){
						MAX = cur.layer;
						maxReseted = true;
					}
				}
			}
			return maxReseted;
		}
	}
	
	// 解决最长公共子串（String）问题
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();
		int L1 = s1.length();
		int L2 = s2.length();
		Node root = new Node();
		root.layer = 0;
		char[] S1 = s1.toCharArray();
		char[] S2 = s2.toCharArray();
		for(int i=0;i<L1;i++){
			root.insertSuffix(S1,i,theS1Flag);
		}
		
		int tmp = 0;
		for(int i=0;i<L2;i++){
			boolean maxReseted = root.insertSuffix(S2,i,theS2Flag);
			if(maxReseted){
				tmp = i;
			}
		}
		System.out.println(s2.substring(tmp, tmp+MAX));
		scan.close();
	}
}
