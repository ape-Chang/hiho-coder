package yjy.hiho;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if(numRows==1){
			return s;
		}
		
		ArrayList<LinkedList<Character>> Qs = new ArrayList<LinkedList<Character>>();
		for(int i=0;i<numRows;i++){
			Qs.add(i,new LinkedList<Character>());;
		}
		char[] A = s.toCharArray();
		int N = A.length;
		int index = 0;
		boolean reverse = false;
		for(int i=0;i<N;i++){
			Qs.get(index).add(A[i]);
			if(reverse){
				index--;
				
				if(index==-1){
					index=1;
					reverse = false;
				}
			}else{
				index++;
				if(index==numRows){
					index=numRows-2;
					reverse = true;
				}
			}
		}
		int count = 0;
		for(int i=0;i<numRows;i++){
			while(!Qs.get(i).isEmpty()){
				A[count] = Qs.get(i).poll();
				count++;
			}
		}
		return String.valueOf(A);
    }
	
	public static void main(String[] args) {
		ZigZagConversion s = new ZigZagConversion();
		String R = s.convert("PAYPALISHIRING", 3);
		System.out.println(R);
	}

}
