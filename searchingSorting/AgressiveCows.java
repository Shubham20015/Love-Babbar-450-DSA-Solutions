package internship.searchingSorting;

import java.util.*;

public class AgressiveCows {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int cows = sc.nextInt();
			int arr[] = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			int low = 0,high = arr[n-1] - arr[0];
			int result = 0;
			
			while(low <= high) {
				int mid = (low + high) / 2;
				if(canPlaceCows(arr,n,cows,mid)) {
					result = mid;
					low = mid + 1;
				}else {
					high = mid-1;
				}
			}
			
			System.out.println(result);
		}
		
		sc.close();
	}
	
	static boolean canPlaceCows(int arr[],int n,int k,int dist) {
		
		int coord = arr[0],count = 1;
		
		for(int i=1;i<n;i++) {
			if(arr[i] - coord >= dist) {
				count++;
				coord = arr[i];
			}
			
			if(count == k)
				return true;
		}
		
		return false;
	}

}
