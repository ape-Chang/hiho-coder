package yjy.hiho;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
    	ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
    	this.generate(1,n,k,new Stack<Integer>(),r);
        return r;
    }
    
    public void generate(int i,int j,int k,Stack<Integer> have,List<List<Integer>> L){
    	if(i>j+1 || (j-i+1)<k){
    		return;
    	}
    	if(k==0){
    		ArrayList<Integer> com = new ArrayList<Integer>(have);
    		L.add(com);
    		return;
    	}
    	have.push(i);
    	this.generate(i+1, j, k-1, have, L);
    	have.pop();
    	this.generate(i+1, j, k, have, L);
    }
	
	public static void main(String[] args) {
		Combinations s = new Combinations();
		List<List<Integer>> r = s.combine(1,1);
		int ii =0;
		ii++;
	}

}
