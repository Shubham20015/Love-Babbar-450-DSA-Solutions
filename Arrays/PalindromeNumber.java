package internship;

import java.util.*;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			boolean flag = true;
			
			for(int i=0;i<n;i++) {
				int temp = arr[i];
				int num = 0,res = 0;
				while(temp != 0) {
					res = temp%10;
					num = num*10 + res;
					temp /= 10;
				}
				System.out.println(num);
				if(num != arr[i])
					flag = false;
			}
			System.out.println(flag == false ? "It is not array of palindromes":"It is an array of palindromes");
		}
		
		
		sc.close();

	}

}
