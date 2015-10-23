package yjy.hiho;

import java.util.HashMap;

public class WordDictionary {
	
	class Node{
		char val;
		boolean hasWord;
		HashMap<Character,Node> chs;
		Node(char val){
			this.val = val;
			this.hasWord = false;
			chs = new HashMap<Character,Node>();
		}
		
		boolean hasSubWord(int begin,String word){
			if(begin==word.length()){return this.hasWord;}
			char c = word.charAt(begin);
			if(c=='.'){
				for(Node nn:this.chs.values()){
					if(nn.hasSubWord(begin+1,word)){return true;}
				}
				return false;
			}else{
				Node found = this.chs.get(c);
				if(found!=null){
					return found.hasSubWord(begin+1,word);
				}else{
					return false;
				}
			}
		}
		
	}
	
	private Node root;
	
	WordDictionary(){
		this.root = new Node('#');
	}

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node cur = root;
        int n = word.length();
        for(int i=0;i<n;i++){
        	char c = word.charAt(i);
        	Node found = cur.chs.get(c);
        	if(found==null){
        		found = new Node(c);
        		cur.chs.put(c,found);
        	}
        	cur = found;
        }
        cur.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return root.hasSubWord(0,word);
    }
    public static void main(String[] args) {
    	WordDictionary s = new WordDictionary();
    	s.addWord("at");
    	s.addWord("and");
    	s.addWord("an");
    	s.addWord("add");
    	System.out.println(s.search("a"));
    	System.out.println(s.search(".at"));
    	s.addWord("bat");
    	System.out.println(s.search(".at"));
    	System.out.println(s.search("an."));
    	System.out.println(s.search("a.d."));
    	System.out.println(s.search("b."));
    	System.out.println(s.search("a.d"));
    	System.out.println(s.search("."));
	}
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");