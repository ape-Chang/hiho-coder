package yjy.hiho;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	int n = s.length();
    	Stack<Integer> ss = new Stack<Integer>();
    	int max = 0;
    	int ii = 0;
    	for(int i=0;i<n;i++){
    		char c =s.charAt(i);
    		if(c=='('){
    			ss.push(0);
    		}else if(c==')'){
    			if(!ss.isEmpty()){
    				int tmp = ss.pop()+2;
    				if(ss.isEmpty()){
    					ii+=tmp;
    					max = Math.max(max,ii);
    				}else{
    					int tmp2 = ss.pop()+tmp;
    					max = Math.max(max,tmp2);
    					ss.push(tmp2);
    				}
    			}else{
    				ii=0;
    			}
    		}
    	}
    	if(ss.isEmpty()){
			max = Math.max(max,ii);
		}else{
			max = Math.max(max,ss.peek());
		}
        return max;
    }
    
	public static void main(String[] args) {
		LongestValidParentheses s = new LongestValidParentheses();
		int r = s.longestValidParentheses("(((()))()");
		System.out.println(r);
	}

}
