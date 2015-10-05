package yjy.hiho;

public class CountCompleteTreeNodes {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int leftDepth(TreeNode node){
		TreeNode cur = node;
		int count=0;
		while(cur!=null){
			cur = cur.left;
			count++;
		}
		return count;
	}
	
	public int countNodes(TreeNode root) {
		if(root==null){
			return 0;
		}
		TreeNode cur = root;
		int L = leftDepth(root);
		cur = root;
		int r = 1;
		while(true){
			if(leftDepth(cur.right)==L-1){
				cur = cur.right;
				if(cur==null)
					break;
				r = (r<<1)+1;
			}else{
				cur = cur.left;
				if(cur==null)
					break;
				r = r<<1;
			}
			L--;
		}
        return r;
    }
	
	public static void main(String[] args) {
		CountCompleteTreeNodes s = new CountCompleteTreeNodes();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
//		TreeNode n7 = new TreeNode(7);
//		TreeNode n8 = new TreeNode(8);
//		TreeNode n9 = new TreeNode(9);
//		TreeNode n10 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
//		n3.right = n7;
//		n4.left = n8;
//		n4.right = n9;
//		n5.left = n10;
		int r = s.countNodes(n1);
		System.out.println(r);
	}

}
