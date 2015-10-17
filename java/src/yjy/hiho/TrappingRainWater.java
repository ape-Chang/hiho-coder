package yjy.hiho;

public class TrappingRainWater {
	
    public int trap(int[] h) {
    	int n = h.length;
    	if(n==0)
    		return 0;
    	int max = h[0];
    	int maxi = 0;
    	for(int i=1;i<n;i++){
    		if(h[i]>max){
    			max = h[i];
    			maxi = i;
    		}
    	}
    	int r = 0;
    	int tmpMax = 0;
    	for(int i=0;i<maxi;i++){
    		if(h[i]<tmpMax){
    			r+=(tmpMax-h[i]);
    		}else{
    			tmpMax = h[i];
    		}
    	}
    	tmpMax = 0;
    	for(int i=n-1;i>maxi;i--){
    		if(h[i]<tmpMax){
    			r+=(tmpMax-h[i]);
    		}else{
    			tmpMax = h[i];
    		}
    	}
        return r;
    }

	public static void main(String[] args) {
		TrappingRainWater s = new TrappingRainWater();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int r = s.trap(height);
		System.out.println(r);
	}

}
