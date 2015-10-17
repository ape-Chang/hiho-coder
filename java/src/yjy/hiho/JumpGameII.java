package yjy.hiho;

public class JumpGameII {
	// Time Limit Exceeded
    public int jump1(int[] nums) {
    	int n = nums.length;
    	int[] times = new int[n];
    	for(int i=0;i<n;i++){
    		times[i] = n-1;
    	}
    	times[0]=0;
    	for(int i=0;i<n;i++){
    		for(int j=1;j<=nums[i];j++){
    			if(i+j>=n)break;
    			times[i+j] = Math.min(times[i+j],times[i]+1);
    		}
    	}
        return times[n-1];
    }
    
    public int jump(int[] nums) {
    	int n = nums.length;
    	if(n<=1)return 0;
    	int times = 0;
    	int bound = 0;
    	int newBound = 0;
    	int index = 0;
    	while(index<n){
    		while(index<=bound){
    			newBound = Math.max(newBound,nums[index]+index);
        		index++;
        	}
    		times++;
        	bound = newBound;
        	if(bound>=n-1)return times;
    	}
        return times-1;
    }
    
	public static void main(String[] args) {
		JumpGameII s = new JumpGameII();
		int[] nums = {2,3,1,1,4,5};
		int r = s.jump(nums);
		System.out.println(r);
	}

}
