package yjy.hiho;

public class BitwiseANDOfNumbersRange {
	
    public int rangeBitwiseAnd(int m, int n) {
    	if(m==n){
    		return m;
    	}
    	long j = 1;
    	int count = 0;
        while((j<<1)<=n){
        	j=j<<1;
        	count++;
        }
        System.out.println(count);
        for(;count>=0;count--){
        	if((m>>count)==(n>>count)){
        		continue;
        	}else{
        		System.out.println(count);
        		break;
        	}
        }
        int r = n;
        for(int i=0;i<=count;i++){
        	r=r>>1;
        }
        for(int i=0;i<=count;i++){
        	r=r<<1;
        }
        return r;
    }

	public static void main(String[] args) {
		BitwiseANDOfNumbersRange s = new BitwiseANDOfNumbersRange();
		int r = s.rangeBitwiseAnd(0,2);
		System.out.println(r);
	}

}
