package yjy.hiho;

public class Pow {
	
	// 超时
	public double myPow(double x, int n) {
		if(n==0||x==1.0){
			return 1.0;
		}
		int ss = 1;
		if(n>0){
			ss = 1;
		}else{
			ss = -1;
		}
		n = Math.abs(n);
		double r = 1.0;
		double mul = x;
		int lefted = n;
		while(lefted!=0){
			int j = 1;
			mul = x;
			while((j<<1)<=lefted){
				j=j<<1;
				mul=mul*mul;
			}
			r*=mul;
			lefted-=j;
		}
		if(ss==1){
			return r;
		}else{
			return 1/r;
		}
    }

	public static void main(String[] args) {
		Pow s = new Pow();
		double r = s.myPow(3,5);
		System.out.println(r);
	}

}
