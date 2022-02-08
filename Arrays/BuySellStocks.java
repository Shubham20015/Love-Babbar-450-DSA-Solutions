package internship;

import java.util.*;

public class BuySellStocks {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE, max = 0;
		
		for(int i=0;i<n;i++) {
			if(min >arr[i]) {
				min = arr[i];
			}
			else if(arr[i] - min > max) {
				max = arr[i] - min;
			}
		}
		
		System.out.println(max);
		sc.close();

	}

}
