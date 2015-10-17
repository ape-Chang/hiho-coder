package yjy.hiho;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> r = new ArrayList<String>();
		char[] stack = new char[n<<1];
		this.generate(n,stack,0,0,r);
		return r;
    }
	
	public void generate(int Pcount,char[] S,int top,int count,List<String> l){
		if(top==S.length){
			l.add(new String(S));
			return;
		}
		if(Pcount==0){
			S[top] = ')';
			this.generate(Pcount,S,top+1,count-1,l);
			return;
		}
		if(count==0){
			S[top] = '(';
			this.generate(Pcount-1,S,top+1,count+1,l);
		}else{
			S[top] = '(';
			this.generate(Pcount-1,S,top+1,count+1,l);
			S[top] = ')';
			this.generate(Pcount,S,top+1,count-1,l);
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses s = new GenerateParentheses();
		List<String> l = s.generateParenthesis(3);
		for(String str:l){
			System.out.println(str);
		}
	}

}
