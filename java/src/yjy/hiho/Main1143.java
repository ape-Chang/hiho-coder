package yjy.hiho;

import java.util.Scanner;

public class Main1143 {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		if(N==1){
			System.out.println(1);
			return;
		}
		if(N==2){
			System.out.println(2);
			return;
		}
		int A1 = 1;
		int A2 = 2;
		int A3 = 0;
		for(int i=3;i<=N;i++){
			A3 = (A1 + A2)%19999997;
			A1 = A2;
			A2 = A3;
		}
		System.out.println(A3);
	}
}
