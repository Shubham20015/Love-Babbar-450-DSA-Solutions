package internship.dynamicProgramming;

import java.util.Scanner;

// If I choose options for 0 then

/*i is placed at 0: 
 * This case is equivalent to solving the problem for n-2 elements as two elements have just swapped their positions.
 *i is not placed at 0: 
   This case is equivalent to solving the problem for n-1 elements as now there are n-1 elements, n-1 positions and every element has n-2 choices
 */

public class CountDearrangements {
	
//	TC: O(2^N) , SC: O(1)
	static int countWaysRec(int n) {
		if(n == 1) return 0;
		if(n == 2) return 1;
		
		return (n-1)*(countWaysRec(n-1) + countWaysRec(n-2));
	}
	
//	TC: O(N) , SC: O(N)
	static int countWaysDP(int n) {
		int dp[] = new int[n+1];
		
		dp[1] = 0;
		dp[2] = 1;
		
		for(int i=3;i<=n;i++) {
			dp[i] = (i-1) * (dp[i-1] + dp[i-2]);
		}
		
		return dp[n];
	}
	
//	TC: O(N) , SC: O(1)
	static int countWaysConst(int n) {
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;
		
		int a = 0;
		int b = 1;
		
		for(int i=3;i<=n;i++) {
			int c = (i-1) * (a+b);
			a = b;
			b = c;
		}
		
		return b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println("Counts of Dearrangements: " + countWaysRec(n));
		System.out.println("Counts of Dearrangements: " + countWaysDP(n));
		System.out.println("Counts of Dearrangements: " + countWaysConst(n));
		
		sc.close();
	}
}
