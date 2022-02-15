package internship.dynamicProgramming;

import java.util.Scanner;

public class CountBalancedTrees {
	
	static long countBT(int h){
        long dp[] = new long[h+1];
        long mod = (long)(1e9+7); 
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=h;i++){
            dp[i] = (dp[i-1]%mod * dp[i-2]%mod + dp[i-2]%mod * dp[i-1]%mod + 
            dp[i-1]%mod * dp[i-1]%mod) % mod;
        }
        
        return dp[h];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		
		System.out.println("No. of balanced binary trees with " + h + " height: " + countBT(h));
		
		sc.close();
	}

}
