package yjy.hiho;

import java.util.TreeMap;

public class MedianFinder {
	class Node{
		int count;
		final int val;
		Node(int val){
			this.count = 0;
			this.val = val;
		}
	}
	private TreeMap<Integer,Node> map;
	private Node mid;
	private int count;
	private double midval;
	private int mid_offset;
	//
	MedianFinder(){
		this.map = new TreeMap<Integer,Node>();
		this.midval = 0.0;
		this.count = 0;
		this.mid = null;
	}
	
	Node midNext(boolean flag){
		if(mid.count>mid_offset){
			if(flag){mid_offset++;}
			return mid;
		}else{
			Node next = map.ceilingEntry(mid.val+1).getValue();
			if(flag){mid_offset = 1;mid=next;}
			return next;
		}
	}
	
	Node midPre(boolean flag){
		if(1<mid_offset){
			if(flag){mid_offset--;}
			return mid;
		}else{
			Node pre = map.floorEntry(mid.val-1).getValue();
			if(flag){mid_offset = pre.count;mid=pre;}
			return pre;
		}
	}
	
	// Adds a number into the data structure.
    public void addNum(int num) {
    	Node node = map.get(num);
    	if(node == null){
    		node = new Node(num);
    		map.put(num,node);
    	}
    	node.count++;
    	count++;
    	if(mid==null){
    		mid = node;
    		midval = node.val;
    		mid_offset = 1;
    	}else{
    		if(count%2==0){
        		if(num==mid.val){
        			midval = num;
        		}else if(num>mid.val){
        			midval = ((double)mid.val+(double)midNext(false).val)/2;
        		}else{
        			// num<mid.val
        			midval = mid.val;
        			mid = midPre(true);
        			midval = (midval+mid.val)/2;
        		}
        	}else{
        		if(num==mid.val){
        			midval = num;
        			mid_offset++;
        		}else if(num>mid.val){
        			mid = midNext(true);
        			midval = mid.val;
        		}else{
        			// num<mid.val
        			midval = mid.val;
        		}
        	}
    	}
    }

    // Returns the median of current data stream
    public double findMedian() {
    	return this.midval;
    }
    
	public static void main(String[] args) {
		// Your MedianFinder object will be instantiated and called as such:
		MedianFinder mf = new MedianFinder();
		mf.addNum(4);
		mf.addNum(4);
		mf.addNum(4);
		mf.addNum(4);
		mf.addNum(3);
		mf.addNum(1);
		mf.addNum(2);
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}

}
