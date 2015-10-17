package yjy.hiho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubsetsII {
	private int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
    	int count=0;
		if(i<nums.length){
			for(int p=i;p<=j;p++){
				if(nums[i]==nums[p]){
					have.push(nums[p]);
					ArrayList<Integer> com = new ArrayList<Integer>(have);
					L.add(com);
					count++;
				}else{
					break;
				}
			}
			this.generate(i+count, j,have, L);
	    	for(int q=0;q<count;q++){
	    		have.pop();
	    		this.generate(i+count, j,have, L);
	    	}
		}
    }
	public static void main(String[] args) {
		SubsetsII s = new SubsetsII();
		int[] nums = {1,2,2};
		List<List<Integer>> r = s.subsetsWithDup(nums);
		for(List<Integer> l : r){
			for(Integer i : l){
				System.out.print(String.format("%d\t",i));
			}
			System.out.println("");
		}
		System.out.println(r.size());
	}

}
