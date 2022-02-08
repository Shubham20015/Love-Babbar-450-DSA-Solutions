package internship.searchingSorting;

import java.util.*;

public class BookAllocation {

	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
			
				int n = sc.nextInt();
				int requiredPages = sc.nextInt();
				int arr[] = new int[n];
				int max = Integer.MIN_VALUE,sum = 0;
				
				for(int i=0;i<n;i++) {
					arr[i] = sc.nextInt();
					sum += arr[i];
					max = Math.max(arr[i],max);
				}
				
				int low = max,high = sum;
				int result = 0;
				
				while(low <= high) {
					int mid = (low + high) / 2;
					if(isFeasible(arr,n,requiredPages,mid)) {
						result = mid;
						high = mid-1;
					}else {
						low = mid + 1;
					}
				}
				
			
			System.out.println(result);
		
			sc.close();

	}
	
	static boolean isFeasible(int arr[],int n,int k,int pages) {
		
		int sum = 0,req = 1;
		
		for(int i=0;i<n;i++) {
		    sum += arr[i];
			if(sum > pages) {
			    req++;
				sum = arr[i];
			}
		}
		
		return req <= k;
	}

}
