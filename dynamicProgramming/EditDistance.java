package internship.dynamicProgramming;

import java.util.Scanner;

public class EditDistance {
	
	public static int editDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1; // Min(replce,Min(delete,insert)) + 1
                }
            }
        }
        
        return dp[n][m];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String t = sc.nextLine();
		
		System.out.println("Min operations required to convert S to T: " + editDistance(s,t));
		
		sc.close();
	}

}
