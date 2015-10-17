package yjy.hiho;

public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
		int n =nums.length;
		if(n==1){
			return nums[0];
		}
		int[] A = new int[n];
		A[0] = nums[0];
		int max = A[0];
		for(int i=1;i<n;i++){
			if(A[i-1]>=0){
				A[i] = A[i-1]+nums[i];
			}else{
				A[i] = nums[i];
			}
			max = Math.max(max,A[i]);	
		}
        return max;
    }

	public static void main(String[] args) {
		MaximumSubarray s = new MaximumSubarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		int[] nums = {1};
		int r = s.maxSubArray(nums);
		System.out.println(r);
	}

}
