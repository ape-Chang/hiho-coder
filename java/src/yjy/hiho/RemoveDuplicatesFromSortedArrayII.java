package yjy.hiho;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
    	int cur = 0;
		int n = nums.length;
		if(n<=1){
			return n;
		}
		boolean twoStrike = false;
		for(int i=1;i<n;i++){
			if(nums[cur]==nums[i]){
				if(twoStrike){
					continue;
				}else{
					twoStrike = true;
					cur++;
					nums[cur]=nums[i];
				}
			}else{
				twoStrike = false;
				cur++;
				nums[cur]=nums[i];
			}
		}
        return cur+1;
    }
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII s = new RemoveDuplicatesFromSortedArrayII();
		int[] nums = {1,2,3,3,4,5,6,6,6,6,6,7,8,9};
		int n = s.removeDuplicates(nums);
		for(int i=0;i<n;i++){
			System.out.println(nums[i]);
		}
	}

}
