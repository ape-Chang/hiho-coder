package yjy.hiho;

public class ReverseInteger {
	
	public int reverse(int x) {
		if(x==0){
			return x;
		}else if(x<=-2147483648){
			return 0;
		}
		int s = x/Math.abs(x);
		x = Math.abs(x);
		long R = 0;
		while(x!=0){
			R = R*10+x%10;
			x = x/10;
		}
		if(R>2147483647){
			R=0;
		}
        return (int)R*s;
    }

	public static void main(String[] args) {
		ReverseInteger s = new ReverseInteger();
		int R = s.reverse(-2147483648);
		System.out.println(R);
	}

}
