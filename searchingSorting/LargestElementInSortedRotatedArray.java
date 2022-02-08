package internship.searchingSorting;

import java.util.Scanner;

public class LargestElementInSortedRotatedArray {

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int low = 0,high = n-1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if(low > mid && arr[mid] < arr[mid-1]) {
				System.out.println(arr[mid-1]);
				System.exit(0);
			}
			
			else if(mid < high && arr[mid+1] < arr[mid]) {
				System.out.println(arr[mid]);
				System.exit(0);
			}
			
			else if(arr[mid] >= arr[high]) {
				low = mid + 1;
			}
			else if(arr[low] >= arr[mid]) {
				high = mid - 1;
			}
		}
		
		sc.close();

	}

}
