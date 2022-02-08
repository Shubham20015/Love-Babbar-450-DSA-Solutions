package internship;

import java.util.*;

public class MinDiffTowers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);
		long ans = arr[n-1] - arr[0];
		
		for(int i=1;i<=n-1;i++) {
			if(arr[i]>=k){ // Height of tower cannot be negative, you can remove this `if condition` if height of tower can negative
				long curMax = Math.max(arr[i-1]+k, arr[n-1]-k);
				long curMin = Math.min(arr[0]+k, arr[i]-k);
				ans = Math.min(ans, curMax-curMin);
			}
		}
		
		System.out.println(ans);
		sc.close();

	}

}
