package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {  

    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int t = scanner.nextInt();
	for (int i = 1; i <= t; ++i) {
	    int n = scanner.nextInt();
	    int q = scanner.nextInt();
	    int[] A = new int[n];
	    for (int j = 0; j < A.length; ++j) A[j] = scanner.nextInt();
	    System.out.println("Case #" + i + ":");
	    while (q-- > 0) {
		int l = scanner.nextInt()-1;
		int r = scanner.nextInt()-1;
		int k = scanner.nextInt();
		int m = Integer.MAX_VALUE;
		for (int p = l; p <= r; ++p) m = Math.min(m, Math.abs(A[p]-k));
		System.out.println(m);
	    }
	}
	scanner.close();
    }

}

