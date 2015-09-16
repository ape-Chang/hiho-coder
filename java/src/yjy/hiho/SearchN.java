package yjy.hiho;

public class SearchN {
	
	public static int Search(int t,int[] A){
		
		if(A.length == 0){
			return -1;
		}
		int i = 0;
		int j = A.length - 1;
		if(A[i]==t){
			return i;
		}
		if(A[i]>t){
			return -1;
		}
		if(A[j]==t){
			return j;
		}
		if(A[j]<t){
			return -1;
		}
		while(i<=j){
			if(i==j || j==i+1){
				return -1;
			}

			int mid = (i+j)/2;
//			System.out.println(i+" "+j+" "+mid);
			if(A[mid]==t){
				return mid;
			}else if(A[mid]<t){
				i = mid;
			}else{
				j = mid;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int[] A = {1,3,4,5,7,34,231,244,333,531,666,888};
//		int[] A = {1,3,4};
		int result = Search(666,A);
		System.out.println(result);
	}
}
