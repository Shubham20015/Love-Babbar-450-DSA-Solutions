package internship.searchingSorting;

import java.util.Scanner;

public class MaxSumNo2Adjacent {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int dp[] = new int[n+1];
        
        dp[1] = arr[0];
        
        for(int i=2;i<=n;i++){
            dp[i] = Math.max(arr[i-1] + dp[i-2],dp[i-1]); 
        }
        
        System.out.println(dp[n]);
		
		sc.close();
	}

}
