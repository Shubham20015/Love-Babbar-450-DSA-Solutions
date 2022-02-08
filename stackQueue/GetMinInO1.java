package internship.stackQueue;

import java.util.Stack;

public class GetMinInO1 {
	private Stack<Integer> stack;
	private Integer minElement;
	
	GetMinInO1(){
		stack = new Stack<>();
	}
	
	public int getMin() {
		if(stack.isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return minElement;
	}
	
	public void push(int item) {
		if(stack.isEmpty()) {
			minElement = item;
			stack.add(item);
			return;
		}
		
		if(item < minElement) {
			stack.add(2*item - minElement);
			minElement = item;
		}
		
		else {
			stack.push(item);
		}
	}
	
	public int pop() {
		if(stack.isEmpty()) {
			System.out.println("Stack Empty Already");
			return -1;
		}
		
		int item = stack.pop();
		
		if(item < minElement) {
			minElement = 2*minElement - item;
		}
		
		return item;
	}
	
	public int peek()
    {
        if (stack.isEmpty())
        {
            System.out.println("Stack is empty ");
            return -1;
        }
 
        int item = stack.peek();
        
        if (item < minElement)
            return minElement;
        else
            return item;
    }
	
	public static void main() {
		GetMinInO1 s = new GetMinInO1();
        s.push(3);
        s.push(5);
        System.out.println("Min Element: " + s.getMin());
        s.push(2);
        s.push(1);
        System.out.println("Min Element: " + s.getMin());
        System.out.println("Popped Element: " + s.pop());
        System.out.println("Min Element: " + s.getMin());
        System.out.println("Popped Element: " + s.pop());
        System.out.println("Top Element: " + s.peek());
	}
}
