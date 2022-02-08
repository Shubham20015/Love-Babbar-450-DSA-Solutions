package internship.stackQueue;

public class MidElementInStack {
	static class DLLNode{
		int data;
		DLLNode prev,next;
		DLLNode(int d){
			data = d;
		}
	}
	
	DLLNode dummy = new DLLNode(-1);
	DLLNode head = dummy;
	DLLNode mid = dummy;
	static int count = 0;
	
	void push(int item) {
		DLLNode curr = new DLLNode(item);
		curr.prev = null;
		curr.next = head;
		count++;
		head.prev = curr;
		head = curr;
		if(count == 1)
			mid = curr;
		else if(count%2 == 0)
			mid = mid.prev;
	}
	
	int pop() {
		if(count == 0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		
		int item = head.data;
		head = head.next;
		if(head != null)
			head.prev = null;
		count--;
		if(count%2 == 1)
			mid = mid.next;
		
		return item;
	}
	
	int findMid() {
		if(count == 0) {
			System.out.println("Stack is Empty");
		}
		return mid.data;
	}
	
	void deleteMid() {
		if(count != 0) {
			if(count == 1) {
				head = null;
				mid = null;
			}
			else if(count == 2) {
				head = head.next;
				mid = mid.next;
				head.prev = null;
			}else {
				mid.prev.next = mid.next;
				mid.next.prev = mid.prev;
				if(count%2 == 0) {
					mid = mid.next;
				}else {
					mid = mid.prev;
				}
				count--;
			}
		}
	}
	
	public static void main(String args[]) {
		MidElementInStack st = new MidElementInStack();
	    st.push(11);
	    st.push(22);
	    st.push(33);
	    st.push(44);
	    st.push(55);
	    st.push(66);
	    st.push(77);
	    System.out.println("Item popped: " + st.pop());
	    System.out.println("Item popped: " + st.pop());
	    System.out.println("Item popped: " + st.pop());
	    System.out.println(st.findMid());
	    st.deleteMid();
	    System.out.println(st.findMid());
	}
}
