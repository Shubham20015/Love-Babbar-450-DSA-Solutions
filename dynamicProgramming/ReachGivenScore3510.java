package internship.dynamicProgramming;

import java.util.*;

public class ReachGivenScore3510 {
	
	static long count(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        
        for(int i=3;i<=n;i++)
            dp[i] += dp[i-3];
            
        for(int i=5;i<=n;i++)
            dp[i] += dp[i-5];
            
        for(int i=10;i<=n;i++)
            dp[i] += dp[i-10];    
        
        return dp[n];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println("Distinct combinations of reach that given score: " + count(n));
		
		sc.close();
	}

}
