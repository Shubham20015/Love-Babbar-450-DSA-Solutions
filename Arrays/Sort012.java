package internship;

import java.util.*;

public class Sort012 {

//	Dutch National Flag Approach 
	/*
	 Algorithm:
	 	start low=mid=0,high=n-1
	 	check while mid <= high
	 	if(element == 0)
	 		swap low,mid
	 		low++;
	 		mid++;
	 	else if(element == 2)
	 		swap mid,high
	 		high--;
	 	else
	 		mid++;
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int low = 0,high = n-1,mid = 0;
		
		while(high >= mid) {
			if(arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low++] = temp;
				mid++;
			}
			else if(arr[mid] == 2) {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high--] = temp;
			}
			else {
				mid++;
			}
		}
		
		for(int ele: arr) {
			System.out.print(ele + " ");
		}
		
		
		sc.close();
	}

}
