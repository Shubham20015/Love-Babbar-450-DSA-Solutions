package internship.stackQueue;

import java.util.*;
import java.util.Queue;

public class FirstNegativeOfSizeK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		long result[] = printFirstNegativeInteger(arr,n,k);
		
		for(long val : result) {
			System.out.print(val + " ");
		}
		
		sc.close();

	}
	
	static long[] printFirstNegativeInteger(long arr[], int N, int K)
    {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Long> ans = new ArrayList<>();
        
        for(int i=0;i<K;i++){
            if(arr[i] < 0){
               q.offer(i);
            }
        }
       
        for(int i=K;i<N;i++){
            ans.add(q.isEmpty() ? 0 : arr[q.peek()]);
            
            while(!q.isEmpty() && q.peek() <= i-K)
                q.poll();
            
            if(arr[i] < 0)
                q.offer(i);
        }
        
       ans.add(q.isEmpty() ? 0 : arr[q.peek()]);
        
        return ans.stream().mapToLong(x -> x).toArray();
    }

}
