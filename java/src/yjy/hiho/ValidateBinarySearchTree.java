package yjy.hiho;

public class ValidateBinarySearchTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private int min;
	private int max;
	
    public boolean isValidBST(TreeNode root) {
    	if(root==null)return true;
    	int localMin = root.val;
    	int localMax = root.val;
    	if(root.left!=null){
    		min = root.left.val;max = root.left.val;
    		boolean r = isValidBST(root.left);
    		if(!r||root.val<=max)return false;
    		localMin = min;
    	}
    	if(root.right!=null){
    		min = root.right.val;max = root.right.val;
    		boolean r = isValidBST(root.right);
    		if(!r||root.val>=min)return false;
    		localMax = max;
    	}
    	min = localMin;
    	max = localMax;
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
