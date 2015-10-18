package yjy.hiho;

import java.util.HashMap;

public class LRUCache {
	
	class Node{
		int val;
		int key;
		Node next;
		Node pre;
		Node(int key,int val){
			this.key = key;
			this.val = val;
		}
	}
	
	private Node keyListHead;
	private Node keyListLast;
	private HashMap<Integer,Node> map;
	private int capacity;
    
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	this.map = new HashMap<Integer,Node>();
    	this.keyListHead = new Node(0,0);
    	this.keyListLast = keyListHead;
    }
    
    public int get(int key) {
    	Node found = map.get(key);
    	if(found==null){return -1;}
    	else{
        	found.pre.next = found.next;
        	if(found==keyListLast){
        		keyListLast = found.pre;
        		keyListLast.next = null;
        	}else{
        		found.next.pre = found.pre;
        	}
        	found.next = null;
        	found.pre  = null;
        	if(keyListHead==keyListLast){
        		keyListHead.next = found;
        		found.pre = keyListHead;
        		keyListLast = found;
        	}else{
        		keyListHead.next.pre = found;
        		found.next = keyListHead.next;
        		keyListHead.next = found;
        		found.pre = keyListHead;
        	}
    	}
        return found.val;
    }
    
    public void set(int key, int value) {
        Node found = map.get(key);
        if(found==null){
        	found = new Node(key,value);
        	map.put(key,found);
        }else{
        	found.val = value;
        	found.pre.next = found.next;
        	if(found==keyListLast){
        		keyListLast = found.pre;
        		keyListLast.next = null;
        	}else{
        		found.next.pre = found.pre;
        	}
        	found.next = null;
        	found.pre  = null;
        }
        if(keyListHead==keyListLast){
    		keyListHead.next = found;
    		found.pre = keyListHead;
    		keyListLast = found;
    	}else{
    		keyListHead.next.pre = found;
    		found.next = keyListHead.next;
    		keyListHead.next = found;
    		found.pre = keyListHead;
    	}
        if(map.size()>capacity && keyListLast!=keyListHead){
        	map.remove(this.keyListLast.key);
    		keyListLast = keyListLast.pre;
    		keyListLast.next = null;
        }
    }
    
    public static void main(String[] args){
//    	LRUCache s = new LRUCache(2);
//    	System.out.println(s.get(2));
//    	s.set(2,6);
//    	System.out.println(s.get(1));
//    	s.set(1,5);
//    	s.set(1,2);
//    	System.out.println(s.get(1));
//    	System.out.println(s.get(2));
    	LRUCache s = new LRUCache(1);
    	s.set(2,1);
    	System.out.println(s.get(2));
    }
}
