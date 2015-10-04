package yjy.hiho;

public class SumRootToLeafNumbers {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public int sumNumbers(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	int r = this.calculateSum(root,0);
        return r;
    }
    
    public int calculateSum(TreeNode node,int sum){
    	int tmp = sum*10+node.val;
    	if(node.left==null&&node.right==null){
    		return tmp;
    	}
    	int l=0;
    	int r=0;
    	if(node.left!=null){
    		l = this.calculateSum(node.left,tmp);
    	}
    	if(node.right!=null){
    		r = this.calculateSum(node.right,tmp);
    	}
    	
    	return l+r;
    }
    
	public static void main(String[] args) {
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		int r = s.sumNumbers(n1);
		System.out.println(r);
	}

}
