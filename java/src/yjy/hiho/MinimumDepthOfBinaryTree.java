package yjy.hiho;

public class MinimumDepthOfBinaryTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
		if(root==null)return 0;
        if(root.left==null&&root.right==null){
        	return 1;
        }else if(root.left!=null&&root.right!=null){
        	int lh = minDepth(root.left);
            int rh = minDepth(root.right);
            return 1+Math.min(lh, rh);
        }else if(root.left!=null){
        	return 1+minDepth(root.left);
        }else{
        	return 1+minDepth(root.right);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
