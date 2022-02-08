package internship.greedy;

import java.util.*;

public class MaxAbsDiffInPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			b[i] = sc.nextInt();
		}
		
		System.out.println(maxSumDiff(a,b,n));
		
		sc.close();
	}
	
	static int maxSumDiff(int a[],int b[],int n) {
		int sum = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i=0;i<n;i++)
			sum += Math.abs(a[i]-b[i]);
		
		return sum;
	}
}
