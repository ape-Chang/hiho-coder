package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	
	class Node{
		boolean isOp;
		int val;
		Node(boolean isOp,int val){
			this.isOp = isOp;
			this.val = val;
		}
	}
	
	public List<Integer> diffResult(Node[] nodes,int i,int j){
//		System.out.println(String.format("%d %d",i,j));
		ArrayList<Integer> r = new ArrayList<Integer>();
		if(i==j){
			r.add(nodes[i].val);
			return r;
		}else if(i>j){
			return r;
		}
		for(int k=i+1;k<j;k+=2){
			List<Integer> left = this.diffResult(nodes,i,k-1);
			List<Integer> right = this.diffResult(nodes,k+1,j);
			for(Integer leftD:left){
				for(Integer rightD:right){
					switch(nodes[k].val){
					case '+':
						r.add(leftD+rightD);
						break;
					case '-':
						r.add(leftD-rightD);
						break;
					case '*':
						r.add(leftD*rightD);
						break;
					}
				}
			}
		}
		return r;
	}
	
    public List<Integer> diffWaysToCompute(String input) {
    	char[] c = input.toCharArray();
    	int n = c.length;
    	
    	ArrayList<Node> nodeList = new ArrayList<Node>();
    	int digit = 0;
    	for(int i=0;i<n;i++){
    		if(c[i]>='0' &&c[i]<='9'){
    			digit = digit*10+(c[i]-'0');
    		}else{
    			nodeList.add(new Node(false,digit));
    			digit = 0;
    			nodeList.add(new Node(true,c[i]));
    		}
    	}
    	nodeList.add(new Node(false,digit));
    	Node[] nodes = new Node[nodeList.size()];
    	int i=0;
    	for(Node nn:nodeList){
    		nodes[i] = nn;
    		i++;
    	}
        return this.diffResult(nodes,0,nodes.length-1);
    }

	public static void main(String[] args) {
		DifferentWaysToAddParentheses s = new DifferentWaysToAddParentheses();
		List<Integer> r = s.diffWaysToCompute("2*3-4*5");
		for(Integer i : r){
			System.out.println(i);
		}
	}

}
