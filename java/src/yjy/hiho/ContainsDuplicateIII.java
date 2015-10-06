package yjy.hiho;

import java.util.TreeSet;

public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	int n = nums.length;
    	TreeSet<Long> set = new TreeSet<Long>();
    	for(int i=0;i<n;i++){
    		Long floor = set.floor(new Long(nums[i]+t));
    		if(floor!=null && floor>=nums[i]-t){
    			return true;
    		}else{
    			set.add(new Long(nums[i]));
    		}
    		if(i>=k){
    			set.remove(new Long(nums[i-k]));
    		}
    	}
        return false;
    }
	
	public static void main(String[] args) {
		ContainsDuplicateIII s = new ContainsDuplicateIII();
		int[] nums = {4,15};
		boolean r = s.containsNearbyAlmostDuplicate(nums,3,3);
		System.out.println(r);
	}

}
