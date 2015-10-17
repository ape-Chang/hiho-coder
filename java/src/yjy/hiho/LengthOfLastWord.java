package yjy.hiho;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
    	int n = s.length();
    	boolean start = false;
    	int count = 0;
    	for(int i=n-1;i>=0;i--){
    		if(s.charAt(i)==' '){
    			if(start){
    				return count;
    			}else{
    				continue;
    			}
    		}else{
    			if(!start){
    				start = true;
    				count = 1;
    			}else{
    				count++;
    			}
    		}
    	}
    	if(!start){
    		return 0;
    	}else{
    		return count;
    	}
    }
	public static void main(String[] args) {
		LengthOfLastWord s = new LengthOfLastWord();
		int r = s.lengthOfLastWord(" world  ");
		System.out.println(r);
	}

}
