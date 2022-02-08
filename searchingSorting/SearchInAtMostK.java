package internship.searchingSorting;

import java.util.Scanner;

public class SearchInAtMostK {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		int target= sc.nextInt();
		int i = 0;
		
		while(i < n) {
			
			if(arr[i] == target) {
				System.out.println(i);
				System.exit(0);
			}
			
			i += Math.max(1, Math.abs(arr[i]-target)/k);
		}
		
		
		
		sc.close();

	}

}
