package ape.chang;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Baidu2 {
	static class X {
		public char[] A;
		public int size;
		public X (String s) {
			A = s.toCharArray();
			Arrays.sort(A);
			size = A.length;
		}
		public void remove(char c) {
			int i = index(c);
			size--;
			while (i < size) {
				A[i] = A[i+1];
				++i;
			}
		}
		public int index(char c) {
			int i = 0;
			while (A[i] != c) ++i;
			return i;
		}
	}

	static public long p(int n) {
		if (n <= 1) return 1;
		int p = 1;
		while (n > 0) p *= n--;
		return p;
	}
	
    public static void main(String[] args) {
		try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		while (n-- > 0) {
			String s = scanner.next();
			char[] A = s.toCharArray();
			X x = new X(s);
			long th = 1;
			for (int i = 0; i < A.length; ++i) {
				th += x.index(A[i])*p(x.size - 1);
				x.remove(A[i]);
			}
			System.out.println(th);
		}
		scanner.close();
    }
}
