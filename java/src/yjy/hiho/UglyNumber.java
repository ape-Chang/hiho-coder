package yjy.hiho;

public class UglyNumber {
    public boolean isUgly(int num) {
    	if(num==0)
    		return false;
    	while(num%30==0)
    		num = num/30;
    	while(num%6==0)
    		num = num/6;
    	while(num%2==0)
    		num = num/2;
        return num==1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
