package yjy.hiho;

public class SearchForARange {
	
	public int[] searchRange(int[] nums, int target) {
		int[] r = {-1,-1};
		int n = nums.length;
		int i=0,j=n-1;
		int base = -1;
		while(i<=j){
			if(i==j){
				if(nums[i]==target){
					base = i;
				}
				break;
			}
			int mid = (i+j)/2;
			if(nums[mid]==target){
				base = mid;
				break;
			}else if(nums[mid]>target){
				j=mid-1;
			}else if(nums[mid]<target){
				i=mid+1;
			}
		}
		if(base==-1){
			return r;
		}
		// left
		if(base==0 || nums[0]==target){
			r[0]=0;
		}else{
			i=0;
			j=base;
			while(i<=j){
				if(i==j){
					if(nums[i]==target && nums[i-1]!=target){
						r[0] = i;
					}
					break;
				}
				int mid = (i+j)/2;
				if(nums[mid]==target && nums[mid-1]!=target){
					r[0] = mid;
					break;
				}else if(nums[mid]==target && nums[mid-1]==target){
					j=mid-1;
				}else if(nums[mid]<target){
					i=mid+1;
				}
			}
		}
		//right
		if(base==n-1 || nums[n-1]==target){
			r[1]=n-1;
		}else{
			i=base;
			j=n-1;
			while(i<=j){
				if(i==j){
					if(nums[i]==target && nums[i+1]!=target){
						r[1] = i;
					}
					break;
				}
				int mid = (i+j)/2;
				if(nums[mid]==target && nums[mid+1]!=target){
					r[1] = mid;
					break;
				}else if(nums[mid]>target){
					j=mid-1;
				}else if(nums[mid]==target && nums[mid+1]==target){
					i=mid+1;
				}
			}
		}
        return r;
    }

	public static void main(String[] args) {
		SearchForARange s = new SearchForARange();
		int[] nums = {5, 7, 7, 8, 8,9,9,9,9, 10};
		int[] range = s.searchRange(nums, 9);
		System.out.println(String.format("%d %d",range[0],range[1]));
	}

}
