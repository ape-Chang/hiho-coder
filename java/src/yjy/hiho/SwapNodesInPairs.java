package yjy.hiho;

public class SwapNodesInPairs {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode cur = head;
		if(head==null){
			return head;
		}else if(null != head.next){
			head = head.next;
		}else{
			return head;
		}
		
		while(cur!=null && cur.next!=null){
			pre.next = cur.next;
			ListNode tmp = cur.next.next;
			cur.next.next = cur;
			cur.next = tmp;
			pre = cur;
			cur = cur.next;
		}
        return head;
    }
	
	public static void main(String[] args) {
		SwapNodesInPairs s = new SwapNodesInPairs();
		int n = 5;
		ListNode nodes[] = new ListNode[n];
		for(int i=0;i<n;i++){
			nodes[i] = new ListNode(i);
		}
		for(int i=0;i<n-1;i++){
			nodes[i].next = nodes[i+1];
		}
		ListNode r = s.swapPairs(nodes[0]);
		ListNode cur = r;
		while(cur!=null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

}
