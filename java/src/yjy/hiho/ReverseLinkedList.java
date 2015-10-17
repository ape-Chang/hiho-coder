package yjy.hiho;

public class ReverseLinkedList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode reverseList(ListNode head) {
    	ListNode r = new ListNode(0);
    	ListNode cur = head;
    	while(cur!=null){
    		ListNode rNext = r.next;
    		ListNode curNext = cur.next;
    		r.next = cur;
    		cur.next = rNext;
    		cur = curNext;
    	}
    	return r.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
