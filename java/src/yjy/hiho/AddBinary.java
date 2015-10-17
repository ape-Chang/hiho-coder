package yjy.hiho;

import java.util.ArrayList;

public class AddBinary {
    public String addBinary(String a, String b) {
    	int n = a.length();
    	int m = b.length();
    	int i = n-1;
    	int j = m-1;
    	int p = 0;
    	ArrayList<Character> r = new ArrayList<Character>();
    	while(i>=0&&j>=0){
    		char d1 = a.charAt(i);
    		char d2 = b.charAt(j);
    		int pp = (d1-'0'+d2-'0'+p);
    		p = pp/2;
    		r.add((char) ('0'+pp%2));
    		i--;j--;
    	}
    	while(i>=0){
    		char d1 = a.charAt(i);
    		int pp = (d1-'0'+p);
    		p = pp/2;
    		r.add((char) ('0'+pp%2));
    		i--;
    	}
    	while(j>=0){
    		char d2 = b.charAt(j);
    		int pp = (d2-'0'+p);
    		p = pp/2;
    		r.add((char) ('0'+pp%2));
    		j--;
    	}
    	if(p!=0){r.add((char)(p+'0'));}
    	int N = r.size();
    	char[] cc = new char[N];
    	for(int k=0;k<N;k++){
    		cc[k] = r.get(N-k-1);
    	}
        return new String(cc);
    }
    
	public static void main(String[] args) {
		AddBinary s = new AddBinary();
		String r = s.addBinary("1","111");
		System.out.println(r);
	}

}
