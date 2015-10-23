package yjy.hiho;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	void visit(TreeNode node, List<Integer> r){
		if(node==null)return;
		visit(node.left,r);
		visit(node.right,r);
		r.add(node.val);
	}
	
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> r = new ArrayList<Integer>();
		this.visit(root,r);
		return r;
	}
	
	class Node{
		boolean visited;
		TreeNode innerNode;
		Node(TreeNode node){
			this.innerNode = node;
			this.visited = false;
		}
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> r = new ArrayList<Integer>();
		Stack<Node> ss = new Stack<Node>();
		if(root!=null)ss.push(new Node(root));
		while(!ss.isEmpty()){
			Node top = ss.peek();
			if(top.visited){
				r.add(top.innerNode.val);
				ss.pop();
			}else{
				top.visited = true;
				if(top.innerNode.right!=null){
					ss.push(new Node(top.innerNode.right));
				}
				if(top.innerNode.left!=null){
					ss.push(new Node(top.innerNode.left));
				}
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
