package internship;

import java.util.*;

public class MoveNegativeBegin {
	
//	Another approach
	/*
	 * j=0
	  for(i= 0 to n)
	  	if(arr[i] < 0)
	  		if(i!=j)
	  			swap arr[i],arr[j]
	  		j++;	
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
			if(arr[mid] < 0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low++] = temp;
				mid++;
			}
			else if(arr[mid] >= 0) {
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
