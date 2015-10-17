package yjy.hiho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 超时	
public class Permutations {
	
	public void visit(int[] nums,int base,List<List<Integer>> L){
		int n = nums.length;
		if(base>=n){
			return;
		}else if(base==n-1){
			List<Integer> l = new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				l.add(nums[i]);
			}
			L.add(l);
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		this.visit(nums,base+1,L);
		for(int i=base+1;i<n;i++){
			int savei = nums[i];
			if(!set.contains(savei)){
				set.add(savei);
			}else{
				continue;
			}
			int savebase = nums[base];
			nums[i] = savebase;
			nums[base] = savei;
			this.visit(nums,base+1,L);
			nums[i] = savei;
			nums[base] = savebase;
		}
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> L = new ArrayList<List<Integer>>();
    	this.visit(nums,0,L);
        return L;
    }
	public static void main(String[] args) {
		Permutations s = new Permutations();
		int[] nums = {3,3,0,0,2,3,2};
		List<List<Integer>> L = s.permuteUnique(nums);
		for(List<Integer> l:L){
			for(Integer i:l){
				System.out.print(String.format("%d ",i));
			}
			System.out.println("");
		}
	}

}
