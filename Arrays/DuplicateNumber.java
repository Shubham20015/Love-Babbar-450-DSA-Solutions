package internship;

import java.util.*;

public class DuplicateNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int tortorise = arr[0];
		int hare = arr[0];
		
		do {
			tortorise = arr[tortorise];
			hare = arr[arr[hare]];
		}while(tortorise != hare);
		
		tortorise = arr[0];
		
		while(tortorise != hare) {
			tortorise = arr[tortorise];
			hare = arr[hare];
		}
		
		System.out.println(hare);
		sc.close();

	}

}
