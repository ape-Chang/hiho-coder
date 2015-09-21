package yjy.hiho;

import java.util.Scanner;

public class Main1044 {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int Q = scan.nextInt();
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i] = scan.nextInt();
		}
		int[][][] R = new int[N][M+1][Q+1];
		
		for(int m=1;m<M+1;m++){
			for(int i=1;i<N;i++){
				R[i][m][0] = 0;
			}
		}
		
		for(int m=1;m<=M;m++){
			for(int i=0;i<N;i++){
				R[i][m][0] = 0;
			}
		}
		
		for(int m=1;m<=M;m++){
			for(int q=0;q<=Q;q++){
				if(q==0){
					R[0][m][q] = 0;
				}else{
					R[0][m][q] = A[0];
				}
			}
		}
		
		for(int m=2;m<=M;m++){
			for(int q=1;q<=Q;q++){
				for(int i=1;i<N;i++){
					int a = R[i-1][m-1][q];
					int b = R[i-1][m-1][q-1]+A[i];
					if(a>b){
						R[i][m][q] = a;
					}else{
						R[i][m][q] = b;
					}
					
				}
			}
		}
		scan.close();
	}
}
