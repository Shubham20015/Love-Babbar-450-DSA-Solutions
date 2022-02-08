package internship.stackQueue;

import java.util.Queue;
import java.util.Stack;
import java.util.*;

public class ReverseFirstKElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			queue.offer(sc.nextInt());
		}
		
		Queue<Integer> result = modifyQueue(queue,k);
		
		while(!result.isEmpty()) {
			System.out.print(result.poll() + " ");
		}
		
		sc.close();
	}
	
	static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        int size = q.size();
        Stack<Integer> stack = new Stack<>();
        
        if(k > size){
            return q;
        }
        
        for(int i=0;i<k;i++){
            stack.add(q.poll());
        }
        for(int i=0;i<k;i++){
            q.offer(stack.pop());
        }
        for(int i=0;i<size-k;i++){
            q.offer(q.poll());
        }
        return q;
    }

}
