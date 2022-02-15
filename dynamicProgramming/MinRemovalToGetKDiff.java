package internship.dynamicProgramming;

import java.util.*;

public class MinRemovalToGetKDiff {
	
//	//	TC: O(N*N) , SC: O(N*N)
	static int minRemoval(int dp[][],int arr[],int i,int j,int k) {
		if(i >= j)
			return 0;
		else if(arr[j] - arr[i] <= k)
			return 0;
		else if(dp[i][j] != -1)
			return dp[i][j];
		
		return dp[i][j] = 1 + Math.min(minRemoval(dp,arr,i+1,j,k),minRemoval(dp,arr,i,j-1,k));
	}
	
//	TC: O(NlogN) , SC: O(N)
	static int minRemovalOp(int arr[],int n,int k) {
		int ans = n-1;
		for(int i=0;i<n;i++) {
			int j = findIndex(arr[i],arr,i,n,k);
			
			if(j != -1)
				// also if we maximize (j-i+1) by selecting max j value then we minimize the n - (j-i+1) value
				ans = Math.min(ans, n - (j-i+1)); // (j-i+1) means length of subarray which satisfies this condition <= k
		}
		
		return ans;
	}
	
	static int findIndex(int key,int arr[],int i,int n,int k) {
		int low = i+1,high = n-1;
		int index = -1;
		
		while(low < high) {
			int mid = low + (high - low) / 2;
			if(arr[mid] - key <= k) {
				index = mid;
				low = mid+1;
			}else {
				high = mid;
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		int dp[][] = new int[n][n];
		
		for(int rows[] : dp)
			Arrays.fill(rows, -1);
		
		for(int i=0;i<n;i++) {
			arr[i]  =sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		System.out.println("Minimum removals required to make differnce less than or equal to " + k + ": " + minRemoval(dp,arr,0,n-1,k));
		System.out.println("Minimum removals required to make differnce less than or equal to " + k + ": " + minRemovalOp(arr,n,k));
		
		sc.close();
	}

}
