package internship.dynamicProgramming;

import java.util.Scanner;

public class CountProdOfSubsequencesLessK {
	
	static int countLessK(int arr[],int n,int k) {
		int dp[][] = new int[k+1][n+1];
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = dp[i][j-1];
				
				if(arr[j-1] <= i && arr[j-1] > 0) {
					dp[i][j] += 1 + dp[i/arr[j-1]][j-1];
				}
			}
		}
		
		return dp[k][n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Count of all subsequences having product less than " + k + ": " + countLessK(arr,n,k));
		
		sc.close();
	}

}
