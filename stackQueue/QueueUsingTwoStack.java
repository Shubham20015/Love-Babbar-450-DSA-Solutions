package internship.stackQueue;

import java.util.Stack;

public class QueueUsingTwoStack {

	public static void main(String[] args) {
		QueueUsingTwoStack queue = new QueueUsingTwoStack();
		queue.push(23);
		queue.push(30);
		queue.push(78);
		System.out.println(queue.pop());
		queue.push(93);
		queue.push(10);
		queue.push(7);
		queue.push(90);
		System.out.println(queue.pop());
		queue.push(18);
		queue.push(54);
		queue.push(73);
		queue.push(20);
		System.out.println(queue.pop());
	}
	
	 	Stack<Integer> s1 = new Stack<Integer>();
	    Stack<Integer> s2 = new Stack<Integer>();

	    void push(int x)
	    {
		    s1.add(x);
	    }
		
	    int pop()
	    {
	       if(s1.isEmpty()){
	           return -1;
	       }
		   while(!s1.isEmpty()){
		       s2.add(s1.pop());
		   }
		   int x = s2.pop();
		   while(!s2.isEmpty()){
		       s1.add(s2.pop());
		   }
		   return x;
	    }

}
