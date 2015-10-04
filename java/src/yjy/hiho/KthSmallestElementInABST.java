package yjy.hiho;

public class KthSmallestElementInABST {
	boolean found;
	int count;
	int k;
	int r;
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	void countNode(TreeNode node){
		if(node.left!=null){
			this.countNode(node.left);
			if(found){
				return;
			}
		}
		count++;
		if(count==k){
			r = node.val;
			found = true;
			return;
		}
		if(node.right!=null){
			this.countNode(node.right);
			if(found){
				return;
			}
		}
		return;
	}
	
	public int kthSmallest(TreeNode root, int k) {
		this.found = false;
		this.count = 0;
		this.k = k;
		this.countNode(root);
		return this.r;
	}
		 
	public static void main(String[] args){
		
	}
}
