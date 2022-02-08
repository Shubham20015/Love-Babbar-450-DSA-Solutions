package internship.stackQueue;

import java.util.Stack;
import java.util.Scanner;

public class RecursiveReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		stack.add('a');
		stack.add('b');
		stack.add('c');
		stack.add('d');
		
		System.out.println(stack);
		reverse();
		System.out.println(stack);
		
		sc.close();
	}
	
	static Stack<Character> stack = new Stack<>();
	
	static void reverse() {
		if(stack.size()>0) {
			char ch = stack.pop();
			reverse();
			insertAtBottom(ch);
		}
	}
	
	static void insertAtBottom(char ch) {
		if(stack.size() == 0) {
			stack.add(ch);
			return ;
		}
		else {
			char x = stack.pop();
			insertAtBottom(ch);
			stack.push(x);
		}
	}
}
