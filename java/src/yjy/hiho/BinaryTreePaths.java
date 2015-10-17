package yjy.hiho;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
    
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	void visit(TreeNode node,Stack<Integer> l,ArrayList<String> r){
		l.push(node.val);
		if(node.left==null && node.right==null){
			int n = l.size();
			StringBuffer buf = new StringBuffer(String.format("%d",l.get(0)));
			for(int i=1;i<n;i++){
				buf.append(String.format("->%d",l.get(i)));
			}
			r.add(buf.toString());
			l.pop();
			return;
		}else{
			if(node.left!=null){visit(node.left,l,r);}
			if(node.right!=null){visit(node.right,l,r);}
		}
		l.pop();
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> r = new ArrayList<String>();
		if(root==null){return r;}
		visit(root,new Stack<Integer>(),r);
        return r;
    }
	
	public static void main(String[] args) {
		BinaryTreePaths s = new BinaryTreePaths();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n4.left = n5;
		n4.right = n6;
		s.binaryTreePaths(n1);
	}

}
