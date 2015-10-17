package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
	
    public int nthUglyNumber1(int n) {
    	long[] u = new long[n];
    	u[0] = 1;
    	long cur = u[0];
    	long[] p = {2,3,5};
    	for(int i=1;i<n;i++){
    		long min = u[i-1]*2;
    		for(int q=0;q<p.length;q++){
    			int k = 1;
    			while(i-k>=0&&u[i-k]*p[q]>cur){
    				min = Math.min(min,u[i-k]*p[q]);
    				k++;
    			}
    		}
    		u[i] = min;
    		cur = min;
    	}
    	return (int)u[n-1];
    }
    
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        int a=0,b=0,c=0;
        List<Integer> table = new ArrayList<Integer>();
        table.add(1);
        while(table.size()<n)
        {
            int next_val = Math.min(table.get(a)*2,Math.min(table.get(b)*3,table.get(c)*5));
            table.add(next_val);
            if(table.get(a)*2==next_val) a++;
            if(table.get(b)*3==next_val) b++;
            if(table.get(c)*5==next_val) c++;
        }
        return table.get(table.size()-1);
    }
    
	public static void main(String[] args) {
		UglyNumberII s = new UglyNumberII();
		for(int i=1;i<1500;i++){
			int r = s.nthUglyNumber(i);
			int r1 = s.nthUglyNumber1(i);
			if(r!=r1){
				System.out.println(String.format("%d %d",r,r1));
			}
		}
	}

}
