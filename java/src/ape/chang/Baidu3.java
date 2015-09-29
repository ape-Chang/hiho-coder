package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

public class Baidu3 {
	static public int longestDescendingSequenceLength(int[] A) {
		int[] L = new int[A.length];
		for (int i = 0; i < L.length; ++i) L[i] = 1;
		for (int i = 1; i < L.length; ++i) 
			for (int j = 0; j < i; ++j)
				if (A[i] <= A[j])
					L[i] = Math.max(L[i], L[j] + 1);
		int max = 0;
		for (int i = 0; i < L.length; ++i) max = Math.max(max, L[i]);
		return max;
	}
	
    public static void main(String[] args) {
		try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt();
			int[] A = new int[n];
			for (int i = 0; i < n; ++i) A[i] = scanner.nextInt();
			System.out.println(longestDescendingSequenceLength(A));
		}
		scanner.close();
    }
}
