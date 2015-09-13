package yjy.hiho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1152 {
//	public static int[] fib = {1,2,3,5,13,21};
	public static boolean isFib(int n){
		boolean result = false;
		switch(n){
		case 1:
			result = true;
			break;
		case 2:
			result = true;
			break;
		case 3:
			result = true;
			break;
		case 5:
			result = true;
			break;
		case 8:
			result = true;
			break;
		case 13:
			result = true;
			break;
		case 21:
			result = true;
			break;
		default:
			result = false;
			break;
		}
		return result;
	}
	
	static class Node{
		Node[] c;
		boolean exist;
		Node(){
			c = new Node[26];
			exist = false;
		}
		
		void insertStr(char[] array,int b,int e){
			Node cur = this;
			for(int i=b;i<=e;i++){
				int index = array[i] - 'a';
				if(cur.c[index]==null){
					cur.c[index] = new Node();
				}
				cur = cur.c[index];
			}
			cur.exist = true;
		}
		
		void printNode(){
			//
		}
	}
	
	public static int countOne(int n){
		int count = 0;
		while(n!=0){
			count++;
			n = n&(n-1);
		}
		return count;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String S = scan.nextLine();
		char[] strArray = S.toCharArray();
		scan.close();
		int N = strArray.length;
		if(N==1){
			System.out.println(S);
			return;
		}
		int[][] A = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				A[i][j] = 0;
			}
		}
		for(int i=0;i<N;i++){
			int bit_num = strArray[i]-'a';
			A[i][i] = 1<<bit_num;
		}
		
		for(int i=1;i<N;i++){
			for(int j=0;j<N-i;j++){
				int bit_num = strArray[j+i]-'a';
				A[j][j+i] = (1<<bit_num)|A[j][j+i-1];
			}
		}
//		Node root = new Node();
		
		ArrayList<String> list = new ArrayList<String>();
		for(int j=0;j<N;j++){
			for(int i=0;i<=j;i++){
				if(isFib(countOne(A[i][j]))){
//					root.insertStr(strArray, i, j);
					String subString = S.substring(i, j+1);
					if(!list.contains(subString)){
						list.add(subString);
					}
				}
			}
		}
		Collections.sort(list);
		for(String s:list){
			System.out.println(s);
		}
	}
}
