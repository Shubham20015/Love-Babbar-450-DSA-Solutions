package internship.dynamicProgramming;

import java.util.Scanner;

public class LongestRepeatedSubsequence {

	static int lcs(int n, String str)
    {
        int dp[][] = new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(str.charAt(i-1) == str.charAt(j-1) && i!=j){ // Remember that in both characters are same but index do not be same
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n][n];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		
		System.out.println("Length of longest repeated subsequence: " + lcs(n,str));
		
		sc.close();
	}


}
