package yjy.hiho;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	class Node implements Comparable<Node>{
		ListNode innerNode;
		Node(ListNode innerNode){
			this.innerNode = innerNode;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.innerNode.val - n.innerNode.val;
		}
		
	}
	// 
    public ListNode mergeKLists(ListNode[] lists) {
    	PriorityQueue<Node> q = new PriorityQueue<Node>();
    	ListNode head = new ListNode(0);
    	int k = lists.length;
    	for(int i=0;i<k;i++){
    		if(lists[i]!=null)
    			q.add(new Node(lists[i]));
    	}
    	ListNode cur = head;
    	while(!q.isEmpty()){
    		ListNode node = q.poll().innerNode;
    		cur.next = node;
    		cur = node;
    		if(node.next!=null){
    			q.add(new Node(node.next));
    		}
    	}
    	cur.next = null;
        return head.next;
    }
	public static void main(String[] args) {
		MergeKSortedLists s = new MergeKSortedLists();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n11 = new ListNode(11);
		ListNode n12 = new ListNode(12);
		ListNode n13 = new ListNode(13);
		n1.next = n11;
		n11.next = n12;
		n12.next = n13;
		ListNode n21 = new ListNode(21);
		ListNode n22 = new ListNode(22);
		ListNode n23 = new ListNode(23);
		n2.next = n21;
		n21.next = n22;
		n22.next = n23;
		ListNode[] lists = {n2,n1,n3};
		ListNode r = s.mergeKLists(lists);
		while(r!=null){
			System.out.println(r.val);
			r = r.next;
		}
	}

}
