package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {  

    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	int k = 0;
	double d = Double.MAX_VALUE;
	for(int i = 1; i <= n; ++i) {
	    int a = scanner.nextInt();
	    String op = scanner.next();
	    int b = scanner.nextInt();
	    double x = 0;
	    if (op.equals("+")) 
		x = Math.abs(a+b-9.0);
	    else if (op.equals("-"))
		x = Math.abs(a-b-9.0);
	    else if (op.equals("*"))
		x = Math.abs(1.0*a*b-9.0);
	    else 
		x = Math.abs(1.0*a/b-9.0);
	    if (x < d) {
		k = i;
		d = x;
	    }
	}
	System.out.println(k);
	scanner.close();
    }

}

