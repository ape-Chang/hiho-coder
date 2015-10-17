package yjy.hiho;

public class RemoveLinkedListElements {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode removeElements(ListNode head, int val) {
    	ListNode h = new ListNode(0);
    	h.next = head;
    	ListNode cur = h;
    	while(cur!=null){
    		while(cur.next!=null&&cur.next.val==val){cur.next = cur.next.next;}
    		cur = cur.next;
    	}
        return h.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
