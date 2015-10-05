package yjy.hiho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MajorityElementII {
	
    public List<Integer> majorityElement(int[] nums) {
        HashSet<Integer> r = new HashSet<Integer>();
        
        int n = nums.length;
        if(n==2){
        	r.add(nums[0]);
        	r.add(nums[1]);
        	return new ArrayList<Integer>(r);
        }else if(n==1){
        	r.add(nums[0]);
        	return new ArrayList<Integer>(r);
        }else if(n==0){
        	return new ArrayList<Integer>(r);
        }
        int k1=0,k2=0,n1=0,n2=0;
        for(int i=0;i<n;i++){
        	if(nums[i]==n1){
        		k1++;
        		continue;
        	}
        	if(nums[i]==n2){
        		k2++;
        		continue;
        	}
        	if(k1==0){
        		n1=nums[i];
        		k1=1;
        		continue;
        	}
        	if(k2==0){
        		n2=nums[i];
        		k2=1;
        		continue;
        	}
        	k1--;
        	k2--;
        }
        int count=0;
        for(int i=0;i<n;i++){
        	if(nums[i]==n1)
        		count++;
        }
        if(count>n/3)
        	r.add(n1);
        count=0;
        for(int i=0;i<n;i++){
        	if(nums[i]==n2)
        		count++;
        }
        if(count>n/3)
        	r.add(n2);
        return new ArrayList<Integer>(r);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
