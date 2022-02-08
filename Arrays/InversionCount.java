package internship;

import java.util.*;

public class InversionCount {
	
//	Not working for very big inputs

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter size of Array: ");
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		System.out.println(mergeSortCount(arr,0,n-1));
		
		sc.close();
	}
	
	public static long mergeSortCount(long arr[], int low, int high) {
		int count = 0;
		if(low<high) {
			int mid = (low+high)/2;
			count +=  mergeSortCount(arr,low,mid);
			count += mergeSortCount(arr,mid+1,high);
			count += merge(arr,low,mid,high);
		}
		return count;
	}
	
	public static long merge(long arr[], int l, int m, int r) {
		long swaps = 0;
		int i = 0,j = 0, k = l;
		
		long[] left = Arrays.copyOfRange(arr, l, m + 1);
		 
        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
				swaps += (m + 1) - (l + i);
			}
		}
		
		while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
		
		return swaps;
	}
	
}
