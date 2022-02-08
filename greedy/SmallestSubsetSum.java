package internship.greedy;

import java.util.*;

public class SmallestSubsetSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] =new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		System.out.println(maxSmallestSum(arr, n));
		
		sc.close();
	}
	
	static int maxSmallestSum(int arr[],int n) {
		Arrays.sort(arr);
		
		int totalSum = 0;
		for(int i=0;i<n;i++)
			totalSum += arr[i];
		
		int greaterSum = 0,count = 0;
		for(int i=n-1;i>=0;i--) {
			totalSum -= arr[i];
			greaterSum += arr[i];
			count++;
			if(greaterSum > totalSum)
				break;
		}
		
		return count;
	}
}
