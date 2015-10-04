package yjy.hiho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	static class Node{
		int layer;
		TreeNode innernode;
		Node(TreeNode node,int layer){
			this.innernode = node;
			this.layer = layer;
		}
	}
	
    public List<Integer> rightSideView(TreeNode root) {
    	ArrayList<Integer> r = new ArrayList<Integer>();
    	if(root==null){
			return r;
		}
        Node rootNode = new Node(root,0);
        LinkedList<Node> Q = new LinkedList<Node>();
        Q.add(rootNode);
        Node pre = null;
        while(!Q.isEmpty()){
        	Node n = Q.poll();
        	if(pre!=null){
        		if(pre.layer!=n.layer){
        			r.add(pre.innernode.val);
        		}
        	}
        	pre = n;
        	TreeNode left = n.innernode.left;
        	TreeNode right = n.innernode.right;
        	if(left!=null){
        		Q.add(new Node(left,n.layer+1));
        	}
        	if(right!=null){
        		Q.add(new Node(right,n.layer+1));
        	}
        }
        r.add(pre.innernode.val);
        return r;
    }
	public static void main(String[] args) {
		BinaryTreeRightSideView s = new BinaryTreeRightSideView();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		List<Integer> r = s.rightSideView(n1);
		for(Integer i:r){
			System.out.println(i);
		}
	}

}
