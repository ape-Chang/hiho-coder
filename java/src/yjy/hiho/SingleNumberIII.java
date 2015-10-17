package yjy.hiho;

import java.util.ArrayList;

public class SingleNumberIII {
	
	public int[] singleNumber(int[] nums) {
        int[] R = new int[2];
        int B = 0;
        int N = nums.length;
        for(int i=0;i<N;i++){
        	B = B^nums[i];
        }
        if(B==0){
        	return null;
        }
        
        int count = 0;
        while(B%2==0){
        	B = B>>1;
        	count++;
        }

        for(int i=0;i<N;i++){
        	int s = nums[i]>>count;
        	if(s%2==0){
        		R[0] = R[0]^nums[i];
        	}else{
        		R[1] = R[1]^nums[i];
        	}
        }
        return R;
    }
	
	public static void main(String[] args){
		
		SingleNumberIII s = new SingleNumberIII();
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] R = s.singleNumber(nums);
		for(int i=0;i<R.length;i++){
			System.out.println(R[i]);
		}
	}
}
