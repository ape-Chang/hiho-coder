package ape.chang;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  
  static class DAG {
    static class Node {
      public int id;
      public int virus;
      public int indegree;
      public int outdegree;
      public Node(int id) {this.id = id;}
    };
    static class Edge {
      public Node from;
      public Node to;
      public Edge(Node from, Node to) {this.from = from; this.to = to;}
    };
    
    private List<Node> nodes;
    private Set<Edge> edges;
    private Map<Integer, List<Node>> edges1;
    
    public void addEdge(int from, int to) {
      nodes.get(from-1).outdegree++;
      nodes.get(to-1).indegree++;
      edges.add(new Edge(nodes.get(from-1), nodes.get(to-1)));
    }
    
    public void setNodeNumber(int n) {
      nodes.clear();
      for (int i = 1; i <= n; ++i)
        nodes.add(new Node(i));
    }
    
    public Node getNode(int id) {return nodes.get(id-1);}
    
    public DAG() {
      nodes = new ArrayList<Main.DAG.Node>();
      edges = new HashSet<Main.DAG.Edge>();
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
        for (Edge edge : edges)
          if (node == edge.from) 
            if (--edge.to.indegree == 0)
              noIndegrees.offer(edge.to);
      }
    }
  };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    DAG dag = new DAG();
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    dag.setNodeNumber(n);
    while (k-- > 0) dag.getNode(scanner.nextInt()).virus++;
    while (m-- > 0) dag.addEdge(scanner.nextInt(), scanner.nextInt());
    dag.topoSort();
    scanner.close();
  }
  
}
