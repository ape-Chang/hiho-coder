package yjy.hiho;

public class HouseRobber {
    public int rob(int[] nums) {
    	int n =nums.length;
    	if(n==0){
    		return 0;
    	}else if(n==1){
    		return nums[0];
    	}else if(n==2){
    		return Math.max(nums[0],nums[1]);
    	}
    	
    	int a = nums[0];
    	int b = Math.max(nums[0],nums[1]);
    	int c = 0;
    	for(int i=2;i<n;i++){
    		c = Math.max(a+nums[i],b);
    		a = b;
    		b = c;
    	}
        return c;
    }

	public static void main(String[] args) {
		HouseRobber s = new HouseRobber();
		int[] nums = {2,1,1,2};
		int r = s.rob(nums);
		System.out.println(r);
	}

}
