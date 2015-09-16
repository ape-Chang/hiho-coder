package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    
    static class Token {
	public int token;
	public Type type;
	public Token(int token, Type type) {
	    this.token = token;
	    this.type = type;
	}
	@Override public String toString() {return type.toString();}
	enum Type {character, number, left, right, eos}
    }
    
    static class TokenStream {
	char[] A;
	int k;
	public TokenStream(String s) {
	    A = s.toCharArray();
	    k = 0;
	}
	public Token next() {
	    if (k == A.length)
		return new Token(-1, Token.Type.eos);
	    else if (A[k] == '(')
		return new Token(A[k++], Token.Type.left);
	    else if (A[k] == ')')
		return new Token(A[k++], Token.Type.right);
	    else if (Character.isUpperCase(A[k]))
		return new Token(A[k++], Token.Type.character);
	    else {
		int n = A[k++] - '0';
		while (k < A.length && Character.isDigit(A[k])) 
		    n = 10*n + A[k++]-'0';
		return new Token(n, Token.Type.number);
	    }
	}
    }
           
    private static int count(Stack<Token> stack) {
	if (stack.size() == 0) return 0;
	if (stack.size() == 1) return 1;
	
	int count = 0;
	Token token = stack.pop();
	while (!stack.isEmpty()) {
	    Token _token = stack.pop();
	    if (_token.type == Token.Type.number) {
		count += _token.token;
		if (!stack.isEmpty()) token = stack.pop();
		else token = null;
	    } else {
		count++;
		token = _token;
	    }
	}
	if (token != null) count++;
	return count;
    }
    
    private static int countChar(String s) {
	TokenStream stream = new TokenStream(s);
	Stack<Token> stack = new Stack<Token>();
	Token token = stream.next();
	int count = 0;
	while (token.type != Token.Type.eos) {
	    if (token.type != Token.Type.right) stack.push(token);
	    else {
		Token times = stream.next();
		
		Stack<Token> _stack = new Stack<Token>();
		Token _token = stack.pop();
		while (_token.type != Token.Type.left) {
		    _stack.push(_token);
		    _token = stack.pop();
		}
		count = (count + count(_stack))*times.token;
	    }
	    token = stream.next();
	}
	if (!stack.isEmpty()) count += count(stack);
	return count;
    }
    
    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int t = Integer.valueOf(scanner.nextLine());
	while (t-- > 0) {
	    String s = scanner.next();
	    System.out.println(countChar(s));
	}
	scanner.close();
    }

}

