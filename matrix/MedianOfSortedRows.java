package internship.matrix;

import java.util.*;

public class MedianOfSortedRows {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int matrix[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE; 
		
		while(low <= high) {
			int mid = (low+high) / 2;
			int count = 0;
			for(int i=0;i<n;i++) {
				count += countSmallerThanEqualToMid(matrix[i],mid);
			}
			
			if(count <= (n*m)/2)
				low = mid+1;
			else
				high = mid-1;
		}
		
		System.out.println(low);
		
		sc.close();

	}
	
	public static int countSmallerThanEqualToMid(int arr[],int mid) {
		int low = 0,high = arr.length-1;
		while(low <= high) {
			int md = (low+high) / 2;
			
			if(arr[md] <= mid) {
				low = md+1;
			}else {
				high = md-1;
			}
		}
		return low;
	}

}
