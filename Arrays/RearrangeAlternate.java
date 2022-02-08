package internship;

import java.util.*;

public class RearrangeAlternate {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int countNegative = 0, countPositive = 0;
		
		for(int i=0;i<n;i++) {
			if(arr[i] < 0)
				countNegative++;
			else
				countPositive++;
		}
		
		Arrays.sort(arr);
		
		if(countNegative <= countPositive) {
			fillArray(arr, countNegative);
		}else {
			reverseArray(arr);
			fillArray(arr, countPositive);
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
		sc.close();

	}
	
	public static void reverseArray(int arr[]) {
		int N = arr.length;
		for(int i=0;i<N/2;i++) {
			int temp = arr[i];
			arr[i] = arr[N-i-1];
			arr[N-i-1] = temp;
		}
	}
	
	public static void fillArray(int arr[],int res) {
		if(res%2 == 1) {
			for(int i=1;i<res;i+=2) {
				int temp = arr[i];
				arr[i] = arr[i + res];
				arr[i + res] = temp;
				}
			}else {
				for(int i=1;i<=res;i+=2) {
					int temp = arr[i];
					arr[i] = arr[i + res-1];
					arr[i + res-1] = temp;
					}
			}
		}
}
