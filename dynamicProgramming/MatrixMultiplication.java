package internship.dynamicProgramming;

import java.util.*;

public class MatrixMultiplication {
	
	static int matrixMultiplication(int N, int arr[])
    {
        int dp[][] = new int[N][N];
        
        for(int rows[]: dp)
            Arrays.fill(rows,-1);
        
        return solve(dp,arr,1,N-1);
    }
    
    static int solve(int dp[][],int arr[],int i,int j){
        if(i == j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++){
            int count = solve(dp,arr,i,k) + solve(dp,arr,k+1,j) + (arr[i-1] * arr[k] * arr[j]);
            min = Math.min(min,count);
        }
        
        return dp[i][j] = min;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Cost of matrix multiplication: " + matrixMultiplication(n, arr));
		
		sc.close();

	}

}
