package ape.chang;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ape.chang.Main.DAG.Node;

public class Main {
  
  static class DAG {
    static class Node {
      public int id;
      public int virus;
      public int indegree;
      public Node(int id) {this.id = id;}
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
    
    public void setNodeNumber(int n) {
      nodes.clear();
      for (int i = 1; i <= n; ++i) {
        nodes.add(new Node(i));
        edges.put(i, new ArrayList<Node>());
      }
    }
    
    public Node getNode(int id) {return nodes.get(id-1);}
    
    public DAG() {
      nodes = new ArrayList<Main.DAG.Node>();
      edges = new HashMap<Integer, List<Node>>();
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
        for (Node jacent : edges.get(node.id)) 
          if (--jacent.indegree == 0)
            noIndegrees.add(jacent);
      }
      
      for (Integer id : edges.keySet()) 
        for (Node jacent : edges.get(id))
          jacent.indegree++;
      
      nodes = sorted;
    }
  };

  public static void main(String[] args) {
    try {System.setIn(new FileInputStream("input"));} catch (Exception e) {return;}
    Scanner scanner = new Scanner(System.in);
    
    DAG dag = new DAG();
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    dag.setNodeNumber(n);
    while (k-- > 0) dag.getNode(scanner.nextInt()).virus++;
    while (m-- > 0) dag.addEdge(scanner.nextInt(), scanner.nextInt());
    scanner.close();
    dag.topoSort();
    
    for (Node node : dag.nodes) 
      for (Node jacent : dag.edges.get(node.id))
        jacent.virus += node.virus;
    
    int virus = 0;
    for (Node node : dag.nodes) {
      virus += node.virus;
      if (virus >= 142857) 
        virus %= 142857;
    }
    System.out.println(virus);
  }
  
}
