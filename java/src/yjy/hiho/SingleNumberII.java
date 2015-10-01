package yjy.hiho;

public class SingleNumberII {
	
	public int singleNumber(int[] nums) {
		int r = 0;
		int n = nums.length;
		for(int k=0;k<32;k++){
			int t = 0;
			for(int i=0;i<n;i++){
				t+=(nums[i]>>k)&1;
			}
			t = t%3;
			r+=(t<<k);
		}
        return r;
    }

	public static void main(String[] args) {
		SingleNumberII s = new SingleNumberII();
		int[] nums = {1,1,1,2,3,2,3,23,2,3};
		int r = s.singleNumber(nums);
		System.out.println(r);
	}

}
