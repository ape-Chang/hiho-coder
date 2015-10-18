package ape.chang;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {  
	
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			BigInteger c = BigInteger.valueOf(scanner.nextInt());
			while (n-- > 0) {
				BigInteger b = BigInteger.valueOf(scanner.nextInt());
				if (b.compareTo(c) <= 0) c = c.add(b);
				else c = c.add( c.gcd(b) );
			}
			System.out.println(c);
		}
		scanner.close();
    }
    

}

