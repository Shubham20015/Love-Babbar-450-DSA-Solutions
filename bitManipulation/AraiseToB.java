package internship.bitManipulation;

import java.util.Scanner;

public class AraiseToB {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int base = sc.nextInt();
		int power = sc.nextInt();
		
		int ans = 1;
		
		while(power > 0) {
			if((power&1) == 1) {
				ans *= base;
			}
			
			base *= base;
			power >>= 1; 
		}
		
		System.out.println(ans);
		
		sc.close();
	}

}
