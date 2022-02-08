package internship.stackQueue;

import java.util.*;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		if(ispar(str)) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not Balanced");
		}
		
		sc.close();
	}
	
	static boolean ispar(String str)
    {
        Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			switch(ch) {
			case '}': if(!stack.isEmpty() && stack.peek() == '{')
						stack.pop();
					  else
					    return false;
					  break;
			case ']': if(!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					  else
					    return false;	
			  		  break;
			case ')': if(!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
			  		  else
					    return false;
			  		  break; 
			default: stack.push(ch); 		  
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		}
		
		return true;
    }

}
