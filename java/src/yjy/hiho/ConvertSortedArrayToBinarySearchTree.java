package yjy.hiho;

public class ConvertSortedArrayToBinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	TreeNode generate(int[] nums,int i,int j){
		int mid = (i+j)/2;
		TreeNode root = new TreeNode(nums[mid]);
		if(i!=mid){
			root.left = this.generate(nums,i,mid-1);
		}
		if(j!=mid){
			root.right = this.generate(nums,mid+1,j);
		}
		return root;
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums.length==0)return null;
        return this.generate(nums,0,nums.length-1);
    }
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree s = new ConvertSortedArrayToBinarySearchTree();
		int nums[] = {1,2,3,4,5,6,7,8,9};
		TreeNode r = s.sortedArrayToBST(nums);
	}

}
