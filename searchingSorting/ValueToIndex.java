package internship.searchingSorting;

import java.util.Scanner;

public class ValueToIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			
			if(i+1 == arr[i]) {
				System.out.println(arr[i]);
			}
		}
		
		
		
		sc.close();
	}

}
