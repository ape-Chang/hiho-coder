package yjy.hiho;

import java.util.Scanner;

public class Main1037 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] A = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<=i;j++){
				A[i][j] = scan.nextInt();
			}
		}
		scan.close();
		
		if(N==1){
			System.out.println(A[0][0]);
			return;
		}
		
		int[][] R = new int[N][N];
		R[0][0] = A[0][0];
		for(int i=1;i<N;i++){
			R[i][0] = R[i-1][0] + A[i][0];
			R[i][i] = R[i-1][i-1] + A[i][i];
		}
		
		for(int i=1;i<N;i++){
			for(int j=1;j<=i-1;j++){
				if(R[i-1][j-1]>R[i-1][j]){
					R[i][j] = R[i-1][j-1];
				}else{
					R[i][j] = R[i-1][j];
				}
				R[i][j] +=A[i][j];
			}
		}
		int max = R[N-1][0];
		for(int i = 0; i<N;i++){
			if(max < R[N-1][i]){
				max = R[N-1][i];
			}
		}
		System.out.println(max);
		return;
	}
}
