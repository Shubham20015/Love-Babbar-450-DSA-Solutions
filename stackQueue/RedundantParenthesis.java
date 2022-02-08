package internship.stackQueue;

import java.util.Stack;
import java.util.Scanner;

public class RedundantParenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		String str = sc.next();
		System.out.println(redundant(str) ? "Yes":"No");
		
		sc.close();
	}
	
	static boolean redundant(String str) {
		Stack<Character> stack = new Stack<>();
		char arr[] = str.toCharArray();
		for(char ch : arr) {
			if(ch == ')') {
				
				char top = stack.pop();
				boolean flag = true;
				
				while(top != '(') {
					if(top == '*' || top == '/' || top == '-' || top == '+')
						flag = false;
					stack.pop();
				}
				
				if(flag == true) return true;
			}else {
				stack.push(ch);
			}
		}
		
		return false;
	}

}
