package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

import sun.net.www.content.image.gif;

public class Main {
    
    static class Gift {
	public int cost;
	public int value;
	public Gift(int cost, int value) {
	    this.cost = cost;
	    this.value = value;
	}
    }
    
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	int tickets = scanner.nextInt();
	Gift[] gifts = new Gift[n];
	for (int i = 0; i < n; ++i) {
	    int cost = scanner.nextInt();
	    int value = scanner.nextInt();
	    gifts[i] = new Gift(cost, value);
	}
	int[] dp = new int[tickets+1];
	for (int i = 0; i < dp.length; ++i) dp[i] = 0;
	for (int i = 0; i < gifts.length; ++i) {
	    int[] tmp = new int[dp.length];
	    for (int j = 1; j < dp.length; ++j) {
		if (j >= gifts[i].cost)
		    tmp[j] = Math.max(dp[j], dp[j-gifts[i].cost] + gifts[i].value);
		else
		    tmp[j] = dp[j];
	    }
	    dp = tmp;
	}
	System.out.println(dp[tickets]);
	scanner.close();
    }

}
