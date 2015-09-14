package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	int k = scanner.nextInt();
	boolean didExsit = false;
	int smallerThanMe = 0;
	while (n-- > 0) {
	    int x = scanner.nextInt();
	    if (x < k) ++smallerThanMe;
	    if (x == k) didExsit = true;
	}
	if (didExsit) 
	    System.out.println(smallerThanMe+1);
	else 
	    System.out.println(-1);
	scanner.close();
    }

}
