package yjy.hiho;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
    	int n = nums.length;
    	if(n==0){
    		return 0;
    	}
    	int i=0,j=0;
    	int sum = nums[0];
    	while(sum<s){
    		j++;
    		if(j<n){
    			sum+=nums[j];
    		}else{
    			return 0;
    		}
    	}
    	int min = j+1;
    	while(true){
    		while(sum>=s){
        		if(j-i+1<min){
        			min = j-i+1;
        		}
        		sum-=nums[i];
        		i++;
        	}
    		j++;
    		if(j<n){
    			sum+=nums[j];
    		}else{
    			break;
    		}
    	}
        return min;
    }
	public static void main(String[] args) {
		MinimumSizeSubarraySum s = new MinimumSizeSubarraySum();
		int[] nums = {2,3,1,2,4,3};
		int r = s.minSubArrayLen(7,nums);
		System.out.println(r);
	}

}
