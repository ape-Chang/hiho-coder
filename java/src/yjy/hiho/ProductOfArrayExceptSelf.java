package yjy.hiho;

public class ProductOfArrayExceptSelf {
	
	public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n<=1){
        	int [] tmp = {1};
        	return tmp;
        }
        int[] pre = new int[n];
        int[] tail = new int[n];
        pre[0]=nums[0];
        tail[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
        	pre[i] = pre[i-1]*nums[i];
        }
        for(int i=n-2;i>=0;i--){
        	tail[i] = tail[i+1]*nums[i];
        }
        
        for(int i=1;i<n;i++){
        	pre[i] = pre[i-1]*nums[i];
        }
        int [] out = new int[n];
        out[0]=tail[1];
        out[n-1]=pre[n-2];
        for(int i=1;i<=n-2;i++){
        	out[i] = pre[i-1]*tail[i+1];
        }
        return out;
    }

	public static void main(String[] args) {
		ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();
		int[] nums = {1,2};
		int[] r = s.productExceptSelf(nums);
		for(int i=0;i<r.length;i++){
			System.out.println(r[i]);
		}
	}

}
