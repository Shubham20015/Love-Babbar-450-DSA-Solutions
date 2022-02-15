package internship.dynamicProgramming;

import java.util.Scanner;

public class FriendPairing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countFriendsPairings(n));
		sc.close();
	}
	
	static long countFriendsPairings(int n) 
    { 
        long dp[] = new long[n+1];
        long mod = (long)1e9+7;
        if(n == 0 || n == 1 || n == 2)
            return n;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + (i-1)*dp[i-2])%mod;
        }
        
        return dp[n];
    }

}
