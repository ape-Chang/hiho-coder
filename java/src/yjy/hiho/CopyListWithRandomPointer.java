package yjy.hiho;

public class CopyListWithRandomPointer {
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode cur = head;
    	if(head==null)return null;
    	while(cur!=null){
    		RandomListNode curNext = cur.next;
    		RandomListNode curCopy = new RandomListNode(cur.label);
    		curCopy.random = cur.random;
    		cur.next = curCopy;
    		curCopy.next = curNext;
    		cur = curNext;
    	}
    	cur = head.next;
    	while(cur!=null){
    		if(cur.random!=null)cur.random = cur.random.next;
    		if(cur.next==null){break;}else{cur=cur.next.next;}
    	}
    	cur = head;
    	RandomListNode copyHead = head.next;
    	RandomListNode copyCur = copyHead;
    	while(cur!=null){
    		cur.next = cur.next.next;
    		if(copyCur.next!=null)copyCur.next = copyCur.next.next;
    		cur = cur.next;
    		copyCur = copyCur.next;
    	}
        return copyHead;
    }
	public static void main(String[] args) {
		CopyListWithRandomPointer s = new CopyListWithRandomPointer();
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n1.random = n5;
		n2.random = n1;
		n3.random = n3;
		n4.random = n5;
		n5.random = n1;
		RandomListNode r = s.copyRandomList(n1);
		while(r!=null){
			System.out.println(String.format("%d %d",r.label,r.random.label));
			r=r.next;
		}
	}

}
