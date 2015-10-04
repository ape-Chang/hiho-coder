package yjy.hiho;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	static class TreeNode {
		int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] in, int[] post,int iin,int jin,int ipost,int jpost) {
//		System.out.println(String.format("%d %d %d %d",iin,jin,ipost,jpost));
		if(iin==jin){
			return new TreeNode(in[iin]);
		}
		TreeNode cur = new TreeNode(post[jpost]);
		for(int i=iin;i<=jin;i++){
			if(in[i]==post[jpost]){
				int d = i-iin;
				if(i==iin){
					cur.left = null;
					cur.right = this.buildTree(in,post,i+1,jin,ipost, jpost-1);
				}else if(i==jin){
					cur.left = this.buildTree(in,post,iin,i-1,ipost,jpost-1);
					cur.right = null;
				}else{
					cur.left = this.buildTree(in,post,iin,i-1,ipost,ipost+d-1);
					cur.right = this.buildTree(in,post,i+1,jin,ipost+d, jpost-1);
				}
				break;
			}
		}
        return cur;
    }
	
	public TreeNode buildTree(int[] in, int[] post) {
		int n = in.length;
		if(n==0 || n!=post.length){
			return null;
		}
        return this.buildTree(in,post,0,n-1,0,n-1);
    }

	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal s = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		int[] inorder = {1,2,3,4};
		int[] postorder = {3,2,4,1};
		TreeNode r = s.buildTree(inorder, postorder);
		int ii=0;
		ii++;
	}

}
