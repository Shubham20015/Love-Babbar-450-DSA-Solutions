package internship.dynamicProgramming;

import java.util.Scanner;

public class CoinGameWinner {
	
	static boolean chooseWinner(int n,int x,int y) {
		boolean dp[] = new boolean[n+1];
		
		dp[0] = false;
		dp[1] = true;
		
		for(int i=2;i<=n;i++) {
			if(i-1 >= 0 && dp[i-1] == false)
				dp[i] = true;
			else if(i-x >= 0 && dp[i-x] == false)
				dp[i] = true;
			else if(i-y >= 0 && dp[i-y] == false)
				dp[i] = true;
			else
				dp[i] = false;
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		System.out.println("Winner of coin game is " + (chooseWinner(n,x,y) ? "A" : "B"));
		
		sc.close();
	}

}
