package yjy.hiho;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int cur = 0;
		int n = nums.length;
		if(n<=1){
			return n;
		}
		for(int i=1;i<n;i++){
			if(nums[cur]==nums[i]){
				continue;
			}else{
				cur++;
				nums[cur]=nums[i];
			}
		}
        return cur+1;
    }
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
		int[] nums = {1,2,3,3,4,5,6,6,6,7,8,9};
		int n = s.removeDuplicates(nums);
		for(int i=0;i<n;i++){
			System.out.println(nums[i]);
		}
	}

}
