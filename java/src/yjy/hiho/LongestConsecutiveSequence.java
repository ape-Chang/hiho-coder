package yjy.hiho;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
    	int max = 0;
    	int n = nums.length;
    	if(n==0)return 0;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<n;i++){
    		int length = 0;
    		if(!map.containsKey(nums[i])){
    			Integer left = map.get(nums[i]-1);
    			Integer right = map.get(nums[i]+1);
    			if(left==null && right==null){
    				length = 1;
    				map.put(nums[i],length);
    			}else if(left!=null && right==null){
    				length = left+1;
    				map.put(nums[i],length);
    				map.put(nums[i]-left,length);
    			}else if(left==null && right!=null){
    				length = right+1;
    				map.put(nums[i],length);
    				map.put(nums[i]+right,length);
    			}else if(left!=null && right!=null){
    				length = left+right+1;
    				map.put(nums[i],length);
    				map.put(nums[i]-left,length);
    				map.put(nums[i]+right,length);
    			}
    		}
    		max = Math.max(max,length);
    	}
        return max;
    }
	public static void main(String[] args) {
		LongestConsecutiveSequence s = new LongestConsecutiveSequence();
		int[] nums = {100,4,200,1,3,2};
		int r = s.longestConsecutive(nums);
		System.out.println(r);
	}

}
