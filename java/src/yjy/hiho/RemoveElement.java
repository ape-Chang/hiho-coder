package yjy.hiho;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
    	int n = nums.length;
    	int tail = n-1;
    	for(int i=n-1;i>=0;i--){
    		if(nums[i]==val){
    			nums[i] = nums[tail];
    			tail--;
    		}
    	}
        return tail+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
