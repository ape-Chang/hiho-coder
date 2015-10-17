package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int n) {
    	ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
    	if(n==0)return r;
    	ArrayList<Integer> row = new ArrayList<Integer>();
    	ArrayList<Integer> last = row;
    	row.add(1);r.add(row);
    	int curRow = 2;
    	while(curRow<=n){
    		row = new ArrayList<Integer>();
    		row.add(1);
    		for(int i=1;i<curRow-1;i++){
    			row.add(last.get(i-1)+last.get(i));
    		}
    		row.add(1);
    		r.add(row);
    		last = row;
    		curRow++;
    	}
        return r;
    }
	
	public static void main(String[] args) {
		PascalsTriangle s = new PascalsTriangle();
		List<List<Integer>> r = s.generate(5);
		for(List<Integer> l:r){
    		for(Integer i:l){
    			System.out.print(String.format("%d ",i));
    		}
    		System.out.println("");
    	}
	}

}
