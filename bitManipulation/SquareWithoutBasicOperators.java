package internship.bitManipulation;

import java.util.*;

public class SquareWithoutBasicOperators {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(square(n));
		
		sc.close();
	}
	
	static long square(long n) {
		if(n  == 0) {
			return 0;
		}
		
		if(n < 0) {
			n = -n;
		}
		
		long x = n>>1;
		
		if((n&1) == 1) {
			return ((square(x)<<2)+(x << 2)+1);
		}else {
			return (square(x)<<2);
		}
	}

}
