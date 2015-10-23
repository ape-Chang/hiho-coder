package yjy.hiho;

public class PalindromeLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public boolean isPalindrome(ListNode head) {
		if(head==null){return true;}
		ListNode cur1 = head;
		ListNode cur2 = head;
		boolean isEvent = false;
		while(cur2.next!=null){
			cur1 = cur1.next;
			cur2 = cur2.next;
			if(cur2.next!=null){
				cur2 = cur2.next;
			}else{
				isEvent = true;
			}
		}
		if(!isEvent){
			cur1 = cur1.next;
		}
		if(cur1==null){return true;}
		ListNode holder = new ListNode(0);
		while(cur1!=null){
			ListNode cur1Next = cur1.next;
			cur1.next = holder.next;
			holder.next = cur1;
			cur1 = cur1Next;
		}
		cur1 = holder.next;
		cur2 = head;
		while(cur1!=null){
			if(cur1.val!=cur2.val)return false;
			cur2 = cur2.next;
			cur1 = cur1.next;
		}
        return true;
    }
	
	public static void main(String[] args) {
		PalindromeLinkedList s = new PalindromeLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		boolean r = s.isPalindrome(n1);
		System.out.println(r);
	}

}
