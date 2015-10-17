package yjy.hiho;

import java.util.Arrays;

public class _3SumClosest {
	
    public int threeSumClosest(int[] nums, int target) {
    	int n = nums.length;
    	if(n<3){
    		return -100;
    	}
    	Arrays.sort(nums);
    	int R = nums[0]+nums[1]+nums[2];
    	int min = Math.abs(R-target);
    	for(int i=0;i<n;i++){
    		int first = nums[i];
    		int low = i+1;
    		int high = n-1;
    		while(low<high){
    			int sum = first+nums[low]+nums[high];
    			if(Math.abs(sum-target)<min){
    				R = sum;
    				min = Math.abs(sum-target);
    			}
    			if(sum==target){
    				return target;
    			}else if(sum<target){
    				low++;
    			}else if(sum>target){
    				high--;
    			}
    		}
    	}
        return R;
    }

	public static void main(String[] args) {
		int[] nums = {-3,-2,-5,3,-4};
		_3SumClosest s = new _3SumClosest();
		int r = s.threeSumClosest(nums, -1);
		System.out.println(r);
	}

}
