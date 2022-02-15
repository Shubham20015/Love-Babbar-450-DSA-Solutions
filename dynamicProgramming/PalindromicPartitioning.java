package internship.dynamicProgramming;

import java.util.*;

public class PalindromicPartitioning {
	
	static int palindromicPartition(String str)
    {
        int n = str.length();
        int dp[][] = new int[n][n];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);
        
        return LongestPalindrome(dp,str,0,n-1);    
    }
    
    static int LongestPalindrome(int dp[][],String str,int i,int j){
        if(i >= j)
            return 0;
            
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(isPalindrome(str,i,j))
            return dp[i][j] = 0;
        
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = 1 + LongestPalindrome(dp,str,i,k) + LongestPalindrome(dp,str,k+1,j);
            ans = Math.min(ans,temp);
        }
        
        return dp[i][j] = ans;
    }
    
    static boolean isPalindrome(String temp,int i,int j){
        
        while(i < j){
            if(temp.charAt(i) != temp.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(palindromicPartition(str));
		
		sc.close();
	}

}
