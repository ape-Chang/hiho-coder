package yjy.hiho;

public class RemoveNthNodeFromEndOfList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur2 = head;
		ListNode cur1 = head;
		for(int i=0;i<n;i++){
			cur2 = cur2.next;
		}
		if(cur2==null){
			head = head.next;
			return head;
		}
		while(cur2.next!=null){
			cur2 = cur2.next;
			cur1 = cur1.next;
		}
		cur1.next = cur1.next.next;
		return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
