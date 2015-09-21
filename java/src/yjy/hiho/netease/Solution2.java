package yjy.hiho.netease;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	public static int solveCase(Scanner scan){
		String S = scan.nextLine();
		char[] CC = S.toCharArray();
		int N = CC.length;
		int sum = 0;
		int op = 0;
		char lastElm = '#';
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<N;i++){
			if(CC[i]=='('){
				stack.push(sum);
				sum = 0;
				lastElm = '(';
				continue;
			}
			
			if(CC[i]==')'){
				stack.push(sum);
				sum = stack.pop()+sum;
				lastElm = ')';
				continue;
			}
			
			if(CC[i]>='A' && CC[i]<='Z'){
				sum++;
				lastElm = 'A';
				continue;
			}
			
			if(CC[i]>='0' && CC[i]<='9'){
				if(lastElm == '0'){
					op = op*10+(CC[i]-'0');
				}else if(lastElm == 'A'){
					op = CC[i]-'0';
				}
				lastElm = '0';
				continue;
			}
		}
		return sum;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String NStr = scan.nextLine();
		int N = Integer.parseInt(NStr);
		for(int i=0;i<N;i++){
			int result = Solution2.solveCase(scan);
			System.out.println(result);
		}
		scan.close();
	}
}
