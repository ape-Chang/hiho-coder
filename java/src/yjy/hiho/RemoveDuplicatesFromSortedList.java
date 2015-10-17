package yjy.hiho;

public class RemoveDuplicatesFromSortedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode cur = head;
		while(cur.next!=null){
			if(cur.next.val==cur.val){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
			}
		}
        return head;
    }

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList s = new RemoveDuplicatesFromSortedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);
		ListNode n8 = new ListNode(5);
		ListNode n9 = new ListNode(6);
		ListNode n10 = new ListNode(7);
		ListNode n11 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n11;
		s.deleteDuplicates(n1);
		ListNode n = n1;
		while(n!=null){
			System.out.println(n.val);
			n = n.next;
		}
	}

}
