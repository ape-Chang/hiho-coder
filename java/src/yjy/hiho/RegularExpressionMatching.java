package yjy.hiho;

public class RegularExpressionMatching {
	class Node1{
		char val;
		Node next;
		Node1(char val){
			this.val = val;
		}
		
		boolean visit(char[] cArray,int index){
			if(this.val == '.'){
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
	
	class Node{
		char val;
		boolean recrusive;
		Node next;
		Node(char val){
			this.val = val;
			this.recrusive = false;
		}
		
		boolean visit(char[] cArray,int index){
			if(this.recrusive){
				if(index>=cArray.length){
					if(this.next==null){
						return true;
					}else{
						return this.next.visit(cArray,index);
					}
				}
				if(this.next==null){
					if(this.val=='.'){
						return true;
					}else{
						for(int i=index;i<cArray.length;i++){
							if(cArray[i]!=this.val){return false;}
						}
						return true;
					}
				}else{
					for(int i=index;i<=cArray.length;i++){
						if(i>index&&this.val!='.'&&cArray[i-1]!=this.val){
							break;
						}
						if(this.next.visit(cArray,i))return true;
					}
					return false;
				}
			}else{
				if(index>=cArray.length){return false;}
				if(this.val != '.'&&this.val != cArray[index]){return false;}
				if(this.next!=null){
					return this.next.visit(cArray,index+1);
				}else{
					return index==cArray.length-1;
				}
			}
		}
	}
	
	public boolean isMatch(String s, String p) {
		int m = p.length();
		int n = s.length();
		if(m==0){return n==0;}
		Node head = new Node('s');
		Node cur = head;
		for(int i=0;i<m;i++){
			char c = p.charAt(i);
			if(c=='*'){
				cur.recrusive = true;
			}else{
				cur.next = new Node(c);
				cur = cur.next;
			}
		}
        return head.next.visit(s.toCharArray(),0);
    }
	
	public static void main(String[] args) {
		RegularExpressionMatching s = new RegularExpressionMatching();
		boolean r = s.isMatch("aab", "c*aacc*b");
		System.out.println(r);
	}

}
