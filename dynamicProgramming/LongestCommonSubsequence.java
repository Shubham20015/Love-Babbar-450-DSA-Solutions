package internship.dynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubsequence {
	
	static int lcs(int x, int y, String s1, String s2)
    {
        int dp[][] = new int[x+1][y+1];
        
        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[x][y];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println("Length of longest common subsequence: " + lcs(n,m,s1,s2));
		
		sc.close();
	}

}
