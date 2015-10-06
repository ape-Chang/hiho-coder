package yjy.hiho;

import java.util.ArrayList;

public class BasicCalculator {
	class Node{
		char type;
		int val;
	}
	private int index;
    public int calculate(String s) {
    	char[] c = s.toCharArray();
    	ArrayList<Node> l = new ArrayList<Node>();
    	int val = 0;
    	boolean readingDigit = false;
    	int n = c.length;
    	for(int i=0;i<n;i++){
    		if(c[i]>='0' && c[i]<='9'){
    			readingDigit = true;
    			val = val*10 + (c[i]-'0');
    		}else if(c[i]>='+'||c[i]>='-'||c[i]>='('||c[i]>=')'){
    			if(readingDigit){
    				Node nd = new Node();
    				nd.type = 'd';
    				nd.val = val;
        			l.add(nd);
        			val = 0;
        			readingDigit = false;
    			}
    			Node node = new Node();
    			node.type = c[i];
    			l.add(node);
    		}
    	}
    	if(readingDigit){
			Node nd = new Node();
			nd.type = 'd';
			nd.val = val;
			l.add(nd);
			readingDigit = false;
		}
    	this.index = 0;
        return this.visit(l);
    }
    
    public int visit(ArrayList<Node> l){
    	int ret = 0;
    	int sign = 1;
    	int n = l.size();
    	while(index<n){
    		Node cur = l.get(index);
    		index++;
    		switch(cur.type){
    		case '+':
    			sign = 1;
    			break;
    		case '-':
    			sign = -1;
    			break;
    		case '(':
    			ret+=sign*this.visit(l);
    			break;
    		case ')':
    			return ret;
    		case 'd':
    			ret+=sign*cur.val;
    			break;
    		}
    	}
    	return ret;
    }
    
	public static void main(String[] args) {
		BasicCalculator s = new BasicCalculator();
		int r = s.calculate(" 2-1 + 2 ");
		System.out.println(r== 2-1 + 2 );
	}

}
