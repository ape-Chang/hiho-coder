package yjy.hiho;

public class FlattenBinaryTreeToLinkedList {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode flattenWithLast(TreeNode node) {
		TreeNode tmp = node;
		if(node.left!=null){
			tmp = this.flattenWithLast(node.left);
		}
		TreeNode r = tmp;
		TreeNode right = node.right;
		TreeNode left = node.left;
		if(right!=null){
			r = this.flattenWithLast(right);
		}
		if(left!=null){
			node.right = left;
			node.left = null;
		}
		tmp.right = right;
        return r;
    }
	
    public void flatten(TreeNode root) {
    	if(root==null){
    		return;
    	}
        this.flattenWithLast(root);
    }
	
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList s = new FlattenBinaryTreeToLinkedList();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;
		n5.right = n6;
		s.flatten(n1);
		TreeNode cur = n1;
		while(cur!=null){
			System.out.println(cur.val);
			cur=cur.right;
		}
	}

}
