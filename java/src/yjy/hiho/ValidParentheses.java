package yjy.hiho;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> ss = new Stack<Character>();
        int n = s.length();
        for(int i=0;i<n;i++){
        	char c = s.charAt(i);
        	if(c=='('||c=='{'||c=='['){
        		ss.push(c);
        	}else{
        		if(ss.isEmpty())return false;
        		char cc;
        		switch(s.charAt(i)){
            	case ')':
            		cc = ss.pop();
            		if(cc!='(')return false;
            		break;
            	case '}':
            		cc = ss.pop();
            		if(cc!='{')return false;
            		break;
            	case ']':
            		cc = ss.pop();
            		if(cc!='[')return false;
            		break;
            	}
        	}
        }
        return ss.isEmpty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
