package yjy.hiho;

import java.util.Stack;

public class NextPermutation {
	
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2){
        	return;
        }
        int base = -1;
        for(int i=n-2;i>=0;i--){
        	if(nums[i]<nums[i+1]){
        		base = i;
        		break;
        	}
        }
        if(base == -1){
        	Stack<Integer> s = new Stack<Integer>();
        	for(int i=0;i<n;i++)
        		s.add(nums[i]);
        	for(int i=0;i<n;i++)
        		nums[i] = s.pop();
        }else{
        	int i=base+1;
        	int j=n-1;
        	int p=-1;
        	while(i<=j){
        		if(i==j){
        			if(nums[i]>nums[base] && (i+1>=n||nums[i+1]<=nums[base])){
        				p=i;
        			}
        			break;
        		}
        		int mid = (i+j)/2;
        		if(nums[mid]>nums[base] && (mid+1>=n||nums[mid+1]<=nums[base])){
        			p = mid;
        			break;
        		}else if(nums[mid]>nums[base]){
        			i = mid+1;
        		}else{
        			j = mid-1;
        		}
        	}
        	if(p==-1){
        		return;
        	}
        	int tmp = nums[base];
        	nums[base] = nums[p];
        	nums[p] = tmp;
        	Stack<Integer> s = new Stack<Integer>();
        	for(int k=base+1;k<n;k++)
        		s.add(nums[k]);
        	for(int k=base+1;k<n;k++)
        		nums[k] = s.pop();
        }
    }

	public static void main(String[] args) {
		NextPermutation s = new NextPermutation();
		int[] nums = {1,2,3,4,6,11,10,9,8,7,5};
//		int[] nums = {1,2,3};
//		int[] nums = {1,1,5};
//		int[] nums = {3,2,1};
		s.nextPermutation(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}

}
