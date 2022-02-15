package internship.dynamicProgramming;

import java.util.Scanner;

public class LongestSubsequenceDiff1 {
	
	static int longestSubsequence(int n, int arr[])
    {
        int dp[] = new int[n];
        dp[0] = 1;
        int ans = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(Math.abs(arr[i] - arr[j]) == 1){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += 1;
            ans = Math.max(ans,dp[i]);
        }
        
        return ans;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Length of longest subsequence having adjacent difference one: " + longestSubsequence(n,arr));
		
		sc.close();

	}

}
