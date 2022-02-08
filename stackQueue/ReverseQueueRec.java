package internship.stackQueue;

import java.util.Queue;
import java.util.*;

public class ReverseQueueRec {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> queue = new LinkedList<>();
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			queue.offer(sc.nextInt());
		}
		
		Queue<Integer> result = rev(queue);
		
		while(!result.isEmpty()) {
			System.out.print(result.poll() + " ");
		}
		
		sc.close();
	}
	
	static Queue<Integer> rev(Queue<Integer> q){
        if(q.isEmpty()){
            return q;
        }
        int x = q.poll();
        rev(q);
        q.add(x);
        return q;
    }

}
