package internship.greedy;

import java.util.*;

public class WineTradingInGorgevia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
			
		while(true) {
			int n = sc.nextInt();
			if(n == 0) break;
			long arr[] = new long[n];
				
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextLong();
			}
		
			System.out.println(wineTrading(arr,n));
		}
		
		sc.close();
	}
	
	static long wineTrading(long arr[],int n) {
		int buy = 0;
		int sell = 0;
		long total_work = 0;
		
		while(true) {
			
			while(sell < n && arr[sell] >= 0)
				sell++;
			while(buy < n && arr[buy] <= 0)
				buy++;
			
			if(buy == n && sell == n)
				break;
			
			long wine_sold = Math.min(arr[buy], -arr[sell]);
			total_work += wine_sold*Math.abs(sell-buy);
			arr[buy] -= wine_sold;
			arr[sell] += wine_sold;
		}
		
		return total_work;
	}
}
