package yjy.hiho;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
	
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private int target = 0;
	void visit(TreeNode node,int sum,Stack<Integer> s,List<List<Integer>> L){
		if(node==null){
			return;
		}
		s.push(node.val);
		if(node.right==null && node.left==null){
			if(sum+node.val==this.target){
				L.add(new ArrayList<Integer>(s));
			}
		}else{
			if(node.left!=null){
				this.visit(node.left,sum+node.val,s,L);
			}
			if(node.right!=null){
				this.visit(node.right,sum+node.val,s,L);
			}
		}
		s.pop();
		return;
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	this.target = sum;
    	List<List<Integer>> L = new ArrayList<List<Integer>>();
    	this.visit(root,0,new Stack<Integer>(),L);
        return L;
    }

	public static void main(String[] args) {
		PathSumII s = new PathSumII();
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(5);
		TreeNode n10 = new TreeNode(1);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n3.left=n5;
		n3.right=n6;
		n4.left=n7;
		n4.right=n8;
		n6.left=n9;
		n6.right=n10;
		List<List<Integer>> L = s.pathSum(n1,22);
		for(List<Integer> l:L){
			for(Integer i:l){
				System.out.print(String.format("%d ",i));
			}
			System.out.println("");
		}
	}

}
