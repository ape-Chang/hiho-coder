package yjy.hiho;

public class ReverseWordsInAString {
	
	public void reverse(char[] c,int i,int j){
		while(i<j){
			char tmp = c[i];
			c[i] = c[j];
			c[j] = tmp;
			i++;
			j--;
		}
	}
	
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        if(n==0)
        	return "";
        int i=0;int j=0;
        int wordCount = 0;
        P:while(true){
        	while(c[i]==' '){
        		i++;
        		if(i>=n)
        			break P;
        	}
        	j=i;
        	while(j<n && c[j]!=' '){
        		j++;
        	}
        	wordCount++;
        	this.reverse(c,i,j-1);
        	i=j+1;
        	if(i>=n)
    			break P;
        }
        if(wordCount==0)
        	return "";
        this.reverse(c,0,n-1);
        return new String(c);
    }

	public static void main(String[] args) {
		ReverseWordsInAString s = new ReverseWordsInAString();
		String r = s.reverseWords("the sky is blue");
		System.out.println(r);
	}

}
