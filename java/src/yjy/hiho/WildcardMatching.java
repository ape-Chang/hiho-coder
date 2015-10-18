package yjy.hiho;

public class WildcardMatching {
	class Node{
		char val;
		Node next;
		Node(char val){
			this.val = val;
		}
		
		boolean visit(char[] cArray,int index){
			if(this.val == '?'){
				if(index>=cArray.length){return false;}
				if(this.next!=null){
					return this.next.visit(cArray,index+1);
				}else{
					return index==cArray.length-1;
				}
			}else if(this.val == '*'){
				if(this.next==null){
					return true;
				}
				for(int i=index;i<=cArray.length;i++){
					if(this.next.visit(cArray,i)){return true;}
				}
				return false;
			}else{
				if(index>=cArray.length){return false;}
				if(this.val != cArray[index]){return false;}
				if(this.next!=null){
					return this.next.visit(cArray,index+1);
				}else{
					return index==cArray.length-1;
				}
			}
		}
	}
	
    public boolean isMatch1(String s, String p) {
    	int m = p.length();
		int n = s.length();
		if(m==0){return n==0;}
		Node head = new Node('s');
		Node cur = head;
		boolean lastIsStart = false;
		for(int i=0;i<m;i++){
			char c = p.charAt(i);
			if(!lastIsStart || c!='*'){
				cur.next = new Node(c);
				cur = cur.next;
			}
			lastIsStart = (c=='*');
		}
        return head.next.visit(s.toCharArray(),0);
    }
    
    // DP
    public boolean isMatch(String s, String p) {
    	int n = s.length();
    	int m = p.length();
    	if(n==0&&m==0){
    		return true;
    	}else if(n==0){
    		for(int i=0;i<m;i++){
    			if(p.charAt(i)!='*')return false;
    		}
    		return true;
    	}else if(m==0){
    		return false;
    	}
    	boolean[][] A = new boolean[n+1][m+1];
    	boolean[][] B = new boolean[n+1][m+1];
		A[0][0] = true;
		B[0][0] = true;
		for(int i=1;i<=n;i++){
			A[i][0] = false;
			B[i][0] = true;
		}
		boolean allStart = true;
		for(int i=1;i<=m;i++){
			if(allStart && p.charAt(i-1)!='*'){allStart=false;}
			A[0][i] = allStart;
			B[0][i] = allStart;
		}
    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=m;j++){
    			char cs = s.charAt(i-1);
    			char cp = p.charAt(j-1);
    			if(cp=='?'){
    				A[i][j] = A[i-1][j-1];
    			}else if(cp=='*'){
    				A[i][j] = B[i][j-1];
    			}else{
    				if(cs==cp){
    					A[i][j] = A[i-1][j-1];
    				}else{
    					A[i][j] = false;
    				}
    			}
    			B[i][j] = B[i-1][j]||A[i][j];
    		}
    	}
    	return A[n][m];
    }
	
	public static void main(String[] args) {
		WildcardMatching s = new WildcardMatching();
		boolean r = s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba","*a***bbaaaa***ba");
		System.out.println(r);
	}

}
