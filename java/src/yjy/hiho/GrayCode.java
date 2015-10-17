package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(0);
        int cur = 0;
        for(int i=0;i<n;i++){
        	int t = 1<<i;
        	for(int j=cur;j>=0;j--){
        		r.add(r.get(j)|t);
        	}
        	cur = r.size()-1;
        }
        return r;
    }

	public static void main(String[] args) {
		GrayCode s = new GrayCode();
		List<Integer> r = s.grayCode(3);
		for(Integer i : r){
			System.out.println(i);
		}
	}

}
