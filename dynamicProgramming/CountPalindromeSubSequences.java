package internship.dynamicProgramming;

import java.util.Scanner;

public class CountPalindromeSubSequences {
	
	static long countPS(String str)
    {
       double mod = 1e9+7;
       int n = str.length();
	   double dp[][] = new double [n][n];
		
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;i++,j++) {
				if(gap == 0) {
					dp[i][j] = 1;
				}else if(gap == 1) {
					dp[i][j] = str.charAt(i) == str.charAt(j)?3:2;
				}else {
					if(str.charAt(i) == str.charAt(j))
						dp[i][j] = (dp[i+1][j] + dp[i][j-1] + 1)%mod;
					else
						dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1])%mod;
				}
				if(dp[i][j] < 0)
				    dp[i][j] += mod;
			}
		}
		
		return (long)(dp[0][n-1]%mod);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println("Count of palindrome subsequences: " + countPS(str));
		
		sc.close();
	}

}
