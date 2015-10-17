package yjy.hiho;

public class BalancedBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	private boolean isBalance;
	public int nodeHeight(TreeNode root){
		if(root==null)return 0;
		int lh = nodeHeight(root.left);
		if(!this.isBalance){return 0;}
		int rh = nodeHeight(root.right);
		if(!this.isBalance){return 0;}
		if(Math.abs(lh-rh)>1){
			this.isBalance = false;
		}
		return 1+Math.max(lh, rh);
	}
    public boolean isBalanced(TreeNode root) {
        if(root==null){return true;}
        isBalance = true;
        nodeHeight(root);
        return isBalance;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
