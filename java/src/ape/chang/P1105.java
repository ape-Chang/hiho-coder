package ape.chang;

import java.io.FileInputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1105 {
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	PriorityQueue<Integer> heap = new PriorityQueue<Integer>(10000, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	int t = scanner.nextInt();
	while (t-- > 0) {
		if (scanner.next().equals("A"))
			heap.add(scanner.nextInt());
		else {
			System.out.println(heap.peek());
			heap.remove();
		}
	}
	scanner.close();
    }
}
