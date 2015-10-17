package yjy.hiho;

public class DeleteNodeInALinkedList {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public void deleteNode(ListNode node) {
        if(node.next==null){return;}
        node.val = node.next.val;
        node.next = node.next.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
