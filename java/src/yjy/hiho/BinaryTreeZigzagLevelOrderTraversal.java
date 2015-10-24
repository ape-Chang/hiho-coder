package yjy.hiho;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	class Node{
		TreeNode node;
		int level;
		Node(TreeNode node,int level){
			this.node = node;
			this.level = level;
		}
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
    	if(root==null){return r;}
    	LinkedList<Node> q = new LinkedList<Node>();    	
    	q.add(new Node(root,1));
    	int curLv = 0;
    	ArrayDeque<Integer> ll = null;
    	while(!q.isEmpty()){
    		Node nn = q.poll();
    		if(nn.level==curLv){
    			if(curLv%2==0){
    				ll.addFirst(nn.node.val);
    			}else{
    				ll.addLast(nn.node.val);
    			}
    		}else{
    			curLv = nn.level;
    			if(ll!=null){r.add(new ArrayList<Integer>(ll));}
    			ll = new ArrayDeque<Integer>();
    			ll.add(nn.node.val);
    		}
    		if(nn.node.left!=null){
    			q.add(new Node(nn.node.left,nn.level+1));
    		}
    		if(nn.node.right!=null){
    			q.add(new Node(nn.node.right,nn.level+1));
    		}
    	}
    	if(ll!=null){r.add(new ArrayList<Integer>(ll));}
        return r;
    }
    
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode n3 = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);
		n3.left = n9;
		n3.right = n20;
		n20.left = n15;
		n20.right = n7;
		List<List<Integer>> r = s.zigzagLevelOrder(n3);
		System.out.println(r);
	}

}
