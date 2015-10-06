package yjy.hiho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(n<3){
        	return r;
        }
        Arrays.sort(nums);
        int _1st = nums[0]+123;
        P0:for(int k=0;k<n-2;k++){
        	while(_1st==nums[k]){
        		k++;
        		if(k>=n-2)
            		break P0;
        	}
        	_1st = nums[k];
        	int i = k+1;
        	int j = n-1;
        	int target = -_1st;
        	P1:while(i<j){
        		int sum = nums[i]+nums[j];
        		if(sum==target){
        			ArrayList<Integer> newArray = new ArrayList<Integer>();
        			newArray.add(_1st);
        			newArray.add(nums[i]);
        			newArray.add(nums[j]);
        			r.add(newArray);
        			int cur = nums[i];
        			while(nums[i]==cur){
        				i++;
        				if(i>=j)
                    		break P1;
        			}
        			continue;
        		}else if(sum<target){
        			i++;
        		}else{
        			j--;
        		}
        	}
        }
        return r;
    }
	public static void main(String[] args) {
		_3Sum s = new _3Sum();
//		int[] nums = {-1, 0, 1, 2, -1, -4};
		int [] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		List<List<Integer>> L = s.threeSum(nums);
		for(List<Integer> l : L){
			for(Integer i:l){
				System.out.print(String.format("%d ",i));
			}
			System.out.println("");
		}
	}

}
