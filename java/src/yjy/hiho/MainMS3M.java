package yjy.hiho;

import java.util.HashMap;
import java.util.Scanner;

public class MainMS3M {

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int N = scan.nextInt();
		int [] A = new int[N];
		for(int i=0;i<N;i++){
			A[i] = scan.nextInt();
		}
		HashMap<Integer,Integer> fib = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> fibC = new HashMap<Integer,Integer>();
		int a=1;int b=1;
		int countOne = 0;
		for(int i=0;i<N;i++){
			if(A[i]==1){
				Integer C1 = fibC.get(1);
				if(C1==null){
					C1 = 0;
					fibC.put(1, C1);
				}
				fibC.put(1, C1+countOne);
				countOne++;
				continue;
			}
			if(a+b==A[i]){
				b = a+b;
				a = b-a;
				fib.put(b, a);
			}
			Integer pre = fib.get(A[i]);
			if(pre!=null){
				Integer Cpre = fibC.get(pre);
				if(Cpre==null){
					Cpre = 0;
					fibC.put(pre, Cpre);
				}
				Integer Ccur = fibC.get(A[i]);
				if(Ccur==null){
					Ccur = 0;
					fibC.put(A[i],Ccur);
				}
				fibC.put(A[i],Ccur+Cpre);
			}
		}
		int sum = 0;
		for(Integer v : fibC.values()){
			sum+=v;
		}
		sum+=countOne;
		System.out.println(sum);
		scan.close();
	}
}
