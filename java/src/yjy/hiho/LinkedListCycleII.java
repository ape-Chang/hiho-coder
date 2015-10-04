package yjy.hiho;

public class LinkedListCycleII {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
		ListNode h1 = head;
		ListNode h2 = head;
		if(head==null || head.next==null || head.next.next==null){
			return null;
		}
		h1 = head.next;
		h2 = head.next.next;
		while(h1!=h2){
			if(h2.next==null || h2.next.next==null){
				return null;
			}
			h1=h1.next;
			h2=h2.next.next;
		}
		h1 = head;
		while(h1!=h2){
			h1=h1.next;
			h2=h2.next;
		}
        return h1;
    }

	public static void main(String[] args) {
		LinkedListCycleII s = new LinkedListCycleII();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n5;
		ListNode r = s.detectCycle(n1);
		System.out.println(r.val);
	}

}
