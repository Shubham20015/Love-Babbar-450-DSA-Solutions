package internship.string;

import java.util.*;

public class BalancedParenthesis {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		Stack<Character> stack = new Stack<>();
		boolean flag = true;
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			switch(ch) {
			case '}': if(!stack.isEmpty() && stack.peek() == '{')
						stack.pop();
					  else
						  flag = false;
					  break;
			case ']': if(!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					  else
						  flag = false;
			  		  break;
			case ')': if(!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					  else
						  flag = false;
			  		  break; 
			default: stack.push(ch); 		  
			}
		}
		
		if(!stack.isEmpty()) {
			flag = false;
		}
		
		System.out.println(flag);
		
		sc.close();
	}
}
