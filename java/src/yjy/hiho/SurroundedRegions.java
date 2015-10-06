package yjy.hiho;

import java.util.LinkedList;

public class SurroundedRegions {
	class Node{
		int i;
		int j;
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
    public void solve(char[][] b) {
        int m = b.length;
        if(m==0)
        	return;
        int n = b[0].length;
        if(n==0)
        	return;
        LinkedList<Node> Q = new LinkedList<Node>();
        for(int i=0;i<m;i++){
        	if(b[i][0]=='O'){
        		b[i][0]='V';
        		Q.add(new Node(i,0));
        	}
        	if(b[i][n-1]=='O'){
        		b[i][n-1]='V';
        		Q.add(new Node(i,n-1));
        	}
        }
        for(int i=0;i<n;i++){
        	if(b[0][i]=='O'){
        		b[0][i]='V';
        		Q.add(new Node(0,i));
        	}
        	if(b[m-1][i]=='O'){
        		b[m-1][i]='V';
        		Q.add(new Node(m-1,i));
        	}
        }
        while(!Q.isEmpty()){
        	Node node = Q.poll();
        	int i = node.i;
        	int j = node.j;
        	if(i-1>=0 && b[i-1][j]=='O'){
        		b[i-1][j]='V';
        		Q.add(new Node(i-1,j));
        	}
        	if(i+1<=m-1 && b[i+1][j]=='O'){
        		b[i+1][j]='V';
        		Q.add(new Node(i+1,j));
        	}
        	if(j-1>=0 && b[i][j-1]=='O'){
        		b[i][j-1]='V';
        		Q.add(new Node(i,j-1));
        	}
        	if(j+1<=n-1 && b[i][j+1]=='O'){
        		b[i][j+1]='V';
        		Q.add(new Node(i,j+1));
        	}
        }
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		switch(b[i][j]){
        		case 'V':b[i][j]='O';break;
        		case 'O':b[i][j]='X';break;
        		}
        	}
        }
    }

	public static void main(String[] args) {
		SurroundedRegions s = new SurroundedRegions();
		char[][] b = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'},
		};
		s.solve(b);
		for(int i=0;i<b.length;i++){
        	for(int j=0;j<b[0].length;j++){
        		System.out.print(String.format("%c ",b[i][j]));
        	}
        	System.out.println("");
        }
	}

}
