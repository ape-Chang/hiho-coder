package yjy.hiho;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
    	int n = s.length();
    	if(n==0){return "";}
    	int N = 2*n+1;
    	char[] a = new char[N];
    	for(int i=0;i<n;i++){
    		a[i*2] = '#';
    		a[i*2+1]=s.charAt(i);
    	}
    	a[n*2]='#';
    	int max[] = new int[N];
    	int maxP = 1;
    	max[0]=1;max[1]=3;
    	for(int i=2;i<N;i++){
    		if(i*2+1>N){break;}
    		if(max[i-1]>max[i-2]+2){
    			max[i]=max[i-2];
    		}else{
    			int p = i-1+(max[i-1]-1)/2;
    			int q = i-(p-i);
    			int tmp = p-q+1;
    			while(true){
    				p++;
    				q--;
    				if(p>=N||q<0||a[p]!=a[q]){break;}
    				tmp+=2;
    			}
    			max[i]=tmp;
    			if(q<0){maxP = Math.max(maxP,tmp/2);}
    		}
    		
    	}
    	String head = s.substring(maxP,s.length());
    	StringBuffer buf = new StringBuffer();
    	for(int i=head.length()-1;i>=0;i--){
    		buf.append(head.charAt(i));
    	}
        return buf.toString()+s;
    }
	public static void main(String[] args) {
		ShortestPalindrome s = new ShortestPalindrome();
		String r = s.shortestPalindrome("abbssbba");
		System.out.println(r);
	}

}
