package yjy.hiho;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> T) {
		int n = T.size();
		int[] sum = new int[n];
		if(n==0){
			return 0;
		}else if(n==1){
			return T.get(0).get(0);
		}
		sum[0]=T.get(0).get(0);
		for(int i=1;i<n;i++){
			List<Integer> cost = T.get(i);
			sum[i] = cost.get(i)+sum[i-1];
			for(int j=i-1;j>0;j--){
				sum[j] = cost.get(j)+Math.min(sum[j],sum[j-1]);
			}
			sum[0] = cost.get(0)+sum[0];
		}
		int min = sum[0];
		for(int i=0;i<n;i++){
			min = Math.min(min,sum[i]);
		}
        return min;
    }
	public static void main(String[] args) {
		Triangle s = new Triangle();
//		s.minimumTotal(T);
	}

}
