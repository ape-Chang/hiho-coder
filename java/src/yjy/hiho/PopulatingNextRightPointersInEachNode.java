package yjy.hiho;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {
	
	
	
	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	static class Node{
		int layer;
		TreeLinkNode innernode;
		Node(TreeLinkNode node,int layer){
			this.innernode = node;
			this.layer = layer;
		}
	}
	
	public void connect(TreeLinkNode root) {
		if(root==null){
			return;
		}
        Node rootNode = new Node(root,0);
        LinkedList<Node> Q = new LinkedList<Node>();
        Q.add(rootNode);
        Node pre = null;
        while(!Q.isEmpty()){
        	Node n = Q.poll();
        	if(pre!=null){
        		if(pre.layer==n.layer){
        			pre.innernode.next = n.innernode;
        		}else{
        			pre.innernode.next = null;
        		}
        	}
        	pre = n;
        	TreeLinkNode left = n.innernode.left;
        	TreeLinkNode right = n.innernode.right;
        	if(left!=null){
        		Q.add(new Node(left,n.layer+1));
        	}
        	if(right!=null){
        		Q.add(new Node(right,n.layer+1));
        	}
        }
    }

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode s = new PopulatingNextRightPointersInEachNode();
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		s.connect(n1);
		TreeLinkNode n = n7;
		if(n.next!=null){
			System.out.println(n.next.val);
		}
		
		
		
	}

}
