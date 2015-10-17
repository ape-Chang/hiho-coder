package yjy.hiho;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		if(x<0)return false;
		int r=x,t=0;
		while(r!=0){
			t = 10*t+r%10;
			r = r/10;
		}
        return t==x;
    }

	public static void main(String[] args) {
		PalindromeNumber s = new PalindromeNumber();
		boolean r = s.isPalindrome(0);
		System.out.println(r);
	}

}
