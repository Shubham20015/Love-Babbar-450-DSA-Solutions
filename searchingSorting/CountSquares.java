package internship.searchingSorting;

import java.util.Scanner;

public class CountSquares {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println((int)(Math.sqrt(n-1)));
		
		sc.close();

	}

}
