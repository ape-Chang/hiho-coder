package yjy.hiho;

import yjy.hiho.BinaryTreeInorderTraversal.TreeNode;

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
		if(root==null){return null;}
		invertTree(root.left);
		invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
