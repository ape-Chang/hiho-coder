package yjy.hiho;

import java.util.Scanner;

public class HihoSolution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextInt()){
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(a+b);
		}
		scan.close();
	}
}
