package yjy.hiho;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMS3 {  
	static long Mod = 1000000007;
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int N = scan.nextInt();
    	int[] A = new int[N];
    	long max = 0;
    	for (int i = 0; i < N; i++) {
    		A[i] = scan.nextInt();
    		max = Math.max(max, A[i]);
    	}
    	Map<Long, Long> map1 = new HashMap<Long, Long>();
    	Map<Long, Long> map2 = new HashMap<Long, Long>();
    	long a = 1;
    	long b = 1;
    	while (b <= max) {
    		map1.put(b, 0L);
    		map2.put(b, a);
    		b = a+b;
    		a = b-a;
    	}
    	
    	int i = 0;
    	long k = 0;
    	long Count1 = 0;
    	while (i < N) {
    		if (map1.containsKey((long)A[i])) {
    			long p = 0;
    			if (A[i] == 1) {
    				p = ++Count1;
    			} else if (A[i] == 2) {
    				p = Count1*(Count1-1)/2;
    			} else {
    				p = map1.get( map2.get((long)A[i]) );
    			}
    			long q = map1.get((long)A[i]) + p; if (q > Mod) q %= Mod;
    			map1.put((long)A[i], q);
    			k += p; 
    			if (k > Mod){
    				k %= Mod;
    			}
    		}
    		i++;
    	}
		System.out.println(k);
		scan.close();
    }

}
