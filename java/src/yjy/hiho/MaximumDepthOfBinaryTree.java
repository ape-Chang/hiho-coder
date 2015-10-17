package yjy.hiho;

public class MaximumDepthOfBinaryTree {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	int visit(TreeNode node){
		if(node==null){return 0;}
		int r = Math.max(visit(node.left), visit(node.right));
		return r+1;
		
	}
    public int maxDepth(TreeNode root) {
        return visit(root);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
