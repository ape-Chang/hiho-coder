package yjy.hiho;

public class ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n!=t.length())return false;
        int[] count = new int[26];
        for(int i=0;i<n;i++){
        	count[s.charAt(i)-'a']++;
        	count[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
        	if(count[i]!=0)return false;
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
