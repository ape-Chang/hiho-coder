package yjy.hiho;

public class Candy {
    public int candy(int[] ratings) {
    	int n = ratings.length;
    	if(n==0){return 0;}else if(n==1){return 1;}
    	int [] a = new int[n];
    	int [] b = new int[n];
    	a[0] = 1;
    	for(int i=1;i<n;i++){
    		if(ratings[i]<=ratings[i-1]){
    			a[i] = 1;
    		}else{
    			a[i]=a[i-1]+1;
    		}
    	}
    	b[n-1] = 1;
    	for(int i=n-2;i>=0;i--){
    		if(ratings[i]<=ratings[i+1]){
    			b[i] = 1;
    		}else{
    			b[i]=b[i+1]+1;
    		}
    	}
    	int r = 0;
    	for(int i=0;i<n;i++){
    		r += Math.max(a[i], b[i]);
    	}
        return r;
    }
	public static void main(String[] args) {
		Candy s = new Candy();
		int[] ratings = {1,23,4,5,66,7,7,7,4,2};
		int r = s.candy(ratings);
		System.out.println(r);
	}

}
