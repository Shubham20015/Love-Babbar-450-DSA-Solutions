package internship.searchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class EkoTressCutting {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();
			int height = sc.nextInt();
			int arr[] = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			int low = 0,high = arr[n-1];
			int result = 0;
			
			while(low <= high) {
				int mid = (low + high) / 2;
				if(canTakeHeight(arr,n,height,mid)) {
					result = mid;
					low = mid + 1;
				}else {
					high = mid-1;
				}
			}
			
			System.out.println(result);
		
			sc.close();

	}
	
	static boolean canTakeHeight(int arr[],int n,int k,int height) {
		
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			if(arr[i] > height) {
				sum += (arr[i] - height);
			}
		}
		
		return sum >= k;
	}

}
