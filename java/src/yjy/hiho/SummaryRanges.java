package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> r = new ArrayList<String>();
        int n = nums.length;
        if(n==0){
        	return r;
        }
        
        int begin = nums[0];
        int pre = nums[0];
        int end = nums[0];
        for(int i=1;i<n;i++){
        	if(pre+1==nums[i]){
        		end = nums[i];
        	}else{
        		if(begin==end){
        			r.add(Integer.toString(begin));
        		}else{
        			r.add(String.format("%d->%d",begin,end));
        		}
        		begin = nums[i];
        		end = nums[i];
        	}
        	pre = nums[i];
        }
        if(begin==end){
			r.add(Integer.toString(begin));
		}else{
			r.add(String.format("%d->%d",begin,end));
		}
        return r;
    }
	public static void main(String[] args) {
		SummaryRanges s = new SummaryRanges();
		int nums[] = {0,1,2,4,5,7};
		List<String> r = s.summaryRanges(nums);
		for(String ss : r){
			System.out.println(ss);
		}
	}

}
