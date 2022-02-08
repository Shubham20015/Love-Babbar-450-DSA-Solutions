package internship.stackQueue;

import java.util.Stack;
import java.util.Scanner;

// time complexity and space complexity is same for both

public class InsertAtBottom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<size;i++) {
			stack.add(sc.nextInt());
		}
		Stack<Integer> res = insertAtBottomRec(stack,n);
		while(!res.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
		sc.close();
	}
	
	static void insertAtBottom(Stack<Integer> stack, int n) {
		Stack<Integer> temp = new Stack<>();
		while(!stack.isEmpty()) {
			temp.add(stack.pop());
		}
		stack.add(n);
		while(!temp.isEmpty()) {
			stack.add(temp.pop());
		}
	}
	
	static Stack<Integer> insertAtBottomRec(Stack<Integer> stack, int n) {
		if(stack.size() == 0)
			stack.add(n);
		else {
			int x = stack.peek();
			stack.pop();
			stack = insertAtBottomRec(stack, n);
			stack.add(x);
		}
		return stack;
	}

}
