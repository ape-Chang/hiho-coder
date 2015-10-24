package yjy.hiho;

public class WordSearch {
	
	private int n;
	private int m;
	private boolean[][] visited;
	private char[][] board;
	boolean dfs(String word,int index,int i,int j){
		if(visited[i][j]==true){return false;}
		char c = word.charAt(index);
		if(c==board[i][j]){
			if(index+1==word.length()){
				return true;
			}
			visited[i][j] = true;
			if(i-1>=0){
				boolean r = dfs(word,index+1,i-1,j);
				if(r){return true;}
			}
			if(i+1<n){
				boolean r = dfs(word,index+1,i+1,j);
				if(r){return true;}
			}
			if(j-1>=0){
				boolean r = dfs(word,index+1,i,j-1);
				if(r){return true;}
			}
			if(j+1<m){
				boolean r = dfs(word,index+1,i,j+1);
				if(r){return true;}
			}
			visited[i][j] = false;
		}else{
			return false;
		}
		return false;
	}
	
    public boolean exist(char[][] board, String word) {
    	n = board.length;
    	if(n==0)return false;
    	m = board[0].length;
    	this.board = board;
    	this.visited = new boolean[n][m];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<m;j++){
    			boolean r = dfs(word,0,i,j);
    			if(r){return true;}
    		}
    	}
        return false;
    }
    
	public static void main(String[] args) {
		WordSearch s = new WordSearch();
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
			};
		boolean r = s.exist(board, "F");
		System.out.println(r);
	}

}
