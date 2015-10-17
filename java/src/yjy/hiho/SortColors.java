package yjy.hiho;

public class SortColors {

	public void sortColors(int[] nums) {
		int n = nums.length;
        int i=0;
        int j=n-1;
        while(i<n && nums[i]==0){
        	i++;
        }
        
        while(j>=0 && nums[j]==2){
        	j--;
        }
        int k = 0;
        while(k<n){
        	switch(nums[k]){
        	case 0:
        		if(k>=i){
        			nums[k] = nums[i];
            		nums[i] = 0;
            		while(i<n && nums[i]==0 ){
            			i++;
            		}
        		}else{
        			k++;
        		}
        		break;
        	case 1:
        		k++;
        		break;
        	case 2:
        		if(k<=j){
        			nums[k] = nums[j];
            		nums[j] = 2;
            		while(j>=0 && nums[j]==2){
            			j--;
            		}
        		}else{
        			return;
        		}
        		
        		break;
        	}
        }
    }
	
	public static void main(String[] args) {
		SortColors s = new SortColors();
		int[] nums = {2};
		s.sortColors(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}

}
