package internship;

import java.util.*;

public class CylindricalRotate {
	
//	Clockwise Rotation 
//	For anto-clockwise Rotation change only temp variable and 2nd for loop conditions

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		long temp = arr[n-1];
		
		for(int i=n-1;i>=1;i--) {
			arr[i] = arr[i-1];
		}
		
		arr[0] = temp;
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
		sc.close();

	}

}
