package yjy.hiho;

public class SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	boolean isReflect(TreeNode t1,TreeNode t2){
		if(t1==null && t2==null){
			return true;
		}else if(t1!=null && t2!=null){
			if(t1.val!=t2.val){
				return false;
			}else{
				return isReflect(t1.left,t2.right)&&isReflect(t1.right,t2.left);
			}
		}else{
			return false;
		}
	}
	
    public boolean isSymmetric(TreeNode root) {
    	if(root==null){return true;}
        return isReflect(root.left,root.right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
