package internship.heaps;

import java.util.*;

public class MaxInKsubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int res[] = maxSlidingWindow(arr, n, k);
		
		for(int val : res) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}
	
// 	TC: O(NlogN) , SC: O(logK)
	static int[] maxSlidingWindow(int[] nums, int k) {
        
		int n = nums.length;
		
		int res[] = new int[n-k+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

		for(int i=0;i<k;i++){
		    pq.add(new int[] {nums[i],i});
		}

		res[0] = pq.peek()[0];
		int index = 1;

		for(int i=k;i<n;i++){
		    pq.add(new int[] {nums[i],i});
		    while(pq.peek()[1] <= i-k) pq.poll();
		    res[index++] = pq.peek()[0];
		}

		return res;
    }
	
// 	TC: O(N) , SC: O(K)
	static int[] maxSlidingWindowOp(int[] nums, int k) {
		int n = nums.length;
		Deque<Integer> q = new ArrayDeque<>();
		int res[] = new int[n-k+1];
		int index = 0;

		for(int i=0;i<n;i++){
		    if(!q.isEmpty() && q.peek() == i-k)
			q.poll();
		    while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
			q.pollLast();

		    q.offer(i);

		    if(i >= k-1){
			res[index++] = nums[q.peek()];
		    }
		}

		return res;
    }
}
