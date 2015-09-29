package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

public class Ms1 {
	public static int p, q;
	public static double max;
	public static double x, y, r;
	
	public static void scanLeftHalf() {
		int lowerBound = (int) Math.ceil(x);
		int upperBound = (int) Math.floor(x+r);
		int yy = (int) Math.ceil(y+r);
		for (int i = lowerBound; i <= upperBound; ++i) {
			double d = 0.0f;
			while (true) {
				d = (i-x)*(i-x) + (yy-y)*(yy-y);
				if (d <= r*r) break;
				--yy;
			}
			if (d >= max) {p = i; q = yy; max = d;}
		}
		for (int i = upperBound; i >= lowerBound; --i) {
			double d = 0.0f;
			while (true) {
				d = (i-x)*(i-x) + (yy-y)*(yy-y);
				if (d > r*r) break;
				--yy;
			}
			++yy;
			d = (i-x)*(i-x) + (yy-y)*(yy-y);
			if (d > max) {p = i; q = yy; max = d;}
		}
	}
	
	public static void scanRightHalf() {
		int lowerBound = (int) Math.ceil(x-r);
		int upperBound = (int) Math.floor(x);
		int yy = (int) Math.ceil(y+r);
		for (int i = upperBound; i >= lowerBound; --i) {
			double d = 0.0f;
			while (true) {
				d = (i-x)*(i-x) + (yy-y)*(yy-y);
				if (d <= r*r) break;
				--yy;
			}
			if (d > max) {p = i; q = yy; max = d;}
		}
		for (int i = lowerBound; i <= upperBound; ++i) {
			double d = 0.0f;
			while (true) {
				d = (i-x)*(i-x) + (yy-y)*(yy-y);
				if (d > r*r) break;
				--yy;
			}
			++yy;
			d = (i-x)*(i-x) + (yy-y)*(yy-y);
			if (d > max) {p = i; q = yy; max = d;}
		}
	}
	
    public static void main(String[] args) {
		try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
		Scanner scanner = new Scanner(System.in);
		x = scanner.nextDouble(); y = scanner.nextDouble(); r = scanner.nextDouble();
		scanLeftHalf();
		scanRightHalf();
		System.out.println(String.format("%d %d", p, q));
		scanner.close();
    }
}
