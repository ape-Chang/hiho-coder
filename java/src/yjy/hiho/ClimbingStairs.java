package yjy.hiho;

public class ClimbingStairs {
	public int climbStairs(int n) {
        int cur=1,last,llast;
        if(n==0 || n==1){return cur;}
        last = 1;
        llast = 1;
        for(int i=2;i<=n;i++){
        	cur = last + llast;
        	llast = last;
        	last = cur;
        }
        return cur;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
