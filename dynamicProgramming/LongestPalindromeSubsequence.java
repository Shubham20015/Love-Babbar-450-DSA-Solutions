package internship.dynamicProgramming;

import java.util.*;

// TC: O(N*N) , SC: O(N*N)
public class LongestPalindromeSubsequence {
//	Memosiation
	static int lps(int dp[][],String str,int i,int j) {
		if(i == j)
			return 1;
		if(i > j)
			return 0;
		if(dp[i][j] != -1)
			return dp[i][j];
		if(str.charAt(i) == str.charAt(j))
			return dp[i][j] = lps(dp,str,i+1,j-1) + 2;
		
		return dp[i][j] = Math.max(lps(dp,str,i+1,j),lps(dp,str,i,j-1));
	}
	
//	Tabulation
	static int lpsDP(String str,int n) {
		int dp[][] = new int[n][n];
		
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;i++,j++) {
				if(gap == 0) {
					dp[i][j] = 1;
				}else if(gap == 1) {
					dp[i][j] = str.charAt(i) == str.charAt(j)?2:1;
				}else {
					if(str.charAt(i) == str.charAt(j))
						dp[i][j] = dp[i+1][j-1] + 2;
					else
						dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
				}
			}
		}
		
		return dp[0][n-1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		int dp[][] = new int[n][n];
		
		for(int rows[]: dp)
			Arrays.fill(rows, -1);
		
		System.out.println("Length of longest palindrome subsequence: " + lps(dp,str,0,n-1));
		
		sc.close();

	}

}
