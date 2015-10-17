package yjy.hiho;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
    	if(n<=0)return false;
        while(n!=0){
        	if(n%2==1 && n!=1){return false;}
        	n=n/2;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
