package internship.greedy;

import java.util.*;

public class JobScheduling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Job arr[] = new Job[n];
		
		for(int i=0;i<n;i++) {
			int profit = sc.nextInt();
			int deadline = sc.nextInt();
			arr[i] = new Job(i,profit,deadline);
		}
		
		int ans[] = JobSchedule(arr, n);
		
		System.out.println(ans[0] + " " + ans[1]);
		
		sc.close();
	}
	
	static class Job {
	    int id, profit, deadline;
	    Job(int x, int y, int z){
	        this.id = x;
	        this.deadline = y;
	        this.profit = z; 
	    }
	}
	
	static int[] JobSchedule(Job arr[], int n)
    {
        Arrays.sort(arr,(Job a, Job b) -> b.profit - a.profit);
        int maxDead = arr[0].deadline;
        for(int i=1;i<n;i++){
            maxDead = Math.max(maxDead, arr[i].deadline);
        }
        int slots[] = new int[maxDead+1];
        for(int i=0;i<=maxDead;i++)
            slots[i] = -1;
        
        int jobCount = 0,maxProfit = 0;    
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(slots[j] == -1){
                    slots[j] = i;
                    jobCount++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        return new int [] {jobCount,maxProfit};
    }

}
