package internship.dynamicProgramming;

import java.util.*;

public class Combination_nCr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(nCr(n,r));
		sc.close();
	}
	
	static int nCr(int n, int r)
    {
        if(n < r) return 0;
        if((n-r) < r) r = n-r;
        int dp[] = new int[r+1];
        int mod  = 1000000007;
        Arrays.fill(dp,0);
        dp[0] = 1; 
        for(int i=1;i<=n;i++){
            int index = Math.min(r,i);
            for(int j=index;j>0;j--){
                dp[j] = (dp[j]%mod + dp[j-1]%mod)%mod;
            }
        }
        
        return dp[r];
    }

}
