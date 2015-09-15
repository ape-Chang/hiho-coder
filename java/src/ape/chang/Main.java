package ape.chang;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    
    static class UGraph {
	public int[][] M;
	public UGraph(int n) {
	    M = new int[n][n];
	    for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
		    if (i == j)
			M[i][j] = 0;
		    else
			M[i][j] = Integer.MAX_VALUE;
	}
	public void addEdge(int from, int to, int length) {
	    M[from][to] = Math.min(M[from][to], length);
	    M[to][from] = M[from][to];
	}
	public int distance(int src, int dst) {
	    if (src == dst) return 0;
	    int n = M.length;
	    
	    int[] dist = new int[n];
	    for (int i = 0; i < dist.length; ++i)
		dist[i] = Integer.MAX_VALUE;
	    dist[src] = 0;
	    Set<Integer> visited = new HashSet<Integer>();

	    while (n-- > 0) {
		int x = 0, m = Integer.MAX_VALUE;
		for (int y = 0; y < dist.length; ++y)
		    if (!visited.contains(y) && dist[y] <= m)
			m = dist[x = y];
		visited.add(x);
		for (int y = 0; y < dist.length; ++y)
		    
		    if (M[x][y] == Integer.MAX_VALUE || dist[x] == Integer.MAX_VALUE)
			;
		    else
			dist[y] = Math.min(dist[y], dist[x] + M[x][y]);
	    }
	    return dist[dst];
	}
    }
    
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	int m = scanner.nextInt();
	int src = scanner.nextInt() - 1;
	int dst = scanner.nextInt() - 1;
	UGraph graph = new UGraph(n);
	while (m-- > 0) {
	    int from = scanner.nextInt() - 1;
	    int to = scanner.nextInt() - 1;
	    int length = scanner.nextInt();
	    graph.addEdge(from, to, length);
	}
	System.out.println(graph.distance(src, dst));
	scanner.close();
    }
}

