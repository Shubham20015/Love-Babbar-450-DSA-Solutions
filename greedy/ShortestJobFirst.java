package internship.greedy;

import java.util.*;

public class ShortestJobFirst {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Process arr[] = new Process[n];
		
		for(int i=0;i<n;i++) {
			int arrivalTime = sc.nextInt();
			int burstTime = sc.nextInt();
			arr[i] = new Process(i+1,arrivalTime,burstTime);
		}
		
		ArrayList<Integer> ans = scheduling(arr,n);
		
		for(int val : ans)
			System.out.print(val + " ");
		
		sc.close();
	}
//	TC : O(N + logN) , SC: O(N) -> not giving correct answer
	static class Process{
		int jobid;
		int arrival;
		int burst;
		Process(int i,int a,int b){
			jobid = i;
			arrival = a;
			burst = b;
		}
	}
	
	static class customComparator implements Comparator<Process>{

		@Override
		public int compare(Process o1, Process o2) {
			if(o1.arrival == o2.arrival) {
				if(o1.burst == o2.burst)
					return o1.jobid < o2.jobid ? 1:-1;
				else 
					return o1.burst < o2.burst ? 1:-1;
			}
			return o1.arrival < o2.arrival ? 1:-1;
		}
		
	}
	
	static ArrayList<Integer> scheduling(Process arr[],int n){
		Arrays.sort(arr,new customComparator());
		
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Process> pq = new PriorityQueue<>((Process a,Process b) -> b.burst - a.burst);
		
		pq.add(new Process(arr[0].jobid,arr[0].arrival,arr[0].burst));
		int i = 1,current_time = 0;
		
		while(!pq.isEmpty()) {
			Process temp = pq.poll();
			int burst_time = temp.burst;
			int id = temp.jobid;
			
			ans.add(id);
			current_time += burst_time;
			
			while(true) {
				if(i<n && arr[i].arrival <= current_time) {
					pq.add(new Process(arr[i].jobid,arr[i].arrival,arr[i].burst));
					i++;
				}else {
					break;
				}
			}
			
		}
		
		return ans;
	}

}
