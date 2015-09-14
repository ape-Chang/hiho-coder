package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
  
    private static char[] expand(String s) {
	char[] A = new char[2*s.length() + 1];
	int i = 0;
	for (char c : s.toCharArray()) {
	    A[i++] = '#';
	    A[i++] = c;
	}
	A[i] = '#';
	return A;
    }
    
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int t = scanner.nextInt();
	while (t-- > 0) {
	    char[] A = expand(scanner.next());
	    int[] P = new int[A.length];
	    int id = 0, mx = 1;
	    for (int i = 1; i < A.length; ++i) {
		if (i < id+mx) 
		    P[i] = Math.min(P[2*id-i], id+mx-i);
		while (i-P[i] >= 0 && i+P[i] < A.length && A[i-P[i]] == A[i+P[i]])
		    P[i]++;
		if (i+P[i] > id+mx) { // <- important!
		    id = i;
		    mx = P[i];
		}
	    }
	    mx = 0;
	    for (int m : P) mx = Math.max(mx, m);
	    System.out.println(mx-1);
	}
	scanner.close();
    }

    
}
