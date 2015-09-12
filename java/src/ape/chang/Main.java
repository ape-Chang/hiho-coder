package ape.chang;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  
  static class DAG {
    static class Node {
      public int id;
      public Node(int id) {this.id = id;}
      // extra
      public int virus;
      public int indegree; 
    };
    static class Edge {
      public Node from;
      public Node to;
      public Edge(Node from, Node to) {this.from = from; this.to = to;}
    };
    
    private List<Node> nodes;
    private Map<Integer, List<Node>> edges;
    
    public void addEdge(int from, int to) {
      nodes.get(to-1).indegree++;
      edges.get(from).add(nodes.get(to-1));
    }
    
    public Node getNode(int id) {return nodes.get(id-1);}
    
    public DAG(int n) {
      nodes = new ArrayList<Main.DAG.Node>();
      edges = new HashMap<Integer, List<Node>>();
      for (int i = 1; i <= n; ++i) {
        nodes.add(new Node(i));
        edges.put(i, new ArrayList<Node>());
      }
    }
    
    public void topoSort() {
      List<Node> sorted = new ArrayList<Main.DAG.Node>();
      Deque<Node> noIndegrees = new LinkedList<Main.DAG.Node>();
      for (Node node : nodes) 
        if (node.indegree == 0)
          noIndegrees.offer(node);
      
      while (!noIndegrees.isEmpty()) {
        Node node = noIndegrees.poll();
        sorted.add(node);
        for (Node jacent : edges.get(node.id)) {
          jacent.virus += node.virus;
          if (--jacent.indegree == 0)
            noIndegrees.add(jacent); 
        }
      }
      
      nodes = sorted;
    }
  };

  public static void main(String[] args) {
    try {System.setIn(new FileInputStream("input"));} catch (Exception e) {return;}
    Scanner scanner = new Scanner(System.in);
    
    int n = scanner.nextInt();
    DAG dag = new DAG(n);
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    while (k-- > 0) dag.getNode(scanner.nextInt()).virus++;
    while (m-- > 0) {
      int from = scanner.nextInt();
      int to = scanner.nextInt();
      dag.addEdge(from, to);
    } 
    scanner.close();
    dag.topoSort();
    
    int virus = 0;
    for (DAG.Node node : dag.nodes) {
      virus += node.virus;
      if (virus >= 142857) 
        virus %= 142857;
    }
    System.out.println(virus);
  }
  
}