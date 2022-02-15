package internship.dynamicProgramming;

import java.util.Scanner;

public class LongestPalindromeSubstring {
	
	static String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        String ans = "";
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 0){
                    dp[i][j] = true;
                }
                else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j] == true){
                    ans = s.substring(i,j+1);
                }
            }
        }
        
        return ans;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		System.out.println("Longest palidrome substring: " + longestPalindrome(str));
		
		sc.close();
	}

}
