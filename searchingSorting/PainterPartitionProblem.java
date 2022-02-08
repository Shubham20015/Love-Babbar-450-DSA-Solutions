package internship.searchingSorting;

import java.util.Scanner;

public class PainterPartitionProblem {
		
		public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
			
				int n = sc.nextInt();
				int painter = sc.nextInt();
				int arr[] = new int[n];
				long max = Integer.MIN_VALUE,sum = 0;
				
				for(int i=0;i<n;i++) {
					arr[i] = sc.nextInt();
					sum += arr[i];
					max = Math.max(arr[i],max);
				}
				
				long low = max,high = sum;
				long result = 0;
				
				while(low <= high) {
					long mid = (low + high) / 2;
					if(isFeasible(arr,n,painter,mid)) {
						result = mid;
						high = mid-1;
					}else {
						low = mid + 1;
					}
				}
				
			
				System.out.println(result);
				
				System.out.println(partition(arr,n,painter));
	
				sc.close();

		}

		static boolean isFeasible(int arr[],int n,int k,long given) {
			
			long sum = 0;
			int req = 1;
			
			for(int i=0;i<n;i++) {
			    sum += arr[i];
				if(sum > given) {
				    req++;
					sum = arr[i];
				}
			}
			
			return req <= k;
		}
		
//		Recursive Brute Force approach (Don't give correct answer)
		
		static int partition(int arr[],int n,int k) {
			if(k == 1)
				return sum(arr,0,n-1);
			if(n == 1)
				return arr[0];
			
			int bestComb = Integer.MAX_VALUE;
			
			for(int i=1;i<=n;i++) {
				bestComb = Math.min(bestComb, Math.max(partition(arr,i,k-1), sum(arr,i,n-1)));
			}
			
			return bestComb;
				
		}
		
		static int sum(int arr[],int i,int j) {
			
			int total = 0;
			for(int x=i;x<=j;x++) {
				total += arr[i];
			}
			
			return total;
		}

}
