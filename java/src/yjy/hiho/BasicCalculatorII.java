package yjy.hiho;

public class BasicCalculatorII {
	public int calculate(String s) {
    	char[] c = s.toCharArray();
    	int val = 0,item = 1,sign = 1,r = 0,n = c.length;
    	char lastOp = '+';
    	boolean readingDigit = false;
    	for(int i=0;i<n;i++){
    		if(c[i]>='0' && c[i]<='9'){
    			readingDigit = true;
    			val = val*10 + (c[i]-'0');
    		}else if(c[i]=='+'||c[i]=='-'||c[i]=='*'||c[i]=='/'){
    			if(readingDigit){
    				switch(lastOp){
    				case '*':item*=val;break;
    				case '/':item/=val;break;
    				case '+':item=val;break;
    				case '-':item=val;break;
    				}
        			val = 0;
        			readingDigit = false;
    			}
    			if(c[i]=='+'||c[i]=='-'){
    				r+=sign*item;
    				switch(c[i]){
    				case '+':sign=1;break;
    				case '-':sign=-1;break;
    				}
        		}
    			lastOp = c[i];
    		}
    	}
    	if(readingDigit){
    		switch(lastOp){
			case '*':item*=val;break;
			case '/':item/=val;break;
			case '+':item=val;break;
			case '-':item=val;break;
			}
    		r+=sign*item;
		}
    	return r;
    }
	
	public static void main(String[] args) {
		BasicCalculatorII s = new BasicCalculatorII();
		int r = s.calculate(" 3+5 / 2 ");
		System.out.println(r);
	}

}
