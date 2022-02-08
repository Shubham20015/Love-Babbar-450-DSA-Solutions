package internship.searchingSorting;

import java.util.*;

public class WeightedJobScheduling {
	
	static class Jobs{
		
		int start,finish,profit;
		
		Jobs(int start, int finish, int profit)
	    {
	        this.start = start;
	        this.finish = finish;
	        this.profit = profit;
	    }
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Jobs arr[] = new Jobs[n];
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			arr[i] = new Jobs(x,y,z);
		}
		
		Arrays.sort(arr,(Jobs a,Jobs b) -> a.finish - b.finish);
		
		int dp[] = new int[n];
		
		dp[0] = arr[0].profit;
		
		for(int i=1;i<n;i++) {
			int including = arr[i].profit;
			
//			O(N^2)
//			int lNConflict = -1;
//			for(int j=i-1;j>=0;j--) {
//				if(arr[j].finish <= arr[i].start) {
//					lNConflict = j;
//					break;
//				}				
//			}
			
//			O(NlogN)
			int lNConflict = binarySearch(arr,i);
			
			if(lNConflict != -1) {
				including += arr[lNConflict].profit;
			}
			
			dp[i] = Math.max(including, dp[i-1]);
		}
		
		System.out.println(dp[n-1]);
		
		sc.close();
	}
	
	static int binarySearch(Jobs arr[],int index) {
		int low = 0,high = index -1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if(arr[mid].finish <= arr[index].start) {
				if(arr[mid+1].finish <= arr[index].start) {
					low = mid+1;
				}else {
					return mid;
				}
			}else {
				high = mid -1;
			}
		}
		
		return -1;
	}
}
