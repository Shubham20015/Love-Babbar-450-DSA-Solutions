package internship;

import java.util.*;

public class ThreeWayPartition {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int low=0,high=n-1;
		
		for(int mid=0;mid<=high;) {
			if(arr[mid] < a) {
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
			}else if(arr[mid] > b) {
					int temp = arr[high];
					arr[high] = arr[mid];
					arr[mid] = temp;
					high--;
			}else {
					mid++;
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] +  " ");
		}
		
		sc.close();
	}
}
