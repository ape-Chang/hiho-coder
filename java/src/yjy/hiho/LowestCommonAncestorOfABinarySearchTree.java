package yjy.hiho;

public class LowestCommonAncestorOfABinarySearchTree {

	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode cur = root;
		int min = Math.min(p.val,q.val);
		int max = Math.max(p.val,q.val);
		while(true){
			if(cur==null)return null;
			if(cur.val>=min && cur.val<=max){
				return cur;
			}else if(cur.val<min){
				cur = cur.right;
			}else if(cur.val>max){
				cur = cur.left;
			}
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
