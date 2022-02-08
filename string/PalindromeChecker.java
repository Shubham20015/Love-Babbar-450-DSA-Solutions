package internship.string;

import java.util.*;

public class PalindromeChecker {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char arr[] = str.toCharArray();
		int n = arr.length;
		int flag = 1;
		
		for(int i=0;i<n/2;i++) {

			if(arr[i] != arr[n-i-1]) {
				flag = 0;
				break;
			}
		}
		
		System.out.println(flag);
		
		sc.close();

	}

}
