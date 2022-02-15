package internship.dynamicProgramming;

import java.util.*;

public class MaxLengthChain {
	
	static class Pair{
		int x,y;
		Pair(int _x,int _y){
			x = _x;
			y = _y;
		}
	}
	
	static int maxChainLength(Pair arr[], int n)
    {
       int dp[] = new int[n];
       Arrays.fill(dp,1);
       int ans = 1;
       Arrays.sort(arr,(Pair a, Pair b) -> a.x - b.x);
       for(int i=1;i<n;i++){
           for(int j=0;j<i;j++){
               if(arr[j].y < arr[i].x)
                dp[i] = Math.max(dp[i],dp[j] + 1);
           }
           ans = Math.max(ans,dp[i]);
       }
       
       return ans;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Pair arr[] = new Pair[n];
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new Pair(x,y);
		}
		
		System.out.println("Length of longest chain: " + maxChainLength(arr, n));
		
		sc.close();

	}

}
