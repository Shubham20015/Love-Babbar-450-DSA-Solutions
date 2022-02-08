package internship.searchingSorting;

import java.util.Scanner;

public class KthSmallestInSortedArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[m];
		
		for(int i=0;i<n;i++) {
			arr1[i] = sc.nextInt();
		}
		
		for(int i=0;i<m;i++) {
			arr2[i] = sc.nextInt();
		}
		
		System.out.println(KthSmallest(arr1,arr2,n,m,k));
		
		sc.close();
	}
	
	static int KthSmallest(int arr1[],int arr2[],int n,int m,int k) {
		int low = Math.max(0, k-m),high = Math.min(n, k);
		while(low <= high) {
			int cut1 = (low+high)/2;
			int cut2 = k - cut1;
			int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1];
			int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr1[cut2-1];
			int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
			int r2 = cut2 == m ? Integer.MAX_VALUE : arr1[cut2];
			
			if(l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
			else if(l1 > l2) high = cut1-1;
			else low = cut1+1;
		}
		return -1;
	}

}
