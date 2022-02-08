package internship;

import java.util.*;

public class MaxBuySell2Shares {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		int firstBuy = Integer.MAX_VALUE;
		int secondBuy = Integer.MAX_VALUE;
		int firstSell = 0;
		int secondSell = 0;
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			firstBuy = Math.min(firstBuy, arr[i]);
			firstSell = Math.max(firstSell, arr[i] - firstBuy);
			secondBuy = Math.min(secondBuy, arr[i] - firstSell);
			secondSell = Math.max(secondSell, arr[i] - secondBuy);
			System.out.println(firstBuy + " " + firstSell + " " + secondBuy + " " +  secondSell);
		}
		
		System.out.println(secondSell);
		
		sc.close();
	}

}
