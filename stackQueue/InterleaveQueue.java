package internship.stackQueue;

import java.util.Queue;
import java.util.Stack;
import java.util.*;

public class InterleaveQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			queue.offer(sc.nextInt());
		}
		
		Queue<Integer> result = interleave(queue);
		
		while(!result.isEmpty()) {
			System.out.print(result.poll() + " ");
		}
		
		sc.close();
	}
	
	static Queue<Integer> interleave(Queue<Integer> q){
		int n = q.size();
		if(n%2 == 1) {
			System.out.println("Input Even number of numbers");
			return q;
		}
		
//		Q: 11 12 13 14 15 16
		int halfSize = n/2;
		Stack<Integer> stack = new Stack<>();
		
//		Q: 14 15 16  S: 13 12 11
		for(int i=0;i<halfSize;i++) {
			stack.push(q.poll());
		}
//		Q: 14 15 16 13 12 11
		for(int i=0;i<halfSize;i++) {
			q.offer(stack.pop());
		}
//		Q: 13 12 11 14 15 16
		for(int i=0;i<halfSize;i++) {
			q.offer(q.poll());
		}
//		Q: 14 15 16  S: 11 12 13
		for(int i=0;i<halfSize;i++) {
			stack.push(q.poll());
		}
//		Q: 11 14 12 15 13 16
		while(!stack.isEmpty()) {
			q.offer(stack.pop());
			q.offer(q.poll());
		}
		
		return q;
	}

}
