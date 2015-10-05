package yjy.hiho;

import java.util.HashSet;

public class NumberOfIslands {
	
	class Node{
		Node p;
		int val;
		int count;
		Node(int val){
			this.val = val;
			this.count = 1;
			this.p = null;
		}
		
		Node getP(){
			Node cur = this;
			while(cur.p!=null){
				cur = cur.p;
			}
			return cur;
		}
		Node merge(Node n){
			if(n==null || this==n){
				return this;
			}
			if(this.count>n.count){
				n.p = this;
				this.count+=n.count;
				return this;
			}else{
				this.p = n;
				n.count+=this.count;
				return n;
			}
		}
	}
	
    public int numIslands(char[][] grid) {
    	int m = grid.length;
    	if(m==0){
    		return 0;
    	}
    	int n = grid[0].length;
    	if(n==0){
    		return 0;
    	}
    	Node[][] nodes = new Node[m][n];
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(grid[i][j]=='1'){
    				Node p = new Node(i*n+j);
    				nodes[i][j] = p;
    				if(i>0 && grid[i-1][j]=='1'){
    					p = p.merge(nodes[i-1][j].getP());
    				}
    				if(j>0 && grid[i][j-1]=='1'){
    					p = p.merge(nodes[i][j-1].getP());
    				}
    			}
    		}
    	}
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			Node p = nodes[i][j];
    			if(p!=null){
    				set.add(p.getP().val);
    			}
    		}
    	}
        return set.size();
    }

	public static void main(String[] args){
		NumberOfIslands s = new NumberOfIslands();
		char[][] grid = {
				{'1','1','0','1','0'},
				{'1','0','0','1','0'},
				{'1','1','1','1','0'},
				{'0','0','0','0','0'}
		};
		int r = s.numIslands(grid);
		System.out.println(r);
	}
}
