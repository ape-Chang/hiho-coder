package yjy.hiho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	static class Node{
		TreeNode node;
		int level;
		Node(TreeNode node,int level){
			this.node = node;
			this.level = level;
		}
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
    	if(root==null)return r;
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(new Node(root,0));
        int curLevel = 0;
        ArrayList<Integer> row = new ArrayList<Integer>();
        while(!q.isEmpty()){
        	Node cur = q.poll();
        	if(curLevel == cur.level){row.add(cur.node.val);}
        	else{
        		curLevel = cur.level;
        		r.add(row);
        		row = new ArrayList<Integer>();
        		row.add(cur.node.val);
        	}
        	if(cur.node.left!=null){q.add(new Node(cur.node.left,cur.level+1));}
        	if(cur.node.right!=null){q.add(new Node(cur.node.right,cur.level+1));}
        }
        if(!row.isEmpty()){r.add(row);}
        return r;
    }
    
    public static void main(String[] args){
    	BinaryTreeLevelOrderTraversal s = new BinaryTreeLevelOrderTraversal();
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	TreeNode n3 = new TreeNode(3);
    	n1.left = n2;
    	n2.right = n3;
    	List<List<Integer>> r = s.levelOrder(n1);
    	for(List<Integer> l:r){
    		for(Integer i:l){
    			System.out.println(i);
    		}
    		System.out.println("");
    	}
    }
}
