package ape.chang;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
  
  static class UndiredctedGraph {
    enum Color {White, Black, Uncolored}
    static class Node {
      public int id;
      public List<Node> jacent;
      public Node(int id) {
        this.id = id; 
        jacent = new ArrayList<Node>();
        color = Color.Uncolored;
      }
      // extra
      public Color color; // 1 for white, -1 for black, 0 for uncolored
    }
    public List<Node> nodes;
    public UndiredctedGraph(int n) {
      nodes = new ArrayList<Node>();
      for (int i = 0; i < n; ++i)
        nodes.add(new Node(i));
    }
    public void addEdge(int from, int to) {
      nodes.get(from).jacent.add(nodes.get(to));
      nodes.get(to).jacent.add(nodes.get(from));
    }
    public boolean isBipartite() {
      try {
        color(nodes.get(0), Color.Black);
        return true;
      } catch(Exception e) {
        return false;
      }
    }
    private void color(Node node, Color color) {
      if (node.color == color) ;
    }
  }
  
  public static void main(String[] args) {
    try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
    Scanner scanner = new Scanner(System.in);
    
    scanner.close();
  }
  
}
