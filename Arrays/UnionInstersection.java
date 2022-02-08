package internship;

import java.util.*;

public class UnionInstersection {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		long arr1[] = new long[n];
		long arr2[] = new long[m];
		Set<Long> union = new HashSet<>();
		
		for(int i=0;i<n;i++) {			
			arr1[i] = sc.nextLong();
			union.add(arr1[i]);
		}
		
		for(int i=0;i<m;i++) {			
			arr2[i] = sc.nextLong();
		}
		
		System.out.print("Intersection of two array: ");
		
		for(int i=0;i<m;i++) {			
			if(union.contains(arr2[i])) {
				System.out.print(arr2[i] + " ");
			}
			union.add(arr2[i]);
		}
		
		System.out.print("\nUnion of two array: ");
		
		for(long element: union) {
			System.out.print(element + " ");
		}
		
		
		sc.close();
	}

}
