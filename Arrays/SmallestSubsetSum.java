package internship;

import java.util.*;

public class SmallestSubsetSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		int i = 0,j = 0;
		int sum = 0,lengthOfSubset = Integer.MAX_VALUE;
		while(i<n && j<n) {
			sum += arr[j];
			if(sum > x) {
				lengthOfSubset = Math.min(lengthOfSubset, j-i+1);
				sum -= (arr[i]+arr[j]);
				i++;
			}else {
				j++;
			}
		}
		
		System.out.println(lengthOfSubset);
		
		sc.close();

	}

}
