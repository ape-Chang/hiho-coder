package yjy.hiho;

public class SlidingWindowMaximum {
	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	int n = nums.length;
    	if(n==0){
    		int[] dummy = {};
    		return dummy;
    	}
    	int[] left = new int[n];
    	int max = 0;
    	for(int i=0;i<n;i++){
    		if(i%k==0){
    			max = nums[i];
    		}else{
    			max = Math.max(max,nums[i]);
    		}
    		left[i] = max;
    	}
    	int[] right = new int[n];
    	max = 0;
    	for(int i=n-1;i>=0;i--){
    		if(i%k==k-1){
    			max = nums[i];
    		}else{
    			max = Math.max(max,nums[i]);
    		}
    		right[i] = max;
    	}
    	int[] r = new int[n-k+1];
    	for(int i=0;i<n-k+1;i++){
    		r[i] = Math.max(left[i+k-1],right[i]);
    	}
    	return r;
    }
	
	public static void main(String[] args) {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		int[] nums = {};
		int k = 0;
		int[] r = s.maxSlidingWindow(nums,k);
		for(int i=0;i<nums.length-k+1;i++){
			System.out.println(r[i]);
		}
	}

}
