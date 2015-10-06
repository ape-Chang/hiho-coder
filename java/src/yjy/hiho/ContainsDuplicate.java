package yjy.hiho;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!set.add(nums[i]))
        		return true;
        }
        return false;
    }
	public static void main(String[] args) {
		ContainsDuplicate s = new ContainsDuplicate();
		int[] nums = {1,34,5,6,2,13,7};
		System.out.println(s.containsDuplicate(nums));
	}

}
