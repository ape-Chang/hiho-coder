package yjy.hiho;
public class PathSum {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	boolean visit(TreeNode node,int sum,int acc){
		if(node.left==null && node.right==null){
			return acc+node.val==sum;
		}
		if(node.left!=null&&visit(node.left,sum,acc+node.val))return true;
		if(node.right!=null&&visit(node.right,sum,acc+node.val))return true;
		return false;
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null)return false;
        return visit(root,sum,0);
    }
    
	public static void main(String[] args) {
		PathSum s = new PathSum();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		boolean r = s.hasPathSum(n1,1);
		System.out.println(r);
	}

}
