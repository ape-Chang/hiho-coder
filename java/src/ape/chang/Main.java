package ape.chang;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    static class DirectedGraph {
	static class Node {
	    int id;
	    Node[] jacents;
	    public Node(int id) {
		this.id = id;
		jacents = new Node[10];
	    }
	}
	List<Node> nodes;
	public DirectedGraph() {
	    nodes = new ArrayList<Node>();
	    init();
	}
	public void addEdge(int from, int to) {
	    nodes.get(from).jacents[to] = nodes.get(to);
	}
	public void init() {
	    for (int i = 0; i < 10; ++i)
		nodes.add(new Node(i));
	    for (int i = 0; i < 10; ++i)
		addEdge(i, i);
	    
	    addEdge(1, 2);
	    addEdge(1, 3);
	    addEdge(1, 4);
	    addEdge(1, 5);
	    addEdge(1, 6);
	    addEdge(1, 7);
	    addEdge(1, 8);
	    addEdge(1, 9);
	    addEdge(1, 0);
	    
	    addEdge(2, 3);
	    addEdge(2, 5);
	    addEdge(2, 6);
	    addEdge(2, 8);
	    addEdge(2, 9);
	    addEdge(2, 0);
	    
	    addEdge(3, 6);
	    addEdge(3, 9);
	    
	    addEdge(4, 5);
	    addEdge(4, 6);
	    addEdge(4, 7);
	    addEdge(4, 8);
	    addEdge(4, 9);
	    addEdge(4, 0);
	    
	    addEdge(5, 6);
	    addEdge(5, 8);
	    addEdge(5, 9);
	    addEdge(5, 0);
	    
	    addEdge(6, 9);
	    
	    addEdge(7, 8);
	    addEdge(7, 9);
	    addEdge(7, 0);
	    
	    addEdge(8, 9);
	    addEdge(8, 0);
	}
	public int invalidPosition(String s) {
	    Node node = nodes.get(s.charAt(0) - '0');
	    int i = 1;
	    while (i < s.length()) {
		node = node.jacents[s.charAt(i) - '0'];
		if (node == null) break;
		else ++i;
	    }
	    return i;
	}
    }
    
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	DirectedGraph pad = new DirectedGraph();
	BigInteger one = new BigInteger("1");
	int t = scanner.nextInt();
	while (t-- > 0) {
	    String s = scanner.next();
	    int p;
	    while ((p = pad.invalidPosition(s)) != s.length()) {
		char[] A = s.toCharArray();
		while (++p < A.length) A[p] = '0';
		s = new BigInteger(new String(A)).subtract(one).toString();
	    }
	    System.out.println(s);
	}
	scanner.close();
    }

}
