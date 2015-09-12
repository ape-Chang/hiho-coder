package yjy.hiho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	ArrayList<Node> nexts;
	int count = 0;
	int index;
	Node(){
		count = 0;
		nexts = new ArrayList<Node>();
	}
}

public class Main {
	
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int sum = 0;
		int N,M,K;
		N = scan.nextInt();
		M = scan.nextInt();
		K = scan.nextInt();
		
		int[] counts = new int[N];
		Node[] nodes = new Node[N];
		
		for(int i = 0 ; i<N ; i++){
			counts[i] = 0;
			nodes[i] = new Node();
			nodes[i].index = i;
		}
		for(int i = 0 ; i<K ; i++){
			int index = scan.nextInt()-1;
			counts[index] = (counts[index]+1)%142857;
		}
		for(int i = 0 ; i<M ; i++){
			int pre = scan.nextInt()-1;
			int next = scan.nextInt()-1;
			nodes[pre].nexts.add(nodes[next]);
			nodes[next].count++;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		for(int i=0;i<N;i++){
			if(nodes[i].count == 0){
				queue.add(nodes[i]);
			}
		}
		while(!queue.isEmpty()){
			Node cur = queue.poll();
			
			for(Node elm : cur.nexts){
				elm.count--;
				counts[elm.index] += counts[cur.index];
				counts[elm.index] = counts[elm.index]%142857;
				if(elm.count == 0){
					queue.add(elm);
				}
			}
		}
		scan.close();
		for(int i=0;i<N;i++){
			sum += counts[i];
			sum = sum%142857;
		}
		System.out.println(sum);
	}
}
