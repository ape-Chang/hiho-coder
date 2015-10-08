package yjy.hiho;

import java.util.ArrayList;
import java.util.HashMap;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int nn, int dd) {
    	int s1=1,s2=1;
    	long numerator = nn;
    	long denominator = dd;
    	if(numerator<0)
    		s1 = -1;
    	if(denominator<0)
    		s2 = -1;
    	int s = s1*s2;
    	numerator = Math.abs(numerator);
    	denominator = Math.abs(denominator);
    	long a = numerator/denominator;
    	long b = numerator%denominator;
    	if(b==0){
    		if(s==1 || a==0){
    			return Long.toString(a);
    		}else{
    			return "-"+Long.toString(a);
    		}
    	}
    		
    	HashMap<Long,Integer> map = new HashMap<Long,Integer>();
    	ArrayList<Long> L = new ArrayList<Long>();
    	int i=0;
    	Integer e=0;
    	while(b!=0){
    		map.put(b,i);
    		L.add(b*10/denominator);
    		i++;
    		long tmp = b*10%denominator;
    		e = map.get(tmp);
    		if(e!=null){
    			break;
    		}
    		b = tmp;
    	}
    	String C = "";
    	if(b==0){
    		int n = L.size();
    		char[] cc = new char[n];
    		for(int k=0;k<n;k++){
    			cc[k] = (char)('0'+L.get(k));
    		}
    		C = new String(cc);
    	}else{
    		int n = L.size()-e;
    		char[] cc1 = new char[e];
    		char[] cc = new char[n];
    		for(int k=0;k<cc1.length;k++){
    			cc1[k] = (char)('0'+L.get(k));
    		}
    		for(int k=0;k<n;k++){
    			cc[k] = (char)('0'+L.get(k+e));
    		}
    		C = (new String(cc1))+"("+(new String(cc))+")";
    	}
    	String ret = Long.toString(a)+"."+C;
    	if(s==-1){
    		ret = "-"+ret;
    	}
        return ret;
    }
    
	public static void main(String[] args) {
		FractionToRecurringDecimal s = new FractionToRecurringDecimal();
		String r = s.fractionToDecimal(-1,-2147483648);
		System.out.println(r);
	}
}
