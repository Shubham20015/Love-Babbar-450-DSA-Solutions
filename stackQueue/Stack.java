package internship.stackQueue;

public class Stack {
	private int maxSize = 10;
	private long array[];
	private int top;
	
	public Stack() {
		array = new long[maxSize];
		top = -1;
	}
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		array = new long[maxSize];
		top = -1;
	}
	
	public void push(long x) {
		if(isFull()) {
			maxSize *= 2;
		}
		array[++top] = x;
	}
	
	public long pop() {
		if(isEmpty()) {
			System.out.println("Stack is already empty");
			return -1;
		}
		return array[top--];
	}
	
	public int size() {
		return top+1;
	}
	
	public long peek() {
		return array[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	private boolean isFull() {
		return top == maxSize-1;
	}
}
