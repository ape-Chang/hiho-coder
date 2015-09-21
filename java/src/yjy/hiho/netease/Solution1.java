package yjy.hiho.netease;

import java.util.Scanner;

public class Solution1 {
	// 9706
	public static int solveCase(Scanner scan){
		String S = scan.nextLine();
		char[] A = S.toCharArray();
		int N = A.length;
		if(N<4){
			return 0;
		}
		
		int[] R6 = new int[N];
		int[] R06 = new int[N];
		int[] R706 = new int[N];
		int[] R9706 = new int[N];
		
		if(A[N-1]=='6'){
			R6[N-1] = 1;
		}else{
			R6[N-1] = 0;
		}
		
		for(int i =N-2;i>=0;i--){
			if(A[i]=='6'){
				R6[i] = R6[i+1] + 1;
			}else{
				R6[i] = R6[i+1];
			}
		}
		
		R06[N-1]=0;
		for(int i =N-2;i>=0;i--){
			if(A[i]=='0'){
				R06[i] = Math.min(R6[i+1], R06[i+1]+1);
			}else{
				R06[i] = R06[i+1];
			}
		}
		
		R706[N-1]=0;
		for(int i =N-2;i>=0;i--){
			if(A[i]=='7'){
				R706[i] = Math.min(R06[i+1], R706[i+1]+1);
			}else{
				R706[i] = R706[i+1];
			}
		}
		
		R9706[N-1]=0;
		for(int i =N-2;i>=0;i--){
			if(A[i]=='9'){
				R9706[i] = Math.min(R706[i+1], R9706[i+1]+1);
			}else{
				R9706[i] = R9706[i+1];
			}
		}

		return R9706[0];
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String NStr = scan.nextLine();
		int N = Integer.parseInt(NStr);
		for(int i=0;i<N;i++){
			int result = Solution1.solveCase(scan);
			System.out.println(result);
		}
		scan.close();
	}
}
