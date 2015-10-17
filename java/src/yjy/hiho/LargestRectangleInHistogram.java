package yjy.hiho;

import java.util.Stack;

public class LargestRectangleInHistogram {

	class Node{
		int i;
		int val;
		Node(int i,int val){
			this.i = i;
			this.val = val;
		}
	}
	
    public int largestRectangleArea(int[] h) {
    	Stack<Node> S = new Stack<Node>();
    	S.push(new Node(0,0));
    	int n = h.length;
    	int max = 0;
    	for(int i=0;i<n;i++){
    		if(S.peek().val<=h[i]){
    			S.push(new Node(i,h[i]));
    		}else{
    			int left = i;
    			while(S.peek().val>h[i]){
    				Node node = S.pop();
    				left = node.i;
    				max = Math.max(max,node.val*(i-node.i));
    			}
    			S.push(new Node(left,h[i]));
    		}
    	}
    	while(!S.isEmpty()){
			Node node = S.pop();
			max = Math.max(max,node.val*(n-node.i));
		}
        return max;
    }
	
	public static void main(String[] args) {
		LargestRectangleInHistogram s = new LargestRectangleInHistogram();
		int[] nums = {1,1,1};
		int r = s.largestRectangleArea(nums);
		System.out.println(r);
	}

}
