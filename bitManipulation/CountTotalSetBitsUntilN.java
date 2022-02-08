package internship.bitManipulation;

import java.util.Scanner;

public class CountTotalSetBitsUntilN {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(countNBits(n));
		
//		for(int i=1;i<=n;i++) {
//			System.out.println(i+" --> "+Integer.toBinaryString(i));  // This used to check binary form of any number
//		}
		sc.close();

	}
	
	public static int largestPower(int n) {
		int i = 0;
		while((1<<i)<=n) i++; //1<<i -> left shift of 1 which gives power of 2's
		return i-1;
	}
	
	public static int countNBits(int n) {
		
		if(n == 0) return 0;
		int x = largestPower(n);
		return x*(1<<(x-1))+n-(1<<x)+1+countNBits(n-(1<<x));  
//		x*(1<<(x-1)) means x*pow(2,x) -> gives all set bits less than largest power of 2
//		n-(1<<x)+1 means n-pow(2,x)+1 -> gives MSB for all numbers greater than largest power of 2
//		countNBits(n-pow(2,x)) (recursive function) gives set bits for remaining numbers after taking their MSB
	}

}
