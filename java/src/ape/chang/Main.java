package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {  

    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int n = Integer.valueOf(scanner.nextLine());
	int[] A = new int[n+1];
	for (int i = 1; i <= n; ++i) {
	    for (int j = i; j >= 1; --j) {
		int x = scanner.nextInt();
		A[j] = Math.max(A[j-1]+x, A[j]+x);
	    }
	}
	int max = 0;
	for (int i : A) if (i > max) max = i;
	System.out.println(max);
	scanner.close();
    }

}

