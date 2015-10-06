package yjy.hiho;

import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	Integer tmp1 = map.get(nums[i]);
        	if(tmp1==null){
        		tmp1 = 1;
        		map.put(nums[i],tmp1);
        	}else if(tmp1>0){
        		return true;
        	}else{
        		map.put(nums[i],1);
        	}
        	if(i-k>=0){
        		map.put(nums[i-k],map.get(nums[i-k])-1);
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		ContainsDuplicateII s = new ContainsDuplicateII();
		int[] nums = {2,34,22,6,2,13,7};
		System.out.println(s.containsNearbyDuplicate(nums,3));
	}
}
