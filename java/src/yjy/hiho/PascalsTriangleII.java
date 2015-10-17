package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int n) {
    	n++;
        ArrayList<Integer> r = new ArrayList<Integer>();
        if(n==0){return r;}
        r.add(1);
        if(n==1){return r;}
        for(int i=2;i<=n;i++){
        	for(int j=i-2;j>=1;j--){
        		r.set(j,r.get(j-1)+r.get(j));
        	}
        	r.add(1);
        }
        return r;
    }
	public static void main(String[] args) {
		PascalsTriangleII s = new PascalsTriangleII();
		List<Integer> r = s.getRow(3);
		for(Integer i:r){
			System.out.print(String.format("%d ",i));
		}
	}

}
