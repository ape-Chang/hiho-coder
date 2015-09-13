package yjy.hiho;

import java.util.Scanner;

public class Main1051 {

	
	public static void solveCase(Scanner scan){
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] array = new int[N];
		for(int i=0;i<N;i++){
			array[i] = scan.nextInt();
		}
		if(M>=N){
			System.out.println(100);
			return;
		}
		int max = array[M]-1;
		int tmp = 100 - array[N-M-1];
		if(tmp>max){
			max = tmp;
		}
		for(int i=M+1;i<N;i++){
			tmp = array[i]-array[i-M-1] - 1;
			if(tmp>max){
				max = tmp;
			}
		}
		System.out.println(max);
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++){
			Main1051.solveCase(scan);
		}
		scan.close();
	}
}
