package yjy.hiho;

public class FindMinimumInRotatedSortedArray {
	
	public int findMin(int[] nums) {
		int n = nums.length;
		if(n==1){
			return nums[0];
		}
		int pre = nums[0];
		for(int i=1;i<n;i++){
			if(nums[i]<pre){
				return nums[i];
			}
			pre = nums[i];
		} 
		return nums[0];
    }
	
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();
		int[] nums = {4 ,5 ,6 ,7 ,8 ,9 ,10};
		int r = s.findMin(nums);
		System.out.println(r);
	}

}
