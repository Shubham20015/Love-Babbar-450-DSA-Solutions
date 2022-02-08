package internship.stackQueue;

import java.util.*;
import java.util.Queue;

public class StackUsingTwoQueue {

	public static void main(String[] args) {
		StackUsingTwoQueue stack = new StackUsingTwoQueue();
		stack.push(23);
		stack.push(45);
		System.out.println(stack.pop());
		stack.push(67);
		stack.push(89);
		System.out.println(stack.pop());
	}
	
	Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    void push(int a)
    {
	    q1.add(a);
    }
    
    int pop()
    {
        if(q1.isEmpty())
            return -1;
	    while(q1.size() > 1){
	        q2.add(q1.poll());
	    }
	    int x = q1.poll();
	    while(!q2.isEmpty()){
	        q1.add(q2.poll());
	    }
	    return x;
    }

}
