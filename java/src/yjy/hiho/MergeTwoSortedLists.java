package yjy.hiho;

public class MergeTwoSortedLists {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode cur=head,cur1=l1,cur2=l2;
		while(cur1!=null && cur2!=null){
			if(cur1.val<cur2.val){
				cur.next = cur1;
				cur = cur.next;
				cur1 = cur1.next;
			}else{
				cur.next = cur2;
				cur = cur.next;
				cur2 = cur2.next;
			}
		}
		while(cur1!=null){
			cur.next = cur1;
			cur = cur.next;
			cur1 = cur1.next;
		}
		while(cur2!=null){
			cur.next = cur2;
			cur = cur.next;
			cur2 = cur2.next;
		}
		cur.next = null;
		return head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
