package yjy.hiho;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m+n-1;
        int i=m-1,j=n-1;
        while(i>=0 && j>=0){
        	if(nums1[i]>nums2[j]){
        		nums1[cur] = nums1[i];
        		i--;cur--;
        	}else{
        		nums1[cur] = nums2[j];
        		j--;cur--;
        	}
        }
        while(j>=0){
        	nums1[cur] = nums2[j];
        	j--;cur--;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
