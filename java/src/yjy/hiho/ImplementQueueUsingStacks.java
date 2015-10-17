package yjy.hiho;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	
	class MyQueue {
		Stack<Integer> s1;
		Stack<Integer> s2;
		
		MyQueue(){
			s1 = new Stack<Integer>();
			s2 = new Stack<Integer>();
		}
		
	    // Push element x to the back of queue.
	    public void push(int x) {
	        s1.push(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if(s2.isEmpty()){
	        	while(!s1.isEmpty())s2.push(s1.pop());
	        }
	        if(!s2.isEmpty()){
	        	s2.pop();
	        }
	    }

	    // Get the front element.
	    public int peek() {
	    	if(s2.isEmpty()){
	        	while(!s1.isEmpty())s2.push(s1.pop());
	        }
	    	return s2.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return s1.isEmpty()&&s2.isEmpty();
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
