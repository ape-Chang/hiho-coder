package yjy.hiho;

public class LinkedListCycle {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public boolean hasCycle(ListNode head) {
		ListNode h1 = head;
		ListNode h2 = head;
		if(h1==null){
			return false;
		}
		h1 = h1.next;
		h2 = h2.next;
		if(h1==null){
			return false;
		}
		h2 = h2.next;
		while(h1!=h2){
			if(h2==null || h2.next == null){
				return false;
			}
			h1 = h1.next;
			h2 = h2.next.next;
		}
		
        return true;
    }

	public static void main(String[] args) {
		LinkedListCycle s = new LinkedListCycle();
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(0);
		ListNode n5 = new ListNode(0);
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n0;
		boolean r = s.hasCycle(n0);
		System.out.println(r);
	}

}
