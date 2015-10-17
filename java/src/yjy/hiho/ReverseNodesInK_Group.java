package yjy.hiho;

public class ReverseNodesInK_Group {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		int i = 0;
		ListNode headNode = new ListNode(0);
		headNode.next = head;
		ListNode pre = headNode;
		ListNode cur = head;
		ListNode h1 = cur;
		while(cur!=null){
			cur = cur.next;
			i=(i+1)%k;
			if(i==0){
				ListNode h2 = cur;
				ListNode savedH1 = h1;
				while(h1!=cur){
					ListNode h1Next = h1.next;
					h1.next = h2;
					h2 = h1;
					h1 = h1Next;
				}
				pre.next = h2;
				pre = savedH1;
			}
		}
        return headNode.next;
    }
    
    public static void main(String[] args) {
    	ReverseNodesInK_Group s = new ReverseNodesInK_Group();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(10);
		ListNode n11 = new ListNode(11);
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
		ListNode r = s.reverseKGroup(n1,2);
		while(r!=null){
			System.out.println(String.format("%d",r.val));
			r=r.next;
		}
	}
}
