package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

	class Node{
		Node parent;
		private Node[] chs;
		String word;
		private int cCount;
		private char val;
		Node(Node parent,char val){
			this.val = val;
			this.parent = parent;
			this.chs = new Node[26];
			this.word = null;
			this.cCount = 0;
		}
		
		void setChild(char c,Node ch){
			this.chs[c-'a'] = ch;
			cCount++;
		}
		
		void unSetChild(char c){
			this.chs[c-'a'] = null;
			cCount--;
		}
		
		int getChNum(){
			return cCount;
		}
		
		Node getChild(char c){
			return this.chs[c-'a'];
		}
		
		void pruning(){
			if(this.cCount==0 && this.parent!=null){
				this.parent.unSetChild(this.val);
				this.parent.pruning();
			}
		}
	}
	
	private int n;
	private int m;
	
	
	void dfs(Node cur,int i,int j,List<String> r,char[][] board,boolean[][] flag){
		if(flag[i][j]==true){return;}
		Node next = cur.getChild(board[i][j]);
		if(next==null){return;}
		flag[i][j] = true;
		if(next.word!=null){
			r.add(next.word);
			next.word = null;
			next.pruning();
		}
		if(i+1<n){dfs(next,i+1,j,r,board,flag);}
		if(i-1>=0){dfs(next,i-1,j,r,board,flag);}
		if(j+1<m){dfs(next,i,j+1,r,board,flag);}
		if(j-1>=0){dfs(next,i,j-1,r,board,flag);}
		flag[i][j] = false;
	}
	
    public List<String> findWords(char[][] board, String[] words) {
    	ArrayList<String> r = new ArrayList<String>();
    	Node root = new Node(null,'#');
    	int N = words.length;
    	for(int i=0;i<N;i++){
    		int k = words[i].length();
    		Node cur = root;
    		for(int j=0;j<k;j++){
    			char c = words[i].charAt(j);
    			Node ch = cur.getChild(c);
    			if(ch==null){
    				ch = new Node(cur,c);
    				cur.setChild(c, ch);
    			}
    			cur = ch;
    		}
    		cur.word = words[i];
    	}
    	n = board.length;
    	if(n==0){return r;}
    	m = board[0].length;
    	if(m==0){return r;}
    	boolean[][] flag = new boolean[n][m];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<m;j++){
    			this.dfs(root,i,j,r,board,flag);
    		}
    	}
    	return r;
    }
    
	public static void main(String[] args) {
		WordSearchII s = new WordSearchII();
		char[][] board = {
		                  {'o','a','a','n'},
		                  {'e','t','a','e'},
		                  {'i','h','k','r'},
		                  {'i','f','l','v'}
		                  };
		String[] words = {"oath","pea","eat","rain"};
		List<String> r = s.findWords(board, words);
		for(String ss : r){
			System.out.println(ss);
		}
	}

}
