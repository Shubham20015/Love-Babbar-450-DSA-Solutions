package internship.string;

import java.util.Scanner;

public class LongsetCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		int dp[][] = new int[x+1][y+1];
        
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        System.out.println(dp[x][y]);
		
		sc.close();
	}

}
