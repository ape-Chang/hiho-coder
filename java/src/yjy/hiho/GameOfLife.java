package yjy.hiho;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int n = board.length;
        if(n==0){return;}
        int m = board[0].length;
        if(m==0){return;}
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		int count = 0;
        		for(int p=i-1;p<=i+1;p++){
        			for(int q=j-1;q<=j+1;q++){
        				if(p>=0&&p<n&&q>=0&&q<m&&(p!=i||q!=j)){
        					count+=board[p][q]&1;
        				}
        			}
        		}
        		if(board[i][j]==1){
        			if(count==2||count==3){
        				board[i][j]+=2;
        			}
        		}else if(board[i][j]==0&&count==3){
        			board[i][j]+=2;
        		}
        	}
        }
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		board[i][j]=board[i][j]>>1;
        	}
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
