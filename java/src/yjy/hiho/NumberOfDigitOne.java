package yjy.hiho;

public class NumberOfDigitOne {
	
    public int countDigitOne(int n) {
    	int k = n;
    	int m = 0;
    	while(k>0){
    		k = k/10;
    		m++;
    	}
    	int[] p =new int[m+1];
    	p[0] = 0;
    	for(int i=1;i<=m;i++){
    		p[i]=10*p[i-1]+(int)Math.pow(10,i-1);
    	}
    	k=n;
    	int mod = (int)Math.pow(10,m-1);
    	int l = m-1;
    	int r = 0;
    	while(mod>0){
    		int digit = (k/mod);
    		r = r+p[l]*digit;
    		k = k-(k/mod)*mod;
    		if(digit==1){
    			r+=k+1;
    		}else{
    			r+=Math.pow(10,l);
    		}
    		while(mod>k){
    			mod = mod/10;
    			l--;
    		}	
    	}
        return r;
    }

	public static void main(String[] args) {
		NumberOfDigitOne s = new NumberOfDigitOne();
		int r = s.countDigitOne(101);
		System.out.println(r);
	}

}
