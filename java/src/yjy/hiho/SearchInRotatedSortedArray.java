package yjy.hiho;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int t) {
        int n = nums.length;
        if(n==0)return -1;
        if(nums[0]==t){
        	return 0;
        }else if(nums[0]>t){
        	int max = nums[0];
        	int i = 0;
        	int j = n-1;
        	while(i<=j){
        		if(i==j){
        			if(nums[i]==t){return i;}else{return -1;}
        		}
        		int mid = (i+j)/2;
        		if(nums[mid]==t){
        			return mid;
        		}else if(nums[mid]<t||nums[mid]>=max){
        			i = mid+1;
        		}else{
        			j = mid-1;
        		}
        	}
        }else{
        	int min = nums[0];
        	int i = 0;
        	int j = n-1;
        	while(i<=j){
        		if(i==j){
        			if(nums[i]==t){return i;}else{return -1;}
        		}
        		int mid = (i+j)/2;
        		if(nums[mid]==t){
        			return mid;
        		}else if(nums[mid]<min || nums[mid]>t){
        			j = mid-1;
        		}else{
        			i = mid+1;
        		}
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		int[] nums = {4, 3};
		int r = s.search(nums,4);
		System.out.println(r);
	}

}
