package internship.bitManipulation;

import java.util.Scanner;

public class DivideWithoutBasicOperators {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(divide(a,b));
		
		sc.close();
	}
	
	static long divide(long dividend,long divisor) {
		
		long sign = ((dividend < 0)^(divisor < 0)?-1:1);
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		int quotient = 0,temp = 0;
		
//		while(dividend >= divisor) {
//			dividend -= divisor;
//			quotient++;
//		}
		
		for(int i=31;i>=0;i--) {
			if(temp + (divisor << i) <= dividend) {
				temp += (divisor << i);
				quotient |= 1L << i;
			}
		}
		
		return quotient * sign;
	}

}
