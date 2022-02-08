package internship;

import java.util.*;

public class MinSwapsWithK {
	
//	Study sliding window technique properly 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		int count = 0;
		
		for(int i=0;i<n;i++) {
			if(arr[i] <= k)
				count++;
		}
		
		int notCount = 0;
		
		for(int i=0;i<count;i++) {
			if(arr[i] > k)
				notCount++;
		}
		
		int i = 0,j = count,ans = notCount;
		
		while(j<n) {
			if(arr[i] > k)
				notCount--;
			if(arr[j] > k)
				notCount++;
			
			ans = Math.min(ans, notCount);
			i++;
			j++;
		}
		
		System.out.println(ans);
		
		sc.close();
	}

}
