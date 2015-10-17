package yjy.hiho;

public class FirstBadVersion {
	
	boolean isBadVersion(int version){
		return version>6;
	}
	public int firstBadVersion(int n) {
		if(isBadVersion(1))return 1;
		int i=1,j=n;
		int r = n;
		while(i<=j){
			if(i==j){return i;}
			int mid = i+(j-i)/2;
			if(isBadVersion(mid)){
				if(!isBadVersion(mid-1)){
					return mid;
				}else{
					
				}
				r = mid;
				j = mid-1;
			}else{
				i = mid+1;
			}
		}
		return r;
	}
	
	public static void main(String[] args){
		FirstBadVersion s = new FirstBadVersion();
		int r = s.firstBadVersion(99);
		System.out.println(r);
	}
}
