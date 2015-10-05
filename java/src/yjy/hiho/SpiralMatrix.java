package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] A) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		int m = A.length;
		if(m==0){
			return r;
		}
		int n = A[0].length;
		if(n==0){
			return r;
		}
		int top=0,bottom=m-1;
		int left=0,right=n-1;
		while(left<=right && top<=bottom){
			int d = Math.min(right-left,bottom-top);
			if(d==0){
				if(right==left && bottom==top){
					r.add(A[top][left]);
				}else if(right==left){
					for(int i=top;i<=bottom;i++){
						r.add(A[i][left]);
					}
				}else if(bottom==top){
					for(int i=left;i<=right;i++){
						r.add(A[top][i]);
					}
				}
				break;
			}
			for(int i=left;i<right;i++){
				r.add(A[top][i]);
			}
			for(int i=top;i<bottom;i++){
				r.add(A[i][right]);
			}
			for(int i=right;i>left;i--){
				r.add(A[bottom][i]);
			}
			for(int i=bottom;i>top;i--){
				r.add(A[i][left]);
			}
			top++;
			bottom--;
			left++;
			right--;
		}
        return r;
    }
	
	public static void main(String[] args) {
		SpiralMatrix s = new SpiralMatrix();
		int[][] A = {
				{1,2,3},
				{6,7,8},
				{11,17,18},
				{21,27,28},
		};
		List<Integer> r = s.spiralOrder(A);
		for(Integer i:r){
			System.out.println(i);
		}
	}

}
