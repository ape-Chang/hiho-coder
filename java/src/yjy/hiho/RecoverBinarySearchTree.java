package yjy.hiho;

public class RecoverBinarySearchTree {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private TreeNode firstNode;
	private TreeNode secondNode;
	private TreeNode cur;
	private TreeNode last;
	private TreeNode tmp;
	
	public void visit(TreeNode node){
		if(node.left!=null){
			visit(node.left);
		}
		last = cur;
		cur = node;
		if(last!=null&&last.val>cur.val){
			if(firstNode==null){
				firstNode = last;
				tmp = cur;
			}else if(secondNode==null){
				secondNode = cur;
			}else{
				return;
			}
		}
		if(node.right!=null){
			visit(node.right);
		}
	}

    public void recoverTree(TreeNode root) {
    	if(root==null)return;
    	firstNode = null;
    	secondNode = null;
    	cur = null;
    	last = null;
    	visit(root);
    	if(firstNode!=null){
    		if(secondNode==null){
    			secondNode = tmp;
    		}
    		int tmp = firstNode.val;
    		firstNode.val = secondNode.val;
    		secondNode.val = tmp;
    	}
    }
	
	public static void main(String[] args) {
		RecoverBinarySearchTree s = new RecoverBinarySearchTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		s.recoverTree(n1);
		int ii = 0;
		ii++;
	}

}
