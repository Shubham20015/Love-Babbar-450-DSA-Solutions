package internship.dynamicProgramming;

import java.util.Scanner;

public class MobileNumericKeyboard {
	
	static long getCount(int N)
	{
	    long dp[][] = new long[N+1][10];
//	    Assume old mobile num keypad
		int arr[][] = {{0,8},
		               {1,2,4},
		               {1,2,3,5},
		               {2,3,6},
		               {1,4,5,7},
		               {2,4,5,6,8},
		               {3,5,6,9},
		               {4,7,8},
		               {0,5,7,8,9},
		               {6,8,9}};
		               
		for(int i=1;i<=N;i++){
		    for(int j=0;j<=9;j++){
		        if(i == 1){
		            dp[i][j] = 1;
		        }else{
		            for(int prev: arr[j]){
		                dp[i][j] += dp[i-1][prev];
		            }
		        }
		    }
		}
		
		long sum = 0;
		
		for(int i=0;i<10;i++)
		    sum += dp[N][i];
		    
		return sum;    
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println("Number of possible numbers of the given length" + getCount(N));
		
		sc.close();
	}

}
