package yjy.hiho;

public class LowestCommonAncestorOfABinaryTree {
	private TreeNode result = null;
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int visit(TreeNode node, TreeNode p, TreeNode q){
		int r = 0;
		if(node==p){
			r = r|1;
		}
		if(node==q){
			r = r|2;
		}
		if(node.left!=null){
			r = r|this.visit(node.left, p, q);
		}
		if(node.right!=null){
			r = r|this.visit(node.right, p, q);
		}
		if(r==3 && result==null){
			result = node;
		}
		return r;
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	result = null;
    	this.visit(root,p,q);
        return this.result;
    }
    
	public static void main(String[] args) {
		LowestCommonAncestorOfABinaryTree s = new LowestCommonAncestorOfABinaryTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		TreeNode r = s.lowestCommonAncestor(n1,n4,n5);
		System.out.println(r.val);
	}

}
