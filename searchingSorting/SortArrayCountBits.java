package internship.searchingSorting;

import java.util.*;

public class SortArrayCountBits {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Integer arr[] = new Integer[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr,(c1,c2) -> Integer.bitCount(c2) - Integer.bitCount(c1));
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}

}
