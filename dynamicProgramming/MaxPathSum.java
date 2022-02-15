package internship.dynamicProgramming;

import java.util.Scanner;

public class MaxPathSum {
	
	 static int maximumPath(int N, int Matrix[][])
	    {
	        int dp[][] = new int[N][N];
	        
	        for(int i=0;i<N;i++){
	            for(int j=0;j<N;j++){
	                if(i == 0){
	                    dp[i][j] = Matrix[i][j];
	                }
	                else if(j == 0){
	                    dp[i][j] = Matrix[i][j] + Math.max(dp[i-1][j],dp[i-1][j+1]);
	                }
	                else if(j == N-1){
	                    dp[i][j] = Matrix[i][j] + Math.max(dp[i-1][j],dp[i-1][j-1]);
	                }else{
	                    dp[i][j] = Matrix[i][j] + Math.max(dp[i-1][j],Math.max(dp[i-1][j+1],dp[i-1][j-1]));
	                }
	            }
	        }
	        
	        int ans = 0;
	        
	        for(int j=0;j<N;j++){
	            ans = Math.max(ans,dp[N-1][j]);
	        }
	        
	        return ans;
	    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int mat[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Maximum sum of path in matrix: " + maximumPath(n,mat));
		
		sc.close();
	}

}
