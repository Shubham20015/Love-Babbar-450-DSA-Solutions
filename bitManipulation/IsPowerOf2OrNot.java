package internship.bitManipulation;

import java.util.Scanner;

public class IsPowerOf2OrNot {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		if(n == 0) {
			System.out.println("false");
			System.exit(0);
		}
		
		System.out.println((n & (n-1)) == 0);
		
		sc.close();
	}
}
