package internship.dynamicProgramming;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	
	static int longestSubsequence(int size, int a[])
    {
        int dp[] = new int[size];
        dp[0] = 1;
        
        int ans = Integer.MIN_VALUE;
        
        for(int i=1;i<size;i++){
            int temp = 0;
            for(int j=0;j<i;j++){
                if(a[j] < a[i]){
                    temp = Math.max(dp[j],temp);
                }
            }
            
            dp[i] = temp + 1;
            ans = Math.max(dp[i],ans);
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
		
		System.out.println("Length of longest increasing subsequence: " + longestSubsequence(n,arr));
		
		sc.close();
	}

}
