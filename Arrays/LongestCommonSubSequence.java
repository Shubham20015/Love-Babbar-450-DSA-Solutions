package internship;

import java.util.*;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			arr[i] =sc.nextInt();
			set.add(arr[i]);
		}
		
		int ans = 0;
		
		for(int i=0;i<n;i++) {
//			This if condition checks whether it is first no. of series or not
			if(!set.contains(arr[i]-1)) {
				int nextValue = arr[i];
				
				while(set.contains(nextValue)) {
					nextValue++;
				}
				
				if(ans < nextValue - arr[i])
					ans = nextValue - arr[i];
			}
		}
		
		System.out.println(ans);
		
		sc.close();

	}

}
