package yjy.hiho;

import java.util.Scanner;

public class PackSum {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] item = new int[N];
		for(int i=0;i<N;i++){
			int a = scan.nextInt();
			item[i] = a;
		}
		scan.close();
		int SUM = 0;
		for(int i=0;i<N;i++){
			SUM += item[i];
		}
		if(SUM%2 == 1){
			System.out.println("NO");
			return;
		}
		int P = SUM/2+1;
		boolean[][] A = new boolean[N][P];
		int[][] T = new int[N][P];
		
		for(int j=0;j<P;j++){
			A[0][j] = false;
		}
		A[0][item[0]] = true;
		
		for(int i=1;i<N;i++){
			for(int j=0;j<P;j++){
				A[i][j] = false;
				if((j-item[i]>=0)&&A[i-1][j-item[i]]){
					A[i][j] = true;
					T[i][j] = i;
				}else if(A[i-1][j]){
					A[i][j] = true;
					T[i][j] = T[i-1][j];
				}
			}
		}
		if(A[N-1][P-1]){
			System.out.println("YES");
		}else{
			System.out.println("NO");
			return;
		}
		
		int j = P-1;
		int i = N-1;
		while(j>0){
			System.out.println(T[i][j]);
			int a = T[i][j];
			j -= item[a];
			if(i!=a){
				i = a;
			}else{
				i--;
			}
		}
		
	}
}
