package internship.stackQueue;

class Node{
	int data;
	Node next,prev;
	Node(int data){
		this.data = data;
		
	}
}

public class StackLL {
	
	private Node head = new Node(-1);
	private Node mid = new Node(-1);
	private int count;
	
	StackLL(){
		count = 0;
	}
	
	public void push(int x) {
		Node newNode = new Node(x);
		newNode.prev = null;
		newNode.next = head;
		count++;
		
		head.prev = newNode;
		if(count == 1) {
			mid = head;
		}else if(count % 2 == 0) {
			mid = mid.prev;
		}
		head = newNode;
	}
	
	public int pop() {
		
		if (count == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
		
		int item = head.data;
		head = head.next;
		
		if(head != null)
			head.prev = null;
		count--;
		
		if((count&1) == 1)
			mid = mid.next;
		return item;	
	}
	
	public int findMid() {
		
		if (count == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
		
		return mid.data;
	}
	
	public void deleteMid() {
		if(count != 0) {
			if(count == 1) {
				head = null;
				mid = null;
			}else if(count == 2) {
				head = head.next;
				mid = mid.next;
				head.prev = null;
			}else {
				mid.next.prev = mid.prev;
				mid.prev.next = mid.next;
				if (count%2 == 0)
                    mid = mid.prev;
                else
                    mid = mid.next;
				count--;
			}
		}
	}
	
	public void printStack() {
		Node curr = head;
		while(curr.next != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	
	public static void main(String args[]) {
		StackLL stack = new StackLL();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.printStack();
		System.out.println(stack.findMid());
	}
}
