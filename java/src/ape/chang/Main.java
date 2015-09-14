package ape.chang;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    static class Dag {
	static class Node {
	    public int id;
	    public List<Node> jacent;
	    public Node(int id) {
		this.id = id;
		this.jacent = new ArrayList<Main.Dag.Node>();
	    }
	    public int indegree;
	}
	public List<Node> nodes;
	public Dag(int n) {
	    nodes = new ArrayList<Main.Dag.Node>();
	    for (int i = 0; i < n; ++i) {
		nodes.add(new Node(i));
	    }
	}
	public void addEdge(int from, int to) {
	    nodes.get(from).jacent.add(nodes.get(to));
	    nodes.get(to).indegree++;
	}
	public boolean validate() {
	    List<Node> sorted = new ArrayList<Node>();
	    Queue<Node> noIndegrees = new LinkedList<Node>();
	    for (Node node : nodes)
		if (node.indegree == 0)
		    noIndegrees.offer(node);
	    while (!noIndegrees.isEmpty()) {
		Node node = noIndegrees.poll();
		sorted.add(node);
		for (Node jacent : node.jacent) 
		    if (--jacent.indegree == 0)
			noIndegrees.offer(jacent);
	    }
	    if (sorted.size() == nodes.size()) return true;
	    else return false;
	}
    }
    
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int t = scanner.nextInt();
	while (t-- > 0) {
	    int n = scanner.nextInt();
	    Dag dag = new Dag(n);
	    int m = scanner.nextInt();
	    while (m-- > 0) {
		int from = scanner.nextInt()-1;
		int to = scanner.nextInt()-1;
		dag.addEdge(from, to);
	    }
	    if (dag.validate())
		System.out.println("Correct");
	    else 
		System.out.println("Wrong");
	}
	scanner.close();
    }

    
}
