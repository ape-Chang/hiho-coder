package yjy.hiho;

import java.util.Scanner;

public class FastSort {
	
	public static void quickSort(int[] A,int i,int j){
		if(i>=j){
			return;
		}
		int I = i;
		int J = j;
		int slot = i;
		int v = A[slot];
		while(i<j){
			while(slot<j){
				if(A[j]<v){
					A[slot] = A[j];
					slot = j;
					j--;
//					System.out.println(slot);
					break;
				}
				j--;
			}
			while(i<slot){
				if(A[i]>v){
					A[slot] = A[i];
					slot = i;
					i++;
//					System.out.println(slot);
					break;
				}
				i++;
			}
		}
		A[slot] = v;
		quickSort(A,I,slot-1);
		quickSort(A,slot+1,J);
	}
	
	// 实现快速排序
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i] = scan.nextInt();
		}
		quickSort(A,0,N-1);
		for(int i=0;i<N;i++){
			System.out.println(A[i]);
		}
		scan.close();
	}
}
