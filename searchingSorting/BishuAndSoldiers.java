package internship.searchingSorting;

import java.util.*;

public class BishuAndSoldiers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int power[] = new int[n];
		
		for(int i=0;i<n;i++) {
			power[i] = sc.nextInt();
		}
		
		int result[] = new int[n+1];
		
//		This stores power of previous indexes in current index 
		for(int i=1;i<=n;i++) {
			result[i] = result[i-1] + power[i-1];
		}
		
		int q = sc.nextInt();
		
		Arrays.sort(power);
		
		while(q-->0) {
			
			int killpower = sc.nextInt();
			
			int count = bs(power,n,killpower);
			
			System.out.println(count + " " + result[count]);
		}
		
		sc.close();
	}
	
	static int bs(int arr[],int n,int k) {
		if(arr[n-1] <= k)
			return n;
		if(arr[0] > k)
			return 0;
		
		int low = 0,high = n-1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(arr[mid] == k && arr[mid+1] > k) 
				return mid+1;
			
			if(arr[mid] > k) {
				high = mid -1;
			}else {
				low = mid + 1;
			}
		}
		
		return 0;
	}

}
