package internship.string;

import java.util.*;

public class ReverseString {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char arr[] = str.toCharArray();
		int n = arr.length;
		
		for(int i=0;i<n/2;i++) {
			char ch = arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = ch;
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]);
		}
		
		sc.close();
	}
}
