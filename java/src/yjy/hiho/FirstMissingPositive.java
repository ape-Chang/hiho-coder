package yjy.hiho;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    	int n = nums.length;
    	if(n==0)return 1;
    	int index=0;
    	while(true){
    		int val = nums[index];
    		if(val!=index+1 && val>0 && val<=n && val!=nums[val-1]){
    			nums[index] = nums[val-1];
    			nums[val-1] = val;
    		}else{
    			if(++index>=n)break;
    		}
    	}
    	for(int i=0;i<n;i++){
    		if((i+1)!=nums[i]){
    			return i+1;
    		}
    	}
        return n+1;
    }
	public static void main(String[] args) {
		FirstMissingPositive s = new FirstMissingPositive();
		int[] nums = {0,-1,3,1};
		int r = s.firstMissingPositive(nums);
		System.out.println(r);
	}

}
