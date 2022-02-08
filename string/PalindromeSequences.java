package internship.string;

import java.util.Scanner;

public class PalindromeSequences {

	public static void main(String[] args) {
//		For large string inputs we have to do mod 10e9+7
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int n = str.length();
		int dp[][] = new int [n][n];
		
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;i++,j++) {
				if(gap == 0) {
					dp[i][j] = 1;
				}else if(gap == 1) {
					dp[i][j] = str.charAt(i) == str.charAt(j)?3:2;
				}else {
					if(str.charAt(i) == str.charAt(j))
						dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1;
					else
						dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
				}
			}
		}
		
		System.out.println(dp[0][n-1]);
		
		sc.close();
	}

}
