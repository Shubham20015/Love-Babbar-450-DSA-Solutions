package internship.searchingSorting;

import java.util.Scanner;

public class NthRootOfInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double x = sc.nextDouble();
		int n = sc.nextInt();
		double ans = NthRoot(x,n);
		
		System.out.println(ans);
		
		sc.close();
	}
	
	static double NthRoot(double x,int n) {
		if(x == 0)
			return 0;
		
		double low = 1.0;
		double high = x;
		double eps = 1e-6;
		
		while((high - low) > eps) {
			double mid = (high + low)/2;
			if(Math.pow(mid, n) > x) {
				high = mid;
			}else {
				low = mid;
			}
		}
//		we can return high or low any value
		return high;
	}

}
