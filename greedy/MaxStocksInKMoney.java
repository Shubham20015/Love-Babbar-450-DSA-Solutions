package internship.greedy;

import java.util.*;

public class MaxStocksInKMoney {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] =new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		System.out.println(maxStocks(arr, n, k));
		
		sc.close();

	}
	
	static class Pair{
		int value;
		int day;
		Pair(int value,int day){
			this.value = value;
			this.day = day;
		}
	}
	
	static int maxStocks(int arr[],int n,int k) {
		Pair stocks[] = new Pair[n];
		
		for(int i=0;i<n;i++) {
			stocks[i] = new Pair(arr[i],i+1);
		}
		
		Arrays.sort(stocks,(a,b) -> a.value - b.value);
		
		int ans = 0;
		for(int i=0;i<n;i++) {
			int maxStocksInDay =  Math.min(stocks[i].day, k/stocks[i].value);
			ans += maxStocksInDay;
			k -= stocks[i].value * maxStocksInDay;
		}
		
		return ans;
	}

}
