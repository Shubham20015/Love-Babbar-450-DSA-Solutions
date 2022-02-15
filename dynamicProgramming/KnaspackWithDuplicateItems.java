package internship.dynamicProgramming;

import java.util.Scanner;

public class KnaspackWithDuplicateItems {
	
	static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[][] = new int[N+1][W+1];
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=W;j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j],val[i-1] + dp[i][j-wt[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[N][W];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];
		
		for(int i=0;i<n;i++) {
			val[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			wt[i] = sc.nextInt();
		}
		
		System.out.println("Maximum profit: " + knapSack(n, w, val, wt));
		
		sc.close();
	}

}
