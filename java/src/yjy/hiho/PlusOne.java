package yjy.hiho;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		int p = 1;
		for(int i=n-1;i>=0;i--){
			int pp = (digits[i]+p);
			p = pp/10;
			digits[i] = pp%10;
			if(p==0)break;
		}
		if(p==1){
			int[] r = new int[n+1];
			for(int i=0;i<n;i++){
				r[i+1] = digits[i];
			}
			r[0] = 1;
			return r;
		}else{
			return digits;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
