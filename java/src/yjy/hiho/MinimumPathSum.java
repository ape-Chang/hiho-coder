package yjy.hiho;

public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] c = new int[m][n];
		c[0][0] = grid[0][0];
		for(int i=1;i<m;i++){
			c[i][0] = c[i-1][0]+grid[i][0];
		}
		for(int j=1;j<n;j++){
			c[0][j] = c[0][j-1]+grid[0][j];
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				c[i][j] = grid[i][j] + Math.min(c[i][j-1],c[i-1][j]);
			}
		}
        return c[m-1][n-1];
    }

	public static void main(String[] args) {
		MinimumPathSum s = new MinimumPathSum();
		int[][] grid = 
				{{1,2,3},
				{3,2,1},
				{2,1,3}};
		int r = s.minPathSum(grid);
		System.out.println(r);
	}

}
