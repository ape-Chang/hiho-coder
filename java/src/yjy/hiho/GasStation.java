package yjy.hiho;

public class GasStation {
	
	class Node{
		int val;
		int index;
		Node next;
		Node(int index){
			this.index = index;
			this.next = null;
		}
	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int n = gas.length;
    	if(n==0 || n!=cost.length){
    		return -1;
    	}else if(n==1){
    		if(gas[0]-cost[0]>=0){
    			return 0;
    		}else{
    			return -1;
    		}
    	}
    	int[] a = new int[n];    	
    	for(int i=0;i<n;i++){
    		a[i]=gas[i]-cost[i];
    	}
    	Node head = new Node(0);
    	head.val = a[0];
    	Node cur = head;
    	for(int i=1;i<n;i++){
    		Node tmp = new Node(i);
    		cur.next = tmp;
    		tmp.val = a[i];
    		cur = tmp;
    	}
    	cur.next = head;
    	while(head.next!=head){
    		int val = head.val;
    		if(val>=0){
    			int nextVal = head.next.val;
    			head.next = head.next.next;
    			head.val+=nextVal;
    		}else{
    			int nextVal = head.next.val;
    			if(nextVal>=0){
    				head = head.next;
    			}else{
        			head.next = head.next.next;
        			head.val+=nextVal;
    			}
    		}
    	}
    	if(head.val>=0){
    		return head.index;
    	}else{
    		return -1;
    	}
    }
	public static void main(String[] args) {
		GasStation s = new GasStation();
		int[] gas = {2,0,2,40};
		int[] cost = {5,5,5,5};
		int r = s.canCompleteCircuit(gas, cost);
		System.out.println(r);
	}

}
