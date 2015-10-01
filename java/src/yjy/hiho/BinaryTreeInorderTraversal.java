package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> R = new ArrayList<Integer>();
		this.TraversalIn(root,R);
        return R;
    }
	
	public void TraversalIn(TreeNode node,List<Integer> l){
		if(node==null){
			return;
		}
		this.TraversalIn(node.left,l);
		l.add(node.val);
		this.TraversalIn(node.right, l);
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> R = new ArrayList<Integer>();
		this.TraversalPre(root,R);
        return R;
    }
	
	public void TraversalPre(TreeNode node,List<Integer> l){
		if(node==null){
			return;
		}
		l.add(node.val);
		this.TraversalPre(node.left,l);
		this.TraversalPre(node.right, l);
	}

	public static void main(String[] args) {
		BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.right = n2;
		n2.left = n3;
		List<Integer> r = s.inorderTraversal(n1);
		for(Integer i:r){
			System.out.println(i);
		}
	}

}
