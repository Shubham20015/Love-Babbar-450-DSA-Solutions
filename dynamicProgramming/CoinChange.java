package internship.dynamicProgramming;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[m];
		
		for(int i=0;i<m;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solve(n,m,arr));
		System.out.println(count(arr,n,m));
		
		sc.close();
	}
	
//	TC:O(2^n) , SC: O(2^n) -> used to have distinct combinations only
	static long solve(int n,int m,int S[]){
        if(n == 0){
            return 1;
        }
        
        if(n < 0 || m < 0){
            return 0;
        }
    
        return solve(n-S[m],m,S) + solve(n,m-1,S);
    }
	
//	TC:O(m*n) , SC:O(n)
	 static long count(int S[], int m, int n) {
	        long dp[] = new long[n+1];
	        dp[0] = 1;
	        for(int i=0;i<m;i++){
	            for(int j=S[i];j<=n;j++){
	                if(j >= S[i])
	                    dp[j] += dp[j-S[i]];
	            }
	        }
	        
	        return dp[n];
	    }

}
