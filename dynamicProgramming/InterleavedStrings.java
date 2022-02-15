package internship.dynamicProgramming;

import java.util.Scanner;

public class InterleavedStrings {
	
	static boolean isInterLeave(String a,String b,String c)
	{
	    int n = a.length();
	    int m = b.length();
        boolean dp[][] = new boolean[n+1][m+1];
        
        if ((m + n) != c.length())
            return false;
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                else if(j == 0){
                    dp[i][j] = a.charAt(i-1) == c.charAt(i+j-1) ? dp[i-1][j] : false;
                }    
                else if(i == 0){
                    dp[i][j] = b.charAt(j-1) == c.charAt(i+j-1) ? dp[i][j-1] : false;
                } 
                else {
                    if(a.charAt(i-1) == c.charAt(i+j-1)){
                        dp[i][j] = dp[i-1][j];
                    }
                    if(b.charAt(j-1) == c.charAt(i+j-1)){
                        dp[i][j] = dp[i][j] || dp[i][j-1];
                    }
                }
            }
        }
        
        return dp[n][m];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();
		
		System.out.println(isInterLeave(A,B,C));
		
		sc.close();
	}

}
