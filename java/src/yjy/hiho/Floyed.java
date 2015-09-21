package yjy.hiho;

import java.util.Scanner;

public class Floyed {
	
	static int MAX_INT = 1000000000;
	
	// 实现Floyed算法
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[][] D = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				D[i][j] = MAX_INT;
			}
			D[i][i] = 0;
		}
		
		for(int i=0;i<M;i++){
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			int d = scan.nextInt();
			D[a][b] = d;
			D[b][a] = d;
		}
		
		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(D[i][j]>D[i][k]+D[k][j]){
						int DD = D[i][k]+D[k][j];
						D[i][j]=DD;
						D[j][i]=DD;
					}
				}
			}
		}
		for(int i=0;i<N;i++){
			System.out.println(D[0][i]);
		}
		System.out.println("Done");
		scan.close();
	}
}
