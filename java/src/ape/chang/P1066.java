package ape.chang;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1066 {

	static class UnionFindSet {
		private Map<String, String> unionFindSet;
		public UnionFindSet() {
			unionFindSet = new HashMap<String, String>();
		}
		public void union(String a, String b) {
			String rootA = find(a);
			String rootB = find(b);
			if (rootA == null && rootB == null) {
				unionFindSet.put(a, a);
				unionFindSet.put(b, a);
			} else if (rootA == null) {
				unionFindSet.put(a, rootB);
			} else if (rootB == null) {
				unionFindSet.put(b, rootA);
			} else {
				if (!rootA.equals(rootB))
					unionFindSet.put(rootB, rootA);
			}
		}
		public String find(String x) {
			if (!unionFindSet.containsKey(x))
				return null;
			String y = x;
			while (!y.equals(unionFindSet.get(y)))
				y = unionFindSet.get(y);
			while (!y.equals(x)) {
				String t = unionFindSet.get(x);
				unionFindSet.put(x, y);
				x = t;
			}
			return y;
		}
	}

    public static void main(String[] args) {
		try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
		Scanner scanner = new Scanner(System.in);
		UnionFindSet unionFindSet = new UnionFindSet();
		int t = scanner.nextInt();
		while (t-- > 0) {
			int op = scanner.nextInt();
			String a = scanner.next();
			String b = scanner.next();
			if (op == 0) unionFindSet.union(a, b);
			else {
				String rootA = unionFindSet.find(a);
				String rootB = unionFindSet.find(b);
				if (rootA == null || rootB == null || !rootA.equals(rootB))
					System.out.println("no");
				else
					System.out.println("yes");
			}
		}
		scanner.close();
    }
	
}
