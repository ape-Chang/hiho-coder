package yjy.hiho;

public class SingleNumber {

	public int singleNumber(int[] nums) {
		int r = 0;
		int N = nums.length;
		for(int i=0;i<N;i++){
			r = r^nums[i];
		}
        return r;
    }
	
	public static void main(String[] args) {
		SingleNumber s = new SingleNumber();
		int[] nums = {11,11,12,12,13,13,14};
		int r = s.singleNumber(nums);
		System.out.println(r);
	}

}
