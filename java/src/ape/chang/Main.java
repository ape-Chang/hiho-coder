package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    
    private static int count9706(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray())
	    if (c == '9' || c == '0' || c == '7' || c == '6') 
		stack.push(c);
	int count = 0;
	while (!stack.isEmpty()) {
	    Stack<Character> _stack = new Stack<Character>();
	    String pattern = "6079";
	    int k = 0;
	    while (!stack.isEmpty()) {
		char c = stack.pop();
		if (c == pattern.charAt(k))
		    k++;
		else
		    _stack.push(c);
		if (k == 4) {
		    ++count;
		    while (!_stack.isEmpty()) stack.push(_stack.pop());
		    break;
		}
	    }
	}
	return count;
    }
           
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int t = Integer.valueOf(scanner.nextLine());
	while (t-- > 0) {
	    String s = scanner.next();
	    System.out.println(count9706(s));
	}
	scanner.close();
    }

}

