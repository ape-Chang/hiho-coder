package yjy.hiho;

import java.util.ArrayList;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
    	int n = path.length();
    	boolean slash = false;
    	StringBuffer buf = null;
    	ArrayList<String> l = new ArrayList<String>();
    	for(int i=0;i<n;i++){
    		char c = path.charAt(i);
    		if(c=='/'){
    			if(slash){
    				continue;
    			}else{
    				slash = true;
    				if(buf!=null){
    					l.add(buf.toString());
    					buf = null;
    				}
    			}
    		}else{
    			if(slash){
    				slash = false;
    				buf = new StringBuffer();
    			}
    			buf.append(c);
    		}
    	}
    	if(buf!=null){l.add(buf.toString());buf = null;}
    	Stack<String> S = new Stack<String>();
    	for(String ss:l){
    		if(ss.equals(".")){
    			continue;
    		}else if(ss.equals("..")){
    			if(!S.isEmpty())S.pop();
    		}else{
    			S.push(ss);
    		}
    	}
    	StringBuffer rBuf = new StringBuffer();
    	if(S.isEmpty()){return "/";}
    	for(String rr:S){
    		rBuf.append(String.format("/%s",rr));
    	}
    	return rBuf.toString();
    }
	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		String r = s.simplifyPath("/home//foo/");
		System.out.println(r);
	}

}
