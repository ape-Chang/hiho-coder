package yjy.hiho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Subsets {
	private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
    	this.nums = nums;
    	Arrays.sort(this.nums);
    	ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
    	int n = nums.length;
    	this.generate(0,n-1,new Stack<Integer>(),r);
    	r.add(new ArrayList<Integer>());
        return r;
    }
    
    public void generate(int i,int j,Stack<Integer> have,List<List<Integer>> L){
    	if(i>j+1){
    		return;
    	}
		boolean needpop = false;
		if(i<nums.length){
			have.push(nums[i]);
			ArrayList<Integer> com = new ArrayList<Integer>(have);
			L.add(com);
			needpop = true;
		}
    	this.generate(i+1, j,have, L);
    	if(needpop){
    		have.pop();
    	}
    	this.generate(i+1, j,have, L);
    }
    
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] nums = {1,3,2};
		List<List<Integer>> r = s.subsets(nums);
		for(List<Integer> l : r){
			for(Integer i : l){
				System.out.print(String.format("%d\t",i));
			}
			System.out.println("");
		}
		System.out.println(r.size());
	}

}
