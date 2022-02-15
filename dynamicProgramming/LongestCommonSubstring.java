package internship.dynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubstring {
	
	static int longestCommonSubstr(String S1, String S2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        
        return ans;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println("Length of longest common substring: " + longestCommonSubstr(s1,s2,n,m));
		
		sc.close();

	}

}
