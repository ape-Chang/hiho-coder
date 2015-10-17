package yjy.hiho;

public class PartitionList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public ListNode partition(ListNode head, int x) {
    	if(head==null){
    		return null;
    	}
    	ListNode l = new ListNode(0);
    	ListNode llast = l;
    	ListNode r = new ListNode(0);
    	ListNode rlast = r;
    	ListNode cur = head;
    	while(cur!=null){
    		if(cur.val>=x){
    			rlast.next = cur;
    			rlast = cur;
    		}else{
    			llast.next = cur;
    			llast = cur;
    		}
    		cur=cur.next;
    	}
    	llast.next = r.next;
    	rlast.next = null;
        return l.next;
    }
	public static void main(String[] args) {
		PartitionList s = new PartitionList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		ListNode r = s.partition(n1,3);
		while(r!=null){
			System.out.println(r.val);
			r = r.next;
		}
	}

}
