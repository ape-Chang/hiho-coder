package yjy.hiho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ContainerWithMostWater {
	
	public int maxArea2(int[] A) {
		int maxIndex = 0;
		int max=0;
		int N = A.length;
		for(int i=0;i<N;i++){
			if(A[i]>max){
				max = A[i];
				maxIndex = i;
			}
		}
		int R=0;
		int leftmax = 0;
		int lastX = 0;
		int lastH = 0;
		for(int i=0;i<maxIndex;i++){
			if(A[i]>leftmax){
				leftmax = A[i];
				R+=(i-lastX)*lastH;
				lastX = i;
				lastH = A[i];
			}
		}
		R+=(maxIndex-lastX)*lastH;
		
		int rightmax = 0;
		lastX = 0;
		lastH = 0;
		for(int i=N-1;i>maxIndex;i--){
			if(A[i]>rightmax){
				rightmax = A[i];
				R+=(lastX-i)*lastH;
				lastX = i;
				lastH = A[i];
			}
		}
		R+=(lastX-maxIndex)*lastH;
        return R;
    }
	
	public int maxArea(int[] A) {
		int N = A.length;
		if(N<=1){
			return 0;
		}
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<Integer> Seq = new ArrayList<Integer>();
		for(int i=0;i<N;i++){
			Seq.add(A[i]);
			ArrayList<Integer> l = map.get(A[i]);
			if(l==null){
				l = new ArrayList<Integer>();
				map.put(A[i], l);
			}
			l.add(i);
		}
		Collections.sort(Seq);
		int Max=0,low=N,high=-1;
		Integer maxii = Seq.get(N-1);
		ArrayList<Integer> maxPos = map.get(maxii);
		for(Integer p:maxPos){
			if(p>high){
				high = p;
			}
			if(p<low){
				low = p;
			}
		}
		Max = maxii*(high-low);
		int lastii = maxii;
		
		for(int i=N-2;i>=0;i--){
			Integer ii = Seq.get(i);
			if(ii==lastii){
				continue;
			}
			ArrayList<Integer> pos = map.get(ii);
			for(Integer p:pos){
				if(p>high){
					high = p;
				}
				if(p<low){
					low = p;
				}
			}
			if(Max < ii*(high-low)){
				Max = ii*(high-low);
			}
			lastii = ii;
		}
        return Max;
    }

	public static void main(String[] args) {
		ContainerWithMostWater s = new ContainerWithMostWater();
		int[] height = {1,2,4,3};
		int R = s.maxArea(height);
		System.out.println(R);
	}

}
