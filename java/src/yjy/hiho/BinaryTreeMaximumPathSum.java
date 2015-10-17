package yjy.hiho;

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private int max = 0;
	public int visit(TreeNode node){
		int left=0,right=0;
		if(node.left!=null){
			left = Math.max(left,this.visit(node.left));
		}
		if(node.right!=null){
			right = Math.max(right,this.visit(node.right));
		}
		this.max = Math.max(this.max,left+right+node.val);
		return Math.max(left,right)+node.val;
	}
	
    public int maxPathSum(TreeNode root) {
    	max = root.val;
    	this.visit(root);
        return max;
    }
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum s = new BinaryTreeMaximumPathSum();
		s.maxPathSum(null);
	}

}
