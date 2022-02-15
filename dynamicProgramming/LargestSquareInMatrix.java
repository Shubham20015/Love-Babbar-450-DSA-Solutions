package internship.dynamicProgramming;

import java.util.Scanner;

public class LargestSquareInMatrix {
	
	static int maxSquare(int n, int m, int mat[][]){
        int dp[][] = new int[n+1][m+1];
        int max = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(mat[i-1][j-1] == 1)
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
           
                max = Math.max(max,dp[i][j]);
            }
        }
        
        return max;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int mat[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Max size of square sub-matrix: " + maxSquare(n, m, mat));
		
		sc.close();
	}

}
