package yjy.hiho;

import java.util.HashSet;

public class HappyNumber {
	
	public boolean isHappy(int n) {
		if(n==1){return true;}
		int sum = n;
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(sum);
		while(true){
			int r = sum;
			int tmp = 0;
			while(r!=0){
				tmp+=(r%10)*(r%10);
				r=r/10;
			}
			if(tmp==1){
				return true;
			}else if(set.contains(tmp)){
				return false;
			}else{
				sum = tmp;
				set.add(sum);
			}
		}
    }

	public static void main(String[] args) {
		HappyNumber s = new HappyNumber();
		boolean r = s.isHappy(2);
		System.out.println(r);
	}

}
