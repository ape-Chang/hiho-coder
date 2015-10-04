package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<TreeNode> generateTrees(int n) {
		if(n==0){
			List<TreeNode> tmp = new ArrayList<TreeNode>();
			tmp.add(null);
			return tmp;
		}
		return this.generateTreesR(1,n);
	}
	
	public List<TreeNode> generateTreesR(int i,int j){
		ArrayList<TreeNode> r =  new ArrayList<TreeNode>();
		if(i==j){
			r.add(new TreeNode(i));
			return r;
		}else if(j<i){
			return r;
		}
		for(int k=i;k<=j;k++){
			List<TreeNode> left = this.generateTreesR(i,k-1);
			List<TreeNode> right = this.generateTreesR(k+1,j);
			if(left.isEmpty()){
				for(TreeNode n:right){
					TreeNode root = new TreeNode(k);
					root.left = null;
					root.right = n;
					r.add(root);
				}
				continue;
			}
			if(right.isEmpty()){
				for(TreeNode n:left){
					TreeNode root = new TreeNode(k);
					root.right = null;
					root.left = n;
					r.add(root);
				}
				continue;
			}
			for(TreeNode rn:right){
				for(TreeNode ln:left){
					TreeNode root = new TreeNode(k);
					root.right = rn;
					root.left = ln;
					r.add(root);
				}
			}
		}
		return r;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII s = new UniqueBinarySearchTreesII();
		List<TreeNode> r = s.generateTrees(1);
		r.add(null);
		int ii=0;
		ii++;
	}

}
