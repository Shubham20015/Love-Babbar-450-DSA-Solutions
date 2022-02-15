package internship.dynamicProgramming;

import java.util.Scanner;

public class LCSOf3Strings {
	
	static int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        int dp[][][] = new int[n1+1][n2+1][n3+1];
        
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                for(int k=0;k<=n3;k++){
                    if(i == 0 || j == 0 || k == 0){
                        dp[i][j][k] = 0;
                    }
                    else if(A.charAt(i-1) == B.charAt(j-1) && B.charAt(j-1) == C.charAt(k-1)){
                        dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                    }else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
                    }
                }
            }
        }
        
        return dp[n1][n2][n3];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		
		System.out.println("Length of longest common subsequence: " + LCSof3(s1,s2,s3,n1,n2,n3));
		
		sc.close();
	}

}
