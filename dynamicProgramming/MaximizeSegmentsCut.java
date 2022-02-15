package internship.dynamicProgramming;

import java.util.*;

public class MaximizeSegmentsCut {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		System.out.println(maximizeCuts(n,x,y,z));
		System.out.println(maximizeCutsDP(n,x,y,z));
		
		sc.close();
	}
	
//  TC: O(n) , SC: O(n)
	static int maximizeCuts(int n, int x, int y, int z)
    {
      int dp[] = new int[n+1];
      Arrays.fill(dp,-1);
      return solve(n,x,y,z,dp) < 0 ? 0:dp[n];
    }
    
    static int solve(int n, int x, int y, int z,int dp[]){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int op1 = Integer.MIN_VALUE,op2 = Integer.MIN_VALUE,op3 = Integer.MIN_VALUE;
        if(n >= x) op1 =  solve(n-x, x, y, z,dp);
        if(n >= y) op2 =  solve(n-y, x, y, z,dp);
        if(n >= z) op3 =  solve(n-z, x, y, z,dp);
        return dp[n] = 1 + Math.max(op1,Math.max(op2,op3));
    }
	
//    TC: O(n) , SC: O(n)
	static int maximizeCutsDP(int n, int x, int y, int z)
    {
       int dp[] = new int[n+1];

       for(int i=1;i<=n;i++){
           dp[i] = -1;
           if(i-x >= 0) dp[i] = Math.max(dp[i],dp[i-x]);
           if(i-y >= 0) dp[i] = Math.max(dp[i],dp[i-y]);
           if(i-z >= 0) dp[i] = Math.max(dp[i],dp[i-z]);
           if(dp[i] != -1) dp[i] += 1;
       }
       
       return dp[n] == -1?0:dp[n];
    }

}
