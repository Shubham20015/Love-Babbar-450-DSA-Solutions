package internship.stackQueue;

public class StackUsingDeque {
	static class Dnode{
		int value;
		Dnode next;
		Dnode prev;
		
		Dnode(int val){
			value = val;
			next = prev = null;
		}
	}
	
	static class Deque {
		private Dnode head; 
		private Dnode tail;
		
		Deque(){
			head = tail = null;
		}
		
		boolean isEmpty() {
			return head == null;
		}
		
		int size() {
			if(!isEmpty()) {
				Dnode temp = head;
				int len = 0;
				while(temp != null) {
					len++;
					temp = temp.next;
				}
				return len;
			}
			return 0;
		}
		
		void insertFirst(int element) {
			Dnode node = new Dnode(element);
			if(isEmpty()) {
				head = tail = node;
			}else {
				head.prev = node;
				node.next = head;
				head = node;
			}
		}
		
		void insertLast(int element) {
			Dnode node = new Dnode(element);
			if(isEmpty()) {
				head = tail = node;
			}else {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
		}
		
		int removeFirst() {
			if(isEmpty()) {
				System.out.println("Underflow");
				return -1;
			}
			int x = head.value;
			head = head.next;
			head.prev = null;
			return x;
		}
		
		int removeLast() {
			if(isEmpty()) {
				System.out.println("Underflow");
				return -1;
			}
			int x = tail.value;
			tail = tail.prev;
			tail.next = null;
			return x;
		}
		
		void display() {
			if(!isEmpty()) {
				Dnode curr = head;
				while(curr != null) {
					System.out.print(curr.value + " ");
					curr = curr.next;
				}
				return ;
			}
			System.out.println("List is Empty");
		}
	}
	
	static class Stack{
		Deque q = new Deque();
		
		void push(int x) {
			q.insertLast(x);
		}
		int pop() {
			return q.removeLast();
		}
		int size() {
			return q.size();
		}
		void display() {
			q.display();
		}
		boolean isEmpty() {
			return q.isEmpty();
		}
	}
	
	static class Queue{
		Deque q = new Deque();
		
		void offer(int x) {
			q.insertLast(x);
		}
		int poll() {
			return q.removeFirst();
		}
		int size() {
			return q.size();
		}
		void display() {
			q.display();
		}
		boolean isEmpty() {
			return q.isEmpty();
		}
	}
	
	public static void main(String args[]) {
		
	    Stack stack = new Stack();
	 
	    stack.push(7);
	    stack.push(8);
	    System.out.print("Stack: ");
	    stack.display();
	 
	    System.out.println();
	     
	    stack.pop();
	    System.out.print("Stack: ");
	    stack.display();
	 
	    System.out.println();
	 
	    Queue queue = new Queue();
	 
	    queue.offer(12);
	    queue.offer(13);
	    System.out.print("Queue: ");
	    queue.display();
	 
	    System.out.println();
	     
	    queue.poll();
	    System.out.print("Queue: ");
	    queue.display();
	 
	    System.out.println();
	    System.out.println("Size of stack is " + stack.size());
	    System.out.println("Size of queue is " + queue.size());
	}
}
