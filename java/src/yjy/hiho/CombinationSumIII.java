package yjy.hiho;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSumIII {
	
	private int targetN;
	
    public List<List<Integer>> combinationSum3(int k, int n) {
    	ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
    	this.targetN = n;
    	this.generate(1,9,k,new Stack<Integer>(),0,r);
        return r;
    }
	
	public void generate(int i,int j,int k,Stack<Integer> have,int sum,List<List<Integer>> L){
    	if(i>j+1 || (j-i+1)<k){
    		return;
    	}
    	if(k==0){
    		if(sum==this.targetN){
    			ArrayList<Integer> com = new ArrayList<Integer>(have);
        		L.add(com);
    		}
    		return;
    	}
    	have.push(i);
    	this.generate(i+1, j, k-1, have, sum+i, L);
    	have.pop();
    	this.generate(i+1, j, k, have, sum, L);
    }

	public static void main(String[] args) {
		CombinationSumIII s = new CombinationSumIII();
		List<List<Integer>> r = s.combinationSum3(3, 9);
		int ii=0;
		ii++;
	}

}
