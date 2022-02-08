package internship.graph;

import java.util.*;

public class TravellingSalesman {
//	TC: O((N^2)*(2^N)) , SC: O(N*(2^N))
	public static int tsp(int mask,int pos,int dp[][],int dist[][],int n) {
		int VISITED_ALL = (1<<n)-1;
		
		if(mask == VISITED_ALL) {
			return dist[pos][0];
		}
		
		if(dp[mask][pos] != -1) {
			System.out.println("Cache (mask, pos):: " + mask + "   :::  " + pos  );
			return dp[mask][pos];
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int city=0;city<n;city++) {
			if((mask & (1 << city)) == 0) {
				int newAns = dist[pos][city] + tsp(mask | (1 << city),city,dp,dist,n);
				ans = Math.min(ans, newAns);
			}
		}
		
		return dp[mask][pos] = ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int size = (1<<n);
		int dist[][] = new int[n][n];
		int dp[][] = new int[size][n];
		
		for(int i=0;i<size;i++) {
			Arrays.fill(dp[i],-1);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dist[i][j] = sc.nextInt();
			}
		}
		
		int ans = tsp(1,0,dp,dist,n);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
		sc.close();
	}

}
