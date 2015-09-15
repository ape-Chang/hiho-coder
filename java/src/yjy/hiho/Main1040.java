package yjy.hiho;

import java.util.Scanner;

public class Main1040 {

	public static boolean solveCase(Scanner scan){
		int [][] A = new int[4][4];
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				A[i][j] = scan.nextInt();
			}
		}
		int[][] V = new int[4][2];
		for(int i=0;i<4;i++){
			V[i][0] = A[i][2]-A[i][0];
			V[i][1] = A[i][3]-A[i][1];
			if(V[i][0]==0 && V[i][1]==0){
				return false;
			}
		}
		
		for(int i=0;i<4;i++){
			int count = 0;
			for(int j=1;j<4;j++){
				int k = (i+j)%4;
				if(V[i][0]*V[k][0]+V[i][1]*V[k][1]==0){
					// 垂直
					count++;
				}else{
					if(V[i][0]*V[k][1] == V[k][0]*V[i][1]){
						// 平行 判断是否共线 i k
						int v00 = V[i][0];
						int v01 = V[i][1];
						int v10 = A[k][0]-A[i][0];
						int v11 = A[k][1]-A[i][1];
						if(v00*v11 == v10*v01){
							return false;
						}
					}else{
						return false;
					}
				}
			}
			if(count != 2){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i=0 ; i<N ; i++){
			boolean isRect = Main1040.solveCase(scan);
			if(isRect){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		scan.close();
	}
}
